package ir.nasim.features.pfm.persiandate.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import ir.nasim.A45;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.B45;
import ir.nasim.BC5;
import ir.nasim.C19406qI3;
import ir.nasim.C24709z45;
import ir.nasim.I45;
import ir.nasim.R45;
import ir.nasim.S45;
import ir.nasim.TA5;
import ir.nasim.YE5;
import java.lang.reflect.Field;
import java.util.Date;

/* loaded from: classes6.dex */
public class PersianDatePicker extends LinearLayout {
    private S45 a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private e f;
    private final PersianNumberPicker g;
    private final PersianNumberPicker h;
    private final PersianNumberPicker i;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private final TextView o;
    private int p;
    private int q;
    NumberPicker.OnValueChangeListener r;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        long a;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.a);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readLong();
        }
    }

    class a implements NumberPicker.Formatter {
        a() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            return R45.a(i + "");
        }
    }

    class b implements NumberPicker.Formatter {
        b() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            return R45.a(i + "");
        }
    }

    class c implements NumberPicker.Formatter {
        c() {
        }

        @Override // android.widget.NumberPicker.Formatter
        public String format(int i) {
            return R45.a(i + "");
        }
    }

    class d implements NumberPicker.OnValueChangeListener {
        d() {
        }

        @Override // android.widget.NumberPicker.OnValueChangeListener
        public void onValueChange(NumberPicker numberPicker, int i, int i2) {
            int value = PersianDatePicker.this.g.getValue();
            boolean zB = B45.b(value);
            int value2 = PersianDatePicker.this.h.getValue();
            int value3 = PersianDatePicker.this.i.getValue();
            if (value2 < 7) {
                PersianDatePicker.this.i.setMinValue(1);
                PersianDatePicker.this.setDayNumberPickerMaxValue(31);
            } else if (value2 < 12) {
                if (value3 == 31) {
                    PersianDatePicker.this.i.setValue(30);
                    value3 = 30;
                }
                PersianDatePicker.this.i.setMinValue(1);
                PersianDatePicker.this.setDayNumberPickerMaxValue(30);
            } else if (value2 == 12) {
                if (zB) {
                    if (value3 == 31) {
                        PersianDatePicker.this.i.setValue(30);
                        value3 = 30;
                    }
                    PersianDatePicker.this.i.setMinValue(1);
                    PersianDatePicker.this.setDayNumberPickerMaxValue(30);
                } else {
                    if (value3 > 29) {
                        PersianDatePicker.this.i.setValue(29);
                        value3 = 29;
                    }
                    PersianDatePicker.this.i.setMinValue(1);
                    PersianDatePicker.this.setDayNumberPickerMaxValue(29);
                }
            }
            PersianDatePicker.this.a.c(value, value2, value3);
            if (PersianDatePicker.this.n) {
                PersianDatePicker.this.o.setText(PersianDatePicker.this.a.h());
            }
            if (PersianDatePicker.this.f != null) {
                PersianDatePicker.this.f.a(value, value2, value3);
            }
        }
    }

    public interface e {
        void a(int i, int i2, int i3);
    }

    public PersianDatePicker(Context context) {
        this(context, null, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(int i) {
        this.g.setValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i) {
        this.h.setValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i) {
        this.i.setValue(i);
    }

    private void n(NumberPicker numberPicker, int i) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        for (Field field : NumberPicker.class.getDeclaredFields()) {
            if (field.getName().equals("mSelectionDivider")) {
                field.setAccessible(true);
                try {
                    field.set(numberPicker, new ColorDrawable(i));
                    return;
                } catch (Resources.NotFoundException | IllegalAccessException | IllegalArgumentException e2) {
                    C19406qI3.d("PersianDatePicker", e2);
                    return;
                }
            }
        }
    }

    private void o(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, YE5.PersianDatePicker, 0, 0);
        this.q = typedArrayObtainStyledAttributes.getInteger(YE5.PersianDatePicker_yearRange, 10);
        this.j = typedArrayObtainStyledAttributes.getInt(YE5.PersianDatePicker_minYear, this.a.i() - this.q);
        this.k = typedArrayObtainStyledAttributes.getInt(YE5.PersianDatePicker_maxYear, this.a.i() + this.q);
        this.e = typedArrayObtainStyledAttributes.getBoolean(YE5.PersianDatePicker_displayMonthNames, false);
        this.n = typedArrayObtainStyledAttributes.getBoolean(YE5.PersianDatePicker_displayDescription, false);
        this.d = typedArrayObtainStyledAttributes.getInteger(YE5.PersianDatePicker_selectedDay, this.a.b());
        this.c = typedArrayObtainStyledAttributes.getInt(YE5.PersianDatePicker_selectedYear, this.a.i());
        this.b = typedArrayObtainStyledAttributes.getInteger(YE5.PersianDatePicker_selectedMonth, this.a.e());
        int i = this.j;
        int i2 = this.c;
        if (i > i2) {
            this.j = i2 - this.q;
        }
        if (this.k < i2) {
            this.k = i2 + this.q;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void p() throws IllegalAccessException, SecurityException, IllegalArgumentException {
        int i = this.p;
        if (i > 0) {
            n(this.g, i);
            n(this.h, this.p);
            n(this.i, this.p);
        }
        this.g.setMinValue(this.j);
        this.g.setMaxValue(this.k);
        int i2 = this.c;
        int i3 = this.k;
        if (i2 > i3) {
            this.c = i3;
        }
        int i4 = this.c;
        int i5 = this.j;
        if (i4 < i5) {
            this.c = i5;
        }
        this.g.setValue(this.c);
        this.g.setOnValueChangedListener(this.r);
        this.h.setMinValue(1);
        PersianNumberPicker persianNumberPicker = this.h;
        int i6 = this.l;
        if (i6 <= 0) {
            i6 = 12;
        }
        persianNumberPicker.setMaxValue(i6);
        if (this.e) {
            this.h.setDisplayedValues(A45.a);
        }
        int i7 = this.b;
        if (i7 < 1 || i7 > 12) {
            throw new IllegalArgumentException(String.format("Selected month (%d) must be between 1 and 12", Integer.valueOf(this.b)));
        }
        this.h.setValue(i7);
        this.h.setOnValueChangedListener(this.r);
        this.i.setMinValue(1);
        setDayNumberPickerMaxValue(31);
        int i8 = this.d;
        if (i8 > 31 || i8 < 1) {
            throw new IllegalArgumentException(String.format("Selected day (%d) must be between 1 and 31", Integer.valueOf(this.d)));
        }
        boolean zB = B45.b(this.c);
        int i9 = this.b;
        if (i9 < 7) {
            this.i.setMinValue(1);
            setDayNumberPickerMaxValue(31);
        } else if (i9 < 12) {
            if (this.d == 31) {
                this.d = 30;
            }
            this.i.setMinValue(1);
            setDayNumberPickerMaxValue(30);
        } else if (i9 == 12) {
            if (zB) {
                if (this.d == 31) {
                    this.d = 30;
                }
                this.i.setMinValue(1);
                setDayNumberPickerMaxValue(30);
            } else {
                if (this.d > 29) {
                    this.d = 29;
                }
                this.i.setMinValue(1);
                setDayNumberPickerMaxValue(29);
            }
        }
        this.i.setValue(this.d);
        this.i.setOnValueChangedListener(this.r);
        if (this.n) {
            this.o.setVisibility(0);
            this.o.setText(this.a.h());
        }
    }

    private void setTextColor(int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.g.setTextColor(i);
            this.h.setTextColor(i);
            this.i.setTextColor(i);
        }
    }

    public Date getDisplayDate() {
        return this.a.g();
    }

    @Deprecated
    public C24709z45 getDisplayPersianDate() {
        C24709z45 c24709z45 = new C24709z45();
        c24709z45.C(this.a.i(), this.a.e(), this.a.b());
        return c24709z45;
    }

    public S45 getPersianPickerDate() {
        return this.a;
    }

    public PersianNumberPicker getYearNumberPicker() {
        return this.g;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setDisplayDate(new Date(savedState.a));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = getDisplayDate().getTime();
        return savedState;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.g.setBackgroundColor(i);
        this.h.setBackgroundColor(i);
        this.i.setBackgroundColor(i);
    }

    public void setDayNumberPickerMaxValue(int i) {
        if (this.h.getValue() != this.l) {
            this.i.setMaxValue(i);
            return;
        }
        int i2 = this.m;
        if (i2 > 0) {
            this.i.setMaxValue(i2);
        } else {
            this.i.setMaxValue(i);
        }
    }

    public void setDisplayDate(Date date) {
        this.a.f(date);
        setDisplayPersianDate(this.a);
    }

    @Deprecated
    public void setDisplayPersianDate(C24709z45 c24709z45) {
        I45 i45 = new I45();
        i45.c(c24709z45.w(), c24709z45.s(), c24709z45.r());
        setDisplayPersianDate(i45);
    }

    public void setDividerColor(int i) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        n(this.h, i);
        n(this.g, i);
        n(this.i, i);
    }

    public void setMaxYear(int i) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        this.k = i;
        p();
    }

    public void setMinYear(int i) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        this.j = i;
        p();
    }

    public void setOnDateChangedListener(e eVar) {
        this.f = eVar;
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public PersianDatePicker(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i);
        this.r = new d();
        View viewInflate = LayoutInflater.from(context).inflate(AbstractC12208eD5.sl_persian_date_picker, this);
        PersianNumberPicker persianNumberPicker = (PersianNumberPicker) viewInflate.findViewById(BC5.yearNumberPicker);
        this.g = persianNumberPicker;
        PersianNumberPicker persianNumberPicker2 = (PersianNumberPicker) viewInflate.findViewById(BC5.monthNumberPicker);
        this.h = persianNumberPicker2;
        PersianNumberPicker persianNumberPicker3 = (PersianNumberPicker) viewInflate.findViewById(BC5.dayNumberPicker);
        this.i = persianNumberPicker3;
        this.o = (TextView) viewInflate.findViewById(BC5.descriptionTextView);
        persianNumberPicker.setFormatter(new a());
        persianNumberPicker2.setFormatter(new b());
        persianNumberPicker3.setFormatter(new c());
        this.a = new I45();
        o(context, attributeSet);
        p();
        setTextColor(AbstractC4043Dl1.c(getContext(), TA5.secondary));
    }

    public void setDisplayPersianDate(S45 s45) {
        this.a.a(Long.valueOf(s45.getTimestamp()));
        final int i = this.a.i();
        final int iE = this.a.e();
        final int iB = this.a.b();
        this.c = i;
        this.b = iE;
        this.d = iB;
        if (this.j > i) {
            int i2 = i - this.q;
            this.j = i2;
            this.g.setMinValue(i2);
        }
        int i3 = this.k;
        int i4 = this.c;
        if (i3 < i4) {
            int i5 = i4 + this.q;
            this.k = i5;
            this.g.setMaxValue(i5);
        }
        this.g.post(new Runnable() { // from class: ir.nasim.K45
            @Override // java.lang.Runnable
            public final void run() {
                this.a.k(i);
            }
        });
        this.h.post(new Runnable() { // from class: ir.nasim.L45
            @Override // java.lang.Runnable
            public final void run() {
                this.a.l(iE);
            }
        });
        this.i.post(new Runnable() { // from class: ir.nasim.M45
            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(iB);
            }
        });
    }
}
