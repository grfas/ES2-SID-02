package mongo;

import java.util.*;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoWrite {
	private static int tempo = 5000;

	public MongoWrite() {

	}

	int i = 1;

	MongoClient mongoClient1 = new MongoClient("localhost", 27017);
	MongoDatabase database = mongoClient1.getDatabase("sid");
	MongoCollection<Document> collection = database.getCollection("Sensor");

	/**
	 * 
	 * @param tmp
	 * @param hum
	 * @param dat
	 * @param tim
	 * @param cell
	 */
	public void insert(String tmp, String hum, String dat, String tim, String cell) {
		LinkedList<Document> listaDeDocs = new LinkedList<Document>();
		String copy = " 'cell':0";
		if (!cell.equals(copy)) {

			if (!tmp.isEmpty() || !hum.isEmpty() || !dat.isEmpty() || !tim.isEmpty() || !cell.isEmpty()) {

				Document docTmp = new Document("id_sensor", splitNameTmp(tmp)).append("variavel", splitTmpVar(tmp))

						.append("TimeStamp", splitDat(dat) + " " + splitTim(tim)).append("migracao", 0);

				Document docCell = new Document("id_sensor", splitNameCell(cell)).append("variavel", splitCell(cell))
						.append("TimeStamp", splitDat(dat) + "  " + splitTim(tim)).append("migracao", 0);

				listaDeDocs.add(docTmp);

				listaDeDocs.add(docCell);

			}

			try {
				if (!listaDeDocs.isEmpty()) {

					for (Document document : listaDeDocs) {
						collection.insertOne(document);
						System.out.println("Inserido Com Sucesso no Mongo");

					}
				}

			} catch (Exception e) {
			}

			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		} else {
			if (!tmp.isEmpty() || !hum.isEmpty() || !dat.isEmpty() || !tim.isEmpty() || !cell.isEmpty()) {

				Document docTmp = new Document("id_sensor", splitNameTmp(tmp)).append("variavel", splitTmpVar(tmp))

						.append("TimeStamp", splitDat(dat) + " " + splitTim(tim)).append("migracao", 0);

				Document docCell = new Document("id_sensor", splitNameCellnull(cell))
						.append("variavel", splitCellVarNull(cell))
						.append("TimeStamp", splitDat(dat) + "  " + splitTim(tim)).append("migracao", 0);

				listaDeDocs.add(docTmp);

				listaDeDocs.add(docCell);

			}
			try {
				if (!listaDeDocs.isEmpty()) {

					for (Document document : listaDeDocs) {
						collection.insertOne(document);

					}
					System.out.println("Inserido Com Sucesso no Mongo");
				}

			} catch (Exception e) {
			}

			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitNameTmp(String s) {
		String a = s.substring(2, 5);
		return a;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitTmpVar(String s) {
		String a = s.substring(8, 13);

		if (a.matches("[0-9.]*")) {
			return a;
		} else {
			System.out.println("Erro: De leitura de valor");
			return null;
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitHum(String s) {

		String a = s.substring(7, 12);
		if (a.matches("[0-9]")) {
			return a;
		} else {
			System.out.println("Erro: De leitura de v	alor");
			return null;
		}

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitDat(String s) {
		String data = s.substring(7, 16);
		String [] parts = data.split("/");
		String dia = parts[0];
		String mes = parts[1];
		String ano = parts[2];
		
		String concat = ano + "/" +mes +"/" +dia;
		System.out.println(concat);
		return concat;

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitTim(String s) {
		System.out.println(s.length());
		if(s.length()==13) {
			String a = s.substring(7, 12);
			return a;
		}
		else if(s.length()==14) {
		String a = s.substring(7, 13);
		return a;
		}else if (s.length()== 15) {
			String a = s.substring(7, 14);
			return a;
		}else if (s.length()==16) {
			String a = s.substring(7, 15);
			return a;
		}
		return null;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitNameCell(String s) {
		String a = s.substring(1, 5);

		if (a.equals("cell")) {

			String name = "Luminosidade";
			return name;
		} else {
			return null;
		}

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitNameCellnull(String s) {
		String a1 = "Luminosidade";
		return a1;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitCellVarNull(String s) {
		String a2 = "0";
		return a2;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */

	public String splitCell(String s) {

		if (s.length() == 23) {
			String a = s.substring(8, 9);
			return a;
		} else if (s.length() == 24) {
			String a = s.substring(8, 10);
			return a;
		} else if (s.length() == 25) {
			String a = s.substring(8, 11);
			return a;

		} else if (s.length() == 26) {
			String a = s.substring(8, 12);
			return a;
		}
		return null;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
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
