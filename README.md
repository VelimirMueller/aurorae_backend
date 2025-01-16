# The Aurorae Backend

## Endpoints

### public

| Endpoint | Method | Auth needed? | Description |
| -------- | -------- | ------- | ------- |
| `/public` | GET | no | Accessible without authentication, this endpoint allows anonymous access to the landing page. |
| `/public` | POST | no | Provides data for the landing page. |
| `/hello` | POST | no | A greeting api endpoint - just for fun! |

### admin dashboard

| Endpoint | Method | Auth needed? | Description |
| -------- | -------- | ------- | ------- |
| `/admin` |  GET | yes | Protected endpoint to access Aurorae dashboard. |

### authentication API

| Endpoint | Method | Auth needed? | Description | payload |
| -------- | -------- | ------- | ------- | ------- |
| `/api/v1/login` |  POST | no | Accessible endpoint to login as existing user. | `{emailAddress: string, password: string}` |
| `/api/v1/register` |  POST | no | Accessible endpoint to login as existing user. | `{username: string, emailAddress: string, password: string}, passwordRepeat: string` |


