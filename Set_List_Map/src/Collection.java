import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Collection {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"张宇");
        map.put(2,"Google");
        map.put(3,"zhihu");
        String s = map.get(2);
        System.out.println(s);

        Set<Integer> set = map.keySet();
        for (int i : set){
            //map.get(下标)此方法取得是Map内的值
            System.out.println("key:" + i + ",value:" + map.get(i));
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            int key = it.next();

        }
    }
}
