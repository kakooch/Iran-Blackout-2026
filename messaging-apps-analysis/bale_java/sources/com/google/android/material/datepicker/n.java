package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC23026wD5;
import ir.nasim.YC5;
import java.util.Locale;

/* loaded from: classes3.dex */
class n extends RecyclerView.h {
    private final e d;

    public static class a extends RecyclerView.C {
        final TextView u;

        a(TextView textView) {
            super(textView);
            this.u = textView;
        }
    }

    n(e eVar) {
        this.d = eVar;
    }

    int A(int i) {
        return this.d.A8().i().c + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        int iA = A(i);
        String string = aVar.u.getContext().getString(AbstractC23026wD5.mtrl_picker_navigate_to_year_description);
        aVar.u.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iA)));
        aVar.u.setContentDescription(String.format(string, Integer.valueOf(iA)));
        b bVarB8 = this.d.B8();
        if (m.g().get(1) == iA) {
            com.google.android.material.datepicker.a aVar2 = bVarB8.f;
        } else {
            com.google.android.material.datepicker.a aVar3 = bVarB8.d;
        }
        this.d.D8();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(YC5.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.A8().j();
    }

    int z(int i) {
        return i - this.d.A8().i().c;
    }
}
