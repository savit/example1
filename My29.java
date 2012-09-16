import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class My29 {
	public static void main(String[] args) {
		System.out.println("Форматирование текста в Java");
		String [] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (int i=0; i<fontNames.length; i++){
			System.out.println(fontNames[i]);
		}
		MyFrame frame=new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(){
		setTitle("Окно программы");
		setSize(600, 400);
		MyPanel panel=new MyPanel();
		Container pane=getContentPane();
		pane.add(panel);
	}
}
	
class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponents(g);//наследование в конструкторе
		Graphics2D g2=(Graphics2D) g;
		
		//выведем в окно текст заданного шрифта
		/*Font f=new Font ("SansSerif", Font.ITALIC, 20);
		g2.setFont(f);
		g2.drawString("Пример форматирования текста на панели", 5, 33);*/
		
		//перебор шрифтов и вывод в столбик
		String [] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();//переберем все шрифты и выведем их в окно
		for (int i=0; i<20; i++){
			g2.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			Font f1=new Font (fontNames[i], Font.BOLD, 20);
			g2.setFont(f1);//задаем шрифт
			g2.drawString(fontNames[i], 5, 20*i);//выводим текст с заданную позицию
		}
		//вывод текста в центре
		g2.setColor(Color.RED);
		Font f2=new Font ("SansSerif", Font.ITALIC, 20);
		g2.setFont(f2);
		String s="Текст в центре";
		FontRenderContext context=g2.getFontRenderContext();//получение контекста текущего текста
		Rectangle2D r=f2.getStringBounds(s, context);//получить прямоугольник
		double x1=(getWidth()-r.getWidth())/2;
		double y1=(getHeight()-r.getHeight())/2;
		double 	ascent =-r.getY(); //учет размера шрифта в расчете
		double y2=y1+ascent;
		g2.drawString(s,(int)x1,(int)y2);
	}
}