package ir.nasim;

import android.os.Build;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.xl7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC23935xl7 {
    public static final EnumC23935xl7 b = new EnumC23935xl7("Cut", 0, android.R.string.cut);
    public static final EnumC23935xl7 c = new EnumC23935xl7("Copy", 1, android.R.string.copy);
    public static final EnumC23935xl7 d = new EnumC23935xl7("Paste", 2, android.R.string.paste);
    public static final EnumC23935xl7 e = new EnumC23935xl7("SelectAll", 3, android.R.string.selectAll);
    public static final EnumC23935xl7 f;
    private static final /* synthetic */ EnumC23935xl7[] g;
    private static final /* synthetic */ F92 h;
    private final int a;

    static {
        f = new EnumC23935xl7("Autofill", 4, Build.VERSION.SDK_INT <= 26 ? XD5.autofill : android.R.string.autofill);
        EnumC23935xl7[] enumC23935xl7ArrA = a();
        g = enumC23935xl7ArrA;
        h = G92.a(enumC23935xl7ArrA);
    }

    private EnumC23935xl7(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC23935xl7[] a() {
        return new EnumC23935xl7[]{b, c, d, e, f};
    }

    public static EnumC23935xl7 valueOf(String str) {
        return (EnumC23935xl7) Enum.valueOf(EnumC23935xl7.class, str);
    }

    public static EnumC23935xl7[] values() {
        return (EnumC23935xl7[]) g.clone();
    }

    public final String j(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-309609081, i, -1, "androidx.compose.foundation.text.TextContextMenuItems.resolvedString (ContextMenu.android.kt:131)");
        }
        String strC = UY6.c(this.a, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return strC;
    }
}
