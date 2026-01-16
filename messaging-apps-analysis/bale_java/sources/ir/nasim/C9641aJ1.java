package ir.nasim;

import ir.nasim.InterfaceC13485gJ1;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.ZI1;
import java.util.List;

/* renamed from: ir.nasim.aJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9641aJ1 extends C18920pU0 implements ZI1 {
    private final InterfaceC12258eJ1 A0;
    private InterfaceC13485gJ1.a B0;
    private final C6765Ow5 J;
    private final InterfaceC6692Oo4 Y;
    private final C7029Py7 Z;
    private final C10938cS7 z0;

    public /* synthetic */ C9641aJ1(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21426te1 interfaceC21426te1, InterfaceC4356Eu interfaceC4356Eu, boolean z, InterfaceC15194jA0.a aVar, C6765Ow5 c6765Ow5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1, JH6 jh6, int i, ED1 ed1) {
        this(interfaceC21331tU0, interfaceC21426te1, interfaceC4356Eu, z, aVar, c6765Ow5, interfaceC6692Oo4, c7029Py7, c10938cS7, interfaceC12258eJ1, (i & 1024) != 0 ? null : jh6);
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean C() {
        return false;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C7029Py7 E() {
        return this.Z;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public List G0() {
        return ZI1.a.a(this);
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C10938cS7 I() {
        return this.z0;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC6692Oo4 K() {
        return this.Y;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC12258eJ1 L() {
        return this.A0;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return false;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public boolean isSuspend() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C18920pU0
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public C9641aJ1 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(jh6, "source");
        C9641aJ1 c9641aJ1 = new C9641aJ1((InterfaceC21331tU0) interfaceC12795fB1, (InterfaceC21426te1) ab2, interfaceC4356Eu, this.G, aVar, g0(), K(), E(), I(), L(), jh6);
        c9641aJ1.X0(P0());
        c9641aJ1.t1(r1());
        return c9641aJ1;
    }

    public InterfaceC13485gJ1.a r1() {
        return this.B0;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public C6765Ow5 g0() {
        return this.J;
    }

    public void t1(InterfaceC13485gJ1.a aVar) {
        AbstractC13042fc3.i(aVar, "<set-?>");
        this.B0 = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9641aJ1(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21426te1 interfaceC21426te1, InterfaceC4356Eu interfaceC4356Eu, boolean z, InterfaceC15194jA0.a aVar, C6765Ow5 c6765Ow5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1, JH6 jh6) {
        super(interfaceC21331tU0, interfaceC21426te1, interfaceC4356Eu, z, aVar, jh6 == null ? JH6.a : jh6);
        AbstractC13042fc3.i(interfaceC21331tU0, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(c6765Ow5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(c10938cS7, "versionRequirementTable");
        this.J = c6765Ow5;
        this.Y = interfaceC6692Oo4;
        this.Z = c7029Py7;
        this.z0 = c10938cS7;
        this.A0 = interfaceC12258eJ1;
        this.B0 = InterfaceC13485gJ1.a.COMPATIBLE;
    }
}
