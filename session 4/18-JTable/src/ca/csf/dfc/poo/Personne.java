package ca.csf.dfc.poo;

/**
 * Classe representant une personne, avec son nom et son âge.
 * 
 * @author nrichard
 */
public class Personne implements Comparable<Personne>
{

    /**
     * age minimal d'une personne.
     */
	public final static int AGE_MIN = 0;

    /**
     * Le nom de la personne.
     */
    private String m_Nom;

    /**
     * L'age de la personne.
     */
    private int m_age;

    /**
     * Etat civil d'une personne.
     */
    private EtatCivil m_Etat;

    /**
     * Constructeur par defaut. Met un nom vide et l'âge à zero.
     */
    public Personne()
    {
        this("", 0, EtatCivil.CELIBATAIRE);
    }

    /**
     * Constructeur d'initialisation.
     * 
     * @param p_Nom
     *            Nom de la personne
     * @param p_Age
     *            age de la personne
     * @param p_Etat
     *            Etat civiel
     */
    public Personne(String p_Nom, int p_Age, EtatCivil p_Etat)
    {
        this.setNom(p_Nom);
        this.setAge(p_Age);
        this.setEtat(p_Etat);
    }

    /**
     * Construit une copie de p_Autre.
     * 
     * @param p_Autre
     *            Personne à copier
     * @throws NullPointerException
     *             Paramètre nul.
     */
    public Personne(Personne p_Autre)
    {
        if (p_Autre == null) { throw new NullPointerException(); }

        this.setNom(p_Autre.getNom());
        this.setAge(p_Autre.getAge());
        this.setEtat(p_Autre.getEtat());
    }

    /**
     * Retourne l'etat.
     * 
     * @return l'etat
     */
    public EtatCivil getEtat()
    {
        return this.m_Etat;
    }

    /**
     * Pour modifier l'etat.
     * 
     * @param p_etat
     *            Nouvelle valeur.
     */
    public void setEtat(EtatCivil p_etat)
    {
        if (p_etat == null) { throw new NullPointerException("L'etat ne doit pas être null"); }
        this.m_Etat = p_etat;
    }

    /**
     * Retourne le nom.
     * 
     * @return le nom
     */
    public String getNom()
    {
        return this.m_Nom;
    }

    /**
     * Pour modifier le nom.
     * 
     * @param p_Nom
     *            Nouvelle valeur.
     */
    public void setNom(String p_Nom)
    {
        if (p_Nom == null) { throw new NullPointerException("Nom nul !"); }
        this.m_Nom = p_Nom;
    }

    /**
     * Retourne l'âge.
     * 
     * @return l'âge
     */
    public int getAge()
    {
        return this.m_age;
    }

    /**
     * Pour modifier l'âge.
     * 
     * @param p_age
     *            Nouvelle valeur.
     * @throws IllegalArgumentException
     *             Si p_age < aGE_MIN.
     */
    public void setAge(int p_age)
    {
        if (p_age < AGE_MIN) { throw new IllegalArgumentException("L'âge " + p_age + " doit être >= " + AGE_MIN); }
        this.m_age = p_age;
    }

    /**
     * Redefinition.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Personne [m_Nom=" + this.m_Nom + ", m_age=" + this.m_age + ", m_Etat=" + this.m_Etat + "]";
    }

    /**
     * Pour se presenter en tant que personne.
     * 
     * @return Un message de presentation.
     */
    public String sePresenter()
    {
        return "Bonjour, je m'appelle " + this.m_Nom +", je suis "+this.getEtat()+ " et j'ai " + this.m_age + " an(s)";
    }

    /**
     * Compare le contenu des Personne pour determiner l'egalite. Redefinition.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object p_Obj)
    {
        boolean egaux = false;

        if (p_Obj instanceof Personne)
        {

            Personne p = (Personne) p_Obj;

            egaux = this.getNom().equals(p.getNom()) && (this.getAge() == p.getAge())
                    && this.getEtat().equals(p.getEtat());
        }

        return egaux;
    }

    /**
     * Compare deux Personnes d'après l'âge.
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Personne p_Autre)
    {

        Integer âge = this.getAge();
        return âge.compareTo(p_Autre.getAge());
    }
}
