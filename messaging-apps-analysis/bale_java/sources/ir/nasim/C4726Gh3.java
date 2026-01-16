package ir.nasim;

import java.util.Collection;
import java.util.Map;

/* renamed from: ir.nasim.Gh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4726Gh3 implements InterfaceC21651tu, InterfaceC9301Zi5 {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C4726Gh3.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    private final C9424Zw2 a;
    private final JH6 b;
    private final InterfaceC23016wC4 c;
    private final InterfaceC4243Eh3 d;
    private final boolean e;

    /* renamed from: ir.nasim.Gh3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C9182Yv3 e;
        final /* synthetic */ C4726Gh3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C9182Yv3 c9182Yv3, C4726Gh3 c4726Gh3) {
            super(0);
            this.e = c9182Yv3;
            this.f = c4726Gh3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XC6 invoke() {
            XC6 xc6P = this.e.d().n().o(this.f.e()).p();
            AbstractC13042fc3.h(xc6P, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return xc6P;
        }
    }

    public C4726Gh3(C9182Yv3 c9182Yv3, InterfaceC4009Dh3 interfaceC4009Dh3, C9424Zw2 c9424Zw2) {
        Collection collectionD;
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        this.a = c9424Zw2;
        JH6 jh6A = interfaceC4009Dh3 == null ? null : c9182Yv3.a().s().a(interfaceC4009Dh3);
        if (jh6A == null) {
            jh6A = JH6.a;
            AbstractC13042fc3.h(jh6A, "NO_SOURCE");
        }
        this.b = jh6A;
        this.c = c9182Yv3.e().c(new a(c9182Yv3, this));
        this.d = (interfaceC4009Dh3 == null || (collectionD = interfaceC4009Dh3.d()) == null) ? null : (InterfaceC4243Eh3) AbstractC15401jX0.r0(collectionD);
        this.e = AbstractC13042fc3.d(interfaceC4009Dh3 != null ? Boolean.valueOf(interfaceC4009Dh3.g()) : null, Boolean.TRUE);
    }

    protected final InterfaceC4243Eh3 a() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC21651tu
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public XC6 getType() {
        return (XC6) MN6.a(this.c, this, f[0]);
    }

    @Override // ir.nasim.InterfaceC21651tu
    public C9424Zw2 e() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC9301Zi5
    public boolean g() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public JH6 i() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC21651tu
    public Map j() {
        return AbstractC20051rO3.k();
    }
}
