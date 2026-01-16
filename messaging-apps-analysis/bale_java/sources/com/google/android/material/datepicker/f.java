package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.x;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import ir.nasim.AbstractC10402bY7;
import ir.nasim.AbstractC10701c32;
import ir.nasim.AbstractC12181eA5;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC21175tE5;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C10345bV3;
import ir.nasim.HB5;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.K93;
import ir.nasim.O98;
import ir.nasim.UU3;
import ir.nasim.WB5;
import ir.nasim.YC5;
import ir.nasim.YJ4;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class f<S> extends androidx.fragment.app.l {
    static final Object H1 = "CONFIRM_BUTTON_TAG";
    static final Object I1 = "CANCEL_BUTTON_TAG";
    static final Object J1 = "TOGGLE_BUTTON_TAG";
    private int A1;
    private CharSequence B1;
    private TextView C1;
    private CheckableImageButton D1;
    private C10345bV3 E1;
    private Button F1;
    private boolean G1;
    private final LinkedHashSet m1 = new LinkedHashSet();
    private final LinkedHashSet n1 = new LinkedHashSet();
    private final LinkedHashSet o1 = new LinkedHashSet();
    private final LinkedHashSet p1 = new LinkedHashSet();
    private int q1;
    private j r1;
    private CalendarConstraints s1;
    private e t1;
    private int u1;
    private CharSequence v1;
    private boolean w1;
    private int x1;
    private int y1;
    private CharSequence z1;

    class a implements InterfaceC22474vI4 {
        final /* synthetic */ int a;
        final /* synthetic */ View b;
        final /* synthetic */ int c;

        a(int i, View view, int i2) {
            this.a = i;
            this.b = view;
            this.c = i2;
        }

        @Override // ir.nasim.InterfaceC22474vI4
        public O98 b(View view, O98 o98) {
            int i = o98.f(O98.m.i()).b;
            if (this.a >= 0) {
                this.b.getLayoutParams().height = this.a + i;
                View view2 = this.b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.b;
            view3.setPadding(view3.getPaddingLeft(), this.c + i, this.b.getPaddingRight(), this.b.getPaddingBottom());
            return o98;
        }
    }

    class b extends YJ4 {
        b() {
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Button unused = f.this.F1;
            f.M8(f.this);
            throw null;
        }
    }

    static /* synthetic */ DateSelector M8(f fVar) {
        fVar.Q8();
        return null;
    }

    private static Drawable O8(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, AbstractC9594aE.b(context, HB5.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AbstractC9594aE.b(context, HB5.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private void P8(Window window) {
        if (this.G1) {
            return;
        }
        View viewFindViewById = V7().findViewById(WB5.fullscreen_header);
        AbstractC10701c32.a(window, true, AbstractC10402bY7.e(viewFindViewById), null);
        AbstractC12990fW7.E0(viewFindViewById, new a(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingTop()));
        this.G1 = true;
    }

    private DateSelector Q8() {
        AbstractC18350oW3.a(E5().getParcelable("DATE_SELECTOR_KEY"));
        return null;
    }

    private static int S8(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_content_padding);
        int i = Month.j().d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_month_horizontal_padding));
    }

    private int T8(Context context) {
        int i = this.q1;
        if (i != 0) {
            return i;
        }
        Q8();
        throw null;
    }

    private void U8(Context context) {
        this.D1.setTag(J1);
        this.D1.setImageDrawable(O8(context));
        this.D1.setChecked(this.x1 != 0);
        AbstractC12990fW7.p0(this.D1, null);
        a9(this.D1);
        this.D1.setOnClickListener(new c());
    }

    static boolean V8(Context context) {
        return X8(context, R.attr.windowFullscreen);
    }

    static boolean W8(Context context) {
        return X8(context, AbstractC12181eA5.nestedScrollable);
    }

    static boolean X8(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(UU3.d(context, AbstractC12181eA5.materialCalendarStyle, e.class.getCanonicalName()), new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    private void Y8() {
        j jVarT8;
        int iT8 = T8(S7());
        Q8();
        this.t1 = e.H8(null, iT8, this.s1);
        if (this.D1.isChecked()) {
            Q8();
            jVarT8 = g.t8(null, iT8, this.s1);
        } else {
            jVarT8 = this.t1;
        }
        this.r1 = jVarT8;
        Z8();
        x xVarS = F5().s();
        xVarS.q(WB5.mtrl_calendar_frame, this.r1);
        xVarS.j();
        this.r1.r8(new b());
    }

    private void Z8() {
        String strR8 = R8();
        this.C1.setContentDescription(String.format(h6(AbstractC23026wD5.mtrl_picker_announce_current_selection), strR8));
        this.C1.setText(strR8);
    }

    private void a9(CheckableImageButton checkableImageButton) {
        this.D1.setContentDescription(this.D1.isChecked() ? checkableImageButton.getContext().getString(AbstractC23026wD5.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(AbstractC23026wD5.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.l
    public final Dialog B8(Bundle bundle) {
        Dialog dialog = new Dialog(S7(), T8(S7()));
        Context context = dialog.getContext();
        this.w1 = V8(context);
        int iD = UU3.d(context, AbstractC12181eA5.colorSurface, f.class.getCanonicalName());
        C10345bV3 c10345bV3 = new C10345bV3(context, null, AbstractC12181eA5.materialCalendarStyle, AbstractC21175tE5.Widget_MaterialComponents_MaterialCalendar);
        this.E1 = c10345bV3;
        c10345bV3.Q(context);
        this.E1.b0(ColorStateList.valueOf(iD));
        this.E1.a0(AbstractC12990fW7.v(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void M6(Bundle bundle) {
        super.M6(bundle);
        if (bundle == null) {
            bundle = E5();
        }
        this.q1 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        AbstractC18350oW3.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.s1 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.u1 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.v1 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.x1 = bundle.getInt("INPUT_MODE_KEY");
        this.y1 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.z1 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.A1 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.B1 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.w1 ? YC5.mtrl_picker_fullscreen : YC5.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.w1) {
            viewInflate.findViewById(WB5.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(S8(context), -2));
        } else {
            viewInflate.findViewById(WB5.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(S8(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(WB5.mtrl_picker_header_selection_text);
        this.C1 = textView;
        AbstractC12990fW7.r0(textView, 1);
        this.D1 = (CheckableImageButton) viewInflate.findViewById(WB5.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(WB5.mtrl_picker_title_text);
        CharSequence charSequence = this.v1;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.u1);
        }
        U8(context);
        this.F1 = (Button) viewInflate.findViewById(WB5.confirm_button);
        Q8();
        throw null;
    }

    public String R8() {
        Q8();
        G5();
        throw null;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public final void i7(Bundle bundle) {
        super.i7(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.q1);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.s1);
        if (this.t1.C8() != null) {
            bVar.b(this.t1.C8().f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.u1);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.v1);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.y1);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.z1);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.A1);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.B1);
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() throws Resources.NotFoundException {
        super.j7();
        Window window = F8().getWindow();
        if (this.w1) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.E1);
            P8(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = b6().getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.E1, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new K93(F8(), rect));
        }
        Y8();
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void k7() {
        this.r1.s8();
        super.k7();
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.o1.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.p1.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) o6();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
