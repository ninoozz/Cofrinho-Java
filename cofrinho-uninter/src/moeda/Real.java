package moeda;

public class Real extends Moeda{


    public Real(double valor) {
        super(valor);
        this.cotacao = 1.0;
        //cotacao recebe 1.0 pois é a moeda base para atribuir as outras cotações
    }

    @Override
    public double converter() {
        //conversão para real baseado no atributo cotacao, implementado igualmente nas
        // outras moedas
        return this.valor * this.cotacao;
    }
}
