package UI;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Commands;
import controller.ConstantsDistance;
import controller.DistanceListener;

import java.awt.Font;

import javax.swing.JMenu;

public class JMenuBarDistance extends JMenuBar{
	/**
	 * configuraciones o seting( Colores, Idioma, )
	 * help, about
	 * File--- almacenar .... leer (percistencia)
	 * clear
	 * 
	 */
	private JMenu jMenuFile;
	private JMenu jMenuOption;
	private static JMenuBarDistance jMenuBarDistance;
	
	private JMenuBarDistance() {
		System.out.println("entro1");
		init();
	}
	
	public static JMenuBarDistance getInstance(){
		if(jMenuBarDistance == null){
			return jMenuBarDistance = new JMenuBarDistance();
		}
		return jMenuBarDistance;
	}
	
	private void init() {
		jMenuFile = new JMenu(Commands.COMMAND_FILE.getTitle());
		jMenuOption = new JMenu(Commands.COMMAND_OPTION.getTitle());
		this.add(jMenuFile);
		this.add(jMenuOption);
		jMenuFile.add(new JMenuItem(Commands.COMMAND_FILE_SAVE.getTitle()));
		jMenuFile.add(new JMenuItem(Commands.COMMAND_FILE_LOAD.getTitle()));
		jMenuFile.addSeparator();
		jMenuFile.add(new JMenuItem(Commands.COMMAND_FILE_EXIT.getTitle()));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_SHOW_POINT));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_COLOR_FONT));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_COLOR_LINE));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_COLOR_POINT));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_SET_NUM_DECIMAL));
		jMenuOption.add(getItem(Commands.COMMAND_OPTION_SET_FONT));
		
	}
	
	public JMenuItem getItem(Commands commands){
		JMenuItem item = new JMenuItem(commands.getTitle());
		item.setActionCommand(commands.getCommand());
		item.setToolTipText(commands.getHind());
		item.addActionListener(DistanceListener.getInstance());
		return item;
	}
	
	public void setFontJMenu(Font font) {
		jMenuFile.setFont(font);
		jMenuOption.setFont(font);
		for (int i = 0; i < jMenuFile.getItemCount(); i++) {
			if(jMenuFile.getItem(i) != null){
				jMenuFile.getItem(i).setFont(font);
			}
			
		}
		
		for (int i = 0; i < jMenuOption.getItemCount(); i++) {
			if(jMenuOption.getItem(i) != null) {
				jMenuOption.getItem(i).setFont(font);
			}
			
		}
	}
	
	}
