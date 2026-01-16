package ir.nasim;

import ir.nasim.M17;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public class GU0 extends F0 implements InterfaceC13882gy7 {
    private final InterfaceC21331tU0 d;
    private final List e;
    private final Collection f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GU0(InterfaceC21331tU0 interfaceC21331tU0, List list, Collection collection, ON6 on6) {
        super(on6);
        if (interfaceC21331tU0 == null) {
            r(0);
        }
        if (list == null) {
            r(1);
        }
        if (collection == null) {
            r(2);
        }
        if (on6 == null) {
            r(3);
        }
        this.d = interfaceC21331tU0;
        this.e = Collections.unmodifiableList(new ArrayList(list));
        this.f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void r(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public boolean e() {
        return true;
    }

    @Override // ir.nasim.InterfaceC13882gy7
    public List getParameters() {
        List list = this.e;
        if (list == null) {
            r(4);
        }
        return list;
    }

    @Override // ir.nasim.AbstractC12686f2
    protected Collection h() {
        Collection collection = this.f;
        if (collection == null) {
            r(6);
        }
        return collection;
    }

    @Override // ir.nasim.AbstractC12686f2
    protected M17 l() {
        M17.a aVar = M17.a.a;
        if (aVar == null) {
            r(7);
        }
        return aVar;
    }

    @Override // ir.nasim.AbstractC12686f2, ir.nasim.InterfaceC13882gy7
    public InterfaceC21331tU0 t() {
        InterfaceC21331tU0 interfaceC21331tU0 = this.d;
        if (interfaceC21331tU0 == null) {
            r(5);
        }
        return interfaceC21331tU0;
    }

    public String toString() {
        return OI1.m(this.d).b();
    }
}
