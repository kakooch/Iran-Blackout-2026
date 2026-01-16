package ir.nasim;

import com.google.crypto.tink.shaded.protobuf.AbstractC2360w;

/* renamed from: ir.nasim.zU2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC24950zU2 implements AbstractC2360w.a {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);

    private static final AbstractC2360w.b i = new AbstractC2360w.b() { // from class: ir.nasim.zU2.a
    };
    private final int a;

    EnumC24950zU2(int i2) {
        this.a = i2;
    }

    public static EnumC24950zU2 a(int i2) {
        if (i2 == 0) {
            return UNKNOWN_HASH;
        }
        if (i2 == 1) {
            return SHA1;
        }
        if (i2 == 2) {
            return SHA384;
        }
        if (i2 == 3) {
            return SHA256;
        }
        if (i2 == 4) {
            return SHA512;
        }
        if (i2 != 5) {
            return null;
        }
        return SHA224;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
