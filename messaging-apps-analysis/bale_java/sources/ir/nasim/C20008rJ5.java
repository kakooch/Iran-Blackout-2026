package ir.nasim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C20008rJ5;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 R2\u00020\u0001:\u0002STB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0003R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006U"}, d2 = {"Lir/nasim/rJ5;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "oa", "pa", "Lir/nasim/lJ5;", "item", "na", "(Lir/nasim/lJ5;)V", "", "url", "ma", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "onMoreBotsClick", "V9", "(Ljava/lang/String;Lir/nasim/UA2;Lir/nasim/ub1;I)V", "ja", "ia", "ha", "Lir/nasim/rJ5$c;", "state", "ra", "(Lir/nasim/rJ5$c;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "T6", "Lir/nasim/dQ0;", "h1", "Lir/nasim/dQ0;", "ka", "()Lir/nasim/dQ0;", "setChatNavigator", "(Lir/nasim/dQ0;)V", "chatNavigator", "Lir/nasim/x88;", "i1", "Lir/nasim/x88;", "getWebViewModule", "()Lir/nasim/x88;", "setWebViewModule", "(Lir/nasim/x88;)V", "webViewModule", "Lir/nasim/cz2;", "j1", "Lir/nasim/cz2;", "binding", "Lir/nasim/Wy6;", "k1", "Lir/nasim/Yu3;", "la", "()Lir/nasim/Wy6;", "viewModel", "Lir/nasim/mJ5;", "l1", "Lir/nasim/mJ5;", "mainAdapter", "Lir/nasim/nJ5;", "m1", "Lir/nasim/nJ5;", "footerAdapter", "Landroidx/recyclerview/widget/f;", "n1", "Landroidx/recyclerview/widget/f;", "concatAdapter", "o1", "Lir/nasim/UA2;", "p1", "Ljava/lang/String;", "currentMoreBotsUrl", "q1", "c", "a", "sharedmedia_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.rJ5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20008rJ5 extends CX2 {

    /* renamed from: q1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int r1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    public InterfaceC11677dQ0 chatNavigator;

    /* renamed from: i1, reason: from kotlin metadata */
    public C23572x88 webViewModule;

    /* renamed from: j1, reason: from kotlin metadata */
    private C11425cz2 binding;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: l1, reason: from kotlin metadata */
    private C17053mJ5 mainAdapter;

    /* renamed from: m1, reason: from kotlin metadata */
    private C17644nJ5 footerAdapter;

    /* renamed from: n1, reason: from kotlin metadata */
    private androidx.recyclerview.widget.f concatAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private UA2 onMoreBotsClick;

    /* renamed from: p1, reason: from kotlin metadata */
    private String currentMoreBotsUrl;

    /* renamed from: ir.nasim.rJ5$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20008rJ5 a() {
            return new C20008rJ5();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rJ5$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;
        final /* synthetic */ String b;

        b(UA2 ua2, String str) {
            this.a = ua2;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$onMoreBotsClick");
            AbstractC13042fc3.i(str, "$url");
            ua2.invoke(str);
            return C19938rB7.a;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String strC = UY6.c(RD5.features_sharedmedia_more_bots_btn, interfaceC22053ub1, 0);
            C11984ds7 c11984ds7A = C11984ds7.e.a(interfaceC22053ub1, 6);
            C11984ds7 c11984ds7A2 = c11984ds7A.a((1 & 1) != 0 ? c11984ds7A.a : 0L, (1 & 2) != 0 ? c11984ds7A.b : G10.a.a(interfaceC22053ub1, G10.b).I(), (1 & 4) != 0 ? c11984ds7A.c : 0L, (1 & 8) != 0 ? c11984ds7A.d : 0L);
            InterfaceC15796kB2 interfaceC15796kB2A = T81.a.a();
            interfaceC22053ub1.W(2035098743);
            boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
            final UA2 ua2 = this.a;
            final String str = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.sJ5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20008rJ5.b.c(ua2, str);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC16797ls7.j(strC, null, null, null, interfaceC15796kB2A, null, c11984ds7A2, (SA2) objB, null, interfaceC22053ub1, (C11984ds7.f << 18) | 24576, 302);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.rJ5$c */
    private static final class c {
        public static final c a = new c("Loading", 0);
        public static final c b = new c("Content", 1);
        public static final c c = new c("Empty", 2);
        public static final c d = new c("Error", 3);
        private static final /* synthetic */ c[] e;
        private static final /* synthetic */ F92 f;

        static {
            c[] cVarArrA = a();
            e = cVarArrA;
            f = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c, d};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) e.clone();
        }
    }

    /* renamed from: ir.nasim.rJ5$d */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            try {
                iArr[c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[c.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[c.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[c.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.rJ5$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rJ5$e$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20008rJ5 d;
            final /* synthetic */ C17053mJ5 e;
            final /* synthetic */ androidx.recyclerview.widget.f f;
            final /* synthetic */ C17644nJ5 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20008rJ5 c20008rJ5, C17053mJ5 c17053mJ5, androidx.recyclerview.widget.f fVar, C17644nJ5 c17644nJ5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20008rJ5;
                this.e = c17053mJ5;
                this.f = fVar;
                this.g = c17644nJ5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC13460gG3 abstractC13460gG3D = ((C13628gZ0) this.c).d();
                if (abstractC13460gG3D instanceof AbstractC13460gG3.b) {
                    this.d.ra(c.a);
                } else if (!(abstractC13460gG3D instanceof AbstractC13460gG3.c)) {
                    this.d.ra(c.d);
                } else {
                    if (this.e.getItemCount() == 0) {
                        this.d.ra(c.c);
                        return C19938rB7.a;
                    }
                    List listB = this.f.B();
                    AbstractC13042fc3.h(listB, "getAdapters(...)");
                    if (!AbstractC15401jX0.i0(listB, this.g)) {
                        this.f.A(this.g);
                    }
                    this.d.ra(c.b);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C13628gZ0 c13628gZ0, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(c13628gZ0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20008rJ5.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17053mJ5 c17053mJ5 = C20008rJ5.this.mainAdapter;
                if (c17053mJ5 == null) {
                    return C19938rB7.a;
                }
                androidx.recyclerview.widget.f fVar = C20008rJ5.this.concatAdapter;
                if (fVar == null) {
                    return C19938rB7.a;
                }
                C17644nJ5 c17644nJ5 = C20008rJ5.this.footerAdapter;
                if (c17644nJ5 == null) {
                    return C19938rB7.a;
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E = c17053mJ5.E();
                a aVar = new a(C20008rJ5.this, c17053mJ5, fVar, c17644nJ5, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2E, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rJ5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rJ5$f$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20008rJ5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20008rJ5 c20008rJ5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20008rJ5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.currentMoreBotsUrl = (String) this.c;
                C17644nJ5 c17644nJ5 = this.d.footerAdapter;
                if (c17644nJ5 != null) {
                    c17644nJ5.notifyItemChanged(0);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20008rJ5.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6O3 = C20008rJ5.this.la().o3();
                a aVar = new a(C20008rJ5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6O3, aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rJ5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rJ5$g$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20008rJ5 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20008rJ5 c20008rJ5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20008rJ5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    NT4 nt4 = (NT4) this.c;
                    C17053mJ5 c17053mJ5 = this.d.mainAdapter;
                    if (c17053mJ5 != null) {
                        this.b = 1;
                        if (c17053mJ5.L(nt4, this) == objE) {
                            return objE;
                        }
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
            public final Object invoke(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20008rJ5.this.new g(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2B3 = C20008rJ5.this.la().B3();
                a aVar = new a(C20008rJ5.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2B3, aVar, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rJ5$h */
    /* synthetic */ class h extends EB2 implements UA2 {
        h(Object obj) {
            super(1, obj, C20008rJ5.class, "handlePeerItemClick", "handlePeerItemClick(Lir/nasim/sharedmedia/data/model/RecommendedPeer;)V", 0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            y((C16462lJ5) obj);
            return C19938rB7.a;
        }

        public final void y(C16462lJ5 c16462lJ5) {
            AbstractC13042fc3.i(c16462lJ5, "p0");
            ((C20008rJ5) this.receiver).na(c16462lJ5);
        }
    }

    /* renamed from: ir.nasim.rJ5$i */
    static final class i implements InterfaceC14603iB2 {
        i() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            String str = C20008rJ5.this.currentMoreBotsUrl;
            UA2 ua2 = C20008rJ5.this.onMoreBotsClick;
            if (str == null || ua2 == null) {
                return;
            }
            C20008rJ5.this.V9(str, ua2, interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rJ5$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.rJ5$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.rJ5$l */
    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.rJ5$m */
    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C20008rJ5() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new j(new SA2() { // from class: ir.nasim.pJ5
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20008rJ5.sa(this.a);
            }
        }));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C8671Wy6.class), new k(interfaceC9173Yu3B), new l(null, interfaceC9173Yu3B), new m(this, interfaceC9173Yu3B));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(final String str, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1136266797);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(1639047314, true, new b(ua2, str), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.qJ5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return C20008rJ5.W9(this.a, str, ua2, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W9(C20008rJ5 c20008rJ5, String str, UA2 ua2, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c20008rJ5, "$tmp0_rcvr");
        AbstractC13042fc3.i(str, "$url");
        AbstractC13042fc3.i(ua2, "$onMoreBotsClick");
        c20008rJ5.V9(str, ua2, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    private final void ha() {
        AbstractC16751lo1.c(this, j.b.STARTED, new e(null));
    }

    private final void ia() {
        AbstractC16751lo1.c(this, j.b.STARTED, new f(null));
    }

    private final void ja() {
        AbstractC16751lo1.c(this, j.b.STARTED, new g(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8671Wy6 la() {
        return (C8671Wy6) this.viewModel.getValue();
    }

    private final void ma(String url) {
        if (!u6() || o6() == null) {
            return;
        }
        C8671Wy6.t4(la(), EnumC14682iJ5.e, null, 2, null);
        C22042ua0.A9(this, ir.nasim.features.bank.mybank.webview.a.r1.a(url, false), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void na(C16462lJ5 item) {
        la().s4(EnumC14682iJ5.c, Integer.valueOf(item.d()));
        InterfaceC11677dQ0 interfaceC11677dQ0Ka = ka();
        C11458d25 c11458d25R = C11458d25.r(item.d());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C22042ua0.A9(this, InterfaceC11677dQ0.b(interfaceC11677dQ0Ka, c11458d25R, ExPeerType.BOT, null, null, false, null, null, null, null, 0L, null, null, null, false, null, null, null, null, null, false, null, null, null, null, null, false, null, 134217724, null), false, null, 6, null);
    }

    private final void oa() {
        C11425cz2 c11425cz2 = this.binding;
        if (c11425cz2 != null) {
            c11425cz2.e.setTypeface(C6011Lu2.k());
        }
    }

    private final void pa() {
        RecyclerView recyclerView;
        this.mainAdapter = new C17053mJ5(new h(this));
        this.onMoreBotsClick = new UA2() { // from class: ir.nasim.oJ5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20008rJ5.qa(this.a, (String) obj);
            }
        };
        this.footerAdapter = new C17644nJ5(AbstractC19242q11.c(-1697265907, true, new i()));
        C17053mJ5 c17053mJ5 = this.mainAdapter;
        AbstractC13042fc3.f(c17053mJ5);
        androidx.recyclerview.widget.f fVar = new androidx.recyclerview.widget.f(c17053mJ5);
        C11425cz2 c11425cz2 = this.binding;
        if (c11425cz2 != null && (recyclerView = c11425cz2.f) != null) {
            recyclerView.setAdapter(fVar);
        }
        this.concatAdapter = fVar;
        ha();
        ja();
        ia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(C20008rJ5 c20008rJ5, String str) {
        AbstractC13042fc3.i(c20008rJ5, "this$0");
        AbstractC13042fc3.i(str, "url");
        c20008rJ5.ma(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(c state) {
        C11425cz2 c11425cz2 = this.binding;
        if (c11425cz2 != null) {
            int i2 = d.a[state.ordinal()];
            if (i2 == 1) {
                c11425cz2.d.setVisibility(0);
                c11425cz2.f.setVisibility(8);
                c11425cz2.b.setVisibility(8);
                return;
            }
            if (i2 == 2) {
                c11425cz2.d.setVisibility(8);
                c11425cz2.f.setVisibility(0);
                c11425cz2.b.setVisibility(8);
            } else if (i2 == 3) {
                c11425cz2.d.setVisibility(8);
                c11425cz2.f.setVisibility(8);
                c11425cz2.b.setVisibility(0);
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                c11425cz2.d.setVisibility(0);
                c11425cz2.f.setVisibility(8);
                c11425cz2.b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC15408jX7 sa(C20008rJ5 c20008rJ5) {
        AbstractC13042fc3.i(c20008rJ5, "this$0");
        Fragment fragmentU7 = c20008rJ5.U7();
        AbstractC13042fc3.h(fragmentU7, "requireParentFragment(...)");
        return fragmentU7;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C11425cz2 c11425cz2C = C11425cz2.c(inflater.cloneInContext(new C16731lm1(S7(), AbstractC15235jE5.Theme_Bale_Base)), container, false);
        this.binding = c11425cz2C;
        LinearLayout root = c11425cz2C.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        RecyclerView recyclerView;
        super.T6();
        C11425cz2 c11425cz2 = this.binding;
        if (c11425cz2 != null && (recyclerView = c11425cz2.f) != null) {
            recyclerView.setAdapter(null);
        }
        this.mainAdapter = null;
        this.footerAdapter = null;
        this.concatAdapter = null;
        this.onMoreBotsClick = null;
        this.currentMoreBotsUrl = null;
        this.binding = null;
    }

    public final InterfaceC11677dQ0 ka() {
        InterfaceC11677dQ0 interfaceC11677dQ0 = this.chatNavigator;
        if (interfaceC11677dQ0 != null) {
            return interfaceC11677dQ0;
        }
        AbstractC13042fc3.y("chatNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        oa();
        pa();
    }
}
