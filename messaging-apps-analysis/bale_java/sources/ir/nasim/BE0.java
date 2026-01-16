package ir.nasim;

/* loaded from: classes2.dex */
public final class BE0 implements InterfaceC20346rr2 {
    private final int a;
    private boolean b;

    public /* synthetic */ BE0(int i, ED1 ed1) {
        this(i);
    }

    @Override // ir.nasim.InterfaceC20346rr2
    public void a() {
        this.b = true;
    }

    @Override // ir.nasim.InterfaceC20346rr2
    public int b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    private BE0(int i) {
        this.a = i;
    }
}
