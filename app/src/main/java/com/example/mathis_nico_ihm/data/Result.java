package com.example.mathis_nico_ihm.data;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }
// Commentaire de Mathis Petit
    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }
//Commentaire test GitHub
    // Success sub-class
    public final static class Success<T> extends Result {
        private T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }
// COmmentaire numéro 2
    // Error sub-class
    public final static class Error extends Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}