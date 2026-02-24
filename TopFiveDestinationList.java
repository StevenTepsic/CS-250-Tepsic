import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
                
                
                
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/summer.png"))); ////changed icon for application from default to vacation one

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);
        
        //added label with name
        JLabel lblNewLabel = new JLabel("Steven Tepsic");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        listModel = new DefaultListModel();
        
        
             

        //Make updates to your top 5 list below. Import the new image files to resources directory.
        addDestinationNameAndPicture("1. New Orleans, LA: A fun historic town with plenty to see and do!", new ImageIcon(getClass().getResource("/resources/newOrleans.png")));
        addDestinationNameAndPicture("2. Washington DC: Tons of amazing museums to explore, plus tons of sightseeing to be done in and around the national mall", new ImageIcon(getClass().getResource("/resources/smithsonian.png")));
        addDestinationNameAndPicture("3. Point Pleseant, WV: A quaint town, that once a year hosts the incredibly fun, scary, and silly Mothman Festival", new ImageIcon(getClass().getResource("/resources/mothman.png")));
        addDestinationNameAndPicture("4. Aoshima and Tashirojima Islans, Japan: These wonderous islands are favorite destinations due to the cat population overtaking the humans", new ImageIcon(getClass().getResource("/resources/catIsland.png")));
        addDestinationNameAndPicture("5. Phantom Menace Pepsi Vending Machine in Pittsburgh, PA: Why check out anything else when we still have an Episode I podracing vending machine in the wild?", new ImageIcon(getClass().getResource("/resources/anniePepsi.png")));
        //destinations and pictures updates

   	   
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());
        
       
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setBackground(new Color(128, 0, 255));  //changed background to purple

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}