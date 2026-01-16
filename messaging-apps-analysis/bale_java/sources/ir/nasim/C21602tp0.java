package ir.nasim;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.IOException;
import java.io.InterruptedIOException;

/* renamed from: ir.nasim.tp0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21602tp0 {
    private final com.google.android.exoplayer2.upstream.cache.a a;
    private final Cache b;
    private final com.google.android.exoplayer2.upstream.b c;
    private final String d;
    private final byte[] e;
    private final a f;
    private long g;
    private long h;
    private long i;
    private volatile boolean j;

    /* renamed from: ir.nasim.tp0$a */
    public interface a {
        void a(long j, long j2, long j3);
    }

    public C21602tp0(com.google.android.exoplayer2.upstream.cache.a aVar, com.google.android.exoplayer2.upstream.b bVar, byte[] bArr, a aVar2) {
        this.a = aVar;
        this.b = aVar.o();
        this.c = bVar;
        this.e = bArr == null ? new byte[131072] : bArr;
        this.f = aVar2;
        this.d = aVar.p().a(bVar);
        this.g = bVar.g;
    }

    private long c() {
        long j = this.h;
        if (j == -1) {
            return -1L;
        }
        return j - this.c.g;
    }

    private void d(long j) {
        this.i += j;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(c(), this.i, j);
        }
    }

    private void e(long j) {
        if (this.h == j) {
            return;
        }
        this.h = j;
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(c(), this.i, 0L);
        }
    }

    private long f(long j, long j2) throws IOException {
        long jB;
        boolean z = true;
        boolean z2 = j + j2 == this.h || j2 == -1;
        if (j2 != -1) {
            try {
                jB = this.a.b(this.c.a().h(j).g(j2).a());
            } catch (IOException unused) {
                AbstractC22885vz1.a(this.a);
            }
        } else {
            z = false;
            jB = -1;
        }
        if (!z) {
            g();
            try {
                jB = this.a.b(this.c.a().h(j).g(-1L).a());
            } catch (IOException e) {
                AbstractC22885vz1.a(this.a);
                throw e;
            }
        }
        if (z2 && jB != -1) {
            try {
                e(jB + j);
            } catch (IOException e2) {
                AbstractC22885vz1.a(this.a);
                throw e2;
            }
        }
        int i = 0;
        int i2 = 0;
        while (i != -1) {
            g();
            com.google.android.exoplayer2.upstream.cache.a aVar = this.a;
            byte[] bArr = this.e;
            i = aVar.read(bArr, 0, bArr.length);
            if (i != -1) {
                d(i);
                i2 += i;
            }
        }
        if (z2) {
            e(j + i2);
        }
        this.a.close();
        return i2;
    }

    private void g() throws InterruptedIOException {
        if (this.j) {
            throw new InterruptedIOException();
        }
    }

    public void a() throws InterruptedIOException {
        g();
        Cache cache = this.b;
        String str = this.d;
        com.google.android.exoplayer2.upstream.b bVar = this.c;
        this.i = cache.c(str, bVar.g, bVar.h);
        com.google.android.exoplayer2.upstream.b bVar2 = this.c;
        long j = bVar2.h;
        if (j != -1) {
            this.h = bVar2.g + j;
        } else {
            long jA = InterfaceC8806Xk1.a(this.b.b(this.d));
            if (jA == -1) {
                jA = -1;
            }
            this.h = jA;
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(c(), this.i, 0L);
        }
        while (true) {
            long j2 = this.h;
            if (j2 != -1 && this.g >= j2) {
                return;
            }
            g();
            long j3 = this.h;
            long jE = this.b.e(this.d, this.g, j3 == -1 ? Long.MAX_VALUE : j3 - this.g);
            if (jE > 0) {
                this.g += jE;
            } else {
                long j4 = -jE;
                if (j4 == Long.MAX_VALUE) {
                    j4 = -1;
                }
                long j5 = this.g;
                this.g = j5 + f(j5, j4);
            }
        }
    }

    public void b() {
        this.j = true;
    }
}
