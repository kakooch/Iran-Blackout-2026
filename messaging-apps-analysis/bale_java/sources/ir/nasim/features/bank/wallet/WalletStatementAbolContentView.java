package ir.nasim.features.bank.wallet;

import ai.bale.proto.WalletOuterClass$ResponseGetWalletInvoice;
import ai.bale.proto.WalletStruct$WalletInvoice;
import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10976cX0;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.BC5;
import ir.nasim.C14486i0;
import ir.nasim.C14593iA1;
import ir.nasim.C19014pe0;
import ir.nasim.C19985rH0;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.H38;
import ir.nasim.I38;
import ir.nasim.InterfaceC12737f70;
import ir.nasim.InterfaceC13373g70;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.features.bank.wallet.WalletStatementAbolContentView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u001d\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lir/nasim/features/bank/wallet/WalletStatementAbolContentView;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/I38;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "k", "m", "()V", "Lir/nasim/i0;", "abol", "setAbolInstance", "(Lir/nasim/i0;)V", "title", "t2", "(I)V", "R4", "", "Lir/nasim/pe0;", "list", "n", "(Ljava/util/List;)V", "a", "Lir/nasim/i0;", "Lir/nasim/H38;", "b", "Lir/nasim/H38;", "presenter", "Landroid/view/View;", "c", "Landroid/view/View;", "shadow", "d", TokenNames.I, "lastPage", "", "e", "Z", "loading", "f", "reachedEnd", "g", "Ljava/util/List;", "billInfos", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class WalletStatementAbolContentView extends RelativeLayout implements InterfaceC16866m0, I38 {

    /* renamed from: a, reason: from kotlin metadata */
    private C14486i0 abol;

    /* renamed from: b, reason: from kotlin metadata */
    private H38 presenter;

    /* renamed from: c, reason: from kotlin metadata */
    private View shadow;

    /* renamed from: d, reason: from kotlin metadata */
    private int lastPage;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean loading;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean reachedEnd;

    /* renamed from: g, reason: from kotlin metadata */
    private List billInfos;

    public static final class a implements InterfaceC15419jZ0 {
        final /* synthetic */ InterfaceC12737f70 b;

        a(InterfaceC12737f70 interfaceC12737f70) {
            this.b = interfaceC12737f70;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(WalletOuterClass$ResponseGetWalletInvoice walletOuterClass$ResponseGetWalletInvoice) {
            WalletStatementAbolContentView.this.R4();
            AbstractC13042fc3.f(walletOuterClass$ResponseGetWalletInvoice);
            List<WalletStruct$WalletInvoice> invoicesList = walletOuterClass$ResponseGetWalletInvoice.getInvoicesList();
            AbstractC13042fc3.h(invoicesList, "getInvoicesList(...)");
            List<WalletStruct$WalletInvoice> list = invoicesList;
            WalletStatementAbolContentView walletStatementAbolContentView = WalletStatementAbolContentView.this;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (WalletStruct$WalletInvoice walletStruct$WalletInvoice : list) {
                Context context = walletStatementAbolContentView.getContext();
                int i = AbstractC12217eE5.formatDateAtTime;
                Context context2 = walletStatementAbolContentView.getContext();
                AbstractC13042fc3.h(context2, "getContext(...)");
                arrayList.add(new C19014pe0(walletStruct$WalletInvoice.getAmount() > 0 ? "+" : "-", String.valueOf(walletStruct$WalletInvoice.getAmount()), context.getString(i, C14593iA1.h(context2, walletStruct$WalletInvoice.getDateTime(), false, 4, null), C14593iA1.A(walletStruct$WalletInvoice.getDateTime())), walletStruct$WalletInvoice.getDescription().getValue(), false));
            }
            WalletStatementAbolContentView walletStatementAbolContentView2 = WalletStatementAbolContentView.this;
            walletStatementAbolContentView2.billInfos = AbstractC15401jX0.R0(walletStatementAbolContentView2.billInfos, arrayList);
            WalletStatementAbolContentView walletStatementAbolContentView3 = WalletStatementAbolContentView.this;
            walletStatementAbolContentView3.n(walletStatementAbolContentView3.billInfos);
            if (arrayList.isEmpty()) {
                WalletStatementAbolContentView.this.reachedEnd = true;
            }
            WalletStatementAbolContentView.this.loading = false;
            WalletStatementAbolContentView.this.lastPage++;
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) {
            WalletStatementAbolContentView.this.R4();
            WalletStatementAbolContentView.this.loading = false;
            this.b.e(AbstractC12217eE5.loading_wallet_transactions_list_failed_description, AbstractC12217eE5.loading_wallet_transactions_list_failed_title, null);
        }
    }

    public static final class b extends RecyclerView.t {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.a(recyclerView, i);
            if (recyclerView.canScrollVertically(1)) {
                return;
            }
            WalletStatementAbolContentView.this.m();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletStatementAbolContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.billInfos = AbstractC10360bX0.m();
        k(context);
    }

    private final void k(Context context) {
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(AbstractC12208eD5.wallet_statement_result_layout, this);
        setBackgroundColor(C5495Jo7.a.j0());
        this.presenter = new H38(this);
        ((TextView) findViewById(BC5.result_wallet_statement_close)).setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.J38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletStatementAbolContentView.l(this.a, view);
            }
        });
        ((TextView) findViewById(BC5.result_wallet_statement_title)).setTypeface(C6011Lu2.i());
        this.shadow = findViewById(BC5.c6);
        t2(0);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(WalletStatementAbolContentView walletStatementAbolContentView, View view) {
        AbstractC13042fc3.i(walletStatementAbolContentView, "this$0");
        C14486i0 c14486i0 = walletStatementAbolContentView.abol;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void R4() {
        findViewById(BC5.c6).setVisibility(8);
        findViewById(BC5.progress_bar_view).setVisibility(8);
    }

    public final void m() {
        if (this.loading || this.reachedEnd) {
            return;
        }
        InterfaceC13373g70.a aVar = InterfaceC13373g70.a;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        InterfaceC12737f70 interfaceC12737f70A = aVar.a(context);
        String str = (String) C5735Kp4.w().i().Y().Y().B().b();
        t2(0);
        this.loading = true;
        H38 h38 = this.presenter;
        if (h38 == null) {
            AbstractC13042fc3.y("presenter");
            h38 = null;
        }
        h38.i(str, this.lastPage).a(new a(interfaceC12737f70A));
    }

    public void n(List list) {
        AbstractC13042fc3.i(list, "list");
        RecyclerView recyclerView = (RecyclerView) findViewById(BC5.result_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addOnScrollListener(new b());
        recyclerView.setAdapter(new C19985rH0(list));
    }

    public void setAbolInstance(C14486i0 abol) {
        this.abol = abol;
    }

    @Override // ir.nasim.InterfaceC4411Fa0
    public void t2(int title) {
        findViewById(BC5.c6).setVisibility(0);
        findViewById(BC5.progress_bar_view).setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletStatementAbolContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.billInfos = AbstractC10360bX0.m();
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletStatementAbolContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.billInfos = AbstractC10360bX0.m();
        k(context);
    }
}
