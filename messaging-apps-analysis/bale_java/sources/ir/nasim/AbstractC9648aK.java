package ir.nasim;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.aK, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC9648aK extends ZJ {

    /* renamed from: ir.nasim.aK$a */
    public static final class a extends AbstractC11442d1 implements RandomAccess {
        final /* synthetic */ int[] a;

        a(int[] iArr) {
            this.a = iArr;
        }

        public int C(int i) {
            return AbstractC10242bK.q0(this.a, i);
        }

        public int E(int i) {
            return AbstractC10242bK.F0(this.a, i);
        }

        @Override // ir.nasim.G0, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        public boolean f(int i) {
            return AbstractC10242bK.S(this.a, i);
        }

        @Override // ir.nasim.G0
        public int getSize() {
            return this.a.length;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return C(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // ir.nasim.G0, java.util.Collection
        public boolean isEmpty() {
            return this.a.length == 0;
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer get(int i) {
            return Integer.valueOf(this.a[i]);
        }

        @Override // ir.nasim.AbstractC11442d1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return E(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static float[] A(float[] fArr, float[] fArr2) {
        AbstractC13042fc3.i(fArr, "<this>");
        AbstractC13042fc3.i(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
        AbstractC13042fc3.f(fArrCopyOf);
        return fArrCopyOf;
    }

    public static int[] B(int[] iArr, int i) {
        AbstractC13042fc3.i(iArr, "<this>");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i;
        AbstractC13042fc3.f(iArrCopyOf);
        return iArrCopyOf;
    }

    public static int[] C(int[] iArr, int[] iArr2) {
        AbstractC13042fc3.i(iArr, "<this>");
        AbstractC13042fc3.i(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
        AbstractC13042fc3.f(iArrCopyOf);
        return iArrCopyOf;
    }

    public static long[] D(long[] jArr, long[] jArr2) {
        AbstractC13042fc3.i(jArr, "<this>");
        AbstractC13042fc3.i(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
        AbstractC13042fc3.f(jArrCopyOf);
        return jArrCopyOf;
    }

    public static Object[] E(Object[] objArr, Object obj) {
        AbstractC13042fc3.i(objArr, "<this>");
        int length = objArr.length;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, length + 1);
        objArrCopyOf[length] = obj;
        AbstractC13042fc3.f(objArrCopyOf);
        return objArrCopyOf;
    }

    public static Object[] F(Object[] objArr, Object[] objArr2) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(objArr2, "elements");
        int length = objArr.length;
        int length2 = objArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, length + length2);
        System.arraycopy(objArr2, 0, objArrCopyOf, length, length2);
        AbstractC13042fc3.f(objArrCopyOf);
        return objArrCopyOf;
    }

    public static boolean[] G(boolean[] zArr, boolean[] zArr2) {
        AbstractC13042fc3.i(zArr, "<this>");
        AbstractC13042fc3.i(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
        AbstractC13042fc3.f(zArrCopyOf);
        return zArrCopyOf;
    }

    public static void H(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static void I(int[] iArr, int i, int i2) {
        AbstractC13042fc3.i(iArr, "<this>");
        Arrays.sort(iArr, i, i2);
    }

    public static final void J(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static void K(Object[] objArr, Comparator comparator) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static void L(Object[] objArr, Comparator comparator, int i, int i2) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(comparator, "comparator");
        Arrays.sort(objArr, i, i2, comparator);
    }

    public static SortedSet M(Comparable[] comparableArr) {
        AbstractC13042fc3.i(comparableArr, "<this>");
        return (SortedSet) AbstractC10242bK.W0(comparableArr, new TreeSet());
    }

    public static Long[] N(long[] jArr) {
        AbstractC13042fc3.i(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static List c(int[] iArr) {
        AbstractC13042fc3.i(iArr, "<this>");
        return new a(iArr);
    }

    public static List d(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "<this>");
        List listA = AbstractC10858cK.a(objArr);
        AbstractC13042fc3.h(listA, "asList(...)");
        return listA;
    }

    public static final int e(float[] fArr, float f, int i, int i2) {
        AbstractC13042fc3.i(fArr, "<this>");
        return Arrays.binarySearch(fArr, i, i2, f);
    }

    public static /* synthetic */ int f(float[] fArr, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return e(fArr, f, i, i2);
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(bArr, "<this>");
        AbstractC13042fc3.i(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static char[] h(char[] cArr, char[] cArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(cArr, "<this>");
        AbstractC13042fc3.i(cArr2, "destination");
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    public static float[] i(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(fArr, "<this>");
        AbstractC13042fc3.i(fArr2, "destination");
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    public static int[] j(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(iArr, "<this>");
        AbstractC13042fc3.i(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static long[] k(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(jArr, "<this>");
        AbstractC13042fc3.i(jArr2, "destination");
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static Object[] l(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        AbstractC13042fc3.i(objArr, "<this>");
        AbstractC13042fc3.i(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static /* synthetic */ byte[] m(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return g(bArr, bArr2, i, i2, i3);
    }

    public static /* synthetic */ float[] n(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return i(fArr, fArr2, i, i2, i3);
    }

    public static /* synthetic */ int[] o(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return j(iArr, iArr2, i, i2, i3);
    }

    public static /* synthetic */ long[] p(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return k(jArr, jArr2, i, i2, i3);
    }

    public static /* synthetic */ Object[] q(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return l(objArr, objArr2, i, i2, i3);
    }

    public static byte[] r(byte[] bArr, int i, int i2) {
        AbstractC13042fc3.i(bArr, "<this>");
        YJ.b(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        AbstractC13042fc3.h(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] s(Object[] objArr, int i, int i2) {
        AbstractC13042fc3.i(objArr, "<this>");
        YJ.b(i2, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
        AbstractC13042fc3.h(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static final void t(int[] iArr, int i, int i2, int i3) {
        AbstractC13042fc3.i(iArr, "<this>");
        Arrays.fill(iArr, i2, i3, i);
    }

    public static void u(long[] jArr, long j, int i, int i2) {
        AbstractC13042fc3.i(jArr, "<this>");
        Arrays.fill(jArr, i, i2, j);
    }

    public static void v(Object[] objArr, Object obj, int i, int i2) {
        AbstractC13042fc3.i(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static /* synthetic */ void w(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        t(iArr, i, i2, i3);
    }

    public static /* synthetic */ void x(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        u(jArr, j, i, i2);
    }

    public static /* synthetic */ void y(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        v(objArr, obj, i, i2);
    }

    public static byte[] z(byte[] bArr, byte[] bArr2) {
        AbstractC13042fc3.i(bArr, "<this>");
        AbstractC13042fc3.i(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        AbstractC13042fc3.f(bArrCopyOf);
        return bArrCopyOf;
    }
}
