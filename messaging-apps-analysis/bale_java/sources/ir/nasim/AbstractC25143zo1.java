package ir.nasim;

import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.zo1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC25143zo1 {

    /* renamed from: ir.nasim.zo1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C12889fL5 e;
        final /* synthetic */ InterfaceC20315ro1 f;
        final /* synthetic */ long g;
        final /* synthetic */ InterfaceC14603iB2 h;

        /* renamed from: ir.nasim.zo1$a$a, reason: collision with other inner class name */
        static final class C1823a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ long c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ Object e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1823a(long j, InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
                this.d = interfaceC14603iB2;
                this.e = obj;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1823a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    long j = this.c;
                    this.b = 1;
                    if (HG1.b(j, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            AbstractC10685c16.b(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                Object obj2 = this.e;
                this.b = 2;
                obj = interfaceC14603iB2.invoke(obj2, this);
                return obj == objE ? objE : obj;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1823a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, long j, InterfaceC14603iB2 interfaceC14603iB2) {
            super(1);
            this.e = c12889fL5;
            this.f = interfaceC20315ro1;
            this.g = j;
            this.h = interfaceC14603iB2;
        }

        public final void a(Object obj) {
            InterfaceC24823zG1 interfaceC24823zG1 = (InterfaceC24823zG1) this.e.a;
            if (interfaceC24823zG1 != null) {
                InterfaceC13730gj3.a.a(interfaceC24823zG1, null, 1, null);
            }
            this.e.a = AbstractC10533bm0.b(this.f, null, null, new C1823a(this.g, this.h, obj, null), 3, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(obj);
            return C19938rB7.a;
        }
    }

    public static final UA2 a(long j, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(interfaceC14603iB2, "destinationFunction");
        return new a(new C12889fL5(), interfaceC20315ro1, j, interfaceC14603iB2);
    }

    public static final void b(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "<this>");
        ua2.invoke(C19938rB7.a);
    }
}
