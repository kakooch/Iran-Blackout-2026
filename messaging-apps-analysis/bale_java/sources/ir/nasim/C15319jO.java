package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.jO, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15319jO extends AbstractC21435tf0 {
    private final C11458d25 g;
    private Context h;
    public C19024pf0 i;
    private UI4 j;

    public C15319jO(C19024pf0 c19024pf0, UI4 ui4, Context context, C11458d25 c11458d25) {
        super(c19024pf0, false);
        this.i = c19024pf0;
        this.j = ui4;
        this.h = context;
        this.g = c11458d25;
    }

    public C11458d25 J() {
        return this.g;
    }

    protected View K(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.h).inflate(i, viewGroup, false);
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void G(ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd2, int i, C18823pJ2 c18823pJ2) {
        viewOnClickListenerC4440Fd2.j1(c18823pJ2);
        if (i == this.i.r() - 1) {
            this.j.V(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public ViewOnClickListenerC4440Fd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewOnClickListenerC4440Fd2(this, K(AbstractC12208eD5.adapter_play_list_audio, viewGroup));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(ViewOnClickListenerC4440Fd2 viewOnClickListenerC4440Fd2) {
        viewOnClickListenerC4440Fd2.a();
    }
}
