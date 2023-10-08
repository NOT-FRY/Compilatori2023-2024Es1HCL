import java.io.*;
import java.util.HashMap;
import java.util.logging.Logger;

public class Lexer {
	
	private File input;
	private static HashMap<String,Token> stringTable;
	private int state;

	private RandomAccessFile fr;
	private Logger logger;

	public Lexer(){
		// la symbol table in questo caso la chiamiamo stringTable
		stringTable = new HashMap<String,Token>();
		state = 0;
		stringTable.put("if", new Token("IF"));
		stringTable.put("then", new Token("THEN"));
		stringTable.put("else", new Token ("ELSE"));
		stringTable.put("while", new Token("WHILE"));
		stringTable.put("int", new Token ("INT"));
		stringTable.put("float",new Token("FLOAT"));

		logger = Logger.getLogger(this.getClass().getName());

		// inserimento delle parole chiavi nella stringTable per evitare di scrivere un diagramma di transizione per ciascuna di esse (le parole chiavi verranno "catturate" dal diagramma di transizione e gestite e di conseguenza). IF poteva anche essere associato ad una costante numerica

	}
	
	public Boolean initialize(String filePath){

		File input= new File(filePath);

		try  {
			fr=new RandomAccessFile(input,"r");
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
			return false;
		}

		return true;
	   // prepara file input per lettura e controlla errori
	} 
	
