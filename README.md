# Internship Application Project

## Prepared by: Atika Zeynep Evmez

This program is prepared for internship application to *** company according to the given description.

The program is a web application that can display abnormal earthquakes on a world map within a simple panel. In this program, data is obtained in two different ways: 1) Real-time earthquake data is retrieved using the USGS (United States Geological Survey) API. 2) Random earthquake data is generated. These two different types of data are presented on separate pages.

## Prerequisites

You need to meet the following prerequisites to run the program:
- You need to have Docker installed. [Install Docker](https://docs.docker.com/get-docker/)
- You need to have Docker Compose installed. [Install Docker Compose](https://docs.docker.com/compose/install/)

## Getting Started

1. **Clone the repository:**

    ```bash
    git clone git@github.com:atikazeynep/internship_case.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd internship_case
    ```

3. **Start the project using Docker Compose:**

    ```bash
    docker-compose up --build
    ```

    This command will build Docker images for the backend and frontend, create a container for each service, and start them.

4. **Once the containers are started, you can access the application:**

    - **Backend:** Open your web browser and go to `http://localhost:8080`.
    - **Frontend:** Open your web browser and go to either `http://localhost:3000` or `http://localhost:4000`, you can see data from USGS API at `http://localhost:3000` and random data at `http://localhost:4000`

5. **To stop the containers, you can press `Ctrl + C` in the terminal while Docker Compose is running, or you can use the following command:**

    ```bash
    docker-compose down
    ```

## Additional Notes

- If you make changes to the code, you can rebuild and restart the containers using the same `docker-compose up --build` command.
- You can run Docker Compose in the background by adding the `-d` flag: `docker-compose up -d`.
