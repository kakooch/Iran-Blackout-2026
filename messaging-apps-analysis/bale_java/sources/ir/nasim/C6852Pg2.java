package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J+\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lir/nasim/Pg2;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "T8", "U8", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "r1", "Ljava/lang/String;", "S8", "()Ljava/lang/String;", "setFlavour", "(Ljava/lang/String;)V", "getFlavour$annotations", "flavour", "call_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Pg2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6852Pg2 extends FW2 {

    /* renamed from: r1, reason: from kotlin metadata */
    public String flavour;

    /* renamed from: ir.nasim.Pg2$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Pg2$a$a, reason: collision with other inner class name */
        static final class C0578a implements InterfaceC14603iB2 {
            final /* synthetic */ C6852Pg2 a;

            /* renamed from: ir.nasim.Pg2$a$a$a, reason: collision with other inner class name */
            /* synthetic */ class C0579a extends EB2 implements SA2 {
                C0579a(Object obj) {
                    super(0, obj, C6852Pg2.class, "openBazzar", "openBazzar()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C6852Pg2) this.receiver).U8();
                }
            }

            /* renamed from: ir.nasim.Pg2$a$a$b */
            /* synthetic */ class b extends EB2 implements SA2 {
                b(Object obj) {
                    super(0, obj, C6852Pg2.class, "onClosePressed", "onClosePressed()V", 0);
                }

                @Override // ir.nasim.SA2
                public /* bridge */ /* synthetic */ Object invoke() {
                    y();
                    return C19938rB7.a;
                }

                public final void y() {
                    ((C6852Pg2) this.receiver).T8();
                }
            }

            C0578a(C6852Pg2 c6852Pg2) {
                this.a = c6852Pg2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C6852Pg2 c6852Pg2 = this.a;
                interfaceC22053ub1.W(1500661242);
                boolean zD = interfaceC22053ub1.D(c6852Pg2);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new C0579a(c6852Pg2);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC16733lm3 interfaceC16733lm3 = (InterfaceC16733lm3) objB;
                interfaceC22053ub1.Q();
                C6852Pg2 c6852Pg22 = this.a;
                interfaceC22053ub1.W(1500663006);
                boolean zD2 = interfaceC22053ub1.D(c6852Pg22);
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new b(c6852Pg22);
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC5389Jd0.d((SA2) ((InterfaceC16733lm3) objB2), (SA2) interfaceC16733lm3, null, interfaceC22053ub1, 0, 4);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-863823305, true, new C0578a(C6852Pg2.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T8() {
        Q7().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U8() {
        if (AbstractC20762sZ6.X(S8(), "bazaar", false, 2, null)) {
            Intent intent = new Intent("android.intent.action.EDIT");
            FragmentActivity fragmentActivityA5 = A5();
            intent.setData(Uri.parse("bazaar://details?id=" + (fragmentActivityA5 != null ? fragmentActivityA5.getPackageName() : null)));
            intent.setPackage("com.farsitel.bazaar");
            n8(intent);
            return;
        }
        if (AbstractC20762sZ6.X(S8(), "myket", false, 2, null) || AbstractC20762sZ6.X(S8(), "bale", false, 2, null)) {
            FragmentActivity fragmentActivityA52 = A5();
            String str = "myket://comment?id=" + (fragmentActivityA52 != null ? fragmentActivityA52.getPackageName() : null);
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            n8(intent2);
            return;
        }
        FragmentActivity fragmentActivityQ7 = Q7();
        FragmentActivity fragmentActivityA53 = A5();
        fragmentActivityQ7.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://cafebazaar.ir/app/?id=" + (fragmentActivityA53 != null ? fragmentActivityA53.getPackageName() : null))).addFlags(268435456));
        T8();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        C6879Pj2.a.r();
        composeView.setContent(AbstractC19242q11.c(79821628, true, new a()));
        return composeView;
    }

    public final String S8() {
        String str = this.flavour;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y("flavour");
        return null;
    }
}
