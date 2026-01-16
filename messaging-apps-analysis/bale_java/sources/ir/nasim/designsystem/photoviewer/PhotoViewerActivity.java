package ir.nasim.designsystem.photoviewer;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.x;
import com.makeramen.roundedimageview.RoundedImageView;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12171e95;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15226jD5;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC5730Kp;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.BC5;
import ir.nasim.C11458d25;
import ir.nasim.C16335l6;
import ir.nasim.C18684p44;
import ir.nasim.C19938rB7;
import ir.nasim.C21753u45;
import ir.nasim.C22055ub3;
import ir.nasim.C5495Jo7;
import ir.nasim.C5505Jq;
import ir.nasim.C5721Ko;
import ir.nasim.C6011Lu2;
import ir.nasim.C6906Pm2;
import ir.nasim.C7781Te0;
import ir.nasim.ED1;
import ir.nasim.EG6;
import ir.nasim.EnumC19631qg6;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.OI2;
import ir.nasim.PH3;
import ir.nasim.QG4;
import ir.nasim.QI2;
import ir.nasim.R62;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.UK5;
import ir.nasim.VI2;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.designsystem.PullBackLayout;
import ir.nasim.designsystem.photoviewer.PhotoViewerActivity;
import ir.nasim.designsystem.photoviewer.a;
import ir.nasim.designsystem.photoviewer.c;
import ir.nasim.designsystem.photoviewer.data.Photo;
import ir.nasim.designsystem.photoviewer.widget.RecyclerViewFixMotionLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ª\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002«\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u0017H\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b.\u0010)J\u0019\u0010/\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b/\u0010)J\u0019\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b1\u0010)J\u001b\u00103\u001a\u0004\u0018\u0001022\b\u00100\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0017H\u0003¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b<\u0010\u0007J\u001f\u0010@\u001a\u00020\b2\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\b@\u0010AJ\u001f\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020=H\u0002¢\u0006\u0004\bE\u0010FJ\u001f\u0010G\u001a\u00020\b2\u0006\u0010C\u001a\u00020B2\u0006\u0010D\u001a\u00020=H\u0002¢\u0006\u0004\bG\u0010FJ\u000f\u0010H\u001a\u00020\bH\u0002¢\u0006\u0004\bH\u0010\u0007J\u0017\u0010I\u001a\u00020\b2\u0006\u0010?\u001a\u00020\nH\u0002¢\u0006\u0004\bI\u0010\rJ\u000f\u0010J\u001a\u00020\bH\u0002¢\u0006\u0004\bJ\u0010\u0007J\u000f\u0010K\u001a\u00020\bH\u0002¢\u0006\u0004\bK\u0010\u0007J\u000f\u0010L\u001a\u00020\bH\u0002¢\u0006\u0004\bL\u0010\u0007J\u0017\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020 H\u0014¢\u0006\u0004\bN\u0010#J\u0019\u0010Q\u001a\u00020\b2\b\u0010P\u001a\u0004\u0018\u00010OH\u0014¢\u0006\u0004\bQ\u0010RJ/\u0010X\u001a\u00020\b2\u0006\u0010S\u001a\u00020\u00172\u000e\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190T2\u0006\u0010W\u001a\u00020VH\u0016¢\u0006\u0004\bX\u0010YJ\u0019\u0010\\\u001a\u00020\n2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016¢\u0006\u0004\b\\\u0010]J\u0017\u0010`\u001a\u00020\n2\u0006\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\bH\u0016¢\u0006\u0004\bb\u0010\u0007J\u001f\u0010c\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\bc\u0010dJ\u001f\u0010e\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\be\u0010dJ\u000f\u0010f\u001a\u00020\bH\u0016¢\u0006\u0004\bf\u0010\u0007J\u0017\u0010h\u001a\u00020\b2\u0006\u0010g\u001a\u00020=H\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\bH\u0016¢\u0006\u0004\bj\u0010\u0007J\u000f\u0010k\u001a\u00020\bH\u0016¢\u0006\u0004\bk\u0010\u0007J\u000f\u0010l\u001a\u00020\bH\u0016¢\u0006\u0004\bl\u0010\u0007J\u000f\u0010m\u001a\u00020\bH\u0014¢\u0006\u0004\bm\u0010\u0007R\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u001a\u0010v\u001a\u00020\u00178\u0006X\u0086D¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001d\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010eR\u0018\u0010\u0086\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010oR\u0019\u0010\u0089\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001f\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190T8\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u0090\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R!\u0010\u0096\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u0098\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0097\u0001\u0010oR\u0018\u0010\u009a\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010sR\u0018\u0010\u009c\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010sR\u0018\u0010\u009e\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010sR\u0018\u0010 \u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010oR\u0018\u0010¢\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¡\u0001\u0010oR\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001¨\u0006¬\u0001"}, d2 = {"Lir/nasim/designsystem/photoviewer/PhotoViewerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lir/nasim/designsystem/photoviewer/a$c;", "Lir/nasim/designsystem/photoviewer/a$a;", "Lir/nasim/designsystem/photoviewer/a$b;", "Lir/nasim/designsystem/PullBackLayout$a;", "<init>", "()V", "Lir/nasim/rB7;", "l2", "", "isStarterImage", "I2", "(Z)V", "Lir/nasim/designsystem/photoviewer/data/Photo;", "photo", "b2", "(Lir/nasim/designsystem/photoviewer/data/Photo;)V", "", "date", "x2", "(J)V", "r2", "", "color", "", "S1", "(I)Ljava/lang/String;", "j2", "P1", "n2", "O1", "Landroid/content/Context;", "context", "i2", "(Landroid/content/Context;)V", "T1", "S2", "T2", "string", "E2", "(Ljava/lang/String;)V", "position", "Landroid/text/Spannable;", "a2", "(I)Landroid/text/Spannable;", "F2", "G2", "caption", "D2", "", "p2", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "placeHolderColor", "H2", "(I)V", "Landroid/net/Uri;", "uri", "C2", "(Landroid/net/Uri;)V", "q2", "", "currentAlpha", "isCaptionEnabled", "Q1", "(FZ)V", "Landroid/view/View;", "view", "alpha", "B2", "(Landroid/view/View;F)V", "P2", "g2", "Q2", "o2", "K2", "O2", "newBase", "attachBaseContext", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "requestCode", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "v", "k", "(ILir/nasim/designsystem/photoviewer/data/Photo;)V", "J", "g", "progress", "u", "(F)V", "y", "z", "A", "onDestroy", "Lir/nasim/core/modules/profile/entity/ExPeerType;", "Z", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "z0", TokenNames.I, "getPERMISSIONS_REQUEST_STORAGE", "()I", "PERMISSIONS_REQUEST_STORAGE", "Lir/nasim/designsystem/photoviewer/a;", "A0", "Lir/nasim/designsystem/photoviewer/a;", "adapter", "Landroidx/recyclerview/widget/u;", "B0", "Landroidx/recyclerview/widget/u;", "snapHelper", "Ljava/util/ArrayList;", "C0", "Ljava/util/ArrayList;", "list", "D0", "peerUniqueId", "E0", "isFromSharedMedia", "F0", "Lir/nasim/designsystem/photoviewer/data/Photo;", "selectedItem", "G0", "[Ljava/lang/String;", "colors", "Lir/nasim/d25;", "H0", "Lir/nasim/d25;", "peer", "Lir/nasim/designsystem/photoviewer/c;", "I0", "Lir/nasim/Yu3;", "f2", "()Lir/nasim/designsystem/photoviewer/c;", "viewModel", "J0", "isVisibleBars", "K0", "peerImageCount", "L0", "selectedPosition", "M0", "currentIndex", "N0", "requestForwardBusy", "O0", "requestBackwardBusy", "P0", "Landroid/view/MenuItem;", "itemShareMenu", "Lir/nasim/l6;", "Q0", "Lir/nasim/l6;", "binding", "R0", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class PhotoViewerActivity extends Hilt_PhotoViewerActivity implements a.c, a.InterfaceC1021a, a.b, PullBackLayout.a {

    /* renamed from: R0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int S0 = 8;

    /* renamed from: A0, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: D0, reason: from kotlin metadata */
    private long peerUniqueId;

    /* renamed from: E0, reason: from kotlin metadata */
    private boolean isFromSharedMedia;

    /* renamed from: F0, reason: from kotlin metadata */
    private Photo selectedItem;

    /* renamed from: G0, reason: from kotlin metadata */
    private String[] colors;

    /* renamed from: H0, reason: from kotlin metadata */
    private C11458d25 peer;

    /* renamed from: J0, reason: from kotlin metadata */
    private boolean isVisibleBars;

    /* renamed from: L0, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: P0, reason: from kotlin metadata */
    private MenuItem itemShareMenu;

    /* renamed from: Q0, reason: from kotlin metadata */
    private C16335l6 binding;

    /* renamed from: Z, reason: from kotlin metadata */
    private ExPeerType exPeerType = ExPeerType.UNKNOWN;

    /* renamed from: z0, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_STORAGE = 10001;

    /* renamed from: B0, reason: from kotlin metadata */
    private final u snapHelper = new u();

    /* renamed from: C0, reason: from kotlin metadata */
    private final ArrayList list = new ArrayList();

    /* renamed from: I0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.ub5
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return PhotoViewerActivity.U2(this.a);
        }
    });

    /* renamed from: K0, reason: from kotlin metadata */
    private int peerImageCount = 1;

    /* renamed from: M0, reason: from kotlin metadata */
    private int currentIndex = 1;

    /* renamed from: N0, reason: from kotlin metadata */
    private boolean requestForwardBusy = true;

    /* renamed from: O0, reason: from kotlin metadata */
    private boolean requestBackwardBusy = true;

    /* renamed from: ir.nasim.designsystem.photoviewer.PhotoViewerActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void a(Context context, Photo photo, long j, ExPeerType exPeerType, boolean z) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(photo, "photo");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            Intent intent = new Intent(context, (Class<?>) PhotoViewerActivity.class);
            intent.putExtra("PEER_UNIQUE_ID_PARAM", j);
            intent.putExtra("EX_PEER_TYPE", exPeerType.getValue());
            intent.putExtra("FIRST_SELECTED_PHOTO", photo);
            intent.putExtra("IS_FROM_SHARED_MEDIA", z);
            context.startActivity(intent);
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements EG6.b {
        b() {
        }

        @Override // ir.nasim.EG6.b
        public void a(int i) throws Resources.NotFoundException, UnsupportedEncodingException {
            if (i < 0) {
                return;
            }
            PhotoViewerActivity photoViewerActivity = PhotoViewerActivity.this;
            photoViewerActivity.selectedItem = (Photo) photoViewerActivity.list.get(i);
            PhotoViewerActivity.this.I2(false);
            C16335l6 c16335l6 = PhotoViewerActivity.this.binding;
            if (c16335l6 == null) {
                AbstractC13042fc3.y("binding");
                c16335l6 = null;
            }
            c16335l6.n.setTitle(PhotoViewerActivity.this.a2(i));
            PhotoViewerActivity.this.selectedPosition = i;
            if (i <= 10 && !PhotoViewerActivity.this.requestBackwardBusy) {
                PhotoViewerActivity photoViewerActivity2 = PhotoViewerActivity.this;
                photoViewerActivity2.r2(((Photo) photoViewerActivity2.list.get(0)).getTimeStamp());
            } else {
                if (i < PhotoViewerActivity.this.list.size() - 10 || PhotoViewerActivity.this.requestForwardBusy) {
                    return;
                }
                PhotoViewerActivity photoViewerActivity3 = PhotoViewerActivity.this;
                photoViewerActivity3.x2(((Photo) photoViewerActivity3.list.get(PhotoViewerActivity.this.list.size() - 1)).getTimeStamp());
            }
        }
    }

    public static final class c implements c.b {
        final /* synthetic */ int b;

        c(int i) {
            this.b = i;
        }

        @Override // ir.nasim.designsystem.photoviewer.c.b
        public void a(Photo photo) {
            AbstractC13042fc3.i(photo, "photo");
            a aVar = null;
            if (((Photo) PhotoViewerActivity.this.list.get(this.b)).getTimeStamp() == photo.getTimeStamp()) {
                PhotoViewerActivity.this.list.set(this.b, photo);
                a aVar2 = PhotoViewerActivity.this.adapter;
                if (aVar2 == null) {
                    AbstractC13042fc3.y("adapter");
                } else {
                    aVar = aVar2;
                }
                aVar.notifyItemChanged(this.b, photo);
                return;
            }
            ArrayList arrayList = PhotoViewerActivity.this.list;
            PhotoViewerActivity photoViewerActivity = PhotoViewerActivity.this;
            int i = 0;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                if (((Photo) obj).getTimeStamp() == photo.getTimeStamp()) {
                    photoViewerActivity.list.set(i, photo);
                    a aVar3 = photoViewerActivity.adapter;
                    if (aVar3 == null) {
                        AbstractC13042fc3.y("adapter");
                        aVar3 = null;
                    }
                    aVar3.notifyItemChanged(i, photo);
                }
                i = i2;
            }
        }

        @Override // ir.nasim.designsystem.photoviewer.c.b
        public void b(Photo photo) {
            AbstractC13042fc3.i(photo, "photo");
            MenuItem menuItem = PhotoViewerActivity.this.itemShareMenu;
            int i = 0;
            a aVar = null;
            if (menuItem != null) {
                Photo photo2 = PhotoViewerActivity.this.selectedItem;
                if (photo2 == null) {
                    AbstractC13042fc3.y("selectedItem");
                    photo2 = null;
                }
                menuItem.setVisible(photo2.getPhotoPath() != null);
            }
            if (((Photo) PhotoViewerActivity.this.list.get(this.b)).getTimeStamp() == photo.getTimeStamp()) {
                PhotoViewerActivity.this.list.set(this.b, photo);
                a aVar2 = PhotoViewerActivity.this.adapter;
                if (aVar2 == null) {
                    AbstractC13042fc3.y("adapter");
                } else {
                    aVar = aVar2;
                }
                aVar.notifyItemChanged(this.b, photo);
                return;
            }
            ArrayList arrayList = PhotoViewerActivity.this.list;
            PhotoViewerActivity photoViewerActivity = PhotoViewerActivity.this;
            for (Object obj : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                if (((Photo) obj).getTimeStamp() == photo.getTimeStamp()) {
                    photoViewerActivity.list.set(i, photo);
                    a aVar3 = photoViewerActivity.adapter;
                    if (aVar3 == null) {
                        AbstractC13042fc3.y("adapter");
                        aVar3 = null;
                    }
                    aVar3.notifyItemChanged(i, photo);
                }
                i = i2;
            }
        }
    }

    static final class d implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        d(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A2(PhotoViewerActivity photoViewerActivity, C7781Te0 c7781Te0) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        boolean z = false;
        if (!c7781Te0.d()) {
            List listB = c7781Te0.b();
            if (listB == null || listB.isEmpty()) {
                z = true;
            } else {
                int size = photoViewerActivity.list.size() - 1;
                photoViewerActivity.list.addAll(c7781Te0.b());
                a aVar = photoViewerActivity.adapter;
                if (aVar == null) {
                    AbstractC13042fc3.y("adapter");
                    aVar = null;
                }
                aVar.notifyItemRangeInserted(size, c7781Te0.b().size());
            }
        }
        photoViewerActivity.requestForwardBusy = z;
        return C19938rB7.a;
    }

    private final void B2(View view, float alpha) {
        view.animate().alpha(alpha).setDuration(200L);
    }

    private final void C2(Uri uri) {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        RoundedImageView roundedImageView = c16335l6.b;
        AbstractC13042fc3.h(roundedImageView, "avatarImg");
        QI2.l(uri, roundedImageView);
    }

    private final void D2(String caption) throws UnsupportedEncodingException {
        CharSequence charSequenceP2 = p2(caption);
        C16335l6 c16335l6 = null;
        if (charSequenceP2 == null || charSequenceP2.length() == 0) {
            C16335l6 c16335l62 = this.binding;
            if (c16335l62 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c16335l6 = c16335l62;
            }
            Toolbar toolbar = c16335l6.d;
            AbstractC13042fc3.h(toolbar, "captionToolbar");
            toolbar.setVisibility(8);
            return;
        }
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
            c16335l63 = null;
        }
        c16335l63.e.setText(charSequenceP2);
        C16335l6 c16335l64 = this.binding;
        if (c16335l64 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l64;
        }
        Toolbar toolbar2 = c16335l6.d;
        AbstractC13042fc3.h(toolbar2, "captionToolbar");
        toolbar2.setVisibility(0);
    }

    private final void E2(String string) {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.f.setText(string);
    }

    private final void F2(String string) {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.h.setText(string);
    }

    private final void G2(String string) {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.l.setText(string);
    }

    private final void H2(int placeHolderColor) throws Resources.NotFoundException {
        String string;
        C16335l6 c16335l6 = null;
        if (placeHolderColor == 0) {
            string = getResources().getString(TA5.placeholder_empty);
            AbstractC13042fc3.f(string);
        } else {
            String[] strArr = this.colors;
            if (strArr == null) {
                AbstractC13042fc3.y("colors");
                strArr = null;
            }
            int iAbs = Math.abs(placeHolderColor);
            String[] strArr2 = this.colors;
            if (strArr2 == null) {
                AbstractC13042fc3.y("colors");
                strArr2 = null;
            }
            string = strArr[iAbs % strArr2.length];
        }
        C16335l6 c16335l62 = this.binding;
        if (c16335l62 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l62;
        }
        c16335l6.k.getBackground().setColorFilter(Color.parseColor(string), PorterDuff.Mode.SRC_ATOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I2(boolean isStarterImage) throws Resources.NotFoundException, UnsupportedEncodingException {
        MenuItem menuItem = this.itemShareMenu;
        Photo photo = null;
        C16335l6 c16335l6 = null;
        Photo photo2 = null;
        if (menuItem != null) {
            Photo photo3 = this.selectedItem;
            if (photo3 == null) {
                AbstractC13042fc3.y("selectedItem");
                photo3 = null;
            }
            menuItem.setVisible(photo3.getPhotoPath() != null);
        }
        Photo photo4 = this.selectedItem;
        if (photo4 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo4 = null;
        }
        E2(photo4.getDate());
        Photo photo5 = this.selectedItem;
        if (photo5 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo5 = null;
        }
        F2(photo5.getSenderName());
        Photo photo6 = this.selectedItem;
        if (photo6 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo6 = null;
        }
        if (!AbstractC20762sZ6.n0(photo6.getSenderName())) {
            Photo photo7 = this.selectedItem;
            if (photo7 == null) {
                AbstractC13042fc3.y("selectedItem");
                photo7 = null;
            }
            G2(String.valueOf(photo7.getSenderName().charAt(0)));
        }
        Photo photo8 = this.selectedItem;
        if (photo8 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo8 = null;
        }
        D2(photo8.getCaption());
        Photo photo9 = this.selectedItem;
        if (photo9 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo9 = null;
        }
        H2(photo9.getUserId());
        Photo photo10 = this.selectedItem;
        if (photo10 == null) {
            AbstractC13042fc3.y("selectedItem");
            photo10 = null;
        }
        if (AbstractC12171e95.a(photo10)) {
            C16335l6 c16335l62 = this.binding;
            if (c16335l62 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c16335l6 = c16335l62;
            }
            Toolbar toolbar = c16335l6.c;
            AbstractC13042fc3.h(toolbar, "bottomToolbar");
            toolbar.setVisibility(8);
            return;
        }
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
            c16335l63 = null;
        }
        Toolbar toolbar2 = c16335l63.c;
        AbstractC13042fc3.h(toolbar2, "bottomToolbar");
        toolbar2.setVisibility(0);
        if (isStarterImage) {
            ir.nasim.designsystem.photoviewer.c cVarF2 = f2();
            Photo photo11 = this.selectedItem;
            if (photo11 == null) {
                AbstractC13042fc3.y("selectedItem");
            } else {
                photo2 = photo11;
            }
            cVarF2.f1(photo2).j(this, new d(new UA2() { // from class: ir.nasim.yb5
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return PhotoViewerActivity.J2(this.a, (Uri) obj);
                }
            }));
            return;
        }
        if (this.list.size() > 1) {
            Photo photo12 = this.selectedItem;
            if (photo12 == null) {
                AbstractC13042fc3.y("selectedItem");
                photo12 = null;
            }
            if (photo12.getAvatar() == null) {
                q2();
                return;
            }
            Photo photo13 = this.selectedItem;
            if (photo13 == null) {
                AbstractC13042fc3.y("selectedItem");
            } else {
                photo = photo13;
            }
            Uri uri = Uri.parse(photo.getAvatar());
            AbstractC13042fc3.h(uri, "parse(...)");
            C2(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J2(PhotoViewerActivity photoViewerActivity, Uri uri) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        if (uri != null && photoViewerActivity.list.size() == 1) {
            photoViewerActivity.C2(uri);
        }
        return C19938rB7.a;
    }

    private final void K2() {
        Window window = getWindow();
        window.addFlags(RecyclerView.UNDEFINED_DURATION);
        window.setStatusBarColor(AbstractC4043Dl1.c(this, R.color.black));
    }

    private final void O1() {
        C16335l6 c16335l6 = null;
        this.snapHelper.b(null);
        u uVar = this.snapHelper;
        C16335l6 c16335l62 = this.binding;
        if (c16335l62 == null) {
            AbstractC13042fc3.y("binding");
            c16335l62 = null;
        }
        uVar.b(c16335l62.j);
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l63;
        }
        RecyclerViewFixMotionLayout recyclerViewFixMotionLayout = c16335l6.j;
        AbstractC13042fc3.h(recyclerViewFixMotionLayout, "photoRecycler");
        UK5.b(recyclerViewFixMotionLayout, this.snapHelper, null, new b(), 2, null);
    }

    private final void O2() {
        Window window = getWindow();
        window.addFlags(RecyclerView.UNDEFINED_DURATION);
        window.setStatusBarColor(AbstractC4043Dl1.c(this, R.color.transparent));
    }

    private final void P1() {
        n2();
        C16335l6 c16335l6 = this.binding;
        C16335l6 c16335l62 = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.e.setMovementMethod(new ScrollingMovementMethod());
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
            c16335l63 = null;
        }
        g1(c16335l63.c);
        i2(this);
        C16335l6 c16335l64 = this.binding;
        if (c16335l64 == null) {
            AbstractC13042fc3.y("binding");
            c16335l64 = null;
        }
        c16335l64.d.setVisibility(8);
        C16335l6 c16335l65 = this.binding;
        if (c16335l65 == null) {
            AbstractC13042fc3.y("binding");
            c16335l65 = null;
        }
        RecyclerViewFixMotionLayout recyclerViewFixMotionLayout = c16335l65.j;
        a aVar = this.adapter;
        if (aVar == null) {
            AbstractC13042fc3.y("adapter");
            aVar = null;
        }
        recyclerViewFixMotionLayout.setAdapter(aVar);
        O1();
        a aVar2 = this.adapter;
        if (aVar2 == null) {
            AbstractC13042fc3.y("adapter");
            aVar2 = null;
        }
        aVar2.notifyDataSetChanged();
        C16335l6 c16335l66 = this.binding;
        if (c16335l66 == null) {
            AbstractC13042fc3.y("binding");
            c16335l66 = null;
        }
        c16335l66.j.scrollToPosition(0);
        C16335l6 c16335l67 = this.binding;
        if (c16335l67 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l62 = c16335l67;
        }
        RecyclerView.m itemAnimator = c16335l62.j.getItemAnimator();
        if (itemAnimator instanceof x) {
            x xVar = (x) itemAnimator;
            xVar.x(0L);
            xVar.w(0L);
            xVar.z(0L);
            xVar.A(0L);
            xVar.V(false);
        }
    }

    private final void P2(View view, float alpha) {
        view.animate().translationY(alpha).setDuration(200L);
    }

    private final void Q1(float currentAlpha, boolean isCaptionEnabled) {
        C16335l6 c16335l6 = null;
        if (currentAlpha != 1.0f) {
            C16335l6 c16335l62 = this.binding;
            if (c16335l62 == null) {
                AbstractC13042fc3.y("binding");
                c16335l62 = null;
            }
            BaleToolbar baleToolbar = c16335l62.n;
            AbstractC13042fc3.h(baleToolbar, "tlPhotoViewer");
            B2(baleToolbar, 1.0f);
            C16335l6 c16335l63 = this.binding;
            if (c16335l63 == null) {
                AbstractC13042fc3.y("binding");
                c16335l63 = null;
            }
            BaleToolbar baleToolbar2 = c16335l63.n;
            AbstractC13042fc3.h(baleToolbar2, "tlPhotoViewer");
            P2(baleToolbar2, 0.0f);
            if (isCaptionEnabled) {
                C16335l6 c16335l64 = this.binding;
                if (c16335l64 == null) {
                    AbstractC13042fc3.y("binding");
                    c16335l64 = null;
                }
                Toolbar toolbar = c16335l64.d;
                AbstractC13042fc3.h(toolbar, "captionToolbar");
                B2(toolbar, 1.0f);
                C16335l6 c16335l65 = this.binding;
                if (c16335l65 == null) {
                    AbstractC13042fc3.y("binding");
                    c16335l65 = null;
                }
                Toolbar toolbar2 = c16335l65.d;
                AbstractC13042fc3.h(toolbar2, "captionToolbar");
                P2(toolbar2, 0.0f);
            }
            C16335l6 c16335l66 = this.binding;
            if (c16335l66 == null) {
                AbstractC13042fc3.y("binding");
                c16335l66 = null;
            }
            Toolbar toolbar3 = c16335l66.c;
            AbstractC13042fc3.h(toolbar3, "bottomToolbar");
            B2(toolbar3, 1.0f);
            C16335l6 c16335l67 = this.binding;
            if (c16335l67 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c16335l6 = c16335l67;
            }
            Toolbar toolbar4 = c16335l6.c;
            AbstractC13042fc3.h(toolbar4, "bottomToolbar");
            P2(toolbar4, 0.0f);
            return;
        }
        C16335l6 c16335l68 = this.binding;
        if (c16335l68 == null) {
            AbstractC13042fc3.y("binding");
            c16335l68 = null;
        }
        BaleToolbar baleToolbar3 = c16335l68.n;
        AbstractC13042fc3.h(baleToolbar3, "tlPhotoViewer");
        B2(baleToolbar3, 0.0f);
        C16335l6 c16335l69 = this.binding;
        if (c16335l69 == null) {
            AbstractC13042fc3.y("binding");
            c16335l69 = null;
        }
        BaleToolbar baleToolbar4 = c16335l69.n;
        AbstractC13042fc3.h(baleToolbar4, "tlPhotoViewer");
        C16335l6 c16335l610 = this.binding;
        if (c16335l610 == null) {
            AbstractC13042fc3.y("binding");
            c16335l610 = null;
        }
        P2(baleToolbar4, c16335l610.i.getHeight() * (-1));
        if (isCaptionEnabled) {
            C16335l6 c16335l611 = this.binding;
            if (c16335l611 == null) {
                AbstractC13042fc3.y("binding");
                c16335l611 = null;
            }
            Toolbar toolbar5 = c16335l611.d;
            AbstractC13042fc3.h(toolbar5, "captionToolbar");
            B2(toolbar5, 0.0f);
            C16335l6 c16335l612 = this.binding;
            if (c16335l612 == null) {
                AbstractC13042fc3.y("binding");
                c16335l612 = null;
            }
            Toolbar toolbar6 = c16335l612.d;
            AbstractC13042fc3.h(toolbar6, "captionToolbar");
            C16335l6 c16335l613 = this.binding;
            if (c16335l613 == null) {
                AbstractC13042fc3.y("binding");
                c16335l613 = null;
            }
            P2(toolbar6, c16335l613.i.getHeight());
        }
        C16335l6 c16335l614 = this.binding;
        if (c16335l614 == null) {
            AbstractC13042fc3.y("binding");
            c16335l614 = null;
        }
        Toolbar toolbar7 = c16335l614.c;
        AbstractC13042fc3.h(toolbar7, "bottomToolbar");
        B2(toolbar7, 0.0f);
        C16335l6 c16335l615 = this.binding;
        if (c16335l615 == null) {
            AbstractC13042fc3.y("binding");
            c16335l615 = null;
        }
        Toolbar toolbar8 = c16335l615.c;
        AbstractC13042fc3.h(toolbar8, "bottomToolbar");
        C16335l6 c16335l616 = this.binding;
        if (c16335l616 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l616;
        }
        P2(toolbar8, c16335l6.i.getHeight());
    }

    private final void Q2(boolean isCaptionEnabled) {
        C16335l6 c16335l6 = this.binding;
        C16335l6 c16335l62 = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.n.setAlpha(1.0f);
        if (isCaptionEnabled) {
            C16335l6 c16335l63 = this.binding;
            if (c16335l63 == null) {
                AbstractC13042fc3.y("binding");
                c16335l63 = null;
            }
            c16335l63.d.setAlpha(1.0f);
        }
        C16335l6 c16335l64 = this.binding;
        if (c16335l64 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l62 = c16335l64;
        }
        c16335l62.c.setAlpha(1.0f);
    }

    private final String S1(int color) {
        String string = getString(color);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final void S2() {
        C21753u45.O0(C21753u45.a, this, this.PERMISSIONS_REQUEST_STORAGE, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
    }

    private final void T1() {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        final BaleToolbar baleToolbar = c16335l6.n;
        baleToolbar.y(AbstractC15226jD5.more_menu);
        baleToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.wb5
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return PhotoViewerActivity.Y1(baleToolbar, menuItem);
            }
        });
        final ArrayList arrayList = new ArrayList();
        if (!this.isFromSharedMedia) {
            String string = getString(AbstractC12217eE5.ShowAllMedia);
            AbstractC13042fc3.h(string, "getString(...)");
            arrayList.add(new C18684p44(1, string, 0, C5495Jo7.a.d2(), 0, 0));
        }
        String string2 = getString(AbstractC12217eE5.SaveToGallery);
        AbstractC13042fc3.h(string2, "getString(...)");
        arrayList.add(new C18684p44(2, string2, 0, C5495Jo7.a.d2(), 0, 0));
        baleToolbar.l0(BC5.more_item, arrayList, new AdapterView.OnItemClickListener() { // from class: ir.nasim.xb5
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                PhotoViewerActivity.W1(baleToolbar, arrayList, this, adapterView, view, i, j);
            }
        });
    }

    private final void T2() {
        C11458d25 c11458d25 = this.peer;
        if (c11458d25 == null) {
            AbstractC13042fc3.y("peer");
            c11458d25 = null;
        }
        Context applicationContext = getApplicationContext();
        AbstractC13042fc3.h(applicationContext, "getApplicationContext(...)");
        startActivity(C22055ub3.k(c11458d25, applicationContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.designsystem.photoviewer.c U2(PhotoViewerActivity photoViewerActivity) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        return (ir.nasim.designsystem.photoviewer.c) new G(photoViewerActivity).b(ir.nasim.designsystem.photoviewer.c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(BaleToolbar baleToolbar, ArrayList arrayList, PhotoViewerActivity photoViewerActivity, AdapterView adapterView, View view, int i, long j) {
        AbstractC13042fc3.i(baleToolbar, "$this_with");
        AbstractC13042fc3.i(arrayList, "$items");
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        baleToolbar.getPopupWindow().dismiss();
        int iD = ((C18684p44) arrayList.get(i)).d();
        if (iD == 1) {
            photoViewerActivity.T2();
            return;
        }
        if (iD != 2) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 29 && !C5505Jq.F()) {
            photoViewerActivity.S2();
            return;
        }
        ir.nasim.designsystem.photoviewer.c cVarF2 = photoViewerActivity.f2();
        Photo photo = photoViewerActivity.selectedItem;
        if (photo == null) {
            AbstractC13042fc3.y("selectedItem");
            photo = null;
        }
        cVarF2.h1(photo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y1(BaleToolbar baleToolbar, MenuItem menuItem) {
        AbstractC13042fc3.i(baleToolbar, "$this_with");
        AbstractC13042fc3.i(menuItem, "item");
        if (menuItem.getItemId() != BC5.more_item) {
            return false;
        }
        baleToolbar.getPopupWindow().setInputMethodMode(2);
        baleToolbar.getPopupWindow().show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Spannable a2(int position) {
        if (this.list.size() >= 1) {
            Photo photo = this.selectedItem;
            if (photo == null) {
                AbstractC13042fc3.y("selectedItem");
                photo = null;
            }
            if (!AbstractC12171e95.a(photo)) {
                int i = this.selectedPosition;
                if (position < i) {
                    this.currentIndex--;
                } else if (position > i) {
                    this.currentIndex++;
                }
                String string = getString(AbstractC12217eE5.Of, Integer.valueOf(this.currentIndex), Integer.valueOf(this.peerImageCount));
                AbstractC13042fc3.h(string, "getString(...)");
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new ForegroundColorSpan(C5495Jo7.a.l2()), 0, string.length(), 18);
                return spannableString;
            }
        }
        return new SpannableString("");
    }

    private final void b2(final Photo photo) {
        if (AbstractC12171e95.a(photo)) {
            return;
        }
        f2().i1(photo.getTimeStamp()).j(this, new d(new UA2() { // from class: ir.nasim.tb5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PhotoViewerActivity.d2(this.a, photo, (C7781Te0) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d2(PhotoViewerActivity photoViewerActivity, Photo photo, C7781Te0 c7781Te0) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        AbstractC13042fc3.i(photo, "$photo");
        photoViewerActivity.requestForwardBusy = false;
        photoViewerActivity.requestBackwardBusy = false;
        if (c7781Te0.b() != null && c7781Te0.b().size() > photoViewerActivity.list.size()) {
            int iC = c7781Te0.c() - 1;
            photoViewerActivity.peerImageCount = c7781Te0.a();
            int iIndexOf = c7781Te0.b().indexOf(photo);
            photoViewerActivity.selectedPosition = iIndexOf;
            if (iIndexOf == -1) {
                return C19938rB7.a;
            }
            photoViewerActivity.currentIndex = photoViewerActivity.peerImageCount - iC;
            photoViewerActivity.list.clear();
            photoViewerActivity.list.addAll(c7781Te0.b());
            a aVar = photoViewerActivity.adapter;
            C16335l6 c16335l6 = null;
            if (aVar == null) {
                AbstractC13042fc3.y("adapter");
                aVar = null;
            }
            aVar.notifyDataSetChanged();
            C16335l6 c16335l62 = photoViewerActivity.binding;
            if (c16335l62 == null) {
                AbstractC13042fc3.y("binding");
                c16335l62 = null;
            }
            c16335l62.j.scrollToPosition(photoViewerActivity.selectedPosition);
            C16335l6 c16335l63 = photoViewerActivity.binding;
            if (c16335l63 == null) {
                AbstractC13042fc3.y("binding");
            } else {
                c16335l6 = c16335l63;
            }
            c16335l6.n.setTitle(photoViewerActivity.a2(photoViewerActivity.selectedPosition));
        }
        return C19938rB7.a;
    }

    private final ir.nasim.designsystem.photoviewer.c f2() {
        return (ir.nasim.designsystem.photoviewer.c) this.viewModel.getValue();
    }

    private final void g2() {
        C16335l6 c16335l6 = this.binding;
        C16335l6 c16335l62 = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.n.setAlpha(0.0f);
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
            c16335l63 = null;
        }
        c16335l63.d.setAlpha(0.0f);
        C16335l6 c16335l64 = this.binding;
        if (c16335l64 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l62 = c16335l64;
        }
        c16335l62.c.setAlpha(0.0f);
    }

    private final void i2(Context context) {
        C16335l6 c16335l6 = this.binding;
        Photo photo = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        BaleToolbar baleToolbar = c16335l6.n;
        baleToolbar.setBackgroundColor(AbstractC4043Dl1.c(context, TA5.t2));
        baleToolbar.setTitle(a2(0));
        baleToolbar.setTitleCentered(false);
        BaleToolbar.setHasBackButton$default(baleToolbar, this, true, false, 4, null);
        Photo photo2 = this.selectedItem;
        if (photo2 == null) {
            AbstractC13042fc3.y("selectedItem");
        } else {
            photo = photo2;
        }
        if (AbstractC12171e95.a(photo)) {
            return;
        }
        T1();
    }

    private final void j2() {
        VI2 vi2B = OI2.b(C5721Ko.a.d());
        AbstractC13042fc3.h(vi2B, "with(...)");
        a aVar = new a(vi2B);
        this.adapter = aVar;
        aVar.D(this.list);
        a aVar2 = this.adapter;
        a aVar3 = null;
        if (aVar2 == null) {
            AbstractC13042fc3.y("adapter");
            aVar2 = null;
        }
        aVar2.G(this);
        a aVar4 = this.adapter;
        if (aVar4 == null) {
            AbstractC13042fc3.y("adapter");
            aVar4 = null;
        }
        aVar4.E(this);
        a aVar5 = this.adapter;
        if (aVar5 == null) {
            AbstractC13042fc3.y("adapter");
            aVar5 = null;
        }
        aVar5.F(this);
        f2().e1().j(this, new d(new UA2() { // from class: ir.nasim.sb5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PhotoViewerActivity.k2(this.a, (Boolean) obj);
            }
        }));
        a aVar6 = this.adapter;
        if (aVar6 == null) {
            AbstractC13042fc3.y("adapter");
        } else {
            aVar3 = aVar6;
        }
        aVar3.setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k2(PhotoViewerActivity photoViewerActivity, Boolean bool) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        a aVar = photoViewerActivity.adapter;
        if (aVar == null) {
            AbstractC13042fc3.y("adapter");
            aVar = null;
        }
        aVar.C(bool.booleanValue());
        return C19938rB7.a;
    }

    private final void l2() {
        if (getIntent().hasExtra("PEER_UNIQUE_ID_PARAM")) {
            this.peerUniqueId = getIntent().getLongExtra("PEER_UNIQUE_ID_PARAM", 0L);
            Parcelable parcelableExtra = getIntent().getParcelableExtra("FIRST_SELECTED_PHOTO");
            AbstractC13042fc3.g(parcelableExtra, "null cannot be cast to non-null type ir.nasim.designsystem.photoviewer.data.Photo");
            Photo photo = (Photo) parcelableExtra;
            this.list.add(photo);
            this.selectedItem = photo;
        }
        if (getIntent().hasExtra("EX_PEER_TYPE")) {
            this.exPeerType = ExPeerType.fromValue(getIntent().getIntExtra("EX_PEER_TYPE", 0));
        }
        this.isFromSharedMedia = getIntent().getBooleanExtra("IS_FROM_SHARED_MEDIA", false);
        this.peer = C11458d25.r(this.peerUniqueId);
        this.colors = new String[]{S1(TA5.placeholder_0), S1(TA5.placeholder_1), S1(TA5.placeholder_2), S1(TA5.placeholder_3), S1(TA5.placeholder_4), S1(TA5.placeholder_5), S1(TA5.placeholder_6)};
    }

    private final void n2() {
        C16335l6 c16335l6 = this.binding;
        C16335l6 c16335l62 = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.m.setBackgroundColor(-16777216);
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
            c16335l63 = null;
        }
        c16335l63.m.setCallback(this);
        C16335l6 c16335l64 = this.binding;
        if (c16335l64 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l62 = c16335l64;
        }
        c16335l62.m.setPullDownEnable(true);
    }

    private final void o2() {
        String path;
        Intent intentH;
        Photo photo = this.selectedItem;
        Photo photo2 = null;
        if (photo == null) {
            AbstractC13042fc3.y("selectedItem");
            photo = null;
        }
        String caption = photo.getCaption();
        Photo photo3 = this.selectedItem;
        if (photo3 == null) {
            AbstractC13042fc3.y("selectedItem");
        } else {
            photo2 = photo3;
        }
        Uri uri = Uri.parse(photo2.getPhotoUri());
        if (uri == null || (path = uri.getPath()) == null || (intentH = C22055ub3.a.h(this, "image/jpeg", path, caption)) == null) {
            return;
        }
        startActivity(Intent.createChooser(intentH, getString(AbstractC12217eE5.menu_share)));
        finish();
    }

    private final CharSequence p2(String caption) throws UnsupportedEncodingException {
        String strDecode;
        C16335l6 c16335l6 = null;
        if (caption == null || caption.length() == 0) {
            return null;
        }
        try {
            strDecode = URLDecoder.decode(caption, "UTF-8");
        } catch (Exception unused) {
            strDecode = null;
        }
        if (strDecode != null) {
            caption = strDecode;
        }
        Spannable spannableF = AbstractC5730Kp.f(caption, null, null, null);
        if (spannableF == null || spannableF.length() == 0) {
            return spannableF;
        }
        C16335l6 c16335l62 = this.binding;
        if (c16335l62 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l62;
        }
        return R62.W(spannableF, c16335l6.e.getPaint().getFontMetricsInt(), AbstractC7426Rr.a.f(14.0f), false, null, null, 48, null);
    }

    private final void q2() {
        QI2 qi2 = QI2.a;
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        RoundedImageView roundedImageView = c16335l6.b;
        AbstractC13042fc3.h(roundedImageView, "avatarImg");
        qi2.a(roundedImageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(long date) {
        this.requestBackwardBusy = true;
        f2().j1(date, EnumC19631qg6.b).j(this, new d(new UA2() { // from class: ir.nasim.vb5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PhotoViewerActivity.v2(this.a, (C7781Te0) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v2(PhotoViewerActivity photoViewerActivity, C7781Te0 c7781Te0) {
        AbstractC13042fc3.i(photoViewerActivity, "this$0");
        boolean z = false;
        if (!c7781Te0.d()) {
            List listB = c7781Te0.b();
            if (listB == null || listB.isEmpty()) {
                z = true;
            } else {
                photoViewerActivity.list.addAll(0, AbstractC15401jX0.T0(c7781Te0.b()));
                a aVar = photoViewerActivity.adapter;
                if (aVar == null) {
                    AbstractC13042fc3.y("adapter");
                    aVar = null;
                }
                aVar.notifyItemRangeInserted(0, c7781Te0.b().size());
                photoViewerActivity.selectedPosition += c7781Te0.b().size();
            }
        }
        photoViewerActivity.requestBackwardBusy = z;
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(long date) {
        this.requestForwardBusy = true;
        f2().j1(date, EnumC19631qg6.a).j(this, new d(new UA2() { // from class: ir.nasim.zb5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return PhotoViewerActivity.A2(this.a, (C7781Te0) obj);
            }
        }));
    }

    @Override // ir.nasim.designsystem.photoviewer.a.b
    public void A() {
        C21753u45.O0(C21753u45.a, this, 0, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
    }

    @Override // ir.nasim.designsystem.photoviewer.a.InterfaceC1021a
    public void J(int position, Photo photo) {
        AbstractC13042fc3.i(photo, "photo");
        Photo photoY0 = f2().Y0(photo);
        this.list.set(position, photoY0);
        a aVar = this.adapter;
        if (aVar == null) {
            AbstractC13042fc3.y("adapter");
            aVar = null;
        }
        aVar.notifyItemChanged(position, photoY0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        AbstractC13042fc3.i(newBase, "newBase");
        super.attachBaseContext(PH3.h(newBase));
    }

    @Override // ir.nasim.designsystem.PullBackLayout.a
    public void g() {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        this.isVisibleBars = c16335l6.n.getAlpha() == 1.0f;
    }

    @Override // ir.nasim.designsystem.photoviewer.a.InterfaceC1021a
    public void k(int position, Photo photo) {
        AbstractC13042fc3.i(photo, "photo");
        f2().Z0(photo, new c(position));
    }

    @Override // ir.nasim.designsystem.photoviewer.Hilt_PhotoViewerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) throws Resources.NotFoundException, UnsupportedEncodingException {
        C6011Lu2.m(this);
        PH3.h(this);
        super.onCreate(savedInstanceState);
        C16335l6 c16335l6C = C16335l6.c(getLayoutInflater());
        this.binding = c16335l6C;
        if (c16335l6C == null) {
            AbstractC13042fc3.y("binding");
            c16335l6C = null;
        }
        setContentView(c16335l6C.getRoot());
        l2();
        j2();
        P1();
        I2(true);
        Object obj = this.list.get(0);
        AbstractC13042fc3.h(obj, "get(...)");
        b2((Photo) obj);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        AbstractC13042fc3.h(menuInflater, "getMenuInflater(...)");
        menuInflater.inflate(AbstractC15226jD5.photo_viewer_bottom, menu);
        this.itemShareMenu = menu != null ? menu.findItem(BC5.shareMenuItem) : null;
        return true;
    }

    @Override // ir.nasim.designsystem.photoviewer.Hilt_PhotoViewerActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C16335l6 c16335l6 = this.binding;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        c16335l6.j.setAdapter(null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        AbstractC13042fc3.i(item, "item");
        if (item.getItemId() != BC5.shareMenuItem) {
            return true;
        }
        o2();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode == this.PERMISSIONS_REQUEST_STORAGE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                Photo photo = this.selectedItem;
                if (photo == null) {
                    AbstractC13042fc3.y("selectedItem");
                    photo = null;
                }
                C6906Pm2.A(photo.getPhotoPath(), getApplicationContext(), 0, null, null);
            }
        }
    }

    @Override // ir.nasim.designsystem.PullBackLayout.a
    public void u(float progress) {
        C16335l6 c16335l6 = null;
        if (progress == 0.0f) {
            K2();
            if (this.isVisibleBars) {
                C16335l6 c16335l62 = this.binding;
                if (c16335l62 == null) {
                    AbstractC13042fc3.y("binding");
                    c16335l62 = null;
                }
                Q2(c16335l62.e.getText() != null);
            }
        } else {
            if (this.isVisibleBars) {
                O2();
            }
            g2();
        }
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l6 = c16335l63;
        }
        c16335l6.m.setBackgroundColor(progress == 0.0f ? -16777216 : 0);
    }

    @Override // ir.nasim.designsystem.photoviewer.a.c
    public void v() {
        C16335l6 c16335l6 = this.binding;
        C16335l6 c16335l62 = null;
        if (c16335l6 == null) {
            AbstractC13042fc3.y("binding");
            c16335l6 = null;
        }
        float alpha = c16335l6.c.getAlpha();
        C16335l6 c16335l63 = this.binding;
        if (c16335l63 == null) {
            AbstractC13042fc3.y("binding");
        } else {
            c16335l62 = c16335l63;
        }
        Q1(alpha, c16335l62.e.getText() != null);
    }

    @Override // ir.nasim.designsystem.PullBackLayout.a
    public void y() {
        K2();
    }

    @Override // ir.nasim.designsystem.PullBackLayout.a
    public void z() {
        P0();
    }
}
