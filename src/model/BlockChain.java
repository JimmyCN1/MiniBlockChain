package model;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    List<Block> blockChain = new ArrayList<>();

    public void addBlock(Block block) {
        blockChain.add(block);
    }

    public int getBlockChainSize() {
        return this.blockChain.size();
    }

    public String getPreviousHash() {
        return this.blockChain.get(blockChain.size() - 1).getCurrentHash();
    }

    public void printBlocks() {
        for (Block block : blockChain) {
            System.out.println(block.toString());
        }
    }
}
