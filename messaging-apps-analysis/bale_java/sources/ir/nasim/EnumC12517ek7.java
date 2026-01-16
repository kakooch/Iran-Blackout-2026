package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.ek7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC12517ek7 implements B.c {
    TaskType_UNKNOWN(0),
    TaskType_VITRIN(1),
    TaskType_BALE_GUID(2),
    TaskType_CHARITY(3),
    TaskType_CHARGE(4),
    TaskType_C2C(5),
    TaskType_CROWD_FUNDING(6),
    TaskType_INTERNET(7),
    TaskType_MEHRABANI(8),
    TaskType_CLUB_POINT(9),
    TaskType_ARBAEEN_CHANNEL(10),
    TaskType_JOIN_GROUP(11),
    TaskType_SEND_PACKET(12),
    TaskType_BILL(13),
    UNRECOGNIZED(-1);

    private static final B.d q = new B.d() { // from class: ir.nasim.ek7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12517ek7 a(int i) {
            return EnumC12517ek7.j(i);
        }
    };
    private final int a;

    EnumC12517ek7(int i) {
        this.a = i;
    }

    public static EnumC12517ek7 j(int i) {
        switch (i) {
            case 0:
                return TaskType_UNKNOWN;
            case 1:
                return TaskType_VITRIN;
            case 2:
                return TaskType_BALE_GUID;
            case 3:
                return TaskType_CHARITY;
            case 4:
                return TaskType_CHARGE;
            case 5:
                return TaskType_C2C;
            case 6:
                return TaskType_CROWD_FUNDING;
            case 7:
                return TaskType_INTERNET;
            case 8:
                return TaskType_MEHRABANI;
            case 9:
                return TaskType_CLUB_POINT;
            case 10:
                return TaskType_ARBAEEN_CHANNEL;
            case 11:
                return TaskType_JOIN_GROUP;
            case 12:
                return TaskType_SEND_PACKET;
            case 13:
                return TaskType_BILL;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
