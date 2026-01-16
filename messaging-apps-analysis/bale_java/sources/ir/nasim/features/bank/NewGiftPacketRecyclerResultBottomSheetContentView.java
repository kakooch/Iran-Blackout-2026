package ir.nasim.features.bank;

import ai.bale.proto.Giftpacket$ResponseOpenGiftPacket;
import ai.bale.proto.GiftpacketStruct$GiftReceiver;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13554gQ7;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC23658xI2;
import ir.nasim.AbstractC5969Lp4;
import ir.nasim.C11458d25;
import ir.nasim.C12366eV1;
import ir.nasim.C12889fL5;
import ir.nasim.C14486i0;
import ir.nasim.C17213mb2;
import ir.nasim.C19938rB7;
import ir.nasim.C20644sM5;
import ir.nasim.C21231tK7;
import ir.nasim.C22042ua0;
import ir.nasim.C22472vI2;
import ir.nasim.C24398yZ;
import ir.nasim.C5495Jo7;
import ir.nasim.C5735Kp4;
import ir.nasim.C6004Lt4;
import ir.nasim.C6011Lu2;
import ir.nasim.C7183Qq;
import ir.nasim.C8624Wt4;
import ir.nasim.DialogC9423Zw1;
import ir.nasim.ED1;
import ir.nasim.EnumC18608ow5;
import ir.nasim.EnumC19802qy;
import ir.nasim.EnumC22278uy;
import ir.nasim.EnumC23107wM5;
import ir.nasim.F92;
import ir.nasim.G92;
import ir.nasim.II2;
import ir.nasim.InterfaceC14756iQ7;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.KB5;
import ir.nasim.P17;
import ir.nasim.SA2;
import ir.nasim.XY6;
import ir.nasim.core.modules.profile.entity.Avatar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.core.network.RpcTimeoutException;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u009b\u00012\u00020\u0001:\u0003P\u009c\u0001Ba\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\u001cJ\u000f\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\u0013H\u0002¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b$\u0010\u001aJ\u000f\u0010%\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020\u0018H\u0002¢\u0006\u0004\b&\u0010\u001aJ\u000f\u0010'\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010\u001aJ\u000f\u0010(\u001a\u00020\u0018H\u0002¢\u0006\u0004\b(\u0010\u001aJ\u0017\u0010*\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0018H\u0002¢\u0006\u0004\b,\u0010\u001aJ\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010.J7\u00102\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b2\u00103J7\u00104\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u000f2\u0006\u00101\u001a\u0002002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00103J\u000f\u00105\u001a\u00020\u0018H\u0002¢\u0006\u0004\b5\u0010\u001aJ\u000f\u00106\u001a\u00020\u0018H\u0002¢\u0006\u0004\b6\u0010\u001aJ\u000f\u00107\u001a\u00020\u0018H\u0002¢\u0006\u0004\b7\u0010\u001aJ\u0017\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0018H\u0002¢\u0006\u0004\b;\u0010\u001aJ\u0017\u0010<\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b<\u0010:J\u0017\u0010=\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0004H\u0002¢\u0006\u0004\b=\u0010:J\u000f\u0010>\u001a\u00020\u0004H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0018H\u0002¢\u0006\u0004\b@\u0010\u001aJ\u000f\u0010A\u001a\u00020\u0018H\u0002¢\u0006\u0004\bA\u0010\u001aJ\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010.J\u000f\u0010C\u001a\u00020\u0004H\u0002¢\u0006\u0004\bC\u0010?J\u000f\u0010D\u001a\u00020\u0013H\u0002¢\u0006\u0004\bD\u0010\u001cJ\u000f\u0010E\u001a\u00020\u0018H\u0002¢\u0006\u0004\bE\u0010\u001aJ\u000f\u0010F\u001a\u00020\u0018H\u0002¢\u0006\u0004\bF\u0010\u001aJ\u000f\u0010G\u001a\u00020\u000fH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0018H\u0002¢\u0006\u0004\bI\u0010\u001aJ\u000f\u0010J\u001a\u00020\u0018H\u0002¢\u0006\u0004\bJ\u0010\u001aJ\u000f\u0010K\u001a\u00020\u0018H\u0002¢\u0006\u0004\bK\u0010\u001aJ\u0017\u0010M\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0004H\u0002¢\u0006\u0004\bM\u0010:J\u0017\u0010N\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0013H\u0016¢\u0006\u0004\bP\u0010\u001cJ\u000f\u0010Q\u001a\u00020\u0018H\u0014¢\u0006\u0004\bQ\u0010\u001aR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010WR\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020g0f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010hR\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010KR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010KR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010jR\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010jR\u0018\u0010m\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010lR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010nR\u0016\u0010q\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bJ\u0010pR\u0016\u0010s\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\br\u0010pR\u0016\u0010t\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010pR\u0016\u0010w\u001a\u00020u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010vR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010yR\u0016\u0010{\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bF\u0010pR\u0016\u0010}\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b|\u0010pR\u0016\u0010~\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010pR\u0017\u0010\u0080\u0001\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u007f\u0010pR\u0016\u0010\u0082\u0001\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010KR\u0018\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010jR\u0018\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010jR\u0018\u0010\u008a\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010jR\u0018\u0010\u008c\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010jR\u0018\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001d\u0010\u0096\u0001\u001a\u00030\u0091\u00018\u0006¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001¨\u0006\u009d\u0001"}, d2 = {"Lir/nasim/features/bank/NewGiftPacketRecyclerResultBottomSheetContentView;", "Lir/nasim/features/bank/GiftPacketPayBottomSheetContentViewBase;", "Landroid/content/Context;", "context", "", DialogEntity.COLUMN_RID, "", "ownerId", "date", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "Lir/nasim/vI2;", "giftPacketContent", "", "myWalletId", "Lir/nasim/ua0;", "activity", "", "randomGiftPacketIsFailure", "laterSendToWallet", "<init>", "(Landroid/content/Context;JIJLir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Lir/nasim/vI2;Ljava/lang/String;Lir/nasim/ua0;ZZ)V", "Lir/nasim/rB7;", TokenNames.X, "()V", "Q", "()Z", TokenNames.S, TokenNames.R, "P", "N", TokenNames.L, TokenNames.M, TokenNames.O, "B", "D", TokenNames.C, "A", "u", "delayState", "setDelayPacketState", "(I)V", "g0", "getDelayPacketState", "()I", "walletId", "Lir/nasim/uy;", "orderType", "Y", "(Ljava/lang/String;Lir/nasim/uy;Lir/nasim/d25;JJ)V", "a0", "W", "r", "v", "diffTime", "t", "(J)V", TokenNames.V, TokenNames.U, TokenNames.T, "w", "()J", "s", TokenNames.F, "getRemainCount", "getTotalAmount", "h0", TokenNames.E, "G", "getWiningAmount", "()Ljava/lang/String;", "x", "y", "J", "different", "i0", "d", "(Landroid/content/Context;)V", "a", "onDetachedFromWindow", "Lir/nasim/ro1;", "k", "Lir/nasim/ro1;", "coroutineScope", "l", "Z", "m", "n", "Ljava/lang/Long;", "winnerAmount", "o", "isLoading", "Lir/nasim/Lt4;", "p", "Lir/nasim/Lt4;", "adapter", "Lir/nasim/II2;", "q", "Lir/nasim/II2;", "resultStatus", "", "Lai/bale/proto/GiftpacketStruct$GiftReceiver;", "Ljava/util/List;", "receivers", TokenNames.I, "receiverCount", "Ljava/lang/Integer;", "rank", "Lir/nasim/vI2;", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvReceivedCountOwner", "z", "tvRemainCountOwner", "tvRemainCount", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "list", "Lir/nasim/designsystem/avatar/AvatarViewGlide;", "Lir/nasim/designsystem/avatar/AvatarViewGlide;", "avSenderAvatar", "tvSenderName", "H", "tvTitle", "tvBack", "z0", "tvTimer", "A0", "ONE_SECOND", "B0", "Ljava/lang/String;", "C0", "myUid", "D0", "pageNumber", "E0", "maxTry", "F0", "currentTry", "Lir/nasim/Bk5;", "G0", "Lir/nasim/Bk5;", "androidProperties", "Lir/nasim/Wt4;", "H0", "Lir/nasim/Wt4;", "getBinding", "()Lir/nasim/Wt4;", "binding", "Landroid/os/CountDownTimer;", "I0", "Landroid/os/CountDownTimer;", "countDownTimer", "J0", "b", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class NewGiftPacketRecyclerResultBottomSheetContentView extends GiftPacketPayBottomSheetContentViewBase {

    /* renamed from: J0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int K0 = 8;
    private static final int L0 = 86400000;

    /* renamed from: A, reason: from kotlin metadata */
    private TextView tvRemainCount;

    /* renamed from: A0, reason: from kotlin metadata */
    private final long ONE_SECOND;

    /* renamed from: B, reason: from kotlin metadata */
    private RecyclerView list;

    /* renamed from: B0, reason: from kotlin metadata */
    private String walletId;

    /* renamed from: C0, reason: from kotlin metadata */
    private int myUid;

    /* renamed from: D, reason: from kotlin metadata */
    private AvatarViewGlide avSenderAvatar;

    /* renamed from: D0, reason: from kotlin metadata */
    private int pageNumber;

    /* renamed from: E0, reason: from kotlin metadata */
    private int maxTry;

    /* renamed from: F0, reason: from kotlin metadata */
    private int currentTry;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView tvSenderName;

    /* renamed from: G0, reason: from kotlin metadata */
    private final InterfaceC3570Bk5 androidProperties;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: H0, reason: from kotlin metadata */
    private final C8624Wt4 binding;

    /* renamed from: I0, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView tvBack;

    /* renamed from: k, reason: from kotlin metadata */
    private final InterfaceC20315ro1 coroutineScope;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean randomGiftPacketIsFailure;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean laterSendToWallet;

    /* renamed from: n, reason: from kotlin metadata */
    private Long winnerAmount;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: p, reason: from kotlin metadata */
    private C6004Lt4 adapter;

    /* renamed from: q, reason: from kotlin metadata */
    private II2 resultStatus;

    /* renamed from: r, reason: from kotlin metadata */
    private List receivers;

    /* renamed from: s, reason: from kotlin metadata */
    private long date;

    /* renamed from: t, reason: from kotlin metadata */
    private long rid;

    /* renamed from: u, reason: from kotlin metadata */
    private int ownerId;

    /* renamed from: v, reason: from kotlin metadata */
    private int receiverCount;

    /* renamed from: w, reason: from kotlin metadata */
    private Integer rank;

    /* renamed from: x, reason: from kotlin metadata */
    private C22472vI2 giftPacketContent;

    /* renamed from: y, reason: from kotlin metadata */
    private TextView tvReceivedCountOwner;

    /* renamed from: z, reason: from kotlin metadata */
    private TextView tvRemainCountOwner;

    /* renamed from: z0, reason: from kotlin metadata */
    private TextView tvTimer;

    /* renamed from: ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final int a() {
            return NewGiftPacketRecyclerResultBottomSheetContentView.L0;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class b {
        public static final b a = new b("IDLE", 0);
        public static final b b = new b("DELAYED", 1);
        public static final b c = new b("REQUEST", 2);
        private static final /* synthetic */ b[] d;
        private static final /* synthetic */ F92 e;

        static {
            b[] bVarArrA = a();
            d = bVarArrA;
            e = G92.a(bVarArrA);
        }

        private b(String str, int i) {
        }

        private static final /* synthetic */ b[] a() {
            return new b[]{a, b, c};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) d.clone();
        }
    }

    public static final class c extends CountDownTimer {
        final /* synthetic */ NewGiftPacketRecyclerResultBottomSheetContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, long j2) {
            super(j, j2);
            this.a = newGiftPacketRecyclerResultBottomSheetContentView;
        }

        private final String a(long j, long j2) {
            long j3 = j / j2;
            if (j3 >= 10) {
                return String.valueOf(j3);
            }
            return "0" + j3;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            TextView textView = this.a.tvTimer;
            if (textView == null) {
                AbstractC13042fc3.y("tvTimer");
                textView = null;
            }
            textView.setText(XY6.e("00:00:00"));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            long j2 = 60;
            long j3 = j2 * 1000;
            long j4 = j2 * j3;
            long j5 = j % (24 * j4);
            String strA = a(j5, j4);
            long j6 = j5 % j4;
            String strA2 = a(j6, j3);
            String strA3 = a(j6 % j3, 1000L);
            TextView textView = this.a.tvTimer;
            if (textView == null) {
                AbstractC13042fc3.y("tvTimer");
                textView = null;
            }
            textView.setText(XY6.e(strA + ":" + strA2 + ":" + strA3));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NewGiftPacketRecyclerResultBottomSheetContentView(Context context, long j, int i, long j2, C11458d25 c11458d25, ExPeerType exPeerType, C22472vI2 c22472vI2, String str, C22042ua0 c22042ua0, boolean z, boolean z2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
        AbstractC13042fc3.i(c22472vI2, "giftPacketContent");
        AbstractC13042fc3.i(str, "myWalletId");
        AbstractC13042fc3.i(c22042ua0, "activity");
        long jV = c22472vI2.v();
        int iR = c22472vI2.r();
        EnumC19802qy enumC19802qyS = c22472vI2.s();
        AbstractC13042fc3.h(enumC19802qyS, "getGivingType(...)");
        String strT = c22472vI2.t();
        AbstractC13042fc3.h(strT, "getRegarding(...)");
        super(context, c11458d25, exPeerType, jV, iR, enumC19802qyS, strT, c22042ua0);
        this.coroutineScope = AbstractC20906so1.a(C12366eV1.c().X(P17.b(null, 1, null)));
        this.resultStatus = II2.GiftOpeningStatus_PENDING;
        this.receivers = new ArrayList();
        this.rank = 0;
        this.ONE_SECOND = 1000L;
        this.maxTry = 1;
        InterfaceC3570Bk5 interfaceC3570Bk5Q = C7183Qq.q(EnumC18608ow5.c);
        AbstractC13042fc3.h(interfaceC3570Bk5Q, "getInstance(...)");
        this.androidProperties = interfaceC3570Bk5Q;
        C8624Wt4 c8624Wt4C = C8624Wt4.c(LayoutInflater.from(getContext()), this, true);
        AbstractC13042fc3.h(c8624Wt4C, "inflate(...)");
        this.binding = c8624Wt4C;
        this.rid = j;
        this.date = j2;
        this.ownerId = i;
        setExPeerType$nasim_release(exPeerType);
        this.giftPacketContent = c22472vI2;
        this.walletId = str;
        this.myUid = C5735Kp4.w().i().X0();
        this.randomGiftPacketIsFailure = z;
        this.laterSendToWallet = z2;
        d(context);
    }

    private final void A() {
        E();
        F();
    }

    private final void B() {
        J();
        y();
        x();
        G();
        A();
        C();
        D();
    }

    private final void C() {
        this.binding.r.getRoot().setVisibility(4);
        this.binding.r.d.setTypeface(C6011Lu2.k());
    }

    private final void D() {
        this.binding.t.setTypeface(C6011Lu2.i());
    }

    private final void E() {
        this.tvReceivedCountOwner = this.binding.h;
    }

    private final void F() {
        C8624Wt4 c8624Wt4 = this.binding;
        this.tvRemainCount = c8624Wt4.C;
        this.tvRemainCountOwner = c8624Wt4.i;
    }

    private final void G() {
        TextView textView = this.binding.H;
        this.tvSenderName = textView;
        if (textView == null) {
            AbstractC13042fc3.y("tvSenderName");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.k());
        this.avSenderAvatar = this.binding.G;
        final C21231tK7 c21231tK7I0 = AbstractC5969Lp4.d().i0(this.ownerId);
        if (c21231tK7I0 == null) {
            return;
        }
        getBinder().s8(c21231tK7I0.h(), new InterfaceC14756iQ7() { // from class: ir.nasim.Ot4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) {
                NewGiftPacketRecyclerResultBottomSheetContentView.H(this.a, c21231tK7I0, (Avatar) obj, abstractC13554gQ7);
            }
        });
        getBinder().s8(c21231tK7I0.r(), new InterfaceC14756iQ7() { // from class: ir.nasim.Pt4
            @Override // ir.nasim.InterfaceC14756iQ7
            public final void b(Object obj, AbstractC13554gQ7 abstractC13554gQ7) throws Resources.NotFoundException {
                NewGiftPacketRecyclerResultBottomSheetContentView.I(this.a, (String) obj, abstractC13554gQ7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, C21231tK7 c21231tK7, Avatar avatar, AbstractC13554gQ7 abstractC13554gQ7) {
        AvatarViewGlide avatarViewGlide;
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(c21231tK7, "$userVM");
        AvatarViewGlide avatarViewGlide2 = newGiftPacketRecyclerResultBottomSheetContentView.avSenderAvatar;
        if (avatarViewGlide2 == null) {
            AbstractC13042fc3.y("avSenderAvatar");
            avatarViewGlide2 = null;
        }
        avatarViewGlide2.B(22.0f, true);
        AvatarViewGlide avatarViewGlide3 = newGiftPacketRecyclerResultBottomSheetContentView.avSenderAvatar;
        if (avatarViewGlide3 == null) {
            AbstractC13042fc3.y("avSenderAvatar");
            avatarViewGlide = null;
        } else {
            avatarViewGlide = avatarViewGlide3;
        }
        AvatarViewGlide.v(avatarViewGlide, avatar, (String) c21231tK7.r().b(), c21231tK7.o(), false, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, String str, AbstractC13554gQ7 abstractC13554gQ7) throws Resources.NotFoundException {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        if (str != null) {
            TextView textView = newGiftPacketRecyclerResultBottomSheetContentView.tvSenderName;
            if (textView == null) {
                AbstractC13042fc3.y("tvSenderName");
                textView = null;
            }
            String string = newGiftPacketRecyclerResultBottomSheetContentView.getResources().getString(AbstractC12217eE5.gift_packet_sender_name);
            AbstractC13042fc3.h(string, "getString(...)");
            textView.setText(AbstractC20153rZ6.M(string, "{0}", str, false, 4, null));
        }
    }

    private final void J() {
        C8624Wt4 c8624Wt4 = this.binding;
        this.tvTimer = c8624Wt4.L;
        c8624Wt4.M.setVisibility(4);
        TextView textView = this.tvTimer;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("tvTimer");
            textView = null;
        }
        textView.setVisibility(4);
        TextView textView3 = this.tvTimer;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvTimer");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        TextView textView4 = this.tvTimer;
        if (textView4 == null) {
            AbstractC13042fc3.y("tvTimer");
        } else {
            textView2 = textView4;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Qt4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewGiftPacketRecyclerResultBottomSheetContentView.K(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, View view) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        AbstractC23658xI2.l(newGiftPacketRecyclerResultBottomSheetContentView.getContext(), newGiftPacketRecyclerResultBottomSheetContentView.getExPeerType$nasim_release());
    }

    private final boolean L() {
        return this.resultStatus == II2.GiftOpeningStatus_ALREADY_RECEIVED;
    }

    private final boolean M() {
        return this.resultStatus == II2.GiftOpeningStatus_GIFT_CREATOR;
    }

    private final boolean N() {
        return w() <= this.ONE_SECOND;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean O() {
        /*
            r4 = this;
            boolean r0 = r4.S()
            r1 = 0
            if (r0 == 0) goto L47
            java.util.List r0 = r4.receivers
            int r0 = r0.size()
            if (r0 <= 0) goto L47
            java.lang.Integer r0 = r4.rank
            r2 = 1
            if (r0 != 0) goto L15
            goto L1b
        L15:
            int r0 = r0.intValue()
            if (r0 == 0) goto L36
        L1b:
            ir.nasim.vI2 r0 = r4.giftPacketContent
            if (r0 == 0) goto L24
            ir.nasim.qy r0 = r0.s()
            goto L25
        L24:
            r0 = 0
        L25:
            ir.nasim.qy r3 = ir.nasim.EnumC19802qy.RANDOM
            if (r0 == r3) goto L2a
            goto L36
        L2a:
            java.lang.Integer r0 = r4.rank
            if (r0 != 0) goto L2f
            goto L47
        L2f:
            int r0 = r0.intValue()
            if (r0 != r2) goto L47
            return r2
        L36:
            java.util.List r0 = r4.receivers
            java.lang.Object r0 = r0.get(r1)
            ai.bale.proto.GiftpacketStruct$GiftReceiver r0 = (ai.bale.proto.GiftpacketStruct$GiftReceiver) r0
            int r0 = r0.getUserId()
            int r3 = r4.myUid
            if (r0 != r3) goto L47
            return r2
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.bank.NewGiftPacketRecyclerResultBottomSheetContentView.O():boolean");
    }

    private final boolean P() {
        return this.resultStatus == II2.GiftOpeningStatus_SOLD_OUT || w() <= this.ONE_SECOND;
    }

    private final boolean Q() {
        return this.resultStatus == II2.GiftOpeningStatus_PENDING;
    }

    private final boolean R() {
        return this.resultStatus == II2.GiftOpeningStatus_SOLD_OUT;
    }

    private final boolean S() {
        II2 ii2 = this.resultStatus;
        return ii2 == II2.GiftOpeningStatus_ALREADY_RECEIVED || ii2 == II2.GiftOpeningStatus_SUCCESSFUL;
    }

    private final void T(long diffTime) {
        TextView textView = this.tvTimer;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("tvTimer");
            textView = null;
        }
        textView.setVisibility(0);
        this.binding.M.setVisibility(0);
        if (R() || diffTime <= this.ONE_SECOND || L() || getRemainCount() == 0 || N()) {
            TextView textView3 = this.tvTimer;
            if (textView3 == null) {
                AbstractC13042fc3.y("tvTimer");
                textView3 = null;
            }
            textView3.setText(XY6.e("00:00:00"));
        } else {
            i0(diffTime);
        }
        if (getExPeerType$nasim_release() != ExPeerType.PRIVATE || getRemainCount() >= 1) {
            return;
        }
        this.binding.M.setVisibility(4);
        TextView textView4 = this.tvTimer;
        if (textView4 == null) {
            AbstractC13042fc3.y("tvTimer");
        } else {
            textView2 = textView4;
        }
        textView2.setVisibility(4);
    }

    private final void U(long diffTime) {
        if (M() || S()) {
            return;
        }
        if (R() || diffTime <= this.ONE_SECOND) {
            this.binding.v.setVisibility(0);
            TextView textView = null;
            this.binding.u.setText(XY6.c(XY6.e(String.valueOf(getTotalAmount())), (char) 0, 2, null));
            if (getPeer$nasim_release().C()) {
                this.binding.q.setVisibility(8);
                StringBuilder sb = new StringBuilder();
                sb.append(getContext().getString(AbstractC12217eE5.gift_packet_status_private_lose));
                char[] chars = Character.toChars(128532);
                AbstractC13042fc3.h(chars, "toChars(...)");
                sb.append(new String(chars));
                String string = sb.toString();
                AbstractC13042fc3.h(string, "toString(...)");
                this.binding.I.setText(string);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getContext().getString(!this.laterSendToWallet ? AbstractC12217eE5.gift_dialogs_lose_comment_new : AbstractC12217eE5.competion_is_heavy));
                char[] chars2 = Character.toChars(128525);
                AbstractC13042fc3.h(chars2, "toChars(...)");
                sb2.append(new String(chars2));
                String string2 = sb2.toString();
                AbstractC13042fc3.h(string2, "toString(...)");
                this.binding.I.setText(string2);
            }
            if (diffTime <= this.ONE_SECOND) {
                TextView textView2 = this.tvTimer;
                if (textView2 == null) {
                    AbstractC13042fc3.y("tvTimer");
                } else {
                    textView = textView2;
                }
                textView.setText(getContext().getString(AbstractC12217eE5.gift_packet_status_lose));
            } else {
                TextView textView3 = this.tvTimer;
                if (textView3 == null) {
                    AbstractC13042fc3.y("tvTimer");
                } else {
                    textView = textView3;
                }
                textView.setText(getContext().getString(AbstractC12217eE5.gift_packet_status_lose_gift));
            }
            this.binding.U.setVisibility(8);
            if (C5495Jo7.a.J2()) {
                this.binding.d.setImageResource(KB5.ic_big_lose_dark);
            } else {
                this.binding.d.setImageResource(KB5.ic_big_lose);
            }
        }
    }

    private final void V() {
        if (M() || !S()) {
            return;
        }
        String strC = XY6.c(XY6.e(getWiningAmount()), (char) 0, 2, null);
        if (h0()) {
            this.binding.y.setVisibility(0);
        } else {
            this.binding.S.setVisibility(0);
        }
        this.binding.R.setText(strC);
        this.binding.m.setText(getContext().getString(AbstractC12217eE5.gift_packet_rial, strC));
        this.binding.b0.setText(getContext().getString(AbstractC12217eE5.gift_packet_rial, XY6.c(XY6.e(String.valueOf(getTotalAmount())), (char) 0, 2, null)));
        if (!L()) {
            this.binding.d0.setVisibility(0);
        }
        if (!O()) {
            if (C5495Jo7.a.J2()) {
                this.binding.d.setImageResource(KB5.ic_big_gift_dark);
            } else {
                this.binding.d.setImageResource(KB5.ic_big_gift);
            }
            this.binding.I.setVisibility(8);
            this.binding.K.setVisibility(8);
            this.binding.J.setVisibility(8);
            return;
        }
        if (getPeer$nasim_release().C()) {
            if (C5495Jo7.a.J2()) {
                this.binding.d.setImageResource(KB5.ic_big_gift_dark);
            } else {
                this.binding.d.setImageResource(KB5.ic_big_gift);
            }
            this.binding.I.setVisibility(8);
            this.binding.K.setVisibility(8);
            this.binding.J.setVisibility(8);
            this.binding.q.setVisibility(8);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getString(AbstractC12217eE5.gift_packet_status_first));
        sb.append(Separators.SP);
        char[] chars = Character.toChars(128525);
        AbstractC13042fc3.h(chars, "toChars(...)");
        sb.append(new String(chars));
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        this.binding.d.setImageResource(KB5.ic_big_medal);
        this.binding.I.setText(string);
    }

    private final void W() {
        this.binding.l.getRoot().setVisibility(8);
        this.binding.b.setVisibility(8);
        this.binding.t.setVisibility(8);
        this.isLoading = false;
        this.resultStatus = II2.GiftOpeningStatus_SOLD_OUT;
        r();
        String str = getContext().getString(AbstractC12217eE5.yor_are_not_lucky);
        AbstractC13042fc3.h(str, "toString(...)");
        this.binding.I.setText(str);
        this.binding.A.setVisibility(8);
        this.binding.q.setVisibility(8);
        if (C5495Jo7.a.J2()) {
            this.binding.d.setImageResource(KB5.ic_big_lose_dark);
        } else {
            this.binding.d.setImageResource(KB5.ic_big_lose);
        }
        TextView textView = this.tvTimer;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("tvTimer");
            textView = null;
        }
        textView.setText(getContext().getString(AbstractC12217eE5.you_are_not_win_gift));
        TextView textView3 = this.tvTimer;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvTimer");
            textView3 = null;
        }
        textView3.setTextSize(16.0f);
        TextView textView4 = this.tvTimer;
        if (textView4 == null) {
            AbstractC13042fc3.y("tvTimer");
        } else {
            textView2 = textView4;
        }
        textView2.setTypeface(C6011Lu2.k());
    }

    private final void X() {
        C17213mb2.l("open_Gift_Packet_click", "click_exPeerType", String.valueOf(getExPeerType$nasim_release().getValue()));
        C22472vI2 c22472vI2 = this.giftPacketContent;
        if ((c22472vI2 != null ? c22472vI2.s() : null) == EnumC19802qy.RANDOM) {
            Y(this.walletId, EnumC22278uy.PRIZE_DESC, getPeer$nasim_release(), this.rid, this.date);
        } else {
            Y(this.walletId, EnumC22278uy.DATE_ASC, getPeer$nasim_release(), this.rid, this.date);
        }
    }

    private final void Y(String walletId, EnumC22278uy orderType, C11458d25 peer, long rid, long date) {
        if (!c()) {
            AbstractC20507s76.D(new Runnable() { // from class: ir.nasim.Mt4
                @Override // java.lang.Runnable
                public final void run() {
                    NewGiftPacketRecyclerResultBottomSheetContentView.Z(this.a);
                }
            }, 100L);
            return;
        }
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        if (Math.abs(System.currentTimeMillis() - date) >= AbstractC5969Lp4.e().S().h2()) {
            a0(walletId, orderType, peer, rid, date);
            g0();
            return;
        }
        if (getDelayPacketState() != b.a.ordinal()) {
            if (getDelayPacketState() == b.b.ordinal()) {
                W();
                return;
            } else {
                a0(walletId, orderType, peer, rid, date);
                return;
            }
        }
        if (this.randomGiftPacketIsFailure) {
            setDelayPacketState(b.b.ordinal());
            W();
        } else {
            setDelayPacketState(b.c.ordinal());
            a0(walletId, orderType, peer, rid, date);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        C14486i0 bottomSheet$nasim_release = newGiftPacketRecyclerResultBottomSheetContentView.getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
    }

    private final void a0(final String walletId, final EnumC22278uy orderType, final C11458d25 peer, final long rid, final long date) {
        AbstractC5969Lp4.d().h1(walletId, Integer.valueOf(this.pageNumber), orderType, peer, Long.valueOf(rid), Long.valueOf(date)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.Rt4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) throws Resources.NotFoundException {
                NewGiftPacketRecyclerResultBottomSheetContentView.b0(this.a, walletId, orderType, peer, rid, date, (Giftpacket$ResponseOpenGiftPacket) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.St4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                NewGiftPacketRecyclerResultBottomSheetContentView.d0(this.a, (Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(final NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, String str, EnumC22278uy enumC22278uy, C11458d25 c11458d25, long j, long j2, Giftpacket$ResponseOpenGiftPacket giftpacket$ResponseOpenGiftPacket) throws Resources.NotFoundException {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(str, "$walletId");
        AbstractC13042fc3.i(enumC22278uy, "$orderType");
        AbstractC13042fc3.i(c11458d25, "$peer");
        if (giftpacket$ResponseOpenGiftPacket != null) {
            II2 status = giftpacket$ResponseOpenGiftPacket.getStatus();
            AbstractC13042fc3.f(status);
            newGiftPacketRecyclerResultBottomSheetContentView.resultStatus = status;
            if (newGiftPacketRecyclerResultBottomSheetContentView.Q()) {
                int i = newGiftPacketRecyclerResultBottomSheetContentView.currentTry;
                if (i < newGiftPacketRecyclerResultBottomSheetContentView.maxTry) {
                    newGiftPacketRecyclerResultBottomSheetContentView.currentTry = i + 1;
                    newGiftPacketRecyclerResultBottomSheetContentView.Y(str, enumC22278uy, c11458d25, j, j2);
                    return;
                }
                Context context = newGiftPacketRecyclerResultBottomSheetContentView.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                String string = newGiftPacketRecyclerResultBottomSheetContentView.getResources().getString(AbstractC12217eE5.gift_packet_result_pending_state_error);
                AbstractC13042fc3.h(string, "getString(...)");
                new DialogC9423Zw1(context, string, new View.OnClickListener() { // from class: ir.nasim.Ut4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewGiftPacketRecyclerResultBottomSheetContentView.c0(this.a, view);
                    }
                }).show();
                return;
            }
            List list = newGiftPacketRecyclerResultBottomSheetContentView.receivers;
            List<GiftpacketStruct$GiftReceiver> giftReceiversList = giftpacket$ResponseOpenGiftPacket.getGiftReceiversList();
            AbstractC13042fc3.h(giftReceiversList, "getGiftReceiversList(...)");
            list.addAll(giftReceiversList);
            if (newGiftPacketRecyclerResultBottomSheetContentView.winnerAmount == null) {
                newGiftPacketRecyclerResultBottomSheetContentView.receiverCount = giftpacket$ResponseOpenGiftPacket.getOpenedCount();
                newGiftPacketRecyclerResultBottomSheetContentView.winnerAmount = Long.valueOf(giftpacket$ResponseOpenGiftPacket.getSelfWinAmount().getValue());
                if (giftpacket$ResponseOpenGiftPacket.getRank() != null) {
                    newGiftPacketRecyclerResultBottomSheetContentView.rank = Integer.valueOf(giftpacket$ResponseOpenGiftPacket.getRank().getValue());
                }
                newGiftPacketRecyclerResultBottomSheetContentView.binding.l.getRoot().setVisibility(8);
                newGiftPacketRecyclerResultBottomSheetContentView.binding.b.setVisibility(8);
                newGiftPacketRecyclerResultBottomSheetContentView.binding.t.setVisibility(8);
            }
            if (giftpacket$ResponseOpenGiftPacket.getGiftReceiversList().size() > 0) {
                newGiftPacketRecyclerResultBottomSheetContentView.pageNumber++;
            }
            newGiftPacketRecyclerResultBottomSheetContentView.r();
            C6004Lt4 c6004Lt4 = newGiftPacketRecyclerResultBottomSheetContentView.adapter;
            if (c6004Lt4 == null) {
                AbstractC13042fc3.y("adapter");
                c6004Lt4 = null;
            }
            c6004Lt4.notifyDataSetChanged();
        }
        newGiftPacketRecyclerResultBottomSheetContentView.binding.l.getRoot().setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.binding.b.setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.binding.t.setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.isLoading = false;
        C17213mb2.l("open_Gift_Packet_result", "result_exPeerType", String.valueOf(newGiftPacketRecyclerResultBottomSheetContentView.getExPeerType$nasim_release().getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, View view) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        C14486i0 bottomSheet$nasim_release = newGiftPacketRecyclerResultBottomSheetContentView.getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(final NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, Exception exc) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        final C12889fL5 c12889fL5 = new C12889fL5();
        String localizedMessage = exc.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "";
        }
        c12889fL5.a = localizedMessage;
        if ((exc instanceof RpcTimeoutException) || localizedMessage.length() == 0 || C20644sM5.c(new C20644sM5("[a-z]", EnumC23107wM5.c), (CharSequence) c12889fL5.a, 0, 2, null) != null) {
            c12889fL5.a = newGiftPacketRecyclerResultBottomSheetContentView.getResources().getString(AbstractC12217eE5.error_connection);
        }
        newGiftPacketRecyclerResultBottomSheetContentView.binding.l.getRoot().setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.binding.b.setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.binding.t.setVisibility(8);
        newGiftPacketRecyclerResultBottomSheetContentView.isLoading = false;
        AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.Tt4
            @Override // java.lang.Runnable
            public final void run() {
                NewGiftPacketRecyclerResultBottomSheetContentView.e0(this.a, c12889fL5);
            }
        });
        C17213mb2.l("open_Gift_Packet_failure", "failure_exPeerType", String.valueOf(newGiftPacketRecyclerResultBottomSheetContentView.getExPeerType$nasim_release().getValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(final NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, C12889fL5 c12889fL5) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        AbstractC13042fc3.i(c12889fL5, "$errorMessage");
        Context context = newGiftPacketRecyclerResultBottomSheetContentView.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        C22042ua0 fragment$nasim_release = newGiftPacketRecyclerResultBottomSheetContentView.getFragment$nasim_release();
        AbstractC13042fc3.g(fragment$nasim_release, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        C24398yZ.g(context, fragment$nasim_release, (String) c12889fL5.a, new SA2() { // from class: ir.nasim.Vt4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewGiftPacketRecyclerResultBottomSheetContentView.f0(this.a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f0(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        C14486i0 bottomSheet$nasim_release = newGiftPacketRecyclerResultBottomSheetContentView.getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
        return C19938rB7.a;
    }

    private final void g0() {
        this.androidProperties.remove(getPeer$nasim_release().getPeerId() + Separators.SP + this.rid);
    }

    private final int getDelayPacketState() {
        return this.androidProperties.getInt(getPeer$nasim_release().getPeerId() + Separators.SP + this.rid, b.a.ordinal());
    }

    private final int getRemainCount() {
        C22472vI2 c22472vI2 = this.giftPacketContent;
        return (c22472vI2 != null ? c22472vI2.r() : 0) - this.receiverCount;
    }

    private final long getTotalAmount() {
        C22472vI2 c22472vI2 = this.giftPacketContent;
        if (c22472vI2 != null) {
            return c22472vI2.v();
        }
        return 0L;
    }

    private final String getWiningAmount() {
        Long l = this.winnerAmount;
        return l != null ? String.valueOf(l) : "0";
    }

    private final boolean h0() {
        Boolean boolU;
        C22472vI2 c22472vI2 = this.giftPacketContent;
        if (c22472vI2 == null || (boolU = c22472vI2.u()) == null) {
            return false;
        }
        return boolU.booleanValue();
    }

    private final void i0(long different) {
        this.countDownTimer = new c(different, this, this.ONE_SECOND).start();
    }

    private final void r() {
        long jW = w();
        this.binding.W.setVisibility(0);
        TextView textView = null;
        if (L()) {
            TextView textView2 = this.tvTimer;
            if (textView2 == null) {
                AbstractC13042fc3.y("tvTimer");
                textView2 = null;
            }
            textView2.setText(getContext().getString(AbstractC12217eE5.gift_packet_status_received));
        } else {
            this.binding.U.setVisibility(0);
            if (this.laterSendToWallet) {
                this.binding.U.setText(getResources().getString(AbstractC12217eE5.amount_of_gift_will_be_deposit_into_your_wallet));
            }
        }
        this.binding.I.setVisibility(0);
        if (!O() || getPeer$nasim_release().C()) {
            this.binding.K.setVisibility(0);
        } else {
            this.binding.J.setVisibility(0);
        }
        this.binding.q.setVisibility(0);
        T(jW);
        U(jW);
        V();
        t(jW);
        TextView textView3 = this.tvTimer;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvTimer");
            textView3 = null;
        }
        TextView textView4 = this.tvTimer;
        if (textView4 == null) {
            AbstractC13042fc3.y("tvTimer");
            textView4 = null;
        }
        textView3.setText(XY6.e(textView4.getText().toString()));
        TextView textView5 = this.tvRemainCount;
        if (textView5 == null) {
            AbstractC13042fc3.y("tvRemainCount");
            textView5 = null;
        }
        textView5.setText(XY6.e(String.valueOf(getRemainCount())));
        this.binding.z.setText(XY6.e(String.valueOf(this.receiverCount)));
        TextView textView6 = this.tvRemainCountOwner;
        if (textView6 == null) {
            AbstractC13042fc3.y("tvRemainCountOwner");
            textView6 = null;
        }
        textView6.setText(XY6.e(String.valueOf(getRemainCount())));
        TextView textView7 = this.tvReceivedCountOwner;
        if (textView7 == null) {
            AbstractC13042fc3.y("tvReceivedCountOwner");
        } else {
            textView = textView7;
        }
        textView.setText(XY6.e(String.valueOf(this.receiverCount)));
        this.binding.E.setVisibility(0);
        if (getRemainCount() <= 0 || P()) {
            this.binding.D.setVisibility(8);
        }
        v();
    }

    private final void s() {
        List list = this.receivers;
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ExPeerType exPeerType$nasim_release = getExPeerType$nasim_release();
        C22472vI2 c22472vI2 = this.giftPacketContent;
        C6004Lt4 c6004Lt4 = null;
        this.adapter = new C6004Lt4(list, context, exPeerType$nasim_release, (c22472vI2 != null ? c22472vI2.s() : null) == EnumC19802qy.RANDOM, false, 16, null);
        RecyclerView recyclerView = this.list;
        if (recyclerView == null) {
            AbstractC13042fc3.y("list");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.list;
        if (recyclerView2 == null) {
            AbstractC13042fc3.y("list");
            recyclerView2 = null;
        }
        C6004Lt4 c6004Lt42 = this.adapter;
        if (c6004Lt42 == null) {
            AbstractC13042fc3.y("adapter");
        } else {
            c6004Lt4 = c6004Lt42;
        }
        recyclerView2.setAdapter(c6004Lt4);
    }

    private final void setDelayPacketState(int delayState) {
        this.androidProperties.putInt(getPeer$nasim_release().getPeerId() + Separators.SP + this.rid, delayState);
    }

    private final void t(long diffTime) {
        if (M()) {
            this.binding.d.setImageResource(KB5.ic_big_owner);
            this.binding.D.setVisibility(8);
            this.binding.F.setVisibility(8);
            this.binding.I.setVisibility(8);
            this.binding.K.setVisibility(8);
            this.binding.J.setVisibility(8);
            this.binding.x.setVisibility(getVisibility());
            if (this.receiverCount > 0) {
                u();
                return;
            }
            this.binding.l0.setVisibility(8);
            this.binding.o.setVisibility(8);
            this.binding.U.setVisibility(8);
            this.binding.e0.setVisibility(8);
            TextView textView = null;
            if (diffTime > this.ONE_SECOND) {
                int i = getPeer$nasim_release().C() ? AbstractC12217eE5.gift_packet_result_empty_state_message_owner_in_private : AbstractC12217eE5.gift_packet_result_empty_state_message_owner;
                TextView textView2 = this.tvTimer;
                if (textView2 == null) {
                    AbstractC13042fc3.y("tvTimer");
                } else {
                    textView = textView2;
                }
                textView.setText(getContext().getResources().getString(i));
                return;
            }
            int i2 = AbstractC12217eE5.gift_packet_owner_expire;
            TextView textView3 = this.tvTimer;
            if (textView3 == null) {
                AbstractC13042fc3.y("tvTimer");
            } else {
                textView = textView3;
            }
            textView.setText(getContext().getResources().getString(i2));
        }
    }

    private final void u() {
        if (M()) {
            this.binding.U.setVisibility(8);
            this.binding.e0.setVisibility(8);
            TextView textView = null;
            if (getRemainCount() == 0) {
                int i = getPeer$nasim_release().C() ? AbstractC12217eE5.gift_packet_owner_finish_private : AbstractC12217eE5.gift_packet_owner_finish;
                TextView textView2 = this.tvTimer;
                if (textView2 == null) {
                    AbstractC13042fc3.y("tvTimer");
                } else {
                    textView = textView2;
                }
                textView.setText(getContext().getString(i));
                return;
            }
            if (N()) {
                TextView textView3 = this.tvTimer;
                if (textView3 == null) {
                    AbstractC13042fc3.y("tvTimer");
                } else {
                    textView = textView3;
                }
                textView.setText(getContext().getString(AbstractC12217eE5.gift_packet_owner_expire));
                if (getRemainCount() != 0) {
                    this.binding.V.setVisibility(0);
                }
            }
        }
    }

    private final void v() {
        if (getPeer$nasim_release().C()) {
            this.binding.l0.setVisibility(8);
            this.receivers = new ArrayList();
            C6004Lt4 c6004Lt4 = this.adapter;
            if (c6004Lt4 == null) {
                AbstractC13042fc3.y("adapter");
                c6004Lt4 = null;
            }
            c6004Lt4.notifyDataSetChanged();
        }
    }

    private final long w() {
        return L0 - (Calendar.getInstance().getTime().getTime() - this.date);
    }

    private final void x() {
        TextView textView = this.binding.Q;
        this.tvTitle = textView;
        if (textView == null) {
            AbstractC13042fc3.y("tvTitle");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.i());
    }

    private final void y() {
        TextView textView = this.binding.p;
        this.tvBack = textView;
        TextView textView2 = null;
        if (textView == null) {
            AbstractC13042fc3.y("tvBack");
            textView = null;
        }
        textView.setTypeface(C6011Lu2.k());
        TextView textView3 = this.tvBack;
        if (textView3 == null) {
            AbstractC13042fc3.y("tvBack");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Nt4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewGiftPacketRecyclerResultBottomSheetContentView.z(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NewGiftPacketRecyclerResultBottomSheetContentView newGiftPacketRecyclerResultBottomSheetContentView, View view) {
        AbstractC13042fc3.i(newGiftPacketRecyclerResultBottomSheetContentView, "this$0");
        C14486i0 bottomSheet$nasim_release = newGiftPacketRecyclerResultBottomSheetContentView.getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
    }

    @Override // ir.nasim.features.bank.GiftPacketPayBottomSheetContentViewBase, ir.nasim.InterfaceC16866m0
    public boolean a() {
        C14486i0 bottomSheet$nasim_release = getBottomSheet();
        if (bottomSheet$nasim_release != null) {
            bottomSheet$nasim_release.g();
        }
        return super.a();
    }

    @Override // ir.nasim.features.bank.GiftPacketPayBottomSheetContentViewBase
    protected void d(Context context) {
        AbstractC13042fc3.i(context, "context");
        super.d(context);
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        setView$nasim_release(this.binding.getRoot());
        this.list = this.binding.o;
        B();
        s();
        this.binding.b.setVisibility(0);
        this.binding.t.setVisibility(0);
        X();
    }

    public final C8624Wt4 getBinding() {
        return this.binding;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AbstractC20906so1.d(this.coroutineScope, null, 1, null);
        super.onDetachedFromWindow();
    }
}
