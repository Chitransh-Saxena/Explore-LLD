package org.lld.cor_pattern;

import org.lld.cor_pattern.logger_sink.AbstractSink;

import java.util.List;

public class WarnLogger extends AbstractLogger {

    public WarnLogger(AbstractLogger nextLogger) {
        super(nextLogger);
    }

    public void log(String level, String message, List<AbstractSink> sinks) {

        if("WARN".equals(level)) {
            System.out.println("WARN::" + "Warn message here");

            for(AbstractSink sink : sinks)
                sink.flush(message, level);
        }
        else {
            super.log(level, message, sinks);
        }
    }
}
