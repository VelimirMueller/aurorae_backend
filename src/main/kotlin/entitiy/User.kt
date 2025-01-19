package entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import io.quarkus.elytron.security.common.BcryptUtil
import io.quarkus.security.jpa.Password
import io.quarkus.security.jpa.Roles
import io.quarkus.security.jpa.UserDefinition
import io.quarkus.security.jpa.Username

class Person: PanacheEntity() {
    lateinit var name: String
    lateinit var email: String
    lateinit var role: String
}