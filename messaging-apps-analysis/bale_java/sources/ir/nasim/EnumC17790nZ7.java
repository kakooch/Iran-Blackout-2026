package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.nZ7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC17790nZ7 implements B.c {
    ActionType_UNKNOWN(0),
    ActionType_URL(1),
    ActionType_PEER(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.nZ7.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17790nZ7 a(int i) {
            return EnumC17790nZ7.j(i);
        }
    };
    private final int a;

    EnumC17790nZ7(int i) {
        this.a = i;
    }

    public static EnumC17790nZ7 j(int i) {
        if (i == 0) {
            return ActionType_UNKNOWN;
        }
        if (i == 1) {
            return ActionType_URL;
        }
        if (i != 2) {
            return null;
        }
        return ActionType_PEER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
