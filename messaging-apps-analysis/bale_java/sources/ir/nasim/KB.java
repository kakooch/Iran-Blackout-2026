package ir.nasim;

/* loaded from: classes4.dex */
public enum KB {
    ANY(1),
    TEXT(2),
    LINKS(3),
    DOCUMENTS(4),
    PHOTOS(5),
    VIDEOS(6),
    AUDIOS(7),
    VOICES(8),
    MEDIA(9),
    UNSUPPORTED_VALUE(-1);

    private int a;

    KB(int i) {
        this.a = i;
    }

    public static KB p(int i) {
        switch (i) {
            case 1:
                return ANY;
            case 2:
                return TEXT;
            case 3:
                return LINKS;
            case 4:
                return DOCUMENTS;
            case 5:
                return PHOTOS;
            case 6:
                return VIDEOS;
            case 7:
                return AUDIOS;
            case 8:
                return VOICES;
            case 9:
                return MEDIA;
            default:
                return UNSUPPORTED_VALUE;
        }
    }

    public int j() {
        return this.a;
    }
}
