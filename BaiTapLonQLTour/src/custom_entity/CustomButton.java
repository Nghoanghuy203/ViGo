package custom_entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class CustomButton extends JButton {
	private String text;
	private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color borderColor;
    private int radius;
    private Color color_foreground;
    private Color hightlight;
    
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
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
    
    
    public Color getColor_fogeground(Color color_fogeground) {
		return color_fogeground;
	}

	public void setColor_fogeground(Color color_fogeground) {
		color_foreground = color_fogeground;
	}

	public Color getHightlight() {
		return hightlight;
	}

	public void setHightlight(Color hightlight) {
		this.hightlight = hightlight;
	}

	/**
     * @param over true thì hightlight, false thì ngược lại
     * @param color màu của background
     * @param colorOver màu của background khi chuột vào
     * @param colorClick màu của background khi click chuột
     * @param borderColor màu của viền
     * @param radius số đo góc
     * @param foreground màu chữ
     * @param hightlight màu chữ khi chọn
     */
    public CustomButton(String text,boolean over, Color color, Color colorOver, Color colorClick, Color borderColor,Color color_foreground,Color hightlight, int radius) {
		this.text = text;
    	this.over = over;
		this.color = color;
		this.colorOver = colorOver;
		this.colorClick = colorClick;
		this.borderColor = borderColor;
		this.radius = radius;
		this.color_foreground = color_foreground;
		this.hightlight = hightlight;
		makeButton();
	}
    private void makeButton(){
    	
    	setForeground(color_foreground);
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener();
        setFocusPainted(false);
        setBorder(null);
        
    }
	public CustomButton(String text) {
        //  Init Color
		setText(text);
        setColor(Color.WHITE); // mau cua background
        setColorOver(ChonMau.blue_4B70F5); // mau khi chuot di chuyen vao
        setColorClick(Color.white);// mau cua background khi click chuot
        setBorderColor(ChonMau.blue_4B70F5);// mau cua vien
        makeButton();
    }
	private void addMouseListener(){
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                over = true;
                setForeground(hightlight);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;
                setForeground(color_foreground);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
                setForeground(color_foreground);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                    setForeground(hightlight);
                    
                } else {
                    setBackground(color);
                    setForeground(color_foreground);
                }
            }
        });
	}
    

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
