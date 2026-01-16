package ir.nasim;

import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class GQ7 extends AbstractC14602iB1 implements FQ7 {
    protected AbstractC4099Dr3 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GQ7(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, AbstractC4099Dr3 abstractC4099Dr3, JH6 jh6) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, jh6);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (c6432No4 == null) {
            x(2);
        }
        if (jh6 == null) {
            x(3);
        }
        this.e = abstractC4099Dr3;
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public void I0(AbstractC4099Dr3 abstractC4099Dr3) {
        this.e = abstractC4099Dr3;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 N() {
        return null;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public ZI5 Q() {
        return null;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        AbstractC4099Dr3 type = getType();
        if (type == null) {
            x(9);
        }
        return type;
    }

    @Override // ir.nasim.InterfaceC15936kQ7
    public AbstractC4099Dr3 getType() {
        AbstractC4099Dr3 abstractC4099Dr3 = this.e;
        if (abstractC4099Dr3 == null) {
            x(4);
        }
        return abstractC4099Dr3;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List getTypeParameters() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(8);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List h() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(6);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return false;
    }
}
