<h1>
<p align="center">
  <br>public-sale
</h1>
  <p align="center">
    Track product auction prices :)
  <br/>
  </p>
</p>
<p align="center">
  <a href="#about-the-project">About The Project</a> •
  <a href="#developing">Developing</a> •
  <a href="#features">Features</a> •
  <a href="#author">Author</a> •
  <a href="#license">License</a>
</p>

![public-sale-diagram](https://github.com/Daiven75/public-sale/assets/44280182/5d2577ff-2865-410b-ab02-45f63502e6d2)                                                                                                
                                                                                                                                                      
## 💻 About the project

Public-sale - Is a product auction system, which consists of a service that returns prices in real time (auction-service), while the other 2 services (auction-consumer and auction-producer) do the job of fetching new offers generated from a third-party service

---

## Developing

### 🔨 Built With
This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [![spring][Spring]][Spring-url]
* [![kafka][Kafka]][Kafka-url]
* [![avro][Avro]][Avro-url]
* [![nestJS][NestJS]][NestJS-url]
* [![postgres][Postgres]][Postgres-url]
* [![docker][Docker]][Docker-url]

### 🚀 How run project

#### You need to have [Docker](https://www.docker.com/) installed.

```bash

# Clone this repository
$ git clone https://github.com/Daiven75/public-sale.git

# Access project folder in terminal/cmd
$ cd public-sale

# Run the command in the terminal to go up all stack
$ docker-compose up -d

# The server will start on port:8080 - access http:localhost:8080

```

---

## ⚙️ Features

#### Product
- [x] Search all products
- [x] Search for a specific product by id

#### Proposal
- [x] Search all products
- [x] Search for a specific product by id

#### OBS: You can check the batch insertion of products for query mock up, through this [file](https://github.com/Daiven75/public-sale/blob/master/auction-service/src/main/resources/data.sql)
---

## 💪 How to contribute to the project

1. Make a **fork** the project.
2. Create a new branch with your changes: `git checkout -b my-feature`
3. Save the changes and create a commit message telling what you did: `git commit -m "feature: My new feature"`
4. Submit your changes: `git push origin my-feature`
> If you have any questions, check this [GitHub Contributing Guide](./CONTRIBUTING.md)

---

## 🦸 Author

 <br />
 <a href="https://github.com/Daiven75">Lucas Silva</a>
 <br />
 <br />
 
[![Gmail Badge](https://img.shields.io/badge/-75.lucas.slima@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:75.lucas.slima@gmail.com)](mailto:75.lucas.slima@gmail.com)

---

## 📝 License

This project is licensed [MIT](./LICENSE).

Made by Lucas Silva 👋🏽 [Contact](https://www.linkedin.com/in/lucas-silva-959102169)

[Spring]: https://img.shields.io/badge/spring-008000?style=for-the-badge&logo=spring&logoColor=white
[Spring-url]: https://spring.io/

[Kafka]: https://img.shields.io/badge/kafka-000000?style=for-the-badge&logo=apache-kafka&logoColor=white
[Kafka-url]: https://kafka.apache.org/

[Postgres]: https://img.shields.io/badge/postgres-483d8b?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]: https://www.postgresql.org/

[NestJS]: https://img.shields.io/badge/nest-b22222?style=for-the-badge&logo=nestjs&logoColor=white
[NestJS-url]: https://nestjs.com/

[Avro]: https://img.shields.io/badge/avro-dodgerblue?style=for-the-badge&logo=avro&logoColor=white
[Avro-url]: https://avro.apache.org/

[Docker]: https://img.shields.io/badge/docker-00bfff?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
