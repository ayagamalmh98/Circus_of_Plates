package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;

import controller.facade.Facade;
import controller.game.Game;
import controller.music.Music;
import controller.strategy.Strategy;
import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
import model.logging;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {
    private JFrame frame;
    private JFrame frame1;
    /**
     * Launch the application.
     */
    logging log =new logging ();
    // static Music music_catch=new Music();
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                   // music_catch.PlayMusic("C:\\eclipse-workspace\\final42\\MusicREs\\win.wav");
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public GUI() {
        initialize();
    }

    private void initialize1(Strategy level2) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitMenuItem);
        menuBar.add(menu);
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        JMenuItem PlugMenuItem = new JMenuItem("Plug-in");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menu.add(undoMenuItem);
        menu.addSeparator();
		menu.add(PlugMenuItem);
		menuBar.add(menu);
        Game g = new Game(900, 750, level2,false,"");
        final GameController gameController = GameEngine.start("Circus Of Plates", g, menuBar,Color.black);  
        log.help().info("The game is stated!");
        frame1 = new JFrame();
		frame1.setBounds(100, 100, 400, 250);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 800);
		frame1.getContentPane().add(panel);
		panel.setLayout(null);
		String s1[] = { "White", "Gray", "Green", "Purple" };
		JComboBox<?> comboBox = new JComboBox<Object>(s1);
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 20));
		comboBox.setBounds(63, 70, 267, 39);
		panel.add(comboBox);

		JLabel lblNewLabel = new JLabel("Choose a Color");
		
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(63, 28, 267, 33);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().toString() == "White") {
					//codee plugin
					frame1.setVisible(false);
					gameController.changeWorld(new controller.game.Game(900, 750, level2,false,"White"));
					//gameController.resume();
				} else if (comboBox.getSelectedItem().toString() == "Gray") {
					//codee plugin
					frame1.setVisible(false);
					gameController.changeWorld(new controller.game.Game(900, 750, level2,false,"Gray"));
					//gameController.resume();
				} else if (comboBox.getSelectedItem().toString() == "Green") {
					//codee plugin
					frame1.setVisible(false);
					gameController.changeWorld(new controller.game.Game(900, 750, level2,false,"Green"));
					//gameController.resume();
				} else if (comboBox.getSelectedItem().toString() == "Purple") {
					//codee plugin
					frame1.setVisible(false);
					gameController.changeWorld(new controller.game.Game(900, 750, level2,false,"Purple"));
					//gameController.resume();
				}
			}
		});
		btnNewButton.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 24));
		btnNewButton.setBounds(205, 137, 125, 41);
		panel.add(btnNewButton);
        
        newMenuItem.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
                gameController.changeWorld(new controller.game.Game(900, 750, level2,false,""));
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
            log.help().info("The game is Paused");
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                gameController.resume();
                log.help().info("The game is resumed");
            }
        });
        undoMenuItem.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                g.undo();
                log.help().info("Undo is done");
            }
        });
        PlugMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//gameController.pause();
				frame1.setVisible(true);
			}
		});
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Facade facade = new Facade();
        frame = new JFrame();
        frame.setSize(900, 800);
        frame.getContentPane().setBounds(new Rectangle(0, 0, 900, 800));
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 900, 800);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        String s1[] = { "Easy", "Medium", "Hard" };

        JComboBox<?> comboBox = new JComboBox<Object>(s1);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(Color.GRAY);
        comboBox.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 20));
        comboBox.setBounds(330, 373, 267, 39);
        panel.add(comboBox);

        JLabel lblNewLabel = new JLabel("Choose Your Journey");
        lblNewLabel.setForeground(new Color(255, 204, 102));
        lblNewLabel.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(330, 323, 267, 33);
        panel.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Start");
        btnNewButton.setBackground(Color.GRAY);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (comboBox.getSelectedItem().toString() == "Easy") {
                    frame.setVisible(false);
                    initialize1(facade.factory.setLevel(1));
                    log.help().info("The game set to be easy");
                } else if (comboBox.getSelectedItem().toString() == "Medium") {
                    frame.setVisible(false);
                    initialize1(facade.factory.setLevel(2));
                    log.help().info("The game set to be medium");
                } else if (comboBox.getSelectedItem().toString() == "Hard") {
                    frame.setVisible(false);
                    initialize1(facade.factory.setLevel(3));
                    log.help().info("The game set to be hard");

                }
                log.help().info("Difficulty of the game is chosen");
            }
        });
        btnNewButton.setFont(new Font("Andalus", Font.BOLD | Font.ITALIC, 24));
        btnNewButton.setBounds(599, 459, 125, 41);
        panel.add(btnNewButton);

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon(GUI.class.getResource("/background-1.png")));
        image.setBounds(0, 0, 900, 800);
        panel.add(image);
        frame.setPreferredSize(new Dimension(900, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
