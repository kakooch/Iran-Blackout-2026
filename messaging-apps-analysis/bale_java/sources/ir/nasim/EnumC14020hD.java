package ir.nasim;

/* renamed from: ir.nasim.hD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public enum EnumC14020hD {
    UNKNOWN(0),
    TEXT(1),
    VOICERECODRING(2),
    SENDINGVOICE(3),
    SENDINGFILE(4),
    SENDINGPHOTO(5),
    SENDINGVIDEO(6),
    SENDINGMUSIC(7),
    CHOOSINGSTICKER(8),
    CHOSINGGIF(9),
    CREATINGGIFTPACKET(10),
    SENDINGALBUM(11),
    CHOSINGEMOJI(12),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EnumC14020hD(int i) {
        this.a = i;
    }

    public static EnumC14020hD p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return TEXT;
            case 2:
                return VOICERECODRING;
            case 3:
                return SENDINGVOICE;
            case 4:
                return SENDINGFILE;
            case 5:
                return SENDINGPHOTO;
            case 6:
                return SENDINGVIDEO;
            case 7:
                return SENDINGMUSIC;
            case 8:
                return CHOOSINGSTICKER;
            case 9:
                return CHOSINGGIF;
            case 10:
                return CREATINGGIFTPACKET;
            case 11:
                return SENDINGALBUM;
            case 12:
                return CHOSINGEMOJI;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
