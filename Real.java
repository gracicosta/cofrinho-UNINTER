
public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.println("Real " + valor);
    }

    @Override
    public double converter() {
        return valor;
    }
}