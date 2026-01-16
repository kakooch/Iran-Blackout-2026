package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.ck7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC11283ck7 implements B.c {
    TaskRewardStatus_UNKNOWN(0),
    TaskRewardStatus_LOCKED(1),
    TaskRewardStatus_AVAILABLE(2),
    TaskRewardStatus_RECIVED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.ck7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC11283ck7 a(int i) {
            return EnumC11283ck7.j(i);
        }
    };
    private final int a;

    EnumC11283ck7(int i) {
        this.a = i;
    }

    public static EnumC11283ck7 j(int i) {
        if (i == 0) {
            return TaskRewardStatus_UNKNOWN;
        }
        if (i == 1) {
            return TaskRewardStatus_LOCKED;
        }
        if (i == 2) {
            return TaskRewardStatus_AVAILABLE;
        }
        if (i != 3) {
            return null;
        }
        return TaskRewardStatus_RECIVED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
