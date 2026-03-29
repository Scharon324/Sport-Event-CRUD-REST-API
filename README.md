# Sport-Event-CRUD-REST-API

### Creating Sport Events:

$ curl -X POST http://localhost:8080/events \
-H "Content-Type: application/json" \
-d '{
  "name": "Basketball Game",
  "sport": "Basketball",
  "startTime": "2026-05-10T19:30:00",
  "status": "INACTIVE"
}'

{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"INACTIVE"}

$ curl -X POST http://localhost:8080/events \
-H "Content-Type: application/json" \
-d '{
  "name": "Marathon",
  "sport": "Running",
  "startTime": "2026-06-01T09:00:00",
  "status": "ACTIVE"
}'

{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}

### Getting all sport events

$ curl http://localhost:8080/events

[{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"INACTIVE"},
{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

### Filtering By Status

$ curl "http://localhost:8080/events?status=ACTIVE"

[{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

$ curl "http://localhost:8080/events?status=INACTIVE"

[{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"INACTIVE"}]

### Name search

$ curl "http://localhost:8080/events?name=Basketball"all"

[{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"INACTIVE"},
{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

### Status Change

$ curl -X PATCH "http://localhost:8080/events/1/status?status=ACTIVE"

{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"ACTIVE"}

$ curl http://localhost:8080/events

[{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"ACTIVE"},
{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

### Deleting Test

$ curl -X DELETE http://localhost:8080/events/1

Event deleted successfully

$ curl http://localhost:8080/events

[{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

### Updating Test

$ curl -X PUT http://localhost:8080/events/2 \
-H "Content-Type: application/json" \
-d '{
  "name": "Updated Marathon",
  "sport": "Running",
  "startTime": "2026-07-01T10:00:00",
  "status": "ACTIVE"
}'

{"id":2,"name":"Updated Marathon","sport":"Running","startTime":"2026-07-01T10:00:00","status":"ACTIVE"}

## Filter by status only

$ curl "http://localhost:8080/events?sport=Running"

[{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

$ curl "http://localhost:8080/events?status=INACTIVE"

[{"id":1,"name":"Basketball Game","sport":"Basketball","startTime":"2026-05-10T19:30:00","status":"INACTIVE"}]

## Filtering both by sport and status

$ curl "http://localhost:8080/events?sport=Running&status=ACTIVE"

[{"id":2,"name":"Marathon","sport":"Running","startTime":"2026-06-01T09:00:00","status":"ACTIVE"}]

## Sending bad request

$ curl -X POST http://localhost:8080/events \
-H "Content-Type: application/json" \
-d '{"name": "", "sport": "", "status": "ACTIVE"}'

{"name":"Event name is required","startTime":"Start time is required","sport":"Sport is required"}