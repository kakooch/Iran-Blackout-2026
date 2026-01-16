package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;

/* loaded from: classes3.dex */
public final class jn implements Ea {
    @Override // io.appmetrica.analytics.impl.Ea
    public final String a(Context context) {
        ProtobufStateStorage<Object> protobufStateStorageA;
        C2644jl c2644jl;
        try {
            Rl rlA = Ql.a(C2644jl.class);
            if (rlA != null && (protobufStateStorageA = rlA.a(context, rlA.c(context))) != null && (c2644jl = (C2644jl) protobufStateStorageA.read()) != null) {
                return c2644jl.a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
