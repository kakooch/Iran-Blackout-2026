package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.bK, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10242bK extends AbstractC9648aK {

    /* renamed from: ir.nasim.bK$a */
    public static final class a implements Iterable, InterfaceC17915nm3 {
        final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return DJ.a(this.a);
        }
    }

    /* renamed from: ir.nasim.bK$b */
    public static final class b implements InterfaceC23384wp6 {
        final /* synthetic */ Object[] a;

        public b(Object[] objArr) {
            this.a = objArr;
        }

        @Override // ir.nasim.InterfaceC23384wp6
        public Iterator iterator() {
            return DJ.a(this.a);
        }
    }

    /* renamed from: ir.nasim.bK$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Object[] e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object[] objArr) {
            super(0);
            this.e = objArr;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke() {
            return DJ.a(this.e);
        }
    }

    public static String A0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        String string = ((StringBuilder) w0(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String B0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return y0(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static /* synthetic */ String C0(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return z0(cArr, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static /* synthetic */ String D0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return A0(objArr, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static Object E0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[l0(objArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int F0(int[] iArr, int i) {
        AbstractC13042fc3.i(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (i == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static int G0(Object[] objArr, Object obj) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i = length - 1;
                    if (objArr[length] == null) {
                        return length;
                    }
                    if (i < 0) {
                        break;
                    }
                    length = i;
                }
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i2 = length2 - 1;
                    if (AbstractC13042fc3.d(obj, objArr[length2])) {
                        return length2;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length2 = i2;
                }
            }
        }
        return -1;
    }

    public static Object H0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[objArr.length - 1];
    }

    public static List I0(Object[] objArr, UA2 ua2) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(ua2, "transform");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(ua2.invoke(obj));
        }
        return arrayList;
    }

    public static Integer J0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int iJ0 = j0(iArr);
        int i2 = 1;
        if (1 <= iJ0) {
            while (true) {
                int i3 = iArr[i2];
                if (i < i3) {
                    i = i3;
                }
                if (i2 == iJ0) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i);
    }

    public static Integer K0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i = iArr[0];
        int iJ0 = j0(iArr);
        int i2 = 1;
        if (1 <= iJ0) {
            while (true) {
                int i3 = iArr[i2];
                if (i > i3) {
                    i = i3;
                }
                if (i2 == iJ0) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i);
    }

    public static List L0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length == 0) {
            return AbstractC10360bX0.m();
        }
        List listO1 = o1(objArr);
        AbstractC14812iX0.b0(listO1);
        return listO1;
    }

    public static char M0(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object N0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Iterable O(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return objArr.length == 0 ? AbstractC10360bX0.m() : new a(objArr);
    }

    public static Object O0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static InterfaceC23384wp6 P(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return objArr.length == 0 ? AbstractC9962aq6.e() : new b(objArr);
    }

    public static List P0(Object[] objArr, C24411ya3 c24411ya3) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(c24411ya3, "indices");
        return c24411ya3.isEmpty() ? AbstractC10360bX0.m() : AbstractC9648aK.d(AbstractC9648aK.s(objArr, c24411ya3.f().intValue(), c24411ya3.j().intValue() + 1));
    }

    public static boolean Q(byte[] bArr, byte b2) {
        AbstractC13042fc3.i(bArr, "<this>");
        return o0(bArr, b2) >= 0;
    }

    public static final Object[] Q0(Object[] objArr, Comparator comparator) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        if (objArr.length == 0) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        AbstractC13042fc3.h(objArrCopyOf, "copyOf(...)");
        AbstractC9648aK.K(objArrCopyOf, comparator);
        return objArrCopyOf;
    }

    public static boolean R(char[] cArr, char c2) {
        AbstractC13042fc3.i(cArr, "<this>");
        return p0(cArr, c2) >= 0;
    }

    public static List R0(Object[] objArr, Comparator comparator) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        return AbstractC9648aK.d(Q0(objArr, comparator));
    }

    public static boolean S(int[] iArr, int i) {
        AbstractC13042fc3.i(iArr, "<this>");
        return q0(iArr, i) >= 0;
    }

    public static float S0(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        float f = 0.0f;
        for (float f2 : fArr) {
            f += f2;
        }
        return f;
    }

    public static boolean T(long[] jArr, long j) {
        AbstractC13042fc3.i(jArr, "<this>");
        return r0(jArr, j) >= 0;
    }

    public static int T0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static boolean U(Object[] objArr, Object obj) {
        AbstractC13042fc3.i(objArr, "<this>");
        return s0(objArr, obj) >= 0;
    }

    public static final List U0(Object[] objArr, int i) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return AbstractC10360bX0.m();
        }
        int length = objArr.length;
        if (i >= length) {
            return f1(objArr);
        }
        if (i == 1) {
            return AbstractC9766aX0.e(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = length - i; i2 < length; i2++) {
            arrayList.add(objArr[i2]);
        }
        return arrayList;
    }

    public static boolean V(short[] sArr, short s) {
        AbstractC13042fc3.i(sArr, "<this>");
        return t0(sArr, s) >= 0;
    }

    public static final Collection V0(int[] iArr, Collection collection) {
        AbstractC13042fc3.i(iArr, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        for (int i : iArr) {
            collection.add(Integer.valueOf(i));
        }
        return collection;
    }

    public static List W(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return AbstractC15401jX0.m1(r1(iArr));
    }

    public static final Collection W0(Object[] objArr, Collection collection) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        for (Object obj : objArr) {
            collection.add(obj);
        }
        return collection;
    }

    public static List X(Object[] objArr, int i) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (i >= 0) {
            return U0(objArr, AbstractC23053wG5.e(objArr.length - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static HashSet X0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return (HashSet) V0(iArr, new HashSet(AbstractC19460qO3.f(iArr.length)));
    }

    public static List Y(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return (List) Z(objArr, new ArrayList());
    }

    public static HashSet Y0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return (HashSet) W0(objArr, new HashSet(AbstractC19460qO3.f(objArr.length)));
    }

    public static final Collection Z(Object[] objArr, Collection collection) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static List Z0(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        int length = bArr.length;
        return length != 0 ? length != 1 ? i1(bArr) : AbstractC9766aX0.e(Byte.valueOf(bArr[0])) : AbstractC10360bX0.m();
    }

    public static int a0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static List a1(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        int length = cArr.length;
        return length != 0 ? length != 1 ? j1(cArr) : AbstractC9766aX0.e(Character.valueOf(cArr[0])) : AbstractC10360bX0.m();
    }

    public static Object b0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static List b1(double[] dArr) {
        AbstractC13042fc3.i(dArr, "<this>");
        int length = dArr.length;
        return length != 0 ? length != 1 ? k1(dArr) : AbstractC9766aX0.e(Double.valueOf(dArr[0])) : AbstractC10360bX0.m();
    }

    public static Float c0(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static List c1(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        int length = fArr.length;
        return length != 0 ? length != 1 ? l1(fArr) : AbstractC9766aX0.e(Float.valueOf(fArr[0])) : AbstractC10360bX0.m();
    }

    public static Integer d0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static List d1(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        int length = iArr.length;
        return length != 0 ? length != 1 ? m1(iArr) : AbstractC9766aX0.e(Integer.valueOf(iArr[0])) : AbstractC10360bX0.m();
    }

    public static Object e0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static List e1(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        int length = jArr.length;
        return length != 0 ? length != 1 ? n1(jArr) : AbstractC9766aX0.e(Long.valueOf(jArr[0])) : AbstractC10360bX0.m();
    }

    public static C24411ya3 f0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return new C24411ya3(0, j0(iArr));
    }

    public static List f1(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? o1(objArr) : AbstractC9766aX0.e(objArr[0]) : AbstractC10360bX0.m();
    }

    public static C24411ya3 g0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return new C24411ya3(0, l0(objArr));
    }

    public static List g1(short[] sArr) {
        AbstractC13042fc3.i(sArr, "<this>");
        int length = sArr.length;
        return length != 0 ? length != 1 ? p1(sArr) : AbstractC9766aX0.e(Short.valueOf(sArr[0])) : AbstractC10360bX0.m();
    }

    public static int h0(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        return bArr.length - 1;
    }

    public static List h1(boolean[] zArr) {
        AbstractC13042fc3.i(zArr, "<this>");
        int length = zArr.length;
        return length != 0 ? length != 1 ? q1(zArr) : AbstractC9766aX0.e(Boolean.valueOf(zArr[0])) : AbstractC10360bX0.m();
    }

    public static int i0(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        return fArr.length - 1;
    }

    public static final List i1(byte[] bArr) {
        AbstractC13042fc3.i(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static int j0(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return iArr.length - 1;
    }

    public static final List j1(char[] cArr) {
        AbstractC13042fc3.i(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static int k0(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        return jArr.length - 1;
    }

    public static final List k1(double[] dArr) {
        AbstractC13042fc3.i(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d : dArr) {
            arrayList.add(Double.valueOf(d));
        }
        return arrayList;
    }

    public static int l0(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return objArr.length - 1;
    }

    public static final List l1(float[] fArr) {
        AbstractC13042fc3.i(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    public static Integer m0(int[] iArr, int i) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (i < 0 || i >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static final List m1(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static Object n0(Object[] objArr, int i) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static final List n1(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static final int o0(byte[] bArr, byte b2) {
        AbstractC13042fc3.i(bArr, "<this>");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b2 == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static List o1(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return new ArrayList(AbstractC10360bX0.h(objArr));
    }

    public static final int p0(char[] cArr, char c2) {
        AbstractC13042fc3.i(cArr, "<this>");
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            if (c2 == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final List p1(short[] sArr) {
        AbstractC13042fc3.i(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    public static final int q0(int[] iArr, int i) {
        AbstractC13042fc3.i(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final List q1(boolean[] zArr) {
        AbstractC13042fc3.i(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final int r0(long[] jArr, long j) {
        AbstractC13042fc3.i(jArr, "<this>");
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (j == jArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final Set r1(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return (Set) V0(iArr, new LinkedHashSet(AbstractC19460qO3.f(iArr.length)));
    }

    public static int s0(Object[] objArr, Object obj) {
        AbstractC13042fc3.i(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (AbstractC13042fc3.d(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static Set s1(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? (Set) W0(objArr, new LinkedHashSet(AbstractC19460qO3.f(objArr.length))) : AbstractC4363Eu6.c(objArr[0]) : AbstractC4597Fu6.d();
    }

    public static final int t0(short[] sArr, short s) {
        AbstractC13042fc3.i(sArr, "<this>");
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            if (s == sArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static Iterable t1(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        return new C15157j63(new c(objArr));
    }

    public static final Appendable u0(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(bArr, "<this>");
        AbstractC13042fc3.i(appendable, "buffer");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (ua2 != null) {
                appendable.append((CharSequence) ua2.invoke(Byte.valueOf(b2)));
            } else {
                appendable.append(String.valueOf((int) b2));
            }
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static List u1(Object[] objArr, Object[] objArr2) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(objArr2, "other");
        int iMin = Math.min(objArr.length, objArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(AbstractC4616Fw7.a(objArr[i], objArr2[i]));
        }
        return arrayList;
    }

    public static final Appendable v0(char[] cArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(cArr, "<this>");
        AbstractC13042fc3.i(appendable, "buffer");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (char c2 : cArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (ua2 != null) {
                appendable.append((CharSequence) ua2.invoke(Character.valueOf(c2)));
            } else {
                appendable.append(c2);
            }
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final Appendable w0(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(appendable, "buffer");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            AbstractC15425jZ6.b(appendable, obj, ua2);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String y0(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(bArr, "<this>");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        String string = ((StringBuilder) u0(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static final String z0(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(cArr, "<this>");
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        String string = ((StringBuilder) v0(cArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
