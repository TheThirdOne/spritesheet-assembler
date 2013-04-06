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
		if( args.length == 0 || args[0].equalsIgnoreCase("help"))
		{
			System.out.println("The first argument is the ending of the files");
			System.out.println("The second argument is the number of columns");
			System.out.println("The third argument is the ending of rows");
			System.out.println("type help for this help screen");
			
		}else
		{
		String ending = args[0]+".png";
		int col = Integer.parseInt(args[1]);
		int row = Integer.parseInt(args[2]);
		System.out.println("Columns: "+ col+ " Rows: "+row);
		File tempFile = new File(1+ending);
		try
		{
			BufferedImage temp = ImageIO.read(tempFile);
			int h = temp.getHeight();
			int w = temp.getWidth();
			BufferedImage out = new BufferedImage(w*col, h*row,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = out.createGraphics();
			for(int i = 0; i < col*row;i++)
			{
				tempFile = new File((i+1)+ending);
				temp = ImageIO.read(tempFile);
				g.drawImage((Image)temp, (i % col)*w,((int) i/col)*h, null);
			}
			File outputfile = new File("saved.png");
		    ImageIO.write(out, "png", outputfile);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		

	}

}
