package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C24870zL3;
import ir.nasim.features.audioplayer.audioinfo.mp3.MP3Exception;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes5.dex */
public class AL3 extends QN {
    static final Logger v = Logger.getLogger(AL3.class.getName());

    class a implements b {
        final long a;
        final /* synthetic */ long b;

        a(long j) {
            this.b = j;
            this.a = j - 128;
        }

        @Override // ir.nasim.AL3.b
        public boolean a(BL3 bl3) {
            return bl3.a() == this.a && DZ2.w(bl3);
        }
    }

    interface b {
        boolean a(BL3 bl3);
    }

    public AL3(InputStream inputStream, long j) {
        this(inputStream, j, Level.FINEST);
    }

    public String toString() {
        return "{ title : " + this.d + "  artist : " + this.e + " cover : " + this.t + "  duration : " + this.c + " }";
    }

    long v(BL3 bl3, long j, b bVar) throws MP3Exception, IOException {
        C24870zL3 c24870zL3W = w(bl3, bVar);
        if (c24870zL3W == null) {
            throw new MP3Exception("No audio frame");
        }
        if (c24870zL3W.b() > 0) {
            return c24870zL3W.a().j(r4 * c24870zL3W.c());
        }
        long jA = bl3.a() - c24870zL3W.c();
        long jC = c24870zL3W.c();
        int iA = c24870zL3W.a().a();
        long j2 = iA;
        int iC = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND / c24870zL3W.a().c();
        boolean z = false;
        int i = 1;
        while (true) {
            if (i == iC && !z && j > 0) {
                return c24870zL3W.a().j(j - jA);
            }
            c24870zL3W = x(bl3, bVar, c24870zL3W);
            if (c24870zL3W == null) {
                return (((jC * 1000) * i) * 8) / j2;
            }
            int iA2 = c24870zL3W.a().a();
            int i2 = iC;
            if (iA2 != iA) {
                z = true;
            }
            j2 += iA2;
            jC += c24870zL3W.c();
            i++;
            iC = i2;
        }
    }

    C24870zL3 w(BL3 bl3, b bVar) throws IOException {
        C24870zL3.b bVar2;
        int i = bVar.a(bl3) ? -1 : bl3.read();
        int i2 = 0;
        while (i != -1) {
            if (i2 == 255 && (i & 224) == 224) {
                bl3.mark(2);
                int i3 = bVar.a(bl3) ? -1 : bl3.read();
                if (i3 == -1) {
                    break;
                }
                int i4 = bVar.a(bl3) ? -1 : bl3.read();
                if (i4 == -1) {
                    break;
                }
                try {
                    bVar2 = new C24870zL3.b(i, i3, i4);
                } catch (MP3Exception unused) {
                    bVar2 = null;
                }
                if (bVar2 != null) {
                    bl3.reset();
                    bl3.mark(bVar2.d() + 2);
                    int iD = bVar2.d();
                    byte[] bArr = new byte[iD];
                    bArr[0] = -1;
                    bArr[1] = (byte) i;
                    int i5 = iD - 2;
                    try {
                        bl3.b(bArr, 2, i5);
                        C24870zL3 c24870zL3 = new C24870zL3(bVar2, bArr);
                        if (!c24870zL3.d()) {
                            int i6 = bVar.a(bl3) ? -1 : bl3.read();
                            int i7 = bVar.a(bl3) ? -1 : bl3.read();
                            if (i6 != -1 && i7 != -1) {
                                if (i6 == 255 && (i7 & 254) == (i & 254)) {
                                    int i8 = bVar.a(bl3) ? -1 : bl3.read();
                                    int i9 = bVar.a(bl3) ? -1 : bl3.read();
                                    if (i8 != -1 && i9 != -1) {
                                        try {
                                            if (new C24870zL3.b(i7, i8, i9).n(bVar2)) {
                                                bl3.reset();
                                                bl3.c(i5);
                                            }
                                        } catch (MP3Exception unused2) {
                                        }
                                    }
                                }
                            }
                            return c24870zL3;
                        }
                    } catch (EOFException unused3) {
                    }
                }
                bl3.reset();
            }
            i2 = i;
            i = bVar.a(bl3) ? -1 : bl3.read();
        }
        return null;
    }

    C24870zL3 x(BL3 bl3, b bVar, C24870zL3 c24870zL3) throws IOException {
        C24870zL3.b bVar2;
        C24870zL3.b bVarA = c24870zL3.a();
        bl3.mark(4);
        int i = bVar.a(bl3) ? -1 : bl3.read();
        int i2 = bVar.a(bl3) ? -1 : bl3.read();
        if (i != -1 && i2 != -1) {
            if (i == 255 && (i2 & 224) == 224) {
                int i3 = bVar.a(bl3) ? -1 : bl3.read();
                int i4 = bVar.a(bl3) ? -1 : bl3.read();
                if (i3 != -1 && i4 != -1) {
                    try {
                        bVar2 = new C24870zL3.b(i2, i3, i4);
                    } catch (MP3Exception unused) {
                        bVar2 = null;
                    }
                    if (bVar2 != null && bVar2.n(bVarA)) {
                        int iD = bVar2.d();
                        byte[] bArr = new byte[iD];
                        bArr[0] = (byte) i;
                        bArr[1] = (byte) i2;
                        bArr[2] = (byte) i3;
                        bArr[3] = (byte) i4;
                        try {
                            bl3.b(bArr, 4, iD - 4);
                            return new C24870zL3(bVar2, bArr);
                        } catch (EOFException unused2) {
                        }
                    }
                }
                return null;
            }
            bl3.reset();
        }
        return null;
    }

    public AL3(InputStream inputStream, long j, Level level) throws IOException {
        this.a = "MP3";
        this.b = "0";
        BL3 bl3 = new BL3(inputStream);
        if (IZ2.v(bl3)) {
            IZ2 iz2 = new IZ2(bl3, level);
            this.g = iz2.a();
            this.f = iz2.b();
            this.e = iz2.c();
            this.j = iz2.e();
            this.t = iz2.h();
            this.u = iz2.p();
            this.r = iz2.u();
            this.p = iz2.f();
            this.o = iz2.g();
            this.m = iz2.i();
            this.n = iz2.j();
            this.c = iz2.k();
            this.i = iz2.l();
            this.q = iz2.m();
            this.s = iz2.n();
            this.d = iz2.q();
            this.k = iz2.r();
            this.l = iz2.s();
            this.h = iz2.t();
        }
        long j2 = this.c;
        if (j2 <= 0 || j2 >= 3600000) {
            try {
                this.c = v(bl3, j, new a(j));
            } catch (MP3Exception e) {
                Logger logger = v;
                if (logger.isLoggable(level)) {
                    logger.log(level, "Could not determine MP3 duration", (Throwable) e);
                }
            }
        }
        if (this.d == null || this.g == null || this.e == null) {
            long j3 = j - 128;
            if (bl3.a() <= j3) {
                bl3.c(j3 - bl3.a());
                if (DZ2.w(inputStream)) {
                    DZ2 dz2 = new DZ2(inputStream);
                    if (this.g == null) {
                        this.g = dz2.a();
                    }
                    if (this.e == null) {
                        this.e = dz2.c();
                    }
                    if (this.j == null) {
                        this.j = dz2.e();
                    }
                    if (this.i == null) {
                        this.i = dz2.l();
                    }
                    if (this.d == null) {
                        this.d = dz2.q();
                    }
                    if (this.k == 0) {
                        this.k = dz2.r();
                    }
                    if (this.h == 0) {
                        this.h = dz2.t();
                    }
                }
            }
        }
    }
}
