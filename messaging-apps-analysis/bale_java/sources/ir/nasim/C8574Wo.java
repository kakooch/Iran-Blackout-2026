package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.Wo, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C8574Wo implements InterfaceC14735iO4 {
    private final Context a;
    private final WH1 b;
    private final long c;
    private final TS4 d;

    public /* synthetic */ C8574Wo(Context context, WH1 wh1, long j, TS4 ts4, ED1 ed1) {
        this(context, wh1, j, ts4);
    }

    @Override // ir.nasim.InterfaceC14735iO4
    public InterfaceC14124hO4 a() {
        return new C8340Vo(this.a, this.b, this.c, this.d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(C8574Wo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        C8574Wo c8574Wo = (C8574Wo) obj;
        return AbstractC13042fc3.d(this.a, c8574Wo.a) && AbstractC13042fc3.d(this.b, c8574Wo.b) && C24381yX0.q(this.c, c8574Wo.c) && AbstractC13042fc3.d(this.d, c8574Wo.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + C24381yX0.w(this.c)) * 31) + this.d.hashCode();
    }

    private C8574Wo(Context context, WH1 wh1, long j, TS4 ts4) {
        this.a = context;
        this.b = wh1;
        this.c = j;
        this.d = ts4;
    }
}
