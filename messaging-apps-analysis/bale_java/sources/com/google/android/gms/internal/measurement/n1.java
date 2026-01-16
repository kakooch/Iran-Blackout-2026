package com.google.android.gms.internal.measurement;

import ir.nasim.Qr8;

/* loaded from: classes3.dex */
final class n1 implements InterfaceC2113d1 {
    private final Qr8 a;
    private final String b;
    private final Object[] c;
    private final int d;

    n1(Qr8 qr8, String str, Object[] objArr) {
        this.a = qr8;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String a() {
        return this.b;
    }

    final Object[] b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2113d1
    public final boolean c() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2113d1
    public final int e() {
        return (this.d & 1) == 1 ? 1 : 2;
    }

    @Override // com.google.android.gms.internal.measurement.InterfaceC2113d1
    public final Qr8 zza() {
        return this.a;
    }
}
