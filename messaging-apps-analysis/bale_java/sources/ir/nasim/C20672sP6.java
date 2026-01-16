package ir.nasim;

import ai.bale.proto.PeersStruct$ExPeer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.j;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14486i0;
import ir.nasim.C20672sP6;
import ir.nasim.C21753u45;
import ir.nasim.D20;
import ir.nasim.EnumC20117rV6;
import ir.nasim.FQ6;
import ir.nasim.InterfaceC10294bP6;
import ir.nasim.InterfaceC10891cN5;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.KW3;
import ir.nasim.RV6;
import ir.nasim.TC2;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.media.components.PhotoViewerBridge;
import ir.nasim.features.payment.view.fragment.y;
import ir.nasim.story.model.StoryWidget;
import ir.nasim.story.ui.storyadder.StoryAdderBottomSheet;
import ir.nasim.story.ui.storyadder.StoryAdderSourceCallerEnum;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.messenger.Utilities;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000b*\u0002\u0099\u0001\b\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002¡\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\u0003J\u000f\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0003J\u000f\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\u0003J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0003J\u000f\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010\u0003J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\u0003J3\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00040\u0019H\u0002¢\u0006\u0004\b1\u00102J+\u0010:\u001a\u0002092\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\u0003J!\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u0002092\b\u00108\u001a\u0004\u0018\u000107H\u0016¢\u0006\u0004\b>\u0010?J/\u0010E\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\r2\u000e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0A2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ)\u0010J\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0004H\u0016¢\u0006\u0004\bL\u0010\u0003J\u000f\u0010M\u001a\u00020\u0004H\u0016¢\u0006\u0004\bM\u0010\u0003J\u000f\u0010N\u001a\u00020\u0004H\u0016¢\u0006\u0004\bN\u0010\u0003J\u000f\u0010O\u001a\u00020\u0004H\u0016¢\u0006\u0004\bO\u0010\u0003J\u000f\u0010P\u001a\u00020\u0004H\u0016¢\u0006\u0004\bP\u0010\u0003J\u000f\u0010Q\u001a\u00020\u0004H\u0016¢\u0006\u0004\bQ\u0010\u0003R\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\"\u0010c\u001a\u00020\\8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0016\u0010/\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010X\u001a\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010lR\u0014\u0010r\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010t\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\bs\u0010qR\u0014\u0010v\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\bu\u0010qR\u0014\u0010x\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\bw\u0010qR\u0014\u0010z\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\by\u0010qR\u0014\u0010|\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\b{\u0010qR\u0014\u0010~\u001a\u00020\r8\u0002X\u0082D¢\u0006\u0006\n\u0004\b}\u0010qR\u0015\u0010\u0080\u0001\u001a\u00020-8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u007f\u0010lR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R*\u0010\u008c\u0001\u001a\u00030\u0085\u00018\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R \u0010\u0098\u0001\u001a\t\u0012\u0004\u0012\u00020-0\u0095\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u009c\u0001\u001a\u00030\u0099\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0017\u0010\u009f\u0001\u001a\u00020R8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001¨\u0006£\u0001²\u0006\u000f\u0010¢\u0001\u001a\u00020\u001a8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lir/nasim/sP6;", "Lir/nasim/ua0;", "<init>", "()V", "Lir/nasim/rB7;", "hb", "Ua", "Lir/nasim/gj3;", "Ha", "()Lir/nasim/gj3;", "qb", "Ga", "xa", "", "Fa", "()I", "Aa", "Lir/nasim/fU6;", "Na", "()Lir/nasim/fU6;", "bridge", "ua", "(Lir/nasim/fU6;)Lir/nasim/gj3;", "Lir/nasim/tgwidgets/editor/ui/stories/recorder/l;", "entry", "Lkotlin/Function1;", "", "result", "eb", "(Lir/nasim/tgwidgets/editor/ui/stories/recorder/l;Lir/nasim/UA2;)V", "Wa", "Da", "Ea", "ta", "Ba", "Ca", "Ya", "Xa", "mb", "kb", "ib", "jb", "va", "pb", "wa", "", "path", "isVideo", "onDone", "gb", "(Ljava/lang/String;ZLir/nasim/UA2;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "i9", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "requestCode", "", "permissions", "", "grantResults", "g7", "(I[Ljava/lang/String;[I)V", "resultCode", "Landroid/content/Intent;", "data", "H6", "(IILandroid/content/Intent;)V", "U6", "c7", "a1", "h7", "S0", "T6", "Lir/nasim/vz2;", "h1", "Lir/nasim/vz2;", "_binding", "Lir/nasim/bX6;", "i1", "Lir/nasim/Yu3;", "Va", "()Lir/nasim/bX6;", "viewModel", "Lai/bale/proto/PeersStruct$ExPeer;", "j1", "Lai/bale/proto/PeersStruct$ExPeer;", "La", "()Lai/bale/proto/PeersStruct$ExPeer;", "lb", "(Lai/bale/proto/PeersStruct$ExPeer;)V", "exPeer", "k1", "Z", "Lir/nasim/n10;", "l1", "Ka", "()Lir/nasim/n10;", "errorSnackBar", "m1", "Ljava/lang/String;", "photoFile", "n1", "videoFile", "o1", TokenNames.I, "REQUEST_MERGE_CAMERA_PHOTO_VIDEO", "p1", "REQUEST_PHOTO_EDITOR", "q1", "PERMISSIONS_REQUEST_CAMERA_PHOTO", "r1", "PERMISSIONS_REQUEST_CAMERA_VIDEO", "s1", "PERMISSIONS_REQUEST_CAMERA_PHOTO_AND_VIDEO", "t1", "PERMISSIONS_REQUEST_STORAGE_FOR_DOCUMENT", "u1", "PERMISSIONS_REQUEST_STORAGE_FOR_TEXT", "v1", "EXTRA_EDITED_IMAGE_URI", "Lir/nasim/story/ui/storyadder/StoryAdderSourceCallerEnum;", "w1", "Lir/nasim/story/ui/storyadder/StoryAdderSourceCallerEnum;", "sourceCallerEnum", "Lir/nasim/kD2;", "x1", "Lir/nasim/kD2;", "Ma", "()Lir/nasim/kD2;", "setGalleryNavigator", "(Lir/nasim/kD2;)V", "galleryNavigator", "Lcom/google/android/material/bottomsheet/b;", "y1", "Lcom/google/android/material/bottomsheet/b;", "galleryFragment", "Lir/nasim/I35;", "z1", "Lir/nasim/I35;", "permissionResultCallback", "Lir/nasim/v6;", "A1", "Lir/nasim/v6;", "requestPermissionLauncher", "ir/nasim/sP6$e", "B1", "Lir/nasim/sP6$e;", "onSuggestionClick", "Ja", "()Lir/nasim/vz2;", "binding", "C1", "a", "isVisible", "story_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.sP6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20672sP6 extends QX2 {

    /* renamed from: C1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int D1 = 8;

    /* renamed from: A1, reason: from kotlin metadata */
    private AbstractC22357v6 requestPermissionLauncher;

    /* renamed from: h1, reason: from kotlin metadata */
    private C22886vz2 _binding;

    /* renamed from: j1, reason: from kotlin metadata */
    public PeersStruct$ExPeer exPeer;

    /* renamed from: k1, reason: from kotlin metadata */
    private boolean isVideo;

    /* renamed from: m1, reason: from kotlin metadata */
    private String photoFile;

    /* renamed from: n1, reason: from kotlin metadata */
    private String videoFile;

    /* renamed from: w1, reason: from kotlin metadata */
    private StoryAdderSourceCallerEnum sourceCallerEnum;

    /* renamed from: x1, reason: from kotlin metadata */
    public InterfaceC15814kD2 galleryNavigator;

    /* renamed from: y1, reason: from kotlin metadata */
    private com.google.android.material.bottomsheet.b galleryFragment;

    /* renamed from: i1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rP6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C20672sP6.rb(this.a);
        }
    });

    /* renamed from: l1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 errorSnackBar = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.dP6
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C20672sP6.Ia(this.a);
        }
    });

    /* renamed from: o1, reason: from kotlin metadata */
    private final int REQUEST_MERGE_CAMERA_PHOTO_VIDEO = 1;

    /* renamed from: p1, reason: from kotlin metadata */
    private final int REQUEST_PHOTO_EDITOR = 4;

    /* renamed from: q1, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_CAMERA_PHOTO = 6;

    /* renamed from: r1, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_CAMERA_VIDEO = 66;

    /* renamed from: s1, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_CAMERA_PHOTO_AND_VIDEO = 6666;

    /* renamed from: t1, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_STORAGE_FOR_DOCUMENT = 3011;

    /* renamed from: u1, reason: from kotlin metadata */
    private final int PERMISSIONS_REQUEST_STORAGE_FOR_TEXT = 3012;

    /* renamed from: v1, reason: from kotlin metadata */
    private final String EXTRA_EDITED_IMAGE_URI = "EXTRA_EDITED_IMAGE_URI";

    /* renamed from: z1, reason: from kotlin metadata */
    private final I35 permissionResultCallback = new I35();

    /* renamed from: B1, reason: from kotlin metadata */
    private final e onSuggestionClick = new e();

    /* renamed from: ir.nasim.sP6$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C20672sP6 a(StoryAdderSourceCallerEnum storyAdderSourceCallerEnum) {
            AbstractC13042fc3.i(storyAdderSourceCallerEnum, "sourceCallerEnum");
            C20672sP6 c20672sP6 = new C20672sP6();
            Bundle bundle = new Bundle();
            bundle.putParcelable("SOURCE_CALLER_ENUM_ARG", storyAdderSourceCallerEnum);
            c20672sP6.a8(bundle);
            return c20672sP6;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sP6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C12971fU6 e;

        /* renamed from: ir.nasim.sP6$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C12971fU6 d;
            final /* synthetic */ C20672sP6 e;
            final /* synthetic */ InterfaceC20315ro1 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C12971fU6 c12971fU6, C20672sP6 c20672sP6, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c12971fU6;
                this.e = c20672sP6;
                this.f = interfaceC20315ro1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(C20672sP6 c20672sP6) {
                c20672sP6.Va().V5();
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                InterfaceC10891cN5 interfaceC10891cN5 = (InterfaceC10891cN5) this.c;
                if (interfaceC10891cN5 instanceof InterfaceC10891cN5.c) {
                    C12971fU6 c12971fU6 = this.d;
                    EnumC20117rV6.a aVar = EnumC20117rV6.h;
                    InterfaceC10891cN5.c cVar = (InterfaceC10891cN5.c) interfaceC10891cN5;
                    c12971fU6.D(aVar.a(((C21346tV6) cVar.a()).b()), false, false);
                    if (!this.e.Va().t4()) {
                        EnumC20117rV6 enumC20117rV6A = aVar.a(((C21346tV6) cVar.a()).b());
                        if (enumC20117rV6A == null) {
                            return C19938rB7.a;
                        }
                        C12971fU6 c12971fU62 = this.d;
                        String strH6 = this.e.h6(enumC20117rV6A.y());
                        AbstractC13042fc3.h(strH6, "getString(...)");
                        final C20672sP6 c20672sP6 = this.e;
                        c12971fU62.E(strH6, new SA2() { // from class: ir.nasim.tP6
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return C20672sP6.b.a.y(c20672sP6);
                            }
                        });
                    }
                    AbstractC20906so1.d(this.f, null, 1, null);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC10891cN5 interfaceC10891cN5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC10891cN5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C12971fU6 c12971fU6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = c12971fU6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = C20672sP6.this.new b(this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2T6 = C20672sP6.this.Va().t6();
                a aVar = new a(this.e, C20672sP6.this, interfaceC20315ro1, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2T6, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sP6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.sP6$c$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C20672sP6 a;

            a(C20672sP6 c20672sP6) {
                this.a = c20672sP6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(C19951rD2 c19951rD2, InterfaceC20295rm1 interfaceC20295rm1) throws IllegalArgumentException {
                MediaController.m mVarA;
                KW3 kw3 = (KW3) AbstractC15401jX0.s0(c19951rD2.a());
                if (kw3 != null) {
                    C20672sP6 c20672sP6 = this.a;
                    if (kw3 instanceof KW3.b) {
                        KW3.b bVar = (KW3.b) kw3;
                        IS7 is7B = IS7.b(bVar.b());
                        if (is7B == null) {
                            return C19938rB7.a;
                        }
                        mVarA = C10248bK5.a.b(bVar.b(), is7B.a());
                    } else {
                        mVarA = C10248bK5.a.a(kw3.b());
                    }
                    C12971fU6 c12971fU6Na = c20672sP6.Na();
                    ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVarR = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.r(mVarA, c20672sP6.Va().L4());
                    AbstractC13042fc3.h(lVarR, "fromPhotoEntry(...)");
                    C12971fU6.z(c12971fU6Na, lVarR, 0L, false, false, 14, null);
                }
                return C19938rB7.a;
            }
        }

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20672sP6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10040ay6 interfaceC10040ay6F3 = C20672sP6.this.Va().F3();
                a aVar = new a(C20672sP6.this);
                this.b = 1;
                if (interfaceC10040ay6F3.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sP6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.sP6$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C20672sP6 a;

            a(C20672sP6 c20672sP6) {
                this.a = c20672sP6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
                if (list != null) {
                    this.a.Va().u3(list);
                }
                return C19938rB7.a;
            }
        }

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20672sP6.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4R4 = C20672sP6.this.Va().r4();
                a aVar = new a(C20672sP6.this);
                this.b = 1;
                if (interfaceC9336Zm4R4.b(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.sP6$e */
    public static final class e implements InterfaceC15974kV0 {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(C20672sP6 c20672sP6, String str) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            AbstractC13042fc3.i(str, "it");
            C22042ua0.A9(c20672sP6, RV6.v1.a(str, false, (56 & 4) != 0 ? false : true, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15974kV0
        public void a(FileReference fileReference) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            if (C8386Vt0.nb()) {
                C12971fU6 c12971fU6Na = C20672sP6.this.Na();
                C10248bK5 c10248bK5 = C10248bK5.a;
                String path = new File(C4053Dm2.u(), fileReference.getFileName()).getPath();
                AbstractC13042fc3.h(path, "getPath(...)");
                ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVarR = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.r(c10248bK5.a(path), C20672sP6.this.Va().L4());
                AbstractC13042fc3.h(lVarR, "fromPhotoEntry(...)");
                C12971fU6.z(c12971fU6Na, lVarR, 0L, false, false, 14, null);
                return;
            }
            if (C8386Vt0.jb()) {
                PhotoViewerAbs.getInstance(true);
                final C20672sP6 c20672sP6 = C20672sP6.this;
                c20672sP6.gb(C4053Dm2.u() + Separators.SLASH + fileReference.getFileName(), false, new UA2() { // from class: ir.nasim.uP6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return C20672sP6.e.c(c20672sP6, (String) obj);
                    }
                });
                return;
            }
            C22042ua0.A9(C20672sP6.this, RV6.v1.a(C4053Dm2.u() + Separators.SLASH + fileReference.getFileName(), false, (56 & 4) != 0 ? false : true, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
        }
    }

    /* renamed from: ir.nasim.sP6$f */
    static final class f implements InterfaceC14603iB2 {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.Da();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.ta();
            return C19938rB7.a;
        }

        private static final boolean o(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            C23144wQ6.a.g("click");
            c20672sP6.Ea();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.Q7().onBackPressed();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.Ya();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.Va().V4();
            C23144wQ6.a.b(EnumC17253mf2.b);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(C20672sP6 c20672sP6, InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
            y(interfaceC9102Ym4, false);
            c20672sP6.Va().s3();
            return C19938rB7.a;
        }

        private static final void y(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(C20672sP6 c20672sP6) {
            AbstractC13042fc3.i(c20672sP6, "this$0");
            c20672sP6.Aa();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            n((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void n(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-1797499102);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
                interfaceC22053ub1.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1.Q();
            boolean z = C20672sP6.this.La().getType() == EnumC10088b35.ExPeerType_PRIVATE;
            e eVar = C20672sP6.this.onSuggestionClick;
            interfaceC22053ub1.W(-1797480125);
            boolean zD = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP6 = C20672sP6.this;
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.vP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.z(c20672sP6);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa2 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797476772);
            boolean zD2 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP62 = C20672sP6.this;
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.wP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.A(c20672sP62);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa22 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797483453);
            boolean zD3 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP63 = C20672sP6.this;
            Object objB4 = interfaceC22053ub1.B();
            if (zD3 || objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.xP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.B(c20672sP63);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            SA2 sa23 = (SA2) objB4;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797473452);
            boolean zD4 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP64 = C20672sP6.this;
            Object objB5 = interfaceC22053ub1.B();
            if (zD4 || objB5 == aVar.a()) {
                objB5 = new SA2() { // from class: ir.nasim.yP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.p(c20672sP64);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            SA2 sa24 = (SA2) objB5;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797491118);
            boolean zD5 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP65 = C20672sP6.this;
            Object objB6 = interfaceC22053ub1.B();
            if (zD5 || objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.zP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.t(c20672sP65);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            SA2 sa25 = (SA2) objB6;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797487093);
            boolean zD6 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP66 = C20672sP6.this;
            Object objB7 = interfaceC22053ub1.B();
            if (zD6 || objB7 == aVar.a()) {
                objB7 = new SA2() { // from class: ir.nasim.AP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.v(c20672sP66);
                    }
                };
                interfaceC22053ub1.s(objB7);
            }
            SA2 sa26 = (SA2) objB7;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797466466);
            boolean zD7 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP67 = C20672sP6.this;
            Object objB8 = interfaceC22053ub1.B();
            if (zD7 || objB8 == aVar.a()) {
                objB8 = new SA2() { // from class: ir.nasim.BP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.w(c20672sP67);
                    }
                };
                interfaceC22053ub1.s(objB8);
            }
            interfaceC22053ub1.Q();
            C13636ga c13636ga = new C13636ga(sa2, sa22, sa23, sa24, sa25, sa26, (SA2) objB8, null, eVar, 128, null);
            int iFa = C20672sP6.this.Fa();
            boolean z2 = AbstractC10222bH6.b(C20672sP6.this.Va().o4(), null, interfaceC22053ub1, 0, 1).getValue() instanceof FQ6.b;
            String strC4 = C20672sP6.this.Va().C4();
            C20672sP6 c20672sP68 = C20672sP6.this;
            if (strC4.length() == 0) {
                strC4 = c20672sP68.Q7().getString(AbstractC12217eE5.story_suggested_backgrounds);
                AbstractC13042fc3.h(strC4, "getString(...)");
            }
            boolean zO = o(interfaceC9102Ym4);
            List listM = (List) AbstractC10222bH6.b(C20672sP6.this.Va().r4(), null, interfaceC22053ub1, 0, 1).getValue();
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            interfaceC22053ub1.W(-1797436102);
            List listM2 = C20672sP6.this.Va().E4() ? (List) AbstractC10222bH6.b(C20672sP6.this.Va().B4(), null, interfaceC22053ub1, 0, 1).getValue() : AbstractC10360bX0.m();
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1797446062);
            boolean zD8 = interfaceC22053ub1.D(C20672sP6.this);
            final C20672sP6 c20672sP69 = C20672sP6.this;
            Object objB9 = interfaceC22053ub1.B();
            if (zD8 || objB9 == aVar.a()) {
                objB9 = new SA2() { // from class: ir.nasim.CP6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C20672sP6.f.x(c20672sP69, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB9);
            }
            interfaceC22053ub1.Q();
            SP6.x(null, c13636ga, z, iFa, z2, strC4, (SA2) objB9, zO, listM, listM2, interfaceC22053ub1, 0, 1);
        }
    }

    /* renamed from: ir.nasim.sP6$g */
    public static final class g extends PhotoViewerAbs.EmptyPhotoViewerProviderAbs {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ UA2 b;

        g(ArrayList arrayList, UA2 ua2) {
            this.a = arrayList;
            this.b = ua2;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public boolean allowCaption() {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
            AbstractC13042fc3.i(h, "videoEditedInfo");
            Object obj = this.a.get(0);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.media.utils.MediaControllerUtility.PhotoEntry");
            AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) obj;
            String str = bVar.c;
            if (str == null && (str = bVar.A) == null) {
                str = "";
            }
            this.b.invoke(str);
        }
    }

    /* renamed from: ir.nasim.sP6$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.sP6$h$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C20672sP6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C20672sP6 c20672sP6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c20672sP6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                FQ6 fq6 = (FQ6) this.c;
                if (fq6 instanceof FQ6.d) {
                    C22042ua0.A9(this.d, RV6.v1.a(((FQ6.d) fq6).a().getDescriptor(), false, (56 & 4) != 0 ? false : false, (56 & 8) != 0 ? false : true, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
                    this.d.Va().R2();
                } else if (fq6 instanceof FQ6.a) {
                    C17468n10 c17468n10Ka = this.d.Ka();
                    String strH6 = this.d.h6(SD5.story_hafez_faal_loading_error);
                    AbstractC13042fc3.h(strH6, "getString(...)");
                    c17468n10Ka.o(strH6);
                    this.d.Va().R2();
                } else if (!AbstractC13042fc3.d(fq6, FQ6.b.a) && !AbstractC13042fc3.d(fq6, FQ6.c.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(FQ6 fq6, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(fq6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C20672sP6.this.new h(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 interfaceC10258bL6O4 = C20672sP6.this.Va().o4();
                a aVar = new a(C20672sP6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC10258bL6O4, aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa() {
        if (C8386Vt0.nb()) {
            C12971fU6.x(Na(), false, false, 3, null);
        } else {
            mb();
        }
    }

    private final void Ba() {
        if (AbstractC4043Dl1.a(Q7(), "android.permission.CAMERA") != 0 || AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            ib();
            return;
        }
        File fileZ3 = Va().z3(EnumC21310tR6.f.p());
        if (fileZ3 == null) {
            return;
        }
        this.photoFile = fileZ3.getAbsolutePath();
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", FileProvider.h(S7(), Q7().getPackageName() + ".provider", fileZ3));
        intent.addFlags(2);
        intent.addFlags(1);
        C22548vQ6 c22548vQ6M4 = Va().m4();
        if (c22548vQ6M4 != null) {
            Va().H5(new InterfaceC10294bP6.e(c22548vQ6M4.a()));
        }
        startActivityForResult(intent, this.REQUEST_MERGE_CAMERA_PHOTO_VIDEO);
    }

    private final void Ca() {
        if (AbstractC4043Dl1.a(Q7(), "android.permission.CAMERA") != 0 || AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.isVideo = true;
            ib();
            return;
        }
        File fileZ3 = Va().z3(EnumC21310tR6.e.p());
        if (fileZ3 == null) {
            return;
        }
        this.videoFile = fileZ3.getAbsolutePath();
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", FileProvider.h(S7(), Q7().getPackageName() + ".provider", fileZ3));
        intent.addFlags(2);
        intent.addFlags(1);
        C22548vQ6 c22548vQ6M4 = Va().m4();
        if (c22548vQ6M4 != null) {
            Va().H5(new InterfaceC10294bP6.h(c22548vQ6M4.a()));
        }
        startActivityForResult(intent, this.REQUEST_MERGE_CAMERA_PHOTO_VIDEO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Da() {
        va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ea() {
        wa();
        Va().u5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Fa() {
        int typeValue = La().getTypeValue();
        return typeValue != 2 ? typeValue != 3 ? AbstractC12217eE5.story_type_select_empty_state : AbstractC12217eE5.story_type_select_empty_state_channel : AbstractC12217eE5.story_type_select_empty_state_group;
    }

    private final void Ga() {
        xa();
    }

    private final InterfaceC13730gj3 Ha() {
        return AbstractC16751lo1.c(this, j.b.STARTED, new c(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C17468n10 Ia(C20672sP6 c20672sP6) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        ConstraintLayout root = c20672sP6.Ja().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C17468n10 c17468n10 = new C17468n10(root, null, 0, 6, null);
        c17468n10.k(c20672sP6.Ja().b);
        c17468n10.m(-1);
        return c17468n10;
    }

    private final C22886vz2 Ja() {
        C22886vz2 c22886vz2 = this._binding;
        AbstractC13042fc3.f(c22886vz2);
        return c22886vz2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C17468n10 Ka() {
        return (C17468n10) this.errorSnackBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12971fU6 Na() {
        C12971fU6 c12971fU6 = C12971fU6.a;
        AbstractC22357v6 abstractC22357v6 = this.requestPermissionLauncher;
        if (abstractC22357v6 == null) {
            AbstractC13042fc3.y("requestPermissionLauncher");
            abstractC22357v6 = null;
        }
        C12971fU6 c12971fU6V = c12971fU6.p(this, abstractC22357v6, this.permissionResultCallback, Va().L4()).r(new InterfaceC12261eJ4() { // from class: ir.nasim.mP6
            @Override // ir.nasim.InterfaceC12261eJ4
            public final void a(ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, UA2 ua2) throws IOException {
                C20672sP6.Sa(this.a, lVar, ua2);
            }
        }).t(new UA2() { // from class: ir.nasim.nP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.Oa(this.a, (StoryWidget.LinkWidget) obj);
            }
        }).s(new UA2() { // from class: ir.nasim.oP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.Pa(this.a, (StoryWidget.LinkWidget) obj);
            }
        }).u(new UA2() { // from class: ir.nasim.pP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.Qa(this.a, (C19526qV6) obj);
            }
        }).v(new UA2() { // from class: ir.nasim.qP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.Ra(this.a, ((Boolean) obj).booleanValue());
            }
        });
        ua(c12971fU6V);
        return c12971fU6V;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Oa(C20672sP6 c20672sP6, StoryWidget.LinkWidget linkWidget) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        C14153hR6.INSTANCE.a(linkWidget).K8(c20672sP6.Q7().B0(), null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Pa(C20672sP6 c20672sP6, StoryWidget.LinkWidget linkWidget) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        if (linkWidget == null) {
            return C19938rB7.a;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(linkWidget.a()));
        C18987pb3 c18987pb3 = C18987pb3.a;
        FragmentActivity fragmentActivityQ7 = c20672sP6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        if (!c18987pb3.k0(intent, fragmentActivityQ7)) {
            String strA = linkWidget.a();
            AbstractC7426Rr.a aVar = AbstractC7426Rr.a;
            Context contextS7 = c20672sP6.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            aVar.A(contextS7, Uri.parse(strA));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Qa(C20672sP6 c20672sP6, C19526qV6 c19526qV6) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(c19526qV6, "it");
        C17753nV6.INSTANCE.a(c19526qV6.d(), c19526qV6.e(), c19526qV6.f()).K8(c20672sP6.Q7().B0(), null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ra(C20672sP6 c20672sP6, boolean z) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        C22548vQ6 c22548vQ6M4 = c20672sP6.Va().m4();
        if (c22548vQ6M4 != null) {
            int iA = c22548vQ6M4.a();
            c20672sP6.Va().H5(z ? new InterfaceC10294bP6.h(iA) : new InterfaceC10294bP6.e(iA));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(C20672sP6 c20672sP6, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, final UA2 ua2) throws IOException {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(lVar, "entry");
        AbstractC13042fc3.i(ua2, "result");
        com.google.android.material.bottomsheet.b bVar = c20672sP6.galleryFragment;
        if (bVar != null) {
            bVar.x8();
        }
        c20672sP6.eb(lVar, new UA2() { // from class: ir.nasim.cP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.Ta(ua2, ((Boolean) obj).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ta(UA2 ua2, boolean z) {
        AbstractC13042fc3.i(ua2, "$result");
        ua2.invoke(Boolean.valueOf(z));
        return C19938rB7.a;
    }

    private final void Ua() {
        AbstractC10533bm0.d(AbstractC16751lo1.a(this), null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C10366bX6 Va() {
        return (C10366bX6) this.viewModel.getValue();
    }

    private final void Wa() {
        C22042ua0.m9(this, this, false, 2, null);
        C22042ua0.A9(this, MW6.INSTANCE.a(Va().i4().getId(), new ArrayList(), (60 & 4) != 0 ? null : null, (60 & 8) != 0 ? null : null, (60 & 16) != 0 ? null : null, (60 & 32) != 0 ? -1 : 0), false, null, 6, null);
    }

    private final void Xa() {
        Va().w3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ya() {
        C22042ua0.A9(this, TS6.INSTANCE.a(), false, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Za(final C20672sP6 c20672sP6, final String str) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(str, "imagePath");
        c20672sP6.gb(str, false, new UA2() { // from class: ir.nasim.iP6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20672sP6.ab(str, c20672sP6, (String) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ab(String str, C20672sP6 c20672sP6, String str2) {
        AbstractC13042fc3.i(str, "$imagePath");
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(str2, "it");
        bb(c20672sP6, str);
        return C19938rB7.a;
    }

    private static final void bb(C20672sP6 c20672sP6, String str) {
        C22042ua0.A9(c20672sP6, RV6.v1.a(str, false, (56 & 4) != 0 ? false : false, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
        c20672sP6.photoFile = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 cb(C20672sP6 c20672sP6, String str) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(str, "it");
        db(c20672sP6, str);
        return C19938rB7.a;
    }

    private static final void db(C20672sP6 c20672sP6, String str) {
        C22042ua0.A9(c20672sP6, RV6.v1.a(str, false, (56 & 4) != 0 ? false : false, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
    }

    private final void eb(final ir.nasim.tgwidgets.editor.ui.stories.recorder.l entry, final UA2 result) throws IOException {
        if (entry.O()) {
            entry.w(new Utilities.b() { // from class: ir.nasim.jP6
                @Override // ir.nasim.tgwidgets.editor.messenger.Utilities.b
                public final void a(Object obj) {
                    C20672sP6.fb(this.a, result, entry, (ir.nasim.tgwidgets.editor.messenger.H) obj);
                }
            });
            return;
        }
        File fileI = ir.nasim.tgwidgets.editor.ui.stories.recorder.l.I(0, entry.p);
        entry.j(fileI);
        C10366bX6 c10366bX6Va = Va();
        String path = fileI.getPath();
        AbstractC13042fc3.h(path, "getPath(...)");
        PeersStruct$ExPeer peersStruct$ExPeerI4 = Va().i4();
        C19526qV6 c19526qV6 = entry.g;
        C14189hV6 c14189hV6 = null;
        if (c19526qV6 != null) {
            if (!c19526qV6.e()) {
                c19526qV6 = null;
            }
            if (c19526qV6 != null) {
                c14189hV6 = new C14189hV6(c19526qV6.d(), c19526qV6.f());
            }
        }
        C20081rR6 c20081rR6 = new C20081rR6();
        InterfaceC19490qR6 interfaceC19490qR6 = entry.f;
        AbstractC13042fc3.h(interfaceC19490qR6, "storyLinkEditor");
        c10366bX6Va.p6(path, peersStruct$ExPeerI4, (4 & 4) != 0 ? null : c14189hV6, (4 & 8) != 0 ? null : c20081rR6.a(interfaceC19490qR6), (4 & 16) != 0 ? null : null);
        result.invoke(Boolean.TRUE);
        Wa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(C20672sP6 c20672sP6, UA2 ua2, ir.nasim.tgwidgets.editor.ui.stories.recorder.l lVar, ir.nasim.tgwidgets.editor.messenger.H h2) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        AbstractC13042fc3.i(ua2, "$result");
        AbstractC13042fc3.i(lVar, "$entry");
        if (h2 == null) {
            return;
        }
        if (h2.q / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT <= c20672sP6.Va().L4()) {
            c20672sP6.Va().W2(lVar, h2);
            ua2.invoke(Boolean.TRUE);
            c20672sP6.Wa();
        } else {
            String strH6 = c20672sP6.h6(SD5.add_story_duration_error);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c20672sP6.I9(strH6);
            ua2.invoke(Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gb(String path, boolean isVideo, UA2 onDone) {
        ArrayList<Object> arrayListG = AbstractC10360bX0.g(new AbstractC14815iX3.b(0, 0, 0L, path, V13.c(path), isVideo));
        PhotoViewerBridge photoViewerBridge = new PhotoViewerBridge();
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        photoViewerBridge.setParentActivity(fragmentActivityQ7);
        photoViewerBridge.openPhotoForSelect(arrayListG, 0, 2, false, new g(arrayListG, onDone), null, null);
    }

    private final void hb() {
        Bundle bundleR7 = R7();
        AbstractC13042fc3.f(bundleR7);
        Object objC = AbstractC19455qN7.c(bundleR7, "SOURCE_CALLER_ENUM_ARG", StoryAdderSourceCallerEnum.class);
        AbstractC13042fc3.f(objC);
        this.sourceCallerEnum = (StoryAdderSourceCallerEnum) objC;
    }

    private final void ib() {
        C21753u45.Q0(C21753u45.a, this, this.PERMISSIONS_REQUEST_CAMERA_PHOTO_AND_VIDEO, null, new C21753u45.d[]{C21753u45.d.f, C21753u45.d.j, C21753u45.d.m}, 4, null);
    }

    private final void jb() {
        C22548vQ6 c22548vQ6M4 = Va().m4();
        if (c22548vQ6M4 != null) {
            Va().H5(new InterfaceC10294bP6.q(c22548vQ6M4.a()));
        }
        C22042ua0.A9(this, RV6.v1.a("", true, (56 & 4) != 0 ? false : false, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
    }

    private final void kb() {
        C22548vQ6 c22548vQ6M4 = Va().m4();
        if (c22548vQ6M4 != null) {
            Va().H5(new InterfaceC10294bP6.k(c22548vQ6M4.a()));
        }
        InterfaceC15814kD2 interfaceC15814kD2Ma = Ma();
        long jF = AbstractC5969Lp4.f();
        ExPeerType exPeerTypeFromValue = ExPeerType.fromValue(La().getTypeValue());
        AbstractC13042fc3.h(exPeerTypeFromValue, "fromValue(...)");
        com.google.android.material.bottomsheet.b bVarB = InterfaceC15814kD2.b(interfaceC15814kD2Ma, jF, exPeerTypeFromValue, Va().G3(), new TC2.d(true, null, 2, null), false, 16, null);
        this.galleryFragment = bVarB;
        if (bVarB != null) {
            y.Companion companion = ir.nasim.features.payment.view.fragment.y.INSTANCE;
            FragmentManager fragmentManagerV5 = V5();
            AbstractC13042fc3.h(fragmentManagerV5, "getParentFragmentManager(...)");
            companion.b(bVarB, fragmentManagerV5, null);
        }
    }

    private final void mb() {
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        StoryAdderBottomSheet storyAdderBottomSheet = new StoryAdderBottomSheet(contextS7, new SA2() { // from class: ir.nasim.gP6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20672sP6.nb(this.a);
            }
        }, new SA2() { // from class: ir.nasim.hP6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20672sP6.ob(this.a);
            }
        });
        C14486i0.a aVar = C14486i0.f;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C14486i0 c14486i0A = aVar.a(fragmentActivityQ7);
        storyAdderBottomSheet.setAbol(c14486i0A);
        c14486i0A.o(storyAdderBottomSheet);
        C22548vQ6 c22548vQ6M4 = Va().m4();
        if (c22548vQ6M4 != null) {
            Va().H5(new InterfaceC10294bP6.d(c22548vQ6M4.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 nb(C20672sP6 c20672sP6) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        c20672sP6.Ba();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ob(C20672sP6 c20672sP6) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        c20672sP6.Ca();
        return C19938rB7.a;
    }

    private final void pb() {
        D20.a aVarE = C10600bs7.a.e(p6());
        String strH6 = h6(SD5.story_text_story_tooltip);
        AbstractC13042fc3.h(strH6, "getString(...)");
        aVarE.X1(strH6);
        aVarE.W1(-1);
        aVarE.a();
        Va().j6();
    }

    private final void qb() {
        AbstractC16751lo1.c(this, j.b.RESUMED, new h(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C10366bX6 rb(C20672sP6 c20672sP6) {
        AbstractC13042fc3.i(c20672sP6, "this$0");
        FragmentActivity fragmentActivityQ7 = c20672sP6.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (C10366bX6) new androidx.lifecycle.G(fragmentActivityQ7).b(C10366bX6.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta() {
        C22042ua0.A9(this, C7164Qn7.INSTANCE.a(), false, null, 6, null);
        C23144wQ6.a.g("click");
        if (Va().N2()) {
            pb();
        }
    }

    private final InterfaceC13730gj3 ua(C12971fU6 bridge) {
        return AbstractC19455qN7.g(this, null, new b(bridge, null), 1, null);
    }

    private final void va() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.Q0(C21753u45.a, this, this.PERMISSIONS_REQUEST_STORAGE_FOR_DOCUMENT, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
        } else {
            kb();
        }
    }

    private final void wa() {
        if (AbstractC4043Dl1.a(AbstractC5969Lp4.d().j2(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            C21753u45.Q0(C21753u45.a, this, this.PERMISSIONS_REQUEST_STORAGE_FOR_TEXT, null, new C21753u45.d[]{C21753u45.d.j, C21753u45.d.m}, 4, null);
        } else {
            jb();
        }
    }

    private final void xa() {
        AbstractC18623oy2.d(this, "REQUEST_CODE_LINK_BOTTOM_SHEET", new InterfaceC14603iB2() { // from class: ir.nasim.kP6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C20672sP6.ya((String) obj, (Bundle) obj2);
            }
        });
        AbstractC18623oy2.d(this, "REQUEST_CODE_TAG_BOTTOM_SHEET", new InterfaceC14603iB2() { // from class: ir.nasim.lP6
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return C20672sP6.za((String) obj, (Bundle) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        String string = bundle.getString("KEY_LINK");
        if (string != null) {
            String string2 = bundle.getString("KEY_LINK_TITLE");
            if (string2 == null) {
                string2 = "";
            }
            C12971fU6.a.C(new StoryWidget.LinkWidget(string, string2, null, 4, null));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(String str, Bundle bundle) {
        AbstractC13042fc3.i(str, "<unused var>");
        AbstractC13042fc3.i(bundle, "bundle");
        C12971fU6.a.D(EnumC20117rV6.h.a(bundle.getInt("KEY_TAG_ID")), bundle.getBoolean("KEY_IS_ENABLED"), bundle.getBoolean("KEY_IS_SPECIAL_ENABLED"));
        return C19938rB7.a;
    }

    @Override // androidx.fragment.app.Fragment
    public void H6(int requestCode, int resultCode, Intent data) {
        super.H6(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode != this.REQUEST_MERGE_CAMERA_PHOTO_VIDEO) {
                if (requestCode == this.REQUEST_PHOTO_EDITOR) {
                    Uri uri = Uri.parse(data != null ? data.getStringExtra(this.EXTRA_EDITED_IMAGE_URI) : null);
                    if (uri != null) {
                        RV6.a aVar = RV6.v1;
                        String absolutePath = new File(C6906Pm2.a.r(uri)).getAbsolutePath();
                        AbstractC13042fc3.h(absolutePath, "getAbsolutePath(...)");
                        C22042ua0.A9(this, aVar.a(absolutePath, false, (56 & 4) != 0 ? false : false, (56 & 8) != 0 ? false : false, (56 & 16) != 0 ? AbstractC10360bX0.m() : null, (56 & 32) != 0 ? null : null), false, null, 6, null);
                        return;
                    }
                    return;
                }
                return;
            }
            String str = this.photoFile;
            if (str != null) {
                if (C8386Vt0.jb()) {
                    Context contextS7 = S7();
                    AbstractC13042fc3.h(contextS7, "requireContext(...)");
                    AbstractC19455qN7.a(contextS7, str, new UA2() { // from class: ir.nasim.eP6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C20672sP6.Za(this.a, (String) obj);
                        }
                    });
                } else {
                    bb(this, str);
                }
            }
            String str2 = this.videoFile;
            if (str2 != null) {
                if (C8386Vt0.xb()) {
                    gb(str2, true, new UA2() { // from class: ir.nasim.fP6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return C20672sP6.cb(this.a, (String) obj);
                        }
                    });
                } else {
                    db(this, str2);
                }
            }
        }
    }

    public final PeersStruct$ExPeer La() {
        PeersStruct$ExPeer peersStruct$ExPeer = this.exPeer;
        if (peersStruct$ExPeer != null) {
            return peersStruct$ExPeer;
        }
        AbstractC13042fc3.y("exPeer");
        return null;
    }

    public final InterfaceC15814kD2 Ma() {
        InterfaceC15814kD2 interfaceC15814kD2 = this.galleryNavigator;
        if (interfaceC15814kD2 != null) {
            return interfaceC15814kD2;
        }
        AbstractC13042fc3.y("galleryNavigator");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C22886vz2.c(inflater, container, false);
        lb(Va().i4());
        hb();
        C19938rB7 c19938rB7 = C19938rB7.a;
        C10366bX6 c10366bX6Va = Va();
        StoryAdderSourceCallerEnum storyAdderSourceCallerEnum = this.sourceCallerEnum;
        StoryAdderSourceCallerEnum storyAdderSourceCallerEnum2 = null;
        if (storyAdderSourceCallerEnum == null) {
            AbstractC13042fc3.y("sourceCallerEnum");
            storyAdderSourceCallerEnum = null;
        }
        c10366bX6Va.x5(storyAdderSourceCallerEnum.getActionType(), La().getId());
        C10366bX6 c10366bX6Va2 = Va();
        StoryAdderSourceCallerEnum storyAdderSourceCallerEnum3 = this.sourceCallerEnum;
        if (storyAdderSourceCallerEnum3 == null) {
            AbstractC13042fc3.y("sourceCallerEnum");
        } else {
            storyAdderSourceCallerEnum2 = storyAdderSourceCallerEnum3;
        }
        c10366bX6Va2.H5(new InterfaceC10294bP6.p(storyAdderSourceCallerEnum2.getActionType()));
        this.requestPermissionLauncher = N7(new C19881r6(), this.permissionResultCallback);
        ConstraintLayout root = Ja().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void S0() throws Resources.NotFoundException {
        C12971fU6.a.B();
        super.S0();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        C12971fU6.a.o();
        Va().O2();
        super.T6();
        Va().d6();
    }

    @Override // androidx.fragment.app.Fragment
    public void U6() {
        AbstractC19329q98.a(Q7().getWindow(), Ja().getRoot()).c(false);
        super.U6();
    }

    @Override // ir.nasim.InterfaceC19822r00
    public void a1() {
        C12971fU6.a.A();
        super.a1();
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void c7() {
        C12971fU6.a.A();
        super.c7();
    }

    @Override // androidx.fragment.app.Fragment
    public void g7(int requestCode, String[] permissions, int[] grantResults) {
        AbstractC13042fc3.i(permissions, "permissions");
        AbstractC13042fc3.i(grantResults, "grantResults");
        if (requestCode == this.PERMISSIONS_REQUEST_CAMERA_PHOTO_AND_VIDEO || requestCode == this.PERMISSIONS_REQUEST_CAMERA_PHOTO || requestCode == this.PERMISSIONS_REQUEST_CAMERA_VIDEO) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                if (this.isVideo) {
                    Ca();
                } else {
                    Ba();
                }
            }
        }
        if (requestCode == this.PERMISSIONS_REQUEST_STORAGE_FOR_DOCUMENT) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                kb();
            }
        }
        if (requestCode == this.PERMISSIONS_REQUEST_STORAGE_FOR_TEXT) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                jb();
            }
        }
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() throws Resources.NotFoundException {
        C12971fU6.a.B();
        super.h7();
    }

    @Override // ir.nasim.C22042ua0
    public void i9() {
        super.i9();
        Va().Y4();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Va().l6();
        if (Va().E4()) {
            Ua();
        }
        Ja().c.setContent(AbstractC19242q11.c(-1840716180, true, new f()));
        Ga();
        Xa();
        qb();
        Ha();
    }

    public final void lb(PeersStruct$ExPeer peersStruct$ExPeer) {
        AbstractC13042fc3.i(peersStruct$ExPeer, "<set-?>");
        this.exPeer = peersStruct$ExPeer;
    }
}
