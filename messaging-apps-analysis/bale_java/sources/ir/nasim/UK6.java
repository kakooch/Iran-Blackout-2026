package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class UK6 {
    public static final Integer f = 0;
    protected HashMap a = new HashMap();
    protected HashMap b = new HashMap();
    HashMap c = new HashMap();
    public final C13060fe1 d;
    private int e;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.HORIZONTAL_CHAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.VERTICAL_CHAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.ALIGN_HORIZONTALLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.ALIGN_VERTICALLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[e.BARRIER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum c {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum d {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum e {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public UK6() {
        C13060fe1 c13060fe1 = new C13060fe1(this);
        this.d = c13060fe1;
        this.e = 0;
        this.a.put(f, c13060fe1);
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i = this.e;
        this.e = i + 1;
        sb.append(i);
        sb.append("__");
        return sb.toString();
    }

    public void a(C17242me1 c17242me1) {
        C17749nV2 c17749nV2;
        C18931pV2 c18931pV2X;
        C18931pV2 c18931pV2X2;
        c17242me1.t1();
        this.d.v().e(this, c17242me1, 0);
        this.d.t().e(this, c17242me1, 1);
        for (Object obj : this.b.keySet()) {
            C18931pV2 c18931pV2X3 = ((C17749nV2) this.b.get(obj)).X();
            if (c18931pV2X3 != null) {
                InterfaceC14709iL5 interfaceC14709iL5C = (InterfaceC14709iL5) this.a.get(obj);
                if (interfaceC14709iL5C == null) {
                    interfaceC14709iL5C = c(obj);
                }
                interfaceC14709iL5C.b(c18931pV2X3);
            }
        }
        for (Object obj2 : this.a.keySet()) {
            InterfaceC14709iL5 interfaceC14709iL5 = (InterfaceC14709iL5) this.a.get(obj2);
            if (interfaceC14709iL5 != this.d && (interfaceC14709iL5.d() instanceof C17749nV2) && (c18931pV2X2 = ((C17749nV2) interfaceC14709iL5.d()).X()) != null) {
                InterfaceC14709iL5 interfaceC14709iL5C2 = (InterfaceC14709iL5) this.a.get(obj2);
                if (interfaceC14709iL5C2 == null) {
                    interfaceC14709iL5C2 = c(obj2);
                }
                interfaceC14709iL5C2.b(c18931pV2X2);
            }
        }
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            InterfaceC14709iL5 interfaceC14709iL52 = (InterfaceC14709iL5) this.a.get(it.next());
            if (interfaceC14709iL52 != this.d) {
                C16651le1 c16651le1A = interfaceC14709iL52.a();
                c16651le1A.B0(interfaceC14709iL52.getKey().toString());
                c16651le1A.b1(null);
                interfaceC14709iL52.d();
                c17242me1.a(c16651le1A);
            } else {
                interfaceC14709iL52.b(c17242me1);
            }
        }
        Iterator it2 = this.b.keySet().iterator();
        while (it2.hasNext()) {
            C17749nV2 c17749nV22 = (C17749nV2) this.b.get(it2.next());
            if (c17749nV22.X() != null) {
                Iterator it3 = c17749nV22.l0.iterator();
                while (it3.hasNext()) {
                    c17749nV22.X().a(((InterfaceC14709iL5) this.a.get(it3.next())).a());
                }
                c17749nV22.apply();
            } else {
                c17749nV22.apply();
            }
        }
        Iterator it4 = this.a.keySet().iterator();
        while (it4.hasNext()) {
            InterfaceC14709iL5 interfaceC14709iL53 = (InterfaceC14709iL5) this.a.get(it4.next());
            if (interfaceC14709iL53 != this.d && (interfaceC14709iL53.d() instanceof C17749nV2) && (c18931pV2X = (c17749nV2 = (C17749nV2) interfaceC14709iL53.d()).X()) != null) {
                Iterator it5 = c17749nV2.l0.iterator();
                while (it5.hasNext()) {
                    Object next = it5.next();
                    InterfaceC14709iL5 interfaceC14709iL54 = (InterfaceC14709iL5) this.a.get(next);
                    if (interfaceC14709iL54 != null) {
                        c18931pV2X.a(interfaceC14709iL54.a());
                    } else if (next instanceof InterfaceC14709iL5) {
                        c18931pV2X.a(((InterfaceC14709iL5) next).a());
                    } else {
                        System.out.println("couldn't find reference for " + next);
                    }
                }
                interfaceC14709iL53.apply();
            }
        }
        for (Object obj3 : this.a.keySet()) {
            InterfaceC14709iL5 interfaceC14709iL55 = (InterfaceC14709iL5) this.a.get(obj3);
            interfaceC14709iL55.apply();
            C16651le1 c16651le1A2 = interfaceC14709iL55.a();
            if (c16651le1A2 != null && obj3 != null) {
                c16651le1A2.o = obj3.toString();
            }
        }
    }

    public C12166e90 b(Object obj, d dVar) {
        C13060fe1 c13060fe1C = c(obj);
        if (c13060fe1C.d() == null || !(c13060fe1C.d() instanceof C12166e90)) {
            C12166e90 c12166e90 = new C12166e90(this);
            c12166e90.Y(dVar);
            c13060fe1C.H(c12166e90);
        }
        return (C12166e90) c13060fe1C.d();
    }

    public C13060fe1 c(Object obj) {
        InterfaceC14709iL5 interfaceC14709iL5E = (InterfaceC14709iL5) this.a.get(obj);
        if (interfaceC14709iL5E == null) {
            interfaceC14709iL5E = e(obj);
            this.a.put(obj, interfaceC14709iL5E);
            interfaceC14709iL5E.c(obj);
        }
        if (interfaceC14709iL5E instanceof C13060fe1) {
            return (C13060fe1) interfaceC14709iL5E;
        }
        return null;
    }

    public int d(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public C13060fe1 e(Object obj) {
        return new C13060fe1(this);
    }

    public UK6 g(ET1 et1) {
        return l(et1);
    }

    public C17749nV2 h(Object obj, e eVar) {
        C17749nV2 jy2;
        if (obj == null) {
            obj = f();
        }
        C17749nV2 c17749nV2 = (C17749nV2) this.b.get(obj);
        if (c17749nV2 == null) {
            int i = a.a[eVar.ordinal()];
            if (i == 1) {
                jy2 = new JY2(this);
            } else if (i == 2) {
                jy2 = new C14774iS7(this);
            } else if (i == 3) {
                jy2 = new C11295cm(this);
            } else if (i == 4) {
                jy2 = new C11917dm(this);
            } else if (i != 5) {
                c17749nV2 = new C17749nV2(this, eVar);
                c17749nV2.c(obj);
                this.b.put(obj, c17749nV2);
            } else {
                jy2 = new C12166e90(this);
            }
            c17749nV2 = jy2;
            c17749nV2.c(obj);
            this.b.put(obj, c17749nV2);
        }
        return c17749nV2;
    }

    public void i(Object obj, Object obj2) {
        C13060fe1 c13060fe1C = c(obj);
        if (c13060fe1C instanceof C13060fe1) {
            c13060fe1C.M(obj2);
        }
    }

    InterfaceC14709iL5 j(Object obj) {
        return (InterfaceC14709iL5) this.a.get(obj);
    }

    public void k() {
        this.b.clear();
        this.c.clear();
    }

    public UK6 l(ET1 et1) {
        this.d.I(et1);
        return this;
    }

    public void m(String str, String str2) {
        ArrayList arrayList;
        C13060fe1 c13060fe1C = c(str);
        if (c13060fe1C instanceof C13060fe1) {
            c13060fe1C.K(str2);
            if (this.c.containsKey(str2)) {
                arrayList = (ArrayList) this.c.get(str2);
            } else {
                arrayList = new ArrayList();
                this.c.put(str2, arrayList);
            }
            arrayList.add(str);
        }
    }

    public UK6 n(ET1 et1) {
        this.d.N(et1);
        return this;
    }

    public UK6 o(ET1 et1) {
        return n(et1);
    }
}
