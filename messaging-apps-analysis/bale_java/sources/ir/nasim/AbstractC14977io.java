package ir.nasim;

import android.content.res.Resources;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.io, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14977io {
    private static final Comparator[] a;
    private static final InterfaceC14603iB2 b;

    /* renamed from: ir.nasim.io$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.io$a$a, reason: collision with other inner class name */
        static final class C1306a extends AbstractC8614Ws3 implements SA2 {
            public static final C1306a e = new C1306a();

            C1306a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Float invoke() {
                return Float.valueOf(0.0f);
            }
        }

        /* renamed from: ir.nasim.io$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            public static final b e = new b();

            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Float invoke() {
                return Float.valueOf(0.0f);
            }
        }

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(C7631Sn6 c7631Sn6, C7631Sn6 c7631Sn62) {
            SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
            C8838Xn6 c8838Xn6 = C8838Xn6.a;
            return Integer.valueOf(Float.compare(((Number) semanticsConfigurationW.v(c8838Xn6.L(), C1306a.e)).floatValue(), ((Number) c7631Sn62.w().v(c8838Xn6.L(), b.e)).floatValue()));
        }
    }

    /* renamed from: ir.nasim.io$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC22219ur7.values().length];
            try {
                iArr[EnumC22219ur7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC22219ur7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC22219ur7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.io$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke(ir.nasim.C3419Au3 r3) {
            /*
                r2 = this;
                androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.e()
                if (r3 == 0) goto L1a
                boolean r0 = r3.C()
                r1 = 1
                if (r0 != r1) goto L1a
                ir.nasim.Xn6 r0 = ir.nasim.C8838Xn6.a
                ir.nasim.co6 r0 = r0.g()
                boolean r3 = r3.i(r0)
                if (r3 == 0) goto L1a
                goto L1b
            L1a:
                r1 = 0
            L1b:
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14977io.c.invoke(ir.nasim.Au3):java.lang.Boolean");
        }
    }

    /* renamed from: ir.nasim.io$d */
    static final class d extends AbstractC8614Ws3 implements SA2 {
        public static final d e = new d();

        d() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* renamed from: ir.nasim.io$e */
    public static final class e implements Comparator {
        final /* synthetic */ Comparator a;
        final /* synthetic */ Comparator b;

        public e(Comparator comparator, Comparator comparator2) {
            this.a = comparator;
            this.b = comparator2;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int iCompare = this.a.compare(obj, obj2);
            return iCompare != 0 ? iCompare : this.b.compare(((C7631Sn6) obj).q(), ((C7631Sn6) obj2).q());
        }
    }

    /* renamed from: ir.nasim.io$f */
    public static final class f implements Comparator {
        final /* synthetic */ Comparator a;

        public f(Comparator comparator) {
            this.a = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int iCompare = this.a.compare(obj, obj2);
            return iCompare != 0 ? iCompare : AbstractC18050o01.d(Integer.valueOf(((C7631Sn6) obj).o()), Integer.valueOf(((C7631Sn6) obj2).o()));
        }
    }

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i = 0;
        while (i < 2) {
            comparatorArr[i] = new f(new e(i == 0 ? C11509d76.a : C20024rL3.a, C3419Au3.J0.b()));
            i++;
        }
        a = comparatorArr;
        b = a.e;
    }

    private static final List A(boolean z, ArrayList arrayList, Resources resources, C16734lm4 c16734lm4) {
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int iO = AbstractC10360bX0.o(arrayList);
        int size = 0;
        if (iO >= 0) {
            int i = 0;
            while (true) {
                C7631Sn6 c7631Sn6 = (C7631Sn6) arrayList.get(i);
                if (i == 0 || !x(arrayList2, c7631Sn6)) {
                    arrayList2.add(new XV4(c7631Sn6.j(), AbstractC10360bX0.s(c7631Sn6)));
                }
                if (i == iO) {
                    break;
                }
                i++;
            }
        }
        AbstractC12992fX0.B(arrayList2, C4112Ds7.a);
        ArrayList arrayList3 = new ArrayList();
        Comparator comparator = a[!z ? 1 : 0];
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            XV4 xv4 = (XV4) arrayList2.get(i2);
            AbstractC12992fX0.B((List) xv4.f(), comparator);
            arrayList3.addAll((Collection) xv4.f());
        }
        final InterfaceC14603iB2 interfaceC14603iB2 = b;
        AbstractC12992fX0.B(arrayList3, new Comparator() { // from class: ir.nasim.ho
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC14977io.B(interfaceC14603iB2, obj, obj2);
            }
        });
        while (size <= AbstractC10360bX0.o(arrayList3)) {
            List list = (List) c16734lm4.b(((C7631Sn6) arrayList3.get(size)).o());
            if (list != null) {
                if (w((C7631Sn6) arrayList3.get(size), resources)) {
                    size++;
                } else {
                    arrayList3.remove(size);
                }
                arrayList3.addAll(size, list);
                size += list.size();
            } else {
                size++;
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B(InterfaceC14603iB2 interfaceC14603iB2, Object obj, Object obj2) {
        return ((Number) interfaceC14603iB2.invoke(obj, obj2)).intValue();
    }

    private static final List C(boolean z, List list, AbstractC20768sa3 abstractC20768sa3, Resources resources) {
        C16734lm4 c16734lm4C = AbstractC21388ta3.c();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            r((C7631Sn6) list.get(i), arrayList, c16734lm4C, abstractC20768sa3, resources);
        }
        return A(z, arrayList, resources, c16734lm4C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(C20450s2 c20450s2, Object obj) {
        if (c20450s2 == obj) {
            return true;
        }
        if (!(obj instanceof C20450s2)) {
            return false;
        }
        C20450s2 c20450s22 = (C20450s2) obj;
        if (!AbstractC13042fc3.d(c20450s2.b(), c20450s22.b())) {
            return false;
        }
        if (c20450s2.a() != null || c20450s22.a() == null) {
            return c20450s2.a() == null || c20450s22.a() != null;
        }
        return false;
    }

    private static final String n(C7631Sn6 c7631Sn6, Resources resources) {
        Collection collection;
        CharSequence charSequence;
        SemanticsConfiguration semanticsConfigurationN = c7631Sn6.a().n();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        Collection collection2 = (Collection) AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.d());
        if ((collection2 == null || collection2.isEmpty()) && (((collection = (Collection) AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.H())) == null || collection.isEmpty()) && ((charSequence = (CharSequence) AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.g())) == null || charSequence.length() == 0))) {
            return resources.getString(AbstractC9600aE5.state_empty);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(C7631Sn6 c7631Sn6) {
        return !c7631Sn6.n().i(C8838Xn6.a.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        if (semanticsConfigurationW.i(c8838Xn6.g()) && !AbstractC13042fc3.d(AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.i()), Boolean.TRUE)) {
            return true;
        }
        C3419Au3 c3419Au3Q = q(c7631Sn6.q(), c.e);
        if (c3419Au3Q != null) {
            SemanticsConfiguration semanticsConfigurationE = c3419Au3Q.e();
            if (!(semanticsConfigurationE != null ? AbstractC13042fc3.d(AbstractC5719Kn6.a(semanticsConfigurationE, c8838Xn6.i()), Boolean.TRUE) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C3419Au3 q(C3419Au3 c3419Au3, UA2 ua2) {
        for (C3419Au3 c3419Au3A0 = c3419Au3.A0(); c3419Au3A0 != null; c3419Au3A0 = c3419Au3A0.A0()) {
            if (((Boolean) ua2.invoke(c3419Au3A0)).booleanValue()) {
                return c3419Au3A0;
            }
        }
        return null;
    }

    private static final void r(C7631Sn6 c7631Sn6, ArrayList arrayList, C16734lm4 c16734lm4, AbstractC20768sa3 abstractC20768sa3, Resources resources) {
        boolean zV = v(c7631Sn6);
        boolean zBooleanValue = ((Boolean) c7631Sn6.w().v(C8838Xn6.a.v(), d.e)).booleanValue();
        if ((zBooleanValue || w(c7631Sn6, resources)) && abstractC20768sa3.a(c7631Sn6.o())) {
            arrayList.add(c7631Sn6);
        }
        if (zBooleanValue) {
            c16734lm4.r(c7631Sn6.o(), C(zV, c7631Sn6.k(), abstractC20768sa3, resources));
            return;
        }
        List listK = c7631Sn6.k();
        int size = listK.size();
        for (int i = 0; i < size; i++) {
            r((C7631Sn6) listK.get(i), arrayList, c16734lm4, abstractC20768sa3, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        EnumC22219ur7 enumC22219ur7 = (EnumC22219ur7) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.K());
        B26 b26 = (B26) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.C());
        boolean z = enumC22219ur7 != null;
        if (((Boolean) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.E())) != null) {
            return b26 != null ? B26.m(b26.p(), B26.b.h()) : false ? z : true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t(C7631Sn6 c7631Sn6, Resources resources) throws Resources.NotFoundException {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        Object objA = AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.F());
        EnumC22219ur7 enumC22219ur7 = (EnumC22219ur7) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.K());
        B26 b26 = (B26) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.C());
        if (enumC22219ur7 != null) {
            int i = b.a[enumC22219ur7.ordinal()];
            if (i == 1) {
                if ((b26 == null ? false : B26.m(b26.p(), B26.b.g())) && objA == null) {
                    objA = resources.getString(AbstractC9600aE5.state_on);
                }
            } else if (i == 2) {
                if ((b26 == null ? false : B26.m(b26.p(), B26.b.g())) && objA == null) {
                    objA = resources.getString(AbstractC9600aE5.state_off);
                }
            } else if (i == 3 && objA == null) {
                objA = resources.getString(AbstractC9600aE5.indeterminate);
            }
        }
        Boolean bool = (Boolean) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.E());
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (!(b26 == null ? false : B26.m(b26.p(), B26.b.h())) && objA == null) {
                objA = zBooleanValue ? resources.getString(AbstractC9600aE5.selected) : resources.getString(AbstractC9600aE5.not_selected);
            }
        }
        C7932Tu5 c7932Tu5 = (C7932Tu5) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.B());
        if (c7932Tu5 != null) {
            if (c7932Tu5 != C7932Tu5.d.a()) {
                if (objA == null) {
                    InterfaceC10351bW0 interfaceC10351bW0C = c7932Tu5.c();
                    float fB = ((((Number) interfaceC10351bW0C.j()).floatValue() - ((Number) interfaceC10351bW0C.f()).floatValue()) > 0.0f ? 1 : ((((Number) interfaceC10351bW0C.j()).floatValue() - ((Number) interfaceC10351bW0C.f()).floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (c7932Tu5.b() - ((Number) interfaceC10351bW0C.f()).floatValue()) / (((Number) interfaceC10351bW0C.j()).floatValue() - ((Number) interfaceC10351bW0C.f()).floatValue());
                    if (fB < 0.0f) {
                        fB = 0.0f;
                    }
                    if (fB > 1.0f) {
                        fB = 1.0f;
                    }
                    if (!(fB == 0.0f)) {
                        iM = (fB == 1.0f ? 1 : 0) != 0 ? 100 : AbstractC23053wG5.m(Math.round(fB * 100), 1, 99);
                    }
                    objA = resources.getString(AbstractC9600aE5.template_percent, Integer.valueOf(iM));
                }
            } else if (objA == null) {
                objA = resources.getString(AbstractC9600aE5.in_progress);
            }
        }
        if (c7631Sn6.w().i(c8838Xn6.g())) {
            objA = n(c7631Sn6, resources);
        }
        return (String) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C13245fu u(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationW = c7631Sn6.w();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        C13245fu c13245fu = (C13245fu) AbstractC5719Kn6.a(semanticsConfigurationW, c8838Xn6.g());
        List list = (List) AbstractC5719Kn6.a(c7631Sn6.w(), c8838Xn6.H());
        return c13245fu == null ? list != null ? (C13245fu) AbstractC15401jX0.s0(list) : null : c13245fu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(C7631Sn6 c7631Sn6) {
        return c7631Sn6.p().getLayoutDirection() == EnumC12613eu3.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(C7631Sn6 c7631Sn6, Resources resources) {
        List list = (List) AbstractC5719Kn6.a(c7631Sn6.w(), C8838Xn6.a.d());
        boolean z = ((list != null ? (String) AbstractC15401jX0.s0(list) : null) == null && u(c7631Sn6) == null && t(c7631Sn6, resources) == null && !s(c7631Sn6)) ? false : true;
        if (!AbstractC13192fo6.f(c7631Sn6)) {
            if (c7631Sn6.w().C()) {
                return true;
            }
            if (c7631Sn6.A() && z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean x(ArrayList arrayList, C7631Sn6 c7631Sn6) {
        float fL = c7631Sn6.j().l();
        float fE = c7631Sn6.j().e();
        boolean z = fL >= fE;
        int iO = AbstractC10360bX0.o(arrayList);
        if (iO >= 0) {
            int i = 0;
            while (true) {
                CK5 ck5 = (CK5) ((XV4) arrayList.get(i)).e();
                boolean z2 = ck5.l() >= ck5.e();
                if (!z && !z2 && Math.max(fL, ck5.l()) < Math.min(fE, ck5.e())) {
                    arrayList.set(i, new XV4(ck5.n(0.0f, fL, Float.POSITIVE_INFINITY, fE), ((XV4) arrayList.get(i)).f()));
                    ((List) ((XV4) arrayList.get(i)).f()).add(c7631Sn6);
                    return true;
                }
                if (i == iO) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(C7631Sn6 c7631Sn6, SemanticsConfiguration semanticsConfiguration) {
        Iterator it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            if (!c7631Sn6.n().i((C11322co6) ((Map.Entry) it.next()).getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(AbstractC20768sa3 abstractC20768sa3, C15552jm4 c15552jm4, C15552jm4 c15552jm42, Resources resources) {
        c15552jm4.i();
        c15552jm42.i();
        C8338Vn6 c8338Vn6 = (C8338Vn6) abstractC20768sa3.b(-1);
        C7631Sn6 c7631Sn6B = c8338Vn6 != null ? c8338Vn6.b() : null;
        AbstractC13042fc3.f(c7631Sn6B);
        List listC = C(v(c7631Sn6B), AbstractC9766aX0.e(c7631Sn6B), abstractC20768sa3, resources);
        int iO = AbstractC10360bX0.o(listC);
        int i = 1;
        if (1 > iO) {
            return;
        }
        while (true) {
            int iO2 = ((C7631Sn6) listC.get(i - 1)).o();
            int iO3 = ((C7631Sn6) listC.get(i)).o();
            c15552jm4.q(iO2, iO3);
            c15552jm42.q(iO3, iO2);
            if (i == iO) {
                return;
            } else {
                i++;
            }
        }
    }
}
