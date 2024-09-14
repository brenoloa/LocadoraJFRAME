public class Frota {
    private String modelo;
    private String marca;
    private String placa;
    private int Ano;
    private double km;
    private boolean disponivel;
    public Frota(String modelo, String marca, String placa, int ano, double km) {
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        Ano = ano;
        this.km = km;
        this.disponivel = true;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getAno() {
        return Ano;
    }
    public void setAno(int ano) {
        Ano = ano;
    }
    public double getKm() {
        return km;
    }
    public void setKm(double km) {
        this.km = km;
    }
    public boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    
}
