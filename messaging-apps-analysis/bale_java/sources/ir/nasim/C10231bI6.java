package ir.nasim;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.bI6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10231bI6 extends RecyclerView.o {
    private int a;

    public C10231bI6(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        int i = this.a;
        rect.right = i;
        rect.bottom = i;
    }
}
