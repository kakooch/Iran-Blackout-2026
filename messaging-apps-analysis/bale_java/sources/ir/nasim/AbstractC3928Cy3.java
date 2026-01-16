package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Cy3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC3928Cy3 {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.zy3
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC3928Cy3.h((C24648yy3) abstractC20124rW4);
            }
        }, C24648yy3.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Ay3
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC3928Cy3.e((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C24058xy3.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.By3
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC3928Cy3.d((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C24058xy3 d(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        if (c19799qx5.e() != FN4.RAW) {
            throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got " + c19799qx5.e());
        }
        try {
            C14403hr3 c14403hr3X = C14403hr3.X(c19799qx5.g(), C2352n.b());
            if (c14403hr3X.V() == 0) {
                return C24058xy3.a(C24648yy3.b(c14403hr3X.U().U()));
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + c14403hr3X);
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C24648yy3 e(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C15011ir3 c15011ir3W = C15011ir3.W(c22275ux5.d().Y(), C2352n.b());
            if (c22275ux5.d().W() == FN4.RAW) {
                return C24648yy3.b(c15011ir3W.U());
            }
            throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + c22275ux5.d().W() + " with format " + c15011ir3W);
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e2);
        }
    }

    public static void f() {
        g(com.google.crypto.tink.internal.b.c());
    }

    public static void g(com.google.crypto.tink.internal.b bVar) {
        bVar.m(b);
        bVar.l(c);
        bVar.k(d);
        bVar.j(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22275ux5 h(C24648yy3 c24648yy3) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.KmsAeadKey").r(((C15011ir3) C15011ir3.V().p(c24648yy3.c()).e()).b()).p(FN4.RAW).e());
    }
}
