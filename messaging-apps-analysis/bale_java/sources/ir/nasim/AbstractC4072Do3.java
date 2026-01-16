package ir.nasim;

import android.view.KeyEvent;

/* renamed from: ir.nasim.Do3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4072Do3 {
    private static final InterfaceC3838Co3 a = new c(a(new C25226zw5() { // from class: ir.nasim.Do3.b
        @Override // ir.nasim.C25226zw5, ir.nasim.InterfaceC4288Em3
        public Object get(Object obj) {
            return Boolean.valueOf(AbstractC23371wo3.e(((C20908so3) obj).f()));
        }
    }));

    /* renamed from: ir.nasim.Do3$a */
    public static final class a implements InterfaceC3838Co3 {
        final /* synthetic */ UA2 a;

        a(UA2 ua2) {
            this.a = ua2;
        }

        @Override // ir.nasim.InterfaceC3838Co3
        public EnumC18526oo3 a(KeyEvent keyEvent) {
            if (((Boolean) this.a.invoke(C20908so3.a(keyEvent))).booleanValue() && AbstractC23371wo3.f(keyEvent)) {
                if (AbstractC13780go3.o(AbstractC23371wo3.a(keyEvent), C13532gO3.a.y())) {
                    return EnumC18526oo3.M0;
                }
                return null;
            }
            if (((Boolean) this.a.invoke(C20908so3.a(keyEvent))).booleanValue()) {
                long jA = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO3 = C13532gO3.a;
                if (AbstractC13780go3.o(jA, c13532gO3.d()) ? true : AbstractC13780go3.o(jA, c13532gO3.n())) {
                    return EnumC18526oo3.r;
                }
                if (AbstractC13780go3.o(jA, c13532gO3.v())) {
                    return EnumC18526oo3.s;
                }
                if (AbstractC13780go3.o(jA, c13532gO3.w())) {
                    return EnumC18526oo3.t;
                }
                if (AbstractC13780go3.o(jA, c13532gO3.a())) {
                    return EnumC18526oo3.A;
                }
                if (AbstractC13780go3.o(jA, c13532gO3.x())) {
                    return EnumC18526oo3.M0;
                }
                if (AbstractC13780go3.o(jA, c13532gO3.y())) {
                    return EnumC18526oo3.L0;
                }
                return null;
            }
            if (AbstractC23371wo3.e(keyEvent)) {
                return null;
            }
            if (AbstractC23371wo3.f(keyEvent)) {
                long jA2 = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO32 = C13532gO3.a;
                if (AbstractC13780go3.o(jA2, c13532gO32.i())) {
                    return EnumC18526oo3.B;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.j())) {
                    return EnumC18526oo3.D;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.k())) {
                    return EnumC18526oo3.G;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.h())) {
                    return EnumC18526oo3.H;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.s())) {
                    return EnumC18526oo3.J;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.r())) {
                    return EnumC18526oo3.Y;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.p())) {
                    return EnumC18526oo3.E0;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.o())) {
                    return EnumC18526oo3.F0;
                }
                if (AbstractC13780go3.o(jA2, c13532gO32.n())) {
                    return EnumC18526oo3.s;
                }
                return null;
            }
            long jA3 = AbstractC23371wo3.a(keyEvent);
            C13532gO3 c13532gO33 = C13532gO3.a;
            if (AbstractC13780go3.o(jA3, c13532gO33.i())) {
                return EnumC18526oo3.b;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.j())) {
                return EnumC18526oo3.c;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.k())) {
                return EnumC18526oo3.l;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.h())) {
                return EnumC18526oo3.m;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.s())) {
                return EnumC18526oo3.n;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.r())) {
                return EnumC18526oo3.o;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.p())) {
                return EnumC18526oo3.h;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.o())) {
                return EnumC18526oo3.i;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.l()) ? true : AbstractC13780go3.o(jA3, c13532gO33.q())) {
                return EnumC18526oo3.J0;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.c())) {
                return EnumC18526oo3.u;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.g())) {
                return EnumC18526oo3.v;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.t())) {
                return EnumC18526oo3.s;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.f())) {
                return EnumC18526oo3.t;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.e())) {
                return EnumC18526oo3.r;
            }
            if (AbstractC13780go3.o(jA3, c13532gO33.u())) {
                return EnumC18526oo3.K0;
            }
            return null;
        }
    }

    /* renamed from: ir.nasim.Do3$c */
    public static final class c implements InterfaceC3838Co3 {
        final /* synthetic */ InterfaceC3838Co3 a;

        c(InterfaceC3838Co3 interfaceC3838Co3) {
            this.a = interfaceC3838Co3;
        }

        @Override // ir.nasim.InterfaceC3838Co3
        public EnumC18526oo3 a(KeyEvent keyEvent) {
            EnumC18526oo3 enumC18526oo3 = null;
            if (AbstractC23371wo3.f(keyEvent) && AbstractC23371wo3.e(keyEvent)) {
                long jA = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO3 = C13532gO3.a;
                if (AbstractC13780go3.o(jA, c13532gO3.i())) {
                    enumC18526oo3 = EnumC18526oo3.A0;
                } else if (AbstractC13780go3.o(jA, c13532gO3.j())) {
                    enumC18526oo3 = EnumC18526oo3.B0;
                } else if (AbstractC13780go3.o(jA, c13532gO3.k())) {
                    enumC18526oo3 = EnumC18526oo3.D0;
                } else if (AbstractC13780go3.o(jA, c13532gO3.h())) {
                    enumC18526oo3 = EnumC18526oo3.C0;
                }
            } else if (AbstractC23371wo3.e(keyEvent)) {
                long jA2 = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO32 = C13532gO3.a;
                if (AbstractC13780go3.o(jA2, c13532gO32.i())) {
                    enumC18526oo3 = EnumC18526oo3.e;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.j())) {
                    enumC18526oo3 = EnumC18526oo3.d;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.k())) {
                    enumC18526oo3 = EnumC18526oo3.g;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.h())) {
                    enumC18526oo3 = EnumC18526oo3.f;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.m())) {
                    enumC18526oo3 = EnumC18526oo3.u;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.g())) {
                    enumC18526oo3 = EnumC18526oo3.x;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.c())) {
                    enumC18526oo3 = EnumC18526oo3.w;
                } else if (AbstractC13780go3.o(jA2, c13532gO32.b())) {
                    enumC18526oo3 = EnumC18526oo3.I0;
                }
            } else if (AbstractC23371wo3.f(keyEvent)) {
                long jA3 = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO33 = C13532gO3.a;
                if (AbstractC13780go3.o(jA3, c13532gO33.p())) {
                    enumC18526oo3 = EnumC18526oo3.E0;
                } else if (AbstractC13780go3.o(jA3, c13532gO33.o())) {
                    enumC18526oo3 = EnumC18526oo3.F0;
                }
            } else if (AbstractC23371wo3.d(keyEvent)) {
                long jA4 = AbstractC23371wo3.a(keyEvent);
                C13532gO3 c13532gO34 = C13532gO3.a;
                if (AbstractC13780go3.o(jA4, c13532gO34.c())) {
                    enumC18526oo3 = EnumC18526oo3.y;
                } else if (AbstractC13780go3.o(jA4, c13532gO34.g())) {
                    enumC18526oo3 = EnumC18526oo3.z;
                }
            }
            return enumC18526oo3 == null ? this.a.a(keyEvent) : enumC18526oo3;
        }
    }

    public static final InterfaceC3838Co3 a(UA2 ua2) {
        return new a(ua2);
    }

    public static final InterfaceC3838Co3 b() {
        return a;
    }
}
