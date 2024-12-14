package org.lld.cor_pattern.logger_sink;

public class FileSink extends AbstractSink {
    @Override
    public void flush(String message, String level) {
        System.out.println("Flushed to file for: " + level);
    }
}
