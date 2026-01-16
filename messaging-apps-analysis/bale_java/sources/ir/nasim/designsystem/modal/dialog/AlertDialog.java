package ir.nasim.designsystem.modal.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C19406qI3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.JF5;
import ir.nasim.KB5;
import java.util.ArrayList;
import kotlin.Metadata;

/* loaded from: classes5.dex */
public final class AlertDialog extends Dialog implements Drawable.Callback {
    public static final b G = new b(null);
    public static final int H = 8;
    private FrameLayout A;
    private Drawable B;
    private final Rect D;
    private View a;
    private TextView b;
    private TextView c;
    private FrameLayout d;
    private ScrollView e;
    private LinearLayout f;
    private ViewTreeObserver.OnScrollChangedListener g;
    private BitmapDrawable[] h;
    private final boolean[] i;
    private final AnimatorSet[] j;
    private int k;
    private DialogInterface.OnClickListener l;
    private CharSequence[] m;
    private int[] n;
    private ArrayList o;
    private CharSequence p;
    private CharSequence q;
    private final int r;
    private boolean s;
    private boolean t;
    private CharSequence u;
    private DialogInterface.OnClickListener v;
    private CharSequence w;
    private DialogInterface.OnClickListener x;
    private CharSequence y;
    private DialogInterface.OnClickListener z;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lir/nasim/designsystem/modal/dialog/AlertDialog$AlertDialogCell;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "widthMeasureSpec", "heightMeasureSpec", "Lir/nasim/rB7;", "onMeasure", "(II)V", "", ParameterNames.TEXT, ParameterNames.ICON, "setTextAndIcon", "(Ljava/lang/CharSequence;I)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "imageView", "nasim_release"}, k = 1, mv = {2, 0, 0})
    public static final class AlertDialogCell extends FrameLayout {

        /* renamed from: a, reason: from kotlin metadata */
        private final TextView textView;

        /* renamed from: b, reason: from kotlin metadata */
        private final ImageView imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlertDialogCell(Context context) {
            super(context);
            AbstractC13042fc3.i(context, "context");
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            setPadding(aVar.f(23.0f), 0, aVar.f(23.0f), 0);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            imageView.setColorFilter(c5495Jo7.g0(), PorterDuff.Mode.SRC_IN);
            addView(imageView, C14433hu3.c(24, 24, (JF5.g() ? 5 : 3) | 16));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            textView.setSingleLine(true);
            textView.setGravity(17);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(c5495Jo7.g0());
            textView.setTextSize(1, 14.0f);
            textView.setTypeface(C6011Lu2.k());
            addView(textView, C14433hu3.c(-2, -2, (JF5.g() ? 5 : 3) | 16));
        }

