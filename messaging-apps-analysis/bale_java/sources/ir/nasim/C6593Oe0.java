package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.InterfaceC22805vr3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.Oe0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6593Oe0 extends A0 {
    private final InterfaceC8507Wg4 c;
    private final C21830uC4 d;
    private final C22837vu e;

    /* renamed from: ir.nasim.Oe0$a */
    public static final class a implements InterfaceC22805vr3.a {
        private final HashMap a = new HashMap();
        final /* synthetic */ InterfaceC21331tU0 b;
        final /* synthetic */ C6593Oe0 c;
        final /* synthetic */ List d;
        final /* synthetic */ JH6 e;

        /* renamed from: ir.nasim.Oe0$a$a, reason: collision with other inner class name */
        public static final class C0556a implements InterfaceC22805vr3.a {
            private final /* synthetic */ InterfaceC22805vr3.a a;
            final /* synthetic */ InterfaceC22805vr3.a b;
            final /* synthetic */ a c;
            final /* synthetic */ C6432No4 d;
            final /* synthetic */ ArrayList e;

            C0556a(InterfaceC22805vr3.a aVar, a aVar2, C6432No4 c6432No4, ArrayList arrayList) {
                this.b = aVar;
                this.c = aVar2;
                this.d = c6432No4;
                this.e = arrayList;
                this.a = aVar;
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public void a() {
                this.b.a();
                this.c.a.put(this.d, new C4122Du((InterfaceC21651tu) AbstractC15401jX0.V0(this.e)));
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public InterfaceC22805vr3.a b(C6432No4 c6432No4, C24948zU0 c24948zU0) {
                AbstractC13042fc3.i(c6432No4, "name");
                AbstractC13042fc3.i(c24948zU0, "classId");
                return this.a.b(c6432No4, c24948zU0);
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public void c(C6432No4 c6432No4, C24948zU0 c24948zU0, C6432No4 c6432No42) {
                AbstractC13042fc3.i(c6432No4, "name");
                AbstractC13042fc3.i(c24948zU0, "enumClassId");
                AbstractC13042fc3.i(c6432No42, "enumEntryName");
                this.a.c(c6432No4, c24948zU0, c6432No42);
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public void d(C6432No4 c6432No4, BU0 bu0) {
                AbstractC13042fc3.i(c6432No4, "name");
                AbstractC13042fc3.i(bu0, "value");
                this.a.d(c6432No4, bu0);
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public InterfaceC22805vr3.b e(C6432No4 c6432No4) {
                AbstractC13042fc3.i(c6432No4, "name");
                return this.a.e(c6432No4);
            }

            @Override // ir.nasim.InterfaceC22805vr3.a
            public void f(C6432No4 c6432No4, Object obj) {
                this.a.f(c6432No4, obj);
            }
        }

        /* renamed from: ir.nasim.Oe0$a$b */
        public static final class b implements InterfaceC22805vr3.b {
            private final ArrayList a = new ArrayList();
            final /* synthetic */ C6432No4 c;
            final /* synthetic */ InterfaceC21331tU0 d;

            b(C6432No4 c6432No4, InterfaceC21331tU0 interfaceC21331tU0) {
                this.c = c6432No4;
                this.d = interfaceC21331tU0;
            }

            @Override // ir.nasim.InterfaceC22805vr3.b
            public void a() {
                InterfaceC24919zQ7 interfaceC24919zQ7B = KI1.b(this.c, this.d);
                if (interfaceC24919zQ7B != null) {
                    HashMap map = a.this.a;
                    C6432No4 c6432No4 = this.c;
                    C7302Rd1 c7302Rd1 = C7302Rd1.a;
                    List listC = YW0.c(this.a);
                    AbstractC4099Dr3 type = interfaceC24919zQ7B.getType();
                    AbstractC13042fc3.h(type, "parameter.type");
                    map.put(c6432No4, c7302Rd1.a(listC, type));
                }
            }

            @Override // ir.nasim.InterfaceC22805vr3.b
            public void b(BU0 bu0) {
                AbstractC13042fc3.i(bu0, "value");
                this.a.add(new C13760gm3(bu0));
            }

            @Override // ir.nasim.InterfaceC22805vr3.b
            public void c(Object obj) {
                this.a.add(a.this.i(this.c, obj));
            }

            @Override // ir.nasim.InterfaceC22805vr3.b
            public void d(C24948zU0 c24948zU0, C6432No4 c6432No4) {
                AbstractC13042fc3.i(c24948zU0, "enumClassId");
                AbstractC13042fc3.i(c6432No4, "enumEntryName");
                this.a.add(new N92(c24948zU0, c6432No4));
            }
        }

        a(InterfaceC21331tU0 interfaceC21331tU0, C6593Oe0 c6593Oe0, List list, JH6 jh6) {
            this.b = interfaceC21331tU0;
            this.c = c6593Oe0;
            this.d = list;
            this.e = jh6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AbstractC7068Qd1 i(C6432No4 c6432No4, Object obj) {
            AbstractC7068Qd1 abstractC7068Qd1C = C7302Rd1.a.c(obj);
            return abstractC7068Qd1C == null ? AbstractC15430ja2.b.a(AbstractC13042fc3.q("Unsupported annotation argument: ", c6432No4)) : abstractC7068Qd1C;
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void a() {
            this.d.add(new C22241uu(this.b.p(), this.a, this.e));
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.a b(C6432No4 c6432No4, C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(c24948zU0, "classId");
            ArrayList arrayList = new ArrayList();
            C6593Oe0 c6593Oe0 = this.c;
            JH6 jh6 = JH6.a;
            AbstractC13042fc3.h(jh6, "NO_SOURCE");
            InterfaceC22805vr3.a aVarW = c6593Oe0.w(c24948zU0, jh6, arrayList);
            AbstractC13042fc3.f(aVarW);
            return new C0556a(aVarW, this, c6432No4, arrayList);
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void c(C6432No4 c6432No4, C24948zU0 c24948zU0, C6432No4 c6432No42) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(c24948zU0, "enumClassId");
            AbstractC13042fc3.i(c6432No42, "enumEntryName");
            this.a.put(c6432No4, new N92(c24948zU0, c6432No42));
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void d(C6432No4 c6432No4, BU0 bu0) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(bu0, "value");
            this.a.put(c6432No4, new C13760gm3(bu0));
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public InterfaceC22805vr3.b e(C6432No4 c6432No4) {
            AbstractC13042fc3.i(c6432No4, "name");
            return new b(c6432No4, this.b);
        }

        @Override // ir.nasim.InterfaceC22805vr3.a
        public void f(C6432No4 c6432No4, Object obj) {
            if (c6432No4 != null) {
                this.a.put(c6432No4, i(c6432No4, obj));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6593Oe0(InterfaceC8507Wg4 interfaceC8507Wg4, C21830uC4 c21830uC4, ON6 on6, InterfaceC20347rr3 interfaceC20347rr3) {
        super(on6, interfaceC20347rr3);
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC20347rr3, "kotlinClassFinder");
        this.c = interfaceC8507Wg4;
        this.d = c21830uC4;
        this.e = new C22837vu(interfaceC8507Wg4, c21830uC4);
    }

    private final InterfaceC21331tU0 G(C24948zU0 c24948zU0) {
        return AbstractC23370wo2.c(this.c, c24948zU0, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.A0
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public AbstractC7068Qd1 z(String str, Object obj) {
        AbstractC13042fc3.i(str, "desc");
        AbstractC13042fc3.i(obj, "initializer");
        if (AbstractC20762sZ6.X("ZBCS", str, false, 2, null)) {
            int iIntValue = ((Integer) obj).intValue();
            int iHashCode = str.hashCode();
            if (iHashCode == 66) {
                if (str.equals("B")) {
                    obj = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 67) {
                if (str.equals(TokenNames.C)) {
                    obj = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 83) {
                if (str.equals(TokenNames.S)) {
                    obj = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(str);
            }
            if (iHashCode == 90 && str.equals("Z")) {
                obj = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(str);
        }
        return C7302Rd1.a.c(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.A0
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public InterfaceC21651tu B(C6266Mw5 c6266Mw5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c6266Mw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        return this.e.a(c6266Mw5, interfaceC6692Oo4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.A0
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public AbstractC7068Qd1 D(AbstractC7068Qd1 abstractC7068Qd1) {
        AbstractC7068Qd1 c16974mA7;
        AbstractC13042fc3.i(abstractC7068Qd1, "constant");
        if (abstractC7068Qd1 instanceof C8341Vo0) {
            c16974mA7 = new C8701Wz7(((Number) ((C8341Vo0) abstractC7068Qd1).b()).byteValue());
        } else if (abstractC7068Qd1 instanceof C5359Iz6) {
            c16974mA7 = new DA7(((Number) ((C5359Iz6) abstractC7068Qd1).b()).shortValue());
        } else if (abstractC7068Qd1 instanceof C6066Ma3) {
            c16974mA7 = new C14001hA7(((Number) ((C6066Ma3) abstractC7068Qd1).b()).intValue());
        } else {
            if (!(abstractC7068Qd1 instanceof C24258yJ3)) {
                return abstractC7068Qd1;
            }
            c16974mA7 = new C16974mA7(((Number) ((C24258yJ3) abstractC7068Qd1).b()).longValue());
        }
        return c16974mA7;
    }

    @Override // ir.nasim.A0
    protected InterfaceC22805vr3.a w(C24948zU0 c24948zU0, JH6 jh6, List list) {
        AbstractC13042fc3.i(c24948zU0, "annotationClassId");
        AbstractC13042fc3.i(jh6, "source");
        AbstractC13042fc3.i(list, "result");
        return new a(G(c24948zU0), this, list, jh6);
    }
}
