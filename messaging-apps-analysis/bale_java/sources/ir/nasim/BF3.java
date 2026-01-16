package ir.nasim;

import com.google.protobuf.B;

/* loaded from: classes8.dex */
public enum BF3 implements B.c {
    SIP_MEDIA_ENCRYPT_DISABLE(0),
    SIP_MEDIA_ENCRYPT_ALLOW(1),
    SIP_MEDIA_ENCRYPT_REQUIRE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.BF3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BF3 a(int i) {
            return BF3.j(i);
        }
    };
    private final int a;

    BF3(int i) {
        this.a = i;
    }

    public static BF3 j(int i) {
        if (i == 0) {
            return SIP_MEDIA_ENCRYPT_DISABLE;
        }
        if (i == 1) {
            return SIP_MEDIA_ENCRYPT_ALLOW;
        }
        if (i != 2) {
            return null;
        }
        return SIP_MEDIA_ENCRYPT_REQUIRE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
