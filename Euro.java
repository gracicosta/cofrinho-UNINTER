public class Euro extends Moeda {

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Euro " + valor);
    }

    @Override
    public double converter() {
        return valor * 6.19; 
    }
}