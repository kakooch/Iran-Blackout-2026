package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.N15;
import ir.nasim.X2;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Wk2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8541Wk2 extends C20882sl7 implements O44 {
    private final ConstraintLayout r;
    private final C8488We3 s;
    private C22007uW1 t;
    private boolean u;
    private boolean v;
    private View w;
    private final InterfaceC9173Yu3 x;
    private final C20326rp2 y;
    public static final a z = new a(null);
    public static final int A = 8;

    /* renamed from: ir.nasim.Wk2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Wk2$b */
    public static final class b extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C8541Wk2(c15481jf3, z, c(), null);
        }
    }

    /* renamed from: ir.nasim.Wk2$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DocumentStateButton.a.values().length];
            try {
                iArr[DocumentStateButton.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentStateButton.a.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocumentStateButton.a.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocumentStateButton.a.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public /* synthetic */ C8541Wk2(C15481jf3 c15481jf3, boolean z2, AbstractC23538x54 abstractC23538x54, ED1 ed1) {
        this(c15481jf3, z2, abstractC23538x54);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A1(C8541Wk2 c8541Wk2, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        c8541Wk2.z0().b().m(c8967Xz7);
        return true;
    }

    private final void B1(View view, DocumentStateButton.a aVar) {
        Context context = this.s.getRoot().getContext();
        int i = aVar == null ? -1 : c.a[aVar.ordinal()];
        String string = i != 1 ? (i == 2 || i == 3) ? context.getString(AbstractC12217eE5.download) : context.getString(AbstractC12217eE5.accessibility_activate) : context.getString(AbstractC12217eE5.cancel_download);
        AbstractC13042fc3.f(string);
        if (this.u) {
            string = context.getString(AbstractC12217eE5.accessibility_activate);
        }
        AbstractC13042fc3.f(string);
        AbstractC12990fW7.l0(view, X2.a.i, string, new InterfaceC10698c3() { // from class: ir.nasim.Sk2
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar2) {
                return C8541Wk2.D1(this.a, view2, aVar2);
            }
        });
    }

    static /* synthetic */ void C1(C8541Wk2 c8541Wk2, View view, DocumentStateButton.a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            aVar = null;
        }
        c8541Wk2.B1(view, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D1(C8541Wk2 c8541Wk2, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c8541Wk2.s.c.performClick();
        return true;
    }

    private final void V0() {
        C8488We3 c8488We3 = this.s;
        MessageEmojiTextView messageEmojiTextView = c8488We3.e;
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.j());
        c8488We3.d.setTextSize(c3335Al0.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20326rp2 l1(C15481jf3 c15481jf3) {
        AbstractC13042fc3.i(c15481jf3, "$binding");
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        return new C20326rp2(messageReactionView, messageStateView, messageEmojiTextView, commentContainerView);
    }

    private final void m1(final C8967Xz7 c8967Xz7, final AbstractC17757nW1.b bVar) {
        final C8488We3 c8488We3 = this.s;
        c8488We3.g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Pk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C8541Wk2.q1(this.a, c8967Xz7, c8488We3, view);
            }
        });
        c8488We3.c.setOnClickListener(new UA2() { // from class: ir.nasim.Qk2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C8541Wk2.n1(this.a, c8967Xz7, bVar, (DocumentStateButton.a) obj);
            }
        });
        c8488We3.e.r(bVar.f());
        c8488We3.d.r(bVar.e());
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        C22007uW1 c22007uW1 = new C22007uW1(c14970in2D, bVar, null, 4, null);
        c22007uW1.I(s1(bVar));
        c22007uW1.I(r1(bVar));
        c22007uW1.I(new CW1(new SA2() { // from class: ir.nasim.Rk2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8541Wk2.p1(this.a, bVar);
            }
        }));
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        c22007uW1.I(new GX1(root, AbstractC12217eE5.media_Document, null, null, 12, null));
        AbstractC4767Gm.a(c22007uW1, bVar.b(), G0(), bVar.e().toString());
        c22007uW1.l();
        this.t = c22007uW1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n1(final C8541Wk2 c8541Wk2, C8967Xz7 c8967Xz7, AbstractC17757nW1.b bVar, DocumentStateButton.a aVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(bVar, "$document");
        AbstractC13042fc3.i(aVar, "it");
        View view = c8541Wk2.w;
        if (view != null) {
            c8541Wk2.B1(view, aVar);
        }
        int i = c.a[aVar.ordinal()];
        if (i == 1) {
            c8541Wk2.z0().d().c(c8967Xz7, bVar.b().a().a(), new SA2() { // from class: ir.nasim.Mk2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C8541Wk2.o1(this.a);
                }
            });
        } else if (i == 2) {
            InterfaceC24373yW1.h(c8541Wk2.z0().d(), c8967Xz7, null, null, 6, null);
        } else if (i == 3) {
            C22007uW1 c22007uW1 = c8541Wk2.t;
            if (c22007uW1 != null) {
                c22007uW1.H();
            }
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            c8541Wk2.z0().b().l(c8967Xz7);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o1(C8541Wk2 c8541Wk2) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        C22007uW1 c22007uW1 = c8541Wk2.t;
        if (c22007uW1 != null) {
            c22007uW1.L();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p1(C8541Wk2 c8541Wk2, AbstractC17757nW1.b bVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(bVar, "$document");
        c8541Wk2.v = bVar instanceof AbstractC17757nW1.d;
        c8541Wk2.u = true;
        View view = c8541Wk2.w;
        if (view != null) {
            C1(c8541Wk2, view, null, 2, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(C8541Wk2 c8541Wk2, C8967Xz7 c8967Xz7, C8488We3 c8488We3, View view) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c8488We3, "$this_with");
        c8541Wk2.j(c8967Xz7.c());
        InterfaceC22948w54 interfaceC22948w54B = c8541Wk2.z0().b();
        ImageView imageView = c8488We3.g;
        AbstractC13042fc3.h(imageView, "moreOptions");
        interfaceC22948w54B.e(imageView, c8967Xz7);
    }

    private final AbstractC22597vW1 r1(AbstractC17757nW1.b bVar) {
        if (bVar instanceof AbstractC17757nW1.d) {
            DocumentStateButton documentStateButton = this.s.c;
            AbstractC13042fc3.h(documentStateButton, "documentStateButton");
            return new P13(documentStateButton, KB5.paper_bold);
        }
        DocumentStateButton documentStateButton2 = this.s.c;
        AbstractC13042fc3.h(documentStateButton2, "documentStateButton");
        return new OW1(documentStateButton2, Integer.valueOf(KB5.paper_bold), false, 4, null);
    }

    private final AbstractC22597vW1 s1(AbstractC17757nW1.b bVar) {
        C8488We3 c8488We3 = this.s;
        if (!(bVar instanceof AbstractC17757nW1.d)) {
            Spannable spannableE = bVar.e();
            BubbleTextView bubbleTextView = c8488We3.d;
            AbstractC13042fc3.h(bubbleTextView, "fileDetails");
            return new C5454Jk2(spannableE, bubbleTextView);
        }
        Spannable spannableE2 = bVar.e();
        byte[] bArrI = ((AbstractC17757nW1.d) bVar).i();
        BubbleTextView bubbleTextView2 = c8488We3.d;
        AbstractC13042fc3.h(bubbleTextView2, "fileDetails");
        ShapeableImageView shapeableImageView = c8488We3.f;
        AbstractC13042fc3.h(shapeableImageView, "imageViewFile");
        return new O13(spannableE2, bArrI, bubbleTextView2, shapeableImageView);
    }

    private final C20326rp2 u1() {
        return (C20326rp2) this.x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(C8488We3 c8488We3, View view) {
        AbstractC13042fc3.i(c8488We3, "$this_apply");
        c8488We3.c.performClick();
    }

    private final int w1(int i) {
        return Math.min(i, (int) (this.s.getRoot().getResources().getDisplayMetrics().widthPixels * 0.75d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(final C8541Wk2 c8541Wk2, View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        Context context = c8541Wk2.s.getRoot().getContext();
        String string = c8541Wk2.u ? context.getString(AbstractC12217eE5.accessibility_activate) : context.getString(AbstractC12217eE5.item_not_downloaded_content_description);
        AbstractC13042fc3.f(string);
        AbstractC12990fW7.c(view, context.getString(AbstractC12217eE5.message_options_context_menu), new InterfaceC10698c3() { // from class: ir.nasim.Tk2
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C8541Wk2.y1(this.a, c8967Xz7, view2, aVar);
            }
        });
        AbstractC12990fW7.l0(view, X2.a.i, (CharSequence) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null)), new InterfaceC10698c3() { // from class: ir.nasim.Uk2
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C8541Wk2.z1(this.a, view2, aVar);
            }
        });
        AbstractC12990fW7.l0(view, X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.Vk2
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C8541Wk2.A1(this.a, c8967Xz7, view2, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y1(C8541Wk2 c8541Wk2, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        c8541Wk2.j(c8967Xz7.c());
        InterfaceC22948w54 interfaceC22948w54B = c8541Wk2.z0().b();
        ConstraintLayout root = c8541Wk2.s.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        interfaceC22948w54B.e(root, c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z1(C8541Wk2 c8541Wk2, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c8541Wk2, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c8541Wk2.s.c.performClick();
        return true;
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 4;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    @Override // ir.nasim.C20882sl7
    protected void X0(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        B0().s((w1(((Number) xv4.e()).intValue()) - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight());
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        C22007uW1 c22007uW1 = this.t;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        this.t = null;
        this.u = false;
        this.v = false;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void i() {
        super.i();
        this.s.e.invalidate();
    }

    @Override // ir.nasim.O44
    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        aVar.V(this.v);
        aVar.M(this.u);
        aVar.Y(this.u);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = w1(((Number) xv4.e()).intValue());
        root.setLayoutParams(layoutParams2);
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.File");
        m1(c8967Xz7, (AbstractC17757nW1.b) objF);
        Z0();
        if (c8967Xz7.i() != null) {
            B0().u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C20882sl7
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public C20326rp2 B0() {
        return this.y;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(final View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.w = view;
        x0().getRoot().postDelayed(new Runnable() { // from class: ir.nasim.Lk2
            @Override // java.lang.Runnable
            public final void run() {
                C8541Wk2.x1(this.a, view, c8967Xz7);
            }
        }, 100L);
        super.w(view, c8967Xz7);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.i) {
            C22007uW1 c22007uW1 = this.t;
            if (c22007uW1 != null) {
                c22007uW1.K(((N15.i) n15).b());
            }
        } else {
            super.z(n15);
        }
        CommentContainerView commentContainerView = x0().e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        if (commentContainerView.getVisibility() == 0) {
            B0().u();
        }
    }

    private C8541Wk2(final C15481jf3 c15481jf3, boolean z2, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z2, abstractC23538x54);
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        this.x = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Nk2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C8541Wk2.l1(c15481jf3);
            }
        });
        this.y = u1();
        ViewStub viewStub = c15481jf3.g;
        AbstractC13042fc3.h(viewStub, "mainViewStub");
        ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
        viewStub.setLayoutParams(layoutParams2);
        final C8488We3 c8488We3A = C8488We3.a(R0(AbstractC12208eD5.item_chat_file_bubble));
        DocumentStateButton documentStateButton = c8488We3A.c;
        Context context = c15481jf3.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        documentStateButton.setTintColor(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
        Context context2 = c8488We3A.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        if (!C10082b3.c(context2)) {
            c8488We3A.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ok2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C8541Wk2.v1(c8488We3A, view);
                }
            });
        }
        c8488We3A.e.setTypeface(C6011Lu2.k());
        c8488We3A.d.setTypeface(C6011Lu2.k());
        this.s = c8488We3A;
        V0();
    }
}
