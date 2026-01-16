package ir.nasim.core.runtime.http;

import ir.nasim.YS2;

/* loaded from: classes5.dex */
public class HTTPError extends Exception {
    private int a;
    private YS2 b;

    public HTTPError(int i, YS2 ys2) {
        this.a = i;
        this.b = ys2;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Header: " + this.b + ", ErrorCode: " + this.a;
    }

    public HTTPError(int i) {
        this.a = i;
    }
}
