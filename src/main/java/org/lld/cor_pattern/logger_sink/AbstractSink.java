package org.lld.cor_pattern.logger_sink;

public abstract class AbstractSink {

    public abstract void flush(String message, String level);
}
