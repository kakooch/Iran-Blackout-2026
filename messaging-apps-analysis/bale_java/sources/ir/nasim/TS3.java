package ir.nasim;

import ir.nasim.C22698vg6;
import ir.nasim.TS3;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class TS3 extends VW7 {
    private QQ3 b;
    private final UG7 c;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ TS3 d;
        final /* synthetic */ C20298rm4 e;

        /* renamed from: ir.nasim.TS3$a$a, reason: collision with other inner class name */
        static final class C0661a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ TS3 c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ C20298rm4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0661a(TS3 ts3, ArrayList arrayList, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = ts3;
                this.d = arrayList;
                this.e = c20298rm4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void D(C20298rm4 c20298rm4, Exception exc) {
                c20298rm4.n(new C5354Iz1((Throwable) exc));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void z(C20298rm4 c20298rm4, C14505i18 c14505i18) {
                c20298rm4.n(new C5354Iz1(Boolean.TRUE));
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0661a(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C6517Nv5 c6517Nv5S0 = this.c.c.s0(new ArrayList(), this.d);
                final C20298rm4 c20298rm4 = this.e;
                C6517Nv5 c6517Nv5M0 = c6517Nv5S0.m0(new InterfaceC24449ye1() { // from class: ir.nasim.RS3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        TS3.a.C0661a.z(c20298rm4, (C14505i18) obj2);
                    }
                });
                final C20298rm4 c20298rm42 = this.e;
                c6517Nv5M0.E(new InterfaceC24449ye1() { // from class: ir.nasim.SS3
                    @Override // ir.nasim.InterfaceC24449ye1
                    public final void apply(Object obj2) {
                        TS3.a.C0661a.D(c20298rm42, (Exception) obj2);
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0661a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList, TS3 ts3, C20298rm4 c20298rm4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = arrayList;
            this.d = ts3;
            this.e = c20298rm4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                ArrayList arrayList = new ArrayList();
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C25238zy(((C22698vg6.b) it.next()).d(), 0L));
                }
                WM3 wm3C = C12366eV1.c();
                C0661a c0661a = new C0661a(this.d, arrayList, this.e, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3C, c0661a, this) == objE) {
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

    public TS3(QQ3 qq3, UG7 ug7) {
        AbstractC13042fc3.i(qq3, "marketModule");
        AbstractC13042fc3.i(ug7, "updatesModule");
        this.b = qq3;
        this.c = ug7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(C20298rm4 c20298rm4, C22698vg6 c22698vg6) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1(c22698vg6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C20298rm4 c20298rm4, Exception exc) {
        AbstractC13042fc3.i(c20298rm4, "$liveData");
        c20298rm4.n(new C5354Iz1((Throwable) exc));
    }

    public androidx.lifecycle.r T0(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "list");
        C20298rm4 c20298rm4 = new C20298rm4();
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new a(arrayList, this, c20298rm4, null), 2, null);
        return c20298rm4;
    }

    public androidx.lifecycle.r U0(String str, byte[] bArr) {
        AbstractC13042fc3.i(str, "query");
        final C20298rm4 c20298rm4 = new C20298rm4();
        QQ3.d0(this.b, str, false, bArr, 2, null).m0(new InterfaceC24449ye1() { // from class: ir.nasim.PS3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                TS3.V0(c20298rm4, (C22698vg6) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.QS3
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                TS3.W0(c20298rm4, (Exception) obj);
            }
        });
        return c20298rm4;
    }
}
