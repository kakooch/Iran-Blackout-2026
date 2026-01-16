package ir.nasim;

import android.os.Looper;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.jD4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15225jD4 {
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    private static volatile C15225jD4 H = null;
    private static int h = 0;
    public static final int i = 1;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    private final SparseArray a = new SparseArray();
    private final SparseArray b = new SparseArray();
    private final SparseArray c = new SparseArray();
    private final ArrayList d = new ArrayList(10);
    private int e = 0;
    private int[] f;
    private boolean g;

    /* renamed from: ir.nasim.jD4$a */
    private class a {
        private int a;
        private Object[] b;

        private a(int i, Object[] objArr) {
            this.a = i;
            this.b = objArr;
        }
    }

    /* renamed from: ir.nasim.jD4$b */
    public interface b {
        void didReceivedNotification(int i, Object... objArr);
    }

    static {
        int i2 = 1 + 1;
        j = i2;
        k = i2 + 1;
        l = i2 + 2;
        m = i2 + 3;
        n = i2 + 4;
        o = i2 + 5;
        p = i2 + 6;
        q = i2 + 7;
        r = i2 + 8;
        s = i2 + 9;
        t = i2 + 10;
        u = i2 + 11;
        v = i2 + 12;
        w = i2 + 13;
        x = i2 + 14;
        y = i2 + 15;
        z = i2 + 16;
        A = i2 + 17;
        B = i2 + 18;
        C = i2 + 19;
        D = i2 + 20;
        E = i2 + 21;
        F = i2 + 22;
        h = i2 + 24;
        G = i2 + 23;
    }

    public static C15225jD4 b() {
        C15225jD4 c15225jD4 = H;
        if (c15225jD4 == null) {
            synchronized (C15225jD4.class) {
                try {
                    c15225jD4 = H;
                    if (c15225jD4 == null) {
                        c15225jD4 = new C15225jD4();
                        H = c15225jD4;
                    }
                } finally {
                }
            }
        }
        return c15225jD4;
    }

    public void a(Object obj, int i2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (this.e != 0) {
            ArrayList arrayList = (ArrayList) this.c.get(i2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.c.put(i2, arrayList);
            }
            arrayList.add(obj);
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.a.get(i2);
        if (arrayList2 == null) {
            SparseArray sparseArray = this.a;
            ArrayList arrayList3 = new ArrayList();
            sparseArray.put(i2, arrayList3);
            arrayList2 = arrayList3;
        }
        if (arrayList2.contains(obj)) {
            return;
        }
        arrayList2.add(obj);
    }

    public void c(int i2, Object... objArr) {
        boolean z2 = false;
        if (this.f != null) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f;
                if (i3 >= iArr.length) {
                    break;
                }
                if (iArr[i3] == i2) {
                    z2 = true;
                    break;
                }
                i3++;
            }
        }
        d(i2, z2, objArr);
    }

    public void d(int i2, boolean z2, Object... objArr) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (!z2 && this.g) {
            this.d.add(new a(i2, objArr));
            return;
        }
        this.e++;
        ArrayList arrayList = (ArrayList) this.a.get(i2);
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((b) arrayList.get(i3)).didReceivedNotification(i2, objArr);
            }
        }
        int i4 = this.e - 1;
        this.e = i4;
        if (i4 == 0) {
            if (this.b.size() != 0) {
                for (int i5 = 0; i5 < this.b.size(); i5++) {
                    int iKeyAt = this.b.keyAt(i5);
                    ArrayList arrayList2 = (ArrayList) this.b.get(iKeyAt);
                    for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                        e(arrayList2.get(i6), iKeyAt);
                    }
                }
                this.b.clear();
            }
            if (this.c.size() != 0) {
                for (int i7 = 0; i7 < this.c.size(); i7++) {
                    int iKeyAt2 = this.c.keyAt(i7);
                    ArrayList arrayList3 = (ArrayList) this.c.get(iKeyAt2);
                    for (int i8 = 0; i8 < arrayList3.size(); i8++) {
                        a(arrayList3.get(i8), iKeyAt2);
                    }
                }
                this.c.clear();
            }
        }
    }

    public void e(Object obj, int i2) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("addObserver allowed only from MAIN thread");
        }
        if (this.e == 0) {
            ArrayList arrayList = (ArrayList) this.a.get(i2);
            if (arrayList != null) {
                arrayList.remove(obj);
                return;
            }
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.b.get(i2);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            this.b.put(i2, arrayList2);
        }
        arrayList2.add(obj);
    }

    public void f(int[] iArr) {
        this.f = iArr;
    }

    public void g(boolean z2) {
        this.g = z2;
        if (z2 || this.d.isEmpty()) {
            return;
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            d(aVar.a, true, aVar.b);
        }
        this.d.clear();
    }
}
