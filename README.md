# blackstar
-- build
mvn spring-boot:run
https://rogerdudler.github.io/git-guide/index.de.html 

-- get list of tags
git tag -l
-- tag
git log
git tag 2.0.1 id (as derived from latest commit)

-- build docker image
docker build -t blissfish/blackstar:2.0.0 .

-- run
docker run --rm -p 8080:8080 blissfish/blackstar:2.0.0 .

-- push to docker hub
docker login

docker push blissfish/blackstar:2.0.2

docker system prune -a





https://docs.microsoft.com/de-de/azure/aks/kubernetes-walkthrough

az group create --name BlissfishRG --location eastus

az aks create \
    --resource-group BlissfishRG \
    --name BlissfishAKSCluster \
    --node-count 1 \
    --enable-addons monitoring \
    --generate-ssh-keys
    
az aks get-credentials --overwrite-existing --resource-group BlissfishRG --name BlissfishAKSCluster

kubectl get nodes

kubectl apply -f blissfish-blackstar-deployment.yaml
kubectl apply -f blissfish-blackstar-service.yaml

kubectl get service blissfish-blackstar --watch

kubectl run blissfish-blackstar --image=blissfish/blackstar:1.0.0 --port 8080

kubectl delete deployment blissfish-blackstar --grace-period=0

kubectl expose deployment blissfish-blackstar --type=LoadBalancer --port 80 --target-port 8080

kubectl delete service blissfish-blackstar --grace-period=0

https://docs.microsoft.com/de-de/azure/aks/kubernetes-dashboard
kubectl create clusterrolebinding kubernetes-dashboard --clusterrole=cluster-admin --serviceaccount=kube-system:kubernetes-dashboard
az aks browse --resource-group BlissfishRG --name BlissfishAKSCluster
az group delete --name BlissfishRG --yes --no-wait
az aks delete --name BlissfishAKSCluster --resource-group BlissfishRG --no-wait

HELM
kubectl apply -f helm-rbac.yaml

