cinema_e_booking

To run, settings will need to be changed in the file:
    cinema_e_booking/src/main/resources/application.properties
  
You'll want to update these lines with your MySQL login information:
    spring.datasource.username=root
    spring.datasource.password=redred123


Additionally in the application.properties files you can change server.port=8080 to make it run on whatever port you want (if you already have something running on 8080 that you don't want to kill).

    
For the blocked pages that take you the custom login page, the username is "user@gmail.com" and the password is "password".
These settings can be changed in SecurityConfig.java located in 
cinema_e_booking/src/main/java/cinema/booking/config but I wouldn't
recommend touching any of that for the time being.


To run, you can download Spring Tools Suite from https://spring.io/tools
It's a flavor of Eclipse built for the spring framework but i'm pretty normal eclipse will work as well.
