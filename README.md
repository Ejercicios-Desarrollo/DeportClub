# DeportClub

## Patrones de Diseño Utilizados

### State

Para la motivación, ya que BajarDePeso, TonificarCuerpo y MantenerFigura implementan métodos similares pero cada uno con distinto comportamiento.

Esto proporciona:
- Mayor cohesión a la clase Deportista
- Mayor mantenibilidad, debido a que el comportamiento por cada estado es fácilmente localizable.
- Extensibilidad para incoporar nuevos estados (nuevos comportamientos).

### Adapter

Para el sistema externo de cálculos ideales, ya que al ser un sistema externo, no conocemos como está implementado por lo que debemos adaptarlo a nuestro sistema:

Esto proporciona:
- Mayor mantenibilidad debido al nulo acoplamiento entre BajarDePeso y TonificarCuerpo y la clase adaptada.
- Mayor cohesión de la clases BajarDePeso y TonificarCuerpo debido a la delegación de cierto comportamiento en el adapter.

### Composite

Para las superseries, ya que tienen una estructura de árbol.

Esto permite que otras clases traten de forma polimórfica a un ejercicio simple y a un conjunto combinado de ellos (superseries).

### Strategy

Para la generación de rutina, normalmente las rutinas son de entre 3 días como mínimo y 6 días como máximo, por lo que habrá 4 estrategias de generación de rutinas, cada una relizará la misma acción (generar una rutina) pero con un algoritmo distinto.

Este patrón encapsula distintas formas (o algoritmos) de resolver el mismo problema en diferentes clases.

Esto proporciona además una mayor cohesión a la clase Motivación y mayor mantenibilidad debido a que cada estrategia tiene un comportamiento muy particular.

### Observer:

En los métodos pesarse() y medirNiveles(), se hará una verificación con los valores ideales calculados en la motivación correspondiente y si no hubo una mejora respecto a los últimos niveles medidos, se reforzará la rutina.

Se utilizará otro observer en pesarse() para consultar si durante ese mes se pesó 3 veces más, para otorgar o no el trofeo al creído.

Al generar una rutina nueva se debe tener otro observer para otorgar o no el trofeo a la constancia, verificando si el deportista asistió a todos los días de entrenamiento y realizó todos los ejercicios.

Y por último este patrón se debe aplicar también en el cambio de motivación, para verificar cuantas veces cambió de rutina antes de cumplir la motivación, si es menor a 4, otorgar trofeo a la dedicación.

La utilización de este patrón permite notificar a las clases que lo requieran cuando ocurra un evento y que estas puedan actuar en consecuencia. Además, desacopla las acciones que se ejecutan de los eventos que las activan.

Esto proporciona:
- Mayor cohesión a la clases.
- Mayor mantenibilidad debido a que el comportamiento establecido por cada observador es facilmente localizable.
- Extensibilidad a causa del desacoplamiento entre acción – reacción.
- Mayor facilidad para reutilización de los observadores.


## Modelo de datos

Para el modelado de la motivación, utilizaría una estrategia de JOINED TABLE, para separar los distintos atributos en cada tabla, compartiendo los atributos comunes en la tabla motivación. 

Si hubiera elegido modelarlo como SINGLE TABLE tendría todos los atributos, muchos de ellos nulos, en la misma tabla.

La estrategia TABLE PER CLASS queda descartada ya que no puedo tener una relación bidireccional con el deportista, me impide utilizar el polimorfismo con las motivaciones.
