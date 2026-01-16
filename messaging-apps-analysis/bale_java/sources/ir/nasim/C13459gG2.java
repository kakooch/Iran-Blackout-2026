package ir.nasim;

/* renamed from: ir.nasim.gG2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C13459gG2 extends AbstractC19859r37 implements UA2 {
    int b;

    public C13459gG2(InterfaceC20295rm1 interfaceC20295rm1) {
        super(1, interfaceC20295rm1);
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
        return new C13459gG2(interfaceC20295rm1);
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        AbstractC14862ic3.e();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC10685c16.b(obj);
        return C19938rB7.a;
    }

    @Override // ir.nasim.UA2
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
        return ((C13459gG2) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
