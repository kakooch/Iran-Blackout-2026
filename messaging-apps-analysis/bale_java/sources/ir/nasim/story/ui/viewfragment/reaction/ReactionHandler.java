package ir.nasim.story.ui.viewfragment.reaction;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15087iz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.C12853fH5;
import ir.nasim.C17180mX6;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C6979Pu3;
import ir.nasim.C8386Vt0;
import ir.nasim.ED1;
import ir.nasim.GA5;
import ir.nasim.HG5;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.QY0;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.story.ui.viewfragment.reaction.ReactionHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00016B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!JW\u0010)\u001a\u00020\u00102\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00100\"2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0010¢\u0006\u0004\b+\u0010\u0012J\u0015\u0010-\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.R$\u00104\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020#098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR$\u0010N\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001c\u0010S\u001a\n P*\u0004\u0018\u00010O0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001c\u0010U\u001a\n P*\u0004\u0018\u00010O0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010R¨\u0006V"}, d2 = {"Lir/nasim/story/ui/viewfragment/reaction/ReactionHandler;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "t", "()I", "itemSize", "u", "(I)I", "Lir/nasim/rB7;", "z", "()V", "", "G", "()Z", "", "value", "v", "(F)F", "Landroidx/lifecycle/j;", "lifecycle", "D", "(Landroidx/lifecycle/j;)V", "Lir/nasim/mX6;", "reactionVm", "r", "(Lir/nasim/mX6;)V", "Lkotlin/Function1;", "Lir/nasim/fH5;", "onSelectItem", "Lkotlin/Function0;", "onShow", "onCloseByBtn", "onScroll", "B", "(Lir/nasim/UA2;Lir/nasim/SA2;Lir/nasim/SA2;Lir/nasim/SA2;)V", "w", "callListener", TokenNames.E, "(Z)Z", "Lir/nasim/story/ui/viewfragment/reaction/ReactionHandler$b;", "a", "Lir/nasim/story/ui/viewfragment/reaction/ReactionHandler$b;", "getLastCommand", "()Lir/nasim/story/ui/viewfragment/reaction/ReactionHandler$b;", "lastCommand", "Lir/nasim/iz3;", "b", "Lir/nasim/iz3;", "_scope", "", "c", "Ljava/util/List;", "_reactions", "Lir/nasim/Pu3;", "d", "Lir/nasim/Pu3;", "_binding", "Lir/nasim/HG5;", "e", "Lir/nasim/HG5;", "reactionAdapter", "f", "Lir/nasim/SA2;", "_onShow", "g", "_onCloseByBtn", "h", "_onScroll", "i", "Lir/nasim/UA2;", "_onSelectItem", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "j", "Landroid/animation/ValueAnimator;", "showAnimator", "k", "hideAnimator", "story_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes7.dex */
public final class ReactionHandler extends FrameLayout implements DefaultLifecycleObserver {

    /* renamed from: a, reason: from kotlin metadata */
    private b lastCommand;

    /* renamed from: b, reason: from kotlin metadata */
    private AbstractC15087iz3 _scope;

    /* renamed from: c, reason: from kotlin metadata */
    private final List _reactions;

    /* renamed from: d, reason: from kotlin metadata */
    private final C6979Pu3 _binding;

    /* renamed from: e, reason: from kotlin metadata */
    private HG5 reactionAdapter;

    /* renamed from: f, reason: from kotlin metadata */
    private SA2 _onShow;

    /* renamed from: g, reason: from kotlin metadata */
    private SA2 _onCloseByBtn;

    /* renamed from: h, reason: from kotlin metadata */
    private SA2 _onScroll;

    /* renamed from: i, reason: from kotlin metadata */
    private UA2 _onSelectItem;

    /* renamed from: j, reason: from kotlin metadata */
    private final ValueAnimator showAnimator;

    /* renamed from: k, reason: from kotlin metadata */
    private final ValueAnimator hideAnimator;

    public static final class a extends RecyclerView.t {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            SA2 sa2;
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i != 1 || (sa2 = ReactionHandler.this._onScroll) == null) {
                return;
            }
            sa2.invoke();
        }
    }

    public static abstract class b {
        private final boolean a;

        public static final class a extends b {
            public static final a b = new a();

            private a() {
                super(false, null);
            }
        }

        /* renamed from: ir.nasim.story.ui.viewfragment.reaction.ReactionHandler$b$b, reason: collision with other inner class name */
        public static final class C1548b extends b {
            public static final C1548b b = new C1548b();

            private C1548b() {
                super(false, null);
            }
        }

        public static final class c extends b {
            public static final c b = new c();

            private c() {
                super(false, null);
            }
        }

        public static final class d extends b {
            private final boolean b;

            public d(boolean z) {
                super(z, null);
                this.b = z;
            }

            @Override // ir.nasim.story.ui.viewfragment.reaction.ReactionHandler.b
            public boolean a() {
                return this.b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && this.b == ((d) obj).b;
            }

            public int hashCode() {
                return Boolean.hashCode(this.b);
            }

            public String toString() {
                return "SHOW(callListener=" + this.b + Separators.RPAREN;
            }
        }

        public /* synthetic */ b(boolean z, ED1 ed1) {
            this(z);
        }

        public boolean a() {
            return this.a;
        }

        private b(boolean z) {
            this.a = z;
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C17180mX6 c;
        final /* synthetic */ ReactionHandler d;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ ReactionHandler d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ReactionHandler reactionHandler, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = reactionHandler;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                List list = (List) this.c;
                RecyclerView recyclerView = this.d._binding.d;
                ReactionHandler reactionHandler = this.d;
                if (reactionHandler._reactions.size() != list.size()) {
                    AbstractC13042fc3.f(recyclerView);
                    ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = Integer.min(reactionHandler.u(list.size()), reactionHandler.t());
                    recyclerView.setLayoutParams(layoutParams2);
                }
                if (recyclerView.getAdapter() == null) {
                    reactionHandler.z();
                }
                HG5 hg5 = reactionHandler.reactionAdapter;
                if (hg5 != null) {
                    hg5.C(list);
                }
                this.d._reactions.clear();
                this.d._reactions.addAll(list);
                this.d.G();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(list, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C17180mX6 c17180mX6, ReactionHandler reactionHandler, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c17180mX6;
            this.d = reactionHandler;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6Z0 = this.c.Z0();
                a aVar = new a(this.d, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6Z0, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ReactionHandler.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static final class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ReactionHandler.this.setAlpha(0.0f);
            ReactionHandler.this.setVisibility(0);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactionHandler(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(ReactionHandler reactionHandler, C12853fH5 c12853fH5) {
        AbstractC13042fc3.i(reactionHandler, "this$0");
        AbstractC13042fc3.i(c12853fH5, "item");
        UA2 ua2 = reactionHandler._onSelectItem;
        if (ua2 != null) {
            ua2.invoke(c12853fH5);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ReactionHandler reactionHandler, View view) {
        AbstractC13042fc3.i(reactionHandler, "this$0");
        reactionHandler.w();
        SA2 sa2 = reactionHandler._onCloseByBtn;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ReactionHandler reactionHandler, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(reactionHandler, "this$0");
        AbstractC13042fc3.i(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        reactionHandler.setAlpha(reactionHandler.v(fFloatValue));
        reactionHandler.setScaleX(fFloatValue);
        reactionHandler.setScaleY(fFloatValue);
        reactionHandler.setPivotX(reactionHandler.getWidth() - ((int) ((30 * AbstractC3742Cd6.c()) + 0.5d)));
        reactionHandler.setPivotY(reactionHandler.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G() {
        SA2 sa2;
        if (!C8386Vt0.a.lb() || !(this.lastCommand instanceof b.d)) {
            return false;
        }
        if (getVisibility() != 8) {
            return true;
        }
        if (this._reactions.isEmpty()) {
            return false;
        }
        ValueAnimator valueAnimator = this.showAnimator;
        AbstractC13042fc3.f(valueAnimator);
        valueAnimator.addListener(new e());
        valueAnimator.start();
        if (this.lastCommand.a() && (sa2 = this._onShow) != null) {
            sa2.invoke();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(C12853fH5 c12853fH5) {
        AbstractC13042fc3.i(c12853fH5, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int t() {
        return (C22078ud6.c() - ((int) ((40 * AbstractC3742Cd6.c()) + 0.5d))) - ((int) ((12 * AbstractC3742Cd6.c()) + 0.5d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int u(int itemSize) {
        return (int) ((((itemSize * 40) + (itemSize * 2) + 12) * AbstractC3742Cd6.c()) + 0.5d);
    }

    private final float v(float value) {
        float f = 0.0f;
        if (value > 0.0f) {
            f = 1.0f;
            if (value < 1.0f) {
                return value;
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ReactionHandler reactionHandler, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(reactionHandler, "this$0");
        AbstractC13042fc3.i(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        reactionHandler.setAlpha(reactionHandler.v(fFloatValue));
        reactionHandler.setScaleX(fFloatValue);
        reactionHandler.setScaleY(fFloatValue);
        reactionHandler.setPivotX(reactionHandler.getWidth() - ((int) ((30 * AbstractC3742Cd6.c()) + 0.5d)));
        reactionHandler.setPivotY(reactionHandler.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        RecyclerView recyclerView = this._binding.d;
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(null);
        recyclerView.setClipToOutline(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        HG5 hg5 = new HG5(new UA2() { // from class: ir.nasim.aH5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ReactionHandler.A(this.a, (C12853fH5) obj);
            }
        });
        this.reactionAdapter = hg5;
        recyclerView.setAdapter(hg5);
    }

    public final void B(UA2 onSelectItem, SA2 onShow, SA2 onCloseByBtn, SA2 onScroll) {
        AbstractC13042fc3.i(onSelectItem, "onSelectItem");
        this._onSelectItem = onSelectItem;
        this._onShow = onShow;
        this._onCloseByBtn = onCloseByBtn;
        this._onScroll = onScroll;
        this.lastCommand = b.C1548b.b;
    }

    public final void D(j lifecycle) {
        AbstractC13042fc3.i(lifecycle, "lifecycle");
        lifecycle.a(this);
        this._scope = o.a(lifecycle);
    }

    public final boolean E(boolean callListener) {
        this.lastCommand = new b.d(callListener);
        return G();
    }

    public final b getLastCommand() {
        return this.lastCommand;
    }

    public final void r(C17180mX6 reactionVm) {
        AbstractC13042fc3.i(reactionVm, "reactionVm");
        AbstractC15087iz3 abstractC15087iz3 = this._scope;
        if (abstractC15087iz3 != null) {
            AbstractC10533bm0.d(abstractC15087iz3, null, null, new c(reactionVm, this, null), 3, null);
        }
        reactionVm.c1();
    }

    public final void w() {
        this.lastCommand = b.a.b;
        if (getVisibility() == 8) {
            return;
        }
        ValueAnimator valueAnimator = this.hideAnimator;
        AbstractC13042fc3.f(valueAnimator);
        valueAnimator.addListener(new d());
        valueAnimator.start();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactionHandler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ReactionHandler(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactionHandler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.lastCommand = b.c.b;
        this._reactions = new ArrayList();
        C6979Pu3 c6979Pu3C = C6979Pu3.c(LayoutInflater.from(context), this, true);
        this._binding = c6979Pu3C;
        AppCompatImageView appCompatImageView = c6979Pu3C.b;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WG5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReactionHandler.C(this.a, view);
            }
        });
        int iK = QY0.k(AbstractC4043Dl1.c(context, GA5.n100_dark), 99);
        appCompatImageView.setBackground(new RippleDrawable(new ColorStateList(new int[][]{StateSet.WILD_CARD}, new int[]{iK}), null, AbstractC4310Eo7.d((int) ((10 * AbstractC3742Cd6.c()) + 0.5d), iK)));
        c6979Pu3C.d.addOnScrollListener(new a());
        if (isInEditMode()) {
            RecyclerView recyclerView = c6979Pu3C.d;
            HG5 hg5 = new HG5(new UA2() { // from class: ir.nasim.XG5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return ReactionHandler.g((C12853fH5) obj);
                }
            });
            ArrayList arrayList = new ArrayList(3);
            for (int i2 = 0; i2 < 3; i2++) {
                arrayList.add(new C12853fH5("", false));
            }
            hg5.C(arrayList);
            recyclerView.setAdapter(hg5);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(new OvershootInterpolator(1.5f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.YG5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReactionHandler.F(this.a, valueAnimator);
            }
        });
        this.showAnimator = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setDuration(200L);
        valueAnimatorOfFloat2.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.ZG5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ReactionHandler.x(this.a, valueAnimator);
            }
        });
        this.hideAnimator = valueAnimatorOfFloat2;
    }
}
