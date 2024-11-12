# clim-api-service

```mermaid
erDiagram
    user {
        Long id PK
        String username
        String email UK
        String password
        int grade
        int class
        int class_number
        Boolean is_admin
    }

    notification {
        Long id PK
        String writer FK
        String title
        String content(255)
        Date notice_date
    }

    room {
        Long id PK
        Long user_id FK
        int room_number
        Boolean is_passed
        Date today_date
    }

    room_user_history {
        Long id PK
        Long room_user_id FK
        String description
    }

    refresh_token {
        Long id PK
        String email UK
        String token
        Date expiry_date
    }

    email_verification {
        Long id PK
        String auth_code
        String email
        Boolean is_verified
        DateTime created_at
    }

    setting {
        Long id PK
        Long user_id FK
        Boolean is_push_notification
    }

    user ||--|| setting: ""
    user }|--|| room: ""
    user ||--|| notification: ""
    user ||--|{ room_user_history: ""
    room ||--|{ room_user_history: ""
```