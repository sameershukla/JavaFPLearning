package com.example.fp.basics.utils;

import java.util.function.Supplier;

public abstract class Try<T> {
    public abstract boolean isSuccess();

    public abstract T get() throws Exception;

    public abstract Exception getException();

    public static <T> Try<T> of(Supplier<T> f) {
        try {
            return new Success<>(f.get());
        } catch (Exception e) {
            return new Failure<>(e);
        }
    }

    private static class Success<T> extends Try<T> {
        private final T value;

        private Success(T value) {
            this.value = value;
        }

        public boolean isSuccess() {
            return true;
        }

        public T get() throws Exception {
            return value;
        }

        public Exception getException() {
            throw new IllegalStateException("Success.getException");
        }
    }

    private static class Failure<T> extends Try<T> {
        private final Exception exception;

        private Failure(Exception exception) {
            this.exception = exception;
        }

        public boolean isSuccess() {
            return false;
        }

        public T get() throws Exception {
            throw exception;
        }

        public Exception getException() {
            return exception;
        }
    }
}
