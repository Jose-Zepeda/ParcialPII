package org.example;

public class Telefono {
    // Propiedades básicas de un teléfono
    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private double tamanoPantalla;
    private int memoriaRAM;
    private int almacenamientoInterno;
    private boolean tieneCamara;
    private int resolucionCamara;
    private boolean esSmartphone;
    private String imei;

    // Constructor
    public Telefono(String marca, String modelo, String sistemaOperativo, double tamanoPantalla, int memoriaRAM, int almacenamientoInterno, boolean tieneCamara, int resolucionCamara, boolean esSmartphone, String imei) {
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.tamanoPantalla = tamanoPantalla;
        this.memoriaRAM = memoriaRAM;
        this.almacenamientoInterno = almacenamientoInterno;
        this.tieneCamara = tieneCamara;
        this.resolucionCamara = resolucionCamara;
        this.esSmartphone = esSmartphone;
        this.imei = imei;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getTamanoPantalla() {
        return tamanoPantalla;
    }

    public void setTamanoPantalla(double tamanoPantalla) {
        this.tamanoPantalla = tamanoPantalla;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public int getAlmacenamientoInterno() {
        return almacenamientoInterno;
    }

    public void setAlmacenamientoInterno(int almacenamientoInterno) {
        this.almacenamientoInterno = almacenamientoInterno;
    }

    public boolean isTieneCamara() {
        return tieneCamara;
    }

    public void setTieneCamara(boolean tieneCamara) {
        this.tieneCamara = tieneCamara;
    }

    public int getResolucionCamara() {
        return resolucionCamara;
    }

    public void setResolucionCamara(int resolucionCamara) {
        this.resolucionCamara = resolucionCamara;
    }

    public boolean isEsSmartphone() {
        return esSmartphone;
    }

    public void setEsSmartphone(boolean esSmartphone) {
        this.esSmartphone = esSmartphone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
