package ir.nasim;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Pair;
import com.google.android.exoplayer2.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class XY3 {
    private static final MediaMetadataCompat t;
    public final MediaSessionCompat a;
    private final Looper b;
    private final d c;
    private final ArrayList d;
    private final ArrayList e;
    private e[] f;
    private Map g;
    private h h;
    private com.google.android.exoplayer2.z0 i;
    private Pair j;
    private Bundle k;
    private i l;
    private k m;
    private g n;
    private long o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    public interface b extends c {
    }

    public interface c {
        boolean h(com.google.android.exoplayer2.z0 z0Var, String str, Bundle bundle, ResultReceiver resultReceiver);
    }

    private class d extends MediaSessionCompat.b implements z0.d {
        private int f;
        private int g;

        private d() {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void C(Uri uri, Bundle bundle) {
            if (XY3.this.B(8192L)) {
                XY3.this.l.g(uri, true, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void F() {
            if (XY3.this.B(Http2Stream.EMIT_BUFFER_SIZE)) {
                XY3.this.l.e(false);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void H(String str, Bundle bundle) {
            if (XY3.this.B(32768L)) {
                XY3.this.l.m(str, false, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void K(String str, Bundle bundle) {
            if (XY3.this.B(65536L)) {
                XY3.this.l.a(str, false, bundle);
            }
        }

        @Override // com.google.android.exoplayer2.z0.d
        public void M3(com.google.android.exoplayer2.z0 z0Var, z0.c cVar) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            if (cVar.a(11)) {
                if (this.f != z0Var.r0()) {
                    if (XY3.this.m != null) {
                        XY3.this.m.l(z0Var);
                    }
                    z = true;
                } else {
                    z = false;
                }
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (cVar.a(0)) {
                int iU = z0Var.N().u();
                int iR0 = z0Var.r0();
                if (XY3.this.m != null) {
                    XY3.this.m.i(z0Var);
                } else {
                    if (this.g != iU || this.f != iR0) {
                    }
                    this.g = iU;
                    z = true;
                }
                z2 = true;
                this.g = iU;
                z = true;
            }
            this.f = z0Var.r0();
            if (cVar.b(4, 5, 7, 8, 12)) {
                z2 = true;
            }
            if (cVar.b(9)) {
                XY3.this.G();
            } else {
                z3 = z2;
            }
            if (z3) {
                XY3.this.F();
            }
            if (z) {
                XY3.this.E();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void P(Uri uri, Bundle bundle) {
            if (XY3.this.B(131072L)) {
                XY3.this.l.g(uri, false, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void Q(MediaDescriptionCompat mediaDescriptionCompat) {
            if (XY3.this.y()) {
                XY3.h(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void T() {
            if (XY3.this.x(8L)) {
                XY3.this.i.y0();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void U(long j) {
            if (XY3.this.x(256L)) {
                XY3 xy3 = XY3.this;
                xy3.I(xy3.i, XY3.this.i.r0(), j);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void V(boolean z) {
            if (XY3.this.z()) {
                XY3.j(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void W(float f) {
            if (!XY3.this.x(4194304L) || f <= 0.0f) {
                return;
            }
            XY3.this.i.e(XY3.this.i.c().e(f));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void Y(RatingCompat ratingCompat) {
            if (XY3.this.A()) {
                XY3.f(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void Z(RatingCompat ratingCompat, Bundle bundle) {
            if (XY3.this.A()) {
                XY3.f(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void a0(int i) {
            if (XY3.this.x(262144L)) {
                int i2 = 1;
                if (i != 1) {
                    i2 = 2;
                    if (i != 2 && i != 3) {
                        i2 = 0;
                    }
                }
                XY3.this.i.s(i2);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void b0(int i) {
            if (XY3.this.x(2097152L)) {
                boolean z = true;
                if (i != 1 && i != 2) {
                    z = false;
                }
                XY3.this.i.Y(z);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void c0() {
            if (XY3.this.C(32L)) {
                XY3.this.m.b(XY3.this.i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void d0() {
            if (XY3.this.C(16L)) {
                XY3.this.m.k(XY3.this.i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void e(MediaDescriptionCompat mediaDescriptionCompat) {
            if (XY3.this.y()) {
                XY3.h(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void e0(long j) {
            if (XY3.this.C(4096L)) {
                XY3.this.m.d(XY3.this.i, j);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void f0() {
            if (XY3.this.x(1L)) {
                XY3.this.i.stop();
                if (XY3.this.r) {
                    XY3.this.i.m();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void h(MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (XY3.this.y()) {
                XY3.h(XY3.this);
                com.google.android.exoplayer2.z0 unused = XY3.this.i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void k(String str, Bundle bundle, ResultReceiver resultReceiver) {
            if (XY3.this.i != null) {
                for (int i = 0; i < XY3.this.d.size(); i++) {
                    if (((c) XY3.this.d.get(i)).h(XY3.this.i, str, bundle, resultReceiver)) {
                        return;
                    }
                }
                for (int i2 = 0; i2 < XY3.this.e.size() && !((c) XY3.this.e.get(i2)).h(XY3.this.i, str, bundle, resultReceiver); i2++) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void p(String str, Bundle bundle) {
            if (XY3.this.i == null || !XY3.this.g.containsKey(str)) {
                return;
            }
            AbstractC18350oW3.a(XY3.this.g.get(str));
            com.google.android.exoplayer2.z0 unused = XY3.this.i;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void q() {
            if (XY3.this.x(64L)) {
                XY3.this.i.x0();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public boolean r(Intent intent) {
            return (XY3.this.w() && XY3.this.n.a(XY3.this.i, intent)) || super.r(intent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void t() {
            if (XY3.this.x(2L)) {
                XY3.this.i.h();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void v() {
            if (XY3.this.x(4L)) {
                if (XY3.this.i.p() == 1) {
                    if (XY3.this.l != null) {
                        XY3.this.l.e(true);
                    } else {
                        XY3.this.i.r();
                    }
                } else if (XY3.this.i.p() == 4) {
                    XY3 xy3 = XY3.this;
                    xy3.I(xy3.i, XY3.this.i.r0(), -9223372036854775807L);
                }
                ((com.google.android.exoplayer2.z0) AbstractC20011rK.e(XY3.this.i)).q();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void x(String str, Bundle bundle) {
            if (XY3.this.B(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE)) {
                XY3.this.l.m(str, true, bundle);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void z(String str, Bundle bundle) {
            if (XY3.this.B(2048L)) {
                XY3.this.l.a(str, true, bundle);
            }
        }
    }

    public interface e {
    }

    public static final class f implements h {
        private final MediaControllerCompat a;
        private final String b;

        public f(MediaControllerCompat mediaControllerCompat, String str) {
            this.a = mediaControllerCompat;
            this.b = str == null ? "" : str;
        }

        @Override // ir.nasim.XY3.h
        public MediaMetadataCompat b(com.google.android.exoplayer2.z0 z0Var) {
            if (z0Var.N().v()) {
                return XY3.t;
            }
            MediaMetadataCompat.b bVar = new MediaMetadataCompat.b();
            if (z0Var.k()) {
                bVar.c("android.media.metadata.ADVERTISEMENT", 1L);
            }
            bVar.c("android.media.metadata.DURATION", (z0Var.L() || z0Var.f() == -9223372036854775807L) ? -1L : z0Var.f());
            long jC = this.a.c().c();
            if (jC != -1) {
                List listD = this.a.d();
                int i = 0;
                while (true) {
                    if (listD == null || i >= listD.size()) {
                        break;
                    }
                    MediaSessionCompat.QueueItem queueItem = (MediaSessionCompat.QueueItem) listD.get(i);
                    if (queueItem.d() == jC) {
                        MediaDescriptionCompat mediaDescriptionCompatC = queueItem.c();
                        Bundle bundleC = mediaDescriptionCompatC.c();
                        if (bundleC != null) {
                            for (String str : bundleC.keySet()) {
                                Object obj = bundleC.get(str);
                                if (obj instanceof String) {
                                    bVar.e(this.b + str, (String) obj);
                                } else if (obj instanceof CharSequence) {
                                    bVar.f(this.b + str, (CharSequence) obj);
                                } else if (obj instanceof Long) {
                                    bVar.c(this.b + str, ((Long) obj).longValue());
                                } else if (obj instanceof Integer) {
                                    bVar.c(this.b + str, ((Integer) obj).intValue());
                                } else if (obj instanceof Bitmap) {
                                    bVar.b(this.b + str, (Bitmap) obj);
                                } else if (obj instanceof RatingCompat) {
                                    bVar.d(this.b + str, (RatingCompat) obj);
                                }
                            }
                        }
                        CharSequence charSequenceJ = mediaDescriptionCompatC.j();
                        if (charSequenceJ != null) {
                            String strValueOf = String.valueOf(charSequenceJ);
                            bVar.e("android.media.metadata.TITLE", strValueOf);
                            bVar.e("android.media.metadata.DISPLAY_TITLE", strValueOf);
                        }
                        CharSequence charSequenceI = mediaDescriptionCompatC.i();
                        if (charSequenceI != null) {
                            bVar.e("android.media.metadata.DISPLAY_SUBTITLE", String.valueOf(charSequenceI));
                        }
                        CharSequence charSequenceB = mediaDescriptionCompatC.b();
                        if (charSequenceB != null) {
                            bVar.e("android.media.metadata.DISPLAY_DESCRIPTION", String.valueOf(charSequenceB));
                        }
                        Bitmap bitmapD = mediaDescriptionCompatC.d();
                        if (bitmapD != null) {
                            bVar.b("android.media.metadata.DISPLAY_ICON", bitmapD);
                        }
                        Uri uriE = mediaDescriptionCompatC.e();
                        if (uriE != null) {
                            bVar.e("android.media.metadata.DISPLAY_ICON_URI", String.valueOf(uriE));
                        }
                        String strG = mediaDescriptionCompatC.g();
                        if (strG != null) {
                            bVar.e("android.media.metadata.MEDIA_ID", strG);
                        }
                        Uri uriH = mediaDescriptionCompatC.h();
                        if (uriH != null) {
                            bVar.e("android.media.metadata.MEDIA_URI", String.valueOf(uriH));
                        }
                    } else {
                        i++;
                    }
                }
            }
            return bVar.a();
        }
    }

    public interface g {
        boolean a(com.google.android.exoplayer2.z0 z0Var, Intent intent);
    }

    public interface h {
        default boolean a(MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
            if (mediaMetadataCompat == mediaMetadataCompat2) {
                return true;
            }
            if (mediaMetadataCompat.k() != mediaMetadataCompat2.k()) {
                return false;
            }
            Set<String> setJ = mediaMetadataCompat.j();
            Bundle bundleD = mediaMetadataCompat.d();
            Bundle bundleD2 = mediaMetadataCompat2.d();
            for (String str : setJ) {
                Object obj = bundleD.get(str);
                Object obj2 = bundleD2.get(str);
                if (obj != obj2) {
                    if ((obj instanceof Bitmap) && (obj2 instanceof Bitmap)) {
                        if (!((Bitmap) obj).sameAs((Bitmap) obj2)) {
                            return false;
                        }
                    } else if ((obj instanceof RatingCompat) && (obj2 instanceof RatingCompat)) {
                        RatingCompat ratingCompat = (RatingCompat) obj;
                        RatingCompat ratingCompat2 = (RatingCompat) obj2;
                        if (ratingCompat.f() != ratingCompat2.f() || ratingCompat.g() != ratingCompat2.g() || ratingCompat.h() != ratingCompat2.h() || ratingCompat.b() != ratingCompat2.b() || ratingCompat.e() != ratingCompat2.e() || ratingCompat.d() != ratingCompat2.d()) {
                            return false;
                        }
                    } else if (!AbstractC9683aN7.c(obj, obj2)) {
                        return false;
                    }
                }
            }
            return true;
        }

        MediaMetadataCompat b(com.google.android.exoplayer2.z0 z0Var);
    }

    public interface i extends c {
        void a(String str, boolean z, Bundle bundle);

        void e(boolean z);

        long f();

        void g(Uri uri, boolean z, Bundle bundle);

        void m(String str, boolean z, Bundle bundle);
    }

    public interface j extends c {
    }

    public interface k extends c {
        void b(com.google.android.exoplayer2.z0 z0Var);

        long c(com.google.android.exoplayer2.z0 z0Var);

        void d(com.google.android.exoplayer2.z0 z0Var, long j);

        void i(com.google.android.exoplayer2.z0 z0Var);

        long j(com.google.android.exoplayer2.z0 z0Var);

        void k(com.google.android.exoplayer2.z0 z0Var);

        void l(com.google.android.exoplayer2.z0 z0Var);
    }

    public interface l extends c {
    }

    static {
        AbstractC9253Zd2.a("goog.exo.mediasession");
        t = new MediaMetadataCompat.b().a();
    }

    public XY3(MediaSessionCompat mediaSessionCompat) {
        this.a = mediaSessionCompat;
        Looper looperN = AbstractC9683aN7.N();
        this.b = looperN;
        d dVar = new d();
        this.c = dVar;
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new e[0];
        this.g = Collections.emptyMap();
        this.h = new f(mediaSessionCompat.b(), null);
        this.o = 2360143L;
        mediaSessionCompat.i(3);
        mediaSessionCompat.h(dVar, new Handler(looperN));
        this.r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(long j2) {
        i iVar = this.l;
        return iVar != null && ((j2 & iVar.f()) != 0 || this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(long j2) {
        k kVar;
        com.google.android.exoplayer2.z0 z0Var = this.i;
        return (z0Var == null || (kVar = this.m) == null || ((j2 & kVar.j(z0Var)) == 0 && !this.q)) ? false : true;
    }

    private int D(int i2, boolean z) {
        if (i2 == 2) {
            return z ? 6 : 2;
        }
        if (i2 == 3) {
            return z ? 3 : 2;
        }
        if (i2 != 4) {
            return this.s ? 1 : 0;
        }
        return 1;
    }

    private void H(c cVar) {
        if (cVar == null || this.d.contains(cVar)) {
            return;
        }
        this.d.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(com.google.android.exoplayer2.z0 z0Var, int i2, long j2) {
        z0Var.U(i2, j2);
    }

    private void O(c cVar) {
        if (cVar != null) {
            this.d.remove(cVar);
        }
    }

    static /* synthetic */ l f(XY3 xy3) {
        xy3.getClass();
        return null;
    }

    static /* synthetic */ j h(XY3 xy3) {
        xy3.getClass();
        return null;
    }

    static /* synthetic */ b j(XY3 xy3) {
        xy3.getClass();
        return null;
    }

    private long u(com.google.android.exoplayer2.z0 z0Var) {
        boolean zK = z0Var.K(5);
        boolean zK2 = z0Var.K(11);
        boolean zK3 = z0Var.K(12);
        if (!z0Var.N().v()) {
            z0Var.k();
        }
        long j2 = zK ? 6554375L : 6554119L;
        if (zK3) {
            j2 |= 64;
        }
        if (zK2) {
            j2 |= 8;
        }
        long j3 = this.o & j2;
        k kVar = this.m;
        return kVar != null ? j3 | (kVar.j(z0Var) & 4144) : j3;
    }

    private long v() {
        i iVar = this.l;
        if (iVar == null) {
            return 0L;
        }
        return iVar.f() & 257024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w() {
        return (this.i == null || this.n == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(long j2) {
        return this.i != null && ((j2 & this.o) != 0 || this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        return false;
    }

    public final void E() {
        MediaMetadataCompat mediaMetadataCompatB;
        com.google.android.exoplayer2.z0 z0Var;
        h hVar = this.h;
        MediaMetadataCompat mediaMetadataCompatB2 = (hVar == null || (z0Var = this.i) == null) ? t : hVar.b(z0Var);
        h hVar2 = this.h;
        if (!this.p || hVar2 == null || (mediaMetadataCompatB = this.a.b().b()) == null || !hVar2.a(mediaMetadataCompatB, mediaMetadataCompatB2)) {
            this.a.j(mediaMetadataCompatB2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5 A[PHI: r5
      0x00e5: PHI (r5v4 int) = (r5v2 int), (r5v3 int) binds: [B:35:0x00e3, B:38:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XY3.F():void");
    }

    public final void G() {
        com.google.android.exoplayer2.z0 z0Var;
        k kVar = this.m;
        if (kVar == null || (z0Var = this.i) == null) {
            return;
        }
        kVar.i(z0Var);
    }

    public void J(long j2) {
        long j3 = j2 & 6554447;
        if (this.o != j3) {
            this.o = j3;
            F();
        }
    }

    public void K(g gVar) {
        this.n = gVar;
    }

    public void L(i iVar) {
        i iVar2 = this.l;
        if (iVar2 != iVar) {
            O(iVar2);
            this.l = iVar;
            H(iVar);
            F();
        }
    }

    public void M(com.google.android.exoplayer2.z0 z0Var) {
        AbstractC20011rK.a(z0Var == null || z0Var.O() == this.b);
        com.google.android.exoplayer2.z0 z0Var2 = this.i;
        if (z0Var2 != null) {
            z0Var2.o(this.c);
        }
        this.i = z0Var;
        if (z0Var != null) {
            z0Var.m0(this.c);
        }
        F();
        E();
    }

    public void N(k kVar) {
        k kVar2 = this.m;
        if (kVar2 != kVar) {
            O(kVar2);
            this.m = kVar;
            H(kVar);
        }
    }
}
