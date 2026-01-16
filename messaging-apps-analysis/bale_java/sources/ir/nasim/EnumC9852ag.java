package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.ag, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public enum EnumC9852ag implements B.c {
    BaleCustomAdPlatform_UNKNOWN(0),
    BaleCustomAdPlatform_ANDROID(1),
    BaleCustomAdPlatform_WEB(2),
    BaleCustomAdPlatform_ANDROIDANDWEB(3),
    UNRECOGNIZED(-1);

    private static final B.d g = new B.d() { // from class: ir.nasim.ag.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC9852ag a(int i) {
            return EnumC9852ag.j(i);
        }
    };
    private final int a;

    EnumC9852ag(int i) {
        this.a = i;
    }

    public static EnumC9852ag j(int i) {
        if (i == 0) {
            return BaleCustomAdPlatform_UNKNOWN;
        }
        if (i == 1) {
            return BaleCustomAdPlatform_ANDROID;
        }
        if (i == 2) {
            return BaleCustomAdPlatform_WEB;
        }
        if (i != 3) {
            return null;
        }
        return BaleCustomAdPlatform_ANDROIDANDWEB;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
