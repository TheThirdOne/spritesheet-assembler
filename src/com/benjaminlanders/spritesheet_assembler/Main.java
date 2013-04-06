package com.benjaminlanders.spritesheet_assembler;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		String ending = "-sprite.png";//args[0]+".png";
		int col = 2;//Integer.parseInt(args[1]);
		int row = 2;//Integer.parseInt(args[2]);
		System.out.println("Columns: "+ col+ " Rows: "+row);
		File tempFile = new File(1+ending);
		try {
			BufferedImage temp = ImageIO.read(tempFile);
			BufferedImage out = new BufferedImage(temp.getHeight()*row,temp.getWidth()*col,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = out.createGraphics();
			g.drawImage((Image)temp, 0, 0, null);
			File outputfile = new File("saved.png");
		    ImageIO.write(out, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
