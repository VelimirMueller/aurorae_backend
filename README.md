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
| `/admin` |  GET | - [x] | Protected endpoint to access Aurorae dashboard. |

