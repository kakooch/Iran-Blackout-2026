package com.google.android.gms.internal.firebase_messaging;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzac implements ObjectEncoder {
    static final ObjectEncoder zza = new zzac();

    private zzac() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object obj, Object obj2) {
        int i = zzad.zza;
        String strValueOf = String.valueOf(obj.getClass().getCanonicalName());
        throw new EncodingException(strValueOf.length() != 0 ? "Couldn't find encoder for type ".concat(strValueOf) : new String("Couldn't find encoder for type "));
    }
}
