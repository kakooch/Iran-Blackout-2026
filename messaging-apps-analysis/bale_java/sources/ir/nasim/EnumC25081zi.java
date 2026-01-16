package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.zi, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC25081zi implements B.c {
    PlatformUnknown(0),
    PlatformAndroid(1),
    PlatformWeb(2),
    PlatformWebAndAndroid(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.zi.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC25081zi a(int i) {
            return EnumC25081zi.j(i);
        }
    };
    private final int a;

    EnumC25081zi(int i) {
        this.a = i;
    }

    public static EnumC25081zi j(int i) {
        if (i == 0) {
            return PlatformUnknown;
        }
        if (i == 1) {
            return PlatformAndroid;
        }
        if (i == 2) {
            return PlatformWeb;
        }
        if (i != 3) {
            return null;
        }
        return PlatformWebAndAndroid;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
