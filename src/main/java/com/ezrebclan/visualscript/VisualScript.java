package com.ezrebclan.visualscript;

import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.ezrebclan.visualscript.component.Context;
import com.ezrebclan.visualscript.component.IfScriptComponent;
import com.ezrebclan.visualscript.handlers.ImageLoadHandler;

public class VisualScript {

	public static void main(String[] args) {
		ImageLoadHandler.loadImagesFromFields();
		windowTest();
	}
	
	public static void windowTest() {
		JFrame jf = new JFrame("test") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 886976099993241647L;

			@Override
			protected void processWindowEvent(WindowEvent e) {
				super.processWindowEvent(e);
				if(e.getID() == WindowEvent.WINDOW_CLOSING) {
					System.exit(0);
				}
			}
		};
		JPanel jp = new JPanel();
		IfScriptComponent isc = new IfScriptComponent();
		jf.setVisible(true);
		jf.setSize(1000, 600);
		jf.setLayout(null);
		jf.add(jp);
		jp.setBorder(new BevelBorder(BevelBorder.RAISED));
		jp.setSize(500, 500);
		jp.setBackground(Color.BLACK);
		jp.setLayout(null);
		Context c = new Context();
		c.setFrame(jp);
		c.setxPos(50);
		c.setyPos(50);
		System.out.println(1);
		isc.create(c);
		System.out.println(2);
		isc.draw(c);
		System.out.println(3);
	}
}
