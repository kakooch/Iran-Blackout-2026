package ir.nasim;

import ir.nasim.InterfaceC6138Mi3;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: classes8.dex */
public abstract class RL5 implements InterfaceC6138Mi3 {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public final RL5 a(Type type) {
            AbstractC13042fc3.i(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new QL5(cls);
                }
            }
            return ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) ? new BL5(type) : type instanceof WildcardType ? new UL5((WildcardType) type) : new GL5(type);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    protected abstract Type R();

    public boolean equals(Object obj) {
        return (obj instanceof RL5) && AbstractC13042fc3.d(R(), ((RL5) obj).R());
    }

    public int hashCode() {
        return R().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + R();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public InterfaceC4009Dh3 z(C9424Zw2 c9424Zw2) {
        return InterfaceC6138Mi3.a.a(this, c9424Zw2);
    }
}
