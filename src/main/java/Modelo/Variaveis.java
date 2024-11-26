/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Entity
@Table(name = "Variaveis")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Variaveis.findAll", query = "SELECT v FROM Variaveis v"),
    @NamedQuery(name = "Variaveis.findById", query = "SELECT v FROM Variaveis v WHERE v.id = :id"),
    @NamedQuery(name = "Variaveis.findByUmidade", query = "SELECT v FROM Variaveis v WHERE v.umidade = :umidade"),
    @NamedQuery(name = "Variaveis.findByTemperatura", query = "SELECT v FROM Variaveis v WHERE v.temperatura = :temperatura"),
    @NamedQuery(name = "Variaveis.findByPrecipitacao", query = "SELECT v FROM Variaveis v WHERE v.precipitacao = :precipitacao")
})
public class Variaveis implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "umidade")
    private double umidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperatura")
    private double temperatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precipitacao")
    private double precipitacao;

    public Variaveis()
    {
    }

    public Variaveis(Integer id)
    {
        this.id = id;
    }

    public Variaveis(Integer id, double umidade, double temperatura, double precipitacao)
    {
        this.id = id;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public double getUmidade()
    {
        return umidade;
    }

    public void setUmidade(double umidade)
    {
        this.umidade = umidade;
    }

    public double getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(double temperatura)
    {
        this.temperatura = temperatura;
    }

    public double getPrecipitacao()
    {
        return precipitacao;
    }

    public void setPrecipitacao(double precipitacao)
    {
        this.precipitacao = precipitacao;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variaveis))
        {
            return false;
        }
        Variaveis other = (Variaveis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Modelo.Variaveis[ id=" + id + " ]";
    }
    
}
