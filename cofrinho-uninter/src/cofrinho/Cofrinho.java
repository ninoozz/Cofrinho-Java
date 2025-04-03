package cofrinho;

import moeda.Euro;
import moeda.Moeda;
import moeda.Real;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    //Classe de dados singleton
    private static Cofrinho instancia = null;
    private final ArrayList<Moeda> listaMoedas;

    private Cofrinho(){
        listaMoedas = new ArrayList<Moeda>();
    }

    public static Cofrinho getInstancia() {
        if (instancia == null)
            instancia = new Cofrinho();
        return instancia;
    }

    public void adicionar(Moeda moeda){
        this.listaMoedas.add(moeda);
        System.out.println("Valor adicionado!\n");
    }

    public void remover(Moeda moeda){

        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho de moedas está vazio\n");
        }else {
            //Verifico a ultima ocorrência do valor da moeda recebida no parâmetro da
            //função tratando elas como se fossem uma pilha,
            //removendo apenas a última ocorrência no cofre

            int ultimaOcorrencia = -1;
            //-1 é o valor padrão para quando a moeda não existe no cofre

            for (int i = 0; i < listaMoedas.size(); i++) {

                Moeda valorMoedaLista = listaMoedas.get(i);

                if (valorMoedaLista.info() == moeda.info() && valorMoedaLista.getClass().equals(moeda.getClass())) {
                    //O valor e classe da moeda deve ser o mesmo para ser classificado
                    // como uma ocorrência
                    ultimaOcorrencia = i;
                }
            }

            if (ultimaOcorrencia == -1) {
                System.out.println("Não existe nenhuma moeda com este valor no cofre");
            }else{
                listaMoedas.remove(ultimaOcorrencia);
                System.out.println("\nMoeda removida!\n");
            }
        }
    }

    public ArrayList<String> listagemMoedas(){
        ArrayList<String> listaMoedasEmString = new ArrayList<String>();
        if (!listaMoedas.isEmpty()){
            for(Moeda moeda: listaMoedas){
                listaMoedasEmString.add(moeda.getClass().getName().replace("moeda.","") + " :" +
                        " " + moeda.info());
            }
        }else {
            listaMoedasEmString.add("A lista está vazia, por favor, adicione moedas\n");
        }
        return listaMoedasEmString;
    }

    public double totalConvertido(){

        double totalConvertido = 0;

        for (Moeda moeda : listaMoedas) totalConvertido += moeda.converter();

        return totalConvertido;
    }
}