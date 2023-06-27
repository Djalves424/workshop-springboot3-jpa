# Projeto web services com Spring Boot e JPA / Hibernate

Efetuado acompanhamento das aulas desse projeto com Dr. Nelio Alves.

Objetivos:

•	Criar projeto Spring Boot Java

•	Implementar modelo de domínio

•	Estruturar camadas lógicas: resource, service, repository

•	Configurar banco de dados de teste (H2)

•	Povoar o banco de dados

•	CRUD - Create, Retrieve, Update, Delete

•	Tratamento de exceções


![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/5c1ac08c-b8ae-4c69-938c-eb06c5fc706f)

################################################################################################

(Modelo de domínio) ➝ Domain Model

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/c2bf4dec-07e9-4025-8afb-9b82b5d01e36)

(instância de domínio) ➝ Domain Instance

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/edf1a51b-e677-47ec-8460-1e13e8900854)

################################################################################################

(Camadas Lógicas) ➝ Logical Layers

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/eb7a6e9d-128d-4846-b25f-d8035a32edf0)

################################################################################################

(Projeto criado) ➝ Project created

Checklist:

•	Spring Initializr

o	Maven

o	Java 17

o	Packing JAR

o	Dependencies: Spring Web

################################################################################################

(Entidade de usuário e recurso) ➝ User entity and resource

Basic entity checklist:

•	Basic attributes
•	Associations (instantiate collections)

•	Constructors

•	Getters & Setters (collections: only get)

•	hashCode & equals

•	Serializable

################################################################################################

H2 database, test profile, JPA

Checklist:

•	JPA & H2 dependencies

•	application.properties

•	application-test.properties

•	Entity: JPA mapping

################################################################################################

Incluir as Dependencias ➝ JPA e H2database conforme a imagem a seguir:

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/6b414e1c-89bc-42fc-b99b-9044643852a7)

################################################################################################

Criar um arquivo no projeto chamado application.properties e salvar essas configurações

# application.properties:

spring.profiles.active=test 

spring.jpa.open-in-view=true

################################################################################################

Criar um arquivo no projeto chamado application-test.properties e salvar essas configurações
 
# application-test.properties:

DATASOURCE

spring.datasource.driverClassName=org.h2.Driver 

spring.datasource.url=jdbc:h2:mem:testdb 

spring.datasource.username=sa 

spring.datasource.password=

# H2 CLIENT:

spring.h2.console.enabled=true 

spring.h2.console.path=/h2-console

# JPA, SQL:

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect 

spring.jpa.defer-datasource-initialization=true 

spring.jpa.show-sql=true 

spring.jpa.properties.hibernate.format_sql=true

################################################################################################

JPA repository, dependency injection, database seeding

Checklist:

•	UserRepository extends JPARepository<User, Long>

•	Configuration class for "test" profile

•	@Autowired UserRepository

•	Instantiate objects in memory

•	Persist objects

################################################################################################

(Objetos) ➝ Objects:

User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 

User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

################################################################################################

Service layer, component registration 

Order, Instant, ISO 8601

(Nova entidade básica) ➝ Basic new entity 

checklist:

•	Entity

o	"To many" association, lazy loading, JsonIgnore

•	Repository

•	Seed

•	Service

•	Resource

################################################################################################

(Objetos) ➝ Objects:
Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 

Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2); 

Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

OrderStatus enum

Category

(Objetos) ➝ Objects:
Category cat1 = new Category(null, "Electronics"); 

Category cat2 = new Category(null, "Books"); 

Category cat3 = new Category(null, "Computers");

Product

(Objetos) ➝ Objects:

Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 

Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");

Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 

Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");

Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

################################################################################################

Many-to-many association with JoinTable

OrderItem, many-to-many association with extra attributes

Checklist:

•	OrderItemPK

•	OrderItem

•	Order one-to-many association

•	Seed

(Objetos) ➝ Objects:

OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 

OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 

OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 

OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());



Product-OrderItem one-to-many association

Payment, one-to-one association

Subtotal & Total methods

################################################################################################

(Inserção do usuário) ➝ User insert

Checklist:

•	UserService

•	UserResource

Test:

{

"name": "Bob Brown", 

"email": "bob@gmail.com", 

"phone": "977557755",


"password": "123456"

}

(usuário deletar) ➝ User delete

Checklist:

•	UserService

•	UserResource

(atualização do usuário) ➝ User update

Checklist:

•	UserService

•	UserResource

Test:

{

"name": "Bob Brown", 

"email": "bob@gmail.com", 

"phone": "977557755"

}

################################################################################################

(Manipulação de exceção) ➝ Exception handling - findById

Checklist:

•	NEW CLASS: services.exceptions.ResourceNotFoundException

•	NEW CLASS: resources.exceptions.StandardError

•	NEW CLASS: resources.exceptions.ResourceExceptionHandler

•	UserService

(Manipulação de exceção) ➝ Exception handling - delete

Checklist:

•	NEW CLASS: services.exceptions.DatabaseException

•	ResourceExceptionHandler

•	UserService

•	EmptyResultDataAccessException

•	DataIntegrityViolationException

(Manipulação de exceção) ➝ Exception handling - update

Checklist:

•	UserService

•	EntityNotFoundException

################################################################################################

(Instalação local) ➝ Install local PostgreSQL

Checklist:

•	Download and install: https://www.postgresql.org/download/

•	Super user: postgres

•	Password: 1234567

•	Port: 5432

•	Start/stop service: Task manager -> Services

•	Check instalation

•	Start pgAdmin

•	Databases -> Create -> Database

•	Encoding: UTF8

################################################################################################

Dev profile

Checklist:

•	PgAdmin: create local database: create database springboot_course

•	Add PostgreSQL Maven dependency

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/7423512f-8b71-4b5f-a6a4-055452af8a6a)

•	(Criar arquivo no projeto e adicionar esses arquivos conforme imagem a baixo) ➝ Create file: application-dev.properties

![image](https://github.com/Djalves424/workshop-springboot3-jpa/assets/108296040/0e28a9c0-12bc-47f1-afcf-dcac576a1302)


spring.datasource.url=jdbc:postgresql://localhost:5432/springboot_course 

spring.datasource.username=postgres

spring.datasource.password=1234567

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true 

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true 

spring.jpa.properties.hibernate.format_sql=true

jwt.secret=MYJWTSECRET 

jwt.expiration=3600000





















