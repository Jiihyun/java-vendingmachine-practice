package vendingmachine.view;

import vendingmachine.io.writer.Writer;

import java.util.function.Supplier;

public class RetryHandler {
    private final Writer writer;

    public RetryHandler(Writer writer) {
        this.writer = writer;
    }

    public <T> T retryUntilSuccess(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                writer.writeln(exception.getMessage());
            }
        }
    }
}
