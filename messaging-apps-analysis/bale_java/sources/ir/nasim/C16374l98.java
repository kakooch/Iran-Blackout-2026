package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* renamed from: ir.nasim.l98, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C16374l98 implements WildcardType, Type {
    public static final a c = new a(null);
    private static final C16374l98 d = new C16374l98(null, null);
    private final Type a;
    private final Type b;

    /* renamed from: ir.nasim.l98$a */
    public static final class a {
        private a() {
        }

        public final C16374l98 a() {
            return C16374l98.d;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C16374l98(Type type, Type type2) {
        this.a = type;
        this.b = type2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type type = this.b;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        if (this.b != null) {
            return "? super " + AbstractC22891vz7.h(this.b);
        }
        Type type = this.a;
        if (type == null || AbstractC13042fc3.d(type, Object.class)) {
            return Separators.QUESTION;
        }
        return "? extends " + AbstractC22891vz7.h(this.a);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type type = this.a;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public String toString() {
        return getTypeName();
    }
}
