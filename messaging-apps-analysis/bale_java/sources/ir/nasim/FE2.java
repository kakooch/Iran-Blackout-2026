package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class FE2 {
    private final C3988Df0 a;
    private final C19195pw1 b = new C19195pw1();
    private final StringBuilder c = new StringBuilder();

    FE2(C3988Df0 c3988Df0) {
        this.a = c3988Df0;
    }

    private C24184yB1 b(int i) {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new C24184yB1(i + 5, '$');
        }
        if (iF >= 5 && iF < 15) {
            return new C24184yB1(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new C24184yB1(i + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(iF2)));
        }
        return new C24184yB1(i + 6, c);
    }

    private C24184yB1 d(int i) throws FormatException {
        int iF = f(i, 5);
        if (iF == 15) {
            return new C24184yB1(i + 5, '$');
        }
        char c = '+';
        if (iF >= 5 && iF < 15) {
            return new C24184yB1(i + 5, (char) (iF + 43));
        }
        int iF2 = f(i, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new C24184yB1(i + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new C24184yB1(i + 7, (char) (iF2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case SetRpcStruct$ComposedRpc.SEARCH_PEER_FIELD_NUMBER /* 233 */:
                c = '\"';
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER /* 234 */:
                c = '%';
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_DIALOGS_ORDER_FIELD_NUMBER /* 235 */:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case SetRpcStruct$ComposedRpc.LOAD_OWN_STICKERS_FIELD_NUMBER /* 238 */:
                c = ')';
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_OWN_STICKERS_FIELD_NUMBER /* 239 */:
                c = '*';
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER /* 240 */:
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case WKSRecord.Service.SUR_MEAS /* 243 */:
                c = '.';
                break;
            case SetRpcStruct$ComposedRpc.ADD_STICKER_COLLECTION_FIELD_NUMBER /* 244 */:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER /* 246 */:
                c = ';';
                break;
            case SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER /* 247 */:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case Type.TSIG /* 250 */:
                c = '?';
                break;
            case Type.IXFR /* 251 */:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.a();
        }
        return new C24184yB1(i + 8, c);
    }

    private AB1 e(int i) {
        int i2 = i + 7;
        if (i2 > this.a.n()) {
            int iF = f(i, 4);
            return iF == 0 ? new AB1(this.a.n(), 10, 10) : new AB1(this.a.n(), iF - 1, 10);
        }
        int iF2 = f(i, 7) - 8;
        return new AB1(i2, iF2 / 11, iF2 % 11);
    }

    static int g(C3988Df0 c3988Df0, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (c3988Df0.i(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    private boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.a.n()) {
            return false;
        }
        while (i < i2) {
            if (this.a.i(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean i(int i) {
        int i2;
        if (i + 1 > this.a.n()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.a.n(); i3++) {
            if (i3 == 2) {
                if (!this.a.i(i + 2)) {
                    return false;
                }
            } else if (this.a.i(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i) {
        int i2;
        if (i + 1 > this.a.n()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.a.n(); i3++) {
            if (this.a.i(i2)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i) {
        int iF;
        if (i + 5 > this.a.n()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i + 6 <= this.a.n() && (iF = f(i, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    private boolean l(int i) {
        int iF;
        if (i + 5 > this.a.n()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i + 7 > this.a.n()) {
            return false;
        }
        int iF3 = f(i, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i + 8 <= this.a.n() && (iF = f(i, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    private boolean m(int i) {
        if (i + 7 > this.a.n()) {
            return i + 4 <= this.a.n();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.a.i(i3);
            }
            if (this.a.i(i2)) {
                return true;
            }
            i2++;
        }
    }

    private C14908ih0 n() {
        while (k(this.b.a())) {
            C24184yB1 c24184yB1B = b(this.b.a());
            this.b.h(c24184yB1B.a());
            if (c24184yB1B.c()) {
                return new C14908ih0(new C24774zB1(this.b.a(), this.c.toString()), true);
            }
            this.c.append(c24184yB1B.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.n()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.n());
            }
            this.b.f();
        }
        return new C14908ih0(false);
    }

    private C24774zB1 o() throws FormatException {
        C14908ih0 c14908ih0Q;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.c()) {
                c14908ih0Q = n();
                zB = c14908ih0Q.b();
            } else if (this.b.d()) {
                c14908ih0Q = p();
                zB = c14908ih0Q.b();
            } else {
                c14908ih0Q = q();
                zB = c14908ih0Q.b();
            }
            if (iA == this.b.a() && !zB) {
                break;
            }
        } while (!zB);
        return c14908ih0Q.a();
    }

    private C14908ih0 p() throws FormatException {
        while (l(this.b.a())) {
            C24184yB1 c24184yB1D = d(this.b.a());
            this.b.h(c24184yB1D.a());
            if (c24184yB1D.c()) {
                return new C14908ih0(new C24774zB1(this.b.a(), this.c.toString()), true);
            }
            this.c.append(c24184yB1D.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.n()) {
                this.b.b(5);
            } else {
                this.b.h(this.a.n());
            }
            this.b.e();
        }
        return new C14908ih0(false);
    }

    private C14908ih0 q() {
        while (m(this.b.a())) {
            AB1 ab1E = e(this.b.a());
            this.b.h(ab1E.a());
            if (ab1E.d()) {
                return new C14908ih0(ab1E.e() ? new C24774zB1(this.b.a(), this.c.toString()) : new C24774zB1(this.b.a(), this.c.toString(), ab1E.c()), true);
            }
            this.c.append(ab1E.b());
            if (ab1E.e()) {
                return new C14908ih0(new C24774zB1(this.b.a(), this.c.toString()), true);
            }
            this.c.append(ab1E.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new C14908ih0(false);
    }

    String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            C24774zB1 c24774zB1C = c(i, str);
            String strA = AbstractC4269Ek2.a(c24774zB1C.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = c24774zB1C.d() ? String.valueOf(c24774zB1C.c()) : null;
            if (i == c24774zB1C.a()) {
                return sb.toString();
            }
            i = c24774zB1C.a();
            str = strValueOf;
        }
    }

    C24774zB1 c(int i, String str) throws FormatException {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i);
        C24774zB1 c24774zB1O = o();
        return (c24774zB1O == null || !c24774zB1O.d()) ? new C24774zB1(this.b.a(), this.c.toString()) : new C24774zB1(this.b.a(), this.c.toString(), c24774zB1O.c());
    }

    int f(int i, int i2) {
        return g(this.a, i, i2);
    }
}
