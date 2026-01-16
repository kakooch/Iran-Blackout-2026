package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C15053iv6;
import ir.nasim.C21753u45;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.MX7;
import ir.nasim.OJ1;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\u000e2\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J+\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006D²\u0006\f\u0010C\u001a\u00020B8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/iv6;", "Lir/nasim/ua0;", "<init>", "()V", "", "path", "Lir/nasim/rB7;", "Wa", "(Ljava/lang/String;)V", "ua", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "xa", "(Ljava/lang/String;)Landroid/net/Uri;", "", "titleText", "descriptionText", "startButtonText", "Lkotlin/Function0;", "Lir/nasim/settings/ui/utilities/UnitCallback;", "startButtonCallback", "za", "(IIILir/nasim/SA2;)V", "va", "Lir/nasim/nw6;", "Ja", "()Lir/nasim/nw6;", "ra", "()Lir/nasim/ua0;", "Lir/nasim/rv6;", "Ca", "()Lir/nasim/rv6;", "Lir/nasim/Lu6;", "Aa", "()Lir/nasim/Lu6;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/cw6;", "h1", "Lir/nasim/Yu3;", "ya", "()Lir/nasim/cw6;", "viewModel", "Lir/nasim/vt2;", "i1", "Lir/nasim/vt2;", "ta", "()Lir/nasim/vt2;", "setFoldersNavigator", "(Lir/nasim/vt2;)V", "foldersNavigator", "Lir/nasim/rd1;", "j1", "Lir/nasim/rd1;", "sa", "()Lir/nasim/rd1;", "setConnectionListItemProvider$settings_productionRelease", "(Lir/nasim/rd1;)V", "connectionListItemProvider", "Lir/nasim/bw6;", "state", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.iv6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C15053iv6 extends LX2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC22824vt2 foldersNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    public InterfaceC20203rd1 connectionListItemProvider;

    /* renamed from: ir.nasim.iv6$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        /* renamed from: ir.nasim.iv6$a$a, reason: collision with other inner class name */
        static final class C1307a implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            C1307a(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.z0(this.a, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.iv6$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.c(this.a, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2, int i, int i2, int i3) {
            this.a = sa2;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2, Dialog dialog) {
            AbstractC13042fc3.i(sa2, "$startButtonCallback");
            AbstractC13042fc3.i(dialog, "$dialog");
            sa2.invoke();
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$dialog");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "dialog");
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            int i2 = QD5.enable_log_dialog_negative_btn;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-284995114, true, new C1307a(this.c), interfaceC22053ub1, 54);
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(67661400, true, new b(this.d), interfaceC22053ub1, 54);
            interfaceC22053ub1.W(1045793897);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.D(dialog);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.gv6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C15053iv6.a.d(sa2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i3 = this.b;
            interfaceC22053ub1.W(1045801951);
            boolean zD = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.hv6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C15053iv6.a.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa22, i3, c1454b, (SA2) objB2, i2, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iv6$b */
    /* synthetic */ class b extends EB2 implements UA2 {
        b(Object obj) {
            super(1, obj, C15053iv6.class, "showFragmentWithLeftSlideInAnimation", "showFragmentWithLeftSlideInAnimation(Landroidx/fragment/app/Fragment;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((Fragment) obj);
            return C19938rB7.a;
        }

        public final void y(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "p0");
            ((C15053iv6) this.receiver).x9(fragment);
        }
    }

    /* renamed from: ir.nasim.iv6$c */
    static final class c implements LX7 {
        public static final c a = new c();

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 b(c cVar, SA2 sa2, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            AbstractC13042fc3.i(cVar, "$tmp0_rcvr");
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(ua2, "$$unused$var$");
            cVar.I(sa2, ua2, interfaceC22053ub1, QJ5.a(i | 1));
            return C19938rB7.a;
        }

        @Override // ir.nasim.LX7
        public final void I(final SA2 sa2, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
            int i2;
            AbstractC13042fc3.i(sa2, "onBackPressed");
            AbstractC13042fc3.i(ua2, "$unused$var$");
            InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1213273866);
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1J.V(this) ? 256 : 128;
            }
            if ((i2 & 131) == 130 && interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.L();
            } else {
                AbstractC21266tO6.f0(sa2, null, null, interfaceC22053ub1J, i2 & 14, 6);
            }
            InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
            if (interfaceC20208rd6M != null) {
                interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jv6
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C15053iv6.c.b(this.a, sa2, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
    }

    /* renamed from: ir.nasim.iv6$d */
    static final class d implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.iv6$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C15053iv6 a;

            /* renamed from: ir.nasim.iv6$d$a$a, reason: collision with other inner class name */
            static final class C1308a implements InterfaceC14603iB2 {
                final /* synthetic */ C15053iv6 a;
                final /* synthetic */ InterfaceC9664aL6 b;

                C1308a(C15053iv6 c15053iv6, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c15053iv6;
                    this.b = interfaceC9664aL6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 h(C15053iv6 c15053iv6) {
                    AbstractC13042fc3.i(c15053iv6, "this$0");
                    c15053iv6.Q7().onBackPressed();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 i(C15053iv6 c15053iv6) {
                    AbstractC13042fc3.i(c15053iv6, "this$0");
                    c15053iv6.ya().y1();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 k(C15053iv6 c15053iv6) {
                    AbstractC13042fc3.i(c15053iv6, "this$0");
                    c15053iv6.ya().o1();
                    return C19938rB7.a;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 n(C15053iv6 c15053iv6, String str) {
                    AbstractC13042fc3.i(c15053iv6, "this$0");
                    c15053iv6.Wa(str);
                    return C19938rB7.a;
                }

                public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    C10639bw6 c10639bw6C = a.c(this.b);
                    interfaceC22053ub1.W(1967905951);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C15053iv6 c15053iv6 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.kv6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C15053iv6.d.a.C1308a.h(c15053iv6);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    SA2 sa2 = (SA2) objB;
                    interfaceC22053ub1.Q();
                    C18018nw6 c18018nw6Ja = this.a.Ja();
                    C20390rv6 c20390rv6Ca = this.a.Ca();
                    C6015Lu6 c6015Lu6Aa = this.a.Aa();
                    interfaceC22053ub1.W(1967917892);
                    boolean zD2 = interfaceC22053ub1.D(this.a);
                    final C15053iv6 c15053iv62 = this.a;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.lv6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C15053iv6.d.a.C1308a.i(c15053iv62);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    SA2 sa22 = (SA2) objB2;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1967920360);
                    boolean zD3 = interfaceC22053ub1.D(this.a);
                    final C15053iv6 c15053iv63 = this.a;
                    Object objB3 = interfaceC22053ub1.B();
                    if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                        objB3 = new SA2() { // from class: ir.nasim.mv6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C15053iv6.d.a.C1308a.k(c15053iv63);
                            }
                        };
                        interfaceC22053ub1.s(objB3);
                    }
                    SA2 sa23 = (SA2) objB3;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1967922839);
                    boolean zD4 = interfaceC22053ub1.D(this.a);
                    final C15053iv6 c15053iv64 = this.a;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new UA2() { // from class: ir.nasim.nv6
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C15053iv6.d.a.C1308a.n(c15053iv64, (String) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    defpackage.C.d(c10639bw6C, sa2, c18018nw6Ja, c20390rv6Ca, c6015Lu6Aa, sa22, sa23, (UA2) objB4, interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C15053iv6 c15053iv6) {
                this.a = c15053iv6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C10639bw6 c(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C10639bw6) interfaceC9664aL6.getValue();
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC11024cc1.a(AbstractC22073ud1.c().d(this.a.sa()), AbstractC19242q11.e(-1382286063, true, new C1308a(this.a, AbstractC5976Lq2.c(this.a.ya().k1(), null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1578400209, true, new a(C15053iv6.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iv6$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.iv6$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.iv6$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.iv6$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = sa2;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            if (sa2 != null && (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) != null) {
                return abstractC20375ru1;
            }
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            return hVar != null ? hVar.p3() : AbstractC20375ru1.a.b;
        }
    }

    /* renamed from: ir.nasim.iv6$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = fragment;
            this.f = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            G.c cVarN3;
            InterfaceC15408jX7 interfaceC15408jX7C = AbstractC6550Nz2.c(this.f);
            androidx.lifecycle.h hVar = interfaceC15408jX7C instanceof androidx.lifecycle.h ? (androidx.lifecycle.h) interfaceC15408jX7C : null;
            if (hVar != null && (cVarN3 = hVar.n3()) != null) {
                return cVarN3;
            }
            G.c cVarN32 = this.e.n3();
            AbstractC13042fc3.h(cVarN32, "defaultViewModelProviderFactory");
            return cVarN32;
        }
    }

    public C15053iv6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new f(new e(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C11402cw6.class), new g(interfaceC9173Yu3B), new h(null, interfaceC9173Yu3B), new i(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6015Lu6 Aa() {
        return new C6015Lu6(new SA2() { // from class: ir.nasim.bv6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ba(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        OJ1.Companion companion = OJ1.INSTANCE;
        Context contextS7 = c15053iv6.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        c15053iv6.n8(companion.a(contextS7));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20390rv6 Ca() {
        return new C20390rv6(new SA2() { // from class: ir.nasim.Mu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Da(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Xu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ea(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Yu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Fa(this.a);
            }
        }, new UA2() { // from class: ir.nasim.Zu6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C15053iv6.Ga(this.a, ((Boolean) obj).booleanValue());
            }
        }, new SA2() { // from class: ir.nasim.av6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ha(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Da(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().j1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ea(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().i1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().e1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga(C15053iv6 c15053iv6, boolean z) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().u1(z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ha(final C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.za(QD5.disable_log_dialog_title, QD5.disable_log_dialog_desc, QD5.disable_log_dialog_negative_btn, new SA2() { // from class: ir.nasim.Uu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ia(this.a);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().g1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C18018nw6 Ja() {
        return new C18018nw6(new SA2() { // from class: ir.nasim.cv6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Qa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.ev6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ra(this.a);
            }
        }, new SA2() { // from class: ir.nasim.fv6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Sa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Nu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ta(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ou6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ua(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Pu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Va(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Qu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ka(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Ru6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.La(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Su6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Ma(this.a);
            }
        }, new SA2() { // from class: ir.nasim.Tu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Na(this.a);
            }
        }, new b(this), new SA2() { // from class: ir.nasim.dv6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Oa(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ka(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, new C21854uF1(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 La(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, new C13239ft3(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, C8386Vt0.Z9() ? new C8793Xi6() : new C4747Gj6(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Na(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, new C22112uh0(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oa(final C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.za(QD5.enable_log_dialog_title, QD5.enable_log_dialog_desc, QD5.enable_log_dialog_positive_btn, new SA2() { // from class: ir.nasim.Wu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.Pa(this.a);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pa(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        c15053iv6.ya().h1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qa(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        if (C8386Vt0.V8()) {
            C22042ua0.A9(c15053iv6, new C18189oE4(), false, null, 6, null);
        } else {
            C22042ua0.A9(c15053iv6, new C8644Wv6(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ra(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, c15053iv6.ra(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Sa(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, new C11577dF(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ta(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C21753u45 c21753u45 = C21753u45.a;
        Context contextS7 = c15053iv6.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (c21753u45.U(contextS7)) {
            C22042ua0.A9(c15053iv6, C8386Vt0.a.L8() ? MX7.Companion.b(MX7.INSTANCE, null, c.a, 1, null) : new ir.nasim.features.settings.a(), false, null, 6, null);
        } else {
            c15053iv6.va();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ua(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, c15053iv6.ta().create(), false, null, 6, null);
        C3343Am.g("click_folders_setting");
        c15053iv6.ya().p1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Va(C15053iv6 c15053iv6) {
        AbstractC13042fc3.i(c15053iv6, "this$0");
        C22042ua0.A9(c15053iv6, new BQ0(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa(String path) {
        if (path != null && path.length() != 0) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(ua(path));
            Uri uriXa = xa(path);
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.STREAM", uriXa);
            n8(Intent.createChooser(intent, h6(AbstractC12217eE5.menu_share)));
        }
        ya().m1();
    }

    private final C22042ua0 ra() {
        return C8386Vt0.a.e8() ? C20358rs4.INSTANCE.a() : new DS();
    }

    private final String ua(String path) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(AbstractC20762sZ6.d1(path, Separators.DOT, null, 2, null));
    }

    private final void va() {
        C21753u45 c21753u45 = C21753u45.a;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        c21753u45.J0(fragmentActivityQ7, 0, new SA2() { // from class: ir.nasim.Vu6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15053iv6.wa();
            }
        }, C21753u45.d.j, C21753u45.d.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa() {
        return C19938rB7.a;
    }

    private final Uri xa(String path) {
        return FileProvider.h(Q7(), S7().getPackageName() + ".provider", new File(path));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C11402cw6 ya() {
        return (C11402cw6) this.viewModel.getValue();
    }

    private final void za(int titleText, int descriptionText, int startButtonText, SA2 startButtonCallback) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-1340470278, true, new a(startButtonCallback, startButtonText, titleText, descriptionText)), 4, null).show();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1753058324, true, new d()));
        return composeView;
    }

    public final InterfaceC20203rd1 sa() {
        InterfaceC20203rd1 interfaceC20203rd1 = this.connectionListItemProvider;
        if (interfaceC20203rd1 != null) {
            return interfaceC20203rd1;
        }
        AbstractC13042fc3.y("connectionListItemProvider");
        return null;
    }

    public final InterfaceC22824vt2 ta() {
        InterfaceC22824vt2 interfaceC22824vt2 = this.foldersNavigator;
        if (interfaceC22824vt2 != null) {
            return interfaceC22824vt2;
        }
        AbstractC13042fc3.y("foldersNavigator");
        return null;
    }
}
