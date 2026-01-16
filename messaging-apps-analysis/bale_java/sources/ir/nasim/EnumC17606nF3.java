package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.nF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC17606nF3 implements B.c {
    PUBLISHER(0),
    SUBSCRIBER(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.nF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17606nF3 a(int i) {
            return EnumC17606nF3.j(i);
        }
    };
    private final int a;

    EnumC17606nF3(int i) {
        this.a = i;
    }

    public static EnumC17606nF3 j(int i) {
        if (i == 0) {
            return PUBLISHER;
        }
        if (i != 1) {
            return null;
        }
        return SUBSCRIBER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
