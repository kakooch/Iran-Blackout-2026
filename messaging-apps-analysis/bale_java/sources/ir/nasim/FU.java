package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import ir.nasim.core.modules.file.entity.FileReference;

/* loaded from: classes5.dex */
public final class FU {
    private final Context a;
    private InterfaceC7857Tm2 b;

    public FU(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    private final void f(FileReference fileReference, int i, UA2 ua2, SA2 sa2) {
        if (fileReference != null) {
            this.b = AbstractC5969Lp4.e().D().D(fileReference, true, new a(sa2, i, ua2), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
        } else if (sa2 != null) {
            sa2.invoke();
        }
    }

    public static /* synthetic */ void g(FU fu, C20610sI7 c20610sI7, int i, SA2 sa2, UA2 ua2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.DU
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return FU.h();
                }
            };
        }
        fu.e(c20610sI7, i, sa2, ua2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(FU fu, C20610sI7 c20610sI7, int i, UA2 ua2, SA2 sa2) {
        AbstractC13042fc3.i(fu, "this$0");
        AbstractC13042fc3.i(c20610sI7, "$userAvatar");
        AbstractC13042fc3.i(ua2, "$onDownload");
        AbstractC13042fc3.i(sa2, "$onFailure");
        fu.f(c20610sI7.a(), i, ua2, sa2);
        return C19938rB7.a;
    }

    public final void d() {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.b;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
        }
        this.b = null;
    }

    public final void e(final C20610sI7 c20610sI7, final int i, final SA2 sa2, final UA2 ua2) {
        AbstractC13042fc3.i(c20610sI7, "userAvatar");
        AbstractC13042fc3.i(sa2, "onFailure");
        AbstractC13042fc3.i(ua2, "onDownload");
        f(c20610sI7.b(), i, ua2, new SA2() { // from class: ir.nasim.EU
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FU.i(this.a, c20610sI7, i, ua2, sa2);
            }
        });
    }

    public static final class a implements InterfaceC8091Um2 {
        final /* synthetic */ SA2 b;
        final /* synthetic */ int c;
        final /* synthetic */ UA2 d;

        a(SA2 sa2, int i, UA2 ua2) {
            this.b = sa2;
            this.c = i;
            this.d = ua2;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            UI2 ui2E = OI2.b(C5721Ko.a.d()).j().Z0(interfaceC3346Am2.getDescriptor()).e();
            int i = this.c;
            ui2E.c0(i, i).M0(new C0371a(FU.this, this.d));
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            FU.this.b = null;
            SA2 sa2 = this.b;
            if (sa2 != null) {
                sa2.invoke();
            }
        }

        /* renamed from: ir.nasim.FU$a$a, reason: collision with other inner class name */
        public static final class C0371a extends AbstractC4151Dx1 {
            final /* synthetic */ FU d;
            final /* synthetic */ UA2 e;

            C0371a(FU fu, UA2 ua2) {
                this.d = fu;
                this.e = ua2;
            }

            @Override // ir.nasim.InterfaceC21549tj7
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Drawable drawable, InterfaceC22855vv7 interfaceC22855vv7) {
                AbstractC13042fc3.i(drawable, "resource");
                this.d.b = null;
                this.e.invoke(drawable);
            }

            @Override // ir.nasim.InterfaceC21549tj7
            public void g(Drawable drawable) {
            }
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
        }
    }
}
