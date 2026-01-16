package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.C2352n;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C7588Sj;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.Wj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC8529Wj {
    private static final C8575Wo0 a;
    private static final AbstractC22010uW4 b;
    private static final AbstractC21353tW4 c;
    private static final com.google.crypto.tink.internal.a d;
    private static final AbstractC4789Go3 e;
    private static final Map f;
    private static final Map g;

    static {
        C8575Wo0 c8575Wo0H = AbstractC10893cN7.h("type.googleapis.com/google.crypto.tink.AesSivKey");
        a = c8575Wo0H;
        b = AbstractC22010uW4.a(new AbstractC22010uW4.b() { // from class: ir.nasim.Tj
            @Override // ir.nasim.AbstractC22010uW4.b
            public final InterfaceC20931sq6 a(AbstractC20124rW4 abstractC20124rW4) {
                return AbstractC8529Wj.j((C7588Sj) abstractC20124rW4);
            }
        }, C7588Sj.class, C22275ux5.class);
        c = AbstractC21353tW4.a(new AbstractC21353tW4.b() { // from class: ir.nasim.Uj
            @Override // ir.nasim.AbstractC21353tW4.b
            public final AbstractC20124rW4 a(InterfaceC20931sq6 interfaceC20931sq6) {
                return AbstractC8529Wj.g((C22275ux5) interfaceC20931sq6);
            }
        }, c8575Wo0H, C22275ux5.class);
        d = com.google.crypto.tink.internal.a.a(new C9882aj(), C6642Oj.class, C19799qx5.class);
        e = AbstractC4789Go3.a(new AbstractC4789Go3.b() { // from class: ir.nasim.Vj
            @Override // ir.nasim.AbstractC4789Go3.b
            public final AbstractC14981io3 a(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
                return AbstractC8529Wj.f((C19799qx5) interfaceC20931sq6, c19060pi6);
            }
        }, c8575Wo0H, C19799qx5.class);
        f = e();
        g = d();
    }

    private static Map d() {
        EnumMap enumMap = new EnumMap(FN4.class);
        enumMap.put((EnumMap) FN4.RAW, (FN4) C7588Sj.c.d);
        enumMap.put((EnumMap) FN4.TINK, (FN4) C7588Sj.c.b);
        FN4 fn4 = FN4.CRUNCHY;
        C7588Sj.c cVar = C7588Sj.c.c;
        enumMap.put((EnumMap) fn4, (FN4) cVar);
        enumMap.put((EnumMap) FN4.LEGACY, (FN4) cVar);
        return Collections.unmodifiableMap(enumMap);
    }

    private static Map e() {
        HashMap map = new HashMap();
        map.put(C7588Sj.c.d, FN4.RAW);
        map.put(C7588Sj.c.b, FN4.TINK);
        map.put(C7588Sj.c.c, FN4.CRUNCHY);
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C6642Oj f(C19799qx5 c19799qx5, C19060pi6 c19060pi6) throws GeneralSecurityException {
        if (!c19799qx5.f().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
        try {
            C6876Pj c6876PjX = C6876Pj.X(c19799qx5.g(), C2352n.b());
            if (c6876PjX.V() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return C6642Oj.a().e(C7588Sj.b().b(c6876PjX.U().size()).c(l(c19799qx5.e())).a()).d(C18469oi6.a(c6876PjX.U().W(), C19060pi6.b(c19060pi6))).c(c19799qx5.c()).a();
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("Parsing AesSivKey failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C7588Sj g(C22275ux5 c22275ux5) throws GeneralSecurityException {
        if (!c22275ux5.d().X().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + c22275ux5.d().X());
        }
        try {
            C7120Qj c7120QjW = C7120Qj.W(c22275ux5.d().Y(), C2352n.b());
            if (c7120QjW.U() == 0) {
                return C7588Sj.b().b(c7120QjW.T()).c(l(c22275ux5.d().W())).a();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (InvalidProtocolBufferException e2) {
            throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e2);
        }
    }

    public static void h() {
        i(com.google.crypto.tink.internal.b.c());
    }

    public static void i(com.google.crypto.tink.internal.b bVar) {
        bVar.m(b);
        bVar.l(c);
        bVar.k(d);
        bVar.j(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static C22275ux5 j(C7588Sj c7588Sj) {
        return C22275ux5.c((C6691Oo3) C6691Oo3.Z().q("type.googleapis.com/google.crypto.tink.AesSivKey").r(((C7120Qj) C7120Qj.V().p(c7588Sj.c()).e()).b()).p(k(c7588Sj.d())).e());
    }

    private static FN4 k(C7588Sj.c cVar) throws GeneralSecurityException {
        Map map = f;
        if (map.containsKey(cVar)) {
            return (FN4) map.get(cVar);
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + cVar);
    }

    private static C7588Sj.c l(FN4 fn4) throws GeneralSecurityException {
        Map map = g;
        if (map.containsKey(fn4)) {
            return (C7588Sj.c) map.get(fn4);
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + fn4.getNumber());
    }
}
