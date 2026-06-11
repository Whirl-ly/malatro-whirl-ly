Facultad de Ciencias Físicas y Matemáticas Departamento de Ciencias de la Computación CC3002 - Metodologías de Diseño y Programación 

## Malatro _Proyecto Semestral_ 

## **Profesores** 

Matías Toro Ignacio Slater 

## **Auxiliares** 

Vicente Figueroa Marcelo Zamorano 

## **Contents** 

**1. Introducción al proyecto . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 3 2. Descripción del problema . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 3** 2.1. Puntaje . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 3 2.2. Cartas . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 3 2.2.1. Rango . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 3 2.2.2. Pinta . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 4 2.2.3. Jokers . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 4 2.3. Mano . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 4 2.4. Combinaciones de póker . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 4 2.5. Sistema de puntuación . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5 2.6. Reglas del juego . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5 **3. Modelo de la solución . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5 4. Evaluación . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5** 4.1. Ponderaciones . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 5 4.2. Modalidad de entrega . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 6 4.2.1. Política de días de emergencia . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 6 4.3. Bonificaciones . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 7 **5. Recomendaciones . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 7 6. Anexo - Ejemplo de una Jugada en Malatro . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 8** 6.1. Estado de la mano . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 8 6.2. Cálculo de Puntaje . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 8 6.3. Resultado Final . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . 9 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Introducción al proyecto 

3 

## **1. Introducción al proyecto** 

Uno de los principales objetivos del curso es que aprendan a escribir programas de calidad y utilizando buenas metodologías de diseño y programación. Para lograr este objetivo, se les presenta un proyecto semestral dividido en 3 Tareas en las que se espera que apliquen los contenidos enseñados en el curso. 

**Importante: este documento describe el contexto general y la visión global del proyecto.** En cada tarea y entrega parcial se indicará explícitamente qué subconjunto de requisitos debe implementarse y cuáles no forman parte de la evaluación en esa instancia. 

El proyecto simula un “caso real” en el que usted deberá desarrollar código de acuerdo a requisitos, como si los hubiera hecho un cliente “real” que serán explicados en el presente documento. Para promover el desarrollo constante de la solución, junto con presentar los requisitos específicos a implementar en cada momento, existirán pequeños entregables, denominados **Entregas Parciales** . 

El proyecto a realizar será crear una versión simplificada de la mecánica principal del juego _Balatro_ , desarrollado por _LocalThunk_ . A grandes rasgos, el juego se basa en construir manos de póker utilizando una baraja estándar, combinando cartas y Jokers para obtener la mayor cantidad de puntos posible. El jugador podrá formar combinaciones de cartas utilizando una baraja estándar a través de su mano, junto a comodines especiales llamados Jokers, con el objetivo de maximizar su puntaje antes de que se acaben sus turnos. 

## **2. Descripción del problema** 

## **2.1. Puntaje** 

El puntaje se expresa mediante dos valores: 

- Chips ( _chips_ ): el puntaje base de la jugada. 

- Multiplicador ( _mult_ ): un factor que multiplica los chips para calcular el puntaje final. 

El puntaje total de una mano es: 

puntaje = chips × mult 

## **2.2. Cartas** 

Las cartas son los elementos fundamentales del juego. Cada carta posee dos atributos principales: rango y pinta. 

## **2.2.1. Rango** 

Toda carta posee un rango, el cual determina su orden, el valor ( _chips_ ) que aporta y su clasificación. Los rangos posibles son los siguientes: 

- **As** : tiene valor 11, puede actuar con orden 1 o 14 para efectos de escaleras, y su clasificación es **impar** . 

- **Rangos numéricos** : corresponden a los valores del 2 al 10. Su orden y valor coinciden con su número. Su clasificación es **par** o **impar** según corresponda. 

- **Figuras** : corresponden a Jota, Reina y Rey. Su orden es 11, 12 y 13 respectivamente, su valor es 10, y su clasificación es **figura** . 

