package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.Ya4, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC8973Ya4 implements B.c {
    BrowserType_INTERNAL_BROWSER(0),
    BrowserType_EXTERNAL_BROWSER(1),
    UNRECOGNIZED(-1);

    private static final B.d e = new B.d() { // from class: ir.nasim.Ya4.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC8973Ya4 a(int i) {
            return EnumC8973Ya4.j(i);
        }
    };
    private final int a;

    EnumC8973Ya4(int i) {
        this.a = i;
    }

    public static EnumC8973Ya4 j(int i) {
        if (i == 0) {
            return BrowserType_INTERNAL_BROWSER;
        }
        if (i != 1) {
            return null;
        }
        return BrowserType_EXTERNAL_BROWSER;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
