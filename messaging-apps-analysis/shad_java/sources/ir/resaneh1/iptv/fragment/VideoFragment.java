package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.iranlms.asemnavideoplayerlibrary.player.models.EnumStreamType;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIImagePlayer;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.Abs;
import ir.resaneh1.iptv.model.GetStreamUrlInput;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class VideoFragment extends PresenterFragment {
    Abs abs = new Abs();
    public String id;
    private PlayerPresenter playerPresenter;
    PlayerPresenter.MyViewHolder playerPresenterHolder;
    private Call<GetStreamUrlOutput> requestForStreamURL;
    public String type;
    UIImagePlayer uiImagePlayer;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.video_fragment;
    }

    public VideoFragment(String str, String str2) {
        this.id = str;
        this.type = str2;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        MyLog.e("DetailFragment", "init: ");
        this.playerPresenter = new PlayerPresenter((Activity) getContext());
        this.uiImagePlayer = new UIImagePlayer();
        this.swipeBackEnabled = false;
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        this.progressBar.setVisibility(4);
        hideCloseView();
        makeVodlayout();
        onPlayClick();
        setToolbar();
        setCloseView();
    }

    private void setToolbar() {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.addViewToRightLayout(toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_arrow_back_white));
        toolbarImageView.imageView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.VideoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ApplicationLoader.applicationActivity.onBackPressed();
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
    }

    public void setCloseView() {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.addViewToRightLayout(toolbarImageView.createView((Activity) this.mContext, R.drawable.close_white));
        toolbarImageView.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.VideoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoFragment.this.hideCloseView();
                PlayerPresenter.destroyPlayer(VideoFragment.this.getContext());
                ApplicationLoader.applicationActivity.onBackPressed();
            }
        });
    }

    public void hideCloseView() {
        View view;
        UIImagePlayer uIImagePlayer = this.uiImagePlayer;
        if (uIImagePlayer != null && (view = uIImagePlayer.imageViewClose) != null) {
            view.setVisibility(4);
        }
        setToolbar();
    }

    void playVideo(final PlayerPresenterItem playerPresenterItem) {
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1).delay(300L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.VideoFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                playerPresenterItem.isTouchControllerAlwaysEnabled = true;
                VideoFragment videoFragment = VideoFragment.this;
                videoFragment.playerPresenterHolder = videoFragment.playerPresenter.createViewHolderAndBind(playerPresenterItem);
                VideoFragment.this.uiImagePlayer.frameLayout.removeAllViews();
                VideoFragment videoFragment2 = VideoFragment.this;
                videoFragment2.uiImagePlayer.frameLayout.addView(videoFragment2.playerPresenterHolder.itemView);
                VideoFragment videoFragment3 = VideoFragment.this;
                videoFragment3.callGetStream(videoFragment3.playerPresenterHolder);
            }
        }));
    }

    public void callGetStream(final PlayerPresenter.MyViewHolder myViewHolder) {
        PlayerPresenter.destroyPlayer(getContext());
        this.uiImagePlayer.playImage.setEnabled(false);
        this.uiImagePlayer.startImage.setEnabled(false);
        this.uiImagePlayer.progressBar.setVisibility(0);
        if (((PlayerPresenterItem) myViewHolder.item).stream_id != null) {
            if (this.requestForStreamURL != null) {
                MyLog.e("requestStream", "cancelRequest" + this.requestForStreamURL);
                this.requestForStreamURL.cancel();
            }
            Titem titem = myViewHolder.item;
            this.requestForStreamURL = ApiRequestIPTV.getInstance(this.currentAccount).getStreamUrl(new GetStreamUrlInput(((PlayerPresenterItem) titem).stream_id, ((PlayerPresenterItem) titem).stream_type), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.VideoFragment.4
                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onResponse(final Call call, final Response response) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.VideoFragment.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View viewFindViewById;
                            View viewFindViewById2;
                            MyLog.e("requestStream ", call + BuildConfig.FLAVOR);
                            if (call.isCanceled()) {
                                MyLog.e("requestStream", "canceled " + call);
                                return;
                            }
                            PlayerPresenter.destroyPlayer(VideoFragment.this.getContext());
                            GetStreamUrlOutput getStreamUrlOutput = (GetStreamUrlOutput) response.body();
                            PlayObject playObject = getStreamUrlOutput.playObject;
                            if (playObject.setting == null) {
                                playObject.setting = new PlayObject.Setting();
                            }
                            if (getStreamUrlOutput.playObject.type == EnumStreamType.live) {
                                ((PlayerPresenterItem) myViewHolder.item).isLive = true;
                            }
                            VideoFragment.this.playerPresenter.onGetStreamUrlResponse(getStreamUrlOutput, myViewHolder);
                            VideoFragment.this.uiImagePlayer.playImage.setEnabled(true);
                            VideoFragment.this.uiImagePlayer.startImage.setEnabled(true);
                            VideoFragment.this.uiImagePlayer.progressBar.setVisibility(4);
                            View viewFindViewById3 = VideoFragment.this.playerPresenterHolder.playerFragment.findViewById(R.id.root);
                            if (viewFindViewById3 != null && (viewFindViewById = viewFindViewById3.findViewById(R.id.player_view)) != null && (viewFindViewById2 = viewFindViewById.findViewById(R.id.exo_content_frame)) != null) {
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                                layoutParams.gravity = 17;
                                viewFindViewById2.setLayoutParams(layoutParams);
                            }
                            MyLog.e("requestStream", "Play");
                        }
                    }, 250L);
                }

                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onFailure(Call call, Throwable th) {
                    VideoFragment.this.uiImagePlayer.playImage.setEnabled(true);
                    VideoFragment.this.uiImagePlayer.startImage.setEnabled(true);
                    VideoFragment.this.uiImagePlayer.progressBar.setVisibility(4);
                }
            });
        }
    }

    void makeVodlayout() {
        addUiImagePlayer();
        this.uiImagePlayer.playImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.VideoFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoFragment.this.onPlayClick();
            }
        });
    }

    public void onPlayClick() {
        playVideo(new PlayerPresenterItem(this.id, this.type));
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        PlayerBaseFragment playerBaseFragment;
        PlayerPresenter.MyViewHolder myViewHolder = this.playerPresenterHolder;
        if (myViewHolder == null || (playerBaseFragment = myViewHolder.playerFragment) == null || playerBaseFragment == null || !playerBaseFragment.consumeBackPress()) {
            return super.onBackPressed();
        }
        return false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        MyLog.e("destroy", "detilFrag resume");
        super.onResume();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        MyLog.e("destroy", "detilFrag pause");
        super.onPause();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        MyLog.e("destroy", "detilFrag destroy");
        super.onFragmentDestroy();
    }

    public void addUiImagePlayer() {
        this.uiImagePlayer.createView((Activity) this.mContext, this.abs.image_url);
        this.uiImagePlayer.view.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.uiImagePlayer.view.setBackgroundColor(-16777216);
        this.uiImagePlayer.frameLayout.setBackgroundColor(-16777216);
        GlideHelper.loadWithColorPlaceHolder(this.mContext, this.uiImagePlayer.imageview, BuildConfig.FLAVOR, -16777216);
        this.linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.grey_800));
        this.linearLayout.addView(this.uiImagePlayer.view);
        this.uiImagePlayer.shareImage.setVisibility(8);
        this.uiImagePlayer.bookmarkImage.setVisibility(4);
    }
}
