We need a RabbitMQ broker available for us to connect to. 
The simplest way to do this is by using Docker to fetch and run a RabbitMQ image for us:

docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management


We expose port 5672 so that our application can connect to RabbitMQ.
And, we expose port 15672 so that we can see what our RabbitMQ broker is doing via either 
the management UI: http://localhost:15672 or the HTTP API: http://localhost:15672/api/index.html.




