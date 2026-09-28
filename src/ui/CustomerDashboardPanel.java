package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CustomerDashboardPanel extends JPanel
{
    private JTable booksTable;

    public CustomerDashboardPanel()
    {
        setLayout(new BorderLayout(20, 20));

        setBackground(new Color(245, 247, 250));

        setBorder(new EmptyBorder(25, 30, 25, 30));

        //Top Section
        JPanel topPanel = new JPanel();

        topPanel.setLayout(new BorderLayout(0, 20));

        topPanel.setOpaque(false);

        // Welcome text
        JPanel welcomePanel = new JPanel();

        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));

        welcomePanel.setOpaque(false);

        JLabel welcomeLabel = new JLabel("Good evening, Sounak");

        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JLabel subtitleLabel = new JLabel(
                "Here's an overview of your current library activity."
        );

        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        subtitleLabel.setForeground(new Color(100, 100, 100));

        welcomePanel.add(welcomeLabel);

        welcomePanel.add(Box.createVerticalStrut(5));

        welcomePanel.add(subtitleLabel);

        topPanel.add(welcomePanel, BorderLayout.NORTH);


        //Summary Cards
        JPanel cardsPanel = new JPanel(new GridLayout(1, 4, 15, 0));
        cardsPanel.setOpaque(false);

        cardsPanel.add(createCard(
                "ISSUED BOOKS",
                "4",
                "Currently issued"
        ));

        cardsPanel.add(createCard(
                "DUE SOON",
                "2",
                "Within 3 days"
        ));

        cardsPanel.add(createCard(
                "OVERDUE",
                "1",
                "Return required"
        ));

        cardsPanel.add(createCard(
                "CURRENT DUE",
                "₹120.00",
                "Outstanding amount"
        ));

        topPanel.add(cardsPanel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);


        //Issued Books Section
        JPanel booksPanel = new JPanel(new BorderLayout(0, 15));

        booksPanel.setBackground(Color.WHITE);

        booksPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220)
                        ),
                        new EmptyBorder(20, 20, 20, 20)
                )
        );

        JLabel booksTitle = new JLabel("Currently Issued Books");

        booksTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));

        booksPanel.add(booksTitle, BorderLayout.NORTH);


        //Table
        String[] columns =
        {
            "Book",
            "Author",
            "Issued On",
            "Due Date",
            "Status",
            "Fine"
        };

        Object[][] data =
        {
            {
                "DBMS Concepts",
                "Korth",
                "10 Sep 2026",
                "25 Sep 2026",
                "Due Today",
                "₹0"
            },
            {
                "Data Structures",
                "Narasimha",
                "15 Sep 2026",
                "27 Sep 2026",
                "Due in 2 days",
                "₹0"
            },
            {
                "Clean Code",
                "Robert Martin",
                "01 Sep 2026",
                "20 Sep 2026",
                "OVERDUE",
                "₹80"
            },
            {
                "Operating Systems",
                "Galvin",
                "18 Sep 2026",
                "03 Oct 2026",
                "Due in 8 days",
                "₹0"
            }
        };


        DefaultTableModel model = new DefaultTableModel(data, columns)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        booksTable = new JTable(model);

        booksTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        booksTable.setRowHeight(45);

        booksTable.getTableHeader().setFont(
                new Font("Segoe UI", Font.BOLD, 14)
        );

        booksTable.getTableHeader().setPreferredSize(
                new Dimension(0, 40)
        );

        booksTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        booksTable.setShowGrid(false);
        booksTable.setIntercellSpacing(new Dimension(0, 0));


       //Column Widths
        booksTable.getColumnModel().getColumn(0).setPreferredWidth(180); 

        booksTable.getColumnModel().getColumn(1).setPreferredWidth(150);

        booksTable.getColumnModel().getColumn(2).setPreferredWidth(120);

        booksTable.getColumnModel().getColumn(3).setPreferredWidth(120);

        booksTable.getColumnModel().getColumn(4).setPreferredWidth(130);

        booksTable.getColumnModel().getColumn(5).setPreferredWidth(80);


        //Status Render
        booksTable.getColumnModel()
                .getColumn(4)
                .setCellRenderer(new StatusRenderer());


        JScrollPane scrollPane = new JScrollPane(booksTable);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder()
        );

        booksPanel.add(scrollPane, BorderLayout.CENTER);

        add(booksPanel, BorderLayout.CENTER);
    }


    //Create Summary Cards
    private JPanel createCard(
            String title,
            String value,
            String description
    )

    {
        JPanel card = new JPanel();

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        card.setBackground(Color.WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220)
                        ),
                        new EmptyBorder(18, 20, 18, 20)
                )
        );


        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 12)
        );

        titleLabel.setForeground(
                new Color(100, 100, 100)
        );


        JLabel valueLabel = new JLabel(value);

        valueLabel.setFont(
                new Font("Segoe UI", Font.BOLD, 28)
        );


        JLabel descriptionLabel = new JLabel(description);

        descriptionLabel.setFont(
                new Font("Segoe UI", Font.PLAIN, 12)
        );

        descriptionLabel.setForeground(
                new Color(120, 120, 120)
        );


        card.add(titleLabel);
        card.add(Box.createVerticalStrut(8));

        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));

        card.add(descriptionLabel);

        return card;
    }


    //Status Renderer
    private static class StatusRenderer
            extends DefaultTableCellRenderer
    {
        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column
        )
        {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table,
                    value,
                    isSelected,
                    hasFocus,
                    row,
                    column
            );

            label.setHorizontalAlignment(SwingConstants.CENTER);

            String status = value.toString();

            if (status.equals("OVERDUE"))
            {
                label.setForeground(new Color(190, 40, 40));
                label.setFont(
                        new Font("Segoe UI", Font.BOLD, 13)
                );
            }
            else if (status.equals("Due Today"))
            {
                label.setForeground(new Color(200, 130, 20));
                label.setFont(
                        new Font("Segoe UI", Font.BOLD, 13)
                );
            }
            else
            {
                label.setForeground(new Color(60, 110, 70));
            }

            return label;
        }
    }
}