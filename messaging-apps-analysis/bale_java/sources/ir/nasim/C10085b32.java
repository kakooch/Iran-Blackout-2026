package ir.nasim;

import android.content.Context;
import android.widget.EdgeEffect;

/* renamed from: ir.nasim.b32, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C10085b32 {
    private final Context a;
    private final int b;
    private long c = C4414Fa3.b.a();
    private EdgeEffect d;
    private EdgeEffect e;
    private EdgeEffect f;
    private EdgeEffect g;
    private EdgeEffect h;
    private EdgeEffect i;
    private EdgeEffect j;
    private EdgeEffect k;

    public C10085b32(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    private final EdgeEffect e(EnumC24286yM4 enumC24286yM4) {
        EdgeEffect edgeEffectB = Z22.a.b(this.a);
        edgeEffectB.setColor(this.b);
        if (!C4414Fa3.e(this.c, C4414Fa3.b.a())) {
            if (enumC24286yM4 == EnumC24286yM4.a) {
                long j = this.c;
                edgeEffectB.setSize((int) (j >> 32), (int) (j & 4294967295L));
            } else {
                long j2 = this.c;
                edgeEffectB.setSize((int) (j2 & 4294967295L), (int) (j2 >> 32));
            }
        }
        return edgeEffectB;
    }

    private final boolean o(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    private final boolean y(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(Z22.a.c(edgeEffect) == 0.0f);
    }

    public final boolean A() {
        return y(this.h);
    }

    public final boolean B() {
        return y(this.d);
    }

    public final void C(long j) {
        this.c = j;
        EdgeEffect edgeEffect = this.d;
        if (edgeEffect != null) {
            edgeEffect.setSize((int) (j >> 32), (int) (j & 4294967295L));
        }
        EdgeEffect edgeEffect2 = this.e;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize((int) (j >> 32), (int) (j & 4294967295L));
        }
        EdgeEffect edgeEffect3 = this.f;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize((int) (j & 4294967295L), (int) (j >> 32));
        }
        EdgeEffect edgeEffect4 = this.g;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize((int) (j & 4294967295L), (int) (j >> 32));
        }
        EdgeEffect edgeEffect5 = this.h;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize((int) (j >> 32), (int) (j & 4294967295L));
        }
        EdgeEffect edgeEffect6 = this.i;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize((int) (j >> 32), (int) (j & 4294967295L));
        }
        EdgeEffect edgeEffect7 = this.j;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize((int) (j & 4294967295L), (int) (j >> 32));
        }
        EdgeEffect edgeEffect8 = this.k;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize((int) (4294967295L & j), (int) (j >> 32));
        }
    }

    public final void f() {
        EdgeEffect edgeEffect = this.d;
        if (edgeEffect != null) {
            edgeEffect.finish();
        }
        EdgeEffect edgeEffect2 = this.e;
        if (edgeEffect2 != null) {
            edgeEffect2.finish();
        }
        EdgeEffect edgeEffect3 = this.f;
        if (edgeEffect3 != null) {
            edgeEffect3.finish();
        }
        EdgeEffect edgeEffect4 = this.g;
        if (edgeEffect4 != null) {
            edgeEffect4.finish();
        }
        EdgeEffect edgeEffect5 = this.h;
        if (edgeEffect5 != null) {
            edgeEffect5.finish();
        }
        EdgeEffect edgeEffect6 = this.i;
        if (edgeEffect6 != null) {
            edgeEffect6.finish();
        }
        EdgeEffect edgeEffect7 = this.j;
        if (edgeEffect7 != null) {
            edgeEffect7.finish();
        }
        EdgeEffect edgeEffect8 = this.k;
        if (edgeEffect8 != null) {
            edgeEffect8.finish();
        }
    }

    public final EdgeEffect g() {
        EdgeEffect edgeEffect = this.e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.a);
        this.e = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect h() {
        EdgeEffect edgeEffect = this.i;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.a);
        this.i = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect i() {
        EdgeEffect edgeEffect = this.f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.b);
        this.f = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect j() {
        EdgeEffect edgeEffect = this.j;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.b);
        this.j = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect k() {
        EdgeEffect edgeEffect = this.g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.b);
        this.g = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect l() {
        EdgeEffect edgeEffect = this.k;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.b);
        this.k = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect m() {
        EdgeEffect edgeEffect = this.d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.a);
        this.d = edgeEffectE;
        return edgeEffectE;
    }

    public final EdgeEffect n() {
        EdgeEffect edgeEffect = this.h;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect edgeEffectE = e(EnumC24286yM4.a);
        this.h = edgeEffectE;
        return edgeEffectE;
    }

    public final boolean p() {
        return o(this.e);
    }

    public final boolean q() {
        return y(this.i);
    }

    public final boolean r() {
        return y(this.e);
    }

    public final boolean s() {
        return o(this.f);
    }

    public final boolean t() {
        return y(this.j);
    }

    public final boolean u() {
        return y(this.f);
    }

    public final boolean v() {
        return o(this.g);
    }

    public final boolean w() {
        return y(this.k);
    }

    public final boolean x() {
        return y(this.g);
    }

    public final boolean z() {
        return o(this.d);
    }
}
