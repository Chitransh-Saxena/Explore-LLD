package org.lld.cor_pattern;

import org.lld.cor_pattern.logger_sink.AbstractSink;

import java.util.List;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(AbstractLogger nextLogger) {
        super(nextLogger);
    }

    public InfoLogger() {
    }

    public void log(String level, String message, List<AbstractSink> sinks) {

        if(level.equals("INFO")) {
            System.out.println("INFO :: " + message);

            for(AbstractSink sink : sinks)
                sink.flush(message, level);
        }
        else {

            super.log(level, message, sinks);
        }
    }
}
