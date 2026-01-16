package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.tc4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC21409tc4 implements B.c {
    MultiplexingType_AMOUNT(0),
    MultiplexingType_PERCENTAGE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.tc4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21409tc4 a(int i) {
            return EnumC21409tc4.j(i);
        }
    };
    private final int a;

    EnumC21409tc4(int i) {
        this.a = i;
    }

    public static EnumC21409tc4 j(int i) {
        if (i == 0) {
            return MultiplexingType_AMOUNT;
        }
        if (i != 1) {
            return null;
        }
        return MultiplexingType_PERCENTAGE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
