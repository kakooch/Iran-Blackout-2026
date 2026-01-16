package ir.nasim.features.attach;

import android.content.Context;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC21710u02;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C14486i0;
import ir.nasim.C18680p40;
import ir.nasim.C19406qI3;
import ir.nasim.C22527vO3;
import ir.nasim.C5495Jo7;
import ir.nasim.C6042Lx6;
import ir.nasim.C7183Qq;
import ir.nasim.EM2;
import ir.nasim.InterfaceC16866m0;
import ir.nasim.KB5;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.attach.NewChatAttachAlertBottomSheet;
import ir.nasim.features.attach.model.AttachmentData;
import ir.nasim.features.attach.model.BankAttachment;
import ir.nasim.features.attach.model.ShareAttachment;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002KHB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u0010J\u000f\u0010\u001c\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u0010J/\u0010#\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010\u0010J\u000f\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b&\u0010\u0010J\u001f\u0010*\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0000H\u0002¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b,\u0010\bJ\r\u0010-\u001a\u00020\u000e¢\u0006\u0004\b-\u0010\u0010J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b1\u0010\u0015J\u0017\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u0018¢\u0006\u0004\b7\u00108J\u0011\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J-\u0010=\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010<\u001a\u00020\u0018¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\u000e¢\u0006\u0004\b?\u0010\u0010J\u0015\u0010B\u001a\u00020'2\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u000eH\u0014¢\u0006\u0004\bF\u0010\u0010R \u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010OR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00120U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020.0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010[R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010LR\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010^R\u0016\u0010b\u001a\u00020`8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010aR\u0016\u0010e\u001a\u00020c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010dR\u0018\u0010g\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010hR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010iR\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010jR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010lR\u0016\u0010p\u001a\u00020n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010y\u001a\u00020u8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010w¨\u0006z"}, d2 = {"Lir/nasim/features/attach/NewChatAttachAlertBottomSheet;", "Landroid/widget/RelativeLayout;", "Lir/nasim/m0;", "Lir/nasim/Lx6$a;", "Lir/nasim/p40$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lir/nasim/features/attach/model/AttachmentData;", "attachmentData", "Lir/nasim/features/attach/NewChatAttachAlertBottomSheet$b;", "listener", "(Landroid/content/Context;Lir/nasim/features/attach/model/AttachmentData;Lir/nasim/features/attach/NewChatAttachAlertBottomSheet$b;)V", "Lir/nasim/rB7;", "i", "()V", "k", "Lir/nasim/features/attach/model/BankAttachment;", "attachment", "g", "(Lir/nasim/features/attach/model/BankAttachment;)V", "", ParameterNames.TAG, "", "n", "(Ljava/lang/String;)Z", "j", "l", "", "id", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "type", "m", "(ILir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Ljava/lang/String;)Z", "u", "v", "Lir/nasim/i0;", "abol", "contentView", "t", "(Lir/nasim/i0;Lir/nasim/features/attach/NewChatAttachAlertBottomSheet;)V", "h", "o", "Lir/nasim/features/attach/model/ShareAttachment;", TokenNames.I, "(Lir/nasim/features/attach/model/ShareAttachment;)V", "c", "Landroid/hardware/Camera;", "camera", "J", "(Landroid/hardware/Camera;)V", "isVisible", "setBadgeVisibility", "(Z)V", "Lir/nasim/EM2;", "H", "()Lir/nasim/EM2;", "isCommentChat", "setExPeerType", "(ILir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Z)V", "p", "Landroidx/appcompat/app/AppCompatActivity;", "activity", "q", "(Landroidx/appcompat/app/AppCompatActivity;)Lir/nasim/i0;", "setAbolInstance", "(Lir/nasim/i0;)V", "onAttachedToWindow", "Ljava/util/HashMap;", "a", "Ljava/util/HashMap;", "mapIds", "b", "Z", "isBadgeVisible", "Lir/nasim/p40;", "Lir/nasim/p40;", "bankAdapter", "Lir/nasim/Lx6;", "d", "Lir/nasim/Lx6;", "shareAdapter", "Ljava/util/ArrayList;", "e", "Ljava/util/ArrayList;", "bankItems", "f", "shareItems", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "peerType", "Lir/nasim/vO3;", "Lir/nasim/vO3;", "transferMarginDecorator", "Landroid/view/View;", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "tvPermissionDenied", "Lir/nasim/i0;", "bottomSheet", "Lir/nasim/features/attach/model/AttachmentData;", "Lir/nasim/features/attach/NewChatAttachAlertBottomSheet$b;", "Landroid/hardware/Camera;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "rootLayoutAttachment", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "shareListLayout", "Landroid/widget/ImageView;", "r", "Landroid/widget/ImageView;", "swipeIcon", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "transferList", "shareList", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class NewChatAttachAlertBottomSheet extends RelativeLayout implements InterfaceC16866m0, C6042Lx6.a, C18680p40.a {
    public static final int v = 8;

    /* renamed from: a, reason: from kotlin metadata */
    private final HashMap mapIds;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isBadgeVisible;

    /* renamed from: c, reason: from kotlin metadata */
    private final C18680p40 bankAdapter;

    /* renamed from: d, reason: from kotlin metadata */
    private final C6042Lx6 shareAdapter;

    /* renamed from: e, reason: from kotlin metadata */
    private final ArrayList bankItems;

    /* renamed from: f, reason: from kotlin metadata */
    private final ArrayList shareItems;

    /* renamed from: g, reason: from kotlin metadata */
    private ExPeerType peerType;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean isCommentChat;

    /* renamed from: i, reason: from kotlin metadata */
    private C22527vO3 transferMarginDecorator;

    /* renamed from: j, reason: from kotlin metadata */
    private View view;

    /* renamed from: k, reason: from kotlin metadata */
    private TextView tvPermissionDenied;

    /* renamed from: l, reason: from kotlin metadata */
    private C14486i0 bottomSheet;

    /* renamed from: m, reason: from kotlin metadata */
    private AttachmentData attachmentData;

    /* renamed from: n, reason: from kotlin metadata */
    private b listener;

    /* renamed from: o, reason: from kotlin metadata */
    private Camera camera;

    /* renamed from: p, reason: from kotlin metadata */
    private ConstraintLayout rootLayoutAttachment;

    /* renamed from: q, reason: from kotlin metadata */
    private LinearLayout shareListLayout;

    /* renamed from: r, reason: from kotlin metadata */
    private ImageView swipeIcon;

    /* renamed from: s, reason: from kotlin metadata */
    private RecyclerView transferList;

    /* renamed from: t, reason: from kotlin metadata */
    private RecyclerView shareList;

    public interface b {
        void F3(int i);

        EM2 H();

        void H4(int i);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ExPeerType.values().length];
            try {
                iArr[ExPeerType.GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExPeerType.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExPeerType.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExPeerType.BOT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
            int[] iArr2 = new int[EM2.values().length];
            try {
                iArr2[EM2.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EM2.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EM2.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewChatAttachAlertBottomSheet(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.mapIds = new HashMap();
        this.bankAdapter = new C18680p40(this);
        this.shareAdapter = new C6042Lx6(this);
        this.bankItems = new ArrayList();
        this.shareItems = new ArrayList();
        this.transferMarginDecorator = new C22527vO3(16, 16, (int) ((15 * AbstractC3742Cd6.c()) + 0.5d), 0, 0, 24, null);
    }

    private final void g(BankAttachment attachment) {
        if (n(attachment.getTag())) {
            C7183Qq.p().putInt(attachment.getTag(), 1);
        }
    }

    private final void i() {
        this.mapIds.put("GIFT_POCKET", 3);
        this.mapIds.put("GOLD_GIFT_POCKET", 33);
        this.mapIds.put("MONEY_TRANSFER", 9);
        this.mapIds.put("MONEY_REQUEST", 10);
        this.mapIds.put("CAMERA", 11);
        this.mapIds.put("GALLERY", 1);
        this.mapIds.put("FILE", 4);
        this.mapIds.put("LOCATION", 6);
        this.mapIds.put("CONTACT", 5);
        this.mapIds.put("CROWDFUNDING", 13);
        this.mapIds.put("POLL", 7);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void j() {
        AttachmentData attachmentData = this.attachmentData;
        if (attachmentData == null) {
            AbstractC13042fc3.y("attachmentData");
            attachmentData = null;
        }
        int i = 0;
        for (Object obj : attachmentData.getShareAttachments()) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            ShareAttachment shareAttachment = (ShareAttachment) obj;
            String tag = shareAttachment.getTag();
            switch (tag.hashCode()) {
                case -1611296843:
                    if (tag.equals("LOCATION")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.drawable_location));
                        break;
                    } else {
                        break;
                    }
                case 2157948:
                    if (tag.equals("FILE")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.drawable_file));
                        break;
                    } else {
                        break;
                    }
                case 2461631:
                    if (tag.equals("POLL")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.chart));
                        break;
                    } else {
                        break;
                    }
                case 521667378:
                    if (tag.equals("GALLERY")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.drawable_gallery));
                        break;
                    } else {
                        break;
                    }
                case 1669509120:
                    if (tag.equals("CONTACT")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.drawable_contact));
                        break;
                    } else {
                        break;
                    }
                case 1980544805:
                    if (tag.equals("CAMERA")) {
                        shareAttachment.setSrc(Integer.valueOf(KB5.drawable_camera));
                        break;
                    } else {
                        break;
                    }
            }
            this.shareItems.add(shareAttachment);
            i = i2;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final void k() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.bankItems);
        this.bankItems.clear();
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            BankAttachment bankAttachment = (BankAttachment) obj;
            String tag = bankAttachment.getTag();
            switch (tag.hashCode()) {
                case -1016828027:
                    if (tag.equals("GIFT_POCKET")) {
                        bankAttachment.setSrc(Integer.valueOf(KB5.drawable_gift_pocket));
                        break;
                    } else {
                        break;
                    }
                case -685134384:
                    if (tag.equals("MONEY_REQUEST")) {
                        bankAttachment.setSrc(Integer.valueOf(KB5.drawable_request_money));
                        break;
                    } else {
                        break;
                    }
                case 518415792:
                    if (tag.equals("CROWDFUNDING")) {
                        bankAttachment.setSrc(Integer.valueOf(KB5.drawable_crowdfunding));
                        bankAttachment.setBadgeEnabled(!n(bankAttachment.getTag()));
                        break;
                    } else {
                        break;
                    }
                case 1361098278:
                    if (tag.equals("GOLD_GIFT_POCKET")) {
                        bankAttachment.setSrc(Integer.valueOf(KB5.gift_card));
                        break;
                    } else {
                        break;
                    }
                case 1909810346:
                    if (tag.equals("MONEY_TRANSFER")) {
                        bankAttachment.setSrc(Integer.valueOf(KB5.drawable_transfer_money));
                        break;
                    } else {
                        break;
                    }
            }
            this.bankItems.add(bankAttachment);
            i = i2;
        }
    }

    private final void l() {
        RecyclerView recyclerView = this.transferList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            AbstractC13042fc3.y("transferList");
            recyclerView = null;
        }
        recyclerView.setAdapter(this.bankAdapter);
        RecyclerView recyclerView3 = this.shareList;
        if (recyclerView3 == null) {
            AbstractC13042fc3.y("shareList");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.shareAdapter);
        RecyclerView recyclerView4 = this.transferList;
        if (recyclerView4 == null) {
            AbstractC13042fc3.y("transferList");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(this.transferMarginDecorator);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        RecyclerView recyclerView5 = this.shareList;
        if (recyclerView5 == null) {
            AbstractC13042fc3.y("shareList");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.setLayoutManager(linearLayoutManager);
    }

    private final boolean m(int id, C11458d25 peer, ExPeerType type, String tag) {
        int i = c.a[type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && (AbstractC13042fc3.d(tag, "CROWDFUNDING") || AbstractC13042fc3.d(tag, "GIFT_POCKET") || AbstractC13042fc3.d(tag, "GOLD_GIFT_POCKET") || AbstractC13042fc3.d(tag, "MONEY_REQUEST"))) {
                    return true;
                }
            } else {
                if (AbstractC13042fc3.d(tag, "GIFT_POCKET") || AbstractC13042fc3.d(tag, "GOLD_GIFT_POCKET") || AbstractC13042fc3.d(tag, "MONEY_REQUEST")) {
                    return true;
                }
                if (AbstractC13042fc3.d(tag, "MONEY_TRANSFER") && peer.getPeerId() != id) {
                    return true;
                }
            }
        } else if (AbstractC13042fc3.d(tag, "CROWDFUNDING") || AbstractC13042fc3.d(tag, "GIFT_POCKET") || AbstractC13042fc3.d(tag, "GOLD_GIFT_POCKET") || AbstractC13042fc3.d(tag, "MONEY_REQUEST")) {
            return true;
        }
        return false;
    }

    private final boolean n(String tag) {
        return C7183Qq.p().getInt(tag, -1) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(NewChatAttachAlertBottomSheet newChatAttachAlertBottomSheet) {
        AbstractC13042fc3.i(newChatAttachAlertBottomSheet, "this$0");
        newChatAttachAlertBottomSheet.v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(NewChatAttachAlertBottomSheet newChatAttachAlertBottomSheet, int i) {
        AbstractC13042fc3.i(newChatAttachAlertBottomSheet, "this$0");
        if (i == 2) {
            newChatAttachAlertBottomSheet.u();
        }
    }

    private final void t(C14486i0 abol, NewChatAttachAlertBottomSheet contentView) {
        if (abol.j()) {
            C14486i0.i(abol, contentView, false, 2, null);
        } else {
            abol.o(contentView);
        }
    }

    private final void u() {
        try {
            Camera camera = this.camera;
            if (camera != null) {
                camera.startPreview();
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    private final void v() {
        Camera camera = this.camera;
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            this.camera = null;
        }
    }

    @Override // ir.nasim.C6042Lx6.a
    public EM2 H() {
        b bVar = this.listener;
        if (bVar != null) {
            return bVar.H();
        }
        return null;
    }

    @Override // ir.nasim.C6042Lx6.a
    public void I(ShareAttachment attachment) {
        AbstractC13042fc3.i(attachment, "attachment");
        b bVar = this.listener;
        if (bVar != null) {
            Object obj = this.mapIds.get(attachment.getTag());
            AbstractC13042fc3.f(obj);
            bVar.F3(((Number) obj).intValue());
        }
        C14486i0 c14486i0 = this.bottomSheet;
        if (c14486i0 != null) {
            c14486i0.g();
        }
    }

    @Override // ir.nasim.C6042Lx6.a
    public void J(Camera camera) {
        AbstractC13042fc3.i(camera, "camera");
        this.camera = camera;
    }

    @Override // ir.nasim.C18680p40.a
    public void c(BankAttachment attachment) {
        AbstractC13042fc3.i(attachment, "attachment");
        b bVar = this.listener;
        if (bVar != null) {
            Object obj = this.mapIds.get(attachment.getTag());
            AbstractC13042fc3.f(obj);
            bVar.H4(((Number) obj).intValue());
        }
        C14486i0 c14486i0 = this.bottomSheet;
        if (c14486i0 != null) {
            c14486i0.g();
        }
        g(attachment);
    }

    public final void h(Context context) {
        AbstractC13042fc3.i(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.view = ((LayoutInflater) systemService).inflate(AbstractC12208eD5.bottom_sheet_chat_attach, this);
        this.rootLayoutAttachment = (ConstraintLayout) findViewById(BC5.rootLayoutAttachment);
        this.shareListLayout = (LinearLayout) findViewById(BC5.share_list_layout);
        this.swipeIcon = (ImageView) findViewById(BC5.swipeIcon);
        this.transferList = (RecyclerView) findViewById(BC5.transfer_list);
        this.shareList = (RecyclerView) findViewById(BC5.share_list);
        View view = this.view;
        ImageView imageView = null;
        if (view == null) {
            AbstractC13042fc3.y("view");
            view = null;
        }
        this.tvPermissionDenied = (TextView) view.findViewById(BC5.text_permission_denied);
        Drawable drawableF = AbstractC4043Dl1.f(getContext(), KB5.drawable_bottom_sheet_background);
        if (drawableF != null) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.j());
            ConstraintLayout constraintLayout = this.rootLayoutAttachment;
            if (constraintLayout == null) {
                AbstractC13042fc3.y("rootLayoutAttachment");
                constraintLayout = null;
            }
            constraintLayout.setBackground(drawableF);
        }
        Drawable drawableF2 = AbstractC4043Dl1.f(getContext(), KB5.drawable_attach_repo_list);
        if (drawableF2 != null) {
            AbstractC21710u02.h(drawableF2, C5495Jo7.a.k());
            LinearLayout linearLayout = this.shareListLayout;
            if (linearLayout == null) {
                AbstractC13042fc3.y("shareListLayout");
                linearLayout = null;
            }
            linearLayout.setBackground(drawableF2);
        }
        ImageView imageView2 = this.swipeIcon;
        if (imageView2 == null) {
            AbstractC13042fc3.y("swipeIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setColorFilter(C5495Jo7.a.l());
    }

    public final void o() {
        Context context = getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        h(context);
        k();
        j();
        l();
        this.bankAdapter.B(this.bankItems);
        this.shareAdapter.B(this.shareItems);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        EM2 em2H = H();
        int i = em2H == null ? -1 : c.b[em2H.ordinal()];
        TextView textView = null;
        if (i == 1) {
            TextView textView2 = this.tvPermissionDenied;
            if (textView2 == null) {
                AbstractC13042fc3.y("tvPermissionDenied");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        } else if (i == 2) {
            TextView textView3 = this.tvPermissionDenied;
            if (textView3 == null) {
                AbstractC13042fc3.y("tvPermissionDenied");
                textView3 = null;
            }
            textView3.setVisibility(0);
            TextView textView4 = this.tvPermissionDenied;
            if (textView4 == null) {
                AbstractC13042fc3.y("tvPermissionDenied");
            } else {
                textView = textView4;
            }
            textView.setText(AbstractC12217eE5.send_media_permission_denied);
        } else if (i == 3) {
            TextView textView5 = this.tvPermissionDenied;
            if (textView5 == null) {
                AbstractC13042fc3.y("tvPermissionDenied");
                textView5 = null;
            }
            textView5.setVisibility(0);
            TextView textView6 = this.tvPermissionDenied;
            if (textView6 == null) {
                AbstractC13042fc3.y("tvPermissionDenied");
            } else {
                textView = textView6;
            }
            textView.setText(this.isCommentChat ? AbstractC12217eE5.default_send_media_permission_denied_comment : AbstractC12217eE5.default_send_media_permission_denied);
        }
        super.onAttachedToWindow();
    }

    public final void p() {
        int i = 0;
        for (Object obj : this.shareItems) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            if (AbstractC13042fc3.d(((ShareAttachment) obj).getTag(), "CAMERA")) {
                this.shareAdapter.notifyItemChanged(i);
            }
            i = i2;
        }
    }

    public final C14486i0 q(AppCompatActivity activity) {
        AbstractC13042fc3.i(activity, "activity");
        C14486i0 c14486i0A = C14486i0.f.a(activity);
        setAbolInstance(c14486i0A);
        t(c14486i0A, this);
        c14486i0A.l(new C14486i0.b() { // from class: ir.nasim.Ds4
            @Override // ir.nasim.C14486i0.b
            public final void onDismiss() {
                NewChatAttachAlertBottomSheet.r(this.a);
            }
        });
        c14486i0A.m(new C14486i0.c() { // from class: ir.nasim.Es4
            @Override // ir.nasim.C14486i0.c
            public final void a(int i) {
                NewChatAttachAlertBottomSheet.s(this.a, i);
            }
        });
        return c14486i0A;
    }

    public void setAbolInstance(C14486i0 abol) {
        this.bottomSheet = abol;
    }

    public final void setBadgeVisibility(boolean isVisible) {
        this.isBadgeVisible = isVisible;
    }

    public final void setExPeerType(int id, C11458d25 peer, ExPeerType type, boolean isCommentChat) {
        AbstractC13042fc3.i(peer, "peer");
        AbstractC13042fc3.i(type, "type");
        this.isCommentChat = isCommentChat;
        this.peerType = type;
        ArrayList arrayList = new ArrayList();
        AttachmentData attachmentData = this.attachmentData;
        if (attachmentData == null) {
            AbstractC13042fc3.y("attachmentData");
            attachmentData = null;
        }
        arrayList.addAll(attachmentData.getBankAttachments());
        BankAttachment bankAttachment = (BankAttachment) arrayList.get(2);
        String string = getContext().getString(AbstractC12217eE5.crowdfunding_attachment_title);
        AbstractC13042fc3.h(string, "getString(...)");
        arrayList.add(3, bankAttachment.copy((249 & 1) != 0 ? bankAttachment.titleColor : null, (249 & 2) != 0 ? bankAttachment.tag : "CROWDFUNDING", (249 & 4) != 0 ? bankAttachment.title : string, (249 & 8) != 0 ? bankAttachment.backgroundTint : null, (249 & 16) != 0 ? bankAttachment.tint : null, (249 & 32) != 0 ? bankAttachment.border : null, (249 & 64) != 0 ? bankAttachment.badgeEnabled : false, (249 & 128) != 0 ? bankAttachment.src : null));
        this.bankItems.clear();
        if (!isCommentChat) {
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                BankAttachment bankAttachment2 = (BankAttachment) obj;
                if (m(id, peer, type, bankAttachment2.getTag())) {
                    this.bankItems.add(bankAttachment2);
                }
                i = i2;
            }
        }
        this.bankAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewChatAttachAlertBottomSheet(Context context, AttachmentData attachmentData, b bVar) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attachmentData, "attachmentData");
        AbstractC13042fc3.i(bVar, "listener");
        this.mapIds = new HashMap();
        this.bankAdapter = new C18680p40(this);
        this.shareAdapter = new C6042Lx6(this);
        this.bankItems = new ArrayList();
        this.shareItems = new ArrayList();
        this.transferMarginDecorator = new C22527vO3(16, 16, (int) ((15 * AbstractC3742Cd6.c()) + 0.5d), 0, 0, 24, null);
        this.attachmentData = attachmentData;
        this.listener = bVar;
        i();
    }
}
