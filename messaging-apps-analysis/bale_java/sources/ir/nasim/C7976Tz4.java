package ir.nasim;

/* renamed from: ir.nasim.Tz4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7976Tz4 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ C7737Sz4 d;
    final /* synthetic */ InterfaceC14603iB2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7976Tz4(C7737Sz4 c7737Sz4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.d = c7737Sz4;
        this.e = interfaceC14603iB2;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        C7976Tz4 c7976Tz4 = new C7976Tz4(this.d, this.e, interfaceC20295rm1);
        c7976Tz4.c = obj;
        return c7976Tz4;
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        AbstractC14862ic3.e();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC10685c16.b(obj);
        return AbstractC10533bm0.d((InterfaceC20315ro1) this.c, this.d.x, null, this.e, 2, null);
    }

    @Override // ir.nasim.InterfaceC14603iB2
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((C7976Tz4) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
