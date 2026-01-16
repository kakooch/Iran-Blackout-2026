package ir.nasim.videoplayer;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Spannable;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.SeekBar;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.F;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.E0;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC10882cM5;
import ir.nasim.AbstractC12281eL6;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14329hk1;
import ir.nasim.AbstractC14628iD5;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC16751lo1;
import ir.nasim.AbstractC19224pz3;
import ir.nasim.AbstractC19329q98;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19945rC5;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC22163um1;
import ir.nasim.AbstractC22357v6;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC3336Al1;
import ir.nasim.AbstractC3742Cd6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC6459Nq2;
import ir.nasim.AbstractC8081Ul1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9203Yx6;
import ir.nasim.C10776cA7;
import ir.nasim.C11458d25;
import ir.nasim.C11637dL5;
import ir.nasim.C12372eV7;
import ir.nasim.C13297fz4;
import ir.nasim.C14819iX7;
import ir.nasim.C15539jl1;
import ir.nasim.C17428mw7;
import ir.nasim.C17468n10;
import ir.nasim.C18391oa8;
import ir.nasim.C19406qI3;
import ir.nasim.C19881r6;
import ir.nasim.C19938rB7;
import ir.nasim.C19994rI0;
import ir.nasim.C21015sz4;
import ir.nasim.C21356tW7;
import ir.nasim.C21753u45;
import ir.nasim.C3976Dd6;
import ir.nasim.C4337Er7;
import ir.nasim.C4568Fr4;
import ir.nasim.C5191Ih0;
import ir.nasim.C8386Vt0;
import ir.nasim.C8610Ws;
import ir.nasim.C8792Xi5;
import ir.nasim.C9663aL5;
import ir.nasim.CV7;
import ir.nasim.ED1;
import ir.nasim.EnumC21012sz1;
import ir.nasim.EnumC23696xM4;
import ir.nasim.EnumC24384yX3;
import ir.nasim.EnumC4870Gx3;
import ir.nasim.EnumC7541Sd6;
import ir.nasim.EnumC9274Zf5;
import ir.nasim.F92;
import ir.nasim.G47;
import ir.nasim.G92;
import ir.nasim.GY;
import ir.nasim.H02;
import ir.nasim.IT5;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC17266mg5;
import ir.nasim.InterfaceC17517n6;
import ir.nasim.InterfaceC17652nK4;
import ir.nasim.InterfaceC18963pY7;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.InterfaceC22474vI4;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.InterfaceC4806Gq2;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.InterfaceC9336Zm4;
import ir.nasim.J95;
import ir.nasim.JA5;
import ir.nasim.L93;
import ir.nasim.NI0;
import ir.nasim.O98;
import ir.nasim.OI2;
import ir.nasim.OK4;
import ir.nasim.PH3;
import ir.nasim.PT7;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UI2;
import ir.nasim.VD5;
import ir.nasim.VI2;
import ir.nasim.XE4;
import ir.nasim.XV4;
import ir.nasim.YT7;
import ir.nasim.animation.view.transition.sharedelement.CapturedSharedElement;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.videoplayer.NewVideoPlayerActivity;
import ir.nasim.videoplayer.ui.component.ScrollableCaption;
import ir.nasim.videoplayer.ui.component.ThumbnailContainer;
import ir.nasim.videoplayer.ui.component.VideoPlayerControllerView;
import ir.nasim.videoplayer.ui.component.button.PlayerStateButton;
import ir.nasim.videoplayer.ui.component.photoview.PhotoView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0002\u008f\u0001\b\u0007\u0018\u0000 \u0093\u00012\u00020\u0001:\b\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0003J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002¢\u0006\u0004\b(\u0010)J\u001d\u0010*\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0003¢\u0006\u0004\b*\u0010)J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001eH\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u001cH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b6\u0010\u0003J\u000f\u00107\u001a\u00020\u0006H\u0002¢\u0006\u0004\b7\u0010\u0003J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003JG\u0010A\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020\u001e2\b\b\u0002\u0010=\u001a\u00020\u001e2\b\b\u0002\u0010>\u001a\u00020\u001e2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060?H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0002¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\u0003J\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u0019\u0010H\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010L\u001a\u00020\u00062\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010P\u001a\u00020\u00062\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bP\u0010QJ\u001d\u0010U\u001a\u00020\u00062\f\u0010T\u001a\b\u0012\u0004\u0012\u00020S0RH\u0002¢\u0006\u0004\bU\u0010VJ\u0017\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bY\u0010ZJ\u0017\u0010]\u001a\u00020[2\u0006\u0010\\\u001a\u00020[H\u0002¢\u0006\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010a\u001a\u0004\bg\u0010hR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010a\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010a\u001a\u0004\bq\u0010rR\u001b\u0010x\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010a\u001a\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R*\u0010\u0084\u0001\u001a\r\u0012\t\u0012\u00070\u0080\u0001R\u00020\u00000%8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0081\u0001\u0010a\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010`R\u0018\u0010\u0088\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010`R\u0018\u0010\u008a\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010`R \u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00020+0\u008b\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u0098\u0001"}, d2 = {"Lir/nasim/videoplayer/NewVideoPlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/content/Context;", "newBase", "Lir/nasim/rB7;", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "d4", "e4", "T3", "V3", "O2", "W3", "S2", "W2", "", "x", "", "y3", "(F)Z", "w3", "Lir/nasim/gj3;", "K2", "()Lir/nasim/gj3;", "", "Lir/nasim/Er7;", "items", "g4", "(Ljava/util/List;)V", "i4", "", "senderName", "S3", "(Ljava/lang/String;)V", "rightContentIsAvailable", "leftContentIsAvailable", "Y3", "(ZZ)V", "translationY", "C3", "(F)V", "z3", "A3", "n4", "r4", "Lir/nasim/videoplayer/NewVideoPlayerActivity$d;", "swipe", "leftAnimated", "centerAnimated", "rightAnimated", "Lkotlin/Function0;", "onAnimationEnded", "D3", "(Lir/nasim/videoplayer/NewVideoPlayerActivity$d;ZZZLir/nasim/SA2;)V", "b3", "a3", "M3", "Landroid/text/Spannable;", "caption", "N3", "(Landroid/text/Spannable;)V", "Lir/nasim/G47;", "systemBarState", "v3", "(Lir/nasim/G47;)V", "Lir/nasim/XE4;", "notifier", "l3", "(Lir/nasim/XE4;)V", "Lir/nasim/Fq2;", "", "progressFlow", "l4", "(Lir/nasim/Fq2;)V", "Lir/nasim/xM4;", "orientation", "r3", "(Lir/nasim/xM4;)V", "Lir/nasim/jl1;", "contentSize", "f3", "(Lir/nasim/jl1;)Lir/nasim/jl1;", "Lir/nasim/Fr4;", "Z", "Lir/nasim/Yu3;", "c3", "()Lir/nasim/Fr4;", "binding", "Lir/nasim/sz4;", "z0", "h3", "()Lir/nasim/sz4;", "viewModel", "Lir/nasim/VI2;", "A0", "e3", "()Lir/nasim/VI2;", "glideRequests", "Lir/nasim/oa8;", "B0", "i3", "()Lir/nasim/oa8;", "windowInsetsController", "Lir/nasim/YT7;", "C0", "g3", "()Lir/nasim/YT7;", "videoPlayerGestureListener", "Lir/nasim/Dd6;", "D0", "Lir/nasim/Dd6;", "screenOrientationController", "E0", TokenNames.I, "indexOfCenterContentHolder", "Lir/nasim/videoplayer/NewVideoPlayerActivity$b;", "F0", "d3", "()Ljava/util/List;", "contentHolders", "G0", "hasPostponedSharedElementTransitionStarted", "H0", "hasSharedElementBeenReturned", "I0", "isMovingVertically", "Lir/nasim/v6;", "J0", "Lir/nasim/v6;", "requestPermissionLauncher", "ir/nasim/videoplayer/NewVideoPlayerActivity$h", "K0", "Lir/nasim/videoplayer/NewVideoPlayerActivity$h;", "permissionResultCallback", "L0", "b", "c", "d", "a", "videoplayer_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes8.dex */
public final class NewVideoPlayerActivity extends Hilt_NewVideoPlayerActivity {

    /* renamed from: L0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 glideRequests;

    /* renamed from: B0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 windowInsetsController;

    /* renamed from: C0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 videoPlayerGestureListener;

    /* renamed from: D0, reason: from kotlin metadata */
    private final C3976Dd6 screenOrientationController;

    /* renamed from: E0, reason: from kotlin metadata */
    private int indexOfCenterContentHolder;

    /* renamed from: F0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 contentHolders;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean hasPostponedSharedElementTransitionStarted;

    /* renamed from: H0, reason: from kotlin metadata */
    private boolean hasSharedElementBeenReturned;

    /* renamed from: I0, reason: from kotlin metadata */
    private boolean isMovingVertically;

    /* renamed from: J0, reason: from kotlin metadata */
    private AbstractC22357v6 requestPermissionLauncher;

    /* renamed from: K0, reason: from kotlin metadata */
    private final h permissionResultCallback;

    /* renamed from: Z, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 binding;

    /* renamed from: z0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final ActivityOptions a(Activity activity, View view) {
            AbstractC13042fc3.i(activity, "activity");
            AbstractC13042fc3.i(view, "sharedElement");
            ActivityOptions activityOptionsMakeSceneTransitionAnimation = ActivityOptions.makeSceneTransitionAnimation(activity, view, view.getTransitionName());
            AbstractC13042fc3.h(activityOptionsMakeSceneTransitionAnimation, "makeSceneTransitionAnimation(...)");
            return activityOptionsMakeSceneTransitionAnimation;
        }

        public final Intent b(Context context, C11458d25 c11458d25, ExPeerType exPeerType, InterfaceC18963pY7 interfaceC18963pY7, String str, EnumC24384yX3 enumC24384yX3) {
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c11458d25, "peer");
            AbstractC13042fc3.i(exPeerType, DialogEntity.COLUMN_EX_PEER_TYPE);
            AbstractC13042fc3.i(interfaceC18963pY7, "viewableContent");
            AbstractC13042fc3.i(enumC24384yX3, "mediaLoadType");
            Intent intent = new Intent(context, (Class<?>) NewVideoPlayerActivity.class);
            intent.putExtra("PEER_UNIQUE_ID_ARG", c11458d25.u());
            intent.putExtra("EX_PEER_TYPE_ARG", exPeerType);
            intent.putExtra("VIEWABLE_CONTENT_ARG", interfaceC18963pY7);
            intent.addFlags(268435456);
            intent.putExtra("STARTER_TRANSITION_NAME_ARG", str);
            intent.putExtra("MEDIA_LOAD_TYPE_ARG", enumC24384yX3);
            return intent;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class b {
        private final ThumbnailContainer a;
        private final PlayerStateButton b;
        private final PhotoView c;
        private final InterfaceC20315ro1 d;
        private final VI2 e;
        private final int f;
        private InterfaceC9336Zm4 g;
        private AbstractC3336Al1 h;
        private InterfaceC13730gj3 i;
        private View j;
        private String k;
        final /* synthetic */ NewVideoPlayerActivity l;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[c.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b, reason: collision with other inner class name */
        static final class C1671b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ AbstractC3336Al1.a e;
            final /* synthetic */ NewVideoPlayerActivity f;

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$a */
            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = ((Boolean) obj).booleanValue();
                    return aVar;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.F(this.c);
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$b, reason: collision with other inner class name */
            static final class C1672b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1672b(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1672b c1672b = new C1672b(this.d, interfaceC20295rm1);
                    c1672b.c = obj;
                    return c1672b;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.k = (String) this.c;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1672b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ NewVideoPlayerActivity d;
                final /* synthetic */ AbstractC3336Al1.a e;
                final /* synthetic */ b f;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$c$a */
                public static final class a implements Runnable {
                    final /* synthetic */ View a;
                    final /* synthetic */ NewVideoPlayerActivity b;

                    public a(View view, NewVideoPlayerActivity newVideoPlayerActivity) {
                        this.a = view;
                        this.b = newVideoPlayerActivity;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.b.S0();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(NewVideoPlayerActivity newVideoPlayerActivity, AbstractC3336Al1.a aVar, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = newVideoPlayerActivity;
                    this.e = aVar;
                    this.f = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    c cVar = new c(this.d, this.e, this.f, interfaceC20295rm1);
                    cVar.c = obj;
                    return cVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) throws InterruptedException {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC14329hk1.a aVar = (AbstractC14329hk1.a) this.c;
                    C15539jl1 c15539jl1F3 = this.d.f3(this.e.b());
                    if (aVar.d() == null) {
                        this.f.e.z(aVar.g()).u0(new C5191Ih0(10, 3)).c0(c15539jl1F3.b(), c15539jl1F3.a()).Q0(this.f.E());
                    } else {
                        this.f.e.n(this.f.E());
                        C8610Ws c8610Ws = new C8610Ws(new File(aVar.d()));
                        c8610Ws.S(this.f.E());
                        c8610Ws.start();
                        PhotoView photoViewE = this.f.E();
                        ViewGroup.LayoutParams layoutParams = photoViewE.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        layoutParams.width = c15539jl1F3.b();
                        layoutParams.height = c15539jl1F3.a();
                        photoViewE.setLayoutParams(layoutParams);
                        photoViewE.setBackground(c8610Ws);
                        if (this.f.g.getValue() == c.b && !this.d.hasPostponedSharedElementTransitionStarted) {
                            PhotoView photoViewE2 = this.f.E();
                            OK4.a(photoViewE2, new a(photoViewE2, this.d));
                            this.d.hasPostponedSharedElementTransitionStarted = true;
                        }
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC14329hk1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(aVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d */
            public static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a */
                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a$a, reason: collision with other inner class name */
                    public static final class C1673a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a$a$a, reason: collision with other inner class name */
                        public static final class C1674a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1674a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1673a.this.a(null, this);
                            }
                        }

                        public C1673a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.d.a.C1673a.C1674a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.d.a.C1673a.C1674a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$d$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L49
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$a r5 = (ir.nasim.AbstractC14329hk1.a) r5
                                boolean r5 = r5.f()
                                java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L49
                                return r1
                            L49:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.d.a.C1673a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1673a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e */
            public static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a */
                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a$a, reason: collision with other inner class name */
                    public static final class C1675a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a$a$a, reason: collision with other inner class name */
                        public static final class C1676a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1676a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1675a.this.a(null, this);
                            }
                        }

                        public C1675a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.e.a.C1675a.C1676a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.e.a.C1675a.C1676a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$e$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$a r5 = (ir.nasim.AbstractC14329hk1.a) r5
                                java.lang.String r5 = r5.e()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.e.a.C1675a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1675a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new e(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f */
            public static final class f implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f$a */
                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f$a$a, reason: collision with other inner class name */
                    public static final class C1677a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1677a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.f.a.C1677a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.f.a.C1677a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$b$f$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L4f
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            r2 = r6
                            ir.nasim.hk1$a r2 = (ir.nasim.AbstractC14329hk1.a) r2
                            java.lang.String r4 = r2.d()
                            if (r4 != 0) goto L46
                            byte[] r2 = r2.g()
                            if (r2 != 0) goto L46
                            goto L4f
                        L46:
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r6, r0)
                            if (r6 != r1) goto L4f
                            return r1
                        L4f:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.C1671b.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public f(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1671b(AbstractC3336Al1.a aVar, NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = aVar;
                this.f = newVideoPlayerActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean y(AbstractC14329hk1.a aVar, AbstractC14329hk1.a aVar2) {
                return AbstractC13042fc3.d(aVar.d(), aVar2.d()) && aVar.g() == aVar2.g();
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1671b c1671b = b.this.new C1671b(this.e, this.f, interfaceC20295rm1);
                c1671b.c = obj;
                return c1671b;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    PlayerStateButton playerStateButtonB = b.this.B();
                    playerStateButtonB.setClickable(false);
                    playerStateButtonB.setFocusable(false);
                    playerStateButtonB.c();
                    playerStateButtonB.setOnClickListener(null);
                    b.this.j = null;
                    InterfaceC4557Fq2 interfaceC4557Fq2A = this.e.a();
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    obj = AbstractC6459Nq2.p0(interfaceC4557Fq2A, interfaceC20315ro1, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10685c16.b(obj);
                }
                a aVar = new a(b.this, null);
                C13297fz4 c13297fz4 = C13297fz4.a;
                InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) obj;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new d(interfaceC10258bL6, c13297fz4, aVar, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new e(interfaceC10258bL6, c13297fz4, new C1672b(b.this, null), null), 3, null);
                f fVar = new f(AbstractC6459Nq2.w(interfaceC10258bL6, new InterfaceC14603iB2() { // from class: ir.nasim.videoplayer.g
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(NewVideoPlayerActivity.b.C1671b.y((AbstractC14329hk1.a) obj2, (AbstractC14329hk1.a) obj3));
                    }
                }));
                c cVar = new c(this.f, this.e, b.this, null);
                this.c = null;
                this.b = 2;
                if (AbstractC6459Nq2.l(fVar, cVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1671b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ AbstractC3336Al1.b e;
            final /* synthetic */ NewVideoPlayerActivity f;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    a aVar = new a(this.d, interfaceC20295rm1);
                    aVar.c = ((Boolean) obj).booleanValue();
                    return aVar;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.F(this.c);
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$b, reason: collision with other inner class name */
            static final class C1678b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1678b(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1678b c1678b = new C1678b(this.d, interfaceC20295rm1);
                    c1678b.c = obj;
                    return c1678b;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.k = (String) this.c;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1678b) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$c, reason: collision with other inner class name */
            static final class C1679c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ NewVideoPlayerActivity d;
                final /* synthetic */ AbstractC3336Al1.b e;
                final /* synthetic */ b f;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$c$a */
                public static final class a implements IT5 {
                    final /* synthetic */ b a;
                    final /* synthetic */ NewVideoPlayerActivity b;

                    public a(b bVar, NewVideoPlayerActivity newVideoPlayerActivity) {
                        this.a = bVar;
                        this.b = newVideoPlayerActivity;
                    }

                    @Override // ir.nasim.IT5
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
                        AbstractC13042fc3.i(drawable, "resource");
                        AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
                        AbstractC13042fc3.i(enumC21012sz1, "dataSource");
                        if (this.a.g.getValue() != c.b || this.b.hasPostponedSharedElementTransitionStarted) {
                            return false;
                        }
                        PhotoView photoViewE = this.a.E();
                        OK4.a(photoViewE, new RunnableC1680b(photoViewE, this.b));
                        this.b.hasPostponedSharedElementTransitionStarted = true;
                        return false;
                    }

                    @Override // ir.nasim.IT5
                    public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
                        AbstractC13042fc3.i(interfaceC21549tj7, "target");
                        if (this.a.g.getValue() != c.b || this.b.hasPostponedSharedElementTransitionStarted) {
                            return false;
                        }
                        PhotoView photoViewE = this.a.E();
                        OK4.a(photoViewE, new RunnableC1680b(photoViewE, this.b));
                        this.b.hasPostponedSharedElementTransitionStarted = true;
                        return false;
                    }
                }

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$c$b, reason: collision with other inner class name */
                public static final class RunnableC1680b implements Runnable {
                    final /* synthetic */ View a;
                    final /* synthetic */ NewVideoPlayerActivity b;

                    public RunnableC1680b(View view, NewVideoPlayerActivity newVideoPlayerActivity) {
                        this.a = view;
                        this.b = newVideoPlayerActivity;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.b.S0();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1679c(NewVideoPlayerActivity newVideoPlayerActivity, AbstractC3336Al1.b bVar, b bVar2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = newVideoPlayerActivity;
                    this.e = bVar;
                    this.f = bVar2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1679c c1679c = new C1679c(this.d, this.e, this.f, interfaceC20295rm1);
                    c1679c.c = obj;
                    return c1679c;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC14329hk1.b bVar = (AbstractC14329hk1.b) this.c;
                    C15539jl1 c15539jl1F3 = this.d.f3(this.e.b());
                    if (bVar.d() == null) {
                        this.f.e.z(bVar.g()).u0(new C5191Ih0(10, 3)).c0(c15539jl1F3.b(), c15539jl1F3.a()).Q0(this.f.E());
                    } else if (this.d.hasPostponedSharedElementTransitionStarted) {
                        this.f.e.y(bVar.d()).h1(this.f.e.z(bVar.g()).u0(new C5191Ih0(10, 3))).i1(H02.k()).c0(c15539jl1F3.b(), c15539jl1F3.a()).Q0(this.f.E());
                    } else {
                        UI2 ui2C0 = this.f.e.y(bVar.d()).c0(c15539jl1F3.b(), c15539jl1F3.a());
                        AbstractC13042fc3.h(ui2C0, "override(...)");
                        UI2 ui2B0 = ui2C0.B0(new a(this.f, this.d));
                        AbstractC13042fc3.h(ui2B0, "addListener(...)");
                        ui2B0.Q0(this.f.E());
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(AbstractC14329hk1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1679c) create(bVar, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$d$a$a, reason: collision with other inner class name */
                    public static final class C1681a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$d$a$a$a, reason: collision with other inner class name */
                        public static final class C1682a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1682a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1681a.this.a(null, this);
                            }
                        }

                        public C1681a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.d.a.C1681a.C1682a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$d$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.d.a.C1681a.C1682a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$d$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$d$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L49
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$b r5 = (ir.nasim.AbstractC14329hk1.b) r5
                                boolean r5 = r5.f()
                                java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L49
                                return r1
                            L49:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.d.a.C1681a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1681a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$e$a$a, reason: collision with other inner class name */
                    public static final class C1683a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$e$a$a$a, reason: collision with other inner class name */
                        public static final class C1684a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1684a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1683a.this.a(null, this);
                            }
                        }

                        public C1683a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.e.a.C1683a.C1684a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$e$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.e.a.C1683a.C1684a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$e$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$e$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$b r5 = (ir.nasim.AbstractC14329hk1.b) r5
                                java.lang.String r5 = r5.e()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.e.a.C1683a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1683a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public e(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new e(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class f implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                public static final class a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$f$a$a, reason: collision with other inner class name */
                    public static final class C1685a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1685a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return a.this.a(null, this);
                        }
                    }

                    public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.f.a.C1685a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$f$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.f.a.C1685a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$f$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$c$f$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L4f
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            r2 = r6
                            ir.nasim.hk1$b r2 = (ir.nasim.AbstractC14329hk1.b) r2
                            java.lang.String r4 = r2.d()
                            if (r4 != 0) goto L46
                            byte[] r2 = r2.g()
                            if (r2 != 0) goto L46
                            goto L4f
                        L46:
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r6, r0)
                            if (r6 != r1) goto L4f
                            return r1
                        L4f:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.c.f.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public f(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(AbstractC3336Al1.b bVar, NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = bVar;
                this.f = newVideoPlayerActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean y(AbstractC14329hk1.b bVar, AbstractC14329hk1.b bVar2) {
                return AbstractC13042fc3.d(bVar.d(), bVar2.d()) && bVar.g() == bVar2.g();
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = b.this.new c(this.e, this.f, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    b.this.A().setTouchable(true);
                    PlayerStateButton playerStateButtonB = b.this.B();
                    playerStateButtonB.setClickable(false);
                    playerStateButtonB.setFocusable(false);
                    playerStateButtonB.c();
                    playerStateButtonB.setOnClickListener(null);
                    b bVar = b.this;
                    bVar.j = bVar.E();
                    AbstractC12990fW7.L0(b.this.E(), this.e.c());
                    InterfaceC4557Fq2 interfaceC4557Fq2A = this.e.a();
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    obj = AbstractC6459Nq2.p0(interfaceC4557Fq2A, interfaceC20315ro1, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10685c16.b(obj);
                }
                a aVar = new a(b.this, null);
                C13297fz4 c13297fz4 = C13297fz4.a;
                InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) obj;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new d(interfaceC10258bL6, c13297fz4, aVar, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new e(interfaceC10258bL6, c13297fz4, new C1678b(b.this, null), null), 3, null);
                f fVar = new f(AbstractC6459Nq2.w(interfaceC10258bL6, new InterfaceC14603iB2() { // from class: ir.nasim.videoplayer.h
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(NewVideoPlayerActivity.b.c.y((AbstractC14329hk1.b) obj2, (AbstractC14329hk1.b) obj3));
                    }
                }));
                C1679c c1679c = new C1679c(this.f, this.e, b.this, null);
                this.c = null;
                this.b = 2;
                if (AbstractC6459Nq2.l(fVar, c1679c, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ AbstractC3336Al1.c e;
            final /* synthetic */ NewVideoPlayerActivity f;

            static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
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
                    this.d.G((InterfaceC17266mg5) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC17266mg5 interfaceC17266mg5, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((a) create(interfaceC17266mg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$b, reason: collision with other inner class name */
            static final class C1686b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1686b(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1686b c1686b = new C1686b(this.d, interfaceC20295rm1);
                    c1686b.c = ((Boolean) obj).booleanValue();
                    return c1686b;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.F(this.c);
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1686b) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    c cVar = new c(this.d, interfaceC20295rm1);
                    cVar.c = obj;
                    return cVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.k = (String) this.c;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(String str, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(str, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$d, reason: collision with other inner class name */
            static final class C1687d extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                /* synthetic */ Object c;
                /* synthetic */ Object d;

                C1687d(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return AbstractC6392Nk0.a(((c) this.d) == c.b && (((AbstractC14329hk1.c) this.c).i() instanceof CV7.a));
                }

                @Override // ir.nasim.InterfaceC15796kB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object q(AbstractC14329hk1.c cVar, c cVar2, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1687d c1687d = new C1687d(interfaceC20295rm1);
                    c1687d.c = cVar;
                    c1687d.d = cVar2;
                    return c1687d.invokeSuspend(C19938rB7.a);
                }
            }

            static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ boolean c;
                final /* synthetic */ b d;
                final /* synthetic */ NewVideoPlayerActivity e;
                final /* synthetic */ AbstractC3336Al1.c f;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(b bVar, NewVideoPlayerActivity newVideoPlayerActivity, AbstractC3336Al1.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                    this.e = newVideoPlayerActivity;
                    this.f = cVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    e eVar = new e(this.d, this.e, this.f, interfaceC20295rm1);
                    eVar.c = ((Boolean) obj).booleanValue();
                    return eVar;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return n(((Boolean) obj).booleanValue(), (InterfaceC20295rm1) obj2);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    if (this.c) {
                        this.d.j = this.e.c3().b;
                        AbstractC12990fW7.L0(this.e.c3().b, this.f.c());
                    } else {
                        b bVar = this.d;
                        bVar.j = bVar.E();
                        AbstractC12990fW7.L0(this.d.E(), this.f.b());
                    }
                    return C19938rB7.a;
                }

                public final Object n(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((e) create(Boolean.valueOf(z), interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                f(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    f fVar = new f(this.d, interfaceC20295rm1);
                    fVar.c = obj;
                    return fVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.K((C8792Xi5) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C8792Xi5 c8792Xi5, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((f) create(c8792Xi5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    g gVar = new g(this.d, interfaceC20295rm1);
                    gVar.c = obj;
                    return gVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.M((C12372eV7) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(C12372eV7 c12372eV7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((g) create(c12372eV7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                h(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    h hVar = new h(this.d, interfaceC20295rm1);
                    hVar.c = obj;
                    return hVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.N((EnumC9274Zf5) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(EnumC9274Zf5 enumC9274Zf5, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((h) create(enumC9274Zf5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                /* synthetic */ Object c;
                final /* synthetic */ b d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                i(b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = bVar;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    i iVar = new i(this.d, interfaceC20295rm1);
                    iVar.c = obj;
                    return iVar;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.d.L((CV7) this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CV7 cv7, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((i) create(cv7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$j$a$a, reason: collision with other inner class name */
                    public static final class C1688a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$j$a$a$a, reason: collision with other inner class name */
                        public static final class C1689a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1689a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1688a.this.a(null, this);
                            }
                        }

                        public C1688a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.j.a.C1688a.C1689a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$j$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.j.a.C1688a.C1689a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$j$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$j$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                ir.nasim.Xi5 r5 = r5.f()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.j.a.C1688a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1688a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public j(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new j(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$k$a$a, reason: collision with other inner class name */
                    public static final class C1690a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$k$a$a$a, reason: collision with other inner class name */
                        public static final class C1691a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1691a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1690a.this.a(null, this);
                            }
                        }

                        public C1690a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.k.a.C1690a.C1691a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$k$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.k.a.C1690a.C1691a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$k$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$k$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                ir.nasim.eV7 r5 = r5.j()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.k.a.C1690a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1690a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public k(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new k(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$l$a$a, reason: collision with other inner class name */
                    public static final class C1692a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$l$a$a$a, reason: collision with other inner class name */
                        public static final class C1693a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1693a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1692a.this.a(null, this);
                            }
                        }

                        public C1692a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.l.a.C1692a.C1693a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$l$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.l.a.C1692a.C1693a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$l$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$l$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                ir.nasim.Zf5 r5 = r5.d()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.l.a.C1692a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1692a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public l(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new l(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$m$a$a, reason: collision with other inner class name */
                    public static final class C1694a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$m$a$a$a, reason: collision with other inner class name */
                        public static final class C1695a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1695a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1694a.this.a(null, this);
                            }
                        }

                        public C1694a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.m.a.C1694a.C1695a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$m$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.m.a.C1694a.C1695a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$m$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$m$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                ir.nasim.CV7 r5 = r5.i()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.m.a.C1694a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1694a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public m(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new m(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$n$a$a, reason: collision with other inner class name */
                    public static final class C1696a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$n$a$a$a, reason: collision with other inner class name */
                        public static final class C1697a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1697a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1696a.this.a(null, this);
                            }
                        }

                        public C1696a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.n.a.C1696a.C1697a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$n$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.n.a.C1696a.C1697a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$n$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$n$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                ir.nasim.mg5 r5 = r5.e()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.n.a.C1696a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1696a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public n(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new n(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$o$a$a, reason: collision with other inner class name */
                    public static final class C1698a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$o$a$a$a, reason: collision with other inner class name */
                        public static final class C1699a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1699a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1698a.this.a(null, this);
                            }
                        }

                        public C1698a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.o.a.C1698a.C1699a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$o$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.o.a.C1698a.C1699a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$o$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$o$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L49
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                boolean r5 = r5.h()
                                java.lang.Boolean r5 = ir.nasim.AbstractC6392Nk0.a(r5)
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L49
                                return r1
                            L49:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.o.a.C1698a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1698a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public o(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new o(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            public static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC4557Fq2 c;
                final /* synthetic */ InterfaceC14603iB2 d;
                final /* synthetic */ InterfaceC14603iB2 e;

                public static final class a implements InterfaceC4557Fq2 {
                    final /* synthetic */ InterfaceC4557Fq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$p$a$a, reason: collision with other inner class name */
                    public static final class C1700a implements InterfaceC4806Gq2 {
                        final /* synthetic */ InterfaceC4806Gq2 a;

                        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$p$a$a$a, reason: collision with other inner class name */
                        public static final class C1701a extends AbstractC22163um1 {
                            /* synthetic */ Object a;
                            int b;

                            public C1701a(InterfaceC20295rm1 interfaceC20295rm1) {
                                super(interfaceC20295rm1);
                            }

                            @Override // ir.nasim.E90
                            public final Object invokeSuspend(Object obj) {
                                this.a = obj;
                                this.b |= RecyclerView.UNDEFINED_DURATION;
                                return C1700a.this.a(null, this);
                            }
                        }

                        public C1700a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                            this.a = interfaceC4806Gq2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // ir.nasim.InterfaceC4806Gq2
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.p.a.C1700a.C1701a
                                if (r0 == 0) goto L13
                                r0 = r6
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$p$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.p.a.C1700a.C1701a) r0
                                int r1 = r0.b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.b = r1
                                goto L18
                            L13:
                                ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$p$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$b$d$p$a$a$a
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.a
                                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                                int r2 = r0.b
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                ir.nasim.AbstractC10685c16.b(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                ir.nasim.AbstractC10685c16.b(r6)
                                ir.nasim.Gq2 r6 = r4.a
                                ir.nasim.hk1$c r5 = (ir.nasim.AbstractC14329hk1.c) r5
                                java.lang.String r5 = r5.g()
                                r0.b = r3
                                java.lang.Object r5 = r6.a(r5, r0)
                                if (r5 != r1) goto L45
                                return r1
                            L45:
                                ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.b.d.p.a.C1700a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                        }
                    }

                    public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                        this.a = interfaceC4557Fq2;
                    }

                    @Override // ir.nasim.InterfaceC4557Fq2
                    public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                        Object objB = this.a.b(new C1700a(interfaceC4806Gq2), interfaceC20295rm1);
                        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public p(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC4557Fq2;
                    this.d = interfaceC14603iB2;
                    this.e = interfaceC14603iB22;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new p(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                        this.b = 1;
                        if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                    return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(AbstractC3336Al1.c cVar, NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = cVar;
                this.f = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = b.this.new d(this.e, this.f, interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20315ro1 interfaceC20315ro1;
                Object objE = AbstractC14862ic3.e();
                int i2 = this.b;
                if (i2 == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    PlayerStateButton playerStateButtonB = b.this.B();
                    playerStateButtonB.setClickable(true);
                    playerStateButtonB.setFocusable(true);
                    InterfaceC4557Fq2 interfaceC4557Fq2A = this.e.a();
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    obj = AbstractC6459Nq2.p0(interfaceC4557Fq2A, interfaceC20315ro1, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    AbstractC10685c16.b(obj);
                }
                InterfaceC10258bL6 interfaceC10258bL6 = (InterfaceC10258bL6) obj;
                InterfaceC4557Fq2 interfaceC4557Fq2Z = b.this.z(interfaceC10258bL6);
                f fVar = new f(b.this, null);
                C13297fz4 c13297fz4 = C13297fz4.a;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new j(interfaceC4557Fq2Z, c13297fz4, fVar, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new k(b.this.z(interfaceC10258bL6), c13297fz4, new g(b.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new l(b.this.z(interfaceC10258bL6), c13297fz4, new h(b.this, null), null), 3, null);
                InterfaceC10258bL6 interfaceC10258bL62 = interfaceC10258bL6;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new m(interfaceC10258bL62, c13297fz4, new i(b.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new n(interfaceC10258bL62, c13297fz4, new a(b.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new o(interfaceC10258bL62, c13297fz4, new C1686b(b.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new p(interfaceC10258bL62, c13297fz4, new c(b.this, null), null), 3, null);
                InterfaceC4557Fq2 interfaceC4557Fq2V = AbstractC6459Nq2.v(AbstractC6459Nq2.p(interfaceC10258bL62, b.this.g, new C1687d(null)));
                e eVar = new e(b.this, this.f, this.e, null);
                this.c = null;
                this.b = 2;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2V, eVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AbstractC3336Al1 c;
            final /* synthetic */ b d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(AbstractC3336Al1 abstractC3336Al1, b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = abstractC3336Al1;
                this.d = bVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new e(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    AbstractC3336Al1 abstractC3336Al1 = this.c;
                    if (abstractC3336Al1 instanceof AbstractC3336Al1.b) {
                        this.b = 1;
                        if (this.d.u((AbstractC3336Al1.b) abstractC3336Al1, this) == objE) {
                            return objE;
                        }
                    } else if (abstractC3336Al1 instanceof AbstractC3336Al1.c) {
                        this.b = 2;
                        if (this.d.v((AbstractC3336Al1.c) abstractC3336Al1, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (!(abstractC3336Al1 instanceof AbstractC3336Al1.a)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.b = 3;
                        if (this.d.t((AbstractC3336Al1.a) abstractC3336Al1, this) == objE) {
                            return objE;
                        }
                    }
                } else {
                    if (i != 1 && i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class f implements View.OnLayoutChangeListener {
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                view.setTranslationX(-view.getWidth());
            }
        }

        public static final class g implements View.OnLayoutChangeListener {
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                view.setTranslationX(view.getWidth());
            }
        }

        public static final class h extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;
            final /* synthetic */ InterfaceC10258bL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public h(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC10258bL6 interfaceC10258bL6) {
                super(3, interfaceC20295rm1);
                this.e = interfaceC10258bL6;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC10258bL6 interfaceC10258bL6C = ((c) this.d) == c.b ? this.e : AbstractC6459Nq2.C();
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC10258bL6C, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                h hVar = new h(interfaceC20295rm1, this.e);
                hVar.c = interfaceC4806Gq2;
                hVar.d = obj;
                return hVar.invokeSuspend(C19938rB7.a);
            }
        }

        public static final class i implements IT5 {
            final /* synthetic */ NewVideoPlayerActivity b;

            public i(NewVideoPlayerActivity newVideoPlayerActivity) {
                this.b = newVideoPlayerActivity;
            }

            @Override // ir.nasim.IT5
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean b(Drawable drawable, Object obj, InterfaceC21549tj7 interfaceC21549tj7, EnumC21012sz1 enumC21012sz1, boolean z) {
                String stringExtra;
                AbstractC13042fc3.i(drawable, "resource");
                AbstractC13042fc3.i(obj, CommonUrlParts.MODEL);
                AbstractC13042fc3.i(enumC21012sz1, "dataSource");
                if (b.this.g.getValue() == c.b && !this.b.hasPostponedSharedElementTransitionStarted && (stringExtra = this.b.getIntent().getStringExtra("STARTER_TRANSITION_NAME_ARG")) != null && AbstractC20153rZ6.S(stringExtra, "thumb_", false, 2, null)) {
                    this.b.S0();
                    this.b.hasPostponedSharedElementTransitionStarted = true;
                }
                return false;
            }

            @Override // ir.nasim.IT5
            public boolean d(GlideException glideException, Object obj, InterfaceC21549tj7 interfaceC21549tj7, boolean z) {
                String stringExtra;
                AbstractC13042fc3.i(interfaceC21549tj7, "target");
                if (b.this.g.getValue() == c.b && !this.b.hasPostponedSharedElementTransitionStarted && (stringExtra = this.b.getIntent().getStringExtra("STARTER_TRANSITION_NAME_ARG")) != null && AbstractC20153rZ6.S(stringExtra, "thumb_", false, 2, null)) {
                    this.b.S0();
                    this.b.hasPostponedSharedElementTransitionStarted = true;
                }
                return false;
            }
        }

        public b(final NewVideoPlayerActivity newVideoPlayerActivity, ThumbnailContainer thumbnailContainer, PlayerStateButton playerStateButton, PhotoView photoView, InterfaceC20315ro1 interfaceC20315ro1, VI2 vi2, c cVar) {
            AbstractC13042fc3.i(thumbnailContainer, "page");
            AbstractC13042fc3.i(playerStateButton, "playerStateButton");
            AbstractC13042fc3.i(photoView, "thumbnailImageView");
            AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
            AbstractC13042fc3.i(vi2, "glideRequests");
            AbstractC13042fc3.i(cVar, "contentPosition");
            this.l = newVideoPlayerActivity;
            this.a = thumbnailContainer;
            this.b = playerStateButton;
            this.c = photoView;
            this.d = interfaceC20315ro1;
            this.e = vi2;
            this.f = AbstractC4043Dl1.c(thumbnailContainer.getContext(), JA5.n600_light);
            this.g = AbstractC12281eL6.a(cVar);
            thumbnailContainer.setVideoPlayerGestureListener(newVideoPlayerActivity.g3());
            J95 attacher = photoView.getAttacher();
            attacher.Q(true);
            attacher.c0(new InterfaceC17652nK4() { // from class: ir.nasim.videoplayer.f
                @Override // ir.nasim.InterfaceC17652nK4
                public final void a(View view, float f2, float f3) {
                    NewVideoPlayerActivity.b.P(newVideoPlayerActivity, view, f2, f3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(boolean z) {
            PlayerStateButton playerStateButton = this.b;
            playerStateButton.setClickable(z);
            playerStateButton.setFocusable(z);
            playerStateButton.animate().alpha(z ? 1.0f : 0.0f).setDuration(200L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PlayerStateButton G(InterfaceC17266mg5 interfaceC17266mg5) {
            if (interfaceC17266mg5 instanceof InterfaceC17266mg5.b) {
                PlayerStateButton playerStateButton = this.b;
                final NewVideoPlayerActivity newVideoPlayerActivity = this.l;
                playerStateButton.d();
                playerStateButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.videoplayer.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewVideoPlayerActivity.b.H(this.a, newVideoPlayerActivity, view);
                    }
                });
                return playerStateButton;
            }
            if (interfaceC17266mg5 instanceof InterfaceC17266mg5.a) {
                PlayerStateButton playerStateButton2 = this.b;
                playerStateButton2.c();
                playerStateButton2.setOnClickListener(null);
                return playerStateButton2;
            }
            if (interfaceC17266mg5 instanceof InterfaceC17266mg5.d) {
                PlayerStateButton playerStateButton3 = this.b;
                final NewVideoPlayerActivity newVideoPlayerActivity2 = this.l;
                playerStateButton3.e();
                playerStateButton3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.videoplayer.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        NewVideoPlayerActivity.b.I(newVideoPlayerActivity2, view);
                    }
                });
                return playerStateButton3;
            }
            if (!(interfaceC17266mg5 instanceof InterfaceC17266mg5.c)) {
                throw new NoWhenBranchMatchedException();
            }
            PlayerStateButton playerStateButton4 = this.b;
            final NewVideoPlayerActivity newVideoPlayerActivity3 = this.l;
            playerStateButton4.d();
            playerStateButton4.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.videoplayer.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewVideoPlayerActivity.b.J(newVideoPlayerActivity3, view);
                }
            });
            return playerStateButton4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void H(b bVar, NewVideoPlayerActivity newVideoPlayerActivity, View view) {
            AbstractC13042fc3.i(bVar, "this$0");
            AbstractC13042fc3.i(newVideoPlayerActivity, "this$1");
            bVar.b.c();
            newVideoPlayerActivity.h3().o3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(NewVideoPlayerActivity newVideoPlayerActivity, View view) {
            AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
            newVideoPlayerActivity.h3().n3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void J(NewVideoPlayerActivity newVideoPlayerActivity, View view) {
            AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
            newVideoPlayerActivity.h3().o3();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void K(C8792Xi5 c8792Xi5) {
            C4568Fr4 c4568Fr4C3 = this.l.c3();
            if (this.c.getVisibility() == 0 && c8792Xi5.d()) {
                this.c.setVisibility(8);
            }
            c4568Fr4C3.c.n0(c8792Xi5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void L(CV7 cv7) {
            String stringExtra;
            if (AbstractC13042fc3.d(cv7, CV7.a.a)) {
                if (this.g.getValue() == c.b && !this.l.hasPostponedSharedElementTransitionStarted && ((stringExtra = this.l.getIntent().getStringExtra("STARTER_TRANSITION_NAME_ARG")) == null || !AbstractC20153rZ6.S(stringExtra, "thumb_", false, 2, null))) {
                    this.l.S0();
                    this.l.hasPostponedSharedElementTransitionStarted = true;
                }
                this.a.setTouchable(true);
                this.c.setVisibility(8);
                this.a.setBackground(new ColorDrawable(0));
                return;
            }
            if (!(cv7 instanceof CV7.b)) {
                throw new NoWhenBranchMatchedException();
            }
            CV7.b bVar = (CV7.b) cv7;
            C15539jl1 c15539jl1F3 = this.l.f3(bVar.a());
            UI2 ui2C0 = this.e.z(bVar.b()).u0(new C5191Ih0(10, 3)).c0(c15539jl1F3.b(), c15539jl1F3.a());
            AbstractC13042fc3.h(ui2C0, "override(...)");
            UI2 ui2B0 = ui2C0.B0(new i(this.l));
            AbstractC13042fc3.h(ui2B0, "addListener(...)");
            ui2B0.Q0(this.c);
            this.a.setTouchable(false);
            this.c.setVisibility(0);
            this.a.setBackground(new ColorDrawable(this.f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void M(C12372eV7 c12372eV7) {
            int i2;
            AspectRatioFrameLayout aspectRatioFrameLayout = this.l.c3().b;
            int i3 = c12372eV7.b;
            aspectRatioFrameLayout.setAspectRatio((i3 == 0 || (i2 = c12372eV7.a) == 0) ? 0.0f : (i2 * c12372eV7.d) / i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void N(final EnumC9274Zf5 enumC9274Zf5) {
            VideoPlayerControllerView videoPlayerControllerView = this.l.c3().c;
            final NewVideoPlayerActivity newVideoPlayerActivity = this.l;
            videoPlayerControllerView.m0(enumC9274Zf5, new View.OnClickListener() { // from class: ir.nasim.videoplayer.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewVideoPlayerActivity.b.O(newVideoPlayerActivity, enumC9274Zf5, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void O(NewVideoPlayerActivity newVideoPlayerActivity, EnumC9274Zf5 enumC9274Zf5, View view) {
            AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
            AbstractC13042fc3.i(enumC9274Zf5, "$playbackSpeed");
            newVideoPlayerActivity.h3().C3(enumC9274Zf5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void P(NewVideoPlayerActivity newVideoPlayerActivity, View view, float f2, float f3) {
            AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
            AbstractC13042fc3.i(view, "<unused var>");
            newVideoPlayerActivity.g3().s().invoke(Float.valueOf(f2), Float.valueOf(f3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object t(AbstractC3336Al1.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objE = AbstractC20906so1.e(new C1671b(aVar, this.l, null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object u(AbstractC3336Al1.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objE = AbstractC20906so1.e(new c(bVar, this.l, null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object v(AbstractC3336Al1.c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objE = AbstractC20906so1.e(new d(cVar, this.l, null), interfaceC20295rm1);
            return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
        }

        private final void x(AbstractC3336Al1 abstractC3336Al1) {
            this.c.getAttacher().l0();
            if (AbstractC13042fc3.d(this.h, abstractC3336Al1)) {
                return;
            }
            this.h = abstractC3336Al1;
            InterfaceC13730gj3 interfaceC13730gj3 = this.i;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            this.i = null;
            if (abstractC3336Al1 == null) {
                AbstractC12990fW7.L0(this.c, null);
                this.j = null;
                this.a.setVisibility(8);
                return;
            }
            this.a.setVisibility(0);
            PhotoView photoView = this.c;
            photoView.setVisibility(0);
            photoView.setBackground(null);
            ViewGroup.LayoutParams layoutParams = photoView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            photoView.setLayoutParams(layoutParams);
            this.a.setBackground(new ColorDrawable(this.f));
            this.i = AbstractC10533bm0.d(this.d, null, null, new e(abstractC3336Al1, this, null), 3, null);
        }

        private final void y(c cVar) {
            Object value;
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, cVar));
            int i2 = a.a[cVar.ordinal()];
            if (i2 == 1) {
                ThumbnailContainer thumbnailContainer = this.a;
                if (thumbnailContainer.getWidth() > 0) {
                    thumbnailContainer.setTranslationX(-thumbnailContainer.getWidth());
                    return;
                } else if (!thumbnailContainer.isLaidOut() || thumbnailContainer.isLayoutRequested()) {
                    thumbnailContainer.addOnLayoutChangeListener(new f());
                    return;
                } else {
                    thumbnailContainer.setTranslationX(-thumbnailContainer.getWidth());
                    return;
                }
            }
            if (i2 == 2) {
                this.a.setTranslationX(0.0f);
                return;
            }
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            ThumbnailContainer thumbnailContainer2 = this.a;
            if (thumbnailContainer2.getWidth() > 0) {
                thumbnailContainer2.setTranslationX(thumbnailContainer2.getWidth());
            } else if (!thumbnailContainer2.isLaidOut() || thumbnailContainer2.isLayoutRequested()) {
                thumbnailContainer2.addOnLayoutChangeListener(new g());
            } else {
                thumbnailContainer2.setTranslationX(thumbnailContainer2.getWidth());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final InterfaceC4557Fq2 z(InterfaceC10258bL6 interfaceC10258bL6) {
            return AbstractC6459Nq2.s0(this.g, new h(null, interfaceC10258bL6));
        }

        public final ThumbnailContainer A() {
            return this.a;
        }

        public final PlayerStateButton B() {
            return this.b;
        }

        public final View C() {
            if (AbstractC13042fc3.d(this.k, this.c.getTransitionName())) {
                return this.c;
            }
            if (this.g.getValue() != c.b) {
                return null;
            }
            TextureView textureView = this.l.c3().k;
            AbstractC12990fW7.L0(textureView, this.k);
            return textureView;
        }

        public final View D() {
            return this.j;
        }

        public final PhotoView E() {
            return this.c;
        }

        public final void w(AbstractC3336Al1 abstractC3336Al1, c cVar) {
            AbstractC13042fc3.i(cVar, "contentPosition");
            y(cVar);
            x(abstractC3336Al1);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class c {
        public static final c a = new c("LEFT", 0);
        public static final c b = new c("CENTER", 1);
        public static final c c = new c("RIGHT", 2);
        private static final /* synthetic */ c[] d;
        private static final /* synthetic */ F92 e;

        static {
            c[] cVarArrA = a();
            d = cVarArrA;
            e = G92.a(cVarArrA);
        }

        private c(String str, int i) {
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{a, b, c};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) d.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    static final class d {
        public static final d a = new d("NONE", 0);
        public static final d b = new d("LEFT", 1);
        public static final d c = new d("RIGHT", 2);
        private static final /* synthetic */ d[] d;
        private static final /* synthetic */ F92 e;

        static {
            d[] dVarArrA = a();
            d = dVarArrA;
            e = G92.a(dVarArrA);
        }

        private d(String str, int i) {
        }

        private static final /* synthetic */ d[] a() {
            return new d[]{a, b, c};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) d.clone();
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[EnumC7541Sd6.values().length];
            try {
                iArr[EnumC7541Sd6.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC7541Sd6.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[d.values().length];
            try {
                iArr2[d.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[d.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[d.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
            int[] iArr3 = new int[EnumC23696xM4.values().length];
            try {
                iArr3[EnumC23696xM4.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[EnumC23696xM4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            c = iArr3;
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
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
                this.d.v3((G47) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(G47 g47, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(g47, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                b bVar = new b(this.d, interfaceC20295rm1);
                bVar.c = obj;
                return bVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                XE4 xe4 = (XE4) this.c;
                if (xe4 != null) {
                    this.d.l3(xe4);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(XE4 xe4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(xe4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                c cVar = new c(this.d, interfaceC20295rm1);
                cVar.c = obj;
                return cVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                XV4 xv4 = (XV4) this.c;
                boolean zBooleanValue = ((Boolean) xv4.a()).booleanValue();
                this.d.Y3(((Boolean) xv4.b()).booleanValue(), zBooleanValue);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((c) create(xv4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean y(NewVideoPlayerActivity newVideoPlayerActivity, boolean z, boolean z2, boolean z3, float f, float f2) {
                float width = newVideoPlayerActivity.getWindow().getDecorView().getWidth();
                if (f < 0.13f * width && z) {
                    newVideoPlayerActivity.n4();
                    return true;
                }
                if (f > width * 0.87f && z2) {
                    newVideoPlayerActivity.r4();
                    return true;
                }
                if (z3) {
                    newVideoPlayerActivity.h3().Y2();
                    return true;
                }
                newVideoPlayerActivity.h3().t3();
                return true;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                d dVar = new d(this.d, interfaceC20295rm1);
                dVar.c = obj;
                return dVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C17428mw7 c17428mw7 = (C17428mw7) this.c;
                final boolean zBooleanValue = ((Boolean) c17428mw7.a()).booleanValue();
                final boolean zBooleanValue2 = ((Boolean) c17428mw7.b()).booleanValue();
                final boolean zBooleanValue3 = ((Boolean) c17428mw7.c()).booleanValue();
                YT7 yt7G3 = this.d.g3();
                final NewVideoPlayerActivity newVideoPlayerActivity = this.d;
                yt7G3.A(new InterfaceC14603iB2() { // from class: ir.nasim.videoplayer.k
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(NewVideoPlayerActivity.f.d.y(newVideoPlayerActivity, zBooleanValue2, zBooleanValue3, zBooleanValue, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
                    }
                });
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C17428mw7 c17428mw7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((d) create(c17428mw7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                e eVar = new e(this.d, interfaceC20295rm1);
                eVar.c = obj;
                return eVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.N3((Spannable) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Spannable spannable, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((e) create(spannable, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$f, reason: collision with other inner class name */
        static final class C1702f extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1702f(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1702f c1702f = new C1702f(this.d, interfaceC20295rm1);
                c1702f.c = obj;
                return c1702f;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC14329hk1 abstractC14329hk1 = (AbstractC14329hk1) this.c;
                this.d.g4(abstractC14329hk1.c());
                this.d.S3(abstractC14329hk1.b());
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC14329hk1 abstractC14329hk1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1702f) create(abstractC14329hk1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                g gVar = new g(this.d, interfaceC20295rm1);
                gVar.c = obj;
                return gVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3336Al1 abstractC3336Al1 = (AbstractC3336Al1) this.c;
                NewVideoPlayerActivity newVideoPlayerActivity = this.d;
                ((b) newVideoPlayerActivity.d3().get(((newVideoPlayerActivity.indexOfCenterContentHolder - 1) + newVideoPlayerActivity.d3().size()) % newVideoPlayerActivity.d3().size())).w(abstractC3336Al1, c.a);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC3336Al1 abstractC3336Al1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((g) create(abstractC3336Al1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            h(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                h hVar = new h(this.d, interfaceC20295rm1);
                hVar.c = obj;
                return hVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3336Al1 abstractC3336Al1 = (AbstractC3336Al1) this.c;
                NewVideoPlayerActivity newVideoPlayerActivity = this.d;
                ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).w(abstractC3336Al1, c.b);
                if (abstractC3336Al1 instanceof AbstractC3336Al1.b) {
                    this.d.S2();
                    C4568Fr4 c4568Fr4C3 = this.d.c3();
                    c4568Fr4C3.c.setContentType(VideoPlayerControllerView.b.c);
                    AspectRatioFrameLayout aspectRatioFrameLayout = c4568Fr4C3.b;
                    AbstractC13042fc3.h(aspectRatioFrameLayout, "aspectRatioFrameLayout");
                    aspectRatioFrameLayout.setVisibility(8);
                    c4568Fr4C3.getRoot().setKeepScreenOn(false);
                } else if (abstractC3336Al1 instanceof AbstractC3336Al1.a) {
                    this.d.S2();
                    C4568Fr4 c4568Fr4C32 = this.d.c3();
                    c4568Fr4C32.c.setContentType(VideoPlayerControllerView.b.b);
                    AspectRatioFrameLayout aspectRatioFrameLayout2 = c4568Fr4C32.b;
                    AbstractC13042fc3.h(aspectRatioFrameLayout2, "aspectRatioFrameLayout");
                    aspectRatioFrameLayout2.setVisibility(8);
                    c4568Fr4C32.getRoot().setKeepScreenOn(true);
                } else {
                    if (!(abstractC3336Al1 instanceof AbstractC3336Al1.c)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.d.W2();
                    C4568Fr4 c4568Fr4C33 = this.d.c3();
                    c4568Fr4C33.c.setContentType(VideoPlayerControllerView.b.a);
                    AspectRatioFrameLayout aspectRatioFrameLayout3 = c4568Fr4C33.b;
                    AbstractC13042fc3.h(aspectRatioFrameLayout3, "aspectRatioFrameLayout");
                    aspectRatioFrameLayout3.setVisibility(0);
                    c4568Fr4C33.getRoot().setKeepScreenOn(true);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC3336Al1 abstractC3336Al1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((h) create(abstractC3336Al1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            i(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                i iVar = new i(this.d, interfaceC20295rm1);
                iVar.c = obj;
                return iVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC3336Al1 abstractC3336Al1 = (AbstractC3336Al1) this.c;
                NewVideoPlayerActivity newVideoPlayerActivity = this.d;
                ((b) newVideoPlayerActivity.d3().get((newVideoPlayerActivity.indexOfCenterContentHolder + 1) % newVideoPlayerActivity.d3().size())).w(abstractC3336Al1, c.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC3336Al1 abstractC3336Al1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((i) create(abstractC3336Al1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ NewVideoPlayerActivity d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = newVideoPlayerActivity;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                j jVar = new j(this.d, interfaceC20295rm1);
                jVar.c = obj;
                return jVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.d.r3((EnumC23696xM4) this.c);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC23696xM4 enumC23696xM4, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((j) create(enumC23696xM4, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$k$a$a, reason: collision with other inner class name */
                public static final class C1703a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$k$a$a$a, reason: collision with other inner class name */
                    public static final class C1704a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1704a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1703a.this.a(null, this);
                        }
                    }

                    public C1703a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.k.a.C1703a.C1704a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$k$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.k.a.C1703a.C1704a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$k$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$k$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.hk1 r5 = (ir.nasim.AbstractC14329hk1) r5
                            android.text.Spannable r5 = r5.a()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.k.a.C1703a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1703a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public k(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new k(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$l$a$a, reason: collision with other inner class name */
                public static final class C1705a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$l$a$a$a, reason: collision with other inner class name */
                    public static final class C1706a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1706a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1705a.this.a(null, this);
                        }
                    }

                    public C1705a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.l.a.C1705a.C1706a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$l$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.l.a.C1705a.C1706a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$l$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$l$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.Al1 r5 = r5.b()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.l.a.C1705a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1705a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public l(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new l(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$m$a$a, reason: collision with other inner class name */
                public static final class C1707a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$m$a$a$a, reason: collision with other inner class name */
                    public static final class C1708a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1708a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1707a.this.a(null, this);
                        }
                    }

                    public C1707a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.m.a.C1707a.C1708a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$m$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.m.a.C1707a.C1708a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$m$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$m$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.Al1 r5 = r5.a()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.m.a.C1707a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1707a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public m(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new m(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class n extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$n$a$a, reason: collision with other inner class name */
                public static final class C1709a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$n$a$a$a, reason: collision with other inner class name */
                    public static final class C1710a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1710a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1709a.this.a(null, this);
                        }
                    }

                    public C1709a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.n.a.C1709a.C1710a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$n$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.n.a.C1709a.C1710a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$n$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$n$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.Al1 r5 = r5.c()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.n.a.C1709a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1709a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public n(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new n(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((n) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class o extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$o$a$a, reason: collision with other inner class name */
                public static final class C1711a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$o$a$a$a, reason: collision with other inner class name */
                    public static final class C1712a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1712a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1711a.this.a(null, this);
                        }
                    }

                    public C1711a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.o.a.C1711a.C1712a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$o$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.o.a.C1711a.C1712a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$o$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$o$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.xM4 r5 = r5.e()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.o.a.C1711a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1711a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public o(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new o(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((o) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class p extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$p$a$a, reason: collision with other inner class name */
                public static final class C1713a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$p$a$a$a, reason: collision with other inner class name */
                    public static final class C1714a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1714a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1713a.this.a(null, this);
                        }
                    }

                    public C1713a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.p.a.C1713a.C1714a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$p$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.p.a.C1713a.C1714a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$p$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$p$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.G47 r5 = r5.f()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.p.a.C1713a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1713a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public p(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new p(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((p) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class q extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$q$a$a, reason: collision with other inner class name */
                public static final class C1715a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$q$a$a$a, reason: collision with other inner class name */
                    public static final class C1716a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1716a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1715a.this.a(null, this);
                        }
                    }

                    public C1715a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.q.a.C1715a.C1716a
                            if (r0 == 0) goto L13
                            r0 = r6
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$q$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.q.a.C1715a.C1716a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$q$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$q$a$a$a
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r6)
                            goto L45
                        L29:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L31:
                            ir.nasim.AbstractC10685c16.b(r6)
                            ir.nasim.Gq2 r6 = r4.a
                            ir.nasim.cA7 r5 = (ir.nasim.C10776cA7) r5
                            ir.nasim.XE4 r5 = r5.d()
                            r0.b = r3
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L45
                            return r1
                        L45:
                            ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.q.a.C1715a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1715a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public q(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new q(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((q) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class r extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$r$a$a, reason: collision with other inner class name */
                public static final class C1717a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$r$a$a$a, reason: collision with other inner class name */
                    public static final class C1718a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1718a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1717a.this.a(null, this);
                        }
                    }

                    public C1717a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.r.a.C1717a.C1718a
                            if (r0 == 0) goto L13
                            r0 = r7
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$r$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.r.a.C1717a.C1718a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$r$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$r$a$a$a
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r7)
                            goto L5e
                        L29:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L31:
                            ir.nasim.AbstractC10685c16.b(r7)
                            ir.nasim.Gq2 r7 = r5.a
                            ir.nasim.cA7 r6 = (ir.nasim.C10776cA7) r6
                            ir.nasim.Al1 r2 = r6.b()
                            r4 = 0
                            if (r2 == 0) goto L41
                            r2 = r3
                            goto L42
                        L41:
                            r2 = r4
                        L42:
                            java.lang.Boolean r2 = ir.nasim.AbstractC6392Nk0.a(r2)
                            ir.nasim.Al1 r6 = r6.c()
                            if (r6 == 0) goto L4d
                            r4 = r3
                        L4d:
                            java.lang.Boolean r6 = ir.nasim.AbstractC6392Nk0.a(r4)
                            ir.nasim.XV4 r6 = ir.nasim.AbstractC4616Fw7.a(r2, r6)
                            r0.b = r3
                            java.lang.Object r6 = r7.a(r6, r0)
                            if (r6 != r1) goto L5e
                            return r1
                        L5e:
                            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.r.a.C1717a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1717a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public r(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new r(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((r) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class s extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC4557Fq2 c;
            final /* synthetic */ InterfaceC14603iB2 d;
            final /* synthetic */ InterfaceC14603iB2 e;

            public static final class a implements InterfaceC4557Fq2 {
                final /* synthetic */ InterfaceC4557Fq2 a;

                /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$s$a$a, reason: collision with other inner class name */
                public static final class C1719a implements InterfaceC4806Gq2 {
                    final /* synthetic */ InterfaceC4806Gq2 a;

                    /* renamed from: ir.nasim.videoplayer.NewVideoPlayerActivity$f$s$a$a$a, reason: collision with other inner class name */
                    public static final class C1720a extends AbstractC22163um1 {
                        /* synthetic */ Object a;
                        int b;

                        public C1720a(InterfaceC20295rm1 interfaceC20295rm1) {
                            super(interfaceC20295rm1);
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            this.a = obj;
                            this.b |= RecyclerView.UNDEFINED_DURATION;
                            return C1719a.this.a(null, this);
                        }
                    }

                    public C1719a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                        this.a = interfaceC4806Gq2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // ir.nasim.InterfaceC4806Gq2
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof ir.nasim.videoplayer.NewVideoPlayerActivity.f.s.a.C1719a.C1720a
                            if (r0 == 0) goto L13
                            r0 = r8
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$s$a$a$a r0 = (ir.nasim.videoplayer.NewVideoPlayerActivity.f.s.a.C1719a.C1720a) r0
                            int r1 = r0.b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.b = r1
                            goto L18
                        L13:
                            ir.nasim.videoplayer.NewVideoPlayerActivity$f$s$a$a$a r0 = new ir.nasim.videoplayer.NewVideoPlayerActivity$f$s$a$a$a
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.a
                            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                            int r2 = r0.b
                            r3 = 1
                            if (r2 == 0) goto L31
                            if (r2 != r3) goto L29
                            ir.nasim.AbstractC10685c16.b(r8)
                            goto L6b
                        L29:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L31:
                            ir.nasim.AbstractC10685c16.b(r8)
                            ir.nasim.Gq2 r8 = r6.a
                            ir.nasim.cA7 r7 = (ir.nasim.C10776cA7) r7
                            ir.nasim.Al1 r2 = r7.b()
                            r4 = 0
                            if (r2 == 0) goto L41
                            r2 = r3
                            goto L42
                        L41:
                            r2 = r4
                        L42:
                            ir.nasim.Al1 r5 = r7.c()
                            if (r5 == 0) goto L49
                            r4 = r3
                        L49:
                            ir.nasim.G47 r7 = r7.f()
                            boolean r7 = r7.b()
                            ir.nasim.mw7 r5 = new ir.nasim.mw7
                            java.lang.Boolean r7 = ir.nasim.AbstractC6392Nk0.a(r7)
                            java.lang.Boolean r2 = ir.nasim.AbstractC6392Nk0.a(r2)
                            java.lang.Boolean r4 = ir.nasim.AbstractC6392Nk0.a(r4)
                            r5.<init>(r7, r2, r4)
                            r0.b = r3
                            java.lang.Object r7 = r8.a(r5, r0)
                            if (r7 != r1) goto L6b
                            return r1
                        L6b:
                            ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.f.s.a.C1719a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
                    }
                }

                public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
                    this.a = interfaceC4557Fq2;
                }

                @Override // ir.nasim.InterfaceC4557Fq2
                public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
                    Object objB = this.a.b(new C1719a(interfaceC4806Gq2), interfaceC20295rm1);
                    return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public s(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC4557Fq2;
                this.d = interfaceC14603iB2;
                this.e = interfaceC14603iB22;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new s(this.c, this.d, this.e, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(new a(this.c), this.d);
                    InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                    this.b = 1;
                    if (AbstractC6459Nq2.l(interfaceC4557Fq2W, interfaceC14603iB2, this) == objE) {
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
                return ((s) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        public static final class t extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public t(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2A = ((C10776cA7) this.d).a().a();
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                t tVar = new t(interfaceC20295rm1);
                tVar.c = interfaceC4806Gq2;
                tVar.d = obj;
                return tVar.invokeSuspend(C19938rB7.a);
            }
        }

        public static final class u extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            private /* synthetic */ Object c;
            /* synthetic */ Object d;

            public u(InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2A = ((C10776cA7) this.d).a().a();
                    this.b = 1;
                    if (AbstractC6459Nq2.A(interfaceC4806Gq2, interfaceC4557Fq2A, this) == objE) {
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

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                u uVar = new u(interfaceC20295rm1);
                uVar.c = interfaceC4806Gq2;
                uVar.d = obj;
                return uVar.invokeSuspend(C19938rB7.a);
            }
        }

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean D(Spannable spannable, Spannable spannable2) {
            return AbstractC20153rZ6.y(spannable, spannable2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean z(AbstractC14329hk1 abstractC14329hk1, AbstractC14329hk1 abstractC14329hk12) {
            return AbstractC13042fc3.d(abstractC14329hk1.c(), abstractC14329hk12.c()) && AbstractC13042fc3.d(abstractC14329hk1.b(), abstractC14329hk12.b());
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = NewVideoPlayerActivity.this.new f(interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i2 = this.b;
            if (i2 == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC10258bL6 interfaceC10258bL6N2 = NewVideoPlayerActivity.this.h3().N2();
                g gVar = new g(NewVideoPlayerActivity.this, null);
                C13297fz4 c13297fz4 = C13297fz4.a;
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new l(interfaceC10258bL6N2, c13297fz4, gVar, null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new m(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new h(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new n(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new i(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new o(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new j(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new p(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new a(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new q(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new b(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new r(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new c(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new s(NewVideoPlayerActivity.this.h3().N2(), c13297fz4, new d(NewVideoPlayerActivity.this, null), null), 3, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new k(AbstractC6459Nq2.s0(NewVideoPlayerActivity.this.h3().N2(), new t(null)), new InterfaceC14603iB2() { // from class: ir.nasim.videoplayer.i
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(NewVideoPlayerActivity.f.D((Spannable) obj2, (Spannable) obj3));
                    }
                }, new e(NewVideoPlayerActivity.this, null), null), 3, null);
                InterfaceC4557Fq2 interfaceC4557Fq2W = AbstractC6459Nq2.w(AbstractC6459Nq2.s0(NewVideoPlayerActivity.this.h3().N2(), new u(null)), new InterfaceC14603iB2() { // from class: ir.nasim.videoplayer.j
                    @Override // ir.nasim.InterfaceC14603iB2
                    public final Object invoke(Object obj2, Object obj3) {
                        return Boolean.valueOf(NewVideoPlayerActivity.f.z((AbstractC14329hk1) obj2, (AbstractC14329hk1) obj3));
                    }
                });
                C1702f c1702f = new C1702f(NewVideoPlayerActivity.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2W, c1702f, this) == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;
        final /* synthetic */ NewVideoPlayerActivity b;

        public g(View view, NewVideoPlayerActivity newVideoPlayerActivity) {
            this.a = view;
            this.b = newVideoPlayerActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NewVideoPlayerActivity.E3(this.b, null, false, false, false, null, 31, null);
            this.b.M3();
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public static final class h implements InterfaceC17517n6 {
        private UA2 a = new UA2() { // from class: ir.nasim.gz4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return NewVideoPlayerActivity.h.d(((Boolean) obj).booleanValue());
            }
        };

        h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(boolean z) {
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC17517n6
        public /* bridge */ /* synthetic */ void a(Object obj) {
            c(((Boolean) obj).booleanValue());
        }

        public void c(boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }

        public final void e(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "<set-?>");
            this.a = ua2;
        }
    }

    public static final class i implements SeekBar.OnSeekBarChangeListener {
        i() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            AbstractC13042fc3.i(seekBar, "seekBar");
            if (z) {
                NewVideoPlayerActivity.this.h3().h3(i * 10);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            AbstractC13042fc3.i(seekBar, "seekBar");
            NewVideoPlayerActivity.this.h3().w3(seekBar.getProgress() * 10);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            AbstractC13042fc3.i(seekBar, "seekBar");
            NewVideoPlayerActivity.this.h3().y3(seekBar.getProgress() * 10);
        }
    }

    public static final class j extends AbstractC9203Yx6 {
        final /* synthetic */ C9663aL5 b;
        final /* synthetic */ NewVideoPlayerActivity c;
        final /* synthetic */ NI0 d;

        j(C9663aL5 c9663aL5, NewVideoPlayerActivity newVideoPlayerActivity, NI0 ni0) {
            this.b = c9663aL5;
            this.c = newVideoPlayerActivity;
            this.d = ni0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(View view) {
            AbstractC13042fc3.i(view, "$view");
            Drawable background = view.getBackground();
            if (background != null) {
                background.setAlpha(255);
            }
        }

        @Override // ir.nasim.AbstractC9203Yx6
        public Parcelable b(View view, Matrix matrix, RectF rectF) {
            AbstractC13042fc3.i(view, "sharedElement");
            AbstractC13042fc3.i(matrix, "viewToGlobalMatrix");
            AbstractC13042fc3.i(rectF, "screenBounds");
            Parcelable parcelableB = super.b(view, matrix, rectF);
            if (parcelableB == null) {
                return null;
            }
            C19406qI3.a("NewVideoPlayerActivity", "onCaptureSharedElementSnapshot(" + view + Separators.RPAREN, new Object[0]);
            return parcelableB;
        }

        @Override // ir.nasim.AbstractC9203Yx6
        public View d(Context context, Parcelable parcelable) {
            AbstractC13042fc3.i(context, "context");
            C19406qI3.a("NewVideoPlayerActivity", "onCreateSnapshotView(" + parcelable + Separators.RPAREN, new Object[0]);
            if (!(parcelable instanceof CapturedSharedElement)) {
                return super.d(context, parcelable);
            }
            CapturedSharedElement capturedSharedElement = (CapturedSharedElement) parcelable;
            View viewD = super.d(context, capturedSharedElement.getParcelable());
            if (viewD == null) {
                return null;
            }
            viewD.setClipBounds(capturedSharedElement.getClipBounds());
            viewD.setOutlineProvider(new C21356tW7(capturedSharedElement.getCorners()));
            viewD.setClipToOutline(true);
            return viewD;
        }

        @Override // ir.nasim.AbstractC9203Yx6
        public void e(List list, Map map) {
            Object next;
            String transitionName;
            AbstractC13042fc3.i(list, "names");
            AbstractC13042fc3.i(map, "sharedElements");
            C19406qI3.a("NewVideoPlayerActivity", "onMapSharedElements(" + list + ", " + map + Separators.RPAREN, new Object[0]);
            if (this.b.a) {
                map.clear();
                NewVideoPlayerActivity newVideoPlayerActivity = this.c;
                View viewC = ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).C();
                if (viewC == null || (transitionName = viewC.getTransitionName()) == null) {
                    return;
                }
                if (list.contains(transitionName)) {
                    map.put(transitionName, viewC);
                    this.d.c(viewC);
                }
            } else {
                NewVideoPlayerActivity newVideoPlayerActivity2 = this.c;
                View viewD = ((b) newVideoPlayerActivity2.d3().get(newVideoPlayerActivity2.indexOfCenterContentHolder)).D();
                if (viewD == null) {
                    return;
                }
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (AbstractC13042fc3.d(viewD.getTransitionName(), (String) next)) {
                            break;
                        }
                    }
                }
                String str = (String) next;
                if (str == null) {
                    return;
                } else {
                    map.put(str, viewD);
                }
            }
            C19406qI3.a("NewVideoPlayerActivity", "onMapSharedElements(" + list + ", " + map + Separators.RPAREN, new Object[0]);
        }

        @Override // ir.nasim.AbstractC9203Yx6
        public void g(List list, List list2, List list3) {
            Drawable background;
            AbstractC13042fc3.i(list, "sharedElementNames");
            AbstractC13042fc3.i(list2, "sharedElements");
            AbstractC13042fc3.i(list3, "sharedElementSnapshots");
            int size = list2.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list2.get(i);
                view.setClipBounds(null);
                view.setOutlineProvider(null);
                view.setClipToOutline(false);
            }
            C9663aL5 c9663aL5 = this.b;
            if (c9663aL5.a) {
                this.c.h3().i3();
                NewVideoPlayerActivity newVideoPlayerActivity = this.c;
                View viewD = ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).D();
                if (viewD != null && (background = viewD.getBackground()) != null) {
                    background.setAlpha(0);
                }
            } else {
                c9663aL5.a = true;
            }
            C19406qI3.a("NewVideoPlayerActivity", "onSharedElementEnd()", new Object[0]);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
        @Override // ir.nasim.AbstractC9203Yx6
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(java.util.List r8, java.util.List r9, java.util.List r10) {
            /*
                r7 = this;
                java.lang.String r0 = "sharedElementNames"
                ir.nasim.AbstractC13042fc3.i(r8, r0)
                java.lang.String r8 = "sharedElements"
                ir.nasim.AbstractC13042fc3.i(r9, r8)
                java.lang.String r8 = "sharedElementSnapshots"
                ir.nasim.AbstractC13042fc3.i(r10, r8)
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "onSharedElementStart("
                r8.append(r0)
                r8.append(r10)
                java.lang.String r0 = ")"
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                r0 = 0
                java.lang.Object[] r1 = new java.lang.Object[r0]
                java.lang.String r2 = "NewVideoPlayerActivity"
                ir.nasim.C19406qI3.a(r2, r8, r1)
                r8 = r9
                java.util.Collection r8 = (java.util.Collection) r8
                int r1 = r8.size()
                r2 = r0
            L35:
                if (r2 >= r1) goto L69
                java.lang.Object r3 = ir.nasim.ZW0.t0(r10, r2)
                android.view.View r3 = (android.view.View) r3
                java.lang.Object r4 = r9.get(r2)
                android.view.View r4 = (android.view.View) r4
                r5 = 0
                if (r3 == 0) goto L4b
                android.graphics.Rect r6 = r3.getClipBounds()
                goto L4c
            L4b:
                r6 = r5
            L4c:
                r4.setClipBounds(r6)
                if (r3 == 0) goto L55
                android.view.ViewOutlineProvider r5 = r3.getOutlineProvider()
            L55:
                r4.setOutlineProvider(r5)
                if (r3 == 0) goto L62
                boolean r3 = r3.getClipToOutline()
                r5 = 1
                if (r3 != r5) goto L62
                goto L63
            L62:
                r5 = r0
            L63:
                r4.setClipToOutline(r5)
                int r2 = r2 + 1
                goto L35
            L69:
                ir.nasim.aL5 r10 = r7.b
                boolean r10 = r10.a
                if (r10 == 0) goto L82
                int r8 = r8.size()
                r10 = r0
            L74:
                if (r10 >= r8) goto Lac
                java.lang.Object r1 = r9.get(r10)
                android.view.View r1 = (android.view.View) r1
                r1.setVisibility(r0)
                int r10 = r10 + 1
                goto L74
            L82:
                ir.nasim.videoplayer.NewVideoPlayerActivity r8 = r7.c
                java.util.List r9 = ir.nasim.videoplayer.NewVideoPlayerActivity.k2(r8)
                int r8 = ir.nasim.videoplayer.NewVideoPlayerActivity.n2(r8)
                java.lang.Object r8 = r9.get(r8)
                ir.nasim.videoplayer.NewVideoPlayerActivity$b r8 = (ir.nasim.videoplayer.NewVideoPlayerActivity.b) r8
                android.view.View r8 = r8.D()
                if (r8 != 0) goto L99
                return
            L99:
                android.graphics.drawable.Drawable r9 = r8.getBackground()
                if (r9 == 0) goto La2
                r9.setAlpha(r0)
            La2:
                ir.nasim.hz4 r9 = new ir.nasim.hz4
                r9.<init>()
                r0 = 200(0xc8, double:9.9E-322)
                r8.postDelayed(r9, r0)
            Lac:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.videoplayer.NewVideoPlayerActivity.j.h(java.util.List, java.util.List, java.util.List):void");
        }

        @Override // ir.nasim.AbstractC9203Yx6
        public void i(List list, List list2, AbstractC9203Yx6.a aVar) {
            AbstractC13042fc3.i(list, "sharedElementNames");
            AbstractC13042fc3.i(list2, "sharedElements");
            AbstractC13042fc3.i(aVar, "listener");
            if (this.b.a) {
                if (list2.isEmpty()) {
                    this.c.h3().i3();
                }
                this.c.hasSharedElementBeenReturned = true;
            }
            super.i(list, list2, aVar);
            C19406qI3.a("NewVideoPlayerActivity", "onSharedElementsArrived(" + list2 + Separators.RPAREN, new Object[0]);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC4557Fq2 c;
        final /* synthetic */ ProgressDialog d;

        static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
            int b;
            final /* synthetic */ ProgressDialog c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ProgressDialog progressDialog, InterfaceC20295rm1 interfaceC20295rm1) {
                super(3, interfaceC20295rm1);
                this.c = progressDialog;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                this.c.dismiss();
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC15796kB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
            }
        }

        static final class b implements InterfaceC4806Gq2 {
            final /* synthetic */ ProgressDialog a;

            b(ProgressDialog progressDialog) {
                this.a = progressDialog;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            public /* bridge */ /* synthetic */ Object a(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return b(((Number) obj).intValue(), interfaceC20295rm1);
            }

            public final Object b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.setProgress(i);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(InterfaceC4557Fq2 interfaceC4557Fq2, ProgressDialog progressDialog, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC4557Fq2;
            this.d = progressDialog;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A0 = AbstractC6459Nq2.a0(this.c, new a(this.d, null));
                b bVar = new b(this.d);
                this.b = 1;
                if (interfaceC4557Fq2A0.b(bVar, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final G.c invoke() {
            return this.e.n3();
        }
    }

    public static final class m extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ ComponentActivity e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(ComponentActivity componentActivity) {
            super(0);
            this.e = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C14819iX7 invoke() {
            return this.e.d1();
        }
    }

    public static final class n extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ ComponentActivity f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(SA2 sa2, ComponentActivity componentActivity) {
            super(0);
            this.e = sa2;
            this.f = componentActivity;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC20375ru1 invoke() {
            AbstractC20375ru1 abstractC20375ru1;
            SA2 sa2 = this.e;
            return (sa2 == null || (abstractC20375ru1 = (AbstractC20375ru1) sa2.invoke()) == null) ? this.f.p3() : abstractC20375ru1;
        }
    }

    public NewVideoPlayerActivity() {
        EnumC4870Gx3 enumC4870Gx3 = EnumC4870Gx3.c;
        this.binding = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.Zy4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.J2(this.a);
            }
        });
        this.viewModel = new F(AbstractC10882cM5.b(C21015sz4.class), new m(this), new l(this), new n(null, this));
        this.glideRequests = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.az4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.k3(this.a);
            }
        });
        this.windowInsetsController = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.bz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.u4(this.a);
            }
        });
        this.videoPlayerGestureListener = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.cz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.t4(this.a);
            }
        });
        this.screenOrientationController = new C3976Dd6(this);
        this.indexOfCenterContentHolder = 1;
        this.contentHolders = AbstractC13269fw3.b(enumC4870Gx3, new SA2() { // from class: ir.nasim.dz4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.Q2(this.a);
            }
        });
        this.permissionResultCallback = new h();
    }

    private final void A3() {
        if (this.isMovingVertically) {
            this.isMovingVertically = false;
            c3().getRoot().getBackground().setAlpha(255);
            ((b) d3().get(this.indexOfCenterContentHolder)).A().getBackground().setAlpha(255);
            c3().b.getBackground().setAlpha(255);
        }
    }

    private final void C3(float translationY) {
        if (!this.isMovingVertically) {
            z3();
        }
        c3().getRoot().getBackground().setAlpha(255 - AbstractC23053wG5.m(AbstractC20723sV3.d(Math.abs(translationY) / ((int) ((1 * AbstractC3742Cd6.c()) + 0.5d))), 0, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER));
    }

    private final void D3(final d swipe, boolean leftAnimated, boolean centerAnimated, boolean rightAnimated, final SA2 onAnimationEnded) {
        L3(((b) d3().get(((this.indexOfCenterContentHolder - 1) + d3().size()) % d3().size())).A(), -getWindow().getDecorView().getWidth(), leftAnimated);
        float width = 0.0f;
        ViewPropertyAnimator viewPropertyAnimatorL3 = L3(((b) d3().get(this.indexOfCenterContentHolder)).A(), 0.0f, centerAnimated);
        if (viewPropertyAnimatorL3 != null) {
            viewPropertyAnimatorL3.withEndAction(new Runnable() { // from class: ir.nasim.ez4
                @Override // java.lang.Runnable
                public final void run() {
                    NewVideoPlayerActivity.H3(onAnimationEnded);
                }
            });
        }
        L3(((b) d3().get((this.indexOfCenterContentHolder + 1) % d3().size())).A(), getWindow().getDecorView().getWidth(), rightAnimated);
        int i2 = e.b[swipe.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                width = getWindow().getDecorView().getWidth();
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                width = -getWindow().getDecorView().getWidth();
            }
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = c3().b;
        AbstractC13042fc3.h(aspectRatioFrameLayout, "aspectRatioFrameLayout");
        ViewPropertyAnimator viewPropertyAnimatorL32 = L3(aspectRatioFrameLayout, width, centerAnimated);
        if (viewPropertyAnimatorL32 != null) {
            viewPropertyAnimatorL32.withEndAction(new Runnable() { // from class: ir.nasim.videoplayer.a
                @Override // java.lang.Runnable
                public final void run() {
                    NewVideoPlayerActivity.K3(swipe, this);
                }
            });
        }
    }

    static /* synthetic */ void E3(NewVideoPlayerActivity newVideoPlayerActivity, d dVar, boolean z, boolean z2, boolean z3, SA2 sa2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dVar = d.a;
        }
        boolean z4 = (i2 & 2) != 0 ? true : z;
        boolean z5 = (i2 & 4) != 0 ? true : z2;
        boolean z6 = (i2 & 8) == 0 ? z3 : true;
        if ((i2 & 16) != 0) {
            sa2 = new SA2() { // from class: ir.nasim.Ay4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return NewVideoPlayerActivity.F3();
                }
            };
        }
        newVideoPlayerActivity.D3(dVar, z4, z5, z6, sa2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F3() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H3(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$tmp0");
        sa2.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4568Fr4 J2(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        C4568Fr4 c4568Fr4C = C4568Fr4.c(newVideoPlayerActivity.getLayoutInflater());
        c4568Fr4C.getRoot().getBackground().setAlpha(255);
        return c4568Fr4C;
    }

    private final InterfaceC13730gj3 K2() {
        return AbstractC16751lo1.b(this, j.b.STARTED, new f(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(d dVar, NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(dVar, "$swipe");
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        if (dVar != d.a) {
            AspectRatioFrameLayout aspectRatioFrameLayout = newVideoPlayerActivity.c3().b;
            AbstractC13042fc3.f(aspectRatioFrameLayout);
            aspectRatioFrameLayout.setVisibility(8);
            aspectRatioFrameLayout.setTranslationX(0.0f);
        }
    }

    private static final ViewPropertyAnimator L3(View view, float f2, boolean z) {
        if (z) {
            return view.animate().translationX(f2).setDuration(200L);
        }
        view.setTranslationX(f2);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M3() {
        Iterator it = d3().iterator();
        while (it.hasNext()) {
            ((b) it.next()).A().animate().translationY(0.0f).setDuration(200L);
        }
        c3().b.animate().translationY(0.0f).setDuration(200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N3(Spannable caption) {
        final C4568Fr4 c4568Fr4C3 = c3();
        if (!C8386Vt0.Q7()) {
            c4568Fr4C3.c.h0(caption, new UA2() { // from class: ir.nasim.Qy4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return NewVideoPlayerActivity.P3(this.a, ((Boolean) obj).booleanValue());
                }
            });
        } else {
            c4568Fr4C3.j.i0(caption);
            c4568Fr4C3.j.setOnScrollListener(new ScrollableCaption.b() { // from class: ir.nasim.Py4
                @Override // ir.nasim.videoplayer.ui.component.ScrollableCaption.b
                public final void a(ScrollableCaption.c cVar) {
                    NewVideoPlayerActivity.O3(c4568Fr4C3, this, cVar);
                }
            });
        }
    }

    private final void O2() {
        final C4568Fr4 c4568Fr4C3 = c3();
        final C11637dL5 c11637dL5 = new C11637dL5();
        AbstractC12990fW7.E0(getWindow().getDecorView(), new InterfaceC22474vI4() { // from class: ir.nasim.Vy4
            @Override // ir.nasim.InterfaceC22474vI4
            public final O98 b(View view, O98 o98) {
                return NewVideoPlayerActivity.P2(c11637dL5, c4568Fr4C3, view, o98);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(C4568Fr4 c4568Fr4, NewVideoPlayerActivity newVideoPlayerActivity, ScrollableCaption.c cVar) {
        AbstractC13042fc3.i(c4568Fr4, "$this_with");
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(cVar, "state");
        boolean z = cVar.a() + c4568Fr4.o.getBottom() < ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).B().getBottom();
        if ((cVar instanceof ScrollableCaption.c.b) || (cVar instanceof ScrollableCaption.c.C1721c)) {
            newVideoPlayerActivity.h3().j3(true, z);
        } else {
            if (!(cVar instanceof ScrollableCaption.c.a)) {
                throw new NoWhenBranchMatchedException();
            }
            newVideoPlayerActivity.h3().l3(false, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O98 P2(C11637dL5 c11637dL5, C4568Fr4 c4568Fr4, View view, O98 o98) {
        AbstractC13042fc3.i(c11637dL5, "$capturedStatusBarHeight");
        AbstractC13042fc3.i(c4568Fr4, "$this_with");
        AbstractC13042fc3.i(view, "<unused var>");
        AbstractC13042fc3.i(o98, "insets");
        L93 l93F = o98.f(O98.m.i());
        AbstractC13042fc3.h(l93F, "getInsets(...)");
        int i2 = l93F.b;
        if (i2 > 0) {
            c11637dL5.a = i2;
        }
        C19406qI3.a("NewVideoPlayerActivity", "windowInsetsChanged(captured: " + c11637dL5.a + ", current: " + i2 + Separators.RPAREN, new Object[0]);
        BaleToolbar baleToolbar = c4568Fr4.o;
        AbstractC13042fc3.h(baleToolbar, "toolbar");
        baleToolbar.setPadding(l93F.a, c11637dL5.a, l93F.c, baleToolbar.getPaddingBottom());
        c4568Fr4.c.onApplyWindowInsets(o98.y());
        c4568Fr4.j.onApplyWindowInsets(o98.y());
        return O98.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P3(NewVideoPlayerActivity newVideoPlayerActivity, boolean z) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        if (z) {
            C21015sz4.k3(newVideoPlayerActivity.h3(), false, false, 3, null);
        } else {
            C21015sz4.m3(newVideoPlayerActivity.h3(), false, false, 3, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Q2(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        C4568Fr4 c4568Fr4C3 = newVideoPlayerActivity.c3();
        ThumbnailContainer thumbnailContainer = c4568Fr4C3.d;
        AbstractC13042fc3.h(thumbnailContainer, "page1");
        PlayerStateButton playerStateButton = c4568Fr4C3.g;
        AbstractC13042fc3.h(playerStateButton, "playerStateButton1");
        PhotoView photoView = c4568Fr4C3.l;
        AbstractC13042fc3.h(photoView, "thumbnailImageView1");
        b bVar = new b(newVideoPlayerActivity, thumbnailContainer, playerStateButton, photoView, AbstractC19224pz3.a(newVideoPlayerActivity), newVideoPlayerActivity.e3(), c.a);
        ThumbnailContainer thumbnailContainer2 = c4568Fr4C3.e;
        AbstractC13042fc3.h(thumbnailContainer2, "page2");
        PlayerStateButton playerStateButton2 = c4568Fr4C3.h;
        AbstractC13042fc3.h(playerStateButton2, "playerStateButton2");
        PhotoView photoView2 = c4568Fr4C3.m;
        AbstractC13042fc3.h(photoView2, "thumbnailImageView2");
        b bVar2 = new b(newVideoPlayerActivity, thumbnailContainer2, playerStateButton2, photoView2, AbstractC19224pz3.a(newVideoPlayerActivity), newVideoPlayerActivity.e3(), c.b);
        ThumbnailContainer thumbnailContainer3 = c4568Fr4C3.f;
        AbstractC13042fc3.h(thumbnailContainer3, "page3");
        PlayerStateButton playerStateButton3 = c4568Fr4C3.i;
        AbstractC13042fc3.h(playerStateButton3, "playerStateButton3");
        PhotoView photoView3 = c4568Fr4C3.n;
        AbstractC13042fc3.h(photoView3, "thumbnailImageView3");
        return AbstractC10360bX0.p(bVar, bVar2, new b(newVideoPlayerActivity, thumbnailContainer3, playerStateButton3, photoView3, AbstractC19224pz3.a(newVideoPlayerActivity), newVideoPlayerActivity.e3(), c.c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S2() {
        YT7 yt7G3 = g3();
        yt7G3.x(new InterfaceC14603iB2() { // from class: ir.nasim.Fy4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(NewVideoPlayerActivity.T2(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        });
        yt7G3.B(new InterfaceC14603iB2() { // from class: ir.nasim.Gy4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(NewVideoPlayerActivity.U2(((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        });
        yt7G3.y(new InterfaceC14603iB2() { // from class: ir.nasim.Hy4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return NewVideoPlayerActivity.V2(((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S3(String senderName) {
        c3().o.setTitle(senderName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean T2(float f2, float f3) {
        return false;
    }

    private final void T3() {
        C4568Fr4 c4568Fr4C3 = c3();
        if (C8386Vt0.Q7()) {
            c4568Fr4C3.c.h0(null, new UA2() { // from class: ir.nasim.Ky4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return NewVideoPlayerActivity.U3(((Boolean) obj).booleanValue());
                }
            });
            return;
        }
        ScrollableCaption scrollableCaption = c4568Fr4C3.j;
        AbstractC13042fc3.h(scrollableCaption, "scrollableCaption");
        scrollableCaption.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean U2(float f2, float f3) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U3(boolean z) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V2(float f2, float f3) {
        return C19938rB7.a;
    }

    private final void V3() {
        VideoPlayerControllerView videoPlayerControllerView = c3().c;
        videoPlayerControllerView.setOnSeekbarChangeListener(new i());
        videoPlayerControllerView.setPlayer(h3().J2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2() {
        YT7 yt7G3 = g3();
        yt7G3.x(new InterfaceC14603iB2() { // from class: ir.nasim.Iy4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(NewVideoPlayerActivity.X2(this.a, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        });
        yt7G3.B(new InterfaceC14603iB2() { // from class: ir.nasim.Jy4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(NewVideoPlayerActivity.Y2(this.a, ((Float) obj).floatValue(), ((Float) obj2).floatValue()));
            }
        });
        yt7G3.y(new InterfaceC14603iB2() { // from class: ir.nasim.Ly4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return NewVideoPlayerActivity.Z2(this.a, ((Float) obj).floatValue(), ((Float) obj2).floatValue());
            }
        });
    }

    private final void W3() {
        XV4 xv4M2 = h3().M2();
        final PT7 pt7 = new PT7(this, ((Number) xv4M2.a()).floatValue(), ((Number) xv4M2.b()).floatValue(), g3());
        c3().getRoot().setOnTouchListener(new View.OnTouchListener() { // from class: ir.nasim.Yy4
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NewVideoPlayerActivity.X3(pt7, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X2(NewVideoPlayerActivity newVideoPlayerActivity, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        if (newVideoPlayerActivity.y3(f2)) {
            newVideoPlayerActivity.h3().s3();
            return true;
        }
        if (!newVideoPlayerActivity.w3(f2)) {
            return false;
        }
        newVideoPlayerActivity.h3().r3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X3(PT7 pt7, View view, MotionEvent motionEvent) {
        AbstractC13042fc3.i(pt7, "$gestureDetector");
        view.getParent().requestDisallowInterceptTouchEvent(true);
        AbstractC13042fc3.f(motionEvent);
        return pt7.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Y2(NewVideoPlayerActivity newVideoPlayerActivity, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        if (newVideoPlayerActivity.y3(f2)) {
            newVideoPlayerActivity.h3().v3();
            return true;
        }
        if (!newVideoPlayerActivity.w3(f2)) {
            return false;
        }
        newVideoPlayerActivity.h3().u3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y3(final boolean rightContentIsAvailable, final boolean leftContentIsAvailable) {
        g3().C(new InterfaceC15796kB2() { // from class: ir.nasim.By4
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(NewVideoPlayerActivity.a4(rightContentIsAvailable, this, leftContentIsAvailable, (EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
            }
        });
        g3().D(new InterfaceC15796kB2() { // from class: ir.nasim.Cy4
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return NewVideoPlayerActivity.b4(this.a, (EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
            }
        });
        g3().z(new InterfaceC15796kB2() { // from class: ir.nasim.Dy4
            @Override // ir.nasim.InterfaceC15796kB2
            public final Object q(Object obj, Object obj2, Object obj3) {
                return Boolean.valueOf(NewVideoPlayerActivity.c4(leftContentIsAvailable, this, rightContentIsAvailable, (EnumC7541Sd6) obj, ((Float) obj2).floatValue(), ((Float) obj3).floatValue()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z2(NewVideoPlayerActivity newVideoPlayerActivity, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        newVideoPlayerActivity.h3().x3();
        return C19938rB7.a;
    }

    private final void a3() {
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a4(boolean z, NewVideoPlayerActivity newVideoPlayerActivity, boolean z2, EnumC7541Sd6 enumC7541Sd6, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(enumC7541Sd6, "scrollDirection");
        int i2 = e.a[enumC7541Sd6.ordinal()];
        if (i2 == 1) {
            int i3 = z ? -((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getWidth() : 0;
            int width = z2 ? ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getWidth() : 0;
            if (z2) {
                ThumbnailContainer thumbnailContainerA = ((b) newVideoPlayerActivity.d3().get(((newVideoPlayerActivity.indexOfCenterContentHolder - 1) + newVideoPlayerActivity.d3().size()) % newVideoPlayerActivity.d3().size())).A();
                thumbnailContainerA.setTranslationX(thumbnailContainerA.getTranslationX() + f2);
            }
            ThumbnailContainer thumbnailContainerA2 = ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A();
            thumbnailContainerA2.setTranslationX(AbstractC23053wG5.l(thumbnailContainerA2.getTranslationX() + f2, i3, width));
            newVideoPlayerActivity.c3().b.setTranslationX(thumbnailContainerA2.getTranslationX());
            if (z) {
                ThumbnailContainer thumbnailContainerA3 = ((b) newVideoPlayerActivity.d3().get((newVideoPlayerActivity.indexOfCenterContentHolder + 1) % newVideoPlayerActivity.d3().size())).A();
                thumbnailContainerA3.setTranslationX(thumbnailContainerA3.getTranslationX() + f2);
            }
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            ThumbnailContainer thumbnailContainerA4 = ((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A();
            thumbnailContainerA4.setTranslationY(thumbnailContainerA4.getTranslationY() + f3);
            newVideoPlayerActivity.c3().b.setTranslationY(((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationY());
            newVideoPlayerActivity.C3(((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationY());
        }
        return true;
    }

    private final void b3() {
        P0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b4(NewVideoPlayerActivity newVideoPlayerActivity, EnumC7541Sd6 enumC7541Sd6, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        int i2 = enumC7541Sd6 == null ? -1 : e.a[enumC7541Sd6.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                newVideoPlayerActivity.M3();
                E3(newVideoPlayerActivity, null, false, false, false, null, 31, null);
            } else if (((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationY() < (-newVideoPlayerActivity.getWindow().getDecorView().getHeight()) * 0.15f) {
                newVideoPlayerActivity.b3();
            } else if (((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationY() > newVideoPlayerActivity.getWindow().getDecorView().getHeight() * 0.15f) {
                newVideoPlayerActivity.a3();
            } else {
                newVideoPlayerActivity.A3();
                newVideoPlayerActivity.M3();
            }
        } else if (((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationX() < (-newVideoPlayerActivity.getWindow().getDecorView().getWidth()) * 0.25f) {
            newVideoPlayerActivity.r4();
        } else if (((b) newVideoPlayerActivity.d3().get(newVideoPlayerActivity.indexOfCenterContentHolder)).A().getTranslationX() > newVideoPlayerActivity.getWindow().getDecorView().getWidth() * 0.25f) {
            newVideoPlayerActivity.n4();
        } else {
            E3(newVideoPlayerActivity, null, false, false, false, null, 31, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C4568Fr4 c3() {
        return (C4568Fr4) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c4(boolean z, NewVideoPlayerActivity newVideoPlayerActivity, boolean z2, EnumC7541Sd6 enumC7541Sd6, float f2, float f3) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(enumC7541Sd6, "direction");
        int i2 = e.a[enumC7541Sd6.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (z && f2 > 0.0f) {
            newVideoPlayerActivity.n4();
        } else {
            if (!z2 || f2 >= 0.0f) {
                E3(newVideoPlayerActivity, null, false, false, false, null, 31, null);
                return false;
            }
            newVideoPlayerActivity.r4();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List d3() {
        return (List) this.contentHolders.getValue();
    }

    private final void d4() {
        NI0 ni0 = new NI0();
        Window window = getWindow();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeClipBounds());
        transitionSet.addTransition(new C19994rI0());
        transitionSet.addTransition(ni0);
        transitionSet.setDuration(200L);
        window.setSharedElementEnterTransition(transitionSet);
        N0(new j(new C9663aL5(), this, ni0));
    }

    private final VI2 e3() {
        return (VI2) this.glideRequests.getValue();
    }

    private final void e4() {
        BaleToolbar baleToolbar = c3().o;
        baleToolbar.y(AbstractC14628iD5.new_video_player_menu);
        BaleToolbar.setHasBackButton$default(baleToolbar, this, true, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C15539jl1 f3(C15539jl1 contentSize) {
        View decorView = getWindow().getDecorView();
        float fMin = Math.min(decorView.getWidth() / contentSize.b(), decorView.getHeight() / contentSize.a());
        return new C15539jl1((int) Math.ceil(contentSize.b() * fMin), (int) Math.ceil(fMin * contentSize.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YT7 g3() {
        return (YT7) this.videoPlayerGestureListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g4(final List items) {
        c3().o.setOnMenuItemClickListener(new Toolbar.g() { // from class: ir.nasim.Ey4
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return NewVideoPlayerActivity.h4(this.a, items, menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C21015sz4 h3() {
        return (C21015sz4) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h4(NewVideoPlayerActivity newVideoPlayerActivity, List list, MenuItem menuItem) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(list, "$items");
        if (menuItem.getItemId() != AbstractC19945rC5.more_item) {
            return false;
        }
        newVideoPlayerActivity.i4(list);
        return true;
    }

    private final C18391oa8 i3() {
        return (C18391oa8) this.windowInsetsController.getValue();
    }

    private final void i4(List items) {
        C4568Fr4 c4568Fr4C3 = c3();
        AbstractC8081Ul1.b bVar = new AbstractC8081Ul1.b();
        Iterator it = items.iterator();
        while (it.hasNext()) {
            final C4337Er7 c4337Er7 = (C4337Er7) it.next();
            AbstractC8081Ul1.b.k(bVar, c4337Er7.c(), c4337Er7.a(), null, new SA2() { // from class: ir.nasim.Sy4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return NewVideoPlayerActivity.j4(c4337Er7, this);
                }
            }, 4, null);
        }
        BaleToolbar baleToolbar = c4568Fr4C3.o;
        AbstractC13042fc3.h(baleToolbar, "toolbar");
        ConstraintLayout constraintLayoutB = c4568Fr4C3.getRoot();
        AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
        new GY.a(baleToolbar, constraintLayoutB, null, 4, null).d(true).f(true).e(new Runnable() { // from class: ir.nasim.Ty4
            @Override // java.lang.Runnable
            public final void run() {
                NewVideoPlayerActivity.k4(this.a);
            }
        }).b(bVar).e(85);
        h3().f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j4(C4337Er7 c4337Er7, NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(c4337Er7, "$item");
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        c4337Er7.b().invoke(newVideoPlayerActivity);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VI2 k3(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        return OI2.e(newVideoPlayerActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k4(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        newVideoPlayerActivity.h3().e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l3(final XE4 notifier) {
        C4568Fr4 c4568Fr4C3 = c3();
        if (notifier instanceof XE4.c) {
            ConstraintLayout constraintLayoutB = c4568Fr4C3.getRoot();
            AbstractC13042fc3.h(constraintLayoutB, "getRoot(...)");
            C17468n10 c17468n10 = new C17468n10(constraintLayoutB, c4568Fr4C3.c, 0, 4, null);
            String string = getString(((XE4.c) notifier).b());
            AbstractC13042fc3.h(string, "getString(...)");
            c17468n10.o(string);
            h3().d3();
            return;
        }
        if (!(notifier instanceof XE4.b)) {
            if (!(notifier instanceof XE4.a)) {
                throw new NoWhenBranchMatchedException();
            }
            l4(((XE4.a) notifier).b());
        } else {
            this.permissionResultCallback.e(new UA2() { // from class: ir.nasim.My4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return NewVideoPlayerActivity.m3(this.a, notifier, ((Boolean) obj).booleanValue());
                }
            });
            AbstractC22357v6 abstractC22357v6 = this.requestPermissionLauncher;
            if (abstractC22357v6 == null) {
                AbstractC13042fc3.y("requestPermissionLauncher");
                abstractC22357v6 = null;
            }
            abstractC22357v6.a(((XE4.b) notifier).c());
        }
    }

    private final void l4(InterfaceC4557Fq2 progressFlow) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(1);
        progressDialog.setTitle(VD5.exo_download_downloading);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(true);
        final InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(AbstractC19224pz3.a(this), null, null, new k(progressFlow, progressDialog, null), 3, null);
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.nasim.Wy4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                NewVideoPlayerActivity.m4(this.a, interfaceC13730gj3D, dialogInterface);
            }
        });
        progressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m3(final NewVideoPlayerActivity newVideoPlayerActivity, XE4 xe4, boolean z) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(xe4, "$notifier");
        if (z) {
            newVideoPlayerActivity.h3().d3();
            ((XE4.b) xe4).b().invoke();
        } else {
            C21753u45.g1(C21753u45.a, newVideoPlayerActivity, C21753u45.d.m, null, new SA2() { // from class: ir.nasim.Xy4
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return NewVideoPlayerActivity.o3(this.a);
                }
            }, 4, null);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m4(NewVideoPlayerActivity newVideoPlayerActivity, InterfaceC13730gj3 interfaceC13730gj3, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(interfaceC13730gj3, "$downloaderJob");
        newVideoPlayerActivity.h3().d3();
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n4() {
        this.indexOfCenterContentHolder = ((this.indexOfCenterContentHolder - 1) + d3().size()) % d3().size();
        E3(this, d.b, false, false, false, new SA2() { // from class: ir.nasim.Uy4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.o4(this.a);
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o3(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        newVideoPlayerActivity.h3().d3();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o4(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        newVideoPlayerActivity.h3().z3();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r3(EnumC23696xM4 orientation) {
        C4568Fr4 c4568Fr4C3 = c3();
        c4568Fr4C3.getRoot().setFitsSystemWindows(true);
        c4568Fr4C3.o.setFitsSystemWindows(false);
        int i2 = e.c[orientation.ordinal()];
        if (i2 == 1) {
            c4568Fr4C3.b.setResizeMode(1);
            c4568Fr4C3.c.j0(orientation, new UA2() { // from class: ir.nasim.Ny4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return NewVideoPlayerActivity.t3(this.a, (View) obj);
                }
            });
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            c4568Fr4C3.b.setResizeMode(2);
            c4568Fr4C3.c.j0(orientation, new UA2() { // from class: ir.nasim.Oy4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return NewVideoPlayerActivity.u3(this.a, (View) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r4() {
        this.indexOfCenterContentHolder = (this.indexOfCenterContentHolder + 1) % d3().size();
        E3(this, d.c, false, false, false, new SA2() { // from class: ir.nasim.Ry4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return NewVideoPlayerActivity.s4(this.a);
            }
        }, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s4(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        newVideoPlayerActivity.h3().A3();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t3(NewVideoPlayerActivity newVideoPlayerActivity, View view) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(view, "it");
        newVideoPlayerActivity.screenOrientationController.j();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YT7 t4(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        return new YT7(newVideoPlayerActivity, null, null, null, null, null, null, null, 254, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u3(NewVideoPlayerActivity newVideoPlayerActivity, View view) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        AbstractC13042fc3.i(view, "it");
        newVideoPlayerActivity.screenOrientationController.l();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C18391oa8 u4(NewVideoPlayerActivity newVideoPlayerActivity) {
        AbstractC13042fc3.i(newVideoPlayerActivity, "this$0");
        return AbstractC19329q98.a(newVideoPlayerActivity.getWindow(), newVideoPlayerActivity.getWindow().getDecorView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v3(G47 systemBarState) {
        if (systemBarState.b()) {
            i3().e(O98.m.h());
        } else {
            i3().a(O98.m.h());
        }
        if (systemBarState.a()) {
            i3().e(O98.m.g());
        } else {
            i3().a(O98.m.g());
        }
        C4568Fr4 c4568Fr4C3 = c3();
        if (systemBarState.b()) {
            c4568Fr4C3.o.animate().y(0.0f).alpha(1.0f).setDuration(200L);
            c4568Fr4C3.p.animate().translationY(0.0f).alpha(1.0f).setDuration(200L);
        } else {
            c4568Fr4C3.o.animate().y(-c4568Fr4C3.o.getHeight()).alpha(0.0f).setDuration(200L);
            c4568Fr4C3.p.animate().translationY(c4568Fr4C3.p.getHeight()).alpha(0.0f).setDuration(200L);
        }
    }

    private final boolean w3(float x) {
        return ((double) getWindow().getDecorView().getWidth()) * 0.3d >= ((double) x);
    }

    private final boolean y3(float x) {
        return ((double) getWindow().getDecorView().getWidth()) * 0.7d <= ((double) x);
    }

    private final void z3() {
        if (this.isMovingVertically) {
            return;
        }
        this.isMovingVertically = true;
        h3().Y2();
        ((b) d3().get(this.indexOfCenterContentHolder)).A().getBackground().setAlpha(0);
        c3().b.getBackground().setAlpha(0);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        AbstractC13042fc3.i(newBase, "newBase");
        super.attachBaseContext(PH3.b(PH3.a, newBase, null, 1, null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        h3().D3(newConfig);
        View decorView = getWindow().getDecorView();
        AbstractC13042fc3.h(decorView, "getDecorView(...)");
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new g(decorView, this));
    }

    @Override // ir.nasim.videoplayer.Hilt_NewVideoPlayerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        C21015sz4 c21015sz4H3 = h3();
        Configuration configuration = getResources().getConfiguration();
        AbstractC13042fc3.h(configuration, "getConfiguration(...)");
        c21015sz4H3.D3(configuration);
        AbstractC19329q98.b(getWindow(), false);
        i3().d(2);
        this.requestPermissionLauncher = t0(new C19881r6(), this.permissionResultCallback);
        setContentView(c3().getRoot());
        E0 e0F2 = h3().F2();
        if (e0F2 != null) {
            e0F2.R(c3().k);
        }
        Q0();
        d4();
        e4();
        T3();
        V3();
        W3();
        O2();
        K2();
    }

    @Override // ir.nasim.videoplayer.Hilt_NewVideoPlayerActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        C4568Fr4 c4568Fr4C3 = c3();
        c4568Fr4C3.c.setPlayer(null);
        c4568Fr4C3.c.setOnSeekbarChangeListener(null);
        E0 e0F2 = h3().F2();
        if (e0F2 != null) {
            e0F2.d0(c3().k);
        }
        AbstractC12990fW7.E0(getWindow().getDecorView(), null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        if (!this.hasSharedElementBeenReturned) {
            h3().e3();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        h3().g3();
    }
}
