package com.bumptech.glide.load.engine;

import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.InterfaceC14373ho3;

/* loaded from: classes2.dex */
class o implements DW5 {
    private final boolean a;
    private final boolean b;
    private final DW5 c;
    private final a d;
    private final InterfaceC14373ho3 e;
    private int f;
    private boolean g;

    interface a {
        void b(InterfaceC14373ho3 interfaceC14373ho3, o oVar);
    }

    o(DW5 dw5, boolean z, boolean z2, InterfaceC14373ho3 interfaceC14373ho3, a aVar) {
        this.c = (DW5) AbstractC3322Aj5.d(dw5);
        this.a = z;
        this.b = z2;
        this.e = interfaceC14373ho3;
        this.d = (a) AbstractC3322Aj5.d(aVar);
    }

    @Override // ir.nasim.DW5
    public synchronized void a() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.a();
        }
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return this.c.b();
    }

    synchronized void c() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    DW5 d() {
        return this.c;
    }

    boolean e() {
        return this.a;
    }

    @Override // ir.nasim.DW5
    public int f() {
        return this.c.f();
    }

    void g() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.d.b(this.e, this);
        }
    }

    @Override // ir.nasim.DW5
    public Object get() {
        return this.c.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}
