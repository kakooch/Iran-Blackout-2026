package ir.nasim;

/* loaded from: classes8.dex */
abstract class Z12 extends Y12 {
    public static final W12 e(char c, boolean z) {
        if (!z) {
            if (c == 'D') {
                return W12.h;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c);
        }
        if (c == 'H') {
            return W12.g;
        }
        if (c == 'M') {
            return W12.f;
        }
        if (c == 'S') {
            return W12.e;
        }
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + c);
    }

    public static final W12 f(String str) {
        AbstractC13042fc3.i(str, "shortName");
        int iHashCode = str.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && str.equals("us")) {
                                    return W12.c;
                                }
                            } else if (str.equals("ns")) {
                                return W12.b;
                            }
                        } else if (str.equals("ms")) {
                            return W12.d;
                        }
                    } else if (str.equals("s")) {
                        return W12.e;
                    }
                } else if (str.equals("m")) {
                    return W12.f;
                }
            } else if (str.equals("h")) {
                return W12.g;
            }
        } else if (str.equals("d")) {
            return W12.h;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + str);
    }
}
