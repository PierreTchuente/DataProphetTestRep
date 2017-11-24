/**
 * 
 */
package stopai.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @author TCHUENTE
 *
 */
/**
 * @author TCHUENTE
 *
 */
public class MainFrame extends JFrame {

	private final int MAX_NUMBER_TESTCASE = 5;
	private final int MIN_NUMBER_TESTCASE = 1;

	private final int MIN_NUMBER_AI = 3;
	private final int MAX_NUMBER_AI = 40;

	private final int MIN_NUMBER_CHANELS = 1;
	private int maxNumberofChanels = 0; // this max depend on the number of AI.

	private final int LINE = 1;
	private final int CIRCLE = 2;

	private JLabel testCaselabel = new JLabel("Num of Test Case");
	private JTextField txtTestCase = new JTextField(8);

	private JLabel numAilabel = new JLabel("Num of Ai");
	private JTextField txtnumAi = new JTextField(8);

	private JLabel numComChanels = new JLabel("Num of Communication Chanels");
	private JTextField txtnumComChanels = new JTextField(8);

	private JButton btnCapture = new JButton("Start The Program");

	private JPanel panelNorh = new JPanel();
	private JPanel panelSouth = new JPanel();

	/**
	 * @param title
	 */
	public MainFrame(String title) {
		setTitle(title);
		// FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 20);
		// setLayout(flowLayout);

		BorderLayout borderlayout = new BorderLayout(0, 0);
		setLayout(borderlayout);
		panelNorh.setBorder(new LineBorder(Color.BLACK));
		panelSouth.setBorder(new LineBorder(Color.BLUE, 2, true));

		panelNorh.setLayout(new FlowLayout(FlowLayout.LEFT));
		/*
		 * panelNorh.add(testCaselabel); panelNorh.add(txtTestCase);
		 * 
		 * panelNorh.add(numAilabel); panelNorh.add(txtnumAi);
		 * 
		 * panelNorh.add(numComChanels); panelNorh.add(txtnumComChanels);
		 */

		panelNorh.add(btnCapture);

		add(panelNorh, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.CENTER);

		/*
		 * GridLayout gridLayout = new GridLayout(2, 3, 20, 20);
		 * setLayout(gridLayout); Add labels and text fields to the frame
		 */

		/*
		 * JLabel("jth Relation")); add(new JTextField(8));
		 */

		setSize(800, 700); // Set the frame size
		setLocationRelativeTo(null);// Center a frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // Display the frame

		btnCapture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				int numberCase = 0;
				int numberofAi = 0;
				int numberofChannels = 0;

				// Code to handle the number of test case.
				numberCase = Integer.parseInt(JOptionPane.showInputDialog(
						"Please Provide the number of test case between "
								+ MIN_NUMBER_TESTCASE + " and "
								+ MAX_NUMBER_TESTCASE, MIN_NUMBER_TESTCASE));
				if (numberCase == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null,
							"You have decided to exit the Program. Good Bey!!");
					System.exit(0);
				}

				while (numberCase < MIN_NUMBER_TESTCASE
						|| numberCase > MAX_NUMBER_TESTCASE) {
					JOptionPane.showMessageDialog(null,
							"Value must be between " + MIN_NUMBER_TESTCASE
									+ " and " + MAX_NUMBER_TESTCASE);
					numberCase = Integer.parseInt(JOptionPane.showInputDialog(
							"Please Provide the number of test case between "
									+ MIN_NUMBER_TESTCASE + " and "
									+ MAX_NUMBER_TESTCASE, MIN_NUMBER_TESTCASE));
				}

				// Code to handle the number of AI
				numberofAi = Integer.parseInt(JOptionPane.showInputDialog(
						"Please Provide the number of AI between "
								+ MIN_NUMBER_AI + " and " + MAX_NUMBER_AI,
						MIN_NUMBER_AI));
				while (numberofAi < MIN_NUMBER_AI || numberofAi > MAX_NUMBER_AI) {
					JOptionPane.showMessageDialog(null,
							"Value must be between " + MIN_NUMBER_AI + " and "
									+ MAX_NUMBER_AI);
					numberofAi = Integer.parseInt(JOptionPane.showInputDialog(
							"Please Provide the number of AI between "
									+ MIN_NUMBER_AI + " and " + MAX_NUMBER_AI,
							MIN_NUMBER_AI));
				}

				maxNumberofChanels = ((numberofAi * (numberofAi - 1)) / 2 - 1);
				numberofChannels = Integer.parseInt(JOptionPane
						.showInputDialog(
								"Please Provide the number of Comminication chanels between "
										+ MIN_NUMBER_CHANELS + " and "
										+ maxNumberofChanels,
								MIN_NUMBER_CHANELS));
				while (numberofChannels < MIN_NUMBER_CHANELS
						|| numberofChannels > maxNumberofChanels) {
					JOptionPane.showMessageDialog(null,
							"Value must be between " + MIN_NUMBER_CHANELS
									+ " and " + maxNumberofChanels);
					numberofChannels = Integer.parseInt(JOptionPane
							.showInputDialog(
									"Please Provide the number of Comminication chanels "
											+ MIN_NUMBER_CHANELS + " and "
											+ maxNumberofChanels,
									MIN_NUMBER_CHANELS));
				}

			}
		});
	}

	/**
	 * 
	 * @author TCHUENTE Panel to draw our AI object.
	 *
	 */
	
	class CanvasPanel extends JPanel {

		private int width = 0;
		private int height = 0;
		
		public CanvasPanel() {
			width = getWidth();
			height = getHeight();
		}
		
		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public void paintComponent(Graphics g, int shape, int xPos, int yPos,int xPos2, int yPos2) {
			switch (shape) {
			case LINE:
                 g.setColor(Color.BLACK);
                 g.drawLine(xPos, yPos, xPos2, yPos2);
				break;
				
			case CIRCLE:
				 g.setColor(Color.BLUE);
                 g.drawOval(xPos, yPos, 2, 2);
				break;
				
			default:
				break;
			}
         repaint();
		}
		
	}

}
