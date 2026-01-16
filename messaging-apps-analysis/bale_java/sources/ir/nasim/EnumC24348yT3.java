package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yT3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC24348yT3 implements B.c {
    MarketActionType_UNKNOWN(0),
    MarketActionType_OPEN_URL(1),
    MarketActionType_OPEN_CHAT(2),
    MarketActionType_OPEN_MESSAGE(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.yT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24348yT3 a(int i) {
            return EnumC24348yT3.j(i);
        }
    };
    private final int a;

    EnumC24348yT3(int i) {
        this.a = i;
    }

    public static EnumC24348yT3 j(int i) {
        if (i == 0) {
            return MarketActionType_UNKNOWN;
        }
        if (i == 1) {
            return MarketActionType_OPEN_URL;
        }
        if (i == 2) {
            return MarketActionType_OPEN_CHAT;
        }
        if (i != 3) {
            return null;
        }
        return MarketActionType_OPEN_MESSAGE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
