# codigopostal-api
API to access and validade all postal codes and related information from Portugal

This objective of this project was to create an API that anyone could use to validate and/or get information about the postal codes and related information in mainland Portugal, Madeira and the Azores.

The best way to understand howto use this API is to download Postman and import the API specs from here https://github.com/jdmedeiros/codigopostal-api-specs or you can take a look at the Apimatic generated code which is here https://github.com/jdmedeiros/codigopostal-api-consume 

This project is designed to be hosted in a Tomcat server and a MySQL server. The recomended way is with Docker, using "docker-compose up --no-start" will create a multi-container with Tomcat and MySQL, deploy the war file and import the database.

In sum, there are four endpoint: [ distritos | concelhos | moradas | codigos ]

http://127.0.0.1:8080/postal/distritos
[
    {
        "designacaoDistrito": "Aveiro"
    },
    ...
    ...
    {
        "designacaoDistrito": "Ilha do Corvo"
    }
]


http://127.0.0.1:8080/postal/distritos?designacaoDistrito=Lisboa
[
    {
        "designacaoDistrito": "Lisboa"
    }
]

http://127.0.0.1:8080/postal/distritos?designacaoDistrito=L% [Anything that starts with L]
[
    {
        "designacaoDistrito": "Leiria"
    },
    {
        "designacaoDistrito": "Lisboa"
    }
]

http://127.0.0.1:8080/postal/distritos?designacaoDistrito=__a_a% [Anything that has an "a" in the 3rd and 5th positions]
[
    {
        "designacaoDistrito": "Braga"
    },
    {
        "designacaoDistrito": "Bragança"
    },
    {
        "designacaoDistrito": "Viana do Castelo"
    }
]

http://127.0.0.1:8080/postal/moradas?blabla
{
    "message": "Erro. Parâmetros válidos: [ codPostal4 [ codPostal3 ] ]"
}

http://127.0.0.1:8080/postal/codigos?blabla
{
    "message": "Erro. Parâmetros inválidos são: [ designacaoDistrito | designacaoConcelho | designacaoConcelho | codPostal4 | codPostal3 | localidade | arruamento ]"
}

 
