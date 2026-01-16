package ir.nasim;

import ir.nasim.InterfaceC13485gJ1;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.ZI1;
import java.util.List;

/* renamed from: ir.nasim.lJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C16458lJ1 extends C21676tw5 implements ZI1 {
    private final C9193Yw5 A;
    private final InterfaceC6692Oo4 B;
    private final C7029Py7 D;
    private final C10938cS7 G;
    private final InterfaceC12258eJ1 H;
    private InterfaceC13485gJ1.a J;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16458lJ1(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, C9193Yw5 c9193Yw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1) {
        super(interfaceC12795fB1, interfaceC20989sw5, interfaceC4356Eu, enumC11067cg4, ri1, z, c6432No4, aVar, JH6.a, z2, z3, z6, false, z4, z5);
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(enumC11067cg4, "modality");
        AbstractC13042fc3.i(ri1, "visibility");
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(c10938cS7, "versionRequirementTable");
        this.A = c9193Yw5;
        this.B = interfaceC6692Oo4;
        this.D = c7029Py7;
        this.G = c10938cS7;
        this.H = interfaceC12258eJ1;
        this.J = InterfaceC13485gJ1.a.COMPATIBLE;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C7029Py7 E() {
        return this.D;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public List G0() {
        return ZI1.a.a(this);
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C10938cS7 I() {
        return this.G;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC6692Oo4 K() {
        return this.B;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC12258eJ1 L() {
        return this.H;
    }

    @Override // ir.nasim.C21676tw5
    protected C21676tw5 N0(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, JH6 jh6) {
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(enumC11067cg4, "newModality");
        AbstractC13042fc3.i(ri1, "newVisibility");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(c6432No4, "newName");
        AbstractC13042fc3.i(jh6, "source");
        return new C16458lJ1(interfaceC12795fB1, interfaceC20989sw5, getAnnotations(), enumC11067cg4, ri1, P(), c6432No4, aVar, w0(), c0(), isExternal(), B(), l0(), g0(), K(), E(), I(), L());
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public C9193Yw5 g0() {
        return this.A;
    }

    public final void b1(C22862vw5 c22862vw5, InterfaceC4146Dw5 interfaceC4146Dw5, InterfaceC25104zk2 interfaceC25104zk2, InterfaceC25104zk2 interfaceC25104zk22, InterfaceC13485gJ1.a aVar) {
        AbstractC13042fc3.i(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.T0(c22862vw5, interfaceC4146Dw5, interfaceC25104zk2, interfaceC25104zk22);
        C19938rB7 c19938rB7 = C19938rB7.a;
        this.J = aVar;
    }

    @Override // ir.nasim.C21676tw5, ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        Boolean boolD = AbstractC5031Hp2.C.d(g0().W());
        AbstractC13042fc3.h(boolD, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return boolD.booleanValue();
    }
}
