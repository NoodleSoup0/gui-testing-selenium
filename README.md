# Basketball Schedule GUI Test Automation

This project demonstrates automated GUI testing for the [nusports.com](https://nusports.com) Women’s Basketball schedule. It uses Selenium, JUnit, and Cucumber, showing the workflow from test recording to maintainable Page Object design.

---

## Overview

Steps:

- Recording browser interactions using **Katalon Recorder**  
- Converting the recording into **JUnit Selenium tests**  
- Splitting tests into **Cucumber step definitions**  
- Refactoring into **Page Objects** for maintainability  

Technologies:

- **Java:** JDK 11  
- **JUnit:** 5.10  
- **Gradle:** 8.10  
- **Selenium WebDriver (ChromeDriver)** – Automates browser interactions in code.    
- **Cucumber** – Allows writing readable, BDD-style test scenarios.    
- **Katalon Recorder** – A browser extension for recording web interactions, similar to Selenium IDE. It can generate Selenium-compatible Java code, which we used as the starting point for our automated tests.

---

## Process

1. **Record Test with Katalon Recorder**  
   - Record navigating to **Sports → Women’s Basketball → Schedule**  
   - Add `assertText` to verify the first game score  

3. **Generate & Refine JUnit Test**  
   - Export Katalon test as **Java (WebDriver + JUnit)**   
   - Add `Actions` hover for Sports menu  
   - Run Gradle `test` to verify  

4. **Convert to Cucumber Scenario**  
   - Create `BasketballSchedule.feature`  
   - Implement step definitions using Selenium actions  
   - Add `@After` to close the browser  

5. **Refactor into Page Objects**  
   - `SportsMenu.java` → hover and navigate to basketball menu  
   - `BasketballMenu.java` → click schedule link  
   - `BasketballSchedule.java` → get the game score  
   - Step definitions now call Page Object methods for cleaner, maintainable code  

---

## Running Tests

```bash
./gradlew cucumber
