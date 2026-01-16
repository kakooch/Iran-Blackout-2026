package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.nE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC17597nE3 implements B.c {
    EGRESS_SOURCE_TYPE_WEB(0),
    EGRESS_SOURCE_TYPE_SDK(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.nE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC17597nE3 a(int i) {
            return EnumC17597nE3.j(i);
        }
    };
    private final int a;

    EnumC17597nE3(int i) {
        this.a = i;
    }

    public static EnumC17597nE3 j(int i) {
        if (i == 0) {
            return EGRESS_SOURCE_TYPE_WEB;
        }
        if (i != 1) {
            return null;
        }
        return EGRESS_SOURCE_TYPE_SDK;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
