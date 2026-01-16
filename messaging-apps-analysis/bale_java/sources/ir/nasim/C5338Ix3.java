package ir.nasim;

/* renamed from: ir.nasim.Ix3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5338Ix3 implements InterfaceC19920r98 {
    private SA2 a;
    private InterfaceC9102Ym4 b;
    private final InterfaceC9102Ym4 c = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);

    @Override // ir.nasim.InterfaceC19920r98
    public boolean a() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public void c(int i) {
        AbstractC20529s98.a.a().setValue(C11078ch5.a(i));
    }

    public final void d(SA2 sa2) {
        if (this.b == null) {
            this.a = sa2;
        }
    }

    public void e(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }
}
