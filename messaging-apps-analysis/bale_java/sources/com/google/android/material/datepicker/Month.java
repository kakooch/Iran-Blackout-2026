package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes3.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    private final Calendar a;
    final int b;
    final int c;
    final int d;
    final int e;
    final long f;
    private String g;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.h(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i) {
            return new Month[i];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarD = m.d(calendar);
        this.a = calendarD;
        this.b = calendarD.get(2);
        this.c = calendarD.get(1);
        this.d = calendarD.getMaximum(7);
        this.e = calendarD.getActualMaximum(5);
        this.f = calendarD.getTimeInMillis();
    }

    static Month h(int i, int i2) {
        Calendar calendarI = m.i();
        calendarI.set(1, i);
        calendarI.set(2, i2);
        return new Month(calendarI);
    }

    static Month i(long j) {
        Calendar calendarI = m.i();
        calendarI.setTimeInMillis(j);
        return new Month(calendarI);
    }

    static Month j() {
        return new Month(m.g());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.a.compareTo(month.a);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.b == month.b && this.c == month.c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    int o() {
        int firstDayOfWeek = this.a.get(7) - this.a.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.d : firstDayOfWeek;
    }

    long p(int i) {
        Calendar calendarD = m.d(this.a);
        calendarD.set(5, i);
        return calendarD.getTimeInMillis();
    }

    int q(long j) {
        Calendar calendarD = m.d(this.a);
        calendarD.setTimeInMillis(j);
        return calendarD.get(5);
    }

    String r() {
        if (this.g == null) {
            this.g = c.c(this.a.getTimeInMillis());
        }
        return this.g;
    }

    long s() {
        return this.a.getTimeInMillis();
    }

    Month t(int i) {
        Calendar calendarD = m.d(this.a);
        calendarD.add(2, i);
        return new Month(calendarD);
    }

    int u(Month month) {
        if (this.a instanceof GregorianCalendar) {
            return ((month.c - this.c) * 12) + (month.b - this.b);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.b);
    }
}
