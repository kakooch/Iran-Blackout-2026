package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;

/* renamed from: ir.nasim.Mo3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC6192Mo3 implements AbstractC2360w.a {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    private static final AbstractC2360w.b g = new AbstractC2360w.b() { // from class: ir.nasim.Mo3.a
    };
    private final int a;

    EnumC6192Mo3(int i) {
        this.a = i;
    }

    public static EnumC6192Mo3 a(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
