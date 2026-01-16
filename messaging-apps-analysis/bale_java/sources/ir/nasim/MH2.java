package ir.nasim;

import android.content.Context;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.List;

/* loaded from: classes5.dex */
public final class MH2 extends TY3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MH2(ImageViewCrossFade imageViewCrossFade, BubbleTextView bubbleTextView, DocumentStateButton documentStateButton, InterfaceC23783xW1 interfaceC23783xW1) {
        super(imageViewCrossFade, bubbleTextView, documentStateButton, interfaceC23783xW1);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(bubbleTextView, "processTextView");
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
    }

    @Override // ir.nasim.TY3
    public List x(AbstractC17757nW1.c cVar, C17177mX3 c17177mX3) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c17177mX3, "extras");
        UH2 uh2 = new UH2(B());
        byte[] bArrE = cVar.e();
        ImageViewCrossFade imageViewCrossFadeA = A();
        XV4 xv4D = c17177mX3.d();
        Context context = A().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        VG2 vg2 = new VG2(bArrE, imageViewCrossFadeA, xv4D, y(context));
        List listX = super.x(cVar, c17177mX3);
        listX.add(uh2);
        listX.add(vg2);
        return listX;
    }
}
