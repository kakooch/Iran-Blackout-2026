package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class x1 extends y1 {
    x1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(k(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(j(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.z1.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.z1.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.measurement.z1.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.measurement.z1.o(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.y1
    public final void c(Object obj, long j, boolean z) {
        if (z1.h) {
            z1.n(obj, j, z);
        } else {
            z1.o(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final void d(Object obj, long j, byte b) {
        if (z1.h) {
            z1.d(obj, j, b);
        } else {
            z1.e(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final void e(Object obj, long j, double d) {
        o(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final void f(Object obj, long j, float f) {
        n(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.y1
    public final boolean g(Object obj, long j) {
        return z1.h ? z1.y(obj, j) : z1.z(obj, j);
    }
}
