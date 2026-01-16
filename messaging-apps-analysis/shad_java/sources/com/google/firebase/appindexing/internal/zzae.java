package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.appindexing.zzb;

/* compiled from: com.google.firebase:firebase-appindexing@@19.2.0 */
/* loaded from: classes3.dex */
public final class zzae {
    public static FirebaseAppIndexingException zza(Status status, String str) {
        Preconditions.checkNotNull(status);
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null && !statusMessage.isEmpty()) {
            str = statusMessage;
        }
        switch (status.getStatusCode()) {
            case 17510:
                return new FirebaseAppIndexingInvalidArgumentException(str);
            case 17511:
                return new FirebaseAppIndexingTooManyArgumentsException(str);
            case 17512:
            default:
                return new FirebaseAppIndexingException(str);
            case 17513:
                return new zzb(str);
            case 17514:
                return new com.google.firebase.appindexing.zza(str);
        }
    }
}
