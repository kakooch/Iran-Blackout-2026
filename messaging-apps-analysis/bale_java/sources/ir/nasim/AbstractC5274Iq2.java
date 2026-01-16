package ir.nasim;

/* renamed from: ir.nasim.Iq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5274Iq2 {

    /* renamed from: ir.nasim.Iq2$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC15796kB2 a;

        public a(InterfaceC15796kB2 interfaceC15796kB2) {
            this.a = interfaceC15796kB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objA = AbstractC5274Iq2.a(new b(this.a, interfaceC4806Gq2, null), interfaceC20295rm1);
            return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Iq2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC15796kB2 d;
        final /* synthetic */ InterfaceC4806Gq2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC15796kB2;
            this.e = interfaceC4806Gq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                InterfaceC4806Gq2 interfaceC4806Gq2 = this.e;
                this.b = 1;
                if (interfaceC15796kB2.q(interfaceC20315ro1, interfaceC4806Gq2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        C5040Hq2 c5040Hq2 = new C5040Hq2(interfaceC20295rm1.getContext(), interfaceC20295rm1);
        Object objB = AbstractC13419gB7.b(c5040Hq2, c5040Hq2, interfaceC14603iB2);
        if (objB == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objB;
    }

    public static final InterfaceC4557Fq2 b(InterfaceC15796kB2 interfaceC15796kB2) {
        return new a(interfaceC15796kB2);
    }
}
