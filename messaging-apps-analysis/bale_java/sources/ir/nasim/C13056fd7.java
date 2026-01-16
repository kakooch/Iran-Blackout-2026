package ir.nasim;

import android.text.TextUtils;
import okhttp3.internal.http2.Http2Connection;

/* renamed from: ir.nasim.fd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13056fd7 extends C18981pa7 {
    @Override // ir.nasim.C18981pa7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.i = iE;
        this.l = (iE & 2) != 0;
        this.j = (iE & 16) != 0;
        this.k = (iE & 32) != 0;
        this.u = (iE & 8192) != 0;
        this.v = (iE & 16384) != 0;
        this.w = (262144 & iE) != 0;
        this.x = (524288 & iE) != 0;
        this.y = (2097152 & iE) != 0;
        this.z = (iE & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0;
        this.b = t1.e(z);
        if ((this.i & 256) != 0) {
            this.c = Z57.d(t1, t1.e(z), z);
        }
        this.d = Z57.d(t1, t1.e(z), z);
        if ((this.i & 4) != 0) {
            this.A = P57.d(t1, t1.e(z), z);
        }
        if ((this.i & 2048) != 0) {
            this.B = t1.e(z);
        }
        if ((this.i & 8) != 0) {
            this.C = U57.d(t1, t1.e(z), z);
        }
        this.e = t1.e(z);
        this.g = t1.g(z);
        if ((this.i & 512) != 0) {
            Q57 q57D = Q57.d(t1, t1.e(z), z);
            this.h = q57D;
            if (q57D != null) {
                this.R = q57D.F;
            }
            if (q57D != null && !TextUtils.isEmpty(q57D.u)) {
                this.g = this.h.u;
            }
        }
        if ((this.i & 64) != 0) {
            this.p = AbstractC15161j67.d(t1, t1.e(z), z);
        }
        if ((this.i & 128) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                N57 n57D = N57.d(t1, t1.e(z), z);
                if (n57D == null) {
                    return;
                }
                this.n.add(n57D);
            }
        }
        if ((this.i & 1024) != 0) {
            this.q = t1.e(z);
        }
        if ((this.i & 1024) != 0) {
            this.r = t1.e(z);
        }
        if ((this.i & 8388608) != 0) {
            this.s = T57.d(t1, t1.e(z), z);
        }
        if ((this.i & 32768) != 0) {
            this.t = t1.e(z);
        }
        if ((this.i & 65536) != 0) {
            this.D = t1.g(z);
        }
        if ((this.i & 131072) != 0) {
            this.E = t1.f(z);
        }
        if ((this.i & 4194304) != 0) {
            int iE4 = t1.e(z);
            if (iE4 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE4)));
                }
                return;
            }
            int iE5 = t1.e(z);
            for (int i2 = 0; i2 < iE5; i2++) {
                C5882Lf7 c5882Lf7D = C5882Lf7.d(t1, t1.e(z), z);
                if (c5882Lf7D == null) {
                    return;
                }
                this.G.add(c5882Lf7D);
            }
        }
    }
}
