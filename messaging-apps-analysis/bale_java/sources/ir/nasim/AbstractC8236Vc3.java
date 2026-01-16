package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.xbill.DNS.TTL;

/* renamed from: ir.nasim.Vc3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC8236Vc3 extends AbstractC8470Wc3 {

    /* renamed from: ir.nasim.Vc3$a */
    private static class a extends AbstractList implements RandomAccess, Serializable {
        final int[] a;
        final int b;
        final int c;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Integer) && AbstractC8236Vc3.i(this.a, ((Integer) obj).intValue(), this.b, this.c) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.a[this.b + i] != aVar.a[aVar.b + i]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Integer get(int i) {
            AbstractC4029Dj5.h(i, size());
            return Integer.valueOf(this.a[this.b + i]);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iG = 1;
            for (int i = this.b; i < this.c; i++) {
                iG = (iG * 31) + AbstractC8236Vc3.g(this.a[i]);
            }
            return iG;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int i;
            if (!(obj instanceof Integer) || (i = AbstractC8236Vc3.i(this.a, ((Integer) obj).intValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return i - this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Integer set(int i, Integer num) {
            AbstractC4029Dj5.h(i, size());
            int[] iArr = this.a;
            int i2 = this.b;
            int i3 = iArr[i2 + i];
            iArr[i2 + i] = ((Integer) AbstractC4029Dj5.j(num)).intValue();
            return Integer.valueOf(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iJ;
            if (!(obj instanceof Integer) || (iJ = AbstractC8236Vc3.j(this.a, ((Integer) obj).intValue(), this.b, this.c)) < 0) {
                return -1;
            }
            return iJ - this.b;
        }

        int[] r() {
            return Arrays.copyOfRange(this.a, this.b, this.c);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.c - this.b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            AbstractC4029Dj5.n(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            int[] iArr = this.a;
            int i3 = this.b;
            return new a(iArr, i + i3, i3 + i2);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.a[this.b]);
            int i = this.b;
            while (true) {
                i++;
                if (i >= this.c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.a[i]);
            }
        }

        a(int[] iArr, int i, int i2) {
            this.a = iArr;
            this.b = i;
            this.c = i2;
        }
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j) {
        int i = (int) j;
        AbstractC4029Dj5.g(((long) i) == j, "Out of range: %s", j);
        return i;
    }

    public static int e(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int f(int i, int i2, int i3) {
        AbstractC4029Dj5.f(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }

    public static int h(int[] iArr, int i) {
        return i(iArr, i, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int[] iArr, int i, int i2, int i3) {
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int[] iArr, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (iArr[i4] == i) {
                return i4;
            }
        }
        return -1;
    }

    public static int k(long j) {
        if (j > TTL.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return j < -2147483648L ? RecyclerView.UNDEFINED_DURATION : (int) j;
    }

    public static int[] l(Collection collection) {
        if (collection instanceof a) {
            return ((a) collection).r();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) AbstractC4029Dj5.j(array[i])).intValue();
        }
        return iArr;
    }

    public static int g(int i) {
        return i;
    }
}
