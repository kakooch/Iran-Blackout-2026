package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* loaded from: classes3.dex */
public class FirebaseInstallationsException extends FirebaseException {
    private final a a;

    public enum a {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    public FirebaseInstallationsException(a aVar) {
        this.a = aVar;
    }

    public FirebaseInstallationsException(String str, a aVar) {
        super(str);
        this.a = aVar;
    }
}
