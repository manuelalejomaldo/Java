/**
 * 
 */
package ca.csf.dfc.poo.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import ca.csf.dfc.poo.Personne;

import ca.csf.dfc.poo.EtatCivil;

/**
 * @author nrichard
 */
public class DemoJTablePersonnes extends JFrame {
	private static final long serialVersionUID = 1L;

	ModeleDeTable m_Modele = new ModeleDeTable();
	JTable m_Table = new JTable(m_Modele);
	JLabel lbl_Msg1 = new JLabel("");

	/**
	 * Constructeur
	 */
	public DemoJTablePersonnes() {
		
		super("Demo JTable avec un modele");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// Dans le constructeur
        // Cr�ation d'une instance de ma classe d'�coute
        //GestClickSouris gestClickSouris = new GestClickSouris();
        // Ajout � la liste d'�coute du JFrame
        //this.addMouseListener(gestClickSouris);
        

		this.m_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btn_Ajouter = new JButton("Ajouter");
		btn_Ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent p_e) {
				m_Modele.ajouter(new Personne("Nouv", 33, EtatCivil.SEPARE));

			}
		});
		
		JButton btn_Remover = new JButton("Remover");
		btn_Remover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent p_e) {
				m_Modele.remover(0);//remove la premier line

			}
		});

		this.add(btn_Ajouter, BorderLayout.NORTH);
		this.add(btn_Remover, BorderLayout.SOUTH);
		this.add(new JScrollPane(m_Table), BorderLayout.CENTER);
		//this.add(lbl_Msg1,BorderLayout.SOUTH);

		//this.setSize(500, 300);
		this.pack();
		this.setLocationRelativeTo(null);

		chargerModele();

		this.m_Table.addMouseListener(new GestDoubleClick());//
	}

	/**
	 * 
	 */
	private void chargerModele() {
		// Obtenu a� partir d'un fichier ou d'une BD ...
		Personne[] tab = { new Personne("Therese", 33, EtatCivil.SEPARE), new Personne("Bob", 45, EtatCivil.MARIE),
				new Personne("Bobby", 12, EtatCivil.CELIBATAIRE), new Personne("Agnes", 49, EtatCivil.VEUF),
				new Personne("Charlotte", 33, EtatCivil.CONJOINT_DE_FAIT),
				new Personne("Therese", 33, EtatCivil.SEPARE), new Personne("Bob", 45, EtatCivil.MARIE),
				new Personne("Bobby", 12, EtatCivil.CELIBATAIRE), new Personne("Agnes", 49, EtatCivil.VEUF),
				new Personne("Charlotte", 33, EtatCivil.CONJOINT_DE_FAIT),
				new Personne("Therese", 33, EtatCivil.SEPARE), new Personne("Bob", 45, EtatCivil.MARIE),
				new Personne("Bobby", 12, EtatCivil.CELIBATAIRE), new Personne("Agnes", 49, EtatCivil.VEUF),
				new Personne("Charlotte", 33, EtatCivil.CONJOINT_DE_FAIT),
				new Personne("Therese", 33, EtatCivil.SEPARE), new Personne("Bob", 45, EtatCivil.MARIE),
				new Personne("Bobby", 12, EtatCivil.CELIBATAIRE), new Personne("Agnes", 49, EtatCivil.VEUF),
				new Personne("Charlotte", 33, EtatCivil.CONJOINT_DE_FAIT), };

		for (Personne p : tab) {
			this.m_Modele.ajouter(p);
		}

	}

	/**
	 * Gestionnaire du double-clique sur la table.
	 * 
	 * @author nrichard
	 */
	private class GestDoubleClick implements MouseListener {

		/**
		 * Redefinition.
		 * 
		 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
		 */
		@Override
		public void mouseClicked(MouseEvent p_e) {
			
			//int indice = m_Table.getSelectedRow();
			if (p_e.getClickCount() == 2) {
				int indice = m_Table.getSelectedRow();
				if (indice >= 0) {
					Personne p = m_Modele.getPersonne(indice);
					//JOptionPane.showMessageDialog(DemoJTablePersonnes.this,"L'ndex selection�e est :" + indice);
					JOptionPane.showMessageDialog(DemoJTablePersonnes.this, p.sePresenter());
					//JOptionPane.showMessageDialog(DemoJTable.this, p.sePresenter());
					lbl_Msg1.setText(p.sePresenter());
					
				}
			} //*//
			

		}

		@Override
		public void mousePressed(MouseEvent p_e) {
		}

		@Override
		public void mouseReleased(MouseEvent p_e) {
		}

		@Override
		public void mouseEntered(MouseEvent p_e) {
		}

		@Override
		public void mouseExited(MouseEvent p_e) {
		}

	}

}
