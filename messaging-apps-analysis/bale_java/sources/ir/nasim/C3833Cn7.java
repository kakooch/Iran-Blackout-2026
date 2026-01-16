package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.tgwidgets.editor.ui.stories.recorder.l;
import java.io.IOException;

/* renamed from: ir.nasim.Cn7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3833Cn7 extends AbstractC13141fj5 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final Context i;

    /* renamed from: ir.nasim.Cn7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Cn7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Bitmap c;
        final /* synthetic */ C15481jf3 d;
        final /* synthetic */ ViewGroup e;
        final /* synthetic */ C3833Cn7 f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Bitmap bitmap, C15481jf3 c15481jf3, ViewGroup viewGroup, C3833Cn7 c3833Cn7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bitmap;
            this.d = c15481jf3;
            this.e = viewGroup;
            this.f = c3833Cn7;
            this.g = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws IOException {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(350L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            this.d.getRoot().draw(new Canvas(this.c));
            this.e.removeView(this.d.getRoot());
            String strC = ZP6.a.c(this.f.i, this.c);
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVarS = this.f.s();
            C3833Cn7 c3833Cn7 = this.f;
            Bitmap bitmap = this.c;
            l.c cVarQ = c3833Cn7.q(strC);
            AbstractC13042fc3.f(lVarS);
            c3833Cn7.c(lVarS, bitmap, cVarQ);
            InterfaceC14603iB2 interfaceC14603iB2 = this.g;
            ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVarS2 = this.f.s();
            AbstractC13042fc3.h(lVarS2, "<get-entry>(...)");
            interfaceC14603iB2.invoke(lVarS2, AbstractC6392Nk0.a(false));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3833Cn7(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.i = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(MessageEmojiTextView messageEmojiTextView, SpannableStringBuilder spannableStringBuilder) {
        AbstractC13042fc3.i(messageEmojiTextView, "$this_apply");
        AbstractC13042fc3.i(spannableStringBuilder, "res");
        messageEmojiTextView.setText(spannableStringBuilder);
        return C19938rB7.a;
    }

    public void C(C8967Xz7 c8967Xz7, C15481jf3 c15481jf3, IQ0 iq0, ViewGroup viewGroup) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c15481jf3, "postToStoryBinding");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(viewGroup, "rootView");
        C20882sl7 c20882sl7 = new C20882sl7(c15481jf3, true, RA4.a.a());
        C8967Xz7 c8967Xz7A = c8967Xz7.a((324977 & 1) != 0 ? c8967Xz7.a : null, (324977 & 2) != 0 ? c8967Xz7.b : m(), (324977 & 4) != 0 ? c8967Xz7.c : null, (324977 & 8) != 0 ? c8967Xz7.d : null, (324977 & 16) != 0 ? c8967Xz7.e : null, (324977 & 32) != 0 ? c8967Xz7.f : null, (324977 & 64) != 0 ? c8967Xz7.g : null, (324977 & 128) != 0 ? c8967Xz7.h : c8967Xz7.d(), (324977 & 256) != 0 ? c8967Xz7.i : null, (324977 & 512) != 0 ? c8967Xz7.j : null, (324977 & 1024) != 0 ? c8967Xz7.k : null, (324977 & 2048) != 0 ? c8967Xz7.l : n(this.i, iq0), (324977 & 4096) != 0 ? c8967Xz7.m : null, (324977 & 8192) != 0 ? c8967Xz7.n : null, (324977 & 16384) != 0 ? c8967Xz7.o : null, (324977 & 32768) != 0 ? c8967Xz7.p : null, (324977 & 65536) != 0 ? c8967Xz7.q : null, (324977 & 131072) != 0 ? c8967Xz7.r : true, (324977 & 262144) != 0 ? c8967Xz7.s : false);
        f(c15481jf3, c8967Xz7A);
        InterfaceC20284rl0.h(c20882sl7, c8967Xz7A, new XV4(Integer.valueOf(AbstractC8943Xx1.c(320)), Integer.valueOf(AbstractC8943Xx1.c(v(viewGroup)))), null, 4, null);
        C19938rB7 c19938rB7 = C19938rB7.a;
        final MessageEmojiTextView messageEmojiTextView = c15481jf3.i;
        AbstractC13042fc3.f(messageEmojiTextView);
        Spannable spannableD = c8967Xz7.d();
        if (spannableD == null) {
            spannableD = new SpannableStringBuilder();
        }
        t(messageEmojiTextView, spannableD, 13, new UA2() { // from class: ir.nasim.Bn7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C3833Cn7.D(messageEmojiTextView, (SpannableStringBuilder) obj);
            }
        });
        messageEmojiTextView.setMaxLines(14);
        c15481jf3.getRoot().invalidate();
        BubbleTextView bubbleTextView = c15481jf3.m;
        bubbleTextView.setPadding(AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(8), AbstractC8943Xx1.c(4), AbstractC8943Xx1.c(8));
        Context context = bubbleTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        bubbleTextView.setTextColor(OY0.b(context, AbstractC15199jA5.n500));
        bubbleTextView.setTextSize(16.0f);
        bubbleTextView.setMaxLines(1);
        bubbleTextView.setSingleLine();
        bubbleTextView.setEllipsize(TextUtils.TruncateAt.END);
        bubbleTextView.setMinHeight(AbstractC8943Xx1.c(30));
        c15481jf3.getRoot().invalidate();
    }

    @Override // ir.nasim.AbstractC13141fj5
    public void p(C16731lm1 c16731lm1, C8967Xz7 c8967Xz7, ViewGroup viewGroup, IQ0 iq0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22) {
        AbstractC13042fc3.i(c16731lm1, "contextThemeWrapper");
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(viewGroup, "rootView");
        AbstractC13042fc3.i(iq0, "chatType");
        AbstractC13042fc3.i(interfaceC14603iB2, "onUploadStory");
        AbstractC13042fc3.i(interfaceC14603iB22, "onEdit");
        C15481jf3 c15481jf3L = l(c16731lm1);
        c15481jf3L.getRoot().measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 1073741824));
        C(c8967Xz7, c15481jf3L, iq0, viewGroup);
        ConstraintLayout constraintLayoutB = c15481jf3L.getRoot();
        constraintLayoutB.setVisibility(4);
        viewGroup.addView(constraintLayoutB);
        ZP6 zp6 = ZP6.a;
        ConstraintLayout constraintLayoutB2 = c15481jf3L.getRoot();
        AbstractC13042fc3.h(constraintLayoutB2, "getRoot(...)");
        Bitmap bitmapA = zp6.a(constraintLayoutB2);
        y(c15481jf3L);
        AbstractC10533bm0.d(AbstractC20906so1.a(C12366eV1.c()), null, null, new b(bitmapA, c15481jf3L, viewGroup, this, interfaceC14603iB22, null), 3, null);
    }
}
