package ir.nasim;

/* renamed from: ir.nasim.Ez5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C4407Ez5 implements InterfaceC4173Dz5 {
    private final C3939Cz5 b;
    private final InterfaceC24449ye1 c;
    private final U33 d;
    private boolean e;
    private boolean f;
    private final String g;
    private final Object a = new Object();
    private final Runnable h = new a();

    /* renamed from: ir.nasim.Ez5$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (C4407Ez5.this.a) {
                C4407Ez5.this.f = true;
                C4407Ez5.this.e = false;
            }
            int i = 0;
            boolean z = false;
            while (true) {
                if (i < 10) {
                    C4656Fz5 c4656Fz5C = C4407Ez5.this.b.c();
                    if (c4656Fz5C == null) {
                        z = false;
                        break;
                    }
                    try {
                        C4407Ez5.this.c.apply(c4656Fz5C.b());
                        C4407Ez5.this.b.g(c4656Fz5C);
                        i++;
                        z = true;
                    } catch (Throwable th) {
                        C4407Ez5.this.b.g(c4656Fz5C);
                        throw th;
                    }
                } else {
                    break;
                }
            }
            synchronized (C4407Ez5.this.a) {
                if (z) {
                    C4407Ez5.this.d.a(C4407Ez5.this.g, C4407Ez5.this.h);
                    C4407Ez5.this.e = true;
                } else {
                    try {
                        if (C4407Ez5.this.e) {
                            C4407Ez5.this.d.a(C4407Ez5.this.g, C4407Ez5.this.h);
                            C4407Ez5.this.e = true;
                        } else {
                            C4407Ez5.this.e = false;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                C4407Ez5.this.f = false;
            }
        }
    }

    public C4407Ez5(String str, EnumC9950ap7 enumC9950ap7, C3939Cz5 c3939Cz5, InterfaceC24449ye1 interfaceC24449ye1, U33 u33) {
        this.b = c3939Cz5;
        this.c = interfaceC24449ye1;
        this.g = str;
        if (u33 != null) {
            this.d = u33;
        } else {
            this.d = AbstractC20507s76.i(str, enumC9950ap7);
        }
        c3939Cz5.a(this);
        a();
    }

    @Override // ir.nasim.InterfaceC4173Dz5
    public void a() {
        synchronized (this.a) {
            try {
                if (this.e) {
                    return;
                }
                this.e = true;
                if (!this.f) {
                    this.d.a(this.g, this.h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
