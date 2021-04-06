package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class NewMainInterface extends JFrame implements Finals
{
  private static final long serialVersionUID = 5691196863267451960L;

  private InterfaceController listener;
  private JPanel northPanel;
  private JPanel eastPanel;
  private JPanel centerPanel;

  /**
   * Default constructor.
   */
  public NewMainInterface()
  {
    createComponents();
    setupFrame();
    setSize(400, 500);
    setTitle("Rimplex");
    setVisible(true); // display this
    centerForm();

  }

  private void centerForm()
  {
    Dimension dimScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dimFrameSize = getSize();

    if (dimFrameSize.height > dimScreenSize.height)
    {
      dimFrameSize.height = dimScreenSize.height;
    }
    if (dimFrameSize.width > dimScreenSize.width)
    {
      dimFrameSize.width = dimScreenSize.width;
    }

    setLocation((dimScreenSize.width - dimFrameSize.width) / 2,
        (dimScreenSize.height - dimFrameSize.height) / 2);
  }

  private void setupFrame()
  {
    Container contentPane = getContentPane();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    listener = new InterfaceController();

    contentPane.setLayout(new BorderLayout());

    setupNorthPanel();
    setupCenterPanel();
    setUpEastPanel();

    contentPane.add(centerPanel, BorderLayout.CENTER);
    contentPane.add(eastPanel, BorderLayout.EAST);
  }

  private void setUpEastPanel()
  {
    eastPanel = new JPanel(new GridLayout(5, 2));

    for (String function : FUNCTIONS)
    {
      JButton btn = new JButton(function);
      btn.setForeground(Color.BLUE);
      btn.addActionListener(listener);
      eastPanel.add(btn);
    }
  }

  private void setupCenterPanel()
  {
    centerPanel = new JPanel(new GridLayout(5, 3));

    JButton sign = new JButton(SIGN);
    JButton clearBtn = new JButton(CLEAR);
    JButton backBtn = new JButton(BACKSPACE);

    ArrayList<JButton> btns = new ArrayList<>();
    btns.add(sign);
    btns.add(clearBtn);
    btns.add(backBtn);

    for (JButton btn : btns)
    {
      btn.addActionListener(listener);
      btn.setForeground(Color.MAGENTA);
      centerPanel.add(btn);
    }

    for (int i = 1; i < 10; i++)
    {
      JButton btn = new JButton(String.valueOf(i));
      centerPanel.add(btn);
      btn.addActionListener(listener);
      centerPanel.add(btn);
    }

    centerPanel.add(new JPanel());

    JButton zeroBtn = new JButton("0");
    zeroBtn.addActionListener(listener);
    centerPanel.add(zeroBtn);

    JButton imagBtn = new JButton("i");
    imagBtn.addActionListener(listener);
    centerPanel.add(imagBtn);
  }

  /**
   * Corwin adds the north items.
   */
  private void setupNorthPanel()
  {
    northPanel = new JPanel();
  }

  private void createComponents()
  {
    // TODO Auto-generated method stub

  }
}
