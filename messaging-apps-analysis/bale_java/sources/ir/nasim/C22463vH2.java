package ir.nasim;

import ir.nasim.AbstractC22608vX3;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* renamed from: ir.nasim.vH2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22463vH2 extends AbstractC22608vX3 {

    /* renamed from: ir.nasim.vH2$a */
    public static final class a extends AbstractC22608vX3.b {
        private final InterfaceC16733lm3 a = C1660a.a;

        /* renamed from: ir.nasim.vH2$a$a, reason: collision with other inner class name */
        /* synthetic */ class C1660a extends EB2 implements InterfaceC14603iB2 {
            public static final C1660a a = new C1660a();

            C1660a() {
                super(2, C22463vH2.class, "<init>", "<init>(Lir/nasim/databinding/ItemChatImageBubbleBinding;Lir/nasim/features/conversation/messages/content/adapter/holder/bubble/album/AlbumClickListener;)V", 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public final C22463vH2 invoke(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
                AbstractC13042fc3.i(c9263Ze3, "p0");
                AbstractC13042fc3.i(interfaceC11285cl, "p1");
                return new C22463vH2(c9263Ze3, interfaceC11285cl, null);
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

    public /* synthetic */ C22463vH2(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl, ED1 ed1) {
        this(c9263Ze3, interfaceC11285cl);
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
        return new MH2(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
    }

    private C22463vH2(C9263Ze3 c9263Ze3, InterfaceC11285cl interfaceC11285cl) {
        super(c9263Ze3, interfaceC11285cl);
    }

    @Override // ir.nasim.AbstractC20283rl
    public void r() {
    }

    @Override // ir.nasim.AbstractC20283rl
    public void s() {
    }
}
