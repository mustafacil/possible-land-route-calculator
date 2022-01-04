### **possible land route calculator**

##### **Usage**
`possible-land-route-calculator` service calculates the possible route between two countries based on the country list in the link below.
Link: `https://raw.githubusercontent.com/mledoze/countries/master/countries.json`

To query whether there is a route between two countries you need to send `GET` request to `localhost:8080/routing/{origin}/{destination}`

You can find the graphs under test in `test/resources/static` folder.

#### **How to Run**

##### **Run Application with Maven**
`mvn test`

`mvn spring-boot:run`

##### **Location**
`localhost:8080`

