package com.github.javacodekata.lambda.stream;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ListTransformer {

    private final List<String> values;


    private ListTransformer(List<String> values) {
        this.values = values;
    }


    public static ListTransformer of(List<String> values) {
        checkNotNull(values);
        return new ListTransformer(ImmutableList.copyOf(values));
    }


    /**
     * This method should take the String List and sort all the String elements in ascending (ASCII) order.
     *
     * @return The sorted values in ascending ASCII order.
     */
    public List<String> getSortedStrings() {
        List<String> copyOfValues = new ArrayList<>(values);

        Collections.sort(copyOfValues);

        return copyOfValues;
    }


    /**
     * This method should take the String List and:
     * <ol>
     * <li>filter the elements that contains one or more digits;</li>
     * <li>transform (map) the remaining Strings into Integers;</li>
     * <li>sort the Integers in ascending order.</li>
     * </ol>
     *
     * @return
     */
    public List<Integer> getSortedIntegers() {
        List<String> copyOfValues = new ArrayList<>(values);

        CollectionUtils.filter(copyOfValues, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return ((String) object).matches("\\d+");
            }
        });

        Collection<Integer> integers = (Collection<Integer>) CollectionUtils.collect(copyOfValues, new Transformer() {
            @Override
            public Object transform(Object input) {
                return Integer.valueOf((String) input);
            }
        });

        ArrayList<Integer> integersList = new ArrayList<>(integers);

        Collections.sort(integersList);

        return integersList;
    }


    /**
     * This method should take the String List and:
     * <ol>
     * <li>filter the elements that contains one or more digits;</li>
     * <li>transform (map) the remaining Strings into Integers;</li>
     * <li>sort the Integers in descending order.</li>
     * </ol>
     *
     * @return
     */
    public List<Integer> getSortedDescendingIntegers() {
        List<String> copyOfValues = new ArrayList<>(values);

        CollectionUtils.filter(copyOfValues, new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return ((String) object).matches("\\d+");
            }
        });

        Collection<Integer> integers = (Collection<Integer>) CollectionUtils.collect(copyOfValues, new Transformer() {
            @Override
            public Object transform(Object input) {
                return Integer.valueOf((String) input);
            }
        });

        ArrayList<Integer> integersList = new ArrayList<>(integers);

        Collections.sort(integersList, Collections.reverseOrder());

        return integersList;
    }

}
