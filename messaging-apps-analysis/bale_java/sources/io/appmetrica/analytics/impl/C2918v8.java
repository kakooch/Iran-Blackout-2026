package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.StateSerializer;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import java.io.IOException;

/* renamed from: io.appmetrica.analytics.impl.v8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2918v8 implements StateSerializer {
    public final StateSerializer a;
    public final AESEncrypter b;

    public C2918v8(StateSerializer<Object> stateSerializer, AESEncrypter aESEncrypter) {
        this.a = stateSerializer;
        this.b = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return this.a.defaultValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final byte[] toByteArray(Object obj) {
        try {
            return this.b.encrypt(this.a.toByteArray(obj));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object toState(byte[] bArr) throws IOException {
        try {
            return this.a.toState(this.b.decrypt(bArr));
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
