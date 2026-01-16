package ir.nasim;

/* loaded from: classes4.dex */
public enum SB {
    UNKNOWN(0),
    PHOTO(1),
    VIDEO(2),
    VOICE(3),
    GIF(4),
    AUDIO(5),
    DOCUMENT(6),
    STICKER(7),
    CROWDFUNDING(8),
    SPONSORED(9),
    UNSUPPORTED_VALUE(-1);

    private int a;

    SB(int i) {
        this.a = i;
    }

    public static SB p(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return PHOTO;
            case 2:
                return VIDEO;
            case 3:
                return VOICE;
            case 4:
                return GIF;
            case 5:
                return AUDIO;
            case 6:
                return DOCUMENT;
            case 7:
                return STICKER;
            case 8:
                return CROWDFUNDING;
            case 9:
                return SPONSORED;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
