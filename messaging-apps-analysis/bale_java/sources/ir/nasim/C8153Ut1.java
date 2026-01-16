package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C8153Ut1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006%²\u0006\f\u0010\"\u001a\u00020!8\nX\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u00020#8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/Ut1;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Wx2;", "h1", "Lir/nasim/bW7;", "T9", "()Lir/nasim/Wx2;", "binding", "Lir/nasim/bi5;", "i1", "Lir/nasim/Yu3;", "U9", "()Lir/nasim/bi5;", "viewModel", "j1", "a", "Lir/nasim/ai5;", "uiState", "", "isButtonEnabled", "chat_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ut1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8153Ut1 extends AbstractC18349oW2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new c(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;
    static final /* synthetic */ InterfaceC5239Im3[] k1 = {AbstractC10882cM5.i(new C25226zw5(C8153Ut1.class, "binding", "getBinding()Lir/nasim/chat/databinding/FragmentCreatePollBinding;", 0))};

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: ir.nasim.Ut1$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C8153Ut1 a(long j, long j2, long j3, int i) {
            C8153Ut1 c8153Ut1 = new C8153Ut1();
            Bundle bundle = new Bundle();
            bundle.putLong("unique_id", j);
            bundle.putLong("thread_id", j2);
            bundle.putLong("thread_date", j3);
            bundle.putInt("expeer_value", i);
            c8153Ut1.a8(bundle);
            return c8153Ut1;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ut1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        /* renamed from: ir.nasim.Ut1$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8153Ut1 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8153Ut1 c8153Ut1, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8153Ut1;
                this.d = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (b.y(this.d).f()) {
                    C8153Ut1 c8153Ut1 = this.c;
                    C22042ua0.m9(c8153Ut1, c8153Ut1, false, 2, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(ComposeView composeView) {
            this.b = composeView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(C8153Ut1 c8153Ut1) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().S0();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(C8153Ut1 c8153Ut1, boolean z) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().b1(z);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 C(C8153Ut1 c8153Ut1, boolean z) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().a1(z);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 D(C8153Ut1 c8153Ut1, int i, int i2) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().Z0(i, i2);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 E(C8153Ut1 c8153Ut1, String str) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            AbstractC13042fc3.i(str, "it");
            c8153Ut1.U9().e1(str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 F(C8153Ut1 c8153Ut1, int i) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().U0(i);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 G(C8153Ut1 c8153Ut1, int i, String str) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            AbstractC13042fc3.i(str, "newText");
            c8153Ut1.U9().c1(i, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 H(C8153Ut1 c8153Ut1) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            c8153Ut1.U9().R0();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean I(InterfaceC9664aL6 interfaceC9664aL6) {
            int i;
            AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
            List listC = y(interfaceC9664aL6).c();
            if ((listC instanceof Collection) && listC.isEmpty()) {
                i = 0;
            } else {
                Iterator it = listC.iterator();
                i = 0;
                while (it.hasNext()) {
                    if ((!AbstractC20762sZ6.n0((String) it.next())) && (i = i + 1) < 0) {
                        AbstractC10360bX0.v();
                    }
                }
            }
            return i >= 2 && (AbstractC20762sZ6.n0(y(interfaceC9664aL6).d()) ^ true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 J(C8153Ut1 c8153Ut1, InterfaceC9664aL6 interfaceC9664aL6) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            AbstractC13042fc3.i(interfaceC9664aL6, "$uiState$delegate");
            C10498bi5 c10498bi5U9 = c8153Ut1.U9();
            long jL = AbstractC17026mG5.a.l(Long.MAX_VALUE);
            EnumC9058Yh5 enumC9058Yh5 = y(interfaceC9664aL6).g() ? EnumC9058Yh5.a : EnumC9058Yh5.b;
            boolean zH = y(interfaceC9664aL6).h();
            List listC = y(interfaceC9664aL6).c();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listC) {
                if (!AbstractC20762sZ6.n0((String) obj)) {
                    arrayList.add(obj);
                }
            }
            String strD = y(interfaceC9664aL6).d();
            Bundle bundleE5 = c8153Ut1.E5();
            ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(bundleE5 != null ? bundleE5.getInt("expeer_value") : 2);
            AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
            c10498bi5U9.T0(jL, enumC9058Yh5, zH, arrayList, strD, exPeerTypeFromValue);
            return C19938rB7.a;
        }

        private static final boolean K(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 L(C8153Ut1 c8153Ut1) {
            AbstractC13042fc3.i(c8153Ut1, "this$0");
            C22042ua0.m9(c8153Ut1, c8153Ut1, false, 2, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 M() {
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C9878ai5 y(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C9878ai5) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z() {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            x((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void x(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String string = null;
            final InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(C8153Ut1.this.U9().X0(), null, interfaceC22053ub1, 0, 1);
            interfaceC22053ub1.W(-520440506);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.Vt1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return Boolean.valueOf(C8153Ut1.b.I(interfaceC9664aL6B));
                    }
                });
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB;
            interfaceC22053ub1.Q();
            Boolean boolValueOf = Boolean.valueOf(y(interfaceC9664aL6B).f());
            interfaceC22053ub1.W(-520432342);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6B) | interfaceC22053ub1.D(C8153Ut1.this);
            C8153Ut1 c8153Ut1 = C8153Ut1.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new a(c8153Ut1, interfaceC9664aL6B, null);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB2, interfaceC22053ub1, 0);
            boolean zK = K(interfaceC9664aL6);
            List listC = y(interfaceC9664aL6B).c();
            String strD = y(interfaceC9664aL6B).d();
            boolean zH = y(interfaceC9664aL6B).h();
            boolean zG = y(interfaceC9664aL6B).g();
            if (y(interfaceC9664aL6B).e() != null) {
                Context context = this.b.getContext();
                Integer numE = y(interfaceC9664aL6B).e();
                AbstractC13042fc3.f(numE);
                string = context.getString(numE.intValue());
            }
            String str = string;
            Bundle bundleE5 = C8153Ut1.this.E5();
            boolean z = bundleE5 != null && bundleE5.getInt("expeer_value") == ExPeerType.GROUP.getValue();
            interfaceC22053ub1.W(-520424898);
            boolean zD = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut12 = C8153Ut1.this;
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.cu1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.L(c8153Ut12);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa2 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520420834);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.du1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.M();
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            SA2 sa22 = (SA2) objB4;
            interfaceC22053ub1.Q();
            C8153Ut1 c8153Ut13 = C8153Ut1.this;
            interfaceC22053ub1.W(-520417154);
            Object objB5 = interfaceC22053ub1.B();
            if (objB5 == aVar.a()) {
                objB5 = new SA2() { // from class: ir.nasim.eu1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.z();
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            SA2 sa23 = (SA2) objB5;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520346576);
            boolean zD2 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut14 = C8153Ut1.this;
            boolean z2 = z;
            Object objB6 = interfaceC22053ub1.B();
            if (zD2 || objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.fu1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.A(c8153Ut14);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            SA2 sa24 = (SA2) objB6;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520384974);
            boolean zD3 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut15 = C8153Ut1.this;
            Object objB7 = interfaceC22053ub1.B();
            if (zD3 || objB7 == aVar.a()) {
                objB7 = new UA2() { // from class: ir.nasim.gu1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8153Ut1.b.B(c8153Ut15, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB7);
            }
            UA2 ua2 = (UA2) objB7;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520380967);
            boolean zD4 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut16 = C8153Ut1.this;
            Object objB8 = interfaceC22053ub1.B();
            if (zD4 || objB8 == aVar.a()) {
                objB8 = new UA2() { // from class: ir.nasim.hu1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8153Ut1.b.C(c8153Ut16, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB8);
            }
            UA2 ua22 = (UA2) objB8;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520410283);
            boolean zD5 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut17 = C8153Ut1.this;
            Object objB9 = interfaceC22053ub1.B();
            if (zD5 || objB9 == aVar.a()) {
                objB9 = new InterfaceC14603iB2() { // from class: ir.nasim.Wt1
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C8153Ut1.b.D(c8153Ut17, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    }
                };
                interfaceC22053ub1.s(objB9);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB9;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520405439);
            boolean zD6 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut18 = C8153Ut1.this;
            Object objB10 = interfaceC22053ub1.B();
            if (zD6 || objB10 == aVar.a()) {
                objB10 = new UA2() { // from class: ir.nasim.Xt1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8153Ut1.b.E(c8153Ut18, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB10);
            }
            UA2 ua23 = (UA2) objB10;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520396199);
            boolean zD7 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut19 = C8153Ut1.this;
            Object objB11 = interfaceC22053ub1.B();
            if (zD7 || objB11 == aVar.a()) {
                objB11 = new UA2() { // from class: ir.nasim.Yt1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C8153Ut1.b.F(c8153Ut19, ((Integer) obj).intValue());
                    }
                };
                interfaceC22053ub1.s(objB11);
            }
            UA2 ua24 = (UA2) objB11;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520401311);
            boolean zD8 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut110 = C8153Ut1.this;
            Object objB12 = interfaceC22053ub1.B();
            if (zD8 || objB12 == aVar.a()) {
                objB12 = new InterfaceC14603iB2() { // from class: ir.nasim.Zt1
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj, Object obj2) {
                        return C8153Ut1.b.G(c8153Ut110, ((Integer) obj).intValue(), (String) obj2);
                    }
                };
                interfaceC22053ub1.s(objB12);
            }
            InterfaceC14603iB2 interfaceC14603iB22 = (InterfaceC14603iB2) objB12;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520392369);
            boolean zD9 = interfaceC22053ub1.D(C8153Ut1.this);
            final C8153Ut1 c8153Ut111 = C8153Ut1.this;
            Object objB13 = interfaceC22053ub1.B();
            if (zD9 || objB13 == aVar.a()) {
                objB13 = new SA2() { // from class: ir.nasim.au1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.H(c8153Ut111);
                    }
                };
                interfaceC22053ub1.s(objB13);
            }
            SA2 sa25 = (SA2) objB13;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-520376619);
            boolean zD10 = interfaceC22053ub1.D(C8153Ut1.this) | interfaceC22053ub1.V(interfaceC9664aL6B);
            final C8153Ut1 c8153Ut112 = C8153Ut1.this;
            Object objB14 = interfaceC22053ub1.B();
            if (zD10 || objB14 == aVar.a()) {
                objB14 = new SA2() { // from class: ir.nasim.bu1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C8153Ut1.b.J(c8153Ut112, interfaceC9664aL6B);
                    }
                };
                interfaceC22053ub1.s(objB14);
            }
            interfaceC22053ub1.Q();
            AbstractC25193zt1.B(sa2, sa22, c8153Ut13, sa23, zK, listC, strD, zH, zG, z2, str, sa24, ua2, ua22, interfaceC14603iB2, ua23, ua24, interfaceC14603iB22, sa25, (SA2) objB14, interfaceC22053ub1, 3120, 0, 0);
        }
    }

    /* renamed from: ir.nasim.Ut1$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C8658Wx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Ut1$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Ut1$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Ut1$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Ut1$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Ut1$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C8153Ut1() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new e(new d(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10498bi5.class), new f(interfaceC9173Yu3B), new g(null, interfaceC9173Yu3B), new h(this, interfaceC9173Yu3B));
    }

    private final C8658Wx2 T9() {
        Object objA = this.binding.a(this, k1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C8658Wx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10498bi5 U9() {
        return (C10498bi5) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        return inflater.inflate(AbstractC10185bD5.fragment_create_poll, container, false).getRootView();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        ComposeView composeView = T9().b;
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(1797067139, true, new b(composeView)));
    }
}
