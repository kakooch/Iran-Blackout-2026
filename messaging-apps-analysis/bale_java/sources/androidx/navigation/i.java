package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.g;
import androidx.navigation.h;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC19810qy7;
import ir.nasim.AbstractC20609sI6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21263tO3;
import ir.nasim.AbstractC6935Pp4;
import ir.nasim.AbstractC7179Qp4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9962aq6;
import ir.nasim.C19409qI6;
import ir.nasim.ED1;
import ir.nasim.InterfaceC23384wp6;
import ir.nasim.UA2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class i {
    public static final a j = new a(null);
    private static final Map k = new LinkedHashMap();
    private final String a;
    private j b;
    private String c;
    private CharSequence d;
    private final List e;
    private final C19409qI6 f;
    private Map g;
    private int h;
    private String i;

    public static final class a {

        /* renamed from: androidx.navigation.i$a$a, reason: collision with other inner class name */
        static final class C0105a extends AbstractC8614Ws3 implements UA2 {
            public static final C0105a e = new C0105a();

            C0105a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i invoke(i iVar) {
                AbstractC13042fc3.i(iVar, "it");
                return iVar.C();
            }
        }

        private a() {
        }

        public final String a(String str) {
            if (str == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + str;
        }

        public final String b(Context context, int i) throws Resources.NotFoundException {
            String strValueOf;
            AbstractC13042fc3.i(context, "context");
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                strValueOf = context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(i);
            }
            AbstractC13042fc3.h(strValueOf, "try {\n                co….toString()\n            }");
            return strValueOf;
        }

        public final InterfaceC23384wp6 c(i iVar) {
            AbstractC13042fc3.i(iVar, "<this>");
            return AbstractC9962aq6.j(iVar, C0105a.e);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements Comparable {
        private final i a;
        private final Bundle b;
        private final boolean c;
        private final int d;
        private final boolean e;
        private final int f;

        public b(i iVar, Bundle bundle, boolean z, int i, boolean z2, int i2) {
            AbstractC13042fc3.i(iVar, "destination");
            this.a = iVar;
            this.b = bundle;
            this.c = z;
            this.d = i;
            this.e = z2;
            this.f = i2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            AbstractC13042fc3.i(bVar, "other");
            boolean z = this.c;
            if (z && !bVar.c) {
                return 1;
            }
            if (!z && bVar.c) {
                return -1;
            }
            int i = this.d - bVar.d;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle = this.b;
            if (bundle != null && bVar.b == null) {
                return 1;
            }
            if (bundle == null && bVar.b != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = bVar.b;
                AbstractC13042fc3.f(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z2 = this.e;
            if (z2 && !bVar.e) {
                return 1;
            }
            if (z2 || !bVar.e) {
                return this.f - bVar.f;
            }
            return -1;
        }

        public final i h() {
            return this.a;
        }

        public final Bundle i() {
            return this.b;
        }

        public final boolean j(Bundle bundle) {
            Bundle bundle2;
            Object objA;
            if (bundle == null || (bundle2 = this.b) == null) {
                return false;
            }
            Set<String> setKeySet = bundle2.keySet();
            AbstractC13042fc3.h(setKeySet, "matchingArgs.keySet()");
            for (String str : setKeySet) {
                if (!bundle.containsKey(str)) {
                    return false;
                }
                androidx.navigation.b bVar = (androidx.navigation.b) this.a.g.get(str);
                Object objA2 = null;
                o oVarA = bVar != null ? bVar.a() : null;
                if (oVarA != null) {
                    Bundle bundle3 = this.b;
                    AbstractC13042fc3.h(str, "key");
                    objA = oVarA.a(bundle3, str);
                } else {
                    objA = null;
                }
                if (oVarA != null) {
                    AbstractC13042fc3.h(str, "key");
                    objA2 = oVarA.a(bundle, str);
                }
                if (!AbstractC13042fc3.d(objA, objA2)) {
                    return false;
                }
            }
            return true;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ g e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(g gVar) {
            super(1);
            this.e = gVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            AbstractC13042fc3.i(str, "key");
            return Boolean.valueOf(!this.e.j().contains(str));
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Bundle e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Bundle bundle) {
            super(1);
            this.e = bundle;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            AbstractC13042fc3.i(str, "key");
            return Boolean.valueOf(!this.e.containsKey(str));
        }
    }

    public i(String str) {
        AbstractC13042fc3.i(str, "navigatorName");
        this.a = str;
        this.e = new ArrayList();
        this.f = new C19409qI6();
        this.g = new LinkedHashMap();
    }

    private final boolean F(g gVar, Uri uri, Map map) {
        return AbstractC7179Qp4.a(map, new d(gVar.p(uri, map))).isEmpty();
    }

    public static /* synthetic */ int[] v(i iVar, i iVar2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i & 1) != 0) {
            iVar2 = null;
        }
        return iVar.t(iVar2);
    }

    public final int A() {
        return this.h;
    }

    public final String B() {
        return this.a;
    }

    public final j C() {
        return this.b;
    }

    public final String E() {
        return this.i;
    }

    public final boolean I(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "route");
        if (AbstractC13042fc3.d(this.i, str)) {
            return true;
        }
        b bVarN = N(str);
        if (AbstractC13042fc3.d(this, bVarN != null ? bVarN.h() : null)) {
            return bVarN.j(bundle);
        }
        return false;
    }

    public b L(h hVar) {
        AbstractC13042fc3.i(hVar, "navDeepLinkRequest");
        if (this.e.isEmpty()) {
            return null;
        }
        b bVar = null;
        for (g gVar : this.e) {
            Uri uriC = hVar.c();
            Bundle bundleO = uriC != null ? gVar.o(uriC, this.g) : null;
            int iH = gVar.h(uriC);
            String strA = hVar.a();
            boolean z = strA != null && AbstractC13042fc3.d(strA, gVar.i());
            String strB = hVar.b();
            int iU = strB != null ? gVar.u(strB) : -1;
            if (bundleO == null) {
                if (z || iU > -1) {
                    if (F(gVar, uriC, this.g)) {
                    }
                }
            }
            b bVar2 = new b(this, bundleO, gVar.z(), iH, z, iU);
            if (bVar == null || bVar2.compareTo(bVar) > 0) {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public final b N(String str) {
        AbstractC13042fc3.i(str, "route");
        h.a.C0104a c0104a = h.a.d;
        Uri uri = Uri.parse(j.a(str));
        AbstractC13042fc3.e(uri, "Uri.parse(this)");
        h hVarA = c0104a.a(uri).a();
        return this instanceof j ? ((j) this).i0(hVarA) : L(hVarA);
    }

    public final void O(int i, AbstractC6935Pp4 abstractC6935Pp4) {
        AbstractC13042fc3.i(abstractC6935Pp4, "action");
        if (V()) {
            if (i == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0".toString());
            }
            this.f.l(i, abstractC6935Pp4);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public final void P(int i) {
        this.h = i;
        this.c = null;
    }

    public final void Q(CharSequence charSequence) {
        this.d = charSequence;
    }

    public final void R(j jVar) {
        this.b = jVar;
    }

    public final void S(String str) {
        Object next;
        if (str == null) {
            P(0);
        } else {
            if (!(!AbstractC20762sZ6.n0(str))) {
                throw new IllegalArgumentException("Cannot have an empty route".toString());
            }
            String strA = j.a(str);
            P(strA.hashCode());
            j(strA);
        }
        List list = this.e;
        List list2 = list;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (AbstractC13042fc3.d(((g) next).y(), j.a(this.i))) {
                    break;
                }
            }
        }
        AbstractC19810qy7.a(list2).remove(next);
        this.i = str;
    }

    public boolean V() {
        return true;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        boolean zD = AbstractC13042fc3.d(this.e, iVar.e);
        if (this.f.o() != iVar.f.o()) {
            z = false;
            break;
        }
        Iterator it = AbstractC9962aq6.c(AbstractC20609sI6.a(this.f)).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (!AbstractC13042fc3.d(this.f.f(iIntValue), iVar.f.f(iIntValue))) {
                z = false;
                break;
            }
        }
        z = true;
        if (this.g.size() != iVar.g.size()) {
            z2 = false;
            break;
        }
        for (Map.Entry entry : AbstractC21263tO3.B(this.g)) {
            if (!iVar.g.containsKey(entry.getKey()) || !AbstractC13042fc3.d(iVar.g.get(entry.getKey()), entry.getValue())) {
                z2 = false;
                break;
            }
        }
        z2 = true;
        return this.h == iVar.h && AbstractC13042fc3.d(this.i, iVar.i) && zD && z && z2;
    }

    public final void h(String str, androidx.navigation.b bVar) {
        AbstractC13042fc3.i(str, "argumentName");
        AbstractC13042fc3.i(bVar, "argument");
        this.g.put(str, bVar);
    }

    public int hashCode() {
        int i = this.h * 31;
        String str = this.i;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        for (g gVar : this.e) {
            int i2 = iHashCode * 31;
            String strY = gVar.y();
            int iHashCode2 = (i2 + (strY != null ? strY.hashCode() : 0)) * 31;
            String strI = gVar.i();
            int iHashCode3 = (iHashCode2 + (strI != null ? strI.hashCode() : 0)) * 31;
            String strT = gVar.t();
            iHashCode = iHashCode3 + (strT != null ? strT.hashCode() : 0);
        }
        Iterator itB = AbstractC20609sI6.b(this.f);
        if (itB.hasNext()) {
            AbstractC18350oW3.a(itB.next());
            throw null;
        }
        for (String str2 : this.g.keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str2.hashCode()) * 31;
            Object obj = this.g.get(str2);
            iHashCode = iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(g gVar) {
        AbstractC13042fc3.i(gVar, "navDeepLink");
        List listA = AbstractC7179Qp4.a(this.g, new c(gVar));
        if (listA.isEmpty()) {
            this.e.add(gVar);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + gVar.y() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + listA).toString());
    }

    public final void j(String str) {
        AbstractC13042fc3.i(str, "uriPattern");
        i(new g.a().b(str).a());
    }

    public final Bundle o(Bundle bundle) {
        Map map;
        if (bundle == null && ((map = this.g) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry entry : this.g.entrySet()) {
            ((androidx.navigation.b) entry.getValue()).d((String) entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry entry2 : this.g.entrySet()) {
                String str = (String) entry2.getKey();
                androidx.navigation.b bVar = (androidx.navigation.b) entry2.getValue();
                if (!bVar.e(str, bundle2)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + str + "' in argument bundle. " + bVar.a().b() + " expected.").toString());
                }
            }
        }
        return bundle2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] t(androidx.navigation.i r6) {
        /*
            r5 = this;
            ir.nasim.BJ r0 = new ir.nasim.BJ
            r0.<init>()
            r1 = r5
        L6:
            ir.nasim.AbstractC13042fc3.f(r1)
            androidx.navigation.j r2 = r1.b
            if (r6 == 0) goto L10
            androidx.navigation.j r3 = r6.b
            goto L11
        L10:
            r3 = 0
        L11:
            if (r3 == 0) goto L24
            androidx.navigation.j r3 = r6.b
            ir.nasim.AbstractC13042fc3.f(r3)
            int r4 = r1.h
            androidx.navigation.i r3 = r3.Z(r4)
            if (r3 != r1) goto L24
            r0.addFirst(r1)
            goto L3a
        L24:
            if (r2 == 0) goto L2e
            int r3 = r2.g0()
            int r4 = r1.h
            if (r3 == r4) goto L31
        L2e:
            r0.addFirst(r1)
        L31:
            boolean r1 = ir.nasim.AbstractC13042fc3.d(r2, r6)
            if (r1 == 0) goto L38
            goto L3a
        L38:
            if (r2 != 0) goto L6a
        L3a:
            java.util.List r6 = ir.nasim.ZW0.m1(r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = ir.nasim.ZW0.x(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L4f:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L65
            java.lang.Object r1 = r6.next()
            androidx.navigation.i r1 = (androidx.navigation.i) r1
            int r1 = r1.h
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.add(r1)
            goto L4f
        L65:
            int[] r6 = ir.nasim.ZW0.l1(r0)
            return r6
        L6a:
            r1 = r2
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.i.t(androidx.navigation.i):int[]");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(Separators.LPAREN);
        String str = this.c;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.h));
        } else {
            sb.append(str);
        }
        sb.append(Separators.RPAREN);
        String str2 = this.i;
        if (str2 != null && !AbstractC20762sZ6.n0(str2)) {
            sb.append(" route=");
            sb.append(this.i);
        }
        if (this.d != null) {
            sb.append(" label=");
            sb.append(this.d);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "sb.toString()");
        return string;
    }

    public String x() {
        String str = this.c;
        return str == null ? String.valueOf(this.h) : str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(p pVar) {
        this(q.b.a(pVar.getClass()));
        AbstractC13042fc3.i(pVar, "navigator");
    }
}
