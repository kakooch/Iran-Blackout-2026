package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.bg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC10472bg implements B.c {
    BaleCustomAdStatus_UNKNOWN(0),
    BaleCustomAdStatus_ACTIVE(1),
    BaleCustomAdStatus_DEACTIVE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.bg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC10472bg a(int i) {
            return EnumC10472bg.j(i);
        }
    };
    private final int a;

    EnumC10472bg(int i) {
        this.a = i;
    }

    public static EnumC10472bg j(int i) {
        if (i == 0) {
            return BaleCustomAdStatus_UNKNOWN;
        }
        if (i == 1) {
            return BaleCustomAdStatus_ACTIVE;
        }
        if (i != 2) {
            return null;
        }
        return BaleCustomAdStatus_DEACTIVE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
