package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;

/* loaded from: classes5.dex */
public class BV1 extends AbstractC21707u0 {
    private final C9057Yh4 b;
    private InterfaceC9031Ye5 c;
    private InterfaceC9031Ye5 d;
    private InterfaceC9031Ye5 e;
    private InterfaceC9031Ye5 f;
    private InterfaceC9031Ye5 g;

    public BV1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.b = c9057Yh4;
    }

    public InterfaceC9031Ye5 A(boolean z) {
        AbstractC20507s76.e();
        return KN6.d(this.b.G().C0(), z, "Dialog_Bot");
    }

    public InterfaceC9031Ye5 B(boolean z) {
        AbstractC20507s76.e();
        return KN6.d(this.b.G().D0(), z, "Dialog_Channel");
    }

    public C19024pf0 C(C11458d25 c11458d25) {
        AbstractC20507s76.e();
        return (C19024pf0) KN6.d(this.b.G().H0(c11458d25), false, "Message");
    }

    public C19024pf0 D() {
        AbstractC20507s76.e();
        return (C19024pf0) KN6.m(this.b.G().q0(), false, "Message");
    }

    public InterfaceC9031Ye5 E(boolean z) {
        AbstractC20507s76.e();
        InterfaceC9031Ye5 interfaceC9031Ye5D = KN6.d(this.b.A().m0(), z, SIPHeaderNames.CONTACT);
        interfaceC9031Ye5D.a();
        return interfaceC9031Ye5D;
    }

    public InterfaceC9031Ye5 F(boolean z) {
        AbstractC20507s76.e();
        return KN6.d(this.b.G().J0(), z, "Dialog");
    }

    public InterfaceC9031Ye5 G(boolean z) {
        AbstractC20507s76.e();
        return KN6.d(this.b.G().M0(), z, "Dialog_Group");
    }

    public InterfaceC9031Ye5 H(boolean z) {
        AbstractC20507s76.e();
        InterfaceC9031Ye5 interfaceC9031Ye5D = KN6.d(this.b.Q().H(), z, "GlobalSearchEntity");
        interfaceC9031Ye5D.a();
        return interfaceC9031Ye5D;
    }

    public InterfaceC9031Ye5 I() {
        AbstractC20507s76.e();
        InterfaceC9031Ye5 interfaceC9031Ye5D = KN6.d(this.b.y().L1(), false, "PaymentDetailItem");
        interfaceC9031Ye5D.a();
        return interfaceC9031Ye5D;
    }

    public InterfaceC9031Ye5 J(C11458d25 c11458d25, boolean z) {
        AbstractC20507s76.e();
        InterfaceC9031Ye5 interfaceC9031Ye5M = KN6.m(this.b.Q().I(c11458d25), z, "GlobalSearchEntity");
        interfaceC9031Ye5M.a();
        return interfaceC9031Ye5M;
    }

    public InterfaceC9031Ye5 K(boolean z) {
        AbstractC20507s76.e();
        return KN6.d(this.b.G().S0(), z, "Dialog_Private");
    }

    public InterfaceC9031Ye5 L() {
        AbstractC20507s76.e();
        if (this.g == null) {
            this.g = A(true);
        }
        return this.g;
    }

    public InterfaceC9031Ye5 M() {
        AbstractC20507s76.e();
        if (this.d == null) {
            this.d = B(true);
        }
        return this.d;
    }

    public InterfaceC9031Ye5 N() {
        AbstractC20507s76.e();
        if (this.c == null) {
            this.c = F(true);
        }
        return this.c;
    }

    public InterfaceC9031Ye5 O() {
        AbstractC20507s76.e();
        if (this.e == null) {
            this.e = G(true);
        }
        return this.e;
    }

    public InterfaceC9031Ye5 P() {
        AbstractC20507s76.e();
        if (this.f == null) {
            this.f = K(true);
        }
        return this.f;
    }
}
