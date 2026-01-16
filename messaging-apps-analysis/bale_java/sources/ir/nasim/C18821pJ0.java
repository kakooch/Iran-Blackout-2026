package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: ir.nasim.pJ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C18821pJ0 extends AbstractC20003rJ0 {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C18821pJ0.class, "consumed");
    private volatile int consumed;
    private final VI5 d;
    private final boolean e;

    public /* synthetic */ C18821pJ0(VI5 vi5, boolean z, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0, int i2, ED1 ed1) {
        this(vi5, z, (i2 & 4) != 0 ? C18712p72.a : interfaceC11938do1, (i2 & 8) != 0 ? -3 : i, (i2 & 16) != 0 ? EnumC6162Ml0.SUSPEND : enumC6162Ml0);
    }

    private final void q() {
        if (this.e && f.getAndSet(this, 1) != 0) {
            throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
        }
    }

    @Override // ir.nasim.AbstractC20003rJ0, ir.nasim.InterfaceC4557Fq2
    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (this.b != -3) {
            Object objB = super.b(interfaceC4806Gq2, interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
        q();
        Object objD = AbstractC6942Pq2.d(interfaceC4806Gq2, this.d, this.e, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected String h() {
        return "channel=" + this.d;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected Object j(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = AbstractC6942Pq2.d(new C7640So6(interfaceC16204ks5), this.d, this.e, interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.AbstractC20003rJ0
    protected AbstractC20003rJ0 l(InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        return new C18821pJ0(this.d, this.e, interfaceC11938do1, i, enumC6162Ml0);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public InterfaceC4557Fq2 m() {
        return new C18821pJ0(this.d, this.e, null, 0, null, 28, null);
    }

    @Override // ir.nasim.AbstractC20003rJ0
    public VI5 p(InterfaceC20315ro1 interfaceC20315ro1) {
        q();
        return this.b == -3 ? this.d : super.p(interfaceC20315ro1);
    }

    public C18821pJ0(VI5 vi5, boolean z, InterfaceC11938do1 interfaceC11938do1, int i, EnumC6162Ml0 enumC6162Ml0) {
        super(interfaceC11938do1, i, enumC6162Ml0);
        this.d = vi5;
        this.e = z;
        this.consumed = 0;
    }
}
