package com.google.android.gms.internal.vision;

import ir.nasim.Br8;
import ir.nasim.InterfaceC18561or8;

/* loaded from: classes3.dex */
final class N0 implements C0 {
    private final InterfaceC18561or8 a;
    private final String b;
    private final Object[] c;
    private final int d;

    N0(InterfaceC18561or8 interfaceC18561or8, String str, Object[] objArr) {
        this.a = interfaceC18561or8;
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

    @Override // com.google.android.gms.internal.vision.C0
    public final boolean c() {
        return (this.d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.vision.C0
    public final InterfaceC18561or8 e() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.vision.C0
    public final int zza() {
        return (this.d & 1) == 1 ? Br8.a : Br8.b;
    }
}
