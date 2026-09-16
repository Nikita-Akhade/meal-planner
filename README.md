# 🍽️ Meal Planner

A full-stack recipe and weekly meal-planning application built with **Java Spring Boot**, **PostgreSQL**, and **React**.

The application allows users to manage recipes and ingredients, organize recipes into weekly meal plans, and automatically generate a consolidated shopping list from the meals planned for the week.

The project was developed as a hands-on full-stack application, with a **Spring Boot REST API** powering a **React frontend** and PostgreSQL providing persistent data storage.

---

## 📋 Project Overview

Planning meals for an entire week can be time-consuming, especially when recipes contain multiple ingredients and quantities.

The goal of this project is to provide a simple application where users can:

* Create and manage recipes
* Store recipe ingredients and quantities
* Browse available recipes
* Search recipes by ingredient
* Create weekly meal plans
* Assign recipes to specific days and meal slots
* Automatically generate a shopping list
* Aggregate ingredients across all recipes in a weekly plan

### ⭐ Standout Feature

The main feature of the application is **automatic shopping-list generation**.

Instead of manually going through every recipe in a weekly meal plan, the backend collects the ingredients from all assigned recipes, groups identical ingredients together, and calculates their combined quantities.

For example:

```text
Monday Dinner
→ Chicken Curry
   → Chicken: 500 g
   → Rice: 200 g

Wednesday Lunch
→ Chicken Rice Bowl
   → Chicken: 300 g
   → Rice: 150 g
```

The generated shopping list can aggregate these into:

```text
Chicken: 800 g
Rice: 350 g
```

This demonstrates backend data aggregation across multiple related entities.

---

# 🚀 Features

## Recipe Management

* Create recipes
* View all recipes
* View individual recipe details
* Delete recipes
* Store preparation time
* Store cooking instructions
* Associate multiple ingredients with each recipe
* Store ingredient quantities

## Recipe Browsing

* Recipe card-based listing
* Recipe detail view
* Ingredient information
* Preparation information
* Cooking instructions
* Basic navigation using React Router

## Recipe Search

Recipes can be searched or filtered based on ingredients.

Example:

```text
Search: chicken
```

The application can retrieve recipes matching the requested ingredient.

## Weekly Meal Planning

The meal planner is organized around:

```text
7 Days × 3 Meal Slots
```

Example:

| Day       | Breakfast | Lunch  | Dinner |
| --------- | --------- | ------ | ------ |
| Monday    | Recipe    | Recipe | Recipe |
| Tuesday   | Recipe    | Recipe | Recipe |
| Wednesday | Recipe    | Recipe | Recipe |
| Thursday  | Recipe    | Recipe | Recipe |
| Friday    | Recipe    | Recipe | Recipe |
| Saturday  | Recipe    | Recipe | Recipe |
| Sunday    | Recipe    | Recipe | Recipe |

Recipes can be assigned to specific days and meal slots.

## 🛒 Automatic Shopping List

The shopping-list functionality:

1. Retrieves the selected meal plan
2. Finds all recipes assigned to the plan
3. Retrieves ingredients for those recipes
4. Groups identical ingredients
5. Adds their quantities
6. Returns a consolidated shopping list

The endpoint is:

```http
GET /mealplans/{id}/shopping-list
```

---

# 🏗️ Architecture

The project follows a typical full-stack client-server architecture.

```text
┌─────────────────────────────┐
│         React Frontend      │
│                             │
│  Recipe UI                  │
│  Meal Planner UI            │
│  Shopping List UI           │
└──────────────┬──────────────┘
               │
               │ HTTP / REST API
               ▼
┌─────────────────────────────┐
│      Spring Boot Backend    │
│                             │
│ Controllers                 │
│ Services                    │
│ Repositories                │
│ JPA Entities                │
└──────────────┬──────────────┘
               │
               │ JPA / Hibernate
               ▼
┌─────────────────────────────┐
│         PostgreSQL          │
│                             │
│ Recipes                     │
│ Ingredients                 │
│ Recipe Ingredients          │
│ Meal Plans                  │
│ Meal Plan Entries           │
└─────────────────────────────┘
```

---

# 🛠️ Technology Stack

## Backend

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **Maven**
* **PostgreSQL**

## Frontend

