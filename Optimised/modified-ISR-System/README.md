# Intelligent Submission & Review System (OPTIMIZED)

An optimized Java application for managing research output submissions and automated review workflows.

## Overview

The **Intelligent Submission & Review System (ISR)** is a comprehensive platform designed to streamline the process of submitting research papers and managing peer reviews. This optimized version implements clean architecture principles with well-separated layers including controllers, models, repositories, and services.

### Key Features

- **Research paper submission**: Submit research papers with title and content validation
- **Automated validation**: Content validation with minimum length requirements (20 characters)
- **Review workflow management**: Automated workflow for assigning and tracking reviews
- **Reviewer management**: Track and manage reviewer information and assignments
- **Notification system**: Notify relevant stakeholders of submission status
- **Evaluation service**: Evaluate submission quality and reviewer feedback

## Prerequisites

Before running this project, ensure you have the following installed:

- **Java 26** or higher (configured in pom.xml)
- **Maven 3.6+** - For building and managing dependencies
- **MongoDB** - For data persistence

## Building the project

### Step 1: Navigate to the project directory

### Step 2: Build the project with Maven

```bash
mvn clean compile
```

This command will:
- Clean any previous build artifacts
- Download dependencies (MongoDB driver and SLF4J)
- Compile the Java source code

### Step 3: Create the executable package (optional)

```bash
mvn package
```

## Running the Application

### Option 1: Using Maven Exec Plugin

```bash
mvn exec:java
```

This is the simplest way to run the application directly. Maven will compile and execute the main class.

### Option 2: Using Java directly - after building

```bash
mvn clean package
java -cp target/modified-ISR-System-1.0-SNAPSHOT.jar:$HOME/.m2/repository/org/mongodb/mongodb-driver-sync/4.11.1/mongodb-driver-sync-4.11.1.jar:$HOME/.m2/repository/org/slf4j/slf4j-simple/2.0.12/slf4j-simple-2.0.12.jar com.isr.optimised.Main
```

### Option 3: Direct dxecution

First, ensure MongoDB is running, then:

If using IntelliJ IDEA or Eclipse:
1. Open the project in your IDE
2. Locate `Main.java` in `src/main/java/com/isr/baseline/`
3. Right-click and select "Run" or press `Ctrl+Shift+F10` (IntelliJ)

## Usage

Once the application runs, you'll be prompted to:

1. **Enter research paper title**: Provide a title for your research output
2. **Enter research content**: Supply the research paper content (minimum 20 characters required)

Example:
```
Research Submission System (Optimised version)
Log: Acting as Researcher (Actor)
Enter Research Paper Title: Machine Learning Applications in Data Science
Enter Research Content (min 20 chars for validity): This paper discusses...

[Action] Submitting research output...
UI: Forwarding submission to Controller...
Controller: received confirmation from Database
Reviewer [Dr. Smith]: Notification received for submission 6a04ddb52cfb9f3a9e5d8baa
Reviewer [Prof. Jones]: Notification received for submission 6a04ddb52cfb9f3a9e5d8baa
Reviewer [Dr. Smith]: Submitted score 85 for submission 6a04ddb52cfb9f3a9e5d8baa
Reviewer [Prof. Jones]: Submitted score 78 for submission 6a04ddb52cfb9f3a9e5d8baa
[Email Sent] To: RES-99 | Status: Accepted
UI: Success! Submission fully processed.

```

The system will:
- Validate the submitted content
- Process the submission through the workflow
- Assign reviewers if applicable
- Display success or error messages

## Dependencies

- **MongoDB Driver Sync** (v4.11.1) - For database operations
- **SLF4J Simple** (v2.0.12) - For logging

All dependencies are managed by Maven and will be automatically downloaded during the build process.

## Configuration

### Java Compiler Version

The project is configured to use Java 26:
- Source version: 26
- Target version: 26

If you need to change this for compatibility, edit the `pom.xml` file:

```xml
<properties>
    <maven.compiler.source>YOUR_VERSION</maven.compiler.source>
    <maven.compiler.target>YOUR_VERSION</maven.compiler.target>
</properties>
```

### Main Class

The application entry point is configured in `pom.xml`:

```xml
<mainClass>com.isr.optimised.Main</mainClass>
```

## Troubleshooting

### Issue: "Java version not found"

**Solution**: Ensure Java 26 is installed:
```bash
java -version
```

### Issue: Maven not found

**Solution**: Install Maven or add it to your PATH:
```bash
# On Ubuntu/Debian
sudo apt-get install maven

# Verify installation
mvn -version
```

### Issue: Compilation errors

**Solution**: Clean and rebuild:
```bash
mvn clean compile
```

### Issue: Missing dependencies

**Solution**: Maven should automatically download dependencies, but if issues persist:
```bash
mvn clean install -U
```

## Contributing

This is an academic project for COS730. Follow the existing code structure and naming conventions when contributing.

## License

This project is part of the University of Pretoria COS730 course. Please refer to the course guidelines for usage and distribution.

## Contact & Support

For issues or questions related to this project, please contact your course instructor or teaching assistants.


