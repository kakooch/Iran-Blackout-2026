package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;

/* renamed from: io.appmetrica.analytics.impl.m3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2698m3 {
    public final C2674l3 a;
    public final GZIPCompressor b;

    public C2698m3() {
        this(new C2674l3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C2674l3 c2674l3 = this.a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c2674l3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, bArrCopyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C2698m3(C2674l3 c2674l3, GZIPCompressor gZIPCompressor) {
        this.a = c2674l3;
        this.b = gZIPCompressor;
    }
}
