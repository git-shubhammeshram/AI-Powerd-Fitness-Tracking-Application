# 🧠 AI-Powered Fitness Tracking Application

A full-stack intelligent fitness tracking system that leverages **AI and microservices architecture** to help users monitor and improve their health and fitness goals. Built using **React** for the frontend, **Spring Boot** for the backend, and integrated with **Gemini AI API** for personalized recommendations and workout insights.

---

## 🚀 Key Features

- 🔐 **OAuth2 Authentication**: Secure user login and registration system with role-based access (user/admin/trainer).
- 📊 **AI Insights**: Integrated with **Gemini API** to generate personalized workout and diet suggestions.
- 🏋️‍♀️ **Workout & Diet Management**: Track daily workouts, meals, and calories with ease.
- 💬 **Real-Time Notifications**: RabbitMQ for async messaging and real-time notifications (e.g., progress alerts).
- 📱 **Responsive Frontend**: Built with **React** for a dynamic and mobile-friendly user experience.
- 🧩 **Microservices Architecture**: Scalable services for user management, fitness tracking, AI analysis, and notifications.
- 🗃️ **Hybrid Data Storage**:
  - **MySQL** for relational data like users, workouts, and nutrition.
  - **MongoDB** for unstructured or semi-structured data like user activity logs and AI responses.
- 📈 **Progress Dashboard**: Visual tracking of fitness journey and performance analytics.
- 🔄 **Asynchronous Communication**: RabbitMQ handles background tasks like AI report generation and email alerts.

---

## 🛠️ Tech Stack

- **Frontend**: React, Axios, Tailwind CSS (or Bootstrap)
- **Backend**: Spring Boot (Java 17), Spring Security, Spring Data JPA
- **Architecture**: Microservices (Eureka, API Gateway)
- **Authentication**: OAuth2, JWT
- **Messaging**: RabbitMQ
- **Database**: MySQL + MongoDB
- **AI Integration**: Gemini API (Google AI)
- **Dev Tools**: Docker, Postman, Swagger, Maven

---

## 📦 Modules

| Module               | Technology               | Description                                        |
|----------------------|--------------------------|----------------------------------------------------|
| Auth Service         | Spring Boot + OAuth2     | Handles login, registration, and token validation  |
| User Service         | Spring Boot + MySQL      | Stores user profiles and preferences               |
| Fitness Tracker      | Spring Boot + MongoDB    | Stores fitness activity logs, workout plans        |
| AI Recommendation    | Gemini API + Spring Boot | Sends data to Gemini for personalized suggestions  |
| Notification Service | RabbitMQ                 | Sends real-time notifications and emails           |
| API Gateway          | Spring Cloud Gateway     | Routes requests to proper services                 |
| Frontend             | React                    | Responsive dashboard with charts and forms         |

---

## 🌐 Live Demo

[Live App Link](#) *(Add your deployed link here if available)*

---

## 📄 License

This project is licensed under the **MIT License** – free to use, modify, and distribute.

---

## 🙌 Contributors

- **Shubham Meshram** – Full Stack Developer

<!-- Add more contributors here if needed -->
