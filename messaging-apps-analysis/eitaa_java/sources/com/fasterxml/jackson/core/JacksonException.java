package com.fasterxml.jackson.core;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class JacksonException extends IOException {
    protected JacksonException(String str) {
        super(str);
    }

    protected JacksonException(String str, Throwable th) {
        super(str, th);
    }
}
