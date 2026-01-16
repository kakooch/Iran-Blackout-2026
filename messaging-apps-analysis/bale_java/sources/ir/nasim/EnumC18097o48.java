package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.o48, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC18097o48 implements B.c {
    PacketStatus_UNKNOWN(0),
    PacketStatus_HIDDEN(1),
    PacketStatus_LOCKED(2),
    PacketStatus_INPROGRESS(3),
    PacketStatus_COMPLETED(4),
    PacketStatus_RECEIVED(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.o48.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC18097o48 a(int i2) {
            return EnumC18097o48.j(i2);
        }
    };
    private final int a;

    EnumC18097o48(int i2) {
        this.a = i2;
    }

    public static EnumC18097o48 j(int i2) {
        if (i2 == 0) {
            return PacketStatus_UNKNOWN;
        }
        if (i2 == 1) {
            return PacketStatus_HIDDEN;
        }
        if (i2 == 2) {
            return PacketStatus_LOCKED;
        }
        if (i2 == 3) {
            return PacketStatus_INPROGRESS;
        }
        if (i2 == 4) {
            return PacketStatus_COMPLETED;
        }
        if (i2 != 5) {
            return null;
        }
        return PacketStatus_RECEIVED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
