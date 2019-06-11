package src.unepproject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.rmi.CORBA.Util;

/*
 * BLOCK CLASS
 * MDALEL AHMED
 * ©ahmed.mdallel@esprit.tn©
 */
public class Block {
private int index;
private String timestamp;
private String hash;
private String previousHash;
private String data;
private int nonce;
// constricteur block 
public Block(int index, String timestamp, String previousHash,String data) {
	this.index = index;
	this.timestamp = timestamp;
	this.previousHash = previousHash;
	this.data = data;
	this.nonce = 0;
	this.hash = Block.calculateHash(this);
}

public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public String getTimestamp() {
	return timestamp;
}
public void setTimestamp(String timestamp) {
	this.timestamp = timestamp;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}
public String getPreviousHash() {
	return previousHash;
}
public void setPreviousHash(String previousHash) {
	this.previousHash = previousHash;
}
public int getNance() {
	return nonce;
}
public void setNance(int nance) {
	this.nonce = nance;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public String str() {
	return index + timestamp + previousHash + data + nonce;//information du block
}
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Block #").append(index).append("[previousHash : ").append(previousHash).append(", ").append("timestamp : ").append(timestamp).append(", ").append("data : ").append(data).append(", ").append("hash : ").append(hash).append(" ]");
return builder.toString();
}
// calculer le hash en SHA-256
public static String calculateHash(Block block) {
	if(block != null) {
		MessageDigest digest=null;
			try {
			 digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				return null;
			}
			String txt = block.str();
			final byte bytes[] = digest.digest(txt.getBytes());
			final StringBuilder builder = new StringBuilder();
			for (final byte b : bytes) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length() == 1) {
					builder.append('0');
				}
				builder.append(hex);
			}
			return builder.toString();
		
	}
	return null;
}
//calculer la difficulté
public void mineBlock(int difficulty) {
	nonce = 0;
	while (!getHash().substring(0, difficulty).equals(Utils.zeros(difficulty))) {
		nonce++;
		hash=Block.calculateHash(this);
	}
}

}
