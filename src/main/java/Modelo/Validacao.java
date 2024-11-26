package Modelo;

import java.util.List;

public class Validacao {
    public String mensagem;
    
    public double umidadenum;
    public double temperaturanum;
    public double precipitacaonum;
    
    public void validarVariaveis() {
        try {
            this.umidadenum = Double.parseDouble(Estaticos.umidade);
            this.temperaturanum = Double.parseDouble(Estaticos.temperatura);
            this.precipitacaonum = Double.parseDouble(Estaticos.precipitacao);
        } catch (Exception e) {
            this.mensagem = "Números inválidos";
        }
    }
}