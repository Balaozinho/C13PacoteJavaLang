
public class Ex3TestaString {
	
//Para imprimir fj22, devo criar uma nova string e derivar ela	
public static void main (String [] args){
	String s = "fj11";
	s = s.replaceAll("1", "2");
	System.out.println(s);
}
		
//public static void main (String [] args) {
//	String s = "fj11";
//	s.replaceAll("1", "2");
//	System.out.println(s);
//}
//N�o ir� realizar o replace, pois a String � imut�vel. 

	
//public static void main (String [] args){
//		String s = "fj11";
//	s.toUpperCase();
//		System.out.print(s);
//	}
//Lembrar que string � imut�vel, portanto, n�o ficar� mai�scula a impress�o de fj11
}

//realizar exercicios do 4 em diante