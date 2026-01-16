package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.kc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC16043kc4 implements B.c {
    MessageState_SENT(0),
    MessageState_RECEIVED(1),
    MessageState_READ(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.kc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16043kc4 a(int i) {
            return EnumC16043kc4.j(i);
        }
    };
    private final int a;

    EnumC16043kc4(int i) {
        this.a = i;
    }

    public static EnumC16043kc4 j(int i) {
        if (i == 0) {
            return MessageState_SENT;
        }
        if (i == 1) {
            return MessageState_RECEIVED;
        }
        if (i != 2) {
            return null;
        }
        return MessageState_READ;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
