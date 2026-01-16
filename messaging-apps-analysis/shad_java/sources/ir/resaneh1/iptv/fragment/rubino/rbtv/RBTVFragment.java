package ir.resaneh1.iptv.fragment.rubino.rbtv;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.google.android.exoplayer2.SimpleExoPlayer;
import ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell;
import ir.resaneh1.iptv.fragment.rubino.rbtv.interfaces.UpdateVideoTime;
import ir.resaneh1.iptv.model.RubinoPostObject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.BaseFragment;

/* compiled from: RBTVFragment.kt */
/* loaded from: classes3.dex */
public final class RBTVFragment extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private final long currentPosition;
    private final long duration;
    private final RubinoPostObject postObject;
    private final Lazy rbtvCell$delegate;
    private final UpdateVideoTime updateVideoTime;

    static {
        new Companion(null);
    }

    public RBTVFragment(RubinoPostObject postObject, long j, long j2, UpdateVideoTime updateVideoTime) {
        Intrinsics.checkNotNullParameter(postObject, "postObject");
        Intrinsics.checkNotNullParameter(updateVideoTime, "updateVideoTime");
        this.postObject = postObject;
        this.currentPosition = j;
        this.duration = j2;
        this.updateVideoTime = updateVideoTime;
        this.rbtvCell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RBTVCell>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVFragment$rbtvCell$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RBTVCell invoke() {
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                final RBTVFragment rBTVFragment = this.this$0;
                return new RBTVCell(context, new RBTVCell.RBTVCallBack() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVFragment$rbtvCell$2.1
                    @Override // ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell.RBTVCallBack
                    public void onVideoEnded() {
                        rBTVFragment.finishFragment();
                    }
                });
            }
        });
    }

    /* compiled from: RBTVFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final RBTVCell getRbtvCell() {
        return (RBTVCell) this.rbtvCell$delegate.getValue();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        UpdateVideoTime updateVideoTime = this.updateVideoTime;
        SimpleExoPlayer exoPlayer = getRbtvCell().getExoPlayer();
        updateVideoTime.updateVideo(exoPlayer == null ? 0L : exoPlayer.getCurrentPosition());
        return super.onBackPressed();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        Log.i("RBTVFragment", "createView: ");
        this.fragmentView = getRbtvCell();
        getRbtvCell().setData(this.postObject, this.currentPosition, this.duration);
        this.actionBar = null;
        View fragmentView = this.fragmentView;
        Intrinsics.checkNotNullExpressionValue(fragmentView, "fragmentView");
        return fragmentView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.igtvPlayerAdjustVolume);
        ApplicationLoader.applicationActivity.getWindow().addFlags(128);
        this.needLockOrientation = true;
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.igtvPlayerAdjustVolume);
        ApplicationLoader.applicationActivity.getWindow().clearFlags(128);
        getRbtvCell().stopAndReleasePlayer();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        getRbtvCell().pausePlayer();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        getRbtvCell().resumePlayer();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (i == NotificationCenter.igtvPlayerAdjustVolume) {
            if (args[0] == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            getRbtvCell().setVolume(!((Boolean) r1).booleanValue());
        }
    }
}
