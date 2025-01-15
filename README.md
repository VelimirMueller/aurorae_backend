# The Aurorae Backend

## Endpoints

| Endpoint | Description |
| -------- | ----------- |
| `/api/public` | Accessible without authentication, this endpoint allows anonymous access. |
| `/api/admin` | Secured with role-based access control (RBAC), this endpoint is accessible only to users with the adminrole. Access is controlled declaratively by using the @RolesAllowed annotation. |
| `/api/users/me` | Also secured by RBAC, this endpoint is accessible only to users with the user role. It returns the caller’s username as a string. |

