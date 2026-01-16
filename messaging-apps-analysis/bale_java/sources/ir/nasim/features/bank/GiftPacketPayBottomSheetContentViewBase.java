package ir.nasim.features.bank;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C22042ua0;
import ir.nasim.C23278wf0;
import ir.nasim.EnumC19739qr4;
import ir.nasim.EnumC19802qy;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b7\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002BI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0013\u0010\u0018B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u001aJ\u0019\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b \u0010\u0015J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010#R\"\u0010+\u001a\u00020%8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b$\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00103\u001a\u00020,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00108\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u001fR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b \u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\b\u001a\u00020\u00078\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010b\u001a\u00020\u00118\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a¨\u0006c"}, d2 = {"Lir/nasim/features/bank/GiftPacketPayBottomSheetContentViewBase;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Landroid/content/Context;", "context", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "", "totalAmount", "", "packetCount", "Lir/nasim/qy;", "giftGivingType", "", DialogEntity.COLUMN_MESSAGE, "Lir/nasim/ua0;", "activity", "<init>", "(Landroid/content/Context;Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;JILir/nasim/qy;Ljava/lang/String;Lir/nasim/ua0;)V", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/i0;", "abol", "Lir/nasim/rB7;", "setAbolInstance", "(Lir/nasim/i0;)V", "d", "", "c", "()Z", "a", "Landroid/view/View;", "Landroid/view/View;", "getView$nasim_release", "()Landroid/view/View;", "setView$nasim_release", "(Landroid/view/View;)V", "view", "Lir/nasim/wf0;", "b", "Lir/nasim/wf0;", "getBinder$nasim_release", "()Lir/nasim/wf0;", "setBinder$nasim_release", "(Lir/nasim/wf0;)V", "binder", "Lir/nasim/i0;", "getBottomSheet$nasim_release", "()Lir/nasim/i0;", "setBottomSheet$nasim_release", "bottomSheet", "Lir/nasim/d25;", "getPeer$nasim_release", "()Lir/nasim/d25;", "setPeer$nasim_release", "(Lir/nasim/d25;)V", "e", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "getExPeerType$nasim_release", "()Lir/nasim/core/modules/profile/entity/ExPeerType;", "setExPeerType$nasim_release", "(Lir/nasim/core/modules/profile/entity/ExPeerType;)V", "f", "J", "getTotalAmount$nasim_release", "()J", "setTotalAmount$nasim_release", "(J)V", "g", TokenNames.I, "getPacketCount$nasim_release", "()I", "setPacketCount$nasim_release", "(I)V", "h", "Lir/nasim/qy;", "getGiftGivingType$nasim_release", "()Lir/nasim/qy;", "setGiftGivingType$nasim_release", "(Lir/nasim/qy;)V", "i", "Ljava/lang/String;", "getMessage$nasim_release", "()Ljava/lang/String;", "setMessage$nasim_release", "(Ljava/lang/String;)V", "j", "Lir/nasim/ua0;", "getFragment$nasim_release", "()Lir/nasim/ua0;", "setFragment$nasim_release", "(Lir/nasim/ua0;)V", "fragment", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public class GiftPacketPayBottomSheetContentViewBase extends RelativeLayout implements InterfaceC16866m0 {

    /* renamed from: a, reason: from kotlin metadata */
    public View view;

    /* renamed from: b, reason: from kotlin metadata */
    private C23278wf0 binder;

    /* renamed from: c, reason: from kotlin metadata */
    private C14486i0 bottomSheet;

    /* renamed from: d, reason: from kotlin metadata */
    public C11458d25 peer;

    /* renamed from: e, reason: from kotlin metadata */
    public ExPeerType exPeerType;

    /* renamed from: f, reason: from kotlin metadata */
    private long totalAmount;

    /* renamed from: g, reason: from kotlin metadata */
    private int packetCount;

    /* renamed from: h, reason: from kotlin metadata */
    public EnumC19802qy giftGivingType;

    /* renamed from: i, reason: from kotlin metadata */
    public String message;

    /* renamed from: j, reason: from kotlin metadata */
    public C22042ua0 fragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPacketPayBottomSheetContentViewBase(Context context, C11458d25 c11458d25, ExPeerType exPeerType, long j, int i, EnumC19802qy enumC19802qy, String str, C22042ua0 c22042ua0) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(enumC19802qy, "giftGivingType");
        AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(c22042ua0, "activity");
        this.binder = new C23278wf0();
        setPeer$nasim_release(c11458d25);
        setExPeerType$nasim_release(exPeerType);
        this.totalAmount = j;
        this.packetCount = i;
        setGiftGivingType$nasim_release(enumC19802qy);
        setMessage$nasim_release(str);
        setFragment$nasim_release(c22042ua0);
    }

    @Override // ir.nasim.InterfaceC16866m0
    public boolean a() {
        this.binder.C8();
        return false;
    }

    public final boolean c() {
        EnumC19739qr4 enumC19739qr4C2 = AbstractC5969Lp4.d().c2();
        if (enumC19739qr4C2 == null || enumC19739qr4C2 != EnumC19739qr4.NO_CONNECTION) {
            return true;
        }
        Toast.makeText(getContext(), AbstractC12217eE5.error_connection_msg, 1).show();
        return false;
    }

    protected void d(Context context) {
        AbstractC13042fc3.i(context, "context");
    }

    /* renamed from: getBinder$nasim_release, reason: from getter */
    public final C23278wf0 getBinder() {
        return this.binder;
    }

    /* renamed from: getBottomSheet$nasim_release, reason: from getter */
    public final C14486i0 getBottomSheet() {
        return this.bottomSheet;
    }

    public final ExPeerType getExPeerType$nasim_release() {
        ExPeerType exPeerType = this.exPeerType;
        if (exPeerType != null) {
            return exPeerType;
        }
        AbstractC13042fc3.y(DialogEntity.COLUMN_EX_PEER_TYPE);
        return null;
    }

    public final C22042ua0 getFragment$nasim_release() {
        C22042ua0 c22042ua0 = this.fragment;
        if (c22042ua0 != null) {
            return c22042ua0;
        }
        AbstractC13042fc3.y("fragment");
        return null;
    }

    public final EnumC19802qy getGiftGivingType$nasim_release() {
        EnumC19802qy enumC19802qy = this.giftGivingType;
        if (enumC19802qy != null) {
            return enumC19802qy;
        }
        AbstractC13042fc3.y("giftGivingType");
        return null;
    }

    public final String getMessage$nasim_release() {
        String str = this.message;
        if (str != null) {
            return str;
        }
        AbstractC13042fc3.y(DialogEntity.COLUMN_MESSAGE);
        return null;
    }

    /* renamed from: getPacketCount$nasim_release, reason: from getter */
    public final int getPacketCount() {
        return this.packetCount;
    }

    public final C11458d25 getPeer$nasim_release() {
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 != null) {
            return c11458d25;
        }
        AbstractC13042fc3.y("peer");
        return null;
    }

    /* renamed from: getTotalAmount$nasim_release, reason: from getter */
    public final long getTotalAmount() {
        return this.totalAmount;
    }

    public final View getView$nasim_release() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        AbstractC13042fc3.y("view");
        return null;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.bottomSheet = abol;
    }

    public final void setBinder$nasim_release(C23278wf0 c23278wf0) {
        AbstractC13042fc3.i(c23278wf0, "<set-?>");
        this.binder = c23278wf0;
    }

    public final void setBottomSheet$nasim_release(C14486i0 c14486i0) {
        this.bottomSheet = c14486i0;
    }

    public final void setExPeerType$nasim_release(ExPeerType exPeerType) {
        AbstractC13042fc3.i(exPeerType, "<set-?>");
        this.exPeerType = exPeerType;
    }

    public final void setFragment$nasim_release(C22042ua0 c22042ua0) {
        AbstractC13042fc3.i(c22042ua0, "<set-?>");
        this.fragment = c22042ua0;
    }

    public final void setGiftGivingType$nasim_release(EnumC19802qy enumC19802qy) {
        AbstractC13042fc3.i(enumC19802qy, "<set-?>");
        this.giftGivingType = enumC19802qy;
    }

    public final void setMessage$nasim_release(String str) {
        AbstractC13042fc3.i(str, "<set-?>");
        this.message = str;
    }

    public final void setPacketCount$nasim_release(int i) {
        this.packetCount = i;
    }

    public final void setPeer$nasim_release(C11458d25 c11458d25) {
        AbstractC13042fc3.i(c11458d25, "<set-?>");
        this.peer = c11458d25;
    }

    public final void setTotalAmount$nasim_release(long j) {
        this.totalAmount = j;
    }

    public final void setView$nasim_release(View view) {
        AbstractC13042fc3.i(view, "<set-?>");
        this.view = view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPacketPayBottomSheetContentViewBase(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.binder = new C23278wf0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPacketPayBottomSheetContentViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.binder = new C23278wf0();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftPacketPayBottomSheetContentViewBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.binder = new C23278wf0();
    }
}
