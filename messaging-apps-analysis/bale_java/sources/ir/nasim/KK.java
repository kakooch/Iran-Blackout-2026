package ir.nasim;

import ir.nasim.InterfaceC13730gj3;
import ir.nasim.KK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class KK {
    private final int a;
    private final InterfaceC20315ro1 b;
    private final List c;
    private final InterfaceC19699qn4 d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        final /* synthetic */ InterfaceC13730gj3 g;

        /* renamed from: ir.nasim.KK$a$a, reason: collision with other inner class name */
        static final class C0464a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            int e;
            final /* synthetic */ KK f;
            final /* synthetic */ InterfaceC13730gj3 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0464a(KK kk, InterfaceC13730gj3 interfaceC13730gj3, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.f = kk;
                this.g = interfaceC13730gj3;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0464a(this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                KK kk;
                InterfaceC19699qn4 interfaceC19699qn4;
                InterfaceC13730gj3 interfaceC13730gj3;
                Object objE = AbstractC14862ic3.e();
                int i = this.e;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC19699qn4 interfaceC19699qn42 = this.f.d;
                    kk = this.f;
                    InterfaceC13730gj3 interfaceC13730gj32 = this.g;
                    this.b = interfaceC19699qn42;
                    this.c = kk;
                    this.d = interfaceC13730gj32;
                    this.e = 1;
                    if (interfaceC19699qn42.a(null, this) == objE) {
                        return objE;
                    }
                    interfaceC19699qn4 = interfaceC19699qn42;
                    interfaceC13730gj3 = interfaceC13730gj32;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC13730gj3 = (InterfaceC13730gj3) this.d;
                    kk = (KK) this.c;
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                    AbstractC10685c16.b(obj);
                }
                try {
                    kk.c.remove(interfaceC13730gj3);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC19699qn4.e(null);
                    return C19938rB7.a;
                } catch (Throwable th) {
                    interfaceC19699qn4.e(null);
                    throw th;
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0464a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = interfaceC13730gj3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(KK kk, InterfaceC13730gj3 interfaceC13730gj3, Throwable th) {
            AbstractC10533bm0.d(kk.b, null, null, new C0464a(kk, interfaceC13730gj3, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KK.this.new a(this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            KK kk;
            InterfaceC13730gj3 interfaceC13730gj3;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC19699qn4 = KK.this.d;
                kk = KK.this;
                InterfaceC13730gj3 interfaceC13730gj32 = this.g;
                this.b = interfaceC19699qn4;
                this.c = kk;
                this.d = interfaceC13730gj32;
                this.e = 1;
                if (interfaceC19699qn4.a(null, this) == objE) {
                    return objE;
                }
                interfaceC13730gj3 = interfaceC13730gj32;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC13730gj3 = (InterfaceC13730gj3) this.d;
                kk = (KK) this.c;
                interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                AbstractC10685c16.b(obj);
            }
            try {
                if (kk.c.size() >= kk.a) {
                    InterfaceC13730gj3.a.a((InterfaceC13730gj3) kk.c.remove(0), null, 1, null);
                }
                kk.c.add(interfaceC13730gj3);
                interfaceC19699qn4.e(null);
                final InterfaceC13730gj3 interfaceC13730gj33 = this.g;
                final KK kk2 = KK.this;
                interfaceC13730gj33.s(new UA2() { // from class: ir.nasim.JK
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return KK.a.y(kk2, interfaceC13730gj33, (Throwable) obj2);
                    }
                });
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return KK.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            KK kk;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC19699qn4 = KK.this.d;
                KK kk2 = KK.this;
                this.b = interfaceC19699qn4;
                this.c = kk2;
                this.d = 1;
                if (interfaceC19699qn4.a(null, this) == objE) {
                    return objE;
                }
                kk = kk2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kk = (KK) this.c;
                interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                AbstractC10685c16.b(obj);
            }
            try {
                Iterator it = kk.c.iterator();
                while (it.hasNext()) {
                    InterfaceC13730gj3.a.a((InterfaceC13730gj3) it.next(), null, 1, null);
                }
                kk.c.clear();
                C19938rB7 c19938rB7 = C19938rB7.a;
                interfaceC19699qn4.e(null);
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public KK(int i, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        this.a = i;
        this.b = interfaceC20315ro1;
        this.c = new ArrayList();
        this.d = AbstractC20899sn4.b(false, 1, null);
    }

    public final void e(InterfaceC13730gj3 interfaceC13730gj3) {
        AbstractC13042fc3.i(interfaceC13730gj3, "job");
        AbstractC10533bm0.d(this.b, null, null, new a(interfaceC13730gj3, null), 3, null);
    }

    public final void f() {
        AbstractC10533bm0.d(this.b, null, null, new b(null), 3, null);
    }
}
