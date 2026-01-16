package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import ir.nasim.C24175yA1;
import ir.nasim.C9475a16;
import java.util.Calendar;
import java.util.Date;

/* renamed from: ir.nasim.yA1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C24175yA1 extends com.google.android.material.bottomsheet.b {
    private final String n1;
    private final String o1;
    private final Long p1;
    private final Long q1;
    private final Long r1;
    private final UA2 s1;
    private final SA2 t1;
    private final boolean u1;

    /* renamed from: ir.nasim.yA1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView a;
        final /* synthetic */ C24175yA1 b;

        a(ComposeView composeView, C24175yA1 c24175yA1) {
            this.a = composeView;
            this.b = c24175yA1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C24175yA1 c24175yA1) {
            AbstractC13042fc3.i(c24175yA1, "this$0");
            c24175yA1.v8();
            SA2 sa2 = c24175yA1.t1;
            if (sa2 != null) {
                sa2.invoke();
            }
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            Date time;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            this.a.setViewCompositionStrategy(v.b.b);
            String str = this.b.n1;
            String str2 = this.b.o1;
            Long l = this.b.q1;
            if (l != null) {
                time = new Date(l.longValue());
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.add(1, -7);
                time = calendar.getTime();
            }
            Date date = time;
            AbstractC13042fc3.f(date);
            Long l2 = this.b.r1;
            Date date2 = l2 != null ? new Date(l2.longValue()) : new Date();
            Date date3 = this.b.p1 != null ? new Date(this.b.p1.longValue()) : new Date();
            UA2 ua2 = this.b.s1;
            boolean z = this.b.u1;
            interfaceC22053ub1.W(50246561);
            boolean zV = interfaceC22053ub1.V(this.b);
            final C24175yA1 c24175yA1 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.xA1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C24175yA1.a.c(c24175yA1);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC19332qA1.e(str, date2, date, ua2, (SA2) objB, null, str2, date3, z, interfaceC22053ub1, 0, 32);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ C24175yA1(String str, String str2, Long l, Long l2, Long l3, UA2 ua2, SA2 sa2, boolean z, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, ua2, (i & 64) != 0 ? null : sa2, (i & 128) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z8(com.google.android.material.bottomsheet.a aVar, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(aVar, "$this_apply");
        aVar.o().J0(4);
        aVar.o().x0(false);
    }

    private final Object a9(View view) {
        try {
            C9475a16.a aVar = C9475a16.b;
            Object parent = view.getParent();
            AbstractC13042fc3.g(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setBackgroundColor(AbstractC4043Dl1.c(S7(), android.R.color.transparent));
            return C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        final com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(S7());
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setContent(AbstractC19242q11.c(-1209312206, true, new a(composeView, this)));
        aVar.setContentView(composeView);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.wA1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                C24175yA1.Z8(aVar, dialogInterface);
            }
        });
        a9(composeView);
        return aVar;
    }

    public C24175yA1(String str, String str2, Long l, Long l2, Long l3, UA2 ua2, SA2 sa2, boolean z) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(ua2, "onDateSelected");
        this.n1 = str;
        this.o1 = str2;
        this.p1 = l;
        this.q1 = l2;
        this.r1 = l3;
        this.s1 = ua2;
        this.t1 = sa2;
        this.u1 = z;
    }
}
