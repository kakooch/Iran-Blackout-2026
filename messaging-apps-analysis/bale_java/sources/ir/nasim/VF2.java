package ir.nasim;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class VF2 {
    private final ir.nasim.database.dailogLists.c a;
    private final InterfaceC20315ro1 b;
    private final AbstractC13778go1 c;
    private final InterfaceC9173Yu3 d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.VF2$a$a, reason: collision with other inner class name */
        static final class C0697a implements InterfaceC4806Gq2 {
            final /* synthetic */ VF2 a;

            /* renamed from: ir.nasim.VF2$a$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0698a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC9389Zs3.values().length];
                    try {
                        iArr[EnumC9389Zs3.a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC9389Zs3.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnumC9389Zs3.c.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[EnumC9389Zs3.d.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            C0697a(VF2 vf2) {
                this.a = vf2;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                String strM;
                Object value;
                List<WP1> list2 = list;
                VF2 vf2 = this.a;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
                for (WP1 wp1 : list2) {
                    String strA = wp1.a();
                    if (strA == null) {
                        strA = "";
                    }
                    String str = strA;
                    int i = C0698a.a[vf2.f().ordinal()];
                    if (i == 1) {
                        strM = AbstractC20153rZ6.M(str, ". ", "، ", false, 4, null);
                    } else if (i == 2) {
                        strM = AbstractC20153rZ6.M(str, ". ", ", ", false, 4, null);
                    } else if (i == 3) {
                        strM = AbstractC20153rZ6.M(str, ". ", "، ", false, 4, null);
                    } else {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        strM = AbstractC20153rZ6.M(str, ". ", ", ", false, 4, null);
                    }
                    InterfaceC9336Zm4 interfaceC9336Zm4H = vf2.h();
                    do {
                        value = interfaceC9336Zm4H.getValue();
                    } while (!interfaceC9336Zm4H.f(value, AbstractC20051rO3.r((Map) value, AbstractC4616Fw7.a(AbstractC6392Nk0.e(wp1.b()), strM))));
                    arrayList.add(C19938rB7.a);
                }
                return C19938rB7.a;
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return VF2.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2R = VF2.this.a.r();
                C0697a c0697a = new C0697a(VF2.this);
                this.b = 1;
                if (interfaceC4557Fq2R.b(c0697a, this) == objE) {
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

    public VF2(ir.nasim.database.dailogLists.c cVar, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(cVar, "dialogFolderDao");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = cVar;
        this.b = interfaceC20315ro1;
        this.c = abstractC13778go1;
        this.d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.UF2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return VF2.b(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9336Zm4 b(VF2 vf2) {
        AbstractC13042fc3.i(vf2, "this$0");
        vf2.g();
        return AbstractC12281eL6.a(AbstractC20051rO3.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EnumC9389Zs3 f() {
        String strD = PH3.d();
        EnumC9389Zs3 enumC9389Zs3 = EnumC9389Zs3.b;
        if (AbstractC13042fc3.d(strD, enumC9389Zs3.toString())) {
            return enumC9389Zs3;
        }
        EnumC9389Zs3 enumC9389Zs32 = EnumC9389Zs3.d;
        if (AbstractC13042fc3.d(strD, enumC9389Zs32.toString())) {
            return enumC9389Zs32;
        }
        EnumC9389Zs3 enumC9389Zs33 = EnumC9389Zs3.c;
        return AbstractC13042fc3.d(strD, enumC9389Zs33.toString()) ? enumC9389Zs33 : EnumC9389Zs3.a;
    }

    private final void g() {
        AbstractC10533bm0.d(this.b, this.c, null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC9336Zm4 h() {
        return (InterfaceC9336Zm4) this.d.getValue();
    }

    public final InterfaceC10258bL6 i() {
        return h();
    }
}
