package retrofit2;

/* loaded from: classes5.dex */
public class HttpException extends RuntimeException {
    private final int code;

    private static String getMessage(Response<?> response) {
        Utils.checkNotNull(response, "response == null");
        return "HTTP " + response.code() + " " + response.message();
    }

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.code();
        response.message();
    }

    public int code() {
        return this.code;
    }
}
