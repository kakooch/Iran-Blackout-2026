package ir.nasim;

import java.util.HashMap;

/* renamed from: ir.nasim.xp4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23972xp4 {
    String a = "NasimDispatcher";
    private final Object b = new Object();
    private final HashMap c = new HashMap();
    private final HashMap d = new HashMap();
    private final C3939Cz5 e = new C3939Cz5();
    private final C4407Ez5[] f;
    private InterfaceC19171pt7 g;

    public C23972xp4(String str, EnumC9950ap7 enumC9950ap7, int i, InterfaceC19171pt7 interfaceC19171pt7) {
        this.g = interfaceC19171pt7;
        this.f = new C4407Ez5[i];
        InterfaceC24449ye1 interfaceC24449ye1 = new InterfaceC24449ye1() { // from class: ir.nasim.up4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.d((R92) obj);
            }
        };
        int i2 = 0;
        while (true) {
            C4407Ez5[] c4407Ez5Arr = this.f;
            if (i2 >= c4407Ez5Arr.length) {
                return;
            }
            c4407Ez5Arr[i2] = new C4407Ez5(str + "_" + i2, enumC9950ap7, this.e, interfaceC24449ye1, null);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(C10122b7 c10122b7) {
        c10122b7.b().d(XJ6.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(C10122b7 c10122b7) {
        c10122b7.b().d(XJ6.a);
    }

    private void g(C10122b7 c10122b7, boolean z) {
        R92[] r92ArrA;
        c10122b7.i();
        synchronized (this.b) {
            this.d.remove(c10122b7.e());
            this.c.remove(c10122b7.e());
            r92ArrA = c10122b7.c().a();
        }
        for (R92 r92 : r92ArrA) {
            if (r92.d() != null) {
                r92.d().d(new MA1(r92.b()));
            }
        }
        if (!z || c10122b7.f().f() == null) {
            return;
        }
        c10122b7.f().f().a(c10122b7.f(), c10122b7.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(R92 r92) {
        InterfaceC19171pt7 interfaceC19171pt7;
        C10122b7 c10122b7C = r92.c();
        long jA = AbstractC13372g7.a();
        if (c10122b7C.a() == null) {
            if (r92.b() == C12485eh5.a) {
                return;
            }
            try {
                K6 k6C = c10122b7C.f().c();
                k6C.i(c10122b7C.e(), new U6(c10122b7C));
                AbstractC7407Ro7.c(k6C.e());
                try {
                    k6C.o();
                    AbstractC7407Ro7.b();
                    c10122b7C.h(k6C);
                } finally {
                }
            } catch (Exception e) {
                C19406qI3.c(this.a, "processEnvelope", e);
                if (r92.d() != null) {
                    r92.d().d(new MA1("Unable to create actor"));
                    return;
                }
                return;
            }
        }
        try {
            try {
                if (r92.b() != XJ6.a) {
                    if (r92.b() == C12485eh5.a) {
                        C19406qI3.a(this.a, "nasim get poison pill message, so kill actor: " + c10122b7C.e(), new Object[0]);
                        AbstractC7407Ro7.c(c10122b7C.a().e());
                        try {
                            c10122b7C.a().n();
                            AbstractC7407Ro7.b();
                            g(c10122b7C, false);
                        } finally {
                        }
                    } else {
                        c10122b7C.a().h(r92.b(), r92.d());
                    }
                }
                interfaceC19171pt7 = this.g;
                if (interfaceC19171pt7 == null) {
                    return;
                }
            } catch (Exception e2) {
                InterfaceC19171pt7 interfaceC19171pt72 = this.g;
                if (interfaceC19171pt72 != null) {
                    interfaceC19171pt72.a(c10122b7C.b(), r92, e2);
                } else {
                    C19406qI3.b(this.a, "die: but traceInterface is null!");
                }
                AbstractC7407Ro7.c(c10122b7C.a().e());
                try {
                    c10122b7C.a().n();
                    AbstractC7407Ro7.b();
                    C19406qI3.c(this.a, "die: " + e2.getMessage(), e2);
                    g(c10122b7C, true);
                    interfaceC19171pt7 = this.g;
                    if (interfaceC19171pt7 == null) {
                        return;
                    }
                } finally {
                }
            }
            interfaceC19171pt7.c(r92, AbstractC13372g7.a() - jA);
        } catch (Throwable th) {
            InterfaceC19171pt7 interfaceC19171pt73 = this.g;
            if (interfaceC19171pt73 != null) {
                interfaceC19171pt73.c(r92, AbstractC13372g7.a() - jA);
            }
            throw th;
        }
    }

    public final C9528a7 i(String str, C4614Fw5 c4614Fw5) {
        synchronized (this.b) {
            try {
                if (this.d.containsKey(str)) {
                    return ((C10122b7) this.d.get(str)).b();
                }
                MM3 mm3 = new MM3(this.e);
                C25156zp4 c25156zp4 = (C25156zp4) this.c.get(str);
                if (c25156zp4 == null) {
                    c25156zp4 = new C25156zp4();
                    this.c.put(str, c25156zp4);
                }
                final C10122b7 c10122b7 = new C10122b7(mm3, str, c4614Fw5, c25156zp4);
                c25156zp4.a(mm3, c10122b7);
                this.d.put(c10122b7.e(), c10122b7);
                if (AbstractC20507s76.u() || AbstractC20507s76.t()) {
                    AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.vp4
                        @Override // java.lang.Runnable
                        public final void run() {
                            C23972xp4.e(c10122b7);
                        }
                    });
                } else {
                    c10122b7.b().d(XJ6.a);
                }
                return c10122b7.b();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j(C9528a7 c9528a7, String str, C4614Fw5 c4614Fw5) {
        final C10122b7 c10122b7;
        synchronized (this.b) {
            try {
                if (this.d.containsKey(str)) {
                    c10122b7 = (C10122b7) this.d.get(str);
                } else {
                    MM3 mm3 = new MM3(this.e);
                    C25156zp4 c25156zp4 = (C25156zp4) this.c.get(str);
                    if (c25156zp4 == null) {
                        c25156zp4 = new C25156zp4();
                        this.c.put(str, c25156zp4);
                    }
                    C10122b7 c10122b72 = new C10122b7(mm3, str, c4614Fw5, c25156zp4);
                    c25156zp4.a(mm3, c10122b72);
                    this.d.put(c10122b72.e(), c10122b72);
                    c10122b7 = c10122b72;
                }
                c10122b7.j(c9528a7);
                if (AbstractC20507s76.u() || AbstractC20507s76.t()) {
                    AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.wp4
                        @Override // java.lang.Runnable
                        public final void run() {
                            C23972xp4.f(c10122b7);
                        }
                    });
                } else {
                    c10122b7.b().d(XJ6.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
