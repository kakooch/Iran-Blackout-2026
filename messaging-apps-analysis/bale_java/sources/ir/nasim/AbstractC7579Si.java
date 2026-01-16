package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C6373Ni;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Si, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC7579Si {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.Si$a */
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
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesCmacKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.Pi
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC7579Si.i((C6373Ni) abstractC20124rW4);
            }
        }, C6373Ni.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Qi
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC7579Si.f((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C4965Hi.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.Ri
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC7579Si.e((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    private static C6633Oi d(C6373Ni c6373Ni) {
        return (C6633Oi) C6633Oi.V().p(c6373Ni.c()).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C4965Hi e(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            C5199Ii c5199IiZ = C5199Ii.Z(c19799qx5.g(), C2352n.b());
            if (c5199IiZ.X() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C4965Hi.c().e(C6373Ni.b().b(c5199IiZ.V().size()).c(c5199IiZ.W().U()).d(k(c19799qx5.e())).a()).c(C18469oi6.a(c5199IiZ.V().W(), C19060pi6.b(c19060pi6))).d(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C6373Ni f(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                C5433Ji c5433JiX = C5433Ji.X(c22275ux5.d().Y(), C2352n.b());
                return C6373Ni.b().b(c5433JiX.U()).c(c5433JiX.V().U()).d(k(c22275ux5.d().W())).a();
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e2);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + c22275ux5.d().X());
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
    public static C22275ux5 i(C6373Ni c6373Ni) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesCmacKey").r(((C5433Ji) C5433Ji.W().q(d(c6373Ni)).p(c6373Ni.d()).e()).b()).p(j(c6373Ni.f())).e());
    }

    private static FN4 j(C6373Ni.c cVar) throws GeneralSecurityException {
        if (C6373Ni.c.b.equals(cVar)) {
            return FN4.TINK;
        }
        if (C6373Ni.c.c.equals(cVar)) {
            return FN4.CRUNCHY;
        }
        if (C6373Ni.c.e.equals(cVar)) {
            return FN4.RAW;
        }
        if (C6373Ni.c.d.equals(cVar)) {
            return FN4.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + cVar);
    }

    private static C6373Ni.c k(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C6373Ni.c.b;
        }
        if (i == 2) {
            return C6373Ni.c.c;
        }
        if (i == 3) {
            return C6373Ni.c.d;
        }
        if (i == 4) {
            return C6373Ni.c.e;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
