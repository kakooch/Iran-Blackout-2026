package ir.nasim;

import java.math.BigInteger;
import java.util.Objects;

/* renamed from: ir.nasim.al3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C9906al3 extends AbstractC22735vk3 {
    private final Object a;

    public C9906al3(Boolean bool) {
        Objects.requireNonNull(bool);
        this.a = bool;
    }

    private static boolean E(C9906al3 c9906al3) {
        Object obj = c9906al3.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public Number C() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new C8632Wu3((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean D() {
        return this.a instanceof Boolean;
    }

    public boolean F() {
        return this.a instanceof Number;
    }

    public boolean I() {
        return this.a instanceof String;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C9906al3.class != obj.getClass()) {
            return false;
        }
        C9906al3 c9906al3 = (C9906al3) obj;
        if (this.a == null) {
            return c9906al3.a == null;
        }
        if (E(this) && E(c9906al3)) {
            return C().longValue() == c9906al3.C().longValue();
        }
        Object obj2 = this.a;
        if (!(obj2 instanceof Number) || !(c9906al3.a instanceof Number)) {
            return obj2.equals(c9906al3.a);
        }
        double dDoubleValue = C().doubleValue();
        double dDoubleValue2 = c9906al3.C().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // ir.nasim.AbstractC22735vk3
    public boolean f() {
        return D() ? ((Boolean) this.a).booleanValue() : Boolean.parseBoolean(v());
    }

    @Override // ir.nasim.AbstractC22735vk3
    public double h() {
        return F() ? C().doubleValue() : Double.parseDouble(v());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (E(this)) {
            jDoubleToLongBits = C().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(C().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    @Override // ir.nasim.AbstractC22735vk3
    public int i() {
        return F() ? C().intValue() : Integer.parseInt(v());
    }

    @Override // ir.nasim.AbstractC22735vk3
    public long t() {
        return F() ? C().longValue() : Long.parseLong(v());
    }

    @Override // ir.nasim.AbstractC22735vk3
    public String v() {
        Object obj = this.a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (F()) {
            return C().toString();
        }
        if (D()) {
            return ((Boolean) this.a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.a.getClass());
    }

    public C9906al3(Number number) {
        Objects.requireNonNull(number);
        this.a = number;
    }

    public C9906al3(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }
}
