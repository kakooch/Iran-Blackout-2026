package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.lJ0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC16457lJ0 implements B.c {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.lJ0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC16457lJ0 a(int i) {
            return EnumC16457lJ0.a(i);
        }
    };
    private final int a;

    EnumC16457lJ0(int i) {
        this.a = i;
    }

    public static EnumC16457lJ0 a(int i) {
        if (i == 0) {
            return CHANGE_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return ADDED;
        }
        if (i == 2) {
            return REMOVED;
        }
        if (i != 3) {
            return null;
        }
        return MODIFIED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
