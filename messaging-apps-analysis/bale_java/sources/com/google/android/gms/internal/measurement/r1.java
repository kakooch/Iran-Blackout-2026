package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
abstract class r1 {
    static String a(A0 a0) {
        StringBuilder sb = new StringBuilder(a0.r());
        for (int i = 0; i < a0.r(); i++) {
            byte bF = a0.f(i);
            if (bF == 34) {
                sb.append("\\\"");
            } else if (bF == 39) {
                sb.append("\\'");
            } else if (bF != 92) {
                switch (bF) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bF < 32 || bF > 126) {
                            sb.append('\\');
                            sb.append((char) (((bF >>> 6) & 3) + 48));
                            sb.append((char) (((bF >>> 3) & 7) + 48));
                            sb.append((char) ((bF & 7) + 48));
                            break;
                        } else {
                            sb.append((char) bF);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
