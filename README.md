# online-vote
## How to run the code

# Tech stack
-<b>Node.js</b> <i>20.1.0</i>

-<b>Java</b> <i>20.0.2</i>

-<b>MySql</b> <i>8.0</i>

# Assumptions
- There cannot only be only poll active at the time
- Polls have an end time

# API Endpoint
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
# Design decisions
<b>Database</b>: For this coding exercise I utilised a local MySQL database. This was done to simplify the database development as this is something I've used extensively in the past. Another option considered but not pursued for the sake of time was utilising a service such as AWS RDS. This would have been a good idea if the application were to be deployed in a AWS environment.
