package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.dk7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC11905dk7 implements B.c {
    TaskRewardType_UNKNOW(0),
    TaskRewardType_POINT(1),
    TaskRewardType_PACKET(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.dk7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11905dk7 a(int i) {
            return EnumC11905dk7.j(i);
        }
    };
    private final int a;

    EnumC11905dk7(int i) {
        this.a = i;
    }

    public static EnumC11905dk7 j(int i) {
        if (i == 0) {
            return TaskRewardType_UNKNOW;
        }
        if (i == 1) {
            return TaskRewardType_POINT;
        }
        if (i != 2) {
            return null;
        }
        return TaskRewardType_PACKET;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
