package generic_extra.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueryList<T extends Student & QueryItem> extends ArrayList<T> {

    public QueryList(){}
    public QueryList(List<T> items){
        super(items);
    }
//
    public List<T> getMatches(String field,String value){
        QueryList<T> matches = new QueryList<T>();
        for (var item: this){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
