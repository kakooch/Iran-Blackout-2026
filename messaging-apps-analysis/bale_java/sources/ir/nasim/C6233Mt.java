package ir.nasim;

/* renamed from: ir.nasim.Mt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6233Mt implements InterfaceC9664aL6 {
    private final InterfaceC5342Ix7 a;
    private final InterfaceC9102Ym4 b;
    private AbstractC8151Ut c;
    private long d;
    private long e;
    private boolean f;

    public C6233Mt(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, AbstractC8151Ut abstractC8151Ut, long j, long j2, boolean z) {
        AbstractC8151Ut abstractC8151UtE;
        this.a = interfaceC5342Ix7;
        this.b = AbstractC13472gH6.d(obj, null, 2, null);
        this.c = (abstractC8151Ut == null || (abstractC8151UtE = AbstractC8385Vt.e(abstractC8151Ut)) == null) ? AbstractC6483Nt.i(interfaceC5342Ix7, obj) : abstractC8151UtE;
        this.d = j;
        this.e = j2;
        this.f = z;
    }

    public final AbstractC8151Ut A() {
        return this.c;
    }

    public final boolean B() {
        return this.f;
    }

    public final void C(long j) {
        this.e = j;
    }

    public final void D(long j) {
        this.d = j;
    }

    public final void E(boolean z) {
        this.f = z;
    }

    public void F(Object obj) {
        this.b.setValue(obj);
    }

    public final void G(AbstractC8151Ut abstractC8151Ut) {
        this.c = abstractC8151Ut;
    }

    public final long f() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC9664aL6
    public Object getValue() {
        return this.b.getValue();
    }

    public final long i() {
        return this.d;
    }

    public final InterfaceC5342Ix7 j() {
        return this.a;
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + z() + ", isRunning=" + this.f + ", lastFrameTimeNanos=" + this.d + ", finishedTimeNanos=" + this.e + ')';
    }

    public final Object z() {
        return this.a.b().invoke(this.c);
    }

    public /* synthetic */ C6233Mt(InterfaceC5342Ix7 interfaceC5342Ix7, Object obj, AbstractC8151Ut abstractC8151Ut, long j, long j2, boolean z, int i, ED1 ed1) {
        this(interfaceC5342Ix7, obj, (i & 4) != 0 ? null : abstractC8151Ut, (i & 8) != 0 ? Long.MIN_VALUE : j, (i & 16) != 0 ? Long.MIN_VALUE : j2, (i & 32) != 0 ? false : z);
    }
}
