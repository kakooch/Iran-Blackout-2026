package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Nf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC6346Nf implements B.c {
    AdTargetType_UNKNOWN(0),
    AdTargetType_AUDIENCE(1),
    AdTargetType_CHANNEL(2),
    AdTargetType_CHANNELMEMBERS(3),
    AdTargetType_GENDER(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Nf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6346Nf a(int i2) {
            return EnumC6346Nf.j(i2);
        }
    };
    private final int a;

    EnumC6346Nf(int i2) {
        this.a = i2;
    }

    public static EnumC6346Nf j(int i2) {
        if (i2 == 0) {
            return AdTargetType_UNKNOWN;
        }
        if (i2 == 1) {
            return AdTargetType_AUDIENCE;
        }
        if (i2 == 2) {
            return AdTargetType_CHANNEL;
        }
        if (i2 == 3) {
            return AdTargetType_CHANNELMEMBERS;
        }
        if (i2 != 4) {
            return null;
        }
        return AdTargetType_GENDER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
