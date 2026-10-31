# Test Service

Small Spring Boot service registered with Config Server and Eureka. The
application endpoint is:

```http
GET /api/test?name=Asha
Authorization: Bearer <JWT from Org Access>
```

Response body:

```text
Hello Asha
```

Through the API Gateway, use `/test-service/api/test?name=Asha`. The Gateway
removes the `/test-service` prefix before forwarding the request. The service
uses port `8084` and validates bearer JWTs with the shared `JWT_SECRET`.

For local Docker Compose, start the infrastructure and service with:

```powershell
docker compose up -d --build test-service
```

For Jenkins, configure `TEST_SERVICE_REPO_URL` to the Git repository containing
this service, then choose `test-service` in the `SERVICE` parameter.