En consecuencia, toda carta debe permitir consultar al menos: 

- su orden, 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Modelo de la solución 

4 

- su valor en chips, 

- y su clasificación: **par** , **impar** o **figura** . 

## **2.2.2. Pinta** 

Corazones, Diamantes, Tréboles, Picas. 

## **2.2.3. Jokers** 

Los Jokers son cartas especiales que no se juegan como parte de la mano de póker, sino que permanecen activas modificando las reglas de puntuación. Cada Joker posee uno o más efectos que alteran la forma en la que se calcula el puntaje final de la mano. 

Los Jokers disponibles en esta versión son: 

- Joker Codicioso ( _Greedy Joker_ ): Por cada carta de Diamante presente entre las cartas jugadas, suma +3 al multiplicador. 

- Joker Retorcido ( _Devious Joker_ ): Si las cartas jugadas satisfacen la combinación de Escalera ( _Straight_ ), suma +100 chips al puntaje. 

- Even Steven: Por cada carta de rango par presente entre las cartas jugadas, suma +4 al multiplicador. 

- Cara Aterradora ( _Scary Face_ ): Por cada carta de figura (J, Q, K) presente entre las cartas jugadas, suma +30 chips al puntaje. 

## **2.3. Mano** 

El jugador cuenta con una mano compuesta por hasta 8 cartas y puede tener hasta 2 Jokers activos. En cada ronda, el jugador dispone de: 

- Hasta 3 jugadas. 

- Hasta 3 descartes. 

Tanto una jugada como un descarte deben implicar un mínimo de 1 y un máximo de 5 cartas. 

## **2.4. Combinaciones de póker** 

Existen múltiples combinaciones válidas de póker. Cada combinación posee una condición específica que debe cumplirse para ser válida y un puntaje base (chips y multiplicador). Las combinaciones se evalúan en el siguiente orden, de mayor a menor valor. Si una jugada satisface más de una combinación, debe considerarse **únicamente la de mayor prioridad** según el orden listado: 

- Escalera de color ( _Straight Flush_ ): Una escalera de cinco cartas consecutivas de la misma pinta. Puntaje base: 100 chips, multiplicador x8. 

- Color ( _Flush_ ): Cinco cartas de la misma pinta, sin importar el orden. Puntaje base: 35 chips, multiplicador x4. 

- Escalera ( _Straight_ ): Cinco cartas en orden consecutivo, sin importar la pinta. Puntaje base: 30 chips, multiplicador x4. 

- Trío ( _Three of a Kind_ ): Tres cartas del mismo rango. Puntaje base: 30 chips, multiplicador x3. 

- Par ( _Pair_ ): Dos cartas del mismo rango. Puntaje base: 10 chips, multiplicador x2. 

- Carta Alta ( _High Card_ ): Cualquier mano que no cumpla con las combinaciones anteriores. Solo cuenta la carta de mayor valor. 

Puntaje base: 5 chips, multiplicador x1. 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Modelo de la solución 

5 

## **2.5. Sistema de puntuación** 

El puntaje total de una jugada se obtiene al combinar el puntaje de la combinación jugada, los chips que aporta cada carta de forma individual y los efectos de los Jokers. El algoritmo exacto de cálculo es el siguiente: 

- Determinar la mejor combinación posible entre las cartas jugadas según el orden de prioridad. 

- Inicializar `chips` y `mult` con el puntaje base correspondiente a esa combinación. 

- Sumar a `chips` el valor de cada carta efectívamente jugada. 

- Aplicar los efectos de los Jokers activos sobre `chips` y/o `mult` . 

- Calcular el `puntaje final = chips * mult` y devolver este monto. 

## **2.6. Reglas del juego** 

Una partida se desarrolla alrededor del concepto de manos de póker, es decir, una colección de cartas que el jugador elige y juega en un intento por formar una combinación válida. Estas combinaciones otorgan puntaje, el cual es afectado por distintos modificadores provistos por los Jokers. 

