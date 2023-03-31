package es.sebastianch.test.security

enum class ApplicationUserPermisions(val permission: String) {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");
}