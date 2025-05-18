package Exercicio_2;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a participant who can register for events.
 * Each participant has a name, a unique email, and a list of registrations (inscricoes).
 */
@Entity
@Table(name = "tb_participantes")
public class Participante {

    /**
     * Unique identifier for the participant.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the participant.
     */
    private String nome;

    /**
     * Unique email address of the participant.
     */
    @Column(unique = true)
    private String email;

    /**
     * List of registrations (inscricoes) associated with this participant.
     * One participant can have many registrations.
     */
    @OneToMany(mappedBy = "participante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscricao> inscricoes;

    /**
     * Default constructor.
     */
    public Participante() {
    }

    /**
     * Constructs a participant with the specified name and email.
     * @param nome Name of the participant
     * @param email Email address of the participant
     */
    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Gets the unique identifier of the participant.
     * @return id of the participant
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the participant.
     * @param id id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the participant.
     * @return name of the participant
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the name of the participant.
     * @param nome name to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the email address of the participant.
     * @return email of the participant
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the participant.
     * @param email email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the list of registrations for this participant.
     * @return list of registrations
     */
    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    /**
     * Sets the list of registrations for this participant.
     * @param inscricoes list of registrations to set
     */
    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }
}