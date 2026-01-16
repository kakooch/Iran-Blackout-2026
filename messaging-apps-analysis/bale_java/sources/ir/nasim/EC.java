package ir.nasim;

/* loaded from: classes4.dex */
public enum EC {
    SUPPORT_TELEGRAM_GATEWAY(1),
    SIX_DIGIT_OTP(2),
    UNSUPPORTED_VALUE(-1);

    private int a;

    EC(int i) {
        this.a = i;
    }

    public static EC p(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : SIX_DIGIT_OTP : SUPPORT_TELEGRAM_GATEWAY;
    }

    public int j() {
        return this.a;
    }
}
