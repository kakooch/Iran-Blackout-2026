package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC15194jA0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.Ew5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4380Ew5 extends AbstractC19790qw5 implements InterfaceC4146Dw5 {
    private InterfaceC24919zQ7 m;
    private final InterfaceC4146Dw5 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C4380Ew5(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, boolean z2, boolean z3, InterfaceC15194jA0.a aVar, InterfaceC4146Dw5 interfaceC4146Dw5, JH6 jh6) {
        C4380Ew5 c4380Ew5;
        C4380Ew5 c4380Ew52;
        super(enumC11067cg4, ri1, interfaceC20989sw5, interfaceC4356Eu, C6432No4.s("<set-" + interfaceC20989sw5.getName() + Separators.GREATER_THAN), z, z2, z3, aVar, jh6);
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
        if (interfaceC4146Dw5 != 0) {
            c4380Ew52 = this;
            c4380Ew5 = interfaceC4146Dw5;
        } else {
            c4380Ew5 = this;
            c4380Ew52 = c4380Ew5;
        }
        c4380Ew52.n = c4380Ew5;
    }

    public static AQ7 N0(InterfaceC4146Dw5 interfaceC4146Dw5, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC4146Dw5 == null) {
            x(7);
        }
        if (abstractC4099Dr3 == null) {
            x(8);
        }
        if (interfaceC4356Eu == null) {
            x(9);
        }
        return new AQ7(interfaceC4146Dw5, null, 0, interfaceC4356Eu, C6432No4.s("<set-?>"), abstractC4099Dr3, false, false, false, null, JH6.a);
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    @Override // ir.nasim.AbstractC14602iB1
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public InterfaceC4146Dw5 a() {
        InterfaceC4146Dw5 interfaceC4146Dw5 = this.n;
        if (interfaceC4146Dw5 == null) {
            x(13);
        }
        return interfaceC4146Dw5;
    }

    public void P0(InterfaceC24919zQ7 interfaceC24919zQ7) {
        if (interfaceC24919zQ7 == null) {
            x(6);
        }
        this.m = interfaceC24919zQ7;
    }

    @Override // ir.nasim.AB2, ir.nasim.InterfaceC15194jA0, ir.nasim.InterfaceC14592iA0
    public Collection d() {
        Collection collectionJ0 = super.J0(false);
        if (collectionJ0 == null) {
            x(10);
        }
        return collectionJ0;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        XC6 xc6Y = PI1.g(this).Y();
        if (xc6Y == null) {
            x(12);
        }
        return xc6Y;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public List h() {
        InterfaceC24919zQ7 interfaceC24919zQ7 = this.m;
        if (interfaceC24919zQ7 == null) {
            throw new IllegalStateException();
        }
        List listSingletonList = Collections.singletonList(interfaceC24919zQ7);
        if (listSingletonList == null) {
            x(11);
        }
        return listSingletonList;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.i(this, obj);
    }
}
