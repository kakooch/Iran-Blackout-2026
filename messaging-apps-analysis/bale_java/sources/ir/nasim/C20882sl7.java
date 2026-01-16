package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC14879ie0;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.N15;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import ir.nasim.features.conversation.view.HashtagSpan;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.sl7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20882sl7 implements InterfaceC20284rl0 {
    private static final a p = new a(null);
    public static final int q = 8;
    private final C15481jf3 a;
    private final boolean b;
    private AbstractC23538x54 c;
    private final ConstraintLayout d;
    private final C25112zl0 e;
    private InterfaceC20875sl0 f;
    private final E64 g;
    private final GestureDetector h;
    private final List i;
    private final C23338wl0 j;
    private String k;
    private final InterfaceC9173Yu3 l;
    private final T73 m;
    private EnumC8893Xt7 n;
    private GestureDetector o;

    /* renamed from: ir.nasim.sl7$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sl7$b */
    public static class b implements InterfaceC22152ul0 {
        private final boolean a;
        private AbstractC23538x54 b;

        public b(boolean z, AbstractC23538x54 abstractC23538x54) {
            AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
            this.a = z;
            this.b = abstractC23538x54;
        }

        @Override // ir.nasim.InterfaceC22152ul0
        public final InterfaceC20284rl0 a(ViewStub viewStub) {
            AbstractC13042fc3.i(viewStub, "viewStub");
            viewStub.setLayoutResource(AbstractC12208eD5.item_chat_text_bubble);
            C15481jf3 c15481jf3A = C15481jf3.a(viewStub.inflate());
            AbstractC13042fc3.h(c15481jf3A, "bind(...)");
            return b(c15481jf3A, this.a);
        }

        protected InterfaceC20284rl0 b(C15481jf3 c15481jf3, boolean z) {
            AbstractC13042fc3.i(c15481jf3, "binding");
            return new C20882sl7(c15481jf3, z, this.b);
        }

        protected final AbstractC23538x54 c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.sl7$c */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ C8967Xz7 b;

        c(C8967Xz7 c8967Xz7) {
            this.b = c8967Xz7;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            C20882sl7.this.L0(this.b);
            return true;
        }
    }

    /* renamed from: ir.nasim.sl7$d */
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C20882sl7.this.B0().r();
        }
    }

    public C20882sl7(C15481jf3 c15481jf3, boolean z, AbstractC23538x54 abstractC23538x54) {
        AbstractC13042fc3.i(c15481jf3, "binding");
        AbstractC13042fc3.i(abstractC23538x54, "bubbleClickListener");
        this.a = c15481jf3;
        this.b = z;
        this.c = abstractC23538x54;
        ConstraintLayout constraintLayout = c15481jf3.f;
        AbstractC13042fc3.h(constraintLayout, "layout");
        this.d = constraintLayout;
        ConstraintLayout root = c15481jf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        this.e = new C25112zl0(root);
        E64 e64 = new E64();
        this.g = e64;
        this.h = new GestureDetector(c15481jf3.getRoot().getContext(), e64);
        this.i = new ArrayList();
        C23338wl0 c23338wl0 = new C23338wl0(new UA2() { // from class: ir.nasim.ml7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C20882sl7.u0(this.a, (MotionEvent) obj));
            }
        }, this.c.e());
        this.j = c23338wl0;
        this.l = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.nl7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20882sl7.W(this.a);
            }
        });
        this.m = H0();
        W0(z);
        V0();
        c15481jf3.m.setTypeface(C6011Lu2.i());
        c15481jf3.i.setMovementMethod(c23338wl0);
        c15481jf3.l.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final C21569tl7 H0() {
        return (C21569tl7) this.l.getValue();
    }

    private final boolean I0(String str) {
        int iD = JF5.d(str);
        return iD == 1 || iD == 3;
    }

    private final boolean K0(ViewStub viewStub) {
        return viewStub.getInflatedId() != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void L0(C8967Xz7 c8967Xz7) {
        if (this instanceof O44) {
            ((O44) this).j(c8967Xz7.c());
        }
        InterfaceC22948w54 interfaceC22948w54B = this.c.b();
        MessageEmojiTextView messageEmojiTextView = this.a.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        interfaceC22948w54B.e(messageEmojiTextView, c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M0(XV4 xv4, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(xv4, "$action");
        AbstractC13042fc3.i(view, "<unused var>");
        ((SA2) xv4.f()).invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        InterfaceC22948w54 interfaceC22948w54B = c20882sl7.c.b();
        ConstraintLayout root = c20882sl7.a.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        interfaceC22948w54B.e(root, c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, C4602Fv2 c4602Fv2, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(c4602Fv2, "$it");
        AbstractC13042fc3.i(view, "<unused var>");
        c20882sl7.c.b().p(c8967Xz7, c4602Fv2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "<unused var>");
        c20882sl7.c.b().b(c8967Xz7.j(), (C17532n74) c8967Xz7.i().e());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 T0(C20882sl7 c20882sl7, String str) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(str, "it");
        c20882sl7.c.b().q(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U0(C20882sl7 c20882sl7, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        GestureDetector gestureDetector = c20882sl7.o;
        if (gestureDetector == null) {
            return false;
        }
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    private final void V0() {
        C15481jf3 c15481jf3 = this.a;
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.d());
        c15481jf3.m.setTextSize(c3335Al0.u());
        c15481jf3.j.setTextSize(c3335Al0.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C21569tl7 W(C20882sl7 c20882sl7) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        C15481jf3 c15481jf3 = c20882sl7.a;
        MessageReactionView messageReactionView = c15481jf3.k;
        AbstractC13042fc3.h(messageReactionView, "textViewReactions");
        MessageStateView messageStateView = c15481jf3.l;
        AbstractC13042fc3.h(messageStateView, "textViewState");
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        CommentContainerView commentContainerView = c15481jf3.e;
        AbstractC13042fc3.h(commentContainerView, "commentContainer");
        return new C21569tl7(messageReactionView, messageStateView, messageEmojiTextView, commentContainerView);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Y0() {
        /*
            r4 = this;
            ir.nasim.jf3 r0 = r4.a
            ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView r1 = r0.i
            java.lang.String r2 = "textViewBody"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L4c
            android.view.ViewStub r1 = r0.g
            java.lang.String r3 = "mainViewStub"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            boolean r1 = r4.K0(r1)
            if (r1 == 0) goto L22
            int r2 = r4.C0()
            goto L4c
        L22:
            ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView r1 = r0.h
            java.lang.String r3 = "replyView"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L30
            goto L4c
        L30:
            ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView r1 = r0.m
            java.lang.String r3 = "textViewUsername"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L3e
            goto L4b
        L3e:
            ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView r1 = r0.j
            java.lang.String r3 = "textViewForward"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L4c
        L4b:
            r2 = 6
        L4c:
            androidx.constraintlayout.widget.Barrier r0 = r0.b
            r0.setDpMargin(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20882sl7.Y0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, String str) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(str, "it");
        c20882sl7.c.b().n(c8967Xz7, str);
        return C19938rB7.a;
    }

    private final void a0(final C8967Xz7 c8967Xz7) {
        this.j.i(new AbstractC14879ie0.d() { // from class: ir.nasim.bl7
            @Override // ir.nasim.AbstractC14879ie0.d
            public final boolean a(TextView textView, String str) {
                return C20882sl7.b0(this.a, c8967Xz7, textView, str);
            }
        });
        this.j.j(new AbstractC14879ie0.e() { // from class: ir.nasim.cl7
            @Override // ir.nasim.AbstractC14879ie0.e
            public final boolean a(TextView textView, String str) {
                return C20882sl7.c0(this.a, c8967Xz7, textView, str);
            }
        });
        this.g.c(new SA2() { // from class: ir.nasim.dl7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C20882sl7.d0(this.a, c8967Xz7));
            }
        });
        this.g.e(new SA2() { // from class: ir.nasim.el7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20882sl7.e0(this.a, c8967Xz7);
            }
        });
        this.g.d(new SA2() { // from class: ir.nasim.fl7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Boolean.valueOf(C20882sl7.f0(this.a, c8967Xz7));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, TextView textView, String str) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        InterfaceC22948w54 interfaceC22948w54B = c20882sl7.c.b();
        AbstractC13042fc3.f(str);
        return interfaceC22948w54B.h(c8967Xz7, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, TextView textView, String str) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        return c20882sl7.c.b().m(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c20882sl7.L0(c8967Xz7);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c20882sl7.c.b().m(c8967Xz7);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        InterfaceC22948w54 interfaceC22948w54B = c20882sl7.c.b();
        MessageEmojiTextView messageEmojiTextView = c20882sl7.a.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        return interfaceC22948w54B.j(messageEmojiTextView, c8967Xz7, c20882sl7.k);
    }

    private final void g0(final C8967Xz7 c8967Xz7) {
        XV4 xv4I = c8967Xz7.i();
        if ((xv4I != null ? (C17532n74) xv4I.e() : null) != null) {
            this.a.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rl7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C20882sl7.h0(this.a, c8967Xz7, view);
                }
            });
            this.a.e.C((Spannable) xv4I.f(), ((C17532n74) xv4I.e()).G(), ((C17532n74) xv4I.e()).F());
        } else {
            CommentContainerView commentContainerView = this.a.e;
            AbstractC13042fc3.h(commentContainerView, "commentContainer");
            commentContainerView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c20882sl7.c.b().b(c8967Xz7.j(), (C17532n74) c8967Xz7.i().e());
    }

    private final void j0(final C8967Xz7 c8967Xz7, final C4602Fv2 c4602Fv2) {
        MessageEmojiTextView messageEmojiTextView = this.a.j;
        messageEmojiTextView.r(c4602Fv2 != null ? c4602Fv2.b() : null);
        messageEmojiTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ol7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20882sl7.k0(c4602Fv2, this, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(C4602Fv2 c4602Fv2, C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        if (c4602Fv2 != null) {
            c20882sl7.c.b().p(c8967Xz7, c4602Fv2);
        }
    }

    private final void l0(C8967Xz7 c8967Xz7, Spannable spannable) {
        MessageReactionView messageReactionView = this.a.k;
        messageReactionView.r(spannable);
        a0(c8967Xz7);
        this.k = c8967Xz7.k();
        messageReactionView.setMovementMethod(defpackage.x.d.a(new UA2() { // from class: ir.nasim.ll7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20882sl7.m0((MotionEvent) obj);
            }
        }));
        MessageEmojiTextView messageEmojiTextView = this.a.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        n0(c8967Xz7, spannable, messageEmojiTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m0(MotionEvent motionEvent) {
        AbstractC13042fc3.i(motionEvent, "it");
        AbstractC5770Kt3.b(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
        return C19938rB7.a;
    }

    private final void n0(final C8967Xz7 c8967Xz7, Spannable spannable, final View view) {
        if (spannable != null) {
            MG5[] mg5Arr = (MG5[]) spannable.getSpans(0, spannable.length(), MG5.class);
            if (mg5Arr != null) {
                for (MG5 mg5 : mg5Arr) {
                    mg5.b(new InterfaceC14603iB2() { // from class: ir.nasim.il7
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return C20882sl7.o0(this.a, c8967Xz7, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                    mg5.c(new InterfaceC14603iB2() { // from class: ir.nasim.jl7
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return C20882sl7.p0(this.a, c8967Xz7, view, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, String str, boolean z) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(str, "reactionCode");
        c20882sl7.c.b().t(c8967Xz7, str, z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view, String str, boolean z) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(view, "$anchor");
        AbstractC13042fc3.i(str, "reactionCode");
        c20882sl7.c.b().g(c8967Xz7, str, view);
        return C19938rB7.a;
    }

    private final void q0(final C8967Xz7 c8967Xz7, PO5 po5) {
        MessageReplyView messageReplyView = this.a.h;
        messageReplyView.d0(po5);
        Y0();
        messageReplyView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Wk7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20882sl7.r0(this.a, c8967Xz7, view);
            }
        });
        messageReplyView.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.hl7
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return C20882sl7.s0(this.a, c8967Xz7, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        c20882sl7.c.b().s(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s0(C20882sl7 c20882sl7, C8967Xz7 c8967Xz7, View view) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        return c20882sl7.c.b().m(c8967Xz7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u0(C20882sl7 c20882sl7, MotionEvent motionEvent) {
        AbstractC13042fc3.i(c20882sl7, "this$0");
        AbstractC13042fc3.i(motionEvent, "event");
        AbstractC5770Kt3.b(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
        return c20882sl7.h.onTouchEvent(motionEvent);
    }

    private final void v0(final TextView textView) {
        CharSequence text = textView.getText();
        if (text instanceof Spanned) {
            this.i.clear();
            Spanned spanned = (Spanned) text;
            Object[] spans = spanned.getSpans(0, spanned.length(), ClickableSpan.class);
            AbstractC13042fc3.h(spans, "getSpans(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : spans) {
                final ClickableSpan clickableSpan = (ClickableSpan) obj;
                XV4 xv4 = new XV4(spanned.subSequence(spanned.getSpanStart(clickableSpan), spanned.getSpanEnd(clickableSpan)).toString(), new SA2() { // from class: ir.nasim.gl7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20882sl7.w0(clickableSpan, textView);
                    }
                });
                this.i.add(xv4);
                arrayList.add(xv4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w0(ClickableSpan clickableSpan, TextView textView) {
        AbstractC13042fc3.i(textView, "$textView");
        clickableSpan.onClick(textView);
        return C19938rB7.a;
    }

    protected final E64 A0() {
        return this.g;
    }

    protected T73 B0() {
        return this.m;
    }

    protected int C0() {
        return 0;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout d() {
        return this.d;
    }

    protected C25112zl0 E0() {
        return this.e;
    }

    protected Spannable F0(C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        return c8967Xz7.d();
    }

    protected final EnumC8893Xt7 G0() {
        return this.n;
    }

    protected final boolean J0() {
        return this.b;
    }

    protected final View Q0(int i) {
        ViewStub viewStub = this.a.c;
        viewStub.setLayoutResource(i);
        viewStub.setInflatedId(viewStub.getId());
        View viewInflate = viewStub.inflate();
        AbstractC13042fc3.h(viewInflate, "run(...)");
        return viewInflate;
    }

    protected final View R0(int i) {
        ViewStub viewStub = this.a.g;
        viewStub.setLayoutResource(i);
        viewStub.setInflatedId(viewStub.getId());
        View viewInflate = viewStub.inflate();
        AbstractC13042fc3.h(viewInflate, "run(...)");
        return viewInflate;
    }

    public final void S0(boolean z, C8967Xz7 c8967Xz7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        MessageEmojiTextView messageEmojiTextView = this.a.i;
        messageEmojiTextView.setTextIsSelectable(z);
        if (z) {
            MessageEmojiTextView messageEmojiTextView2 = this.a.i;
            AbstractC13042fc3.h(messageEmojiTextView2, "textViewBody");
            ActionModeCallbackC6761Ow1 actionModeCallbackC6761Ow1 = new ActionModeCallbackC6761Ow1(messageEmojiTextView2, new UA2() { // from class: ir.nasim.pl7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C20882sl7.T0(this.a, (String) obj);
                }
            });
            messageEmojiTextView.setCustomSelectionActionModeCallback(actionModeCallbackC6761Ow1);
            messageEmojiTextView.setCustomInsertionActionModeCallback(actionModeCallbackC6761Ow1);
            this.o = new GestureDetector(messageEmojiTextView.getContext(), new c(c8967Xz7));
            messageEmojiTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.ql7
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return C20882sl7.U0(this.a, view, motionEvent);
                }
            });
            Context context = this.a.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            messageEmojiTextView.setHighlightColor(QY0.k(OY0.b(context, AbstractC21139tA5.a09), 100));
            return;
        }
        messageEmojiTextView.setCustomSelectionActionModeCallback(null);
        messageEmojiTextView.setCustomInsertionActionModeCallback(null);
        messageEmojiTextView.setMovementMethod(this.j);
        messageEmojiTextView.setOnTouchListener(null);
        this.o = null;
        Y(c8967Xz7, F0(c8967Xz7));
        AbstractC13042fc3.f(messageEmojiTextView);
        if (!messageEmojiTextView.isLaidOut() || messageEmojiTextView.isLayoutRequested()) {
            messageEmojiTextView.addOnLayoutChangeListener(new d());
        } else {
            B0().r();
        }
    }

    protected void W0(boolean z) {
        ConstraintLayout constraintLayout = this.a.f;
        if (z) {
            constraintLayout.setBackgroundResource(KB5.bubble_in);
        } else {
            constraintLayout.setBackgroundResource(KB5.bubble_out);
        }
    }

    protected void X0(XV4 xv4) {
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        B0().s((((Number) xv4.e()).intValue() - this.a.getRoot().getPaddingLeft()) - this.a.getRoot().getPaddingRight());
    }

    protected final void Y(final C8967Xz7 c8967Xz7, Spannable spannable) {
        HashtagSpan[] hashtagSpanArr;
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        MessageEmojiTextView messageEmojiTextView = this.a.i;
        messageEmojiTextView.r(spannable);
        a0(c8967Xz7);
        if (spannable != null && (hashtagSpanArr = (HashtagSpan[]) spannable.getSpans(0, spannable.length(), HashtagSpan.class)) != null && hashtagSpanArr.length > 0) {
            HashtagSpan hashtagSpan = hashtagSpanArr[0];
            new UA2() { // from class: ir.nasim.kl7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C20882sl7.Z(this.a, c8967Xz7, (String) obj);
                }
            };
            throw null;
        }
        AbstractC13042fc3.f(messageEmojiTextView);
        ViewGroup.LayoutParams layoutParams = messageEmojiTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.F = I0(messageEmojiTextView.getText().toString()) == JF5.g() ? 0.0f : 1.0f;
        messageEmojiTextView.setLayoutParams(layoutParams2);
        Y0();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Z0() {
        /*
            r5 = this;
            ir.nasim.jf3 r0 = r5.a
            android.view.ViewStub r1 = r0.g
            java.lang.String r2 = "mainViewStub"
            ir.nasim.AbstractC13042fc3.h(r1, r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            if (r2 == 0) goto L39
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView r3 = r0.m
            java.lang.String r4 = "textViewUsername"
            ir.nasim.AbstractC13042fc3.h(r3, r4)
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L1f
            goto L2c
        L1f:
            ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView r0 = r0.j
            java.lang.String r3 = "textViewForward"
            ir.nasim.AbstractC13042fc3.h(r0, r3)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L32
        L2c:
            r0 = 6
            int r0 = ir.nasim.AbstractC8943Xx1.c(r0)
            goto L33
        L32:
            r0 = 0
        L33:
            r2.topMargin = r0
            r1.setLayoutParams(r2)
            return
        L39:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C20882sl7.Z0():void");
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void a() {
        B0().t();
        this.a.k.setMovementMethod(null);
        this.k = null;
        this.o = null;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void i() {
        this.a.i.invalidate();
        this.a.k.invalidate();
        this.a.h.f0();
    }

    protected final void i0(String str) {
        AbstractC13042fc3.i(str, "contentDescription");
        this.a.f.setContentDescription(str);
    }

    @Override // ir.nasim.InterfaceC7879To6
    public Rect l() {
        return E0().a();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void o(C8967Xz7 c8967Xz7, XV4 xv4, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(xv4, "maxAvailableSpace");
        C15481jf3 c15481jf3 = this.a;
        this.n = enumC8893Xt7;
        X0(xv4);
        c15481jf3.m.r(c8967Xz7.o());
        Y(c8967Xz7, c8967Xz7.d());
        l0(c8967Xz7, c8967Xz7.l());
        j0(c8967Xz7, c8967Xz7.g());
        q0(c8967Xz7, c8967Xz7.m());
        t0(c8967Xz7.r());
        i0(c8967Xz7.e());
        Z0();
        g0(c8967Xz7);
        B0().r();
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void t(InterfaceC20875sl0 interfaceC20875sl0) {
        AbstractC13042fc3.i(interfaceC20875sl0, "listener");
        this.f = interfaceC20875sl0;
    }

    public void t0(Spannable spannable) {
        AbstractC13042fc3.i(spannable, "state");
        this.a.l.r(spannable);
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void w(View view, final C8967Xz7 c8967Xz7) {
        String string;
        AbstractC13042fc3.i(view, "accessibleView");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        MessageEmojiTextView messageEmojiTextView = this.a.i;
        AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
        v0(messageEmojiTextView);
        for (final XV4 xv4 : this.i) {
            AbstractC12990fW7.c(view, (CharSequence) xv4.e(), new InterfaceC10698c3() { // from class: ir.nasim.Xk7
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C20882sl7.M0(xv4, view2, aVar);
                }
            });
        }
        AbstractC12990fW7.c(view, this.a.getRoot().getContext().getString(AbstractC12217eE5.message_options_context_menu), new InterfaceC10698c3() { // from class: ir.nasim.Yk7
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                return C20882sl7.N0(this.a, c8967Xz7, view2, aVar);
            }
        });
        final C4602Fv2 c4602Fv2G = c8967Xz7.g();
        if (c4602Fv2G != null) {
            C4602Fv2 c4602Fv2G2 = c8967Xz7.g();
            AbstractC12990fW7.c(view, String.valueOf(c4602Fv2G2 != null ? c4602Fv2G2.b() : null), new InterfaceC10698c3() { // from class: ir.nasim.Zk7
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C20882sl7.O0(this.a, c8967Xz7, c4602Fv2G, view2, aVar);
                }
            });
        }
        XV4 xv4I = c8967Xz7.i();
        if ((xv4I != null ? (C17532n74) xv4I.e() : null) != null) {
            if (((C17532n74) c8967Xz7.i().e()).E() > 0) {
                string = XY6.v(String.valueOf(((C17532n74) c8967Xz7.i().e()).E())) + Separators.SP + view.getContext().getString(AbstractC12217eE5.comment);
            } else {
                string = view.getContext().getString(AbstractC12217eE5.leave_comment);
                AbstractC13042fc3.f(string);
            }
            this.a.e.setContentDescription(string);
            AbstractC12990fW7.c(view, string, new InterfaceC10698c3() { // from class: ir.nasim.al7
                @Override // ir.nasim.InterfaceC10698c3
                public final boolean a(View view2, InterfaceC10698c3.a aVar) {
                    return C20882sl7.P0(this.a, c8967Xz7, view2, aVar);
                }
            });
        }
    }

    public final C15481jf3 x0() {
        return this.a;
    }

    public final C23338wl0 y0() {
        return this.j;
    }

    @Override // ir.nasim.InterfaceC20284rl0
    public void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (n15 instanceof N15.l) {
            N15.l lVar = (N15.l) n15;
            j0(lVar.c(), lVar.b());
            return;
        }
        if (n15 instanceof N15.v) {
            N15.v vVar = (N15.v) n15;
            t0(vVar.c());
            C8967Xz7 c8967Xz7B = vVar.b();
            CharSequence text = this.a.k.getText();
            Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
            MessageEmojiTextView messageEmojiTextView = this.a.i;
            AbstractC13042fc3.h(messageEmojiTextView, "textViewBody");
            n0(c8967Xz7B, spannable, messageEmojiTextView);
            B0().r();
            return;
        }
        if (n15 instanceof N15.u) {
            this.a.m.r(((N15.u) n15).b().o());
            Y0();
            B0().r();
            return;
        }
        if (n15 instanceof N15.j) {
            N15.j jVar = (N15.j) n15;
            Y(jVar.c(), jVar.b());
            B0().r();
            return;
        }
        if (n15 instanceof N15.p) {
            N15.p pVar = (N15.p) n15;
            l0(pVar.b(), pVar.c());
            B0().r();
            return;
        }
        if (n15 instanceof N15.s) {
            N15.s sVar = (N15.s) n15;
            q0(sVar.b(), sVar.b().m());
            return;
        }
        if (n15 instanceof N15.g) {
            i0(((N15.g) n15).b());
            return;
        }
        if (n15 instanceof N15.r) {
            g0(((N15.r) n15).b());
            B0().r();
            return;
        }
        C19406qI3.a("TextBubble", "Unknown payload case encountered for " + n15.getClass().getSimpleName() + "!", new Object[0]);
    }

    protected final AbstractC23538x54 z0() {
        return this.c;
    }
}
