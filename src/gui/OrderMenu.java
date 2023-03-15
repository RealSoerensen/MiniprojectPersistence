package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.TreePath;

import controller.ProductController;
import dal.product.ProductContainer;
import model.Product;

public class OrderMenu {
	private JFrame frame;
	private JTree tree;
	private JTextField tfName;
	private JTextField tfPrice;
	private JTextField tfStock;
	private JTextField tfBrand;
	private ProductController productController;
	private JTextField tfDescription;

	/**
	 * Create the application.
	 */
	public OrderMenu() {
		productController = new ProductController(ProductContainer.getInstance());
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Produkt Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(e -> {
			frame.dispose();
			new LoginMenu();
		});
		panel_1.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		JButton btnCreateProduct = new JButton("Afslur Ordre");
		btnCreateProduct.addActionListener(e -> {
			//Lave popup menu der spørger om man vil købe x produkter for x penge.
		});
		panel_1.add(btnCreateProduct);
		
		JButton btnRemoveProduct = new JButton("Tilføj til Ordre");
		btnRemoveProduct.addActionListener(e -> {
			TreePath path = tree.getSelectionPath();
			if(path == null || path.getPathCount() != 2) {
				return;
			}
			orderController.addProductToCart(Long.parseLong(path.getPathComponent(1).toString()));
		});
		panel_1.add(btnRemoveProduct);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Produkter");
		List<Object> products = productController.getAll();
		for (Object product : products) {
			DefaultMutableTreeNode category = new DefaultMutableTreeNode(((Product) product).getCategory());
			if (!root.isNodeChild(category)) {
				root.add(category);
			}
			category.add(new DefaultMutableTreeNode(((Product) product).getId()));
		}

		tree = new JTree(root);
		tree.getSelectionModel().addTreeSelectionListener(e -> {
			TreeNode selectedNode = (TreeNode) tree.getLastSelectedPathComponent();
			if (selectedNode != null) {
				Product product = (Product) productController.get(Long.parseLong(selectedNode.toString()));
				tfName.setText(product.getName());
				tfDescription.setText(product.getDescription());
				tfPrice.setText(String.valueOf(product.getSalesPrice()));
				tfStock.setText(String.valueOf(product.getStock()));
			}
		});
		panel_3.add(new JScrollPane(tree));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Produkt detaljer");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Navn");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_2);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setColumns(10);
		panel_6.add(tfName);
		
		JLabel lblNewLabel_3 = new JLabel("Beskrivelse");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_3);
		
		tfDescription = new JTextField();
		tfDescription.setEditable(false);
		panel_6.add(tfDescription);
		tfDescription.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Brand");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_5);
		
		tfBrand = new JTextField();
		tfBrand.setEditable(false);
		panel_6.add(tfBrand);
		tfBrand.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Pris");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNewLabel_4);
		
		tfPrice = new JTextField();
		tfPrice.setEditable(false);
		tfPrice.setColumns(10);
		panel_6.add(tfPrice);
	}
}
