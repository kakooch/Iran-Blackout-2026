package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC12799fB5;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.C22317v2;
import ir.nasim.DC5;
import ir.nasim.WB5;
import ir.nasim.X2;
import ir.nasim.YC5;
import ir.nasim.YJ4;
import java.util.Calendar;

/* loaded from: classes3.dex */
public final class e<S> extends com.google.android.material.datepicker.j {
    static final Object g1 = "MONTHS_VIEW_GROUP_TAG";
    static final Object h1 = "NAVIGATION_PREV_TAG";
    static final Object i1 = "NAVIGATION_NEXT_TAG";
    static final Object j1 = "SELECTOR_TOGGLE_TAG";
    private int X0;
    private CalendarConstraints Y0;
    private Month Z0;
    private k a1;
    private com.google.android.material.datepicker.b b1;
    private RecyclerView c1;
    private RecyclerView d1;
    private View e1;
    private View f1;

    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d1.smoothScrollToPosition(this.a);
        }
    }

    class b extends C22317v2 {
        b() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.r0(null);
        }
    }

    class c extends com.google.android.material.datepicker.k {
        final /* synthetic */ int I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void Q1(RecyclerView.z zVar, int[] iArr) {
            if (this.I == 0) {
                iArr[0] = e.this.d1.getWidth();
                iArr[1] = e.this.d1.getWidth();
            } else {
                iArr[0] = e.this.d1.getHeight();
                iArr[1] = e.this.d1.getHeight();
            }
        }
    }

    class d implements l {
        d() {
        }

        @Override // com.google.android.material.datepicker.e.l
        public void a(long j) {
            if (e.this.Y0.e().B0(j)) {
                e.v8(e.this);
                throw null;
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.e$e, reason: collision with other inner class name */
    class C0183e extends RecyclerView.o {
        private final Calendar a = m.i();
        private final Calendar b = m.i();

        C0183e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o
        public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            if ((recyclerView.getAdapter() instanceof n) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                e.v8(e.this);
                throw null;
            }
        }
    }

    class f extends C22317v2 {
        f() {
        }

        @Override // ir.nasim.C22317v2
        public void g(View view, X2 x2) {
            super.g(view, x2);
            x2.C0(e.this.f1.getVisibility() == 0 ? e.this.h6(AbstractC23026wD5.mtrl_picker_toggle_to_year_selection) : e.this.h6(AbstractC23026wD5.mtrl_picker_toggle_to_day_selection));
        }
    }

    class g extends RecyclerView.t {
        final /* synthetic */ com.google.android.material.datepicker.i a;
        final /* synthetic */ MaterialButton b;

        g(com.google.android.material.datepicker.i iVar, MaterialButton materialButton) {
            this.a = iVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            int iD2 = i < 0 ? e.this.G8().d2() : e.this.G8().g2();
            e.this.Z0 = this.a.A(iD2);
            this.b.setText(this.a.B(iD2));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.L8();
        }
    }

    class i implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;

        i(com.google.android.material.datepicker.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iD2 = e.this.G8().d2() + 1;
            if (iD2 < e.this.d1.getAdapter().getItemCount()) {
                e.this.J8(this.a.A(iD2));
            }
        }
    }

    class j implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.i a;

        j(com.google.android.material.datepicker.i iVar) {
            this.a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iG2 = e.this.G8().g2() - 1;
            if (iG2 >= 0) {
                e.this.J8(this.a.A(iG2));
            }
        }
    }

    enum k {
        DAY,
        YEAR
    }

    interface l {
        void a(long j);
    }

    static int E8(Context context) {
        return context.getResources().getDimensionPixelSize(AbstractC12799fB5.mtrl_calendar_day_height);
    }

    private static int F8(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_calendar_days_of_week_height);
        int i2 = com.google.android.material.datepicker.h.e;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(AbstractC12799fB5.mtrl_calendar_day_height) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(AbstractC12799fB5.mtrl_calendar_bottom_padding);
    }

    public static e H8(DateSelector dateSelector, int i2, CalendarConstraints calendarConstraints) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.h());
        eVar.a8(bundle);
        return eVar;
    }

    private void I8(int i2) {
        this.d1.post(new a(i2));
    }

    static /* synthetic */ DateSelector v8(e eVar) {
        eVar.getClass();
        return null;
    }

    private void y8(View view, com.google.android.material.datepicker.i iVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(WB5.month_navigation_fragment_toggle);
        materialButton.setTag(j1);
        AbstractC12990fW7.p0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(WB5.month_navigation_previous);
        materialButton2.setTag(h1);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(WB5.month_navigation_next);
        materialButton3.setTag(i1);
        this.e1 = view.findViewById(WB5.mtrl_calendar_year_selector_frame);
        this.f1 = view.findViewById(WB5.mtrl_calendar_day_selector_frame);
        K8(k.DAY);
        materialButton.setText(this.Z0.r());
        this.d1.addOnScrollListener(new g(iVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(iVar));
        materialButton2.setOnClickListener(new j(iVar));
    }

    private RecyclerView.o z8() {
        return new C0183e();
    }

    CalendarConstraints A8() {
        return this.Y0;
    }

    com.google.android.material.datepicker.b B8() {
        return this.b1;
    }

    Month C8() {
        return this.Z0;
    }

    public DateSelector D8() {
        return null;
    }

    LinearLayoutManager G8() {
        return (LinearLayoutManager) this.d1.getLayoutManager();
    }

    void J8(Month month) {
        com.google.android.material.datepicker.i iVar = (com.google.android.material.datepicker.i) this.d1.getAdapter();
        int iC = iVar.C(month);
        int iC2 = iC - iVar.C(this.Z0);
        boolean z = Math.abs(iC2) > 3;
        boolean z2 = iC2 > 0;
        this.Z0 = month;
        if (z && z2) {
            this.d1.scrollToPosition(iC - 3);
            I8(iC);
        } else if (!z) {
            I8(iC);
        } else {
            this.d1.scrollToPosition(iC + 3);
            I8(iC);
        }
    }

    void K8(k kVar) {
        this.a1 = kVar;
        if (kVar == k.YEAR) {
            this.c1.getLayoutManager().A1(((n) this.c1.getAdapter()).z(this.Z0.c));
            this.e1.setVisibility(0);
            this.f1.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.e1.setVisibility(8);
            this.f1.setVisibility(0);
            J8(this.Z0);
        }
    }

    void L8() {
        k kVar = this.a1;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            K8(k.DAY);
        } else if (kVar == k.DAY) {
            K8(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        if (bundle == null) {
            bundle = E5();
        }
        this.X0 = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC18350oW3.a(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.Y0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.Z0 = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(G5(), this.X0);
        this.b1 = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthI = this.Y0.i();
        if (com.google.android.material.datepicker.f.V8(contextThemeWrapper)) {
            i2 = YC5.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = YC5.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        viewInflate.setMinimumHeight(F8(S7()));
        GridView gridView = (GridView) viewInflate.findViewById(WB5.mtrl_calendar_days_of_week);
        AbstractC12990fW7.p0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.d());
        gridView.setNumColumns(monthI.d);
        gridView.setEnabled(false);
        this.d1 = (RecyclerView) viewInflate.findViewById(WB5.mtrl_calendar_months);
        this.d1.setLayoutManager(new c(G5(), i3, false, i3));
        this.d1.setTag(g1);
        com.google.android.material.datepicker.i iVar = new com.google.android.material.datepicker.i(contextThemeWrapper, null, this.Y0, new d());
        this.d1.setAdapter(iVar);
        int integer = contextThemeWrapper.getResources().getInteger(DC5.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(WB5.mtrl_calendar_year_selector_frame);
        this.c1 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.c1.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.c1.setAdapter(new n(this));
            this.c1.addItemDecoration(z8());
        }
        if (viewInflate.findViewById(WB5.month_navigation_fragment_toggle) != null) {
            y8(viewInflate, iVar);
        }
        if (!com.google.android.material.datepicker.f.V8(contextThemeWrapper)) {
            new u().b(this.d1);
        }
        this.d1.scrollToPosition(iVar.C(this.Z0));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle bundle) {
        super.i7(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.X0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Y0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.Z0);
    }

    @Override // com.google.android.material.datepicker.j
    public boolean r8(YJ4 yj4) {
        return super.r8(yj4);
    }
}
