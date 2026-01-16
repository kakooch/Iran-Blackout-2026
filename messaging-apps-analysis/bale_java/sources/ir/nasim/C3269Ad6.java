package ir.nasim;

import ir.nasim.C24677z13;

/* renamed from: ir.nasim.Ad6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3269Ad6 implements C24677z13.f {
    public static final a e = new a(null);
    private final C24677z13.f a;
    private final Object b;
    private boolean c;
    private C24677z13.g d;

    /* renamed from: ir.nasim.Ad6$a */
    public static final class a {
        private a() {
        }

        public final C3269Ad6 a(C24677z13.f fVar) {
            return new C3269Ad6(fVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C3269Ad6(C24677z13.f fVar, ED1 ed1) {
        this(fVar);
    }

    private final void a() {
        C19938rB7 c19938rB7;
        synchronized (this.b) {
            try {
                if (this.c) {
                    C24677z13.f fVar = this.a;
                    if (fVar != null) {
                        fVar.clear();
                        c19938rB7 = C19938rB7.a;
                    } else {
                        c19938rB7 = null;
                    }
                    if (c19938rB7 == null) {
                        PI3.c("ScreenFlashWrapper", "completePendingScreenFlashClear: screenFlash is null!");
                    }
                } else {
                    PI3.l("ScreenFlashWrapper", "completePendingScreenFlashClear: none pending!");
                }
                this.c = false;
                C19938rB7 c19938rB72 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        synchronized (this.b) {
            try {
                C24677z13.g gVar = this.d;
                if (gVar != null) {
                    gVar.a();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final C3269Ad6 d(C24677z13.f fVar) {
        return e.a(fVar);
    }

    public final void c() {
        b();
        a();
    }

    @Override // ir.nasim.C24677z13.f
    public void clear() {
        a();
    }

    private C3269Ad6(C24677z13.f fVar) {
        this.a = fVar;
        this.b = new Object();
    }
}
