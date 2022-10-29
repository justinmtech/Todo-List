# Todo-List
A simple todo-list made with Spring.

# Setup
1. Download most recent JAR file release
2. Place file in a folder of its own preferably
3. Create an application.properties file with the proper settings
4.  Run JAR file with terminal using "java -jar <jarFileName>.jar"

# Configuration
- server.port=8081
- server.address=localhost
- spring.datasource.url = jdbc:mysql://localhost:3306/server
- spring.datasource.username = root
- spring.datasource.password = password
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
- spring.jpa.hibernate.ddl-auto = update
- spring.jpa.properties.hibernate.globally_quoted_identifiers=false
