
<h1>Create a <font color="yellow">minikube</font></h1>

https://minikube.sigs.k8s.io/docs/start/
    
https://kubernetes.io/docs/tutorials/hello-minikube/

<h3>Start the local kubernetes (Start your cluster)</h3>

    minikube start

<h3>You can now use it to access your shiny new cluster</h3>

    kubectl get po -A

<h3>Open the Kubernetes dashboard in a browser</h3>

    minikube dashboard

<h3>Create this java docker image by</h3>

    docker build -t java/docker:2022.07.09 .


<h3>Use the kubectl create command to create a Deployment that manages a Pod. The Pod runs a Container based on the provided Docker image.</h3>

    kubectl create deployment hello-node --image=k8s.gcr.io/echoserver:1.4

<h3>View the Deployment:</h3>
    
    kubectl get deployments

The output is similar to:

    NAME         READY   UP-TO-DATE   AVAILABLE   AGE
    hello-node   1/1     1            1           1m

<h3>View the Pod:</h3>

    kubectl get pods

The output is similar to:

    NAME                          READY     STATUS    RESTARTS   AGE
    hello-node-5f76cf6ccf-br9b5   1/1       Running   0          1m

<h3>View cluster events:</h3>

    kubectl get events

<h3>View the kubectl configuration:</h3>

    kubectl config view