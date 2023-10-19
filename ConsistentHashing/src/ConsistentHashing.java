import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {
    private SortedMap<Integer,String> ring = new TreeMap<>();
    private int numberofReplicas;

    public ConsistentHashing(int numberofReplicas){
        this.numberofReplicas = numberofReplicas;
    }
    public void addNode(String node){
        for(int i = 0;i<numberofReplicas;i++){
            int hash = getHash(i+node);
            ring.put(hash,node);
        }
    }
    public void removeNode(String node){
        for(int i = 0;i<numberofReplicas;i++){
            int hash = getHash(i+node);
            ring.remove(hash);
        }
    }
    public String getNode(String key){
       if(ring.isEmpty()){
           return null;
       }
        int hash = getHash(key);
       SortedMap<Integer,String> tailMap = ring.tailMap(hash);
       if(tailMap.isEmpty()){
           return ring.get(ring.firstKey());
       }
       return tailMap.get(tailMap.firstKey());

    }

    private int getHash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(input.getBytes());
            return byteArrayToInt(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 not supported.");
        }
    }

    private int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (byte b : bytes) {
            value = (value << 8) | (b & 0xFF);
        }
        return value;
    }

}


