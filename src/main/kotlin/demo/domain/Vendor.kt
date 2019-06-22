package demo.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "vendor")
data class Vendor(

        @Id
        private val id: String,

        private val firstName: String,
        private val lastName: String
)