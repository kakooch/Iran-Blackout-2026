package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.G;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C20366rt2;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003*\u00016\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR&\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R&\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R \u0010,\u001a\b\u0012\u0004\u0012\u00020\t0'8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R2\u00103\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\t0-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00068²\u0006\f\u00105\u001a\u0002048\nX\u008a\u0084\u0002²\u0006\f\u00107\u001a\u0002068\nX\u008a\u0084\u0002"}, d2 = {"Lir/nasim/rt2;", "Lir/nasim/ua0;", "Lir/nasim/Gs2;", "<init>", "()V", "", "folderName", "", DialogFolderAssociationEntity.COLUMN_FOLDER_ID, "Lir/nasim/rB7;", "ea", "(Ljava/lang/String;I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Mt2;", "h1", "Lir/nasim/Yu3;", "Y9", "()Lir/nasim/Mt2;", "viewModel", "Lkotlin/Function1;", "i1", "Lir/nasim/UA2;", "S1", "()Lir/nasim/UA2;", "onCreateNewFolderClick", "j1", "h", "onEditFolderClicked", "Lkotlin/Function0;", "k1", "Lir/nasim/SA2;", "s1", "()Lir/nasim/SA2;", "onEditReservedFolderClicked", "Lkotlin/Function3;", "", "l1", "Lir/nasim/kB2;", "p", "()Lir/nasim/kB2;", "onDeleteFolderClicked", "Lir/nasim/Hs2;", "folderListUiAction", "ir/nasim/rt2$a$a$a", "folderListAction", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.rt2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20366rt2 extends KW2 implements InterfaceC4824Gs2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final UA2 onCreateNewFolderClick;

    /* renamed from: j1, reason: from kotlin metadata */
    private final UA2 onEditFolderClicked;

    /* renamed from: k1, reason: from kotlin metadata */
    private final SA2 onEditReservedFolderClicked;

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC15796kB2 onDeleteFolderClicked;

    /* renamed from: ir.nasim.rt2$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.rt2$a$a, reason: collision with other inner class name */
        static final class C1531a implements InterfaceC14603iB2 {
            final /* synthetic */ C20366rt2 a;

            /* renamed from: ir.nasim.rt2$a$a$a, reason: collision with other inner class name */
            public static final class C1532a implements InterfaceC13228fs2, InterfaceC4824Gs2, InterfaceC5058Hs2 {
                private final /* synthetic */ C20366rt2 a;
                private final /* synthetic */ InterfaceC5058Hs2 b;

                C1532a(C20366rt2 c20366rt2, InterfaceC9664aL6 interfaceC9664aL6) {
                    this.a = c20366rt2;
                    this.b = C1531a.d(interfaceC9664aL6);
                }

                @Override // ir.nasim.InterfaceC4824Gs2
                /* renamed from: S1 */
                public UA2 getOnCreateNewFolderClick() {
                    return this.a.getOnCreateNewFolderClick();
                }

                @Override // ir.nasim.InterfaceC5058Hs2
                public SA2 a() {
                    return this.b.a();
                }

                @Override // ir.nasim.InterfaceC5058Hs2
                public UA2 b() {
                    return this.b.b();
                }

                @Override // ir.nasim.InterfaceC5058Hs2
                public UA2 c() {
                    return this.b.c();
                }

                @Override // ir.nasim.InterfaceC5058Hs2
                public UA2 d() {
                    return this.b.d();
                }

                @Override // ir.nasim.InterfaceC4824Gs2
                /* renamed from: h */
                public UA2 getOnEditFolderClicked() {
                    return this.a.getOnEditFolderClicked();
                }

                @Override // ir.nasim.InterfaceC4824Gs2
                /* renamed from: p */
                public InterfaceC15796kB2 getOnDeleteFolderClicked() {
                    return this.a.getOnDeleteFolderClicked();
                }

                @Override // ir.nasim.InterfaceC4824Gs2
                /* renamed from: s1 */
                public SA2 getOnEditReservedFolderClicked() {
                    return this.a.getOnEditReservedFolderClicked();
                }
            }

            C1531a(C20366rt2 c20366rt2) {
                this.a = c20366rt2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final InterfaceC5058Hs2 d(InterfaceC9664aL6 interfaceC9664aL6) {
                return (InterfaceC5058Hs2) interfaceC9664aL6.getValue();
            }

            private static final C1532a f(InterfaceC9664aL6 interfaceC9664aL6) {
                return (C1532a) interfaceC9664aL6.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(C20366rt2 c20366rt2) {
                AbstractC13042fc3.i(c20366rt2, "this$0");
                c20366rt2.Q7().onBackPressed();
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(new C1532a(this.a, AbstractC10222bH6.q(this.a.Y9().Z0(), interfaceC22053ub1, 0)), interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-99648112);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C20366rt2 c20366rt2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.qt2
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C20366rt2.a.C1531a.h(c20366rt2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC4584Ft2.s((SA2) objB, f(interfaceC9664aL6Q), this.a.Y9(), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-2047723986, true, new C1531a(C20366rt2.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rt2$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        /* renamed from: ir.nasim.rt2$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.e0(UY6.d(FD5.delete_folder_message, new Object[]{this.a}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(int i, String str) {
            this.b = i;
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C20366rt2 c20366rt2, int i, Dialog dialog) {
            AbstractC13042fc3.i(c20366rt2, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            c20366rt2.Y9().W0(i);
            dialog.dismiss();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            InterfaceC14603iB2 interfaceC14603iB2A = M51.a.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(260756934, true, new a(this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-1914715156);
            boolean zD = interfaceC22053ub1.D(C20366rt2.this) | interfaceC22053ub1.e(this.b) | interfaceC22053ub1.D(dialog);
            final C20366rt2 c20366rt2 = C20366rt2.this;
            final int i2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.st2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20366rt2.b.d(c20366rt2, i2, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(FD5.delete_folder, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1914705993);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.tt2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20366rt2.b.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, cVar, interfaceC18060o11E, cVar2, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(FD5.cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rt2$c */
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

    /* renamed from: ir.nasim.rt2$d */
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

    /* renamed from: ir.nasim.rt2$e */
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

    /* renamed from: ir.nasim.rt2$f */
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

    /* renamed from: ir.nasim.rt2$g */
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
            return (hVar == null || (cVarN3 = hVar.n3()) == null) ? this.e.n3() : cVarN3;
        }
    }

    public C20366rt2() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new d(new c(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C6236Mt2.class), new e(interfaceC9173Yu3B), new f(null, interfaceC9173Yu3B), new g(this, interfaceC9173Yu3B));
        this.onCreateNewFolderClick = new UA2() { // from class: ir.nasim.mt2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20366rt2.Z9(this.a, ((Integer) obj).intValue());
            }
        };
        this.onEditFolderClicked = new UA2() { // from class: ir.nasim.nt2
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20366rt2.ba(this.a, ((Integer) obj).intValue());
            }
        };
        this.onEditReservedFolderClicked = new SA2() { // from class: ir.nasim.ot2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20366rt2.ca(this.a);
            }
        };
        this.onDeleteFolderClicked = new InterfaceC15796kB2() { // from class: ir.nasim.pt2
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return C20366rt2.aa(this.a, (String) obj, ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6236Mt2 Y9() {
        return (C6236Mt2) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z9(C20366rt2 c20366rt2, int i) {
        AbstractC13042fc3.i(c20366rt2, "this$0");
        if (c20366rt2.Y9().V0(i)) {
            C22042ua0.A9(c20366rt2, new C6960Ps2(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 aa(C20366rt2 c20366rt2, String str, int i, boolean z) {
        AbstractC13042fc3.i(c20366rt2, "this$0");
        AbstractC13042fc3.i(str, "folderName");
        if (z) {
            c20366rt2.ea(str, i);
        } else {
            c20366rt2.Y9().W0(i);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ba(C20366rt2 c20366rt2, int i) {
        AbstractC13042fc3.i(c20366rt2, "this$0");
        C22042ua0.A9(c20366rt2, C6960Ps2.INSTANCE.a(Integer.valueOf(i), null), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ca(C20366rt2 c20366rt2) {
        AbstractC13042fc3.i(c20366rt2, "this$0");
        c20366rt2.Y9().j1();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(C20366rt2 c20366rt2, String str, Bundle bundle) {
        AbstractC13042fc3.i(c20366rt2, "this$0");
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        if (bundle.getBoolean("isFolderCreated")) {
            c20366rt2.Y9().k1();
        }
    }

    private final void ea(String folderName, int folderId) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(769522660, true, new b(folderId, folderName)), 4, null).show();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-58268407, true, new a()));
        return composeView;
    }

    @Override // ir.nasim.InterfaceC4824Gs2
    /* renamed from: S1, reason: from getter */
    public UA2 getOnCreateNewFolderClick() {
        return this.onCreateNewFolderClick;
    }

    @Override // ir.nasim.InterfaceC4824Gs2
    /* renamed from: h, reason: from getter */
    public UA2 getOnEditFolderClicked() {
        return this.onEditFolderClicked;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        V5().H1("resultKey", p6(), new InterfaceC13295fz2() { // from class: ir.nasim.lt2
            @Override // ir.nasim.InterfaceC13295fz2
            public final void a(String str, Bundle bundle) {
                C20366rt2.da(this.a, str, bundle);
            }
        });
    }

    @Override // ir.nasim.InterfaceC4824Gs2
    /* renamed from: p, reason: from getter */
    public InterfaceC15796kB2 getOnDeleteFolderClicked() {
        return this.onDeleteFolderClicked;
    }

    @Override // ir.nasim.InterfaceC4824Gs2
    /* renamed from: s1, reason: from getter */
    public SA2 getOnEditReservedFolderClicked() {
        return this.onEditReservedFolderClicked;
    }
}
