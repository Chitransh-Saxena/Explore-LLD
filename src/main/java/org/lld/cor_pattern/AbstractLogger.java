package org.lld.cor_pattern;

import org.lld.cor_pattern.logger_sink.AbstractSink;

import java.util.List;

public abstract class AbstractLogger {

    public AbstractLogger() {
    }

    private AbstractSink logSink;

    public AbstractSink getLogSink() {
        return logSink;
    }

    public void setLogSink(AbstractSink logSink) {
        this.logSink = logSink;
    }

    AbstractLogger nextLogger;

    public AbstractLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }


    public void log(String level, String message, List<AbstractSink> sink) {

        if(nextLogger == null)  throw new IllegalCallerException("Next logger not instantiated");
        if(nextLogger != null)  {
            System.out.println("Calling next level");
            nextLogger.log(level, message, sink);

        }
    }
}
