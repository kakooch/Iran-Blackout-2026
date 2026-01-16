package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Rf, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC7318Rf implements B.c {
    AdViewerLocation_UNKNOWN(0),
    AdViewerLocation_EAST_AZERBAIJAN(1),
    AdViewerLocation_WEST_AZERBAIJAN(2),
    AdViewerLocation_ARDABIL(3),
    AdViewerLocation_ESFAHAN(4),
    AdViewerLocation_ILAM(5),
    AdViewerLocation_BUSHEHR(6),
    AdViewerLocation_TEHRAN(7),
    AdViewerLocation_CHAHARMAHAL_BAKHTIARI(8),
    AdViewerLocation_SOUTH_KHORASAN(9),
    AdViewerLocation_RAZAVI_KHORASAN(10),
    AdViewerLocation_NORTH_KHORASAN(11),
    AdViewerLocation_KHUZESTAN(12),
    AdViewerLocation_ZANJAN(13),
    AdViewerLocation_SEMNAN(14),
    AdViewerLocation_SISTAN_BALUCHESTAN(15),
    AdViewerLocation_FARS(16),
    AdViewerLocation_QAZVIN(17),
    AdViewerLocation_QOM(18),
    AdViewerLocation_KURDISTAN(19),
    AdViewerLocation_KERMAN(20),
    AdViewerLocation_KERMANSHAH(21),
    AdViewerLocation_KOHGILUYEH_BOYERAHMAD(22),
    AdViewerLocation_GOLESTAN(23),
    AdViewerLocation_GILAN(24),
    AdViewerLocation_LORESTAN(25),
    AdViewerLocation_MAZANDARAN(26),
    AdViewerLocation_MARKAZI(27),
    AdViewerLocation_HORMOZGAN(28),
    AdViewerLocation_HAMEDAN(29),
    AdViewerLocation_YAZD(30),
    AdViewerLocation_ALBORZ(31),
    UNRECOGNIZED(-1);

    private static final B.d z0 = new B.d() { // from class: ir.nasim.Rf.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC7318Rf a(int i) {
            return EnumC7318Rf.j(i);
        }
    };
    private final int a;

    EnumC7318Rf(int i) {
        this.a = i;
    }

    public static EnumC7318Rf j(int i) {
        switch (i) {
            case 0:
                return AdViewerLocation_UNKNOWN;
            case 1:
                return AdViewerLocation_EAST_AZERBAIJAN;
            case 2:
                return AdViewerLocation_WEST_AZERBAIJAN;
            case 3:
                return AdViewerLocation_ARDABIL;
            case 4:
                return AdViewerLocation_ESFAHAN;
            case 5:
                return AdViewerLocation_ILAM;
            case 6:
                return AdViewerLocation_BUSHEHR;
            case 7:
                return AdViewerLocation_TEHRAN;
            case 8:
                return AdViewerLocation_CHAHARMAHAL_BAKHTIARI;
            case 9:
                return AdViewerLocation_SOUTH_KHORASAN;
            case 10:
                return AdViewerLocation_RAZAVI_KHORASAN;
            case 11:
                return AdViewerLocation_NORTH_KHORASAN;
            case 12:
                return AdViewerLocation_KHUZESTAN;
            case 13:
                return AdViewerLocation_ZANJAN;
            case 14:
                return AdViewerLocation_SEMNAN;
            case 15:
                return AdViewerLocation_SISTAN_BALUCHESTAN;
            case 16:
                return AdViewerLocation_FARS;
            case 17:
                return AdViewerLocation_QAZVIN;
            case 18:
                return AdViewerLocation_QOM;
            case 19:
                return AdViewerLocation_KURDISTAN;
            case 20:
                return AdViewerLocation_KERMAN;
            case 21:
                return AdViewerLocation_KERMANSHAH;
            case 22:
                return AdViewerLocation_KOHGILUYEH_BOYERAHMAD;
            case 23:
                return AdViewerLocation_GOLESTAN;
            case 24:
                return AdViewerLocation_GILAN;
            case 25:
                return AdViewerLocation_LORESTAN;
            case 26:
                return AdViewerLocation_MAZANDARAN;
            case 27:
                return AdViewerLocation_MARKAZI;
            case 28:
                return AdViewerLocation_HORMOZGAN;
            case 29:
                return AdViewerLocation_HAMEDAN;
            case 30:
                return AdViewerLocation_YAZD;
            case 31:
                return AdViewerLocation_ALBORZ;
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
