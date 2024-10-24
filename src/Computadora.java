public class Computadora {
    private String marca;
    private String modelo;
    private Long codigoBarras;
    private Double precioTotal;
    private Double porcentajeAumento;
    private Double montoFinal;
    private String[][] componentes;

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

    public Long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(Double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponentes(String[][] componentes) {
        this.componentes = componentes;
    }

    // Metodo para inicializar componentes
    public void inicializarComponentes(int cantidadComponentes) {
        // Inicializamos la matriz de componentes con la cantidad de filas y 4 columnas
        componentes = new String[cantidadComponentes][4];
    }

    // Metodo para agregar un componente en la posición 'i' del array de componentes
    public void agregarComponente(String[] componente, int i) {
        if (i >= 0 && i < componentes.length) {
            componentes[i] = componente;
        } else {
            System.out.println("Índice fuera de los límites del array de componentes");
        }
    }
}