# chat-app

# Real-Time Chat Application - Backend

This is a backend service for a **real-time chat application** built using **Spring Boot**, **Spring WebSocket**, and **MongoDB**. It allows users to join chat rooms, exchange messages in real time, and manage chatroom data effectively.

---

## 🔧 Tech Stack

- **Backend Framework**: Spring Boot
- **Real-Time Messaging**: Spring WebSocket
- **Database**: MongoDB
- **API Testing**: Postman
- **Build Tool**: Maven

---

## 🚀 Features

- Room-based real-time chat via WebSocket
- User registration and chat room creation
- Message broadcasting in chat rooms
- MongoDB-based storage for messages, rooms, and users
- REST APIs for user and room management
- Seamless WebSocket handshake and message flow

---

## 📁 Folder Structure
src/
├── config/              # WebSocket configuration
├── controller/          # REST controllers and WebSocket message handling
├── model/               # Data models (User, Message, Room)
├── repository/          # MongoDB repositories
├── service/             # Business logic
└── ChatAppApplication.java



---

## 📡 REST API Endpoints

### 👤 User APIs

| Method | Endpoint            | Description            |
|--------|---------------------|------------------------|
| POST   | `/api/users`        | Register a new user    |
| GET    | `/api/users`        | Get list of all users  |

### 💬 Chat Room APIs

| Method | Endpoint             | Description               |
|--------|----------------------|---------------------------|
| POST   | `/api/rooms`         | Create a new chat room    |
| GET    | `/api/rooms`         | Fetch all chat rooms      |

### 🔄 WebSocket

| Endpoint | `/chat` (WebSocket) |
|---------|----------------------|
| Use STOMP client or frontend to send/receive messages. Example room topic: `/topic/room/{roomId}` |

---

## 🔌 WebSocket Flow

1. User connects to `ws://localhost:8080/chat` using STOMP/WebSocket client.
2. Subscribes to a topic like `/topic/room/{roomId}`.
3. Sends messages to `/app/message`.
4. Backend broadcasts messages to all subscribers in the room.

---

## 🛠️ Setup & Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/codebyysh/chat-app.git
   cd chat-app-backend



---