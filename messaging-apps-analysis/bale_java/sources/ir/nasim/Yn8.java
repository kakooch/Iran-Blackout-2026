package ir.nasim;

import com.google.android.gms.internal.clearcut.AbstractC2081f;

/* loaded from: classes3.dex */
public enum Yn8 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(AbstractC2081f.b),
    ENUM(null),
    MESSAGE(null);

    private final Object a;

    Yn8(Object obj) {
        this.a = obj;
    }
}
