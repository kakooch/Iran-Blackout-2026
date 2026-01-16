package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.uT3, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC21982uT3 implements B.c {
    ContentSearchDefaultTab_ANY(0),
    ContentSearchDefaultTab_PHOTO(1),
    ContentSearchDefaultTab_CHANNEL(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.uT3.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC21982uT3 a(int i) {
            return EnumC21982uT3.j(i);
        }
    };
    private final int a;

    EnumC21982uT3(int i) {
        this.a = i;
    }

    public static EnumC21982uT3 j(int i) {
        if (i == 0) {
            return ContentSearchDefaultTab_ANY;
        }
        if (i == 1) {
            return ContentSearchDefaultTab_PHOTO;
        }
        if (i != 2) {
            return null;
        }
        return ContentSearchDefaultTab_CHANNEL;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
