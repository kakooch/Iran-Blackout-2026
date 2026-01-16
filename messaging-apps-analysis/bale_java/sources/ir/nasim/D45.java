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

/* loaded from: classes6.dex */
public class D45 {
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
    private final String[] l;
    private final String[] m;
    private final String[] n;
    private final String[] o;
    private final String[] p;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.AFGHAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.KURDISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.PASHTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    enum b {
        AFGHAN,
        IRANIAN,
        KURDISH,
        PASHTO
    }

    public D45() {
        this(new Date());
    }

    private void H() throws ParseException {
        this.e = Integer.parseInt(new SimpleDateFormat("yyyy", this.k).format(this.a));
        this.f = Integer.parseInt(new SimpleDateFormat("MM", this.k).format(this.a));
        this.g = Integer.parseInt(new SimpleDateFormat("dd", this.k).format(this.a));
        this.h = Integer.parseInt(new SimpleDateFormat("HH", this.k).format(this.a));
        this.i = Integer.parseInt(new SimpleDateFormat("mm", this.k).format(this.a));
        this.j = Integer.parseInt(new SimpleDateFormat("ss", this.k).format(this.a));
        l(false);
    }

    private void P(int[] iArr, int[] iArr2) throws ParseException {
        this.e = iArr[0];
        this.f = iArr[1];
        this.g = iArr[2];
        this.b = iArr2[0];
        this.c = iArr2[1];
        this.d = iArr2[2];
        this.h = iArr2[3];
        this.i = iArr2[4];
        this.j = iArr2[5];
        Y();
    }

    public static D45 X() throws ParseException {
        D45 d45 = new D45();
        d45.k(1L);
        d45.Q(0).R(0).S(0);
        return d45;
    }

