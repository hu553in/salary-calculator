-- Add dummy data to "employees" table

insert into employees
values
    ('{
      "id": "a9978664-4d1d-40dd-81fa-d9026ef9485d",
      "type": "engineer",
      "first_name": "Maksim",
      "last_name": "Maksimov",
      "patronymic": "Maksimovich",
      "work_start_date": "2016-09-20",
      "additional_info": {
      	"base_salary": 35000
      }
    }'),
    ('{
      "id": "54542670-af8e-4423-a834-d4e645cc18b1",
      "type": "worker",
      "first_name": "Ivan",
      "last_name": "Ivanov",
      "patronymic": "Ivanovich",
      "work_start_date": "2015-01-01",
      "additional_info": {
        "rank": 5,
        "monthly_completed_details": 100
      }
    }'),
    ('{
      "id": "9808af20-10c9-48de-83a6-9785fcad0d9d",
      "type": "manager",
      "first_name": "Petr",
      "last_name": "Petrov",
      "patronymic": "Petrovich",
      "work_start_date": "2019-05-13",
      "additional_info": {
        "monthly_completed_transactions": 100,
      	"base_salary": 25000
      }
    }');
