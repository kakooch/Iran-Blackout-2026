package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.ee0, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC12450ee0 implements B.c {
    ReportType_UNKNOWN(0),
    ReportType_NSFW(1),
    ReportType_SCAM(2),
    ReportType_SPAM(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.ee0.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12450ee0 a(int i) {
            return EnumC12450ee0.j(i);
        }
    };
    private final int a;

    EnumC12450ee0(int i) {
        this.a = i;
    }

    public static EnumC12450ee0 j(int i) {
        if (i == 0) {
            return ReportType_UNKNOWN;
        }
        if (i == 1) {
            return ReportType_NSFW;
        }
        if (i == 2) {
            return ReportType_SCAM;
        }
        if (i != 3) {
            return null;
        }
        return ReportType_SPAM;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
