package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* renamed from: ir.nasim.kO, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15910kO implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final ImageView c;
    public final TextView d;
    public final StyledPlayerControlView e;
    public final ConstraintLayout f;

    private C15910kO(ConstraintLayout constraintLayout, RecyclerView recyclerView, ImageView imageView, TextView textView, StyledPlayerControlView styledPlayerControlView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = imageView;
        this.d = textView;
        this.e = styledPlayerControlView;
        this.f = constraintLayout2;
    }

    public static C15910kO a(View view) {
        int i = BC5.collection;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = BC5.icon_separator;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.message_separator;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.player_control;
                    StyledPlayerControlView styledPlayerControlView = (StyledPlayerControlView) AbstractC11738dW7.a(view, i);
                    if (styledPlayerControlView != null) {
                        i = BC5.separator;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            return new C15910kO((ConstraintLayout) view, recyclerView, imageView, textView, styledPlayerControlView, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15910kO c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C15910kO d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.audio_play_list_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
