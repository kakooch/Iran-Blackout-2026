package ir.nasim;

/* loaded from: classes3.dex */
public final class C25 extends AbstractC19859r37 implements InterfaceC14603iB2 {
    int b;
    private /* synthetic */ Object c;
    final /* synthetic */ io.livekit.android.room.a d;
    final /* synthetic */ InterfaceC14603iB2 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C25(io.livekit.android.room.a aVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        super(2, interfaceC20295rm1);
        this.d = aVar;
        this.e = interfaceC14603iB2;
    }

    @Override // ir.nasim.E90
    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        C25 c25 = new C25(this.d, this.e, interfaceC20295rm1);
        c25.c = obj;
        return c25;
    }

    @Override // ir.nasim.E90
    public final Object invokeSuspend(Object obj) {
        Object objE = AbstractC14862ic3.e();
        int i = this.b;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return obj;
        }
        AbstractC10685c16.b(obj);
        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
        if (this.d.s()) {
            return null;
        }
        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
        this.b = 1;
        Object objInvoke = interfaceC14603iB2.invoke(interfaceC20315ro1, this);
        return objInvoke == objE ? objE : objInvoke;
    }

    @Override // ir.nasim.InterfaceC14603iB2
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
        return ((C25) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
    }
}
