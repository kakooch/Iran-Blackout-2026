package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zF3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC24816zF3 implements B.c {
    SIP_NO_HEADERS(0),
    SIP_X_HEADERS(1),
    SIP_ALL_HEADERS(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.zF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24816zF3 a(int i) {
            return EnumC24816zF3.j(i);
        }
    };
    private final int a;

    EnumC24816zF3(int i) {
        this.a = i;
    }

    public static EnumC24816zF3 j(int i) {
        if (i == 0) {
            return SIP_NO_HEADERS;
        }
        if (i == 1) {
            return SIP_X_HEADERS;
        }
        if (i != 2) {
            return null;
        }
        return SIP_ALL_HEADERS;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
