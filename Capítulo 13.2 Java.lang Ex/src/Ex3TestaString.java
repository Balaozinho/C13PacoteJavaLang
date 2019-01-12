
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
//Não irá realizar o replace, pois a String é imutável. 

	
//public static void main (String [] args){
//		String s = "fj11";
//	s.toUpperCase();
//		System.out.print(s);
//	}
//Lembrar que string é imutável, portanto, não ficará maiúscula a impressão de fj11
}

//realizar exercicios do 4 em diante