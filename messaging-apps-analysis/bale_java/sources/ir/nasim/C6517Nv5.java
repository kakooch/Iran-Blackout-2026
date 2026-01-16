package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.Nv5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C6517Nv5 {
    private final ArrayList a;
    private final FC6 b;
    private volatile Object c;
    private final boolean d;
    private volatile Exception e;
    private volatile boolean f;
    private volatile InterfaceC6990Pv5 g;

    /* renamed from: ir.nasim.Nv5$c */
    interface c {
        void a(Object obj);

        void onError(Exception exc);
    }

    public C6517Nv5(InterfaceC6990Pv5 interfaceC6990Pv5) {
        this(false, interfaceC6990Pv5);
    }

    private void B() {
        if (this.a.size() > 0) {
            this.b.a(new Runnable() { // from class: ir.nasim.rv5
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.P();
                }
            });
        }
    }

    private void D(InterfaceC6990Pv5 interfaceC6990Pv5) {
        interfaceC6990Pv5.a(new C7234Qv5(this));
    }

    public static C6517Nv5 F(Exception exc) {
        return new C6517Nv5(exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void M(InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5, final Object obj) {
        C6517Nv5 c6517Nv5 = (C6517Nv5) interfaceC17569nB2.apply(obj);
        c6517Nv5.k0();
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Bv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                c7234Qv5.b(obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.Cv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj2) {
                c7234Qv5.a((Exception) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(C6517Nv5 c6517Nv5, final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.pv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6517Nv5.M(interfaceC17569nB2, c7234Qv5, obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.qv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        if (this.e != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    ((c) it.next()).onError(this.e);
                } catch (Exception e) {
                    C19406qI3.d("Promise", e);
                }
            }
        } else {
            Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                try {
                    ((c) it2.next()).a(this.c);
                } catch (Exception e2) {
                    C19406qI3.d("Promise", e2);
                }
            }
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(InterfaceC24449ye1 interfaceC24449ye1) {
        interfaceC24449ye1.apply(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5, Exception exc) {
        C6517Nv5 c6517Nv5 = (C6517Nv5) interfaceC17569nB2.apply(exc);
        if (c6517Nv5 == null) {
            c7234Qv5.b(null);
            return;
        }
        c6517Nv5.k0();
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Dv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.b(obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.Ev5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(C6517Nv5 c6517Nv5, final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.yv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.b(obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.Av5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6517Nv5.U(interfaceC17569nB2, c7234Qv5, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(C6517Nv5 c6517Nv5, final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.Iv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6517Nv5.Z(interfaceC17569nB2, c7234Qv5, obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.Jv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5, Object obj) {
        try {
            C6517Nv5 c6517Nv5 = (C6517Nv5) interfaceC17569nB2.apply(obj);
            if (c6517Nv5 == null) {
                c7234Qv5.b(null);
                return;
            }
            c6517Nv5.k0();
            c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.uv5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    c7234Qv5.b(obj2);
                }
            });
            c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.vv5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj2) {
                    c7234Qv5.a((Exception) obj2);
                }
            });
        } catch (Exception e) {
            c7234Qv5.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(InterfaceC17569nB2 interfaceC17569nB2, C7234Qv5 c7234Qv5, Object obj) {
        try {
            c7234Qv5.d(interfaceC17569nB2.apply(obj));
        } catch (Exception e) {
            c7234Qv5.c(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d0(C6517Nv5 c6517Nv5, final InterfaceC17569nB2 interfaceC17569nB2, final C7234Qv5 c7234Qv5) {
        c6517Nv5.m0(new InterfaceC24449ye1() { // from class: ir.nasim.wv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C6517Nv5.b0(interfaceC17569nB2, c7234Qv5, obj);
            }
        });
        c6517Nv5.E(new InterfaceC24449ye1() { // from class: ir.nasim.xv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(InterfaceC24449ye1 interfaceC24449ye1) {
        interfaceC24449ye1.apply(this.c);
    }

    public static C6517Nv5 l0(Object obj) {
        return new C6517Nv5(obj);
    }

    public C6517Nv5 A(final InterfaceC17569nB2 interfaceC17569nB2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Kv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C6517Nv5.O(this.a, interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    synchronized void C(Exception exc) {
        if (this.f) {
            C19406qI3.b("Promise", "Promise already completed!");
            C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        } else if (exc == null) {
            C19406qI3.b("Promise", "Error can't be null");
            C19406qI3.d("NON_FATAL_EXCEPTION", exc);
        } else {
            this.f = true;
            this.e = exc;
            B();
        }
    }

    public synchronized C6517Nv5 E(final InterfaceC24449ye1 interfaceC24449ye1) {
        try {
            if (!this.f) {
                this.a.add(new b(interfaceC24449ye1));
            } else if (this.e != null) {
                this.b.a(new Runnable() { // from class: ir.nasim.Fv5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.Q(interfaceC24449ye1);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public C6517Nv5 G(final InterfaceC17569nB2 interfaceC17569nB2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Mv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C6517Nv5.V(this.a, interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    public C6517Nv5 H(final InterfaceC17569nB2 interfaceC17569nB2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Hv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C6517Nv5.W(this.a, interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    public C6517Nv5 h0(final InterfaceC17569nB2 interfaceC17569nB2) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.Lv5
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                C6517Nv5.d0(this.a, interfaceC17569nB2, c7234Qv5);
            }
        });
    }

    public C6517Nv5 i0(final C7234Qv5 c7234Qv5) {
        m0(new InterfaceC24449ye1() { // from class: ir.nasim.sv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.b(obj);
            }
        });
        E(new InterfaceC24449ye1() { // from class: ir.nasim.tv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                c7234Qv5.a((Exception) obj);
            }
        });
        return this;
    }

    synchronized void j0(Object obj) {
        if (this.f) {
            throw new RuntimeException("Promise " + this + " already completed!");
        }
        this.f = true;
        this.c = obj;
        B();
    }

    public synchronized void k0() {
        InterfaceC6990Pv5 interfaceC6990Pv5 = this.g;
        if (!this.f && this.d && interfaceC6990Pv5 != null) {
            this.g = null;
            D(interfaceC6990Pv5);
        }
    }

    public synchronized C6517Nv5 m0(final InterfaceC24449ye1 interfaceC24449ye1) {
        try {
            if (!this.f) {
                this.a.add(new a(interfaceC24449ye1));
            } else if (this.e == null) {
                this.b.a(new Runnable() { // from class: ir.nasim.Gv5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g0(interfaceC24449ye1);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    synchronized void n0(Exception exc) {
        if (this.f) {
            return;
        }
        C(exc);
    }

    synchronized void o0(Object obj) {
        if (this.f) {
            return;
        }
        j0(obj);
    }

    public C6517Nv5 z(final InterfaceC3273Ae1 interfaceC3273Ae1) {
        m0(new InterfaceC24449ye1() { // from class: ir.nasim.ov5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC3273Ae1.apply(obj, null);
            }
        });
        E(new InterfaceC24449ye1() { // from class: ir.nasim.zv5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                interfaceC3273Ae1.apply(null, (Exception) obj);
            }
        });
        return this;
    }

    public C6517Nv5(boolean z, InterfaceC6990Pv5 interfaceC6990Pv5) {
        this.a = new ArrayList();
        this.b = AbstractC7407Ro7.a();
        this.d = z;
        if (z) {
            this.g = interfaceC6990Pv5;
        } else {
            D(interfaceC6990Pv5);
        }
    }

    private C6517Nv5(Object obj) {
        this.a = new ArrayList();
        this.b = AbstractC7407Ro7.a();
        this.c = obj;
        this.e = null;
        this.f = true;
        this.d = false;
    }

    private C6517Nv5(Exception exc) {
        this.a = new ArrayList();
        this.b = AbstractC7407Ro7.a();
        this.c = null;
        this.e = exc;
        this.f = true;
        this.d = false;
    }

    /* renamed from: ir.nasim.Nv5$a */
    class a implements c {
        final /* synthetic */ InterfaceC24449ye1 a;

        a(InterfaceC24449ye1 interfaceC24449ye1) {
            this.a = interfaceC24449ye1;
        }

        @Override // ir.nasim.C6517Nv5.c
        public void a(Object obj) {
            this.a.apply(obj);
        }

        @Override // ir.nasim.C6517Nv5.c
        public void onError(Exception exc) {
        }
    }

    /* renamed from: ir.nasim.Nv5$b */
    class b implements c {
        final /* synthetic */ InterfaceC24449ye1 a;

        b(InterfaceC24449ye1 interfaceC24449ye1) {
            this.a = interfaceC24449ye1;
        }

        @Override // ir.nasim.C6517Nv5.c
        public void onError(Exception exc) {
            this.a.apply(exc);
        }

        @Override // ir.nasim.C6517Nv5.c
        public void a(Object obj) {
        }
    }
}