	public Token nextToken()throws Exception{
		
		//Ad ogni chiamata del lexer (nextToken())
		//si resettano tutte le variabili utilizzate
		state = 0;
		String lessema = ""; // il lessema riconosciuto
        char c;
		int data;
		
		while(true){

			 // legge un carattere da input e lancia eccezione quando incontra EOF per restituire null
			 //  per indicare che non ci sono piu token
			try{
				if( ( data = fr.read() ) != -1){
					c = (char) data;
				}else{
					fr.close();
					throw new EOFException();
				}
			}catch (IOException e){
				logger.info(e.getMessage());
				return null;
			}


			//delimitatori
			switch (state){
				case 0:

					if(Character.isWhitespace(c)) {
						state = 1;
					}
					else
						state = 3; //prossimo automa id

					break;
				case 1:

					if(Character.isWhitespace(c))
						//DO NOTHING (Consuma white spaces)
						;
					else
						state = 2;

					break;
				case 2:
					retrack();
					state = 3;	//prossimo automa id
					break;

				default: break;
			}

			//id
			switch(state){
				case 3:
					if(Character.isLetter(c)){
						state = 4;
						lessema += c;
						// Nel caso in cui il file è terminato ma ho letto qualcosa di valido
						// devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF)
						if(wasLastCharacter()){
							return installID(lessema);
						}
					}else {
						state = 5; //prossimo automa separatori
					}
					break;

				case 4:
					if(Character.isLetterOrDigit(c) || (Character.compare(c,'_') == 0)){
						lessema += c;
						if(wasLastCharacter())
							return installID(lessema);
					}else{
						state = 5; //prossimo automa separatori
						retrack();
						return installID(lessema);
					}
					break;
				default: break;
			}//end switch


			//Separatori
			switch(state){
				case 5:
					if( c=='(' || c==')' || c=='{' || c=='}' || c==',' || c==';' ){
						lessema += c;
						return installSeparator(lessema);
					}else {
						//Non c'è bisogno di nessun retrack() perchè abbiamo letto un solo carattere in questo automa.
						state = 6; //prossimo automa operatori
					}
					break;
				default: break;
			}//end switch


			//Operatori

			//Il codice non può terminare con uno di questi operatori
			switch(state){
				case 6:
					if(c=='<'){
						state = 7;
						lessema += c;
					}else {
						state = 10; //cambio operatore
					}
					break;

				case 7:
					if(c=='-'){
						state = 8;
						lessema += c;
					}else {
						installOperator(lessema);
						state = 9; //cambio operatore <=;
					}
					break;

				case 8:
					if(c=='-'){
						lessema += c;
						return installSeparator(lessema);
					}else {
						//TODO Lancio errore se trovo un altro carattere che non mi aspettavo ??
						state = .. //lancia errore;
					}
					break;
				case 9:
					if(c=='='){
						lessema += c;
						return installSeparator(lessema);
					}else {
						state = .. //lancia errore;
					}
					break;
				case 10:
					if(c=='>'){
						state = 9;
						lessema += c;
						if(wasLastCharacter()){
							return installSeparator(lessema);
						}
					}else {
						state = 11; //cambio operatore;
					}
					break;
				case 11:
					if(c=='='){
						state = 9;
						lessema += c;
					}else {
						state = 11; //prossimo automa
					}
					break;
				default: break;
			}//end switch

			//id
			switch(state){
				case 9:
					if(Character.isLetter(c)){
						state = 10;
						lessema += c;
						// Nel caso in cui il file � terminato ma ho letto qualcosa di valido
						// devo lanciare il token (altrimenti perderei l'ultimo token, troncato per l'EOF) 
						if(wasLastCharacter()){
							return installID(lessema);
						}
						break;
					}
					state = 12;
					break;
					
				case 10:
					if(Character.isLetterOrDigit(c)){
						lessemq += c;
						if(// controlla se � finito il file)
							return installID(lessema);
						break;
					}else{
						state = 11;
						retrack();
						return installID(lessema);
					}
				default: break;
			}//end switch
			
			//unsigned numbers
			switch(state){
				case 12:
					if(Character.isDigit(c)){
						state = 13;
						lessema += c;
						if(// controlla se � finito il file){
							return new Token("NUMBER", lessema);
						}
						break;
					}
					state = 22;
					break;
                           
                case 13:
           }
		}//end while
	}//end method
		
  
private Token installID(String lessema){
	Token token;
	
	//utilizzo come chiave della hashmap il lessema
	if(stringTable.containsKey(lessema))
		return stringTable.get(lessema);
	else{
		token =  new Token("ID", lessema);
		stringTable.put(lessema, token);
		return token;
	}
}

	private Token installSeparator(String lessema){

		Token token;

		if (stringTable.containsKey(lessema))
			return stringTable.get(lessema);

		else {
			if (lessema.equals("(")) {
				token = new Token("LPAR");
				stringTable.put(lessema, token);
				return token;
			}
			if (lessema.equals(")")) {
				token = new Token("RPAR");
				stringTable.put(lessema, token);
				return token;
			}
			if (lessema.equals("{")) {
				token = new Token("LCUR");
				stringTable.put(lessema, token);
				return token;
			}
			if (lessema.equals("}")) {
				token = new Token("RCUR");
				stringTable.put(lessema, token);
				return token;
			}
			if (lessema.equals(",")) {
				token = new Token("COM");
				stringTable.put(lessema, token);
				return token;
			}
			if (lessema.equals(";")) {
				token = new Token("SEMI");
				stringTable.put(lessema, token);
				return token;
			}

		}
		return null;
	}
	
private Token installOperator(String lessema){

	Token token;

	if (stringTable.containsKey(lessema))
		return stringTable.get(lessema);

	else {
		if (lessema.equals("<--")) {
			token = new Token( "ASS");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("<")) {
			token = new Token("LT");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("<=")) {
			token = new Token("LE");
			stringTable.put(lessema, token);
			return token;
		}

		if (lessema.equals(">")) {
			token = new Token("GT");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals(">=")) {
			token = new Token( "GE");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("!=")) {
			token = new Token( "NE");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("==")) {
			token = new Token("EQ");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("+")) {
			token = new Token( "ADD");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("-")) {
			token = new Token( "MIN");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("*")) {
			token = new Token( "MUL");
			stringTable.put(lessema, token);
			return token;
		}
		if (lessema.equals("/")) {
			token = new Token( "DIV");
			stringTable.put(lessema, token);
			return token;
		}

	}
	return null;
}

private void retrack(){
		// fa il retract nel file di un carattere
		try {
			fr.seek(fr.getFilePointer()-1);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
}

private boolean wasLastCharacter(){
		try {
			if(fr.read()==-1)
			{
				fr.close();
				return true;
			}

		} catch (IOException e) {
			logger.info(e.getMessage());
			return true;
		}
			retrack();
			return false;
		}
		
}
