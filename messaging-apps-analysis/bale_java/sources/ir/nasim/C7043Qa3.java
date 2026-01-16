package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Qa3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7043Qa3 implements InterfaceC13882gy7 {
    public static final a f = new a(null);
    private final long a;
    private final InterfaceC8507Wg4 b;
    private final Set c;
    private final XC6 d;
    private final InterfaceC9173Yu3 e;

    /* renamed from: ir.nasim.Qa3$a */
    public static final class a {

        /* renamed from: ir.nasim.Qa3$a$a, reason: collision with other inner class name */
        private enum EnumC0592a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static EnumC0592a[] valuesCustom() {
                EnumC0592a[] enumC0592aArrValuesCustom = values();
                EnumC0592a[] enumC0592aArr = new EnumC0592a[enumC0592aArrValuesCustom.length];
                System.arraycopy(enumC0592aArrValuesCustom, 0, enumC0592aArr, 0, enumC0592aArrValuesCustom.length);
                return enumC0592aArr;
            }
        }

        /* renamed from: ir.nasim.Qa3$a$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC0592a.valuesCustom().length];
                iArr[EnumC0592a.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[EnumC0592a.INTERSECTION_TYPE.ordinal()] = 2;
                a = iArr;
            }
        }

        private a() {
        }

        private final XC6 a(Collection collection, EnumC0592a enumC0592a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = e((XC6) next, (XC6) it.next(), enumC0592a);
            }
            return (XC6) next;
        }

        private final XC6 c(C7043Qa3 c7043Qa3, C7043Qa3 c7043Qa32, EnumC0592a enumC0592a) {
            Set setW0;
            int i = b.a[enumC0592a.ordinal()];
            if (i == 1) {
                setW0 = AbstractC15401jX0.w0(c7043Qa3.k(), c7043Qa32.k());
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                setW0 = AbstractC15401jX0.s1(c7043Qa3.k(), c7043Qa32.k());
            }
            C7043Qa3 c7043Qa33 = new C7043Qa3(c7043Qa3.a, c7043Qa3.b, setW0, null);
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            return C4567Fr3.e(InterfaceC4356Eu.W.b(), c7043Qa33, false);
        }

        private final XC6 d(C7043Qa3 c7043Qa3, XC6 xc6) {
            if (c7043Qa3.k().contains(xc6)) {
                return xc6;
            }
            return null;
        }

        private final XC6 e(XC6 xc6, XC6 xc62, EnumC0592a enumC0592a) {
            if (xc6 == null || xc62 == null) {
                return null;
            }
            InterfaceC13882gy7 interfaceC13882gy7K0 = xc6.K0();
            InterfaceC13882gy7 interfaceC13882gy7K02 = xc62.K0();
            boolean z = interfaceC13882gy7K0 instanceof C7043Qa3;
            if (z && (interfaceC13882gy7K02 instanceof C7043Qa3)) {
                return c((C7043Qa3) interfaceC13882gy7K0, (C7043Qa3) interfaceC13882gy7K02, enumC0592a);
            }
            if (z) {
                return d((C7043Qa3) interfaceC13882gy7K0, xc62);
            }
            if (interfaceC13882gy7K02 instanceof C7043Qa3) {
                return d((C7043Qa3) interfaceC13882gy7K02, xc6);
            }
            return null;
        }

        public final XC6 b(Collection collection) {
            AbstractC13042fc3.i(collection, "types");
            return a(collection, EnumC0592a.INTERSECTION_TYPE);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Qa3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            XC6 xc6P = C7043Qa3.this.n().x().p();
            AbstractC13042fc3.h(xc6P, "builtIns.comparable.defaultType");
            List listS = AbstractC10360bX0.s(AbstractC5351Iy7.f(xc6P, AbstractC9766aX0.e(new C4400Ey7(KQ7.IN_VARIANCE, C7043Qa3.this.d)), null, 2, null));
            if (!C7043Qa3.this.m()) {
                listS.add(C7043Qa3.this.n().L());
            }
            return listS;
        }
    }

    /* renamed from: ir.nasim.Qa3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "it");
            return abstractC4099Dr3.toString();
        }
    }

    public /* synthetic */ C7043Qa3(long j, InterfaceC8507Wg4 interfaceC8507Wg4, Set set, ED1 ed1) {
        this(j, interfaceC8507Wg4, set);
    }

    private final List l() {
        return (List) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        Collection collectionA = AbstractC5043Hq5.a(this.b);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator it = collectionA.iterator();
        while (it.hasNext()) {
            if (!(!k().contains((AbstractC4099Dr3) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final String o() {
        return '[' + AbstractC15401jX0.A0(this.c, ",", null, null, 0, null, c.e, 30, null) + ']';
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public InterfaceC13882gy7 a(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return this;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public Collection b() {
        return l();
    }

    @Override // ir.nasim.InterfaceC13882gy7
    /* renamed from: d */
    public MU0 t() {
        return null;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public boolean e() {
        return false;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public List getParameters() {
        return AbstractC10360bX0.m();
    }

    public final boolean j(InterfaceC13882gy7 interfaceC13882gy7) {
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        Set set = this.c;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (AbstractC13042fc3.d(((AbstractC4099Dr3) it.next()).K0(), interfaceC13882gy7)) {
                return true;
            }
        }
        return false;
    }

    public final Set k() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public AbstractC19738qr3 n() {
        return this.b.n();
    }

    public String toString() {
        return AbstractC13042fc3.q("IntegerLiteralType", o());
    }

    private C7043Qa3(long j, InterfaceC8507Wg4 interfaceC8507Wg4, Set set) {
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        this.d = C4567Fr3.e(InterfaceC4356Eu.W.b(), this, false);
        this.e = AbstractC13269fw3.a(new b());
        this.a = j;
        this.b = interfaceC8507Wg4;
        this.c = set;
    }
}
