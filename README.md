# dukcapil

API contract 

* Validation Object
```
{
    id: Integer
    nik: String
    provinsi: String
    kota: String
}
```

Get Validation Nik

POST /dukcapil/validate
----
Return validation nik from system.
* Url Params
  None
* Headers
  Content-Type: application/json
* Data Params
  ```
  {
    "nik":"3323956623850003"
  }
  ```
* Succes Response:
* Code: 200
  Content:
  ```
  {
    "message": "NIK Terdaftar"
  }
  ```
* Error Response:
* Code: 404
  Content:
  ```
  {
    "id": "78a73108-c1a9-471f-b384-6567495222a8",
    "message": "NIK Tidak Ditemukan"
  }
  ```
