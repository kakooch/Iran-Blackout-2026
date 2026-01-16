package ir.nasim;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* loaded from: classes8.dex */
final class QE2 implements GenericArrayType, Type {
    private final Type a;

    public QE2(Type type) {
        AbstractC13042fc3.i(type, "elementType");
        this.a = type;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && AbstractC13042fc3.d(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return AbstractC22891vz7.h(this.a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
