package StringAnalyzer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringOccurenceAnalyzer {

    public List<StringOccurence> analyse(List<String> words){

        HashMap<String, Integer> occurences = new HashMap<>();

        //check word occurence and update it
        for(String word: words){
            if(occurences.containsKey(word)){
                int n = occurences.get(word);
                n++;
                occurences.put(word, n);
            }else{
                occurences.put(word, 1);
            }
        }

        //new List to save the word and its occurence
        ArrayList<StringOccurence> list = new ArrayList<>();
        for(Map.Entry<String, Integer> i : occurences.entrySet()){
            StringOccurence item = new StringOccurence(i.getKey(), i.getValue());
            list.add(item);
        }

        list.sort((o1, o2) -> -Integer.compare(o1.getOccurence(), o2.getOccurence()));

        /*another possibility for list sorting
		Collections.sort(list, new Comparator<StringOccurence>() {
			@Override
			public int compare(StringOccurence o1, StringOccurence o2) {
				if(o1.getOccurence() < o2.getOccurence()) {
					return 1;
				}else if(o1.getOccurence() == o2.getOccurence()){
					return 0;
				}else {
					return -1;
				}
			}
		});*/


        return list;
    }
}
