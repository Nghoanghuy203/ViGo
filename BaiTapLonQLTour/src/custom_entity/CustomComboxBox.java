package custom_entity;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import java.awt.*;
import java.awt.geom.*;

import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class CustomComboxBox extends JComboBox<Object> implements PopupMenuListener {
	private Color foreground;
	private Color background;
	private Color hightlight;
	private Color borderColor;
	private int radius;
	private boolean arrowButton_IsVisible;

	public Color getHightlight() {
		return hightlight;
	}

	public void setHightlight(Color hightlight) {
		this.hightlight = hightlight;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getForeground() {
		return foreground;
	}

	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public boolean isArrowButton_IsVisible() {
		return arrowButton_IsVisible;
	}

	public void setArrowButton_IsVisible(boolean arrowButton_IsVisible) {
		this.arrowButton_IsVisible = arrowButton_IsVisible;
	}

	public CustomComboxBox(Object[] objects, Color foreground, Color background, Color hightlight, Color borderColor,
			int radius, boolean arrowButton_IsVisible) {
		super(objects);
		this.foreground = foreground;
		this.background = background;
		this.hightlight = hightlight;
		this.borderColor = borderColor;
		this.radius = radius;
		this.arrowButton_IsVisible = arrowButton_IsVisible;
		make_Custom_Combobox();

	}

	public CustomComboxBox(Object[] objects) {
		super(objects);
	}

	public CustomComboxBox() {
		super();
	}

	public void make_Custom_Combobox() {
		
		UIManager.put("ComboBox.foreground", foreground);
	    UIManager.put("ComboBox.background", background);
	    UIManager.put("ComboBox.selectionForeground", hightlight);
	    UIManager.put("ComboBox.selectionBackground", background);

	    UIManager.put("ComboBox.buttonDarkShadow", background);
	    UIManager.put("ComboBox.buttonBackground", foreground);
	    UIManager.put("ComboBox.buttonHighlight",  foreground);
	    UIManager.put("ComboBox.buttonShadow",     foreground);

	    UIManager.put("ComboBox.border", new RoundedCornerBorder());
	    
		 //* setBorder(new RoundedCornerBorder());
	    if(arrowButton_IsVisible) {
	    	setUI(new BasicComboBoxUI() {
	    	@Override
	    	protected JButton createArrowButton() {
	    		JButton button = new BasicArrowButton(BasicArrowButton.SOUTH,
                UIManager.getColor("ComboBox.buttonBackground"),
                UIManager.getColor("ComboBox.buttonShadow"),
                UIManager.getColor("ComboBox.buttonDarkShadow"),
                UIManager.getColor("ComboBox.buttonHighlight"));
				button.setName("ComboBox.arrowButton");
				return button;}
	    	
	    	public void layoutContainer(Container parent) {
	            @SuppressWarnings("unchecked")
	            JComboBox<?> cb = (JComboBox)parent;
	            int width = cb.getWidth();
	            int height = cb.getHeight();

	            Insets insets = getInsets();
	            int buttonHeight = height - (insets.top + insets.bottom);
	            int buttonWidth = buttonHeight;
	            if (arrowButton != null) {
	                Insets arrowInsets = arrowButton.getInsets();
	                buttonWidth = squareButton ?
	                    buttonHeight :
	                    (int)(arrowButton.getPreferredSize().width*0.6) + arrowInsets.left + arrowInsets.right;
	            }
	            Rectangle cvb;

	            if (arrowButton != null) {
	                if (true) {
	                    arrowButton.setBounds(width - (insets.right + buttonWidth),
	                            insets.top, buttonWidth, buttonHeight);
	                } else {
	                    arrowButton.setBounds(insets.left, insets.top,
	                            buttonWidth, buttonHeight);
	                }
	            }
	            if ( editor != null ) {
	                cvb = rectangleForCurrentValue();
	                editor.setBounds(cvb);
	            }}}
	    	);
	    }
	    //else setUI(new BasicComboBoxUI());
		
		
	    setBorderColor(borderColor);
	    Object o = this.getAccessibleContext().getAccessibleChild(0);
	    if (o instanceof JComponent) {
	      JComponent c = (JComponent) o;
	      c.setBorder(new RoundedCornerBorder());
	      c.setForeground(foreground);
	      c.setBackground(background);
	    }
	    addPopupMenuListener(this);
	}
	
	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JComboBox combo = (JComboBox) e.getSource();
				Accessible a = combo.getUI().getAccessibleChild(combo, 0);
				if (a instanceof BasicComboPopup) {
					BasicComboPopup pop = (BasicComboPopup) a;
					Container top = pop.getTopLevelAncestor();
					if (top instanceof JWindow) {
						// http://ateraimemo.com/Swing/DropShadowPopup.html
						System.out.println("HeavyWeightContainer");
						((JWindow) top).setBackground(new Color(0x0, true));
					}
				}
			}
		});
	}

	public JPanel getPanel(Color panelColor, int x, int y, int height, int width) {
		JPanel pnCustomComboxBox = new JPanel();
		pnCustomComboxBox.add(this);
		pnCustomComboxBox.setBackground(panelColor);

		this.setPreferredSize(new Dimension((int) (height * 0.9), (int) (width * 0.9)));
		pnCustomComboxBox.setBounds(x, y, height, width);
		pnCustomComboxBox.setPreferredSize(new Dimension(height, width));
		return pnCustomComboxBox;
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		UIManager.put("ComboBox.selectionForeground", foreground);
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {
		// TODO Auto-generated method stub

	}
}