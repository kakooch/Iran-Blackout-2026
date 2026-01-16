package com.google.android.material.datepicker;

import android.gov.nist.javax.sip.parser.TokenTypes;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import ir.nasim.FG4;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    private final Month a;
    private final Month b;
    private final DateValidator c;
    private Month d;
    private final int e;
    private final int f;

    public interface DateValidator extends Parcelable {
        boolean B0(long j);
    }

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }
    }

    public static final class b {
        static final long e = m.a(Month.h(1900, 0).f);
        static final long f = m.a(Month.h(TokenTypes.CONTENT_DISPOSITION, 11).f);
        private long a;
        private long b;
        private Long c;
        private DateValidator d;

        b(CalendarConstraints calendarConstraints) {
            this.a = e;
            this.b = f;
            this.d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.a = calendarConstraints.a.f;
            this.b = calendarConstraints.b.f;
            this.c = Long.valueOf(calendarConstraints.d.f);
            this.d = calendarConstraints.c;
        }

        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.d);
            Month monthI = Month.i(this.a);
            Month monthI2 = Month.i(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l = this.c;
            return new CalendarConstraints(monthI, monthI2, dateValidator, l == null ? null : Month.i(l.longValue()), null);
        }

        public b b(long j) {
            this.c = Long.valueOf(j);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DateValidator e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.a.equals(calendarConstraints.a) && this.b.equals(calendarConstraints.b) && FG4.a(this.d, calendarConstraints.d) && this.c.equals(calendarConstraints.c);
    }

    Month f() {
        return this.b;
    }

    int g() {
        return this.f;
    }

    Month h() {
        return this.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.d, this.c});
    }

    Month i() {
        return this.a;
    }

    int j() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, 0);
        parcel.writeParcelable(this.b, 0);
        parcel.writeParcelable(this.d, 0);
        parcel.writeParcelable(this.c, 0);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.a = month;
        this.b = month2;
        this.d = month3;
        this.c = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f = month.u(month2) + 1;
        this.e = (month2.c - month.c) + 1;
    }
}
