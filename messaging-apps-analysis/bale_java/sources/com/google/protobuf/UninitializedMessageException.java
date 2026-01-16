package com.google.protobuf;

import java.util.List;

/* loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    private final List a;

    public UninitializedMessageException(P p) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
