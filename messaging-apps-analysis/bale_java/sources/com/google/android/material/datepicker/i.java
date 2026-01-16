package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.e;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.WB5;
import ir.nasim.YC5;

/* loaded from: classes3.dex */
class i extends RecyclerView.h {
    private final CalendarConstraints d;
    private final e.l e;
    private final int f;

    class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            if (this.a.getAdapter().l(i)) {
                i.this.e.a(this.a.getAdapter().getItem(i).longValue());
            }
        }
    }

    public static class b extends RecyclerView.C {
        final TextView u;
        final MaterialCalendarGridView v;

        b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(WB5.month_title);
            this.u = textView;
            AbstractC12990fW7.q0(textView, true);
            this.v = (MaterialCalendarGridView) linearLayout.findViewById(WB5.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    i(Context context, DateSelector dateSelector, CalendarConstraints calendarConstraints, e.l lVar) {
        Month monthI = calendarConstraints.i();
        Month monthF = calendarConstraints.f();
        Month monthH = calendarConstraints.h();
        if (monthI.compareTo(monthH) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthH.compareTo(monthF) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (h.e * e.E8(context)) + (f.V8(context) ? e.E8(context) : 0);
        this.d = calendarConstraints;
        this.e = lVar;
        setHasStableIds(true);
    }

    Month A(int i) {
        return this.d.i().t(i);
    }

    CharSequence B(int i) {
        return A(i).r();
    }

    int C(Month month) {
        return this.d.i().u(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i) {
        Month monthT = this.d.i().t(i);
        bVar.u.setText(monthT.r());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.v.findViewById(WB5.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthT.equals(materialCalendarGridView.getAdapter().a)) {
            h hVar = new h(monthT, null, this.d);
            materialCalendarGridView.setNumColumns(monthT.d);
            materialCalendarGridView.setAdapter((ListAdapter) hVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().k(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(YC5.mtrl_calendar_month_labeled, viewGroup, false);
        if (!f.V8(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public long getItemId(int i) {
        return this.d.i().t(i).s();
    }
}
