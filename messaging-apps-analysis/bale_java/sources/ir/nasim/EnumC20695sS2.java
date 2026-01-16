package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.sS2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC20695sS2 implements B.c {
    GetGroupMode_UNKNOWN(0),
    GetGroupMode_GROUPS(1),
    GetGroupMode_CHANNELS(2),
    GetGroupMode_BOTH(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.sS2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC20695sS2 a(int i) {
            return EnumC20695sS2.j(i);
        }
    };
    private final int a;

    EnumC20695sS2(int i) {
        this.a = i;
    }

    public static EnumC20695sS2 j(int i) {
        if (i == 0) {
            return GetGroupMode_UNKNOWN;
        }
        if (i == 1) {
            return GetGroupMode_GROUPS;
        }
        if (i == 2) {
            return GetGroupMode_CHANNELS;
        }
        if (i != 3) {
            return null;
        }
        return GetGroupMode_BOTH;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
