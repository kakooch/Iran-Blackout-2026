package ir.nasim;

/* renamed from: ir.nasim.uF, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C21852uF implements LE2 {
    private volatile Object a;
    private final Object b = new Object();
    private final InterfaceC16287l11 c;

    public C21852uF(InterfaceC16287l11 interfaceC16287l11) {
        this.c = interfaceC16287l11;
    }

    @Override // ir.nasim.LE2
    public Object N2() {
        if (this.a == null) {
            synchronized (this.b) {
                try {
                    if (this.a == null) {
                        this.a = this.c.get();
                    }
                } finally {
                }
            }
        }
        return this.a;
    }
}
