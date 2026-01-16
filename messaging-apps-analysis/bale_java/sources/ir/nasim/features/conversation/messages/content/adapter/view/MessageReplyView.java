package ir.nasim.features.conversation.messages.content.adapter.view;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21139tA5;
import ir.nasim.C18714p74;
import ir.nasim.C19938rB7;
import ir.nasim.C3335Al0;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.H02;
import ir.nasim.LH0;
import ir.nasim.OI2;
import ir.nasim.OY0;
import ir.nasim.PO5;
import ir.nasim.PX7;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/MessageReplyView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/PO5;", "reply", "", "e0", "(Lir/nasim/PO5;)Ljava/lang/Object;", "color", "Lir/nasim/rB7;", "setColor", "(I)V", "setTextSizes", "()V", "d0", "(Lir/nasim/PO5;)V", "f0", "Lir/nasim/p74;", "y", "Lir/nasim/p74;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MessageReplyView extends ConstraintLayout {

    /* renamed from: y, reason: from kotlin metadata */
    private C18714p74 binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageReplyView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final Object e0(PO5 reply) {
        C18714p74 c18714p74 = this.binding;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        if (reply instanceof PO5.a) {
            ImageView imageView = c18714p74.c;
            AbstractC13042fc3.h(imageView, "fileImageView");
            imageView.setVisibility(0);
            ShapeableImageView shapeableImageView = c18714p74.e;
            AbstractC13042fc3.h(shapeableImageView, "mediaImageView");
            shapeableImageView.setVisibility(8);
            return C19938rB7.a;
        }
        if (reply instanceof PO5.b) {
            ImageView imageView2 = c18714p74.c;
            AbstractC13042fc3.h(imageView2, "fileImageView");
            imageView2.setVisibility(8);
            ShapeableImageView shapeableImageView2 = c18714p74.e;
            AbstractC13042fc3.h(shapeableImageView2, "mediaImageView");
            shapeableImageView2.setVisibility(0);
            PX7 px7Q0 = OI2.b(C5721Ko.a.d()).z(((PO5.b) reply).d()).u0(new LH0()).Q0(c18714p74.e);
            AbstractC13042fc3.f(px7Q0);
            return px7Q0;
        }
        if (!(reply instanceof PO5.c)) {
            ImageView imageView3 = c18714p74.c;
            AbstractC13042fc3.h(imageView3, "fileImageView");
            imageView3.setVisibility(8);
            ShapeableImageView shapeableImageView3 = c18714p74.e;
            AbstractC13042fc3.h(shapeableImageView3, "mediaImageView");
            shapeableImageView3.setVisibility(8);
            return C19938rB7.a;
        }
        ImageView imageView4 = c18714p74.c;
        AbstractC13042fc3.h(imageView4, "fileImageView");
        imageView4.setVisibility(8);
        ShapeableImageView shapeableImageView4 = c18714p74.e;
        AbstractC13042fc3.h(shapeableImageView4, "mediaImageView");
        shapeableImageView4.setVisibility(0);
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ColorDrawable colorDrawable = new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third));
        PX7 px7Q02 = OI2.b(C5721Ko.a.d()).y(((PO5.c) reply).d()).f0(colorDrawable).l(colorDrawable).u0(new LH0()).i1(H02.k()).Q0(c18714p74.e);
        AbstractC13042fc3.f(px7Q02);
        return px7Q02;
    }

    private final void setColor(int color) {
        C18714p74 c18714p74 = this.binding;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        Drawable background = c18714p74.d.getBackground();
        if (background != null) {
            background.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        }
        Drawable background2 = c18714p74.c.getBackground();
        if (background2 != null) {
            background2.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        }
    }

    public final void d0(PO5 reply) {
        C18714p74 c18714p74 = this.binding;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        if (reply == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        c18714p74.g.r(reply.c());
        c18714p74.g.setContentDescription(getContext().getString(AbstractC12217eE5.reply_content_description) + Separators.SP + ((Object) reply.c()));
        c18714p74.f.r(reply.a());
        Integer numB = reply.b();
        if (numB != null) {
            setColor(numB.intValue());
        }
        e0(reply);
    }

    public final void f0() {
        C18714p74 c18714p74 = this.binding;
        C18714p74 c18714p742 = null;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        c18714p74.g.invalidate();
        C18714p74 c18714p743 = this.binding;
        if (c18714p743 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c18714p742 = c18714p743;
        }
        c18714p742.f.invalidate();
    }

    public final void setTextSizes() {
        C18714p74 c18714p74 = this.binding;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        MessageEmojiTextView messageEmojiTextView = c18714p74.f;
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.r());
        c18714p74.g.setTextSize(c3335Al0.s());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageReplyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MessageReplyView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageReplyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        View viewInflate = View.inflate(context, AbstractC12208eD5.message_reply_view, this);
        if (isInEditMode()) {
            return;
        }
        this.binding = C18714p74.a(viewInflate);
        setTextSizes();
        C18714p74 c18714p74 = this.binding;
        if (c18714p74 == null) {
            AbstractC13042fc3.y("binding");
            c18714p74 = null;
        }
        c18714p74.f.setTypeface(C6011Lu2.k());
    }
}
