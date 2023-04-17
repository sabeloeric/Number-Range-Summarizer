package numberrangesummarizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new LinkedList<>();
        for (String str : input.split(",")) {
            try {
                int num = Integer.parseInt(str.trim());
                numbers.add(num);
            } catch (NumberFormatException e) {
                // ignore non-numeric input
            }
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> sortedList = input.stream().sorted().toList();
        List<String> summaryList = new LinkedList<>();
        int rangeStart = sortedList.get(0);
        int rangeEnd = rangeStart;
        for (int i = 1; i < sortedList.size(); i++) {
            int current = sortedList.get(i);
            if (current == rangeEnd + 1) {
                rangeEnd = current;
            } else {
                if (rangeStart == rangeEnd) {
                    summaryList.add(String.valueOf(rangeStart));
                } else {
                    summaryList.add(rangeStart + "-" + rangeEnd);
                }
                rangeStart = current;
                rangeEnd = current;
            }
        }
        if (rangeStart == rangeEnd) {
            summaryList.add(String.valueOf(rangeStart));
        } else {
            summaryList.add(rangeStart + "-" + rangeEnd);
        }
        return String.join(", ", summaryList);
    }
}
