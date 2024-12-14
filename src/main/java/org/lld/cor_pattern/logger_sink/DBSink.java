package org.lld.cor_pattern.logger_sink;

public class DBSink extends AbstractSink {
    @Override
    public void flush(String message, String level) {
        System.out.println("Flushed to DB for :" + level);
    }
}
