package moeda;

public class Dolar extends Moeda{
    public Dolar(double valor) {
        super(valor);
        this.cotacao = 5.5;
    }

    @Override
    public double converter() {
        //conversão para real baseado no atributo cotacao
        return this.valor * this.cotacao;
    }
}
