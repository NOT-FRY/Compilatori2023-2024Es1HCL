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
| [Definizione regolare](#definizioni-regolari-letterali)   | *NDIGIT*       | -         |


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
| =       | *EQ*           | -         |
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

Gli identificatori del linguaggio sono composti da lettere e non possono iniziare con una cifra o con il carattere undescore '_' .

>* **letter** --> [A-Za-z]
>* **letter_** --> [A-Za-z_]
>* **digit** --> [0-9]
>* **id** --> letter ( letter_ | digit )<sup>*</sup>

####  Definizioni regolari letterali

>* **digit** --> [0-9]
>* **idigit** --> ([1-9] digit<sup>*</sup>) || 0 
>* **fdigit** -->  [0-9]<sup>+</sup>\.digit<sup>+</sup>
>* **ndigit** --> \\(-digit<sup>+</sup>(\.digit<sup>+</sup>)?\\)



    





