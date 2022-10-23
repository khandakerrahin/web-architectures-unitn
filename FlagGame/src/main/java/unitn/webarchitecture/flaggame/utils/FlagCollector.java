package unitn.webarchitecture.flaggame.utils;

import java.util.ArrayList;

import unitn.webarchitecture.flaggame.resources.Flags;

public class FlagCollector {
	public ArrayList<Flags> getFlagsCollection(){
		ArrayList<Flags> flagCollection = new ArrayList<Flags>();
		flagCollection.add(new Flags("Algeria","Algiers", 1));
		flagCollection.add(new Flags("Armenia","Yerevan", 2));
		flagCollection.add(new Flags("Chad","N'Djamena", 3));
		flagCollection.add(new Flags("Czech Republic","Prague", 4));
		flagCollection.add(new Flags("Djibouti","Djibouti", 5));
		flagCollection.add(new Flags("Gabon","Libreville", 6));
		flagCollection.add(new Flags("Indonesia","Jakarta", 7));
		flagCollection.add(new Flags("Lithuania","Vilnius", 8));
		flagCollection.add(new Flags("Malta","Valletta", 9));
		flagCollection.add(new Flags("Ukraine","Kiev", 10));
		
		return flagCollection;
	}
}
