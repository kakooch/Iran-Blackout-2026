package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.wF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC23042wF3 implements B.c {
    SCS_CALL_INCOMING(0),
    SCS_PARTICIPANT_JOINED(1),
    SCS_ACTIVE(2),
    SCS_DISCONNECTED(3),
    SCS_ERROR(4),
    UNRECOGNIZED(-1);

    private static final B.d h = new B.d() { // from class: ir.nasim.wF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23042wF3 a(int i2) {
            return EnumC23042wF3.j(i2);
        }
    };
    private final int a;

    EnumC23042wF3(int i2) {
        this.a = i2;
    }

    public static EnumC23042wF3 j(int i2) {
        if (i2 == 0) {
            return SCS_CALL_INCOMING;
        }
        if (i2 == 1) {
            return SCS_PARTICIPANT_JOINED;
        }
        if (i2 == 2) {
            return SCS_ACTIVE;
        }
        if (i2 == 3) {
            return SCS_DISCONNECTED;
        }
        if (i2 != 4) {
            return null;
        }
        return SCS_ERROR;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
