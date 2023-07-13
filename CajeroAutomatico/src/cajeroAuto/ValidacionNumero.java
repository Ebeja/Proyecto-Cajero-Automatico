package cajeroAuto;

public class ValidacionNumero {
	public static boolean isNumero(String cadena) {
		try {
			int numero = Integer.parseInt(cadena);
			return true;
		}catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	

}
