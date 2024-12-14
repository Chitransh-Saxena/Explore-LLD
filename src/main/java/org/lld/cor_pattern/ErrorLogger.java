package org.lld.cor_pattern;

import org.lld.cor_pattern.logger_sink.AbstractSink;

import java.util.List;

public class ErrorLogger extends AbstractLogger {

    public void log(String level, String message, List<AbstractSink> sinks) {
        System.out.println(level + "::" + message);

        for(AbstractSink sink : sinks)
            sink.flush(message , level);
    }
}
