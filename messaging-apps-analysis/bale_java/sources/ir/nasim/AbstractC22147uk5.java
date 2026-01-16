package ir.nasim;

/* renamed from: ir.nasim.uk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22147uk5 {

    /* renamed from: ir.nasim.uk5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4772Gm4 c4772Gm4 = (C4772Gm4) this.c;
                AbstractC10685c16.b(obj);
                return c4772Gm4;
            }
            AbstractC10685c16.b(obj);
            C4772Gm4 c4772Gm4C = ((AbstractC19670qk5) this.c).c();
            InterfaceC14603iB2 interfaceC14603iB2 = this.d;
            this.c = c4772Gm4C;
            this.b = 1;
            return interfaceC14603iB2.invoke(c4772Gm4C, this) == objE ? objE : c4772Gm4C;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC19670qk5 abstractC19670qk5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(abstractC19670qk5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(InterfaceC23475wz1 interfaceC23475wz1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return interfaceC23475wz1.a(new a(interfaceC14603iB2, null), interfaceC20295rm1);
    }
}
