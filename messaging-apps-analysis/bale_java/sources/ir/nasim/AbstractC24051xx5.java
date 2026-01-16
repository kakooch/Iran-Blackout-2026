package ir.nasim;

import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import java.io.IOException;

/* renamed from: ir.nasim.xx5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC24051xx5 {
    public static AbstractC24641yx5 a(C9207Yy1 c9207Yy1) throws IOException {
        int iB = c9207Yy1.b();
        if (iB == 12) {
            return new C3677Bw4(c9207Yy1);
        }
        if (iB == 13) {
            return new C12679f12(c9207Yy1);
        }
        if (iB == 16) {
            return new C10002au6(c9207Yy1);
        }
        if (iB == 17) {
            return new NP(c9207Yy1);
        }
        if (iB == 230) {
            return new HQ5(c9207Yy1);
        }
        if (iB == 231) {
            return new C24386yX5(c9207Yy1);
        }
        switch (iB) {
            case 1:
                return new C7777Td5(c9207Yy1);
            case 2:
                return new C17286mi5(c9207Yy1);
            case 3:
                return new LL3(c9207Yy1);
            case 4:
                return new ML3(c9207Yy1);
            case 5:
                return new KL3(c9207Yy1);
            case 6:
                return new L44(c9207Yy1);
            case 7:
                return new UB7(c9207Yy1);
            case 8:
                return new VB7(c9207Yy1);
            case 9:
                return new VB7(c9207Yy1);
            case 10:
                return new C11899dk1(c9207Yy1);
            default:
                switch (iB) {
                    case 224:
                        return new DV5(c9207Yy1);
                    case 225:
                        return new B06(c9207Yy1);
                    case 226:
                        return new ZS5(c9207Yy1);
                    case SetUpdatesStruct$ComposedUpdates.USER_DEFAULT_CARD_NUMBER_CHANGED_FIELD_NUMBER /* 227 */:
                        return new C14224hZ5(c9207Yy1);
                    default:
                        throw new IOException("Unable to read proto object with header #" + iB);
                }
        }
    }

    public static AbstractC24641yx5 b(byte[] bArr) {
        return a(new C9207Yy1(bArr, 0, bArr.length));
    }

    public static AbstractC24641yx5 c(byte[] bArr) {
        C9207Yy1 c9207Yy1 = new C9207Yy1(bArr, 0, bArr.length);
        int iB = c9207Yy1.b();
        if (iB == 1) {
            return new Z66(c9207Yy1);
        }
        if (iB == 2) {
            return new S66(c9207Yy1);
        }
        if (iB == 3) {
            return new U66(c9207Yy1);
        }
        if (iB == 4) {
            return new W66(c9207Yy1);
        }
        throw new IOException("Unable to read proto object");
    }

    public static C21007sy5 d(C9207Yy1 c9207Yy1) {
        return new C21007sy5(c9207Yy1);
    }

    public static C21007sy5 e(byte[] bArr) {
        return d(new C9207Yy1(bArr, 0, bArr.length));
    }
}
