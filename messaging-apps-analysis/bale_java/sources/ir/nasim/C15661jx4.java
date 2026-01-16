package ir.nasim;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.a;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC17543n85;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC24003xs5;
import ir.nasim.C21753u45;
import ir.nasim.LP;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.root.RootActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 q2\u00020\u0001:\u0001rB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0003J/\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010#\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u000eH\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u000eH\u0002¢\u0006\u0004\b)\u0010\u0003J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010\u0003J\u0019\u00100\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u0010\u0003J\u000f\u00106\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J!\u0010:\u001a\u00020\u000e2\b\b\u0002\u00108\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u0017H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020@2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010\u0003J\u0017\u0010E\u001a\u00020@2\u0006\u0010D\u001a\u00020\u001aH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u000eH\u0002¢\u0006\u0004\bG\u0010\u0003R\u001b\u0010M\u001a\u00020H8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR.\u0010[\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0V0U8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010J\u001a\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010J\u001a\u0004\bf\u0010gR#\u0010m\u001a\n i*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010J\u001a\u0004\bk\u0010lR\u0014\u0010p\u001a\u00020N8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006s"}, d2 = {"Lir/nasim/jx4;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lir/nasim/rB7;", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "Landroid/view/Menu;", "menu", "e7", "(Landroid/view/Menu;)V", "T6", "", "requestCode", "", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "ta", "la", "oa", "qa", "Na", "Lir/nasim/gC6;", "viewState", "Qa", "(Lir/nasim/gC6;)V", "La", "selectItem", "ua", "(Ljava/lang/Integer;)V", "Fa", "Sa", "Ua", "", "Ka", "()Z", "x", "y", "Ra", "(II)V", "Lir/nasim/LP$a;", "activeAuthError", "Ja", "(Lir/nasim/LP$a;)V", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "ya", "(Lir/nasim/LP$a;)Lir/nasim/designsystem/modal/dialog/AlertDialog;", "Ma", DialogEntity.COLUMN_MESSAGE, "wa", "(Ljava/lang/String;)Lir/nasim/designsystem/modal/dialog/AlertDialog;", "Ba", "Lir/nasim/nx4;", "h1", "Lir/nasim/Yu3;", "Ia", "()Lir/nasim/nx4;", "viewModel", "Lir/nasim/It4;", "i1", "Lir/nasim/It4;", "_binding", "j1", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "alertDialog", "", "Lir/nasim/mw7;", "Lcom/google/android/material/card/MaterialCardView;", "Lir/nasim/xs5;", "k1", "Ljava/util/Set;", "cards", "Lir/nasim/n10;", "l1", "Ca", "()Lir/nasim/n10;", "baleSnackBar", "m1", "Ljava/lang/String;", "externalFile", "Lir/nasim/lm1;", "n1", "Ea", "()Lir/nasim/lm1;", "contextThemeWrapper", "kotlin.jvm.PlatformType", "o1", "Ha", "()Ljava/lang/String;", "transactionHash", "Da", "()Lir/nasim/It4;", "binding", "p1", "a", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.jx4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15661jx4 extends AbstractC15403jX2 {

    /* renamed from: p1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private C5303It4 _binding;

    /* renamed from: j1, reason: from kotlin metadata */
    private AlertDialog alertDialog;

    /* renamed from: k1, reason: from kotlin metadata */
    private Set cards;

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 baleSnackBar;

    /* renamed from: m1, reason: from kotlin metadata */
    private String externalFile;

    /* renamed from: n1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contextThemeWrapper;

    /* renamed from: o1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 transactionHash;

    /* renamed from: ir.nasim.jx4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C15661jx4 a(String str) {
            AbstractC13042fc3.i(str, "transactionHash");
            C15661jx4 c15661jx4 = new C15661jx4();
            c15661jx4.a8(AbstractC23348wm0.b(AbstractC4616Fw7.a("ARG_KEY_TRANSACTION_HASH", str)));
            return c15661jx4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jx4$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC10415ba2.values().length];
            try {
                iArr[EnumC10415ba2.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC10415ba2.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.jx4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jx4$d$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C15661jx4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C15661jx4 c15661jx4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c15661jx4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return n(((Number) obj).longValue(), (InterfaceC20295rm1) obj2);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.la();
                return C19938rB7.a;
            }

            public final Object n(long j, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(Long.valueOf(j), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.jx4$d$b */
        public static final class b implements InterfaceC4557Fq2 {
            final /* synthetic */ InterfaceC4557Fq2 a;

            /* renamed from: ir.nasim.jx4$d$b$a */
            public static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC4806Gq2 a;

                /* renamed from: ir.nasim.jx4$d$b$a$a, reason: collision with other inner class name */
                public static final class C1328a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int b;

                    public C1328a(InterfaceC20295rm1 interfaceC20295rm1) {
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
                public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ir.nasim.C15661jx4.d.b.a.C1328a
                        if (r0 == 0) goto L13
                        r0 = r8
                        ir.nasim.jx4$d$b$a$a r0 = (ir.nasim.C15661jx4.d.b.a.C1328a) r0
                        int r1 = r0.b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.b = r1
                        goto L18
                    L13:
                        ir.nasim.jx4$d$b$a$a r0 = new ir.nasim.jx4$d$b$a$a
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r8)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        ir.nasim.AbstractC10685c16.b(r8)
                        ir.nasim.Gq2 r8 = r6.a
                        ir.nasim.gC6 r7 = (ir.nasim.C13427gC6) r7
                        long r4 = r7.c()
                        java.lang.Long r7 = ir.nasim.AbstractC6392Nk0.e(r4)
                        r0.b = r3
                        java.lang.Object r7 = r8.a(r7, r0)
                        if (r7 != r1) goto L49
                        return r1
                    L49:
                        ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C15661jx4.d.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                }
            }

            public b(InterfaceC4557Fq2 interfaceC4557Fq2) {
                this.a = interfaceC4557Fq2;
            }

            @Override // ir.nasim.InterfaceC4557Fq2
            public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15661jx4.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(new b(C15661jx4.this.Ia().f1()));
                a aVar = new a(C15661jx4.this, null);
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
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jx4$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jx4$e$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C15661jx4 a;

            a(C15661jx4 c15661jx4) {
                this.a = c15661jx4;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C13427gC6 c13427gC6, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.Qa(c13427gC6);
                return C19938rB7.a;
            }
        }

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15661jx4.this.new e(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6F1 = C15661jx4.this.Ia().f1();
                a aVar = new a(C15661jx4.this);
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jx4$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15661jx4.this.new f(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(400L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C15661jx4.this.Da().v.V(this.d, this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jx4$g */
    public static final class g extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.jx4$h */
    public static final class h extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC15408jX7 invoke() {
            return (InterfaceC15408jX7) this.e.invoke();
        }
    }

    /* renamed from: ir.nasim.jx4$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9173Yu3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(InterfaceC9173Yu3 interfaceC9173Yu3) {
            super(0);
            this.e = interfaceC9173Yu3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return AbstractC6550Nz2.c(this.e).d1();
        }
    }

    /* renamed from: ir.nasim.jx4$j */
    public static final class j extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(SA2 sa2, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    /* renamed from: ir.nasim.jx4$k */
    public static final class k extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;
        final /* synthetic */ InterfaceC9173Yu3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment, InterfaceC9173Yu3 interfaceC9173Yu3) {
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

    public C15661jx4() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new h(new g(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C18025nx4.class), new i(interfaceC9173Yu3B), new j(null, interfaceC9173Yu3B), new k(this, interfaceC9173Yu3B));
        this.baleSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bx4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15661jx4.ka(this.a);
            }
        });
        this.contextThemeWrapper = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.cx4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15661jx4.va(this.a);
            }
        });
        this.transactionHash = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.dx4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C15661jx4.Ta(this.a);
            }
        });
        AbstractC5969Lp4.d().d0().g("show_invite_code_fragment", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(C15661jx4 c15661jx4, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        c15661jx4.Ba();
    }

    private final void Ba() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            try {
                try {
                    alertDialog.dismiss();
                } catch (Exception e2) {
                    C19406qI3.d("SignUpFragment", e2);
                }
            } finally {
                this.alertDialog = null;
            }
        }
    }

    private final C17468n10 Ca() {
        return (C17468n10) this.baleSnackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C5303It4 Da() {
        C5303It4 c5303It4 = this._binding;
        AbstractC13042fc3.f(c5303It4);
        return c5303It4;
    }

    private final C16731lm1 Ea() {
        return (C16731lm1) this.contextThemeWrapper.getValue();
    }

    private final void Fa() {
        new a.C0011a(S7()).d(new String[]{h6(AbstractC12217eE5.pick_photo_camera), h6(AbstractC12217eE5.pick_photo_gallery)}, new DialogInterface.OnClickListener() { // from class: ir.nasim.Zw4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C15661jx4.Ga(this.a, dialogInterface, i2);
            }
        }).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(C15661jx4 c15661jx4, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                C21753u45.Q0(C21753u45.a, c15661jx4, 4, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
                return;
            }
            Context contextS7 = c15661jx4.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            c15661jx4.startActivityForResult(C22055ub3.j(contextS7, true, false, false, false), 1);
            return;
        }
        String strL = C4053Dm2.l("capture", "jpg");
        c15661jx4.externalFile = strL;
        if (strL == null) {
            Toast.makeText(c15661jx4.G5(), AbstractC12217eE5.toast_no_sdcard, 1).show();
        } else if (AbstractC4043Dl1.a(c15661jx4.S7(), "android.permission.CAMERA") != 0) {
            C21753u45.j0(C21753u45.a, c15661jx4, 3, C21753u45.d.f, null, 8, null);
        } else {
            c15661jx4.Sa();
        }
    }

    private final String Ha() {
        return (String) this.transactionHash.getValue();
    }

    private final void Ja(LP.a activeAuthError) {
        Ba();
        Ia().Z0();
        try {
            if (activeAuthError.a()) {
                AlertDialog alertDialogYa = ya(activeAuthError);
                this.alertDialog = alertDialogYa;
                q9(alertDialogYa);
            } else {
                if (activeAuthError.b() == EnumC10415ba2.b) {
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    return;
                }
                String strH6 = activeAuthError.d() != null ? h6(activeAuthError.d().intValue()) : activeAuthError.e();
                AbstractC13042fc3.f(strH6);
                AlertDialog alertDialogWa = wa(strH6);
                this.alertDialog = alertDialogWa;
                q9(alertDialogWa);
            }
        } catch (Exception e2) {
            C19406qI3.d("SignUpFragment", e2);
        }
    }

    private final boolean Ka() {
        Editable text = Da().o.getText();
        AbstractC13042fc3.h(text, "getText(...)");
        int length = text.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = AbstractC13042fc3.k(text.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return text.subSequence(i2, length + 1).length() == 0;
    }

    private final void La() {
        Q7().finish();
        C5735Kp4.w().F();
        n8(new Intent(Q7(), (Class<?>) RootActivity.class));
    }

    private final void Ma() {
        C22042ua0.v9(this, BC5.content_frame, C5798Kw4.INSTANCE.a(), null, false, false, 28, null);
    }

    private final void Na() {
        AbstractC19224pz3.a(this).d(new d(null));
        AbstractC19224pz3.a(this).d(new e(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(C15661jx4 c15661jx4, String str, String str2) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        if (str == null || str.length() <= 0) {
            return;
        }
        Context contextS7 = c15661jx4.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        QI2.c(str, contextS7, AbstractC8943Xx1.c(100), AbstractC8943Xx1.c(100)).Q0(c15661jx4.Da().c);
        c15661jx4.Da().c.setPadding(AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2));
        c15661jx4.ua(null);
        c15661jx4.Ia().h1(new AbstractC24003xs5.c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(EditText editText) {
        AbstractC13042fc3.i(editText, "$this_run");
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(C13427gC6 viewState) {
        if (viewState.g()) {
            t2(AbstractC12217eE5.progress_common);
            return;
        }
        R4();
        if (viewState.d() instanceof LP.a) {
            Ja((LP.a) viewState.d());
        } else if (viewState.f()) {
            La();
        }
    }

    private final void Ra(int x, int y) {
        AbstractC19224pz3.a(this).d(new f(x, y, null));
    }

    private final void Sa() {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", FileProvider.h(S7(), S7().getPackageName() + ".provider", new File(this.externalFile))), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Ta(C15661jx4 c15661jx4) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        return c15661jx4.R7().getString("ARG_KEY_TRANSACTION_HASH", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua() {
        TextView textView = Da().e;
        if (!Ka()) {
            textView.setBackground(AbstractC4310Eo7.j(OY0.b(Ea(), AbstractC21139tA5.colorPrimary), OY0.b(Ea(), AbstractC21139tA5.colorPrimaryHover), 0));
            textView.setTextColor(-1);
        } else {
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setBackgroundColor(c5495Jo7.Z());
            textView.setTextColor(c5495Jo7.e0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 ka(C15661jx4 c15661jx4) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        RelativeLayout relativeLayoutB = c15661jx4.Da().getRoot();
        AbstractC13042fc3.h(relativeLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(relativeLayoutB, null, 0, 6, null);
        c17468n10.k(c15661jx4.Da().f);
        return c17468n10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        this.cards = AbstractC4597Fu6.i(new C17428mw7(Integer.valueOf(KB5.ic_avatar_man_1), Da().g, AbstractC24003xs5.d.a), new C17428mw7(Integer.valueOf(KB5.ic_avatar_man_2), Da().h, AbstractC24003xs5.e.a), new C17428mw7(Integer.valueOf(KB5.ic_avatar_woman_1), Da().j, AbstractC24003xs5.i.a), new C17428mw7(Integer.valueOf(KB5.ic_avatar_woman_2), Da().k, AbstractC24003xs5.j.a));
        Da().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Vw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15661jx4.ma(this.a, view);
            }
        });
        Set set = this.cards;
        if (set == null) {
            AbstractC13042fc3.y("cards");
            set = null;
        }
        int i2 = 0;
        for (Object obj : set) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            C17428mw7 c17428mw7 = (C17428mw7) obj;
            final int iIntValue = ((Number) c17428mw7.a()).intValue();
            final MaterialCardView materialCardView = (MaterialCardView) c17428mw7.b();
            final AbstractC24003xs5 abstractC24003xs5 = (AbstractC24003xs5) c17428mw7.c();
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.ax4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C15661jx4.na(this.a, iIntValue, materialCardView, abstractC24003xs5, view);
                }
            });
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(C15661jx4 c15661jx4, View view) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        c15661jx4.Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(C15661jx4 c15661jx4, int i2, MaterialCardView materialCardView, AbstractC24003xs5 abstractC24003xs5, View view) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        AbstractC13042fc3.i(materialCardView, "$image");
        AbstractC13042fc3.i(abstractC24003xs5, "$profileAvatar");
        c15661jx4.externalFile = null;
        c15661jx4.Da().c.setImageResource(i2);
        c15661jx4.Da().c.setPadding(AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2));
        c15661jx4.ua(Integer.valueOf(materialCardView.getId()));
        c15661jx4.Ia().h1(abstractC24003xs5);
    }

    private final void oa() {
        final C5303It4 c5303It4Da = Da();
        c5303It4Da.e.setTypeface(C6011Lu2.i());
        c5303It4Da.e.setBackground(AbstractC4310Eo7.j(AbstractC4043Dl1.c(S7(), TA5.primary), AbstractC4043Dl1.c(S7(), TA5.secondary_tint), 0));
        c5303It4Da.e.setTextColor(-1);
        c5303It4Da.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Yw4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15661jx4.pa(c5303It4Da, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(C5303It4 c5303It4, C15661jx4 c15661jx4, View view) {
        AbstractC13042fc3.i(c5303It4, "$this_with");
        AbstractC13042fc3.i(c15661jx4, "this$0");
        String string = c5303It4.o.getText().toString();
        if (string.length() <= 0) {
            C17468n10 c17468n10Ca = c15661jx4.Ca();
            String strH6 = c15661jx4.h6(AbstractC12217eE5.auth_error_confirm);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10Ca.o(strH6);
            return;
        }
        C18025nx4 c18025nx4Ia = c15661jx4.Ia();
        int length = string.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = AbstractC13042fc3.k(string.charAt(!z ? i2 : length), 32) <= 0;
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
        String string2 = string.subSequence(i2, length + 1).toString();
        String strHa = c15661jx4.Ha();
        AbstractC13042fc3.h(strHa, "<get-transactionHash>(...)");
        c18025nx4Ia.k1(string2, strHa);
    }

    private final void qa() {
        final C5303It4 c5303It4Da = Da();
        EditText editText = c5303It4Da.o;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        editText.setTextColor(c5495Jo7.g0());
        c5303It4Da.o.setHintTextColor(c5495Jo7.n0());
        EditText editText2 = c5303It4Da.o;
        AbstractC13042fc3.h(editText2, "inputUsername");
        editText2.addTextChangedListener(new c());
        c5303It4Da.o.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.ix4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C15661jx4.ra(this.a, c5303It4Da, view, z);
            }
        });
        c5303It4Da.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ww4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15661jx4.sa(this.a, c5303It4Da, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(C15661jx4 c15661jx4, C5303It4 c5303It4, View view, boolean z) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        AbstractC13042fc3.i(c5303It4, "$this_with");
        if (!z) {
            c5303It4.i.setStrokeWidth(0);
            c5303It4.n.setTextColor(C5495Jo7.a.f1());
            return;
        }
        c15661jx4.Ra((int) c5303It4.o.getX(), (int) c5303It4.m.getY());
        MaterialCardView materialCardView = c5303It4.i;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        materialCardView.setStrokeColor(c5495Jo7.t2());
        c5303It4.i.setStrokeWidth(AbstractC8943Xx1.c(2));
        c5303It4.n.setTextColor(c5495Jo7.t2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(C15661jx4 c15661jx4, C5303It4 c5303It4, View view) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        AbstractC13042fc3.i(c5303It4, "$this_with");
        c15661jx4.Ra((int) c5303It4.o.getX(), (int) c5303It4.m.getY());
    }

    private final void ta() {
        oa();
        qa();
    }

    private final void ua(Integer selectItem) {
        Set set = this.cards;
        if (set == null) {
            AbstractC13042fc3.y("cards");
            set = null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            MaterialCardView materialCardView = (MaterialCardView) ((C17428mw7) it.next()).b();
            int id = materialCardView.getId();
            if (selectItem != null && id == selectItem.intValue()) {
                materialCardView.setStrokeWidth(AbstractC8943Xx1.c(2));
                materialCardView.setStrokeColor(C5495Jo7.a.t2());
            } else {
                materialCardView.setStrokeWidth(AbstractC8943Xx1.c(0));
            }
            materialCardView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C16731lm1 va(C15661jx4 c15661jx4) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        return new C16731lm1(c15661jx4.S7(), AbstractC23035wE5.Theme_Bale_Base);
    }

    private final AlertDialog wa(String message) {
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        AlertDialog alertDialogA = new AlertDialog.a(fragmentActivityQ7).i(message).l(h6(AbstractC12217eE5.dialog_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.ex4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C15661jx4.xa(this.a, dialogInterface, i2);
            }
        }).a();
        alertDialogA.setCancelable(false);
        alertDialogA.setCanceledOnTouchOutside(false);
        return alertDialogA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(C15661jx4 c15661jx4, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        c15661jx4.Ba();
    }

    private final AlertDialog ya(final LP.a activeAuthError) {
        String strH6 = activeAuthError.d() != null ? h6(activeAuthError.d().intValue()) : activeAuthError.e();
        AbstractC13042fc3.f(strH6);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        AlertDialog alertDialogA = new AlertDialog.a(fragmentActivityQ7).i(strH6).l(h6(AbstractC12217eE5.dialog_try_again), new DialogInterface.OnClickListener() { // from class: ir.nasim.fx4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C15661jx4.za(this.a, activeAuthError, dialogInterface, i2);
            }
        }).j(h6(AbstractC12217eE5.dialog_cancel), new DialogInterface.OnClickListener() { // from class: ir.nasim.gx4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C15661jx4.Aa(this.a, dialogInterface, i2);
            }
        }).a();
        alertDialogA.setCancelable(false);
        alertDialogA.setCanceledOnTouchOutside(false);
        return alertDialogA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(C15661jx4 c15661jx4, LP.a aVar, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c15661jx4, "this$0");
        AbstractC13042fc3.i(aVar, "$activeAuthError");
        c15661jx4.Ba();
        int i3 = b.a[aVar.b().ordinal()];
        if (i3 == 1 || i3 == 2) {
            if (AbstractC13042fc3.d(aVar.c(), "PHONE_CODE_EXPIRED")) {
                c15661jx4.Ma();
                return;
            }
            C18025nx4 c18025nx4Ia = c15661jx4.Ia();
            String string = c15661jx4.Da().o.getText().toString();
            int length = string.length() - 1;
            int i4 = 0;
            boolean z = false;
            while (i4 <= length) {
                boolean z2 = AbstractC13042fc3.k(string.charAt(!z ? i4 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i4++;
                } else {
                    z = true;
                }
            }
            String string2 = string.subSequence(i4, length + 1).toString();
            String strHa = c15661jx4.Ha();
            AbstractC13042fc3.h(strHa, "<get-transactionHash>(...)");
            c18025nx4Ia.k1(string2, strHa);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        String str;
        ArrayList arrayList;
        if (requestCode != 1 || resultCode != -1) {
            if (requestCode == 2 && resultCode == -1 && (str = this.externalFile) != null && str.length() > 0 && new File(str).exists()) {
                AbstractC17543n85.a(null, A5(), this.externalFile, 1, false, new AbstractC17543n85.b() { // from class: ir.nasim.hx4
                    @Override // ir.nasim.AbstractC17543n85.b
                    public final void a(String str2, String str3) {
                        C15661jx4.Oa(this.a, str2, str3);
                    }
                });
                return;
            }
            return;
        }
        if (data == null || (arrayList = (ArrayList) data.getSerializableExtra("PHOTOS")) == null || arrayList.size() == 0) {
            return;
        }
        String str2 = (String) arrayList.get(0);
        AbstractC13042fc3.f(str2);
        ua(null);
        Ia().h1(new AbstractC24003xs5.c(str2));
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        QI2.c(str2, contextS7, AbstractC8943Xx1.c(100), AbstractC8943Xx1.c(100)).Q0(Da().c);
        Da().c.setPadding(AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2), AbstractC8943Xx1.c(2));
    }

    public final C18025nx4 Ia() {
        return (C18025nx4) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        C5303It4 c5303It4C = C5303It4.c(inflater, container, false);
        this._binding = c5303It4C;
        RelativeLayout relativeLayoutB = c5303It4C.getRoot();
        AbstractC13042fc3.h(relativeLayoutB, "let(...)");
        return relativeLayoutB;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        Da().o.setOnFocusChangeListener(null);
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void e7(Menu menu) {
        AbstractC13042fc3.i(menu, "menu");
        super.e7(menu);
        menu.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode == 3) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                Sa();
                return;
            }
            return;
        }
        if (requestCode != 4) {
            return;
        }
        if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            startActivityForResult(C22055ub3.j(contextS7, true, false, false, false), 1);
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        final EditText editText = Da().o;
        editText.post(new Runnable() { // from class: ir.nasim.Xw4
            @Override // java.lang.Runnable
            public final void run() {
                C15661jx4.Pa(editText);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ta();
        Na();
        RelativeLayout relativeLayout = Da().u;
        AbstractC13042fc3.h(relativeLayout, "relativeLayout");
        RelativeLayout relativeLayout2 = Da().u;
        AbstractC13042fc3.h(relativeLayout2, "relativeLayout");
        l4(relativeLayout, relativeLayout2);
    }

    /* renamed from: ir.nasim.jx4$c */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C15661jx4.this.Ua();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
