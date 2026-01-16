package ir.nasim;

import android.view.View;

/* loaded from: classes3.dex */
public abstract class DX7 {

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ View e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view) {
            super(0);
            this.e = view;
        }

        public final void a() {
            this.e.invalidate();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public static final /* synthetic */ CX7 a(View view, Object obj) {
        AbstractC13042fc3.i(view, "<this>");
        return new CX7(obj, new a(view));
    }
}
