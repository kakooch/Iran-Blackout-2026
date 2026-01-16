package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.List;

/* loaded from: classes5.dex */
public final class H23 extends TY3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H23(ImageViewCrossFade imageViewCrossFade, BubbleTextView bubbleTextView, DocumentStateButton documentStateButton, InterfaceC23783xW1 interfaceC23783xW1) {
        super(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(bubbleTextView, "processTextView");
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
    }

    private final AbstractC17168mW3 F(AbstractC17757nW1.c cVar, C17177mX3 c17177mX3) {
        if (cVar instanceof AbstractC17757nW1.c.b.C1415b) {
            return new C14031hE1((AbstractC17757nW1.c.b.C1415b) cVar, A());
        }
        byte[] bArrE = cVar.e();
        ImageViewCrossFade imageViewCrossFadeA = A();
        XV4 xv4D = c17177mX3.d();
        Context context = A().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new P03(bArrE, imageViewCrossFadeA, xv4D, y(context));
    }

    @Override // ir.nasim.TY3
    public List x(AbstractC17757nW1.c cVar, C17177mX3 c17177mX3) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c17177mX3, "extras");
        AbstractC17168mW3 abstractC17168mW3F = F(cVar, c17177mX3);
        List listX = super.x(cVar, c17177mX3);
        listX.add(abstractC17168mW3F);
        return listX;
    }
}
