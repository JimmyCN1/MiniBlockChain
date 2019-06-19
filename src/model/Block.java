package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

public class Block {
    private int index;
    private LocalDateTime currentDateTime;
    private String data;
    private String previousHash;
    private String currentHash;
    private MessageDigest digest;

    public Block(int index, String data, String previousHash) throws NoSuchAlgorithmException {
        this.index = index;
        this.currentDateTime = LocalDateTime.now();
        this.data = data;

        this.previousHash = previousHash;
        this.currentHash = hashBlock(this);
    }

    public String getCurrentHash() {
        return this.currentHash;
    }

    public String toString() {
        return String.format("Block: %s\nDateTime: %s\nData: %s\nCurrentHash: %s\nPreviousHash: %s\n\n",
                this.index, this.currentDateTime, this.data, this.currentHash, this.previousHash);
    }


    private String hashBlock(Block block) throws NoSuchAlgorithmException {
        String blockData = block.index + block.currentDateTime.toString() + block.data + block.previousHash;
        this.digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(blockData.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
