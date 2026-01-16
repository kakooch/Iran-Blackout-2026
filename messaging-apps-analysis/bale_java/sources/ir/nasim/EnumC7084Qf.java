package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Qf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC7084Qf implements B.c {
    AdViewerGender_UNKNOWN(0),
    AdViewerGender_MALE(1),
    AdViewerGender_FEMALE(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.Qf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7084Qf a(int i) {
            return EnumC7084Qf.j(i);
        }
    };
    private final int a;

    EnumC7084Qf(int i) {
        this.a = i;
    }

    public static EnumC7084Qf j(int i) {
        if (i == 0) {
            return AdViewerGender_UNKNOWN;
        }
        if (i == 1) {
            return AdViewerGender_MALE;
        }
        if (i != 2) {
            return null;
        }
        return AdViewerGender_FEMALE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
