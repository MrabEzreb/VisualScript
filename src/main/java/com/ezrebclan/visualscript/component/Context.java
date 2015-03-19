package com.ezrebclan.visualscript.component;

import javax.swing.JPanel;

public class Context {

	private int xPos;
	private int yPos;
	private JPanel frame;
	/**
	 * @return the xPos
	 */
	public int getxPos() {
		return xPos;
	}
	/**
	 * @param xPos the xPos to set
	 */
	public Context setxPos(int xPos) {
		this.xPos = xPos;
		return this;
	}
	/**
	 * @return the yPos
	 */
	public int getyPos() {
		return yPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public Context setyPos(int yPos) {
		this.yPos = yPos;
		return this;
	}
	/**
	 * @return the frame
	 */
	public JPanel getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public Context setFrame(JPanel frame) {
		this.frame = frame;
		return this;
	}
}
