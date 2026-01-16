package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.In3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC5248In3 implements B.c {
    BotResultType_PHOTO(0),
    BotResultType_GIF(1),
    BotResultType_ARTICLE(2),
    BotResultType_VOICE(4),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.In3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC5248In3 a(int i) {
            return EnumC5248In3.j(i);
        }
    };
    private final int a;

    EnumC5248In3(int i) {
        this.a = i;
    }

    public static EnumC5248In3 j(int i) {
        if (i == 0) {
            return BotResultType_PHOTO;
        }
        if (i == 1) {
            return BotResultType_GIF;
        }
        if (i == 2) {
            return BotResultType_ARTICLE;
        }
        if (i != 4) {
            return null;
        }
        return BotResultType_VOICE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
