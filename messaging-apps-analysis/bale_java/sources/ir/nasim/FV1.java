package ir.nasim;

/* loaded from: classes5.dex */
class FV1 {
    private Long e;
    private Long g;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean f = false;

    FV1() {
    }

    public synchronized void a() {
        this.a = false;
    }

    public synchronized void b(Long l) {
        this.c = true;
        this.e = l;
    }

    public synchronized void c(Long l, Long l2) {
        this.c = true;
        this.g = l;
        this.e = l2;
    }

    public synchronized void d(Long l) {
        this.c = true;
        this.g = l;
    }

    public synchronized void e() {
        this.c = true;
        this.e = null;
        this.g = null;
        this.f = true;
        this.a = false;
        this.d = true;
        this.b = false;
    }

    public synchronized void f() {
        this.b = false;
    }

    public synchronized Long g() {
        return this.e;
    }

    public synchronized Long h() {
        return this.g;
    }

    public synchronized boolean i() {
        return this.f;
    }

    public synchronized boolean j() {
        return this.c;
    }

    public synchronized void k() {
        this.d = true;
        this.e = null;
    }

    public synchronized void l(Long l) {
        this.e = l;
    }

    public synchronized void m() {
        this.f = true;
        this.g = null;
    }

    public synchronized void n(Long l) {
        this.g = l;
    }

    public synchronized boolean o() {
        if (!this.c) {
            return false;
        }
        if (this.d) {
            return false;
        }
        if (this.b) {
            return false;
        }
        this.b = true;
        return true;
    }

    public synchronized boolean p() {
        if (!this.c) {
            return false;
        }
        if (this.f) {
            return false;
        }
        if (this.a) {
            return false;
        }
        this.a = true;
        return true;
    }

    public synchronized void q() {
        this.c = false;
        this.f = true;
        this.a = false;
        this.b = false;
        this.d = false;
        this.e = null;
        this.g = null;
    }

    public synchronized void r() {
        this.c = false;
        this.f = false;
        this.a = false;
        this.b = false;
        this.d = false;
        this.e = null;
        this.g = null;
    }

    public synchronized void s() {
        this.c = false;
        this.f = false;
        this.a = false;
        this.b = false;
        this.d = true;
        this.e = null;
        this.g = null;
    }
}
