package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.fg, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC13105fg implements B.c {
    BannerImagePosition_LEFT(0),
    BannerImagePosition_CENTER(1),
    BannerImagePosition_RIGHT(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.fg.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC13105fg a(int i) {
            return EnumC13105fg.j(i);
        }
    };
    private final int a;

    EnumC13105fg(int i) {
        this.a = i;
    }

    public static EnumC13105fg j(int i) {
        if (i == 0) {
            return BannerImagePosition_LEFT;
        }
        if (i == 1) {
            return BannerImagePosition_CENTER;
        }
        if (i != 2) {
            return null;
        }
        return BannerImagePosition_RIGHT;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
