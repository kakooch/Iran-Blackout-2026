package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.pW4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C18942pW4 implements ParameterizedType, Type {
    private final Class a;
    private final Type b;
    private final Type[] c;

    /* renamed from: ir.nasim.pW4$a */
    /* synthetic */ class a extends EB2 implements UA2 {
        public static final a a = new a();

        a() {
            super(1, AbstractC22891vz7.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final String invoke(Type type) {
            AbstractC13042fc3.i(type, "p0");
            return AbstractC22891vz7.h(type);
        }
    }

    public C18942pW4(Class cls, Type type, List list) {
        AbstractC13042fc3.i(cls, "rawType");
        AbstractC13042fc3.i(list, "typeArguments");
        this.a = cls;
        this.b = type;
        this.c = (Type[]) list.toArray(new Type[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (AbstractC13042fc3.d(this.a, parameterizedType.getRawType()) && AbstractC13042fc3.d(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() throws IOException {
        StringBuilder sb = new StringBuilder();
        Type type = this.b;
        if (type != null) {
            sb.append(AbstractC22891vz7.h(type));
            sb.append("$");
            sb.append(this.a.getSimpleName());
        } else {
            sb.append(AbstractC22891vz7.h(this.a));
        }
        Type[] typeArr = this.c;
        if (!(typeArr.length == 0)) {
            AbstractC10242bK.w0(typeArr, sb, (null & 2) != 0 ? ", " : null, (null & 4) != 0 ? "" : Separators.LESS_THAN, (null & 8) == 0 ? Separators.GREATER_THAN : "", (null & 16) != 0 ? -1 : 0, (null & 32) != 0 ? "..." : null, (null & 64) != 0 ? null : a.a);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode();
        Type type = this.b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
