package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.rU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C20105rU3 implements Z73, InterfaceC20714sU3 {
    private static final Pattern k = Pattern.compile("\\w+");
    private static final Pattern l = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern m = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern n = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    static final Pattern o = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    static final Pattern p = Pattern.compile("\\s+");
    private final InterfaceC9542a83 a;
    private final boolean b;
    private final BitSet c;
    private final Map d;
    private final Map e;
    private TA4 f;
    private String g;
    private int h;
    private PH1 i;
    private C6652Ok0 j;

    /* renamed from: ir.nasim.rU3$a */
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

    /* renamed from: ir.nasim.rU3$b */
    public interface b {
        InterfaceC10752c83 a();

        b b(QH1 qh1);

        b c(AbstractC12750f83 abstractC12750f83);

        b d(Class cls);
    }

    /* renamed from: ir.nasim.rU3$c */
    static class c implements b {
        private final List a = new ArrayList(3);
        private final List b = new ArrayList(3);
        private boolean c;

        c() {
        }

        @Override // ir.nasim.C20105rU3.b
        public InterfaceC10752c83 a() {
            return new d(this.c, this.a, this.b);
        }

        @Override // ir.nasim.C20105rU3.b
        public b b(QH1 qh1) {
            this.b.add(qh1);
            return this;
        }

        @Override // ir.nasim.C20105rU3.b
        public b c(AbstractC12750f83 abstractC12750f83) {
            this.a.add(abstractC12750f83);
            return this;
        }

        @Override // ir.nasim.C20105rU3.b
        public b d(Class cls) {
            int size = this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (cls.equals(((QH1) this.b.get(i)).getClass())) {
                    this.b.remove(i);
                    break;
                }
                i++;
            }
            return this;
        }

        public b e() {
            this.c = true;
            this.a.addAll(Arrays.asList(new C23173wU(), new C10350bW(), new C10966cW(), new C13924h30(), new SV0(), new C20523s92(), new C15421jZ2(), new C15632ju4(), new SK4()));
            this.b.addAll(Arrays.asList(new C23673xK(), new C11549dB7()));
            return this;
        }
    }

    /* renamed from: ir.nasim.rU3$d */
    static class d implements InterfaceC10752c83 {
        private final boolean a;
        private final List b;
        private final List c;

        d(boolean z, List list, List list2) {
            this.a = z;
            this.b = list;
            this.c = list2;
        }

        @Override // ir.nasim.InterfaceC10752c83
        public Z73 a(InterfaceC9542a83 interfaceC9542a83) {
            List arrayList;
            List listB = interfaceC9542a83.b();
            int size = listB != null ? listB.size() : 0;
            if (size > 0) {
                arrayList = new ArrayList(size + this.c.size());
                arrayList.addAll(this.c);
                arrayList.addAll(listB);
            } else {
                arrayList = this.c;
            }
            return new C20105rU3(interfaceC9542a83, this.a, this.b, arrayList);
        }
    }

    public C20105rU3(InterfaceC9542a83 interfaceC9542a83, boolean z, List list, List list2) {
        this.a = interfaceC9542a83;
        this.b = z;
        Map mapU = u(list);
        this.d = mapU;
        Map mapT = t(list2);
        this.e = mapT;
        this.c = v(mapU.keySet(), mapT.keySet());
    }

    private void A(PH1 ph1) {
        PH1 ph12 = ph1.e;
        if (ph12 != null) {
            ph12.f = ph1.f;
        }
        PH1 ph13 = ph1.f;
        if (ph13 == null) {
            this.i = ph12;
        } else {
            ph13.e = ph12;
        }
    }

    private void B(PH1 ph1) {
        ph1.a.l();
        A(ph1);
    }

    private void C(PH1 ph1) {
        A(ph1);
    }

    private void D(PH1 ph1, PH1 ph12) {
        PH1 ph13 = ph12.e;
        while (ph13 != null && ph13 != ph1) {
            PH1 ph14 = ph13.e;
            C(ph13);
            ph13 = ph14;
        }
    }

    private void E(String str) {
        this.g = str;
        this.h = 0;
        this.i = null;
        this.j = null;
    }

    private a F(QH1 qh1, char c2) {
        int i = this.h;
        boolean z = false;
        int i2 = 0;
        while (peek() == c2) {
            i2++;
            this.h++;
        }
        if (i2 < qh1.c()) {
            this.h = i;
            return null;
        }
        String strValueOf = Separators.RETURN;
        String strSubstring = i == 0 ? Separators.RETURN : this.g.substring(i - 1, i);
        char cPeek = peek();
        if (cPeek != 0) {
            strValueOf = String.valueOf(cPeek);
        }
        Pattern pattern = k;
        boolean zMatches = pattern.matcher(strSubstring).matches();
        boolean zMatches2 = pattern.matcher(strValueOf).matches();
        Pattern pattern2 = l;
        boolean zMatches3 = pattern2.matcher(strSubstring).matches();
        Pattern pattern3 = n;
        boolean zMatches4 = pattern3.matcher(strSubstring).matches();
        boolean zMatches5 = pattern2.matcher(strValueOf).matches();
        boolean zMatches6 = pattern3.matcher(strValueOf).matches();
        boolean z2 = (!zMatches5 || zMatches4 || zMatches3) && !zMatches;
        boolean z3 = (!zMatches3 || zMatches6 || zMatches5) && !zMatches2;
        boolean z4 = z2 && c2 == qh1.d();
        if (z3 && c2 == qh1.d()) {
            z = true;
        }
        this.h = i;
        return new a(i2, z4, z);
    }

    private static void r(char c2, QH1 qh1, Map map) {
        if (((QH1) map.put(Character.valueOf(c2), qh1)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c2 + Separators.QUOTE);
    }

    private static void s(Iterable iterable, Map map) {
        HJ6 hj6;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            QH1 qh1 = (QH1) it.next();
            char cD = qh1.d();
            char cB = qh1.b();
            if (cD == cB) {
                QH1 qh12 = (QH1) map.get(Character.valueOf(cD));
                if (qh12 == null || qh12.d() != qh12.b()) {
                    r(cD, qh1, map);
                } else {
                    if (qh12 instanceof HJ6) {
                        hj6 = (HJ6) qh12;
                    } else {
                        HJ6 hj62 = new HJ6(cD);
                        hj62.f(qh12);
                        hj6 = hj62;
                    }
                    hj6.f(qh1);
                    map.put(Character.valueOf(cD), hj6);
                }
            } else {
                r(cD, qh1, map);
                r(cB, qh1, map);
            }
        }
    }

    private static Map t(List list) {
        HashMap map = new HashMap();
        s(list, map);
        return map;
    }

    private static Map u(List list) {
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC12750f83 abstractC12750f83 = (AbstractC12750f83) it.next();
            char cM = abstractC12750f83.m();
            List arrayList = (List) map.get(Character.valueOf(cM));
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(Character.valueOf(cM), arrayList);
            }
            arrayList.add(abstractC12750f83);
        }
        return map;
    }

    private static BitSet v(Set set, Set set2) {
        BitSet bitSet = new BitSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            bitSet.set(((Character) it2.next()).charValue());
        }
        return bitSet;
    }

    public static b w() {
        return new c().e();
    }

    private TA4 x(QH1 qh1, char c2) {
        a aVarF = F(qh1, c2);
        if (aVarF == null) {
            return null;
        }
        int i = aVarF.a;
        int i2 = this.h;
        int i3 = i2 + i;
        this.h = i3;
        C5693Kk7 c5693Kk7P = p(this.g, i2, i3);
        PH1 ph1 = new PH1(c5693Kk7P, c2, aVarF.c, aVarF.b, this.i);
        this.i = ph1;
        ph1.g = i;
        ph1.h = i;
        PH1 ph12 = ph1.e;
        if (ph12 != null) {
            ph12.f = ph1;
        }
        return c5693Kk7P;
    }

    private TA4 y() {
        char cPeek = peek();
        TA4 ta4X = null;
        if (cPeek == 0) {
            return null;
        }
        List list = (List) this.d.get(Character.valueOf(cPeek));
        if (list != null) {
            int i = this.h;
            Iterator it = list.iterator();
            while (it.hasNext() && (ta4X = ((AbstractC12750f83) it.next()).f(this)) == null) {
                this.h = i;
            }
        } else {
            QH1 qh1 = (QH1) this.e.get(Character.valueOf(cPeek));
            ta4X = qh1 != null ? x(qh1, cPeek) : z();
        }
        if (ta4X != null) {
            return ta4X;
        }
        this.h++;
        return j(String.valueOf(cPeek));
    }

    private TA4 z() {
        int i = this.h;
        int length = this.g.length();
        while (true) {
            int i2 = this.h;
            if (i2 == length || this.c.get(this.g.charAt(i2))) {
                break;
            }
            this.h++;
        }
        int i3 = this.h;
        if (i != i3) {
            return p(this.g, i, i3);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public C22401vA3 a(String str) {
        if (this.b) {
            return this.a.a(str);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public String b() {
        int iD = AbstractC24767zA3.d(this.g, this.h);
        if (iD == -1) {
            return null;
        }
        String strSubstring = this.g.substring(this.h + 1, iD - 1);
        this.h = iD;
        return AbstractC16612la2.e(strSubstring);
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public String c(Pattern pattern) {
        if (this.h >= this.g.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.g);
        matcher.region(this.h, this.g.length());
        if (!matcher.find()) {
            return null;
        }
        this.h = matcher.end();
        return matcher.group();
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public void d() {
        c(m);
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public String e() {
        int iA = AbstractC24767zA3.a(this.g.replace(Separators.SP, "-"), this.h);
        if (iA == -1) {
            return null;
        }
        String strSubstring = peek() == '<' ? this.g.substring(this.h + 1, iA - 1) : this.g.substring(this.h, iA);
        this.h = iA;
        return AbstractC16612la2.e(strSubstring);
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public void f(PH1 ph1) {
        boolean z;
        HashMap map = new HashMap();
        PH1 ph12 = this.i;
        while (ph12 != null) {
            PH1 ph13 = ph12.e;
            if (ph13 == ph1) {
                break;
            } else {
                ph12 = ph13;
            }
        }
        while (ph12 != null) {
            char c2 = ph12.b;
            QH1 qh1 = (QH1) this.e.get(Character.valueOf(c2));
            if (!ph12.d || qh1 == null) {
                ph12 = ph12.f;
            } else {
                char cD = qh1.d();
                PH1 ph14 = ph12.e;
                int iE = 0;
                boolean z2 = false;
                while (ph14 != null && ph14 != ph1 && ph14 != map.get(Character.valueOf(c2))) {
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
                    D(ph14, ph12);
                    AbstractC12159e83.c(c5693Kk7, c5693Kk72);
                    qh1.a(c5693Kk7, c5693Kk72, iE);
                    if (ph14.g == 0) {
                        B(ph14);
                    }
                    if (ph12.g == 0) {
                        PH1 ph15 = ph12.f;
                        B(ph12);
                        ph12 = ph15;
                    }
                } else {
                    if (!z) {
                        map.put(Character.valueOf(c2), ph12.e);
                        if (!ph12.c) {
                            C(ph12);
                        }
                    }
                    ph12 = ph12.f;
                }
            }
        }
        while (true) {
            PH1 ph16 = this.i;
            if (ph16 == null || ph16 == ph1) {
                return;
            } else {
                C(ph16);
            }
        }
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public TA4 g() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public String h() {
        return this.g;
    }

    @Override // ir.nasim.Z73
    public void i(String str, TA4 ta4) {
        E(str.trim());
        this.f = ta4;
        while (true) {
            TA4 ta4Y = y();
            if (ta4Y == null) {
                f(null);
                AbstractC12159e83.a(ta4);
                return;
            }
            ta4.b(ta4Y);
        }
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public C5693Kk7 j(String str) {
        return new C5693Kk7(str);
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public void k(C6652Ok0 c6652Ok0) {
        C6652Ok0 c6652Ok02 = this.j;
        if (c6652Ok02 != null) {
            c6652Ok02.g = true;
        }
        this.j = c6652Ok0;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public int l() {
        if (this.h < this.g.length() && this.g.charAt(this.h) == '[') {
            int i = this.h + 1;
            int iC = AbstractC24767zA3.c(this.g, i);
            int i2 = iC - i;
            if (iC != -1 && i2 <= 999 && iC < this.g.length() && this.g.charAt(iC) == ']') {
                this.h = iC + 1;
                return i2 + 2;
            }
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public PH1 m() {
        return this.i;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public int n() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public void o() {
        C6652Ok0 c6652Ok0 = this.j;
        if (c6652Ok0 != null) {
            this.j = c6652Ok0.d;
        }
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public C5693Kk7 p(String str, int i, int i2) {
        return new C5693Kk7(str.substring(i, i2));
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public char peek() {
        if (this.h < this.g.length()) {
            return this.g.charAt(this.h);
        }
        return (char) 0;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public C6652Ok0 q() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC20714sU3
    public void setIndex(int i) {
        this.h = i;
    }
}
