package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;

/* loaded from: classes3.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature a;

    public UnsupportedApiCallException(Feature feature) {
        this.a = feature;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.a));
    }
}
