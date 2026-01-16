package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C15225jD4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 j2\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u00042\u00020\u0005:\u0001kB\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J+\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\b\"\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\fH\u0016¢\u0006\u0004\b(\u0010\u0007J=\u0010.\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010-2\u0010\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0002H\u0014¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u0002H\u0014¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\fH\u0016¢\u0006\u0004\b7\u0010\u0007R\u0018\u0010:\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00109R$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R.\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010_\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lir/nasim/J90;", "Lir/nasim/AV1;", "Lir/nasim/mL1;", "Lir/nasim/sN1;", "Lir/nasim/jD4$b;", "Lir/nasim/R90;", "<init>", "()V", "", "Landroidx/recyclerview/widget/RecyclerView$h;", "Landroidx/recyclerview/widget/RecyclerView$C;", "adapters", "Lir/nasim/rB7;", "Ea", "([Landroidx/recyclerview/widget/RecyclerView$h;)V", "ra", "ya", "wa", "xa", "pa", "za", "", "id", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/fE;", "state", "J3", "(Lir/nasim/fE;)V", "X0", "Lir/nasim/pf0;", "displayList", "Landroid/content/Context;", "context", "Lir/nasim/tf0;", "ia", "(Lir/nasim/pf0;Landroid/content/Context;)Lir/nasim/tf0;", "item", "Aa", "(Lir/nasim/mL1;)V", "dialog", "", "Ba", "(Lir/nasim/mL1;)Z", "T6", "l1", "Landroid/view/View;", "emptyDialogs", "Landroid/widget/ProgressBar;", "m1", "Landroid/widget/ProgressBar;", "progressView", "Lir/nasim/bQ1;", "n1", "Lir/nasim/bQ1;", "ua", "()Lir/nasim/bQ1;", "setDialogsAdapter", "(Lir/nasim/bQ1;)V", "dialogsAdapter", "Lir/nasim/Q90;", "o1", "Lir/nasim/Q90;", "presenter", "p1", "res", "Lir/nasim/GN1;", "q1", "Lir/nasim/GN1;", "ta", "()Lir/nasim/GN1;", "Ca", "(Lir/nasim/GN1;)V", "dialogItemClickCallback", "Landroidx/recyclerview/widget/RecyclerView$t;", "r1", "Landroidx/recyclerview/widget/RecyclerView$t;", "va", "()Landroidx/recyclerview/widget/RecyclerView$t;", "Da", "(Landroidx/recyclerview/widget/RecyclerView$t;)V", "listsScrollListener", "", "s1", "Ljava/util/List;", "contactRegisteredList", "t1", "sa", "()Ljava/util/List;", "setAdapters", "(Ljava/util/List;)V", "Lir/nasim/AJ4;", "u1", "Lir/nasim/AJ4;", "onMarkAsReadListener", "v1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public abstract class J90 extends AV1<C17067mL1, C20649sN1> implements C15225jD4.b, R90 {
    public static final int w1 = 8;

    /* renamed from: l1, reason: from kotlin metadata */
    private View emptyDialogs;

    /* renamed from: m1, reason: from kotlin metadata */
    private ProgressBar progressView;

    /* renamed from: n1, reason: from kotlin metadata */
    private C10298bQ1 dialogsAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private Q90 presenter;

    /* renamed from: p1, reason: from kotlin metadata */
    private View res;

    /* renamed from: q1, reason: from kotlin metadata */
    private GN1 dialogItemClickCallback;

    /* renamed from: r1, reason: from kotlin metadata */
    private RecyclerView.t listsScrollListener;

    /* renamed from: s1, reason: from kotlin metadata */
    private final List contactRegisteredList = new ArrayList();

    /* renamed from: t1, reason: from kotlin metadata */
    private List adapters = new ArrayList();

    /* renamed from: u1, reason: from kotlin metadata */
    private AJ4 onMarkAsReadListener;

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC12820fE.values().length];
            try {
                iArr[EnumC12820fE.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC12820fE.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC12820fE.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC12820fE.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public static final class c implements InterfaceC22483vJ4 {
        c() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(C17067mL1 c17067mL1) {
            AbstractC13042fc3.i(c17067mL1, "item");
            J90.this.Aa(c17067mL1);
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(C17067mL1 c17067mL1) {
            AbstractC13042fc3.i(c17067mL1, "item");
            return J90.this.Ba(c17067mL1);
        }
    }

    public static final class d implements AJ4 {
        d() {
        }

        @Override // ir.nasim.AJ4
        public void a(C17067mL1 c17067mL1) {
            AbstractC13042fc3.i(c17067mL1, "dialog");
            J90.this.contactRegisteredList.add(c17067mL1);
        }
    }

    public J90() {
        i8(true);
        this.onMarkAsReadListener = new d();
    }

    private final void Ea(final RecyclerView.h[] adapters) {
        AbstractC7426Rr.a.G(new Runnable() { // from class: ir.nasim.I90
            @Override // java.lang.Runnable
            public final void run() {
                J90.Fa(this.a, adapters);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(J90 j90, RecyclerView.h[] hVarArr) {
        AbstractC13042fc3.i(j90, "this$0");
        AbstractC13042fc3.i(hVarArr, "$adapters");
        try {
            View view = j90.res;
            Q90 q90 = j90.presenter;
            j90.X9(view, q90 != null ? q90.l("BaseDialogFragment") : null, (RecyclerView.h[]) Arrays.copyOf(hVarArr, hVarArr.length));
            j90.ra();
            Q90 q902 = j90.presenter;
            AbstractC13042fc3.f(q902);
            q902.m();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    private final void pa() {
        View view = this.emptyDialogs;
        AbstractC13042fc3.f(view);
        view.setVisibility(8);
        ProgressBar progressBar = this.progressView;
        AbstractC13042fc3.f(progressBar);
        progressBar.setVisibility(8);
    }

    private final void ra() {
        FrameLayout frameLayout = new FrameLayout(Q7());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, C22078ud6.a(5.0f)));
        frameLayout.setBackgroundColor(C5495Jo7.a.o());
        Q9(frameLayout);
        View view = new View(A5());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        S9(view, false);
    }

    private final void wa() {
        View view = this.emptyDialogs;
        AbstractC13042fc3.f(view);
        view.setVisibility(8);
        ProgressBar progressBar = this.progressView;
        AbstractC13042fc3.f(progressBar);
        progressBar.setVisibility(8);
    }

    private final void xa() {
        View view = this.emptyDialogs;
        AbstractC13042fc3.f(view);
        view.setVisibility(0);
        ProgressBar progressBar = this.progressView;
        AbstractC13042fc3.f(progressBar);
        progressBar.setVisibility(0);
    }

    private final void ya() {
        Bundle bundleE5 = E5();
        AbstractC13042fc3.f(bundleE5);
        String string = bundleE5.getString("dialogFragmentType", "ALL");
        AbstractC13042fc3.h(string, "getString(...)");
        this.presenter = new Q90(this, OP1.valueOf(string));
    }

    private final void za() {
        E84 e84G = AbstractC5969Lp4.e().G();
        for (C17067mL1 c17067mL1 : this.contactRegisteredList) {
            e84G.e2(c17067mL1.R(), c17067mL1.Q().h(), 0);
        }
    }

    protected void Aa(C17067mL1 item) {
        AbstractC13042fc3.i(item, "item");
    }

    protected boolean Ba(C17067mL1 dialog) {
        AbstractC13042fc3.i(dialog, "dialog");
        return false;
    }

    public final void Ca(GN1 gn1) {
        this.dialogItemClickCallback = gn1;
    }

    public final void Da(RecyclerView.t tVar) {
        this.listsScrollListener = tVar;
    }

    public void J3(EnumC12820fE state) {
        AbstractC13042fc3.i(state, "state");
        int i = b.a[state.ordinal()];
        if (i == 1) {
            xa();
            return;
        }
        if (i != 2) {
            if (i == 3) {
                wa();
                return;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                pa();
                return;
            }
        }
        View view = this.emptyDialogs;
        AbstractC13042fc3.f(view);
        view.setVisibility(8);
        ProgressBar progressBar = this.progressView;
        AbstractC13042fc3.f(progressBar);
        progressBar.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C15225jD4.b().a(this, C15225jD4.i);
        ya();
        Q90 q90 = this.presenter;
        AbstractC13042fc3.f(q90);
        C19024pf0 c19024pf0L = q90.l("BaseDialogFragment");
        if (c19024pf0L == null) {
            Ea((RecyclerView.h[]) this.adapters.toArray(new RecyclerView.h[0]));
        }
        int i = AbstractC12208eD5.fragment_dialogs_constraint_layout;
        RecyclerView.h[] hVarArr = (RecyclerView.h[]) this.adapters.toArray(new RecyclerView.h[0]);
        View viewGa = ga(inflater, container, i, c19024pf0L, false, false, (RecyclerView.h[]) Arrays.copyOf(hVarArr, hVarArr.length));
        this.res = viewGa;
        if (viewGa != null) {
            viewGa.setBackgroundColor(C5495Jo7.a.o());
        }
        View view = this.res;
        this.emptyDialogs = view != null ? view.findViewById(BC5.emptyDialogs) : null;
        View view2 = this.res;
        ProgressBar progressBar = view2 != null ? (ProgressBar) view2.findViewById(BC5.emptyProgressView) : null;
        this.progressView = progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        View view3 = this.res;
        View viewFindViewById = view3 != null ? view3.findViewById(BC5.add_contact_hint_text) : null;
        AbstractC13042fc3.g(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        ((TextView) viewFindViewById).setTextColor(c5495Jo7.n0());
        View view4 = this.emptyDialogs;
        View viewFindViewById2 = view4 != null ? view4.findViewById(BC5.empty_dialogs_text) : null;
        AbstractC13042fc3.g(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) viewFindViewById2).setTextColor(c5495Jo7.g0());
        if (c19024pf0L != null) {
            ra();
            Q90 q902 = this.presenter;
            AbstractC13042fc3.f(q902);
            q902.m();
        }
        return this.res;
    }

    @Override // ir.nasim.AV1, ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        if (C8386Vt0.ja()) {
            za();
        }
        C10298bQ1 c10298bQ1 = this.dialogsAdapter;
        if (c10298bQ1 != null) {
            if (c10298bQ1 != null) {
                c10298bQ1.R();
            }
            C10298bQ1 c10298bQ12 = this.dialogsAdapter;
            if (c10298bQ12 != null) {
                c10298bQ12.B();
            }
            this.dialogsAdapter = null;
        }
        Q90 q90 = this.presenter;
        if (q90 != null) {
            AbstractC13042fc3.f(q90);
            q90.b();
            this.presenter = null;
        }
        this.adapters.clear();
        C15225jD4.b().e(this, C15225jD4.i);
    }

    @Override // ir.nasim.AV1, ir.nasim.AbstractC22588vV1.e
    public void X0() {
        super.X0();
        wa();
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.i) {
            int childCount = ca().getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView.C cFindContainingViewHolder = ca().findContainingViewHolder(ca().getChildAt(i));
                if (cFindContainingViewHolder instanceof C20649sN1) {
                    ((C20649sN1) cFindContainingViewHolder).S0();
                }
            }
        }
    }

    @Override // ir.nasim.AV1
    protected AbstractC21435tf0 ia(C19024pf0 displayList, Context context) {
        C10298bQ1 c10298bQ1 = new C10298bQ1(displayList, new c(), context, this, this.onMarkAsReadListener);
        this.dialogsAdapter = c10298bQ1;
        return c10298bQ1;
    }

    /* renamed from: sa, reason: from getter */
    public final List getAdapters() {
        return this.adapters;
    }

    /* renamed from: ta, reason: from getter */
    public final GN1 getDialogItemClickCallback() {
        return this.dialogItemClickCallback;
    }

    /* renamed from: ua, reason: from getter */
    public final C10298bQ1 getDialogsAdapter() {
        return this.dialogsAdapter;
    }

    /* renamed from: va, reason: from getter */
    public final RecyclerView.t getListsScrollListener() {
        return this.listsScrollListener;
    }
}
