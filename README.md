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
* Use this command to run dashboard `kubectl -n kubernetes-dashboard port-forward svc/kubernetes-dashboard-kong-proxy 8443:443` and access to https://locahost:8443 -> use alias k-dashboard to run this command
* Use command secrets for admin-user to long-live bearer `kubectl get secret admin-user -n kubernetes-dashboard -o jsonpath="{.data.token}" | base64 -d` -> use alias k-secret to run this command
* K8S API Server run on port 443, for authN and authZ checks, front end for control plane also centralize communication both internal and external, use command `kubectl apply -f namefile.yaml` to deploy.
* Cluster store like db, it's call [etcd](https://etcd.io) (distributed key-value store), store the entire state after deployment. 
* Scheduler in k8s is watches for new workloads/ports and assign them to a node based on several scheduling factors (like rollback-rollout pods).
* Worker node have 3 main concepts: kubelet (main agent that runs on every node also report node state to master node), container runtime (pulling image and start container from container registry i.e docker, [containerd](https://containerd.io)), kube proxy (routing net traffic to load balanced service)
* [minikube handbook](https://minikube.sigs.k8s.io/docs/handbook/)
* If dashboard cannot open, run this command to check the kubernetes-dashboard-kong is crashloopbackoff or not `kubectl get pods -n kubernetes-dashboard`, if yes delete the pod `kubectl delete pod -n kubernetes-dashboard kubernetes-dashboard-kong-xxxxx` and run again command to forward kubernetes-dashboard
* Show pods with IP used command `kubectl get pods -o wide`
* `helm create pos-common` to create helm template
* `helm dependencies build` to build helm charts
* search for any chart template helm from community in [bitnami](https://github.com/bitnami/charts)
* Use alias in command, i.e `alias k="kubectl"`