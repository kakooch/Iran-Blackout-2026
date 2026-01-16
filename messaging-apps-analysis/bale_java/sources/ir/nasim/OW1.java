package ir.nasim;

import android.content.Context;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;

/* loaded from: classes5.dex */
public class OW1 extends AbstractC22597vW1 {
    private final DocumentStateButton a;
    private final Integer b;
    private final boolean c;
    private final Context d;

    public /* synthetic */ OW1(DocumentStateButton documentStateButton, Integer num, boolean z, int i, ED1 ed1) {
        this(documentStateButton, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        DocumentStateButton.d(this.a, null, 1, null);
    }

    @Override // ir.nasim.AbstractC22597vW1, ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        if (this.c) {
            this.a.setContentDescription(this.d.getString(AbstractC12217eE5.voice_downloaded_content_description));
        }
        this.a.c(this.b);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        if (z) {
            DocumentStateButton.f(this.a, true, false, 2, null);
        } else {
            this.a.b();
        }
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void n(C4512Fl2 c4512Fl2, float f, long j) {
        AbstractC13042fc3.i(c4512Fl2, "localSource");
        DocumentStateButton.f(this.a, false, false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void o(float f) {
        this.a.b();
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void p() {
        DocumentStateButton.f(this.a, true, false, 2, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void q(float f, float f2) {
        if (this.c) {
            this.a.setContentDescription(this.d.getString(AbstractC12217eE5.voice_downloading_content_description));
        }
        DocumentStateButton.f(this.a, true, false, 2, null);
        this.a.h((int) (f * 100));
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void r(float f) {
        if (this.c) {
            this.a.setContentDescription(this.d.getString(AbstractC12217eE5.item_not_downloaded_content_description));
        }
        this.a.b();
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void t(float f) {
        this.a.c(this.b);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void u(float f, float f2) {
        DocumentStateButton.f(this.a, false, false, 2, null);
        this.a.h((int) (f * 100));
    }

    protected final DocumentStateButton v() {
        return this.a;
    }

    protected final Integer w() {
        return this.b;
    }

    public OW1(DocumentStateButton documentStateButton, Integer num, boolean z) {
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        this.a = documentStateButton;
        this.b = num;
        this.c = z;
        this.d = documentStateButton.getContext();
    }
}
