package ir.nasim;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ql0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19675ql0 {
    private C12658ez1 a;
    private C21212tI6 b = new C21212tI6();

    public C19675ql0(C12658ez1 c12658ez1) {
        if (c12658ez1 == null) {
            throw new IllegalArgumentException("Stream can not be null");
        }
        this.a = c12658ez1;
    }

    private void c(byte[] bArr) {
        this.a.k(bArr, 0, bArr.length);
    }

    private void d(int i, byte[] bArr) {
        p(i, 2);
        c(bArr);
    }

    private void h(long j) {
        this.a.i(j);
    }

    private void p(int i, int i2) {
        if ((i & 65535) <= 0) {
            throw new IllegalArgumentException("Field Number must greater than zero");
        }
        this.a.n(i2 | (r3 << 3));
    }

    private void r(int i, long j) {
        p(i, 1);
        h(j);
    }

    private void s(long j) {
        this.a.n(j);
    }

    private void t(int i, long j) {
        p(i, 0);
        s(j);
    }

    public void a(int i, boolean z) {
        t(i, z ? 1L : 0L);
    }

    public void b(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        if (bArr.length > 1048576) {
            throw new IllegalArgumentException("Unable to write more than 1 MB");
        }
        this.b.c(i, true);
        d(i, bArr);
    }

    public void e(int i, double d) {
        r(i, Double.doubleToLongBits(d));
    }

    public void f(int i, int i2) {
        t(i, i2);
    }

    public void g(int i, long j) {
        t(i, j);
    }

    public void i(int i, AbstractC17902nl0 abstractC17902nl0) {
        if (abstractC17902nl0 == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        this.b.c(i, true);
        p(i, 2);
        C12658ez1 c12658ez1 = new C12658ez1();
        abstractC17902nl0.serialize(new C19675ql0(c12658ez1));
        c(c12658ez1.c());
    }

    public void j(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Raw can not be null");
        }
        this.a.g(bArr, 0, bArr.length);
    }

    public void k(int i, List list) {
        if (list == null) {
            throw new IllegalArgumentException("Values can not be null");
        }
        if (list.size() > 1048576) {
            throw new IllegalArgumentException("Too many values");
        }
        this.b.c(i, true);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Integer) it.next()) == null) {
                throw new IllegalArgumentException("Value can not be null");
            }
            t(i, r0.intValue());
        }
    }

    public void l(int i, List list) {
        if (list == null) {
            throw new IllegalArgumentException("Values can not be null");
        }
        if (list.size() > 1048576) {
            throw new IllegalArgumentException("Too many values");
        }
        this.b.c(i, true);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (l == null) {
                throw new IllegalArgumentException("Value can not be null");
            }
            t(i, l.longValue());
        }
    }

    public void m(int i, List list) {
        if (list == null) {
            throw new IllegalArgumentException("Values can not be null");
        }
        if (list.size() > 1048576) {
            throw new IllegalArgumentException("Too many values");
        }
        this.b.c(i, true);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
            if (abstractC17902nl0 == null) {
                throw new IllegalArgumentException("Value can not be null");
            }
            i(i, abstractC17902nl0);
        }
    }

    public void n(int i, List list) {
        if (list == null) {
            throw new IllegalArgumentException("Values can not be null");
        }
        if (list.size() > 1048576) {
            throw new IllegalArgumentException("Too many values");
        }
        this.b.c(i, true);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                throw new IllegalArgumentException("Value can not be null");
            }
            o(i, str);
        }
    }

    public void o(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        this.b.c(i, true);
        d(i, str.getBytes());
    }

    public void q(int i, Object obj) throws IOException {
        if (this.b.a(i, false)) {
            return;
        }
        if (obj instanceof Long) {
            g(i, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof byte[]) {
            b(i, (byte[]) obj);
            return;
        }
        if (!(obj instanceof List)) {
            throw new IOException("Incorrect unmapped value");
        }
        for (Object obj2 : (List) obj) {
            if (obj2 instanceof Long) {
                g(i, ((Long) obj2).longValue());
            } else {
                if (!(obj2 instanceof byte[])) {
                    throw new IOException("Incorrect unmapped value in List");
                }
                b(i, (byte[]) obj2);
            }
        }
    }
}
