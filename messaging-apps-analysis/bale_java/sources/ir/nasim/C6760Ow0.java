package ir.nasim;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AbstractC1970f;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC4820Gr7;
import ir.nasim.C21753u45;
import ir.nasim.C6760Ow0;
import ir.nasim.InterfaceC13548gQ1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22261uw0;
import ir.nasim.InterfaceC22848vv0;
import ir.nasim.features.call.ui.CallActivity;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ¢\u00012\u00020\u0001:\u0002£\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003JG\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0003J\u001f\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J'\u0010+\u001a\u00020\u00162\u0006\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b+\u0010,J'\u0010-\u001a\u00020\u00162\u0006\u0010*\u001a\u00020)2\u0006\u0010$\u001a\u00020\u00142\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0004H\u0003¢\u0006\u0004\b/\u0010\u0003J+\u00107\u001a\u0002062\u0006\u00101\u001a\u0002002\b\u00103\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b7\u00108J!\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u0002062\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b:\u0010;J/\u0010A\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00142\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160=2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0004H\u0016¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0004H\u0016¢\u0006\u0004\bD\u0010\u0003R\u001b\u0010J\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR0\u0010q\u001a\u0010\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR0\u0010v\u001a\u0010\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u0004\u0018\u00010i8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bs\u0010l\u001a\u0004\bt\u0010n\"\u0004\bu\u0010pR;\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010w2\u000e\u0010y\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010w8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR.\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007fR*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u0094\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R*\u0010\u009c\u0001\u001a\u00030\u0095\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R \u0010¡\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010Q\u001a\u0006\b\u009f\u0001\u0010 \u0001¨\u0006¤\u0001"}, d2 = {"Lir/nasim/Ow0;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "na", "()Lir/nasim/rB7;", "Lir/nasim/gj3;", "Pa", "()Lir/nasim/gj3;", "Ra", "Qa", "pa", "oa", "qa", "Ha", "Ua", "Ta", "", "callId", "", "groupId", "", "linkTitle", "initiatorUserId", "callLink", "callStartTime", "Oa", "(JILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", "Lir/nasim/wJ4;", "Lir/nasim/kw0;", "Sa", "()Lir/nasim/wJ4;", "ra", "La", "Na", "callLogCount", "", "isDeleteAll", "ab", "(IZ)V", "Landroid/content/Context;", "context", "wa", "(Landroid/content/Context;IZ)Ljava/lang/String;", "va", "Fa", "Va", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "h7", "T6", "Lir/nasim/Bx2;", "h1", "Lir/nasim/bW7;", "ta", "()Lir/nasim/Bx2;", "binding", "Landroidx/recyclerview/widget/RecyclerView$t;", "i1", "Landroidx/recyclerview/widget/RecyclerView$t;", "listsScrollListener", "Lir/nasim/Ew0;", "j1", "Lir/nasim/Yu3;", "Da", "()Lir/nasim/Ew0;", "viewModel", "Lir/nasim/rS1;", "k1", "xa", "()Lir/nasim/rS1;", "dialogsContainerViewModel", "Lir/nasim/pw0;", "l1", "Lir/nasim/pw0;", "adapter", "Lir/nasim/oJ4;", "m1", "Lir/nasim/oJ4;", "onGoingCallAdapter", "Lir/nasim/Vx0;", "n1", "Lir/nasim/Vx0;", "optionsAdapter", "o1", "Z", "isScrollingUp", "Lkotlin/Function1;", "Lir/nasim/kS7;", "p1", "Lir/nasim/UA2;", "za", "()Lir/nasim/UA2;", "Xa", "(Lir/nasim/UA2;)V", "onListScrolled", "Lir/nasim/gQ1;", "q1", "Ba", "Ya", "setAppBarState", "Lir/nasim/Fq2;", "Lir/nasim/Br7;", "value", "r1", "Lir/nasim/Fq2;", "Ca", "()Lir/nasim/Fq2;", "Za", "(Lir/nasim/Fq2;)V", "toolBarActionFlow", "s1", "sa", "Wa", "appBarUIIsCloseState", "Lir/nasim/Vi1;", "t1", "Lir/nasim/Vi1;", "ua", "()Lir/nasim/Vi1;", "setContactsNavigator", "(Lir/nasim/Vi1;)V", "contactsNavigator", "Lir/nasim/Sg3;", "u1", "Lir/nasim/Sg3;", "ya", "()Lir/nasim/Sg3;", "setJaryanNavigator", "(Lir/nasim/Sg3;)V", "jaryanNavigator", "Lir/nasim/Bk5;", "v1", "Lir/nasim/Bk5;", "Aa", "()Lir/nasim/Bk5;", "setPreferences", "(Lir/nasim/Bk5;)V", "preferences", "Lir/nasim/n10;", "w1", "Ea", "()Lir/nasim/n10;", "voiceCallErrorsSnackBar", "x1", "a", "call_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.Ow0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6760Ow0 extends VV2 {

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new s(), AbstractC20046rN7.c());

    /* renamed from: i1, reason: from kotlin metadata */
    private RecyclerView.t listsScrollListener;

    /* renamed from: j1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: k1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 dialogsContainerViewModel;

    /* renamed from: l1, reason: from kotlin metadata */
    private C19194pw0 adapter;

    /* renamed from: m1, reason: from kotlin metadata */
    private C18234oJ4 onGoingCallAdapter;

    /* renamed from: n1, reason: from kotlin metadata */
    private C8422Vx0 optionsAdapter;

    /* renamed from: o1, reason: from kotlin metadata */
    private boolean isScrollingUp;

    /* renamed from: p1, reason: from kotlin metadata */
    private UA2 onListScrolled;

    /* renamed from: q1, reason: from kotlin metadata */
    private UA2 setAppBarState;

    /* renamed from: r1, reason: from kotlin metadata */
    private InterfaceC4557Fq2 toolBarActionFlow;

    /* renamed from: s1, reason: from kotlin metadata */
    private InterfaceC4557Fq2 appBarUIIsCloseState;

    /* renamed from: t1, reason: from kotlin metadata */
    public InterfaceC8288Vi1 contactsNavigator;

    /* renamed from: u1, reason: from kotlin metadata */
    public InterfaceC7565Sg3 jaryanNavigator;

    /* renamed from: v1, reason: from kotlin metadata */
    public InterfaceC3570Bk5 preferences;

    /* renamed from: w1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 voiceCallErrorsSnackBar;
    static final /* synthetic */ InterfaceC5239Im3[] y1 = {AbstractC10882cM5.i(new C25226zw5(C6760Ow0.class, "binding", "getBinding()Lir/nasim/call/databinding/FragmentCallLogsBinding;", 0))};

    /* renamed from: x1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int z1 = 8;

    /* renamed from: ir.nasim.Ow0$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C6760Ow0 a() {
            return new C6760Ow0();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Ow0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ow0$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ boolean c;
            final /* synthetic */ C6760Ow0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6760Ow0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c) {
                    this.d.Da().f1();
                }
                return C19938rB7.a;
            }

            public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6760Ow0.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 appBarUIIsCloseState = C6760Ow0.this.getAppBarUIIsCloseState();
                if (appBarUIIsCloseState != null) {
                    a aVar = new a(C6760Ow0.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(appBarUIIsCloseState, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ow0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ow0$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6760Ow0 d;

            /* renamed from: ir.nasim.Ow0$c$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0563a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[EnumC3635Br7.values().length];
                    try {
                        iArr[EnumC3635Br7.a.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnumC3635Br7.b.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6760Ow0;
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
                int i = C0563a.a[((EnumC3635Br7) this.c).ordinal()];
                if (i == 1) {
                    Object value = this.d.Da().i1().getValue();
                    InterfaceC22261uw0.b bVar = value instanceof InterfaceC22261uw0.b ? (InterfaceC22261uw0.b) value : null;
                    if (bVar != null) {
                        this.d.ab(bVar.b().size(), bVar.c());
                    }
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.d.Da().f1();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC3635Br7 enumC3635Br7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC3635Br7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6760Ow0.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 toolBarActionFlow = C6760Ow0.this.getToolBarActionFlow();
                if (toolBarActionFlow != null) {
                    a aVar = new a(C6760Ow0.this, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(toolBarActionFlow, aVar, this) == objE) {
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
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ow0$d */
    /* synthetic */ class d extends EB2 implements SA2 {
        d(Object obj) {
            super(0, obj, C4375Ew0.class, "refreshCallLogs", "refreshCallLogs()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C4375Ew0) this.receiver).x1();
        }
    }

    /* renamed from: ir.nasim.Ow0$e */
    /* synthetic */ class e extends EB2 implements SA2 {
        e(Object obj) {
            super(0, obj, C6760Ow0.class, "deleteAllClicked", "deleteAllClicked()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C6760Ow0) this.receiver).ra();
        }
    }

    /* renamed from: ir.nasim.Ow0$f */
    /* synthetic */ class f extends EB2 implements SA2 {
        f(Object obj) {
            super(0, obj, C6760Ow0.class, "createPermissionDialog", "createPermissionDialog()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C6760Ow0) this.receiver).qa();
        }
    }

    /* renamed from: ir.nasim.Ow0$g */
    /* synthetic */ class g extends EB2 implements SA2 {
        g(Object obj) {
            super(0, obj, C6760Ow0.class, "openCall", "openCall()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C6760Ow0) this.receiver).Ta();
        }
    }

    /* renamed from: ir.nasim.Ow0$h */
    /* synthetic */ class h extends EB2 implements InterfaceC19342qB2 {
        h(Object obj) {
            super(6, obj, C6760Ow0.class, "joinCall", "joinCall(JILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V", 0);
        }

        @Override // ir.nasim.InterfaceC19342qB2
        public /* bridge */ /* synthetic */ Object j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            y(((Number) obj).longValue(), ((Number) obj2).intValue(), (String) obj3, (Integer) obj4, (String) obj5, (Long) obj6);
            return C19938rB7.a;
        }

        public final void y(long j, int i, String str, Integer num, String str2, Long l) {
            ((C6760Ow0) this.receiver).Oa(j, i, str, num, str2, l);
        }
    }

    /* renamed from: ir.nasim.Ow0$i */
    /* synthetic */ class i extends EB2 implements SA2 {
        i(Object obj) {
            super(0, obj, C6760Ow0.class, "openCreateGroupCallFragment", "openCreateGroupCallFragment()V", 0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            y();
            return C19938rB7.a;
        }

        public final void y() {
            ((C6760Ow0) this.receiver).Ua();
        }
    }

    /* renamed from: ir.nasim.Ow0$j */
    public static final class j extends RecyclerView.t {
        private final int a;

        j() {
            this.a = C6760Ow0.this.b6().getDimensionPixelOffset(AbstractC14008hB5.fab_scroll_threshold);
        }

        private final void c() {
            if (C6760Ow0.this.isScrollingUp) {
                C6760Ow0.this.isScrollingUp = false;
                if (!C8386Vt0.u8()) {
                    C6760Ow0.this.xa().k2();
                    return;
                }
                UA2 onListScrolled = C6760Ow0.this.getOnListScrolled();
                if (onListScrolled != null) {
                    onListScrolled.invoke(EnumC15954kS7.a);
                }
            }
        }

        private final void d() {
            if (C6760Ow0.this.isScrollingUp) {
                return;
            }
            C6760Ow0.this.isScrollingUp = true;
            if (!C8386Vt0.u8()) {
                C6760Ow0.this.xa().j2();
                return;
            }
            UA2 onListScrolled = C6760Ow0.this.getOnListScrolled();
            if (onListScrolled != null) {
                onListScrolled.invoke(EnumC15954kS7.b);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            if (Math.abs(i2) > this.a) {
                if (i2 > 0) {
                    d();
                } else {
                    c();
                }
            }
        }
    }

    /* renamed from: ir.nasim.Ow0$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Ow0$k$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6760Ow0 c;

            /* renamed from: ir.nasim.Ow0$k$a$a, reason: collision with other inner class name */
            static final class C0564a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C6760Ow0 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0564a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c6760Ow0;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0564a c0564a = new C0564a(this.d, interfaceC20295rm1);
                    c0564a.c = obj;
                    return c0564a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        NT4 nt4 = (NT4) this.c;
                        C19194pw0 c19194pw0 = this.d.adapter;
                        if (c19194pw0 != null) {
                            this.b = 1;
                            if (c19194pw0.L(nt4, this) == objE) {
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
                    return ((C0564a) create(nt4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6760Ow0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2J1 = this.c.Da().j1();
                    C0564a c0564a = new C0564a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2J1, c0564a, this) == objE) {
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

        /* renamed from: ir.nasim.Ow0$k$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6760Ow0 c;

            /* renamed from: ir.nasim.Ow0$k$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ C6760Ow0 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c6760Ow0;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = ((Boolean) obj).booleanValue();
                    return aVar;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.Da().E1(this.c);
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Ow0$k$b$b, reason: collision with other inner class name */
            public static final class C0565b implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.Ow0$k$b$b$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.Ow0$k$b$b$a$a, reason: collision with other inner class name */
                    public static final class C0566a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C0566a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.C6760Ow0.k.b.C0565b.a.C0566a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.Ow0$k$b$b$a$a r0 = (ir.nasim.C6760Ow0.k.b.C0565b.a.C0566a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.Ow0$k$b$b$a$a r0 = new ir.nasim.Ow0$k$b$b$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.gZ0 r5 = (ir.nasim.C13628gZ0) r5
                            ir.nasim.iG3 r5 = r5.e()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6760Ow0.k.b.C0565b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public C0565b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.Ow0$k$b$c */
            public static final class c implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;
                final /* synthetic */ C6760Ow0 b;
                final /* synthetic */ C19194pw0 c;

                /* renamed from: ir.nasim.Ow0$k$b$c$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;
                    final /* synthetic */ C6760Ow0 b;
                    final /* synthetic */ C19194pw0 c;

                    /* renamed from: ir.nasim.Ow0$k$b$c$a$a, reason: collision with other inner class name */
                    public static final class C0567a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C0567a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2, C6760Ow0 c6760Ow0, C19194pw0 c19194pw0) {
                        this.a = interfaceC4806Gq2;
                        this.b = c6760Ow0;
                        this.c = c19194pw0;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.C6760Ow0.k.b.c.a.C0567a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.Ow0$k$b$c$a$a r0 = (ir.nasim.C6760Ow0.k.b.c.a.C0567a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.Ow0$k$b$c$a$a r0 = new ir.nasim.Ow0$k$b$c$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L85
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            ir.nasim.iG3 r6 = (ir.nasim.C14653iG3) r6
                            ir.nasim.gG3 r2 = r6.f()
                            boolean r2 = r2 instanceof ir.nasim.AbstractC13460gG3.c
                            if (r2 == 0) goto L7b
                            ir.nasim.gG3 r6 = r6.d()
                            boolean r6 = r6.a()
                            if (r6 == 0) goto L7b
                            ir.nasim.Ow0 r6 = r5.b
                            ir.nasim.Ew0 r6 = ir.nasim.C6760Ow0.fa(r6)
                            ir.nasim.bL6 r6 = r6.l1()
                            java.lang.Object r6 = r6.getValue()
                            java.lang.Boolean r6 = (java.lang.Boolean) r6
                            boolean r6 = r6.booleanValue()
                            r2 = 0
                            if (r6 == 0) goto L6c
                            ir.nasim.pw0 r6 = r5.c
                            int r6 = r6.getItemCount()
                            r4 = 4
                            if (r6 > r4) goto L76
                        L6a:
                            r2 = r3
                            goto L76
                        L6c:
                            ir.nasim.pw0 r6 = r5.c
                            int r6 = r6.getItemCount()
                            r4 = 3
                            if (r6 > r4) goto L76
                            goto L6a
                        L76:
                            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r2)
                            goto L7c
                        L7b:
                            r6 = 0
                        L7c:
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r6, r0)
                            if (r6 != r1) goto L85
                            return r1
                        L85:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6760Ow0.k.b.c.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public c(InterfaceC4557Fq2 interfaceC4557Fq2, C6760Ow0 c6760Ow0, C19194pw0 c19194pw0) {
                    this.a = interfaceC4557Fq2;
                    this.b = c6760Ow0;
                    this.c = c19194pw0;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2, this.b, this.c), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6760Ow0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final AbstractC13460gG3 y(C13628gZ0 c13628gZ0) {
                return c13628gZ0.e().f();
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C19194pw0 c19194pw0 = this.c.adapter;
                    if (c19194pw0 == null) {
                        return C19938rB7.a;
                    }
                    InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.F(new c(new C0565b(AbstractC6459Nq2.x(c19194pw0.E(), new UA2() { // from class: ir.nasim.Pw0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return C6760Ow0.k.b.y((C13628gZ0) obj2);
                        }
                    })), this.c, c19194pw0)));
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2V, aVar, this) == objE) {
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
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            k kVar = C6760Ow0.this.new k(interfaceC20295rm1);
            kVar.c = obj;
            return kVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C6760Ow0.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C6760Ow0.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ow0$l */
    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        /* renamed from: ir.nasim.Ow0$l$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6760Ow0 c;

            /* renamed from: ir.nasim.Ow0$l$a$a, reason: collision with other inner class name */
            static final class C0568a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C6760Ow0 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0568a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c6760Ow0;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C0568a c0568a = new C0568a(this.d, interfaceC20295rm1);
                    c0568a.c = obj;
                    return c0568a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    int size;
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    InterfaceC22261uw0 interfaceC22261uw0 = (InterfaceC22261uw0) this.c;
                    if (interfaceC22261uw0 instanceof InterfaceC22261uw0.a) {
                        this.d.xa().E2(AbstractC4820Gr7.c.a);
                        C18234oJ4 c18234oJ4 = this.d.onGoingCallAdapter;
                        if (c18234oJ4 != null) {
                            c18234oJ4.C(((InterfaceC22261uw0.a) interfaceC22261uw0).a());
                        }
                        UA2 setAppBarState = this.d.getSetAppBarState();
                        if (setAppBarState != null) {
                            setAppBarState.invoke(InterfaceC13548gQ1.a.a);
                        }
                    } else {
                        if (!(interfaceC22261uw0 instanceof InterfaceC22261uw0.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        C18234oJ4 c18234oJ42 = this.d.onGoingCallAdapter;
                        if (c18234oJ42 != null) {
                            c18234oJ42.C(((InterfaceC22261uw0.b) interfaceC22261uw0).a());
                        }
                        if (!(this.d.xa().Q1().f() instanceof AbstractC4820Gr7.a)) {
                            this.d.xa().E2(new AbstractC4820Gr7.a(EnumC11273cj7.a));
                        }
                        C20085rS1 c20085rS1Xa = this.d.xa();
                        InterfaceC22261uw0.b bVar = (InterfaceC22261uw0.b) interfaceC22261uw0;
                        if (bVar.c()) {
                            UA2 setAppBarState2 = this.d.getSetAppBarState();
                            if (setAppBarState2 != null) {
                                setAppBarState2.invoke(new InterfaceC13548gQ1.b(0, true, 1, null));
                            }
                            size = Integer.MAX_VALUE;
                        } else {
                            UA2 setAppBarState3 = this.d.getSetAppBarState();
                            if (setAppBarState3 != null) {
                                setAppBarState3.invoke(new InterfaceC13548gQ1.b(bVar.b().size(), false, 2, null));
                            }
                            size = bVar.b().size();
                        }
                        c20085rS1Xa.w2(size);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC22261uw0 interfaceC22261uw0, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0568a) create(interfaceC22261uw0, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6760Ow0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC9336Zm4 interfaceC9336Zm4I1 = this.c.Da().i1();
                    C0568a c0568a = new C0568a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC9336Zm4I1, c0568a, this) == objE) {
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

        /* renamed from: ir.nasim.Ow0$l$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C6760Ow0 c;

            /* renamed from: ir.nasim.Ow0$l$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ C6760Ow0 d;

                /* renamed from: ir.nasim.Ow0$l$b$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0569a {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC3635Br7.values().length];
                        try {
                            iArr[EnumC3635Br7.a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[EnumC3635Br7.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = c6760Ow0;
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
                    int i = C0569a.a[((EnumC3635Br7) this.c).ordinal()];
                    if (i == 1) {
                        Object value = this.d.Da().i1().getValue();
                        InterfaceC22261uw0.b bVar = value instanceof InterfaceC22261uw0.b ? (InterfaceC22261uw0.b) value : null;
                        if (bVar != null) {
                            this.d.ab(bVar.b().size(), bVar.c());
                        }
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.d.Da().f1();
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(EnumC3635Br7 enumC3635Br7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(enumC3635Br7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c6760Ow0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC10040ay6 interfaceC10040ay6P1 = this.c.xa().P1();
                    a aVar = new a(this.c, null);
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC10040ay6P1, aVar, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            l lVar = C6760Ow0.this.new l(interfaceC20295rm1);
            lVar.c = obj;
            return lVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(C6760Ow0.this, null), 3, null);
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(C6760Ow0.this, null), 3, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ow0$m */
    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.Ow0$m$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C6760Ow0 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C6760Ow0 c6760Ow0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c6760Ow0;
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
                this.d.Ea().o((String) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C6760Ow0.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6M1 = C6760Ow0.this.Da().m1();
                a aVar = new a(C6760Ow0.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10040ay6M1, aVar, this) == objE) {
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
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ow0$n */
    public static final class n implements InterfaceC23079wJ4 {
        n() {
        }

        @Override // ir.nasim.InterfaceC23079wJ4
        public void a(int i) {
            C6760Ow0.this.Da().D1(i);
        }

        @Override // ir.nasim.InterfaceC23079wJ4
        public void b(int i) {
            C6760Ow0.this.Da().C1(i);
        }

        @Override // ir.nasim.InterfaceC23079wJ4
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void e(InterfaceC16239kw0 interfaceC16239kw0) {
            AbstractC13042fc3.i(interfaceC16239kw0, "item");
            C6760Ow0.this.Da().u1(interfaceC16239kw0);
        }

        @Override // ir.nasim.InterfaceC23079wJ4
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean v(InterfaceC16239kw0 interfaceC16239kw0) {
            AbstractC13042fc3.i(interfaceC16239kw0, "item");
            C6760Ow0.this.Da().v1(interfaceC16239kw0);
            return true;
        }
    }

    /* renamed from: ir.nasim.Ow0$o */
    static final class o implements InterfaceC15796kB2 {
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        /* renamed from: ir.nasim.Ow0$o$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C6760Ow0 a;
            final /* synthetic */ int b;
            final /* synthetic */ boolean c;

            a(C6760Ow0 c6760Ow0, int i, boolean z) {
                this.a = c6760Ow0;
                this.b = i;
                this.c = z;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C6760Ow0 c6760Ow0 = this.a;
                Context contextS7 = c6760Ow0.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                AbstractC19555qZ.B0(c6760Ow0.wa(contextS7, this.b, this.c), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.Ow0$o$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ C6760Ow0 a;
            final /* synthetic */ int b;
            final /* synthetic */ boolean c;

            b(C6760Ow0 c6760Ow0, int i, boolean z) {
                this.a = c6760Ow0;
                this.b = i;
                this.c = z;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C6760Ow0 c6760Ow0 = this.a;
                Context contextS7 = c6760Ow0.S7();
                AbstractC13042fc3.h(contextS7, "requireContext(...)");
                AbstractC19555qZ.e0(c6760Ow0.va(contextS7, this.b, this.c), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        o(int i, boolean z) {
            this.b = i;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C6760Ow0 c6760Ow0) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c6760Ow0, "this$0");
            dialog.dismiss();
            c6760Ow0.Da().h1();
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
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-383273425, true, new a(C6760Ow0.this, this.b, this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-1733683535, true, new b(C6760Ow0.this, this.b, this.c), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(997844513);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C6760Ow0.this);
            final C6760Ow0 c6760Ow0 = C6760Ow0.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Qw0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6760Ow0.o.d(dialog, c6760Ow0);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = BD5.dialogs_menu_calllog_delete;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(997853199);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Rw0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C6760Ow0.o.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC18060o11E, cVar, interfaceC18060o11E2, cVar2, aVar, sa2, i2, c1454b, (SA2) objB2, BD5.dialog_cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ow0$p */
    public static final class p extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.Q7().d1();
        }
    }

    /* renamed from: ir.nasim.Ow0$q */
    public static final class q extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ Fragment f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(SA2 sa2, Fragment fragment) {
            super(0);
            this.e = sa2;
            this.f = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.Q7().p3() : abstractC20375ru1;
        }
    }

    /* renamed from: ir.nasim.Ow0$r */
    public static final class r extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.Q7().n3();
        }
    }

    /* renamed from: ir.nasim.Ow0$s */
    public static final class s extends AbstractC8614Ws3 implements UA2 {
        public s() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C3684Bx2.a(fragment.V7());
        }
    }

    /* renamed from: ir.nasim.Ow0$t */
    public static final class t extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.Ow0$u */
    public static final class u extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.Ow0$v */
    public static final class v extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.Ow0$w */
    public static final class w extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.Ow0$x */
    public static final class x extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C6760Ow0() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new u(new t(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C4375Ew0.class), new v(interfaceC9173Yu3B), new w(null, interfaceC9173Yu3B), new x(this, interfaceC9173Yu3B));
        this.dialogsContainerViewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C20085rS1.class), new p(this), new q(null, this), new r(this));
        this.voiceCallErrorsSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.Lw0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6760Ow0.bb(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4375Ew0 Da() {
        return (C4375Ew0) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 Ea() {
        return (C17468n10) this.voiceCallErrorsSnackBar.getValue();
    }

    private final void Fa() {
        Object systemService = S7().getSystemService("notification");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT < 34 || notificationManager.canUseFullScreenIntent() || Aa().h("PREFERENCES_KEY_FULL_SCREEN_INTENT_DIALOG_SHOWN", false)) {
            return;
        }
        C24398yZ c24398yZ = C24398yZ.a;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        c24398yZ.i(contextS7, interfaceC18633oz3P6, new SA2() { // from class: ir.nasim.Mw0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6760Ow0.Ga(this.a);
            }
        });
        Aa().g("PREFERENCES_KEY_FULL_SCREEN_INTENT_DIALOG_SHOWN", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ga(C6760Ow0 c6760Ow0) {
        AbstractC13042fc3.i(c6760Ow0, "this$0");
        c6760Ow0.Va();
        return C19938rB7.a;
    }

    private final void Ha() {
        this.adapter = new C19194pw0(Sa(), new d(Da()), new e(this), new SA2() { // from class: ir.nasim.Iw0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C6760Ow0.Ia(this.a);
            }
        }, new UA2() { // from class: ir.nasim.Jw0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C6760Ow0.Ja(this.a, ((Integer) obj).intValue());
            }
        }, AbstractC6459Nq2.o0(AbstractC1970f.a(AbstractC17418mv7.b(xa().u1(), new UA2() { // from class: ir.nasim.Kw0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C6760Ow0.Ka(((Integer) obj).intValue()));
            }
        })), AbstractC19224pz3.a(this), InterfaceC16863lz6.a.c(), Boolean.FALSE), Da().k1(), new f(this));
        this.onGoingCallAdapter = new C18234oJ4(new g(this), new h(this));
        La();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ia(C6760Ow0 c6760Ow0) {
        AbstractC13042fc3.i(c6760Ow0, "this$0");
        C22042ua0.A9(c6760Ow0, c6760Ow0.ua().d(EnumC6843Pf2.c), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ja(C6760Ow0 c6760Ow0, int i2) {
        AbstractC13042fc3.i(c6760Ow0, "this$0");
        C22042ua0.A9(c6760Ow0, c6760Ow0.ya().h(i2, new ArrayList()), false, null, 6, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ka(int i2) {
        return i2 == 0;
    }

    private final void La() {
        this.optionsAdapter = new C8422Vx0();
        ArrayList arrayList = new ArrayList();
        C8386Vt0 c8386Vt0 = C8386Vt0.a;
        if (c8386Vt0.Ua()) {
            String strH6 = h6(BD5.call_log_option_create_group_call);
            AbstractC13042fc3.h(strH6, "getString(...)");
            arrayList.add(new C7715Sx0(strH6, AbstractC9594aE.b(S7(), AbstractC14606iB5.ic_call_contacts), new i(this), false, DL4.b));
        }
        if (c8386Vt0.V4()) {
            String strH62 = h6(BD5.features_call_link_option_title);
            AbstractC13042fc3.h(strH62, "getString(...)");
            arrayList.add(new C7715Sx0(strH62, AbstractC9594aE.b(S7(), AbstractC14606iB5.features_call_link_icon), new SA2() { // from class: ir.nasim.Nw0
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return C6760Ow0.Ma(this.a);
                }
            }, false, DL4.a));
        }
        C8422Vx0 c8422Vx0 = this.optionsAdapter;
        if (c8422Vx0 != null) {
            c8422Vx0.C(AbstractC15401jX0.m1(arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ma(C6760Ow0 c6760Ow0) {
        AbstractC13042fc3.i(c6760Ow0, "this$0");
        c6760Ow0.Da().A1();
        if (c6760Ow0.Da().q1()) {
            c6760Ow0.Da().B1();
        } else {
            C22042ua0.A9(c6760Ow0, C23438wv0.INSTANCE.a(), false, null, 6, null);
        }
        return C19938rB7.a;
    }

    private final void Na() {
        this.listsScrollListener = new j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oa(long callId, int groupId, String linkTitle, Integer initiatorUserId, String callLink, Long callStartTime) {
        if (callLink == null || AbstractC20762sZ6.n0(callLink)) {
            Da().p1(callId, groupId);
            return;
        }
        Da().z1(new InterfaceC22848vv0.d(0, 1, null), callId);
        if (!C8386Vt0.a.b5()) {
            Da().p1(callId, groupId);
        } else {
            C22042ua0.w9(this, C16848ly0.INSTANCE.a((32 & 1) != 0 ? 0L : callId, linkTitle, callLink, (32 & 8) != 0 ? 0 : initiatorUserId != null ? initiatorUserId.intValue() : 0, (32 & 16) != 0 ? 0L : callStartTime, (32 & 32) != 0 ? false : false), false, null, 6, null);
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    private final InterfaceC13730gj3 Pa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(null), 3, null);
    }

    private final InterfaceC13730gj3 Qa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new l(null), 3, null);
    }

    private final InterfaceC13730gj3 Ra() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new m(null), 3, null);
    }

    private final InterfaceC23079wJ4 Sa() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta() {
        CallActivity.Companion companion = CallActivity.INSTANCE;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        n8(companion.a(contextS7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua() {
        C22042ua0.w9(this, C8594Wq1.INSTANCE.a(), false, null, 6, null);
    }

    private final void Va() {
        n8(new Intent("android.settings.MANAGE_APP_USE_FULL_SCREEN_INTENT", Uri.parse("package:" + Q7().getPackageName())).addFlags(268435456));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ab(int callLogCount, boolean isDeleteAll) {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-576767917, true, new o(callLogCount, isDeleteAll)), 4, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 bb(C6760Ow0 c6760Ow0) {
        AbstractC13042fc3.i(c6760Ow0, "this$0");
        ConstraintLayout root = c6760Ow0.ta().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.m(3000);
        c17468n10.k(c6760Ow0.ta().b);
        return c17468n10;
    }

    private final C19938rB7 na() {
        C3684Bx2 c3684Bx2Ta = ta();
        Ha();
        c3684Bx2Ta.c.setAdapter(new androidx.recyclerview.widget.f(this.optionsAdapter, this.onGoingCallAdapter, this.adapter));
        RecyclerView.t tVar = this.listsScrollListener;
        if (tVar == null) {
            return null;
        }
        c3684Bx2Ta.c.addOnScrollListener(tVar);
        return C19938rB7.a;
    }

    private final InterfaceC13730gj3 oa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new b(null), 3, null);
    }

    private final InterfaceC13730gj3 pa() {
        return AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new c(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa() {
        C21753u45.a.a1(this, 306, C21753u45.c.d, (56 & 8) != 0 ? null : null, (56 & 16) != 0 ? new SA2() { // from class: ir.nasim.e45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.c1();
            }
        } : null, (56 & 32) != 0 ? new SA2() { // from class: ir.nasim.f45
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C21753u45.d1();
            }
        } : null, C21753u45.d.h, C21753u45.d.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra() {
        Da().g1();
    }

    private final C3684Bx2 ta() {
        Object objA = this.binding.a(this, y1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C3684Bx2) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String va(Context context, int callLogCount, boolean isDeleteAll) {
        if (isDeleteAll) {
            String string = context.getString(BD5.delete_all_call_log_description);
            AbstractC13042fc3.f(string);
            return string;
        }
        if (callLogCount <= 1) {
            String string2 = context.getString(BD5.delete_single_call_log_description);
            boolean zD = AbstractC13042fc3.d(Locale.getDefault().getLanguage(), "fa");
            AbstractC13042fc3.f(string2);
            return zD ? GY6.a(string2) : string2;
        }
        String string3 = context.getString(BD5.delete_multi_call_log_description, Separators.SP + callLogCount + Separators.SP);
        boolean zD2 = AbstractC13042fc3.d(Locale.getDefault().getLanguage(), "fa");
        AbstractC13042fc3.f(string3);
        return zD2 ? GY6.a(string3) : string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String wa(Context context, int callLogCount, boolean isDeleteAll) {
        if (isDeleteAll) {
            String string = context.getString(BD5.delete_all_call_log_title);
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        String str = Separators.SP;
        if (callLogCount > 1) {
            str = Separators.SP + callLogCount + Separators.SP;
        }
        String string2 = context.getString(BD5.delete_call_log_title, str);
        boolean zD = AbstractC13042fc3.d(Locale.getDefault().getLanguage(), "fa");
        AbstractC13042fc3.f(string2);
        return zD ? GY6.a(string2) : string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C20085rS1 xa() {
        return (C20085rS1) this.dialogsContainerViewModel.getValue();
    }

    public final InterfaceC3570Bk5 Aa() {
        InterfaceC3570Bk5 interfaceC3570Bk5 = this.preferences;
        if (interfaceC3570Bk5 != null) {
            return interfaceC3570Bk5;
        }
        AbstractC13042fc3.y("preferences");
        return null;
    }

    /* renamed from: Ba, reason: from getter */
    public final UA2 getSetAppBarState() {
        return this.setAppBarState;
    }

    /* renamed from: Ca, reason: from getter */
    public final InterfaceC4557Fq2 getToolBarActionFlow() {
        return this.toolBarActionFlow;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C3684Bx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this.listsScrollListener = null;
        ta().c.setOnScrollListener(null);
        ta().c.setAdapter(null);
        this.adapter = null;
        this.optionsAdapter = null;
        this.onGoingCallAdapter = null;
    }

    public final void Wa(InterfaceC4557Fq2 interfaceC4557Fq2) {
        this.appBarUIIsCloseState = interfaceC4557Fq2;
    }

    public final void Xa(UA2 ua2) {
        this.onListScrolled = ua2;
    }

    public final void Ya(UA2 ua2) {
        this.setAppBarState = ua2;
    }

    public final void Za(InterfaceC4557Fq2 interfaceC4557Fq2) {
        this.toolBarActionFlow = interfaceC4557Fq2;
        pa();
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode != 306) {
            super.g7(requestCode, permissions, grantResults);
            return;
        }
        Integer numD0 = AbstractC10242bK.d0(grantResults);
        if (numD0 == null || numD0.intValue() != 0) {
            Da().F1(false);
        } else {
            Da().w1();
            Da().F1(true);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        if (!((Boolean) Da().k1().getValue()).booleanValue()) {
            C4375Ew0 c4375Ew0Da = Da();
            boolean zO1 = Da().o1();
            if (zO1) {
                Da().w1();
            }
            c4375Ew0Da.F1(zO1);
        }
        Fa();
        super.h7();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Na();
        na();
        Pa();
        Qa();
        Ra();
        oa();
    }

    /* renamed from: sa, reason: from getter */
    public final InterfaceC4557Fq2 getAppBarUIIsCloseState() {
        return this.appBarUIIsCloseState;
    }

    public final InterfaceC8288Vi1 ua() {
        InterfaceC8288Vi1 interfaceC8288Vi1 = this.contactsNavigator;
        if (interfaceC8288Vi1 != null) {
            return interfaceC8288Vi1;
        }
        AbstractC13042fc3.y("contactsNavigator");
        return null;
    }

    public final InterfaceC7565Sg3 ya() {
        InterfaceC7565Sg3 interfaceC7565Sg3 = this.jaryanNavigator;
        if (interfaceC7565Sg3 != null) {
            return interfaceC7565Sg3;
        }
        AbstractC13042fc3.y("jaryanNavigator");
        return null;
    }

    /* renamed from: za, reason: from getter */
    public final UA2 getOnListScrolled() {
        return this.onListScrolled;
    }
}
