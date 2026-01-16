package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* loaded from: classes6.dex */
public final class GS extends VW7 {
    private final SettingsModule b;
    private final InterfaceC9102Ym4 c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;
    private final InterfaceC9102Ym4 f;
    private final InterfaceC9102Ym4 g;
    private final InterfaceC9102Ym4 h;
    private final InterfaceC9102Ym4 i;
    private final InterfaceC9102Ym4 j;
    private final InterfaceC9102Ym4 k;
    private final InterfaceC9102Ym4 l;

    public GS(SettingsModule settingsModule) {
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = settingsModule;
        this.c = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.q5()), null, 2, null);
        this.d = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.r5()), null, 2, null);
        this.e = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.o5()), null, 2, null);
        this.f = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.p5()), null, 2, null);
        this.g = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.s5()), null, 2, null);
        this.h = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.l5()), null, 2, null);
        this.i = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.m5()), null, 2, null);
        this.j = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.j5()), null, 2, null);
        this.k = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.k5()), null, 2, null);
        this.l = AbstractC13472gH6.d(Boolean.valueOf(settingsModule.n5()), null, 2, null);
    }

    private final void m1(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
    }

    private final void o1(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    private final void p1(boolean z) {
        this.k.setValue(Boolean.valueOf(z));
    }

    private final void q1(boolean z) {
        this.f.setValue(Boolean.valueOf(z));
    }

    private final void s1(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    private final void t1(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    private final void u1(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }

    private final void v1(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    private final void w1(boolean z) {
        this.l.setValue(Boolean.valueOf(z));
    }

    private final void x1(boolean z) {
        this.g.setValue(Boolean.valueOf(z));
    }

    public final void P0(boolean z) {
        m1(z);
        this.b.i6(z);
    }

    public final void R0(boolean z) {
        o1(z);
        this.b.n6(z);
    }

    public final void S0(boolean z) {
        p1(z);
        this.b.j6(z);
    }

    public final void T0(boolean z) {
        q1(z);
        this.b.o6(z);
    }

    public final void U0(boolean z) {
        s1(z);
        this.b.k6(z);
    }

    public final void V0(boolean z) {
        t1(z);
        this.b.p6(z);
    }

    public final void W0(boolean z) {
        u1(z);
        this.b.l6(z);
    }

    public final void X0(boolean z) {
        v1(z);
        this.b.q6(z);
    }

    public final void Y0(boolean z) {
        w1(z);
        this.b.m6(z);
    }

    public final void Z0(boolean z) {
        x1(z);
        this.b.r6(z);
    }

    public final boolean a1() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    public final boolean b1() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final boolean c1() {
        return ((Boolean) this.k.getValue()).booleanValue();
    }

    public final boolean d1() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final boolean e1() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    public final boolean f1() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final int g1() {
        return this.b.B0();
    }

    public final boolean h1() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    public final boolean i1() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final boolean j1() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    public final boolean k1() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    public final void l1(int i) {
        this.b.h6(i);
    }

    public final boolean y1() {
        return f1() || i1() || b1() || d1() || k1() || e1() || h1() || a1() || c1() || j1();
    }
}
