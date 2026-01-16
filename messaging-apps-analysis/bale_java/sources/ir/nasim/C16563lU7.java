package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.List;

/* renamed from: ir.nasim.lU7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16563lU7 extends TY3 {

    /* renamed from: ir.nasim.lU7$a */
    public /* synthetic */ class a {
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
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C16563lU7(ImageViewCrossFade imageViewCrossFade, BubbleTextView bubbleTextView, DocumentStateButton documentStateButton, InterfaceC23783xW1 interfaceC23783xW1) {
        super(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(bubbleTextView, "processTextView");
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
    }

    @Override // ir.nasim.LW1
    protected C22007uW1 g(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.h(c14970in2D, "getFilesModule(...)");
        return new SS7(c14970in2D, abstractC17757nW1);
    }

    @Override // ir.nasim.LW1
    protected OW1 h() {
        return new WS7(l());
    }

    @Override // ir.nasim.LW1
    protected void i(DocumentStateButton.a aVar, C14339hl c14339hl, SA2 sa2, SA2 sa22) {
        AbstractC13042fc3.i(aVar, "state");
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(sa2, "resumeAction");
        AbstractC13042fc3.i(sa22, "pauseAction");
        int i = a.a[aVar.ordinal()];
        if (i == 1 || i == 2) {
            k().d(c14339hl);
        } else {
            super.i(aVar, c14339hl, sa2, sa22);
        }
    }

    @Override // ir.nasim.LW1
    protected Integer m() {
        return Integer.valueOf(KB5.bubble_document_state_play);
    }

    @Override // ir.nasim.TY3, ir.nasim.LW1
    protected void n(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        super.n(abstractC17757nW1, abstractC15537jl);
        AbstractC12990fW7.L0(A(), "thumb_" + abstractC15537jl.a());
    }

    @Override // ir.nasim.TY3
    public List x(AbstractC17757nW1.c cVar, C17177mX3 c17177mX3) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c17177mX3, "extras");
        byte[] bArrE = cVar.e();
        ImageViewCrossFade imageViewCrossFadeA = A();
        XV4 xv4D = c17177mX3.d();
        Context context = A().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C20700sS7 c20700sS7 = new C20700sS7(bArrE, imageViewCrossFadeA, xv4D, y(context));
        List listX = super.x(cVar, c17177mX3);
        listX.add(c20700sS7);
        return listX;
    }
}
