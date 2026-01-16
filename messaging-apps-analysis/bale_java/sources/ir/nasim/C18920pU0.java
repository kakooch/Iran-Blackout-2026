package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.pU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C18920pU0 extends BB2 implements InterfaceC18329oU0 {
    private static final C6432No4 H = C6432No4.s("<init>");
    protected final boolean G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C18920pU0(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21426te1 interfaceC21426te1, InterfaceC4356Eu interfaceC4356Eu, boolean z, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC21331tU0, interfaceC21426te1, interfaceC4356Eu, H, aVar, jh6);
        if (interfaceC21331tU0 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (aVar == null) {
            x(2);
        }
        if (jh6 == null) {
            x(3);
        }
        this.G = z;
    }

    public static C18920pU0 l1(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC4356Eu interfaceC4356Eu, boolean z, JH6 jh6) {
        if (interfaceC21331tU0 == null) {
            x(4);
        }
        if (interfaceC4356Eu == null) {
            x(5);
        }
        if (jh6 == null) {
            x(6);
        }
        return new C18920pU0(interfaceC21331tU0, null, interfaceC4356Eu, z, InterfaceC15194jA0.a.DECLARATION, jh6);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void x(int r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18920pU0.x(int):void");
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC15194jA0
    public void D0(Collection collection) {
        if (collection == null) {
            x(20);
        }
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2, ir.nasim.InterfaceC15194jA0, ir.nasim.InterfaceC14592iA0
    public Collection d() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            x(19);
        }
        return setEmptySet;
    }

    @Override // ir.nasim.InterfaceC21426te1
    public boolean d0() {
        return this.G;
    }

    @Override // ir.nasim.InterfaceC21426te1
    public InterfaceC21331tU0 e0() {
        InterfaceC21331tU0 interfaceC21331tU0B = b();
        if (interfaceC21331tU0B == null) {
            x(16);
        }
        return interfaceC21331tU0B;
    }

    public ZI5 j1() {
        InterfaceC21331tU0 interfaceC21331tU0B = b();
        if (!interfaceC21331tU0B.A()) {
            return null;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC21331tU0B.b();
        if (interfaceC12795fB1B instanceof InterfaceC21331tU0) {
            return ((InterfaceC21331tU0) interfaceC12795fB1B).H0();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public InterfaceC18329oU0 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        InterfaceC18329oU0 interfaceC18329oU0 = (InterfaceC18329oU0) super.J0(interfaceC12795fB1, enumC11067cg4, ri1, aVar, z);
        if (interfaceC18329oU0 == null) {
            x(25);
        }
        return interfaceC18329oU0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.BB2
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public C18920pU0 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(21);
        }
        if (aVar == null) {
            x(22);
        }
        if (interfaceC4356Eu == null) {
            x(23);
        }
        if (jh6 == null) {
            x(24);
        }
        InterfaceC15194jA0.a aVar2 = InterfaceC15194jA0.a.DECLARATION;
        if (aVar == aVar2 || aVar == InterfaceC15194jA0.a.SYNTHESIZED) {
            return new C18920pU0((InterfaceC21331tU0) interfaceC12795fB1, this, interfaceC4356Eu, this.G, aVar2, jh6);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + Separators.RETURN + "newOwner: " + interfaceC12795fB1 + Separators.RETURN + "kind: " + aVar);
    }

    @Override // ir.nasim.AbstractC14602iB1, ir.nasim.InterfaceC12795fB1
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public InterfaceC21331tU0 b() {
        InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) super.b();
        if (interfaceC21331tU0 == null) {
            x(15);
        }
        return interfaceC21331tU0;
    }

    public C18920pU0 o1(List list, RI1 ri1) {
        if (list == null) {
            x(13);
        }
        if (ri1 == null) {
            x(14);
        }
        p1(list, ri1, b().q());
        return this;
    }

    public C18920pU0 p1(List list, RI1 ri1, List list2) {
        if (list == null) {
            x(10);
        }
        if (ri1 == null) {
            x(11);
        }
        if (list2 == null) {
            x(12);
        }
        super.Q0(null, j1(), list2, list, null, EnumC11067cg4.FINAL, ri1);
        return this;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.k(this, obj);
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2, ir.nasim.InterfaceC19829r07
    public InterfaceC18329oU0 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(18);
        }
        return (InterfaceC18329oU0) super.c(c5585Jy7);
    }

    @Override // ir.nasim.AbstractC14602iB1
    public InterfaceC18329oU0 a() {
        InterfaceC18329oU0 interfaceC18329oU0 = (InterfaceC18329oU0) super.a();
        if (interfaceC18329oU0 == null) {
            x(17);
        }
        return interfaceC18329oU0;
    }
}
