package ir.nasim.features.bank;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C15490jg2;
import ir.nasim.C18987pb3;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C5358Iz5;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7792Tf2;
import ir.nasim.EnumC8374Vr6;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC16081kg2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.KB5;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.XY6;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.bank.FastChargeBottomSheetContentView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010'J%\u0010*\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b,\u0010!J\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000bH\u0002¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u00020\u000e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001205H\u0002¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0(H\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010;\u001a\u00020\u000e2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001205H\u0016¢\u0006\u0004\b;\u00108J\u000f\u0010<\u001a\u00020\u000eH\u0016¢\u0006\u0004\b<\u00101J\u0017\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001cH\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u000eH\u0016¢\u0006\u0004\b@\u00101J\u0017\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u001cH\u0016¢\u0006\u0004\bB\u0010?J\u0019\u0010E\u001a\u00020\u000e2\b\u0010D\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bE\u0010FR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0017\u0010T\u001a\u00020O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lir/nasim/features/bank/FastChargeBottomSheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/kg2;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "A", "Landroid/view/LayoutInflater;", "inflater", "Lir/nasim/Tf2;", "fastCharge", "o", "(Landroid/view/LayoutInflater;Lir/nasim/Tf2;)V", "Landroid/view/View;", "view", "Lir/nasim/Vr6;", "operator", "w", "(Landroid/view/View;Lir/nasim/Vr6;)V", "", "phoneNumber", "x", "(Landroid/view/View;Ljava/lang/String;)V", "y", "(Landroid/view/View;)V", "", "price", "p", "(Landroid/view/View;J)V", "r", "(Landroid/view/View;Lir/nasim/Tf2;)V", "Lkotlin/Function0;", "onAcceptClicked", "G", "(Lir/nasim/Tf2;Lir/nasim/SA2;)V", "u", "Lir/nasim/d25;", "getChargePeer", "()Lir/nasim/d25;", "z", "()V", "size", TokenNames.M, "(I)V", "", "recentCharges", TokenNames.E, "(Ljava/util/List;)V", "J", "(Lir/nasim/SA2;)V", "G4", "I3", DialogEntity.COLUMN_MESSAGE, "Q3", "(Ljava/lang/String;)V", "R0", "url", "m2", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "a", "Lir/nasim/i0;", "b", "Landroid/view/LayoutInflater;", "Lir/nasim/jg2;", "c", "Lir/nasim/jg2;", "presenter", "Lir/nasim/Iz5;", "d", "Lir/nasim/Iz5;", "getBinding", "()Lir/nasim/Iz5;", "binding", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class FastChargeBottomSheetContentView extends RelativeLayout implements InterfaceC16866m0, InterfaceC16081kg2 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: c, reason: from kotlin metadata */
    private final C15490jg2 presenter;

    /* renamed from: d, reason: from kotlin metadata */
    private final C5358Iz5 binding;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC8374Vr6.values().length];
            try {
                iArr[EnumC8374Vr6.IRANCELL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC8374Vr6.RIGHTEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC8374Vr6.MCI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastChargeBottomSheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.presenter = new C15490jg2(this);
        C5358Iz5 c5358Iz5C = C5358Iz5.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c5358Iz5C, "inflate(...)");
        this.binding = c5358Iz5C;
        A(context);
    }

    private final void A(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.inflater = (LayoutInflater) systemService;
        this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Uf2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastChargeBottomSheetContentView.B(this.a, view);
            }
        });
        this.binding.m.setTypeface(C6011Lu2.i());
        this.binding.l.setTypeface(C6011Lu2.k());
        C5358Iz5 c5358Iz5 = this.binding;
        ConstraintLayout constraintLayout = c5358Iz5.h;
        c5358Iz5.i.setTypeface(C6011Lu2.i());
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Wf2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FastChargeBottomSheetContentView.C(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, View view) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, View view) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
        C18987pb3.x1(C18987pb3.a, fastChargeBottomSheetContentView.getChargePeer(), null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, String str) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(str, "$url");
        fastChargeBottomSheetContentView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        return C19938rB7.a;
    }

    private final void E(List recentCharges) {
        Iterator it = recentCharges.iterator();
        while (it.hasNext()) {
            C7792Tf2 c7792Tf2 = (C7792Tf2) it.next();
            LayoutInflater layoutInflater = this.inflater;
            if (layoutInflater == null) {
                AbstractC13042fc3.y("inflater");
                layoutInflater = null;
            }
            o(layoutInflater, c7792Tf2);
        }
    }

    private final void G(C7792Tf2 fastCharge, final SA2 onAcceptClicked) {
        String strM;
        a.C0011a c0011a = new a.C0011a(getContext());
        if (fastCharge.d() != null) {
            String string = c0011a.getContext().getString(AbstractC12217eE5.fast_charge_sure_message);
            AbstractC13042fc3.h(string, "getString(...)");
            String strM2 = AbstractC20153rZ6.M(string, "{0}", XY6.e(XY6.c(String.valueOf(fastCharge.a()), (char) 0, 2, null)), false, 4, null);
            String strJ = EnumC8374Vr6.j(fastCharge.c(), c0011a.getContext());
            AbstractC13042fc3.h(strJ, "getPersianName(...)");
            strM = AbstractC20153rZ6.M(AbstractC20153rZ6.M(strM2, "{1}", strJ, false, 4, null), "{2}", XY6.e(fastCharge.d()), false, 4, null);
        } else {
            String string2 = c0011a.getContext().getString(AbstractC12217eE5.fast_code_charge_sure_message);
            AbstractC13042fc3.h(string2, "getString(...)");
            String strM3 = AbstractC20153rZ6.M(string2, "{0}", XY6.e(XY6.c(String.valueOf(fastCharge.a()), (char) 0, 2, null)), false, 4, null);
            String strJ2 = EnumC8374Vr6.j(fastCharge.c(), c0011a.getContext());
            AbstractC13042fc3.h(strJ2, "getPersianName(...)");
            strM = AbstractC20153rZ6.M(strM3, "{1}", strJ2, false, 4, null);
        }
        c0011a.f(strM);
        c0011a.setTitle(c0011a.getContext().getString(AbstractC12217eE5.direct_debit_title));
        c0011a.i(c0011a.getContext().getString(AbstractC12217eE5.bank_pay), new DialogInterface.OnClickListener() { // from class: ir.nasim.bg2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FastChargeBottomSheetContentView.I(onAcceptClicked, dialogInterface, i);
            }
        });
        c0011a.g(c0011a.getContext().getString(AbstractC12217eE5.reject_dialog_button), new DialogInterface.OnClickListener() { // from class: ir.nasim.cg2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FastChargeBottomSheetContentView.H(this.a, dialogInterface, i);
            }
        });
        androidx.appcompat.app.a aVarK = c0011a.k();
        aVarK.i(-2).setTextColor(AbstractC4043Dl1.c(aVarK.getContext(), TA5.c9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(SA2 sa2, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(sa2, "$onAcceptClicked");
        sa2.invoke();
    }

    private final void J(final SA2 onAcceptClicked) {
        a.C0011a c0011a = new a.C0011a(getContext());
        c0011a.f(c0011a.getContext().getString(AbstractC12217eE5.fast_charge_first_login_message));
        c0011a.setTitle(c0011a.getContext().getString(AbstractC12217eE5.fast_charge_first_login_title));
        c0011a.i(c0011a.getContext().getString(AbstractC12217eE5.fast_charge_request_permission), new DialogInterface.OnClickListener() { // from class: ir.nasim.eg2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FastChargeBottomSheetContentView.K(onAcceptClicked, dialogInterface, i);
            }
        });
        c0011a.g(c0011a.getContext().getString(AbstractC12217eE5.reject_dialog_button), new DialogInterface.OnClickListener() { // from class: ir.nasim.Vf2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                FastChargeBottomSheetContentView.L(this.a, dialogInterface, i);
            }
        });
        androidx.appcompat.app.a aVarK = c0011a.k();
        aVarK.i(-2).setTextColor(AbstractC4043Dl1.c(aVarK.getContext(), TA5.c9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(SA2 sa2, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(sa2, "$onAcceptClicked");
        sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, DialogInterface dialogInterface, int i) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void M(int size) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(C22078ud6.a(234.0f), size * C22078ud6.a(38.0f));
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.start();
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator(1.3f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.nasim.Xf2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FastChargeBottomSheetContentView.N(this.a, valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, ValueAnimator valueAnimator) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(valueAnimator, "it");
        LinearLayout linearLayout = fastChargeBottomSheetContentView.binding.b;
        Object animatedValue = valueAnimator.getAnimatedValue();
        AbstractC13042fc3.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        linearLayout.setMinimumHeight(((Integer) animatedValue).intValue());
    }

    private final C11458d25 getChargePeer() {
        C11458d25 c11458d25R = C11458d25.r(41L);
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        return c11458d25R;
    }

    private final void o(LayoutInflater inflater, C7792Tf2 fastCharge) {
        View viewInflate = inflater.inflate(AbstractC12208eD5.fast_charge_item_layout, (ViewGroup) this.binding.b, false);
        AbstractC13042fc3.f(viewInflate);
        EnumC8374Vr6 enumC8374Vr6C = fastCharge.c();
        AbstractC13042fc3.h(enumC8374Vr6C, "getOperator(...)");
        w(viewInflate, enumC8374Vr6C);
        x(viewInflate, fastCharge.d());
        y(viewInflate);
        p(viewInflate, fastCharge.a());
        r(viewInflate, fastCharge);
        u(viewInflate);
        ((TextView) viewInflate.findViewById(BC5.delete_recent_charge)).setVisibility(8);
        this.binding.b.addView(viewInflate);
    }

    private final void p(View view, long price) {
        TextView textView = (TextView) view.findViewById(BC5.amount);
        textView.setTypeface(C6011Lu2.i());
        textView.setText(XY6.e(XY6.c(String.valueOf(price), (char) 0, 2, null)));
    }

    private final void r(View view, final C7792Tf2 fastCharge) {
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Yf2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FastChargeBottomSheetContentView.s(this.a, fastCharge, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final FastChargeBottomSheetContentView fastChargeBottomSheetContentView, final C7792Tf2 c7792Tf2, View view) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(c7792Tf2, "$fastCharge");
        if (fastChargeBottomSheetContentView.presenter.o()) {
            fastChargeBottomSheetContentView.G(c7792Tf2, new SA2() { // from class: ir.nasim.ag2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return FastChargeBottomSheetContentView.t(this.a, c7792Tf2);
                }
            });
            return;
        }
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
        C5735Kp4.w().k().S8(fastChargeBottomSheetContentView.presenter.l(c7792Tf2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(FastChargeBottomSheetContentView fastChargeBottomSheetContentView, C7792Tf2 c7792Tf2) {
        AbstractC13042fc3.i(fastChargeBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(c7792Tf2, "$fastCharge");
        C14486i0 c14486i0 = fastChargeBottomSheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
        C5735Kp4.w().k().S8(fastChargeBottomSheetContentView.presenter.l(c7792Tf2));
        return C19938rB7.a;
    }

    private final void u(final View view) {
        ((TextView) view.findViewById(BC5.delete_recent_charge)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Zf2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FastChargeBottomSheetContentView.v(view, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View view, View view2) {
        AbstractC13042fc3.i(view, "$view");
        ViewParent parent = view.getParent();
        LinearLayout linearLayout = parent instanceof LinearLayout ? (LinearLayout) parent : null;
        if (linearLayout != null) {
            linearLayout.removeView(view);
        }
    }

    private final void w(View view, EnumC8374Vr6 operator) {
        ImageView imageView = (ImageView) view.findViewById(BC5.operator_icon);
        int i = a.a[operator.ordinal()];
        imageView.setImageResource(i != 1 ? i != 2 ? i != 3 ? 0 : KB5.fast_charge_mci_label : KB5.rightel_quick_charge_label : KB5.fast_charge_irancel_label);
    }

    private final void x(View view, String phoneNumber) {
        if (phoneNumber != null) {
            TextView textView = (TextView) view.findViewById(BC5.phone_number_text_view);
            textView.setTypeface(C6011Lu2.k());
            textView.setText(XY6.e(phoneNumber));
        }
    }

    private final void y(View view) {
        ((TextView) view.findViewById(BC5.rial)).setTypeface(C6011Lu2.k());
    }

    private final void z() {
        this.binding.j.setVisibility(8);
    }

    @Override // ir.nasim.InterfaceC16081kg2
    public void G4(List recentCharges) {
        AbstractC13042fc3.i(recentCharges, "recentCharges");
        z();
        M(recentCharges.size());
        E(recentCharges);
    }

    @Override // ir.nasim.InterfaceC16081kg2
    public void I3() {
        z();
        M(0);
        this.binding.l.setText(getContext().getString(AbstractC12217eE5.fast_charge_not_used_yet_message));
    }

    @Override // ir.nasim.InterfaceC16081kg2
    public void Q3(String message) throws Resources.NotFoundException {
        AbstractC13042fc3.i(message, DialogEntity.COLUMN_MESSAGE);
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        String string = getResources().getString(AbstractC12217eE5.bank_operation_failed);
        AbstractC13042fc3.h(string, "getString(...)");
        InterfaceC12737f70.l(interfaceC12737f70A, message, string, null, 4, null);
    }

    @Override // ir.nasim.InterfaceC16081kg2
    public void R0() {
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70.k(aVar.a(context), AbstractC12217eE5.bank_operation_success_description, AbstractC12217eE5.bank_operation_succeed, null, 4, null);
    }

    public final C5358Iz5 getBinding() {
        return this.binding;
    }

    @Override // ir.nasim.InterfaceC16081kg2
    public void m2(final String url) {
        AbstractC13042fc3.i(url, "url");
        J(new SA2() { // from class: ir.nasim.dg2
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return FastChargeBottomSheetContentView.D(this.a, url);
            }
        });
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastChargeBottomSheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.presenter = new C15490jg2(this);
        C5358Iz5 c5358Iz5C = C5358Iz5.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c5358Iz5C, "inflate(...)");
        this.binding = c5358Iz5C;
        A(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastChargeBottomSheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.presenter = new C15490jg2(this);
        C5358Iz5 c5358Iz5C = C5358Iz5.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c5358Iz5C, "inflate(...)");
        this.binding = c5358Iz5C;
        A(context);
    }
}
