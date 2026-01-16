package ir.nasim.story.ui.viewfragment.views.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC19242q11;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC7693Su5;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.GA5;
import ir.nasim.InterfaceC12925fP5;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC3313Ai5;
import ir.nasim.InterfaceC5024Ho4;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.M10;
import ir.nasim.SA2;
import ir.nasim.SD5;
import ir.nasim.UY6;
import ir.nasim.story.ui.viewfragment.views.MyStoryStatusView;
import ir.nasim.story.ui.viewfragment.views.PopularStoryBarView;
import ir.nasim.story.ui.viewfragment.views.ReplyStoryView;
import ir.nasim.story.ui.viewfragment.views.footer.FooterStoryView;
import ir.nasim.story.ui.viewfragment.views.footer.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010(\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010,\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0016R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010*\u001a\u0004\b3\u0010\u0019R\u001b\u00106\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b5\u0010\u001cR$\u0010;\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lir/nasim/story/ui/viewfragment/views/footer/FooterStoryView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/story/ui/viewfragment/views/footer/a;", "oldState", "newState", "Lir/nasim/rB7;", "g", "(Lir/nasim/story/ui/viewfragment/views/footer/a;Lir/nasim/story/ui/viewfragment/views/footer/a;)V", "Landroid/view/View;", "view", "f", "(Landroid/view/View;)V", "Lir/nasim/story/ui/viewfragment/views/MyStoryStatusView;", "getMyStoryStatusView", "()Lir/nasim/story/ui/viewfragment/views/MyStoryStatusView;", "Lir/nasim/story/ui/viewfragment/views/PopularStoryBarView;", "getPopularStoryBarView", "()Lir/nasim/story/ui/viewfragment/views/PopularStoryBarView;", "Lir/nasim/story/ui/viewfragment/views/ReplyStoryView;", "getReplyStoryView", "()Lir/nasim/story/ui/viewfragment/views/ReplyStoryView;", "Lir/nasim/Ym4;", "a", "Lir/nasim/Ym4;", "_progress", "value", "b", "Lir/nasim/story/ui/viewfragment/views/footer/a;", "getState", "()Lir/nasim/story/ui/viewfragment/views/footer/a;", "setState", "(Lir/nasim/story/ui/viewfragment/views/footer/a;)V", "state", "c", "Lir/nasim/Yu3;", "getViewMyStoryStatus", "viewMyStoryStatus", "Landroidx/compose/ui/platform/ComposeView;", "d", "getViewUploadingStory", "()Landroidx/compose/ui/platform/ComposeView;", "viewUploadingStory", "e", "getViewPopularStoryBar", "viewPopularStoryBar", "getViewReplyStory", "viewReplyStory", "getProgress", "()I", "setProgress", "(I)V", "progress", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class FooterStoryView extends FrameLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final InterfaceC9102Ym4 _progress;

    /* renamed from: b, reason: from kotlin metadata */
    private ir.nasim.story.ui.viewfragment.views.footer.a state;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewMyStoryStatus;

    /* renamed from: d, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewUploadingStory;

    /* renamed from: e, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewPopularStoryBar;

    /* renamed from: f, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewReplyStory;

    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.story.ui.viewfragment.views.footer.FooterStoryView$a$a, reason: collision with other inner class name */
        static final class C1550a implements InterfaceC14603iB2 {
            final /* synthetic */ FooterStoryView a;

            C1550a(FooterStoryView footerStoryView) {
                this.a = footerStoryView;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC7693Su5.e(null, true, ((Number) this.a._progress.getValue()).intValue(), true, UY6.c(SD5.sending_story, interfaceC22053ub1, 0), interfaceC22053ub1, 3120, 1);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-1144702395, true, new C1550a(FooterStoryView.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterStoryView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void f(View view) {
        if (view.getParent() == null) {
            addView(view);
        } else if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    private final void g(ir.nasim.story.ui.viewfragment.views.footer.a oldState, ir.nasim.story.ui.viewfragment.views.footer.a newState) {
        if (!oldState.a(newState) && !AbstractC13042fc3.d(oldState, a.b.b)) {
            if (AbstractC13042fc3.d(oldState, a.e.b)) {
                getViewUploadingStory().setVisibility(8);
            } else if (oldState instanceof a.C1551a) {
                getViewMyStoryStatus().setVisibility(8);
            } else if (oldState instanceof a.c) {
                getViewPopularStoryBar().setVisibility(8);
            } else {
                if (!(oldState instanceof a.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                getViewReplyStory().setVisibility(8);
            }
        }
        if (AbstractC13042fc3.d(newState, a.b.b)) {
            setBackgroundColor(0);
            return;
        }
        if (AbstractC13042fc3.d(newState, a.e.b)) {
            setBackgroundColor(AbstractC4043Dl1.c(getContext(), GA5.overlay_bg_fixed));
            f(getViewUploadingStory());
            return;
        }
        if (newState instanceof a.C1551a) {
            setBackgroundColor(0);
            MyStoryStatusView viewMyStoryStatus = getViewMyStoryStatus();
            a.C1551a c1551a = (a.C1551a) newState;
            InterfaceC5024Ho4 interfaceC5024Ho4B = c1551a.b();
            if (interfaceC5024Ho4B != null) {
                viewMyStoryStatus.setListener(interfaceC5024Ho4B);
            }
            Integer numD = c1551a.d();
            if (numD != null) {
                viewMyStoryStatus.setViewCount(numD.intValue());
            }
            Integer numC = c1551a.c();
            if (numC != null) {
                viewMyStoryStatus.setReactionCount(numC.intValue());
            }
            f(viewMyStoryStatus);
            return;
        }
        if (!(newState instanceof a.c)) {
            if (!(newState instanceof a.d)) {
                throw new NoWhenBranchMatchedException();
            }
            setBackgroundColor(AbstractC4043Dl1.c(getContext(), GA5.overlay_bg_fixed));
            ReplyStoryView viewReplyStory = getViewReplyStory();
            a.d dVar = (a.d) newState;
            viewReplyStory.j(dVar.e(), dVar.d());
            InterfaceC12925fP5 interfaceC12925fP5B = dVar.b();
            if (interfaceC12925fP5B != null) {
                viewReplyStory.setListener(interfaceC12925fP5B);
            }
            ir.nasim.story.ui.viewfragment.views.a aVarC = dVar.c();
            if (aVarC != null) {
                viewReplyStory.setReaction(aVarC);
            }
            f(viewReplyStory);
            return;
        }
        setBackgroundColor(AbstractC4043Dl1.c(getContext(), GA5.overlay_bg_fixed));
        PopularStoryBarView viewPopularStoryBar = getViewPopularStoryBar();
        a.c cVar = (a.c) newState;
        InterfaceC3313Ai5 interfaceC3313Ai5B = cVar.b();
        if (interfaceC3313Ai5B != null) {
            viewPopularStoryBar.setListener(interfaceC3313Ai5B);
        }
        Integer numE = cVar.e();
        if (numE != null) {
            viewPopularStoryBar.setViewCount(numE.intValue());
        }
        Integer numD2 = cVar.d();
        if (numD2 != null) {
            viewPopularStoryBar.setReactionCount(numD2.intValue());
        }
        ir.nasim.story.ui.viewfragment.views.a aVarC2 = cVar.c();
        if (aVarC2 != null) {
            viewPopularStoryBar.setReaction(aVarC2);
        }
        f(viewPopularStoryBar);
    }

    private final MyStoryStatusView getViewMyStoryStatus() {
        return (MyStoryStatusView) this.viewMyStoryStatus.getValue();
    }

    private final PopularStoryBarView getViewPopularStoryBar() {
        return (PopularStoryBarView) this.viewPopularStoryBar.getValue();
    }

    private final ReplyStoryView getViewReplyStory() {
        return (ReplyStoryView) this.viewReplyStory.getValue();
    }

    private final ComposeView getViewUploadingStory() {
        return (ComposeView) this.viewUploadingStory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyStoryStatusView h(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new MyStoryStatusView(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopularStoryBarView i(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new PopularStoryBarView(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReplyStoryView j(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ReplyStoryView(context, null, 0, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ComposeView k(Context context, FooterStoryView footerStoryView) {
        AbstractC13042fc3.i(context, "$context");
        AbstractC13042fc3.i(footerStoryView, "this$0");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(-414737910, true, footerStoryView.new a()));
        return composeView;
    }

    public final MyStoryStatusView getMyStoryStatusView() {
        if (this.state instanceof a.C1551a) {
            return getViewMyStoryStatus();
        }
        return null;
    }

    public final PopularStoryBarView getPopularStoryBarView() {
        if (this.state instanceof a.c) {
            return getViewPopularStoryBar();
        }
        return null;
    }

    public final int getProgress() {
        return ((Number) this._progress.getValue()).intValue();
    }

    public final ReplyStoryView getReplyStoryView() {
        if (this.state instanceof a.d) {
            return getViewReplyStory();
        }
        return null;
    }

    public final ir.nasim.story.ui.viewfragment.views.footer.a getState() {
        return this.state;
    }

    public final void setProgress(int i) {
        this._progress.setValue(Integer.valueOf(i));
    }

    public final void setState(ir.nasim.story.ui.viewfragment.views.footer.a aVar) {
        AbstractC13042fc3.i(aVar, "value");
        g(this.state, aVar);
        this.state = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FooterStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ FooterStoryView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FooterStoryView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this._progress = AbstractC13472gH6.d(0, null, 2, null);
        this.state = a.b.b;
        this.viewMyStoryStatus = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Qu2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FooterStoryView.h(context);
            }
        });
        this.viewUploadingStory = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ru2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FooterStoryView.k(context, this);
            }
        });
        this.viewPopularStoryBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Su2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FooterStoryView.i(context);
            }
        });
        this.viewReplyStory = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Tu2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FooterStoryView.j(context);
            }
        });
        if (isInEditMode()) {
            addView(getViewReplyStory());
        }
    }
}
