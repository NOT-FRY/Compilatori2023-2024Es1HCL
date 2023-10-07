# Specifica del lessico

### Delimitatori
| Lessema                                                    | Nome del token | Attributo      |
|------------------------------------------------------------|----------------|----------------|
| [Definizione regolare](#definizioni-regolari-delimitatori) | -              | -              |



### Keyword
| Lessema | Nome del token | Attributo |
|---------|----------------|-----------|
| if      | *IF*           | -         |
| then    | *THEN*         | -         |
| else    | *ELSE*         | -         |
| while   | *WHILE*        | -         |
| int     | *INT*          | -         |
| float   | *FLOAT*        | -         |


### Identificatori
| Lessema                                                      | Nome del token | Attributo                          |
|--------------------------------------------------------------|----------------|------------------------------------|
| [Definizione regolare](#definizioni-regolari-identificatori) | *ID*           | Puntatore alla tabella dei simboli |


### Letterali
| Lessema                                                 | Nome del token | Attributo |
|---------------------------------------------------------|----------------|-----------|
| [Definizione regolare](#definizioni-regolari-letterali) | *IDIGIT*       | -         |
| [Definizione regolare](#definizioni-regolari-letterali)   | *FDIGIT*       | -         |


### Separatori
| Lessema | Nome del token | Attributo |
|---------|-------------|-----------|
| (       | *LPAR*      | -         |
| )       | *RPAR*      | -         |
| {       | *LCUR*      | -         |
| }       | *RCUR*      | -         |
| ,       | *COM*       | -         |
| ;       | *SEMI*      | -         |



### Operatori
| Lessema | Nome del token | Attributo |
|---------|----------------|-----------|
| <--     | *ASS*          | -         |
| <       | *LT*           | -         |
| <=      | *LE*           | -         |
| \>      | *GT*           | -         |
| \>=     | *GE*           | -         |
| !=      | *NE*           | -         |
| +       | *ADD*          | -         |
| -       | *MIN*          | -         |
| *       | *MUL*          | -         |
| /       | *DIV*          | -         |


## Definizioni regolari

####  Definizioni regolari delimitatori

>* **blank** --> (\s)
>* **tab** --> (\t)
>* **newline** --> (\n)
>* **ws** --> (blank | tab | newline)<sup>+</sup>


####  Definizioni regolari identificatori

>* **letter** --> [A-Za-z]
>* **letter_** --> [A-Za-z_]
>* **digit** --> [0-9]
>* **id** --> letter ( letter_ | digit )<sup>*</sup>

####  Definizioni regolari letterali

>* **digit** --> [0-9]
>* **idigit** --> ([+-] ? [1-9] digit<sup>*</sup>) | [0]
>* **fdigit** --> (([+-] ? [1-9] digit<sup>*</sup>) | [+-] ? [0]) ( \. digit<sup>+</sup> )





    





