# The Aurorae Backend

## Endpoints

### public

| Endpoint | Method | Content Type | Auth needed? | Description |
| -------- | -------- | ------- | ------- | ------- |
| `/public` | GET | `application/json` | yes | Accessible without authentication, this endpoint allows anonymous access to the landing page. |
| `/public` | POST | `application/json` | yes | Provides data for the landing page. |
| `/hello` | POST | `application/json` | no | A greeting api endpoint - just for fun! |

### admin dashboard

| Endpoint | Method | Content Type | Auth needed? | Description |
| -------- | -------- | ------- | ------- | ------- |
| `/admin` |  GET | `application/json` | yes | Protected endpoint to access Aurorae dashboard. |

### authentication API

| Endpoint | Method | Content Type | Auth needed? | Description |
| -------- | -------- | ------- | ------- | ------- |
| `/api/v1/login` |  POST | `application/json` | no | Accessible endpoint to login as existing user. | `{emailAddress: string, password: string}` |
| `/api/v1/register` |  POST | `application/json` | no | Accessible endpoint to login as existing user. | `{username: string, emailAddress: string, password: string}, passwordRepeat: string` |


