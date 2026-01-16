package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: ir.nasim.z45, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C24709z45 extends GregorianCalendar {
    private static int[] e = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] f = {31, 31, 31, 31, 31, 31, 30, 30, 30, 30, 30, 29};
    private int a;
    private int b;
    private int c;
    private String d;

    /* renamed from: ir.nasim.z45$a */
    static class a {
        private int a;
        private int b;
        private int c;

        a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public int d() {
            return this.c;
        }

        public int e() {
            return this.b;
        }

        public int f() {
            return this.a;
        }

        public void g(int i) {
            this.c = i;
        }

        public void h(int i) {
            this.a = i;
        }

        public String toString() {
            return f() + Separators.SLASH + e() + Separators.SLASH + d();
        }
    }

    public C24709z45() {
        super(TimeZone.getDefault(), Locale.getDefault());
        this.d = Separators.SLASH;
    }

    private String q(int i) {
        if (i >= 9) {
            return String.valueOf(i);
        }
        return "0" + i;
    }

    private static a y(a aVar) {
        if (aVar.e() > 11 || aVar.e() < -11) {
            throw new IllegalArgumentException();
        }
        aVar.h(aVar.f() - 1600);
        aVar.g(aVar.d() - 1);
        int iF = (((aVar.f() * 365) + ((int) Math.floor((aVar.f() + 3) / 4))) - ((int) Math.floor((aVar.f() + 99) / 100))) + ((int) Math.floor((aVar.f() + 399) / 400));
        int i = 0;
        for (int i2 = 0; i2 < aVar.e(); i2++) {
            iF += e[i2];
        }
        if (aVar.e() > 1 && ((aVar.f() % 4 == 0 && aVar.f() % 100 != 0) || aVar.f() % 400 == 0)) {
            iF++;
        }
        int iD = (iF + aVar.d()) - 79;
        int iFloor = (int) Math.floor(iD / 12053);
        int i3 = iD % 12053;
        int iFloor2 = (iFloor * 33) + 979 + ((i3 / 1461) * 4);
        int i4 = i3 % 1461;
        if (i4 >= 366) {
            iFloor2 += (int) Math.floor(r0 / 365);
            i4 = (i4 - 1) % 365;
        }
        while (i < 11) {
            int i5 = f[i];
            if (i4 < i5) {
                break;
            }
            i4 -= i5;
            i++;
        }
        return new a(iFloor2, i, i4 + 1);
    }

    private static a z(a aVar) {
        boolean z;
        if (aVar.e() > 11 || aVar.e() < -11) {
            throw new IllegalArgumentException();
        }
        aVar.h(aVar.f() - 979);
        aVar.g(aVar.d() - 1);
        int iF = (aVar.f() * 365) + ((aVar.f() / 33) * 8) + ((int) Math.floor(((aVar.f() % 33) + 3) / 4));
        for (int i = 0; i < aVar.e(); i++) {
            iF += f[i];
        }
        int iD = iF + aVar.d() + 79;
        int iFloor = (((int) Math.floor(iD / 146097)) * 400) + 1600;
        int i2 = iD % 146097;
        if (i2 >= 36525) {
            iFloor += ((int) Math.floor(r0 / 36524)) * 100;
            i2 = (i2 - 1) % 36524;
            if (i2 >= 365) {
                i2++;
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        int iFloor2 = iFloor + (((int) Math.floor(i2 / 1461)) * 4);
        int i3 = i2 % 1461;
        if (i3 >= 366) {
            iFloor2 += (int) Math.floor(r0 / 365);
            i3 = (i3 - 1) % 365;
            z = false;
        }
        int i4 = 0;
        while (true) {
            int i5 = e[i4];
            if (i3 < ((i4 == 1 && z) ? i4 : 0) + i5) {
                return new a(iFloor2, i4, i3 + 1);
            }
            i3 -= i5 + ((i4 == 1 && z) ? i4 : 0);
            i4++;
        }
    }

    public void C(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        a aVarZ = z(new a(i, i2 - 1, i3));
        set(aVarZ.a, aVarZ.b, aVarZ.c);
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    protected void p() {
        a aVarY = y(new a(get(1), get(2), get(5)));
        this.a = aVarY.a;
        this.b = aVarY.b;
        this.c = aVarY.c;
    }

    public int r() {
        return this.c;
    }

    public int s() {
        return this.b + 1;
    }

    @Override // java.util.Calendar
    public void set(int i, int i2) {
        super.set(i, i2);
        p();
    }

    @Override // java.util.Calendar
    public void setTimeInMillis(long j) {
        super.setTimeInMillis(j);
        p();
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void setTimeZone(TimeZone timeZone) {
        super.setTimeZone(timeZone);
        p();
    }

    @Override // java.util.Calendar
    public String toString() {
        return super.toString().substring(0, r0.length() - 1) + ",PersianDate=" + u() + "]";
    }

    public String u() {
        return "" + q(this.a) + this.d + q(s()) + this.d + q(this.c);
    }

    public int w() {
        return this.a;
    }
}
