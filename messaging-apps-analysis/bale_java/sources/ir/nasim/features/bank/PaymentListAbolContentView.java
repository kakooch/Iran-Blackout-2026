package ir.nasim.features.bank;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.BC5;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C18987pb3;
import ir.nasim.C19024pf0;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC22483vJ4;
import ir.nasim.J44;
import ir.nasim.P15;
import ir.nasim.T15;
import ir.nasim.TA5;
import ir.nasim.W15;
import ir.nasim.X15;
import ir.nasim.features.bank.PaymentListAbolContentView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0017\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u0011R\u0014\u0010!\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lir/nasim/features/bank/PaymentListAbolContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/X15;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "h", "j", "()V", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "textResource", "setHint", "(I)V", "", ParameterNames.TEXT, "(Ljava/lang/String;)V", "title", "t2", "R4", "a", "Ljava/lang/String;", "TAG", "b", "Lir/nasim/i0;", "Lir/nasim/W15;", "c", "Lir/nasim/W15;", "presenter", "Lir/nasim/J44;", "d", "Lir/nasim/J44;", "getCurrentMessage", "()Lir/nasim/J44;", "setCurrentMessage", "(Lir/nasim/J44;)V", "currentMessage", "Lir/nasim/d25;", "e", "Lir/nasim/d25;", "getCurrentPeer", "()Lir/nasim/d25;", "setCurrentPeer", "(Lir/nasim/d25;)V", "currentPeer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "hintTextView", "Landroidx/recyclerview/widget/RecyclerView;", "g", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class PaymentListAbolContentView extends RelativeLayout implements X15, InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: c, reason: from kotlin metadata */
    private W15 presenter;

    /* renamed from: d, reason: from kotlin metadata */
    private J44 currentMessage;

    /* renamed from: e, reason: from kotlin metadata */
    private C11458d25 currentPeer;

    /* renamed from: f, reason: from kotlin metadata */
    private TextView hintTextView;

    /* renamed from: g, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    public static final class a implements InterfaceC22483vJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(P15 p15) {
            AbstractC13042fc3.i(p15, "item");
            C11458d25 c11458d25R = C11458d25.r(11L);
            AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
            C18987pb3.x1(C18987pb3.a, c11458d25R, p15.w(), p15.u(), true, null, null, false, null, null, false, null, 2032, null);
            C14486i0 c14486i0 = PaymentListAbolContentView.this.abol;
            if (c14486i0 != null) {
                c14486i0.g();
            }
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(P15 p15) {
            AbstractC13042fc3.i(p15, "item");
            return false;
        }
    }

    public static final class b implements InterfaceC22483vJ4 {
        b() {
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(P15 p15) {
            AbstractC13042fc3.i(p15, "item");
            C18987pb3 c18987pb3 = C18987pb3.a;
            Integer numS = p15.s();
            AbstractC13042fc3.h(numS, "getPayerUserId(...)");
            C11458d25 c11458d25E = C11458d25.E(numS.intValue());
            AbstractC13042fc3.h(c11458d25E, "user(...)");
            C18987pb3.x1(c18987pb3, c11458d25E, null, null, false, null, null, false, null, null, false, null, 2046, null);
            C14486i0 c14486i0 = PaymentListAbolContentView.this.abol;
            if (c14486i0 != null) {
                c14486i0.g();
            }
        }

        @Override // ir.nasim.InterfaceC22483vJ4
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean v(P15 p15) {
            AbstractC13042fc3.i(p15, "item");
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentListAbolContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.TAG = "PaymentListAbolContentView";
        h(context);
    }

    private final void h(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(AbstractC12208eD5.payment_list_abol, this);
        setBackgroundColor(C5495Jo7.a.j0());
        this.presenter = new W15(this);
        ((ImageButton) findViewById(BC5.payment_list_close)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Z15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentListAbolContentView.i(this.a, view);
            }
        });
        TextView textView = (TextView) findViewById(BC5.payment_list_hint_text_view);
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(textView.getResources().getColor(TA5.c10));
        this.hintTextView = textView;
        RecyclerView recyclerView = (RecyclerView) findViewById(BC5.payment_list_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.F2(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PaymentListAbolContentView paymentListAbolContentView, View view) {
        AbstractC13042fc3.i(paymentListAbolContentView, "this$0");
        C14486i0 c14486i0 = paymentListAbolContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(PaymentListAbolContentView paymentListAbolContentView, int i) {
        AbstractC13042fc3.i(paymentListAbolContentView, "this$0");
        TextView textView = paymentListAbolContentView.hintTextView;
        if (textView == null) {
            AbstractC13042fc3.y("hintTextView");
            textView = null;
        }
        textView.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(PaymentListAbolContentView paymentListAbolContentView, String str) {
        AbstractC13042fc3.i(paymentListAbolContentView, "this$0");
        AbstractC13042fc3.i(str, "$text");
        TextView textView = paymentListAbolContentView.hintTextView;
        if (textView == null) {
            AbstractC13042fc3.y("hintTextView");
            textView = null;
        }
        textView.setText(str);
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void R4() {
        findViewById(BC5.c6).setVisibility(8);
        findViewById(BC5.progress_bar_view).setVisibility(8);
    }

    public final J44 getCurrentMessage() {
        return this.currentMessage;
    }

    public final C11458d25 getCurrentPeer() {
        return this.currentPeer;
    }

    public final void j() {
        W15 w15;
        W15 w152 = this.presenter;
        if (w152 == null) {
            AbstractC13042fc3.y("presenter");
            w15 = null;
        } else {
            w15 = w152;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        J44 j44 = this.currentMessage;
        C11458d25 c11458d25 = this.currentPeer;
        AbstractC13042fc3.f(c11458d25);
        J44 j442 = this.currentMessage;
        long jI = j442 != null ? j442.i() : 0L;
        J44 j443 = this.currentMessage;
        w15.h(context, j44, c11458d25, jI, j443 != null ? j443.h() : 0L);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            AbstractC13042fc3.y("recyclerView");
            recyclerView = null;
        }
        C11335cq c11335cqD = AbstractC5969Lp4.d();
        C11458d25 c11458d252 = this.currentPeer;
        J44 j444 = this.currentMessage;
        Long lValueOf = j444 != null ? Long.valueOf(j444.i()) : null;
        J44 j445 = this.currentMessage;
        C19024pf0 c19024pf0Q2 = c11335cqD.q2(c11458d252, lValueOf, j445 != null ? Long.valueOf(j445.h()) : null);
        AbstractC13042fc3.h(c19024pf0Q2, "getPaymentList(...)");
        recyclerView.setAdapter(new T15(c19024pf0Q2, new a(), new b()));
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    public final void setCurrentMessage(J44 j44) {
        this.currentMessage = j44;
    }

    public final void setCurrentPeer(C11458d25 c11458d25) {
        this.currentPeer = c11458d25;
    }

    public void setHint(final int textResource) {
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.a25
            @Override // java.lang.Runnable
            public final void run() {
                PaymentListAbolContentView.k(this.a, textResource);
            }
        });
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void t2(int title) {
        findViewById(BC5.c6).setVisibility(0);
        findViewById(BC5.progress_bar_view).setVisibility(0);
    }

    @Override // ir.nasim.X15
    public void setHint(final String text) {
        AbstractC13042fc3.i(text, ParameterNames.TEXT);
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Y15
            @Override // java.lang.Runnable
            public final void run() {
                PaymentListAbolContentView.l(this.a, text);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentListAbolContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "PaymentListAbolContentView";
        h(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentListAbolContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.TAG = "PaymentListAbolContentView";
        h(context);
    }
}
