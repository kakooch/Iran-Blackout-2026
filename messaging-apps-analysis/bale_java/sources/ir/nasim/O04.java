package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes9.dex */
public enum O04 implements B.c {
    CallRecordQuality_NOTSPECIFIED(0),
    CallRecordQuality_LOW(1),
    CallRecordQuality_MEDUIM(2),
    CallRecordQuality_HIGH(3),
    CallRecordQuality_ULTRA(4),
    CallRecordQuality_ULTRAPLUS(5),
    UNRECOGNIZED(-1);

    private static final B.d i = new B.d() { // from class: ir.nasim.O04.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public O04 a(int i2) {
            return O04.j(i2);
        }
    };
    private final int a;

    O04(int i2) {
        this.a = i2;
    }

    public static O04 j(int i2) {
        if (i2 == 0) {
            return CallRecordQuality_NOTSPECIFIED;
        }
        if (i2 == 1) {
            return CallRecordQuality_LOW;
        }
        if (i2 == 2) {
            return CallRecordQuality_MEDUIM;
        }
        if (i2 == 3) {
            return CallRecordQuality_HIGH;
        }
        if (i2 == 4) {
            return CallRecordQuality_ULTRA;
        }
        if (i2 != 5) {
            return null;
        }
        return CallRecordQuality_ULTRAPLUS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
