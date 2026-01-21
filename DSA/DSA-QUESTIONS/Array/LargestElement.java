import java.util.Arrays;
import java.util.List;

public class LargestElement {
    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(4,5,6,7,8,2,0);
        Integer largest = intList.get(0);
        for(int i=1;i<intList.size();i++){
            if(intList.get(i)>largest){
                largest = intList.get(i);

            }
        }
        System.out.println("Largest no: "+largest);
    }
}
