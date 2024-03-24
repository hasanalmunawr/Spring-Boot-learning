# Address API Spec

## Create Address
EndPoint : POST /api/contacs/{idContact}/address

Request Header :
- X-API-TOKEN (mandatory)

Request Body :
```json
{
  "street": "Jalan dua",
  "city": "Sarolangun",
  "province": "Jambi",
  "country": "Indonesia",
  "postalCode": 12314
}
```

Response Body (Succes) :
```json
{
  "data": {
    "id": "random UUID string",
    "street": "Jalan dua",
    "city": "Sarolangun",
    "province": "Jambi",
    "country": "Indonesia",
    "postalCode": 12314
  }
}
```

Response Body (Fail) :
```json
{
  "errors": "contact is not found"
}
```

## Update Address
EndPoint : PUT /api/contacts/{idContact}/address/{idAddress}

Request Header :
- X-API-TOKEN (mandatory)

Request Body :
```json
{
  "street": "Jalan dua",
  "city": "Sarolangun",
  "province": "Jambi",
  "country": "Indonesia",
  "postalCode": 12314
}
```

Response Body (Succes) :
```json
{
  "data": {
    "id" : "random UUID string",
    "street": "Jalan dua",
    "city": "Sarolangun",
    "province": "Jambi",
    "country": "Indonesia",
    "postalCode": 12314
  }
}
```

Response Body (Fail) :
```json
{
  "errors" : "Address is not found"
}
```

## Get Address
EndPoint : GET /api/contacts/{idContact}/address/{idAddres}

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Succes) :
```json
{
  "data" : {
    "id": "random UUID string",
    "street": "Jalan dua",
    "city": "Sarolangun",
    "province": "Jambi",
    "country": "Indonesia",
    "postalCode": 12314
  }
}
```

Response Body (Fail) :
```json
{
  "errors": "addres is not found"
}
```

## List Address
EndPoint : GET /api/contacts/{idContact}/addresses

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Succes) :
```json
{
  "data": {
    "id": "random string",
    "street": "Jalan dua",
    "city": "Sarolangun",
    "province": "Jambi",
    "country": "Indonesia",
    "postalCode": 12314
  }
}
```

Response Body (Fail) :
```json
{
  "errors": "contact is not found"
}
```

## Remove Address
EndPoint : DELETE api/contacts/{idContact}/address/{idAddres}

Request Header :
- X-API-TOKEN : Token (mandatory)

Response Body (Succes) :
```json
{
  "data": "OK"
}
```

Response Body (Fail) :
```json
{
  "errors": "addres is not found"
}
```






