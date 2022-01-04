### **possible land route calculator**

#### **How to Run**

##### **Run Application with Maven**
`mvn test`

`mvn spring-boot:run`

##### **Location**
`localhost:8080`

##### **Usage**
You can query whether there is a route between two countries. 
For this purpose you need to send `GETgit` request to `localhost:8080/routing/{origin}/{destination}`

You can find the graphs under test in `test/resources/static` folder.