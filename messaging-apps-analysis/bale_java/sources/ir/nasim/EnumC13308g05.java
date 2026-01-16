package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.g05, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC13308g05 implements B.c {
    UNSPECIFIED(0),
    TEXT(1),
    NUMERIC(2),
    MULTILINE_TEXT(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.g05.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13308g05 a(int i) {
            return EnumC13308g05.j(i);
        }
    };
    private final int a;

    EnumC13308g05(int i) {
        this.a = i;
    }

    public static EnumC13308g05 j(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return TEXT;
        }
        if (i == 2) {
            return NUMERIC;
        }
        if (i != 3) {
            return null;
        }
        return MULTILINE_TEXT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
