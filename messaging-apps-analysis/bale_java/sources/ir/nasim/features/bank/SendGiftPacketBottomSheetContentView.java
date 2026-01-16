package ir.nasim.features.bank;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.C11335cq;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C17213mb2;
import ir.nasim.C23490x06;
import ir.nasim.C23964xo6;
import ir.nasim.C5735Kp4;
import ir.nasim.C6011Lu2;
import ir.nasim.EnumC19802qy;
import ir.nasim.InterfaceC15419jZ0;
import ir.nasim.core.network.RpcTimeoutException;
import ir.nasim.features.bank.SendGiftPacketBottomSheetContentView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lir/nasim/features/bank/SendGiftPacketBottomSheetContentView;", "Lir/nasim/features/bank/GiftPacketPayBottomSheetContentViewBase;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "q", "()V", "m", "l", "k", "d", "", "a", "()Z", "", "Ljava/lang/String;", "defaultWalletId", "Z", "isRpcSuccess", "Lir/nasim/xo6;", "Lir/nasim/xo6;", "getBinding", "()Lir/nasim/xo6;", "binding", "n", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class SendGiftPacketBottomSheetContentView extends GiftPacketPayBottomSheetContentViewBase {
    public static final int o = 8;

    /* renamed from: k, reason: from kotlin metadata */
    private String defaultWalletId;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean isRpcSuccess;

    /* renamed from: m, reason: from kotlin metadata */
    private final C23964xo6 binding;

    public static final class b implements InterfaceC15419jZ0 {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView) {
            AbstractC13042fc3.i(sendGiftPacketBottomSheetContentView, "this$0");
            C14486i0 bottomSheet$nasim_release = sendGiftPacketBottomSheetContentView.getBottomSheet();
            if (bottomSheet$nasim_release != null) {
                bottomSheet$nasim_release.g();
            }
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(C23490x06 c23490x06) {
            SendGiftPacketBottomSheetContentView.this.isRpcSuccess = true;
            C14486i0 bottomSheet$nasim_release = SendGiftPacketBottomSheetContentView.this.getBottomSheet();
            if (bottomSheet$nasim_release != null) {
                bottomSheet$nasim_release.g();
            }
            C17213mb2.l("Send_Gift_Packet_result", "Send_exPeerType_result", String.valueOf(SendGiftPacketBottomSheetContentView.this.getExPeerType$nasim_release().getValue()));
        }

        @Override // ir.nasim.InterfaceC15419jZ0
        public void onError(Exception exc) throws Resources.NotFoundException {
            if (exc instanceof RpcTimeoutException) {
                SendGiftPacketBottomSheetContentView.this.getResources().getString(AbstractC12217eE5.error_connection);
                Toast.makeText(SendGiftPacketBottomSheetContentView.this.getContext(), AbstractC12217eE5.error_connection, 1).show();
                final SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView = SendGiftPacketBottomSheetContentView.this;
                AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.wo6
                    @Override // java.lang.Runnable
                    public final void run() {
                        SendGiftPacketBottomSheetContentView.b.c(sendGiftPacketBottomSheetContentView);
                    }
                }, 500L);
            } else {
                SendGiftPacketBottomSheetContentView.this.getBinding().e.setText(SendGiftPacketBottomSheetContentView.this.getResources().getText(AbstractC12217eE5.gift_packet_send_message_failed));
                SendGiftPacketBottomSheetContentView.this.getBinding().b.setVisibility(0);
            }
            SendGiftPacketBottomSheetContentView.this.getBinding().d.setVisibility(8);
            C17213mb2.l("Send_Gift_Packet_failure", "Send_exPeerType_failure", String.valueOf(SendGiftPacketBottomSheetContentView.this.getExPeerType$nasim_release().getValue()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftPacketBottomSheetContentView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        C23964xo6 c23964xo6C = C23964xo6.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c23964xo6C, "inflate(...)");
        this.binding = c23964xo6C;
        d(context);
    }

    private final void k() {
        if (!c()) {
            this.binding.d.setVisibility(8);
            this.binding.e.setText(getResources().getText(AbstractC12217eE5.gift_packet_send_message_failed));
            this.binding.b.setVisibility(0);
            return;
        }
        this.binding.b.setVisibility(8);
        this.binding.d.setVisibility(0);
        this.binding.e.setText(getResources().getText(AbstractC12217eE5.send_gift_packet_loading_message));
        C11335cq c11335cqI = C5735Kp4.w().i();
        C11458d25 peer$nasim_release = getPeer$nasim_release();
        int packetCount$nasim_release = getPacketCount();
        long totalAmount$nasim_release = getTotalAmount();
        EnumC19802qy giftGivingType$nasim_release = getGiftGivingType$nasim_release();
        String message$nasim_release = getMessage$nasim_release();
        String str = this.defaultWalletId;
        if (str == null) {
            AbstractC13042fc3.y("defaultWalletId");
            str = null;
        }
        c11335cqI.B1(peer$nasim_release, packetCount$nasim_release, totalAmount$nasim_release, giftGivingType$nasim_release, message$nasim_release, str).a(new b());
    }

    private final void l() {
        C14486i0 bottomSheet$nasim_release = getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
    }

    private final void m() {
        this.binding.e.setTypeface(C6011Lu2.i());
        this.binding.b.setVisibility(8);
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.so6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGiftPacketBottomSheetContentView.n(this.a, view);
            }
        });
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.to6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendGiftPacketBottomSheetContentView.p(this.a, view);
            }
        });
        this.binding.c.setTypeface(C6011Lu2.i());
        this.binding.f.setTypeface(C6011Lu2.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView, View view) {
        AbstractC13042fc3.i(sendGiftPacketBottomSheetContentView, "this$0");
        sendGiftPacketBottomSheetContentView.k();
        sendGiftPacketBottomSheetContentView.binding.f.setEnabled(false);
        AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.vo6
            @Override // java.lang.Runnable
            public final void run() {
                SendGiftPacketBottomSheetContentView.o(this.a);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView) {
        AbstractC13042fc3.i(sendGiftPacketBottomSheetContentView, "this$0");
        sendGiftPacketBottomSheetContentView.binding.f.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView, View view) {
        AbstractC13042fc3.i(sendGiftPacketBottomSheetContentView, "this$0");
        sendGiftPacketBottomSheetContentView.l();
    }

    private final void q() {
        this.isRpcSuccess = false;
        this.binding.b.setVisibility(8);
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.uo6
            @Override // java.lang.Runnable
            public final void run() {
                SendGiftPacketBottomSheetContentView.r(this.a);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(SendGiftPacketBottomSheetContentView sendGiftPacketBottomSheetContentView) {
        C14486i0 bottomSheet$nasim_release;
        AbstractC13042fc3.i(sendGiftPacketBottomSheetContentView, "this$0");
        if (!sendGiftPacketBottomSheetContentView.isRpcSuccess || (bottomSheet$nasim_release = sendGiftPacketBottomSheetContentView.getBottomSheet()) == null) {
            return;
        }
        bottomSheet$nasim_release.g();
    }

    @Override // ir.nasim.features.bank.GiftPacketPayBottomSheetContentViewBase, ir.nasim.InterfaceC16866m0
    public boolean a() {
        return true;
    }

    @Override // ir.nasim.features.bank.GiftPacketPayBottomSheetContentViewBase
    protected void d(Context context) {
        AbstractC13042fc3.i(context, "context");
        super.d(context);
        setView$nasim_release(this.binding.getRoot());
        m();
        q();
        k();
    }

    public final C23964xo6 getBinding() {
        return this.binding;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftPacketBottomSheetContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C23964xo6 c23964xo6C = C23964xo6.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c23964xo6C, "inflate(...)");
        this.binding = c23964xo6C;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftPacketBottomSheetContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        C23964xo6 c23964xo6C = C23964xo6.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c23964xo6C, "inflate(...)");
        this.binding = c23964xo6C;
        d(context);
    }
}
