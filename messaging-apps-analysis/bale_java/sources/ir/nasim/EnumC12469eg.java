package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.eg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC12469eg implements B.c {
    BannerImageCover_SMALL(0),
    BannerImageCover_LARGE(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.eg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC12469eg a(int i) {
            return EnumC12469eg.j(i);
        }
    };
    private final int a;

    EnumC12469eg(int i) {
        this.a = i;
    }

    public static EnumC12469eg j(int i) {
        if (i == 0) {
            return BannerImageCover_SMALL;
        }
        if (i != 1) {
            return null;
        }
        return BannerImageCover_LARGE;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
