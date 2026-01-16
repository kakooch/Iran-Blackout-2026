package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ir.nasim.D20;

/* renamed from: ir.nasim.hh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14303hh5 {
    private final Context a;
    private final String b;
    private final UA2 c;
    private final LinearProgressIndicator d;
    private final TextView e;
    private final LinearLayout f;
    private final ImageView g;
    private final LinearLayout h;
    private int i;
    private boolean j;

    public C14303hh5(Context context, LinearLayout linearLayout, final int i, String str, boolean z, C23338wl0 c23338wl0, UA2 ua2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(linearLayout, "parent");
        AbstractC13042fc3.i(str, "answer");
        AbstractC13042fc3.i(c23338wl0, "bubbleMovementMethod");
        AbstractC13042fc3.i(ua2, "onVoteClicked");
        this.a = context;
        this.b = str;
        this.c = ua2;
        this.j = true;
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        double d = 8;
        layoutParams.setMargins(0, 0, 0, (int) ((AbstractC3742Cd6.c() * d) + 0.5d));
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setGravity(16);
        linearLayout2.setMinimumHeight((int) ((52 * AbstractC3742Cd6.c()) + 0.5d));
        linearLayout2.setContentDescription(linearLayout2.getContext().getString(AbstractC12217eE5.poll_unselected_option_label) + str);
        this.h = linearLayout2;
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(KB5.circle);
        double d2 = 24;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) ((AbstractC3742Cd6.c() * d2) + 0.5d), (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d));
        layoutParams2.setMarginEnd((int) ((16 * AbstractC3742Cd6.c()) + 0.5d));
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(imageView.getContext(), z ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light)));
        this.g = imageView;
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(1);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView textView = new TextView(context);
        textView.setText(AbstractC5730Kp.f(str, null, null, null));
        textView.setMovementMethod(c23338wl0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, 0, 0, (int) ((4 * AbstractC3742Cd6.c()) + 0.5d));
        textView.setMinWidth((int) ((SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER * AbstractC3742Cd6.c()) + 0.5d));
        textView.setLayoutParams(layoutParams3);
        AbstractC15575jo7.p(textView, AbstractC23035wE5.TextAppearance_Bale_BodyMedium_2_14_Regular);
        textView.setTypeface(C6011Lu2.k());
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(16);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setVisibility(8);
        this.f = linearLayout4;
        LinearProgressIndicator linearProgressIndicator = new LinearProgressIndicator(context);
        double d3 = 6;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((int) ((268 * AbstractC3742Cd6.c()) + 0.5d), (int) ((AbstractC3742Cd6.c() * d3) + 0.5d));
        layoutParams4.weight = 1.0f;
        layoutParams4.setMarginEnd((int) ((AbstractC3742Cd6.c() * d) + 0.5d));
        linearProgressIndicator.setLayoutParams(layoutParams4);
        linearProgressIndicator.setMax(100);
        linearProgressIndicator.setIndeterminate(false);
        linearProgressIndicator.setTrackColor(AbstractC4043Dl1.c(linearProgressIndicator.getContext(), TA5.bubble_out_third_light));
        linearProgressIndicator.setTrackCornerRadius((int) ((d3 * AbstractC3742Cd6.c()) + 0.5d));
        linearProgressIndicator.setIndicatorColor(AbstractC4043Dl1.c(linearProgressIndicator.getContext(), z ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light));
        this.d = linearProgressIndicator;
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AbstractC15575jo7.p(textView2, AbstractC23035wE5.TextAppearance_Bale_BodySmall_13_Regular);
        textView2.setTypeface(C6011Lu2.k());
        textView2.setTextColor(AbstractC4043Dl1.c(textView2.getContext(), z ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light));
        this.e = textView2;
        linearLayout4.addView(linearProgressIndicator);
        linearLayout4.addView(textView2);
        linearLayout3.addView(textView);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(imageView);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gh5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14303hh5.b(this.a, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(C14303hh5 c14303hh5, int i, View view) {
        AbstractC13042fc3.i(c14303hh5, "this$0");
        if (c14303hh5.j) {
            c14303hh5.c.invoke(Integer.valueOf(i));
        } else {
            c14303hh5.g(c14303hh5.i);
        }
    }

    private final void g(int i) {
        new D20.a(this.a).d1(10).X0(EnumC11622dK.c).W0(KB5.ic_tooltip_arrow).U0(AbstractC4043Dl1.c(this.a, TA5.n400_light)).k2(RecyclerView.UNDEFINED_DURATION).u1(RecyclerView.UNDEFINED_DURATION).b2(17).Q1(12).S1(12).U1(8).O1(8).e1(4).l1(14.0f).C1(true).e2(14.0f).Z1(AbstractC4043Dl1.c(this.a, TA5.surface_light)).g1(AbstractC4043Dl1.c(this.a, TA5.n400_light)).i1(F20.e).k1(I20.a, 0L).s1(false).f1(3000L).a1(0.5f).X1(AbstractC12152e76.c(String.valueOf(i)) + Separators.SP + this.a.getString(AbstractC12217eE5.poll_vote)).a().M0(this.d, 0, 0);
    }

    public final void c(int i, boolean z, int i2) {
        this.f.setVisibility(z ? 0 : 8);
        this.d.setMax(100);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.d, "progress", 0, i);
        objectAnimatorOfInt.setDuration(400L);
        objectAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        objectAnimatorOfInt.start();
        this.e.setText(XY6.v(i + Separators.PERCENT));
        this.i = i2;
    }

    public final String d() {
        return this.b;
    }

    public final void e(boolean z) {
        ImageView imageView = this.g;
        imageView.setImageResource(KB5.circle);
        imageView.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(imageView.getContext(), z ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light)));
    }

    public final void f(boolean z, boolean z2) {
        ColorStateList colorStateListValueOf;
        ImageView imageView = this.g;
        imageView.setImageResource(z ? z2 ? KB5.select_choice_in : KB5.select_choice : KB5.circle);
        if (z) {
            colorStateListValueOf = null;
        } else {
            colorStateListValueOf = ColorStateList.valueOf(AbstractC4043Dl1.c(imageView.getContext(), z2 ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light));
        }
        imageView.setImageTintList(colorStateListValueOf);
        this.h.setContentDescription(z ? this.a.getString(AbstractC12217eE5.poll_selected_option_label) : this.a.getString(AbstractC12217eE5.poll_unselected_option_label));
    }

    public final void h(boolean z, EnumC9058Yh5 enumC9058Yh5, boolean z2) {
        int i;
        AbstractC13042fc3.i(enumC9058Yh5, "pollType");
        boolean z3 = true;
        if (!z) {
            i = KB5.unselected_option;
        } else if (enumC9058Yh5 == EnumC9058Yh5.a) {
            z3 = false;
            i = z2 ? KB5.select_choice_in : KB5.select_choice;
        } else {
            i = KB5.selected_option;
        }
        if (z3) {
            this.g.setImageTintList(ColorStateList.valueOf(AbstractC4043Dl1.c(this.a, z2 ? TA5.bubble_in_secondary_light : TA5.bubble_out_secondary_light)));
        } else {
            this.g.setImageTintList(null);
        }
        this.g.setImageResource(i);
    }

    public final void i() {
        this.h.setOnClickListener(null);
        this.f.clearAnimation();
    }

    public final void j(boolean z, int i, boolean z2) {
        String str;
        LinearLayout linearLayout = this.h;
        if (z) {
            str = this.a.getString(AbstractC12217eE5.poll_selected_option_label) + Separators.SP + this.b + Separators.SP + i + Separators.SP + this.a.getString(AbstractC12217eE5.percentage_symbol);
        } else if (z2) {
            str = this.a.getString(AbstractC12217eE5.poll_others_selected_option_label) + Separators.SP + this.b + i + Separators.SP + this.a.getString(AbstractC12217eE5.percentage_symbol);
        } else {
            str = this.a.getString(AbstractC12217eE5.poll_unselected_option_label) + Separators.SP + this.b;
        }
        linearLayout.setContentDescription(str);
    }

    public final void k(boolean z) {
        this.j = z;
    }
}