* **React**
* **Vite**
* **JavaScript / JSX**
* **React Router**
* **CSS**

## Development Tools

* Git
* GitHub
* Postman / curl
* PostgreSQL
* DBeaver or psql
* IntelliJ IDEA / VS Code

---

# 📁 Project Structure

```text
meal-planner/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   │
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
├── frontend/
│   ├── public/
│   ├── src/
│   │   ├── assets/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── index.css
│   │   └── main.jsx
│   │
│   ├── package.json
│   ├── package-lock.json
│   └── vite.config.js
│
├── .gitignore
└── README.md
```

---

# 🗄️ Data Model

The backend uses JPA entities to model the relationship between recipes, ingredients, and meal plans.

## Recipe

Represents a recipe.

Example information:

```text
Recipe
├── id
├── title
├── preparation time
└── instructions
```

## Ingredient

Represents an ingredient that can be used in recipes.

```text
Ingredient
├── id
└── name
```

## RecipeIngredient

Acts as a join entity between recipes and ingredients.

It stores the quantity required for a particular recipe.

```text
RecipeIngredient
├── id
├── recipe
├── ingredient
├── quantity
└── unit
```

This allows a recipe to contain multiple ingredients while the same ingredient can be reused across different recipes.

## MealPlan

Represents a weekly meal plan.

```text
MealPlan
├── id
└── week
```

## MealPlanEntry

Connects a recipe to a particular day and meal slot.

```text
MealPlanEntry
├── id
├── mealPlan
├── recipe
├── day
└── meal slot
```

---

# 🔌 REST API

The backend exposes REST endpoints that are consumed by the React frontend.

## Recipes

### Create Recipe

```http
POST /recipes
```

Creates a recipe including its ingredients.

### Get All Recipes

```http
GET /recipes
```

Returns all available recipes.

### Get Recipe

```http
GET /recipes/{id}
```

Returns details for a specific recipe.

### Delete Recipe

```http
DELETE /recipes/{id}
```

Deletes a recipe.

### Search Recipes

```http
GET /recipes?ingredient={ingredient}
```

Filters recipes based on an ingredient.

---

## Meal Plans

### Create Meal Plan

```http
POST /mealplans
```

Creates a weekly meal plan.

### Add Meal Plan Entry

```http
POST /mealplans/{id}/entries
```

Assigns a recipe to a specific day and meal slot.

### Get Meal Plan

```http
GET /mealplans/{id}
```

Returns the complete meal plan with assigned recipes.

---

## Shopping List

### Generate Shopping List

```http
GET /mealplans/{id}/shopping-list
```

Generates a consolidated shopping list from all recipes assigned to the meal plan.

---

# ⚙️ Local Development Setup

## Prerequisites

Make sure the following are installed:

* Java
* Maven
* Node.js
* npm
* PostgreSQL
* Git

---

# 🔧 Backend Setup

Navigate to the backend:

```bash
cd backend
```

Configure the PostgreSQL connection in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/meal_planner
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Do not commit real database passwords or other secrets to GitHub.

Start the Spring Boot application:

```bash
./mvnw spring-boot:run
```

The backend runs on:

```text
http://localhost:8080
```

---

# 🎨 Frontend Setup

Navigate to the frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The React application runs on:

```text
http://localhost:5173
```

---

# 🔄 Running the Full Application

Start the backend:

```bash
cd backend
./mvnw spring-boot:run
```

Then start the frontend in another terminal:

```bash
cd frontend
npm run dev
```

Open the React application in your browser:

```text
http://localhost:5173
```

The frontend communicates with the Spring Boot backend through REST APIs.

---

# 📅 Development Plan

The project was developed incrementally over an 8-day implementation plan.

## Day 1 — Project Setup

* Created the Spring Boot project using Spring Initializr
* Added Spring Web
* Added Spring Data JPA
* Added PostgreSQL driver
* Set up the local PostgreSQL database
* Created the React application using Vite
* Configured Spring Boot on port `8080`
* Configured React development server on port `5173`
* Verified both applications were running locally
* Created the initial GitHub repository

## Day 2 — Recipe & Ingredient Entities

Implemented the core recipe data model:

* `Recipe`
* `Ingredient`
* `RecipeIngredient`

Added Spring Data JPA repositories and connected the application to PostgreSQL.

