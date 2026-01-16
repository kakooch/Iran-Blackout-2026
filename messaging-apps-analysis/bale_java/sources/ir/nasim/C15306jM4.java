package ir.nasim;

import io.sentry.C3155n3;
import ir.nasim.YL4;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* renamed from: ir.nasim.jM4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15306jM4 extends VW7 {
    private final VL4 b;
    private final C18852pM4 c;
    private InterfaceC9336Zm4 d;
    private final InterfaceC9173Yu3 e;
    private List f;
    private InterfaceC9336Zm4 g;

    /* renamed from: ir.nasim.jM4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        /* synthetic */ Object c;

        /* renamed from: ir.nasim.jM4$a$a, reason: collision with other inner class name */
        public static final class C1314a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((WL4) obj).d(), ((WL4) obj2).d());
            }
        }

        /* renamed from: ir.nasim.jM4$a$b */
        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((WL4) obj).d(), ((WL4) obj2).d());
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C15306jM4.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object dVar;
            Object value2;
            Object dVar2;
            String strE;
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            String str = (String) this.c;
            if (str.length() > 0) {
                C20644sM5 c20644sM5 = new C20644sM5(C3155n3.DEFAULT_PROPAGATION_TARGETS + str + C3155n3.DEFAULT_PROPAGATION_TARGETS, EnumC23107wM5.c);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C15306jM4.this.g;
                C15306jM4 c15306jM4 = C15306jM4.this;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    dVar2 = (YL4) value2;
                    if (dVar2 instanceof YL4.d) {
                        List list = c15306jM4.f;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            WL4 wl4 = (WL4) obj2;
                            if (c20644sM5.g(wl4.d()) || ((strE = wl4.e()) != null && c20644sM5.g(strE))) {
                                arrayList.add(obj2);
                            }
                        }
                        dVar2 = new YL4.d(AbstractC15401jX0.a1(arrayList, new C1314a()));
                    }
                } while (!interfaceC9336Zm4.f(value2, dVar2));
            } else {
                InterfaceC9336Zm4 interfaceC9336Zm42 = C15306jM4.this.g;
                C15306jM4 c15306jM42 = C15306jM4.this;
                do {
                    value = interfaceC9336Zm42.getValue();
                    dVar = (YL4) value;
                    if (dVar instanceof YL4.d) {
                        dVar = new YL4.d(AbstractC15401jX0.a1(c15306jM42.f, new b()));
                    }
                } while (!interfaceC9336Zm42.f(value, dVar));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jM4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jM4$b$a */
        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(((WL4) obj).d(), ((WL4) obj2).d());
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15306jM4.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objG;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C15306jM4.this.g;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, YL4.c.a));
                VL4 vl4 = C15306jM4.this.b;
                this.b = 1;
                objG = vl4.g(this);
                if (objG == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objG = ((C9475a16) obj).l();
            }
            C15306jM4 c15306jM4 = C15306jM4.this;
            Throwable thE = C9475a16.e(objG);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c15306jM4.g;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, new YL4.a(thE)));
            }
            C15306jM4 c15306jM42 = C15306jM4.this;
            if (C9475a16.j(objG)) {
                List list = (List) objG;
                c15306jM42.f = list;
                InterfaceC9336Zm4 interfaceC9336Zm43 = c15306jM42.g;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, new YL4.d(AbstractC15401jX0.a1(list, new a()))));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15306jM4(VL4 vl4, C18852pM4 c18852pM4) {
        AbstractC13042fc3.i(vl4, "organizationContactDataLoader");
        AbstractC13042fc3.i(c18852pM4, "organizationContactPreferencesStorage");
        this.b = vl4;
        this.c = c18852pM4;
        this.d = AbstractC12281eL6.a("");
        this.e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iM4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15306jM4.a1(this.a);
            }
        });
        this.f = AbstractC10360bX0.m();
        this.g = AbstractC12281eL6.a(YL4.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String a1(C15306jM4 c15306jM4) {
        AbstractC13042fc3.i(c15306jM4, "this$0");
        return c15306jM4.c.d();
    }

    public final InterfaceC13730gj3 V0() {
        return AbstractC6459Nq2.W(AbstractC6459Nq2.b0(AbstractC6459Nq2.s(X0(), 200L), new a(null)), AbstractC9773aX7.a(this));
    }

    public final String W0() {
        return (String) this.e.getValue();
    }

    public final InterfaceC10258bL6 X0() {
        return AbstractC6459Nq2.c(this.d);
    }

    public final InterfaceC10258bL6 Y0() {
        return AbstractC6459Nq2.c(this.g);
    }

    public final InterfaceC13730gj3 Z0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    public final void b1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "query");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.d;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, str));
    }
}
