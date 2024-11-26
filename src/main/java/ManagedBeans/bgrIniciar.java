
package ManagedBeans;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import Modelo.*;



@Named(value = "bgrIniciar")
@Dependent

public class bgrIniciar 
{

    private String umidade;
    private String temperatura;
    private String precipitacao;
    private String mensagem;
    private boolean coletaSerial = false;
    private transient Thread threadSerial;
    
    
    @PostConstruct
    public void init() {
        atualizarValores();
    }
    
    public bgrIniciar()
    {

    }
    //private boolean salvarAtivo = false;
    
    public void ativarSalvamento() throws InterruptedException {
    Estaticos.salvarAtivo = true;
    Estaticos.coletaSerial = true; // Ativa a coleta serial

    // Inicia a thread de coleta serial
    Serial serial = new Serial();
    Thread threadSerial = new Thread(serial);
    threadSerial.start();

    Thread.sleep(2000);
    
//    this.umidade = Estaticos.umidade;
//    this.temperatura = Estaticos.temperatura;
//    this.precipitacao = Estaticos.precipitacao;

    // Inicia uma nova thread para o laço de salvamento
    Thread threadSalvamento = new Thread(() -> {
        try {
            while (Estaticos.salvarAtivo) {
                Thread.sleep(60000);
                atualizarValores();
                coletarEDesalvarDados();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread de salvamento interrompida");
        }
    });
    threadSalvamento.start();   
    }
    
    public void pausarSalvamento() {
        Estaticos.salvarAtivo = false;
         Estaticos.coletaSerial = false;
    }
//   
//    public boolean isSalvarAtivo() {
//        return salvarAtivo;
//    }
//    
//    public void setSalvarAtivo(boolean salvarAtivo) {
//        this.salvarAtivo = salvarAtivo;
//    }
//    

    public void coletarEDesalvarDados() {
    
    Controle controle = new Controle();
    controle.cadastrarVariaveis();
    }
    
    
//    public void pausaSalvamento()
//    {
//        
//        Estaticos.salvarAtivo = false;
//         
//    } 
    
    private void atualizarValores() {
        this.umidade = Estaticos.umidade;
        this.temperatura = Estaticos.temperatura;
        this.precipitacao = Estaticos.precipitacao;
    }
    public String getUmidade()
    {
        return umidade;
    }

    public String getTemperatura()
    {
        return temperatura;
    }

    public String getPrecipitacao()
    {
        return precipitacao;
    }

    public boolean isColetaSerial()
    {
        return coletaSerial;
    }

    public Thread getThreadSerial()
    {
        return threadSerial;
    }

    public void setUmidade(String umidade)
    {
        this.umidade = umidade;
    }

    public void setTemperatura(String temperatura)
    {
        this.temperatura = temperatura;
    }

    public void setPrecipitacao(String precipitacao)
    {
        this.precipitacao = precipitacao;
    }

    public void setColetaSerial(boolean coletaSerial)
    {
        this.coletaSerial = coletaSerial;
    }

    public void setThreadSerial(Thread threadSerial)
    {
        this.threadSerial = threadSerial;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }
    
    
    
    

}
    
