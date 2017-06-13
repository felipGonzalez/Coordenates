package UI;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.Coordenate;
import controller.Commands;
import controller.ConstantsDistance;
import controller.DistanceListener;

public class JToolBarDistance extends JToolBar{

	private static JToolBarDistance jToolBarDistance;
	
	private DistanceListener distanceListener;
	protected JPanelDistance jPanelDistance;
	
	public static JToolBarDistance getInstance() {
		if(jToolBarDistance == null){
			jToolBarDistance = new JToolBarDistance();
			return jToolBarDistance;
		}
		else{
			return jToolBarDistance;
		}
	}
	
	
	private JToolBarDistance () {
		super();
		this.distanceListener= DistanceListener.getInstance(); 
		jPanelDistance = new JPanelDistance();
		init();
		
	}

	private void init() {
		this.jPanelDistance.set(distanceListener.getCoordenateOne(), distanceListener.getCoordenateTwo());
		this.add( createButton(Commands.COMMAND_FILE_SAVE));
		this.add(createButton(Commands.COMMAND_FILE_LOAD));
		this.add(createButton(Commands.COMMAND_FILE_EXIT));
		this.add(jPanelDistance);
		
	}
	
	private JButton createButton(Commands commands) {
		JButton jButton = new JButton(commands.getImageIcon());
		jButton.setActionCommand(commands.getCommand());
		jButton.setToolTipText(commands.getHind());
		jButton.addActionListener(distanceListener);
		return jButton;
	}
	
	public void setCoordenates(Coordenate coordenateOne, Coordenate coordenateTwo) {
		jPanelDistance.set(coordenateOne, coordenateTwo);
	}
	
	public JPanelDistance getPaint() {
		return jPanelDistance;
	}
	
	}
