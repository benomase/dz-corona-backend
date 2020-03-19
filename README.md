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
        "phoneNumber": "123456789",
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
	
	    "firstName" :"fake",
        "lastName " :"fake",
        "age" :"33",
        "numberPhone" :"1234",
        "latitude" :"123",
        "longitude":"123",
        "email":"fake@gmail.com",
        "password":"1234567890",
        "profilePicture":"path",
        "common":"1",
        "wilaya":"24"
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

* **Add Infection**
```js
* Route  : infection
* Method : POST
* URL    : www.server.com/api/infection


* Request Body
{

	  "creationDate" : 1234555,
      "sexe"         :  "M",
      "types"        :  "1",
      "verified"     :  "false",
      "creatorID"    :   "12343214jdjsl",
      "geoLocation"  :   
      {
       	"wilayaID":"1",
        "communeID":"1",
        "latitude"     :"123",
        "longitude"     :"123"
       }

	
}


* Response Body
{
    "status": 200,
    "response": {
        "id": "5e72784cd522512dfa90385f",
        "creationDate": 1234555,
        "geoLocation": {
            "wilayaID": 1,
            "communeID": 1,
            "latitude": 123.0,
            "longitude": 123.0
        },
        "sexe": "M",
        "types": "1",
        "verified": false,
        "creatorID": "12343214jdjsl"
    }
}
```


* **List Infection**
```js
* Route  : infection
* Method : GET
* URL    : www.server.com/api/infection
* Token  : "string token"

* Response Body
{
    "status": 200,
    "response": [
        {
            "id": "5e72784cd522512dfa90385f",
            "creationDate": 1234555,
            "geoLocation": {
                "wilayaID": 1,
                "communeID": 1,
                "latitude": 123.0,
                "longitude": 123.0
            },
            "sexe": "M",
            "types": "1",
            "verified": false,
            "creatorID": "12343214jdjsl"
        },
        {
            "id": "5e734ad3d522512dfa903860",
            "creationDate": 1234555,
            "geoLocation": {
                "wilayaID": 1,
                "communeID": 1,
                "latitude": 123.0,
                "longitude": 123.0
            },
            "sexe": "M",
            "types": "1",
            "verified": false,
            "creatorID": "12343214jdjsl"
        }
    ]
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

