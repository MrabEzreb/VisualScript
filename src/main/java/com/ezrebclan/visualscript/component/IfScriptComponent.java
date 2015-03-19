package com.ezrebclan.visualscript.component;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONObject;

import com.ezrebclan.visualscript.handlers.ImageLoad;

public class IfScriptComponent extends ScriptComponent {

	@ImageLoad(imageName = "IfBlock.png")
	public static Image componentImage;
	public static JFrame j;
	private Canvas c;
	@Override
	public JSONObject run(Context context) {
		return null;
	}

	@Override
	public boolean draw(Context context) {
		Graphics2D g = (Graphics2D) c.getGraphics();
		return false;
	}

	@Override
	public boolean create(Context context) {
		JPanel panel = context.getFrame();
		c = new Canvas() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.drawImage(componentImage, 0, 0, c);
			}
		};
		c.setLocation(context.getxPos(), context.getyPos());
		c.setSize(400, 400);
		panel.add(c);
		return false;
	}

}
