package moeda;


public abstract class Moeda {

    //adicionei o atributo cotacao para atribuílos nas classes filhas
    protected double cotacao;
    protected final double valor;

    Moeda(double valor){
        this.valor = valor;
    };

    public double info(){
        return this.valor;
    }

    public abstract double converter();
}
