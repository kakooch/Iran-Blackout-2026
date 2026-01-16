package ir.nasim;

import android.content.Context;

/* renamed from: ir.nasim.n0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17457n0 implements InterfaceC25103zk1 {
    private AbstractC18048o0 b;

    public AbstractC17457n0() {
    }

    protected static AbstractC17457n0 g(AbstractC18048o0 abstractC18048o0) {
        if (abstractC18048o0 instanceof C8540Wk1) {
            C8540Wk1 c8540Wk1 = (C8540Wk1) abstractC18048o0;
            AbstractC19230q0 abstractC19230q0C = c8540Wk1.c();
            if (abstractC19230q0C instanceof C10835cH3) {
                try {
                    return new C18626oy5(c8540Wk1, new C13388g85(c8540Wk1));
                } catch (Exception e) {
                    throw new RuntimeException("Unknown type in LocalPurchase, exception: " + e.getMessage());
                }
            }
            if (abstractC19230q0C instanceof C10219bH3) {
                return new C19049ph5(c8540Wk1);
            }
            if (abstractC19230q0C instanceof MG3) {
                try {
                    return new ir.nasim.core.modules.messaging.entity.content.a(c8540Wk1, new C13388g85(c8540Wk1));
                } catch (Exception e2) {
                    throw new RuntimeException("Unknown type in LocalCrowdfundingContent, exception: " + e2.getMessage());
                }
            }
            if (abstractC19230q0C instanceof VG3) {
                return new LC3(c8540Wk1);
            }
            if (abstractC19230q0C instanceof C9625aH3) {
                return new C13388g85(c8540Wk1);
            }
            if (abstractC19230q0C instanceof C21874uH3) {
                return new GS7(c8540Wk1);
            }
            if (abstractC19230q0C instanceof SG3) {
                return new XG2(c8540Wk1);
            }
            if (abstractC19230q0C instanceof BH3) {
                return new J08(c8540Wk1);
            }
            if (abstractC19230q0C instanceof GG3) {
                return new TM(c8540Wk1);
            }
            if (abstractC19230q0C instanceof C8894Xu) {
                return new C5512Jq6((C8894Xu) abstractC19230q0C);
            }
            if (abstractC19230q0C instanceof OG3) {
                return new C24967zW1(c8540Wk1);
            }
            if (abstractC19230q0C instanceof FG3) {
                return new C11907dl(c8540Wk1);
            }
            if (abstractC19230q0C instanceof C18215oH3) {
                return new C12872fJ6(c8540Wk1);
            }
            if (abstractC19230q0C instanceof NG3) {
                return new C18285oP1(c8540Wk1);
            }
            throw new RuntimeException("Unknown type in ContentLocalContainer");
        }
        if (!(abstractC18048o0 instanceof C11909dl1)) {
            throw new RuntimeException("Unknown type in AbsContentContainer");
        }
        C11909dl1 c11909dl1 = (C11909dl1) abstractC18048o0;
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        try {
        } catch (Exception e3) {
            C19406qI3.c("AbsContent", "Error in ContentRemoteContainer: " + e3.getMessage(), e3);
        }
        if ((abstractC24063xzC instanceof C12793fB) && C8386Vt0.v9()) {
            return new C5331Iw5(c11909dl1);
        }
        if (abstractC24063xzC instanceof C8205Uz) {
            return new C24562yp4(c11909dl1);
        }
        if (abstractC24063xzC instanceof C16384lB) {
            return new C18626oy5(c11909dl1);
        }
        if (abstractC24063xzC instanceof C21001sy) {
            return new C22472vI2(c11909dl1);
        }
        if (abstractC24063xzC instanceof XA) {
            return new C19049ph5(c11909dl1);
        }
        if (abstractC24063xzC instanceof C22874vy) {
            return new BJ2(c11909dl1);
        }
        if (abstractC24063xzC instanceof C15784kA) {
            C15784kA c15784kA = (C15784kA) abstractC24063xzC;
            if (c15784kA.u() instanceof C6759Ow) {
                return new C15284jK0(c11909dl1);
            }
            if (c15784kA.u() instanceof C13411gB) {
                return new C15080iy5(c11909dl1);
            }
            if (c15784kA.u() instanceof C16829lw) {
                return new C20212re0(c11909dl1);
            }
        } else {
            if (abstractC24063xzC instanceof TC) {
                return new C22149uk7(c11909dl1);
            }
            if (abstractC24063xzC instanceof C12038dw) {
                C12038dw c12038dw = (C12038dw) abstractC24063xzC;
                if (c12038dw.u() instanceof C12629ew) {
                    return new C5672Ki4(c11909dl1);
                }
                if (c12038dw.u() instanceof C13265fw) {
                    return new QM5(c11909dl1);
                }
                if (c12038dw.u() instanceof C13856gw) {
                    return new C11383cu7(c11909dl1);
                }
                if (!(c12038dw.u() instanceof C21142tB) && !(c12038dw.u() instanceof C21679tx)) {
                    return new E50(c11909dl1);
                }
                return new NI5(c11909dl1);
            }
            if (abstractC24063xzC instanceof C16265kz) {
                return new LC3(c11909dl1);
            }
            if (abstractC24063xzC instanceof C6035Lx) {
                C6035Lx c6035Lx = (C6035Lx) abstractC24063xzC;
                if (c6035Lx.w() instanceof C5100Hx) {
                    return new C13388g85(c11909dl1);
                }
                if (c6035Lx.w() instanceof C5568Jx) {
                    return new GS7(c11909dl1);
                }
                if (c6035Lx.w() instanceof C4866Gx) {
                    return new XG2(c11909dl1);
                }
                if (c6035Lx.w() instanceof C5802Kx) {
                    return new J08(c11909dl1);
                }
                if (c6035Lx.w() instanceof C4617Fx) {
                    return new TM(c11909dl1);
                }
                C24967zW1 c24967zW1 = new C24967zW1(c11909dl1);
                return p(c24967zW1) ? new TM(c11909dl1) : q(c24967zW1) ? new J08(c11909dl1) : c24967zW1;
            }
            if (C8386Vt0.B4() && (abstractC24063xzC instanceof C14449hw)) {
                return new C21788u80(c11909dl1, C21788u80.r(((C14449hw) abstractC24063xzC).u()));
            }
            if (abstractC24063xzC instanceof ZC) {
                return new C23345wl7(c11909dl1);
            }
            if (abstractC24063xzC instanceof VC) {
                return new C22739vk7(c11909dl1);
            }
            if (abstractC24063xzC instanceof C23011wC) {
                VB vbU = ((C23011wC) abstractC24063xzC).u();
                if (vbU instanceof C13420gC) {
                    return new C19751qs6(c11909dl1);
                }
                if (vbU instanceof C10786cC) {
                    return new C23404wr6(c11909dl1);
                }
                if (vbU instanceof C11550dC) {
                    return new C23994xr6(c11909dl1);
                }
                if (vbU instanceof ZB) {
                    return new C16195kr6(c11909dl1);
                }
                if (vbU instanceof C14011hC) {
                    return new C22218ur6(c11909dl1);
                }
                if (vbU instanceof C14613iC) {
                    return new C22808vr6(c11909dl1);
                }
                if (vbU instanceof C9576aC) {
                    return new C16786lr6(c11909dl1);
                }
                if (vbU instanceof C16393lC) {
                    return new C20941sr6(c11909dl1);
                }
                if (vbU instanceof C20548sC) {
                    return new C24584yr6(c11909dl1);
                }
                if (vbU instanceof C21825uC) {
                    return new C3395Ar6(c11909dl1);
                }
                if (vbU instanceof C22415vC) {
                    return new C3634Br6(c11909dl1);
                }
                if (vbU instanceof C21151tC) {
                    return new C25178zr6(c11909dl1);
                }
                if (vbU instanceof C15802kC) {
                    return new C19150pr6(c11909dl1);
                }
                if (vbU instanceof C15211jC) {
                    return new C17377mr6(c11909dl1);
                }
                if (vbU instanceof WB) {
                    return new C5512Jq6(c11909dl1);
                }
                if (!(vbU instanceof C18757pC)) {
                    return vbU instanceof C19348qC ? new C6213Mq6(c11909dl1) : vbU instanceof C17575nC ? new C7906Tr6(c11909dl1) : vbU instanceof C16984mC ? new C20951ss6(c11909dl1) : vbU instanceof C18166oC ? new C8608Wr6(c11909dl1) : new WE1(c11909dl1);
                }
                Boolean boolZ = ((C18757pC) vbU).z();
                return (boolZ == null || !boolZ.booleanValue()) ? new C5980Lq6(c11909dl1) : new C20360rs6(c11909dl1);
            }
            if (abstractC24063xzC instanceof C8664Wy) {
                C19231q00 c19231q00 = new C19231q00(((C8664Wy) abstractC24063xzC).u());
                return c19231q00.o("dataType", "").equals("contact") ? new C6833Pe1(c11909dl1) : c19231q00.o("dataType", "").equals("location") ? new C10844cI3(c11909dl1) : new C16122kk3(c11909dl1);
            }
            if (abstractC24063xzC instanceof IC) {
                return new JM6(c11909dl1);
            }
            if (abstractC24063xzC instanceof C7246Qx) {
                return new C18121o72(c11909dl1);
            }
            if (abstractC24063xzC instanceof C20402rx) {
                return new NH1(c11909dl1);
            }
            if (abstractC24063xzC instanceof C16247kx) {
                return new ir.nasim.core.modules.messaging.entity.content.a(c11909dl1);
            }
            if (abstractC24063xzC instanceof C5316Iv) {
                return new C16799lt(c11909dl1);
            }
        }
        return new C11558dC7(c11909dl1);
    }

    public static AbstractC17457n0 h(AbstractC24063xz abstractC24063xz) {
        return g(new C11909dl1(abstractC24063xz));
    }

    public static AbstractC17457n0 n(byte[] bArr) {
        C19084pl0 c19084pl0 = new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(bArr)));
        if (c19084pl0.c(32, false)) {
            return g(AbstractC18048o0.b(c19084pl0.d(33)));
        }
        throw new RuntimeException("Unsupported obsolete format");
    }

    public static byte[] o(AbstractC17457n0 abstractC17457n0) {
        C12658ez1 c12658ez1 = new C12658ez1();
        C19675ql0 c19675ql0 = new C19675ql0(c12658ez1);
        c19675ql0.a(32, true);
        c19675ql0.b(33, abstractC17457n0.i().a());
        return c12658ez1.c();
    }

    private static boolean p(C24967zW1 c24967zW1) {
        return c24967zW1.d.contains("audio/") && C6906Pm2.s(c24967zW1.y()) && c24967zW1.c.f() > 0;
    }

    private static boolean q(C24967zW1 c24967zW1) {
        return c24967zW1.d.contains("audio/") && C6906Pm2.y(c24967zW1.y()) && c24967zW1.c.f() > 0;
    }

    public C24967zW1 f() {
        if (this instanceof C24967zW1) {
            return (C24967zW1) this;
        }
        if (this instanceof C22149uk7) {
            C22149uk7 c22149uk7 = (C22149uk7) this;
            if (c22149uk7.t() instanceof C24967zW1) {
                return (C24967zW1) c22149uk7.t();
            }
        }
        if (!(this instanceof C5331Iw5)) {
            return null;
        }
        C5331Iw5 c5331Iw5 = (C5331Iw5) this;
        if (c5331Iw5.r() instanceof C24967zW1) {
            return (C24967zW1) c5331Iw5.r();
        }
        return null;
    }

    public AbstractC18048o0 i() {
        return this.b;
    }

    public String j(Context context) {
        return null;
    }

    public int k() {
        return 1;
    }

    public abstract C23345wl7 l();

    public boolean m() {
        return f() != null;
    }

    public AbstractC17457n0(C11909dl1 c11909dl1) {
        this.b = c11909dl1;
    }

    public AbstractC17457n0(C8540Wk1 c8540Wk1) {
        this.b = c8540Wk1;
    }
}
