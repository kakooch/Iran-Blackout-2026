package ir.nasim.designsystem.avatar;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import ir.nasim.ED1;
import ir.nasim.KB5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lir/nasim/designsystem/avatar/AvatarViewWithOnline;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", ParameterNames.TEXT, "Lir/nasim/rB7;", "a", "(F)V", "Lir/nasim/designsystem/avatar/AvatarViewGlide;", "Lir/nasim/designsystem/avatar/AvatarViewGlide;", "getAvatarView", "()Lir/nasim/designsystem/avatar/AvatarViewGlide;", "setAvatarView", "(Lir/nasim/designsystem/avatar/AvatarViewGlide;)V", "avatarView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getOnline", "()Landroid/widget/ImageView;", "setOnline", "(Landroid/widget/ImageView;)V", "online", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class AvatarViewWithOnline extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    public AvatarViewGlide avatarView;

    /* renamed from: b, reason: from kotlin metadata */
    public ImageView online;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarViewWithOnline(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final void a(float text) {
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        setAvatarView(new AvatarViewGlide(context));
        getAvatarView().B(text, true);
        addView(getAvatarView());
        setOnline(new ImageView(getContext()));
        getOnline().setImageResource(KB5.indicator_offline);
        getOnline().setVisibility(4);
        addView(getOnline(), new FrameLayout.LayoutParams(C22078ud6.a(11.0f), C22078ud6.a(11.0f), 85));
    }

    public final AvatarViewGlide getAvatarView() {
        AvatarViewGlide avatarViewGlide = this.avatarView;
        if (avatarViewGlide != null) {
            return avatarViewGlide;
        }
        AbstractC13042fc3.y("avatarView");
        return null;
    }

    public final ImageView getOnline() {
        ImageView imageView = this.online;
        if (imageView != null) {
            return imageView;
        }
        AbstractC13042fc3.y("online");
        return null;
    }

    public final void setAvatarView(AvatarViewGlide avatarViewGlide) {
        AbstractC13042fc3.i(avatarViewGlide, "<set-?>");
        this.avatarView = avatarViewGlide;
    }

    public final void setOnline(ImageView imageView) {
        AbstractC13042fc3.i(imageView, "<set-?>");
        this.online = imageView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarViewWithOnline(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ AvatarViewWithOnline(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewWithOnline(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
