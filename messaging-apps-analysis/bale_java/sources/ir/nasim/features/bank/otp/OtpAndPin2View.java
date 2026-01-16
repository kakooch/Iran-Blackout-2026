package ir.nasim.features.bank.otp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20471s40;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11335cq;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.D50;
import ir.nasim.EnumC15044iu7;
import ir.nasim.FJ4;
import ir.nasim.GJ4;
import ir.nasim.HJ4;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.JM4;
import ir.nasim.KB5;
import ir.nasim.T10;
import ir.nasim.UA2;
import ir.nasim.XY6;
import ir.nasim.core.modules.banking.entity.DuplicateTransactionException;
import ir.nasim.core.modules.banking.k;
import ir.nasim.core.modules.banking.l;
import ir.nasim.core.modules.banking.m;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.bank.otp.OtpAndPin2View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0015\u0010\nJ\u0019\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\nJ\u001f\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010,\u001a\u00020\b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u001fH\u0002¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J!\u0010>\u001a\u00020\b2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:¢\u0006\u0004\b>\u0010?J!\u0010A\u001a\u00020\b2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:¢\u0006\u0004\bA\u0010?J\u0015\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u000f¢\u0006\u0004\bC\u0010DJ\u0015\u0010G\u001a\u00020\b2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\r\u0010I\u001a\u00020\b¢\u0006\u0004\bI\u0010\nJ\r\u0010J\u001a\u00020\b¢\u0006\u0004\bJ\u0010\nJ\r\u0010K\u001a\u00020\b¢\u0006\u0004\bK\u0010\nJ\r\u0010L\u001a\u00020\b¢\u0006\u0004\bL\u0010\nJ\r\u0010M\u001a\u00020\b¢\u0006\u0004\bM\u0010\nR\u0018\u0010P\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR$\u0010@\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010bR\u0017\u0010h\u001a\u00020d8\u0006¢\u0006\f\n\u0004\b\u001d\u0010e\u001a\u0004\bf\u0010g¨\u0006i"}, d2 = {"Lir/nasim/features/bank/otp/OtpAndPin2View;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "l", "()V", "Landroid/text/SpannableStringBuilder;", "h", "()Landroid/text/SpannableStringBuilder;", DialogEntity.COLUMN_MESSAGE, "", "boldString", "g", "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;", "r", "y", "m", "Ljava/lang/Exception;", "it", "i", "(Ljava/lang/Exception;)V", "responseMessage", "", "isSuccess", "j", "(Ljava/lang/String;Z)V", "", "timeOut", TokenNames.C, "(I)V", "q", "k", "textColor", "hintColor", "w", "(II)V", "Lcom/google/android/material/textfield/TextInputLayout;", "textInputLayout", "color", "v", "(Lcom/google/android/material/textfield/TextInputLayout;I)V", "Lir/nasim/FJ4;", "onOTPClickValidationChecker", "setOnOTPClickValidationChecker", "(Lir/nasim/FJ4;)V", "Lir/nasim/GJ4;", "onOTPResponseReceiveListener", "setOnOTPResponseReceived", "(Lir/nasim/GJ4;)V", "Lir/nasim/HJ4;", "onOtpClickedSrcCardValidatorListener", "setOnOtpClickedSrcCardValidatorListener", "(Lir/nasim/HJ4;)V", "Lkotlin/Function1;", "Landroid/view/View;", "Ljava/lang/Void;", "onCloseCallback", "setOnCloseCallback", "(Lir/nasim/UA2;)V", "onGetPasscodeFromDialogClicked", "setOnGetPasscodeFromDialogClicked", "messageText", "x", "(Ljava/lang/String;)V", "Lir/nasim/D50;", "bankCardView", "setBankCardView", "(Lir/nasim/D50;)V", "u", "n", "z", "p", "o", "a", "Lir/nasim/FJ4;", "mOnOTPClickValidationChecker", "b", "Lir/nasim/GJ4;", "c", "Lir/nasim/HJ4;", "d", "Lir/nasim/UA2;", "e", "f", "Lir/nasim/D50;", "srcCardView", "Lir/nasim/s40;", "Lir/nasim/s40;", "destBankCard", "Lir/nasim/iu7;", "Lir/nasim/iu7;", "mTransactionType", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "Lir/nasim/JM4;", "Lir/nasim/JM4;", "getBinding", "()Lir/nasim/JM4;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class OtpAndPin2View extends RelativeLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private FJ4 mOnOTPClickValidationChecker;

    /* renamed from: b, reason: from kotlin metadata */
    private GJ4 onOTPResponseReceiveListener;

    /* renamed from: c, reason: from kotlin metadata */
    private HJ4 onOtpClickedSrcCardValidatorListener;

    /* renamed from: d, reason: from kotlin metadata */
    private UA2 onCloseCallback;

    /* renamed from: e, reason: from kotlin metadata */
    private UA2 onGetPasscodeFromDialogClicked;

    /* renamed from: f, reason: from kotlin metadata */
    private D50 srcCardView;

    /* renamed from: g, reason: from kotlin metadata */
    private AbstractC20471s40 destBankCard;

    /* renamed from: h, reason: from kotlin metadata */
    private EnumC15044iu7 mTransactionType;

    /* renamed from: i, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: j, reason: from kotlin metadata */
    private final JM4 binding;

    public static final class a extends CountDownTimer {
        a(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            OtpAndPin2View.this.u();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            TextView textView = OtpAndPin2View.this.getBinding().k;
            String string = OtpAndPin2View.this.getContext().getString(AbstractC12217eE5.otp_seconds);
            AbstractC13042fc3.h(string, "getString(...)");
            textView.setText(AbstractC20153rZ6.M(string, "{1}", XY6.e(String.valueOf(j / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT)), false, 4, null));
        }
    }

    public OtpAndPin2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        JM4 jm4C = JM4.c(LayoutInflater.from(context), this, true);
        AbstractC13042fc3.h(jm4C, "inflate(...)");
        this.binding = jm4C;
        setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.DM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtpAndPin2View.f(view);
            }
        });
        jm4C.f.setTypeface(C6011Lu2.i());
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.otp_button_selector);
        if (drawableF != null) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.Y());
            jm4C.k.setBackground(drawableF);
        }
        jm4C.k.setTypeface(C6011Lu2.i());
        jm4C.c.setTypeface(C6011Lu2.k());
        jm4C.h.setTextColor(C5495Jo7.a.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(OtpAndPin2View otpAndPin2View, View view) {
        AbstractC13042fc3.i(otpAndPin2View, "this$0");
        FJ4 fj4 = otpAndPin2View.mOnOTPClickValidationChecker;
        if (fj4 != null) {
            AbstractC13042fc3.f(fj4);
            if (fj4.a()) {
                otpAndPin2View.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(OtpAndPin2View otpAndPin2View, View view) {
        AbstractC13042fc3.i(otpAndPin2View, "this$0");
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = otpAndPin2View.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        SpannableStringBuilder spannableStringBuilderH = otpAndPin2View.h();
        String string = otpAndPin2View.getContext().getString(AbstractC12217eE5.otp_help_message_title);
        AbstractC13042fc3.h(string, "getString(...)");
        String string2 = otpAndPin2View.getContext().getString(AbstractC12217eE5.understand);
        AbstractC13042fc3.h(string2, "getString(...)");
        InterfaceC12737f70.c(interfaceC12737f70A, spannableStringBuilderH, string, string2, null, 2, 8, null);
    }

    private final void C(int timeOut) {
        this.binding.k.setEnabled(false);
        this.countDownTimer = new a(timeOut * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
    }

    private final SpannableStringBuilder g(SpannableStringBuilder message, String boldString) {
        int iL0 = AbstractC20762sZ6.l0(message, boldString, 0, false, 6, null);
        message.setSpan(new T10(C6011Lu2.i()), iL0, boldString.length() + iL0, 33);
        message.setSpan(new RelativeSizeSpan(1.1f), iL0, boldString.length() + iL0, 33);
        return message;
    }

    private final SpannableStringBuilder h() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(AbstractC12217eE5.otp_help_message));
        String string = getContext().getString(AbstractC12217eE5.otp_first_step);
        AbstractC13042fc3.h(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilderG = g(spannableStringBuilder, string);
        String string2 = getContext().getString(AbstractC12217eE5.otp_second_step);
        AbstractC13042fc3.h(string2, "getString(...)");
        SpannableStringBuilder spannableStringBuilderG2 = g(spannableStringBuilderG, string2);
        String string3 = getContext().getString(AbstractC12217eE5.otp_third_step);
        AbstractC13042fc3.h(string3, "getString(...)");
        return g(spannableStringBuilderG2, string3);
    }

    private final void i(Exception it) {
        m();
        if (it instanceof DuplicateTransactionException) {
            C(((DuplicateTransactionException) it).a());
        } else {
            u();
            Toast.makeText(getContext(), getContext().getString(AbstractC12217eE5.error_eccured), 0).show();
        }
    }

    private final void j(String responseMessage, boolean isSuccess) {
        GJ4 gj4;
        m();
        if (isSuccess) {
            C(AbstractC5969Lp4.d().p2());
        }
        if (responseMessage == null || (gj4 = this.onOTPResponseReceiveListener) == null) {
            return;
        }
        gj4.a(this, responseMessage);
    }

    private final void k() {
        this.binding.e.setVisibility(0);
        this.binding.e.bringToFront();
        this.binding.j.bringToFront();
    }

    private final void l() {
        this.binding.h.setVisibility(8);
    }

    private final void m() {
        this.binding.i.setVisibility(8);
        this.binding.k.setVisibility(0);
    }

    private final void q() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private final void r() {
        D50 d50 = this.srcCardView;
        if ((d50 != null ? d50.getBankCard() : null) == null) {
            HJ4 hj4 = this.onOtpClickedSrcCardValidatorListener;
            if (hj4 != null) {
                hj4.a();
                return;
            }
            return;
        }
        y();
        AbstractC20471s40 abstractC20471s40 = this.destBankCard;
        l lVar = abstractC20471s40 instanceof l ? (l) abstractC20471s40 : null;
        if (this.mTransactionType == null) {
            this.mTransactionType = EnumC15044iu7.UNSUPPORTED_VALUE;
        }
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        D50 d502 = this.srcCardView;
        AbstractC20471s40 bankCard = d502 != null ? d502.getBankCard() : null;
        AbstractC13042fc3.g(bankCard, "null cannot be cast to non-null type ir.nasim.core.modules.banking.DigitOnlyBankCard");
        c11335cqD.r1(m.k((l) bankCard, "", "", ""), lVar, this.mTransactionType, 0L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.GM4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                OtpAndPin2View.s(this.a, (ir.nasim.core.modules.banking.k) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.HM4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                OtpAndPin2View.t(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(OtpAndPin2View otpAndPin2View, k kVar) {
        AbstractC13042fc3.i(otpAndPin2View, "this$0");
        otpAndPin2View.j(kVar.b() ? kVar.c() : kVar.a(), kVar.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(OtpAndPin2View otpAndPin2View, Exception exc) {
        AbstractC13042fc3.i(otpAndPin2View, "this$0");
        otpAndPin2View.i(exc);
    }

    private final void v(TextInputLayout textInputLayout, int color) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Field declaredField = textInputLayout.getClass().getDeclaredField("mDefaultTextColor");
            declaredField.setAccessible(true);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[0]}, new int[]{color});
            declaredField.set(textInputLayout, colorStateList);
            Class<?> cls = textInputLayout.getClass();
            Class cls2 = Boolean.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("updateLabelState", cls2);
            declaredMethod.setAccessible(true);
            Boolean bool = Boolean.TRUE;
            declaredMethod.invoke(textInputLayout, bool);
            Field declaredField2 = textInputLayout.getClass().getDeclaredField("mFocusedTextColor");
            declaredField2.setAccessible(true);
            declaredField2.set(textInputLayout, colorStateList);
            Method declaredMethod2 = textInputLayout.getClass().getDeclaredMethod("updateLabelState", cls2);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(textInputLayout, bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void w(int textColor, int hintColor) {
        this.binding.d.setTextColor(textColor);
        this.binding.d.setHintTextColor(hintColor);
    }

    private final void y() {
        this.binding.k.setVisibility(4);
        this.binding.i.setVisibility(0);
    }

    public final JM4 getBinding() {
        return this.binding;
    }

    public final void n() {
        this.binding.j.setVisibility(8);
        l();
    }

    public final void o() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        w(c5495Jo7.J0(), c5495Jo7.J0());
        TextInputLayout textInputLayout = this.binding.c;
        AbstractC13042fc3.h(textInputLayout, "etCardCvv2InputLayout");
        v(textInputLayout, c5495Jo7.J0());
    }

    public final void p() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        w(c5495Jo7.N0(), c5495Jo7.K0());
        TextInputLayout textInputLayout = this.binding.c;
        AbstractC13042fc3.h(textInputLayout, "etCardCvv2InputLayout");
        v(textInputLayout, c5495Jo7.K0());
    }

    public final void setBankCardView(D50 bankCardView) {
        AbstractC13042fc3.i(bankCardView, "bankCardView");
        this.srcCardView = bankCardView;
    }

    public final void setOnCloseCallback(UA2 onCloseCallback) {
        AbstractC13042fc3.i(onCloseCallback, "onCloseCallback");
        this.onCloseCallback = onCloseCallback;
    }

    public final void setOnGetPasscodeFromDialogClicked(UA2 onGetPasscodeFromDialogClicked) {
        AbstractC13042fc3.i(onGetPasscodeFromDialogClicked, "onGetPasscodeFromDialogClicked");
        this.onGetPasscodeFromDialogClicked = onGetPasscodeFromDialogClicked;
    }

    public final void setOnOTPClickValidationChecker(FJ4 onOTPClickValidationChecker) {
        AbstractC13042fc3.i(onOTPClickValidationChecker, "onOTPClickValidationChecker");
        this.mOnOTPClickValidationChecker = onOTPClickValidationChecker;
    }

    public final void setOnOTPResponseReceived(GJ4 onOTPResponseReceiveListener) {
        AbstractC13042fc3.i(onOTPResponseReceiveListener, "onOTPResponseReceiveListener");
        this.onOTPResponseReceiveListener = onOTPResponseReceiveListener;
    }

    public final void setOnOtpClickedSrcCardValidatorListener(HJ4 onOtpClickedSrcCardValidatorListener) {
        AbstractC13042fc3.i(onOtpClickedSrcCardValidatorListener, "onOtpClickedSrcCardValidatorListener");
        this.onOtpClickedSrcCardValidatorListener = onOtpClickedSrcCardValidatorListener;
    }

    public final void u() {
        m();
        this.binding.k.setEnabled(true);
        this.binding.k.setText(getContext().getString(AbstractC12217eE5.request_otp));
        q();
    }

    public final void x(String messageText) {
        AbstractC13042fc3.i(messageText, "messageText");
        TextView textView = this.binding.h;
        textView.setTypeface(C6011Lu2.k());
        textView.setVisibility(0);
        textView.setText(messageText);
    }

    public final void z() {
        k();
        this.binding.k.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.EM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtpAndPin2View.A(this.a, view);
            }
        });
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OtpAndPin2View.B(this.a, view);
            }
        });
    }
}
