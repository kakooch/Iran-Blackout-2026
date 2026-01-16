package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes8.dex */
public class E45 {
    private Long a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Locale k;
    private b l;
    private final String[] m;
    private final String[] n;
    private final String[] o;
    private final String[] p;
    private final String[] q;
    private final String[] r;
    private final String[] s;
    private final String[] t;
    private final String[] u;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.FINGLISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.AFGHAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.KURDISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PASHTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        FINGLISH,
        AFGHAN,
        IRANIAN,
        KURDISH,
        PASHTO
    }

    public E45() throws ParseException {
        this.k = Locale.getDefault();
        this.l = b.IRANIAN;
        this.m = new String[]{"شنبه", "یک\u200cشنبه", "دوشنبه", "سه\u200cشنبه", "چهارشنبه", "پنج\u200cشنبه", "جمعه"};
        this.n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.a = Long.valueOf(new Date().getTime());
        P();
    }

    private void P() throws ParseException {
        this.e = Integer.parseInt(new SimpleDateFormat("yyyy", this.k).format(this.a));
        this.f = Integer.parseInt(new SimpleDateFormat("MM", this.k).format(this.a));
        this.g = Integer.parseInt(new SimpleDateFormat("dd", this.k).format(this.a));
        this.h = Integer.parseInt(new SimpleDateFormat("HH", this.k).format(this.a));
        this.i = Integer.parseInt(new SimpleDateFormat("mm", this.k).format(this.a));
        this.j = Integer.parseInt(new SimpleDateFormat("ss", this.k).format(this.a));
        k(false);
    }

    private void Z(int[] iArr, int[] iArr2) throws ParseException {
        this.e = iArr[0];
        this.f = iArr[1];
        this.g = iArr[2];
        this.b = iArr2[0];
        this.c = iArr2[1];
        this.d = iArr2[2];
        this.h = iArr2[3];
        this.i = iArr2[4];
        this.j = iArr2[5];
        f0();
    }

    private void f0() throws ParseException {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", this.k).parse("" + this.g + Separators.SLASH + this.f + Separators.SLASH + y() + Separators.SP + this.h + ":" + this.i + ":" + this.j);
            Objects.requireNonNull(date);
            this.a = Long.valueOf(date.getTime());
        } catch (ParseException unused) {
            this.a = Long.valueOf(new Date().getTime());
        }
    }

    private void i(int i, int i2, int i3, int i4, int i5, int i6) throws ParseException {
        int[] iArr = {i, i2, i3, i4, i5, i6};
        int[] iArr2 = {0, 0, 0, 0, 0, 0};
        int[] iArrO = O(i, i2, i3);
        iArr2[0] = iArrO[0];
        iArr2[1] = iArrO[1];
        iArr2[2] = iArrO[2];
        iArr2[3] = i4;
        iArr2[4] = i5;
        iArr2[5] = i6;
        Z(iArr, iArr2);
    }

    private void j(int i, int i2, int i3, int i4, int i5, int i6) throws ParseException {
        int[] iArr = {0, 0, 0, 0, 0, 0};
        int[] iArr2 = {i, i2, i3, i4, i5, i6};
        int[] iArrT = T(i, i2, i3);
        iArr[0] = iArrT[0];
        iArr[1] = iArrT[1];
        iArr[2] = iArrT[2];
        iArr[3] = i4;
        iArr[4] = i5;
        iArr[5] = i6;
        Z(iArr, iArr2);
    }

    private void k(boolean z) throws ParseException {
        if (z) {
            j(this.b, this.c, this.d, this.h, this.i, this.j);
        } else {
            i(this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public int A() {
        return this.i;
    }

    public int B() {
        return C(L(), K());
    }

    public int C(int i, int i2) {
        if (i2 != 12 || R(i)) {
            return i2 <= 6 ? 31 : 30;
        }
        return 29;
    }

    public int D() {
        return E(this);
    }

    public int E(E45 e45) {
        return F(Integer.valueOf(e45.L()), Integer.valueOf(e45.K()));
    }

    public int F(Integer num, Integer num2) {
        if (num2.intValue() <= 6) {
            return 31;
        }
        return (num2.intValue() > 11 && !R(num.intValue())) ? 29 : 30;
    }

    public String G() {
        return H(this);
    }

    public String H(E45 e45) {
        return e45.K() > e45.U().length ? "" : e45.U()[e45.K() - 1];
    }

    public int I() {
        return this.j;
    }

    public int J() {
        return this.d;
    }

    public int K() {
        return this.c;
    }

    public int L() {
        return this.b;
    }

    public String M() {
        return S().booleanValue() ? "ق.ظ" : "ب.ظ";
    }

    public String N() {
        return S().booleanValue() ? "قبل از ظهر" : "بعد از ظهر";
    }

    public int[] O(int i, int i2, int i3) {
        int[] iArr = new int[3];
        int i4 = i2 > 2 ? i + 1 : i;
        iArr[0] = i4;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = ((((i * 365) + 355666) + ((3 + i4) / 4)) - ((i4 + 99) / 100)) + ((i4 + 399) / 400) + i3 + new int[]{0, 31, 59, 90, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 151, SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, 212, WKSRecord.Service.SUR_MEAS, 273, 304, 334}[i2 - 1];
        iArr[2] = i5;
        int i6 = ((i5 / 12053) * 33) - 1595;
        iArr[0] = i6;
        int i7 = i5 % 12053;
        iArr[2] = i7;
        int i8 = i6 + ((i7 / 1461) * 4);
        iArr[0] = i8;
        int i9 = i7 % 1461;
        iArr[2] = i9;
        if (i9 > 365) {
            iArr[0] = i8 + ((i9 - 1) / 365);
            iArr[2] = (i9 - 1) % 365;
        }
        int i10 = iArr[2];
        if (i10 < 186) {
            iArr[1] = (i10 / 31) + 1;
            iArr[2] = (i10 % 31) + 1;
        } else {
            iArr[1] = ((i10 - 186) / 30) + 7;
            iArr[2] = ((i10 - 186) % 30) + 1;
        }
        return iArr;
    }

    public boolean Q() {
        return R(this.b);
    }

    public boolean R(int i) {
        double d = i;
        double dCeil = 1375.0d;
        double d2 = d - 1375.0d;
        if (d2 == 0.0d || d2 % 33.0d == 0.0d) {
            return true;
        }
        if (d2 <= 0.0d) {
            dCeil = d2 > -33.0d ? 1342.0d : 1375.0d - (Math.ceil(Math.abs(d2 / 33.0d)) * 33.0d);
        } else if (d2 > 33.0d) {
            dCeil = 1375.0d + (Math.floor(d2 / 33.0d) * 33.0d);
        }
        return Arrays.binarySearch(new double[]{dCeil, 4.0d + dCeil, 8.0d + dCeil, 12.0d + dCeil, 16.0d + dCeil, dCeil + 20.0d, dCeil + 24.0d, dCeil + 28.0d, 33.0d + dCeil}, d) >= 0;
    }

    public Boolean S() {
        return Boolean.valueOf(this.h < 12);
    }

    public int[] T(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i + 1595;
        int[] iArr = new int[3];
        iArr[0] = 0;
        iArr[1] = 0;
        int i7 = ((i6 * 365) - 355668) + ((i6 / 33) * 8) + (((i6 % 33) + 3) / 4) + i3 + (i2 < 7 ? (i2 - 1) * 31 : ((i2 - 7) * 30) + 186);
        iArr[2] = i7;
        int i8 = (i7 / 146097) * 400;
        iArr[0] = i8;
        int i9 = i7 % 146097;
        iArr[2] = i9;
        if (i9 > 36524) {
            int i10 = i9 - 1;
            iArr[2] = i10;
            iArr[0] = i8 + ((i10 / 36524) * 100);
            int i11 = i10 % 36524;
            iArr[2] = i11;
            if (i11 >= 365) {
                iArr[2] = i11 + 1;
            }
        }
        int i12 = iArr[0];
        int i13 = iArr[2];
        int i14 = i12 + ((i13 / 1461) * 4);
        iArr[0] = i14;
        int i15 = i13 % 1461;
        iArr[2] = i15;
        if (i15 > 365) {
            iArr[0] = i14 + ((i15 - 1) / 365);
            iArr[2] = (i15 - 1) % 365;
        }
        int i16 = iArr[0];
        int[] iArr2 = {0, 31, ((i16 % 4 != 0 || i16 % 100 == 0) && i16 % 400 != 0) ? 28 : 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        iArr[2] = iArr[2] + 1;
        while (true) {
            int i17 = iArr[1];
            if (i17 >= 13 || (i4 = iArr[2]) <= (i5 = iArr2[i17])) {
                break;
            }
            iArr[2] = i4 - i5;
            iArr[1] = i17 + 1;
        }
        return iArr;
    }

    public String[] U() {
        return V(b.IRANIAN);
    }

    public String[] V(b bVar) {
        int i = a.a[bVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.p : this.t : this.s : this.r : this.q;
    }

    public String W() {
        return Y(b.IRANIAN);
    }

    public String X(int i, b bVar) {
        int i2 = a.a[bVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? this.p[i - 1] : this.t[i - 1] : this.s[i - 1] : this.r[i - 1] : this.q[i - 1];
    }

    public String Y(b bVar) {
        return X(K(), bVar);
    }

    public String a() {
        return b(K());
    }

    public E45 a0(int i) throws ParseException {
        if (i < 0 || i > 23) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Hour must be between 0 and 23");
        }
        this.h = i;
        k(false);
        return this;
    }

    public String b(int i) {
        return this.r[i - 1];
    }

    public E45 b0(int i) throws ParseException {
        if (i < 1 || i > 31) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Day must be between 1 and 29~31");
        }
        if (i <= D()) {
            this.d = i;
            k(true);
            return this;
        }
        throw new IllegalArgumentException("PersianDate Error: ##=> Day in the " + G() + " must be between 1 and " + D());
    }

    public String c() {
        return d(K());
    }

    public E45 c0(int i) throws ParseException {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Month must be between 1 and 12");
        }
        this.c = i;
        k(true);
        return this;
    }

    public String d(int i) {
        return this.q[i - 1];
    }

    public E45 d0(int i) throws ParseException {
        if (i < 1) {
            throw new IllegalArgumentException("PersianDate Error: ##=> Year must be greater than 0");
        }
        this.b = i;
        k(true);
        return this;
    }

    public String e() {
        return f(K());
    }

    public Date e0() {
        return new Date(this.a.longValue());
    }

    public String f(int i) {
        return this.s[i - 1];
    }

    public String g() {
        return h(K());
    }

    public String h(int i) {
        return this.t[i - 1];
    }

    public String l() {
        return m(this);
    }

    public String m(E45 e45) {
        return this.o[s(e45)];
    }

    public String n() {
        return o(this);
    }

    public String o(E45 e45) {
        return this.n[s(e45)];
    }

    public String p() {
        return q(this);
    }

    public String q(E45 e45) {
        return this.m[s(e45)];
    }

    public int r() {
        return s(this);
    }

    public int s(E45 e45) {
        return t(e45.e0());
    }

    public int t(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(7) == 7) {
            return 0;
        }
        return calendar.get(7);
    }

    public String toString() {
        return G45.c(this, null);
    }

    public int u() {
        return v(this.h);
    }

    public int v(int i) {
        return i <= 12 ? i : i - 12;
    }

    public int w() {
        return x(K(), J());
    }

    public int x(int i, int i2) {
        int i3 = 1;
        while (i3 < i) {
            i2 = i3 <= 6 ? i2 + 31 : i2 + 30;
            i3++;
        }
        return i2;
    }

    public int y() {
        return this.e;
    }

    public int z() {
        return this.h;
    }

    public E45(Long l) throws ParseException {
        this.k = Locale.getDefault();
        this.l = b.IRANIAN;
        this.m = new String[]{"شنبه", "یک\u200cشنبه", "دوشنبه", "سه\u200cشنبه", "چهارشنبه", "پنج\u200cشنبه", "جمعه"};
        this.n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.a = l;
        P();
    }

    public E45(Date date) throws ParseException {
        this.k = Locale.getDefault();
        this.l = b.IRANIAN;
        this.m = new String[]{"شنبه", "یک\u200cشنبه", "دوشنبه", "سه\u200cشنبه", "چهارشنبه", "پنج\u200cشنبه", "جمعه"};
        this.n = new String[]{"Shanbe", "Yekshanbe", "Doshanbe", "Seshanbe", "Chaharshanbe", "Panjshanbe", "Jom'e"};
        this.o = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        this.p = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.q = new String[]{"Farvardin", "Ordibehesht", "Khordad", "Tir", "Mordad", "Shahrivar", "Mehr", "Aban", "Azar", "Day", "Bahman", "Esfand"};
        this.r = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.s = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.t = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.u = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        this.a = Long.valueOf(date.getTime());
        P();
    }
}
