package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.hh, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC14297hh implements B.c {
    FeatureScope_UNKNOWN(0),
    FeatureScope_SUBMIT_CAMPAIGN(1),
    FeatureScope_SUBMIT_SPONSERED_MESSAGE(2),
    FeatureScope_FESTIVAL(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.hh.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC14297hh a(int i) {
            return EnumC14297hh.j(i);
        }
    };
    private final int a;

    EnumC14297hh(int i) {
        this.a = i;
    }

    public static EnumC14297hh j(int i) {
        if (i == 0) {
            return FeatureScope_UNKNOWN;
        }
        if (i == 1) {
            return FeatureScope_SUBMIT_CAMPAIGN;
        }
        if (i == 2) {
            return FeatureScope_SUBMIT_SPONSERED_MESSAGE;
        }
        if (i != 3) {
            return null;
        }
        return FeatureScope_FESTIVAL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
