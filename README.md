# Calculadora de números complejos

En este laboratorio se desarrolla una calculadora para números complejos, que contiene las siguientes funcionalidades: suma, resta, multiplicación, división, módulo, fase, conjugada, y representación en coordenadas polares.
Dentro del directorio se encontrara una carpeta /Test, en donde se encuentran diferentes pruebas para cada una de estas operaciones.

## Descripción
Un número complejo es un número compuesto por un número **real** y un número **imaginario**.
<br><br>Esta librería realizada en java contiene la representación en objetos de un número complejo y de las posibles operaciones que pueden realizarse entre varios número complejos. También se encuentran operaciones entre vectores y matrices de números complejos.
<br><br>Un número complejo está representado en esta librería por dos números double, el número de la parte real y el número de la parte imaginaria. La clase que hace posible esta representación se llama **ComplexNumber.java**. En esta clase es posible mostrar en unos formatos como **(x=3, y=5)** o **3+5i** un número complejo, lograr obtener el módulo de un número complejo, su fase, su conjugado entre otros.
<br><br>Las operaciones que se pueden realizar entre objetos ComplexNumber (números complejos) están dadas por la clase **MathComplex.java** (es similar a la estructura de la clase Math de java.lang, con la diferencia de que se usan números complejos y hay diversas operaciones distintas). Gracias a esta clase se pueden realizar las operaciones básicas entre números complejos como sumar, restar, multiplicar y dividir. Además es posible convertilos de cartesiano a polar y viceverza, sumar vectores y matrices, multiplicarlos, obtener el producto interno, entre otras operaciones más, como se puede ver en las siguientes porciones de código.

## Uso de la librería

### Si está usando maven

1. Agregue la siguiente dependencia en el POM de su proyecto:

```xml
<dependency>
	<groupId>edu.eci</groupId>
	<artifactId>ComplexNumbers</artifactId>
	<version>1.0-SNAPSHOT</version>
</dependency>
```

2. Vuelva a compilar su proyecto para que la dependencia sea descargada mediante:

> mvn compile<br>mvn package

### Si no está usando maven

1. Para usar la librería, se debe primero clonar el repositorio con el comando:

> git clone https://github.com/k26duran/calculadoraComplejos.git

1. Después se accede a la dirección donde el repositorio fue clonado y se ejecutan los siguientes comando:

> mvn compile<br>mvn package<br>mvn install

1. El último comando **mvn install** genera un archivo .jar que puede copiar y pegar en su proyecto para poder usar la librería.

## Pruebas
 ![](/img/pruebas.PNG)

## Autor

*Karen Paola Durán Vivas*

*Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.*


## Licencia

> GNU GENERAL PUBLIC LICENSE - Version 3, 29 June 2007

Para ver más, leer el archivo **LICENSE** ubicado en la raíz de este repositorio.
