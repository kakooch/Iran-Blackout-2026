package com.google.firebase;

import ir.nasim.AbstractC3795Cj5;

/* loaded from: classes3.dex */
public class FirebaseException extends Exception {
    @Deprecated
    protected FirebaseException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseException(String str) {
        super(str);
        AbstractC3795Cj5.g(str, "Detail message must not be empty");
    }
}
