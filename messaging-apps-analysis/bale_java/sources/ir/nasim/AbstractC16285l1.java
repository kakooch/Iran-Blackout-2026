package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* renamed from: ir.nasim.l1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC16285l1 implements Map.Entry {
    AbstractC16285l1() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return EG4.a(getKey(), entry.getKey()) && EG4.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public abstract Object getKey();

    @Override // java.util.Map.Entry
    public abstract Object getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String toString() {
        String strValueOf = String.valueOf(getKey());
        String strValueOf2 = String.valueOf(getValue());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(Separators.EQUALS);
        sb.append(strValueOf2);
        return sb.toString();
    }
}
