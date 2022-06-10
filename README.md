#Project Walkthrough
<hr>
<h5>Multi Module Maven Project has 3 module which is:<br></h5>

* ## API Module 
<h5>Listening for port 8080<br>
Contains Entities, Controllers for EndPoints, Database Access and Message Producer</h5>
###Tech Stack<hr>
* Spring Data JPA
* Spring Web
* Spring AMQP
* Project Lombok
<hr>

* ## WebApp Module
<h5>Listening for port 7070<br>
Contains WebClient for access to API module</h5>
###Tech Stack<hr>
* Spring WebFlux
<hr>



* ## Messaging Module
<h5>Listening for port 6060<br>
Contains Message Consumer, when API module create new Advertisement and send message to Messaging module,
Consumer receive message from queue and make required database operations.</h5>
###Tech Stack<hr>
* Spring Data JPA
* Spring AMQP