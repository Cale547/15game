import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Presenter {
	JFrame frame;
	TextField txt = new TextField(50);

	public abstract JComponent createCenterComponent();

	public abstract void northButtonPressed();

	public abstract void eastButtonPressed();

	public abstract void southButtonPressed();

	public abstract void westButtonPressed();

	public Presenter() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1200, 800);
		// setup layout manager for frame
		frame.setLayout(new BorderLayout());

		JButton northButton = new JButton("North");
		JButton eastButton = new JButton("East");
		JButton southButton = new JButton("South");
		JButton westButton = new JButton("West");

		northButton.addActionListener(event->northButtonPressed());		
		eastButton.addActionListener(event->eastButtonPressed());		
		southButton.addActionListener(event->southButtonPressed());		
		westButton.addActionListener(event->westButtonPressed());		

		// add northButton to a JPanel, add that lpanel to frame
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BorderLayout());
		buttonPane.add(northButton, BorderLayout.NORTH);
		buttonPane.add(eastButton, BorderLayout.EAST);
		buttonPane.add(southButton, BorderLayout.SOUTH);
		buttonPane.add(westButton, BorderLayout.WEST);

		// create other components (text component, e.g.), add them to frame
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		pane.add(buttonPane, BorderLayout.WEST);		
		pane.add(txt, BorderLayout.EAST);
		frame.add(pane, BorderLayout.SOUTH);

		JComponent centerComponent = createCenterComponent();
		// add centerComponent to frame
		frame.add(centerComponent, BorderLayout.CENTER);
		// show frame	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
	}

	public void showText(String text) {
		// update the text component
		txt.setText(text);
	}

	public JFrame getFrame() {
		return frame;
	}
}
