package ir.nasim;

/* loaded from: classes2.dex */
public final class ON4 {
    public static final ON4 a = new ON4();

    private static final class a implements InterfaceC12197eC3 {
        public static final C0552a i = new C0552a(null);
        private final InterfaceC3516Be5 a;
        private final InterfaceC3516Be5 b;
        private final InterfaceC12197eC3 c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;

        /* renamed from: ir.nasim.ON4$a$a, reason: collision with other inner class name */
        public static final class C0552a {
            private C0552a() {
            }

            public /* synthetic */ C0552a(ED1 ed1) {
                this();
            }
        }

        public a(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52, InterfaceC12197eC3 interfaceC12197eC3) {
            AbstractC13042fc3.i(interfaceC3516Be5, "oldList");
            AbstractC13042fc3.i(interfaceC3516Be52, "newList");
            AbstractC13042fc3.i(interfaceC12197eC3, "callback");
            this.a = interfaceC3516Be5;
            this.b = interfaceC3516Be52;
            this.c = interfaceC12197eC3;
            this.d = interfaceC3516Be5.b();
            this.e = interfaceC3516Be5.c();
            this.f = interfaceC3516Be5.a();
            this.g = 1;
            this.h = 1;
        }

        private final boolean e(int i2, int i3) {
            if (i2 < this.f || this.h == 2) {
                return false;
            }
            int iMin = Math.min(i3, this.e);
            if (iMin > 0) {
                this.h = 3;
                this.c.c(this.d + i2, iMin, AT1.PLACEHOLDER_TO_ITEM);
                this.e -= iMin;
            }
            int i4 = i3 - iMin;
            if (i4 <= 0) {
                return true;
            }
            this.c.a(i2 + iMin + this.d, i4);
            return true;
        }

        private final boolean f(int i2, int i3) {
            if (i2 > 0 || this.g == 2) {
                return false;
            }
            int iMin = Math.min(i3, this.d);
            if (iMin > 0) {
                this.g = 3;
                this.c.c((0 - iMin) + this.d, iMin, AT1.PLACEHOLDER_TO_ITEM);
                this.d -= iMin;
            }
            int i4 = i3 - iMin;
            if (i4 <= 0) {
                return true;
            }
            this.c.a(this.d, i4);
            return true;
        }

        private final boolean g(int i2, int i3) {
            if (i2 + i3 < this.f || this.h == 3) {
                return false;
            }
            int iE = AbstractC23053wG5.e(Math.min(this.b.c() - this.e, i3), 0);
            int i4 = i3 - iE;
            if (iE > 0) {
                this.h = 2;
                this.c.c(this.d + i2, iE, AT1.ITEM_TO_PLACEHOLDER);
                this.e += iE;
            }
            if (i4 <= 0) {
                return true;
            }
            this.c.b(i2 + iE + this.d, i4);
            return true;
        }

        private final boolean h(int i2, int i3) {
            if (i2 > 0 || this.g == 3) {
                return false;
            }
            int iE = AbstractC23053wG5.e(Math.min(this.b.b() - this.d, i3), 0);
            int i4 = i3 - iE;
            if (i4 > 0) {
                this.c.b(this.d, i4);
            }
            if (iE <= 0) {
                return true;
            }
            this.g = 2;
            this.c.c(this.d, iE, AT1.ITEM_TO_PLACEHOLDER);
            this.d += iE;
            return true;
        }

        private final void i() {
            int iMin = Math.min(this.a.b(), this.d);
            int iB = this.b.b() - this.d;
            if (iB > 0) {
                if (iMin > 0) {
                    this.c.c(0, iMin, AT1.PLACEHOLDER_POSITION_CHANGE);
                }
                this.c.a(0, iB);
            } else if (iB < 0) {
                this.c.b(0, -iB);
                int i2 = iMin + iB;
                if (i2 > 0) {
                    this.c.c(0, i2, AT1.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.d = this.b.b();
        }

        private final void k() {
            int iMin = Math.min(this.a.c(), this.e);
            int iC = this.b.c();
            int i2 = this.e;
            int i3 = iC - i2;
            int i4 = this.d + this.f + i2;
            int i5 = i4 - iMin;
            boolean z = i5 != this.a.f() - iMin;
            if (i3 > 0) {
                this.c.a(i4, i3);
            } else if (i3 < 0) {
                this.c.b(i4 + i3, -i3);
                iMin += i3;
            }
            if (iMin > 0 && z) {
                this.c.c(i5, iMin, AT1.PLACEHOLDER_POSITION_CHANGE);
            }
            this.e = this.b.c();
        }

        @Override // ir.nasim.InterfaceC12197eC3
        public void a(int i2, int i3) {
            if (!e(i2, i3) && !f(i2, i3)) {
                this.c.a(i2 + this.d, i3);
            }
            this.f += i3;
        }

        @Override // ir.nasim.InterfaceC12197eC3
        public void b(int i2, int i3) {
            if (!g(i2, i3) && !h(i2, i3)) {
                this.c.b(i2 + this.d, i3);
            }
            this.f -= i3;
        }

        @Override // ir.nasim.InterfaceC12197eC3
        public void c(int i2, int i3, Object obj) {
            this.c.c(i2 + this.d, i3, obj);
        }

        @Override // ir.nasim.InterfaceC12197eC3
        public void d(int i2, int i3) {
            InterfaceC12197eC3 interfaceC12197eC3 = this.c;
            int i4 = this.d;
            interfaceC12197eC3.d(i2 + i4, i3 + i4);
        }

        public final void j() {
            i();
            k();
        }
    }

    private ON4() {
    }

    public final void a(InterfaceC3516Be5 interfaceC3516Be5, InterfaceC3516Be5 interfaceC3516Be52, InterfaceC12197eC3 interfaceC12197eC3, C3277Ae5 c3277Ae5) {
        AbstractC13042fc3.i(interfaceC3516Be5, "oldList");
        AbstractC13042fc3.i(interfaceC3516Be52, "newList");
        AbstractC13042fc3.i(interfaceC12197eC3, "callback");
        AbstractC13042fc3.i(c3277Ae5, "diffResult");
        a aVar = new a(interfaceC3516Be5, interfaceC3516Be52, interfaceC12197eC3);
        c3277Ae5.a().c(aVar);
        aVar.j();
    }
}
