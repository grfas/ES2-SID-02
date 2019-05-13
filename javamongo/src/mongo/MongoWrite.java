package mongo;

import java.util.*;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoWrite {
	private static int tempo = 5000;

	public MongoWrite() {
		// this.tempo = tempo;

	}

	int i = 1;

	MongoClient mongoClient1 = new MongoClient("localhost", 27017);
	MongoDatabase database = mongoClient1.getDatabase("sid");
	MongoCollection<Document> collection = database.getCollection("Sensor");

	public void insert(String tmp, String hum, String dat, String tim, String cell) {
		LinkedList<Document> listaDeDocs = new LinkedList<Document>();
		if (!tmp.isEmpty() || !hum.isEmpty() || !dat.isEmpty() || !tim.isEmpty() || !cell.isEmpty()) {

			Document docTmp = new Document("id_sensor", splitNameTmp(tmp)).append("variavel", splitTmpVar(tmp))

					.append("TimeStamp", splitDat(dat) + " / " + splitTim(tim)).append("migracao", 0);

			//		Document dochum = new Document("ID Sensor", splitHum(sr))
			// .append("dat", splitDat(tr)).append("sens",splitSens(fr));

			Document docCell = new Document("id_sensor", splitNameCell(cell)).append("variavel", splitCell(cell))
					.append("TimeStamp", splitDat(dat) + "  " + splitTim(tim)).append("migracao", 0);
			System.out.println(docTmp.toString());
			System.out.println(docCell.toString());

			listaDeDocs.add(docTmp);

			listaDeDocs.add(docCell);

		}

		try {
			if (!listaDeDocs.isEmpty()) {

				for (Document document : listaDeDocs) {
					collection.insertOne(document);
					System.out.println(listaDeDocs);
					// listaDeDocs.clear;
				}
			}

		} catch (Exception e) {
		}

		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		//		mongoClient1.close();

	}

	public String splitNameTmp(String s) {
		String a = s.substring(2, 5);
		return a;
	}

	public String splitTmpVar(String s) {
		String a = s.substring(8, 13);
		System.out.println(a);
		if (a.matches("[0-9.]*")) {
			return a;
		} else {
			System.out.println("Erro: De leitura de valor");
			return null;
		}
	}

	public String splitHum(String s) {

		String a = s.substring(7, 12);
		if (a.matches("[0-9]")) {
			return a;
		} else {
			System.out.println("Erro: De leitura de v	alor");
			return null;
		}

	}

	public String splitDat(String s) {
		String a = s.substring(7, 14);
		return a;

	}

	public String splitTim(String s) {
		String a = s.substring(7, 14);
		return a;
	}

	public String splitNameCell(String s) {
		String a = s.substring(1, 5);

		if (a.equals("cell")) {

			String name = "Luminosidade";
			return name;
		} else {
			return null;
		}

	}

	// SE o Sensor tiver a ler valores maiores ajustar
	public String splitCell(String s) {
		System.out.println(s.length());
		System.out.println(s);
		if(s.length()==23) {
			String a = s.substring(8, 9);
			return a;}
			else if(s.length()==24) {
				String a = s.substring(8,10);
				return a;}
				else {
					if  (s.length()==25){
					String a = s.substring(8,11);
					return a ;
				
				}	
			}
		return null;
	}

	public String splitSens(String s) {

		String a = s.substring(18, 21);

		if (s.length() == 3) {
			return a;
		} else {
			String b = s.substring(18, 22);
			return b;
		}
	}

	
}
