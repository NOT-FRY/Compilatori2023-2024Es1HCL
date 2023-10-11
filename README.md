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
| [Definizione regolare](#definizioni-regolari-letterali) | *INUMBER*      | -         |
| [Definizione regolare](#definizioni-regolari-letterali)   | *FNUMBER*      | -         |


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
❗ Il codice sorgente nel linguaggio definito, non può terminare con uno dei seguenti operatori

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

❗ Gli identificatori del linguaggio sono composti da lettere e non possono iniziare con una cifra o con il carattere undescore '_' .

>* **letter** --> [A-Za-z]
>* **letter_** --> [A-Za-z_]
>* **digit** --> [0-9]
>* **id** --> letter ( letter_ | digit )<sup>*</sup>

####  Definizioni regolari letterali

>* **digit** --> [0-9]
>* **digits** --> digit<sup>+</sup>
>* **inumber** --> [1-9]digit<sup>*</sup>(E[-+]?digits)?
>* **fnumber** --> inumber.digits(E[-+]?digits)?



    





