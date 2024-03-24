# Contact API Spec

## Create contact

EndPoint : POST /api/contacts
 
Request Header :

- X-API-TOKEN : Token (Mandatoy)

Request Body :

```json
{
  "fistName": "Hasan",
  "lastName": "Almunawar",
  "email": "hasan@example.com",
  "phone": "0812345678"
}
```

Respone Body (Succes) :
```json
{
  "data": {
    "id": "random UUID String",
    "fistName": "Hasan",
    "lastName": "Almunawar",
    "email": "hasan@example.com",
    "phone": "0812345678"
  }
}
```

Respone Body (Fail) :

```json
{
  "erros": "Email format invalid, phone number invalid"
}
```

## Update contact

EndPoint : PUT /api/contatcs/{idContact}

Request Header :

- X-API-TOKEN : Token (Mandatory)

Request Body :
```json
{
  "fistName": "Hasan",
  "lastName": "Almunawar",
  "email": "hasan@example.com",
  "phone": "0812345678"
}
```

Response Body (Succes) :
```json
{
  "data": {
    "id": "random UUID string",
    "fistName": "Hasan",
    "lastName": "Almunawar",
    "email": "hasan@example.com",
    "phone": "0812345678"
  }
}
```

Response Body (Fail, 404) :
```json
{
  "errors": "Contact is not found"
}
```

## Search contact

EndPoint : GET /api/contacts

Query Param :
- name : String, contact first name or last name, using like query, optionl
- email : String, contact email, using like query, optional
- phone : String, contact phone, using like query, optional
- page : Integer, start from 0, default 0
- size : Integer, default 0

Request Header :

- X-API-TOKEN : Token (mandatory)

Respone Body (Succes) :
```json
{
  "data": [
    {
      "fistName": "Hasan",
      "lastName": "Almunawar",
      "email": "hasan@example.com",
      "phone": "0812345678",
    }
  ],
  "pagging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  }
}
```

Response Body (Fail) :
```json
{
  "errors": "Unauthorized"
}
```

## Remove Contact
EndPoint : DELETE /api/contacts/{idContact}

- X-TOKEN-API (mandatory) 

Response Body (Succes) :
```json
{
  "data": "OK"
}
``` 

Response Body (Fail) :
```json
{
  "errors" : "contact id is not found"
}
```