package ir.nasim;

import android.content.Context;
import android.view.View;
import ir.nasim.M44;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public abstract class LW1 implements O44 {
    private final DocumentStateButton a;
    private final InterfaceC23783xW1 b;
    private C22007uW1 c;
    private boolean d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DocumentStateButton.a.values().length];
            try {
                iArr[DocumentStateButton.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DocumentStateButton.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DocumentStateButton.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DocumentStateButton.a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* synthetic */ class b extends EB2 implements SA2 {
        b(Object obj) {
            super(0, obj, C22007uW1.class, "resume", "resume()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C22007uW1) this.receiver).L();
        }
    }

    /* synthetic */ class c extends EB2 implements SA2 {
        c(Object obj) {
            super(0, obj, C22007uW1.class, "pause", "pause()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C22007uW1) this.receiver).H();
        }
    }

    public LW1(DocumentStateButton documentStateButton, InterfaceC23783xW1 interfaceC23783xW1) {
        AbstractC13042fc3.i(documentStateButton, "documentStateButton");
        AbstractC13042fc3.i(interfaceC23783xW1, "documentClickListener");
        this.a = documentStateButton;
        this.b = interfaceC23783xW1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(LW1 lw1, AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(lw1, "this$0");
        AbstractC13042fc3.i(abstractC17757nW1, "$document");
        AbstractC13042fc3.i(abstractC15537jl, "$extras");
        lw1.n(abstractC17757nW1, abstractC15537jl);
        return C19938rB7.a;
    }

    private final DocumentStateButton p(final C22007uW1 c22007uW1, final C14339hl c14339hl) {
        DocumentStateButton documentStateButton = this.a;
        documentStateButton.setOnClickListener(new UA2() { // from class: ir.nasim.JW1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return LW1.q(this.a, c14339hl, c22007uW1, (DocumentStateButton.a) obj);
            }
        });
        Context context = documentStateButton.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        if (!C10082b3.c(context)) {
            documentStateButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.KW1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return LW1.r(this.a, c14339hl, view);
                }
            });
        }
        return documentStateButton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(LW1 lw1, C14339hl c14339hl, C22007uW1 c22007uW1, DocumentStateButton.a aVar) {
        AbstractC13042fc3.i(lw1, "this$0");
        AbstractC13042fc3.i(c14339hl, "$albumData");
        AbstractC13042fc3.i(c22007uW1, "$documentBinder");
        AbstractC13042fc3.i(aVar, "state");
        lw1.i(aVar, c14339hl, new b(c22007uW1), new c(c22007uW1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(LW1 lw1, C14339hl c14339hl, View view) {
        AbstractC13042fc3.i(lw1, "this$0");
        AbstractC13042fc3.i(c14339hl, "$albumData");
        return lw1.b.b(c14339hl);
    }

    public void d(C14339hl c14339hl, AbstractC15537jl abstractC15537jl) {
        String strX;
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        C22007uW1 c22007uW1G = g(c14339hl.c(), abstractC15537jl);
        c22007uW1G.J(e(c14339hl.c(), abstractC15537jl));
        MW1 mw1B = c14339hl.c().b();
        EnumC8893Xt7 enumC8893Xt7B = abstractC15537jl.b();
        C24967zW1 c24967zW1H = c14339hl.d().j().H();
        if (c24967zW1H == null || (strX = c24967zW1H.x()) == null) {
            strX = null;
        }
        if (strX == null) {
            strX = "";
        }
        AbstractC4767Gm.a(c22007uW1G, mw1B, enumC8893Xt7B, strX);
        c22007uW1G.l();
        this.c = c22007uW1G;
        p(c22007uW1G, c14339hl);
    }

    protected List e(final AbstractC17757nW1 abstractC17757nW1, final AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        return AbstractC10360bX0.g(h(), new CW1(new SA2() { // from class: ir.nasim.IW1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return LW1.f(this.a, abstractC17757nW1, abstractC15537jl);
            }
        }));
    }

    protected C22007uW1 g(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        C14970in2 c14970in2D = AbstractC5969Lp4.e().D();
        AbstractC13042fc3.f(c14970in2D);
        return new C22007uW1(c14970in2D, abstractC17757nW1, null, 4, null);
    }

    protected OW1 h() {
        return new OW1(this.a, m(), false, 4, null);
    }

    protected void i(DocumentStateButton.a aVar, C14339hl c14339hl, SA2 sa2, SA2 sa22) {
        AbstractC13042fc3.i(aVar, "state");
        AbstractC13042fc3.i(c14339hl, "albumData");
        AbstractC13042fc3.i(sa2, "resumeAction");
        AbstractC13042fc3.i(sa22, "pauseAction");
        int i = a.a[aVar.ordinal()];
        if (i == 1) {
            sa2.invoke();
            return;
        }
        if (i == 2) {
            sa22.invoke();
            return;
        }
        if (i == 3) {
            sa22.invoke();
            this.b.c(c14339hl);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.b.d(c14339hl);
        }
    }

    @Override // ir.nasim.O44
    public final void j(M44.a aVar) {
        AbstractC13042fc3.i(aVar, "builder");
        t(aVar, this.d);
    }

    protected final InterfaceC23783xW1 k() {
        return this.b;
    }

    protected final DocumentStateButton l() {
        return this.a;
    }

    protected Integer m() {
        return null;
    }

    protected void n(AbstractC17757nW1 abstractC17757nW1, AbstractC15537jl abstractC15537jl) {
        AbstractC13042fc3.i(abstractC17757nW1, "document");
        AbstractC13042fc3.i(abstractC15537jl, "extras");
        this.b.e();
        this.d = true;
    }

    public void o(C14339hl c14339hl) {
        AbstractC13042fc3.i(c14339hl, "albumData");
        C22007uW1 c22007uW1 = this.c;
        if (c22007uW1 != null) {
            c22007uW1.K(c14339hl.c().b());
            p(c22007uW1, c14339hl);
        }
    }

    public void s() {
        this.d = false;
        C22007uW1 c22007uW1 = this.c;
        if (c22007uW1 != null) {
            c22007uW1.R();
        }
        this.c = null;
    }

    protected abstract void t(M44.a aVar, boolean z);
}
