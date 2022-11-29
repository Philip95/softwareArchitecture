package com.mycompany.sa.utility;

import java.util.List;
import java.util.stream.Collectors;

public class ListHelper {

    public static List<String> removeEmptyElements(List<String> list) {
        return list.stream()
                .filter(item -> item != null && !item.isEmpty())
                .collect(Collectors.toList());
    }
}
