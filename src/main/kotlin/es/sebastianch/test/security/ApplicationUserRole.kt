package es.sebastianch.test.security

import es.sebastianch.test.security.ApplicationUserPermisions.*
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class ApplicationUserRole(private val rolePermisions: Set<ApplicationUserPermisions>) {
    USER(setOf(USER_READ, USER_WRITE)),
    ADMIN(setOf(USER_READ, USER_WRITE, ADMIN_READ, ADMIN_WRITE));

    // This method is used to get the authorities of the user
    fun getGrantedAuthorities() =
        rolePermisions.map {
            SimpleGrantedAuthority(it.permission)
        }.toSet()
            .plus(
                SimpleGrantedAuthority("ROLE_${this.name}")
            )




}