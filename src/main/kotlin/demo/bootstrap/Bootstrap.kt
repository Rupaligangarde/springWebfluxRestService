//package demo.bootstrap
//
//import demo.domain.Category
//import demo.domain.Vendor
//import demo.repositories.CategoryRepository
//import demo.repositories.VendorRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.CommandLineRunner
//import org.springframework.stereotype.Component
//
//
//@Component
//class Bootstrap(
//        @Autowired private val categoryRepository: CategoryRepository,
//        @Autowired private val vendorRepository: VendorRepository
//
//) : CommandLineRunner {
//    override fun run(vararg args: String?) {
//
//        //loading data into mongo
//        println("loading categories")
//        categoryRepository.save(Category(categoryNumber = 1)).block()
//        categoryRepository.save(Category(categoryNumber = 2)).block()
//        categoryRepository.save(Category(categoryNumber = 3)).block()
//
//        //loading data into mongo
//        println("loading vendors")
//        vendorRepository.save(Vendor(firstName = "Rupali", lastName = "Gangarde")).block()
//        vendorRepository.save(Vendor(firstName = "Joey", lastName = "Tribiyani")).block()
//        vendorRepository.save(Vendor(firstName = "Chandler", lastName = "Bing")).block()
//
//        println("Loaded categories count is ${categoryRepository.count().block()}")
//        println("Loaded vendors count is ${vendorRepository.count().block()}")
//    }
//}