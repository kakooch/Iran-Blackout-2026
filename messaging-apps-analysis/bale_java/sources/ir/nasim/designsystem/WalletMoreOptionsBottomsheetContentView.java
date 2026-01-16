package ir.nasim.designsystem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21375tZ;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C13932h38;
import ir.nasim.C14486i0;
import ir.nasim.C14505i18;
import ir.nasim.C17486n28;
import ir.nasim.C4100Dr4;
import ir.nasim.C4895Ha1;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.InterfaceC21596to4;
import ir.nasim.designsystem.WalletMoreOptionsBottomsheetContentView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u0013J\u0019\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u00068"}, d2 = {"Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/to4;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/appcompat/app/AppCompatActivity;", "parent", "(Landroid/content/Context;Landroidx/appcompat/app/AppCompatActivity;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "l", "()V", "r", "", "url", "p", "(Ljava/lang/String;)V", "o", "m", "n", "q", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "a", "Lir/nasim/i0;", "getAbol", "()Lir/nasim/i0;", "setAbol", "b", "Landroidx/appcompat/app/AppCompatActivity;", "Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView$a;", "c", "Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView$a;", "getCallback", "()Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView$a;", "setCallback", "(Lir/nasim/designsystem/WalletMoreOptionsBottomsheetContentView$a;)V", "callback", "Lir/nasim/n28;", "d", "Lir/nasim/n28;", "binding", "Lir/nasim/h38;", "e", "Lir/nasim/h38;", "bindingWalletPay", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WalletMoreOptionsBottomsheetContentView extends RelativeLayout implements InterfaceC16866m0, InterfaceC21596to4 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private AppCompatActivity parent;

    /* renamed from: c, reason: from kotlin metadata */
    private a callback;

    /* renamed from: d, reason: from kotlin metadata */
    private C17486n28 binding;

    /* renamed from: e, reason: from kotlin metadata */
    private C13932h38 bindingWalletPay;

    public interface a {
        void w4(String str);
    }

    public static final class b implements InterfaceC15419jZ0 {
        b() {
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C14505i18 c14505i18) {
            AbstractC13042fc3.i(c14505i18, "res");
            Toast.makeText(WalletMoreOptionsBottomsheetContentView.this.getContext(), AbstractC12217eE5.wallet_balance_refresh_toast, 1).show();
            C14486i0 abol = WalletMoreOptionsBottomsheetContentView.this.getAbol();
            if (abol != null) {
                abol.g();
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            AbstractC13042fc3.i(exc, "e");
            Toast.makeText(WalletMoreOptionsBottomsheetContentView.this.getContext(), AbstractC12217eE5.wallet_balance_refresh_failed_toast, 1).show();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMoreOptionsBottomsheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.binding = C17486n28.c(LayoutInflater.from(getContext()), this, true);
        this.bindingWalletPay = C13932h38.c(LayoutInflater.from(getContext()));
        l();
    }

    private final void l() {
        r();
        q();
    }

    private final void m() {
        if (this.parent == null) {
            return;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AppCompatActivity appCompatActivity = this.parent;
        AbstractC13042fc3.f(appCompatActivity);
        AbstractC21375tZ.c(context, appCompatActivity, null, C4895Ha1.a.f(), 4, null).show();
    }

    private final void n() {
        p(AbstractC5969Lp4.d().o2().S().e1());
    }

    private final void o() {
        if (this.parent == null) {
            return;
        }
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        AppCompatActivity appCompatActivity = this.parent;
        AbstractC13042fc3.f(appCompatActivity);
        AbstractC21375tZ.c(context, appCompatActivity, null, C4895Ha1.a.c(), 4, null).show();
    }

    private final void p(String url) {
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        if (!C4100Dr4.a(context)) {
            Toast.makeText(getContext(), AbstractC12217eE5.bank_first_toast_for_check_network_description, 0).show();
            return;
        }
        a aVar = this.callback;
        if (aVar != null) {
            aVar.w4(url);
        }
        C14486i0 c14486i0 = this.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    private final void q() {
        this.binding.o.setTypeface(C6011Lu2.k());
        this.binding.b.setTypeface(C6011Lu2.k());
        this.binding.i.setTypeface(C6011Lu2.k());
        this.binding.j.setTypeface(C6011Lu2.k());
        this.binding.n.setTypeface(C6011Lu2.k());
        this.binding.h.setTypeface(C6011Lu2.k());
    }

    private final void r() {
        setBackgroundColor(C5495Jo7.a.q());
        this.binding.m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.f28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.s(this.a, view);
            }
        });
        this.binding.o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.g28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.t(this.a, view);
            }
        });
        this.binding.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.h28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.u(this.a, view);
            }
        });
        this.binding.i.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.i28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.v(this.a, view);
            }
        });
        this.binding.j.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.j28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.w(this.a, view);
            }
        });
        this.binding.n.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.k28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.x(this.a, view);
            }
        });
        this.binding.m.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.l28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.y(this.a, view);
            }
        });
        this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletMoreOptionsBottomsheetContentView.z(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        C14486i0 c14486i0 = walletMoreOptionsBottomsheetContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.p(AbstractC5969Lp4.d().o2().S().r1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.p(AbstractC5969Lp4.d().o2().S().x4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        walletMoreOptionsBottomsheetContentView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://bale.ai/wallet/terms/")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WalletMoreOptionsBottomsheetContentView walletMoreOptionsBottomsheetContentView, View view) {
        AbstractC13042fc3.i(walletMoreOptionsBottomsheetContentView, "this$0");
        C5735Kp4.w().i().i1().a(walletMoreOptionsBottomsheetContentView.new b());
    }

    public final C14486i0 getAbol() {
        return this.abol;
    }

    public final a getCallback() {
        return this.callback;
    }

    public final void setAbol(C14486i0 c14486i0) {
        this.abol = c14486i0;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    public final void setCallback(a aVar) {
        this.callback = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMoreOptionsBottomsheetContentView(Context context, AppCompatActivity appCompatActivity) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(appCompatActivity, "parent");
        this.binding = C17486n28.c(LayoutInflater.from(getContext()), this, true);
        this.bindingWalletPay = C13932h38.c(LayoutInflater.from(getContext()));
        this.parent = appCompatActivity;
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMoreOptionsBottomsheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.binding = C17486n28.c(LayoutInflater.from(getContext()), this, true);
        this.bindingWalletPay = C13932h38.c(LayoutInflater.from(getContext()));
        l();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletMoreOptionsBottomsheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.binding = C17486n28.c(LayoutInflater.from(getContext()), this, true);
        this.bindingWalletPay = C13932h38.c(LayoutInflater.from(getContext()));
        l();
    }
}
