package ir.nasim;

/* loaded from: classes4.dex */
public enum PA {
    CODE(1),
    PASSWORD(2),
    FUTURE_AUTH_TOKEN(3),
    UNSUPPORTED_VALUE(-1);

    private int a;

    PA(int i) {
        this.a = i;
    }

    public static PA p(int i) {
        return i != 1 ? i != 2 ? i != 3 ? UNSUPPORTED_VALUE : FUTURE_AUTH_TOKEN : PASSWORD : CODE;
    }

    public int j() {
        return this.a;
    }
}
