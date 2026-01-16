package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.m;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.j;
import ir.nasim.AbstractC12174e98;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9350Zo0;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C15493jg5;
import ir.nasim.C6420Nn1;
import ir.nasim.InterfaceC23269we1;
import ir.nasim.InterfaceC7698Sv1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
class DefaultDrmSession implements DrmSession {
    public final List a;
    private final m b;
    private final a c;
    private final b d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final HashMap h;
    private final C6420Nn1 i;
    private final com.google.android.exoplayer2.upstream.j j;
    private final C15493jg5 k;
    final p l;
    final UUID m;
    final e n;
    private int o;
    private int p;
    private HandlerThread q;
    private c r;
    private InterfaceC7698Sv1 s;
    private DrmSession.DrmSessionException t;
    private byte[] u;
    private byte[] v;
    private m.a w;
    private m.d x;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable th) {
            super(th);
        }
    }

    public interface a {
        void a(Exception exc, boolean z);

        void b(DefaultDrmSession defaultDrmSession);

        void c();
    }

    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i);

        void b(DefaultDrmSession defaultDrmSession, int i);
    }

    private class c extends Handler {
        private boolean a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.b) {
                return false;
            }
            int i = dVar.e + 1;
            dVar.e = i;
            if (i > DefaultDrmSession.this.j.b(3)) {
                return false;
            }
            long jA = DefaultDrmSession.this.j.a(new j.c(new LoadEventInfo(dVar.a, mediaDrmCallbackException.a, mediaDrmCallbackException.b, mediaDrmCallbackException.c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.c, mediaDrmCallbackException.d), new MediaLoadData(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.e));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b(int i, Object obj, boolean z) {
            obtainMessage(i, new d(LoadEventInfo.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable thA;
            d dVar = (d) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    thA = defaultDrmSession.l.a(defaultDrmSession.m, (m.d) dVar.d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    thA = defaultDrmSession2.l.b(defaultDrmSession2.m, (m.a) dVar.d);
                }
            } catch (MediaDrmCallbackException e) {
                boolean zA = a(message, e);
                thA = e;
                if (zA) {
                    return;
                }
            } catch (Exception e2) {
                AbstractC18815pI3.l("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                thA = e2;
            }
            DefaultDrmSession.this.j.d(dVar.a);
            synchronized (this) {
                try {
                    if (!this.a) {
                        DefaultDrmSession.this.n.obtainMessage(message.what, Pair.create(dVar.d, thA)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    private static final class d {
        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;

        public d(long j, boolean z, long j2, Object obj) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.C(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.w(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, m mVar, a aVar, b bVar, List list, int i, boolean z, boolean z2, byte[] bArr, HashMap map, p pVar, Looper looper, com.google.android.exoplayer2.upstream.j jVar, C15493jg5 c15493jg5) {
        if (i == 1 || i == 3) {
            AbstractC20011rK.e(bArr);
        }
        this.m = uuid;
        this.c = aVar;
        this.d = bVar;
        this.b = mVar;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.v = bArr;
            this.a = null;
        } else {
            this.a = Collections.unmodifiableList((List) AbstractC20011rK.e(list));
        }
        this.h = map;
        this.l = pVar;
        this.i = new C6420Nn1();
        this.j = jVar;
        this.k = c15493jg5;
        this.o = 2;
        this.n = new e(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj, Object obj2) {
        if (obj == this.x) {
            if (this.o == 2 || s()) {
                this.x = null;
                if (obj2 instanceof Exception) {
                    this.c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.b.f((byte[]) obj2);
                    this.c.c();
                } catch (Exception e2) {
                    this.c.a(e2, true);
                }
            }
        }
    }

    private boolean D() {
        if (s()) {
            return true;
        }
        try {
            byte[] bArrC = this.b.c();
            this.u = bArrC;
            this.b.h(bArrC, this.k);
            this.s = this.b.i(this.u);
            final int i = 3;
            this.o = 3;
            o(new InterfaceC23269we1() { // from class: com.google.android.exoplayer2.drm.b
                @Override // ir.nasim.InterfaceC23269we1
                public final void accept(Object obj) {
                    ((h.a) obj).k(i);
                }
            });
            AbstractC20011rK.e(this.u);
            return true;
        } catch (NotProvisionedException unused) {
            this.c.b(this);
            return false;
        } catch (Exception e2) {
            v(e2, 1);
            return false;
        }
    }

    private void E(byte[] bArr, int i, boolean z) {
        try {
            this.w = this.b.m(bArr, this.a, i, this.h);
            ((c) AbstractC9683aN7.j(this.r)).b(1, AbstractC20011rK.e(this.w), z);
        } catch (Exception e2) {
            x(e2, true);
        }
    }

    private boolean G() {
        try {
            this.b.d(this.u, this.v);
            return true;
        } catch (Exception e2) {
            v(e2, 1);
            return false;
        }
    }

    private void o(InterfaceC23269we1 interfaceC23269we1) {
        Iterator it = this.i.W0().iterator();
        while (it.hasNext()) {
            interfaceC23269we1.accept((h.a) it.next());
        }
    }

    private void p(boolean z) {
        if (this.g) {
            return;
        }
        byte[] bArr = (byte[]) AbstractC9683aN7.j(this.u);
        int i = this.e;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.v == null || G()) {
                    E(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            AbstractC20011rK.e(this.v);
            AbstractC20011rK.e(this.u);
            E(this.v, 3, z);
            return;
        }
        if (this.v == null) {
            E(bArr, 1, z);
            return;
        }
        if (this.o == 4 || G()) {
            long jQ = q();
            if (this.e != 0 || jQ > 60) {
                if (jQ <= 0) {
                    v(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.o = 4;
                    o(new InterfaceC23269we1() { // from class: ir.nasim.KD1
                        @Override // ir.nasim.InterfaceC23269we1
                        public final void accept(Object obj) {
                            ((h.a) obj).j();
                        }
                    });
                    return;
                }
            }
            AbstractC18815pI3.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jQ);
            E(bArr, 2, z);
        }
    }

    private long q() {
        if (!AbstractC9350Zo0.d.equals(this.m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) AbstractC20011rK.e(AbstractC12174e98.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private boolean s() {
        int i = this.o;
        return i == 3 || i == 4;
    }

    private void v(final Exception exc, int i) {
        this.t = new DrmSession.DrmSessionException(exc, j.a(exc, i));
        AbstractC18815pI3.d("DefaultDrmSession", "DRM session error", exc);
        o(new InterfaceC23269we1() { // from class: com.google.android.exoplayer2.drm.c
            @Override // ir.nasim.InterfaceC23269we1
            public final void accept(Object obj) {
                ((h.a) obj).l(exc);
            }
        });
        if (this.o != 4) {
            this.o = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj, Object obj2) {
        if (obj == this.w && s()) {
            this.w = null;
            if (obj2 instanceof Exception) {
                x((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.e == 3) {
                    this.b.l((byte[]) AbstractC9683aN7.j(this.v), bArr);
                    o(new InterfaceC23269we1() { // from class: ir.nasim.LD1
                        @Override // ir.nasim.InterfaceC23269we1
                        public final void accept(Object obj3) {
                            ((h.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrL = this.b.l(this.u, bArr);
                int i = this.e;
                if ((i == 2 || (i == 0 && this.v != null)) && bArrL != null && bArrL.length != 0) {
                    this.v = bArrL;
                }
                this.o = 4;
                o(new InterfaceC23269we1() { // from class: ir.nasim.MD1
                    @Override // ir.nasim.InterfaceC23269we1
                    public final void accept(Object obj3) {
                        ((h.a) obj3).h();
                    }
                });
            } catch (Exception e2) {
                x(e2, true);
            }
        }
    }

    private void x(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.c.b(this);
        } else {
            v(exc, z ? 1 : 2);
        }
    }

    private void y() {
        if (this.e == 0 && this.o == 4) {
            AbstractC9683aN7.j(this.u);
            p(false);
        }
    }

    public void A() {
        if (D()) {
            p(true);
        }
    }

    public void B(Exception exc, boolean z) {
        v(exc, z ? 1 : 3);
    }

    public void F() {
        this.x = this.b.b();
        ((c) AbstractC9683aN7.j(this.r)).b(0, AbstractC20011rK.e(this.x), true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(h.a aVar) {
        if (this.p < 0) {
            AbstractC18815pI3.c("DefaultDrmSession", "Session reference count less than zero: " + this.p);
            this.p = 0;
        }
        if (aVar != null) {
            this.i.f(aVar);
        }
        int i = this.p + 1;
        this.p = i;
        if (i == 1) {
            AbstractC20011rK.g(this.o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.q = handlerThread;
            handlerThread.start();
            this.r = new c(this.q.getLooper());
            if (D()) {
                p(true);
            }
        } else if (aVar != null && s() && this.i.h(aVar) == 1) {
            aVar.k(this.o);
        }
        this.d.a(this, this.p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(h.a aVar) {
        int i = this.p;
        if (i <= 0) {
            AbstractC18815pI3.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.p = i2;
        if (i2 == 0) {
            this.o = 0;
            ((e) AbstractC9683aN7.j(this.n)).removeCallbacksAndMessages(null);
            ((c) AbstractC9683aN7.j(this.r)).c();
            this.r = null;
            ((HandlerThread) AbstractC9683aN7.j(this.q)).quit();
            this.q = null;
            this.s = null;
            this.t = null;
            this.w = null;
            this.x = null;
            byte[] bArr = this.u;
            if (bArr != null) {
                this.b.k(bArr);
                this.u = null;
            }
        }
        if (aVar != null) {
            this.i.i(aVar);
            if (this.i.h(aVar) == 0) {
                aVar.m();
            }
        }
        this.d.b(this, this.p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return this.m;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException e() {
        if (this.o == 1) {
            return this.t;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final InterfaceC7698Sv1 f() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map h() {
        byte[] bArr = this.u;
        if (bArr == null) {
            return null;
        }
        return this.b.a(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean i(String str) {
        return this.b.j((byte[]) AbstractC20011rK.i(this.u), str);
    }

    public boolean r(byte[] bArr) {
        return Arrays.equals(this.u, bArr);
    }

    public void z(int i) {
        if (i != 2) {
            return;
        }
        y();
    }
}
