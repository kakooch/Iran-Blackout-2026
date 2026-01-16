package ir.nasim;

import ir.nasim.W24;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.dm4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C11922dm4 extends AbstractC21988uU0 {
    private final AU0 i;
    private final boolean j;
    private EnumC11067cg4 k;
    private RI1 l;
    private InterfaceC13882gy7 m;
    private List n;
    private final Collection o;
    private final ON6 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11922dm4(InterfaceC12795fB1 interfaceC12795fB1, AU0 au0, boolean z, boolean z2, C6432No4 c6432No4, JH6 jh6, ON6 on6) {
        super(on6, interfaceC12795fB1, c6432No4, jh6, z2);
        if (interfaceC12795fB1 == null) {
            i0(0);
        }
        if (au0 == null) {
            i0(1);
        }
        if (c6432No4 == null) {
            i0(2);
        }
        if (jh6 == null) {
            i0(3);
        }
        if (on6 == null) {
            i0(4);
        }
        this.o = new ArrayList();
        this.p = on6;
        this.i = au0;
        this.j = z;
    }

    private static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return false;
    }

    public void J0() {
        this.m = new GU0(this, this.n, this.o, this.p);
        Iterator it = k().iterator();
        while (it.hasNext()) {
            ((C18920pU0) ((InterfaceC18329oU0) it.next())).f1(p());
        }
    }

    @Override // ir.nasim.InterfaceC21331tU0
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public Set k() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            i0(13);
        }
        return setEmptySet;
    }

    public void L0(EnumC11067cg4 enumC11067cg4) {
        if (enumC11067cg4 == null) {
            i0(6);
        }
        this.k = enumC11067cg4;
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 M(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            i0(16);
        }
        W24.b bVar = W24.b.b;
        if (bVar == null) {
            i0(17);
        }
        return bVar;
    }

    public void M0(List list) {
        if (list == null) {
            i0(14);
        }
        if (this.n == null) {
            this.n = new ArrayList(list);
            return;
        }
        throw new IllegalStateException("Type parameters are already set for " + getName());
    }

    public void N0(RI1 ri1) {
        if (ri1 == null) {
            i0(9);
        }
        this.l = ri1;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean b0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public AU0 f() {
        AU0 au0 = this.i;
        if (au0 == null) {
            i0(8);
        }
        return au0;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean f0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        InterfaceC4356Eu interfaceC4356EuB = InterfaceC4356Eu.W.b();
        if (interfaceC4356EuB == null) {
            i0(5);
        }
        return interfaceC4356EuB;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = this.l;
        if (ri1 == null) {
            i0(10);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        InterfaceC13882gy7 interfaceC13882gy7 = this.m;
        if (interfaceC13882gy7 == null) {
            i0(11);
        }
        return interfaceC13882gy7;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean k0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 m0() {
        W24.b bVar = W24.b.b;
        if (bVar == null) {
            i0(18);
        }
        return bVar;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        List list = this.n;
        if (list == null) {
            i0(15);
        }
        return list;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = this.k;
        if (enumC11067cg4 == null) {
            i0(7);
        }
        return enumC11067cg4;
    }

    public String toString() {
        return AbstractC13413gB1.M(this);
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection y() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            i0(19);
        }
        return listEmptyList;
    }
}