        public final ImageView getImageView() {
            return this.imageView;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AbstractC7426Rr.a.f(48.0f), 1073741824));
        }

        public final void setTextAndIcon(CharSequence text, int icon) {
            AbstractC13042fc3.i(text, ParameterNames.TEXT);
            this.textView.setText(text);
            if (icon == 0) {
                this.imageView.setVisibility(4);
                this.textView.setPadding(0, 0, 0, 0);
            } else {
                this.imageView.setImageResource(icon);
                this.imageView.setVisibility(0);
                this.textView.setPadding(JF5.g() ? 0 : AbstractC7426Rr.a.f(36.0f), 0, JF5.g() ? AbstractC7426Rr.a.f(36.0f) : 0, 0);
            }
        }
    }

    public static final class a {
        private final AlertDialog a;

        public a(Context context) {
            AbstractC13042fc3.i(context, "context");
            this.a = new AlertDialog(context, 0);
        }

        public final AlertDialog a() {
            return this.a;
        }

        public final a b(boolean z) {
            this.a.s = z;
            return this;
        }

        public final a c(boolean z) {
            this.a.t = z;
            return this;
        }

        public final a d(boolean z, boolean z2) {
            this.a.setCancelable(z);
            this.a.setCanceledOnTouchOutside(z2);
            return this;
        }

        public final a e(ArrayList arrayList) {
            this.a.o = arrayList;
            return this;
        }

        public final a f(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            this.a.m = charSequenceArr;
            this.a.l = onClickListener;
            return this;
        }

        public final a g(CharSequence[] charSequenceArr, int[] iArr, DialogInterface.OnClickListener onClickListener) {
            this.a.m = charSequenceArr;
            this.a.n = iArr;
            this.a.l = onClickListener;
            return this;
        }

        public final a h(String[] strArr, DialogInterface.OnClickListener onClickListener) {
            AbstractC13042fc3.i(strArr, "items");
            this.a.m = strArr;
            this.a.l = onClickListener;
            return this;
        }

        public final a i(CharSequence charSequence) {
            this.a.q = charSequence;
            return this;
        }

        public final a j(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.w = charSequence;
            this.a.x = onClickListener;
            return this;
        }

        public final a k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.y = charSequence;
            this.a.z = onClickListener;
            return this;
        }

        public final a l(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            this.a.u = charSequence;
            this.a.v = onClickListener;
            return this;
        }

        public final a m(CharSequence charSequence) {
            this.a.p = charSequence;
            return this;
        }

        public final a n(View view) {
            this.a.a = view;
            return this;
        }

        public final AlertDialog o() {
            this.a.show();
            return this.a;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        final /* synthetic */ int b;

        c(int i) {
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            if (AlertDialog.this.j[this.b] == null || !AbstractC13042fc3.d(AlertDialog.this.j[this.b], animator)) {
                return;
            }
            AlertDialog.this.j[this.b] = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC13042fc3.i(animator, "animation");
            if (AlertDialog.this.j[this.b] == null || !AbstractC13042fc3.d(AlertDialog.this.j[this.b], animator)) {
                return;
            }
            AlertDialog.this.j[this.b] = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlertDialog(Context context, int i) {
        super(context, AbstractC23035wE5.TransparentDialog);
        AbstractC13042fc3.i(context, "context");
        Drawable drawable = null;
        this.h = new BitmapDrawable[]{null, null};
        this.i = new boolean[2];
        this.j = new AnimatorSet[2];
        Rect rect = new Rect();
        this.D = rect;
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.popup_fixed_alert);
        if (drawableF != null) {
            Drawable drawableMutate = drawableF.mutate();
            this.B = drawableMutate;
            if (drawableMutate == null) {
                AbstractC13042fc3.y("shadowDrawable");
                drawableMutate = null;
            }
            drawableMutate.setColorFilter(C5495Jo7.a.p(), PorterDuff.Mode.MULTIPLY);
            Drawable drawable2 = this.B;
            if (drawable2 == null) {
                AbstractC13042fc3.y("shadowDrawable");
            } else {
                drawable = drawable2;
            }
            drawable.getPadding(rect);
        }
        this.r = i;
    }

    private final boolean K(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (K(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        DialogInterface.OnClickListener onClickListener = alertDialog.l;
        if (onClickListener != null) {
            Object tag = view.getTag();
            AbstractC13042fc3.g(tag, "null cannot be cast to non-null type kotlin.Int");
            onClickListener.onClick(alertDialog, ((Integer) tag).intValue());
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        DialogInterface.OnClickListener onClickListener = alertDialog.v;
        if (onClickListener != null) {
            onClickListener.onClick(alertDialog, -1);
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        DialogInterface.OnClickListener onClickListener = alertDialog.x;
        if (onClickListener != null) {
            onClickListener.onClick(alertDialog, -2);
        }
        alertDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AlertDialog alertDialog, View view) {
        AbstractC13042fc3.i(alertDialog, "this$0");
        DialogInterface.OnClickListener onClickListener = alertDialog.z;
        if (onClickListener != null) {
            onClickListener.onClick(alertDialog, -2);
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int i, boolean z) {
        if ((!z || this.i[i]) && (z || !this.i[i])) {
            return;
        }
        this.i[i] = z;
        AnimatorSet animatorSet = this.j[i];
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.j[i] = new AnimatorSet();
        AnimatorSet animatorSet2 = this.j[i];
        if (animatorSet2 != null) {
            animatorSet2.playTogether(ObjectAnimator.ofInt(this.h[i], "alpha", z ? 255 : 0));
        }
        AnimatorSet animatorSet3 = this.j[i];
        if (animatorSet3 != null) {
            animatorSet3.setDuration(150L);
        }
        AnimatorSet animatorSet4 = this.j[i];
        if (animatorSet4 != null) {
            animatorSet4.addListener(new c(i));
        }
        try {
            AnimatorSet animatorSet5 = this.j[i];
            if (animatorSet5 != null) {
                animatorSet5.start();
            }
        } catch (Exception e) {
            C19406qI3.d("AlertDialog", e);
        }
    }

    public final boolean L() {
        return this.s;
    }

    public final void R(int i, int i2) {
        FrameLayout frameLayout = this.A;
        TextView textView = frameLayout != null ? (TextView) frameLayout.findViewWithTag(Integer.valueOf(i2)) : null;
        TextView textView2 = textView instanceof TextView ? textView : null;
        if (textView2 != null) {
            textView2.setTextColor(i);
        }
    }

    public final void S(CharSequence charSequence) {
        this.q = charSequence;
        if (this.c == null) {
            return;
        }
        TextView textView = null;
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView2 = this.c;
            if (textView2 == null) {
                AbstractC13042fc3.y("messageTextView");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView3 = this.c;
        if (textView3 == null) {
            AbstractC13042fc3.y("messageTextView");
            textView3 = null;
        }
        textView3.setText(this.q);
        TextView textView4 = this.c;
        if (textView4 == null) {
            AbstractC13042fc3.y("messageTextView");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        AbstractC13042fc3.i(drawable, "who");
        if (this.f == null) {
            return;
        }
        ScrollView scrollView = this.e;
        if (scrollView != null) {
            scrollView.invalidate();
        }
        LinearLayout linearLayout = this.f;
        if (linearLayout == null) {
            AbstractC13042fc3.y("scrollContainer");
            linearLayout = null;
        }
        linearLayout.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:262:0x0609  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r25) {
        /*
            Method dump skipped, instructions count: 1560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.designsystem.modal.dialog.AlertDialog.onCreate(android.os.Bundle):void");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        AbstractC13042fc3.i(drawable, "who");
        AbstractC13042fc3.i(runnable, "what");
        ScrollView scrollView = this.e;
        if (scrollView != null) {
            scrollView.postDelayed(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        AbstractC13042fc3.i(drawable, "who");
        AbstractC13042fc3.i(runnable, "what");
        ScrollView scrollView = this.e;
        if (scrollView != null) {
            scrollView.removeCallbacks(runnable);
        }
    }
}
