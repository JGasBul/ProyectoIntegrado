package Modelo;
import conexion.Gestion;
public class Juego {

	private int posRulo1;
	private int posRulo2;
	private int posRulo3;
	private int[] rulo1;
	private int[] rulo2;
	private int[] rulo3;
	private int nCoincidencias;
	private int contRetenciones;
	private double valorTirada;
	private Gestion gestion;
	private int ganador;

	public Juego(){
	
		this.posRulo1=5;
		this.posRulo2=8;
		this.posRulo3=2;
		this.rulo1=new int[]{1,2,3,4,5,6,7,8,9,10};
		this.rulo2=new int[]{1,2,3,4,5,6,7,8,9,10};
		this.rulo3=new int[]{1,2,3,4,5,6,7,8,9,10};
		this.nCoincidencias=0;
		this.contRetenciones=0;
		this.valorTirada=1.0;
		this.gestion=new Gestion();
		this.ganador=0;

	}


	public void tiraPalanca() {


		for (int i=0;i<3;i++) {
			int posicionRulos=0;
			int ranRulo= (int) (Math.random() * 200);
			if(ranRulo<60) {
				posicionRulos=0;
			}
			else if(ranRulo>59 && ranRulo<100) {
				posicionRulos=1;
			}
			else if (ranRulo>99 && ranRulo<135){
				posicionRulos=2;
			}
			else if (ranRulo>134 && ranRulo<160){
				posicionRulos=3;
			}
			else if (ranRulo>159 && ranRulo<175){
				posicionRulos=4;
			}
			else if (ranRulo>174 && ranRulo<186){
				posicionRulos=5;
			}
			else if (ranRulo>185 && ranRulo<192){
				posicionRulos=6;
			}
			else if (ranRulo>191 && ranRulo<197){
				posicionRulos=7;
			}
			else if (ranRulo>196 && ranRulo<200){
				posicionRulos=8;
			}
			else if (ranRulo==200){
				posicionRulos=9;
			}
			else {
				
				posicionRulos=0;
			}

			if (i==0){
				this.posRulo1=posicionRulos;
			}
			else if(i==1) {
				this.posRulo2=posicionRulos;
			}
			else {
				this.posRulo3=posicionRulos;
			}


		}


		comprobarRulos();
	}
	public void comprobarRulos() {
		if(this.posRulo1==this.posRulo2) {
			if(posRulo1==posRulo3) {
				nCoincidencias=3; 
			}
			else {
				nCoincidencias=2;
			}
		}
		else if(posRulo1==posRulo3) {
			nCoincidencias=2;
		}
		else if(posRulo2==posRulo3) {
			nCoincidencias=2;

		}
		else {
			nCoincidencias=0;
		}

		if(nCoincidencias==3) {
			this.ganador=1;
			otorgarPremio();

		}

	}



	public void retencion() {

		if(contRetenciones==0) {
			int posicionRulos=0;
			int ranRulo= (int) (Math.random() * 200);
			if(ranRulo<60) {
				posicionRulos=0;
			}
			else if(ranRulo>59 && ranRulo<100) {
				posicionRulos=1;
			}
			else if (ranRulo>99 && ranRulo<135){
				posicionRulos=2;
			}
			else if (ranRulo>134 && ranRulo<160){
				posicionRulos=3;
			}
			else if (ranRulo>159 && ranRulo<175){
				posicionRulos=4;
			}
			else if (ranRulo>174 && ranRulo<186){
				posicionRulos=5;
			}
			else if (ranRulo>185 && ranRulo<192){
				posicionRulos=6;
			}
			else if (ranRulo>191 && ranRulo<197){
				posicionRulos=7;
			}
			else if (ranRulo>196 && ranRulo<200){
				posicionRulos=8;
			}
			else if (ranRulo==200){
				posicionRulos=9;
			}
			else {
				//error no contemplado nos da por defecto la primera posicion
				posicionRulos=0;
			}
			if(posRulo1==posRulo2) {
				this.posRulo3=posicionRulos;
			}
			else if(posRulo1==posRulo3) {
				this.posRulo2=posicionRulos;

			}
			else if(posRulo2==posRulo3) {
				this.posRulo1=posicionRulos;
			}
			this.contRetenciones++;
			comprobarRulos();
		}
		else {
			this.contRetenciones=0;
			this.nCoincidencias=0;
			tiraPalanca();
		}

	}
	public void otorgarPremio() {
		double valorPremio=0;

		switch (this.posRulo1) {
		case 0: valorPremio=0.40;
		break;
		case 1: valorPremio=0.80;
		break;
		case 2: valorPremio=1.60;
		break;
		case 3: valorPremio=2.40;
		break;
		case 4: valorPremio=3.20;
		break;
		case 5: valorPremio=4.0;
		break;
		case 6: valorPremio=8.0;
		break;
		case 7: valorPremio=14.0;
		break;
		case 8: valorPremio=20.0;
		break;
		case 9: valorPremio=100.0;
		break;
		}
		if (this.valorTirada==3) {
			valorPremio=valorPremio*3;
		}
		else if(this.valorTirada==5){
			valorPremio=valorPremio*5;
		}

		
		gestion.Pulsaciones(ganador, valorPremio);
	}
	public double getValorTirada() {
	
		return valorTirada;
	}
	public int getnCoincidencias() {
		return nCoincidencias;
	}


	public void setnCoincidencias(int nCoincidencias) {
		this.nCoincidencias = nCoincidencias;
	}


	public void setValorTirada(double valorTirada) {
		this.valorTirada = valorTirada;
	}
	public int getGanador() {
		return ganador;
	}


	public int getPosRulo1() {
		return posRulo1;
	}


	public int getPosRulo2() {
		return posRulo2;
	}


	public int getPosRulo3() {
		return posRulo3;
	}

}
