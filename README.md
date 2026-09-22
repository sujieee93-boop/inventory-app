# Inventory Application

Spring Boot 3 / Java 17 inventory application used to demonstrate an AWS CI/CD pipeline with GitHub, CodeBuild, ECR, ECS Fargate and CodePipeline.

## Local run

```bash
mvn spring-boot:run
```

Open `http://localhost:8080`.

## AWS build

The supplied `buildspec.yml` builds the JAR, creates the Docker image, pushes `latest` to the `inventory-app` ECR repository in the active CodeBuild region, and produces `imagedefinitions.json` for an ECS standard deployment action.
