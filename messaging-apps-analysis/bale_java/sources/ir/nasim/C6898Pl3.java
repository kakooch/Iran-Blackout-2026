package ir.nasim;

import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.Pl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6898Pl3 implements InterfaceC12258eJ1 {
    private final C4996Hl3 b;
    private final C4996Hl3 c;
    private final V53 d;
    private final boolean e;
    private final EnumC11615dJ1 f;
    private final InterfaceC22805vr3 g;
    private final String h;

    public C6898Pl3(C4996Hl3 c4996Hl3, C4996Hl3 c4996Hl32, C8652Ww5 c8652Ww5, InterfaceC6692Oo4 interfaceC6692Oo4, V53 v53, boolean z, EnumC11615dJ1 enumC11615dJ1, InterfaceC22805vr3 interfaceC22805vr3) {
        String string;
        AbstractC13042fc3.i(c4996Hl3, "className");
        AbstractC13042fc3.i(c8652Ww5, "packageProto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(enumC11615dJ1, "abiStability");
        this.b = c4996Hl3;
        this.c = c4996Hl32;
        this.d = v53;
        this.e = z;
        this.f = enumC11615dJ1;
        this.g = interfaceC22805vr3;
        h.f fVar = AbstractC7849Tl3.m;
        AbstractC13042fc3.h(fVar, "packageModuleName");
        Integer num = (Integer) AbstractC15662jx5.a(c8652Ww5, fVar);
        String str = "main";
        if (num != null && (string = interfaceC6692Oo4.getString(num.intValue())) != null) {
            str = string;
        }
        this.h = str;
    }

    @Override // ir.nasim.InterfaceC12258eJ1
    public String a() {
        return "Class '" + d().b().b() + '\'';
    }

    @Override // ir.nasim.JH6
    public KH6 b() {
        KH6 kh6 = KH6.a;
        AbstractC13042fc3.h(kh6, "NO_SOURCE_FILE");
        return kh6;
    }

    public final C24948zU0 d() {
        return new C24948zU0(this.b.g(), g());
    }

    public final C4996Hl3 e() {
        return this.c;
    }

    public final InterfaceC22805vr3 f() {
        return this.g;
    }

    public final C6432No4 g() {
        String strF = this.b.f();
        AbstractC13042fc3.h(strF, "className.internalName");
        C6432No4 c6432No4P = C6432No4.p(AbstractC20762sZ6.c1(strF, '/', null, 2, null));
        AbstractC13042fc3.h(c6432No4P, "identifier(className.internalName.substringAfterLast('/'))");
        return c6432No4P;
    }

    public String toString() {
        return ((Object) C6898Pl3.class.getSimpleName()) + ": " + this.b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C6898Pl3(InterfaceC22805vr3 interfaceC22805vr3, C8652Ww5 c8652Ww5, InterfaceC6692Oo4 interfaceC6692Oo4, V53 v53, boolean z, EnumC11615dJ1 enumC11615dJ1) {
        AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
        AbstractC13042fc3.i(c8652Ww5, "packageProto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(enumC11615dJ1, "abiStability");
        C4996Hl3 c4996Hl3B = C4996Hl3.b(interfaceC22805vr3.f());
        AbstractC13042fc3.h(c4996Hl3B, "byClassId(kotlinClass.classId)");
        String strE = interfaceC22805vr3.c().e();
        C4996Hl3 c4996Hl3D = null;
        if (strE != null && strE.length() > 0) {
            c4996Hl3D = C4996Hl3.d(strE);
        }
        this(c4996Hl3B, c4996Hl3D, c8652Ww5, interfaceC6692Oo4, v53, z, enumC11615dJ1, interfaceC22805vr3);
    }
}
