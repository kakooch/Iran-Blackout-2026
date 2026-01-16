package ir.nasim.features.smiles.widget;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.components.image.view.BouncerImageView;
import ir.nasim.features.smiles.widget.ImageViewEmoji;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u001dR0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010(R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010(R\u001d\u0010/\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001a¨\u00062"}, d2 = {"Lir/nasim/features/smiles/widget/ImageViewEmoji;", "Lir/nasim/components/image/view/BouncerImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Canvas;", "canvas", "Landroid/graphics/drawable/Drawable;", "k", "(Landroid/graphics/Canvas;)Landroid/graphics/drawable/Drawable;", "Lir/nasim/rB7;", "onDraw", "(Landroid/graphics/Canvas;)V", "", "l", "()Z", "drawable", "recent", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;Z)V", "i", "Z", "getShowBadge", "setShowBadge", "(Z)V", "showBadge", "Lkotlin/Function1;", "", "j", "Lir/nasim/UA2;", "getListener", "()Lir/nasim/UA2;", "setListener", "(Lir/nasim/UA2;)V", "listener", TokenNames.I, "badgePadding", "badgeWidth", "m", "Lir/nasim/Yu3;", "getBadgeDrawable", "()Landroid/graphics/drawable/Drawable;", "badgeDrawable", "n", "isRecent", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class ImageViewEmoji extends BouncerImageView {

    /* renamed from: i, reason: from kotlin metadata */
    private boolean showBadge;

    /* renamed from: j, reason: from kotlin metadata */
    private UA2 listener;

    /* renamed from: k, reason: from kotlin metadata */
    private final int badgePadding;

    /* renamed from: l, reason: from kotlin metadata */
    private final int badgeWidth;

    /* renamed from: m, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 badgeDrawable;

    /* renamed from: n, reason: from kotlin metadata */
    private boolean isRecent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewEmoji(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final Drawable getBadgeDrawable() {
        return (Drawable) this.badgeDrawable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable j(Context context) {
        AbstractC13042fc3.i(context, "$context");
        Drawable drawableF = AbstractC4043Dl1.f(context, KB5.emoji_color_badge);
        if (drawableF == null) {
            return null;
        }
        drawableF.setColorFilter(new PorterDuffColorFilter(AbstractC4043Dl1.c(context, TA5.c7), PorterDuff.Mode.SRC_IN));
        return drawableF;
    }

    private final Drawable k(Canvas canvas) {
        Drawable badgeDrawable = getBadgeDrawable();
        if (badgeDrawable == null) {
            return null;
        }
        badgeDrawable.setBounds((canvas.getWidth() - this.badgeWidth) - this.badgePadding, (canvas.getHeight() - this.badgeWidth) - this.badgePadding, canvas.getWidth() - this.badgePadding, canvas.getHeight() - this.badgePadding);
        badgeDrawable.draw(canvas);
        return badgeDrawable;
    }

    public final UA2 getListener() {
        return this.listener;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsRecent() {
        return this.isRecent;
    }

    @Override // ir.nasim.components.image.view.BouncerImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        if (this.showBadge) {
            k(canvas);
        }
    }

    public final void setImageDrawable(Drawable drawable, boolean recent) {
        super.setImageDrawable(drawable);
        this.isRecent = recent;
    }

    public final void setListener(UA2 ua2) {
        this.listener = ua2;
    }

    public final void setShowBadge(boolean z) {
        this.showBadge = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageViewEmoji(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ImageViewEmoji(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageViewEmoji(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.badgeWidth = (int) ((6 * AbstractC3742Cd6.c()) + 0.5d);
        this.badgeDrawable = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.k33
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ImageViewEmoji.j(context);
            }
        });
        setBackground(AbstractC4310Eo7.h(4.0f));
    }
}
