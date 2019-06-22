package demo.repositories

import demo.domain.Vendor
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface VendorRepository : ReactiveMongoRepository<Vendor, String>