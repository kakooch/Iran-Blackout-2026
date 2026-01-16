package ir.nasim;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C22618vY4;
import ir.nasim.C9475a16;
import ir.nasim.DX4;
import ir.nasim.EX4;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22028uY4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u00020\u0006*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006(²\u0006\f\u0010\n\u001a\u00020\t8\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/vY4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/IA1;", "datePickerState", "Lir/nasim/rB7;", "W9", "(Lir/nasim/IA1;)V", "Lir/nasim/OY4;", "state", "Lir/nasim/po0;", "X9", "(Lir/nasim/OY4;)Lir/nasim/po0;", "", "Lir/nasim/CX4;", "fieldGroups", "", "aa", "(Ljava/util/List;)Z", "Landroidx/compose/ui/platform/ComposeView;", "Z9", "(Landroidx/compose/ui/platform/ComposeView;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/TY4;", "h1", "Lir/nasim/Yu3;", "Y9", "()Lir/nasim/TY4;", "viewModel", "i1", "a", "passport_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.vY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22618vY4 extends AbstractC20131rX2 {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.vY4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C22618vY4 a(String str) {
            AbstractC13042fc3.i(str, "url");
            C22618vY4 c22618vY4 = new C22618vY4();
            c22618vY4.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("arg_url", str)));
            return c22618vY4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.vY4$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ ComposeView b;

        /* renamed from: ir.nasim.vY4$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C22618vY4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9664aL6 interfaceC9664aL6, C22618vY4 c22618vY4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9664aL6;
                this.d = c22618vY4;
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
                NY4 ny4J = b.d(this.c).j();
                if (ny4J != null) {
                    C22618vY4 c22618vY4 = this.d;
                    c22618vY4.L2(ny4J.j());
                    c22618vY4.Y9().C1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vY4$b$b, reason: collision with other inner class name */
        static final class C1668b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            final /* synthetic */ InterfaceC9664aL6 d;
            final /* synthetic */ C19391qG6 e;
            final /* synthetic */ C22618vY4 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1668b(InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6, C22618vY4 c22618vY4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9664aL6;
                this.e = c19391qG6;
                this.f = c22618vY4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1668b(this.d, this.e, this.f, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C22618vY4 c22618vY4;
                Object objE = AbstractC14862ic3.e();
                int i = this.c;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    MY4 my4I = b.d(this.d).i();
                    if (my4I != null) {
                        C19391qG6 c19391qG6 = this.e;
                        C22618vY4 c22618vY42 = this.f;
                        String strH6 = c22618vY42.h6(my4I.j());
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        this.b = c22618vY42;
                        this.c = 1;
                        if (C19391qG6.f(c19391qG6, strH6, null, false, null, this, 14, null) == objE) {
                            return objE;
                        }
                        c22618vY4 = c22618vY42;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c22618vY4 = (C22618vY4) this.b;
                AbstractC10685c16.b(obj);
                c22618vY4.Y9().B1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1668b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vY4$b$c */
        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ C22618vY4 d;
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C22618vY4 c22618vY4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c22618vY4;
                this.e = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, this.e, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objB;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                String strH = b.d(this.e).h();
                if (strH != null) {
                    C22618vY4 c22618vY4 = this.d;
                    try {
                        C9475a16.a aVar = C9475a16.b;
                        Uri uri = Uri.parse(strH);
                        AbstractC7426Rr.a aVar2 = AbstractC7426Rr.a;
                        Context contextS7 = c22618vY4.S7();
                        AbstractC13042fc3.h(contextS7, "requireContext(...)");
                        aVar2.A(contextS7, uri);
                        objB = C9475a16.b(C19938rB7.a);
                    } catch (Throwable th) {
                        C9475a16.a aVar3 = C9475a16.b;
                        objB = C9475a16.b(AbstractC10685c16.a(th));
                    }
                    C9475a16.a(objB);
                }
                this.d.Y9().A1();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vY4$b$d */
        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            int d;
            final /* synthetic */ InterfaceC9664aL6 e;
            final /* synthetic */ C22618vY4 f;
            final /* synthetic */ ComposeView g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(InterfaceC9664aL6 interfaceC9664aL6, C22618vY4 c22618vY4, ComposeView composeView, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = interfaceC9664aL6;
                this.f = c22618vY4;
                this.g = composeView;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new d(this.e, this.f, this.g, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                C22618vY4 c22618vY4;
                IA1 ia1;
                Object objE = AbstractC14862ic3.e();
                int i = this.d;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    IA1 ia1D = b.d(this.e).d();
                    if (ia1D != null) {
                        c22618vY4 = this.f;
                        c22618vY4.Z9(this.g);
                        this.b = c22618vY4;
                        this.c = ia1D;
                        this.d = 1;
                        if (HG1.b(100L, this) == objE) {
                            return objE;
                        }
                        ia1 = ia1D;
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ia1 = (IA1) this.c;
                c22618vY4 = (C22618vY4) this.b;
                AbstractC10685c16.b(obj);
                c22618vY4.W9(ia1);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vY4$b$e */
        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC9664aL6 d;
            final /* synthetic */ C22618vY4 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(InterfaceC9664aL6 interfaceC9664aL6, C22618vY4 c22618vY4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC9664aL6;
                this.e = c22618vY4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(this.d, this.e, interfaceC20295rm1);
                eVar.c = obj;
                return eVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objB;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C20751sY4 c20751sY4C = b.d(this.d).c();
                if (c20751sY4C != null) {
                    C22618vY4 c22618vY4 = this.e;
                    c22618vY4.Y9().D1();
                    String strA = c20751sY4C.a();
                    if (strA != null) {
                        try {
                            C9475a16.a aVar = C9475a16.b;
                            Uri uri = Uri.parse(strA);
                            AbstractC7426Rr.a aVar2 = AbstractC7426Rr.a;
                            Context contextS7 = c22618vY4.S7();
                            AbstractC13042fc3.h(contextS7, "requireContext(...)");
                            aVar2.A(contextS7, uri);
                            objB = C9475a16.b(C19938rB7.a);
                        } catch (Throwable th) {
                            C9475a16.a aVar3 = C9475a16.b;
                            objB = C9475a16.b(AbstractC10685c16.a(th));
                        }
                        C9475a16.a(objB);
                    }
                    c22618vY4.V5().k1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.vY4$b$f */
        static final class f implements InterfaceC14603iB2 {
            final /* synthetic */ C22618vY4 a;
            final /* synthetic */ ComposeView b;
            final /* synthetic */ InterfaceC9664aL6 c;
            final /* synthetic */ C19391qG6 d;

            /* renamed from: ir.nasim.vY4$b$f$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ C22618vY4 a;

                a(C22618vY4 c22618vY4) {
                    this.a = c22618vY4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C22618vY4 c22618vY4) {
                    AbstractC13042fc3.i(c22618vY4, "this$0");
                    c22618vY4.Y9().q1(InterfaceC22028uY4.b.a);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    String strC = UY6.c(LD5.passport_name, interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(-1058733928);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C22618vY4 c22618vY4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.xY4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C22618vY4.b.f.a.c(c22618vY4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC21639ts7.i(strC, null, (SA2) objB, null, null, null, null, interfaceC22053ub1, 0, 122);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.vY4$b$f$b, reason: collision with other inner class name */
            static final class C1669b implements InterfaceC14603iB2 {
                final /* synthetic */ C22618vY4 a;
                final /* synthetic */ ComposeView b;
                final /* synthetic */ InterfaceC9664aL6 c;

                C1669b(C22618vY4 c22618vY4, ComposeView composeView, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c22618vY4;
                    this.b = composeView;
                    this.c = interfaceC9664aL6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C22618vY4 c22618vY4, ComposeView composeView) {
                    AbstractC13042fc3.i(c22618vY4, "this$0");
                    AbstractC13042fc3.i(composeView, "$this_apply");
                    c22618vY4.Z9(composeView);
                    c22618vY4.Y9().q1(InterfaceC22028uY4.h.a);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (b.d(this.c).g() != AY4.a) {
                        InterfaceC19114po0 interfaceC19114po0X9 = this.a.X9(b.d(this.c));
                        interfaceC22053ub1.W(-1058719627);
                        boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.D(this.b);
                        final C22618vY4 c22618vY4 = this.a;
                        final ComposeView composeView = this.b;
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.yY4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C22618vY4.b.f.C1669b.c(c22618vY4, composeView);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10060b07.c(interfaceC19114po0X9, (SA2) objB, interfaceC22053ub1, 0);
                    }
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.vY4$b$f$c */
            static final class c implements InterfaceC15796kB2 {
                final /* synthetic */ C19391qG6 a;
                final /* synthetic */ C22618vY4 b;
                final /* synthetic */ InterfaceC9664aL6 c;

                /* renamed from: ir.nasim.vY4$b$f$c$a */
                /* synthetic */ class a extends EB2 implements UA2 {
                    a(Object obj) {
                        super(1, obj, TY4.class, "handleEvent", "handleEvent(Lir/nasim/passport/ui/main/model/PassportMainEvent;)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y((InterfaceC22028uY4) obj);
                        return C19938rB7.a;
                    }

                    public final void y(InterfaceC22028uY4 interfaceC22028uY4) {
                        AbstractC13042fc3.i(interfaceC22028uY4, "p0");
                        ((TY4) this.receiver).q1(interfaceC22028uY4);
                    }
                }

                c(C19391qG6 c19391qG6, C22618vY4 c22618vY4, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c19391qG6;
                    this.b = c22618vY4;
                    this.c = interfaceC9664aL6;
                }

                public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(ts4, "paddingValues");
                    if ((i & 6) == 0) {
                        i |= interfaceC22053ub1.V(ts4) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.h(androidx.compose.ui.e.a, ts4), 0.0f, 1, null), G10.a.a(interfaceC22053ub1, G10.b).r(), null, 2, null);
                    C19391qG6 c19391qG6 = this.a;
                    C22618vY4 c22618vY4 = this.b;
                    InterfaceC9664aL6 interfaceC9664aL6 = this.c;
                    InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
                    InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                    SA2 sa2A = aVar.a();
                    if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                        AbstractC6797Pa1.c();
                    }
                    interfaceC22053ub1.G();
                    if (interfaceC22053ub1.h()) {
                        interfaceC22053ub1.g(sa2A);
                    } else {
                        interfaceC22053ub1.r();
                    }
                    InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                    OY4 oy4D = b.d(interfaceC9664aL6);
                    TY4 ty4Y9 = c22618vY4.Y9();
                    interfaceC22053ub1.W(1431672028);
                    boolean zD = interfaceC22053ub1.D(ty4Y9);
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new a(ty4Y9);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    LY4.s(oy4D, c19391qG6, (UA2) ((InterfaceC16733lm3) objB), interfaceC22053ub1, 48);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            f(C22618vY4 c22618vY4, ComposeView composeView, InterfaceC9664aL6 interfaceC9664aL6, C19391qG6 c19391qG6) {
                this.a = c22618vY4;
                this.b = composeView;
                this.c = interfaceC9664aL6;
                this.d = c19391qG6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(1782968887, true, new a(this.a), interfaceC22053ub1, 54), AbstractC19242q11.e(-2063882824, true, new C1669b(this.a, this.b, this.c), interfaceC22053ub1, 54), null, null, 0, G10.a.a(interfaceC22053ub1, G10.b).r(), 0L, null, AbstractC19242q11.e(759221634, true, new c(this.d, this.a, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, 805306806, 440);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(ComposeView composeView) {
            this.b = composeView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OY4 d(InterfaceC9664aL6 interfaceC9664aL6) {
            return (OY4) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(C22618vY4 c22618vY4) {
            AbstractC13042fc3.i(c22618vY4, "this$0");
            c22618vY4.Y9().i1();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(C22618vY4.this.Y9().m1(), null, null, null, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.W(-1275450903);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19391qG6();
                interfaceC22053ub1.s(objB);
            }
            C19391qG6 c19391qG6 = (C19391qG6) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1275449026);
            boolean zD = interfaceC22053ub1.D(C22618vY4.this);
            final C22618vY4 c22618vY4 = C22618vY4.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.wY4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C22618vY4.b.f(c22618vY4);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            UV.a(false, (SA2) objB2, interfaceC22053ub1, 0, 1);
            NY4 ny4J = d(interfaceC9664aL6C).j();
            interfaceC22053ub1.W(-1275445716);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C22618vY4.this);
            C22618vY4 c22618vY42 = C22618vY4.this;
            Object objB3 = interfaceC22053ub1.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new a(interfaceC9664aL6C, c22618vY42, null);
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(ny4J, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            MY4 my4I = d(interfaceC9664aL6C).i();
            interfaceC22053ub1.W(-1275438866);
            boolean zV2 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C22618vY4.this);
            C22618vY4 c22618vY43 = C22618vY4.this;
            Object objB4 = interfaceC22053ub1.B();
            if (zV2 || objB4 == aVar.a()) {
                objB4 = new C1668b(interfaceC9664aL6C, c19391qG6, c22618vY43, null);
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(my4I, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 0);
            String strH = d(interfaceC9664aL6C).h();
            interfaceC22053ub1.W(-1275430843);
            boolean zV3 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C22618vY4.this);
            C22618vY4 c22618vY44 = C22618vY4.this;
            Object objB5 = interfaceC22053ub1.B();
            if (zV3 || objB5 == aVar.a()) {
                objB5 = new c(c22618vY44, interfaceC9664aL6C, null);
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(strH, (InterfaceC14603iB2) objB5, interfaceC22053ub1, 0);
            IA1 ia1D = d(interfaceC9664aL6C).d();
            interfaceC22053ub1.W(-1275419161);
            boolean zV4 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C22618vY4.this) | interfaceC22053ub1.D(this.b);
            C22618vY4 c22618vY45 = C22618vY4.this;
            ComposeView composeView = this.b;
            Object objB6 = interfaceC22053ub1.B();
            if (zV4 || objB6 == aVar.a()) {
                objB6 = new d(interfaceC9664aL6C, c22618vY45, composeView, null);
                interfaceC22053ub1.s(objB6);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(ia1D, (InterfaceC14603iB2) objB6, interfaceC22053ub1, 0);
            C20751sY4 c20751sY4C = d(interfaceC9664aL6C).c();
            interfaceC22053ub1.W(-1275410336);
            boolean zV5 = interfaceC22053ub1.V(interfaceC9664aL6C) | interfaceC22053ub1.D(C22618vY4.this);
            C22618vY4 c22618vY46 = C22618vY4.this;
            Object objB7 = interfaceC22053ub1.B();
            if (zV5 || objB7 == aVar.a()) {
                objB7 = new e(interfaceC9664aL6C, c22618vY46, null);
                interfaceC22053ub1.s(objB7);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(c20751sY4C, (InterfaceC14603iB2) objB7, interfaceC22053ub1, 0);
            M10.f(false, AbstractC19242q11.e(2128734067, true, new f(C22618vY4.this, this.b, interfaceC9664aL6C, c19391qG6), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vY4$c */
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

    /* renamed from: ir.nasim.vY4$d */
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

    /* renamed from: ir.nasim.vY4$e */
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

    /* renamed from: ir.nasim.vY4$f */
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

    /* renamed from: ir.nasim.vY4$g */
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

    public C22618vY4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(TY4.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(IA1 datePickerState) {
        String strG = datePickerState.g();
        String strA = datePickerState.a();
        long jF = datePickerState.f();
        long jC = datePickerState.c();
        long jB = datePickerState.b();
        new C24175yA1(strG, strA, Long.valueOf(jF), Long.valueOf(jC), Long.valueOf(jB), datePickerState.e(), datePickerState.d(), true).K8(F5(), "date_picker");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC19114po0 X9(OY4 state) {
        return state.g() == AY4.c ? OA2.a.b : aa(state.f().d()) ? InterfaceC19114po0.b.a.a : InterfaceC19114po0.a.C1453a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TY4 Y9() {
        return (TY4) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9(ComposeView composeView) {
        C23381wp3.f(composeView);
    }

    private final boolean aa(List fieldGroups) {
        List list = fieldGroups;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List<BX4> listC = ((CX4) it.next()).c();
            if (!(listC instanceof Collection) || !listC.isEmpty()) {
                for (BX4 bx4 : listC) {
                    if (AbstractC13042fc3.d(bx4.g(), DX4.a.a)) {
                        EX4 ex4I = bx4.i();
                        if (ex4I instanceof EX4.a) {
                            if (((EX4.a) ex4I).e() != null) {
                            }
                        } else if (ex4I instanceof EX4.b) {
                            if (((EX4.b) ex4I).e() != null) {
                            }
                        } else if (ex4I instanceof EX4.c) {
                            if (((EX4.c) ex4I).h() == null || !(!AbstractC20762sZ6.n0(r2))) {
                            }
                        } else if (!AbstractC13042fc3.d(ex4I, EX4.d.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setBackgroundColor(composeView.getContext().getColor(CA5.background));
        composeView.setContent(AbstractC19242q11.c(459696376, true, new b(composeView)));
        return composeView;
    }
}
