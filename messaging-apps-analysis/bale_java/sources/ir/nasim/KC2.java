package ir.nasim;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.components.badges.view.CounterBadge;

/* loaded from: classes6.dex */
public final class KC2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ImageView b;
    public final CounterBadge c;
    public final EditText d;
    public final LinearLayout e;
    public final ConstraintLayout f;
    public final RecyclerView g;
    public final View h;
    public final View i;
    public final ConstraintLayout j;
    public final View k;
    public final ImageView l;
    public final ImageView m;
    public final Group n;
    public final ImageView o;
    public final TextView p;
    public final ImageView q;
    public final LinearLayout r;
    public final TextView s;

    private KC2(ConstraintLayout constraintLayout, ImageView imageView, CounterBadge counterBadge, EditText editText, LinearLayout linearLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, View view, View view2, ConstraintLayout constraintLayout3, View view3, ImageView imageView2, ImageView imageView3, Group group, ImageView imageView4, TextView textView, ImageView imageView5, LinearLayout linearLayout2, TextView textView2) {
        this.a = constraintLayout;
        this.b = imageView;
        this.c = counterBadge;
        this.d = editText;
        this.e = linearLayout;
        this.f = constraintLayout2;
        this.g = recyclerView;
        this.h = view;
        this.i = view2;
        this.j = constraintLayout3;
        this.k = view3;
        this.l = imageView2;
        this.m = imageView3;
        this.n = group;
        this.o = imageView4;
        this.p = textView;
        this.q = imageView5;
        this.r = linearLayout2;
        this.s = textView2;
    }

    public static KC2 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i = AbstractC11556dC5.arrowImageView;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            i = AbstractC11556dC5.badgeCounter;
            CounterBadge counterBadge = (CounterBadge) AbstractC11738dW7.a(view, i);
            if (counterBadge != null) {
                i = AbstractC11556dC5.captionEditText;
                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                if (editText != null) {
                    i = AbstractC11556dC5.editTextLayout;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = AbstractC11556dC5.galleryRecyclerView;
                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                        if (recyclerView != null && (viewA = AbstractC11738dW7.a(view, (i = AbstractC11556dC5.handlerView))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = AbstractC11556dC5.inputBarDividerView))) != null) {
                            i = AbstractC11556dC5.inputBarLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                            if (constraintLayout2 != null && (viewA3 = AbstractC11738dW7.a(view, (i = AbstractC11556dC5.itemsDividerView))) != null) {
                                i = AbstractC11556dC5.keyboardModeImageView;
                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView2 != null) {
                                    i = AbstractC11556dC5.optionImageView;
                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView3 != null) {
                                        i = AbstractC11556dC5.placeHolderGroup;
                                        Group group = (Group) AbstractC11738dW7.a(view, i);
                                        if (group != null) {
                                            i = AbstractC11556dC5.placeHolderImageview;
                                            ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView4 != null) {
                                                i = AbstractC11556dC5.placeHolderTextView;
                                                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView != null) {
                                                    i = AbstractC11556dC5.sendImageView;
                                                    ImageView imageView5 = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView5 != null) {
                                                        i = AbstractC11556dC5.titleContainer;
                                                        LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = AbstractC11556dC5.titleTextView;
                                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView2 != null) {
                                                                return new KC2(constraintLayout, imageView, counterBadge, editText, linearLayout, constraintLayout, recyclerView, viewA, viewA2, constraintLayout2, viewA3, imageView2, imageView3, group, imageView4, textView, imageView5, linearLayout2, textView2);
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
