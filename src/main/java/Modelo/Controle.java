jpackage Modelo;

import DAL.VariaveisDAO;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

public class Controle {
    public String mensagem;
//    public String umidade;
//    public String temperatura;
//    public String precipitacao;
    
    public void cadastrarVariaveis() {
        this.mensagem = "";
        
//        this.umidade = (listaVariaveis.get(1));
//        this.temperatura = (listaVariaveis.get(2));
//        this.precipitacao = (listaVariaveis.get(3));

        // Criação e execução da validação
        Validacao validacao = new Validacao();  
        validacao.validarVariaveis();  
        

        if (this.mensagem.equals("")) {
            Variaveis variaveis = new Variaveis();
            variaveis.setUmidade(validacao.umidadenum);
            variaveis.setTemperatura(validacao.temperaturanum);
            variaveis.setPrecipitacao(validacao.precipitacaonum);


            VariaveisDAO variaveisDAO = new VariaveisDAO();
            variaveisDAO.salvarVariaveis(variaveis);
            this.mensagem = variaveisDAO.mensagem;
        }
    }


}