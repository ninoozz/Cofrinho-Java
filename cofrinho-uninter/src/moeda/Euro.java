package moeda;

public class Euro extends Moeda{
    public Euro(double valor) {
        super(valor);
        this.cotacao = 4.5;
    }

    @Override
    public double converter() {
        //conversão para real baseado no atributo cotacao
        return this.valor * this.cotacao;
    }
}
