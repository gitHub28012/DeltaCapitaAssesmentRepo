**DeltaCapita Assessment Repository
This repository contains two separate automation projects created for the Delta Capita assessment.
Each project focuses on a different aspect of testing — one for UI & data-driven automation and the other for unit-level testing**.

 **Projects Overview**
 
1.**DeltaCapitaAutomationTask**
**Type: UI Automation (Selenium + TestNG)**
**Tech Stack:**
Java – Core programming language
Selenium WebDriver – Browser automation
Apache POI – Excel data handling (Data-Driven Testing)
TestNG – Test management & execution
ExtentReports – Interactive HTML test reporting
**Key Features:**
Data-driven testing using Apache POI to read test data from Excel.
Reusable Page Object Model (POM) structure for maintainability.
Automated report generation with ExtentReports.
Customizable configuration via property files.
Supports cross-browser execution (configurable in testng.xml).
**Project Structure:**
DeltaCapitaUnitTestAutomationTask/
│── src/main/java    # Core application logic
│── src/test/java    # Unit test classes
│── testng.xml       # TestNG configuration




2. **DeltaCapitaUnitTestAutomationTask**
**Type: Unit Test Automation**
**Tech Stack:**
Java – Core programming language
TestNG – Test execution and assertions
**Key Features:**
Focused on unit-level testing of Java methods.
Uses TestNG assertions for validation.
Lightweight and fast to execute.
**Project Structure:**
DeltaCapitaUnitTestAutomationTask/
│── src/main/java    # Core application logic
│── src/test/java    # Unit test classes
│── testng.xml       # TestNG configuration






