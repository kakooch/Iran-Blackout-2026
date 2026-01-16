package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C24497yj;
import java.security.GeneralSecurityException;

/* renamed from: ir.nasim.Cj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC3789Cj {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;

    /* renamed from: ir.nasim.Cj$a */
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
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesGcmKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.zj
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC3789Cj.h((C24497yj) abstractC20124rW4);
            }
        }, C24497yj.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Aj
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC3789Cj.e((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C22131uj.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.Bj
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC3789Cj.d((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22131uj d(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            C22721vj c22721vjX = C22721vj.X(c19799qx5.g(), C2352n.b());
            if (c22721vjX.V() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C22131uj.a().e(C24497yj.b().c(c22721vjX.U().size()).b(12).d(16).e(j(c19799qx5.e())).a()).d(C18469oi6.a(c22721vjX.U().W(), C19060pi6.b(c19060pi6))).c(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C24497yj e(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C23317wj c23317wjW = C23317wj.W(c22275ux5.d().Y(), C2352n.b());
            if (c23317wjW.U() == 0) {
                return C24497yj.b().c(c23317wjW.T()).b(12).d(16).e(j(c22275ux5.d().W())).a();
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e2);
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
    public static C22275ux5 h(C24497yj c24497yj) throws GeneralSecurityException {
        k(c24497yj);
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesGcmKey").r(((C23317wj) C23317wj.V().p(c24497yj.d()).e()).b()).p(i(c24497yj.f())).e());
    }

    private static FN4 i(C24497yj.c cVar) throws GeneralSecurityException {
        if (C24497yj.c.b.equals(cVar)) {
            return FN4.TINK;
        }
        if (C24497yj.c.c.equals(cVar)) {
            return FN4.CRUNCHY;
        }
        if (C24497yj.c.d.equals(cVar)) {
            return FN4.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + cVar);
    }

    private static C24497yj.c j(FN4 fn4) throws GeneralSecurityException {
        int i = a.a[fn4.ordinal()];
        if (i == 1) {
            return C24497yj.c.b;
        }
        if (i == 2 || i == 3) {
            return C24497yj.c.c;
        }
        if (i == 4) {
            return C24497yj.c.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }

    private static void k(C24497yj c24497yj) throws GeneralSecurityException {
        if (c24497yj.e() != 16) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d. Currently Tink only supports serialization of AES GCM keys with tag size equal to 16 bytes.", Integer.valueOf(c24497yj.e())));
        }
        if (c24497yj.c() != 12) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d. Currently Tink only supports serialization of AES GCM keys with IV size equal to 12 bytes.", Integer.valueOf(c24497yj.c())));
        }
    }
}
