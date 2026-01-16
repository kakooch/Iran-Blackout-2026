package ir.nasim;

import ir.nasim.InterfaceC13485gJ1;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.ZI1;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.mJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17049mJ1 extends KC6 implements ZI1 {
    private final C7950Tw5 G;
    private final InterfaceC6692Oo4 H;
    private final C7029Py7 J;
    private final C10938cS7 Y;
    private final InterfaceC12258eJ1 Z;
    private InterfaceC13485gJ1.a z0;

    public /* synthetic */ C17049mJ1(InterfaceC12795fB1 interfaceC12795fB1, JC6 jc6, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, C7950Tw5 c7950Tw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1, JH6 jh6, int i, ED1 ed1) {
        this(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No4, aVar, c7950Tw5, interfaceC6692Oo4, c7029Py7, c10938cS7, interfaceC12258eJ1, (i & 1024) != 0 ? null : jh6);
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C7029Py7 E() {
        return this.J;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public List G0() {
        return ZI1.a.a(this);
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public C10938cS7 I() {
        return this.Y;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC6692Oo4 K() {
        return this.H;
    }

    @Override // ir.nasim.KC6, ir.nasim.BB2
    protected BB2 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        C6432No4 c6432No42;
        AbstractC13042fc3.i(interfaceC12795fB1, "newOwner");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(jh6, "source");
        JC6 jc6 = (JC6) ab2;
        if (c6432No4 == null) {
            C6432No4 name = getName();
            AbstractC13042fc3.h(name, "name");
            c6432No42 = name;
        } else {
            c6432No42 = c6432No4;
        }
        C17049mJ1 c17049mJ1 = new C17049mJ1(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No42, aVar, g0(), K(), E(), I(), L(), jh6);
        c17049mJ1.X0(P0());
        c17049mJ1.z0 = o1();
        return c17049mJ1;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    public InterfaceC12258eJ1 L() {
        return this.Z;
    }

    public InterfaceC13485gJ1.a o1() {
        return this.z0;
    }

    @Override // ir.nasim.InterfaceC13485gJ1
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public C7950Tw5 g0() {
        return this.G;
    }

    public final KC6 q1(ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1, Map map, InterfaceC13485gJ1.a aVar) {
        AbstractC13042fc3.i(list, "typeParameters");
        AbstractC13042fc3.i(list2, "unsubstitutedValueParameters");
        AbstractC13042fc3.i(ri1, "visibility");
        AbstractC13042fc3.i(map, "userDataMap");
        AbstractC13042fc3.i(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        KC6 kc6N1 = super.n1(zi5, zi52, list, list2, abstractC4099Dr3, enumC11067cg4, ri1, map);
        AbstractC13042fc3.h(kc6N1, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.z0 = aVar;
        return kc6N1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17049mJ1(InterfaceC12795fB1 interfaceC12795fB1, JC6 jc6, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, C7950Tw5 c7950Tw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, C10938cS7 c10938cS7, InterfaceC12258eJ1 interfaceC12258eJ1, JH6 jh6) {
        super(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No4, aVar, jh6 == null ? JH6.a : jh6);
        AbstractC13042fc3.i(interfaceC12795fB1, "containingDeclaration");
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(c7950Tw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        AbstractC13042fc3.i(c10938cS7, "versionRequirementTable");
        this.G = c7950Tw5;
        this.H = interfaceC6692Oo4;
        this.J = c7029Py7;
        this.Y = c10938cS7;
        this.Z = interfaceC12258eJ1;
        this.z0 = InterfaceC13485gJ1.a.COMPATIBLE;
    }
}
