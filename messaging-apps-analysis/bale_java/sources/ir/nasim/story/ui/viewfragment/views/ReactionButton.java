package ir.nasim.story.ui.viewfragment.views;

import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23008wB5;
import ir.nasim.ED1;
import ir.nasim.R62;
import ir.nasim.components.image.view.BouncerImageView;
import ir.nasim.story.ui.viewfragment.views.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/ReactionButton;", "Lir/nasim/components/image/view/BouncerImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/story/ui/viewfragment/views/a;", "value", "i", "Lir/nasim/story/ui/viewfragment/views/a;", "getState", "()Lir/nasim/story/ui/viewfragment/views/a;", "setState", "(Lir/nasim/story/ui/viewfragment/views/a;)V", "state", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class ReactionButton extends BouncerImageView {

    /* renamed from: i, reason: from kotlin metadata */
    private a state;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactionButton(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final a getState() {
        return this.state;
    }

    public final void setState(a aVar) {
        AbstractC13042fc3.i(aVar, "value");
        if (AbstractC13042fc3.d(aVar, this.state)) {
            return;
        }
        if (aVar instanceof a.C1549a) {
            setImageResource(AbstractC23008wB5.drawable_like_story);
        } else if (aVar instanceof a.b) {
            setImageDrawable(R62.A(((a.b) aVar).b()));
        } else {
            if (!(aVar instanceof a.c)) {
                throw new NoWhenBranchMatchedException();
            }
            setImageResource(AbstractC23008wB5.drawable_like_story_empty);
        }
        if (aVar.a()) {
            h();
        }
        this.state = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ReactionButton(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        setImageResource(AbstractC23008wB5.drawable_like_story_empty);
        this.state = new a.c(false);
    }
}