El jugador puede jugar una cantidad limitada de cartas y realizar descartes limitados por ronda. Cuando la cantidad de jugadas llega a cero, y ya no puede realizar más acciones, la partida finaliza. 

Para ganar el juego, el jugador debe alcanzar un puntaje mínimo definido antes de quedarse sin jugadas. En caso contrario, se considera una derrota. 

## **3. Modelo de la solución** 

La resolución de este proyecto se hará siguiendo el patrón arquitectónico _Modelo-Vista-Controlador_ donde primero se implementará el _Modelo_ luego el _Controlador_ y finalmente la _Vista_ . Este patrón se irá explicando a lo largo del proyecto, y tendrán una guía constante para su correcta resolución. En el contexto del proyecto completo, estos componentes serán como se explica a continuación: 

**Modelo –** Representa todas las entidades necesarias que conforman la estructura del proyecto y define las operaciones básicas e interacciones posibles entre ellas. Las entidades en este caso se refieren a todos los elementos del juego. 

**Vista –** Se le pedirá, de manera opcional, que cree una interfaz gráfica o de consola simple para el juego que pueda responder al input de un usuario y mostrar toda la información relevante del juego en pantalla. 

**Controlador –** Servirá de conexión lógica entre la vista y el modelo, se espera que el controlador pueda ejecutar todas las operaciones que un jugador podría querer efectuar, que entregue los mensajes necesarios a cada objeto del modelo y que guarde información importante del estado del juego en cada momento. 

## **4. Evaluación** 

La nota de cada tarea corresponderá a la ponderación de 3 notas individuales que evalúan cada aspecto importante de sus entregas 

## **4.1. Ponderaciones** 

- **Diseño (50%)** : Se evaluará la calidad de su código, exigiendo que este cumpla con los principios de diseño enseñados en el curso. 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Recomendaciones 

6 

- **Testing y Coverage (35%)** : Se evaluará que su código tenga pruebas de su funcionamiento con una cobertura de al menos el 50% de las **líneas** de código escritas en `src/main/scala` . Para obtener el puntaje completo, el coverage en dichas secciones debe ser de al menos 90%. Cabe destacar que las pruebas deben no solo comprobar que el fragmento a testear cumple con lo solicitado, sino que deberá también incluir casos de borde. 

- **Documentación (15%)** : Cada interfaz, clase (abstracta y concreta) y método debe estar documentado. Siga la guía de documentación que encontrará en https://gitlab.com/-/snippets/5969. 

Para guiar la realización de este proyecto, se plantearán objetivos pequeños en forma de _Entregas Parciales_ . 

- **Entrega Parcial (0.5 pts. c/u)** : Dichas entregas deberán ser enviadas en la fecha señalada y no serán evaluadas directamente con nota. Solamente será evaluado que al momento de entregarla se cumpla con el objetivo planteado, **independientemente de su diseño** . 

**IMPORTANTE** : Una entrega parcial se considera completada cuando usted realiza **entrega y coevaluación** . 

La no entrega de una entrega parcial supondrá un **descuento en su nota final** , en la cantidad de puntos señalada. Su finalidad es solamente incentivar el trabajo constante y continuo, por sobre realizar las tareas a último minuto, por lo que las entregas parciales **no tendrán feedback del equipo docente** . 

## **4.2. Modalidad de entrega** 

Deberá subir todo su trabajo al repositorio privado proporcionado a través de _GitHub Classroom_ . 

La entregas consistirán en un archivo de texto ( `.txt` ) que se subirá en la sección _Tareas_ de _U-Cursos_ . **Dicho archivo deberá tener siempre el mismo formato. El no cumplimiento de este implica un descuento en su nota final, específicamente severo si es un archivo comprimido (** **`.rar, .zip` )** . El formato es el siguiente: 

```
Nombre: <Nombre completo> // Sin las llaves!
PR: <URL del pull request> // Sin las llaves!
```

La correcta URL de un pull request es de la forma: 

