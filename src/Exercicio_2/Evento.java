package Exercicio_2;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Represents an event that participants can register for.
 * Each event has a name, date, location, and a list of registrations (inscricoes).
 */
@Entity
@Table(name = "tb_eventos")
public class Evento {

    /**
     * Unique identifier for the event.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the event.
     */
    private String nome;

    /**
     * Date and time when the event will take place.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    /**
     * Location where the event will be held.
     */
    private String local;

    /**
     * List of registrations (inscricoes) associated with this event.
     * One event can have many registrations.
     */
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscricao> inscricoes;

    /**
     * Default constructor.
     */
    public Evento() {
    }

    /**
     * Constructs an event with the specified name, date, and location.
     * @param nome Name of the event
     * @param data Date and time of the event
     * @param local Location of the event
     */
    public Evento(String nome, Date data, String local) {
        this.nome = nome;
        this.data = data;
        this.local = local;
    }

    /**
     * Constructs an event with the specified id, name, date, and location.
     * @param id Unique identifier
     * @param nome Name of the event
     * @param data Date and time of the event
     * @param local Location of the event
     */
    public Evento(Long id, String nome, Date data, String local) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.local = local;
    }

    /**
     * Gets the unique identifier of the event.
     * @return id of the event
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the event.
     * @param id id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the event.
     * @return name of the event
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the event.
     * @param nome name to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the date and time of the event.
     * @return date of the event
     */
    public Date getData() {
        return data;
    }

    /**
     * Sets the date and time of the event.
     * @param data date to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Gets the location of the event.
     * @return location of the event
     */
    public String getLocal() {
        return local;
    }

    /**
     * Sets the location of the event.
     * @param local location to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * Gets the list of registrations for this event.
     * @return list of registrations
     */
    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    /**
     * Sets the list of registrations for this event.
     * @param inscricoes list of registrations to set
     */
    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}