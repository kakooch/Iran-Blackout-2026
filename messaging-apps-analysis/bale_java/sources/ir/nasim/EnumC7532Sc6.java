package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Sc6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC7532Sc6 implements B.c {
    TASK_TYPE_UNKNOWN(0),
    TASK_TYPE_MESSAGE_SEND(1),
    TASK_TYPE_MESSAGE_DELETE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Sc6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7532Sc6 a(int i) {
            return EnumC7532Sc6.j(i);
        }
    };
    private final int a;

    EnumC7532Sc6(int i) {
        this.a = i;
    }

    public static EnumC7532Sc6 j(int i) {
        if (i == 0) {
            return TASK_TYPE_UNKNOWN;
        }
        if (i == 1) {
            return TASK_TYPE_MESSAGE_SEND;
        }
        if (i != 2) {
            return null;
        }
        return TASK_TYPE_MESSAGE_DELETE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
