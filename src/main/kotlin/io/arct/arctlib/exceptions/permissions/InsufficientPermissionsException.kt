package io.arct.arctlib.exceptions.permissions

class InsufficientPermissionsException : PermissionException() {
    override val node: String = "error.insufficient-permissions"
    override val arguments: List<String> = emptyList()
}
