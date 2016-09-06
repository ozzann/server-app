FROM java
COPY . /usr/src/server-app
WORKDIR /usr/src/server-app
RUN javac src/MyServer.java
CMD [ "java", "MyServer" ]
