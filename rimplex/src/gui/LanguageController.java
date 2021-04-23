// package gui;
//
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.Locale;
// import java.util.ResourceBundle;
//
// import javax.swing.JMenuItem;
//
// public class LanguageController implements ActionListener, Finals
// {
//
// @Override
// public void actionPerformed(ActionEvent e)
// {
// NewMainInterface ui = NewMainInterface.getInstance();
//
// if (e.getSource() instanceof JMenuItem)
// {
// JMenuItem item = (JMenuItem) e.getSource();
// switch (item.getText())
// {
// case ENG:
// ui.STRINGS = ResourceBundle.getBundle("gui.Strings");
// break;
// case FRE:
// ui.STRINGS = ResourceBundle.getBundle("gui.Strings_fr_FR");
// break;
// case GER:
// break;
// default:
// ui.STRINGS = ResourceBundle.getBundle("gui.Strings");
// break;
// }
// }
// // TODO Auto-generated method stub
//
// }
//
// }
