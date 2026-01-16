package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class B07 implements InterfaceC9262Ze2 {
    private final InterfaceC24671z07 a;
    private final com.google.android.exoplayer2.X d;
    private InterfaceC10465bf2 g;
    private InterfaceC4589Ft7 h;
    private int i;
    private final C15649jw1 b = new C15649jw1();
    private final EW4 c = new EW4();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private int j = 0;
    private long k = -9223372036854775807L;

    public B07(InterfaceC24671z07 interfaceC24671z07, com.google.android.exoplayer2.X x) {
        this.a = interfaceC24671z07;
        this.d = x.c().g0("text/x-exoplayer-cues").K(x.l).G();
    }

    private void c() throws InterruptedException, ParserException, InterruptedIOException {
        try {
            C07 c07 = (C07) this.a.d();
            while (c07 == null) {
                Thread.sleep(5L);
                c07 = (C07) this.a.d();
            }
            c07.z(this.i);
            c07.c.put(this.c.e(), 0, this.i);
            c07.c.limit(this.i);
            this.a.c(c07);
            D07 d07 = (D07) this.a.b();
            while (d07 == null) {
                Thread.sleep(5L);
                d07 = (D07) this.a.b();
            }
            for (int i = 0; i < d07.j(); i++) {
                byte[] bArrA = this.b.a(d07.h(d07.i(i)));
                this.e.add(Long.valueOf(d07.i(i)));
                this.f.add(new EW4(bArrA));
            }
            d07.y();
        } catch (SubtitleDecoderException e) {
            throw ParserException.a("SubtitleDecoder failed.", e);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    private boolean f(InterfaceC9845af2 interfaceC9845af2) {
        int iB = this.c.b();
        int i = this.i;
        if (iB == i) {
            this.c.c(i + 1024);
        }
        int i2 = interfaceC9845af2.read(this.c.e(), this.i, this.c.b() - this.i);
        if (i2 != -1) {
            this.i += i2;
        }
        long length = interfaceC9845af2.getLength();
        return (length != -1 && ((long) this.i) == length) || i2 == -1;
    }

    private boolean g(InterfaceC9845af2 interfaceC9845af2) {
        return interfaceC9845af2.a((interfaceC9845af2.getLength() > (-1L) ? 1 : (interfaceC9845af2.getLength() == (-1L) ? 0 : -1)) != 0 ? AbstractC8236Vc3.d(interfaceC9845af2.getLength()) : 1024) == -1;
    }

    private void h() {
        AbstractC20011rK.i(this.h);
        AbstractC20011rK.g(this.e.size() == this.f.size());
        long j = this.k;
        for (int iG = j == -9223372036854775807L ? 0 : AbstractC9683aN7.g(this.e, Long.valueOf(j), true, true); iG < this.f.size(); iG++) {
            EW4 ew4 = (EW4) this.f.get(iG);
            ew4.S(0);
            int length = ew4.e().length;
            this.h.d(ew4, length);
            this.h.b(((Long) this.e.get(iG)).longValue(), 1, length, 0, null);
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void a(long j, long j2) {
        int i = this.j;
        AbstractC20011rK.g((i == 0 || i == 5) ? false : true);
        this.k = j2;
        if (this.j == 2) {
            this.j = 1;
        }
        if (this.j == 4) {
            this.j = 3;
        }
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void b(InterfaceC10465bf2 interfaceC10465bf2) {
        AbstractC20011rK.g(this.j == 0);
        this.g = interfaceC10465bf2;
        this.h = interfaceC10465bf2.b(0, 3);
        this.g.s();
        this.g.o(new C12730f63(new long[]{0}, new long[]{0}, -9223372036854775807L));
        this.h.c(this.d);
        this.j = 1;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        return true;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public int e(InterfaceC9845af2 interfaceC9845af2, C8292Vi5 c8292Vi5) throws InterruptedException, ParserException, InterruptedIOException {
        int i = this.j;
        AbstractC20011rK.g((i == 0 || i == 5) ? false : true);
        if (this.j == 1) {
            this.c.O(interfaceC9845af2.getLength() != -1 ? AbstractC8236Vc3.d(interfaceC9845af2.getLength()) : 1024);
            this.i = 0;
            this.j = 2;
        }
        if (this.j == 2 && f(interfaceC9845af2)) {
            c();
            h();
            this.j = 4;
        }
        if (this.j == 3 && g(interfaceC9845af2)) {
            h();
            this.j = 4;
        }
        return this.j == 4 ? -1 : 0;
    }

    @Override // ir.nasim.InterfaceC9262Ze2
    public void release() {
        if (this.j == 5) {
            return;
        }
        this.a.release();
        this.j = 5;
    }
}
