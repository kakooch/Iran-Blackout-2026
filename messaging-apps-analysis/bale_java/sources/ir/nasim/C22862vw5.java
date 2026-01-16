package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.vw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C22862vw5 extends AbstractC19790qw5 implements InterfaceC22266uw5 {
    private AbstractC4099Dr3 m;
    private final InterfaceC22266uw5 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C22862vw5(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, boolean z2, boolean z3, InterfaceC15194jA0.a aVar, InterfaceC22266uw5 interfaceC22266uw5, JH6 jh6) {
        C22862vw5 c22862vw5;
        C22862vw5 c22862vw52;
        super(enumC11067cg4, ri1, interfaceC20989sw5, interfaceC4356Eu, C6432No4.s("<get-" + interfaceC20989sw5.getName() + Separators.GREATER_THAN), z, z2, z3, aVar, jh6);
        if (interfaceC20989sw5 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (enumC11067cg4 == null) {
            x(2);
        }
        if (ri1 == null) {
            x(3);
        }
        if (aVar == null) {
            x(4);
        }
        if (jh6 == null) {
            x(5);
        }
        if (interfaceC22266uw5 != 0) {
            c22862vw52 = this;
            c22862vw5 = interfaceC22266uw5;
        } else {
            c22862vw5 = this;
            c22862vw52 = c22862vw5;
        }
        c22862vw52.n = c22862vw5;
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.AbstractC14602iB1
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public InterfaceC22266uw5 a() {
        InterfaceC22266uw5 interfaceC22266uw5 = this.n;
        if (interfaceC22266uw5 == null) {
            x(8);
        }
        return interfaceC22266uw5;
    }

    public void O0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            abstractC4099Dr3 = V().getType();
        }
        this.m = abstractC4099Dr3;
    }

    @Override // ir.nasim.AB2, ir.nasim.InterfaceC15194jA0, ir.nasim.InterfaceC14592iA0
    public Collection d() {
        Collection collectionJ0 = super.J0(true);
        if (collectionJ0 == null) {
            x(6);
        }
        return collectionJ0;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List h() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(7);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.c(this, obj);
    }
}
