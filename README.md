# school

A simple school management system using spring framework. 

Controllers: expose the API endpoints for CRUD operations 
- Student endpoint: /student

GET request structure:

    {
        "id": 1,
        "name": "Nayoung Kim",
        "grade": 10
    },
    {
        "id": 2,
        "name": "Taliyah Cat",
        "grade": 9
    }

POST request body structure:

    {
        "name": "Taliyah Cat",
        "grade": 9
    }
