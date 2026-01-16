package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.YJ4;

/* loaded from: classes3.dex */
public final class g<S> extends j {
    private int X0;
    private CalendarConstraints Y0;

    class a extends YJ4 {
        a() {
        }
    }

    static g t8(DateSelector dateSelector, int i, CalendarConstraints calendarConstraints) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        gVar.a8(bundle);
        return gVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        super.M6(bundle);
        if (bundle == null) {
            bundle = E5();
        }
        this.X0 = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC18350oW3.a(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.Y0 = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(G5(), this.X0));
        new a();
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void i7(Bundle bundle) {
        super.i7(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.X0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Y0);
    }
}
