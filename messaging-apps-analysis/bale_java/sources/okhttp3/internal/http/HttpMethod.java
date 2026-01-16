package okhttp3.internal.http;

import ir.nasim.AbstractC13042fc3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String method) {
        AbstractC13042fc3.i(method, "method");
        return (AbstractC13042fc3.d(method, "GET") || AbstractC13042fc3.d(method, "HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        AbstractC13042fc3.i(method, "method");
        return AbstractC13042fc3.d(method, "POST") || AbstractC13042fc3.d(method, "PUT") || AbstractC13042fc3.d(method, "PATCH") || AbstractC13042fc3.d(method, "PROPPATCH") || AbstractC13042fc3.d(method, "REPORT");
    }

    public final boolean invalidatesCache(String method) {
        AbstractC13042fc3.i(method, "method");
        return AbstractC13042fc3.d(method, "POST") || AbstractC13042fc3.d(method, "PATCH") || AbstractC13042fc3.d(method, "PUT") || AbstractC13042fc3.d(method, "DELETE") || AbstractC13042fc3.d(method, "MOVE");
    }

    public final boolean redirectsToGet(String method) {
        AbstractC13042fc3.i(method, "method");
        return !AbstractC13042fc3.d(method, "PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        AbstractC13042fc3.i(method, "method");
        return AbstractC13042fc3.d(method, "PROPFIND");
    }
}
