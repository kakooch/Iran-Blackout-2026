package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ho5, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5025Ho5 implements B.c {
    TypingType_UNKNOWN(0),
    TypingType_TEXT(1),
    TypingType_VOICERECODRING(2),
    TypingType_SENDINGVOICE(3),
    TypingType_SENDINGFILE(4),
    TypingType_SENDINGPHOTO(5),
    TypingType_SENDINGVIDEO(6),
    TypingType_SENDINGMUSIC(7),
    TypingType_CHOOSINGSTICKER(8),
    TypingType_CHOSINGGIF(9),
    TypingType_CREATINGGIFTPACKET(10),
    TypingType_SENDINGALBUM(11),
    TypingType_CHOSINGEMOJI(12),
    UNRECOGNIZED(-1);

    private static final B.d p = new B.d() { // from class: ir.nasim.Ho5.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5025Ho5 a(int i) {
            return EnumC5025Ho5.j(i);
        }
    };
    private final int a;

    EnumC5025Ho5(int i) {
        this.a = i;
    }

    public static EnumC5025Ho5 j(int i) {
        switch (i) {
            case 0:
                return TypingType_UNKNOWN;
            case 1:
                return TypingType_TEXT;
            case 2:
                return TypingType_VOICERECODRING;
            case 3:
                return TypingType_SENDINGVOICE;
            case 4:
                return TypingType_SENDINGFILE;
            case 5:
                return TypingType_SENDINGPHOTO;
            case 6:
                return TypingType_SENDINGVIDEO;
            case 7:
                return TypingType_SENDINGMUSIC;
            case 8:
                return TypingType_CHOOSINGSTICKER;
            case 9:
                return TypingType_CHOSINGGIF;
            case 10:
                return TypingType_CREATINGGIFTPACKET;
            case 11:
                return TypingType_SENDINGALBUM;
            case 12:
                return TypingType_CHOSINGEMOJI;
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
