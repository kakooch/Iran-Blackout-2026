package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import ir.nasim.VW5;

/* renamed from: ir.nasim.bp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC10562bp {

    /* renamed from: ir.nasim.bp$a */
    public static final class a extends VW5.e {
        final /* synthetic */ HE0 a;
        final /* synthetic */ MW5 b;

        a(HE0 he0, MW5 mw5) {
            this.a = he0;
            this.b = mw5;
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: h */
        public void f(int i) {
            this.a.F(new IllegalStateException("Unable to load font " + this.b + " (reason=" + i + ')'));
        }

        @Override // ir.nasim.VW5.e
        /* renamed from: i */
        public void g(Typeface typeface) {
            this.a.resumeWith(C9475a16.b(typeface));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Typeface c(MW5 mw5, Context context) {
        Typeface typefaceH = VW5.h(context, mw5.d());
        AbstractC13042fc3.f(typefaceH);
        return typefaceH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(MW5 mw5, Context context, InterfaceC20295rm1 interfaceC20295rm1) throws Resources.NotFoundException {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        VW5.j(context, mw5.d(), new a(ie0, mw5), null);
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }
}
