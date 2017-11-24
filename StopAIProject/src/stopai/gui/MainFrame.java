/**
 * 
 */
package stopai.gui;

import stopai.model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import stopai.model.AIentity;

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

	private JButton btnCapture = new JButton("Start The Program");

	private JPanel panelNorh = new JPanel();
	private JPanel panelSouth = new JPanel();

	private Graph<AIentity, String> graph = null;
	private ArrayList<AIentity> ListofAI = null;

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

				// Could have done better by putting this repeating segment of code in a function.
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

				// Draw AI on the panel and insert them into our Graph.
				CanvasPanel canvaspanel = new CanvasPanel();
				panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
				panelSouth.add(canvaspanel);
				canvaspanel.setHeight(panelSouth.getHeight()-1);
				canvaspanel.setWidth(panelSouth.getWidth()-1);
				int h = canvaspanel.getHeight();
				int w = canvaspanel.getWidth();
				
				graph = new Graph<AIentity, String>();
				ListofAI = new ArrayList<AIentity>();
				
				Random rand = new Random();
				for (int i = 0; i < numberofAi; i++) {

					int x = (rand.nextInt(w)) + 50;
					int y = (rand.nextInt(h)) + 20;
					
					while( (100 > x || x > w/2) || ( 100 > y || y > h/2)){
						 x = (rand.nextInt(w)) + 50;
						 y = (rand.nextInt(h)) + 4;
					}

					System.out.print(x + "," + y);
					System.out.println();

					AIentity Ai = new AIentity(x, y, i);
					Vertex<AIentity> newVertex = new stopai.model.Vertex<AIentity>();
					newVertex.setElement(Ai);
					graph.insertVertex(newVertex);
					ListofAI.add(i,Ai);
					
					canvaspanel.paintComponent(getGraphics(),CIRCLE, Ai.getxPost(),
					 Ai.getyPost(), 25, 25);
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
				
				int i = 0;
				while(i < numberofChannels){
					
					String ij = JOptionPane.showInputDialog("Please provide the ith amd the jth that are connected. like 1,2. if 1 is connected to 2");					
					String [] res = ij.split(",");
					
					int posi = Integer.parseInt(res [0]);
					int posj = Integer.parseInt(res [1]);
					while(posi < 1 || posi > ListofAI.size() || posj < 1 || posj > ListofAI.size()){
						 ij = JOptionPane.showInputDialog("value must be between 1 and " + ListofAI.size());					
						  res = ij.split(",");
						 posi = Integer.parseInt(res [0]);
						 posj = Integer.parseInt(res [1]);
					}
					
					AIentity vi = ListofAI.get(posi-1);
					AIentity vj = ListofAI.get(posj-1);
					
					int xi = vi.getxPost();
					int yi = vi.getyPost();
					
					int xj = vj.getxPost();
					int yj = vj.getyPost();
					
					canvaspanel.paintComponent(getGraphics(),LINE, xi+17,
							yi+17, xj+17, yj+17);
					i++;
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

		// private Graphics g;

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

		protected void paintComponent(Graphics g, int shape, int xPos,
				int yPos, int xPos2, int yPos2) {
			super.paintComponents(g);
			switch (shape) {
			case LINE:
				g.setColor(Color.BLACK);
				g.drawLine(xPos, yPos, xPos2, yPos2);
				break;

			case CIRCLE:
				g.setColor(Color.BLUE);
				g.drawOval(xPos, yPos, xPos2, yPos2);
				break;

			default:
				break;
			}
			repaint();
		}
	}

}
