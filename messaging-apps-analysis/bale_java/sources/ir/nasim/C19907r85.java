package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import ir.nasim.C19907r85;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.features.conversation.messages.content.CircleProgressBar;

/* renamed from: ir.nasim.r85, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19907r85 implements InterfaceC8091Um2 {
    public static final a k = new a(null);
    public static final int l = 8;
    private final FileReference a;
    private final View b;
    private final ImageView c;
    private final CircleProgressBar d;
    private final UA2 e;
    private final SA2 f;
    private final InterfaceC16978mB2 g;
    private final SA2 h;
    private SA2 i;
    private boolean j;

    /* renamed from: ir.nasim.r85$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(UA2 ua2, C19907r85 c19907r85) {
            AbstractC13042fc3.i(ua2, "$onDownloadRetry");
            AbstractC13042fc3.i(c19907r85, "$this_apply");
            ua2.invoke(c19907r85);
            return C19938rB7.a;
        }

        public final C19907r85 b(FileReference fileReference, View view, ImageView imageView, CircleProgressBar circleProgressBar, UA2 ua2, SA2 sa2, InterfaceC16978mB2 interfaceC16978mB2, final UA2 ua22, SA2 sa22) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            AbstractC13042fc3.i(view, "stateContainerView");
            AbstractC13042fc3.i(imageView, "stateImageView");
            AbstractC13042fc3.i(circleProgressBar, "progressBar");
            AbstractC13042fc3.i(ua2, "onDownloadComplete");
            AbstractC13042fc3.i(sa2, "onDownloadCancelled");
            AbstractC13042fc3.i(interfaceC16978mB2, "sendTrafficUsageEvent");
            AbstractC13042fc3.i(ua22, "onDownloadRetry");
            final C19907r85 c19907r85 = new C19907r85(fileReference, view, imageView, circleProgressBar, ua2, sa2, interfaceC16978mB2, sa22, null);
            c19907r85.h(new SA2() { // from class: ir.nasim.q85
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C19907r85.a.d(ua22, c19907r85);
                }
            });
            return c19907r85;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C19907r85(FileReference fileReference, View view, ImageView imageView, CircleProgressBar circleProgressBar, UA2 ua2, SA2 sa2, InterfaceC16978mB2 interfaceC16978mB2, SA2 sa22, ED1 ed1) {
        this(fileReference, view, imageView, circleProgressBar, ua2, sa2, interfaceC16978mB2, sa22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(C19907r85 c19907r85, View view) {
        AbstractC13042fc3.i(c19907r85, "this$0");
        SA2 sa2 = c19907r85.i;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void b() {
        SA2 sa2 = this.i;
        if (sa2 != null) {
            sa2.invoke();
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.p85
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19907r85.f(this.a, view);
            }
        });
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void c(float f) {
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.d.setValue((int) (f * 100));
        this.j = true;
        SA2 sa2 = this.h;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void d(InterfaceC3346Am2 interfaceC3346Am2) {
        AbstractC13042fc3.i(interfaceC3346Am2, "reference");
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        if (this.j) {
            InterfaceC16978mB2 interfaceC16978mB2 = this.g;
            Long lValueOf = Long.valueOf(interfaceC3346Am2.f());
            String strO = C6906Pm2.o(interfaceC3346Am2.getDescriptor());
            if (strO == null) {
                strO = "image/jpeg";
            }
            interfaceC16978mB2.e(lValueOf, strO, Long.valueOf(this.a.getFileId()), Long.valueOf(this.a.getAccessHash()));
            this.j = false;
        }
        this.e.invoke(interfaceC3346Am2);
    }

    @Override // ir.nasim.InterfaceC8091Um2
    public void g(DX1 dx1) {
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.c.setImageResource(AbstractC18163oB5.ic_feed_retry);
    }

    public final void h(SA2 sa2) {
        this.i = sa2;
    }

    public final void i() {
        this.j = false;
        this.f.invoke();
    }

    private C19907r85(FileReference fileReference, View view, ImageView imageView, CircleProgressBar circleProgressBar, UA2 ua2, SA2 sa2, InterfaceC16978mB2 interfaceC16978mB2, SA2 sa22) {
        this.a = fileReference;
        this.b = view;
        this.c = imageView;
        this.d = circleProgressBar;
        this.e = ua2;
        this.f = sa2;
        this.g = interfaceC16978mB2;
        this.h = sa22;
    }
}
