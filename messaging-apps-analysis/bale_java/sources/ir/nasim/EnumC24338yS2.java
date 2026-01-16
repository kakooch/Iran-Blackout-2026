package ir.nasim;

import com.google.protobuf.B;

/* renamed from: ir.nasim.yS2, reason: case insensitive filesystem */
/* loaded from: classes9.dex */
public enum EnumC24338yS2 implements B.c {
    GroupPreviewAction_SHOW_CHAT(0),
    GroupPreviewAction_SHOW_PREVIEW(1),
    GroupPreviewAction_JOIN(2),
    UNRECOGNIZED(-1);

    private static final B.d f = new B.d() { // from class: ir.nasim.yS2.a
        @Override // com.google.protobuf.B.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EnumC24338yS2 a(int i) {
            return EnumC24338yS2.j(i);
        }
    };
    private final int a;

    EnumC24338yS2(int i) {
        this.a = i;
    }

    public static EnumC24338yS2 j(int i) {
        if (i == 0) {
            return GroupPreviewAction_SHOW_CHAT;
        }
        if (i == 1) {
            return GroupPreviewAction_SHOW_PREVIEW;
        }
        if (i != 2) {
            return null;
        }
        return GroupPreviewAction_JOIN;
    }

    @Override // com.google.protobuf.B.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
