* Access eureka dashboard in localhost:8080/eureka, implement in pos_server
* To shutdown service in eureka, use endpoint localhost:<server_port>/actuator/shutdown with POST method
* Use annotations EnableFeignClient to access other services from endpoint (must be implement DTO client)
* Run first the pos_server, then the eureka server, then the gateway server and other services
* Access endpoint from gateway server in localhost:8084/ichwan/<service_name>/<endpoint>
* Use Apache Benchmark to test the performance of the service with implement rate limiter and also run redis from docker
* Docs of [Resilience4j](https://resilience4j.readme.io/docs/getting-started)
* Access grafana in localhost:3000 and prometheus in localhost:9090/targets
* Start to config keycloak from [docker](https://www.keycloak.org/getting-started/getting-started-docker)
* Try [oauth2 playground](https://www.oauth.com/playground/) to test the oauth2 flow
* [keycloak docs](https://www.keycloak.org/docs-api/latest/rest-api/index.html)
* latest RabbitMQ 4.x `docker run -it -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management`