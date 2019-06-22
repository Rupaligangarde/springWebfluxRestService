package demo.repositories

import demo.domain.Category
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface CategoryRepository : ReactiveMongoRepository<Category, String>