package ir.nasim;

import ir.nasim.RL5;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes8.dex */
public final class BL5 extends RL5 implements InterfaceC5896Lh3 {
    private final Type b;
    private final RL5 c;
    private final Collection d;
    private final boolean e;

    public BL5(Type type) {
        RL5 rl5A;
        AbstractC13042fc3.i(type, "reflectType");
        this.b = type;
        Type typeR = R();
        if (!(typeR instanceof GenericArrayType)) {
            if (typeR instanceof Class) {
                Class cls = (Class) typeR;
                if (cls.isArray()) {
                    RL5.a aVar = RL5.a;
                    Class<?> componentType = cls.getComponentType();
                    AbstractC13042fc3.h(componentType, "getComponentType()");
                    rl5A = aVar.a(componentType);
                }
            }
            throw new IllegalArgumentException("Not an array type (" + R().getClass() + "): " + R());
        }
        RL5.a aVar2 = RL5.a;
        Type genericComponentType = ((GenericArrayType) typeR).getGenericComponentType();
        AbstractC13042fc3.h(genericComponentType, "genericComponentType");
        rl5A = aVar2.a(genericComponentType);
        this.c = rl5A;
        this.d = AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return this.e;
    }

    @Override // ir.nasim.RL5
    protected Type R() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC5896Lh3
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public RL5 m() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public Collection getAnnotations() {
        return this.d;
    }
}
