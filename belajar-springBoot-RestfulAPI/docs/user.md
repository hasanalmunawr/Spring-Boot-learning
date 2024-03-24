# User API spec

## Create User

EndPoint : POST /api/users

Request Body :
```json
{
  "username": "hasanalmu",
  "password": "rahasia",
  "name": "Hasan Almunawar"
}
```        
Response Body (Succes) :
```json
{
  "data": "OKE"
}
```

Response Body (Fail) :
```json
{
  "errors": "Username must not blank, ???"
}
```        

## Login User

EndPoint : POST /api/auth/login

Request Body :
```json
{
  "username": "hasanalmu",
  "password": "rahasia"
}
```

Response Body (Succes) :
```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 90134130510 //milliseconds
  }
}
```

Response Body (Fail) :
```json
{
  "errors": "username or password wrong"
}
```

## Get User

EndPoint : GET /api/users/current

Request Header :
- X-TOKEN-API : Token (mandatory)

Response Body (Succes) :
```json
{
  "data": {
    "username": "hasanalmu",
    "name": "Hasan Almunawar"
  }
}
```

Response Body (Fail, 401) :
```json
{
  "errors": "Unauthorized"
}
```

## Update User
EndPoint : PATCH /api/users/current

Request Header :
- X-TOKEN-API (mandatory)

Request Body :
```json
{
  "name": "new name" // pun if you only want to update the name
  "password": "new password" // pun if you only want to update the password
}
```

Response Body (Succes) :
```json
{
  "data": {
    "username": "hasanalmu",
    "name": "new name" // new name after previus update
  }
}
```

Response Body (Fail, 401) :
```json
{
  "errors": "Unauthorized"
}
```

## LogOut User
EndPoint : DELETE /api/auth/logout

Request Header :
- X-API-TOKEN (mandatory) 

Response Body (Succes) :
```json
{
  "data": "OK"
}
```

