package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.sZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20762sZ6 extends AbstractC20153rZ6 {

    /* renamed from: ir.nasim.sZ6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ char[] e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z) {
            super(2);
            this.e = cArr;
            this.f = z;
        }

        public final XV4 a(CharSequence charSequence, int i) {
            AbstractC13042fc3.i(charSequence, "$this$$receiver");
            int iM0 = AbstractC20762sZ6.m0(charSequence, this.e, i, this.f);
            if (iM0 < 0) {
                return null;
            }
            return AbstractC4616Fw7.a(Integer.valueOf(iM0), 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.sZ6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ List e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, boolean z) {
            super(2);
            this.e = list;
            this.f = z;
        }

        public final XV4 a(CharSequence charSequence, int i) {
            AbstractC13042fc3.i(charSequence, "$this$$receiver");
            XV4 xv4D0 = AbstractC20762sZ6.d0(charSequence, this.e, i, this.f, false);
            if (xv4D0 != null) {
                return AbstractC4616Fw7.a(xv4D0.e(), Integer.valueOf(((String) xv4D0.f()).length()));
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.sZ6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ CharSequence e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.e = charSequence;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(C24411ya3 c24411ya3) {
            AbstractC13042fc3.i(c24411ya3, "it");
            return AbstractC20762sZ6.U0(this.e, c24411ya3);
        }
    }

    static /* synthetic */ InterfaceC23384wp6 A0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return y0(charSequence, strArr, i, z, i2);
    }

    public static final boolean B0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!AbstractC11632dL0.h(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String C0(String str, CharSequence charSequence) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(charSequence, "prefix");
        if (!T0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence D0(CharSequence charSequence, CharSequence charSequence2) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "suffix");
        return c0(charSequence, charSequence2, false, 2, null) ? charSequence.subSequence(0, charSequence.length() - charSequence2.length()) : charSequence.subSequence(0, charSequence.length());
    }

    public static String E0(String str, CharSequence charSequence) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(charSequence, "suffix");
        if (!c0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String F0(String str, CharSequence charSequence) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(charSequence, "delimiter");
        return G0(str, charSequence, charSequence);
    }

    public static String G0(String str, CharSequence charSequence, CharSequence charSequence2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(charSequence, "prefix");
        AbstractC13042fc3.i(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !T0(str, charSequence, false, 2, null) || !c0(str, charSequence2, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence H0(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            AbstractC13042fc3.h(sb, "append(...)");
            sb.append(charSequence2);
            sb.append(charSequence, i2, charSequence.length());
            AbstractC13042fc3.h(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final void I0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List J0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(cArr, "delimiters");
        if (cArr.length == 1) {
            return L0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableL = AbstractC11342cq6.l(z0(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterableL, 10));
        Iterator it = iterableL.iterator();
        while (it.hasNext()) {
            arrayList.add(U0(charSequence, (C24411ya3) it.next()));
        }
        return arrayList;
    }

    public static final List K0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return L0(charSequence, str, z, i);
            }
        }
        Iterable iterableL = AbstractC11342cq6.l(A0(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterableL, 10));
        Iterator it = iterableL.iterator();
        while (it.hasNext()) {
            arrayList.add(U0(charSequence, (C24411ya3) it.next()));
        }
        return arrayList;
    }

    private static final List L0(CharSequence charSequence, String str, boolean z, int i) {
        I0(i);
        int length = 0;
        int iH0 = h0(charSequence, str, 0, z);
        if (iH0 == -1 || i == 1) {
            return AbstractC9766aX0.e(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? AbstractC23053wG5.i(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iH0).toString());
            length = str.length() + iH0;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iH0 = h0(charSequence, str, length, z);
        } while (iH0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List M0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return J0(charSequence, cArr, z, i);
    }

    public static /* synthetic */ List N0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return K0(charSequence, strArr, z, i);
    }

    public static final InterfaceC23384wp6 O0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(strArr, "delimiters");
        return AbstractC11342cq6.C(A0(charSequence, strArr, 0, z, i, 2, null), new c(charSequence));
    }

    public static /* synthetic */ InterfaceC23384wp6 P0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return O0(charSequence, strArr, z, i);
    }

    public static final boolean Q0(CharSequence charSequence, char c2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC11632dL0.h(charSequence.charAt(0), c2, z);
    }

    public static final boolean R0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC20153rZ6.S((String) charSequence, (String) charSequence2, false, 2, null) : B0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean S0(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Q0(charSequence, c2, z);
    }

    public static /* synthetic */ boolean T0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return R0(charSequence, charSequence2, z);
    }

    public static final boolean U(CharSequence charSequence, char c2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return k0(charSequence, c2, 0, z, 2, null) >= 0;
    }

    public static final String U0(CharSequence charSequence, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(c24411ya3, "range");
        return charSequence.subSequence(c24411ya3.f().intValue(), c24411ya3.j().intValue() + 1).toString();
    }

    public static boolean V(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (l0(charSequence, (String) charSequence2, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (j0(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static String V0(String str, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(c24411ya3, "range");
        String strSubstring = str.substring(c24411ya3.f().intValue(), c24411ya3.j().intValue() + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean W(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return U(charSequence, c2, z);
    }

    public static String W0(String str, char c2, String str2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "missingDelimiterValue");
        int iK0 = k0(str, c2, 0, false, 6, null);
        if (iK0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iK0 + 1, str.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean X(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return V(charSequence, charSequence2, z);
    }

    public static String X0(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "delimiter");
        AbstractC13042fc3.i(str3, "missingDelimiterValue");
        int iL0 = l0(str, str2, 0, false, 6, null);
        if (iL0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(iL0 + str2.length(), str.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean Y(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return AbstractC13042fc3.d(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ String Y0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return W0(str, c2, str2);
    }

    public static final boolean Z(CharSequence charSequence, char c2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC11632dL0.h(charSequence.charAt(f0(charSequence)), c2, z);
    }

    public static /* synthetic */ String Z0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return X0(str, str2, str3);
    }

    public static boolean a0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC20153rZ6.C((String) charSequence, (String) charSequence2, false, 2, null) : B0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static String a1(String str, char c2, String str2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "missingDelimiterValue");
        int iQ0 = q0(str, c2, 0, false, 6, null);
        if (iQ0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iQ0 + 1, str.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean b0(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return Z(charSequence, c2, z);
    }

    public static String b1(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "delimiter");
        AbstractC13042fc3.i(str3, "missingDelimiterValue");
        int iR0 = r0(str, str2, 0, false, 6, null);
        if (iR0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(iR0 + str2.length(), str.length());
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean c0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a0(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String c1(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return a1(str, c2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final XV4 d0(CharSequence charSequence, Collection collection, int i, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) AbstractC15401jX0.U0(collection);
            int iL0 = !z2 ? l0(charSequence, str, i, false, 4, null) : r0(charSequence, str, i, false, 4, null);
            if (iL0 < 0) {
                return null;
            }
            return AbstractC4616Fw7.a(Integer.valueOf(iL0), str);
        }
        C23231wa3 c24411ya3 = !z2 ? new C24411ya3(AbstractC23053wG5.e(i, 0), charSequence.length()) : AbstractC23053wG5.r(AbstractC23053wG5.i(i, f0(charSequence)), 0);
        if (charSequence instanceof String) {
            int iO = c24411ya3.o();
            int iT = c24411ya3.t();
            int iV = c24411ya3.v();
            if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (AbstractC20153rZ6.G(str2, 0, (String) charSequence, iO, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iO == iT) {
                            break;
                        }
                        iO += iV;
                    } else {
                        return AbstractC4616Fw7.a(Integer.valueOf(iO), str3);
                    }
                }
            }
        } else {
            int iO2 = c24411ya3.o();
            int iT2 = c24411ya3.t();
            int iV2 = c24411ya3.v();
            if ((iV2 > 0 && iO2 <= iT2) || (iV2 < 0 && iT2 <= iO2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (B0(str4, 0, charSequence, iO2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iO2 == iT2) {
                            break;
                        }
                        iO2 += iV2;
                    } else {
                        return AbstractC4616Fw7.a(Integer.valueOf(iO2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ String d1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return b1(str, str2, str3);
    }

    public static C24411ya3 e0(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return new C24411ya3(0, charSequence.length() - 1);
    }

    public static final String e1(String str, char c2, String str2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "missingDelimiterValue");
        int iK0 = k0(str, c2, 0, false, 6, null);
        if (iK0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iK0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int f0(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static String f1(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "delimiter");
        AbstractC13042fc3.i(str3, "missingDelimiterValue");
        int iL0 = l0(str, str2, 0, false, 6, null);
        if (iL0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iL0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int g0(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m0(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static /* synthetic */ String g1(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return e1(str, c2, str2);
    }

    public static int h0(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(str, "string");
        return (z || !(charSequence instanceof String)) ? j0(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ String h1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return f1(str, str2, str3);
    }

    private static final int i0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C23231wa3 c24411ya3 = !z2 ? new C24411ya3(AbstractC23053wG5.e(i, 0), AbstractC23053wG5.i(i2, charSequence.length())) : AbstractC23053wG5.r(AbstractC23053wG5.i(i, f0(charSequence)), AbstractC23053wG5.e(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iO = c24411ya3.o();
            int iT = c24411ya3.t();
            int iV = c24411ya3.v();
            if ((iV <= 0 || iO > iT) && (iV >= 0 || iT > iO)) {
                return -1;
            }
            while (!AbstractC20153rZ6.G((String) charSequence2, 0, (String) charSequence, iO, charSequence2.length(), z)) {
                if (iO == iT) {
                    return -1;
                }
                iO += iV;
            }
            return iO;
        }
        int iO2 = c24411ya3.o();
        int iT2 = c24411ya3.t();
        int iV2 = c24411ya3.v();
        if ((iV2 <= 0 || iO2 > iT2) && (iV2 >= 0 || iT2 > iO2)) {
            return -1;
        }
        while (!B0(charSequence2, 0, charSequence, iO2, charSequence2.length(), z)) {
            if (iO2 == iT2) {
                return -1;
            }
            iO2 += iV2;
        }
        return iO2;
    }

    public static String i1(String str, char c2, String str2) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "missingDelimiterValue");
        int iQ0 = q0(str, c2, 0, false, 6, null);
        if (iQ0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iQ0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    static /* synthetic */ int j0(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return i0(charSequence, charSequence2, i, i2, z, z2);
    }

    public static String j1(String str, String str2, String str3) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(str2, "delimiter");
        AbstractC13042fc3.i(str3, "missingDelimiterValue");
        int iR0 = r0(str, str2, 0, false, 6, null);
        if (iR0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iR0);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int k0(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return g0(charSequence, c2, i, z);
    }

    public static /* synthetic */ String k1(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return i1(str, c2, str2);
    }

    public static /* synthetic */ int l0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return h0(charSequence, str, i, z);
    }

    public static /* synthetic */ String l1(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return j1(str, str2, str3);
    }

    public static final int m0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC10242bK.M0(cArr), i);
        }
        int iE = AbstractC23053wG5.e(i, 0);
        int iF0 = f0(charSequence);
        if (iE > iF0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iE);
            for (char c2 : cArr) {
                if (AbstractC11632dL0.h(c2, cCharAt, z)) {
                    return iE;
                }
            }
            if (iE == iF0) {
                return -1;
            }
            iE++;
        }
    }

    public static Boolean m1(String str) {
        AbstractC13042fc3.i(str, "<this>");
        if (AbstractC13042fc3.d(str, "true")) {
            return Boolean.TRUE;
        }
        if (AbstractC13042fc3.d(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static boolean n0(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!AbstractC10868cL0.d(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static CharSequence n1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zD = AbstractC10868cL0.d(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zD) {
                    break;
                }
                length--;
            } else if (zD) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final int o0(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? s0(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static String o1(String str, char... cArr) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC13042fc3.i(cArr, "chars");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zR = AbstractC10242bK.R(cArr, str.charAt(!z ? i : length));
            if (z) {
                if (!zR) {
                    break;
                }
                length--;
            } else if (zR) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static final int p0(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(str, "string");
        return (z || !(charSequence instanceof String)) ? i0(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static CharSequence p1(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!AbstractC10868cL0.d(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static /* synthetic */ int q0(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = f0(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return o0(charSequence, c2, i, z);
    }

    public static /* synthetic */ int r0(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = f0(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return p0(charSequence, str, i, z);
    }

    public static final int s0(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC13042fc3.i(charSequence, "<this>");
        AbstractC13042fc3.i(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC10242bK.M0(cArr), i);
        }
        for (int i2 = AbstractC23053wG5.i(i, f0(charSequence)); -1 < i2; i2--) {
            char cCharAt = charSequence.charAt(i2);
            for (char c2 : cArr) {
                if (AbstractC11632dL0.h(c2, cCharAt, z)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public static final InterfaceC23384wp6 t0(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return P0(charSequence, new String[]{Separators.NEWLINE, Separators.RETURN, "\r"}, false, 0, 6, null);
    }

    public static List u0(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "<this>");
        return AbstractC11342cq6.K(t0(charSequence));
    }

    public static final CharSequence v0(CharSequence charSequence, int i, char c2) {
        AbstractC13042fc3.i(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c2);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String w0(String str, int i, char c2) {
        AbstractC13042fc3.i(str, "<this>");
        return v0(str, i, c2).toString();
    }

    private static final InterfaceC23384wp6 x0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        I0(i2);
        return new OH1(charSequence, i, i2, new a(cArr, z));
    }

    private static final InterfaceC23384wp6 y0(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        I0(i2);
        return new OH1(charSequence, i, i2, new b(AbstractC9648aK.d(strArr), z));
    }

    static /* synthetic */ InterfaceC23384wp6 z0(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return x0(charSequence, cArr, i, z, i2);
    }
}
