package ir.nasim;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class O26 implements InterfaceC14514i27, InterfaceC13921h27 {
    public static final a i = new a(null);
    public static final TreeMap j = new TreeMap();
    private final int a;
    private volatile String b;
    public final long[] c;
    public final double[] d;
    public final String[] e;
    public final byte[][] f;
    private final int[] g;
    private int h;

    public static final class a {
        private a() {
        }

        public final O26 a(String str, int i) {
            AbstractC13042fc3.i(str, "query");
            TreeMap treeMap = O26.j;
            synchronized (treeMap) {
                Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
                if (entryCeilingEntry == null) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    O26 o26 = new O26(i, null);
                    o26.g(str, i);
                    return o26;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                O26 o262 = (O26) entryCeilingEntry.getValue();
                o262.g(str, i);
                AbstractC13042fc3.h(o262, "sqliteQuery");
                return o262;
            }
        }

        public final void b() {
            TreeMap treeMap = O26.j;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            AbstractC13042fc3.h(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i;
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ O26(int i2, ED1 ed1) {
        this(i2);
    }

    public static final O26 c(String str, int i2) {
        return i.a(str, i2);
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void U0(int i2, String str) {
        AbstractC13042fc3.i(str, "value");
        this.g[i2] = 4;
        this.e[i2] = str;
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void Y(int i2, double d) {
        this.g[i2] = 3;
        this.d[i2] = d;
    }

    @Override // ir.nasim.InterfaceC14514i27
    public String a() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // ir.nasim.InterfaceC14514i27
    public void b(InterfaceC13921h27 interfaceC13921h27) {
        AbstractC13042fc3.i(interfaceC13921h27, "statement");
        int iE = e();
        if (1 > iE) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.g[i2];
            if (i3 == 1) {
                interfaceC13921h27.y1(i2);
            } else if (i3 == 2) {
                interfaceC13921h27.k1(i2, this.c[i2]);
            } else if (i3 == 3) {
                interfaceC13921h27.Y(i2, this.d[i2]);
            } else if (i3 == 4) {
                String str = this.e[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                interfaceC13921h27.U0(i2, str);
            } else if (i3 == 5) {
                byte[] bArr = this.f[i2];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                interfaceC13921h27.n1(i2, bArr);
            }
            if (i2 == iE) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void d(O26 o26) {
        AbstractC13042fc3.i(o26, "other");
        int iE = o26.e() + 1;
        System.arraycopy(o26.g, 0, this.g, 0, iE);
        System.arraycopy(o26.c, 0, this.c, 0, iE);
        System.arraycopy(o26.e, 0, this.e, 0, iE);
        System.arraycopy(o26.f, 0, this.f, 0, iE);
        System.arraycopy(o26.d, 0, this.d, 0, iE);
    }

    public int e() {
        return this.h;
    }

    public final void g(String str, int i2) {
        AbstractC13042fc3.i(str, "query");
        this.b = str;
        this.h = i2;
    }

    public final void j() {
        TreeMap treeMap = j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.a), this);
            i.b();
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void k1(int i2, long j2) {
        this.g[i2] = 2;
        this.c[i2] = j2;
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void n1(int i2, byte[] bArr) {
        AbstractC13042fc3.i(bArr, "value");
        this.g[i2] = 5;
        this.f[i2] = bArr;
    }

    @Override // ir.nasim.InterfaceC13921h27
    public void y1(int i2) {
        this.g[i2] = 1;
    }

    private O26(int i2) {
        this.a = i2;
        int i3 = i2 + 1;
        this.g = new int[i3];
        this.c = new long[i3];
        this.d = new double[i3];
        this.e = new String[i3];
        this.f = new byte[i3][];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
