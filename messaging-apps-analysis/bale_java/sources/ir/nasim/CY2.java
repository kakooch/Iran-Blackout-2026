package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C23802xY2;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public abstract class CY2 {
    private static final C8575Wo0 a;
    private static final M92 b;
    private static final M92 c;
    private static final AbstractC22010uW4 d;
    private static final AbstractC21353tW4 e;
    private static final com.google.crypto.tink.internal.a f;
    private static final AbstractC4789Go3 g;

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.HmacKey");
        a = c8575Wo0H;
        b = M92.a().a(FN4.RAW, C23802xY2.d.e).a(FN4.TINK, C23802xY2.d.b).a(FN4.LEGACY, C23802xY2.d.d).a(FN4.CRUNCHY, C23802xY2.d.c).b();
        c = M92.a().a(EnumC24950zU2.SHA1, C23802xY2.c.b).a(EnumC24950zU2.SHA224, C23802xY2.c.c).a(EnumC24950zU2.SHA256, C23802xY2.c.d).a(EnumC24950zU2.SHA384, C23802xY2.c.e).a(EnumC24950zU2.SHA512, C23802xY2.c.f).b();
        d = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.zY2
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return CY2.i((C23802xY2) abstractC20124rW4);
            }
        }, C23802xY2.class, C22275ux5.class);
        e = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.AY2
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return CY2.f((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        f = com.google.crypto.tink.internal.a.a(new C9882aj(), C20140rY2.class, C19799qx5.class);
        g = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.BY2
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return CY2.e((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    private static C24392yY2 d(C23802xY2 c23802xY2) {
        return (C24392yY2) C24392yY2.X().q(c23802xY2.c()).p((EnumC24950zU2) c.c(c23802xY2.d())).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C20140rY2 e(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            C20749sY2 c20749sY2A0 = C20749sY2.a0(c19799qx5.g(), C2352n.b());
            if (c20749sY2A0.Y() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C20140rY2.c().e(C23802xY2.b().c(c20749sY2A0.W().size()).d(c20749sY2A0.X().W()).b((C23802xY2.c) c.b(c20749sY2A0.X().V())).e((C23802xY2.d) b.b(c19799qx5.e())).a()).d(C18469oi6.a(c20749sY2A0.W().W(), C19060pi6.b(c19060pi6))).c(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C23802xY2 f(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C21369tY2 c21369tY2Z = C21369tY2.Z(c22275ux5.d().Y(), C2352n.b());
            if (c21369tY2Z.X() == 0) {
                return C23802xY2.b().c(c21369tY2Z.V()).d(c21369tY2Z.W().W()).b((C23802xY2.c) c.b(c21369tY2Z.W().V())).e((C23802xY2.d) b.b(c22275ux5.d().W())).a();
            }
            throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + c21369tY2Z.X());
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e2);
        }
    }

    public static void g() {
        h(com.google.crypto.tink.internal.b.c());
    }

    public static void h(com.google.crypto.tink.internal.b bVar) {
        bVar.m(d);
        bVar.l(e);
        bVar.k(f);
        bVar.j(g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22275ux5 i(C23802xY2 c23802xY2) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.HmacKey").r(((C21369tY2) C21369tY2.Y().q(d(c23802xY2)).p(c23802xY2.e()).e()).b()).p((FN4) b.c(c23802xY2.g())).e());
    }
}