The database schema was verified using PostgreSQL database tools such as DBeaver or `psql`.

## Day 3 — Recipe CRUD API

Implemented the recipe REST API:

```text
POST   /recipes
GET    /recipes
GET    /recipes/{id}
DELETE /recipes/{id}
```

The endpoints were tested independently using tools such as Postman or curl before connecting them to the frontend.

## Day 4 — Recipe Browsing UI

Implemented the React recipe browsing experience.

The frontend:

* Fetches recipes from the backend
* Displays recipes as cards
* Shows preparation information
* Provides a recipe detail page
* Displays ingredients and instructions
* Provides navigation between pages

React Router was used for frontend navigation.

## Day 5 — Recipe Form & Search

Added:

* Recipe creation form
* Dynamic ingredient rows
* Add/remove ingredient functionality
* Recipe search
* Ingredient-based filtering

The frontend communicates with the recipe API to create and retrieve data.

## Day 6 — MealPlan & MealPlanEntry

Added the meal-planning data model:

* `MealPlan`
* `MealPlanEntry`

Implemented endpoints for:

```text
POST /mealplans
POST /mealplans/{id}/entries
GET  /mealplans/{id}
```

These endpoints allow recipes to be assigned to specific days and meal slots.

## Day 7 — Weekly Calendar UI

Built the weekly meal-planning interface.

The interface uses a:

```text
7 days × 3 meal slots
```

layout.

Users can select recipes for empty meal slots and save those assignments through the backend API.

## Day 8 — Automatic Shopping List

Implemented the application's main aggregation feature.

The backend:

```text
Meal Plan
    ↓
Assigned Recipes
    ↓
Recipe Ingredients
    ↓
Group Ingredients
    ↓
Sum Quantities
    ↓
Shopping List
```

The resulting API is:

```http
GET /mealplans/{id}/shopping-list
```

The implementation keeps ingredient units consistent for the initial version and does not attempt complex unit conversions.

---

# 🧪 Testing

The backend API can be tested using:

* Postman
* curl

Database tables can be inspected using:

* DBeaver
* PostgreSQL `psql`

The shopping-list functionality should be tested with different weekly meal plans to verify that ingredient quantities are correctly aggregated.

---

# 🔐 Security & Configuration

Environment-specific configuration should not be committed to the public repository.

Sensitive values such as:

* Database passwords
* API keys
* Authentication secrets
* Environment variables

should be stored outside the repository.

Use an `.env` file or environment variables where appropriate and provide example configuration files without real credentials.

---

# 🚧 Future Improvements

Possible future improvements include:

* User authentication and authorization
* Multiple user meal plans
* Recipe editing
* Recipe favorites
* More advanced recipe search
* Ingredient categories
* Shopping-list checkboxes
* Persistent shopping-list status
* Ingredient unit conversion
* Nutritional information
* Recipe images
* Drag-and-drop meal planning
* Mobile-responsive improvements
* Deployment to a cloud platform
* Automated backend and frontend tests
* CI/CD using GitHub Actions

---

# 🎯 Learning Objectives

This project demonstrates practical experience with:

* Building REST APIs using Spring Boot
* Designing relational data models
* Using JPA/Hibernate
* Connecting Java applications to PostgreSQL
* Building React applications with Vite
* Connecting a React frontend to a REST backend
* Managing application state
* Implementing CRUD operations
* Working with entity relationships
* Building data aggregation logic
* Designing reusable frontend components
* Using Git and GitHub for version control

---

# 📌 Project Status

The project is structured as a full-stack application with a React frontend and Spring Boot backend.

The main development focus is recipe management, weekly meal planning, and automatic shopping-list generation.

---

# 👨‍💻 Author

**Nikita Akhade**

GitHub:

`https://github.com/Nikita-Akhade`

---

## ⭐ Key Technical Highlight

One of the most interesting backend problems in this project is the shopping-list aggregation.

Instead of simply displaying ingredients recipe-by-recipe, the backend processes data across several related entities:

```text
MealPlan
   ↓
MealPlanEntry
   ↓
Recipe
   ↓
RecipeIngredient
   ↓
Ingredient
```

It then aggregates quantities for the same ingredient.

This provides a practical example of working with relational data, entity relationships, REST APIs, and backend business logic in a real-world use case.

