package Romeo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Romeo {
    public static void main(String[] args) {
        String prologue = "Friar Laurence: Two households, both alike in dignityIn fair Verona, where we lay our scene" +
                " From ancient grudge break to new mutiny. Where civil blood makes civil hands unclean." +
                " From forth the fatal loins of these two foes. A pair of star-crossed lovers take their life" +
                " Whose misadventured piteous overthrows. Do with their death bury their parents strife" +
                " The fearful passage of their death marked love. And the continuance of their parents’s rage" +
                " Which but their childrens? end, nought could remove. Is now the two hours traffic of our stage" +
                " The which if you with patient ears attend What here shall miss, our toil shall strive to mend.";


        ArrayList<String> stringArrayList= new ArrayList<String>(Arrays.asList(prologue.split(" ")));
        Collections.sort(stringArrayList);


        //----------------------------------EXERCICE 2 && 3----------------------------//


         Stream<String> stream = stringArrayList.stream().filter(str -> str.length() > 2);
         List<String> list = stream.collect(Collectors.toList());
        ArrayList<String> filteredArray = new ArrayList<String>(list);
        Set<String> stringSet = new LinkedHashSet<String>(filteredArray);
        for(String str : stringSet) {
           System.out.println(str);
        }

        //-------------------------------EXERCICE 4----------------------//


        for(String str : stringSet) {
            System.out.println("exerice 4");
            System.out.println(str + " : " + Collections.frequency(stringArrayList, str));
        }



        //--------------------EXERCICE 5 ----------------------------------------
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();

        for(String str : stringSet) {
            map.put(str, Collections.frequency(filteredArray, str));
        }

        ArrayList<Map.Entry<String, Integer>>  mapList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<String, Integer> entry : mapList) {
            System.out.println("Exercice 5");
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //--------------------------EXERCICE 6-------------------------------------------//
        System.out.println("Exercice 6");
        Collection<Integer> indexArray = new ArrayList<Integer>();
        for(Map.Entry<String, Integer> entry : mapList) {
            int fromIndex = 0;
            for(int i = 0; i < entry.getValue(); i++) {
                indexArray.add(prologue.indexOf(entry.getKey(), fromIndex));
                fromIndex = prologue.indexOf(entry.getKey(), fromIndex) + 1;
            }
            System.out.println(entry.getKey() + " : " + entry.getValue() + "" + indexArray);
            indexArray.clear();
        }
    }
}
