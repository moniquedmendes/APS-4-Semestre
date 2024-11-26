
package DAL;

import org.hibernate.Session;
import org.hibernate.Transaction;
import Modelo.Variaveis;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;


public class VariaveisDAO
{
    public String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public void salvarVariaveis(Variaveis variaveis)
    {
        this.mensagem = "";
        variaveis.setId(null);
        
        try
        {
       
            Transaction transaction = session.beginTransaction();
            session.persist(variaveis);
            transaction.commit();
            
        }
        catch (HibernateException e)
        {
            this.mensagem = "Erro no cadastro " + HibernateUtil.mensagem + e.getMessage();
        }
    }

        

    
    
}
