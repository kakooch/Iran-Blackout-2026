package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.G;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C20064rP7;
import ir.nasim.C24254yJ;
import ir.nasim.C5798Kw4;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.LP;
import ir.nasim.auth.PickCountryActivity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.root.RootActivity;
import ir.nasim.features.tour.IntroLogoActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 v2\u00020\u0001:\u0001wB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\b\u0010\u0003J'\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0013\u0010\u0013\u001a\u00020\u0004*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0019\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b#\u0010\"J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J+\u00100\u001a\u00020/2\u0006\u0010*\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b0\u00101J!\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020/2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H\u0016¢\u0006\u0004\b5\u0010\u0003J\u000f\u00106\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\u0003J)\u0010<\u001a\u00020\u00042\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010:H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020B8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\t0P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010JR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\"\u0010f\u001a\u00020_8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010n\u001a\u00020g8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006y²\u0006\u000e\u0010x\u001a\u00020[8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lir/nasim/Kw4;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "ta", "Ea", "sa", "za", "", "savedCountryCode", "savedCountryName", "savedPhoneNumber", "ra", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qa", "(Ljava/lang/String;Ljava/lang/String;)V", "wa", "Landroidx/compose/ui/platform/ComposeView;", "ea", "(Landroidx/compose/ui/platform/ComposeView;)V", "ia", "ja", "Landroid/widget/TextView;", "editText", "ga", "(Landroid/widget/TextView;)V", "Lir/nasim/fp1;", "country", "ya", "(Lir/nasim/fp1;)V", "Lir/nasim/SB6;", "viewState", "va", "(Lir/nasim/SB6;)V", "ua", "Lir/nasim/LP;", "authError", "oa", "(Lir/nasim/LP;)V", "fa", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "T6", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "Landroid/view/Menu;", "menu", "e7", "(Landroid/view/Menu;)V", "Lir/nasim/Tw4;", "h1", "Lir/nasim/Yu3;", "na", "()Lir/nasim/Tw4;", "viewModel", "", "i1", "Ljava/util/List;", "firstTimeOpenWithThisPhone", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "j1", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "alertDialog", "", "k1", "imeiList", "Lir/nasim/ep1;", "l1", "Lir/nasim/ep1;", "countryDb", "Lir/nasim/jp3;", "m1", "Lir/nasim/jp3;", "keyboardHelper", "", "n1", "Z", "isRtl", "Lir/nasim/k36;", "o1", "Lir/nasim/k36;", "ma", "()Lir/nasim/k36;", "setRootBeer", "(Lir/nasim/k36;)V", "rootBeer", "Lir/nasim/eR;", "p1", "Lir/nasim/eR;", "la", "()Lir/nasim/eR;", "setEncryptedSharedPreferences", "(Lir/nasim/eR;)V", "encryptedSharedPreferences", "Lir/nasim/Ht4;", "q1", "Lir/nasim/Ht4;", "_binding", "ka", "()Lir/nasim/Ht4;", "binding", "r1", "a", "showBottomSheet", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Kw4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5798Kw4 extends AbstractC14814iX2 {

    /* renamed from: r1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int s1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private final List firstTimeOpenWithThisPhone;

    /* renamed from: j1, reason: from kotlin metadata */
    private AlertDialog alertDialog;

    /* renamed from: k1, reason: from kotlin metadata */
    private List imeiList;

    /* renamed from: l1, reason: from kotlin metadata */
    private C12561ep1 countryDb;

    /* renamed from: m1, reason: from kotlin metadata */
    private C15581jp3 keyboardHelper;

    /* renamed from: n1, reason: from kotlin metadata */
    private boolean isRtl;

    /* renamed from: o1, reason: from kotlin metadata */
    public C15721k36 rootBeer;

    /* renamed from: p1, reason: from kotlin metadata */
    public C12328eR encryptedSharedPreferences;

    /* renamed from: q1, reason: from kotlin metadata */
    private C5069Ht4 _binding;

    /* renamed from: ir.nasim.Kw4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C5798Kw4 a() {
            return new C5798Kw4();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Kw4$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10415ba2.values().length];
            try {
                iArr[EnumC10415ba2.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.Kw4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Kw4$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C5798Kw4 a;

            a(C5798Kw4 c5798Kw4) {
                this.a = c5798Kw4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(SB6 sb6, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.va(sb6);
                return C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5798Kw4.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6F1 = C5798Kw4.this.na().f1();
                a aVar = new a(C5798Kw4.this);
                this.b = 1;
                if (interfaceC10258bL6F1.b(aVar, this) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Kw4$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ C12889fL5 b;
        final /* synthetic */ String c;
        final /* synthetic */ C12889fL5 d;
        final /* synthetic */ String e;

        /* renamed from: ir.nasim.Kw4$d$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C5798Kw4 a;
            final /* synthetic */ C19818qz6 b;
            final /* synthetic */ InterfaceC9102Ym4 c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ String e;
            final /* synthetic */ C12889fL5 f;
            final /* synthetic */ String g;

            /* renamed from: ir.nasim.Kw4$d$a$a, reason: collision with other inner class name */
            static final class C0473a implements InterfaceC14603iB2 {
                final /* synthetic */ C5798Kw4 a;
                final /* synthetic */ C19818qz6 b;
                final /* synthetic */ InterfaceC9102Ym4 c;
                final /* synthetic */ C12889fL5 d;
                final /* synthetic */ String e;
                final /* synthetic */ C12889fL5 f;
                final /* synthetic */ String g;

                /* renamed from: ir.nasim.Kw4$d$a$a$a, reason: collision with other inner class name */
                static final class C0474a implements InterfaceC14603iB2 {
                    public static final C0474a a = new C0474a();

                    C0474a() {
                    }

                    public final A98 a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        interfaceC22053ub1.W(-1202233230);
                        A98 a98G = AbstractC21393ta8.g(C8062Uj0.a.g(interfaceC22053ub1, 6), AbstractC23236wa8.a.e());
                        interfaceC22053ub1.Q();
                        return a98G;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    }
                }

                /* renamed from: ir.nasim.Kw4$d$a$a$b */
                static final class b implements InterfaceC15796kB2 {
                    final /* synthetic */ C5798Kw4 a;
                    final /* synthetic */ InterfaceC9102Ym4 b;
                    final /* synthetic */ C12889fL5 c;
                    final /* synthetic */ String d;
                    final /* synthetic */ C12889fL5 e;
                    final /* synthetic */ String f;

                    b(C5798Kw4 c5798Kw4, InterfaceC9102Ym4 interfaceC9102Ym4, C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2) {
                        this.a = c5798Kw4;
                        this.b = interfaceC9102Ym4;
                        this.c = c12889fL5;
                        this.d = str;
                        this.e = c12889fL52;
                        this.f = str2;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 f(C5798Kw4 c5798Kw4, InterfaceC9102Ym4 interfaceC9102Ym4) {
                        AbstractC13042fc3.i(c5798Kw4, "this$0");
                        AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                        ComposeView composeView = c5798Kw4.ka().b;
                        AbstractC13042fc3.h(composeView, "bottomSheet");
                        c5798Kw4.ea(composeView);
                        d.d(interfaceC9102Ym4, false);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 h(C5798Kw4 c5798Kw4, C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                        AbstractC13042fc3.i(c5798Kw4, "this$0");
                        AbstractC13042fc3.i(c12889fL5, "$countryCode");
                        AbstractC13042fc3.i(str, "$countryName");
                        AbstractC13042fc3.i(c12889fL52, "$phoneNumber");
                        AbstractC13042fc3.i(str2, "$rawPhoneN");
                        AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                        ComposeView composeView = c5798Kw4.ka().b;
                        AbstractC13042fc3.h(composeView, "bottomSheet");
                        c5798Kw4.ea(composeView);
                        d.d(interfaceC9102Ym4, false);
                        c5798Kw4.na().o1(new U75((String) c12889fL5.a, str, (String) c12889fL52.a), Long.parseLong(str2), c5798Kw4.imeiList, SQ.j);
                        return C19938rB7.a;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final C19938rB7 i(C5798Kw4 c5798Kw4, C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                        AbstractC13042fc3.i(c5798Kw4, "this$0");
                        AbstractC13042fc3.i(c12889fL5, "$countryCode");
                        AbstractC13042fc3.i(str, "$countryName");
                        AbstractC13042fc3.i(c12889fL52, "$phoneNumber");
                        AbstractC13042fc3.i(str2, "$rawPhoneN");
                        AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                        ComposeView composeView = c5798Kw4.ka().b;
                        AbstractC13042fc3.h(composeView, "bottomSheet");
                        c5798Kw4.ea(composeView);
                        d.d(interfaceC9102Ym4, false);
                        C7949Tw4.p1(c5798Kw4.na(), new U75((String) c12889fL5.a, str, (String) c12889fL52.a), Long.parseLong(str2), c5798Kw4.imeiList, null, 8, null);
                        return C19938rB7.a;
                    }

                    public final void d(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
                        if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                            return;
                        }
                        final C5798Kw4 c5798Kw4 = this.a;
                        final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                        final C12889fL5 c12889fL5 = this.c;
                        final String str = this.d;
                        final C12889fL5 c12889fL52 = this.e;
                        final String str2 = this.f;
                        e.a aVar = androidx.compose.ui.e.a;
                        C24254yJ c24254yJ = C24254yJ.a;
                        C24254yJ.m mVarH = c24254yJ.h();
                        InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                        InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
                        int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
                        InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
                        SA2 sa2A = aVar3.a();
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
                        DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
                        DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
                        InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
                        if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                            interfaceC22053ub1A.s(Integer.valueOf(iA));
                            interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                        }
                        DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
                        C9784aZ0 c9784aZ0 = C9784aZ0.a;
                        androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q((float) 17.61d), C17784nZ1.q(18));
                        InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.i(), interfaceC22053ub1, 54);
                        int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
                        SA2 sa2A2 = aVar3.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A2);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
                        DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                        InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                        if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                            interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                            interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                        }
                        DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                        M66 m66 = M66.a;
                        EV4 ev4C = FV4.c(KB5.cross_search, interfaceC22053ub1, 0);
                        float f = 13;
                        androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f));
                        interfaceC22053ub1.W(2128469746);
                        boolean zD = interfaceC22053ub1.D(c5798Kw4);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new SA2() { // from class: ir.nasim.Mw4
                                @Override // ir.nasim.SA2
                                public final Object invoke() {
                                    return C5798Kw4.d.a.C0473a.b.f(c5798Kw4, interfaceC9102Ym4);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC11456d23.b(ev4C, null, androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                        String strC = UY6.c(AbstractC12217eE5.enter_bale_code_string, interfaceC22053ub1, 0);
                        G10 g10 = G10.a;
                        int i2 = G10.b;
                        AbstractC9339Zm7.b(strC, L66.b(m66, aVar, 1.0f, false, 2, null), g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65016);
                        ZH6.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(f)), interfaceC22053ub1, 6);
                        interfaceC22053ub1.u();
                        float f2 = 1;
                        ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f2)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
                        AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.enter_bale_bottom_sheet_body, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i2).b().c()), g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), interfaceC22053ub1, 0, 0, 65528);
                        ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(f2)), 0.0f, g10.a(interfaceC22053ub1, i2).A(), interfaceC22053ub1, 6, 2);
                        androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i2).b().c());
                        InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.o(g10.c(interfaceC22053ub1, i2).b().c()), aVar2.l(), interfaceC22053ub1, 0);
                        int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                        InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                        androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
                        SA2 sa2A3 = aVar3.a();
                        if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                            AbstractC6797Pa1.c();
                        }
                        interfaceC22053ub1.G();
                        if (interfaceC22053ub1.h()) {
                            interfaceC22053ub1.g(sa2A3);
                        } else {
                            interfaceC22053ub1.r();
                        }
                        InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
                        DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B2, aVar3.e());
                        DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
                        InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
                        if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                            interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                            interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                        }
                        DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
                        AbstractC17932no0.A(new SA2() { // from class: ir.nasim.Nw4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C5798Kw4.d.a.C0473a.b.h(c5798Kw4, c12889fL5, str, c12889fL52, str2, interfaceC9102Ym4);
                            }
                        }, InterfaceC19114po0.b.a.a, UY6.c(AbstractC12217eE5.enter_bale_bootom_sheet_telegram, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), Integer.valueOf(KB5.send), null, interfaceC22053ub1, InterfaceC19114po0.b.a.b << 3, 32);
                        AbstractC17932no0.A(new SA2() { // from class: ir.nasim.Ow4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C5798Kw4.d.a.C0473a.b.i(c5798Kw4, c12889fL5, str, c12889fL52, str2, interfaceC9102Ym4);
                            }
                        }, InterfaceC19114po0.b.C1454b.a, UY6.c(AbstractC12217eE5.enter_bale_bootom_sheet_sms, interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), Integer.valueOf(KB5.sms), null, interfaceC22053ub1, InterfaceC19114po0.b.C1454b.b << 3, 32);
                        interfaceC22053ub1.u();
                        interfaceC22053ub1.u();
                    }

                    @Override // ir.nasim.InterfaceC15796kB2
                    public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                        d((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                        return C19938rB7.a;
                    }
                }

                C0473a(C5798Kw4 c5798Kw4, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4, C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2) {
                    this.a = c5798Kw4;
                    this.b = c19818qz6;
                    this.c = interfaceC9102Ym4;
                    this.d = c12889fL5;
                    this.e = str;
                    this.f = c12889fL52;
                    this.g = str2;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C5798Kw4 c5798Kw4, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(c5798Kw4, "this$0");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$showBottomSheet$delegate");
                    ComposeView composeView = c5798Kw4.ka().b;
                    AbstractC13042fc3.h(composeView, "bottomSheet");
                    c5798Kw4.ea(composeView);
                    d.d(interfaceC9102Ym4, false);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null);
                    long jM = G10.a.a(interfaceC22053ub1, G10.b).M();
                    interfaceC22053ub1.W(1399336581);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C5798Kw4 c5798Kw4 = this.a;
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Lw4
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C5798Kw4.d.a.C0473a.c(c5798Kw4, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC9273Zf4.a((SA2) objB, eVarH, this.b, 0.0f, null, jM, 0L, 0.0f, 0L, null, C0474a.a, null, AbstractC19242q11.e(1889411518, true, new b(this.a, this.c, this.d, this.e, this.f, this.g), interfaceC22053ub1, 54), interfaceC22053ub1, 805306416, 384, 2520);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C5798Kw4 c5798Kw4, C19818qz6 c19818qz6, InterfaceC9102Ym4 interfaceC9102Ym4, C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2) {
                this.a = c5798Kw4;
                this.b = c19818qz6;
                this.c = interfaceC9102Ym4;
                this.d = c12889fL5;
                this.e = str;
                this.f = c12889fL52;
                this.g = str2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    F27.a(null, null, 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(1681099707, true, new C0473a(this.a, this.b, this.c, this.d, this.e, this.f, this.g), interfaceC22053ub1, 54), interfaceC22053ub1, 12582912, 127);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        d(C12889fL5 c12889fL5, String str, C12889fL5 c12889fL52, String str2) {
            this.b = c12889fL5;
            this.c = str;
            this.d = c12889fL52;
            this.e = str2;
        }

        private static final boolean c(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C19818qz6 c19818qz6L = AbstractC9273Zf4.l(false, null, interfaceC22053ub1, 0, 3);
            interfaceC22053ub1.W(-683746444);
            C5798Kw4 c5798Kw4 = C5798Kw4.this;
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                ComposeView composeView = c5798Kw4.ka().b;
                AbstractC13042fc3.h(composeView, "bottomSheet");
                objB = AbstractC13472gH6.d(Boolean.valueOf(composeView.getVisibility() == 0), null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            if (c(interfaceC9102Ym4)) {
                M10.f(false, AbstractC19242q11.e(95875808, true, new a(C5798Kw4.this, c19818qz6L, interfaceC9102Ym4, this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Kw4$e */
    public static final class e implements TextWatcher {
        private int a;
        private int b;

        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            if (C5798Kw4.this.isRtl) {
                C5798Kw4.this.ka().i.removeTextChangedListener(this);
                C5798Kw4.this.ka().i.setText(XY6.e(editable.toString()));
                C5798Kw4.this.ka().i.addTextChangedListener(this);
                C5798Kw4.this.ka().i.setSelection(this.a + this.b);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AbstractC13042fc3.i(charSequence, "s");
            this.a = i;
            this.b = i3;
        }
    }

    /* renamed from: ir.nasim.Kw4$f */
    public static final class f extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Kw4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Kw4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Kw4$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Kw4$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C5798Kw4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new g(new f(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C7949Tw4.class), new h(interfaceC9173Yu3B), new i(null, interfaceC9173Yu3B), new j(this, interfaceC9173Yu3B));
        this.firstTimeOpenWithThisPhone = new ArrayList();
        this.imeiList = new ArrayList();
        this.countryDb = C12561ep1.a.b();
        this.keyboardHelper = new C15581jp3();
        this.isRtl = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Aa(C5798Kw4 c5798Kw4, TextView textView, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        if (i2 != 2) {
            return false;
        }
        c5798Kw4.wa();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(C5798Kw4 c5798Kw4, View view) {
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        C17213mb2.g(C17213mb2.a, "request_otp", null, 2, null);
        c5798Kw4.wa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(C5798Kw4 c5798Kw4, View view) {
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        c5798Kw4.keyboardHelper.c(c5798Kw4.ka().i, false);
        c5798Kw4.startActivityForResult(new Intent(c5798Kw4.A5(), (Class<?>) PickCountryActivity.class), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(C5798Kw4 c5798Kw4, View view) {
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        c5798Kw4.keyboardHelper.c(c5798Kw4.ka().i, false);
        c5798Kw4.startActivityForResult(new Intent(c5798Kw4.A5(), (Class<?>) PickCountryActivity.class), 0);
    }

    private final void Ea() {
        if (TextUtils.isEmpty(ka().q.getText())) {
            ia();
        } else {
            ja();
        }
        this.keyboardHelper.c(ka().i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea(ComposeView composeView) {
        composeView.h();
        composeView.setVisibility(8);
    }

    private final void fa() {
        String name;
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            try {
                try {
                    alertDialog.dismiss();
                } catch (Exception e2) {
                    if (getClass().isAnonymousClass()) {
                        name = getClass().getName();
                        if (name.length() <= 23) {
                            AbstractC13042fc3.f(name);
                        } else {
                            AbstractC13042fc3.f(name);
                            name = name.substring(name.length() - 23, name.length());
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    } else {
                        name = getClass().getSimpleName();
                        if (name.length() <= 23) {
                            AbstractC13042fc3.f(name);
                        } else {
                            AbstractC13042fc3.f(name);
                            name = name.substring(0, 23);
                            AbstractC13042fc3.h(name, "substring(...)");
                        }
                    }
                    C19406qI3.d(name, e2);
                }
            } finally {
                this.alertDialog = null;
            }
        }
    }

    private final void ga(final TextView editText) {
        if (editText != null) {
            editText.post(new Runnable() { // from class: ir.nasim.Dw4
                @Override // java.lang.Runnable
                public final void run() {
                    C5798Kw4.ha(editText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(TextView textView) {
        textView.requestFocus();
    }

    private final void ia() {
        ga(ka().q);
    }

    private final void ja() {
        ga(ka().i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5069Ht4 ka() {
        C5069Ht4 c5069Ht4 = this._binding;
        AbstractC13042fc3.f(c5069Ht4);
        return c5069Ht4;
    }

    private final void oa(LP authError) {
        String name;
        R4();
        fa();
        final LP.a aVar = authError instanceof LP.a ? (LP.a) authError : null;
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.a()) {
                String strH6 = aVar.d() != null ? h6(aVar.d().intValue()) : aVar.e();
                AbstractC13042fc3.f(strH6);
                Context contextS7 = S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                NY nyU = new NY(contextS7).E(4).i(strH6).k(4).F(false).f(false).x(h6(AbstractC12217eE5.dialog_try_again)).v(new View.OnClickListener() { // from class: ir.nasim.Ew4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C5798Kw4.pa(aVar, this, view);
                    }
                }).u(h6(AbstractC12217eE5.dialog_cancel));
                Integer numF = aVar.f();
                if (numF != null) {
                    nyU.A(numF.intValue());
                }
                nyU.a().z();
                return;
            }
            String strH62 = aVar.d() != null ? h6(aVar.d().intValue()) : aVar.e();
            AbstractC13042fc3.f(strH62);
            Context contextS72 = S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            NY nyF = new NY(contextS72).E(4).i(strH62).k(4).F(false).x(h6(AbstractC12217eE5.dialog_ok)).f(false);
            Integer numF2 = aVar.f();
            if (numF2 != null) {
                nyF.A(numF2.intValue());
            }
            nyF.a().z();
        } catch (Exception e2) {
            if (getClass().isAnonymousClass()) {
                name = getClass().getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = getClass().getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(LP.a aVar, C5798Kw4 c5798Kw4, View view) {
        AbstractC13042fc3.i(aVar, "$activeAuthError");
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        if (b.a[aVar.b().ordinal()] == 1) {
            c5798Kw4.wa();
        }
    }

    private final void qa(String savedCountryCode, String savedCountryName) {
        String strE;
        if (savedCountryCode.length() != 0) {
            TextView textView = ka().q;
            if (this.isRtl) {
                savedCountryCode = XY6.e(savedCountryCode);
            }
            textView.setText(savedCountryCode);
            ka().e.setText(savedCountryName);
            return;
        }
        String str = "Iran";
        strE = "98";
        if (TextUtils.isEmpty("IR")) {
            ka().q.setText(this.isRtl ? XY6.e("98") : "98");
            ka().e.setText("Iran");
            ia();
            return;
        }
        C13197fp1 c13197fp1H = this.countryDb.h("IR");
        if (c13197fp1H == null) {
            ia();
            return;
        }
        String strG = c13197fp1H.g();
        String strY8 = Y8(c13197fp1H.e());
        if (strG != null && strG.length() != 0) {
            str = strY8;
            strE = strG;
        }
        TextView textView2 = ka().q;
        if (this.isRtl) {
            strE = XY6.e(strE);
        }
        textView2.setText(strE);
        ka().e.setText(str);
        ja();
    }

    private final void ra(String savedCountryCode, String savedCountryName, String savedPhoneNumber) {
        if (this.isRtl) {
            ka().q.setText(XY6.e(savedCountryCode));
        }
        ka().e.setText(savedCountryName);
        ka().i.setText(savedPhoneNumber);
    }

    private final void sa() {
        TextView textView = ka().m;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.o0());
        ka().n.setTextColor(c5495Jo7.o0());
        ka().i.setTextColor(c5495Jo7.n0());
        ka().l.setTextColor(c5495Jo7.g0());
        ka().l.setTypeface(C6011Lu2.i());
        ka().o.setTextColor(c5495Jo7.o0());
        ka().o.setTypeface(C6011Lu2.k());
        ka().e.setTypeface(C6011Lu2.k());
        ka().e.setTextColor(c5495Jo7.g0());
        ka().q.setTypeface(C6011Lu2.k());
        ka().q.setTextColor(c5495Jo7.g0());
        ka().i.setTextColor(c5495Jo7.g0());
        ka().i.setGravity(17);
        ka().i.setTextAlignment(2);
    }

    private final void ta() {
        AbstractC19224pz3.a(this).d(new c(null));
    }

    private final void ua(SB6 viewState) {
        FragmentManager fragmentManagerB0;
        androidx.fragment.app.x xVarS;
        androidx.fragment.app.x xVarC;
        FragmentActivity fragmentActivityQ7 = Q7();
        IntroLogoActivity introLogoActivity = fragmentActivityQ7 instanceof IntroLogoActivity ? (IntroLogoActivity) fragmentActivityQ7 : null;
        if (introLogoActivity == null || (fragmentManagerB0 = introLogoActivity.B0()) == null || (xVarS = fragmentManagerB0.s()) == null || (xVarC = xVarS.c(BC5.activity_base_login, C20064rP7.Companion.b(C20064rP7.INSTANCE, viewState.e(), viewState.k(), this.imeiList, viewState.j(), viewState.c(), viewState.g(), viewState.h(), null, 128, null), null)) == null) {
            C22042ua0.A9(this, C20064rP7.Companion.b(C20064rP7.INSTANCE, viewState.e(), viewState.k(), this.imeiList, viewState.j(), viewState.c(), viewState.g(), viewState.h(), null, 128, null), false, null, 6, null);
        } else {
            xVarC.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va(SB6 viewState) {
        if (viewState.d() instanceof LP.a) {
            oa(viewState.d());
            return;
        }
        if (viewState.l()) {
            t2(AbstractC12217eE5.progress_common);
            return;
        }
        R4();
        if (viewState.f()) {
            Q7().finish();
            C5735Kp4.w().F();
            n8(new Intent(Q7(), (Class<?>) RootActivity.class));
            return;
        }
        if (viewState.e() != 0 && viewState.k().length() > 0) {
            ua(viewState);
        }
        if (ka().i.getText().toString().length() == 0) {
            ra(viewState.i().a(), viewState.i().b(), viewState.i().c());
            qa(viewState.i().a(), viewState.i().b());
        }
    }

    private final void wa() {
        C12889fL5 c12889fL5 = new C12889fL5();
        c12889fL5.a = ka().q.getText().toString();
        String string = ka().e.getText().toString();
        C12889fL5 c12889fL52 = new C12889fL5();
        c12889fL52.a = ka().i.getText().toString();
        if (this.isRtl) {
            c12889fL5.a = XY6.h((String) c12889fL5.a);
            c12889fL52.a = XY6.h((String) c12889fL52.a);
        }
        String str = (String) c12889fL5.a;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = AbstractC13042fc3.k(str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i2, length + 1).toString().length() != 0) {
            String str2 = (String) c12889fL52.a;
            int length2 = str2.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length2) {
                boolean z4 = AbstractC13042fc3.k(str2.charAt(!z3 ? i3 : length2), 32) <= 0;
                if (z3) {
                    if (!z4) {
                        break;
                    } else {
                        length2--;
                    }
                } else if (z4) {
                    i3++;
                } else {
                    z3 = true;
                }
            }
            if (str2.subSequence(i3, length2 + 1).toString().length() != 0) {
                String str3 = new C20644sM5("[^0-9]").k((CharSequence) c12889fL5.a, "") + new C20644sM5("[^0-9]").k((CharSequence) c12889fL52.a, "");
                if (str3.length() == 0) {
                    Context contextS7 = S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    new AlertDialog.a(contextS7).i(h6(AbstractC12217eE5.auth_error_empty_phone)).l(h6(AbstractC12217eE5.dialog_ok), null).o();
                    return;
                }
                try {
                    if (!ma().r() && (!la().b().isEmpty()) && !this.firstTimeOpenWithThisPhone.contains(str3)) {
                        this.firstTimeOpenWithThisPhone.add(str3);
                        na().o1(new U75((String) c12889fL5.a, string, (String) c12889fL52.a), Long.parseLong(str3), this.imeiList, SQ.k);
                    } else if (AbstractC13042fc3.d(c12889fL5.a, "98")) {
                        C7949Tw4.p1(na(), new U75((String) c12889fL5.a, string, (String) c12889fL52.a), Long.parseLong(str3), this.imeiList, null, 8, null);
                    } else {
                        ComposeView composeView = ka().b;
                        AbstractC13042fc3.h(composeView, "bottomSheet");
                        composeView.setVisibility(0);
                        ka().b.g();
                        ka().b.setContent(AbstractC19242q11.c(-103917664, true, new d(c12889fL5, string, c12889fL52, str3)));
                    }
                    return;
                } catch (NumberFormatException unused) {
                    FragmentActivity fragmentActivityQ7 = Q7();
                    AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                    AlertDialog alertDialogA = new AlertDialog.a(fragmentActivityQ7).i(h6(AbstractC12217eE5.auth_error_phone_number_invalid)).l(h6(AbstractC12217eE5.dialog_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.Jw4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            C5798Kw4.xa(this.a, dialogInterface, i4);
                        }
                    }).a();
                    alertDialogA.setCancelable(false);
                    alertDialogA.setCanceledOnTouchOutside(false);
                    q9(alertDialogA);
                    return;
                }
            }
        }
        Context contextS72 = S7();
        AbstractC13042fc3.h(contextS72, "requireContext(...)");
        new AlertDialog.a(contextS72).i(h6(AbstractC12217eE5.auth_error_empty_phone)).l(h6(AbstractC12217eE5.dialog_ok), null).o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(C5798Kw4 c5798Kw4, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c5798Kw4, "this$0");
        c5798Kw4.fa();
    }

    private final void ya(C13197fp1 country) {
        if (country != null) {
            String strG = country.g();
            String strH6 = h6(country.e());
            AbstractC13042fc3.h(strH6, "getString(...)");
            if (this.isRtl) {
                strG = XY6.e(strG);
            }
            ka().q.setText(strG);
            ka().e.setText(strH6);
        }
        ja();
    }

    private final void za() {
        ka().i.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.Fw4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return C5798Kw4.Aa(this.a, textView, i2, keyEvent);
            }
        });
        ka().i.addTextChangedListener(new e());
        ka().d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Gw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5798Kw4.Ba(this.a, view);
            }
        });
        ka().g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Hw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5798Kw4.Ca(this.a, view);
            }
        });
        ka().q.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Iw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5798Kw4.Da(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        String stringExtra;
        String stringExtra2;
        if (data == null || (stringExtra = data.getStringExtra("country_code")) == null || (stringExtra2 = data.getStringExtra("country_shortname")) == null) {
            return;
        }
        int intExtra = data.getIntExtra("country_id", 0);
        if (requestCode == 0 && resultCode == -1) {
            ya(new C13197fp1(stringExtra, stringExtra2, intExtra, null, null, 24, null));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this.isRtl = JF5.g();
        this._binding = C5069Ht4.c(inflater, container, false);
        ConstraintLayout constraintLayoutB = ka().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        View view = ka().c;
        constraintLayoutB.setBackgroundColor(C5495Jo7.a.j0());
        return constraintLayoutB;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void e7(Menu menu) {
        AbstractC13042fc3.i(menu, "menu");
        super.e7(menu);
        menu.clear();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        Ea();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        sa();
        za();
        ta();
        ConstraintLayout constraintLayout = ka().f;
        AbstractC13042fc3.h(constraintLayout, "constraintLayout");
        ConstraintLayout constraintLayout2 = ka().f;
        AbstractC13042fc3.h(constraintLayout2, "constraintLayout");
        l4(constraintLayout, constraintLayout2);
    }

    public final C12328eR la() {
        C12328eR c12328eR = this.encryptedSharedPreferences;
        if (c12328eR != null) {
            return c12328eR;
        }
        AbstractC13042fc3.y("encryptedSharedPreferences");
        return null;
    }

    public final C15721k36 ma() {
        C15721k36 c15721k36 = this.rootBeer;
        if (c15721k36 != null) {
            return c15721k36;
        }
        AbstractC13042fc3.y("rootBeer");
        return null;
    }

    public final C7949Tw4 na() {
        return (C7949Tw4) this.viewModel.getValue();
    }
}
