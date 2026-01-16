package ir.nasim;

import ir.nasim.InterfaceC14371ho1;
import ir.nasim.QA7;

/* loaded from: classes6.dex */
public final class P7 extends VW7 {
    private AH0 b = AH0.a;
    private InterfaceC9336Zm4 c;
    private final InterfaceC10258bL6 d;
    private InterfaceC14371ho1 e;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Throwable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = th;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return P7.this.new a(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = P7.this.c;
                String message = this.d.getMessage();
                if (message == null) {
                    message = "";
                }
                QA7.a aVar = new QA7.a(new Exception(message));
                this.b = 1;
                if (interfaceC9336Zm4.a(aVar, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class b extends L0 implements InterfaceC14371ho1 {
        final /* synthetic */ P7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC14371ho1.a aVar, P7 p7) {
            super(aVar);
            this.b = p7;
        }

        @Override // ir.nasim.InterfaceC14371ho1
        public void m(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this.b), null, null, this.b.new a(th, null), 3, null);
        }
    }

    public P7() {
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(QA7.b.a);
        this.c = interfaceC9336Zm4A;
        this.d = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        this.e = new b(InterfaceC14371ho1.h0, this);
    }
}
