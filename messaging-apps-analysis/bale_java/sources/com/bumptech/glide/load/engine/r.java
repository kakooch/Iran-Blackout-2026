package com.bumptech.glide.load.engine;

import ir.nasim.AbstractC18254oL6;
import ir.nasim.AbstractC21437tf2;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.DW5;
import ir.nasim.InterfaceC20850si5;

/* loaded from: classes2.dex */
final class r implements DW5, AbstractC21437tf2.f {
    private static final InterfaceC20850si5 e = AbstractC21437tf2.d(20, new a());
    private final AbstractC18254oL6 a = AbstractC18254oL6.a();
    private DW5 b;
    private boolean c;
    private boolean d;

    class a implements AbstractC21437tf2.d {
        a() {
        }

        @Override // ir.nasim.AbstractC21437tf2.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r create() {
            return new r();
        }
    }

    r() {
    }

    private void c(DW5 dw5) {
        this.d = false;
        this.c = true;
        this.b = dw5;
    }

    static r d(DW5 dw5) {
        r rVar = (r) AbstractC3322Aj5.d((r) e.b());
        rVar.c(dw5);
        return rVar;
    }

    private void e() {
        this.b = null;
        e.a(this);
    }

    @Override // ir.nasim.DW5
    public synchronized void a() {
        this.a.c();
        this.d = true;
        if (!this.c) {
            this.b.a();
            e();
        }
    }

    @Override // ir.nasim.DW5
    public Class b() {
        return this.b.b();
    }

    @Override // ir.nasim.DW5
    public int f() {
        return this.b.f();
    }

    synchronized void g() {
        this.a.c();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            a();
        }
    }

    @Override // ir.nasim.DW5
    public Object get() {
        return this.b.get();
    }

    @Override // ir.nasim.AbstractC21437tf2.f
    public AbstractC18254oL6 h() {
        return this.a;
    }
}
