package mongo;

import java.util.*;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import config.Config;

public class MongoWrite {
	static Config cfg = new Config();
	private static String parse =cfg.getProperty("mWaitTime");
	int tempo = Integer.parseUnsignedInt(parse);
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
						.append("TimeStamp", splitDat(dat) + " " + splitTim(tim)).append("migracao", 0);

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
						.append("TimeStamp", splitDat(dat) + " " + splitTim(tim)).append("migracao", 0);

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
		String join=null;
		String join2=null;
		
		String dia = parts[0];
		if(dia.length()==1) {
			join =0+dia;
		}else {
			 join = dia;
		}
		String mes = parts[1];
		if(mes.length()==1) {
			 join2= 0+mes;
		}else {
			 join2 = mes;
		}
		String ano = parts[2];
		
		String concat = ano + "-" +join2 +"-" +join;
		System.out.println(concat);
		return concat;

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public String splitTim(String s) {
		
	
		String [] parts = s.split(":");
		String join=null;
		String join2=null;
		String join3=null;
		System.out.println("Teste :"+  s);
		String hora = parts[1];
		if(hora.length()==2) {
			String a=hora.replace("\"", "");
			join =0+a;
		}else {
			String a=hora.replace("\"", "");
			 join = a;
		}
		String min = parts[2];
		
		if(min.length()==1) {
			 join2= 0+min;
		}else {
			 join2 = min;
		}
		String seg = parts[3];
		String seg2 = null;
		seg2 = seg.replaceAll("\\D+","");
		System.out.println("Teste:"+seg2);
		if (seg2.length() == 1) {
			String a=seg2.replace("\"", "");
			join3 = 0 + a;
			
		} else {
			String a=seg2.replace("\"", "");
			join3 = a;
		}

		String concat = join + ":" + join2 + ":" + join3;
	
		return concat;

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
		System.out.println(s.length());
		if(s.contains("eth")) {
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
		}else {
			if (s.length() == 24) {
				String a = s.substring(8, 9);
				return a;
			} else if (s.length() == 25) {
				String a = s.substring(8, 10);
				return a;
			} else if (s.length() == 26) {
				String a = s.substring(8, 11);
				return a;

			} else if (s.length() == 27) {
				String a = s.substring(8, 12);
				return a;
			}
			
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