    private void Y() throws ParseException {
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", this.k).parse("" + this.g + Separators.SLASH + this.f + Separators.SLASH + t() + Separators.SP + this.h + ":" + this.i + ":" + this.j);
            Objects.requireNonNull(date);
            this.a = Long.valueOf(date.getTime());
        } catch (ParseException unused) {
            this.a = Long.valueOf(new Date().getTime());
        }
    }

    private void g(int i, int i2, int i3, int i4, int i5, int i6) throws ParseException {
        int[] iArr = {i, i2, i3, i4, i5, i6};
        int[] iArr2 = {0, 0, 0, 0, 0, 0};
        int[] iArrG = G(i, i2, i3);
        iArr2[0] = iArrG[0];
        iArr2[1] = iArrG[1];
        iArr2[2] = iArrG[2];
        iArr2[3] = i4;
        iArr2[4] = i5;
        iArr2[5] = i6;
        P(iArr, iArr2);
    }

    private void h(int i, int i2, int i3, int i4, int i5, int i6) throws ParseException {
        int[] iArr = {0, 0, 0, 0, 0, 0};
        int[] iArr2 = {i, i2, i3, i4, i5, i6};
        int[] iArrL = L(i, i2, i3);
        iArr[0] = iArrL[0];
        iArr[1] = iArrL[1];
        iArr[2] = iArrL[2];
        iArr[3] = i4;
        iArr[4] = i5;
        iArr[5] = i6;
        P(iArr, iArr2);
    }

    private void l(boolean z) throws ParseException {
        if (z) {
            h(this.b, this.c, this.d, this.h, this.i, this.j);
        } else {
            g(this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    public int A() {
        return this.d;
    }

    public int B() {
        return this.c;
    }

    public int C() {
        return this.b;
    }

    public String D() {
        return K().booleanValue() ? "ق.ظ" : "ب.ظ";
    }

    public Long E() {
        return this.a;
    }

    public String F() {
        return K().booleanValue() ? "قبل از ظهر" : "بعد از ظهر";
    }

    public int[] G(int i, int i2, int i3) {
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

    public boolean I() {
        return J(this.b);
    }

    public boolean J(int i) {
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
        return Arrays.binarySearch(new double[]{dCeil, 4.0d + dCeil, 8.0d + dCeil, 16.0d + dCeil, 20.0d + dCeil, dCeil + 24.0d, dCeil + 28.0d, 33.0d + dCeil}, d) >= 0;
    }

    public Boolean K() {
        return Boolean.valueOf(this.h < 12);
    }

    public int[] L(int i, int i2, int i3) {
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

    public String M() {
        return O(b.IRANIAN);
    }

    public String N(int i, b bVar) {
        int i2 = a.a[bVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? this.m[i - 1] : this.p[i - 1] : this.o[i - 1] : this.n[i - 1];
    }

    public String O(b bVar) {
        return N(B(), bVar);
    }

    public D45 Q(int i) throws ParseException {
        this.h = i;
        l(false);
        return this;
    }

    public D45 R(int i) throws ParseException {
        this.i = i;
        l(false);
        return this;
    }

    public D45 S(int i) throws ParseException {
        this.j = i;
        l(false);
        return this;
    }

    public D45 T(int i) throws ParseException {
        this.d = i;
        l(true);
        return this;
    }

    public D45 U(int i) throws ParseException {
        this.c = i;
        l(true);
        return this;
    }

    public D45 V(int i) throws ParseException {
        this.b = i;
        l(true);
        return this;
    }

    public Date W() {
        return new Date(this.a.longValue());
    }

    public String a() {
        return b(B());
    }

    public String b(int i) {
        return this.n[i - 1];
    }

    public String c() {
        return d(B());
    }

    public String d(int i) {
        return this.o[i - 1];
    }

    public String e() {
        return f(B());
    }

    public String f(int i) {
        return this.p[i - 1];
    }

    public D45 i(long j, long j2, long j3) {
        return j(j, j2, j3, 0L, 0L, 0L);
    }

    public D45 j(long j, long j2, long j3, long j4, long j5, long j6) throws ParseException {
        long jRound;
        long j7 = j2;
        if (j7 >= 12) {
            jRound = Math.round(j7 / 12.0d) + j;
            j7 %= 12;
        } else {
            jRound = j;
        }
        long jIntValue = j3;
        for (long j8 = jRound - 1; j8 >= 0; j8--) {
            jIntValue += J(C() + ((int) j8)) ? 366L : 365L;
        }
        for (long j9 = j7 - 1; j9 >= 0; j9--) {
            int iB = B() + ((int) j9);
            int iC = C();
            if (iB > 12) {
                iB -= 12;
                iC++;
            }
            jIntValue += y(Integer.valueOf(iC), Integer.valueOf(iB)).intValue();
        }
        int i = this.c;
        long j10 = (i > 6 || ((long) i) + j7 < 7) ? j4 : j4 + 1;
        if (i >= 7 && i + j7 <= 6) {
            j10--;
        }
        Long lValueOf = Long.valueOf(this.a.longValue() + (jIntValue * 86400000));
        this.a = lValueOf;
        this.a = Long.valueOf(lValueOf.longValue() + ((j6 + (j10 * 3600) + (60 * j5)) * 1000));
        H();
        return this;
    }

    public D45 k(long j) {
        return i(0L, 0L, j);
    }

    public String m() {
        return n(this);
    }

    public String n(D45 d45) {
        return this.l[p(d45)];
    }

    public int o() {
        return p(this);
    }

    public int p(D45 d45) {
        return q(d45.W());
    }

    public int q(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(7) == 7) {
            return 0;
        }
        return calendar.get(7);
    }

    public int r() {
        return s(B(), A());
    }

    public int s(int i, int i2) {
        int i3 = 1;
        while (i3 < i) {
            i2 = i3 <= 6 ? i2 + 31 : i2 + 30;
            i3++;
        }
        return i2;
    }

    public int t() {
        return this.e;
    }

    public String toString() {
        return F45.a(this, null);
    }

    public int u() {
        return this.h;
    }

    public int v() {
        return this.i;
    }

    public int w() {
        return x(C(), B());
    }

    public int x(int i, int i2) {
        if (i2 != 12 || J(i)) {
            return i2 <= 6 ? 31 : 30;
        }
        return 29;
    }

    public Integer y(Integer num, Integer num2) {
        if (num2.intValue() <= 6) {
            return 31;
        }
        if (num2.intValue() > 11 && !J(num.intValue())) {
            return 29;
        }
        return 30;
    }

    public int z() {
        return this.j;
    }

    public D45(Long l) throws ParseException {
        this.k = Locale.getDefault();
        this.l = new String[]{"شنبه", "یک\u200cشنبه", "دوشنبه", "سه\u200cشنبه", "چهارشنبه", "پنج\u200cشنبه", "جمعه"};
        this.m = new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
        this.n = new String[]{"حمل", "ثور", "جوزا", "سرطان", "اسد", "سنبله", "میزان", "عقرب", "قوس", "جدی", "دلو", "حوت"};
        this.o = new String[]{"جیژنان", "گولان", "زه ردان", "په رپه ر", "گه لاویژ", "نوخشان", "به ران", "خه زان", "ساران", "بفران", "به ندان", "رمشان"};
        this.p = new String[]{"وری", "غويی", "غبرګولی", "چنګاښ", "زمری", "وږی", "تله", "لړم", "ليندۍ", "مرغومی", "سلواغه", "كب"};
        this.a = Long.valueOf(C19732qq7.e(l.longValue()));
        H();
    }

    public D45(Date date) {
        this(Long.valueOf(date.getTime()));
    }
}
