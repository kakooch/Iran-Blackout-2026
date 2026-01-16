package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.drm.m;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC14535i43;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC3895Cu6;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C8208Uz2;
import ir.nasim.DB7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public class DefaultDrmSessionManager implements i {
    private final UUID c;
    private final m.c d;
    private final p e;
    private final HashMap f;
    private final boolean g;
    private final int[] h;
    private final boolean i;
    private final f j;
    private final com.google.android.exoplayer2.upstream.j k;
    private final g l;
    private final long m;
    private final List n;
    private final Set o;
    private final Set p;
    private int q;
    private m r;
    private DefaultDrmSession s;
    private DefaultDrmSession t;
    private Looper u;
    private Handler v;
    private int w;
    private byte[] x;
    private C15493jg5 y;
    volatile d z;

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    public static final class b {
        private boolean d;
        private boolean f;
        private final HashMap a = new HashMap();
        private UUID b = AbstractC9350Zo0.d;
        private m.c c = n.d;
        private com.google.android.exoplayer2.upstream.j g = new com.google.android.exoplayer2.upstream.i();
        private int[] e = new int[0];
        private long h = 300000;

        public DefaultDrmSessionManager a(p pVar) {
            return new DefaultDrmSessionManager(this.b, this.c, pVar, this.a, this.d, this.e, this.f, this.g, this.h);
        }

        public b b(boolean z) {
            this.d = z;
            return this;
        }

        public b c(boolean z) {
            this.f = z;
            return this;
        }

        public b d(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                AbstractC20011rK.a(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, m.c cVar) {
            this.b = (UUID) AbstractC20011rK.e(uuid);
            this.c = (m.c) AbstractC20011rK.e(cVar);
            return this;
        }
    }

    private class c implements m.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.drm.m.b
        public void a(m mVar, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((d) AbstractC20011rK.e(DefaultDrmSessionManager.this.z)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    private class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.n) {
                if (defaultDrmSession.r(bArr)) {
                    defaultDrmSession.z(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e implements i.b {
        private final h.a b;
        private DrmSession c;
        private boolean d;

        public e(h.a aVar) {
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(X x) {
            if (DefaultDrmSessionManager.this.q == 0 || this.d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.c = defaultDrmSessionManager.t((Looper) AbstractC20011rK.e(defaultDrmSessionManager.u), this.b, x, false);
            DefaultDrmSessionManager.this.o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            if (this.d) {
                return;
            }
            DrmSession drmSession = this.c;
            if (drmSession != null) {
                drmSession.b(this.b);
            }
            DefaultDrmSessionManager.this.o.remove(this);
            this.d = true;
        }

        public void e(final X x) {
            ((Handler) AbstractC20011rK.e(DefaultDrmSessionManager.this.v)).post(new Runnable() { // from class: com.google.android.exoplayer2.drm.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f(x);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.i.b
        public void release() {
            AbstractC9683aN7.J0((Handler) AbstractC20011rK.e(DefaultDrmSessionManager.this.v), new Runnable() { // from class: com.google.android.exoplayer2.drm.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g();
                }
            });
        }
    }

    private class f implements DefaultDrmSession.a {
        private final Set a = new HashSet();
        private DefaultDrmSession b;

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z) {
            this.b = null;
            AbstractC12710f43 abstractC12710f43O = AbstractC12710f43.O(this.a);
            this.a.clear();
            DB7 it = abstractC12710f43O.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).B(exc, z);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.a.add(defaultDrmSession);
            if (this.b != null) {
                return;
            }
            this.b = defaultDrmSession;
            defaultDrmSession.F();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void c() {
            this.b = null;
            AbstractC12710f43 abstractC12710f43O = AbstractC12710f43.O(this.a);
            this.a.clear();
            DB7 it = abstractC12710f43O.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).A();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.a.remove(defaultDrmSession);
            if (this.b == defaultDrmSession) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) this.a.iterator().next();
                this.b = defaultDrmSession2;
                defaultDrmSession2.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g implements DefaultDrmSession.b {
        private g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i) {
            if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                ((Handler) AbstractC20011rK.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && DefaultDrmSessionManager.this.q > 0 && DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.add(defaultDrmSession);
                ((Handler) AbstractC20011rK.e(DefaultDrmSessionManager.this.v)).postAtTime(new Runnable() { // from class: com.google.android.exoplayer2.drm.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.b(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.m);
            } else if (i == 0) {
                DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.s = null;
                }
                if (DefaultDrmSessionManager.this.t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.t = null;
                }
                DefaultDrmSessionManager.this.j.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                    ((Handler) AbstractC20011rK.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.C();
        }
    }

    private DrmSession A(int i, boolean z) {
        m mVar = (m) AbstractC20011rK.e(this.r);
        if ((mVar.g() == 2 && C8208Uz2.d) || AbstractC9683aN7.z0(this.h, i) == -1 || mVar.g() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.s;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionX = x(AbstractC12710f43.V(), true, null, z);
            this.n.add(defaultDrmSessionX);
            this.s = defaultDrmSessionX;
        } else {
            defaultDrmSession.a(null);
        }
        return this.s;
    }

    private void B(Looper looper) {
        if (this.z == null) {
            this.z = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.r != null && this.q == 0 && this.n.isEmpty() && this.o.isEmpty()) {
            ((m) AbstractC20011rK.e(this.r)).release();
            this.r = null;
        }
    }

    private void D() {
        DB7 it = AbstractC14535i43.P(this.p).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).b(null);
        }
    }

    private void E() {
        DB7 it = AbstractC14535i43.P(this.o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    private void G(DrmSession drmSession, h.a aVar) {
        drmSession.b(aVar);
        if (this.m != -9223372036854775807L) {
            drmSession.b(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public DrmSession t(Looper looper, h.a aVar, X x, boolean z) {
        List listY;
        B(looper);
        DrmInitData drmInitData = x.o;
        if (drmInitData == null) {
            return A(AbstractC24462yf4.k(x.l), z);
        }
        DefaultDrmSession defaultDrmSessionX = null;
        Object[] objArr = 0;
        if (this.x == null) {
            listY = y((DrmInitData) AbstractC20011rK.e(drmInitData), this.c, false);
            if (listY.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.c);
                AbstractC18815pI3.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new l(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listY = null;
        }
        if (this.g) {
            Iterator it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession defaultDrmSession = (DefaultDrmSession) it.next();
                if (AbstractC9683aN7.c(defaultDrmSession.a, listY)) {
                    defaultDrmSessionX = defaultDrmSession;
                    break;
                }
            }
        } else {
            defaultDrmSessionX = this.t;
        }
        if (defaultDrmSessionX == null) {
            defaultDrmSessionX = x(listY, false, aVar, z);
            if (!this.g) {
                this.t = defaultDrmSessionX;
            }
            this.n.add(defaultDrmSessionX);
        } else {
            defaultDrmSessionX.a(aVar);
        }
        return defaultDrmSessionX;
    }

    private static boolean u(DrmSession drmSession) {
        return drmSession.getState() == 1 && (AbstractC9683aN7.a < 19 || (((DrmSession.DrmSessionException) AbstractC20011rK.e(drmSession.e())).getCause() instanceof ResourceBusyException));
    }

    private boolean v(DrmInitData drmInitData) {
        if (this.x != null) {
            return true;
        }
        if (y(drmInitData, this.c, true).isEmpty()) {
            if (drmInitData.d != 1 || !drmInitData.e(0).c(AbstractC9350Zo0.b)) {
                return false;
            }
            AbstractC18815pI3.k("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.c);
        }
        String str = drmInitData.c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? AbstractC9683aN7.a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private DefaultDrmSession w(List list, boolean z, h.a aVar) {
        AbstractC20011rK.e(this.r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.c, this.r, this.j, this.l, list, this.w, this.i | z, z, this.x, this.f, this.e, (Looper) AbstractC20011rK.e(this.u), this.k, (C15493jg5) AbstractC20011rK.e(this.y));
        defaultDrmSession.a(aVar);
        if (this.m != -9223372036854775807L) {
            defaultDrmSession.a(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession x(List list, boolean z, h.a aVar, boolean z2) {
        DefaultDrmSession defaultDrmSessionW = w(list, z, aVar);
        if (u(defaultDrmSessionW) && !this.p.isEmpty()) {
            D();
            G(defaultDrmSessionW, aVar);
            defaultDrmSessionW = w(list, z, aVar);
        }
        if (!u(defaultDrmSessionW) || !z2 || this.o.isEmpty()) {
            return defaultDrmSessionW;
        }
        E();
        if (!this.p.isEmpty()) {
            D();
        }
        G(defaultDrmSessionW, aVar);
        return w(list, z, aVar);
    }

    private static List y(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.d);
        for (int i = 0; i < drmInitData.d; i++) {
            DrmInitData.SchemeData schemeDataE = drmInitData.e(i);
            if ((schemeDataE.c(uuid) || (AbstractC9350Zo0.c.equals(uuid) && schemeDataE.c(AbstractC9350Zo0.b))) && (schemeDataE.e != null || z)) {
                arrayList.add(schemeDataE);
            }
        }
        return arrayList;
    }

    private synchronized void z(Looper looper) {
        try {
            Looper looper2 = this.u;
            if (looper2 == null) {
                this.u = looper;
                this.v = new Handler(looper);
            } else {
                AbstractC20011rK.g(looper2 == looper);
                AbstractC20011rK.e(this.v);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void F(int i, byte[] bArr) {
        AbstractC20011rK.g(this.n.isEmpty());
        if (i == 1 || i == 3) {
            AbstractC20011rK.e(bArr);
        }
        this.w = i;
        this.x = bArr;
    }

    @Override // com.google.android.exoplayer2.drm.i
    public int a(X x) {
        int iG = ((m) AbstractC20011rK.e(this.r)).g();
        DrmInitData drmInitData = x.o;
        if (drmInitData != null) {
            if (v(drmInitData)) {
                return iG;
            }
            return 1;
        }
        if (AbstractC9683aN7.z0(this.h, AbstractC24462yf4.k(x.l)) != -1) {
            return iG;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.i
    public void b(Looper looper, C15493jg5 c15493jg5) {
        z(looper);
        this.y = c15493jg5;
    }

    @Override // com.google.android.exoplayer2.drm.i
    public DrmSession c(h.a aVar, X x) {
        AbstractC20011rK.g(this.q > 0);
        AbstractC20011rK.i(this.u);
        return t(this.u, aVar, x, true);
    }

    @Override // com.google.android.exoplayer2.drm.i
    public i.b d(h.a aVar, X x) {
        AbstractC20011rK.g(this.q > 0);
        AbstractC20011rK.i(this.u);
        e eVar = new e(aVar);
        eVar.e(x);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.i
    public final void r() {
        int i = this.q;
        this.q = i + 1;
        if (i != 0) {
            return;
        }
        if (this.r == null) {
            m mVarA = this.d.a(this.c);
            this.r = mVarA;
            mVarA.e(new c());
        } else if (this.m != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                ((DefaultDrmSession) this.n.get(i2)).a(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.i
    public final void release() {
        int i = this.q - 1;
        this.q = i;
        if (i != 0) {
            return;
        }
        if (this.m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.n);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).b(null);
            }
        }
        E();
        C();
    }

    private DefaultDrmSessionManager(UUID uuid, m.c cVar, p pVar, HashMap map, boolean z, int[] iArr, boolean z2, com.google.android.exoplayer2.upstream.j jVar, long j) {
        AbstractC20011rK.e(uuid);
        AbstractC20011rK.b(!AbstractC9350Zo0.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.c = uuid;
        this.d = cVar;
        this.e = pVar;
        this.f = map;
        this.g = z;
        this.h = iArr;
        this.i = z2;
        this.k = jVar;
        this.j = new f(this);
        this.l = new g();
        this.w = 0;
        this.n = new ArrayList();
        this.o = AbstractC3895Cu6.h();
        this.p = AbstractC3895Cu6.h();
        this.m = j;
    }
}
