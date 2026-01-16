package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.qE3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC19370qE3 implements B.c {
    H264_720P_30(0),
    H264_720P_60(1),
    H264_1080P_30(2),
    H264_1080P_60(3),
    PORTRAIT_H264_720P_30(4),
    PORTRAIT_H264_720P_60(5),
    PORTRAIT_H264_1080P_30(6),
    PORTRAIT_H264_1080P_60(7),
    UNRECOGNIZED(-1);

    private static final B.d k = new B.d() { // from class: ir.nasim.qE3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC19370qE3 a(int i) {
            return EnumC19370qE3.j(i);
        }
    };
    private final int a;

    EnumC19370qE3(int i) {
        this.a = i;
    }

    public static EnumC19370qE3 j(int i) {
        switch (i) {
            case 0:
                return H264_720P_30;
            case 1:
                return H264_720P_60;
            case 2:
                return H264_1080P_30;
            case 3:
                return H264_1080P_60;
            case 4:
                return PORTRAIT_H264_720P_30;
            case 5:
                return PORTRAIT_H264_720P_60;
            case 6:
                return PORTRAIT_H264_1080P_30;
            case 7:
                return PORTRAIT_H264_1080P_60;
            default:
                return null;
        }
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
