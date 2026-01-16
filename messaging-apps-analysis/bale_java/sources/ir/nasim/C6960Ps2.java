package ir.nasim;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.fragment.app.FragmentManager;
import ir.nasim.C6960Ps2;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.database.dailogLists.DialogFolderAssociationEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lir/nasim/Ps2;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "h1", "Lir/nasim/Yu3;", "X9", "()Ljava/lang/Integer;", DialogFolderAssociationEntity.COLUMN_FOLDER_ID, "", "", "i1", "Y9", "()Ljava/util/List;", "newPeersList", "j1", "a", "dialogList_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ps2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6960Ps2 extends JW2 {

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 folderId = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Ns2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C6960Ps2.W9(this.a);
        }
    });

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 newPeersList = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Os2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C6960Ps2.Z9(this.a);
        }
    });

    /* renamed from: ir.nasim.Ps2$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C6960Ps2 a(Integer num, List list) {
            C6960Ps2 c6960Ps2 = new C6960Ps2();
            ArrayList arrayList = new ArrayList();
            if (num != null) {
                arrayList.add(AbstractC4616Fw7.a("FOLDER_ID", Integer.valueOf(num.intValue())));
            }
            if (list != null) {
                arrayList.add(AbstractC4616Fw7.a("NEW_PEERS", AbstractC15401jX0.n1(list)));
            }
            XV4[] xv4Arr = (XV4[]) arrayList.toArray(new XV4[0]);
            c6960Ps2.a8(AbstractC23348wm0.b((XV4[]) Arrays.copyOf(xv4Arr, xv4Arr.length)));
            return c6960Ps2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ps2$b */
    static final class b implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.Ps2$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C6960Ps2 a;

            a(C6960Ps2 c6960Ps2) {
                this.a = c6960Ps2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.j h(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.j.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final androidx.compose.animation.h i(androidx.compose.animation.d dVar) {
                AbstractC13042fc3.i(dVar, "$this$NavHost");
                return androidx.compose.animation.h.a.a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(C8588Wp4 c8588Wp4, final C6960Ps2 c6960Ps2, C8120Up4 c8120Up4) {
                AbstractC13042fc3.i(c8588Wp4, "$navController");
                AbstractC13042fc3.i(c6960Ps2, "this$0");
                AbstractC13042fc3.i(c8120Up4, "$this$NavHost");
                AbstractC11340cq4.d(c8120Up4, c8588Wp4, c6960Ps2.X9(), c6960Ps2.Y9(), new UA2() { // from class: ir.nasim.Ts2
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C6960Ps2.b.a.n(c6960Ps2, ((Boolean) obj).booleanValue());
                    }
                });
                AbstractC11340cq4.b(c8120Up4, c8588Wp4);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C6960Ps2 c6960Ps2, boolean z) {
                AbstractC13042fc3.i(c6960Ps2, "this$0");
                FragmentManager fragmentManagerV5 = c6960Ps2.V5();
                Bundle bundle = new Bundle();
                bundle.putBoolean("isFolderCreated", z);
                C19938rB7 c19938rB7 = C19938rB7.a;
                fragmentManagerV5.G1("resultKey", bundle);
                c6960Ps2.Q7().z2().l();
                return C19938rB7.a;
            }

            public final void f(InterfaceC22053ub1 interfaceC22053ub1, int i) throws Resources.NotFoundException {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C8588Wp4 c8588Wp4E = AbstractC8854Xp4.e(new androidx.navigation.p[0], interfaceC22053ub1, 0);
                UA2 ua2E = AbstractC8216Va1.e(interfaceC22053ub1, 0);
                UA2 ua2H = AbstractC8216Va1.h(interfaceC22053ub1, 0);
                interfaceC22053ub1.W(-953689896);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new UA2() { // from class: ir.nasim.Qs2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C6960Ps2.b.a.h((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                UA2 ua2 = (UA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-953687783);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.Rs2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C6960Ps2.b.a.i((androidx.compose.animation.d) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                UA2 ua22 = (UA2) objB2;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(-953683556);
                boolean zD = interfaceC22053ub1.D(c8588Wp4E) | interfaceC22053ub1.D(this.a);
                final C6960Ps2 c6960Ps2 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar.a()) {
                    objB3 = new UA2() { // from class: ir.nasim.Ss2
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C6960Ps2.b.a.k(c8588Wp4E, c6960Ps2, (C8120Up4) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC9129Yp4.b(c8588Wp4E, "addFolder", null, null, "root", ua2E, ua2, ua22, ua2H, (UA2) objB3, interfaceC22053ub1, 14180400, 12);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws Resources.NotFoundException {
                f((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b() {
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-851605001, true, new a(C6960Ps2.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer W9(C6960Ps2 c6960Ps2) {
        Bundle bundleE5;
        AbstractC13042fc3.i(c6960Ps2, "this$0");
        Bundle bundleE52 = c6960Ps2.E5();
        if (bundleE52 == null || !bundleE52.containsKey("FOLDER_ID") || (bundleE5 = c6960Ps2.E5()) == null) {
            return null;
        }
        return Integer.valueOf(bundleE5.getInt("FOLDER_ID"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer X9() {
        return (Integer) this.folderId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List Y9() {
        return (List) this.newPeersList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Z9(C6960Ps2 c6960Ps2) {
        long[] longArray;
        AbstractC13042fc3.i(c6960Ps2, "this$0");
        Bundle bundleE5 = c6960Ps2.E5();
        if (bundleE5 == null || (longArray = bundleE5.getLongArray("NEW_PEERS")) == null) {
            return null;
        }
        return AbstractC10242bK.e1(longArray);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextS7, null, 0, 6, null);
        composeView.setBackgroundColor(AbstractC4043Dl1.c(composeView.getContext(), AbstractC24179yA5.background));
        composeView.setViewCompositionStrategy(v.d.b);
        composeView.setContent(AbstractC19242q11.c(-1052165870, true, new b()));
        return composeView;
    }
}
