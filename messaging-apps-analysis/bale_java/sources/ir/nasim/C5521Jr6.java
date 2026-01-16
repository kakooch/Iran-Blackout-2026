package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC7433Rr6;
import ir.nasim.C11411cx6;
import ir.nasim.C5521Jr6;
import ir.nasim.IM5;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Jr6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5521Jr6 extends AbstractC19821r0 {
    public static final a B0 = new a(null);
    public static final int C0 = 8;
    private static Point D0 = new Point(0, 0);
    private boolean A;
    private IM5.c A0;
    private boolean B;
    private boolean D;
    private int G;
    private D17 H;
    private final Set J;
    private ComposeView Y;
    private final InterfaceC9173Yu3 Z;
    private final C14281hf3 w;
    private final B17 x;
    private final InterfaceC9169Yu y;
    private C9456Zz7 z;
    private E17 z0;

    /* renamed from: ir.nasim.Jr6$a */
    public static final class a {
        private a() {
        }

        public final C5521Jr6 a(ViewGroup viewGroup, LayoutInflater layoutInflater, B17 b17, InterfaceC9169Yu interfaceC9169Yu) {
            AbstractC13042fc3.i(viewGroup, "viewGroup");
            AbstractC13042fc3.i(layoutInflater, "inflater");
            AbstractC13042fc3.i(b17, "onSuggestedChannelClick");
            AbstractC13042fc3.i(interfaceC9169Yu, "anonymousUserListener");
            C14281hf3 c14281hf3C = C14281hf3.c(layoutInflater, viewGroup, false);
            AbstractC13042fc3.h(c14281hf3C, "inflate(...)");
            return new C5521Jr6(c14281hf3C, b17, interfaceC9169Yu, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Jr6$b */
    public static final class b implements View.OnLayoutChangeListener {
        final /* synthetic */ MessageEmojiTextView b;

        public b(MessageEmojiTextView messageEmojiTextView) {
            this.b = messageEmojiTextView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C5521Jr6.this.z1(this.b.getLineCount());
        }
    }

    /* renamed from: ir.nasim.Jr6$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ C8894Xu a;
        final /* synthetic */ List b;
        final /* synthetic */ C5521Jr6 c;

        c(C8894Xu c8894Xu, List list, C5521Jr6 c5521Jr6) {
            this.a = c8894Xu;
            this.b = list;
            this.c = c5521Jr6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C5521Jr6 c5521Jr6, List list) {
            AbstractC13042fc3.i(c5521Jr6, "this$0");
            AbstractC13042fc3.i(list, "it");
            c5521Jr6.y.a(list);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C8894Xu c8894Xu = this.a;
            List list = this.b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                C14697iL2 c14697iL2 = (C14697iL2) obj;
                boolean z = false;
                if (c14697iL2 != null && c14697iL2.p0() == 0) {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            interfaceC22053ub1.W(466976187);
            boolean zD = interfaceC22053ub1.D(this.c);
            final C5521Jr6 c5521Jr6 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Kr6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return C5521Jr6.c.c(c5521Jr6, (List) obj2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            C8894Xu c8894Xu2 = this.a;
            AbstractC25206zu4.j(c8894Xu, arrayList, ua2, c8894Xu2 != null ? c8894Xu2.y() : null, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Jr6$d */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ IM5 b;

        d(IM5 im5) {
            this.b = im5;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RecyclerView recyclerView;
            ViewTreeObserver viewTreeObserver;
            C5521Jr6.this.s1(this.b);
            E17 e17 = C5521Jr6.this.z0;
            if (e17 == null || (recyclerView = e17.e) == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }

    /* renamed from: ir.nasim.Jr6$e */
    public static final class e extends RecyclerView.t {
        final /* synthetic */ IM5 b;

        e(IM5 im5) {
            this.b = im5;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (i == 0) {
                C5521Jr6.this.t1(this.b);
            }
        }
    }

    public /* synthetic */ C5521Jr6(C14281hf3 c14281hf3, B17 b17, InterfaceC9169Yu interfaceC9169Yu, ED1 ed1) {
        this(c14281hf3, b17, interfaceC9169Yu);
    }

    private final View A1(int i) {
        ViewStub viewStub = this.w.e;
        viewStub.setLayoutResource(i);
        viewStub.setInflatedId(viewStub.getId());
        View viewInflate = viewStub.inflate();
        AbstractC13042fc3.h(viewInflate, "run(...)");
        return viewInflate;
    }

    private final C19938rB7 B1() {
        E17 e17 = this.z0;
        if (e17 == null) {
            return null;
        }
        e17.e.setVisibility(0);
        return C19938rB7.a;
    }

    private final void C1(int i, IM5 im5) {
        GM5 gm5H;
        C9456Zz7 c9456Zz7 = this.z;
        if (c9456Zz7 == null || (gm5H = c9456Zz7.h()) == null) {
            return;
        }
        gm5H.d(i, im5);
    }

    private final void D1(GM5 gm5) {
        if (gm5.a()) {
            V0();
        }
        this.x.b();
    }

    private final boolean S0(C9456Zz7 c9456Zz7, C9456Zz7 c9456Zz72) {
        return c9456Zz72 != null && c9456Zz7.f().i() == c9456Zz72.f().i() && c9456Zz7.f().h() == c9456Zz72.f().h();
    }

    private final MessageEmojiTextView T0(C9456Zz7 c9456Zz7) {
        MessageEmojiTextView messageEmojiTextView = this.w.f;
        messageEmojiTextView.r(c9456Zz7.d());
        messageEmojiTextView.setTextDirection(JF5.g() ? 4 : 3);
        AbstractC13042fc3.f(messageEmojiTextView);
        if (!messageEmojiTextView.isLaidOut() || messageEmojiTextView.isLayoutRequested()) {
            messageEmojiTextView.addOnLayoutChangeListener(new b(messageEmojiTextView));
        } else {
            z1(messageEmojiTextView.getLineCount());
        }
        AbstractC13042fc3.h(messageEmojiTextView, "apply(...)");
        return messageEmojiTextView;
    }

    private final void U0(List list) {
        RecyclerView recyclerView;
        GM5 gm5H;
        C9456Zz7 c9456Zz7 = this.z;
        if (c9456Zz7 != null && (gm5H = c9456Zz7.h()) != null) {
            gm5H.b(list);
        }
        E17 e17 = this.z0;
        if (e17 == null || (recyclerView = e17.e) == null) {
            return;
        }
        recyclerView.setAdapter(new D17(list, this.x));
    }

    private final void V0() {
        if (this.z0 != null) {
            return;
        }
        final E17 e17A = E17.a(A1(AbstractC12208eD5.suggestion_channels));
        this.w.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Er6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5521Jr6.W0(this.a, e17A, view);
            }
        });
        e17A.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Fr6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5521Jr6.X0(e17A, this, view);
            }
        });
        Drawable background = e17A.getRoot().getBackground();
        if (background != null) {
            Context context = this.w.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            background.setColorFilter(new PorterDuffColorFilter(OY0.b(context, AbstractC21139tA5.n30), PorterDuff.Mode.SRC_IN));
        }
        this.z0 = e17A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(C5521Jr6 c5521Jr6, E17 e17, View view) {
        List listA;
        GM5 gm5H;
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        AbstractC13042fc3.i(e17, "$suggestedLay");
        IM5.c cVar = c5521Jr6.A0;
        if (cVar != null && (listA = cVar.a()) != null && (!listA.isEmpty())) {
            C9456Zz7 c9456Zz7 = c5521Jr6.z;
            if (c9456Zz7 != null && (gm5H = c9456Zz7.h()) != null) {
                gm5H.c();
            }
            ConstraintLayout constraintLayout = e17.d;
            AbstractC13042fc3.h(constraintLayout, "suggestedChannelsLayout");
            ConstraintLayout constraintLayout2 = e17.d;
            AbstractC13042fc3.h(constraintLayout2, "suggestedChannelsLayout");
            constraintLayout.setVisibility((constraintLayout2.getVisibility() == 0) ^ true ? 0 : 8);
        }
        RecyclerView.h adapter = e17.e.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(E17 e17, C5521Jr6 c5521Jr6, View view) {
        GM5 gm5H;
        AbstractC13042fc3.i(e17, "$suggestedLay");
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        e17.d.setVisibility(8);
        C9456Zz7 c9456Zz7 = c5521Jr6.z;
        if (c9456Zz7 == null || (gm5H = c9456Zz7.h()) == null) {
            return;
        }
        gm5H.c();
    }

    private final void Y0(final C9456Zz7 c9456Zz7, final J44 j44, final InterfaceC7199Qr6 interfaceC7199Qr6) {
        ConstraintLayout root = this.w.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gr6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5521Jr6.Z0(this.a, interfaceC7199Qr6, j44, c9456Zz7, view);
            }
        });
        root.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.Hr6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C5521Jr6.a1(this.a, interfaceC7199Qr6, j44, c9456Zz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(C5521Jr6 c5521Jr6, InterfaceC7199Qr6 interfaceC7199Qr6, J44 j44, C9456Zz7 c9456Zz7, View view) {
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        AbstractC13042fc3.i(interfaceC7199Qr6, "$serviceClickListener");
        AbstractC13042fc3.i(j44, "$oldMessage");
        AbstractC13042fc3.i(c9456Zz7, "$message");
        if (c5521Jr6.D) {
            interfaceC7199Qr6.b(j44);
        } else {
            AbstractC13042fc3.f(view);
            interfaceC7199Qr6.c(view, D0, c9456Zz7, j44);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a1(C5521Jr6 c5521Jr6, InterfaceC7199Qr6 interfaceC7199Qr6, J44 j44, C9456Zz7 c9456Zz7, View view) {
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        AbstractC13042fc3.i(interfaceC7199Qr6, "$serviceClickListener");
        AbstractC13042fc3.i(j44, "$oldMessage");
        AbstractC13042fc3.i(c9456Zz7, "$message");
        if (c5521Jr6.D) {
            interfaceC7199Qr6.b(j44);
            return true;
        }
        interfaceC7199Qr6.a(c9456Zz7);
        return true;
    }

    private final void c1(C9456Zz7 c9456Zz7, Spannable spannable, boolean z) {
        C14281hf3 c14281hf3 = this.w;
        T0(c9456Zz7);
        c14281hf3.c.r(spannable);
        BubbleTextView bubbleTextView = c14281hf3.d;
        AbstractC13042fc3.h(bubbleTextView, "newMessagesSeparator");
        bubbleTextView.setVisibility(z ? 0 : 8);
    }

    private final void e1(IM5 im5) {
        ConstraintLayout root;
        if (im5 instanceof IM5.c) {
            B1();
            IM5.c cVar = (IM5.c) im5;
            this.A0 = cVar;
            x1(cVar);
            return;
        }
        if (!(im5 instanceof IM5.a)) {
            if (!(im5 instanceof IM5.b)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        E17 e17 = this.z0;
        if (e17 == null || (root = e17.getRoot()) == null) {
            return;
        }
        root.setVisibility(8);
    }

    private final boolean f1(C9456Zz7 c9456Zz7) {
        return C8386Vt0.Ca() && (c9456Zz7.g().F() instanceof C25178zr6) && !(c9456Zz7.g().F() instanceof C16786lr6) && c9456Zz7.j();
    }

    private final AV2 g1() {
        return (AV2) this.Z.getValue();
    }

    private final ArrayList i1(C9456Zz7 c9456Zz7, C9456Zz7 c9456Zz72) {
        if (c9456Zz72 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        IM5 im5A = ((HM5) c9456Zz7.i().invoke()).a();
        if (!AbstractC13042fc3.d(im5A, c9456Zz72.i())) {
            e1(im5A);
            if (im5A instanceof IM5.c) {
                j1(arrayList, new AbstractC7433Rr6.d(((IM5.c) im5A).a(), c9456Zz7.h()));
            }
        }
        if (c9456Zz7.j() != c9456Zz72.j()) {
            j1(arrayList, new AbstractC7433Rr6.c(c9456Zz7.h()));
        }
        if (!AbstractC13042fc3.d(c9456Zz7.e(), c9456Zz72.e()) && (c9456Zz7.e() instanceof C9403Zu)) {
            j1(arrayList, new AbstractC7433Rr6.a(((C9403Zu) c9456Zz7.e()).a(), ((C9403Zu) c9456Zz7.e()).b()));
        }
        if (!AbstractC13042fc3.d(c9456Zz7.d(), c9456Zz72.d())) {
            j1(arrayList, new AbstractC7433Rr6.b(c9456Zz7.d()));
        }
        return arrayList;
    }

    private static final void j1(ArrayList arrayList, AbstractC7433Rr6 abstractC7433Rr6) {
        arrayList.add(abstractC7433Rr6);
    }

    private final void l1(final C8894Xu c8894Xu, final List list) {
        if (C8386Vt0.n4()) {
            if (c8894Xu == null) {
                ComposeView composeView = this.Y;
                if (composeView != null) {
                    composeView.h();
                    composeView.setVisibility(8);
                    return;
                }
                return;
            }
            MessageEmojiTextView messageEmojiTextView = this.w.f;
            AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
            messageEmojiTextView.setVisibility(8);
            ComposeView composeView2 = this.Y;
            if (composeView2 != null) {
                composeView2.setVisibility(0);
            }
            ComposeView composeView3 = this.Y;
            if (composeView3 != null) {
                composeView3.post(new Runnable() { // from class: ir.nasim.Ir6
                    @Override // java.lang.Runnable
                    public final void run() {
                        C5521Jr6.n1(this.a, c8894Xu, list);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(C5521Jr6 c5521Jr6, C8894Xu c8894Xu, List list) {
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        AbstractC13042fc3.i(list, "$commonGroups");
        ComposeView composeView = c5521Jr6.Y;
        if (composeView != null) {
            composeView.setContent(AbstractC19242q11.c(-765701806, true, new c(c8894Xu, list, c5521Jr6)));
        }
    }

    private final void o1(boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        boolean z5 = z || z2;
        if (!this.A && !this.B) {
            z4 = false;
        }
        this.A = z;
        this.B = z2;
        if (z4 != z5) {
            g1().h(z5, z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AV2 p1(C5521Jr6 c5521Jr6) {
        AbstractC13042fc3.i(c5521Jr6, "this$0");
        View view = c5521Jr6.a;
        AbstractC13042fc3.h(view, "itemView");
        return new AV2(view, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q1(View view, MotionEvent motionEvent) {
        D0 = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(IM5 im5) {
        int iD2;
        int iG2;
        RecyclerView recyclerView;
        E17 e17 = this.z0;
        Object layoutManager = (e17 == null || (recyclerView = e17.e) == null) ? null : recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (iD2 = linearLayoutManager.d2()) > (iG2 = linearLayoutManager.g2())) {
            return;
        }
        while (true) {
            if (!this.J.contains(Integer.valueOf(iD2))) {
                this.J.add(Integer.valueOf(iD2));
                C1(iD2, im5);
            }
            if (iD2 == iG2) {
                return;
            } else {
                iD2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(IM5 im5) {
        RecyclerView recyclerView;
        ViewTreeObserver viewTreeObserver;
        E17 e17 = this.z0;
        if (e17 == null || (recyclerView = e17.e) == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new d(im5));
    }

    private final void u1(IM5 im5) {
        RecyclerView recyclerView;
        E17 e17 = this.z0;
        if (e17 == null || (recyclerView = e17.e) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new e(im5));
    }

    private final void x1(IM5.c cVar) {
        u1(cVar);
        t1(cVar);
    }

    private final void y1() {
        View viewInflate = this.w.b.inflate();
        AbstractC13042fc3.g(viewInflate, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        ComposeView composeView = (ComposeView) viewInflate;
        this.Y = composeView;
        if (composeView != null) {
            composeView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(int i) {
        MessageEmojiTextView messageEmojiTextView = this.w.f;
        if (this.G != i) {
            this.G = i;
            int iC = AbstractC8943Xx1.c(i <= 1 ? 24 : 12);
            Drawable background = messageEmojiTextView.getBackground();
            AbstractC13042fc3.g(background, "null cannot be cast to non-null type com.google.android.material.shape.MaterialShapeDrawable");
            ((C10345bV3) background).Y(iC);
        }
    }

    @Override // ir.nasim.AbstractC19821r0
    public void a() {
        this.z = null;
        this.A = false;
        this.B = false;
        this.D = false;
        this.G = -1;
        ComposeView composeView = this.Y;
        if (composeView != null) {
            composeView.h();
        }
        ComposeView composeView2 = this.Y;
        if (composeView2 != null) {
            composeView2.setVisibility(8);
        }
        MessageEmojiTextView messageEmojiTextView = this.w.f;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        messageEmojiTextView.setVisibility(0);
        ConstraintLayout root = this.w.getRoot();
        root.setOnClickListener(null);
        root.setOnLongClickListener(null);
        g1().i();
        this.H = null;
    }

    public final void d1(AbstractC7433Rr6 abstractC7433Rr6) {
        ConstraintLayout constraintLayout;
        AbstractC13042fc3.i(abstractC7433Rr6, "serviceMessagePayload");
        if (abstractC7433Rr6 instanceof AbstractC7433Rr6.d) {
            AbstractC7433Rr6.d dVar = (AbstractC7433Rr6.d) abstractC7433Rr6;
            if (!dVar.a().isEmpty()) {
                U0(dVar.a());
                E17 e17 = this.z0;
                if (e17 == null || (constraintLayout = e17.d) == null) {
                    return;
                }
                constraintLayout.setVisibility(dVar.b().a() ? 0 : 8);
                return;
            }
            return;
        }
        if (abstractC7433Rr6 instanceof AbstractC7433Rr6.c) {
            C9456Zz7 c9456Zz7 = this.z;
            if (c9456Zz7 != null) {
                D1(c9456Zz7.h());
                return;
            }
            return;
        }
        if (abstractC7433Rr6 instanceof AbstractC7433Rr6.a) {
            AbstractC7433Rr6.a aVar = (AbstractC7433Rr6.a) abstractC7433Rr6;
            l1(aVar.a(), aVar.b());
        } else {
            if (!(abstractC7433Rr6 instanceof AbstractC7433Rr6.b)) {
                throw new NoWhenBranchMatchedException();
            }
            this.w.f.r(((AbstractC7433Rr6.b) abstractC7433Rr6).a());
        }
    }

    public final void r1(J44 j44, C9456Zz7 c9456Zz7, Spannable spannable, boolean z, boolean z2, boolean z3, boolean z4, InterfaceC7199Qr6 interfaceC7199Qr6) {
        AbstractC13042fc3.i(j44, "oldMessage");
        AbstractC13042fc3.i(c9456Zz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(interfaceC7199Qr6, "serviceClickListener");
        this.D = z4;
        boolean zS0 = S0(c9456Zz7, this.z);
        o1(z2, z3, zS0);
        if (zS0) {
            Iterator it = i1(c9456Zz7, this.z).iterator();
            while (it.hasNext()) {
                d1((AbstractC7433Rr6) it.next());
            }
        } else {
            Y0(c9456Zz7, j44, interfaceC7199Qr6);
            c1(c9456Zz7, spannable, z);
            if (f1(c9456Zz7)) {
                D1(c9456Zz7.h());
                V0();
            }
            if (c9456Zz7.e() instanceof C9403Zu) {
                l1(((C9403Zu) c9456Zz7.e()).a(), ((C9403Zu) c9456Zz7.e()).b());
            }
        }
        this.z = c9456Zz7;
    }

    private C5521Jr6(C14281hf3 c14281hf3, B17 b17, InterfaceC9169Yu interfaceC9169Yu) {
        super(c14281hf3.getRoot());
        this.w = c14281hf3;
        this.x = b17;
        this.y = interfaceC9169Yu;
        this.G = -1;
        this.J = new LinkedHashSet();
        this.Z = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Cr6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C5521Jr6.p1(this.a);
            }
        });
        MessageEmojiTextView messageEmojiTextView = c14281hf3.f;
        messageEmojiTextView.setTypeface(C6011Lu2.k());
        messageEmojiTextView.setTextSize(C3335Al0.a.t());
        C11411cx6 c11411cx6M = new C11411cx6.b().o(AbstractC8943Xx1.c(24)).m();
        AbstractC13042fc3.h(c11411cx6M, "build(...)");
        C10345bV3 c10345bV3 = new C10345bV3(c11411cx6M);
        Context context = messageEmojiTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        c10345bV3.setTint(OY0.b(context, AbstractC21139tA5.chips_serviec_message));
        AbstractC12990fW7.t0(messageEmojiTextView, c10345bV3);
        c14281hf3.c.setTypeface(C6011Lu2.k());
        c14281hf3.d.setTypeface(C6011Lu2.i());
        c14281hf3.getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Dr6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return C5521Jr6.q1(view, motionEvent);
            }
        });
        if (C8386Vt0.n4()) {
            y1();
        }
    }
}
