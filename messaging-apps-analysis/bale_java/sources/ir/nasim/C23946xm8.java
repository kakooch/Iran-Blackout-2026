package ir.nasim;

import android.os.Bundle;

/* renamed from: ir.nasim.xm8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C23946xm8 extends Cm8 {
    final /* synthetic */ Long e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ Bundle h;
    final /* synthetic */ boolean i;
    final /* synthetic */ boolean j;
    final /* synthetic */ C15566jn8 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C23946xm8(C15566jn8 c15566jn8, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(c15566jn8, true);
        this.k = c15566jn8;
        this.e = l;
        this.f = str;
        this.g = str2;
        this.h = bundle;
        this.i = z;
        this.j = z2;
    }

    @Override // ir.nasim.Cm8
    final void a() {
        Long l = this.e;
        ((InterfaceC15546jl8) AbstractC3795Cj5.j(this.k.i)).logEvent(this.f, this.g, this.h, this.i, this.j, l == null ? this.a : l.longValue());
    }
}
