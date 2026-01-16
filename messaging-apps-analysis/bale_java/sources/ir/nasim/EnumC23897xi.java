package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.xi, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC23897xi implements B.c {
    ContentTypeNoAds(0),
    ContentTypeAdList(1),
    ContentTypeYektaNetToken(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.xi.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC23897xi a(int i) {
            return EnumC23897xi.j(i);
        }
    };
    private final int a;

    EnumC23897xi(int i) {
        this.a = i;
    }

    public static EnumC23897xi j(int i) {
        if (i == 0) {
            return ContentTypeNoAds;
        }
        if (i == 1) {
            return ContentTypeAdList;
        }
        if (i != 2) {
            return null;
        }
        return ContentTypeYektaNetToken;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
