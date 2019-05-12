package sid.testeMaven1;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.*;
import com.mongodb.client.MongoClient;

public class MongoRead   {
	private DB db;
	private SQLWrite sql;


	public void connectMongo() {
		com.mongodb.MongoClient mongoClient = new com.mongodb.MongoClient("localhost", 27017);
		db = mongoClient.getDB("sid");
		System.out.println("Mondo connected");
		sql=new SQLWrite();
	}

	public  void readDocuments() throws Exception {
		try {
			System.out.println("vai comecar a ler");
			String objectId;
			
			Timestamp timestampDate;
			String tipoVariavel;
			int valorMedicao;

			DBCollection coll = db.getCollection("medicoes");

			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("migracao", "0");
			BasicDBObject fields = new BasicDBObject();
			//	    fields.put("Valor", 3);
			//	    fields.put("IDSensor", 1);
			//	    fields.put("TimeStamp", 4);
			//	    fields.put("Variavel", 2);
			//	    fields.put("_id", 1);

			DBCursor cursor = coll.find(whereQuery, fields);
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
				System.out.println("eee");

				BasicDBObject medicaoBD = (BasicDBObject) cursor.next();
				ObjectId id = (ObjectId)medicaoBD.get("_id");
				objectId = id.toString();
				System.out.println("ID: " + objectId);


				//retira o tipo da variavel
				tipoVariavel = medicaoBD.getString("id_sensor");
				System.out.println("variavel: " +tipoVariavel);

				
				//retirao valor da medicao
				String valorString = medicaoBD.getString("variavel");
				valorMedicao =  Integer.parseInt(valorString);
				System.out.println(valorMedicao);


				//retira a data e hora da medicao
				String horaData =   medicaoBD.getString("TimeStamp");
				System.out.println(horaData);
				timestampDate = Timestamp.valueOf(horaData);
				System.out.println("hora: " +timestampDate);

			


				int idVariavel;
				if(tipoVariavel.equals("humidade")) {
					idVariavel=0;
				}else {
					idVariavel=1;
				}

				Medicao novaMedicao= new Medicao(valorMedicao, timestampDate, tipoVariavel, objectId, idVariavel );
				System.out.println(novaMedicao);
				updateDocument(id, coll, novaMedicao);
				sql.insertMedicoes(novaMedicao);
				



			}

		}catch(Exception e){
			System.out.println(e);
		}
		
	}

	public void updateDocument(ObjectId id, DBCollection coll, Medicao medicao){
//		DBCollection coll = db.getCollection("medicoes");


		BasicDBObject document = new BasicDBObject();
		document.put("id_sensor", medicao.getTipoVariavel());
		document.put("variavel", medicao.getValorMedicao());
		document.put("TimeStamp", medicao.getData());
		document.put("migracao", 1);

		BasicDBObject searchQuery = new BasicDBObject().append("_id", id);

		coll.update(searchQuery, document);


	}


}
