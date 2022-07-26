# Challenge Full Stack Game - Sokfa U

## Aplicacion Empresarial
Proyecto Empresarial Desarrollado en Java Reactivo con Spring (Backend), el cual contiene
el modelo de Datos y la lógica del negocio, se utiliza la arquitectura Limpia del proyecto Bancolombia.
En la cual se muestran los directorios de , Domain, Application, Infraestructure(Driven adapters y Entry points).

Se usa la base de datos Mongo DB Atlas para la persistencia de los datos en la Nube.

Para el Front End Se usa Angular como framework en donde diseña una Single Page Application en la 
cual se reinderizan los componentes según la necesidad del negocio. se aclara que las iamgenes son cargadas
en la carpeta assets del proyecto.

Link de Repositorio: https://github.com/DiegoFelipe7/FullStackGame/tree/main

Se realiza un modelado usando Domain Driven Design que nos facilita la abstracción de la 
lógica del negocio para luego adaptar el código al juego de las cartas.

por último se realizan algunas pruebas unitarias al código y se documenta el código para mayor entendimiento.
![image](https://user-images.githubusercontent.com/51167724/180928323-42884f97-f328-4228-8d5c-e15015afb9bb.png)

## Juego de SuperHeroes

En este juego consiste en tener un mazo de tarjetas de superhéroes de Marvel, vas a
encontrar 108 personajes con diferentes estilos y formas, algunas de estas tarjetas son
personajes individuales y otras son tarjetas con un grupo de personajes. Las tarjetas no
tienen características y/o poderes, para esto debes crear un sistema que permita almacenar
estas tarjetas y asignarles una descripción, poderes (XP) y características.

Luego de tener todas las tarjetas sistematizadas, con sus características y/o poderes, se
debe diseñar un juego de máximo 6 jugadores y mínimo 2 jugadores. El juego consiste en
repartir aleatoriamente 5 tarjetas a los 6 jugadores o a cada jugador creado previamente. El
juego consiste en que cada jugador apuesta sus tarjetas y gana el juego el que tenga todas
las tarjetas. Cada jugador apuesta basado en sus bajara de tarjetas y gana la partida la
tarjeta que tenga mayor XP.

## Instrucciones
*Está diseñado para recibir como máximo 6 jugadores y mínimo 2.
*Cuenta con registro e inicio de sesión con Google y por mediod e correo electrónico.
*Cualquier jugador puede crear un juego, pero solo cuando hayan 3 usuarios matriculados a dicho juego, este arrancará.
*Cuando el juego arranca se repartirán 5 cartas por cada jugador.
*En cada ronda un jugador apuesta una carta de su mazo, el jugador que apostó la carta con más poder gana la ronda y se lleva todas las cartas apostadas.
*El jugador que se quede sin cartas quedará eliminado.
*El Ganador es aquel que termine con las cartas en su mazo.

Log In y Registro con Google
![image](https://user-images.githubusercontent.com/51167724/180927568-a34b7153-b54e-4271-b2ee-91af8d6b7027.png)

Uso de Firebase database para almacenar los usuarios
![image](https://user-images.githubusercontent.com/51167724/180927635-774a3c1c-4715-4e30-8f49-5ac130360d7b.png)

![image](https://user-images.githubusercontent.com/51167724/180927787-aa622d3a-af8e-451d-82e9-3a9240b40725.png)




## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

#### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

#### Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función “public static void main(String[] args)”.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**

### Desarrolladores de está Solución:
##### Diego Felipe Muñoz Mosquera
##### Daniel Felipe Marin Giraldo
##### Erick Santiago Diaz Bueno
