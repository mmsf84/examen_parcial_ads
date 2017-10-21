package pruebas;

public class CleanCode {

	private int SIN_ATRASO = 0;
	private int CON_ATRASO = 1;
	private int CON_DATOS = 1;
	private int SIN_DATOS = 0;
	private int SIMPLIFICADO = 2;
	private int COMPLETO = 1;
	
	public enum CodigoLibro{
		RC("080000"), RVI("140000"), LD("050000"), LM("060000");
		private String value;
		private CodigoLibro(String value){
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public boolean returnEarlyDirty(LibroElectronico libro){
		boolean esLibroValido = false;
		if(libro.indAtraso == SIN_ATRASO){
			if(libro.indContieneDatos == CON_DATOS){
				if(libro.getCodLibro().length()==6){
					esLibroValido = esLibroAceptado(libro.getCodLibro());
				}
			}
		}
		
		return esLibroValido;
	}
	
	public boolean returnEarlyClean(LibroElectronico libro){
		
		if(libro.indAtraso == CON_ATRASO){ return false; }		
		if(libro.indContieneDatos == SIN_DATOS){ return false; }		
		if(libro.getCodLibro().length()!=6){ return false; }
		
		return esLibroAceptado(libro.getCodLibro());		
	}
	
	public void failFastDirty(LibroElectronico libro)throws Exception{
		
		if(libro.indAtraso == SIN_ATRASO){
			if(libro.indSimplificado == COMPLETO){
				if(esLibroAceptado(libro.getCodLibro())){
					//Realiza accion de grabar el libro
					
				}else{
					throw new Exception("El Libro no es codigo aceptado");
				}
			}else{
				throw new Exception("Solo se aceptan libros completos");
			}
		}else{
			throw new Exception("El Libro tiene Atraso");			
		}
	}
	
	public void failFastClean(LibroElectronico libro)throws Exception{
		
		if(libro.indAtraso == CON_ATRASO){ throw new Exception("El Libro tiene Atraso"); } 
		if(libro.indSimplificado == SIMPLIFICADO){ throw new Exception("Solo se aceptan libros completos"); }
		if(esLibroAceptado(libro.getCodLibro())){ throw new Exception("El Libro no es codigo aceptado"); }
		
		//Realiza accion de grabar el libro
	}
	
	public boolean esLibroAceptado(String codLibro){
		for(CodigoLibro libro : CodigoLibro.values()){
			if(libro.value == codLibro){
				return true;
			}
		}
		return false;
	}
}
