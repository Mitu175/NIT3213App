# NIT3213App


This is an Android application developed for the NIT3213 assessment.  
It demonstrates:
- Login functionality using student first name and student ID as credentials
- API integration with the Foostcray endpoint
- Dashboard screen with RecyclerView to display entities
- Navigation to entity details screen
- Clean architecture with ViewModel, Repository, and Retrofit
- Proper UI/UX design with RecyclerView
- Dependency injection using Hilt
- Error handling and user-friendly messages

  The app interacts with the `vu-nit3213-api` for login and fetching entity data.

---

## Features
1. **Login Screen**
    - Enter username (student first name) and password (student ID)
    - Validates input
    - Shows messages for:
        - Empty input: `Please enter username and password`
        - Incorrect credentials: `Incorrect username or password`
        - Successful login: `Login successful!`
    - Navigates to Dashboard on success

2. **Dashboard Screen**
    - Displays list of entities from API in a RecyclerView
    - Each item shows artwork title, artist, medium, and year
    - Clicking an item shows detailed information in the Details screen

3. **Details Screen**
    - Displays all information about the selected entity, including description

---

### Technical Details

- **Languages & Frameworks:** Kotlin, Android SDK
- **Architecture:** MVVM (ViewModel + Repository)
- **Networking:** Retrofit
- **Dependency Injection:** [Hilt/Koin if implemented]
- **Unit Tests:** For critical components
- **Version Control:** Git

---

### API Details

- **Base URL:** `https://nit3213api.onrender.com/`
- **Login Endpoint:** `/footscray/auth`
- **Dashboard Endpoint:** `/dashboard/{keypass}`



### Getting Started

1. Clone the repository:
git clone https://github.com/YourUsername/NIT3213App.git

 2.Open in Android Studio.
 
 3.Build and run the app on an emulator or device.
 
 4.Enter your student credentials to log in.


 Setup Instructions
1. Clone the repository
git clone https://github.com/YourUsername/NIT3213App.git
cd NIT3213App

2. Open in Android Studio

Use Android Studio Ladybug or newer.

Select "Open an Existing Project" and point to this folder.

3. Dependencies

Make sure you have these installed (already included in build.gradle.kts):

Hilt – Dependency Injection

Retrofit + Moshi/Gson – Networking

Navigation Component – Fragment navigation

JUnit & Mockito – Testing

4. Build & Run

Sync Gradle (File → Sync Project with Gradle Files)

Build the project (Build → Make Project)

Run on an emulator or device (minSdk = 24, targetSdk = 36).

5. Login Credentials

Username: Your student first name

Password: Your student ID




Author

Your Name: Mitu Das

Course: NIT3213 Android Application Development

Date: 16/9/25



