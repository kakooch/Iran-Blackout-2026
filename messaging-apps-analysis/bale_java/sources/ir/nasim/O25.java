package ir.nasim;

import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.core.Separators;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes6.dex */
public final class O25 extends RecyclerView.C {
    public static final a A = new a(null);
    public static final int B = 8;
    private final BJ0 u;
    private final UA2 v;
    private final String w;
    private final boolean x;
    private C12692f25 y;
    private boolean z;

    public static final class a {
        private a() {
        }

        public final String a(int i) throws NumberFormatException {
            if (i < 1000) {
                return String.valueOf(i);
            }
            if (i < 1000000) {
                return (i / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) + "k";
            }
            DY6 dy6 = DY6.a;
            String str = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(i / 1000000.0f)}, 1));
            AbstractC13042fc3.h(str, "format(...)");
            return Double.parseDouble(str) + "m";
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O25(BJ0 bj0, UA2 ua2, String str, boolean z) {
        super(bj0.getRoot());
        AbstractC13042fc3.i(bj0, "binding");
        AbstractC13042fc3.i(ua2, "onClick");
        AbstractC13042fc3.i(str, "title");
        this.u = bj0;
        this.v = ua2;
        this.w = str;
        this.x = z;
        bj0.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.J25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O25.J0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(O25 o25, View view) {
        AbstractC13042fc3.i(o25, "this$0");
        C12692f25 c12692f25 = o25.y;
        if (c12692f25 != null) {
            o25.v.invoke(c12692f25);
        }
    }

    private final void M0() {
        BJ0 bj0 = this.u;
        bj0.d.setText(bj0.getRoot().getContext().getString(ID5.join));
        BJ0 bj02 = this.u;
        MaterialButton materialButton = bj02.d;
        Context context = bj02.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        materialButton.setTextColor(OY0.b(context, AbstractC13999hA5.colorOnPrimary));
        BJ0 bj03 = this.u;
        MaterialButton materialButton2 = bj03.d;
        Context context2 = bj03.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        materialButton2.setBackgroundTintList(ColorStateList.valueOf(OY0.b(context2, AbstractC13999hA5.colorPrimary)));
        this.u.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.L25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O25.N0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(final O25 o25, View view) {
        AbstractC13042fc3.i(o25, "this$0");
        final C12692f25 c12692f25 = o25.y;
        if (c12692f25 != null) {
            C19406qI3.a("Source_Join_Cause", "search joinMode()", new Object[0]);
            AbstractC5969Lp4.e().E().q2(new C11458d25(W25.b, c12692f25.b())).E(new InterfaceC24449ye1() { // from class: ir.nasim.M25
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    O25.O0(c12692f25, o25, (Exception) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.N25
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    O25.P0(c12692f25, o25, (Integer) obj);
                }
            });
            XV4 xv4A = AbstractC4616Fw7.a("action_type", 6);
            C12692f25 c12692f252 = o25.y;
            XV4 xv4A2 = AbstractC4616Fw7.a("peer_id", Integer.valueOf(c12692f252 != null ? c12692f252.b() : 0));
            String lowerCase = "CHANNEL".toLowerCase(Locale.ROOT);
            AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
            C3343Am.i("flow_search_v2", AbstractC20051rO3.n(xv4A, xv4A2, AbstractC4616Fw7.a("peer_type", lowerCase)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(C12692f25 c12692f25, O25 o25, Exception exc) {
        AbstractC13042fc3.i(c12692f25, "$it");
        AbstractC13042fc3.i(o25, "this$0");
        Toast.makeText(o25.a.getContext(), UN2.a(exc, c12692f25.a().p() == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(C12692f25 c12692f25, O25 o25, Integer num) {
        AbstractC13042fc3.i(c12692f25, "$it");
        AbstractC13042fc3.i(o25, "this$0");
        c12692f25.a().F().i(Boolean.TRUE);
        o25.Q0();
    }

    private final void Q0() {
        BJ0 bj0 = this.u;
        bj0.d.setText(bj0.getRoot().getContext().getString(ID5.btn_show));
        BJ0 bj02 = this.u;
        MaterialButton materialButton = bj02.d;
        Context context = bj02.getRoot().getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        materialButton.setTextColor(OY0.b(context, AbstractC13999hA5.colorPrimary));
        BJ0 bj03 = this.u;
        MaterialButton materialButton2 = bj03.d;
        Context context2 = bj03.getRoot().getContext();
        AbstractC13042fc3.h(context2, "getContext(...)");
        materialButton2.setBackgroundTintList(ColorStateList.valueOf(OY0.b(context2, AbstractC13999hA5.background)));
        this.u.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.K25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O25.S0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(O25 o25, View view) {
        AbstractC13042fc3.i(o25, "this$0");
        C12692f25 c12692f25 = o25.y;
        if (c12692f25 != null) {
            o25.v.invoke(c12692f25);
            o25.Q0();
        }
    }

    public final void L0(C12692f25 c12692f25, boolean z, boolean z2, C20644sM5 c20644sM5) {
        AbstractC13042fc3.i(c12692f25, "peer");
        AbstractC13042fc3.i(c20644sM5, "matcher");
        if (z2) {
            this.u.h.setText(this.w);
            this.u.h.setVisibility(0);
        } else {
            this.u.h.setVisibility(8);
        }
        if (this.x) {
            this.u.d.setVisibility(0);
            boolean zBooleanValue = ((Boolean) c12692f25.a().F().b()).booleanValue();
            this.z = zBooleanValue;
            if (zBooleanValue) {
                Q0();
            } else {
                M0();
            }
        } else {
            this.u.d.setVisibility(8);
        }
        this.y = c12692f25;
        SpannableString spannableStringI = AbstractC17636nI6.i(Separators.AT + c12692f25.d());
        SpannableString spannableStringI2 = AbstractC17636nI6.i(c12692f25.e());
        for (OU3 ou3 : C20644sM5.e(c20644sM5, spannableStringI2, 0, 2, null)) {
            Context context = this.u.getRoot().getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            spannableStringI2.setSpan(new ForegroundColorSpan(OY0.b(context, AbstractC13999hA5.colorPrimary)), ou3.c().o(), ou3.c().t() + 1, 33);
        }
        for (OU3 ou32 : C20644sM5.e(c20644sM5, spannableStringI, 0, 2, null)) {
            Context context2 = this.u.getRoot().getContext();
            AbstractC13042fc3.h(context2, "getContext(...)");
            spannableStringI.setSpan(new ForegroundColorSpan(OY0.b(context2, AbstractC13999hA5.colorPrimary)), ou32.c().o(), ou32.c().t() + 1, 33);
            spannableStringI.setSpan(new StyleSpan(1), ou32.c().o(), ou32.c().t() + 1, 33);
        }
        this.u.b.B(22.0f, true);
        this.u.b.q(c12692f25.a());
        this.u.g.setText(spannableStringI2);
        this.u.f.setText(spannableStringI);
        this.u.e.setText(XY6.v(A.a(c12692f25.c()) + Separators.SP + this.u.getRoot().getContext().getString(ID5.member)));
        if (z) {
            this.u.c.setVisibility(8);
        } else {
            this.u.c.setVisibility(0);
        }
    }

    public final void a() {
        this.u.b.D();
    }
}
