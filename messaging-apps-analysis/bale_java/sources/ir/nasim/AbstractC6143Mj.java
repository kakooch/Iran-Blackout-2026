package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C5208Ij;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Mj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC6143Mj {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.Mj$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FN4.values().length];
            a = iArr;
            try {
                iArr[FN4.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[FN4.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[FN4.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[FN4.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.Jj
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC6143Mj.h((C5208Ij) abstractC20124rW4);
            }
        }, C5208Ij.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Kj
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC6143Mj.e((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C4257Ej.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.Lj
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC6143Mj.d((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C4257Ej d(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            C4491Fj c4491FjX = C4491Fj.X(c19799qx5.g(), C2352n.b());
            if (c4491FjX.V() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C4257Ej.a().e(C5208Ij.b().b(c4491FjX.U().size()).c(j(c19799qx5.e())).a()).d(C18469oi6.a(c4491FjX.U().W(), C19060pi6.b(c19060pi6))).c(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C5208Ij e(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C4740Gj c4740GjW = C4740Gj.W(c22275ux5.d().Y(), C2352n.b());
            if (c4740GjW.U() == 0) {
                return C5208Ij.b().b(c4740GjW.T()).c(j(c22275ux5.d().W())).a();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e2);
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
    public static C22275ux5 h(C5208Ij c5208Ij) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesGcmSivKey").r(((C4740Gj) C4740Gj.V().p(c5208Ij.c()).e()).b()).p(i(c5208Ij.d())).e());
    }

    private static FN4 i(C5208Ij.c cVar) throws GeneralSecurityException {
        if (C5208Ij.c.b.equals(cVar)) {
            return FN4.TINK;
        }
        if (C5208Ij.c.c.equals(cVar)) {
            return FN4.CRUNCHY;
        }
        if (C5208Ij.c.d.equals(cVar)) {
            return FN4.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + cVar);
    }

    private static C5208Ij.c j(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C5208Ij.c.b;
        }
        if (i == 2 || i == 3) {
            return C5208Ij.c.c;
        }
        if (i == 4) {
            return C5208Ij.c.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
