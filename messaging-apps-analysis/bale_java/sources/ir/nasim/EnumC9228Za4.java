package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Za4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC9228Za4 implements B.c {
    CardinalityType_LIKE(0),
    UNRECOGNIZED(-1);

    private static final B.d d = new B.d() { // from class: ir.nasim.Za4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9228Za4 a(int i) {
            return EnumC9228Za4.j(i);
        }
    };
    private final int a;

    EnumC9228Za4(int i) {
        this.a = i;
    }

    public static EnumC9228Za4 j(int i) {
        if (i != 0) {
            return null;
        }
        return CardinalityType_LIKE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
