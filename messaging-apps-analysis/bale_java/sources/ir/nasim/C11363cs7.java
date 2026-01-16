package ir.nasim;

import android.graphics.Typeface;
import android.view.ContextThemeWrapper;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.D20;
import java.util.Objects;

/* renamed from: ir.nasim.cs7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11363cs7 {
    public static final C11363cs7 a = new C11363cs7();

    private C11363cs7() {
    }

    public static final D20.a a(InterfaceC18633oz3 interfaceC18633oz3) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(C5721Ko.a.d(), AbstractC17008mE5.Theme_Bale_Base);
        D20.a aVarE2 = new D20.a(contextThemeWrapper).d1(16).X0(EnumC11622dK.c).W0(AbstractC24188yB5.ic_tooltip_arrow).U0(OY0.b(contextThemeWrapper, AbstractC15199jA5.n400)).k2(RecyclerView.UNDEFINED_DURATION).u1(RecyclerView.UNDEFINED_DURATION).b2(17).Q1(12).S1(12).O1(8).U1(8).e1(8).l1(14.0f).C1(true).e2(14.0f);
        Typeface typefaceH = VW5.h(contextThemeWrapper, NB5.iran_sans_regular);
        Objects.requireNonNull(typefaceH);
        AbstractC13042fc3.h(typefaceH, "requireNonNull(...)");
        return aVarE2.h2(typefaceH).Z1(OY0.b(contextThemeWrapper, AbstractC15199jA5.background)).g1(OY0.b(contextThemeWrapper, AbstractC15199jA5.n400)).i1(F20.e).a1(0.15f).s1(false).f1(5000L).G1(interfaceC18633oz3).k1(I20.a, 0L);
    }
}
