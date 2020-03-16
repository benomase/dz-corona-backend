corona-dz

# TODO 
#### App Routes 

* **User login**
```js
* Route  : Login
* Method : POST
* URL    : www.server.com/api/auth/login

* Request Body
{
    "phoneNumber" : "123456789",
    "password" :    "qwerty"
}

* Response Body
{
    "jwt":"jwt string",
    "status": 200,
    "user": {
        "phoneNumber": "qwerty",
        "id": "MZzDscI8wrgFZss7RUWi"
    }
}
```

* **User Register**

```js
* Route  : Register
* Method : POST
* URL    : www.server.com/api/user/register

* Request Body
{
	"username" : "fake",
	"phoneNumber" : "1234567890",
	"password" : "fake",
	"email"    : "fake@fakel.com",
	"userType" : "USER | ADMIN",
	"longtitude": "0",
	"latitude" : "0"
}

* Response Body
{
    "status": 201,
    "message": "Account is Created",
    "response": {
        "userId": "XNUO4B148octbd3FgyF6",
        "username": "fake",
        "email": "fake@fakel.com",
        "password": null,
        "phoneNumber": 0,
        "profileImage": null,
        "longtitude": 0,
        "latitude": 0
    }
}
```



* ** User Profile**
```js
* Route  : profile
* Method : POST
* URL    : www.server.com/api/user/profile/{user_id}

* Response Body
{
    "status": 200,
    "message": "User Profile",
    "response": {
        "userId": "XNUO4B148octbd3FgyF6",
        "username": "fake",
        "email": "fake@fakel.com",
        "password": null,
        "phoneNumber": 1234567890,
        "profileImage": "",
        "longtitude": 0,
        "latitude": 0
    }
}
```

**Error Response Body**
```js
{
    "timestamp" : "error time",
    "status"    : "code status (404)",
    "error"     : "Error message brief",
    "message"   : "Error message body"
}
```

