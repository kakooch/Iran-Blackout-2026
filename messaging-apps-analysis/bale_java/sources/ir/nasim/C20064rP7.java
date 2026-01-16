package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.compose.ui.e;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import com.google.android.gms.tasks.Task;
import com.google.i18n.phonenumbers.NumberParseException;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C20064rP7;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.LP;
import ir.nasim.XP7;
import ir.nasim.auth.smsretriever.SMSRetrieverBroadcastReceiver;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.modal.dialog.AlertDialog;
import ir.nasim.features.root.RootActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Í\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r*\u0001=\b\u0007\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0097\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\u001bJ\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\u001bJ\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u0004H\u0002¢\u0006\u0004\b0\u0010\u0003J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b2\u0010\u001bJ\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\u0003J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b>\u0010?J\u0019\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u0010@\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010\u0003J\u0019\u0010F\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ+\u0010N\u001a\u00020M2\u0006\u0010I\u001a\u00020H2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bN\u0010OJ!\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020M2\b\u0010L\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0004H\u0016¢\u0006\u0004\bS\u0010\u0003J\u000f\u0010T\u001a\u00020\u0004H\u0016¢\u0006\u0004\bT\u0010\u0003J\u0015\u0010U\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\b¢\u0006\u0004\bU\u0010\u001bR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010d\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\bb\u0010cR\u001b\u0010j\u001a\u00020e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\"\u0010r\u001a\u00020k8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0016\u0010u\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010tR\u0016\u0010}\u001a\u00020v8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010xR\u0016\u0010\u007f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010tR\u0018\u0010\u0081\u0001\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010cR \u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u0082\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010cR,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0017\u0010\u0095\u0001\u001a\u00020V8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u0098\u0001"}, d2 = {"Lir/nasim/rP7;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "Ja", "Qa", "ib", "", "htmlSection", "Landroid/text/Spanned;", "Wa", "(Ljava/lang/String;)Landroid/text/Spanned;", ParameterNames.TEXT, "boldString", "Landroid/text/SpannableStringBuilder;", "ua", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;", "Landroid/widget/TextView;", "editText", "ya", "(Landroid/widget/TextView;)V", "Ta", "ab", "hb", "phoneNumber", "Va", "(Ljava/lang/String;)V", "", "waitTime", "wa", "(J)V", "Landroid/content/Context;", "context", "", "durationInSeconds", "Aa", "(Landroid/content/Context;I)Ljava/lang/String;", "finalPhoneNumber", "Sa", "textPhoneNumber", "Ma", "", "Ua", "()Z", "gb", "qb", "Za", "Ya", "code", "pb", "kb", "Lir/nasim/XP7;", "viewState", "Xa", "(Lir/nasim/XP7;)V", "Lir/nasim/LP;", "authError", "Fa", "(Lir/nasim/LP;)V", "lb", "ir/nasim/rP7$c", "va", "()Lir/nasim/rP7$c;", DialogEntity.COLUMN_MESSAGE, "Da", "(Ljava/lang/String;)Ljava/lang/String;", "xa", "Landroid/os/Bundle;", "saveInstance", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "T6", "jb", "Lir/nasim/Oy2;", "h1", "Lir/nasim/Oy2;", "_binding", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "i1", "Lir/nasim/designsystem/modal/dialog/AlertDialog;", "alertDialog", "Lir/nasim/jp3;", "j1", "Lir/nasim/jp3;", "keyboardHelper", "k1", "Ljava/lang/String;", "TAG", "Lir/nasim/bQ7;", "l1", "Lir/nasim/Yu3;", "Ea", "()Lir/nasim/bQ7;", "viewModel", "Lir/nasim/TP;", "m1", "Lir/nasim/TP;", "Ba", "()Lir/nasim/TP;", "setAuthNavigator", "(Lir/nasim/TP;)V", "authNavigator", "n1", "J", "fullPhoneNumber", "Lir/nasim/SQ;", "o1", "Lir/nasim/SQ;", "sentCodeType", "p1", "codeTimeoutMillis", "q1", "nextCodeType", "r1", "nextSendCodeWaitTimeMillis", "s1", "transactionHash", "", "t1", "Ljava/util/List;", "imeiList", "Landroid/os/CountDownTimer;", "u1", "Landroid/os/CountDownTimer;", "timer", "v1", "Lir/nasim/n10;", "w1", "Lir/nasim/n10;", "getSnackBar", "()Lir/nasim/n10;", "setSnackBar", "(Lir/nasim/n10;)V", "snackBar", "Ca", "()Lir/nasim/Oy2;", "binding", "x1", "a", "authentication_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.rP7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20064rP7 extends ZX2 {

    /* renamed from: x1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int y1 = 8;

    /* renamed from: h1, reason: from kotlin metadata */
    private C6780Oy2 _binding;

    /* renamed from: i1, reason: from kotlin metadata */
    private AlertDialog alertDialog;

    /* renamed from: j1, reason: from kotlin metadata */
    private C15581jp3 keyboardHelper = new C15581jp3();

    /* renamed from: k1, reason: from kotlin metadata */
    private final String TAG = "NewValidateCodeFragment";

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: m1, reason: from kotlin metadata */
    public TP authNavigator;

    /* renamed from: n1, reason: from kotlin metadata */
    private long fullPhoneNumber;

    /* renamed from: o1, reason: from kotlin metadata */
    private SQ sentCodeType;

    /* renamed from: p1, reason: from kotlin metadata */
    private long codeTimeoutMillis;

    /* renamed from: q1, reason: from kotlin metadata */
    private SQ nextCodeType;

    /* renamed from: r1, reason: from kotlin metadata */
    private long nextSendCodeWaitTimeMillis;

    /* renamed from: s1, reason: from kotlin metadata */
    private String transactionHash;

    /* renamed from: t1, reason: from kotlin metadata */
    private List imeiList;

    /* renamed from: u1, reason: from kotlin metadata */
    private CountDownTimer timer;

    /* renamed from: v1, reason: from kotlin metadata */
    private String textPhoneNumber;

    /* renamed from: w1, reason: from kotlin metadata */
    private C17468n10 snackBar;

    /* renamed from: ir.nasim.rP7$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C20064rP7 b(Companion companion, long j, String str, List list, SQ sq, long j2, SQ sq2, long j3, String str2, int i, Object obj) {
            return companion.a(j, str, list, sq, j2, sq2, j3, (i & 128) != 0 ? null : str2);
        }

        public final C20064rP7 a(long j, String str, List list, SQ sq, long j2, SQ sq2, long j3, String str2) {
            AbstractC13042fc3.i(str, "transactionHash");
            AbstractC13042fc3.i(list, "imeiList");
            AbstractC13042fc3.i(sq, "sentCodeType");
            AbstractC13042fc3.i(sq2, "nextSendCodeType");
            C20064rP7 c20064rP7 = new C20064rP7();
            Bundle bundle = new Bundle();
            bundle.putLong("ARG_KEY_FULL_PHONE_NUMBER", j);
            bundle.putString("ARG_KEY_TRANSACTION_HASH", str);
            bundle.putStringArrayList("ARG_KEY_IMEI_LIST", new ArrayList<>(list));
            bundle.putSerializable("ARG_KEY_SENT_CODE_TYPE", sq);
            bundle.putLong("ARG_KEY_CODE_TIMEOUT_MILLIS", j2);
            bundle.putSerializable("ARG_KEY_NEXT_SEND_CODE_TYPE", sq2);
            bundle.putLong("ARG_KEY_NEXT_SEND_CODE_WAIT_TIME_MILLIS", j3);
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString("ARG_KEY_CODE_FROM_TELEGRAM", str2);
            c20064rP7.a8(bundle);
            return c20064rP7;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rP7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[SQ.values().length];
            try {
                iArr[SQ.e.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SQ.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SQ.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SQ.i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SQ.j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC10415ba2.values().length];
            try {
                iArr2[EnumC10415ba2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnumC10415ba2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnumC10415ba2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    /* renamed from: ir.nasim.rP7$c */
    public static final class c implements N76 {
        c() {
        }

        @Override // ir.nasim.N76
        public void a(String str) {
            if (str != null) {
                C19406qI3.a(C20064rP7.this.TAG, str, new Object[0]);
            }
        }

        @Override // ir.nasim.N76
        public void b(String str) {
            String strDa;
            if (str == null || (strDa = C20064rP7.this.Da(str)) == null) {
                return;
            }
            C20064rP7.this.Ca().n.setText(strDa);
        }
    }

    /* renamed from: ir.nasim.rP7$d */
    public static final class d extends CountDownTimer {
        final /* synthetic */ C20064rP7 a;

        /* renamed from: ir.nasim.rP7$d$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[SQ.values().length];
                try {
                    iArr[SQ.e.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SQ.d.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, C20064rP7 c20064rP7) {
            super(j, 1000L);
            this.a = c20064rP7;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            SQ sq = this.a.nextCodeType;
            if (sq == null) {
                AbstractC13042fc3.y("nextCodeType");
                sq = null;
            }
            int i = a.a[sq.ordinal()];
            if (i == 1) {
                TextView textView = this.a.Ca().p;
                AbstractC13042fc3.h(textView, "requestSendNextCode");
                textView.setVisibility(0);
                TextView textView2 = this.a.Ca().f;
                AbstractC13042fc3.h(textView2, "countDownTimer");
                textView2.setVisibility(8);
                this.a.Ca().d.setText(this.a.h6(AbstractC24206yD5.receive_code_by_calling));
                return;
            }
            if (i != 2) {
                FragmentActivity fragmentActivityA5 = this.a.A5();
                if (fragmentActivityA5 != null) {
                    fragmentActivityA5.onBackPressed();
                    return;
                }
                return;
            }
            TextView textView3 = this.a.Ca().p;
            AbstractC13042fc3.h(textView3, "requestSendNextCode");
            textView3.setVisibility(0);
            TextView textView4 = this.a.Ca().f;
            AbstractC13042fc3.h(textView4, "countDownTimer");
            textView4.setVisibility(8);
            this.a.Ca().d.setText(this.a.h6(AbstractC24206yD5.receive_code_via_sms));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String strAa = this.a.Aa(C5721Ko.a.d(), (int) (j / 1000));
            TextView textView = this.a.Ca().f;
            if (JF5.g()) {
                strAa = XY6.e(strAa);
            }
            textView.setText(strAa);
        }
    }

    /* renamed from: ir.nasim.rP7$e */
    static final class e implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.rP7$e$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C20064rP7 a;
            final /* synthetic */ Dialog b;

            a(C20064rP7 c20064rP7, Dialog dialog) {
                this.a = c20064rP7;
                this.b = dialog;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(C20064rP7 c20064rP7, Dialog dialog) {
                AbstractC13042fc3.i(c20064rP7, "this$0");
                AbstractC13042fc3.i(dialog, "$it");
                c20064rP7.Ya();
                dialog.dismiss();
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC12529em.a aVar = InterfaceC12529em.a;
                InterfaceC12529em.b bVarG = aVar.g();
                C24254yJ c24254yJ = C24254yJ.a;
                C24254yJ.f fVarB = c24254yJ.b();
                final C20064rP7 c20064rP7 = this.a;
                final Dialog dialog = this.b;
                e.a aVar2 = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarB, bVarG, interfaceC22053ub1, 54);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar2);
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
                G10 g10 = G10.a;
                int i2 = G10.b;
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, 0.0f, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 0.0f, 13, null);
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar.l(), interfaceC22053ub1, 0);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
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
                AbstractC9339Zm7.b(c20064rP7.textPhoneNumber, null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), interfaceC22053ub1, 0, 0, 65018);
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().j());
                interfaceC22053ub1.W(1900944985);
                boolean zD = interfaceC22053ub1.D(c20064rP7) | interfaceC22053ub1.D(dialog);
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.uP7
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C20064rP7.e.a.c(c20064rP7, dialog);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC24077y03.b(FV4.c(IB5.edit, interfaceC22053ub1, 0), null, androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), g10.a(interfaceC22053ub1, i2).I(), interfaceC22053ub1, 48, 0);
                interfaceC22053ub1.u();
                ZH6.a(androidx.compose.foundation.layout.t.i(aVar2, g10.c(interfaceC22053ub1, i2).b().j()), interfaceC22053ub1, 0);
                AbstractC19555qZ.e0(UY6.c(AbstractC12217eE5.enter_bale_dialog_body, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(C20064rP7 c20064rP7, Dialog dialog) {
            AbstractC13042fc3.i(c20064rP7, "this$0");
            AbstractC13042fc3.i(dialog, "$it");
            String str = c20064rP7.transactionHash;
            if (str == null) {
                AbstractC13042fc3.y("transactionHash");
                str = null;
            }
            c20064rP7.n8(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/baleOTP_bot?start=" + str)));
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
            InterfaceC14603iB2 interfaceC14603iB2A = C3237Aa1.a.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-60207968, true, new a(C20064rP7.this, dialog), interfaceC22053ub1, 54);
            AbstractC10289bP1.a.b bVar = AbstractC10289bP1.a.b.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-1599365484);
            boolean zD = interfaceC22053ub1.D(C20064rP7.this) | interfaceC22053ub1.D(dialog);
            final C20064rP7 c20064rP7 = C20064rP7.this;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.sP7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20064rP7.e.d(c20064rP7, dialog);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            String strC = UY6.c(AbstractC12217eE5.enter_bale_dialog_open_bot, interfaceC22053ub1, 0);
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-1599350638);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.tP7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20064rP7.e.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.F(interfaceC14603iB2A, c0905b, interfaceC18060o11E, bVar, aVar, sa2, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.Cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.b.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            dialog.setCanceledOnTouchOutside(true);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rP7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.rP7$f$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C20064rP7 a;

            a(C20064rP7 c20064rP7) {
                this.a = c20064rP7;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(XP7 xp7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.Xa(xp7);
                return C19938rB7.a;
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20064rP7.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6B1 = C20064rP7.this.Ea().b1();
                a aVar = new a(C20064rP7.this);
                this.b = 1;
                if (interfaceC10258bL6B1.b(aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rP7$g */
    public static final class g extends C13003fY2 {
        g(EditText editText) {
            super(editText);
        }

        @Override // ir.nasim.C13003fY2, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractC13042fc3.i(editable, "s");
            if (JF5.g()) {
                super.afterTextChanged(editable);
            }
            if (AbstractC20153rZ6.M(editable.toString(), Separators.SP, "", false, 4, null).length() == 5) {
                C20064rP7.this.Za();
            }
        }
    }

    /* renamed from: ir.nasim.rP7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20064rP7.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                this.b = 1;
                if (HG1.b(10000L, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C20064rP7 c20064rP7 = C20064rP7.this;
            c20064rP7.K9(c20064rP7.Ca().k);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rP7$i */
    public static final class i extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ Fragment e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Fragment fragment) {
            super(0);
            this.e = fragment;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Fragment invoke() {
            return this.e;
        }
    }

    /* renamed from: ir.nasim.rP7$j */
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

    /* renamed from: ir.nasim.rP7$k */
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

    /* renamed from: ir.nasim.rP7$l */
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

    /* renamed from: ir.nasim.rP7$m */
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

    public C20064rP7() {
        InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.c, new j(new i(this)));
        this.viewModel = AbstractC6550Nz2.b(this, AbstractC10882cM5.b(C10304bQ7.class), new k(interfaceC9173Yu3B), new l(null, interfaceC9173Yu3B), new m(this, interfaceC9173Yu3B));
        this.textPhoneNumber = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Aa(Context context, int durationInSeconds) {
        Object objValueOf;
        Object objValueOf2;
        if (durationInSeconds < 60) {
            String string = context.getString(AbstractC24206yD5.time_duration_seconds, String.valueOf(durationInSeconds));
            AbstractC13042fc3.h(string, "getString(...)");
            return string;
        }
        if (durationInSeconds >= 3600) {
            int i2 = durationInSeconds / 3600;
            int i3 = (durationInSeconds % 3600) / 60;
            String string2 = i3 > 0 ? context.getString(AbstractC24206yD5.time_duration_hours_comma_minutes, String.valueOf(i2), String.valueOf(i3)) : context.getString(AbstractC24206yD5.time_duration_hours, String.valueOf(i2));
            AbstractC13042fc3.f(string2);
            return string2;
        }
        int i4 = durationInSeconds / 60;
        int i5 = durationInSeconds % 60;
        if (i5 >= 10) {
            objValueOf = Integer.valueOf(i5);
        } else {
            objValueOf = "0" + i5;
        }
        if (i4 >= 10) {
            objValueOf2 = Integer.valueOf(i4);
        } else {
            objValueOf2 = "0" + i4;
        }
        String string3 = context.getString(AbstractC24206yD5.time_duration_minutes_comma_seconds, String.valueOf(objValueOf2), String.valueOf(objValueOf));
        AbstractC13042fc3.f(string3);
        return string3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C6780Oy2 Ca() {
        C6780Oy2 c6780Oy2 = this._binding;
        AbstractC13042fc3.f(c6780Oy2);
        return c6780Oy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Da(String message) {
        String strH6 = h6(AbstractC24206yD5.banking_input_acceptable_digits);
        AbstractC13042fc3.h(strH6, "getString(...)");
        Matcher matcher = Pattern.compile("\\b([" + strH6 + "]{5})\\b").matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private final void Fa(LP authError) {
        xa();
        final LP.a aVar = authError instanceof LP.a ? (LP.a) authError : null;
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.a()) {
                String strH6 = aVar.d() != null ? h6(aVar.d().intValue()) : aVar.e();
                AbstractC13042fc3.f(strH6);
                FragmentActivity fragmentActivityQ7 = Q7();
                AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
                AlertDialog alertDialogA = new AlertDialog.a(fragmentActivityQ7).i(strH6).l(h6(AbstractC24206yD5.dialog_try_again), new DialogInterface.OnClickListener() { // from class: ir.nasim.cP7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        C20064rP7.Ga(this.a, aVar, dialogInterface, i2);
                    }
                }).j(h6(AbstractC24206yD5.dialog_cancel), new DialogInterface.OnClickListener() { // from class: ir.nasim.dP7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        C20064rP7.Ha(this.a, dialogInterface, i2);
                    }
                }).a();
                alertDialogA.setCancelable(false);
                alertDialogA.setCanceledOnTouchOutside(false);
                this.alertDialog = alertDialogA;
                q9(alertDialogA);
                return;
            }
            String strH62 = aVar.d() != null ? h6(aVar.d().intValue()) : aVar.e();
            AbstractC13042fc3.f(strH62);
            FragmentActivity fragmentActivityQ72 = Q7();
            AbstractC13042fc3.h(fragmentActivityQ72, "requireActivity(...)");
            AlertDialog alertDialogA2 = new AlertDialog.a(fragmentActivityQ72).i(strH62).l(h6(AbstractC24206yD5.dialog_ok), new DialogInterface.OnClickListener() { // from class: ir.nasim.eP7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    C20064rP7.Ia(this.a, dialogInterface, i2);
                }
            }).a();
            alertDialogA2.setCancelable(false);
            alertDialogA2.setCanceledOnTouchOutside(false);
            this.alertDialog = alertDialogA2;
            q9(alertDialogA2);
        } catch (Exception e2) {
            C19406qI3.d(this.TAG, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(C20064rP7 c20064rP7, LP.a aVar, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        AbstractC13042fc3.i(aVar, "$authError");
        c20064rP7.xa();
        int i3 = b.b[aVar.b().ordinal()];
        if (i3 == 1) {
            c20064rP7.Za();
        } else if (i3 == 2) {
            c20064rP7.kb();
        } else {
            if (i3 != 3) {
                return;
            }
            c20064rP7.Za();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(C20064rP7 c20064rP7, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.xa();
        c20064rP7.Ca().n.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(C20064rP7 c20064rP7, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.xa();
        c20064rP7.Ca().n.setText("");
    }

    private final void Ja() {
        SQ sq = this.nextCodeType;
        if (sq == null) {
            AbstractC13042fc3.y("nextCodeType");
            sq = null;
        }
        int i2 = b.a[sq.ordinal()];
        if (i2 == 1) {
            Ca().d.setText(h6(AbstractC24206yD5.remaining_time_untill_request_code_via_call));
            Ca().p.setText(AbstractC24206yD5.request_Call);
            Ca().p.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.nP7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C20064rP7.Ka(this.a, view);
                }
            });
            wa(this.nextSendCodeWaitTimeMillis);
            return;
        }
        if (i2 != 2) {
            Ca().d.setText(h6(AbstractC24206yD5.new_auth_code_count_down_hint));
            wa(this.codeTimeoutMillis);
        } else {
            Ca().d.setText(h6(AbstractC24206yD5.remaining_time_untill_request_code_via_sms));
            Ca().p.setText(AbstractC24206yD5.request_SMS);
            Ca().p.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.oP7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C20064rP7.La(this.a, view);
                }
            });
            wa(this.nextSendCodeWaitTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        C10304bQ7 c10304bQ7Ea = c20064rP7.Ea();
        long j2 = c20064rP7.fullPhoneNumber;
        List list = c20064rP7.imeiList;
        SQ sq = null;
        if (list == null) {
            AbstractC13042fc3.y("imeiList");
            list = null;
        }
        SQ sq2 = c20064rP7.nextCodeType;
        if (sq2 == null) {
            AbstractC13042fc3.y("nextCodeType");
        } else {
            sq = sq2;
        }
        c10304bQ7Ea.h1(j2, list, sq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        C10304bQ7 c10304bQ7Ea = c20064rP7.Ea();
        long j2 = c20064rP7.fullPhoneNumber;
        List list = c20064rP7.imeiList;
        SQ sq = null;
        if (list == null) {
            AbstractC13042fc3.y("imeiList");
            list = null;
        }
        SQ sq2 = c20064rP7.nextCodeType;
        if (sq2 == null) {
            AbstractC13042fc3.y("nextCodeType");
        } else {
            sq = sq2;
        }
        c10304bQ7Ea.h1(j2, list, sq);
    }

    private final void Ma(final String textPhoneNumber) {
        Ca().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.fP7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20064rP7.Na(this.a, textPhoneNumber, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(final C20064rP7 c20064rP7, String str, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        AbstractC13042fc3.i(str, "$textPhoneNumber");
        Context contextS7 = c20064rP7.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        AlertDialog.a aVarM = new AlertDialog.a(contextS7).m(c20064rP7.h6(AbstractC24206yD5.new_auth_code_title_alert));
        String strH6 = c20064rP7.h6(AbstractC24206yD5.new_auth_code_message_alert);
        AbstractC13042fc3.h(strH6, "getString(...)");
        AlertDialog alertDialogA = aVarM.i(AbstractC20153rZ6.M(strH6, "{0}", str, false, 4, null)).l(c20064rP7.h6(AbstractC24206yD5.new_auth_code_try_again), new DialogInterface.OnClickListener() { // from class: ir.nasim.gP7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C20064rP7.Oa(this.a, dialogInterface, i2);
            }
        }).k(c20064rP7.h6(AbstractC24206yD5.new_auth_code_change_phone_number), new DialogInterface.OnClickListener() { // from class: ir.nasim.hP7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                C20064rP7.Pa(this.a, dialogInterface, i2);
            }
        }).a();
        c20064rP7.q9(alertDialogA);
        alertDialogA.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(C20064rP7 c20064rP7, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.kb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(C20064rP7 c20064rP7, DialogInterface dialogInterface, int i2) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.Ya();
    }

    private final void Qa() {
        String strV = XY6.v(String.valueOf((int) (this.nextSendCodeWaitTimeMillis / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)));
        SQ sq = this.sentCodeType;
        SQ sq2 = null;
        if (sq == null) {
            AbstractC13042fc3.y("sentCodeType");
            sq = null;
        }
        int[] iArr = b.a;
        int i2 = iArr[sq.ordinal()];
        if (i2 == 1) {
            TextView textView = Ca().q;
            String strH6 = h6(AbstractC24206yD5.auth_code_call);
            AbstractC13042fc3.h(strH6, "getString(...)");
            textView.setText(Wa(strH6));
            DY6 dy6 = DY6.a;
            String strH62 = h6(AbstractC24206yD5.calling_phone_number);
            AbstractC13042fc3.h(strH62, "getString(...)");
            String str = String.format(strH62, Arrays.copyOf(new Object[]{this.textPhoneNumber}, 1));
            AbstractC13042fc3.h(str, "format(...)");
            jb(str);
            return;
        }
        if (i2 == 2) {
            TextView textView2 = Ca().q;
            DY6 dy62 = DY6.a;
            String strH63 = h6(AbstractC24206yD5.auth_code_sms);
            AbstractC13042fc3.h(strH63, "getString(...)");
            String str2 = String.format(strH63, Arrays.copyOf(new Object[]{this.textPhoneNumber}, 1));
            AbstractC13042fc3.h(str2, "format(...)");
            textView2.setText(str2);
            return;
        }
        if (i2 == 3) {
            SQ sq3 = this.nextCodeType;
            if (sq3 == null) {
                AbstractC13042fc3.y("nextCodeType");
            } else {
                sq2 = sq3;
            }
            int i3 = iArr[sq2.ordinal()];
            if (i3 == 1) {
                TextView textView3 = Ca().q;
                String strI6 = i6(AbstractC24206yD5.auth_code_app_next_is_call, strV);
                AbstractC13042fc3.h(strI6, "getString(...)");
                textView3.setText(Wa(strI6));
            } else if (i3 != 2) {
                TextView textView4 = Ca().q;
                String strH64 = h6(AbstractC24206yD5.auth_code_app_next_is_null);
                AbstractC13042fc3.h(strH64, "getString(...)");
                textView4.setText(Wa(strH64));
            } else {
                TextView textView5 = Ca().q;
                String strI62 = i6(AbstractC24206yD5.auth_code_app_next_is_sms, strV);
                AbstractC13042fc3.h(strI62, "getString(...)");
                textView5.setText(Wa(strI62));
            }
            ib();
            return;
        }
        if (i2 != 4) {
            if (i2 != 5) {
                TextView textView6 = Ca().q;
                String strH65 = h6(AbstractC24206yD5.auth_code_all);
                AbstractC13042fc3.h(strH65, "getString(...)");
                textView6.setText(Wa(strH65));
                return;
            }
            Ca().q.setText(h6(AbstractC24206yD5.auth_code_telegram_next_is_null));
            Ca().l.setVisibility(0);
            Ca().l.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bP7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C20064rP7.Ra(this.a, view);
                }
            });
            if (!AbstractC20762sZ6.n0(Ea().a1())) {
                return;
            }
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
            AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
            AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-757323710, true, new e()), 4, null).show();
            return;
        }
        SQ sq4 = this.nextCodeType;
        if (sq4 == null) {
            AbstractC13042fc3.y("nextCodeType");
        } else {
            sq2 = sq4;
        }
        int i4 = iArr[sq2.ordinal()];
        if (i4 == 1) {
            TextView textView7 = Ca().q;
            String strI63 = i6(AbstractC24206yD5.auth_code_whatsapp_next_is_call, strV);
            AbstractC13042fc3.h(strI63, "getString(...)");
            String strH66 = h6(AbstractC24206yD5.auth_code_whatsapp_bold_part);
            AbstractC13042fc3.h(strH66, "getString(...)");
            textView7.setText(ua(strI63, strH66));
            return;
        }
        if (i4 != 2) {
            Ca().q.setText(h6(AbstractC24206yD5.auth_code_whatsapp_next_is_null));
            return;
        }
        TextView textView8 = Ca().q;
        String strI64 = i6(AbstractC24206yD5.auth_code_whatsapp_next_is_sms, strV);
        AbstractC13042fc3.h(strI64, "getString(...)");
        String strH67 = h6(AbstractC24206yD5.auth_code_whatsapp_bold_part);
        AbstractC13042fc3.h(strH67, "getString(...)");
        textView8.setText(ua(strI64, strH67));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        String str = c20064rP7.transactionHash;
        if (str == null) {
            AbstractC13042fc3.y("transactionHash");
            str = null;
        }
        c20064rP7.n8(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/baleOTP_bot?start=" + str)));
    }

    private final void Sa(String finalPhoneNumber) throws NumberFormatException {
        this.textPhoneNumber = finalPhoneNumber;
        try {
            com.google.i18n.phonenumbers.g gVarH = com.google.i18n.phonenumbers.f.o().H("+" + this.textPhoneNumber, null);
            AbstractC13042fc3.f(gVarH);
            this.textPhoneNumber = JF5.c(gVarH);
        } catch (NumberParseException e2) {
            C19406qI3.c(this.TAG, "error in initPhoneNumber: " + e2, e2);
        }
        if (JF5.g()) {
            this.textPhoneNumber = XY6.e(this.textPhoneNumber);
        }
        Ma(this.textPhoneNumber);
    }

    private final void Ta() {
        Ca().d.setTypeface(C6011Lu2.k());
        TextView textView = Ca().d;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.n0());
        Ca().f.setTypeface(C6011Lu2.i());
        Ca().f.setTextColor(c5495Jo7.e2());
        Ca().n.setTypeface(C6011Lu2.i());
        if (!AbstractC20762sZ6.n0(Ea().a1())) {
            Ca().n.setText(Ea().a1());
            Za();
        }
        SQ sq = this.sentCodeType;
        if (sq == null) {
            AbstractC13042fc3.y("sentCodeType");
            sq = null;
        }
        if (sq != SQ.j) {
            ya(Ca().n);
        }
        Ca().e.setClickable(false);
        Ca().e.setTextColor(AbstractC4043Dl1.c(S7(), RA5.secondary));
        Ca().e.setTypeface(C6011Lu2.i());
        Ca().e.setVisibility(4);
        Ca().g.setClickable(false);
        Ca().g.setTypeface(C6011Lu2.i());
        Ca().g.setVisibility(0);
        Ca().q.setTextColor(c5495Jo7.o0());
        Ca().q.setTypeface(C6011Lu2.k());
        Ca().m.setTextColor(c5495Jo7.g0());
        Ca().m.setTypeface(C6011Lu2.i());
        ConstraintLayout constraintLayoutB = Ca().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(constraintLayoutB, null, 0, 6, null);
        c17468n10.k(Ca().b);
        this.snackBar = c17468n10;
        Ca().j.setBackground(AbstractC4310Eo7.j(c5495Jo7.B2(), c5495Jo7.y0(c5495Jo7.n0(), 27), 8));
        Ca().r.setTypeface(C6011Lu2.i());
        Ca().u.setTypeface(C6011Lu2.i());
        Ca().s.setTypeface(C6011Lu2.i());
        Ca().s.setTextColor(c5495Jo7.o0());
        Ca().i.setContent(C3237Aa1.a.c());
        TextView textView2 = Ca().t;
        textView2.setTypeface(C6011Lu2.i());
        textView2.setBackground(AbstractC4310Eo7.j(c5495Jo7.B2(), c5495Jo7.y0(c5495Jo7.n0(), 27), 4));
    }

    private final boolean Ua() {
        Editable text = Ca().n.getText();
        Objects.requireNonNull(text);
        return text.toString().length() < 5;
    }

    private final void Va(String phoneNumber) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + phoneNumber));
        n8(intent);
    }

    private final Spanned Wa(String htmlSection) {
        Spanned spannedA = AbstractC14221hZ2.a(htmlSection, 63);
        AbstractC13042fc3.h(spannedA, "fromHtml(...)");
        return spannedA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa(XP7 viewState) {
        String str;
        List list;
        if (viewState instanceof XP7.a) {
            if (!viewState.a()) {
                R4();
            }
            Fa(((XP7.a) viewState).b());
            return;
        }
        if (viewState instanceof XP7.c) {
            t2(AbstractC24206yD5.progress_common);
            return;
        }
        if (viewState instanceof XP7.d) {
            if (!viewState.a()) {
                R4();
            }
            V5().k1();
            p9(C15661jx4.INSTANCE.a(((XP7.d) viewState).b()));
            return;
        }
        if (viewState instanceof XP7.e) {
            if (!viewState.a()) {
                R4();
            }
            Q7().finish();
            C5735Kp4.w().F();
            n8(new Intent(Q7(), (Class<?>) RootActivity.class));
            return;
        }
        if (!(viewState instanceof XP7.f)) {
            if (!AbstractC13042fc3.d(viewState, XP7.b.c)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        if (!viewState.a()) {
            R4();
        }
        Q7().B0().k1();
        Companion companion = INSTANCE;
        long j2 = this.fullPhoneNumber;
        String str2 = this.transactionHash;
        if (str2 == null) {
            AbstractC13042fc3.y("transactionHash");
            str = null;
        } else {
            str = str2;
        }
        List list2 = this.imeiList;
        if (list2 == null) {
            AbstractC13042fc3.y("imeiList");
            list = null;
        } else {
            list = list2;
        }
        XP7.f fVar = (XP7.f) viewState;
        C22042ua0.A9(this, Companion.b(companion, j2, str, list, fVar.e(), fVar.b(), fVar.c(), fVar.d(), null, 128, null), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ya() {
        if (AbstractC20762sZ6.n0(Ea().a1())) {
            Q7().onBackPressed();
        } else {
            V5().s().r(BC5.activity_base_login, Ba().c(), null).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Za() {
        String strH = XY6.h(AbstractC20153rZ6.M(Ca().n.getText().toString(), Separators.SP, "", false, 4, null));
        if (strH.length() > 0) {
            this.keyboardHelper.c(Ca().n, false);
            pb(strH);
        }
    }

    private final void ab() {
        Ca().n.addTextChangedListener(new g(Ca().n));
        Ca().n.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.nasim.ZO7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return C20064rP7.eb(this.a, textView, i2, keyEvent);
            }
        });
        Ca().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iP7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20064rP7.fb(this.a, view);
            }
        });
        Ca().g.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jP7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20064rP7.bb(this.a, view);
            }
        });
        Ca().j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kP7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20064rP7.cb(this.a, view);
            }
        });
        Ca().t.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lP7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C20064rP7.db(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.Ya();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.Va("02183386");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void db(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        c20064rP7.hb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean eb(C20064rP7 c20064rP7, TextView textView, int i2, KeyEvent keyEvent) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        if (i2 != 2) {
            return false;
        }
        if (c20064rP7.Ua()) {
            c20064rP7.gb();
            return true;
        }
        c20064rP7.Za();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(C20064rP7 c20064rP7, View view) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        if (c20064rP7.Ua()) {
            c20064rP7.gb();
        } else {
            c20064rP7.Za();
        }
    }

    private final void gb() {
        AbstractC7426Rr.a.S(Ca().c, 10.0f, 1);
    }

    private final void hb() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, C3237Aa1.a.f(), 4, null).show();
    }

    private final void ib() {
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC10533bm0.d(AbstractC19224pz3.a(interfaceC18633oz3P6), null, null, new h(null), 3, null);
    }

    private final void kb() {
        C10304bQ7 c10304bQ7Ea = Ea();
        long j2 = this.fullPhoneNumber;
        List list = this.imeiList;
        SQ sq = null;
        if (list == null) {
            AbstractC13042fc3.y("imeiList");
            list = null;
        }
        SQ sq2 = this.sentCodeType;
        if (sq2 == null) {
            AbstractC13042fc3.y("sentCodeType");
        } else {
            sq = sq2;
        }
        c10304bQ7Ea.h1(j2, list, sq);
    }

    private final void lb() {
        Task taskZ = SF6.b(S7()).z();
        final UA2 ua2 = new UA2() { // from class: ir.nasim.pP7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20064rP7.mb(this.a, (Void) obj);
            }
        };
        taskZ.f(new InterfaceC13497gK4() { // from class: ir.nasim.qP7
            @Override // ir.nasim.InterfaceC13497gK4
            public final void onSuccess(Object obj) {
                C20064rP7.nb(ua2, obj);
            }
        }).d(new InterfaceC14681iJ4() { // from class: ir.nasim.aP7
            @Override // ir.nasim.InterfaceC14681iJ4
            public final void a(Exception exc) {
                C20064rP7.ob(this.a, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 mb(C20064rP7 c20064rP7, Void r1) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        SMSRetrieverBroadcastReceiver.INSTANCE.a(c20064rP7.va());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void nb(UA2 ua2, Object obj) {
        AbstractC13042fc3.i(ua2, "$tmp0");
        ua2.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ob(C20064rP7 c20064rP7, Exception exc) {
        AbstractC13042fc3.i(c20064rP7, "this$0");
        AbstractC13042fc3.i(exc, "it");
        C19406qI3.d(c20064rP7.TAG, exc);
    }

    private final void pb(String code) {
        C10304bQ7 c10304bQ7Ea = Ea();
        String str = this.transactionHash;
        if (str == null) {
            AbstractC13042fc3.y("transactionHash");
            str = null;
        }
        c10304bQ7Ea.i1(str, code);
    }

    private final void qb() {
        Ca().f.setVisibility(0);
        Ca().d.setVisibility(0);
        Ca().e.setClickable(false);
        Ca().e.setVisibility(4);
        Ca().g.setVisibility(0);
    }

    private final SpannableStringBuilder ua(String text, String boldString) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        int iL0 = AbstractC20762sZ6.l0(spannableStringBuilder, boldString, 0, false, 6, null);
        spannableStringBuilder.setSpan(new T10(C6011Lu2.i()), iL0, boldString.length() + iL0, 33);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(1.1f), iL0, boldString.length() + iL0, 33);
        return spannableStringBuilder;
    }

    private final c va() {
        return new c();
    }

    private final void wa(long waitTime) {
        this.timer = new d(waitTime, this);
        qb();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer == null) {
            AbstractC13042fc3.y("timer");
            countDownTimer = null;
        }
        countDownTimer.start();
    }

    private final void xa() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null) {
            try {
                try {
                    alertDialog.dismiss();
                } catch (Exception e2) {
                    C19406qI3.d(this.TAG, e2);
                }
            } finally {
                this.alertDialog = null;
            }
        }
    }

    private final void ya(final TextView editText) {
        if (editText != null) {
            editText.post(new Runnable() { // from class: ir.nasim.mP7
                @Override // java.lang.Runnable
                public final void run() {
                    C20064rP7.za(editText);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(TextView textView) {
        textView.requestFocus();
    }

    public final TP Ba() {
        TP tp = this.authNavigator;
        if (tp != null) {
            return tp;
        }
        AbstractC13042fc3.y("authNavigator");
        return null;
    }

    public final C10304bQ7 Ea() {
        return (C10304bQ7) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle saveInstance) {
        super.M6(saveInstance);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List arrayList;
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C6780Oy2.c(inflater, container, false);
        ConstraintLayout constraintLayoutB = Ca().getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        constraintLayoutB.setBackgroundColor(C5495Jo7.a.j0());
        Bundle bundleR7 = R7();
        this.fullPhoneNumber = bundleR7.getLong("ARG_KEY_FULL_PHONE_NUMBER", 0L);
        this.transactionHash = bundleR7.getString("ARG_KEY_TRANSACTION_HASH", "");
        ArrayList<String> stringArrayList = bundleR7.getStringArrayList("ARG_KEY_IMEI_LIST");
        if (stringArrayList == null || (arrayList = AbstractC15401jX0.m1(stringArrayList)) == null) {
            arrayList = new ArrayList();
        }
        this.imeiList = arrayList;
        Serializable serializable = bundleR7.getSerializable("ARG_KEY_SENT_CODE_TYPE");
        AbstractC13042fc3.g(serializable, "null cannot be cast to non-null type ir.nasim.core.modules.auth.entity.AuthSendCodeType");
        this.sentCodeType = (SQ) serializable;
        this.codeTimeoutMillis = bundleR7.getLong("ARG_KEY_CODE_TIMEOUT_MILLIS");
        Serializable serializable2 = bundleR7.getSerializable("ARG_KEY_NEXT_SEND_CODE_TYPE");
        AbstractC13042fc3.g(serializable2, "null cannot be cast to non-null type ir.nasim.core.modules.auth.entity.AuthSendCodeType");
        this.nextCodeType = (SQ) serializable2;
        this.nextSendCodeWaitTimeMillis = bundleR7.getLong("ARG_KEY_NEXT_SEND_CODE_WAIT_TIME_MILLIS");
        return constraintLayoutB;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer == null) {
            AbstractC13042fc3.y("timer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
        SMSRetrieverBroadcastReceiver.INSTANCE.a(null);
        this._binding = null;
        this.snackBar = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        ya(Ca().n);
        this.keyboardHelper.c(Ca().n, true);
    }

    public final void jb(String message) {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        C17468n10 c17468n10 = this.snackBar;
        if (c17468n10 == null || c17468n10 == null) {
            return;
        }
        c17468n10.o(message);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) throws NumberFormatException {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        AbstractC16751lo1.c(this, j.b.RESUMED, new f(null));
        lb();
        Ta();
        ab();
        Sa(String.valueOf(this.fullPhoneNumber));
        Qa();
        Ja();
        ConstraintLayout constraintLayout = Ca().v;
        AbstractC13042fc3.h(constraintLayout, "validateRoot");
        ConstraintLayout constraintLayout2 = Ca().v;
        AbstractC13042fc3.h(constraintLayout2, "validateRoot");
        l4(constraintLayout, constraintLayout2);
    }
}
