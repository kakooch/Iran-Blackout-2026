package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.aa6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC9799aa6 implements B.c {
    hourly(0),
    daily(1),
    weekly(2),
    monthly(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.aa6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9799aa6 a(int i) {
            return EnumC9799aa6.j(i);
        }
    };
    private final int a;

    EnumC9799aa6(int i) {
        this.a = i;
    }

    public static EnumC9799aa6 j(int i) {
        if (i == 0) {
            return hourly;
        }
        if (i == 1) {
            return daily;
        }
        if (i == 2) {
            return weekly;
        }
        if (i != 3) {
            return null;
        }
        return monthly;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
