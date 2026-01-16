package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Un2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8100Un2 implements B.c {
    SendType_UNKNOWN(0),
    SendType_PHOTO(1),
    SendType_VIDEO(2),
    SendType_VOICE(3),
    SendType_GIF(4),
    SendType_AUDIO(5),
    SendType_DOCUMENT(6),
    SendType_STICKER(7),
    SendType_CROWDFUNDING(8),
    SendType_SPONSORED(9),
    UNRECOGNIZED(-1);

    private static final B.d m = new B.d() { // from class: ir.nasim.Un2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8100Un2 a(int i) {
            return EnumC8100Un2.j(i);
        }
    };
    private final int a;

    EnumC8100Un2(int i) {
        this.a = i;
    }

    public static EnumC8100Un2 j(int i) {
        switch (i) {
            case 0:
                return SendType_UNKNOWN;
            case 1:
                return SendType_PHOTO;
            case 2:
                return SendType_VIDEO;
            case 3:
                return SendType_VOICE;
            case 4:
                return SendType_GIF;
            case 5:
                return SendType_AUDIO;
            case 6:
                return SendType_DOCUMENT;
            case 7:
                return SendType_STICKER;
            case 8:
                return SendType_CROWDFUNDING;
            case 9:
                return SendType_SPONSORED;
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
