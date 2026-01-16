package ir.nasim;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes8.dex */
public abstract class C1 extends AbstractC13413gB1 implements ZI5 {
    private static final C6432No4 c = C6432No4.s("<this>");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1(InterfaceC4356Eu interfaceC4356Eu) {
        super(interfaceC4356Eu, c);
        if (interfaceC4356Eu == null) {
            x(0);
        }
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "substitutor";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getTypeParameters";
                break;
            case 3:
                objArr[1] = "getType";
                break;
            case 4:
                objArr[1] = "getValueParameters";
                break;
            case 5:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 6:
                objArr[1] = "getVisibility";
                break;
            case 7:
                objArr[1] = "getOriginal";
                break;
            case 8:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "substitute";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
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
    public Collection d() {
        Set setEmptySet = Collections.emptySet();
        if (setEmptySet == null) {
            x(5);
        }
        return setEmptySet;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        return getType();
    }

    @Override // ir.nasim.InterfaceC15936kQ7
    public AbstractC4099Dr3 getType() {
        AbstractC4099Dr3 type = getValue().getType();
        if (type == null) {
            x(3);
        }
        return type;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List getTypeParameters() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(2);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = QI1.f;
        if (ri1 == null) {
            x(6);
        }
        return ri1;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List h() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            x(4);
        }
        return listEmptyList;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return false;
    }

    @Override // ir.nasim.InterfaceC16386lB1
    public JH6 i() {
        JH6 jh6 = JH6.a;
        if (jh6 == null) {
            x(8);
        }
        return jh6;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.j(this, obj);
    }

    @Override // ir.nasim.InterfaceC19829r07
    public ZI5 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(1);
        }
        if (c5585Jy7.k()) {
            return this;
        }
        AbstractC4099Dr3 abstractC4099Dr3P = b() instanceof InterfaceC21331tU0 ? c5585Jy7.p(getType(), KQ7.OUT_VARIANCE) : c5585Jy7.p(getType(), KQ7.INVARIANT);
        if (abstractC4099Dr3P == null) {
            return null;
        }
        return abstractC4099Dr3P == getType() ? this : new C9645aJ5(b(), new C20982sv7(abstractC4099Dr3P), getAnnotations());
    }

    @Override // ir.nasim.AbstractC13413gB1, ir.nasim.InterfaceC12795fB1
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public InterfaceC17169mW4 a() {
        return this;
    }
}
