package patronadapter.mundo;

/**
 * Ejemplo de Clase adaptadora
 * 
 */

public class CAAddressAdapter implements AddressValidator{

	private CAAddress objCAAddress;

	public CAAddressAdapter() {
		objCAAddress = new CAAddress();
	}
	public boolean isValidAddress(String inp_address, String inp_zip, String inp_state) {
		return objCAAddress
				.isValidCanadianAddr(inp_address, inp_zip, inp_state);
	}
	
	

}
