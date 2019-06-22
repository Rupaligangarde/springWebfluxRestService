package demo.controller

import demo.domain.Category
import demo.repositories.CategoryRepository
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class CategoryControllerTest {

    @MockK
    private lateinit var categoryRepository: CategoryRepository

    private lateinit var categoryController: CategoryController

    private lateinit var webTestClient: WebTestClient

    @BeforeEach
    fun setUp() {
        categoryRepository = mockk()
        categoryController = CategoryController(categoryRepository)
        webTestClient = WebTestClient.bindToController(categoryController).build()

    }

    @Test
    fun `should get all categories`() {

        val category1 = Category(id = "1", description = "cat1")
        val category2 = Category(id = "2", description = "cat2")
        val category3 = Category(id = "3", description = "cat3")
        every { categoryRepository.findAll() } returns Flux.just(category1, category2, category3)
        webTestClient.get().uri("/api/v1/categories")
                .exchange()
                .expectBodyList(Category::class.java)
                .hasSize(3)
    }


    @Test
    fun `should get a category`() {

        val category1 = Category(id = "1", description = "cat1")
        every { categoryRepository.findById(category1.id) } returns Mono.just(category1)
        webTestClient.get().uri("/api/v1/category/1")
                .exchange()
                .expectBodyList(Category::class.java)
                .hasSize(1)
    }
}