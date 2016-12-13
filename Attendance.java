import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class Attendance extends JFrame {

    private static final long serialVersionUID = 1L;
    //JButton b = new JButton("testing");
    private JTable table;
    private String[] columnNames = {"DATE", "FIRST NAME", "LAST NAME", "ID/NUMBER", "PRESENT"};
    private Object[][] data = {
        {new Date(), "Student", "One", new Integer(11023), false},
        {new Date(), "Student", "Two", new Integer(48295), false},
        {new Date(), "Student", "Three", new Integer(89567), false},
        {new Date(), "Student", "Four", new Integer(10582), (false)}
    };

    public Attendance() {
 		
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        add(scrollPane);

        //  Override default renderer on a specific Class
        TableCellRenderer colorRenderer = new ColorRenderer();
        table.setDefaultRenderer(String.class, colorRenderer);

        //  Override default renderer for a specific column
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }
    


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
         		
                Attendance frame = new Attendance();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setTitle("");
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    
     //Color the focused cell
     
    private class ColorRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (hasFocus) {
                setBackground(Color.cyan);
            } else if (isSelected) {
                setBackground(table.getSelectionBackground());
            } else {
                setBackground(table.getBackground());
            }
            return this;
        }
    }
}