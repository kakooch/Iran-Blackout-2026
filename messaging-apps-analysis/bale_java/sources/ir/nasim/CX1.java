package ir.nasim;

/* loaded from: classes7.dex */
public class CX1 {
    private static volatile CX1[] b = new CX1[1];
    private int a = 0;

    public interface a {
    }

    public CX1(int i) {
    }

    public static CX1 e(int i) {
        CX1 cx1 = b[i];
        if (cx1 == null) {
            synchronized (CX1.class) {
                try {
                    cx1 = b[i];
                    if (cx1 == null) {
                        CX1[] cx1Arr = b;
                        CX1 cx12 = new CX1(i);
                        cx1Arr[i] = cx12;
                        cx1 = cx12;
                    }
                } finally {
                }
            }
        }
        return cx1;
    }

    public int b(L57 l57) {
        return 0;
    }

    public int c() {
        int i = this.a;
        this.a = i + 1;
        return i;
    }

    public int d() {
        return 0;
    }

    public int f() {
        return 0;
    }

    public boolean g(int i) {
        return false;
    }

    public void h(a aVar) {
    }

    public void a(String str, a aVar) {
    }
}
