package ir.nasim;

import ir.nasim.W24;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.wU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C23174wU0 extends AbstractC21988uU0 {
    private final EnumC11067cg4 i;
    private final AU0 j;
    private final InterfaceC13882gy7 k;
    private W24 l;
    private Set m;
    private InterfaceC18329oU0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C23174wU0(InterfaceC12795fB1 interfaceC12795fB1, C6432No4 c6432No4, EnumC11067cg4 enumC11067cg4, AU0 au0, Collection collection, JH6 jh6, boolean z, ON6 on6) {
        super(on6, interfaceC12795fB1, c6432No4, jh6, z);
        if (interfaceC12795fB1 == null) {
            i0(0);
        }
        if (c6432No4 == null) {
            i0(1);
        }
        if (enumC11067cg4 == null) {
            i0(2);
        }
        if (au0 == null) {
            i0(3);
        }
        if (collection == null) {
            i0(4);
        }
        if (jh6 == null) {
            i0(5);
        }
        if (on6 == null) {
            i0(6);
        }
        this.i = enumC11067cg4;
        this.j = au0;
        this.k = new GU0(this, Collections.emptyList(), collection, on6);
    }

    private static /* synthetic */ void i0(int i) {
        String str;
        int i2;
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "supertypes";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 8:
                objArr[0] = "constructors";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 12:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 9:
                objArr[1] = "getAnnotations";
                break;
            case 10:
                objArr[1] = "getTypeConstructor";
                break;
            case 11:
                objArr[1] = "getConstructors";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorImpl";
                break;
            case 13:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 14:
                objArr[1] = "getStaticScope";
                break;
            case 15:
                objArr[1] = "getKind";
                break;
            case 16:
                objArr[1] = "getModality";
                break;
            case 17:
                objArr[1] = "getVisibility";
                break;
            case 18:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 19:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 7:
            case 8:
                objArr[2] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                break;
            case 12:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.NU0
    public boolean A() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC18329oU0 D() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean F0() {
        return false;
    }

    public final void J0(W24 w24, Set set, InterfaceC18329oU0 interfaceC18329oU0) {
        if (w24 == null) {
            i0(7);
        }
        if (set == null) {
            i0(8);
        }
        this.l = w24;
        this.m = set;
        this.n = interfaceC18329oU0;
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 M(AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5284Ir3 == null) {
            i0(12);
        }
        W24 w24 = this.l;
        if (w24 == null) {
            i0(13);
        }
        return w24;
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
        AU0 au0 = this.j;
        if (au0 == null) {
            i0(15);
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
            i0(9);
        }
        return interfaceC4356EuB;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = QI1.e;
        if (ri1 == null) {
            i0(17);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public boolean isInline() {
        return false;
    }

    @Override // ir.nasim.MU0
    public InterfaceC13882gy7 j() {
        InterfaceC13882gy7 interfaceC13882gy7 = this.k;
        if (interfaceC13882gy7 == null) {
            i0(10);
        }
        return interfaceC13882gy7;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public Collection k() {
        Set set = this.m;
        if (set == null) {
            i0(11);
        }
        return set;
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
            i0(14);
        }
        return bVar;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public InterfaceC21331tU0 n0() {
        return null;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.NU0
    public List q() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            i0(18);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = this.i;
        if (enumC11067cg4 == null) {
            i0(16);
        }
        return enumC11067cg4;
    }

    public String toString() {
        return "class " + getName();
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
