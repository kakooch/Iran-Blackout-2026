package ir.nasim;

import ir.nasim.RL5;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class GL5 extends RL5 implements InterfaceC9056Yh3 {
    private final Type b;
    private final InterfaceC8781Xh3 c;

    public GL5(Type type) {
        InterfaceC8781Xh3 cl5;
        AbstractC13042fc3.i(type, "reflectType");
        this.b = type;
        Type typeR = R();
        if (typeR instanceof Class) {
            cl5 = new CL5((Class) typeR);
        } else if (typeR instanceof TypeVariable) {
            cl5 = new SL5((TypeVariable) typeR);
        } else {
            if (!(typeR instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + typeR.getClass() + "): " + typeR);
            }
            Type rawType = ((ParameterizedType) typeR).getRawType();
            if (rawType == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            cl5 = new CL5((Class) rawType);
        }
        this.c = cl5;
    }

    @Override // ir.nasim.InterfaceC9056Yh3
    public List A() {
        List listE = AbstractC21912uL5.e(R());
        RL5.a aVar = RL5.a;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listE, 10));
        Iterator it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return false;
    }

    @Override // ir.nasim.InterfaceC9056Yh3
    public String G() {
        return R().toString();
    }

    @Override // ir.nasim.InterfaceC9056Yh3
    public String I() {
        throw new UnsupportedOperationException(AbstractC13042fc3.q("Type not found: ", R()));
    }

    @Override // ir.nasim.RL5
    public Type R() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC9056Yh3
    public InterfaceC8781Xh3 a() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public Collection getAnnotations() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC9056Yh3
    public boolean s() {
        Type typeR = R();
        if (!(typeR instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) typeR).getTypeParameters();
        AbstractC13042fc3.h(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }

    @Override // ir.nasim.RL5, ir.nasim.InterfaceC5194Ih3
    public InterfaceC4009Dh3 z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return null;
    }
}
