
# 📱 Skillify Android App

Skillify is a real-time tutoring and learning platform connecting students with qualified teachers for personalized sessions. This repository hosts the Android app built using Kotlin and Android Studio.

## 🚀 Features

- 🔐 JWT-based login & registration (Student/Teacher roles)
- 👤 Profile management with editable fields and image upload
- 📆 Availability slot creation for teachers
- 📚 Session booking by students with real-time slot filtering
- ✅ Booking confirmation flow (teacher-side)
- 🧑‍🏫 Dashboards for both students and teachers
- 📝 Review system (planned)
- 🔔 Notification system (upcoming)

## 🛠️ Tech Stack

- **Language:** Kotlin
- **IDE:** Android Studio (Giraffe/Hedgehog+)
- **Architecture:** MVVM (Model-View-ViewModel)
- **Network:** Retrofit + OkHttp
- **Authentication:** JWT token (Bearer in headers)
- **Image Uploads:** Multipart form data
- **Session Management:** LiveData + ViewModel
- **UI Components:** Jetpack Compose / XML (specify based on your UI)

## 📦 Folder Structure (Planned)

```
Skillify/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/skillify/
│   │   │   │   ├── auth/               # Login & registration
│   │   │   │   ├── dashboard/          # Student & Teacher dashboards
│   │   │   │   ├── profile/            # Profile screens
│   │   │   │   ├── booking/            # Session booking logic
│   │   │   │   ├── availability/       # Teacher slot creation
│   │   │   │   └── network/            # Retrofit API setup
│   │   │   └── res/                    # Layouts, drawables, strings, etc.
│
└── README.md
```

## 🔧 Setup Instructions

1. **Clone the repo**:
   ```bash
   git clone https://github.com/yourusername/skillify-android.git
   cd skillify-android
   ```

2. **Open in Android Studio**:
   - Open Android Studio → File → Open → Select this directory.

3. **Configure Backend URL**:
   - Set your Django/Flask backend base URL in `Constants.kt` or `network/ApiClient.kt`.

4. **Build and Run**:
   - Connect emulator or real device and click ▶️.

## 📌 Backend Requirements

- A working backend with:
  - `/auth/` for JWT login/register
  - `/profile/` for profile CRUD
  - `/availability/` for slot creation
  - `/booking/` for session handling
- CORS & token header support.

## 📲 Future Enhancements

- In-app messaging system
- Push notifications
- Advanced session filters
- Class notes/document sharing
- Video call integration (e.g., Jitsi)

## 🤝 Contributing

Contributions are welcome! Open issues, suggest features, or submit PRs.
