package Exercicio_2;

import javax.persistence.*;
import java.util.Date;

/**
 * Represents a registration (inscricao) of a participant for an event.
 * Each registration has a date, a confirmation status, and is linked to one event and one participant.
 */
@Entity
@Table(name = "tb_inscricoes")
public class Inscricao {

    /**
     * Unique identifier for the registration.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date and time when the registration was made.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInscricao;

    /**
     * Indicates whether the registration is confirmed.
     */
    private boolean confirmada;

    /**
     * The event associated with this registration.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    /**
     * The participant associated with this registration.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participante_id", nullable = false)
    private Participante participante;

    /**
     * Default constructor.
     */
    public Inscricao() {
    }

    /**
     * Constructs a registration with the specified date, confirmation status, event, and participant.
     * @param dataInscricao Date and time of registration
     * @param confirmada Whether the registration is confirmed
     * @param evento Event associated with the registration
     * @param participante Participant associated with the registration
     */
    public Inscricao(Date dataInscricao, boolean confirmada, Evento evento, Participante participante) {
        this.dataInscricao = dataInscricao;
        this.confirmada = confirmada;
        this.evento = evento;
        this.participante = participante;
    }

    /**
     * Gets the unique identifier of the registration.
     * @return id of the registration
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the registration.
     * @param id id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the date and time of the registration.
     * @return date of registration
     */
    public Date getDataInscricao() {
        return dataInscricao;
    }

    /**
     * Sets the date and time of the registration.
     * @param dataInscricao date to set
     */
    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    /**
     * Checks if the registration is confirmed.
     * @return true if confirmed, false otherwise
     */
    public boolean isConfirmada() {
        return confirmada;
    }

    /**
     * Sets the confirmation status of the registration.
     * @param confirmada confirmation status to set
     */
    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    /**
     * Gets the event associated with this registration.
     * @return event of the registration
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Sets the event associated with this registration.
     * @param evento event to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * Gets the participant associated with this registration.
     * @return participant of the registration
     */
    public Participante getParticipante() {
        return participante;
    }

    /**
     * Sets the participant associated with this registration.
     * @param participante participant to set
     */
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}