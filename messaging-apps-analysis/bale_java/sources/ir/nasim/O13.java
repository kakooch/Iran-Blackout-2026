package ir.nasim;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.widget.ImageView;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* loaded from: classes5.dex */
public final class O13 extends C5454Jk2 {
    private final byte[] e;
    private final ImageView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O13(Spannable spannable, byte[] bArr, BubbleTextView bubbleTextView, ImageView imageView) {
        super(spannable, bubbleTextView);
        AbstractC13042fc3.i(spannable, "mimeType");
        AbstractC13042fc3.i(bubbleTextView, "progressTextView");
        AbstractC13042fc3.i(imageView, "imageViewFile");
        this.e = bArr;
        this.f = imageView;
        Context context = imageView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        imageView.setBackground(new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third)));
        imageView.setVisibility(0);
    }

    private final Object w(Object obj, boolean z) {
        ImageView imageView = this.f;
        if (obj == null) {
            imageView.setVisibility(8);
            return C19938rB7.a;
        }
        imageView.setVisibility(0);
        UI2 ui2Q = OI2.b(C5721Ko.a.d()).Q(obj);
        if (z) {
            ui2Q.i1(H02.k());
        }
        PX7 px7Q0 = ui2Q.l1().Q0(this.f);
        AbstractC13042fc3.f(px7Q0);
        return px7Q0;
    }

    @Override // ir.nasim.C5454Jk2, ir.nasim.AbstractC22597vW1
    public void a() {
        super.a();
        ImageView imageView = this.f;
        OI2.b(C5721Ko.a.d()).n(imageView);
        imageView.setVisibility(8);
    }

    @Override // ir.nasim.C5454Jk2, ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        super.d(interfaceC3346Am2);
        w(interfaceC3346Am2.getDescriptor(), true);
    }

    @Override // ir.nasim.C5454Jk2, ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        super.n(c4512Fl2, f, j);
        w(this.e, false);
    }
}