https://github.com/dcc-cc3002/<TU-REPOSITORIO>/pull/x 

Cuando considere que su entrega está lista para ser evaluada, realice un **pull request** a la rama _main_ de su repositorio principal. 

Se recomienda utilizar una rama diferente para cada entrega (por ejemplo, `entrega-parcial-1` , `entregafinal-1` ). Una vez abierto el pull request, cualquier commit adicional en esa misma rama se incorporará automáticamente al PR. Para efectos de evaluación, solo se considerará el último commit realizado dentro del plazo. Commits posteriores no serán tomados en cuenta. 

## **4.2.1. Política de días de emergencia** 

Usted cuenta con 7 días de emergencia para distribuir a lo largo de su semestre, pudiendo utilizar a lo más 3 por **Entrega Final** . Si usted realiza commits en el plazo de atrasos, el equipo docente registrará cuántos días de atraso ocupó. **Si usted no cuenta con más días de atraso y realiza commits en el período de atrasos, estos no serán considerados** . 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Recomendaciones 

7 

## **4.3. Bonificaciones** 

Puede ganar puntos adicionales al implementar lo siguiente: 

- **TAREA 1, 2, 3 – Readme (0.2 pts.)** : Obtenga puntos adicionales1 detallando en su `README.md` aspectos que considere relevantes de aclarar en su proyecto. Algunos ejemplos pueden ser responder las siguientes preguntas: 

- ‣ _¿Por qué tomó ciertas decisiones en su diseño?_ 

- ‣ _¿Cómo está organizado su código?_ 

- ‣ _¿Qué patrones de diseño utilizó?_ 

- **TAREA 1, 2, 3 – Código y documentación en inglés (0.1/0.2 pts.)** : Se recomienda escribir el código y su documentación en inglés para hacer el proyecto más accesible a más personas. En desarrollo de software son comunes los equipos con integrantes de múltiples nacionalidades; aunque su equipo no parta así, documentar en inglés ayuda a prepararse para ese escenario con menos fricción. Nombres de clases, interfaces, métodos y variables debiesen estar en este idioma, así como también la documentación asociada. 

- **TAREA 1, 2, 3 – Buen uso de Git (hasta 0.4 pts.)** : Se premiará el uso apropiado del controlador de versiones, registrando pequeños cambios en cantidad, con descripciones adecuadas del registro, contrario a entregar toda una tarea en un solo registro, sin descripción: 

- ‣ **(0.1/0.2 pts)** : Crea múltiples commits, siendo cada uno un avance pequeño. Contar con este bonus es **necesario** para poder acceder a los siguientes. 

- ‣ **(0.1 pts)** : Utiliza Conventional Commits, indicando claramente lo que se realizó en el avance. 

- ‣ **(0.1 pts)** : Commits en inglés (misma razón que el bonus de documentación en inglés). 

- **TAREA 3 – Interfaz gráfica (0.5 pts.):** Si incorpora una interfaz gráfica (puede ser de consola) para el juego, se podrá optar a esta bonificación. 

- **TAREA 3 – Patrones de diseño adicionales (0.2 pts):** Al incorporar **correctamente** más patrones de diseño de los solicitados, se podrá optar a esta bonificación (No acumulable). 

- **TAREA 3 – For Comprehension (0.3 pts):** Utilizar **correctamente** la sintaxis de for comprehension (No acumulable). 

## **5. Recomendaciones** 

- No se aferre al primer diseño; busque oportunidades de mejora y extensibilidad. Pregúntese, ¿Qué pasaría si en el futuro se quisiera implementar X funcionalidad nueva? ¿Mi código tendría que ser modificado si quisiera hacerlo? De esta manera, la mayor parte de su código soportaría extensibilidad para cualquier funcionalidad nueva que se desee agregar. 

