driver=org.neo4j.ogm.drivers.http.driver.HttpDriver
URI=http://username:password@localhost:7474
## spring.mustache.prefix=classpath:/templates/

# Multipart Configuration
# multipart.location = ${user.home}/.
multipart.maxFileSize = 20Mb
multipart.maxRequestSize = 20Mb
multipart.fileSizeThreshold = 50Mb
spring.http.multipart.max-file-size=100Mb
spring.http.multipart.max-request-size=100Mb


 security.basic.enabled=false
 management.security.enabled=false
 #security.ignored=/**
 
 
 #mail properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=elethintybit
spring.mail.password=fdsgHJOr9BIUGBbh

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required: true