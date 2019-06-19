package main;

import model.Block;
import model.BlockChain;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        try {
            Block firstBlock = new Block(blockChain.getBlockChainSize(), ".", "0");
            blockChain.addBlock(firstBlock);
            blockChain.addBlock(new Block(blockChain.getBlockChainSize(), "..", blockChain.getPreviousHash()));
            blockChain.addBlock(new Block(blockChain.getBlockChainSize(), ".0.", blockChain.getPreviousHash()));
            blockChain.addBlock(new Block(blockChain.getBlockChainSize(), ".419.", blockChain.getPreviousHash()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        blockChain.printBlocks();
    }
}
