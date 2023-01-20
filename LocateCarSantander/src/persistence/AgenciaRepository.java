package persistence;

import model.Agencia;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AgenciaRepository {
        private List<Agencia> agencia;

        public AgenciaRepository(){
            this.agencia = new ArrayList<Agencia>();
        }

        public void cadastrar(Agencia agencia){
            this.agencia.add(agencia);
        }

    public List<Agencia> buscar(String palavraBuscada) {
        return this.agencia.stream()
                .filter(agencia -> {
                    return agencia.getNome().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }


    private void collect(Collector<Object, ?, List<Object>> toList) {

    }

};

      /*  public List<Agencia> buscar(String palavraBuscada) {
            return this.veiculos.stream()
                    .filter(agencia -> {
                        return agencia.getModelo().toUpperCase().contains(palavraBuscada.toUpperCase()) ||
                                agencia.getPlaca().toUpperCase().contains(palavraBuscada.toUpperCase());
                    })
                    .collect(Collectors.toList());
        }*/


