package gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class StartMenu {
    private JFrame frame;
	private JTree tree;

    public StartMenu() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 260, 240);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setResizable(false);

        JLabel label_1 = new JLabel("Town Center");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(label_1, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
        flowLayout_1.setHgap(25);
        frame.getContentPane().add(panel_2, BorderLayout.WEST);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
        flowLayout.setHgap(25);
        frame.getContentPane().add(panel_3, BorderLayout.EAST);

        JPanel panel_4 = new JPanel();
        frame.getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new GridLayout(5, 2));
        
        JPanel panel_5 = new JPanel();
        panel_5.setPreferredSize(new Dimension(50, 50));
        panel_4.add(panel_5);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(13, 0));
        panel_4.add(panel2);
        
        JPanel panel3 = new JPanel();
        frame.getContentPane().add(panel3, BorderLayout.WEST);
        panel3.setPreferredSize(new Dimension(20, 20));

        JButton buttonArenaMenu = new JButton("Produkt Menu");
        panel_4.add(buttonArenaMenu);
        buttonArenaMenu.addActionListener(e -> {
            frame.dispose();
            new ProduktMenu();
        });

        JButton buttonShopMenu = new JButton("Ny Ordre");
        panel_4.add(buttonShopMenu);
        buttonShopMenu.addActionListener(e -> {
            frame.dispose();
            new OrderMenu();
        });
    }