package org.lld.cor_pattern;

import org.lld.cor_pattern.logger_sink.AbstractSink;
import org.lld.cor_pattern.logger_sink.DBSink;
import org.lld.cor_pattern.logger_sink.FileSink;

import java.util.ArrayList;
import java.util.List;

public class CORMain {

    public static void main(String[] args) {

        AbstractLogger logger = new InfoLogger(new WarnLogger(new ErrorLogger()));
//        AbstractSink fileSink = new FileSink();

        List<AbstractSink> sinkList = new ArrayList<>();
        sinkList.add(new DBSink());
        sinkList.add(new FileSink());


        logger.log("ERROR", "Warn message here", sinkList);
        logger.log("INFO", "Info message here", sinkList);
        logger.log("WARN", "Warn message here", sinkList);


    }
}
