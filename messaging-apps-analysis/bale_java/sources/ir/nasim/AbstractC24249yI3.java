package ir.nasim;

import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.yI3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24249yI3 {
    public static final int a(Object obj) {
        int iHashCode;
        AbstractC13042fc3.i(obj, "<this>");
        if (obj instanceof Number) {
            Number number = (Number) obj;
            iHashCode = number instanceof Long ? obj.hashCode() : number instanceof Integer ? Long.hashCode(number.intValue()) : number instanceof Float ? Integer.hashCode(Float.floatToIntBits(number.floatValue())) : number instanceof Double ? Long.hashCode(Double.doubleToLongBits(number.doubleValue())) : obj.toString().hashCode();
        } else {
            iHashCode = obj instanceof String ? obj.hashCode() : obj.hashCode();
        }
        return Math.abs(iHashCode) % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;
    }
}
