package ir.nasim;

/* renamed from: ir.nasim.oz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18637oz7 {
    private final C47 a = new C47();
    private final C17660nL3 b = new C17660nL3(16);

    /* renamed from: ir.nasim.oz7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C18046nz7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C18046nz7 c18046nz7) {
            super(1);
            this.f = c18046nz7;
        }

        public final void a(InterfaceC19228pz7 interfaceC19228pz7) {
            C47 c47B = C18637oz7.this.b();
            C18637oz7 c18637oz7 = C18637oz7.this;
            C18046nz7 c18046nz7 = this.f;
            synchronized (c47B) {
                try {
                    if (interfaceC19228pz7.e()) {
                        c18637oz7.b.f(c18046nz7, interfaceC19228pz7);
                    } else {
                        c18637oz7.b.g(c18046nz7);
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC19228pz7) obj);
            return C19938rB7.a;
        }
    }

    public final C47 b() {
        return this.a;
    }

    public final InterfaceC9664aL6 c(C18046nz7 c18046nz7, UA2 ua2) {
        synchronized (this.a) {
            InterfaceC19228pz7 interfaceC19228pz7 = (InterfaceC19228pz7) this.b.d(c18046nz7);
            if (interfaceC19228pz7 != null) {
                if (interfaceC19228pz7.e()) {
                    return interfaceC19228pz7;
                }
            }
            try {
                InterfaceC19228pz7 interfaceC19228pz72 = (InterfaceC19228pz7) ua2.invoke(new a(c18046nz7));
                synchronized (this.a) {
                    try {
                        if (this.b.d(c18046nz7) == null && interfaceC19228pz72.e()) {
                            this.b.f(c18046nz7, interfaceC19228pz72);
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return interfaceC19228pz72;
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }
}
