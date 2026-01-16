package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Yc6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC9014Yc6 implements B.c {
    TASK_STATUS_UNKNOWN(0),
    TASK_STATUS_PENDING(1),
    TASK_STATUS_DONE(2),
    TASK_STATUS_FAILED(3),
    TASK_STATUS_CANCELLED(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.Yc6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9014Yc6 a(int i2) {
            return EnumC9014Yc6.j(i2);
        }
    };
    private final int a;

    EnumC9014Yc6(int i2) {
        this.a = i2;
    }

    public static EnumC9014Yc6 j(int i2) {
        if (i2 == 0) {
            return TASK_STATUS_UNKNOWN;
        }
        if (i2 == 1) {
            return TASK_STATUS_PENDING;
        }
        if (i2 == 2) {
            return TASK_STATUS_DONE;
        }
        if (i2 == 3) {
            return TASK_STATUS_FAILED;
        }
        if (i2 != 4) {
            return null;
        }
        return TASK_STATUS_CANCELLED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
