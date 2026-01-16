package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.AbstractC22608vX3;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.X2;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class AT7 extends AbstractC22608vX3 {

    public static final class a extends AbstractC22608vX3.b {
        private final InterfaceC16733lm3 a = C0264a.a;

        /* renamed from: ir.nasim.AT7$a$a, reason: collision with other inner class name */
        /* synthetic */ class C0264a extends EB2 implements InterfaceC14603iB2 {
            public static final C0264a a = new C0264a();

            C0264a() {
                super(2, AT7.class, "<init>", "<init>(Lir/nasim/databinding/ItemChatImageBubbleBinding;Lir/nasim/features/conversation/messages/content/adapter/holder/bubble/album/AlbumClickListener;)V", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final AT7 invoke(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
                AbstractC13042fc3.i(c9263Ze3, "p0");
                AbstractC13042fc3.i(interfaceC11285cl, "p1");
                return new AT7(c9263Ze3, interfaceC11285cl, null);
            }
        }

        @Override // ir.nasim.AbstractC22608vX3.b
        public /* bridge */ /* synthetic */ InterfaceC14603iB2 b() {
            return (InterfaceC14603iB2) c();
        }

        public InterfaceC16733lm3 c() {
            return this.a;
        }
    }

    public /* synthetic */ AT7(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl, ED1 ed1) {
        this(c9263Ze3, interfaceC11285cl);
    }

    private final void M(int i) {
        BubbleTextView bubbleTextView = D().g;
        String strV = XY6.v(C17959nq7.a.a(i));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        spannableStringBuilder.append((CharSequence) strV);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(8));
        Context context = bubbleTextView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AbstractC17636nI6.h(spannableStringBuilder, OY0.b(context, AbstractC21139tA5.bubble_background_icon), 0, 0, 0, 14, null);
        bubbleTextView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    private final String N(Context context, long j) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long hours = timeUnit.toHours(j);
        long j2 = 60;
        long minutes = timeUnit.toMinutes(j) % j2;
        long seconds = timeUnit.toSeconds(j) % j2;
        if (hours != 0) {
            String string = context.getString(AbstractC12217eE5.time_duration_hours_minutes_seconds, Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds));
            AbstractC13042fc3.f(string);
            return string;
        }
        if (minutes != 0) {
            String string2 = context.getString(AbstractC12217eE5.time_duration_minutes_seconds, Long.valueOf(minutes), Long.valueOf(seconds));
            AbstractC13042fc3.f(string2);
            return string2;
        }
        String string3 = context.getString(AbstractC12217eE5.time_duration_seconds, Long.valueOf(seconds));
        AbstractC13042fc3.f(string3);
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final AT7 at7) {
        AbstractC13042fc3.i(at7, "this$0");
        String string = at7.p().getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description);
        AbstractC13042fc3.h(string, "getString(...)");
        ConstraintLayout root = at7.D().getRoot();
        X2.a aVar = X2.a.i;
        AbstractC12990fW7.l0(root, aVar, at7.p().getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.xT7
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar2) {
                return AT7.P(this.a, view, aVar2);
            }
        });
        AbstractC12990fW7.l0(at7.D().getRoot(), X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.yT7
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar2) {
                return AT7.Q(this.a, view, aVar2);
            }
        });
        AbstractC12990fW7.l0(at7.D().b, aVar, at7.p().getContext().getString(AbstractC12217eE5.message_options_activate), new InterfaceC10698c3() { // from class: ir.nasim.zT7
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar2) {
                return AT7.R(this.a, view, aVar2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(AT7 at7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(at7, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        at7.D().b.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q(AT7 at7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(at7, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        at7.D().b.performLongClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R(AT7 at7, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(at7, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        at7.D().b.performClick();
        return true;
    }

    @Override // ir.nasim.AbstractC22608vX3
    protected void C(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        super.C(c14339hl);
        BubbleTextView bubbleTextView = D().g;
        AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
        bubbleTextView.setVisibility(c14339hl.e() == null ? 0 : 8);
    }

    @Override // ir.nasim.AbstractC20283rl
    protected LW1 l(InterfaceC23783xW1 interfaceC23783xW1, EnumC8893Xt7 enumC8893Xt7) {
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
        ImageViewCrossFade imageViewCrossFade = D().c;
        AbstractC13042fc3.h(imageViewCrossFade, "imageView");
        BubbleTextView bubbleTextView = D().g;
        AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
        DocumentStateButton documentStateButton = D().b;
        AbstractC13042fc3.h(documentStateButton, "documentStateButton");
        return new C16563lU7(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void r() {
        p().setImportantForAccessibility(1);
        D().getRoot().postDelayed(new Runnable() { // from class: ir.nasim.wT7
            @Override // java.lang.Runnable
            public final void run() {
                AT7.O(this.a);
            }
        }, 200L);
    }

    @Override // ir.nasim.AbstractC22608vX3
    public void y(C14339hl c14339hl, C17177mX3 c17177mX3, String str) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(c17177mX3, "extras");
        AbstractC13042fc3.i(str, "contentDescription");
        AbstractC17757nW1 abstractC17757nW1C = c14339hl.c();
        AbstractC13042fc3.g(abstractC17757nW1C, "null cannot be cast to non-null type ir.nasim.features.conversation.messages.content.data.Document.Graphical.Video");
        int iG = ((AbstractC17757nW1.c.d) abstractC17757nW1C).g();
        Context context = p().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        super.y(c14339hl, c17177mX3, str + Separators.SP + N(context, iG));
        D().b.setImportantForAccessibility(1);
        D().b.setContentDescription(p().getContext().getString(AbstractC12217eE5.video_play_content_description));
        M(iG);
    }

    private AT7(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
        super(c9263Ze3, interfaceC11285cl);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void s() {
    }
}
