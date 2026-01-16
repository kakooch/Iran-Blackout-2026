package com.google.ads.interactivemedia.v3.internal;

import java.math.BigInteger;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ago extends agj {
    private static final Class<?>[] a = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    private Object b;

    public ago(Boolean bool) {
        a(bool);
    }

    private static boolean i(ago agoVar) {
        Object obj = agoVar.b;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    final void a(Object obj) {
        if (obj instanceof Character) {
            this.b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = false;
        if ((obj instanceof Number) || (obj instanceof String)) {
            z = true;
            break;
        }
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = a;
        for (int i = 0; i < 16; i++) {
            if (clsArr[i].isAssignableFrom(cls)) {
                z = true;
                break;
            }
        }
        com.google.ads.interactivemedia.v3.impl.data.ax.e(z);
        this.b = obj;
    }

    public final boolean b() {
        return this.b instanceof Boolean;
    }

    final Boolean c() {
        return (Boolean) this.b;
    }

    public final boolean d() {
        return b() ? c().booleanValue() : Boolean.parseBoolean(h());
    }

    public final boolean e() {
        return this.b instanceof Number;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ago.class != obj.getClass()) {
            return false;
        }
        ago agoVar = (ago) obj;
        if (this.b == null) {
            return agoVar.b == null;
        }
        if (i(this) && i(agoVar)) {
            return f().longValue() == agoVar.f().longValue();
        }
        Object obj2 = this.b;
        if (!(obj2 instanceof Number) || !(agoVar.b instanceof Number)) {
            return obj2.equals(agoVar.b);
        }
        double dDoubleValue = f().doubleValue();
        double dDoubleValue2 = agoVar.f().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    public final Number f() {
        Object obj = this.b;
        return obj instanceof String ? new ahu((String) obj) : (Number) obj;
    }

    public final boolean g() {
        return this.b instanceof String;
    }

    public final String h() {
        return e() ? f().toString() : b() ? c().toString() : (String) this.b;
    }

    public final int hashCode() {
        long jDoubleToLongBits;
        if (this.b == null) {
            return 31;
        }
        if (i(this)) {
            jDoubleToLongBits = f().longValue();
        } else {
            Object obj = this.b;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(f().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public ago(Number number) {
        a(number);
    }

    public ago(String str) {
        a(str);
    }
}
