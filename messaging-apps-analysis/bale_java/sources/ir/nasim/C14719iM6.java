package ir.nasim;

import android.text.StaticLayout;

/* renamed from: ir.nasim.iM6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14719iM6 {
    public static final C14719iM6 a = new C14719iM6();

    private C14719iM6() {
    }

    public static final boolean a(StaticLayout staticLayout) {
        return staticLayout.isFallbackLineSpacingEnabled();
    }

    public static final void b(StaticLayout.Builder builder, int i, int i2) {
        builder.setLineBreakConfig(AbstractC14108hM6.a().setLineBreakStyle(i).setLineBreakWordStyle(i2).build());
    }
}
