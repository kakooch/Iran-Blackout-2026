package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.iranlms.asemnavideoplayerlibrary.player.models.EnumStreamType;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.model.PlayerStateObject;
import ir.resaneh1.iptv.musicplayer.NewMusicPlayerService;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class PlayerPresenter extends AbstractPresenter<PlayerPresenterItem, MyViewHolder> {
    public static MyViewHolder lastPlayerHolder;

    public PlayerPresenter(Activity activity) {
        super(activity);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        if (this.context == null && ApplicationLoader.applicationActivity != null) {
            this.context = ApplicationLoader.applicationActivity;
        }
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_post_player, viewGroup, false));
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, PlayerPresenterItem playerPresenterItem) {
        super.onBindViewHolder((PlayerPresenter) myViewHolder, (MyViewHolder) playerPresenterItem);
    }

    public static class MyViewHolder extends AbstractPresenter.AbstractViewHolder<PlayerPresenterItem> {
        public PlayerBaseFragment playerFragment;
        public FrameLayout playerFrameLayout;

        public MyViewHolder(View view) {
            super(view);
            this.playerFrameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);
        }
    }

    public Observable<PlayerStateObject> getPlayerStateObjectObservable(MyViewHolder myViewHolder) {
        PlayerBaseFragment playerBaseFragment;
        if (myViewHolder == null || (playerBaseFragment = myViewHolder.playerFragment) == null) {
            return null;
        }
        return playerBaseFragment.getPlayerStateObjectObservable();
    }

    public void onGetStreamUrlResponse(GetStreamUrlOutput getStreamUrlOutput, MyViewHolder myViewHolder) {
        PlayObject playObject = getStreamUrlOutput.playObject;
        if (playObject != null) {
            Titem titem = myViewHolder.item;
            if (!((PlayerPresenterItem) titem).isLive) {
                playObject.type = EnumStreamType.vod;
            } else {
                playObject.type = EnumStreamType.timeshift;
            }
            if (((PlayerPresenterItem) titem).stream_type.equals("aod_track")) {
                playObject.type = EnumStreamType.aod;
                playObject.imageUrl = ((PlayerPresenterItem) myViewHolder.item).image_url;
            }
            Titem titem2 = myViewHolder.item;
            if (((PlayerPresenterItem) titem2).isForcePlayFromBegin) {
                playObject.setting.startTime = 0;
            }
            PlayObject.Setting setting = playObject.setting;
            setting.isTouchControllerAlwaysEnabled = ((PlayerPresenterItem) titem2).isTouchControllerAlwaysEnabled;
            setting.isJustFullScreen = false;
            playObject.viewId = getStreamUrlOutput.viewId;
            play(myViewHolder, playObject);
        }
    }

    public void playStream(MyViewHolder myViewHolder) {
        playStream(myViewHolder, false, BuildConfig.FLAVOR, -1L, -1L, false);
    }

    public void playStreamInsta(MyViewHolder myViewHolder, String str, long j, long j2, boolean z) {
        playStream(myViewHolder, true, str, j, j2, z);
    }

    private void playStream(MyViewHolder myViewHolder, boolean z, String str, long j, long j2, boolean z2) {
        PlayerPresenterItem playerPresenterItem = (PlayerPresenterItem) myViewHolder.item;
        PlayObject playObject = new PlayObject();
        playObject.streamUrl = playerPresenterItem.stream_url;
        playObject.viewId = BuildConfig.FLAVOR;
        playObject.imageUrl = str;
        playObject.isHls = false;
        playObject.isForInsta = z;
        playObject.isForExplore = z2;
        playObject.startTimeForInsta = j;
        playObject.endTimeForInsta = j2;
        play(myViewHolder, playObject);
    }

    public void play(MyViewHolder myViewHolder, PlayObject playObject) {
        lastPlayerHolder = myViewHolder;
        if (!playObject.isForInsta) {
            NewMusicPlayerService.staticStopService(this.context);
        }
        PlayerBaseFragment playerBaseFragment = PlayerBaseFragment.getInstance(playObject, this.context);
        myViewHolder.playerFragment = playerBaseFragment;
        playerBaseFragment.setAsemanPlayerListener(null);
        myViewHolder.playerFragment.parentBaseFragmet = ((LaunchActivity) this.context).getLastFragment();
        if (myViewHolder.playerFragment.getFragmentView().getParent() != null) {
            ((ViewGroup) myViewHolder.playerFragment.getFragmentView().getParent()).removeAllViews();
        }
        myViewHolder.playerFragment.getFragmentView().setBackgroundColor(-16777216);
        myViewHolder.playerFrameLayout.addView(myViewHolder.playerFragment.getFragmentView());
        PlayerBaseFragment playerBaseFragment2 = myViewHolder.playerFragment;
        playerBaseFragment2.needRetrySource = true;
        playerBaseFragment2.initializePlayer();
    }

    public static void destroyPlayer(Context context) {
        try {
            if (lastPlayerHolder != null) {
                MyLog.e("requestStream", "Destroy1");
                if (lastPlayerHolder.itemView.getParent() != null) {
                    ((ViewGroup) lastPlayerHolder.itemView.getParent()).removeView(lastPlayerHolder.itemView);
                }
                PlayerBaseFragment playerBaseFragment = lastPlayerHolder.playerFragment;
                playerBaseFragment.simpleExoPlayerView.controller.release();
                lastPlayerHolder = null;
                playerBaseFragment.releasePlayer();
                playerBaseFragment.onPause();
                playerBaseFragment.onFragmentDestroy();
                playerBaseFragment.setParentLayout(null);
                MyLog.e("requestStream", "Destroy2");
            }
        } catch (Exception e) {
            MyLog.e("error:", "exsmessage:" + e.getMessage() + BuildConfig.FLAVOR);
        }
    }
}
