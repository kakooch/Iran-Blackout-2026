package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.gn6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13773gn6 extends RecyclerView.h {
    private final UA2 d;
    private final InterfaceC10258bL6 e;

    public C13773gn6(UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
        AbstractC13042fc3.i(ua2, "removeContact");
        AbstractC13042fc3.i(interfaceC10258bL6, "selectedContact");
        this.d = ua2;
        this.e = interfaceC10258bL6;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C13182fn6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C10476bg3 c10476bg3C = C10476bg3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c10476bg3C, "inflate(...)");
        return new C13182fn6(c10476bg3C, this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C13182fn6 c13182fn6, int i) {
        AbstractC13042fc3.i(c13182fn6, "holder");
    }
}
