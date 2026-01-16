package ir.nasim;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/* renamed from: ir.nasim.ue3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22085ue3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageButton b;
    public final ImageButton c;
    public final LinearLayout d;
    public final TextView e;
    public final RecyclerView f;
    public final View g;
    public final ImageButton h;
    public final MaterialButton i;
    public final View j;
    public final TextInputEditText k;
    public final CardView l;
    public final TextView m;
    public final View n;

    private C22085ue3(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, LinearLayout linearLayout, TextView textView, RecyclerView recyclerView, View view, ImageButton imageButton3, MaterialButton materialButton, View view2, TextInputEditText textInputEditText, CardView cardView, TextView textView2, View view3) {
        this.a = constraintLayout;
        this.b = imageButton;
        this.c = imageButton2;
        this.d = linearLayout;
        this.e = textView;
        this.f = recyclerView;
        this.g = view;
        this.h = imageButton3;
        this.i = materialButton;
        this.j = view2;
        this.k = textInputEditText;
        this.l = cardView;
        this.m = textView2;
        this.n = view3;
    }

    public static C22085ue3 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i = BC5.back;
        ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
        if (imageButton != null) {
            i = BC5.clear;
            ImageButton imageButton2 = (ImageButton) AbstractC11738dW7.a(view, i);
            if (imageButton2 != null) {
                i = BC5.empty_state;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = BC5.empty_state_text;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.galleryRecyclerView;
                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.handlerView))) != null) {
                            i = BC5.ic_search;
                            ImageButton imageButton3 = (ImageButton) AbstractC11738dW7.a(view, i);
                            if (imageButton3 != null) {
                                i = BC5.invite_button;
                                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                                if (materialButton != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.itemsDividerView))) != null) {
                                    i = BC5.search_field;
                                    TextInputEditText textInputEditText = (TextInputEditText) AbstractC11738dW7.a(view, i);
                                    if (textInputEditText != null) {
                                        i = BC5.text_container;
                                        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                        if (cardView != null) {
                                            i = BC5.titleTextView;
                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView2 != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.toast_anchor))) != null) {
                                                return new C22085ue3((ConstraintLayout) view, imageButton, imageButton2, linearLayout, textView, recyclerView, viewA, imageButton3, materialButton, viewA2, textInputEditText, cardView, textView2, viewA3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
