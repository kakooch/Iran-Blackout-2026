package ir.nasim;

import android.view.View;
import ir.nasim.AbstractC22608vX3;
import ir.nasim.InterfaceC10698c3;
import ir.nasim.X2;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* renamed from: ir.nasim.c23, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10692c23 extends AbstractC22608vX3 {

    /* renamed from: ir.nasim.c23$a */
    public static final class a extends AbstractC22608vX3.b {
        private final InterfaceC16733lm3 a = C0926a.a;

        /* renamed from: ir.nasim.c23$a$a, reason: collision with other inner class name */
        /* synthetic */ class C0926a extends EB2 implements InterfaceC14603iB2 {
            public static final C0926a a = new C0926a();

            C0926a() {
                super(2, C10692c23.class, "<init>", "<init>(Lir/nasim/databinding/ItemChatImageBubbleBinding;Lir/nasim/features/conversation/messages/content/adapter/holder/bubble/album/AlbumClickListener;)V", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final C10692c23 invoke(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
                AbstractC13042fc3.i(c9263Ze3, "p0");
                AbstractC13042fc3.i(interfaceC11285cl, "p1");
                return new C10692c23(c9263Ze3, interfaceC11285cl, null);
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

    public /* synthetic */ C10692c23(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl, ED1 ed1) {
        this(c9263Ze3, interfaceC11285cl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(final C10692c23 c10692c23) {
        AbstractC13042fc3.i(c10692c23, "this$0");
        CharSequence contentDescription = c10692c23.D().b.getContentDescription();
        if (contentDescription == null || AbstractC20762sZ6.n0(contentDescription)) {
            return;
        }
        String string = c10692c23.p().getContext().getString(AbstractC12217eE5.item_not_downloaded_content_description);
        AbstractC13042fc3.h(string, "getString(...)");
        AbstractC12990fW7.l0(c10692c23.D().getRoot(), X2.a.i, (CharSequence) AbstractC15401jX0.q0(AbstractC20762sZ6.N0(string, new String[]{","}, false, 0, 6, null)), new InterfaceC10698c3() { // from class: ir.nasim.Y13
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar) {
                return C10692c23.O(this.a, view, aVar);
            }
        });
        AbstractC12990fW7.l0(c10692c23.D().getRoot(), X2.a.j, AbstractC15401jX0.A0(AbstractC15401jX0.k0(AbstractC20762sZ6.N0(contentDescription, new String[]{","}, false, 0, 6, null), 1), null, null, null, 0, null, null, 63, null), new InterfaceC10698c3() { // from class: ir.nasim.Z13
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar) {
                return C10692c23.P(view, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(C10692c23 c10692c23, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c10692c23, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c10692c23.D().c.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean P(View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(view, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final C10692c23 c10692c23) {
        AbstractC13042fc3.i(c10692c23, "this$0");
        String string = c10692c23.p().getContext().getString(AbstractC12217eE5.message_options_activate);
        AbstractC13042fc3.h(string, "getString(...)");
        AbstractC12990fW7.l0(c10692c23.D().getRoot(), X2.a.i, string, new InterfaceC10698c3() { // from class: ir.nasim.b23
            @Override // ir.nasim.InterfaceC10698c3
            public final boolean a(View view, InterfaceC10698c3.a aVar) {
                return C10692c23.R(this.a, view, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R(C10692c23 c10692c23, View view, InterfaceC10698c3.a aVar) {
        AbstractC13042fc3.i(c10692c23, "this$0");
        AbstractC13042fc3.i(view, "<unused var>");
        c10692c23.D().c.performClick();
        return true;
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
        return new H23(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void r() {
        p().setImportantForAccessibility(1);
        D().getRoot().postDelayed(new Runnable() { // from class: ir.nasim.X13
            @Override // java.lang.Runnable
            public final void run() {
                C10692c23.N(this.a);
            }
        }, 200L);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void s() {
        D().getRoot().postDelayed(new Runnable() { // from class: ir.nasim.a23
            @Override // java.lang.Runnable
            public final void run() {
                C10692c23.Q(this.a);
            }
        }, 200L);
    }

    private C10692c23(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
        super(c9263Ze3, interfaceC11285cl);
        BubbleTextView bubbleTextView = c9263Ze3.g;
        AbstractC13042fc3.h(bubbleTextView, "textViewProgress");
        bubbleTextView.setVisibility(8);
    }
}
