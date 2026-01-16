package com.caverock.androidsvg;

import android.gov.nist.core.Separators;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.caverock.androidsvg.g;
import com.caverock.androidsvg.i;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
class b {
    private f a;
    private u b;
    private boolean c;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[j.values().length];
            b = iArr;
            try {
                iArr[j.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[j.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[j.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[j.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[j.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[j.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[j.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[j.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[j.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[j.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[j.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[j.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[j.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[j.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[j.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                b[j.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                b[j.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                b[j.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                b[j.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                b[j.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                b[j.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                b[j.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                b[j.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                b[j.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[c.values().length];
            a = iArr2;
            try {
                iArr2[c.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[c.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[c.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: com.caverock.androidsvg.b$b, reason: collision with other inner class name */
    private static class C0152b {
        public final String a;
        final c b;
        public final String c;

        C0152b(String str, c cVar, String str2) {
            this.a = str;
            this.b = cVar;
            this.c = str2;
        }
    }

    private enum c {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    private static class d extends i.C0156i {

        private static class a {
            public int a;
            public int b;

            a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }
        }

        d(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int C(int i) {
            if (i >= 48 && i <= 57) {
                return i - 48;
            }
            if (i >= 65 && i <= 70) {
                return i - 55;
            }
            if (i < 97 || i > 102) {
                return -1;
            }
            return i - 87;
        }

        private a D() {
            com.caverock.androidsvg.c cVarC;
            a aVar;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            int i2 = 1;
            if (g("odd")) {
                aVar = new a(2, 1);
            } else {
                if (g("even")) {
                    aVar = new a(2, 0);
                } else {
                    int i3 = (!f('+') && f('-')) ? -1 : 1;
                    com.caverock.androidsvg.c cVarC2 = com.caverock.androidsvg.c.c(this.a, this.b, this.c, false);
                    if (cVarC2 != null) {
                        this.b = cVarC2.a();
                    }
                    if (f('n') || f('N')) {
                        if (cVarC2 == null) {
                            cVarC2 = new com.caverock.androidsvg.c(1L, this.b);
                        }
                        A();
                        boolean zF = f('+');
                        if (!zF && (zF = f('-'))) {
                            i2 = -1;
                        }
                        if (zF) {
                            A();
                            cVarC = com.caverock.androidsvg.c.c(this.a, this.b, this.c, false);
                            if (cVarC == null) {
                                this.b = i;
                                return null;
                            }
                            this.b = cVarC.a();
                        } else {
                            cVarC = null;
                        }
                        int i4 = i2;
                        i2 = i3;
                        i3 = i4;
                    } else {
                        cVarC = cVarC2;
                        cVarC2 = null;
                    }
                    aVar = new a(cVarC2 == null ? 0 : i2 * cVarC2.d(), cVarC != null ? i3 * cVarC.d() : 0);
                }
            }
            A();
            if (f(')')) {
                return aVar;
            }
            this.b = i;
            return null;
        }

        private String E() {
            if (h()) {
                return null;
            }
            String strQ = q();
            return strQ != null ? strQ : H();
        }

        private List G() {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String strH = H();
                if (strH == null) {
                    this.b = i;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strH);
                A();
            } while (z());
            if (f(')')) {
                return arrayList;
            }
            this.b = i;
            return null;
        }

        private List K() {
            List list;
            List list2;
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!f('(')) {
                return null;
            }
            A();
            List listL = L();
            if (listL == null) {
                this.b = i;
                return null;
            }
            if (!f(')')) {
                this.b = i;
                return null;
            }
            Iterator it = listL.iterator();
            while (it.hasNext() && (list = ((s) it.next()).a) != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext() && (list2 = ((t) it2.next()).d) != null) {
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        if (((g) it3.next()) instanceof k) {
                            return null;
                        }
                    }
                }
            }
            return listL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List L() {
            a aVar = null;
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            s sVar = new s(aVar);
            while (!h() && M(sVar)) {
                if (z()) {
                    arrayList.add(sVar);
                    sVar = new s(aVar);
                }
            }
            if (!sVar.f()) {
                arrayList.add(sVar);
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void O(s sVar, t tVar) throws com.caverock.androidsvg.a {
            g hVar;
            h hVar2;
            String strH = H();
            if (strH == null) {
                throw new com.caverock.androidsvg.a("Invalid pseudo class");
            }
            j jVarA = j.a(strH);
            a aVar = null;
            switch (a.b[jVarA.ordinal()]) {
                case 1:
                    hVar = new h(0, 1, true, false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 2:
                    hVar = new h(0, 1, false, false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 3:
                    hVar = new m(false, null);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 4:
                    hVar = new h(0, 1, true, true, tVar.b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 5:
                    hVar = new h(0, 1, false, true, tVar.b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 6:
                    hVar = new m(true, tVar.b);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 7:
                    hVar = new n(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 8:
                    hVar = new i(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 9:
                case 10:
                case 11:
                case 12:
                    boolean z = jVarA == j.nth_child || jVarA == j.nth_of_type;
                    boolean z2 = jVarA == j.nth_of_type || jVarA == j.nth_last_of_type;
                    a aVarD = D();
                    if (aVarD == null) {
                        throw new com.caverock.androidsvg.a("Invalid or missing parameter section for pseudo class: " + strH);
                    }
                    h hVar3 = new h(aVarD.a, aVarD.b, z, z2, tVar.b);
                    sVar.b();
                    hVar2 = hVar3;
                    hVar = hVar2;
                    tVar.b(hVar);
                    return;
                case 13:
                    List listK = K();
                    if (listK == null) {
                        throw new com.caverock.androidsvg.a("Invalid or missing parameter section for pseudo class: " + strH);
                    }
                    k kVar = new k(listK);
                    sVar.b = kVar.b();
                    hVar2 = kVar;
                    hVar = hVar2;
                    tVar.b(hVar);
                    return;
                case 14:
                    hVar = new o(aVar);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 15:
                    G();
                    hVar = new l(strH);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    hVar = new l(strH);
                    sVar.b();
                    tVar.b(hVar);
                    return;
                default:
                    throw new com.caverock.androidsvg.a("Unsupported pseudo class: " + strH);
            }
        }

        private int P() {
            int i;
            if (h()) {
                return this.b;
            }
            int i2 = this.b;
            int iCharAt = this.a.charAt(i2);
            if (iCharAt == 45) {
                iCharAt = a();
            }
            if ((iCharAt < 65 || iCharAt > 90) && ((iCharAt < 97 || iCharAt > 122) && iCharAt != 95)) {
                i = i2;
            } else {
                int iA = a();
                while (true) {
                    if ((iA < 65 || iA > 90) && ((iA < 97 || iA > 122) && !((iA >= 48 && iA <= 57) || iA == 45 || iA == 95))) {
                        break;
                    }
                    iA = a();
                }
                i = this.b;
            }
            this.b = i2;
            return i;
        }

        String F() {
            int iC;
            if (h()) {
                return null;
            }
            char cCharAt = this.a.charAt(this.b);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.b++;
            int iIntValue = l().intValue();
            while (iIntValue != -1 && iIntValue != cCharAt) {
                if (iIntValue == 92) {
                    iIntValue = l().intValue();
                    if (iIntValue != -1) {
                        if (iIntValue == 10 || iIntValue == 13 || iIntValue == 12) {
                            iIntValue = l().intValue();
                        } else {
                            int iC2 = C(iIntValue);
                            if (iC2 != -1) {
                                for (int i = 1; i <= 5 && (iC = C((iIntValue = l().intValue()))) != -1; i++) {
                                    iC2 = (iC2 * 16) + iC;
                                }
                                sb.append((char) iC2);
                            }
                        }
                    }
                }
                sb.append((char) iIntValue);
                iIntValue = l().intValue();
            }
            return sb.toString();
        }

        String H() {
            int iP = P();
            int i = this.b;
            if (iP == i) {
                return null;
            }
            String strSubstring = this.a.substring(i, iP);
            this.b = iP;
            return strSubstring;
        }

        String I() {
            char cCharAt;
            int iC;
            StringBuilder sb = new StringBuilder();
            while (!h() && (cCharAt = this.a.charAt(this.b)) != '\'' && cCharAt != '\"' && cCharAt != '(' && cCharAt != ')' && !k(cCharAt) && !Character.isISOControl((int) cCharAt)) {
                this.b++;
                if (cCharAt == '\\') {
                    if (!h()) {
                        String str = this.a;
                        int i = this.b;
                        this.b = i + 1;
                        cCharAt = str.charAt(i);
                        if (cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\f') {
                            int iC2 = C(cCharAt);
                            if (iC2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !h() && (iC = C(this.a.charAt(this.b))) != -1; i2++) {
                                    this.b++;
                                    iC2 = (iC2 * 16) + iC;
                                }
                                sb.append((char) iC2);
                            }
                        }
                    }
                }
                sb.append(cCharAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String J() {
            if (h()) {
                return null;
            }
            int i = this.b;
            int iCharAt = this.a.charAt(i);
            int i2 = i;
            while (iCharAt != -1 && iCharAt != 59 && iCharAt != 125 && iCharAt != 33 && !j(iCharAt)) {
                if (!k(iCharAt)) {
                    i2 = this.b + 1;
                }
                iCharAt = a();
            }
            if (this.b > i) {
                return this.a.substring(i, i2);
            }
            this.b = i;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        boolean M(com.caverock.androidsvg.b.s r11) throws com.caverock.androidsvg.a {
            /*
                Method dump skipped, instructions count: 310
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.b.d.M(com.caverock.androidsvg.b$s):boolean");
        }

        String N() {
            if (h()) {
                return null;
            }
            int i = this.b;
            if (!g("url(")) {
                return null;
            }
            A();
            String strF = F();
            if (strF == null) {
                strF = I();
            }
            if (strF == null) {
                this.b = i;
                return null;
            }
            A();
            if (h() || g(Separators.RPAREN)) {
                return strF;
            }
            this.b = i;
            return null;
        }
    }

    private enum e {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    enum f {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    private interface g {
        boolean a(q qVar, g.L l);
    }

    private static class h implements g {
        private int a;
        private int b;
        private boolean c;
        private boolean d;
        private String e;

        h(int i, int i2, boolean z, boolean z2, String str) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = z2;
            this.e = str;
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            int i;
            int i2;
            String strO = (this.d && this.e == null) ? l.o() : this.e;
            g.J j = l.b;
            if (j != null) {
                Iterator it = j.d().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    g.L l2 = (g.L) ((g.N) it.next());
                    if (l2 == l) {
                        i = i2;
                    }
                    if (strO == null || l2.o().equals(strO)) {
                        i2++;
                    }
                }
            } else {
                i = 0;
                i2 = 1;
            }
            int i3 = this.c ? i + 1 : i2 - i;
            int i4 = this.a;
            if (i4 == 0) {
                return i3 == this.b;
            }
            int i5 = this.b;
            if ((i3 - i5) % i4 == 0) {
                return Integer.signum(i3 - i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.a);
            }
            return false;
        }

        public String toString() {
            String str = this.c ? "" : "last-";
            return this.d ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.a), Integer.valueOf(this.b), this.e) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.a), Integer.valueOf(this.b));
        }
    }

    private static class i implements g {
        private i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            return !(l instanceof g.J) || ((g.J) l).d().size() == 0;
        }

        public String toString() {
            return "empty";
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    private enum j {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map z = new HashMap();

        static {
            for (j jVar : values()) {
                if (jVar != UNSUPPORTED) {
                    z.put(jVar.name().replace('_', '-'), jVar);
                }
            }
        }

        public static j a(String str) {
            j jVar = (j) z.get(str);
            return jVar != null ? jVar : UNSUPPORTED;
        }
    }

    private static class k implements g {
        private List a;

        k(List list) {
            this.a = list;
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                if (b.l(qVar, (s) it.next(), l)) {
                    return false;
                }
            }
            return true;
        }

        int b() {
            Iterator it = this.a.iterator();
            int i = RecyclerView.UNDEFINED_DURATION;
            while (it.hasNext()) {
                int i2 = ((s) it.next()).b;
                if (i2 > i) {
                    i = i2;
                }
            }
            return i;
        }

        public String toString() {
            return "not(" + this.a + Separators.RPAREN;
        }
    }

    private static class l implements g {
        private String a;

        l(String str) {
            this.a = str;
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            return false;
        }

        public String toString() {
            return this.a;
        }
    }

    private static class m implements g {
        private boolean a;
        private String b;

        public m(boolean z, String str) {
            this.a = z;
            this.b = str;
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            int i;
            String strO = (this.a && this.b == null) ? l.o() : this.b;
            g.J j = l.b;
            if (j != null) {
                Iterator it = j.d().iterator();
                i = 0;
                while (it.hasNext()) {
                    g.L l2 = (g.L) ((g.N) it.next());
                    if (strO == null || l2.o().equals(strO)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public String toString() {
            return this.a ? String.format("only-of-type <%s>", this.b) : String.format("only-child", new Object[0]);
        }
    }

    private static class n implements g {
        private n() {
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            return l.b == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    private static class o implements g {
        private o() {
        }

        @Override // com.caverock.androidsvg.b.g
        public boolean a(q qVar, g.L l) {
            return qVar != null && l == qVar.a;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ o(a aVar) {
            this();
        }
    }

    static class p {
        s a;
        g.E b;
        u c;

        p(s sVar, g.E e, u uVar) {
            this.a = sVar;
            this.b = e;
            this.c = uVar;
        }

        public String toString() {
            return String.valueOf(this.a) + " {...} (src=" + this.c + Separators.RPAREN;
        }
    }

    static class q {
        g.L a;

        q() {
        }

        public String toString() {
            g.L l = this.a;
            return l != null ? String.format("<%s id=\"%s\">", l.o(), this.a.c) : "";
        }
    }

    static class r {
        private List a = null;

        r() {
        }

        void a(p pVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            for (int i = 0; i < this.a.size(); i++) {
                if (((p) this.a.get(i)).a.b > pVar.a.b) {
                    this.a.add(i, pVar);
                    return;
                }
            }
            this.a.add(pVar);
        }

        void b(r rVar) {
            if (rVar.a == null) {
                return;
            }
            if (this.a == null) {
                this.a = new ArrayList(rVar.a.size());
            }
            Iterator it = rVar.a.iterator();
            while (it.hasNext()) {
                a((p) it.next());
            }
        }

        List c() {
            return this.a;
        }

        boolean d() {
            List list = this.a;
            return list == null || list.isEmpty();
        }

        void e(u uVar) {
            List list = this.a;
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((p) it.next()).c == uVar) {
                    it.remove();
                }
            }
        }

        int f() {
            List list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                sb.append(((p) it.next()).toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    private static class t {
        e a;
        String b;
        List c = null;
        List d = null;

        t(e eVar, String str) {
            this.a = null;
            this.b = null;
            this.a = eVar == null ? e.DESCENDANT : eVar;
            this.b = str;
        }

        void a(String str, c cVar, String str2) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(new C0152b(str, cVar, str2));
        }

        void b(g gVar) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            this.d.add(gVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            e eVar = this.a;
            if (eVar == e.CHILD) {
                sb.append("> ");
            } else if (eVar == e.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.b;
            if (str == null) {
                str = Separators.STAR;
            }
            sb.append(str);
            List<C0152b> list = this.c;
            if (list != null) {
                for (C0152b c0152b : list) {
                    sb.append('[');
                    sb.append(c0152b.a);
                    int i = a.a[c0152b.b.ordinal()];
                    if (i == 1) {
                        sb.append('=');
                        sb.append(c0152b.c);
                    } else if (i == 2) {
                        sb.append("~=");
                        sb.append(c0152b.c);
                    } else if (i == 3) {
                        sb.append("|=");
                        sb.append(c0152b.c);
                    }
                    sb.append(']');
                }
            }
            List<g> list2 = this.d;
            if (list2 != null) {
                for (g gVar : list2) {
                    sb.append(':');
                    sb.append(gVar);
                }
            }
            return sb.toString();
        }
    }

    enum u {
        Document,
        RenderOptions
    }

    b(u uVar) {
        this(f.screen, uVar);
    }

    private static int a(List list, int i2, g.L l2) {
        int i3 = 0;
        if (i2 < 0) {
            return 0;
        }
        Object obj = list.get(i2);
        g.J j2 = l2.b;
        if (obj != j2) {
            return -1;
        }
        Iterator it = j2.d().iterator();
        while (it.hasNext()) {
            if (((g.N) it.next()) == l2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    static boolean b(String str, f fVar) {
        d dVar = new d(str);
        dVar.A();
        return c(h(dVar), fVar);
    }

    private static boolean c(List list, f fVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            if (fVar2 == f.all || fVar2 == fVar) {
                return true;
            }
        }
        return false;
    }

    private void e(r rVar, d dVar) throws com.caverock.androidsvg.a {
        String strH = dVar.H();
        dVar.A();
        if (strH == null) {
            throw new com.caverock.androidsvg.a("Invalid '@' rule");
        }
        if (!this.c && strH.equals("media")) {
            List listH = h(dVar);
            if (!dVar.f('{')) {
                throw new com.caverock.androidsvg.a("Invalid @media rule: missing rule set");
            }
            dVar.A();
            if (c(listH, this.a)) {
                this.c = true;
                rVar.b(j(dVar));
                this.c = false;
            } else {
                j(dVar);
            }
            if (!dVar.h() && !dVar.f('}')) {
                throw new com.caverock.androidsvg.a("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (this.c || !strH.equals("import")) {
            p("Ignoring @%s rule", strH);
            o(dVar);
        } else {
            String strN = dVar.N();
            if (strN == null) {
                strN = dVar.F();
            }
            if (strN == null) {
                throw new com.caverock.androidsvg.a("Invalid @import rule: expected string or url()");
            }
            dVar.A();
            h(dVar);
            if (!dVar.h() && !dVar.f(';')) {
                throw new com.caverock.androidsvg.a("Invalid @media rule: expected '}' at end of rule set");
            }
            com.caverock.androidsvg.g.k();
        }
        dVar.A();
    }

    public static List f(String str) {
        d dVar = new d(str);
        ArrayList arrayList = null;
        while (!dVar.h()) {
            String strR = dVar.r();
            if (strR != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strR);
                dVar.A();
            }
        }
        return arrayList;
    }

    private g.E g(d dVar) throws com.caverock.androidsvg.a {
        g.E e2 = new g.E();
        do {
            String strH = dVar.H();
            dVar.A();
            if (!dVar.f(':')) {
                throw new com.caverock.androidsvg.a("Expected ':'");
            }
            dVar.A();
            String strJ = dVar.J();
            if (strJ == null) {
                throw new com.caverock.androidsvg.a("Expected property value");
            }
            dVar.A();
            if (dVar.f('!')) {
                dVar.A();
                if (!dVar.g("important")) {
                    throw new com.caverock.androidsvg.a("Malformed rule set: found unexpected '!'");
                }
                dVar.A();
            }
            dVar.f(';');
            com.caverock.androidsvg.i.S0(e2, strH, strJ);
            dVar.A();
            if (dVar.h()) {
                break;
            }
        } while (!dVar.f('}'));
        return e2;
    }

    private static List h(d dVar) {
        String strW;
        ArrayList arrayList = new ArrayList();
        while (!dVar.h() && (strW = dVar.w()) != null) {
            try {
                arrayList.add(f.valueOf(strW));
            } catch (IllegalArgumentException unused) {
            }
            if (!dVar.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(r rVar, d dVar) throws com.caverock.androidsvg.a {
        List listL = dVar.L();
        if (listL == null || listL.isEmpty()) {
            return false;
        }
        if (!dVar.f('{')) {
            throw new com.caverock.androidsvg.a("Malformed rule block: expected '{'");
        }
        dVar.A();
        g.E eG = g(dVar);
        dVar.A();
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            rVar.a(new p((s) it.next(), eG, this.b));
        }
        return true;
    }

    private r j(d dVar) {
        r rVar = new r();
        while (!dVar.h()) {
            try {
                if (!dVar.g("<!--") && !dVar.g("-->")) {
                    if (!dVar.f('@')) {
                        if (!i(rVar, dVar)) {
                            break;
                        }
                    } else {
                        e(rVar, dVar);
                    }
                }
            } catch (com.caverock.androidsvg.a e2) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e2.getMessage());
            }
        }
        return rVar;
    }

    private static boolean k(q qVar, s sVar, int i2, List list, int i3, g.L l2) {
        t tVarE = sVar.e(i2);
        if (!n(qVar, tVarE, list, i3, l2)) {
            return false;
        }
        e eVar = tVarE.a;
        if (eVar == e.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 >= 0) {
                if (m(qVar, sVar, i2 - 1, list, i3)) {
                    return true;
                }
                i3--;
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return m(qVar, sVar, i2 - 1, list, i3);
        }
        int iA = a(list, i3, l2);
        if (iA <= 0) {
            return false;
        }
        return k(qVar, sVar, i2 - 1, list, i3, (g.L) l2.b.d().get(iA - 1));
    }

    static boolean l(q qVar, s sVar, g.L l2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = l2.b; obj != null; obj = ((g.N) obj).b) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        return sVar.g() == 1 ? n(qVar, sVar.e(0), arrayList, size, l2) : k(qVar, sVar, sVar.g() - 1, arrayList, size, l2);
    }

    private static boolean m(q qVar, s sVar, int i2, List list, int i3) {
        t tVarE = sVar.e(i2);
        g.L l2 = (g.L) list.get(i3);
        if (!n(qVar, tVarE, list, i3, l2)) {
            return false;
        }
        e eVar = tVarE.a;
        if (eVar == e.DESCENDANT) {
            if (i2 == 0) {
                return true;
            }
            while (i3 > 0) {
                i3--;
                if (m(qVar, sVar, i2 - 1, list, i3)) {
                    return true;
                }
            }
            return false;
        }
        if (eVar == e.CHILD) {
            return m(qVar, sVar, i2 - 1, list, i3 - 1);
        }
        int iA = a(list, i3, l2);
        if (iA <= 0) {
            return false;
        }
        return k(qVar, sVar, i2 - 1, list, i3, (g.L) l2.b.d().get(iA - 1));
    }

    private static boolean n(q qVar, t tVar, List list, int i2, g.L l2) {
        List list2;
        String str = tVar.b;
        if (str != null && !str.equals(l2.o().toLowerCase(Locale.US))) {
            return false;
        }
        List<C0152b> list3 = tVar.c;
        if (list3 != null) {
            for (C0152b c0152b : list3) {
                String str2 = c0152b.a;
                str2.hashCode();
                if (str2.equals("id")) {
                    if (!c0152b.c.equals(l2.c)) {
                        return false;
                    }
                } else if (!str2.equals("class") || (list2 = l2.g) == null || !list2.contains(c0152b.c)) {
                    return false;
                }
            }
        }
        List list4 = tVar.d;
        if (list4 == null) {
            return true;
        }
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).a(qVar, l2)) {
                return false;
            }
        }
        return true;
    }

    private void o(d dVar) {
        int i2 = 0;
        while (!dVar.h()) {
            int iIntValue = dVar.l().intValue();
            if (iIntValue == 59 && i2 == 0) {
                return;
            }
            if (iIntValue == 123) {
                i2++;
            } else if (iIntValue == 125 && i2 > 0 && i2 - 1 == 0) {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    r d(String str) {
        d dVar = new d(str);
        dVar.A();
        return j(dVar);
    }

    b(f fVar, u uVar) {
        this.c = false;
        this.a = fVar;
        this.b = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class s {
        List a;
        int b;

        private s() {
            this.a = null;
            this.b = 0;
        }

        void a(t tVar) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(tVar);
        }

        void b() {
            this.b += AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        }

        void c() {
            this.b++;
        }

        void d() {
            this.b += 1000000;
        }

        t e(int i) {
            return (t) this.a.get(i);
        }

        boolean f() {
            List list = this.a;
            return list == null || list.isEmpty();
        }

        int g() {
            List list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                sb.append((t) it.next());
                sb.append(' ');
            }
            sb.append('[');
            sb.append(this.b);
            sb.append(']');
            return sb.toString();
        }

        /* synthetic */ s(a aVar) {
            this();
        }
    }
}
