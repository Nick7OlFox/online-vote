# Bruno Faria Almeida - coding exercise
## How to run the code
Ensure you have the correct software installed
### Setup the database
Import the Data in the file <i>/data/<b>dbConfig.sql</b></i> into mySql workspace. (The code was configured to expect the db to be hosted on localhost:3306. Make sure this is the case or if you have a different port update the file <i>/backend/polling-backend/src/main/resources/<b>application.yml</b></i>)

### Running the code
When the database is successfully configured, you can now simply run the code. There are two projects you need to run.
#### Backend
To run the backend you must run the file <i>/backend/polling-backend/src/main/java/com/exercise/polling_backend/<b>PollingBackendApplication.java</b></i>. This will start a spring boot project. If for any reason this is not working, make sure you reload your Maven dependencies and try again.
#### Frontend
To run the frontend open a terminal and navigate to <i>/frontend/pollingApp</i>. When here run the command <b>ng serve</b>. This should start the angular project. If this is not working, try running <b>npm install -g @angular/cli</b> and then run the command <b>ng serve</b> again.

# Tech stack
-<b>Node.js</b> <i>20.1.0</i>

-<b>Java</b> <i>20.0.2</i>

-<b>MySql</b> <i>8.0</i>

## Assumptions
- There cannot only be only poll active at the time
- Polls can have an end time

## API Endpoint
-<b>POST</b> <i>{host address}</i>/v1/question/

Request Body
```json
Example
{
    "question": "Which team will win Euro 2024?",
    "endDate" : "2024-08-25T21:45:00.000+00:00",
    "listOfOptionsInput" : [
        "England",
        "France",
        "Germany",
        "Portugal",
        "Spain",
        "Italy",
        "Other"
    ]
}
```

-<b>GET</b> <i>{host address}</i>/v1/question/active

-<b>POST</b> <i>{host address}</i>/v1/vote?answerId={id}

-<b>GET</b> <i>{host address}</i>/v1/question/votes?pollId={pollId}
## Design decisions
<b>Database</b>: For this coding exercise I utilised a local MySQL database. This was done to simplify the database development as this is something I've used extensively in the past. Another option considered but not pursued for the sake of time was utilising a service such as AWS RDS. This would have been a good idea if the application were to be deployed in a AWS environment.

## Testing
#### Frontend
In the repository we can find the file <i>/testing/frontend/<b>coding exercise.side</b></i>. This file contains one test case for the frontend where the user votes for the first option in a valid poll. This is an example of using the Selenium IDE browser extension to record a test case for testing the frontend of the application.
#### Backend
To test the several endpoints, Postman was used where all request could be sent and tested to ensure correct behaviour. In the repository we can find the file <i>/testing/backend/<b>postman-endpoints.json</b></i> where the endpoint collection from postman was saved.