package ir.nasim;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import ir.nasim.AbstractC17757nW1;
import ir.nasim.M44;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class TY3 extends LW1 {
    private final ImageViewCrossFade e;
    private final BubbleTextView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TY3(ImageViewCrossFade imageViewCrossFade, BubbleTextView bubbleTextView, DocumentStateButton documentStateButton, InterfaceC23783xW1 interfaceC23783xW1) {
        super(documentStateButton, interfaceC23783xW1);
        AbstractC13042fc3.i(imageViewCrossFade, "imageView");
        AbstractC13042fc3.i(bubbleTextView, "processTextView");
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
        this.e = imageViewCrossFade;
        this.f = bubbleTextView;
    }

    private final void C(ImageViewCrossFade imageViewCrossFade, final C14339hl c14339hl, final DocumentStateButton documentStateButton, final InterfaceC23783xW1 interfaceC23783xW1) {
        imageViewCrossFade.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.RY3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return TY3.D(interfaceC23783xW1, c14339hl, view);
            }
        });
        imageViewCrossFade.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.SY3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TY3.E(interfaceC23783xW1, c14339hl, documentStateButton, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D(InterfaceC23783xW1 interfaceC23783xW1, C14339hl c14339hl, View view) {
        AbstractC13042fc3.i(interfaceC23783xW1, "$documentClickListener");
        AbstractC13042fc3.i(c14339hl, "$albumData");
        return interfaceC23783xW1.b(c14339hl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(InterfaceC23783xW1 interfaceC23783xW1, C14339hl c14339hl, DocumentStateButton documentStateButton, View view) {
        AbstractC13042fc3.i(interfaceC23783xW1, "$documentClickListener");
        AbstractC13042fc3.i(c14339hl, "$albumData");
        AbstractC13042fc3.i(documentStateButton, "$documentStateButton");
        if (interfaceC23783xW1.a()) {
            interfaceC23783xW1.d(c14339hl);
        } else {
            documentStateButton.performClick();
        }
    }

    private final int z(AbstractC17757nW1.c cVar) {
        if (cVar instanceof AbstractC17757nW1.c.a) {
            return AbstractC12217eE5.media_Gif;
        }
        if (cVar instanceof AbstractC17757nW1.c.b) {
            return AbstractC12217eE5.media_picture;
        }
        if ((cVar instanceof AbstractC17757nW1.c.AbstractC1416c.a) || (cVar instanceof AbstractC17757nW1.c.AbstractC1416c.b)) {
            return AbstractC12217eE5.media_sticker;
        }
        if (cVar instanceof AbstractC17757nW1.c.d) {
            return AbstractC12217eE5.media_video2;
        }
        throw new NoWhenBranchMatchedException();
    }

    protected final ImageViewCrossFade A() {
        return this.e;
    }

    protected final BubbleTextView B() {
        return this.f;
    }

    @Override // ir.nasim.LW1
    public final void d(C14339hl c14339hl, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        super.d(c14339hl, abstractC15537jl);
        w(c14339hl, (C17177mX3) abstractC15537jl);
    }

    @Override // ir.nasim.LW1
    protected final List e(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        AbstractC17757nW1.c cVar = (AbstractC17757nW1.c) abstractC17757nW1;
        List listX = x(cVar, (C17177mX3) abstractC15537jl);
        new GX1(this.e, z(cVar), null, null, 12, null);
        return listX;
    }

    @Override // ir.nasim.LW1
    protected void n(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        super.n(abstractC17757nW1, abstractC15537jl);
        AbstractC12990fW7.L0(this.e, abstractC15537jl.a());
    }

    @Override // ir.nasim.LW1
    public void o(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        super.o(c14339hl);
        C(this.e, c14339hl, l(), k());
    }

    @Override // ir.nasim.LW1
    public void s() {
        super.s();
        AbstractC12990fW7.L0(this.e, null);
    }

    @Override // ir.nasim.LW1
    protected void t(M44.a aVar, boolean z) {
        AbstractC13042fc3.i(aVar, "builder");
        aVar.Y(z);
        aVar.M(z);
        aVar.V(z);
    }

    public void w(C14339hl c14339hl, C17177mX3 c17177mX3) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(c17177mX3, "extras");
        C(this.e, c14339hl, l(), k());
    }

    public List x(AbstractC17757nW1.c cVar, C17177mX3 c17177mX3) {
        AbstractC13042fc3.i(cVar, "document");
        AbstractC13042fc3.i(c17177mX3, "extras");
        return super.e(cVar, c17177mX3);
    }

    protected final ColorDrawable y(Context context) {
        AbstractC13042fc3.i(context, "context");
        return new ColorDrawable(OY0.b(context, AbstractC21139tA5.bubble_third));
    }
}
