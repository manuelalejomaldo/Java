package ca.csf.dfc.reservation;

public abstract class Ressource {
	private int m_identifiant;
	
	public Ressource(int p_identifiant) {
		this.m_identifiant = p_identifiant;
	}
	
	public boolean estDuType(String p_type) {
		String nomClasse = this.getClass().getSimpleName();
		
		return nomClasse.compareToIgnoreCase(p_type) == 0;
	}
	
	public int getIdentifiant() {
		return this.m_identifiant;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getClass().getSimpleName());
		sb.append("(identifiant: ");
		sb.append(this.getIdentifiant());
		sb.append(")");
		
		return sb.toString();
	}
}
