FROM mysql:5.7

MAINTAINER HEMPTE Maxime maximehempte@gmail.com

ENV MYSQL_DATABASE petclinic

ADD ./sql-scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306

CMD ["mysqld"]