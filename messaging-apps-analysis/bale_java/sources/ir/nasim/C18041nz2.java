package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import ir.nasim.features.smiles.widget.EmojiRecyclerView;

/* renamed from: ir.nasim.nz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18041nz2 implements InterfaceC9764aW7 {
    private final CoordinatorLayout a;
    public final TextInputEditText b;
    public final LinearLayoutCompat c;
    public final LinearLayout d;
    public final EmojiRecyclerView e;
    public final TextInputLayout f;
    public final TabLayout g;
    public final View h;

    private C18041nz2(CoordinatorLayout coordinatorLayout, TextInputEditText textInputEditText, LinearLayoutCompat linearLayoutCompat, LinearLayout linearLayout, EmojiRecyclerView emojiRecyclerView, TextInputLayout textInputLayout, TabLayout tabLayout, View view) {
        this.a = coordinatorLayout;
        this.b = textInputEditText;
        this.c = linearLayoutCompat;
        this.d = linearLayout;
        this.e = emojiRecyclerView;
        this.f = textInputLayout;
        this.g = tabLayout;
        this.h = view;
    }

    public static C18041nz2 a(View view) {
        View viewA;
        int i = BC5.edSearch;
        TextInputEditText textInputEditText = (TextInputEditText) AbstractC11738dW7.a(view, i);
        if (textInputEditText != null) {
            i = BC5.llEmojiTab;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) AbstractC11738dW7.a(view, i);
            if (linearLayoutCompat != null) {
                i = BC5.llMain;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = BC5.rcSmilesEmoji;
                    EmojiRecyclerView emojiRecyclerView = (EmojiRecyclerView) AbstractC11738dW7.a(view, i);
                    if (emojiRecyclerView != null) {
                        i = BC5.tiSearch;
                        TextInputLayout textInputLayout = (TextInputLayout) AbstractC11738dW7.a(view, i);
                        if (textInputLayout != null) {
                            i = BC5.tlSmilesEmoji;
                            TabLayout tabLayout = (TabLayout) AbstractC11738dW7.a(view, i);
                            if (tabLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.vDivider))) != null) {
                                return new C18041nz2((CoordinatorLayout) view, textInputEditText, linearLayoutCompat, linearLayout, emojiRecyclerView, textInputLayout, tabLayout, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C18041nz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_smiles_emoji, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
