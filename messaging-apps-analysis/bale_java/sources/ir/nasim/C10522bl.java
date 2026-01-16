package ir.nasim;

import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.N15;
import ir.nasim.X2;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.bl, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10522bl extends C20882sl7 implements O44 {
    private final ConstraintLayout r;
    private final C7313Re3 s;
    private final InterfaceC9173Yu3 t;
    private final T73 u;
    private C22151ul v;
    private C4041Dl w;
    private GridLayoutManager x;
    private static final a y = new a(null);
    public static final int z = 8;
    private static final int A = AbstractC8943Xx1.a(1.5d);

    /* renamed from: ir.nasim.bl$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.bl$b */
    public static class b extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C10522bl(c15481jf3, z, c());
        }
    }

    /* renamed from: ir.nasim.bl$c */
    public static final class c implements InterfaceC11285cl {
        c() {
        }

        @Override // ir.nasim.InterfaceC11285cl
        public boolean a() {
            return C10522bl.this.z0().k();
        }

        @Override // ir.nasim.InterfaceC11285cl
        public boolean b(C14339hl c14339hl) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            return C10522bl.this.z0().b().m(c14339hl.d());
        }

        @Override // ir.nasim.InterfaceC11285cl
        public void c(C14339hl c14339hl) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            C10522bl.this.z0().b().l(c14339hl.d());
        }

        @Override // ir.nasim.InterfaceC11285cl
        public void d(C14339hl c14339hl, View view) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            InterfaceC24373yW1.h(C10522bl.this.z0().d(), c14339hl.d(), null, view, 2, null);
        }

        @Override // ir.nasim.InterfaceC11285cl
        public void e(C14339hl c14339hl, boolean z) {
            AbstractC13042fc3.i(c14339hl, "albumData");
            C10522bl.this.z0().b().o(c14339hl.d(), Boolean.valueOf(z));
        }
    }

    /* renamed from: ir.nasim.bl$d */
    /* synthetic */ class d extends EB2 implements UA2 {
        d(Object obj) {
            super(1, obj, C4041Dl.class, "getItemWidthAndHeight", "getItemWidthAndHeight(I)Lkotlin/Pair;", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final XV4 y(int i) {
            return ((C4041Dl) this.receiver).l(i);
        }
    }

    /* renamed from: ir.nasim.bl$e */
    /* synthetic */ class e extends EB2 implements UA2 {
        e(Object obj) {
            super(1, obj, C4041Dl.class, "getItemCorners", "getItemCorners(I)I", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return y(((Number) obj).intValue());
        }

        public final Integer y(int i) {
            return Integer.valueOf(((C4041Dl) this.receiver).k(i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10522bl(final C15481jf3 c15481jf3, boolean z2, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z2, abstractC23538x54);
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        this.t = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Yk
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C10522bl.e1(c15481jf3);
            }
        });
        this.u = l1();
        C7313Re3 c7313Re3A = C7313Re3.a(R0(AbstractC12208eD5.item_chat_album_bubble));
        c7313Re3A.b.addItemDecoration(new C20874sl(A));
        MessageStateView messageStateView = c7313Re3A.c;
        AbstractC13042fc3.h(messageStateView, "stateView");
        ViewGroup.LayoutParams layoutParams = messageStateView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int iC = AbstractC8943Xx1.c(4);
        layoutParams2.setMargins(iC, iC, iC, iC);
        messageStateView.setLayoutParams(layoutParams2);
        this.s = c7313Re3A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20444s13 e1(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        return new C20444s13(messageReactionView, messageStateView, messageEmojiTextView, commentContainerView);
    }

    private final void g1(boolean z2) {
        CommentContainerView commentContainerView = x0().e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        if (commentContainerView.getVisibility() == 0) {
            if (z2) {
                FrameLayout root = this.s.getRoot();
                AbstractC13042fc3.h(root, "getRoot(...)");
                ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.j = x0().e.getId();
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = AbstractC8943Xx1.c(4);
                root.setLayoutParams(layoutParams2);
            } else {
                FrameLayout root2 = this.s.getRoot();
                AbstractC13042fc3.h(root2, "getRoot(...)");
                ViewGroup.LayoutParams layoutParams3 = root2.getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.j = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = 0;
                root2.setLayoutParams(layoutParams4);
            }
            Integer numF = l1().F();
            if (numF != null) {
                l1().E(B0().k(), numF.intValue());
            }
        }
    }

    private final InterfaceC11285cl h1() {
        return new c();
    }

    private final C22151ul i1(C4041Dl c4041Dl) {
        return new C22151ul(J0(), h1(), new d(c4041Dl), new e(c4041Dl), G0());
    }

    private final C4041Dl k1(List list, int i, int i2) {
        return new C4041Dl(!n1(((C14339hl) AbstractC15401jX0.q0(list)).c()) ? 1 : 0, list.size(), i, i2, A);
    }

    private final C20444s13 l1() {
        return (C20444s13) this.t.getValue();
    }

    private final boolean m1() {
        return t1() && o1();
    }

    private final boolean n1(AbstractC17757nW1 abstractC17757nW1) {
        if (!(abstractC17757nW1 instanceof AbstractC17757nW1.c)) {
            return true;
        }
        AbstractC17757nW1.c cVar = (AbstractC17757nW1.c) abstractC17757nW1;
        return ((Number) cVar.d().e()).intValue() < ((Number) cVar.d().f()).intValue();
    }

    private final boolean o1() {
        CharSequence text = x0().k.getText();
        return text == null || AbstractC20762sZ6.n0(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(View view, final C10522bl c10522bl, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c10522bl, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        String string = view.getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description);
        AbstractC13042fc3.h(string, "getString(...)");
        AbstractC12990fW7.l0(view, X2.a.i, view.getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.Zk
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C10522bl.q1(this.a, c8967Xz7, view2, aVar);
            }
        });
        AbstractC12990fW7.l0(view, X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.al
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C10522bl.r1(this.a, c8967Xz7, view2, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q1(C10522bl c10522bl, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c10522bl, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        c10522bl.z0().b().e(c10522bl.d(), c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r1(C10522bl c10522bl, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c10522bl, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        c10522bl.z0().b().m(c8967Xz7);
        return true;
    }

    private final void s1(C8304Vk c8304Vk, int i, int i2) {
        List listA = c8304Vk.a();
        C4041Dl c4041DlK1 = k1(listA, i, i2);
        this.w = c4041DlK1;
        RecyclerView recyclerView = this.s.b;
        GridLayoutManager gridLayoutManagerJ1 = j1(c4041DlK1);
        this.x = gridLayoutManagerJ1;
        recyclerView.setLayoutManager(gridLayoutManagerJ1);
        C22151ul c22151ulI1 = i1(c4041DlK1);
        this.v = c22151ulI1;
        c22151ulI1.C(listA);
        this.s.b.setAdapter(c22151ulI1);
    }

    private final boolean t1() {
        CharSequence text = x0().i.getText();
        return text == null || AbstractC20762sZ6.n0(text);
    }

    private final void u1(C8304Vk c8304Vk) {
        C4041Dl c4041Dl = this.w;
        if (c4041Dl == null) {
            return;
        }
        s1(c8304Vk, c4041Dl.p(), c4041Dl.o());
    }

    private final void v1(int i) {
        x0();
        l1().G(Integer.valueOf(i));
        B0().r();
    }

    @Override // ir.nasim.C20882sl7
    protected T73 B0() {
        return this.u;
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 8;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        this.v = null;
        this.x = null;
        this.w = null;
        this.s.b.setAdapter(null);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public List g() {
        RecyclerView recyclerView = this.s.b;
        int childCount = recyclerView.getChildCount();
        ArrayList arrayList = new ArrayList(childCount);
        int i = 0;
        while (true) {
            List listG = null;
            if (i >= childCount) {
                break;
            }
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null) {
                Object childViewHolder = recyclerView.getChildViewHolder(childAt);
                InterfaceC9437Zx6 interfaceC9437Zx6 = childViewHolder instanceof InterfaceC9437Zx6 ? (InterfaceC9437Zx6) childViewHolder : null;
                if (interfaceC9437Zx6 != null) {
                    listG = interfaceC9437Zx6.g();
                }
            }
            arrayList.add(listG);
            i++;
        }
        List listZ = AbstractC10976cX0.z(AbstractC15401jX0.n0(arrayList));
        if (!listZ.isEmpty()) {
            return listZ;
        }
        return null;
    }

    @Override // ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
    }

    public final GridLayoutManager j1(C4041Dl c4041Dl) {
        AbstractC13042fc3.i(c4041Dl, "spanSizeLookUp");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(x0().getRoot().getContext(), c4041Dl.r(), c4041Dl.q(), false);
        gridLayoutManager.k3(c4041Dl);
        return gridLayoutManager;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        ConstraintLayout root = x0().getRoot();
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        AbstractC13042fc3.f(root);
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = ((Number) xv4.e()).intValue();
        root.setLayoutParams(layoutParams);
        int iIntValue = (((Number) xv4.e()).intValue() - root.getPaddingRight()) - root.getPaddingLeft();
        int iIntValue2 = (((Number) xv4.f()).intValue() - root.getPaddingTop()) - root.getPaddingBottom();
        RecyclerView recyclerView = this.s.b;
        AbstractC13042fc3.h(recyclerView, "recyclerView");
        ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams2.height = iIntValue2;
        recyclerView.setLayoutParams(layoutParams2);
        v1(iIntValue - AbstractC8943Xx1.c(16));
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Album");
        s1((C8304Vk) objF, iIntValue, iIntValue2);
        Z0();
        Spannable spannableD = c8967Xz7.d();
        if (spannableD == null || spannableD.length() == 0) {
            g1(m1());
        }
    }

    @Override // ir.nasim.C20882sl7
    public void t0(Spannable spannable) {
        AbstractC13042fc3.i(spannable, "state");
        C7313Re3 c7313Re3 = this.s;
        boolean zM1 = m1();
        if (zM1) {
            c7313Re3.c.r(spannable);
        } else {
            super.t0(spannable);
        }
        MessageStateView messageStateView = c7313Re3.c;
        AbstractC13042fc3.h(messageStateView, "stateView");
        messageStateView.setVisibility(zM1 ? 0 : 8);
        MessageStateView messageStateView2 = x0().l;
        AbstractC13042fc3.h(messageStateView2, "textViewState");
        messageStateView2.setVisibility(zM1 ^ true ? 0 : 8);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(final View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.s.getRoot().postDelayed(new Runnable() { // from class: ir.nasim.Xk
            @Override // java.lang.Runnable
            public final void run() {
                C10522bl.p1(view, this, c8967Xz7);
            }
        }, 200L);
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.b) {
            N15.b bVar = (N15.b) n15;
            if (bVar.c()) {
                u1(bVar.b());
            } else {
                C22151ul c22151ul = this.v;
                if (c22151ul != null) {
                    c22151ul.C(bVar.b().a());
                }
            }
        } else if (n15 instanceof N15.c) {
            C22151ul c22151ul2 = this.v;
            if (c22151ul2 != null) {
                c22151ul2.C(((N15.c) n15).b().a());
            }
        } else if (n15 instanceof N15.j) {
            super.z(n15);
            t0(((N15.j) n15).d());
        } else if (n15 instanceof N15.p) {
            super.z(n15);
            t0(((N15.p) n15).b().r());
            B0().r();
        } else {
            super.z(n15);
        }
        g1(m1());
    }
}
