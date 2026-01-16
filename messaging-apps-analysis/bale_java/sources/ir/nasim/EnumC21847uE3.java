package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.uE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC21847uE3 implements B.c {
    DEFAULT_SEGMENTED_FILE_PROTOCOL(0),
    HLS_PROTOCOL(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.uE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21847uE3 a(int i) {
            return EnumC21847uE3.j(i);
        }
    };
    private final int a;

    EnumC21847uE3(int i) {
        this.a = i;
    }

    public static EnumC21847uE3 j(int i) {
        if (i == 0) {
            return DEFAULT_SEGMENTED_FILE_PROTOCOL;
        }
        if (i != 1) {
            return null;
        }
        return HLS_PROTOCOL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
