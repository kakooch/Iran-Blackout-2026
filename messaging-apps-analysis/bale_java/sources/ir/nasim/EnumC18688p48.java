package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.p48, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC18688p48 implements B.c {
    PacketType_UNKNOWN(0),
    PacketType_FIRST_TRANSACTION(1),
    PacketType_ENTER_TOWN(2),
    PacketType_TREASURE(3),
    PacketType_REFERALL(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.p48.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18688p48 a(int i2) {
            return EnumC18688p48.j(i2);
        }
    };
    private final int a;

    EnumC18688p48(int i2) {
        this.a = i2;
    }

    public static EnumC18688p48 j(int i2) {
        if (i2 == 0) {
            return PacketType_UNKNOWN;
        }
        if (i2 == 1) {
            return PacketType_FIRST_TRANSACTION;
        }
        if (i2 == 2) {
            return PacketType_ENTER_TOWN;
        }
        if (i2 == 3) {
            return PacketType_TREASURE;
        }
        if (i2 != 4) {
            return null;
        }
        return PacketType_REFERALL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
