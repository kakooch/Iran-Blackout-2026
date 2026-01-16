package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.d83, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C11516d83 implements Z73 {
    private static final Pattern i = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern j = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    private static final Pattern k = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    private static final Pattern l = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern m = Pattern.compile("`+");
    private static final Pattern n = Pattern.compile("^`+");
    private static final Pattern o = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern p = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    private static final Pattern q = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern r = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    private static final Pattern s = Pattern.compile("\\s+");
    private static final Pattern t = Pattern.compile(" *$");
    private final BitSet a;
    private final BitSet b;
    private final Map c;
    private final InterfaceC9542a83 d;
    private String e;
    private int f;
    private PH1 g;
    private C6652Ok0 h;

    /* renamed from: ir.nasim.d83$a */
    private static class a {
        final int a;
        final boolean b;
        final boolean c;

        a(int i, boolean z, boolean z2) {
            this.a = i;
            this.c = z;
            this.b = z2;
        }
    }

    public C11516d83(InterfaceC9542a83 interfaceC9542a83) {
        Map mapE = e(interfaceC9542a83.b());
        this.c = mapE;
        BitSet bitSetD = d(mapE.keySet());
        this.b = bitSetD;
        this.a = f(bitSetD);
        this.d = interfaceC9542a83;
    }

    private TA4 A() {
        int i2 = this.f;
        int length = this.e.length();
        while (true) {
            int i3 = this.f;
            if (i3 == length || this.a.get(this.e.charAt(i3))) {
                break;
            }
            this.f++;
        }
        int i4 = this.f;
        if (i2 != i4) {
            return M(this.e, i2, i4);
        }
        return null;
    }

    private char B() {
        if (this.f < this.e.length()) {
            return this.e.charAt(this.f);
        }
        return (char) 0;
    }

    private void C(PH1 ph1) {
        boolean z;
        HashMap map = new HashMap();
        PH1 ph12 = this.g;
        while (ph12 != null) {
            PH1 ph13 = ph12.e;
            if (ph13 == ph1) {
                break;
            } else {
                ph12 = ph13;
            }
        }
        while (ph12 != null) {
            char c = ph12.b;
            QH1 qh1 = (QH1) this.c.get(Character.valueOf(c));
            if (!ph12.d || qh1 == null) {
                ph12 = ph12.f;
            } else {
                char cD = qh1.d();
                PH1 ph14 = ph12.e;
                int iE = 0;
                boolean z2 = false;
                while (ph14 != null && ph14 != ph1 && ph14 != map.get(Character.valueOf(c))) {
                    if (ph14.c && ph14.b == cD) {
                        iE = qh1.e(ph14, ph12);
                        z2 = true;
                        if (iE > 0) {
                            z = true;
                            break;
                        }
                    }
                    ph14 = ph14.e;
                }
                z = z2;
                z2 = false;
                if (z2) {
                    C5693Kk7 c5693Kk7 = ph14.a;
                    C5693Kk7 c5693Kk72 = ph12.a;
                    ph14.g -= iE;
                    ph12.g -= iE;
                    c5693Kk7.n(c5693Kk7.m().substring(0, c5693Kk7.m().length() - iE));
                    c5693Kk72.n(c5693Kk72.m().substring(0, c5693Kk72.m().length() - iE));
                    G(ph14, ph12);
                    k(c5693Kk7, c5693Kk72);
                    qh1.a(c5693Kk7, c5693Kk72, iE);
                    if (ph14.g == 0) {
                        E(ph14);
                    }
                    if (ph12.g == 0) {
                        PH1 ph15 = ph12.f;
                        E(ph12);
                        ph12 = ph15;
                    }
                } else {
                    if (!z) {
                        map.put(Character.valueOf(c), ph12.e);
                        if (!ph12.c) {
                            F(ph12);
                        }
                    }
                    ph12 = ph12.f;
                }
            }
        }
        while (true) {
            PH1 ph16 = this.g;
            if (ph16 == null || ph16 == ph1) {
                return;
            } else {
                F(ph16);
            }
        }
    }

    private void D(PH1 ph1) {
        PH1 ph12 = ph1.e;
        if (ph12 != null) {
            ph12.f = ph1.f;
        }
        PH1 ph13 = ph1.f;
        if (ph13 == null) {
            this.g = ph12;
        } else {
            ph13.e = ph12;
        }
    }

    private void E(PH1 ph1) {
        ph1.a.l();
        D(ph1);
    }

    private void F(PH1 ph1) {
        D(ph1);
    }

    private void G(PH1 ph1, PH1 ph12) {
        PH1 ph13 = ph12.e;
        while (ph13 != null && ph13 != ph1) {
            PH1 ph14 = ph13.e;
            F(ph13);
            ph13 = ph14;
        }
    }

    private void H() {
        this.h = this.h.d;
    }

    private a J(QH1 qh1, char c) {
        boolean z;
        int i2 = this.f;
        boolean z2 = false;
        int i3 = 0;
        while (B() == c) {
            i3++;
            this.f++;
        }
        if (i3 < qh1.c()) {
            this.f = i2;
            return null;
        }
        String strValueOf = Separators.RETURN;
        String strSubstring = i2 == 0 ? Separators.RETURN : this.e.substring(i2 - 1, i2);
        char cB = B();
        if (cB != 0) {
            strValueOf = String.valueOf(cB);
        }
        Pattern pattern = i;
        boolean zMatches = pattern.matcher(strSubstring).matches();
        Pattern pattern2 = r;
        boolean zMatches2 = pattern2.matcher(strSubstring).matches();
        boolean zMatches3 = pattern.matcher(strValueOf).matches();
        boolean zMatches4 = pattern2.matcher(strValueOf).matches();
        boolean z3 = !zMatches4 && (!zMatches3 || zMatches2 || zMatches);
        boolean z4 = !zMatches2 && (!zMatches || zMatches4 || zMatches3);
        if (c == '_') {
            z = z3 && (!z4 || zMatches);
            if (z4 && (!z3 || zMatches3)) {
                z2 = true;
            }
        } else {
            boolean z5 = z3 && c == qh1.d();
            if (z4 && c == qh1.b()) {
                z2 = true;
            }
            z = z5;
        }
        this.f = i2;
        return new a(i3, z, z2);
    }

    private void K() {
        g(q);
    }

    private C5693Kk7 L(String str) {
        return new C5693Kk7(str);
    }

    private C5693Kk7 M(String str, int i2, int i3) {
        return new C5693Kk7(str.substring(i2, i3));
    }

    private void a(C6652Ok0 c6652Ok0) {
        C6652Ok0 c6652Ok02 = this.h;
        if (c6652Ok02 != null) {
            c6652Ok02.g = true;
        }
        this.h = c6652Ok0;
    }

    private static void b(char c, QH1 qh1, Map map) {
        if (((QH1) map.put(Character.valueOf(c), qh1)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c + Separators.QUOTE);
    }

    private static void c(Iterable iterable, Map map) {
        GJ6 gj6;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            QH1 qh1 = (QH1) it.next();
            char cD = qh1.d();
            char cB = qh1.b();
            if (cD == cB) {
                QH1 qh12 = (QH1) map.get(Character.valueOf(cD));
                if (qh12 == null || qh12.d() != qh12.b()) {
                    b(cD, qh1, map);
                } else {
                    if (qh12 instanceof GJ6) {
                        gj6 = (GJ6) qh12;
                    } else {
                        GJ6 gj62 = new GJ6(cD);
                        gj62.f(qh12);
                        gj6 = gj62;
                    }
                    gj6.f(qh1);
                    map.put(Character.valueOf(cD), gj6);
                }
            } else {
                b(cD, qh1, map);
                b(cB, qh1, map);
            }
        }
    }

    public static BitSet d(Set set) {
        BitSet bitSet = new BitSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        return bitSet;
    }

    public static Map e(List list) {
        HashMap map = new HashMap();
        c(Arrays.asList(new C23673xK(), new C11549dB7()), map);
        c(list, map);
        return map;
    }

    public static BitSet f(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    private String g(Pattern pattern) {
        if (this.f >= this.e.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.e);
        matcher.region(this.f, this.e.length());
        if (!matcher.find()) {
            return null;
        }
        this.f = matcher.end();
        return matcher.group();
    }

    private void h(TA4 ta4) {
        if (ta4.c() == ta4.d()) {
            return;
        }
        l(ta4.c(), ta4.d());
    }

    private void j(C5693Kk7 c5693Kk7, C5693Kk7 c5693Kk72, int i2) {
        if (c5693Kk7 == null || c5693Kk72 == null || c5693Kk7 == c5693Kk72) {
            return;
        }
        StringBuilder sb = new StringBuilder(i2);
        sb.append(c5693Kk7.m());
        TA4 ta4E = c5693Kk7.e();
        TA4 ta4E2 = c5693Kk72.e();
        while (ta4E != ta4E2) {
            sb.append(((C5693Kk7) ta4E).m());
            TA4 ta4E3 = ta4E.e();
            ta4E.l();
            ta4E = ta4E3;
        }
        c5693Kk7.n(sb.toString());
    }

    private void k(TA4 ta4, TA4 ta42) {
        if (ta4 == ta42 || ta4.e() == ta42) {
            return;
        }
        l(ta4.e(), ta42.g());
    }

    private void l(TA4 ta4, TA4 ta42) {
        C5693Kk7 c5693Kk7 = null;
        C5693Kk7 c5693Kk72 = null;
        int length = 0;
        while (ta4 != null) {
            if (ta4 instanceof C5693Kk7) {
                c5693Kk72 = (C5693Kk7) ta4;
                if (c5693Kk7 == null) {
                    c5693Kk7 = c5693Kk72;
                }
                length += c5693Kk72.m().length();
            } else {
                j(c5693Kk7, c5693Kk72, length);
                c5693Kk7 = null;
                c5693Kk72 = null;
                length = 0;
            }
            if (ta4 == ta42) {
                break;
            } else {
                ta4 = ta4.e();
            }
        }
        j(c5693Kk7, c5693Kk72, length);
    }

    private TA4 m() {
        String strG = g(o);
        if (strG != null) {
            String strSubstring = strG.substring(1, strG.length() - 1);
            C9452Zz3 c9452Zz3 = new C9452Zz3("mailto:" + strSubstring, null);
            c9452Zz3.b(new C5693Kk7(strSubstring));
            return c9452Zz3;
        }
        String strG2 = g(p);
        if (strG2 == null) {
            return null;
        }
        String strSubstring2 = strG2.substring(1, strG2.length() - 1);
        C9452Zz3 c9452Zz32 = new C9452Zz3(strSubstring2, null);
        c9452Zz32.b(new C5693Kk7(strSubstring2));
        return c9452Zz32;
    }

    private TA4 n() {
        this.f++;
        if (B() == '\n') {
            C17149mU2 c17149mU2 = new C17149mU2();
            this.f++;
            return c17149mU2;
        }
        if (this.f < this.e.length()) {
            Pattern pattern = k;
            String str = this.e;
            int i2 = this.f;
            if (pattern.matcher(str.substring(i2, i2 + 1)).matches()) {
                String str2 = this.e;
                int i3 = this.f;
                C5693Kk7 c5693Kk7M = M(str2, i3, i3 + 1);
                this.f++;
                return c5693Kk7M;
            }
        }
        return L("\\");
    }

    private TA4 o() {
        String strG;
        String strG2 = g(n);
        if (strG2 == null) {
            return null;
        }
        int i2 = this.f;
        do {
            strG = g(m);
            if (strG == null) {
                this.f = i2;
                return L(strG2);
            }
        } while (!strG.equals(strG2));
        BW0 bw0 = new BW0();
        String strReplace = this.e.substring(i2, this.f - strG2.length()).replace('\n', ' ');
        if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && OW4.d(strReplace)) {
            strReplace = strReplace.substring(1, strReplace.length() - 1);
        }
        bw0.n(strReplace);
        return bw0;
    }

    private TA4 p() {
        int i2 = this.f;
        this.f = i2 + 1;
        if (B() != '[') {
            return L("!");
        }
        this.f++;
        C5693Kk7 c5693Kk7L = L("![");
        a(C6652Ok0.a(c5693Kk7L, i2 + 1, this.h, this.g));
        return c5693Kk7L;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.nasim.TA4 q() {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11516d83.q():ir.nasim.TA4");
    }

    private TA4 r(QH1 qh1, char c) {
        a aVarJ = J(qh1, c);
        if (aVarJ == null) {
            return null;
        }
        int i2 = aVarJ.a;
        int i3 = this.f;
        int i4 = i3 + i2;
        this.f = i4;
        C5693Kk7 c5693Kk7M = M(this.e, i3, i4);
        PH1 ph1 = new PH1(c5693Kk7M, c, aVarJ.c, aVarJ.b, this.g);
        this.g = ph1;
        ph1.g = i2;
        ph1.h = i2;
        PH1 ph12 = ph1.e;
        if (ph12 != null) {
            ph12.f = ph1;
        }
        return c5693Kk7M;
    }

    private TA4 s() {
        String strG = g(l);
        if (strG != null) {
            return L(AbstractC13630gZ2.a(strG));
        }
        return null;
    }

    private TA4 t() {
        String strG = g(j);
        if (strG == null) {
            return null;
        }
        C14832iZ2 c14832iZ2 = new C14832iZ2();
        c14832iZ2.m(strG);
        return c14832iZ2;
    }

    private TA4 u(TA4 ta4) {
        TA4 ta4Y;
        char cB = B();
        if (cB == 0) {
            return null;
        }
        if (cB == '\n') {
            ta4Y = y(ta4);
        } else if (cB == '!') {
            ta4Y = p();
        } else if (cB == '&') {
            ta4Y = s();
        } else if (cB == '<') {
            ta4Y = m();
            if (ta4Y == null) {
                ta4Y = t();
            }
        } else if (cB != '`') {
            switch (cB) {
                case '[':
                    ta4Y = z();
                    break;
                case '\\':
                    ta4Y = n();
                    break;
                case ']':
                    ta4Y = q();
                    break;
                default:
                    if (!this.b.get(cB)) {
                        ta4Y = A();
                        break;
                    } else {
                        ta4Y = r((QH1) this.c.get(Character.valueOf(cB)), cB);
                        break;
                    }
            }
        } else {
            ta4Y = o();
        }
        if (ta4Y != null) {
            return ta4Y;
        }
        this.f++;
        return L(String.valueOf(cB));
    }

    private String v() {
        int iA = AbstractC24767zA3.a(this.e, this.f);
        if (iA == -1) {
            return null;
        }
        String strSubstring = B() == '<' ? this.e.substring(this.f + 1, iA - 1) : this.e.substring(this.f, iA);
        this.f = iA;
        return AbstractC16612la2.e(strSubstring);
    }

    private String x() {
        int iD = AbstractC24767zA3.d(this.e, this.f);
        if (iD == -1) {
            return null;
        }
        String strSubstring = this.e.substring(this.f + 1, iD - 1);
        this.f = iD;
        return AbstractC16612la2.e(strSubstring);
    }

    private TA4 y(TA4 ta4) {
        this.f++;
        if (ta4 instanceof C5693Kk7) {
            C5693Kk7 c5693Kk7 = (C5693Kk7) ta4;
            if (c5693Kk7.m().endsWith(Separators.SP)) {
                String strM = c5693Kk7.m();
                Matcher matcher = t.matcher(strM);
                int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (iEnd > 0) {
                    c5693Kk7.n(strM.substring(0, strM.length() - iEnd));
                }
                return iEnd >= 2 ? new C17149mU2() : new C19991rH6();
            }
        }
        return new C19991rH6();
    }

    private TA4 z() {
        int i2 = this.f;
        this.f = i2 + 1;
        C5693Kk7 c5693Kk7L = L("[");
        a(C6652Ok0.b(c5693Kk7L, i2, this.h, this.g));
        return c5693Kk7L;
    }

    void I(String str) {
        this.e = str;
        this.f = 0;
        this.g = null;
        this.h = null;
    }

    @Override // ir.nasim.Z73
    public void i(String str, TA4 ta4) {
        I(str.trim());
        TA4 ta4U = null;
        while (true) {
            ta4U = u(ta4U);
            if (ta4U == null) {
                C(null);
                h(ta4);
                return;
            }
            ta4.b(ta4U);
        }
    }

    int w() {
        if (this.f < this.e.length() && this.e.charAt(this.f) == '[') {
            int i2 = this.f + 1;
            int iC = AbstractC24767zA3.c(this.e, i2);
            int i3 = iC - i2;
            if (iC != -1 && i3 <= 999 && iC < this.e.length() && this.e.charAt(iC) == ']') {
                this.f = iC + 1;
                return i3 + 2;
            }
        }
        return 0;
    }
}
