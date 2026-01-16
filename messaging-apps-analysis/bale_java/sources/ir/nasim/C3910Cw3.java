package ir.nasim;

/* renamed from: ir.nasim.Cw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3910Cw3 implements InterfaceC9664aL6 {
    private static final a e = new a(null);
    private final int a;
    private final int b;
    private final InterfaceC9102Ym4 c;
    private int d;

    /* renamed from: ir.nasim.Cw3$a */
    private static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C24411ya3 b(int i, int i2, int i3) {
            int i4 = (i / i2) * i2;
            return AbstractC23053wG5.y(Math.max(i4 - i3, 0), i4 + i2 + i3);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3910Cw3(int i, int i2, int i3) {
        this.a = i2;
        this.b = i3;
        this.c = AbstractC10222bH6.h(e.b(i, i2, i3), AbstractC10222bH6.s());
        this.d = i;
    }

    private void i(C24411ya3 c24411ya3) {
        this.c.setValue(c24411ya3);
    }

    @Override // ir.nasim.InterfaceC9664aL6
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C24411ya3 getValue() {
        return (C24411ya3) this.c.getValue();
    }

    public final void j(int i) {
        if (i != this.d) {
            this.d = i;
            i(e.b(i, this.a, this.b));
        }
    }
}
