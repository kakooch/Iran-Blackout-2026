package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.r3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2817r3 implements InterfaceC2841s3 {
    public final int a;

    public C2817r3(int i) {
        this.a = i;
    }

    public static InterfaceC2841s3 a(InterfaceC2841s3... interfaceC2841s3Arr) {
        return new C2817r3(b(interfaceC2841s3Arr));
    }

    public static int b(InterfaceC2841s3... interfaceC2841s3Arr) {
        int bytesTruncated = 0;
        for (InterfaceC2841s3 interfaceC2841s3 : interfaceC2841s3Arr) {
            if (interfaceC2841s3 != null) {
                bytesTruncated = interfaceC2841s3.getBytesTruncated() + bytesTruncated;
            }
        }
        return bytesTruncated;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2841s3
    public final int getBytesTruncated() {
        return this.a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.a + '}';
    }
}
