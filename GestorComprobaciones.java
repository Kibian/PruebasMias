package src;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.DataBaseManager;

public class GestorComprobaciones {

	public boolean comprobadorTiempos(String tiempo) {
		char[] resultado = tiempo.toCharArray();
		int numero = 2;	//num de 2 puntos que debe de haber en el tiempo
        int numSep = 0; //contador para contarlos
        for(int i = 0; i < resultado.length; i++) {
    	    if(Character.toString(resultado[i]).equals(":")) {	//comprobamos que tenga un formato correcto
    		    numSep++;
    	    }
        }
        
        
        if(numero==numSep) {
        	String[] valoresNum = tiempo.split(":");
        	if(valoresNum.length==3) {	//debe de haber horas, mins y seg el fichero puede contener :21:21 y eso estaria mal
        		if(valoresNum[0].length() > 0&& valoresNum[1].length()==2 && valoresNum[2].length()==2) { //comprobamos que no introduzcan por ejemplo 1:121:21, no incluimos las horas en esta comprobacion
        			if(Integer.parseInt(valoresNum[1])<60 && Integer.parseInt(valoresNum[2])<60
        					&& Integer.parseInt(valoresNum[1])>=0 && Integer.parseInt(valoresNum[2])>=0 
        					&& Integer.parseInt(valoresNum[0])>=0) { //hay valores de 2 cifras invalidos, 90 minutos? Imposible
        				//si cumple todo esto es un tiempo valido!
        				return true;
        			}
        		}
        	}
        }
        return false;
	}
	
	//COMPRUEBA SI EL DNI ESTA EN LA BASE DE DATOS
	public boolean comprobadorPresencia(String dni, String carrera) throws SQLException {
		ArrayList<String> dnis = DataBaseManager.getDNIs(carrera);
		boolean resultado = false;
		for(int i = 0; i<dnis.size(); i++) {
			if(dnis.get(i).equals(dni)) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	
	//COMPRUEBA QUE SEA UNA CARRERA QUE EXISTE EN LA BBDD
	public boolean comprobadorCarrera(String carrera) throws SQLException {
		List<String> carreras = DataBaseManager.getCarreras();
		boolean resultado = false;
		for(int i = 0; i<carreras.size(); i++) {
			if(carreras.get(i).equals(carrera)) {
				resultado = true;
				break;
			}
		}
		return resultado;
		
	}
	
}
