Deploying a PostgreSQL database and a Spring Boot application on Kubernetes involves several steps. Kubernetes is a container orchestration platform that can manage and scale your application and database containers. Here's a high-level overview of how to do this:

1. **Set up Kubernetes Cluster:**
    - You can use a managed Kubernetes service like Google Kubernetes Engine (GKE), Amazon EKS, or set up your own cluster using tools like Minikube for local development.

2. **Create Docker Images:**
    - Containerize your Spring Boot application and PostgreSQL database. You can use Docker for this purpose.

3. **Store Docker Images:**
    - Push your Docker images to a container registry like Docker Hub, Google Container Registry, or Amazon Elastic Container Registry (ECR).

4. **Write Kubernetes Manifests:**
    - Create Kubernetes YAML manifests to define your application's deployment, service, and other resources. Below is an example:

   ```yaml
   # postgres-deployment.yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: postgres-deployment
   spec:
     replicas: 1
     selector:
       matchLabels:
         app: postgres
     template:
       metadata:
         labels:
           app: postgres
       spec:
         containers:
           - name: postgres
             image: postgres:latest
             env:
               - name: POSTGRES_DB
                 value: your_database
               - name: POSTGRES_USER
                 value: your_user
               - name: POSTGRES_PASSWORD
                 value: your_password
             
   # spring-boot-deployment.yaml
   apiVersion: apps/v1
   kind: Deployment
   metadata:
     name: spring-boot-deployment
   spec:
     replicas: 3
     selector:
       matchLabels:
         app: spring-boot-app
     template:
       metadata:
         labels:
           app: spring-boot-app
       spec:
         containers:
           - name: spring-boot-app
             image: your-spring-boot-image
             ports:
               - containerPort: 8080
   ```

   You will also need to create Kubernetes Service manifests to expose your services.

5. **Deploy to Kubernetes:**
    - Use `kubectl` to apply your YAML manifests:

   ```bash
   kubectl apply -f postgres-deployment.yaml
   kubectl apply -f spring-boot-deployment.yaml
   ```

6. **Access the Spring Boot Application:**
    - Your Spring Boot application can be accessed via the service you exposed, typically by the NodePort or LoadBalancer.

7. **Database Initialization:**
    - You can use Kubernetes Jobs to run SQL scripts to initialize the database. Create a Job YAML file to run the scripts. For example:

   ```yaml
   apiVersion: batch/v1
   kind: Job
   metadata:
     name: db-init-job
   spec:
     template:
       spec:
         containers:
         - name: db-init-container
           image: postgres:latest
           env:
             - name: POSTGRES_DB
               value: your_database
             - name: POSTGRES_USER
               value: your_user
             - name: POSTGRES_PASSWORD
               value: your_password
           command: ["psql", "-h", "your_postgres_service", "-U", "your_user", "-d", "your_database", "-a", "-f", "/path/to/your/sql/script.sql"]
         restartPolicy: Never
   ```

   Then, apply the Job manifest:

   ```bash
   kubectl apply -f db-init-job.yaml
   ```

This is a simplified overview of deploying a Spring Boot application with a PostgreSQL database on Kubernetes. You may need to adapt these steps to your specific needs, and consider using a Kubernetes Helm chart for a more sophisticated and reusable deployment setup.