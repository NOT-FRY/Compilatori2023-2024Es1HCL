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


❗Se viene trovato un letterale INUMBER che inizia con il digit '0', viene tokenizzato 0 separatamente.
Es:
045 --> (INUMBER, "0") & (INUMBER, "45")

❗Per gli FNUMBER invece, il token '0' non viene separato, ma questo controllo viene effettuato come se fosse un digit normale,
infatti è possibile inserire 0.0 , che verrà identificato come FNUMBER.


##Diagrammi di transizione

**Delimitatori**
![Delimitatori](res\Delimitatori.png)

**ID**
![Id](res\Id.png)

**INUMBER**
![Inumber](res\Inumber.png)

**FNUMBER**
![FNumber](res\Fnumber.png)

**Operatori Aritmetici**
![Operatori Aritmetici](res\operatori_aritmetici.png)

**Operatori**
![Operatori](res\operator.png)

**Separatori**
![Separatori](res\separatori.png)



    





