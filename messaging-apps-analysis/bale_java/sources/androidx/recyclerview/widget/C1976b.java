package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC12197eC3;

/* renamed from: androidx.recyclerview.widget.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1976b implements InterfaceC12197eC3 {
    private final RecyclerView.h a;

    public C1976b(RecyclerView.h hVar) {
        this.a = hVar;
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void a(int i, int i2) {
        this.a.notifyItemRangeInserted(i, i2);
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void b(int i, int i2) {
        this.a.notifyItemRangeRemoved(i, i2);
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void c(int i, int i2, Object obj) {
        this.a.notifyItemRangeChanged(i, i2, obj);
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void d(int i, int i2) {
        this.a.notifyItemMoved(i, i2);
    }
}
