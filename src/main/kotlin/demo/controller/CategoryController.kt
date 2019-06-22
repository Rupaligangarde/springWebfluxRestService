package demo.controller

import demo.domain.Category
import demo.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class CategoryController(
        @Autowired val categoryRepository: CategoryRepository
) {
    @GetMapping("/api/v1/categories")
    fun list(): Flux<Category> {
        return categoryRepository.findAll()
    }

    @GetMapping("/api/v1/category/{id}")
    fun getCategory(@PathVariable id: String): Mono<Category> {
        return categoryRepository.findById(id)
    }
}