# 2FA Authentication Android App

This Android app implements a simple login, sign-up, and email verification flow using Gmail's SMTP service.

## Features

- **Login**: Users can log in with predefined credentials.
- **Sign-Up**: Users can register with name, email, username, and password.
- **Email Verification**: Sends a verification email using Gmail SMTP.

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/2fa_android_app.git
    ```

2. Open in **Android Studio**.

3. Replace Gmail credentials in `MailUtil.java`:
    ```java
    return new PasswordAuthentication("gmail@gmail.com", "app_password");
    ```

4. Build and run the app on your device or emulator.

