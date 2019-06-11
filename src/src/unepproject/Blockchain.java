package src.unepproject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/*
 * BLOCK BLOCKCHAIN
 * MDALEL AHMED
 * ©ahmed.mdallel@esprit.tn©
 */
public class Blockchain {
	private int difficulty;
	private List<Block> blocks;

	public Blockchain(int difficulty) {
		this.difficulty = difficulty;
		blocks = new ArrayList<>();
		Block b = new Block(0, String.valueOf(System.currentTimeMillis()), null, "First Block");
		b.mineBlock(difficulty);
		blocks.add(b);
		try {
			addblock(b.getIndex(), String.valueOf(b.getTimestamp()),b.getHash(),  null, "First Block");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JSONArray getblocK() throws IOException, JSONException {
		String url = "http://localhost:3000/block/";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONArray jsonObj = new JSONArray(response.toString());
		return jsonObj;

	}

	public JSONArray addblock(Integer index,String timestamp,String hash,String previoushash,String data) throws IOException, JSONException {

		String url = "http://localhost:3000/block/";
		JSONObject json = new JSONObject();

		json.put("indexblock", index);
		json.put("timestamp", timestamp);
		json.put("hash",hash);
		json.put("previousHash", previoushash);
		json.put("data", data);

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setDoOutput(true);
		con.setDoInput(true);
		OutputStream os = con.getOutputStream();
		os.write(json.toString().getBytes("UTF-8"));
		os.close();
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				((HttpURLConnection) (new URL(url)).openConnection()).getInputStream(), Charset.forName("UTF-8")));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		JSONArray jsonObj = new JSONArray(response.toString());
		return jsonObj;

	}
	public int getDifficulty() {
		return difficulty;
	}

	public JSONObject latestBlock() throws JSONException, IOException {
		JSONArray lastblock=Blockchain.this.getblocK();
		return  lastblock.getJSONObject(lastblock.length()-1);
	}

	public JSONObject newBlock(String data) throws JSONException, IOException {
		JSONObject lastblock=Blockchain.this.latestBlock();
		JSONObject json = new JSONObject();

		json.put("indexblock",lastblock.getInt("indexblock")+1);
		json.put("timestamp", String.valueOf(System.currentTimeMillis()));
		json.put("previousHash", lastblock.optString("hash", "defaultValue"));
		json.put("data", data);
		return json;
	}
	public boolean isFirstBlockValid() throws JSONException, IOException {
		JSONObject firstBlock=Blockchain.this.getblocK().getJSONObject(0);
         Block fblock =new Block(firstBlock.getInt("indexblock"),firstBlock.getString("timestamp").toString(),firstBlock.get("previousHash").toString(),firstBlock.getString("data").toString());
     	if (fblock != null) {
     		fblock.mineBlock(difficulty);

		}		if (firstBlock.getInt("indexblock") != 0) {
			System.out.println("1");
			return false;
		}
		if (!firstBlock.get("previousHash").toString().equals("null")) {
			System.out.println("2");

			return false;
		}
		if (firstBlock.get("hash").toString().equals("null") || !(Block.calculateHash(fblock).toString().equals(firstBlock.get("hash").toString()))) {
			System.out.println("3");

			return false;
		}
		return true;
	}
	public boolean isValideNewBlock(JSONObject newBlock, JSONObject previousBlock) throws NumberFormatException, JSONException {
		Block nBlock=new Block(newBlock.getInt("indexblock"),( newBlock.getString("timestamp").toString()),newBlock.get("previousHash").toString(),newBlock.getString("data").toString());
     	if (nBlock != null) {
     		nBlock.mineBlock(difficulty);
     	}
		
		if (newBlock != null && previousBlock != null) {
			if (previousBlock.getInt("indexblock") + 1 != newBlock.getInt("indexblock")) {
				System.out.println("4");
				return false;
			}
			if (newBlock.get("previousHash").toString().equals("null") || !newBlock.get("previousHash").toString().equals(previousBlock.get("hash").toString())) {
				System.out.println("5");
				return false;
			}
			if (newBlock.get("hash").toString().equals("null") | !Block.calculateHash(nBlock).toString().equals(newBlock.get("hash").toString())) {
				System.out.println("6");

				return false;
			}
			return true;
		}
		return false;
	}

	public Boolean isBlockChainValid() throws JSONException, IOException {
		if (!isFirstBlockValid()) {
			return false;
		}
		JSONArray blockss=Blockchain.this.getblocK();
		for (int i = 1; i < blockss.length(); i++) {
			 JSONObject currentBlock = blockss.getJSONObject(i);
			 JSONObject previousBlock= blockss.getJSONObject(i - 1);
			if (!isValideNewBlock(currentBlock, previousBlock)) {
				return false;
			}
		}
		return true;
	}


	public void addBlock(JSONObject newBlock) throws NumberFormatException, JSONException, IOException {
		Block b=new Block(newBlock.getInt("indexblock"), newBlock.getString("timestamp"),newBlock.getString("previousHash"),newBlock.getString("data"));

		if (b != null) {
			b.mineBlock(difficulty);
			blocks.add(b);
			addblock(b.getIndex(), String.valueOf(b.getTimestamp()),b.getHash(),  b.getPreviousHash(), b.getData());

		}
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Block block : blocks) {
			builder.append(block).append("\n");
		}
		return builder.toString();
	}

}
