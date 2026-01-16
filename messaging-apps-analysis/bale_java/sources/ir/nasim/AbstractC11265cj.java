package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C8786Xi;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.cj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC11265cj {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.cj$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC24950zU2.values().length];
            b = iArr;
            try {
                iArr[EnumC24950zU2.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[EnumC24950zU2.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[EnumC24950zU2.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC24950zU2.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EnumC24950zU2.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[FN4.values().length];
            a = iArr2;
            try {
                iArr2[FN4.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[FN4.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.Yi
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC11265cj.i((C8786Xi) abstractC20124rW4);
            }
        }, C8786Xi.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Zi
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC11265cj.f((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C7816Ti.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.bj
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC11265cj.e((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    private static C24392yY2 d(C8786Xi c8786Xi) {
        return (C24392yY2) C24392yY2.X().q(c8786Xi.g()).p(k(c8786Xi.d())).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C7816Ti e(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            C8052Ui c8052UiZ = C8052Ui.Z(c19799qx5.g(), C2352n.b());
            if (c8052UiZ.X() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (c8052UiZ.V().Y() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (c8052UiZ.W().Y() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            return C7816Ti.a().f(C8786Xi.b().b(c8052UiZ.V().W().size()).d(c8052UiZ.W().W().size()).e(c8052UiZ.V().X().U()).f(c8052UiZ.W().X().W()).c(j(c8052UiZ.W().X().V())).g(m(c19799qx5.e())).a()).c(C18469oi6.a(c8052UiZ.V().W().W(), C19060pi6.b(c19060pi6))).d(C18469oi6.a(c8052UiZ.W().W().W(), C19060pi6.b(c19060pi6))).e(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C8786Xi f(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C8286Vi c8286ViX = C8286Vi.X(c22275ux5.d().Y(), C2352n.b());
            if (c8286ViX.V().X() == 0) {
                return C8786Xi.b().b(c8286ViX.U().V()).d(c8286ViX.V().V()).e(c8286ViX.U().W().U()).f(c8286ViX.V().W().W()).c(j(c8286ViX.V().W().V())).g(m(c22275ux5.d().W())).a();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e2);
        }
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
    public static C22275ux5 i(C8786Xi c8786Xi) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").r(((C8286Vi) C8286Vi.W().p((C13135fj) C13135fj.X().q((C14317hj) C14317hj.V().p(c8786Xi.f()).e()).p(c8786Xi.c()).e()).q((C21369tY2) C21369tY2.Y().q(d(c8786Xi)).p(c8786Xi.e()).e()).e()).b()).p(l(c8786Xi.h())).e());
    }

    private static C8786Xi.c j(EnumC24950zU2 enumC24950zU2) throws GeneralSecurityException {
        int i = a.b[enumC24950zU2.ordinal()];
        if (i == 1) {
            return C8786Xi.c.b;
        }
        if (i == 2) {
            return C8786Xi.c.c;
        }
        if (i == 3) {
            return C8786Xi.c.d;
        }
        if (i == 4) {
            return C8786Xi.c.e;
        }
        if (i == 5) {
            return C8786Xi.c.f;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + enumC24950zU2.getNumber());
    }

    private static EnumC24950zU2 k(C8786Xi.c cVar) throws GeneralSecurityException {
        if (C8786Xi.c.b.equals(cVar)) {
            return EnumC24950zU2.SHA1;
        }
        if (C8786Xi.c.c.equals(cVar)) {
            return EnumC24950zU2.SHA224;
        }
        if (C8786Xi.c.d.equals(cVar)) {
            return EnumC24950zU2.SHA256;
        }
        if (C8786Xi.c.e.equals(cVar)) {
            return EnumC24950zU2.SHA384;
        }
        if (C8786Xi.c.f.equals(cVar)) {
            return EnumC24950zU2.SHA512;
        }
        throw new GeneralSecurityException("Unable to serialize HashType " + cVar);
    }

    private static FN4 l(C8786Xi.d dVar) throws GeneralSecurityException {
        if (C8786Xi.d.b.equals(dVar)) {
            return FN4.TINK;
        }
        if (C8786Xi.d.c.equals(dVar)) {
            return FN4.CRUNCHY;
        }
        if (C8786Xi.d.d.equals(dVar)) {
            return FN4.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + dVar);
    }

    private static C8786Xi.d m(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C8786Xi.d.b;
        }
        if (i == 2 || i == 3) {
            return C8786Xi.d.c;
        }
        if (i == 4) {
            return C8786Xi.d.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
