package j$.util;

import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public final class Optional<T> {
    private static final Optional a = new Optional();
    private final Object b;

    private Optional() {
        this.b = null;
    }

    private Optional(Object obj) {
        obj.getClass();
        this.b = obj;
    }

    public static Optional empty() {
        return a;
    }

    public static Optional of(Object obj) {
        return new Optional(obj);
    }

    public Object a() {
        Object obj = this.b;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return j$.time.a.y(this.b, ((Optional) obj).b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.b;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isPresent() {
        return this.b != null;
    }

    public String toString() {
        Object obj = this.b;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }
}
