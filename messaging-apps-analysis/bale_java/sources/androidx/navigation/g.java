package androidx.navigation;

import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Bundle;
import io.sentry.C3155n3;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC7179Qp4;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9766aX0;
import ir.nasim.C19938rB7;
import ir.nasim.C20644sM5;
import ir.nasim.ED1;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.XV4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class g {
    private static final b q = new b(null);
    private static final Pattern r = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern s = Pattern.compile("\\{(.+?)\\}");
    private final String a;
    private final String b;
    private final String c;
    private String e;
    private final InterfaceC9173Yu3 h;
    private boolean i;
    private final InterfaceC9173Yu3 j;
    private final InterfaceC9173Yu3 k;
    private final InterfaceC9173Yu3 l;
    private final InterfaceC9173Yu3 m;
    private String n;
    private final InterfaceC9173Yu3 o;
    private boolean p;
    private final List d = new ArrayList();
    private final InterfaceC9173Yu3 f = AbstractC13269fw3.a(new l());
    private final InterfaceC9173Yu3 g = AbstractC13269fw3.a(new j());

    public static final class a {
        public static final C0102a d = new C0102a(null);
        private String a;
        private String b;
        private String c;

        /* renamed from: androidx.navigation.g$a$a, reason: collision with other inner class name */
        public static final class C0102a {
            private C0102a() {
            }

            public /* synthetic */ C0102a(ED1 ed1) {
                this();
            }
        }

        public final g a() {
            return new g(this.a, this.b, this.c);
        }

        public final a b(String str) {
            AbstractC13042fc3.i(str, "uriPattern");
            this.a = str;
            return this;
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    private static final class c implements Comparable {
        private String a;
        private String b;

        public c(String str) {
            List listM;
            AbstractC13042fc3.i(str, "mimeType");
            List listM2 = new C20644sM5(Separators.SLASH).m(str, 0);
            if (listM2.isEmpty()) {
                listM = AbstractC10360bX0.m();
            } else {
                ListIterator listIterator = listM2.listIterator(listM2.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        listM = AbstractC15401jX0.f1(listM2, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listM = AbstractC10360bX0.m();
            }
            this.a = (String) listM.get(0);
            this.b = (String) listM.get(1);
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            AbstractC13042fc3.i(cVar, "other");
            int i = AbstractC13042fc3.d(this.a, cVar.a) ? 2 : 0;
            return AbstractC13042fc3.d(this.b, cVar.b) ? i + 1 : i;
        }

        public final String h() {
            return this.b;
        }

        public final String i() {
            return this.a;
        }
    }

    private static final class d {
        private String a;
        private final List b = new ArrayList();

        public final void a(String str) {
            AbstractC13042fc3.i(str, "name");
            this.b.add(str);
        }

        public final List b() {
            return this.b;
        }

        public final String c() {
            return this.a;
        }

        public final void d(String str) {
            this.a = str;
        }
    }

    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List list;
            XV4 xv4L = g.this.l();
            return (xv4L == null || (list = (List) xv4L.e()) == null) ? new ArrayList() : list;
        }
    }

    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XV4 invoke() {
            return g.this.D();
        }
    }

    /* renamed from: androidx.navigation.g$g, reason: collision with other inner class name */
    static final class C0103g extends AbstractC8614Ws3 implements SA2 {
        C0103g() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pattern invoke() {
            String strN = g.this.n();
            if (strN != null) {
                return Pattern.compile(strN, 2);
            }
            return null;
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            XV4 xv4L = g.this.l();
            if (xv4L != null) {
                return (String) xv4L.f();
            }
            return null;
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Bundle e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(Bundle bundle) {
            super(1);
            this.e = bundle;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            AbstractC13042fc3.i(str, "argName");
            return Boolean.valueOf(!this.e.containsKey(str));
        }
    }

    static final class j extends AbstractC8614Ws3 implements SA2 {
        j() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.valueOf((g.this.y() == null || Uri.parse(g.this.y()).getQuery() == null) ? false : true);
        }
    }

    static final class k extends AbstractC8614Ws3 implements SA2 {
        k() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pattern invoke() {
            String str = g.this.n;
            if (str != null) {
                return Pattern.compile(str);
            }
            return null;
        }
    }

    static final class l extends AbstractC8614Ws3 implements SA2 {
        l() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pattern invoke() {
            String str = g.this.e;
            if (str != null) {
                return Pattern.compile(str, 2);
            }
            return null;
        }
    }

    static final class m extends AbstractC8614Ws3 implements SA2 {
        m() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map invoke() {
            return g.this.H();
        }
    }

    public g(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.h = AbstractC13269fw3.b(enumC4870Gx3, new m());
        this.j = AbstractC13269fw3.b(enumC4870Gx3, new f());
        this.k = AbstractC13269fw3.b(enumC4870Gx3, new e());
        this.l = AbstractC13269fw3.b(enumC4870Gx3, new h());
        this.m = AbstractC13269fw3.a(new C0103g());
        this.o = AbstractC13269fw3.a(new k());
        G();
        F();
    }

    private final boolean A() {
        return ((Boolean) this.g.getValue()).booleanValue();
    }

    private final boolean B(Bundle bundle, String str, String str2, androidx.navigation.b bVar) {
        if (bVar != null) {
            bVar.a().d(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    private final boolean C(Bundle bundle, String str, String str2, androidx.navigation.b bVar) {
        if (!bundle.containsKey(str)) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        o oVarA = bVar.a();
        oVarA.e(bundle, str, str2, oVarA.a(bundle, str));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 D() {
        String str = this.a;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.a).getFragment();
        StringBuilder sb = new StringBuilder();
        AbstractC13042fc3.f(fragment);
        g(fragment, arrayList, sb);
        String string = sb.toString();
        AbstractC13042fc3.h(string, "fragRegex.toString()");
        return AbstractC4616Fw7.a(arrayList, string);
    }

    private final boolean E(List list, d dVar, Bundle bundle, Map map) {
        if (list == null) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String strC = dVar.c();
            Matcher matcher = strC != null ? Pattern.compile(strC, 32).matcher(str) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            Bundle bundle2 = new Bundle();
            try {
                List listB = dVar.b();
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listB, 10));
                int i2 = 0;
                for (Object obj : listB) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        AbstractC10360bX0.w();
                    }
                    String str2 = (String) obj;
                    String strGroup = matcher.group(i3);
                    if (strGroup == null) {
                        strGroup = "";
                    } else {
                        AbstractC13042fc3.h(strGroup, "argMatcher.group(index + 1) ?: \"\"");
                    }
                    androidx.navigation.b bVar = (androidx.navigation.b) map.get(str2);
                    if (C(bundle, str2, strGroup, bVar)) {
                        if (!AbstractC13042fc3.d(strGroup, '{' + str2 + '}') && B(bundle2, str2, strGroup, bVar)) {
                            return false;
                        }
                    }
                    arrayList.add(C19938rB7.a);
                    i2 = i3;
                }
                bundle.putAll(bundle2);
            } catch (IllegalArgumentException unused) {
            }
        }
        return true;
    }

    private final void F() {
        if (this.c == null) {
            return;
        }
        if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.c).matches()) {
            throw new IllegalArgumentException(("The given mimeType " + this.c + " does not match to required \"type/subtype\" format").toString());
        }
        c cVar = new c(this.c);
        this.n = AbstractC20153rZ6.M("^(" + cVar.i() + "|[*]+)/(" + cVar.h() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
    }

    private final void G() {
        if (this.a == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!r.matcher(this.a).find()) {
            sb.append("http[s]?://");
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.a);
        matcher.find();
        boolean z = false;
        String strSubstring = this.a.substring(0, matcher.start());
        AbstractC13042fc3.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        g(strSubstring, this.d, sb);
        if (!AbstractC20762sZ6.X(sb, C3155n3.DEFAULT_PROPAGATION_TARGETS, false, 2, null) && !AbstractC20762sZ6.X(sb, "([^/]+?)", false, 2, null)) {
            z = true;
        }
        this.p = z;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        String string = sb.toString();
        AbstractC13042fc3.h(string, "uriRegex.toString()");
        this.e = AbstractC20153rZ6.M(string, C3155n3.DEFAULT_PROPAGATION_TARGETS, "\\E.*\\Q", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map H() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!A()) {
            return linkedHashMap;
        }
        Uri uri = Uri.parse(this.a);
        for (String str : uri.getQueryParameterNames()) {
            StringBuilder sb = new StringBuilder();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (queryParameters.size() > 1) {
                throw new IllegalArgumentException(("Query parameter " + str + " must only be present once in " + this.a + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
            }
            AbstractC13042fc3.h(queryParameters, "queryParams");
            String str2 = (String) AbstractC15401jX0.s0(queryParameters);
            if (str2 == null) {
                this.i = true;
                str2 = str;
            }
            Matcher matcher = s.matcher(str2);
            d dVar = new d();
            int iEnd = 0;
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                AbstractC13042fc3.g(strGroup, "null cannot be cast to non-null type kotlin.String");
                dVar.a(strGroup);
                AbstractC13042fc3.h(str2, "queryParam");
                String strSubstring = str2.substring(iEnd, matcher.start());
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(Pattern.quote(strSubstring));
                sb.append("(.+?)?");
                iEnd = matcher.end();
            }
            if (iEnd < str2.length()) {
                AbstractC13042fc3.h(str2, "queryParam");
                String strSubstring2 = str2.substring(iEnd);
                AbstractC13042fc3.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
                sb.append(Pattern.quote(strSubstring2));
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "argRegex.toString()");
            dVar.d(AbstractC20153rZ6.M(string, C3155n3.DEFAULT_PROPAGATION_TARGETS, "\\E.*\\Q", false, 4, null));
            AbstractC13042fc3.h(str, "paramName");
            linkedHashMap.put(str, dVar);
        }
        return linkedHashMap;
    }

    private final void g(String str, List list, StringBuilder sb) {
        Matcher matcher = s.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            AbstractC13042fc3.g(strGroup, "null cannot be cast to non-null type kotlin.String");
            list.add(strGroup);
            if (matcher.start() > iEnd) {
                String strSubstring = str.substring(iEnd, matcher.start());
                AbstractC13042fc3.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(Pattern.quote(strSubstring));
            }
            sb.append("([^/]+?)");
            iEnd = matcher.end();
        }
        if (iEnd < str.length()) {
            String strSubstring2 = str.substring(iEnd);
            AbstractC13042fc3.h(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb.append(Pattern.quote(strSubstring2));
        }
    }

    private final List k() {
        return (List) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final XV4 l() {
        return (XV4) this.j.getValue();
    }

    private final Pattern m() {
        return (Pattern) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        return (String) this.l.getValue();
    }

    private final boolean q(Matcher matcher, Bundle bundle, Map map) {
        List list = this.d;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            String str = (String) obj;
            String strDecode = Uri.decode(matcher.group(i3));
            androidx.navigation.b bVar = (androidx.navigation.b) map.get(str);
            try {
                AbstractC13042fc3.h(strDecode, "value");
                if (B(bundle, str, strDecode, bVar)) {
                    return false;
                }
                arrayList.add(C19938rB7.a);
                i2 = i3;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean r(Uri uri, Bundle bundle, Map map) {
        String query;
        for (Map.Entry entry : x().entrySet()) {
            String str = (String) entry.getKey();
            d dVar = (d) entry.getValue();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (this.i && (query = uri.getQuery()) != null && !AbstractC13042fc3.d(query, uri.toString())) {
                queryParameters = AbstractC9766aX0.e(query);
            }
            if (!E(queryParameters, dVar, bundle, map)) {
                return false;
            }
        }
        return true;
    }

    private final void s(String str, Bundle bundle, Map map) {
        Pattern patternM = m();
        Matcher matcher = patternM != null ? patternM.matcher(String.valueOf(str)) : null;
        if (matcher != null && matcher.matches()) {
            List listK = k();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listK, 10));
            int i2 = 0;
            for (Object obj : listK) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    AbstractC10360bX0.w();
                }
                String str2 = (String) obj;
                String strDecode = Uri.decode(matcher.group(i3));
                androidx.navigation.b bVar = (androidx.navigation.b) map.get(str2);
                try {
                    AbstractC13042fc3.h(strDecode, "value");
                    if (B(bundle, str2, strDecode, bVar)) {
                        return;
                    }
                    arrayList.add(C19938rB7.a);
                    i2 = i3;
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final Pattern v() {
        return (Pattern) this.o.getValue();
    }

    private final Pattern w() {
        return (Pattern) this.f.getValue();
    }

    private final Map x() {
        return (Map) this.h.getValue();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return AbstractC13042fc3.d(this.a, gVar.a) && AbstractC13042fc3.d(this.b, gVar.b) && AbstractC13042fc3.d(this.c, gVar.c);
    }

    public final int h(Uri uri) {
        if (uri == null || this.a == null) {
            return 0;
        }
        List<String> pathSegments = uri.getPathSegments();
        List<String> pathSegments2 = Uri.parse(this.a).getPathSegments();
        AbstractC13042fc3.h(pathSegments, "requestedPathSegments");
        AbstractC13042fc3.h(pathSegments2, "uriPathSegments");
        return AbstractC15401jX0.w0(pathSegments, pathSegments2).size();
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String i() {
        return this.b;
    }

    public final List j() {
        List list = this.d;
        Collection collectionValues = x().values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList, ((d) it.next()).b());
        }
        return AbstractC15401jX0.R0(AbstractC15401jX0.R0(list, arrayList), k());
    }

    public final Bundle o(Uri uri, Map map) {
        AbstractC13042fc3.i(uri, "deepLink");
        AbstractC13042fc3.i(map, "arguments");
        Pattern patternW = w();
        Matcher matcher = patternW != null ? patternW.matcher(uri.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!q(matcher, bundle, map)) {
            return null;
        }
        if (A() && !r(uri, bundle, map)) {
            return null;
        }
        s(uri.getFragment(), bundle, map);
        if (!AbstractC7179Qp4.a(map, new i(bundle)).isEmpty()) {
            return null;
        }
        return bundle;
    }

    public final Bundle p(Uri uri, Map map) {
        AbstractC13042fc3.i(map, "arguments");
        Bundle bundle = new Bundle();
        if (uri == null) {
            return bundle;
        }
        Pattern patternW = w();
        Matcher matcher = patternW != null ? patternW.matcher(uri.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return bundle;
        }
        q(matcher, bundle, map);
        if (A()) {
            r(uri, bundle, map);
        }
        return bundle;
    }

    public final String t() {
        return this.c;
    }

    public final int u(String str) {
        AbstractC13042fc3.i(str, "mimeType");
        if (this.c != null) {
            Pattern patternV = v();
            AbstractC13042fc3.f(patternV);
            if (patternV.matcher(str).matches()) {
                return new c(this.c).compareTo(new c(str));
            }
        }
        return -1;
    }

    public final String y() {
        return this.a;
    }

    public final boolean z() {
        return this.p;
    }
}
