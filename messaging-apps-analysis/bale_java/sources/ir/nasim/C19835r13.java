package ir.nasim;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.C20882sl7;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.M44;
import ir.nasim.MW1;
import ir.nasim.N15;
import ir.nasim.X2;
import ir.nasim.animation.view.transition.sharedelement.Corners;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.r13, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C19835r13 extends C20882sl7 implements O44 {
    public static final a Y = new a(null);
    public static final int Z = 8;
    private static final int z0 = AbstractC8943Xx1.c(116);
    private View A;
    private XV4 B;
    private XV4 D;
    private int G;
    private View H;
    private final C25112zl0 J;
    private final ConstraintLayout r;
    private final C9263Ze3 s;
    private XV4 t;
    private final InterfaceC9173Yu3 u;
    private final T73 v;
    private C22007uW1 w;
    private AbstractC17168mW3 x;
    private AbstractC6981Pu5 y;
    private boolean z;

    /* renamed from: ir.nasim.r13$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.r13$b */
    public static class b extends C20882sl7.b {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            super(z, abstractC23538x54);
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        }

        @Override // ir.nasim.C20882sl7.b
        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C19835r13(c15481jf3, z, c());
        }
    }

    /* renamed from: ir.nasim.r13$c */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DocumentStateButton.a.values().length];
            try {
                iArr[DocumentStateButton.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentStateButton.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocumentStateButton.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocumentStateButton.a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19835r13(final C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        super(c15481jf3, z, abstractC23538x54);
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.r = constraintLayout;
        C9263Ze3 c9263Ze3P1 = P1();
        this.s = c9263Ze3P1;
        this.t = AbstractC4616Fw7.a(0, 0);
        this.u = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.j13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19835r13.q1(c15481jf3);
            }
        });
        this.v = O1();
        ImageViewCrossFade imageViewCrossFade = c9263Ze3P1.c;
        AbstractC13042fc3.h(imageViewCrossFade, "imageView");
        this.J = new C25112zl0(imageViewCrossFade);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A1(C19835r13 c19835r13) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        c19835r13.z = true;
        c19835r13.k2();
        return C19938rB7.a;
    }

    private final OW1 B1(AbstractC17757nW1.c cVar) {
        if (cVar instanceof AbstractC17757nW1.c.a) {
            DocumentStateButton documentStateButton = this.s.b;
            AbstractC13042fc3.h(documentStateButton, "documentStateButton");
            return new OW1(documentStateButton, null, false, 6, null);
        }
        if (cVar instanceof AbstractC17757nW1.c.b) {
            DocumentStateButton documentStateButton2 = this.s.b;
            AbstractC13042fc3.h(documentStateButton2, "documentStateButton");
            return new OW1(documentStateButton2, null, false, 6, null);
        }
        if (!(cVar instanceof AbstractC17757nW1.c.d)) {
            throw new IllegalStateException();
        }
        DocumentStateButton documentStateButton3 = this.s.b;
        AbstractC13042fc3.h(documentStateButton3, "documentStateButton");
        return new WS7(documentStateButton3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F1(C19835r13 c19835r13) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        C22007uW1 c22007uW1 = c19835r13.w;
        if (c22007uW1 != null) {
            c22007uW1.L();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G1(C19835r13 c19835r13) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        C22007uW1 c22007uW1 = c19835r13.w;
        if (c22007uW1 != null) {
            c22007uW1.H();
        }
        return C19938rB7.a;
    }

    private final int I1(AbstractC17757nW1.c cVar) {
        if (cVar instanceof AbstractC17757nW1.c.a) {
            return AbstractC12217eE5.media_Gif;
        }
        if (cVar instanceof AbstractC17757nW1.c.b) {
            return AbstractC12217eE5.media_picture;
        }
        if ((cVar instanceof AbstractC17757nW1.c.AbstractC1416c.a) || (cVar instanceof AbstractC17757nW1.c.AbstractC1416c.b)) {
            return AbstractC12217eE5.media_sticker;
        }
        if (cVar instanceof AbstractC17757nW1.c.d) {
            return AbstractC12217eE5.media_video2;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final C20444s13 O1() {
        return (C20444s13) this.u.getValue();
    }

    private final C9263Ze3 P1() {
        C9263Ze3 c9263Ze3A = C9263Ze3.a(R0(AbstractC12208eD5.item_chat_image_bubble));
        c9263Ze3A.g.setTypeface(C6011Lu2.k());
        DocumentStateButton documentStateButton = c9263Ze3A.b;
        Context context = c9263Ze3A.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        documentStateButton.setTintColor(OY0.b(context, AbstractC21139tA5.colorOnPrimary));
        Context context2 = c9263Ze3A.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        documentStateButton.setBackgroundColor(OY0.b(context2, AbstractC21139tA5.bubble_background_icon), PorterDuff.Mode.MULTIPLY);
        c9263Ze3A.c.setCorners(AbstractC8943Xx1.c(10));
        AbstractC13042fc3.h(c9263Ze3A, "apply(...)");
        return c9263Ze3A;
    }

    private final XV4 S1(XV4 xv4, XV4 xv42) {
        View viewM1 = M1();
        ViewGroup.LayoutParams layoutParams = viewM1.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = 0;
        layoutParams.height = 0;
        viewM1.setLayoutParams(layoutParams);
        x0().getRoot().measure(0, 0);
        int measuredWidth = (x0().getRoot().getMeasuredWidth() - x0().getRoot().getPaddingRight()) - x0().getRoot().getPaddingLeft();
        int iIntValue = ((Number) xv4.a()).intValue();
        int iIntValue2 = ((Number) xv4.b()).intValue();
        int iIntValue3 = ((Number) xv42.a()).intValue();
        float fX1 = x1(iIntValue3, iIntValue, ((Number) xv42.b()).intValue(), iIntValue2);
        int iN1 = (int) (iIntValue * fX1);
        if (iN1 < Math.min(measuredWidth, iIntValue3)) {
            iN1 = Math.min(measuredWidth, iIntValue3);
        }
        if (iN1 < N1()) {
            iN1 = N1();
        }
        int i = (int) (fX1 * iIntValue2);
        int i2 = z0;
        if (i < i2) {
            i = i2;
        }
        return AbstractC4616Fw7.a(Integer.valueOf(Math.max(iN1, O1().E(iIntValue3, iN1))), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(View view) {
        AbstractC13042fc3.i(view, "$view");
        view.setVisibility(0);
    }

    private final boolean V1() {
        CharSequence text = x0().k.getText();
        return text == null || AbstractC20762sZ6.n0(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(final C19835r13 c19835r13, View view, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(view, "$accessibleView");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        CharSequence contentDescription = c19835r13.s.g.getContentDescription();
        if (contentDescription == null || AbstractC20762sZ6.n0(contentDescription)) {
            return;
        }
        String string = c19835r13.z ? view.getContext().getString(AbstractC12217eE5.message_options_activate) : view.getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description);
        AbstractC13042fc3.f(string);
        if (c8967Xz7.f() instanceof AbstractC17757nW1.c.d) {
            c19835r13.h2();
            AbstractC12990fW7.l0(c19835r13.s.getRoot(), X2.a.i, view.getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.e13
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C19835r13.X1(this.a, view2, aVar);
                }
            });
        } else {
            AbstractC12990fW7.l0(view, X2.a.i, (CharSequence) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null)), new InterfaceC10698c3() { // from class: ir.nasim.f13
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C19835r13.Y1(this.a, view2, aVar);
                }
            });
            AbstractC12990fW7.l0(view, X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(contentDescription, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.g13
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C19835r13.Z1(view2, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X1(C19835r13 c19835r13, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c19835r13.M1().callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y1(C19835r13 c19835r13, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c19835r13.M1().callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Z1(View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(view, "<unused var>");
        return true;
    }

    private final void a2(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        C9263Ze3 c9263Ze3 = this.s;
        e2(c8967Xz7);
        DocumentStateButton documentStateButton = c9263Ze3.b;
        AbstractC13042fc3.h(documentStateButton, "documentStateButton");
        b2(documentStateButton, c8967Xz7, cVar);
    }

    private final void b2(DocumentStateButton documentStateButton, final C8967Xz7 c8967Xz7, final AbstractC17757nW1.c cVar) {
        documentStateButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.p13
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C19835r13.c2(this.a, c8967Xz7, view);
            }
        });
        documentStateButton.setOnClickListener(new UA2() { // from class: ir.nasim.q13
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19835r13.d2(cVar, this, c8967Xz7, (DocumentStateButton.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c2(C19835r13 c19835r13, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        return c19835r13.z0().b().m(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d2(AbstractC17757nW1.c cVar, C19835r13 c19835r13, C8967Xz7 c8967Xz7, DocumentStateButton.a aVar) {
        C22007uW1 c22007uW1;
        C22007uW1 c22007uW12;
        AbstractC13042fc3.i(cVar, "$document");
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(aVar, "it");
        int i = c.a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                C22007uW1 c22007uW13 = c19835r13.w;
                if (c22007uW13 != null) {
                    c22007uW13.H();
                }
            } else if (i == 3) {
                c19835r13.z0().b().l(c8967Xz7);
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                if ((cVar instanceof AbstractC17757nW1.c.d) && !c19835r13.z && (c22007uW12 = c19835r13.w) != null) {
                    c22007uW12.H();
                }
                InterfaceC24373yW1 interfaceC24373yW1D = c19835r13.z0().d();
                C8948Xx6 c8948Xx6B = c19835r13.b();
                interfaceC24373yW1D.b(c8967Xz7, cVar, c8948Xx6B != null ? c8948Xx6B.c() : null);
            }
        } else if (cVar instanceof AbstractC17757nW1.c.d) {
            if (!c19835r13.z && (c22007uW1 = c19835r13.w) != null) {
                c22007uW1.H();
            }
            InterfaceC24373yW1 interfaceC24373yW1D2 = c19835r13.z0().d();
            C8948Xx6 c8948Xx6B2 = c19835r13.b();
            interfaceC24373yW1D2.b(c8967Xz7, cVar, c8948Xx6B2 != null ? c8948Xx6B2.c() : null);
        } else {
            C22007uW1 c22007uW14 = c19835r13.w;
            if (c22007uW14 != null) {
                c22007uW14.L();
            }
        }
        return C19938rB7.a;
    }

    private final void e2(final C8967Xz7 c8967Xz7) {
        final C9263Ze3 c9263Ze3 = this.s;
        M1().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.b13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19835r13.f2(this.a, c8967Xz7, c9263Ze3, view);
            }
        });
        M1().setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.i13
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C19835r13.g2(this.a, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(C19835r13 c19835r13, C8967Xz7 c8967Xz7, C9263Ze3 c9263Ze3, View view) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c9263Ze3, "$this_with");
        if (!c19835r13.z0().k()) {
            c9263Ze3.b.performClick();
        } else {
            if (AbstractC9222Yz7.a(c8967Xz7)) {
                return;
            }
            InterfaceC24373yW1 interfaceC24373yW1D = c19835r13.z0().d();
            C8948Xx6 c8948Xx6B = c19835r13.b();
            InterfaceC24373yW1.h(interfaceC24373yW1D, c8967Xz7, null, c8948Xx6B != null ? c8948Xx6B.c() : null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g2(C19835r13 c19835r13, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        return c19835r13.z0().b().m(c8967Xz7);
    }

    private final void h2() {
        ConstraintLayout root = this.s.getRoot();
        root.setImportantForAccessibility(1);
        root.setContentDescription(root.getContext().getString(AbstractC12217eE5.media_video));
        DocumentStateButton documentStateButton = this.s.b;
        documentStateButton.setImportantForAccessibility(1);
        documentStateButton.setFocusable(true);
        documentStateButton.setClickable(true);
        documentStateButton.setContentDescription(x0().getRoot().getContext().getString(AbstractC12217eE5.play_video));
    }

    private final void i2(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        C22007uW1 c22007uW1 = this.w;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        C22007uW1 c22007uW1Y1 = y1(c8967Xz7, cVar);
        U1(cVar, c22007uW1Y1);
        c22007uW1Y1.l();
        this.w = c22007uW1Y1;
    }

    private final boolean j2() {
        CharSequence text = x0().i.getText();
        return text == null || AbstractC20762sZ6.n0(text);
    }

    private final void k2() {
        CharSequence contentDescription;
        String string;
        String string2;
        if (this.A == null || (contentDescription = this.s.g.getContentDescription()) == null || AbstractC20762sZ6.n0(contentDescription)) {
            return;
        }
        View view = this.A;
        View view2 = null;
        if (view == null) {
            AbstractC13042fc3.y("accessibleView");
            view = null;
        }
        X2.a aVar = X2.a.i;
        if (this.z) {
            View view3 = this.A;
            if (view3 == null) {
                AbstractC13042fc3.y("accessibleView");
                view3 = null;
            }
            string = view3.getContext().getString(AbstractC12217eE5.message_options_activate);
        } else {
            View view4 = this.A;
            if (view4 == null) {
                AbstractC13042fc3.y("accessibleView");
                view4 = null;
            }
            string = view4.getContext().getString(AbstractC12217eE5.download);
        }
        AbstractC12990fW7.l0(view, aVar, string, new InterfaceC10698c3() { // from class: ir.nasim.c13
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view5, InterfaceC10698c3.a aVar2) {
                return C19835r13.l2(this.a, view5, aVar2);
            }
        });
        ConstraintLayout root = this.s.getRoot();
        if (this.z) {
            View view5 = this.A;
            if (view5 == null) {
                AbstractC13042fc3.y("accessibleView");
            } else {
                view2 = view5;
            }
            string2 = view2.getContext().getString(AbstractC12217eE5.message_options_activate);
        } else {
            View view6 = this.A;
            if (view6 == null) {
                AbstractC13042fc3.y("accessibleView");
            } else {
                view2 = view6;
            }
            string2 = view2.getContext().getString(AbstractC12217eE5.download);
        }
        AbstractC12990fW7.l0(root, aVar, string2, new InterfaceC10698c3() { // from class: ir.nasim.d13
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view7, InterfaceC10698c3.a aVar2) {
                return C19835r13.m2(this.a, view7, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l2(C19835r13 c19835r13, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c19835r13.M1().callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m2(C19835r13 c19835r13, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c19835r13, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c19835r13.M1().callOnClick();
        return true;
    }

    private final void n2(int i) {
        x0();
        O1().G(Integer.valueOf(i));
        B0().r();
    }

    private final XV4 o2() {
        XV4 xv4 = this.B;
        XV4 xv42 = null;
        if (xv4 == null) {
            AbstractC13042fc3.y("originalSize");
            xv4 = null;
        }
        XV4 xv43 = this.D;
        if (xv43 == null) {
            AbstractC13042fc3.y("maxAvailableSpace");
        } else {
            xv42 = xv43;
        }
        XV4 xv4S1 = S1(xv4, xv42);
        n2(((Number) xv4S1.e()).intValue() - AbstractC8943Xx1.c(16));
        View viewM1 = M1();
        ViewGroup.LayoutParams layoutParams = viewM1.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        layoutParams.width = ((Number) xv4S1.e()).intValue();
        layoutParams.height = ((Number) xv4S1.f()).intValue();
        viewM1.setLayoutParams(layoutParams);
        return xv4S1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C20444s13 q1(C15481jf3 c15481jf3) {
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

    private final void r1(boolean z) {
        CommentContainerView commentContainerView = x0().e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        if (commentContainerView.getVisibility() == 0) {
            if (z) {
                ConstraintLayout root = this.s.getRoot();
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
                ConstraintLayout root2 = this.s.getRoot();
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
            Integer numF = O1().F();
            if (numF != null) {
                O1().E(B0().k(), numF.intValue());
            }
        }
    }

    private final DocumentStateButton s1(final AbstractC17757nW1.c.d.b bVar) {
        C9263Ze3 c9263Ze3 = this.s;
        c9263Ze3.g.r(bVar.h());
        DocumentStateButton documentStateButton = c9263Ze3.b;
        DocumentStateButton.f(documentStateButton, false, false, 2, null);
        documentStateButton.setOnClickListener(new UA2() { // from class: ir.nasim.k13
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19835r13.t1(bVar, (DocumentStateButton.a) obj);
            }
        });
        AbstractC13042fc3.h(documentStateButton, "with(...)");
        return documentStateButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t1(AbstractC17757nW1.c.d.b bVar, DocumentStateButton.a aVar) {
        AbstractC13042fc3.i(bVar, "$document");
        AbstractC13042fc3.i(aVar, "it");
        AbstractC5969Lp4.e().G().f0(bVar.b().c());
        return C19938rB7.a;
    }

    private final int w1(AbstractC6981Pu5 abstractC6981Pu5, MW1 mw1) {
        int fileSize;
        if (mw1 instanceof MW1.a) {
            fileSize = ((MW1.a) mw1).a().f();
        } else {
            if (!(mw1 instanceof MW1.b)) {
                throw new NoWhenBranchMatchedException();
            }
            fileSize = ((MW1.b) mw1).a().b().getFileSize();
        }
        int iW = (int) abstractC6981Pu5.w(fileSize / 1024.0f);
        BubbleTextView bubbleTextView = this.s.g;
        AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
        ViewGroup.LayoutParams layoutParams = bubbleTextView.getLayoutParams();
        int marginEnd = iW + (layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd() : 0);
        BubbleTextView bubbleTextView2 = this.s.g;
        AbstractC13042fc3.h(bubbleTextView2, "textViewProgress");
        ViewGroup.LayoutParams layoutParams2 = bubbleTextView2.getLayoutParams();
        return marginEnd + (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams2).getMarginStart() : 0);
    }

    private final float x1(int i, int i2, int i3, int i4) {
        return Math.min(i / i2, i3 / i4);
    }

    @Override // ir.nasim.C20882sl7
    protected T73 B0() {
        return this.v;
    }

    @Override // ir.nasim.C20882sl7
    protected int C0() {
        return 8;
    }

    public AbstractC17168mW3 C1(AbstractC17757nW1.c cVar, XV4 xv4) {
        AbstractC17168mW3 vg2;
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(xv4, "measuredSize");
        ColorDrawable colorDrawableD1 = D1();
        if (cVar instanceof AbstractC17757nW1.c.b.C1415b) {
            ImageViewCrossFade imageViewCrossFade = this.s.c;
            AbstractC13042fc3.h(imageViewCrossFade, "imageView");
            return new C14031hE1((AbstractC17757nW1.c.b.C1415b) cVar, imageViewCrossFade);
        }
        if (cVar instanceof AbstractC17757nW1.c.b) {
            byte[] bArrE = ((AbstractC17757nW1.c.b) cVar).e();
            ImageViewCrossFade imageViewCrossFade2 = this.s.c;
            AbstractC13042fc3.h(imageViewCrossFade2, "imageView");
            vg2 = new P03(bArrE, imageViewCrossFade2, xv4, colorDrawableD1);
        } else if (cVar instanceof AbstractC17757nW1.c.d.b) {
            byte[] bArrE2 = ((AbstractC17757nW1.c.d.b) cVar).e();
            ImageViewCrossFade imageViewCrossFade3 = this.s.c;
            AbstractC13042fc3.h(imageViewCrossFade3, "imageView");
            vg2 = new ES7(bArrE2, imageViewCrossFade3, xv4, colorDrawableD1);
        } else if (cVar instanceof AbstractC17757nW1.c.d) {
            byte[] bArrE3 = ((AbstractC17757nW1.c.d) cVar).e();
            ImageViewCrossFade imageViewCrossFade4 = this.s.c;
            AbstractC13042fc3.h(imageViewCrossFade4, "imageView");
            vg2 = new C20700sS7(bArrE3, imageViewCrossFade4, xv4, colorDrawableD1);
        } else {
            if (!(cVar instanceof AbstractC17757nW1.c.a)) {
                throw new IllegalStateException();
            }
            byte[] bArrE4 = ((AbstractC17757nW1.c.a) cVar).e();
            ImageViewCrossFade imageViewCrossFade5 = this.s.c;
            AbstractC13042fc3.h(imageViewCrossFade5, "imageView");
            vg2 = new VG2(bArrE4, imageViewCrossFade5, xv4, colorDrawableD1);
        }
        return vg2;
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    /* renamed from: D0 */
    public ConstraintLayout d() {
        return this.r;
    }

    protected final ColorDrawable D1() {
        Context context = x0().getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third));
    }

    @Override // ir.nasim.C20882sl7
    protected C25112zl0 E0() {
        return this.J;
    }

    protected AbstractC6981Pu5 E1(AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(cVar, "document");
        if (cVar instanceof AbstractC17757nW1.c.a) {
            BubbleTextView bubbleTextView = this.s.g;
            AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
            return new UH2(bubbleTextView);
        }
        if (cVar instanceof AbstractC17757nW1.c.b) {
            BubbleTextView bubbleTextView2 = this.s.g;
            AbstractC13042fc3.h(bubbleTextView2, "textViewProgress");
            return new M23(bubbleTextView2);
        }
        if (!(cVar instanceof AbstractC17757nW1.c.d)) {
            throw new IllegalStateException();
        }
        BubbleTextView bubbleTextView3 = this.s.g;
        AbstractC13042fc3.h(bubbleTextView3, "textViewProgress");
        return new C24955zU7(bubbleTextView3, ((AbstractC17757nW1.c.d) cVar).g(), new SA2() { // from class: ir.nasim.m13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19835r13.F1(this.a);
            }
        }, new SA2() { // from class: ir.nasim.n13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19835r13.G1(this.a);
            }
        });
    }

    protected final C22007uW1 H1() {
        return this.w;
    }

    protected final C9263Ze3 J1() {
        return this.s;
    }

    protected final XV4 K1() {
        return this.t;
    }

    protected final AbstractC17168mW3 L1() {
        return this.x;
    }

    protected View M1() {
        ImageViewCrossFade imageViewCrossFade = this.s.c;
        AbstractC13042fc3.h(imageViewCrossFade, "imageView");
        return imageViewCrossFade;
    }

    protected int N1() {
        return this.G;
    }

    protected boolean Q1() {
        return j2() && V1();
    }

    protected int R1(int i) {
        return (i - x0().getRoot().getPaddingLeft()) - x0().getRoot().getPaddingRight();
    }

    protected void U1(AbstractC17757nW1.c cVar, C22007uW1 c22007uW1) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c22007uW1, "documentBinder");
        AbstractC17168mW3 abstractC17168mW3 = this.x;
        if (abstractC17168mW3 != null) {
            c22007uW1.I(abstractC17168mW3);
        }
        AbstractC6981Pu5 abstractC6981Pu5 = this.y;
        if (abstractC6981Pu5 != null) {
            c22007uW1.I(abstractC6981Pu5);
        }
        c22007uW1.I(B1(cVar));
        c22007uW1.I(z1());
        ConstraintLayout root = x0().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        c22007uW1.I(new GX1(root, I1(cVar), null, null, 12, null));
        AbstractC4767Gm.a(c22007uW1, cVar.b(), G0(), cVar.c());
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void a() {
        super.a();
        C22007uW1 c22007uW1 = this.w;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        this.w = null;
        this.z = false;
        this.x = null;
        this.y = null;
        View view = this.H;
        if (view != null) {
            AbstractC12990fW7.L0(view, null);
            this.H = null;
        }
    }

    @Override // ir.nasim.InterfaceC20284rl0, ir.nasim.InterfaceC9437Zx6
    public C8948Xx6 b() {
        View view = this.H;
        if (view != null) {
            return new C8948Xx6(view, new Corners(AbstractC8943Xx1.c(10)));
        }
        return null;
    }

    public void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        aVar.M(this.z);
        aVar.Y(this.z);
        boolean z = false;
        aVar.V(aVar.s() && this.z);
        if (aVar.b() && this.z) {
            z = true;
        }
        aVar.E(z);
    }

    @Override // ir.nasim.InterfaceC9437Zx6
    public void n() {
        final View view = this.H;
        if (view != null) {
            view.post(new Runnable() { // from class: ir.nasim.h13
                @Override // java.lang.Runnable
                public final void run() {
                    C19835r13.T1(view);
                }
            });
        }
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public final void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        super.o(c8967Xz7, xv4, enumC8893Xt7);
        u1(xv4, c8967Xz7);
        Spannable spannableD = c8967Xz7.d();
        if (spannableD == null || spannableD.length() == 0) {
            r1(Q1());
        }
    }

    @Override // ir.nasim.C20882sl7
    public void t0(Spannable spannable) {
        AbstractC13042fc3.i(spannable, "state");
        C9263Ze3 c9263Ze3 = this.s;
        boolean zQ1 = Q1();
        if (zQ1) {
            c9263Ze3.f.r(spannable);
        } else {
            super.t0(spannable);
        }
        MessageStateView messageStateView = c9263Ze3.f;
        AbstractC13042fc3.h(messageStateView, "stateView");
        messageStateView.setVisibility(zQ1 ? 0 : 8);
        MessageStateView messageStateView2 = x0().l;
        AbstractC13042fc3.h(messageStateView2, "textViewState");
        messageStateView2.setVisibility(zQ1 ^ true ? 0 : 8);
    }

    protected void u1(XV4 xv4, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        int iR1 = R1(((Number) xv4.e()).intValue());
        int iIntValue = ((Number) xv4.f()).intValue();
        Object objF = c8967Xz7.f();
        AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.Graphical");
        AbstractC17757nW1.c cVar = (AbstractC17757nW1.c) objF;
        ImageViewCrossFade imageViewCrossFade = null;
        ImageViewCrossFade imageViewCrossFade2 = ((cVar instanceof AbstractC17757nW1.c.b) || (cVar instanceof AbstractC17757nW1.c.a)) ? this.s.c : null;
        if (imageViewCrossFade2 != null) {
            long jI = c8967Xz7.h().i();
            long jH = c8967Xz7.h().h();
            StringBuilder sb = new StringBuilder();
            sb.append(jI);
            sb.append(jH);
            AbstractC12990fW7.L0(imageViewCrossFade2, sb.toString());
            imageViewCrossFade = imageViewCrossFade2;
        }
        this.H = imageViewCrossFade;
        v1(c8967Xz7, cVar, AbstractC4616Fw7.a(Integer.valueOf(iR1), Integer.valueOf(iIntValue)));
        Z0();
    }

    protected final void v1(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar, XV4 xv4) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        this.B = cVar.d();
        this.D = xv4;
        AbstractC6981Pu5 abstractC6981Pu5E1 = E1(cVar);
        this.y = abstractC6981Pu5E1;
        this.G = w1(abstractC6981Pu5E1, cVar.b());
        XV4 xv4O2 = o2();
        this.t = xv4O2;
        this.x = C1(cVar, xv4O2);
        if (cVar instanceof AbstractC17757nW1.c.d.b) {
            s1((AbstractC17757nW1.c.d.b) cVar);
        } else {
            a2(c8967Xz7, cVar);
            i2(c8967Xz7, cVar);
        }
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void w(final View view, final C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        this.A = view;
        this.s.getRoot().postDelayed(new Runnable() { // from class: ir.nasim.o13
            @Override // java.lang.Runnable
            public final void run() {
                C19835r13.W1(this.a, view, c8967Xz7);
            }
        }, 200L);
        super.w(view, c8967Xz7);
    }

    protected C22007uW1 y1(C8967Xz7 c8967Xz7, AbstractC17757nW1.c cVar) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(cVar, "document");
        if (cVar instanceof AbstractC17757nW1.c.d) {
            C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
            AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
            return new SS7(c14970in2D, cVar);
        }
        C14970in2 c14970in2D2 = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D2, "getFilesModule(...)");
        return new C22007uW1(c14970in2D2, cVar, null, 4, null);
    }

    @Override // ir.nasim.C20882sl7, ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.y) {
            N15.y yVar = (N15.y) n15;
            C8967Xz7 c8967Xz7B = yVar.b();
            Object objF = yVar.b().f();
            AbstractC13042fc3.g(objF, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.Graphical");
            a2(c8967Xz7B, (AbstractC17757nW1.c) objF);
            i2(yVar.b(), yVar.c());
        } else if (n15 instanceof N15.j) {
            super.z(n15);
            t0(((N15.j) n15).d());
        } else if (n15 instanceof N15.u) {
            super.z(n15);
            t0(((N15.u) n15).b().r());
        } else if (n15 instanceof N15.p) {
            super.z(n15);
            t0(((N15.p) n15).b().r());
            B0().r();
        } else if (n15 instanceof N15.i) {
            C22007uW1 c22007uW1 = this.w;
            if (c22007uW1 != null) {
                c22007uW1.K(((N15.i) n15).b());
            }
        } else {
            super.z(n15);
        }
        XV4 xv4O2 = o2();
        AbstractC17168mW3 abstractC17168mW3 = this.x;
        if (abstractC17168mW3 != null) {
            abstractC17168mW3.B(xv4O2);
        }
        CharSequence text = x0().i.getText();
        if (text == null || text.length() == 0) {
            r1(Q1());
        }
    }

    public CW1 z1() {
        return new CW1(new SA2() { // from class: ir.nasim.l13
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C19835r13.A1(this.a);
            }
        });
    }
}
