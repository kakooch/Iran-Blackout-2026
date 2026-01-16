package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C17881nj;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.sj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC20854sj {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.sj$a */
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
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesEaxKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.pj
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC20854sj.i((C17881nj) abstractC20124rW4);
            }
        }, C17881nj.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.qj
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC20854sj.f((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C15517jj.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.rj
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC20854sj.e((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    private static C18472oj d(C17881nj c17881nj) throws GeneralSecurityException {
        if (c17881nj.e() == 16) {
            return (C18472oj) C18472oj.V().p(c17881nj.c()).e();
        }
        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports aes eax keys with tag size equal to 16 bytes.", Integer.valueOf(c17881nj.e())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C15517jj e(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            C16108kj c16108kjZ = C16108kj.Z(c19799qx5.g(), C2352n.b());
            if (c16108kjZ.X() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C15517jj.a().e(C17881nj.b().c(c16108kjZ.V().size()).b(c16108kjZ.W().U()).d(16).e(k(c19799qx5.e())).a()).d(C18469oi6.a(c16108kjZ.V().W(), C19060pi6.b(c19060pi6))).c(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C17881nj f(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                C16699lj c16699ljX = C16699lj.X(c22275ux5.d().Y(), C2352n.b());
                return C17881nj.b().c(c16699ljX.U()).b(c16699ljX.V().U()).d(16).e(k(c22275ux5.d().W())).a();
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e2);
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: " + c22275ux5.d().X());
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
    public static C22275ux5 i(C17881nj c17881nj) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesEaxKey").r(((C16699lj) C16699lj.W().q(d(c17881nj)).p(c17881nj.d()).e()).b()).p(j(c17881nj.f())).e());
    }

    private static FN4 j(C17881nj.c cVar) throws GeneralSecurityException {
        if (C17881nj.c.b.equals(cVar)) {
            return FN4.TINK;
        }
        if (C17881nj.c.c.equals(cVar)) {
            return FN4.CRUNCHY;
        }
        if (C17881nj.c.d.equals(cVar)) {
            return FN4.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + cVar);
    }

    private static C17881nj.c k(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C17881nj.c.b;
        }
        if (i == 2 || i == 3) {
            return C17881nj.c.c;
        }
        if (i == 4) {
            return C17881nj.c.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
