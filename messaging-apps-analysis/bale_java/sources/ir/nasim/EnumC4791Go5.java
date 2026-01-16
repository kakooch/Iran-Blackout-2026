package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Go5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC4791Go5 implements B.c {
    DeviceType_UNKNOWN(0),
    DeviceType_GENERIC(1),
    DeviceType_PC(2),
    DeviceType_MOBILE(3),
    DeviceType_TABLET(4),
    DeviceType_WATCH(5),
    DeviceType_MIRROR(6),
    DeviceType_CAR(7),
    DeviceType_TABLE(8),
    UNRECOGNIZED(-1);

    private static final B.d l = new B.d() { // from class: ir.nasim.Go5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC4791Go5 a(int i) {
            return EnumC4791Go5.j(i);
        }
    };
    private final int a;

    EnumC4791Go5(int i) {
        this.a = i;
    }

    public static EnumC4791Go5 j(int i) {
        switch (i) {
            case 0:
                return DeviceType_UNKNOWN;
            case 1:
                return DeviceType_GENERIC;
            case 2:
                return DeviceType_PC;
            case 3:
                return DeviceType_MOBILE;
            case 4:
                return DeviceType_TABLET;
            case 5:
                return DeviceType_WATCH;
            case 6:
                return DeviceType_MIRROR;
            case 7:
                return DeviceType_CAR;
            case 8:
                return DeviceType_TABLE;
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
