package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C4396Ey3;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Iy3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC5347Iy3 {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.Fy3
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC5347Iy3.i((C4396Ey3) abstractC20124rW4);
            }
        }, C4396Ey3.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Gy3
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC5347Iy3.f((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C4162Dy3.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.Hy3
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC5347Iy3.d((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C4162Dy3 d(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            C17965nr3 c17965nr3X = C17965nr3.X(c19799qx5.g(), C2352n.b());
            if (c19799qx5.e() != FN4.RAW) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + c17965nr3X);
            }
            if (c17965nr3X.V() == 0) {
                return C4162Dy3.a(e(c17965nr3X.U()));
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + c17965nr3X);
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e2);
        }
    }

    private static C4396Ey3 e(C18556or3 c18556or3) throws GeneralSecurityException {
        C4396Ey3.c cVar;
        AbstractC20124rW4 abstractC20124rW4A = AbstractC5981Lq7.a(((C6691Oo3) C6691Oo3.Z().q(c18556or3.V().X()).r(c18556or3.V().Y()).p(FN4.RAW).e()).f());
        if (abstractC20124rW4A instanceof C24497yj) {
            cVar = C4396Ey3.c.b;
        } else if (abstractC20124rW4A instanceof XH0) {
            cVar = C4396Ey3.c.d;
        } else if (abstractC20124rW4A instanceof C10441bc8) {
            cVar = C4396Ey3.c.c;
        } else if (abstractC20124rW4A instanceof C8786Xi) {
            cVar = C4396Ey3.c.e;
        } else if (abstractC20124rW4A instanceof C17881nj) {
            cVar = C4396Ey3.c.f;
        } else {
            if (!(abstractC20124rW4A instanceof C5208Ij)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + abstractC20124rW4A);
            }
            cVar = C4396Ey3.c.g;
        }
        return C4396Ey3.b().e(c18556or3.W()).c((AbstractC4482Fi) abstractC20124rW4A).d(cVar).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C4396Ey3 f(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            try {
                return e(C18556or3.Z(c22275ux5.d().Y(), C2352n.b()));
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e2);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + c22275ux5.d().X());
    }

    public static void g() {
        h(com.google.crypto.tink.internal.b.c());
    }

    public static void h(com.google.crypto.tink.internal.b bVar) {
        bVar.m(b);
        bVar.l(c);
        bVar.k(d);
        bVar.j(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22275ux5 i(C4396Ey3 c4396Ey3) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").r(j(c4396Ey3).b()).p(FN4.RAW).e());
    }

    private static C18556or3 j(C4396Ey3 c4396Ey3) throws GeneralSecurityException {
        try {
            return (C18556or3) C18556or3.Y().q(c4396Ey3.d()).p(C6691Oo3.a0(AbstractC5981Lq7.b(c4396Ey3.c()), C2352n.b())).e();
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e2);
        }
    }
}
