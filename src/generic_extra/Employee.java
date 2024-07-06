package generic_extra;

import generic_extra.util.QueryItem;

public record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}
