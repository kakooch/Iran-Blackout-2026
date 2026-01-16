package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.rH2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C19987rH2 {
    private final InterfaceC9624aH2 a;
    private final Handler b;
    private final List c;
    final com.bumptech.glide.h d;
    private final InterfaceC13106fg0 e;
    private boolean f;
    private boolean g;
    private boolean h;
    private com.bumptech.glide.g i;
    private a j;
    private boolean k;
    private a l;
    private Bitmap m;
    private InterfaceC15645jv7 n;
    private a o;
    private int p;
    private int q;
    private int r;

    /* renamed from: ir.nasim.rH2$a */
    static class a extends AbstractC4151Dx1 {
        private final Handler d;
        final int e;
        private final long f;
        private Bitmap g;

        a(Handler handler, int i, long j) {
            this.d = handler;
            this.e = i;
            this.f = j;
        }

        Bitmap b() {
            return this.g;
        }

        @Override // ir.nasim.InterfaceC21549tj7
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(Bitmap bitmap, InterfaceC22855vv7 interfaceC22855vv7) {
            this.g = bitmap;
            this.d.sendMessageAtTime(this.d.obtainMessage(1, this), this.f);
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void g(Drawable drawable) {
            this.g = null;
        }
    }

    /* renamed from: ir.nasim.rH2$b */
    public interface b {
        void a();
    }

    /* renamed from: ir.nasim.rH2$c */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                C19987rH2.this.m((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            C19987rH2.this.d.o((a) message.obj);
            return false;
        }
    }

    C19987rH2(com.bumptech.glide.b bVar, InterfaceC9624aH2 interfaceC9624aH2, int i, int i2, InterfaceC15645jv7 interfaceC15645jv7, Bitmap bitmap) {
        this(bVar.f(), com.bumptech.glide.b.t(bVar.h()), interfaceC9624aH2, null, i(com.bumptech.glide.b.t(bVar.h()), i, i2), interfaceC15645jv7, bitmap);
    }

    private static InterfaceC14373ho3 g() {
        return new C22456vG4(Double.valueOf(Math.random()));
    }

    private static com.bumptech.glide.g i(com.bumptech.glide.h hVar, int i, int i2) {
        return hVar.d().b(((C20107rU5) ((C20107rU5) C20107rU5.E0(AbstractC23175wU1.b).z0(true)).p0(true)).c0(i, i2));
    }

    private void l() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            AbstractC3322Aj5.a(this.o == null, "Pending target must be null when starting from the first frame");
            this.a.e();
            this.h = false;
        }
        a aVar = this.o;
        if (aVar != null) {
            this.o = null;
            m(aVar);
            return;
        }
        this.g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + this.a.d();
        this.a.a();
        this.l = new a(this.b, this.a.f(), jUptimeMillis);
        this.i.b(C20107rU5.F0(g())).Y0(this.a).M0(this.l);
    }

    private void n() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.c(bitmap);
            this.m = null;
        }
    }

    private void p() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.k = false;
        l();
    }

    private void q() {
        this.f = false;
    }

    void a() {
        this.c.clear();
        n();
        q();
        a aVar = this.j;
        if (aVar != null) {
            this.d.o(aVar);
            this.j = null;
        }
        a aVar2 = this.l;
        if (aVar2 != null) {
            this.d.o(aVar2);
            this.l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.d.o(aVar3);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    Bitmap c() {
        a aVar = this.j;
        return aVar != null ? aVar.b() : this.m;
    }

    int d() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.e;
        }
        return -1;
    }

    Bitmap e() {
        return this.m;
    }

    int f() {
        return this.a.b();
    }

    int h() {
        return this.r;
    }

    int j() {
        return this.a.g() + this.p;
    }

    int k() {
        return this.q;
    }

    void m(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.o = aVar;
                return;
            }
        }
        if (aVar.b() != null) {
            n();
            a aVar2 = this.j;
            this.j = aVar;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                ((b) this.c.get(size)).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    void o(InterfaceC15645jv7 interfaceC15645jv7, Bitmap bitmap) {
        this.n = (InterfaceC15645jv7) AbstractC3322Aj5.d(interfaceC15645jv7);
        this.m = (Bitmap) AbstractC3322Aj5.d(bitmap);
        this.i = this.i.b(new C20107rU5().u0(interfaceC15645jv7));
        this.p = YM7.i(bitmap);
        this.q = bitmap.getWidth();
        this.r = bitmap.getHeight();
    }

    void r(b bVar) {
        if (this.k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.c.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.c.isEmpty();
        this.c.add(bVar);
        if (zIsEmpty) {
            p();
        }
    }

    void s(b bVar) {
        this.c.remove(bVar);
        if (this.c.isEmpty()) {
            q();
        }
    }

    C19987rH2(InterfaceC13106fg0 interfaceC13106fg0, com.bumptech.glide.h hVar, InterfaceC9624aH2 interfaceC9624aH2, Handler handler, com.bumptech.glide.g gVar, InterfaceC15645jv7 interfaceC15645jv7, Bitmap bitmap) {
        this.c = new ArrayList();
        this.d = hVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.e = interfaceC13106fg0;
        this.b = handler;
        this.i = gVar;
        this.a = interfaceC9624aH2;
        o(interfaceC15645jv7, bitmap);
    }
}
