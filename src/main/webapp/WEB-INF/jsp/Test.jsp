<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Меню</title>
    <style>
      #navbar {
        margin: 0;
        padding: 0;
        list-style-type: none;
        width: 100px;
      }
      #navbar li {
        border-left: 10px solid #666;
        border-bottom: 1px solid #666;
      }
      #navbar a {
        background-color: #949494;
        color: #fff;
        padding: 5px;
        text-decoration: none;
        font-weight: bold;

        display: block;
      }
    </style>
  </head>
 
  <body>
   
    <ul id="navbar">
      <li><a href="#">Главная</a></li>
      <li><a href="#">Прайс-лист</a></li>
      <li><a href="#">Найти сотрудника</a></li>
      <li><a href="#">Найти клиента</a></li>
      <li><a href="#">История обращений</a></li>
    </ul>
 
  </body>
</html>
