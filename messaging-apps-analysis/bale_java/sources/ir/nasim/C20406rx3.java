package ir.nasim;

import ir.nasim.OS4;
import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.rx3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20406rx3 extends AbstractC13413gB1 implements OS4 {
    static final /* synthetic */ InterfaceC5239Im3[] g = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C20406rx3.class), "fragments", "getFragments()Ljava/util/List;"))};
    private final C8773Xg4 c;
    private final C9424Zw2 d;
    private final InterfaceC23016wC4 e;
    private final W24 f;

    /* renamed from: ir.nasim.rx3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return CS4.b(C20406rx3.this.A0().O0(), C20406rx3.this.e());
        }
    }

    /* renamed from: ir.nasim.rx3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24 invoke() {
            if (C20406rx3.this.j0().isEmpty()) {
                return W24.b.b;
            }
            List listJ0 = C20406rx3.this.j0();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
            Iterator it = listJ0.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC24340yS4) it.next()).o());
            }
            List listS0 = AbstractC15401jX0.S0(arrayList, new C12083e07(C20406rx3.this.A0(), C20406rx3.this.e()));
            return C15266jI0.d.a("package view scope for " + C20406rx3.this.e() + " in " + C20406rx3.this.A0().getName(), listS0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20406rx3(C8773Xg4 c8773Xg4, C9424Zw2 c9424Zw2, ON6 on6) {
        super(InterfaceC4356Eu.W.b(), c9424Zw2.h());
        AbstractC13042fc3.i(c8773Xg4, "module");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(on6, "storageManager");
        this.c = c8773Xg4;
        this.d = c9424Zw2;
        this.e = on6.c(new a());
        this.f = new C23459wx3(on6, new b());
    }

    @Override // ir.nasim.OS4
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public C8773Xg4 A0() {
        return this.c;
    }

    @Override // ir.nasim.OS4
    public C9424Zw2 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        OS4 os4 = obj instanceof OS4 ? (OS4) obj : null;
        return os4 != null && AbstractC13042fc3.d(e(), os4.e()) && AbstractC13042fc3.d(A0(), os4.A0());
    }

    public int hashCode() {
        return (A0().hashCode() * 31) + e().hashCode();
    }

    @Override // ir.nasim.InterfaceC12795fB1
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public OS4 b() {
        if (e().d()) {
            return null;
        }
        C8773Xg4 c8773Xg4A0 = A0();
        C9424Zw2 c9424Zw2E = e().e();
        AbstractC13042fc3.h(c9424Zw2E, "fqName.parent()");
        return c8773Xg4A0.z0(c9424Zw2E);
    }

    @Override // ir.nasim.OS4
    public boolean isEmpty() {
        return OS4.a.a(this);
    }

    @Override // ir.nasim.OS4
    public List j0() {
        return (List) MN6.a(this.e, this, g[0]);
    }

    @Override // ir.nasim.OS4
    public W24 o() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        AbstractC13042fc3.i(interfaceC15204jB1, "visitor");
        return interfaceC15204jB1.h(this, obj);
    }
}
