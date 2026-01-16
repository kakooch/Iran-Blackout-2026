package ir.nasim;

import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.qw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC19790qw5 extends AbstractC14602iB1 implements InterfaceC19199pw5 {
    private boolean e;
    private final boolean f;
    private final EnumC11067cg4 g;
    private final InterfaceC20989sw5 h;
    private final boolean i;
    private final InterfaceC15194jA0.a j;
    private RI1 k;
    private AB2 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC19790qw5(EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, boolean z, boolean z2, boolean z3, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC20989sw5.b(), interfaceC4356Eu, c6432No4, jh6);
        if (enumC11067cg4 == null) {
            x(0);
        }
        if (ri1 == null) {
            x(1);
        }
        if (interfaceC20989sw5 == null) {
            x(2);
        }
        if (interfaceC4356Eu == null) {
            x(3);
        }
        if (c6432No4 == null) {
            x(4);
        }
        if (jh6 == null) {
            x(5);
        }
        this.l = null;
        this.g = enumC11067cg4;
        this.k = ri1;
        this.h = interfaceC20989sw5;
        this.e = z;
        this.f = z2;
        this.i = z3;
        this.j = aVar;
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 14:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getModality";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 12:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 13:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 14:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            case 7:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.AB2
    public boolean B0() {
        return false;
    }

    @Override // ir.nasim.AB2
    public boolean C() {
        return false;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public Object C0(InterfaceC14592iA0.a aVar) {
        return null;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public void D0(Collection collection) {
        if (collection == null) {
            x(14);
        }
    }

    @Override // ir.nasim.AB2
    public boolean E0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC19199pw5
    public boolean F() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public InterfaceC19199pw5 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    protected Collection J0(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (InterfaceC20989sw5 interfaceC20989sw5 : V().d()) {
            InterfaceC10612bu interfaceC10612buG = z ? interfaceC20989sw5.g() : interfaceC20989sw5.J();
            if (interfaceC10612buG != null) {
                arrayList.add(interfaceC10612buG);
            }
        }
        return arrayList;
    }

    public void K0(boolean z) {
        this.e = z;
    }

    public void L0(AB2 ab2) {
        this.l = ab2;
    }

    public void M0(RI1 ri1) {
        this.k = ri1;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 N() {
        return V().N();
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 Q() {
        return V().Q();
    }

    @Override // ir.nasim.InterfaceC19199pw5
    public InterfaceC20989sw5 V() {
        InterfaceC20989sw5 interfaceC20989sw5 = this.h;
        if (interfaceC20989sw5 == null) {
            x(12);
        }
        return interfaceC20989sw5;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return false;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public InterfaceC15194jA0.a f() {
        InterfaceC15194jA0.a aVar = this.j;
        if (aVar == null) {
            x(6);
        }
        return aVar;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List getTypeParameters() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(8);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = this.k;
        if (ri1 == null) {
            x(10);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean isExternal() {
        return this.f;
    }

    @Override // ir.nasim.AB2
    public boolean isInfix() {
        return false;
    }

    @Override // ir.nasim.AB2
    public boolean isInline() {
        return this.i;
    }

    @Override // ir.nasim.AB2
    public boolean isOperator() {
        return false;
    }

    @Override // ir.nasim.AB2
    public boolean isSuspend() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = this.g;
        if (enumC11067cg4 == null) {
            x(9);
        }
        return enumC11067cg4;
    }

    @Override // ir.nasim.AB2
    public AB2 s0() {
        return this.l;
    }

    @Override // ir.nasim.InterfaceC19829r07
    public AB2 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(7);
        }
        throw new UnsupportedOperationException();
    }
}
