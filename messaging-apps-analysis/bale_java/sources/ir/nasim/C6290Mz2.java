package ir.nasim;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Mz2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6290Mz2 extends RecyclerView.C {
    private C6290Mz2(FrameLayout frameLayout) {
        super(frameLayout);
    }

    static C6290Mz2 C0(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(AbstractC12990fW7.k());
        frameLayout.setSaveEnabled(false);
        return new C6290Mz2(frameLayout);
    }

    FrameLayout D0() {
        return (FrameLayout) this.a;
    }
}
