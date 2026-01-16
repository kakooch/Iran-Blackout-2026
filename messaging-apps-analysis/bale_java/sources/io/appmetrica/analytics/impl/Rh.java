package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Rh implements InterfaceC2841s3 {
    public final Object a;
    public final InterfaceC2841s3 b;

    public Rh(Object obj, InterfaceC2841s3 interfaceC2841s3) {
        this.a = obj;
        this.b = interfaceC2841s3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2841s3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.a + ", metaInfo=" + this.b + '}';
    }
}
