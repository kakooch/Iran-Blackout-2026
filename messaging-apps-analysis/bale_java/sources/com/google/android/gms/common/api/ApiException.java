package com.google.android.gms.common.api;

/* loaded from: classes3.dex */
public class ApiException extends Exception {
    protected final Status a;

    public ApiException(Status status) {
        super(status.S() + ": " + (status.d0() != null ? status.d0() : ""));
        this.a = status;
    }

    public Status a() {
        return this.a;
    }

    public int getStatusCode() {
        return this.a.S();
    }
}
