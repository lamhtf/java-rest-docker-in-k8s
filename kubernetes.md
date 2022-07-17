# <font color="lihtblue">Create a Docker Image</font>

<h3>Run Maven Install to build to app first</h3>

    mvn clean install

<h3>Login docker desktop by</h3>

    docker login --username lamht

<h3>Create this java docker local image by</h3>

    docker build -t lamht/java-docker:2022.07.09 .

<h3>Docker run locally to test whether it can run successfully</h3>

    docker run -p 8000:8080 lamht/java-docker:2022.07.09
    (-p means --publish)

<h3>Push this java docker image to docker repository by</h3>

    docker push lamht/java-docker:2022.07.09

# <font color="yellow">Create a minikube</font>

https://minikube.sigs.k8s.io/docs/start/
    
https://kubernetes.io/docs/tutorials/hello-minikube/

<h3>Start the local kubernetes (Start your cluster)</h3>

    minikube start

<h3>You can now use it to access your shiny new cluster</h3>

    kubectl get po -A

<h3>Open the Kubernetes dashboard in a browser</h3>

    minikube dashboard

# <font color="lightgreen">Create a Deployment</font>

<h3><font color='gold'>Use the kubectl create command to create a Deployment that manages a Pod. The Pod runs a Container based on the provided Docker image.</font></h3>

    kubectl create deployment java-docker --image=lamht/java-docker:2022.07.09

<h3>View the Deployment:</h3>
    
    kubectl get deployment

The output is similar to:

    NAME          READY   UP-TO-DATE   AVAILABLE   AGE
    java-docker   0/1     1            0           36m

<h3>View the Pod:</h3>

    kubectl get pod

The output is similar to:

    NAME                           READY   STATUS             RESTARTS   AGE
    java-docker-7f5df9f4cd-zsq5q   0/1     ImagePullBackOff   0          37m

<h3>View cluster events:</h3>

    kubectl get event

<h3>View the kubectl configuration:</h3>

    kubectl config view

#   <p style='color:orange'>Create a Service</p>
<h3><p style="color:gold">Expose the Pod to the public internet using the kubectl expose command:</p></h3>
````
kubectl expose deployment java-docker --type=LoadBalancer --port=8080

kubectl expose deployment java-docker --type=NodePort --port=8080

kubectl expose deployment java-docker --type=ClusterIP --port=8080
````

<h3>View the Service:</h3>
````
kubectl get service
````
The output is similar to:
````
NAME          TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
java-docker   NodePort    10.100.98.201   <none>        8080:32495/TCP   107m
kubernetes    ClusterIP   10.96.0.1       <none>        443/TCP          7d4h
````
<h3><p style="color:gold">Run the following command to open the browser for that service:</p></h3>
````
minikube service java-docker
````
# <p style='color:orange'>Create Deployment & Service by yaml</p>
````
kubectl apply -f examples/guestbook/all-in-one/guestbook-all-in-one.yaml
````
#    <font color="red">Clean up</font>
<h3>Now you can clean up the resources you created in your cluster:</h3>
````
kubectl delete service java-docker
kubectl delete deployment java-docker
````

<h3>Optionally, stop the Minikube virtual machine (VM):</h3>
````
minikube stop
````

# Others
<h3>Apply config (including secret, configMap, deployment, service)</h3>
````
kubectl apply -f <spec.yaml>
````

<h3>Store the generated Deployment.yaml or Service.yaml</h3>
````
kubectl get deployment <deployment-name> -o yaml > deployment.yaml
kubectl get service <service-name> -o yaml > service.yaml
````

# Debug
<h3>Execute into the Linux environment</h3>
````
kubectl exec -it <pod-name> /bin/bash
````

<h3>Check the logs of the Pod</h3>
````
kubectl logs <pod-name>
kubectl logs -f <pod-name>
````