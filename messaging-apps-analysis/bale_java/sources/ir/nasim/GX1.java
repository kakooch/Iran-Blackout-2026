package ir.nasim;

import android.content.Context;
import android.view.View;
import ir.nasim.DX1;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class GX1 extends AbstractC22597vW1 {
    private final int a;
    private final Context b;
    private boolean c;
    private int d;
    private SA2 e;

    public /* synthetic */ GX1(View view, int i, View view2, Context context, int i2, ED1 ed1) {
        this(view, i, (i2 & 4) != 0 ? null : view2, (i2 & 8) != 0 ? view.getContext() : context);
    }

    private final void w() {
        C17468n10 c17468n10;
        if (this.c || (c17468n10 = (C17468n10) this.e.invoke()) == null) {
            return;
        }
        Context context = this.b;
        String string = context.getString(AbstractC12217eE5.nasim_message_holder_file_is_blocked_error, context.getString(this.a));
        AbstractC13042fc3.h(string, "getString(...)");
        c17468n10.o(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 x(View view, View view2) {
        AbstractC13042fc3.i(view, "$rootView");
        if (!view.isAttachedToWindow()) {
            return null;
        }
        return new C17468n10(view, view2, 0, 4, null);
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void a() {
        this.c = true;
        this.d = 0;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void m(float f, boolean z) {
        this.c = z;
    }

    @Override // ir.nasim.AbstractC22597vW1
    public void s(float f, DX1 dx1) {
        if (AbstractC13042fc3.d(dx1, DX1.b.a)) {
            w();
        } else if (!(dx1 instanceof DX1.d) && !(dx1 instanceof DX1.c) && !AbstractC13042fc3.d(dx1, DX1.a.a) && dx1 != null) {
            throw new NoWhenBranchMatchedException();
        }
        this.c = false;
    }

    public GX1(final View view, int i, final View view2, Context context) {
        AbstractC13042fc3.i(view, "rootView");
        AbstractC13042fc3.i(context, "context");
        this.a = i;
        this.b = context;
        this.c = true;
        this.e = new SA2() { // from class: ir.nasim.FX1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return GX1.x(view, view2);
            }
        };
    }
}
