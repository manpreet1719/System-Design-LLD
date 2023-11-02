public class Main {
    public static void main(String[] args){
        ConsistentHashing consistentHashing = new ConsistentHashing(3);

        consistentHashing.addNode("Node1");
        consistentHashing.addNode("Node2");
        consistentHashing.addNode("Node3");

        String key1 = "Data1";
        String key2 = "Data2";
        String key3 = "Data3";


        System.out.println("Key" + key1 + "=>" + consistentHashing.getNode(key1));
        System.out.println("Key" + key2 + "=>" + consistentHashing.getNode(key2));
        System.out.println("Key" + key3 + "=>" + consistentHashing.getNode(key3));

        consistentHashing.removeNode("Node1");
        System.out.println("Node is Removed");

        System.out.println("Key" + key1 + "=>" + consistentHashing.getNode(key1));
        System.out.println("Key" + key2 + "=>" + consistentHashing.getNode(key2));
        System.out.println("Key" + key3 + "=>" + consistentHashing.getNode(key3));
    }
}