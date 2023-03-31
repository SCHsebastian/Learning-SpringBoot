package es.sebastianch.test.security

import es.sebastianch.test.security.ApplicationUserPermisions.*

enum class ApplicationUserRole(val rolePermisions: Set<ApplicationUserPermisions>) {
    USER(setOf(USER_READ, USER_WRITE)),
    ADMIN(setOf(USER_READ, USER_WRITE, ADMIN_READ, ADMIN_WRITE)),
}