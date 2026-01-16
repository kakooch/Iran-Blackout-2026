package ir.nasim;

/* loaded from: classes8.dex */
public abstract class WM3 extends AbstractC13778go1 {
    @Override // ir.nasim.AbstractC13778go1
    public AbstractC13778go1 B0(int i) {
        AbstractC3703Bz3.a(i);
        return this;
    }

    public abstract WM3 C0();

    protected final String D0() {
        WM3 wm3C0;
        WM3 wm3C = C12366eV1.c();
        if (this == wm3C) {
            return "Dispatchers.Main";
        }
        try {
            wm3C0 = wm3C.C0();
        } catch (UnsupportedOperationException unused) {
            wm3C0 = null;
        }
        if (this == wm3C0) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
