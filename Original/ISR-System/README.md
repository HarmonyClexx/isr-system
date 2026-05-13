# Intelligent Submission & Review System

A Java-based research submission and evaluation system developed for COS730 at the University of Pretoria.

## Overview

The **Intelligent Submission & Review System (ISR)** is a comprehensive platform designed to streamline the process of submitting research papers and managing peer reviews.
## Features

- **Research submission**: Submit research papers with title and content
- **Validation**: Automatic validation of research submissions
- **Evaluation management**: Manage research evaluations and reviews
- **Reviewer management**: Handle reviewer assignments and management
- **Notifications**: Automated notification service for submission status
- **Database integration**: MongoDB support for data persistence

## Prerequisites

- **Java 26** or higher
- **Maven 3.6+**
- **MongoDB** (for database operations)

### Installing Java 26

```bash
# On Ubuntu/Debian
sudo apt-get install openjdk-26-jdk

# On macOS with Homebrew
brew install java@26

# Verify installation
javac -version
```

### Installing Maven

```bash
# On Ubuntu/Debian
sudo apt-get install maven

# On macOS with Homebrew
brew install maven

# Verify installation
mvn -version
```

### Setting up MongoDB

```bash
# On Ubuntu/Debian
sudo apt-get install mongodb

# On macOS with Homebrew
brew install mongodb-community

# Start MongoDB service
# On Ubuntu/Debian
sudo systemctl start mongodb

# On macOS
brew services start mongodb-community
```

## Building the project

### Using Maven

```bash
# Navigate to the project directory

# Clean and build
mvn clean package

# Or just compile
mvn clean compile
```

The compiled classes will be in the `target/classes/` directory.

## Running the Application

### Direct execution

First, ensure MongoDB is running, then:

If using IntelliJ IDEA or Eclipse:
1. Open the project in your IDE
2. Locate `Main.java` in `src/main/java/com/isr/baseline/`
3. Right-click and select "Run" or press `Ctrl+Shift+F10` (IntelliJ)

## Using the Application

When you run the application, you'll be prompted to:

1. **Enter Research Title**: Provide a title for your research submission
2. **Enter Research Content**: Enter the research content (leave empty to test validation)

The system will then:
- Validate your submission
- Process it through the evaluation system
- Notify you of the result

### Example Usage

```
Research Submission System (Baseline Version)
Enter Research Title: Machine Learning Applications in Data Science
Enter Research Content (Leave empty to test 'invalid' path): This paper discusses...
UI: Forwarding submission to Controller...
Validator: Checking data format...
Controller: received confirmation from Database
SubmissionController: getting available reviewers...
ReviewerManager: fetching reviewers from Database...
Database: returned 3 reviewers
ReviewerManager: Filtering conflicts...
ReviewerManager: Checking workloads...
Review assigned to: Dr. Smith
Review assigned to: Prof. Jones
Evaluation Process Started.
EvaluationManager: Calculating Average...
EvaluationManager: Checking Consensus...
EvaluationManager: Applying Rules...
NotificationService: Acceptance notification prepared

[*] UI NOTIFICATION: Final System Message
Status: Your submission has been reviewed.
```

## Dependencies

The project uses the following key dependencies (see `pom.xml`):

- **MongoDB Java Driver** (4.11.1): Database connectivity
- **SLF4J Simple** (2.0.12): Logging framework

## Troubleshooting

### MongoDB connection issues

If you encounter MongoDB connection errors:

```bash
# Check if MongoDB is running
sudo systemctl status mongodb

# Restart MongoDB
sudo systemctl restart mongodb

# Check MongoDB logs
tail -f /var/log/mongodb/mongod.log
```

### Java Version mismatch

```bash
# Verify your Java version
java -version

# Set JAVA_HOME if needed
export JAVA_HOME=/path/to/java-26
```

### Maven build issues

```bash
# Clean Maven cache and rebuild
mvn clean install -U

# Check for dependency conflicts
mvn dependency:tree
```

### Creating a JAR File

```bash
# Add maven-shade-plugin to pom.xml for fat JAR creation
mvn clean package
```

## Contributing

This is an academic project for COS730. Follow the existing code structure and naming conventions when contributing.

## License

This project is part of the University of Pretoria COS730 course. Please refer to the course guidelines for usage and distribution.

## Contact & Support

For issues or questions related to this project, please contact your course instructor or teaching assistants.