- **NO DEJE LA TAREA PARA ÚLTIMO MOMENTO** . Aunque es un consejo común, y sabemos que es algo que se dice en todos los cursos, aquí es especialmente relevante. Trabajar apresuradamente no solo le resultará en un diseño descuidado, sino que no tendrá tiempo de pensar en uno mejor, y finalmente no podrá aplicar las buenas prácticas enseñadas en el curso. 

> 1Hay bastantes más «Puntos adicionales» de los que usted cree que hay aquí. Lo primero que hace su ayudante al revisar su tarea, es leer su readme. Explicarle adecuadamente su trabajo le ayudará a entenderlo de mejor manera, haciéndole más feliz, y muy posiblemente evitándole a usted tediosos reclamos sobre algo que no se entendió. 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Anexo - Ejemplo de una Jugada en Malatro 

8 

- **Si algo no se especifica en el enunciado, tiene libertad creativa** . Esto es, manejar ciertos casos de borde o ciertos aspectos funcionales que no se detallan, pero asegúrese de cumplir con lo solicitado. 

## **6. Anexo - Ejemplo de una Jugada en Malatro** 

En este ejemplo, el jugador tiene una mano de 8 cartas y dos Jokers. 

## **6.1. Estado de la mano** 

El jugador tiene las siguientes cartas en su mano: 

- Dos de Diamante (2) 

- Tres de Diamante (3) 

- Cuatro de Diamante (4) 

- Cinco de Diamante (5) 

- Seis de Diamante (6) 

- Jota de Trébol (J) 

- Reina de Picas (Q) 

- As de Corazón (A) 

Y los siguientes Jokers activos: 

- Joker Codicioso ( _Greedy Joker_ ) 

- Joker Retorcido ( _Devious Joker_ ) 

La mejor opción es jugar la **Escalera de Color** ( _Straight Flush_ ), que consiste en la secuencia de las cinco cartas de Diamante. Las demás cartas quedan en la mano y no aportan puntaje. 

## **6.2. Cálculo de Puntaje** 

- **Combinación** : La combinación que se ha detectado es una **Escalera de Color** . 

- ‣ Puntaje base de `chips` : 100 

- ‣ Valor base del multiplicador `mult` : 8 

- **Aporte individual de las cartas** : Se añade a los `chips` el valor correspondiente a cada una de las 5 cartas jugadas. 

- ‣ **Dos de Diamante (2)** : Aumenta los chips en su propio valor. 

- Puntaje en `chips` : 100 + 2 = 102 

- ‣ **Tres de Diamante (3)** : Aumenta los chips en su propio valor. 

- Puntaje en `chips` : 102 + 3 = 105 

- ‣ **Cuatro de Diamante (4)** : Aumenta los chips en su propio valor. 

- Puntaje en `chips` : 105 + 4 = 109 

- ‣ **Cinco de Diamante (5)** : Aumenta los chips en su propio valor. 

- Puntaje en `chips` : 109 + 5 = 114 

- ‣ **Seis de Diamante (6)** : Aumenta los chips en su propio valor. 

- Puntaje en `chips` : 114 + 6 = 120 

- **Aplicación de Jokers** : Una vez obtenidos los aportes base, se aplican los efectos de comodines. 

- ‣ **Joker Codicioso (** _**Greedy Joker**_ **)** : Su efecto de +3 al multiplicador por carta de Diamante jugada suma +15 acumulados (ya que se jugaron 5 de Diamante). – Multiplicador `mult` : 8 + 15 = 23 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

Anexo - Ejemplo de una Jugada en Malatro 

9 

- ‣ **Joker Retorcido (** _**Devious Joker**_ **)** : Como la mano efectivamente es una escalera, el Joker otorga +100 chips. 

- Puntaje en `chips` : 120 + 100 = 220 

## **6.3. Resultado Final** 

El puntaje total para esta jugada de **Escalera de Color (** _**Straight Flush**_ **)** es: 

- Puntaje final: 220 (chips) ∗23 (multiplicador) = 5060. 

_Malatro_ 

_CC3002 - Metodologías de Diseño y Programación_ 

