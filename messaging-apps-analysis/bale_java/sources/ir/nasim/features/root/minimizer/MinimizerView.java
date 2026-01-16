package ir.nasim.features.root.minimizer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.BC5;
import ir.nasim.ED1;
import ir.nasim.O98;
import ir.nasim.UA2;
import ir.nasim.features.root.minimizer.MinimizerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010,\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lir/nasim/features/root/minimizer/MinimizerView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Lkotlin/Function1;", "Landroid/view/View;", "Lir/nasim/rB7;", "onCloseClickListener", "setOnCloseClickListener", "(Lir/nasim/UA2;)V", "onRetrieveClickListener", "setOnRetrieveClickListener", "", "name", "setWebAppName", "(Ljava/lang/String;)V", "webAppName", "f", "", "toUp", "c", "(Z)V", "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "webAppNameTextView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "closeImageView", "retrieveImageView", "d", "Z", "isVisibleBeforeKeyboardShowingUp", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class MinimizerView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final TextView webAppNameTextView;

    /* renamed from: b, reason: from kotlin metadata */
    private final ImageView closeImageView;

    /* renamed from: c, reason: from kotlin metadata */
    private final ImageView retrieveImageView;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isVisibleBeforeKeyboardShowingUp;

    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MinimizerView.this.setVisibility(8);
            MinimizerView.this.setTranslationY(0.0f);
            MinimizerView.this.setAlpha(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinimizerView(Context context) {
        this(context, null, 0, 0, 14, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(UA2 ua2, View view) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(view);
    }

    public final void c(boolean toUp) {
        this.isVisibleBeforeKeyboardShowingUp = false;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "translationY", (getHeight() / 2) * (toUp ? -1 : 1));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    public final void f(String webAppName) {
        AbstractC13042fc3.i(webAppName, "webAppName");
        this.isVisibleBeforeKeyboardShowingUp = true;
        setWebAppName(webAppName);
        setAlpha(0.0f);
        setVisibility(0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(50L);
        objectAnimatorOfFloat.start();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        if (insets != null) {
            O98 o98A = O98.A(insets, this);
            AbstractC13042fc3.h(o98A, "toWindowInsetsCompat(...)");
            int i = o98A.f(O98.m.i()).d;
            int i2 = o98A.f(O98.m.d()).d;
            int i3 = o98A.f(O98.m.i()).a;
            int i4 = o98A.f(O98.m.i()).c;
            boolean z = i2 > 0;
            if (z && getVisibility() == 0) {
                setVisibility(8);
            } else if (!z && this.isVisibleBeforeKeyboardShowingUp) {
                setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = -i;
            marginLayoutParams.bottomMargin = i;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i4;
            setLayoutParams(marginLayoutParams);
        }
        return super.onApplyWindowInsets(insets);
    }

    public final void setOnCloseClickListener(final UA2 onCloseClickListener) {
        AbstractC13042fc3.i(onCloseClickListener, "onCloseClickListener");
        this.closeImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gf4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MinimizerView.d(onCloseClickListener, view);
            }
        });
    }

    public final void setOnRetrieveClickListener(final UA2 onRetrieveClickListener) {
        AbstractC13042fc3.i(onRetrieveClickListener, "onRetrieveClickListener");
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ff4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MinimizerView.e(onRetrieveClickListener, view);
            }
        });
    }

    public final void setWebAppName(String name) {
        this.webAppNameTextView.setText(name);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinimizerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MinimizerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MinimizerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MinimizerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        AbstractC13042fc3.i(context, "context");
        LayoutInflater.from(context).inflate(AbstractC12208eD5.nasim_custom_minimizer_view, (ViewGroup) this, true);
        this.webAppNameTextView = (TextView) findViewById(BC5.web_app_name_text_view);
        this.closeImageView = (ImageView) findViewById(BC5.close_image_view);
        this.retrieveImageView = (ImageView) findViewById(BC5.retrieve_image_view);
    }
}
