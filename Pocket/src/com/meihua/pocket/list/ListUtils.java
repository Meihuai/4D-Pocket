package com.meihua.pocket.list;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author meihua.hu
 */
public class ListUtils {

    public static <T> void BatchExecuteByDay(LocalDate beginDate, LocalDate endDate,
                                              Function<Pair<LocalDate,LocalDate>, List<T>> supplier,
                                              Consumer<List<T>> consumer){

        //log.info("BatchExecuteByDay start! beginDate:{}  endDate: {}",beginDate,endDate);
        LocalDate startDate = beginDate;
        LocalDate finishDate =endDate;
        while (startDate.compareTo(finishDate)<=0) {
            List<T>  list = supplier.apply(Pair.of(startDate, startDate.plusDays(1)));
        //log.info("DateExecuteUtils execute  startDate:{} finishDate:{} list size:{}",startDate,finishDate,list.size());
            consumer.accept(list);
            startDate = startDate.plusDays(1);
        }
        //log.info("BatchExecuteByDay done! beginDate:{}  endDate: {}",beginDate,endDate);
    }
}
