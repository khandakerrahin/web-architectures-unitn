package unitn.webarchitecture.flaggame.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import unitn.webarchitecture.flaggame.resources.Player;

public class FlagGameServletContextListener implements ServletContextListener{
	public static PlayerDB pdb;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			FileOutputStream f = new FileOutputStream(new File("PlayersDB_01.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(pdb);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		System.out.println("FlagGame ServletContextListener destroyed");
	}

    //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			pdb = new PlayerDB();
			FileInputStream fi = new FileInputStream(new File("PlayersDB_01.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			PlayerDB pdb1 = (PlayerDB) oi.readObject();
			
			pdb = pdb1;

			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			contextDestroyed(arg0);
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			contextDestroyed(arg0);
		}
		System.out.println("FlagGame ServletContextListener started");
	}
}