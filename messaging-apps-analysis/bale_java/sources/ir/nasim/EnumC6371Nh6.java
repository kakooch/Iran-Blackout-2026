package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Nh6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public enum EnumC6371Nh6 implements B.c {
    SearchContentType_ANY(0),
    SearchContentType_TEXT(1),
    SearchContentType_LINKS(2),
    SearchContentType_DOCUMENTS(3),
    SearchContentType_PHOTOS(4),
    SearchContentType_VIDEOS(5),
    SearchContentType_AUDIOS(6),
    SearchContentType_VOICES(7),
    SearchContentType_MEDIA(8),
    UNRECOGNIZED(-1);

    private static final B.d l = new B.d() { // from class: ir.nasim.Nh6.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC6371Nh6 a(int i) {
            return EnumC6371Nh6.j(i);
        }
    };
    private final int a;

    EnumC6371Nh6(int i) {
        this.a = i;
    }

    public static EnumC6371Nh6 j(int i) {
        switch (i) {
            case 0:
                return SearchContentType_ANY;
            case 1:
                return SearchContentType_TEXT;
            case 2:
                return SearchContentType_LINKS;
            case 3:
                return SearchContentType_DOCUMENTS;
            case 4:
                return SearchContentType_PHOTOS;
            case 5:
                return SearchContentType_VIDEOS;
            case 6:
                return SearchContentType_AUDIOS;
            case 7:
                return SearchContentType_VOICES;
            case 8:
                return SearchContentType_MEDIA;
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
