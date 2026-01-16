package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
class h extends BaseAdapter {
    static final int e = m.i().getMaximum(4);
    final Month a;
    private Collection b;
    b c;
    final CalendarConstraints d;

    h(Month month, DateSelector dateSelector, CalendarConstraints calendarConstraints) {
        this.a = month;
        this.d = calendarConstraints;
        this.b = dateSelector.G1();
    }

    private void e(Context context) {
        if (this.c == null) {
            this.c = new b(context);
        }
    }

    private boolean f(long j) {
        throw null;
    }

    private void i(TextView textView, long j) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.d.e().B0(j)) {
            textView.setEnabled(true);
            aVar = f(j) ? this.c.b : m.g().getTimeInMillis() == j ? this.c.c : this.c.a;
        } else {
            textView.setEnabled(false);
            aVar = this.c.g;
        }
        aVar.b(textView);
    }

    private void j(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.i(j).equals(this.a)) {
            i((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.a.q(j)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    int a(int i) {
        return b() + (i - 1);
    }

    int b() {
        return this.a.o();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.a.o() || i > g()) {
            return null;
        }
        return Long.valueOf(this.a.p(h(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = ir.nasim.YC5.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.Month r8 = r5.a
            int r2 = r8.e
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.a
            long r7 = r8.p(r7)
            com.google.android.material.datepicker.Month r3 = r5.a
            int r3 = r3.c
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.j()
            int r4 = r4.c
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.c.a(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.c.d(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.i(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.h.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    int g() {
        return (this.a.o() + this.a.e) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.e + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.a.d;
    }

    int h(int i) {
        return (i - this.a.o()) + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public void k(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            j(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    boolean l(int i) {
        return i >= b() && i <= g();
    }
}
