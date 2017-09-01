import java.util.Arrays;
public class transaction {

    public static void main(String[] args) {

        String[] firstTransactions = {"Lacrimosa dies illa"};
        Block genesisBlock = new Block(0, firstTransactions);

        String[] block2Transactions = {"Pie Jesu, Domine!", "Os iusti meditabitur sapientiam"};
        Block block2 = new Block(genesisBlock.getBlockHash(), block2Transactions);

        String[] block3Transactions = {"testing"};
        Block block3 = new Block(block2.getBlockHash(), block3Transactions);

        System.out.println("Hash of genesis block:");
        System.out.println(genesisBlock.getBlockHash());

        System.out.println("Hash of block 2:");
        System.out.println(block2.getBlockHash());

        System.out.println("Hash of block 3:");
        System.out.println(block3.getBlockHash());

    }
}
