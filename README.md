* Access eureka dashboard in localhost:8080/eureka, implement in pos_server
* To shutdown service in eureka, use endpoint localhost:<server_port>/actuator/shutdown with POST method
* Use annotations EnableFeignClient to access other services from endpoint (must be implement DTO client)
* Run first the pos_server, then the eureka server, then the gateway server and other services
* Access endpoint from gateway server in localhost:8084/ichwan/<service_name>/<endpoint>
* Use Apache Benchmark to test the performance of the service with implement rate limiter and also run redis from docker
* Docs of [Resilience4j](https://resilience4j.readme.io/docs/getting-started)
* Access grafana in localhost:3000 and prometheus in localhost:9090/targets
* Change grafana dashboard visualize, visit [Grafana Dashboard](https://grafana.com/grafana/dashboards/) (use JVM or spring boot dashboard), copy the link, login to grafana with admin/admin, and import the dashboard