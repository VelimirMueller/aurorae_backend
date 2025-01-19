package entity

import jakarta.persistence.Entity
import jakarta.persistence.Table

import io.quarkus.hibernate.orm.panache.PanacheEntity
import io.quarkus.elytron.security.common.BcryptUtil
import io.quarkus.security.jpa.Password
import io.quarkus.security.jpa.Roles
import io.quarkus.security.jpa.UserDefinition
import io.quarkus.security.jpa.Username

@Entity
@Table(name = "user_t")
@UserDefinition
public class User extends PanacheEntity {
   
}