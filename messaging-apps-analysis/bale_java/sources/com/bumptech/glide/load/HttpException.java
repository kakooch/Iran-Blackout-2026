package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class HttpException extends IOException {
    private final int a;

    public HttpException(int i) {
        this("Http request failed", i);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, Throwable th) {
        super(str + ", status code: " + i, th);
        this.a = i;
    }
}
