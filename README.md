Для того чтобы запустить данный проект вам необходимо поднять собственный контейнер с базой данных в Docker (я это делал через команду
~~~
  docker run --name productDB 
  -e POSTGRES_DB=productDB 
  -e POSTGRES_USER=admin 
  -e POSTGRES_PASSWORD=adminpass 
  -p PUBLIC_IP:5432:5432 
  -d postgres
~~~
где PUBLIC_IP - это IP адрес виртуальном машины, которую я использовал в качестве провайдера базы данных...  

Также вам необходимо будет отредактировать настройки приложений таким образом, чтобы вместо моих данных, указать свои, а именно:  
В [файле](https://github.com/UrijVig/OnlineStore/blob/master/REST_CRUD_API_ForCandlesDB/src/main/resources/application.yaml) указать собственный url для подключения к базе данных.  
В [Файле](https://github.com/UrijVig/OnlineStore/blob/master/webInterfaceForREST_API/src/main/resources/application.yaml) также указать собственные параметры подключения,
так же в поле Server я менял адрес запуска приложения на адрес своего ПК, так как использовал проброс портов на роутере для подключения к сайту из все домашней сети
