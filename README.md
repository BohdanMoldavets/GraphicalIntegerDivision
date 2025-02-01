# Graphical Integer Division

#### A Java application for performing and formatting integer division step by step.

---

## 🧩 Project Description
This project performs integer division and formats the output as a step-by-step graphical long division.
It takes two integer inputs (dividend and divisor), processes the division operation,
and outputs a structured textual representation of the division process.
---

## 🚀 Features

- Performs integer division step by step.

- Formats the result using a classic long division layout.

- Modular architecture with separation of concerns.

- Includes unit tests for core functionality.

---

## 🧰 Tech stack used in this project
- **Java 21** 
- **JUnit 5** (Testing framework)
- **Maven** (Build and dependency management tool)

---

## 🔑 Key Features
- **Modular Structure:** Clearly separated logic for calculation, formatting, and utilities.
- **Classic Long Division Formatting:** Outputs a human-readable graphical division process.
- **Flexible Table Formatting:** Supports customizable table output.
- **Unit Tests:** Ensures correctness with JUnit.


---

## 📂 Project Structure
```
src
├── main
│   ├── java
│   │   └── com.moldavets.integerdivision
│   │       ├── formatter    // Formatting logic for division output
│   │       ├── model        // Data models for division results
│   │       ├── service      // Core division logic
│   │       └── utils        // Utility functions
│   └── resources            // Resource files (if needed)
└── test
    └── java
        └── com.moldavets.integerdivision
            ├── formatter    // Tests for formatting logic
            └── service      // Tests for division logic
```
---

## ⚙️ Installation and Setup

**1. Clone the Repository**
```
https://github.com/BohdanMoldavets/GraphicalIntegerDivision.git
cd GraphicalIntegerDivision
```

**2. Install Dependencies**

```
cd GraphicalIntegerDivision
mvn clean install
```

**3. Start the Application**

---

## 🛑 FAQ
### Q: How can I change the input numbers?
 + **A:** A: Modify the ```Main``` class in ```src/main/java/com/moldavets/integerdivision/Main.java``` and update the ```divide()``` method parameters.
### Q: How can I run tests?
+ **A:** Execute the following command:
```
mvn test
```
---
# Contact
+ Email: [steamdlmb@gmail.com](mailto:steamdlmb@gmail.com)
+ [Telegram](https://telegram.me/moldavets)
+ [Linkedin](https://www.linkedin.com/in/bohdan-moldavets/)


