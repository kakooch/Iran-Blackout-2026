package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.WB5;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
class TimePickerView extends ConstraintLayout {
    private final ClockHandView A;
    private final ClockFaceView B;
    private final MaterialButtonToggleGroup D;
    private final View.OnClickListener G;
    private final Chip y;
    private final Chip z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.d0(TimePickerView.this);
        }
    }

    class b implements MaterialButtonToggleGroup.d {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
            TimePickerView.e0(TimePickerView.this);
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.f0(TimePickerView.this);
            return false;
        }
    }

    class d implements View.OnTouchListener {
        final /* synthetic */ GestureDetector a;

        d(GestureDetector gestureDetector) {
            this.a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
    }

    interface f {
    }

    interface g {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ g d0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ f e0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    static /* synthetic */ e f0(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    private void g0() {
        this.y.setTag(WB5.selection_type, 12);
        this.z.setTag(WB5.selection_type, 10);
        this.y.setOnClickListener(this.G);
        this.z.setOnClickListener(this.G);
        this.y.setAccessibilityClassName("android.view.View");
        this.z.setAccessibilityClassName("android.view.View");
    }

    private void h0() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.y.setOnTouchListener(dVar);
        this.z.setOnTouchListener(dVar);
    }

    private void i0() {
        if (this.D.getVisibility() == 0) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.p(this);
            cVar.n(WB5.material_clock_display, AbstractC12990fW7.A(this) == 0 ? 2 : 1);
            cVar.i(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i0();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            i0();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = new a();
        LayoutInflater.from(context).inflate(YC5.material_timepicker, this);
        this.B = (ClockFaceView) findViewById(WB5.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(WB5.material_clock_period_toggle);
        this.D = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new b());
        this.y = (Chip) findViewById(WB5.material_minute_tv);
        this.z = (Chip) findViewById(WB5.material_hour_tv);
        this.A = (ClockHandView) findViewById(WB5.material_clock_hand);
        h0();
        g0();
    }
}
