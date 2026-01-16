package ir.nasim;

/* renamed from: ir.nasim.Bd6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C3508Bd6 {
    public static final C3508Bd6 a = new C3508Bd6();
    public static final C20644sM5 b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        b = new C20644sM5("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private C3508Bd6() {
    }
}
