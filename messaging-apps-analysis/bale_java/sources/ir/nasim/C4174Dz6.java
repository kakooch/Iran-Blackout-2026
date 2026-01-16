package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C15225jD4;
import ir.nasim.C4174Dz6;
import ir.nasim.JA3;
import ir.nasim.components.appbar.view.BaleToolbar;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J+\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u00068"}, d2 = {"Lir/nasim/Dz6;", "Lir/nasim/ua0;", "Lir/nasim/jD4$b;", "<init>", "()V", "Lir/nasim/gj3;", "V9", "()Lir/nasim/gj3;", "Landroid/view/View;", "view", "Lir/nasim/rB7;", "Z9", "(Landroid/view/View;)V", "X9", "Landroid/os/Bundle;", "saveInstance", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "", "id", "", "", "args", "didReceivedNotification", "(I[Ljava/lang/Object;)V", "", "h1", "Ljava/lang/String;", "title", "i1", ParameterNames.TEXT, "j1", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/widget/TextView;", "k1", "Landroid/widget/TextView;", "contentTextView", "Landroid/widget/LinearLayout;", "l1", "Landroid/widget/LinearLayout;", "loadingContainer", "Lir/nasim/Gz6;", "m1", "Lir/nasim/Yu3;", "W9", "()Lir/nasim/Gz6;", "viewModel", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Dz6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4174Dz6 extends NX2 implements C15225jD4.b {

    /* renamed from: h1, reason: from kotlin metadata */
    private String title = "";

    /* renamed from: i1, reason: from kotlin metadata */
    private String text = "";

    /* renamed from: j1, reason: from kotlin metadata */
    private ViewGroup viewGroup;

    /* renamed from: k1, reason: from kotlin metadata */
    private TextView contentTextView;

    /* renamed from: l1, reason: from kotlin metadata */
    private LinearLayout loadingContainer;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.Dz6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Dz6$a$a, reason: collision with other inner class name */
        static final class C0331a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C4174Dz6 c;

            /* renamed from: ir.nasim.Dz6$a$a$a, reason: collision with other inner class name */
            static final class C0332a implements InterfaceC4806Gq2 {
                final /* synthetic */ C4174Dz6 a;

                /* renamed from: ir.nasim.Dz6$a$a$a$a, reason: collision with other inner class name */
                static final class C0333a implements InterfaceC15796kB2 {
                    final /* synthetic */ JA3 a;
                    final /* synthetic */ C4174Dz6 b;

                    C0333a(JA3 ja3, C4174Dz6 c4174Dz6) {
                        this.a = ja3;
                        this.b = c4174Dz6;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C4174Dz6 c4174Dz6, JA3 ja3) {
                        AbstractC13042fc3.i(c4174Dz6, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = c4174Dz6.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((JA3.a) ja3).a()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strA = ((JA3.a) this.a).a();
                        interfaceC22053ub1.W(670145777);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final C4174Dz6 c4174Dz6 = this.b;
                        final JA3 ja3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.Cz6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C4174Dz6.a.C0331a.C0332a.C0333a.c(c4174Dz6, ja3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.q(dialog, strA, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Dz6$a$a$a$b */
                static final class b implements InterfaceC15796kB2 {
                    final /* synthetic */ JA3 a;

                    b(JA3 ja3) {
                        this.a = ja3;
                    }

                    public final void a(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        AbstractC10781cB3.n(dialog, ((JA3.b) this.a).b(), interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        a((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Dz6$a$a$a$c */
                static final class c implements InterfaceC15796kB2 {
                    final /* synthetic */ JA3 a;
                    final /* synthetic */ C4174Dz6 b;

                    c(JA3 ja3, C4174Dz6 c4174Dz6) {
                        this.a = ja3;
                        this.b = c4174Dz6;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 c(C4174Dz6 c4174Dz6, JA3 ja3) {
                        AbstractC13042fc3.i(c4174Dz6, "this$0");
                        AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                        Context contextS7 = c4174Dz6.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar.A(contextS7, Uri.parse(((JA3.b) ja3).b()));
                        return C19938rB7.a;
                    }

                    public final void b(Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(dialog, "dialog");
                        String strB = ((JA3.b) this.a).b();
                        interfaceC22053ub1.W(670194425);
                        boolean zD = interfaceC22053ub1.D(this.b) | interfaceC22053ub1.D(this.a);
                        final C4174Dz6 c4174Dz6 = this.b;
                        final JA3 ja3 = this.a;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.Ez6
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C4174Dz6.a.C0331a.C0332a.c.c(c4174Dz6, ja3);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10781cB3.C(dialog, strB, (SA2) objB, interfaceC22053ub1, i & 14);
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        b((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                /* renamed from: ir.nasim.Dz6$a$a$a$d */
                public /* synthetic */ class d {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC4458Ff2.values().length];
                        try {
                            iArr[EnumC4458Ff2.a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC4458Ff2.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[EnumC4458Ff2.c.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        a = iArr;
                    }
                }

                C0332a(C4174Dz6 c4174Dz6) {
                    this.a = c4174Dz6;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(JA3 ja3, InterfaceC20295rm1 interfaceC20295rm1) {
                    LinearLayout linearLayout = this.a.loadingContainer;
                    if (linearLayout == null) {
                        AbstractC13042fc3.y("loadingContainer");
                        linearLayout = null;
                    }
                    linearLayout.setVisibility(8);
                    if (ja3 == null) {
                        return C19938rB7.a;
                    }
                    if (ja3 instanceof JA3.a) {
                        Context contextS7 = this.a.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        C4174Dz6 c4174Dz6 = this.a;
                        AbstractC21375tZ.c(contextS7, c4174Dz6, null, AbstractC19242q11.c(-436004495, true, new C0333a(ja3, c4174Dz6)), 4, null).show();
                    } else {
                        if (!(ja3 instanceof JA3.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        JA3.b bVar = (JA3.b) ja3;
                        int i = d.a[bVar.a().ordinal()];
                        if (i == 1) {
                            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
                            Context contextS72 = this.a.S7();
                            AbstractC13042fc3.h(contextS72, "requireContext(...)");
                            aVar.A(contextS72, Uri.parse(bVar.b()));
                        } else if (i == 2) {
                            Context contextS73 = this.a.S7();
                            AbstractC13042fc3.h(contextS73, "requireContext(...)");
                            AbstractC21375tZ.c(contextS73, this.a, null, AbstractC19242q11.c(-2084824793, true, new b(ja3)), 4, null).show();
                        } else {
                            if (i != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            Context contextS74 = this.a.S7();
                            AbstractC13042fc3.h(contextS74, "requireContext(...)");
                            C4174Dz6 c4174Dz62 = this.a;
                            AbstractC21375tZ.c(contextS74, c4174Dz62, null, AbstractC19242q11.c(-1982347800, true, new c(ja3, c4174Dz62)), 4, null).show();
                        }
                    }
                    this.a.W9().U0();
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0331a(C4174Dz6 c4174Dz6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c4174Dz6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0331a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10258bL6 interfaceC10258bL6T0 = this.c.W9().T0();
                    C0332a c0332a = new C0332a(this.c);
                    this.b = 1;
                    if (interfaceC10258bL6T0.b(c0332a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                throw new KotlinNothingValueException();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0331a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4174Dz6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4174Dz6 c4174Dz6 = C4174Dz6.this;
                j.b bVar = j.b.RESUMED;
                C0331a c0331a = new C0331a(c4174Dz6, null);
                this.b = 1;
                if (androidx.lifecycle.w.b(c4174Dz6, bVar, c0331a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Dz6$b */
    public static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Dz6$c */
    public static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Dz6$d */
    public static final class d extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Dz6$e */
    public static final class e extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Dz6$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C4174Dz6() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new c(new b(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C4891Gz6.class), new d(interfaceC9173Yu3B), new e(null, interfaceC9173Yu3B), new f(this, interfaceC9173Yu3B));
    }

    private final InterfaceC13730gj3 V9() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4891Gz6 W9() {
        return (C4891Gz6) this.viewModel.getValue();
    }

    private final void X9() {
        int i = C7183Qq.s().getInt("message_text_size", 14);
        ViewGroup viewGroup = null;
        Spannable spannableF = AbstractC5730Kp.f(this.text, null, null, null);
        TextView textView = this.contentTextView;
        if (textView == null) {
            AbstractC13042fc3.y("contentTextView");
            textView = null;
        }
        Spannable spannable = (Spannable) R62.W(spannableF, textView.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(i), false, null, null, 48, null);
        TextView textView2 = this.contentTextView;
        if (textView2 == null) {
            AbstractC13042fc3.y("contentTextView");
            textView2 = null;
        }
        textView2.setText(spannable);
        TextView textView3 = this.contentTextView;
        if (textView3 == null) {
            AbstractC13042fc3.y("contentTextView");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.k());
        TextView textView4 = this.contentTextView;
        if (textView4 == null) {
            AbstractC13042fc3.y("contentTextView");
            textView4 = null;
        }
        ViewGroup viewGroup2 = this.viewGroup;
        if (viewGroup2 == null) {
            AbstractC13042fc3.y("viewGroup");
        } else {
            viewGroup = viewGroup2;
        }
        textView4.setMovementMethod(new C19204px1(viewGroup, new UA2() { // from class: ir.nasim.Bz6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C4174Dz6.Y9(this.a, (String) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y9(C4174Dz6 c4174Dz6, String str) {
        AbstractC13042fc3.i(c4174Dz6, "this$0");
        AbstractC13042fc3.i(str, "link");
        LinearLayout linearLayout = c4174Dz6.loadingContainer;
        if (linearLayout == null) {
            AbstractC13042fc3.y("loadingContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        c4174Dz6.W9().S0(str);
        return C19938rB7.a;
    }

    private final void Z9(View view) {
        BaleToolbar baleToolbar = (BaleToolbar) view.findViewById(BC5.short_text_toolbar);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        baleToolbar.setTitle(this.title);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle saveInstance) {
        super.M6(saveInstance);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.title = bundleE5.getString("arg_short_text_title", "");
            this.text = bundleE5.getString("arg_short_text_content", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C15225jD4.b().a(this, C15225jD4.i);
        View viewInflate = inflater.inflate(AbstractC12208eD5.fragment_short_text, container, false);
        this.viewGroup = (ViewGroup) viewInflate.findViewById(BC5.background_container);
        this.contentTextView = (TextView) viewInflate.findViewById(BC5.short_text_content);
        this.loadingContainer = (LinearLayout) viewInflate.findViewById(BC5.loading_state_container);
        X9();
        AbstractC13042fc3.f(viewInflate);
        Z9(viewInflate);
        V9();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        C15225jD4.b().e(this, C15225jD4.i);
    }

    @Override // ir.nasim.C15225jD4.b
    public void didReceivedNotification(int id, Object... args) {
        AbstractC13042fc3.i(args, "args");
        if (id == C15225jD4.i && R62.r(this.text)) {
            X9();
        }
    }
}
