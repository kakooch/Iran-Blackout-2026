package ir.nasim;

/* renamed from: ir.nasim.Nr3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public enum EnumC6469Nr3 {
    NORMAL,
    MULTIPLY,
    SCREEN,
    OVERLAY,
    DARKEN,
    LIGHTEN,
    COLOR_DODGE,
    COLOR_BURN,
    HARD_LIGHT,
    SOFT_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
    ADD,
    HARD_MIX;

    public EnumC8503Wg0 j() {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            return EnumC8503Wg0.MODULATE;
        }
        if (iOrdinal == 2) {
            return EnumC8503Wg0.SCREEN;
        }
        if (iOrdinal == 3) {
            return EnumC8503Wg0.OVERLAY;
        }
        if (iOrdinal == 4) {
            return EnumC8503Wg0.DARKEN;
        }
        if (iOrdinal == 5) {
            return EnumC8503Wg0.LIGHTEN;
        }
        if (iOrdinal != 16) {
            return null;
        }
        return EnumC8503Wg0.PLUS;
    }
}
