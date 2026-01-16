package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;

/* loaded from: classes3.dex */
abstract class k extends LinearLayoutManager {

    class a extends o {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.o
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    k(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.p
    public void L1(RecyclerView recyclerView, RecyclerView.z zVar, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        M1(aVar);
    }
}
