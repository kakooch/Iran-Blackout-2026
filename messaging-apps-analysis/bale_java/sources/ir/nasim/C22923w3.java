package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C21753u45;
import ir.nasim.C22923w3;
import ir.nasim.core.modules.profile.entity.Avatar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ+\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0017¢\u0006\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u00108\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010404038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010:\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u00010404038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107¨\u0006?²\u0006\f\u0010>\u001a\u00020=8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/w3;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/I3;", "xa", "()Lir/nasim/I3;", "", ParameterNames.TEXT, "Lir/nasim/rB7;", "ta", "(Ljava/lang/String;)V", "Ha", "oa", "na", "", "avatarId", "Da", "(J)V", "Lir/nasim/core/modules/profile/entity/Avatar;", "avatar", "Ea", "(Lir/nasim/core/modules/profile/entity/Avatar;)V", "snackBarMessage", "Ia", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/A4;", "h1", "Lir/nasim/Yu3;", "wa", "()Lir/nasim/A4;", "viewModel", "Lir/nasim/k05;", "i1", "Lir/nasim/k05;", "va", "()Lir/nasim/k05;", "setPassportNavigator", "(Lir/nasim/k05;)V", "passportNavigator", "j1", "Ljava/lang/String;", "externalFile", "Lir/nasim/v6;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "k1", "Lir/nasim/v6;", "galleryResultCollectAvatarLauncher", "l1", "cameraResultCollectAvatarLauncher", "m1", "a", "Lir/nasim/x4;", "state", "settings_productionRelease"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.w3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22923w3 extends GV2 {
    public static final int n1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    public InterfaceC15690k05 passportNavigator;

    /* renamed from: j1, reason: from kotlin metadata */
    private String externalFile;

    /* renamed from: k1, reason: from kotlin metadata */
    private final AbstractC22357v6 galleryResultCollectAvatarLauncher;

    /* renamed from: l1, reason: from kotlin metadata */
    private final AbstractC22357v6 cameraResultCollectAvatarLauncher;

    /* renamed from: ir.nasim.w3$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.w3$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C22923w3 a;
            final /* synthetic */ InterfaceC9664aL6 b;

            a(C22923w3 c22923w3, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c22923w3;
                this.b = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 A(C22923w3 c22923w3) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                c22923w3.na();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 B(C22923w3 c22923w3, Avatar avatar) throws IOException {
                AbstractC13042fc3.i(c22923w3, "this$0");
                AbstractC13042fc3.i(avatar, "it");
                c22923w3.Ea(avatar);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C22923w3 c22923w3, String str) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                AbstractC13042fc3.i(str, "it");
                c22923w3.ta(str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 t(C22923w3 c22923w3, long j) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                c22923w3.Da(j);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 v(C22923w3 c22923w3, String str) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                AbstractC13042fc3.i(str, "it");
                c22923w3.Ia(str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 w(C22923w3 c22923w3) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                c22923w3.wa().e1();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 x(C22923w3 c22923w3) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                c22923w3.Q7().onBackPressed();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C22923w3 c22923w3, String str) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                AbstractC13042fc3.i(str, "it");
                c22923w3.Ha(str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 z(C22923w3 c22923w3) {
                AbstractC13042fc3.i(c22923w3, "this$0");
                c22923w3.oa();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                o((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }

            public final void o(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C23523x4 c23523x4C = b.c(this.b);
                I3 i3Xa = this.a.xa();
                interfaceC22053ub1.W(921375496);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w3 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.x3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C22923w3.b.a.p(c22923w3, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921377314);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w32 = this.a;
                Object objB2 = interfaceC22053ub1.B();
                if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.y3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C22923w3.b.a.y(c22923w32, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921379278);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w33 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.z3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C22923w3.b.a.z(c22923w33);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                SA2 sa2 = (SA2) objB3;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921381579);
                boolean zD4 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w34 = this.a;
                Object objB4 = interfaceC22053ub1.B();
                if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.A3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C22923w3.b.a.A(c22923w34);
                        }
                    };
                    interfaceC22053ub1.s(objB4);
                }
                SA2 sa22 = (SA2) objB4;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921383814);
                boolean zD5 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w35 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new UA2() { // from class: ir.nasim.B3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C22923w3.b.a.B(c22923w35, (Avatar) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                UA2 ua23 = (UA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921385669);
                boolean zD6 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w36 = this.a;
                Object objB6 = interfaceC22053ub1.B();
                if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new UA2() { // from class: ir.nasim.C3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C22923w3.b.a.t(c22923w36, ((Long) obj).longValue());
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                UA2 ua24 = (UA2) objB6;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921387823);
                boolean zD7 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w37 = this.a;
                Object objB7 = interfaceC22053ub1.B();
                if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                    objB7 = new UA2() { // from class: ir.nasim.D3
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C22923w3.b.a.v(c22923w37, (String) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB7);
                }
                UA2 ua25 = (UA2) objB7;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921389998);
                boolean zD8 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w38 = this.a;
                Object objB8 = interfaceC22053ub1.B();
                if (zD8 || objB8 == InterfaceC22053ub1.a.a()) {
                    objB8 = new SA2() { // from class: ir.nasim.E3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C22923w3.b.a.w(c22923w38);
                        }
                    };
                    interfaceC22053ub1.s(objB8);
                }
                SA2 sa23 = (SA2) objB8;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(921392086);
                boolean zD9 = interfaceC22053ub1.D(this.a);
                final C22923w3 c22923w39 = this.a;
                Object objB9 = interfaceC22053ub1.B();
                if (zD9 || objB9 == InterfaceC22053ub1.a.a()) {
                    objB9 = new SA2() { // from class: ir.nasim.F3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C22923w3.b.a.x(c22923w39);
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC19861r4.I(c23523x4C, i3Xa, ua2, ua22, sa2, sa22, ua23, ua24, ua25, sa23, (SA2) objB9, interfaceC22053ub1, 0, 0);
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C23523x4 c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C23523x4) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1288688774, true, new a(C22923w3.this, AbstractC5976Lq2.c(C22923w3.this.wa().b1(), null, null, null, interfaceC22053ub1, 0, 7)), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w3$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.w3$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.w3$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.w3$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.w3$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C22923w3() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(A4.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
        this.externalFile = "";
        AbstractC22357v6 abstractC22357v6N7 = N7(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.n3
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C22923w3.ua(this.a, (ActivityResult) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N7, "registerForActivityResult(...)");
        this.galleryResultCollectAvatarLauncher = abstractC22357v6N7;
        AbstractC22357v6 abstractC22357v6N72 = N7(new C20490s6(), new InterfaceC17517n6() { // from class: ir.nasim.o3
            @Override // ir.nasim.InterfaceC17517n6
            public final void a(Object obj) {
                C22923w3.ra(this.a, (ActivityResult) obj);
            }
        });
        AbstractC13042fc3.h(abstractC22357v6N72, "registerForActivityResult(...)");
        this.cameraResultCollectAvatarLauncher = abstractC22357v6N72;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(C22923w3 c22923w3) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        C22042ua0.A9(c22923w3, new B42(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(C22923w3 c22923w3) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        C22042ua0.A9(c22923w3, new C12108e32(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(C22923w3 c22923w3) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        C22042ua0.A9(c22923w3, new UI0(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da(long avatarId) {
        wa().d1(avatarId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea(Avatar avatar) throws IOException {
        if (Build.VERSION.SDK_INT > 29 || C21753u45.V(C5721Ko.a.d())) {
            wa().f1(avatar);
        } else {
            C21753u45.a.N0(this, 0, null, new SA2() { // from class: ir.nasim.p3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C22923w3.Fa();
                }
            }, new SA2() { // from class: ir.nasim.q3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C22923w3.Ga();
                }
            }, C21753u45.d.j, C21753u45.d.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Fa() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ha(String text) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", text);
        n8(Intent.createChooser(intent, h6(QD5.menu_share)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ia(String snackBarMessage) {
        if (KV0.b()) {
            wa().g1(snackBarMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na() {
        if (AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.CAMERA") != 0) {
            C21753u45.j0(C21753u45.a, this, 3, C21753u45.d.f, null, 8, null);
            return;
        }
        this.externalFile = C4053Dm2.l("capture", "jpg");
        this.cameraResultCollectAvatarLauncher.a(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.externalFile))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oa() {
        if (AbstractC4043Dl1.a(C5721Ko.a.d(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.a.N0(this, 0, null, new SA2() { // from class: ir.nasim.r3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C22923w3.pa();
                }
            }, new SA2() { // from class: ir.nasim.s3
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C22923w3.qa();
                }
            }, C21753u45.d.j, C21753u45.d.m);
            return;
        }
        AbstractC22357v6 abstractC22357v6 = this.galleryResultCollectAvatarLauncher;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        abstractC22357v6.a(C22055ub3.j(contextS7, true, false, false, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 pa() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(final C22923w3 c22923w3, ActivityResult activityResult) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        AbstractC13042fc3.i(activityResult, "activityResult");
        if (activityResult.getResultCode() == -1 && c22923w3.externalFile.length() > 0 && new File(c22923w3.externalFile).exists()) {
            AbstractC17543n85.a(null, c22923w3.Q7(), c22923w3.externalFile, 1, false, new AbstractC17543n85.b() { // from class: ir.nasim.t3
                @Override // ir.nasim.AbstractC17543n85.b
                public final void a(String str, String str2) {
                    C22923w3.sa(this.a, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(C22923w3 c22923w3, String str, String str2) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        if (str != null) {
            c22923w3.wa().W0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(String text) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        KV0.a(contextS7, text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(C22923w3 c22923w3, ActivityResult activityResult) {
        Intent data;
        AbstractC13042fc3.i(c22923w3, "this$0");
        AbstractC13042fc3.i(activityResult, "activityResult");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) (Build.VERSION.SDK_INT >= 33 ? data.getSerializableExtra("PHOTOS", ArrayList.class) : data.getSerializableExtra("PHOTOS"));
        String str = (String) (arrayList != null ? AbstractC15401jX0.s0(arrayList) : null);
        if (str != null) {
            c22923w3.wa().W0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final A4 wa() {
        return (A4) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final I3 xa() {
        return new I3(new SA2() { // from class: ir.nasim.u3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22923w3.za(this.a);
            }
        }, new SA2() { // from class: ir.nasim.v3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22923w3.Aa(this.a);
            }
        }, new SA2() { // from class: ir.nasim.k3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22923w3.Ba(this.a);
            }
        }, new SA2() { // from class: ir.nasim.l3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22923w3.Ca(this.a);
            }
        }, new SA2() { // from class: ir.nasim.m3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C22923w3.ya(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(C22923w3 c22923w3) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        C22042ua0.A9(c22923w3, c22923w3.va().a(), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(C22923w3 c22923w3) {
        AbstractC13042fc3.i(c22923w3, "this$0");
        C22042ua0.A9(c22923w3, new S32(), false, null, 6, null);
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-420970975, true, new b()));
        return composeView;
    }

    public final InterfaceC15690k05 va() {
        InterfaceC15690k05 interfaceC15690k05 = this.passportNavigator;
        if (interfaceC15690k05 != null) {
            return interfaceC15690k05;
        }
        AbstractC13042fc3.y("passportNavigator");
        return null;
    }
}
