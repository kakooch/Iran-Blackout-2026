package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C17192mZ0;
import ir.nasim.C19938rB7;
import ir.nasim.C20610sI7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.FU;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.JF5;
import ir.nasim.KB5;
import ir.nasim.OY0;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010!\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001d\u0010$\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010\u001aR\u001b\u0010)\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/CommentContainerView;", "Lir/nasim/features/conversation/messages/content/adapter/view/BubbleTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/text/Spannable;", "spannable", "", "isLoadingState", "hasNewComment", "Lir/nasim/rB7;", TokenNames.C, "(Landroid/text/Spannable;ZZ)V", "Lir/nasim/FU;", "h", "Lir/nasim/FU;", "avatarDownloader", "Landroid/graphics/drawable/Drawable;", "i", "Lir/nasim/Yu3;", "getAnimationDrawable", "()Landroid/graphics/drawable/Drawable;", "animationDrawable", "j", "getDividerDrawable", "dividerDrawable", "k", "getBadgeDrawable", "badgeDrawable", "l", "getArrowDrawable", "arrowDrawable", "Landroid/animation/ObjectAnimator;", "m", "getAnim", "()Landroid/animation/ObjectAnimator;", "anim", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class CommentContainerView extends BubbleTextView {

    /* renamed from: h, reason: from kotlin metadata */
    private final FU avatarDownloader;

    /* renamed from: i, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 animationDrawable;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 dividerDrawable;

    /* renamed from: k, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 badgeDrawable;

    /* renamed from: l, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 arrowDrawable;

    /* renamed from: m, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 anim;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommentContainerView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable A(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Drawable drawable = context.getDrawable(JF5.g() ? KB5.ic_story_settings_arrow : KB5.arrow_left_old);
        if (drawable == null) {
            return null;
        }
        drawable.setBounds(0, 0, AbstractC8943Xx1.c(24), AbstractC8943Xx1.c(24));
        drawable.setTint(OY0.b(context, AbstractC21139tA5.bubble_low_text));
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable B(Context context, CommentContainerView commentContainerView) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(commentContainerView, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.circle_bg);
        if (drawableF == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = commentContainerView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        int paddingTop = (marginLayoutParams != null ? marginLayoutParams.topMargin : 0) + commentContainerView.getPaddingTop() + AbstractC8943Xx1.c(8);
        int iC = AbstractC8943Xx1.c(30);
        drawableF.setBounds(iC, paddingTop, AbstractC8943Xx1.c(8) + iC, AbstractC8943Xx1.c(8) + paddingTop);
        drawableF.setTint(OY0.b(context, AbstractC21139tA5.colorError));
        return drawableF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(C17192mZ0 c17192mZ0, int i, CommentContainerView commentContainerView, Drawable drawable) {
        AbstractC13042fc3.i(c17192mZ0, "$avatarSpan");
        AbstractC13042fc3.i(commentContainerView, "this$0");
        AbstractC13042fc3.i(drawable, "resource");
        c17192mZ0.e().set(i, drawable);
        commentContainerView.invalidate();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable E(Context context, CommentContainerView commentContainerView) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(commentContainerView, "this$0");
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.list_divider);
        if (drawableF == null) {
            return null;
        }
        drawableF.setBounds(0, AbstractC8943Xx1.c(4), commentContainerView.getMaxWidth(), AbstractC8943Xx1.c(5));
        drawableF.setTint(OY0.b(context, AbstractC21139tA5.bubble_third));
        return drawableF;
    }

    private final Drawable getAnimationDrawable() {
        return (Drawable) this.animationDrawable.getValue();
    }

    private final Drawable getArrowDrawable() {
        return (Drawable) this.arrowDrawable.getValue();
    }

    private final Drawable getBadgeDrawable() {
        return (Drawable) this.badgeDrawable.getValue();
    }

    private final Drawable getDividerDrawable() {
        return (Drawable) this.dividerDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObjectAnimator y(CommentContainerView commentContainerView) {
        AbstractC13042fc3.i(commentContainerView, "this$0");
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(commentContainerView.getAnimationDrawable(), "level", AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND);
        if (objectAnimatorOfInt != null) {
            objectAnimatorOfInt.setDuration(700L);
        }
        if (objectAnimatorOfInt != null) {
            objectAnimatorOfInt.setRepeatCount(-1);
        }
        if (objectAnimatorOfInt != null) {
            objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        }
        return objectAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable z(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Drawable drawable = context.getDrawable(KB5.nasim_circle_loading_dr);
        if (drawable != null) {
            drawable.setBounds(0, 0, AbstractC8943Xx1.c(22), AbstractC8943Xx1.c(22));
        }
        return drawable;
    }

    public final void C(Spannable spannable, boolean isLoadingState, boolean hasNewComment) {
        if (!AbstractC20153rZ6.y(getText(), spannable)) {
            super.r(spannable);
        }
        if (spannable == null) {
            return;
        }
        if (isLoadingState) {
            setCompoundDrawablesRelative(null, null, getAnimationDrawable(), null);
            getAnim().start();
        } else {
            getAnim().pause();
            getAnim().cancel();
            setCompoundDrawables(null, null, null, null);
            Drawable arrowDrawable = getArrowDrawable();
            if (arrowDrawable != null) {
                setCompoundDrawablesRelative(null, null, arrowDrawable, null);
            }
        }
        if (hasNewComment) {
            Drawable badgeDrawable = getBadgeDrawable();
            if (badgeDrawable != null) {
                getOverlay().add(badgeDrawable);
            }
        } else {
            getOverlay().clear();
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable != null) {
            getOverlay().add(dividerDrawable);
        }
        for (Object obj : spannable.getSpans(0, spannable.length(), C17192mZ0.class)) {
            final C17192mZ0 c17192mZ0 = (C17192mZ0) obj;
            final int i = 0;
            for (Object obj2 : c17192mZ0.d()) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                FU.g(this.avatarDownloader, (C20610sI7) obj2, c17192mZ0.c(), null, new UA2() { // from class: ir.nasim.sZ0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj3) {
                        return CommentContainerView.D(c17192mZ0, i, this, (Drawable) obj3);
                    }
                }, 4, null);
                i = i2;
            }
        }
    }

    public final ObjectAnimator getAnim() {
        Object value = this.anim.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (ObjectAnimator) value;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ CommentContainerView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentContainerView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.avatarDownloader = new FU(context);
        this.animationDrawable = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CommentContainerView.z(context);
            }
        });
        this.dividerDrawable = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.oZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CommentContainerView.E(context, this);
            }
        });
        this.badgeDrawable = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.pZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CommentContainerView.B(context, this);
            }
        });
        this.arrowDrawable = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CommentContainerView.A(context);
            }
        });
        this.anim = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return CommentContainerView.y(this.a);
            }
        });
        if (isInEditMode()) {
            return;
        }
        setTypeface(C6011Lu2.k());
        setLineHeight(AbstractC8943Xx1.c(24));
    }
}
