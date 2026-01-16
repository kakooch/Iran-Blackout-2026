package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.eb4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC12424eb4 implements B.c {
    CrowdFundingStatus_INPROGRESS(0),
    CrowdFundingStatus_DONE(1),
    CrowdFundingStatus_STOPPED(2),
    CrowdFundingStatus_EXPIRED(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.eb4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12424eb4 a(int i) {
            return EnumC12424eb4.j(i);
        }
    };
    private final int a;

    EnumC12424eb4(int i) {
        this.a = i;
    }

    public static EnumC12424eb4 j(int i) {
        if (i == 0) {
            return CrowdFundingStatus_INPROGRESS;
        }
        if (i == 1) {
            return CrowdFundingStatus_DONE;
        }
        if (i == 2) {
            return CrowdFundingStatus_STOPPED;
        }
        if (i != 3) {
            return null;
        }
        return CrowdFundingStatus_EXPIRED;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
