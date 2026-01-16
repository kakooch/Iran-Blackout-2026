package com.google.android.gms.measurement.internal;

import ir.nasim.Au8;
import java.util.List;

/* renamed from: com.google.android.gms.measurement.internal.z1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2336z1 implements Au8 {
    final /* synthetic */ B1 a;

    C2336z1(B1 b1) {
        this.a = b1;
    }

    @Override // ir.nasim.Au8
    public final void a(int i, String str, List list, boolean z, boolean z2) {
        int i2 = i - 1;
        C2217b1 c2217b1U = i2 != 0 ? i2 != 1 ? i2 != 3 ? i2 != 4 ? this.a.a.b().u() : z ? this.a.a.b().y() : !z2 ? this.a.a.b().x() : this.a.a.b().w() : this.a.a.b().v() : z ? this.a.a.b().t() : !z2 ? this.a.a.b().s() : this.a.a.b().r() : this.a.a.b().q();
        int size = list.size();
        if (size == 1) {
            c2217b1U.b(str, list.get(0));
            return;
        }
        if (size == 2) {
            c2217b1U.c(str, list.get(0), list.get(1));
        } else if (size != 3) {
            c2217b1U.a(str);
        } else {
            c2217b1U.d(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
