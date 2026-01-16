package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C24020xu2;
import ir.nasim.GM3;
import ir.nasim.M44;
import ir.nasim.PO5;
import ir.nasim.S53;
import ir.nasim.XM4;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.zu2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25204zu2 {
    private static final b c = new b(null);
    public static final int d = 8;
    private static final EW7 e = new a();
    private static final AbstractC23538x54 f = RA4.a.a();
    private final C11407cx2 a;
    private final UA2 b;

    /* renamed from: ir.nasim.zu2$a */
    public static final class a implements EW7 {
        a() {
        }
    }

    /* renamed from: ir.nasim.zu2$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.zu2$c */
    public static final class c extends AbstractC17457n0 {
        c() {
        }

        @Override // ir.nasim.InterfaceC25103zk1
        public String b(Context context, int i, String str, boolean z) {
            AbstractC13042fc3.i(context, "context");
            return InterfaceC25103zk1.a.a(context);
        }

        @Override // ir.nasim.AbstractC17457n0
        public C23345wl7 l() {
            throw new IllegalStateException();
        }
    }

    public C25204zu2(C11407cx2 c11407cx2, UA2 ua2) {
        AbstractC13042fc3.i(c11407cx2, "binding");
        AbstractC13042fc3.i(ua2, "updateTickMark");
        this.a = c11407cx2;
        this.b = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(C25204zu2 c25204zu2, C15481jf3 c15481jf3, C15481jf3 c15481jf32, int i) {
        AbstractC13042fc3.i(c25204zu2, "this$0");
        AbstractC13042fc3.i(c15481jf3, "$incomingBinding");
        AbstractC13042fc3.i(c15481jf32, "$outgoingBinding");
        c25204zu2.b.invoke(Integer.valueOf(i));
        MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        C3335Al0 c3335Al0 = C3335Al0.a;
        messageEmojiTextView.setTextSize(c3335Al0.d());
        c15481jf3.m.setTextSize(c3335Al0.u());
        c15481jf3.j.setTextSize(c3335Al0.k());
        c15481jf32.i.setTextSize(c3335Al0.d());
        c15481jf32.m.setTextSize(c3335Al0.u());
        c15481jf32.j.setTextSize(c3335Al0.k());
        c15481jf32.h.setTextSizes();
        return C19938rB7.a;
    }

    private final C15481jf3 e(C11407cx2 c11407cx2, J44 j44) {
        JW7 jw7 = new JW7(EnumC9782aY7.b, true, false, false, false, 28, null);
        boolean zF = jw7.f();
        AbstractC23538x54 abstractC23538x54 = f;
        C24020xu2.a aVar = new C24020xu2.a(zF, abstractC23538x54);
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(c11407cx2.getRoot().getContext()).cloneInContext(new ContextThemeWrapper(c11407cx2.getRoot().getContext(), AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming));
        S53.a aVar2 = S53.K0;
        LinearLayout root = c11407cx2.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        AbstractC13042fc3.f(layoutInflaterCloneInContext);
        P64 p64A = aVar2.a(root, layoutInflaterCloneInContext, aVar, false, false, abstractC23538x54.b(), jw7.a(), e, false, jw7, null, false);
        p64A.a.setId(View.generateViewId());
        ConstraintLayout constraintLayout = c11407cx2.b;
        View view = p64A.a;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = AbstractC8943Xx1.c(16);
        layoutParams.h = 0;
        layoutParams.d = 0;
        C19938rB7 c19938rB7 = C19938rB7.a;
        constraintLayout.addView(view, layoutParams);
        Context context = p64A.a.getContext();
        AbstractC13042fc3.f(context);
        p64A.p1(h(context, j44, k(c11407cx2, AbstractC12217eE5.message_text_in_sample), OY0.b(context, AbstractC21139tA5.bubble_low_text), OY0.b(context, AbstractC21139tA5.colorSuccess), AbstractC17636nI6.i(k(c11407cx2, AbstractC12217eE5.message_text_sender_sample)), null, false), null, false, false, false, abstractC23538x54);
        C15481jf3 c15481jf3A = C15481jf3.a(p64A.a.findViewById(BC5.bubbleStub));
        AbstractC13042fc3.h(c15481jf3A, "bind(...)");
        return c15481jf3A;
    }

    private final C15481jf3 f(C11407cx2 c11407cx2, J44 j44, int i) {
        JW7 jw7 = new JW7(EnumC9782aY7.b, false, false, false, false, 28, null);
        boolean zF = jw7.f();
        AbstractC23538x54 abstractC23538x54 = f;
        C24020xu2.a aVar = new C24020xu2.a(zF, abstractC23538x54);
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(c11407cx2.getRoot().getContext()).cloneInContext(new ContextThemeWrapper(c11407cx2.getRoot().getContext(), AbstractC23035wE5.Theme_Bale_BubbleTheme_Outgoing));
        XM4.a aVar2 = XM4.G0;
        LinearLayout root = c11407cx2.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        AbstractC13042fc3.f(layoutInflaterCloneInContext);
        P64 p64A = aVar2.a(root, layoutInflaterCloneInContext, aVar, abstractC23538x54.b(), e, null, jw7.a());
        ConstraintLayout constraintLayout = c11407cx2.b;
        View view = p64A.a;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = AbstractC8943Xx1.c(16);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AbstractC8943Xx1.c(10);
        layoutParams.g = 0;
        layoutParams.i = i;
        C19938rB7 c19938rB7 = C19938rB7.a;
        constraintLayout.addView(view, layoutParams);
        Context context = p64A.a.getContext();
        AbstractC13042fc3.f(context);
        p64A.p1(h(context, j44, k(c11407cx2, AbstractC12217eE5.message_text_out_sample), OY0.b(context, AbstractC21139tA5.bubble_low_text), OY0.b(context, AbstractC21139tA5.colorSuccess), null, new PO5.d(null, AbstractC17636nI6.i(k(c11407cx2, AbstractC12217eE5.message_text_sender_sample)), AbstractC17636nI6.i(k(c11407cx2, AbstractC12217eE5.message_text_in_sample))), true), null, false, false, false, abstractC23538x54);
        C15481jf3 c15481jf3A = C15481jf3.a(p64A.a.findViewById(BC5.bubbleStub));
        AbstractC13042fc3.h(c15481jf3A, "bind(...)");
        return c15481jf3A;
    }

    private final C8967Xz7 h(Context context, J44 j44, String str, int i, int i2, Spannable spannable, PO5 po5, boolean z) {
        return new C8967Xz7(new Q64(-1L, -1L), j(context, i, i2, z), null, po5, new M44.a(), j44, null, AbstractC17636nI6.i(str), null, null, null, spannable, null, "", null, GM3.a.b, null, false, false, 475136, null);
    }

    private final AbstractC17457n0 i() {
        return new c();
    }

    private final Spannable j(Context context, int i, int i2, boolean z) {
        return K74.c.a(context, 29000000L, z ? LA7.d : null, false, null, false, i, C5495Jo7.a.B2(), i2, (512 & 512) != 0 ? null : null, null, false, null, false);
    }

    private final String k(C11407cx2 c11407cx2, int i) {
        String string = c11407cx2.getRoot().getContext().getString(i);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List l() {
        return AbstractC10360bX0.p(Float.valueOf(12.0f), Float.valueOf(13.0f), Float.valueOf(14.0f), Float.valueOf(19.0f), Float.valueOf(24.0f));
    }

    private final void m(SeekBar seekBar, UA2 ua2) {
        seekBar.setMax(4);
        Iterator it = l().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((Number) it.next()).floatValue() == C3335Al0.a.o()) {
                break;
            } else {
                i++;
            }
        }
        seekBar.setProgress(i);
        seekBar.setOnSeekBarChangeListener(new d(ua2));
    }

    public final void c() {
        C11407cx2 c11407cx2 = this.a;
        J44 j44 = new J44(-1L, -1L, -1L, -1, EnumC23558x74.SENT, i(), null, 0, null, null, 0L, null, null, false, null, null, false, null, null, 524224, null);
        final C15481jf3 c15481jf3E = e(this.a, j44);
        C11407cx2 c11407cx22 = this.a;
        ConstraintLayout constraintLayout = c11407cx2.b;
        AbstractC13042fc3.h(constraintLayout, io.appmetrica.analytics.impl.G2.g);
        final C15481jf3 c15481jf3F = f(c11407cx22, j44, ((View) AbstractC11342cq6.u(AbstractC24379yW7.b(constraintLayout))).getId());
        SeekBar seekBar = c11407cx2.u;
        AbstractC13042fc3.h(seekBar, "messageTextSizeSeekBar");
        m(seekBar, new UA2() { // from class: ir.nasim.yu2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C25204zu2.d(this.a, c15481jf3E, c15481jf3F, ((Integer) obj).intValue());
            }
        });
    }

    public final void g(float f2) {
        C7183Qq.s().putInt("message_text_size", (int) f2);
        C3335Al0.a.v(Float.valueOf(f2));
        C20837sh2.a.d(Float.valueOf(f2));
    }

    /* renamed from: ir.nasim.zu2$d */
    public static final class d implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ UA2 b;

        d(UA2 ua2) {
            this.b = ua2;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                C25204zu2.this.g(((Number) C25204zu2.this.l().get(i)).floatValue());
                this.b.invoke(Integer.valueOf(i));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
