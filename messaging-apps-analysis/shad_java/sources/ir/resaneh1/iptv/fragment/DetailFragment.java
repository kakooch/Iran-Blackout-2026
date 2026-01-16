package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIImagePlayer;
import ir.resaneh1.iptv.UIMusicPlayer;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.enums.EnumContentType;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.MyDisposableObservable;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AODObjectAbs;
import ir.resaneh1.iptv.model.AODObjectDet;
import ir.resaneh1.iptv.model.Abs;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.ChildLockCheck;
import ir.resaneh1.iptv.model.CourseAbs;
import ir.resaneh1.iptv.model.CourseDet;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.GetObjectInput;
import ir.resaneh1.iptv.model.GetObjectOutput;
import ir.resaneh1.iptv.model.GetStreamUrlInput;
import ir.resaneh1.iptv.model.GetStreamUrlOutput;
import ir.resaneh1.iptv.model.ImageObject;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.PlayerPresenterItem;
import ir.resaneh1.iptv.model.PlayerStateObject;
import ir.resaneh1.iptv.model.RatingDetailObject;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ScrollViewListObject;
import ir.resaneh1.iptv.model.SectionObject;
import ir.resaneh1.iptv.model.SessionObject;
import ir.resaneh1.iptv.model.TVObjectDet;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.TvEpisodeObjectAbs;
import ir.resaneh1.iptv.model.VODObjectAbs;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.VodObjectDet;
import ir.resaneh1.iptv.musicplayer.AudioPlayManager;
import ir.resaneh1.iptv.musicplayer.PlayableAudioObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.AodDetDescriptionPresenter;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.presenters.TvDetDescriptionPresenter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import ir.resaneh1.iptv.presenters.VodDetDescriptionPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.MessagesController;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class DetailFragment extends PresenterFragment {
    Abs abs;
    private ViewDataObject adsDataObject;
    private LinearLayout adsViewContainer;
    private ViewGroupObject adsViewGroupObject;
    AODObjectDet aodObjectDet;
    CourseDet courseDet;
    public boolean isAutoPlay;
    private PlayerPresenter playerPresenter;
    PlayerPresenter.MyViewHolder playerPresenterHolder;
    private Call<GetStreamUrlOutput> requestForStreamURL;
    TagObject.TagType tagType;
    TVObjectDet tvObjectDet;
    UIImagePlayer uiImagePlayer;
    private UIMusicPlayer uiMusicPlayer;
    VodObjectDet vodObjectDet;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_linearlayout_and_recycler;
    }

    public DetailFragment(VODObjectAbs vODObjectAbs) {
        this.abs = new Abs();
        this.isAutoPlay = false;
        this.abs = vODObjectAbs;
        this.tagType = TagObject.TagType.vod_film;
        this.swipeBackEnabled = false;
        this.fragmentName = "DetailFragment";
    }

    public DetailFragment(TvEpisodeObjectAbs tvEpisodeObjectAbs) {
        this.abs = new Abs();
        this.isAutoPlay = false;
        this.abs = tvEpisodeObjectAbs;
        this.tagType = TagObject.TagType.tv_episode;
        this.swipeBackEnabled = false;
        this.fragmentName = "DetailFragment";
    }

    public DetailFragment(AODObjectAbs aODObjectAbs) {
        this.abs = new Abs();
        this.isAutoPlay = false;
        this.abs = aODObjectAbs;
        this.tagType = TagObject.TagType.aod_track;
        this.swipeBackEnabled = false;
        this.fragmentName = "DetailFragment";
    }

    public DetailFragment(CourseAbs courseAbs) {
        this.abs = new Abs();
        this.isAutoPlay = false;
        this.abs = courseAbs;
        this.tagType = TagObject.TagType.course;
        this.swipeBackEnabled = false;
        this.fragmentName = "DetailFragment";
    }

    public DetailFragment(String str, EnumContentType enumContentType, boolean z) {
        this.abs = new Abs();
        this.isAutoPlay = false;
        this.swipeBackEnabled = false;
        if (enumContentType == EnumContentType.vod_film) {
            VODObjectAbs vODObjectAbs = new VODObjectAbs();
            vODObjectAbs.film_id = str;
            this.abs = vODObjectAbs;
            this.tagType = TagObject.TagType.vod_film;
            this.isAutoPlay = z;
            return;
        }
        if (enumContentType == EnumContentType.audio_track) {
            AODObjectAbs aODObjectAbs = new AODObjectAbs();
            aODObjectAbs.track_id = str;
            this.abs = aODObjectAbs;
            this.tagType = TagObject.TagType.aod_track;
            this.isAutoPlay = z;
            return;
        }
        if (enumContentType == EnumContentType.course_item) {
            CourseAbs courseAbs = new CourseAbs();
            courseAbs.course_id = str;
            this.abs = courseAbs;
            this.tagType = TagObject.TagType.course;
            return;
        }
        if (enumContentType == EnumContentType.tv_episode) {
            TvEpisodeObjectAbs tvEpisodeObjectAbs = new TvEpisodeObjectAbs();
            tvEpisodeObjectAbs.tv_episode_id = str;
            this.abs = tvEpisodeObjectAbs;
            this.tagType = TagObject.TagType.tv_episode;
            this.isAutoPlay = z;
        }
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
        this.mainRecyclerView.clearAnimation();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        initWithVerticalLinearLayoutManager();
        final MainClickHandler mainClickHandler = new MainClickHandler();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                if (abstractViewHolder.item.getPresenterType() == PresenterItemType.session) {
                    if (DetailFragment.this.linearLayout != null) {
                        DetailFragment.this.playVideo(new PlayerPresenterItem(((SessionObject) abstractViewHolder.item).session_id, EnumContentType.course_item.name()));
                        return;
                    }
                    return;
                }
                mainClickHandler.onClick(DetailFragment.this.baseFragment, abstractViewHolder);
            }
        };
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), onPresenterItemClickListener, null);
        this.mainAdapter = mainAdapter;
        this.mainRecyclerView.setAdapter(mainAdapter);
        getObjectDet();
    }

    private void getObjectDet() {
        if (this.abs.getPresenterType() == PresenterItemType.vod) {
            getVodDetObject();
            return;
        }
        if (this.abs.getPresenterType() == PresenterItemType.aod) {
            getAodDetObject();
        } else if (this.abs.getPresenterType() == PresenterItemType.course) {
            getCourseDetObject();
        } else if (this.abs.getPresenterType() == PresenterItemType.tv_episode) {
            getTVDetObject();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
        }
        getObjectDet();
    }

    public void setCloseView() {
        this.uiImagePlayer.imageViewClose.setVisibility(0);
        this.uiImagePlayer.imageViewClose.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailFragment.this.hideCloseView();
                PlayerPresenter.destroyPlayer(DetailFragment.this.getContext());
            }
        });
    }

    public void hideCloseView() {
        View view;
        UIImagePlayer uIImagePlayer = this.uiImagePlayer;
        if (uIImagePlayer == null || (view = uIImagePlayer.imageViewClose) == null) {
            return;
        }
        view.setVisibility(4);
    }

    private void getTVDetObject() {
        ApiRequestIPTV.getInstance(this.currentAccount).getTVEpisodeDetObject(new GetObjectInput(TagObject.TagType.tv_episode.name(), this.abs.getId()), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetObjectOutput getObjectOutput = (GetObjectOutput) response.body();
                DetailFragment detailFragment = DetailFragment.this;
                TVObjectDet tVObjectDet = (TVObjectDet) getObjectOutput.object;
                detailFragment.tvObjectDet = tVObjectDet;
                detailFragment.abs = tVObjectDet.object_abs;
                detailFragment.progressBar.setVisibility(4);
                DetailFragment detailFragment2 = DetailFragment.this;
                detailFragment2.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) detailFragment2.mContext, detailFragment2.abs.getTitle());
                DetailFragment.this.hideCloseView();
                DetailFragment.this.makeTvEpisodeLayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                DetailFragment.this.showRetryLayout();
                MyLog.e("DetailFragment", "onFailure: ");
            }
        });
    }

    private void getAodDetObject() {
        ApiRequestIPTV.getInstance(this.currentAccount).getAodObjectDet(new GetObjectInput(TagObject.TagType.aod_track.name(), this.abs.getId()), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetObjectOutput getObjectOutput = (GetObjectOutput) response.body();
                DetailFragment detailFragment = DetailFragment.this;
                AODObjectDet aODObjectDet = (AODObjectDet) getObjectOutput.object;
                detailFragment.aodObjectDet = aODObjectDet;
                detailFragment.abs = aODObjectDet.object_abs;
                detailFragment.progressBar.setVisibility(4);
                DetailFragment detailFragment2 = DetailFragment.this;
                detailFragment2.toolbarMaker.setToolbarWithBackButtonAndTextWhite((Activity) detailFragment2.mContext, detailFragment2.abs.getTitle());
                DetailFragment.this.hideCloseView();
                DetailFragment.this.makeAodlayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                DetailFragment.this.showRetryLayout();
            }
        });
    }

    private void getCourseDetObject() {
        ApiRequestIPTV.getInstance(this.currentAccount).getCourseDetObject(new GetObjectInput(TagObject.TagType.course.name(), this.abs.getId()), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetObjectOutput getObjectOutput = (GetObjectOutput) response.body();
                DetailFragment detailFragment = DetailFragment.this;
                CourseDet courseDet = (CourseDet) getObjectOutput.object;
                detailFragment.courseDet = courseDet;
                detailFragment.abs = courseDet.object_abs;
                detailFragment.progressBar.setVisibility(4);
                DetailFragment detailFragment2 = DetailFragment.this;
                detailFragment2.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) detailFragment2.mContext, detailFragment2.courseDet.object_abs.title);
                MyLog.e("DetailFragment", "onResponse: ");
                DetailFragment.this.hideCloseView();
                DetailFragment.this.makeCourselayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("DetailFragment", "onFailure: ");
                DetailFragment.this.showRetryLayout();
            }
        });
    }

    private void getVodDetObject() {
        ApiRequestIPTV.getInstance(this.currentAccount).getVodObjectDet(new GetObjectInput(TagObject.TagType.vod_film.name(), this.abs.getId()), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetObjectOutput getObjectOutput = (GetObjectOutput) response.body();
                DetailFragment detailFragment = DetailFragment.this;
                VodObjectDet vodObjectDet = (VodObjectDet) getObjectOutput.object;
                detailFragment.vodObjectDet = vodObjectDet;
                detailFragment.abs = vodObjectDet.object_abs;
                detailFragment.progressBar.setVisibility(4);
                MyLog.e("DetailFragment", "onResponse: ");
                DetailFragment detailFragment2 = DetailFragment.this;
                detailFragment2.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) detailFragment2.mContext, detailFragment2.abs.getTitle());
                DetailFragment.this.hideCloseView();
                DetailFragment.this.makeVodlayout();
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("DetailFragment", "onFailure: ");
                DetailFragment.this.showRetryLayout();
            }
        });
    }

    void playVideo(PlayerPresenterItem playerPresenterItem) {
        this.playerPresenterHolder = this.playerPresenter.createViewHolderAndBind(playerPresenterItem);
        this.uiImagePlayer.frameLayout.removeAllViews();
        this.uiImagePlayer.frameLayout.addView(this.playerPresenterHolder.itemView);
        callGetStream(this.playerPresenterHolder);
        findViewById(R.id.nastedScrollView).scrollTo(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeToPlayStateObservable() {
        Observable<PlayerStateObject> playerStateObjectObservable = this.playerPresenter.getPlayerStateObjectObservable(this.playerPresenterHolder);
        if (playerStateObjectObservable != null) {
            ((PresenterFragment) this).compositeDisposable.add((Disposable) playerStateObjectObservable.subscribeWith(new DisposableObserver<PlayerStateObject>() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.7
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(PlayerStateObject playerStateObject) {
                    MyLog.e("DetailFragment", "state : " + playerStateObject.state);
                    PlayerStateObject.PlayerStateEnum playerStateEnum = playerStateObject.state;
                    if (playerStateEnum == PlayerStateObject.PlayerStateEnum.playAds) {
                        DetailFragment.this.addAdsViewToContainerIfNeeded();
                    } else if (playerStateEnum == PlayerStateObject.PlayerStateEnum.stopAds || playerStateEnum == PlayerStateObject.PlayerStateEnum.errorAds) {
                        DetailFragment.this.clearAdsContainerIfNotNull();
                        DetailFragment.this.adsViewGroupObject = null;
                        DetailFragment.this.adsDataObject = null;
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdsContainerIfNotNull() {
        LinearLayout linearLayout = this.adsViewContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.adsViewContainer.setPadding(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdsViewToContainerIfNeeded() {
        clearAdsContainerIfNotNull();
        if (this.adsViewContainer == null || this.adsViewGroupObject == null || this.adsDataObject == null) {
            return;
        }
        ViewGroupCellPresenter viewGroupCellPresenter = new ViewGroupCellPresenter(this.mContext, false, this.adsViewGroupObject);
        ViewGroupObject viewGroupObject = this.adsViewGroupObject;
        if (viewGroupObject.type == ViewGroupObject.TypeEnum.Normal) {
            setSizeOfCells(viewGroupObject, viewGroupCellPresenter, 1);
        }
        ViewGroupCellPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = viewGroupCellPresenter.createViewHolderAndBind(this.adsDataObject);
        this.adsViewContainer.setPadding(0, AndroidUtilities.dp(this.adsViewGroupObject.v_space * 100.0f), AndroidUtilities.dp(this.adsViewGroupObject.h_space * 100.0f), AndroidUtilities.dp(this.adsViewGroupObject.v_space * 100.0f));
        this.adsViewContainer.addView(myViewHolderCreateViewHolderAndBind.itemView);
    }

    private void setSizeOfCells(ViewGroupObject viewGroupObject, ViewGroupCellPresenter viewGroupCellPresenter, int i) {
        if (viewGroupObject.size == null || viewGroupCellPresenter == null) {
            return;
        }
        int iCalculateItemWidthBasedOnColumns = DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, i, AndroidUtilities.dp((int) (viewGroupObject.h_space * 100.0f)));
        float hWRatio = viewGroupObject.size.getHWRatio();
        viewGroupCellPresenter.widthPx = iCalculateItemWidthBasedOnColumns;
        viewGroupCellPresenter.heightPx = (int) (hWRatio * iCalculateItemWidthBasedOnColumns);
    }

    public void callGetStream(final PlayerPresenter.MyViewHolder myViewHolder) {
        PlayerPresenter.destroyPlayer(getContext());
        if (this.tagType != TagObject.TagType.vod_film || ChildLockCheck.canPlayVideoWithAlert()) {
            this.uiImagePlayer.playImage.setEnabled(false);
            this.uiImagePlayer.startImage.setEnabled(false);
            this.uiImagePlayer.progressBar.setVisibility(0);
            if (((PlayerPresenterItem) myViewHolder.item).stream_id != null) {
                if (this.requestForStreamURL != null) {
                    MyLog.e("requestStream", "cancelRequest" + this.requestForStreamURL);
                    this.requestForStreamURL.cancel();
                }
                Titem titem = myViewHolder.item;
                this.requestForStreamURL = ApiRequestIPTV.getInstance(this.currentAccount).getStreamUrl(new GetStreamUrlInput(((PlayerPresenterItem) titem).stream_id, ((PlayerPresenterItem) titem).stream_type), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.8
                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onResponse(Call call, Response response) {
                        MyLog.e("requestStream ", call + BuildConfig.FLAVOR);
                        if (call.isCanceled()) {
                            MyLog.e("requestStream", "canceled " + call);
                            return;
                        }
                        boolean z = MyLog.isDebugAble;
                        PlayerPresenter.destroyPlayer(DetailFragment.this.getContext());
                        DetailFragment.this.playerPresenter.onGetStreamUrlResponse((GetStreamUrlOutput) response.body(), myViewHolder);
                        DetailFragment.this.uiImagePlayer.playImage.setEnabled(true);
                        DetailFragment.this.uiImagePlayer.startImage.setEnabled(true);
                        DetailFragment.this.uiImagePlayer.progressBar.setVisibility(4);
                        DetailFragment.this.subscribeToPlayStateObservable();
                        DetailFragment.this.setCloseView();
                        MyLog.e("requestStream", "Play");
                    }

                    @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                    public void onFailure(Call call, Throwable th) {
                        DetailFragment.this.uiImagePlayer.playImage.setEnabled(true);
                        DetailFragment.this.uiImagePlayer.startImage.setEnabled(true);
                        DetailFragment.this.uiImagePlayer.progressBar.setVisibility(4);
                    }
                });
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.adsViewContainer != null) {
            addAdsViewToContainerIfNeeded();
        }
    }

    private void addCommentRow(TagObject tagObject) {
        final ListInput listInput = new ListInput(tagObject);
        listInput.limit = 5;
        new ItemListRequest().load(this.mContext, listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.9
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                if (arrayList == null) {
                    return;
                }
                RatingDetailObject ratingDetailObject = new RatingDetailObject();
                ratingDetailObject.star = DetailFragment.this.abs.getStars();
                String str = DetailFragment.this.abs.count_comments;
                if (str == null || str.equals("null")) {
                    ratingDetailObject.count = "0";
                } else {
                    ratingDetailObject.count = DetailFragment.this.abs.count_comments;
                }
                DetailFragment detailFragment = DetailFragment.this;
                ratingDetailObject.type = detailFragment.tagType;
                ratingDetailObject.id = detailFragment.abs.getId();
                ratingDetailObject.onSendCommentClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DetailFragment.this.presentFragment(new SendCommentFragment(DetailFragment.this.abs.getId(), DetailFragment.this.tagType));
                    }
                };
                DetailFragment.this.mainArrayList.add(ratingDetailObject);
                int i = 1;
                for (int i2 = 0; i2 < 5 && i2 < arrayList.size(); i2++) {
                    DetailFragment.this.mainArrayList.add(arrayList.get(i2));
                    i++;
                }
                ButtonItem buttonItem = new ButtonItem("نمایش همه ی نظرات", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.9.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        listInput.title = "نظرات";
                        ListFragment listFragment = new ListFragment(listInput);
                        listFragment.isGrid = false;
                        DetailFragment.this.presentFragment(listFragment);
                    }
                });
                buttonItem.buttonType = ButtonItem.ButtonType.text;
                if (arrayList.size() > 5) {
                    DetailFragment.this.mainArrayList.add(buttonItem);
                    i++;
                }
                DetailFragment detailFragment2 = DetailFragment.this;
                detailFragment2.mainAdapter.notifyItemRangeInserted(detailFragment2.mainArrayList.size() - i, i);
            }
        });
    }

    void makeVodlayout() {
        addUiImagePlayer();
        this.uiImagePlayer.playImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FirebaseEventSender.sendEvent(DetailFragment.this.mContext, "play_vod", DetailFragment.this.abs.getId() + " " + DetailFragment.this.abs.getTitle());
                DetailFragment.this.playVideo(new PlayerPresenterItem(DetailFragment.this.vodObjectDet.object_abs.film_id, DetailFragment.this.tagType + BuildConfig.FLAVOR));
            }
        });
        addAdsViewContainer();
        this.linearLayout.addView(new VodDetDescriptionPresenter(this.mContext).createViewHolderAndBind(this.vodObjectDet).itemView);
        addImageRow(this.vodObjectDet.snapshots);
        addRelatedRow(this.vodObjectDet.related);
        addCommentRow(this.vodObjectDet.comments);
        this.mainAdapter.notifyDataSetChanged();
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1).delay(300L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribeWith(new MyDisposableObservable<Integer>() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.11
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                DetailFragment detailFragment = DetailFragment.this;
                if (detailFragment.isAutoPlay) {
                    detailFragment.uiImagePlayer.playImage.performClick();
                    DetailFragment.this.isAutoPlay = false;
                }
            }
        }));
    }

    private void addAdsViewContainer() {
        if (this.adsViewContainer == null) {
            UILinearLayout uILinearLayout = new UILinearLayout();
            uILinearLayout.createView((Activity) this.mContext);
            this.adsViewContainer = uILinearLayout.linearLayout;
            this.linearLayout.addView(uILinearLayout.view);
        }
    }

    void makeAodlayout() {
        makeAodToolbar();
        addAodPlayer();
        this.linearLayout.addView(new AodDetDescriptionPresenter(this.mContext).createViewHolderAndBind(this.aodObjectDet).itemView);
        RecyclerViewListObject recyclerViewListObjectAddRelatedRow = addRelatedRow(this.aodObjectDet.related);
        addCommentRow(this.aodObjectDet.comments);
        this.mainAdapter.notifyDataSetChanged();
        recyclerViewListObjectAddRelatedRow.onItemLoadedListener = new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.12
            boolean isFirstTime = true;

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                MyLog.e("DetailFragment", "onResponse: ");
                if (this.isFirstTime) {
                    DetailFragment detailFragment = DetailFragment.this;
                    if (detailFragment.uiImagePlayer != null) {
                        this.isFirstTime = false;
                        detailFragment.uiMusicPlayer.setPlayerList(arrayList);
                    }
                }
            }
        };
    }

    void makeAodToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "بازگشت");
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        toolbarImageView.createView((Activity) getContext(), R.drawable.ic_share_grey);
        toolbarImageView.imageView.setPadding(0, AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f));
        this.toolbarMaker.addViewToLeftLayout(toolbarImageView.view);
        toolbarImageView.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailFragment.this.shareIt();
            }
        });
    }

    void makeCourselayout() {
        addUiImagePlayer();
        int i = 0;
        if (this.courseDet.has_trailer) {
            this.uiImagePlayer.playImage.setVisibility(0);
            this.uiImagePlayer.playImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FirebaseEventSender.sendEvent(DetailFragment.this.mContext, "play_course", DetailFragment.this.abs.getId() + " " + DetailFragment.this.abs.getTitle());
                    DetailFragment.this.playVideo(new PlayerPresenterItem(DetailFragment.this.courseDet.trailer_id, EnumContentType.course_item + BuildConfig.FLAVOR));
                }
            });
        } else {
            this.uiImagePlayer.playImage.setVisibility(4);
        }
        Iterator<SectionObject> it = this.courseDet.sections.iterator();
        while (it.hasNext()) {
            SectionObject next = it.next();
            i++;
            this.mainArrayList.add(next);
            Iterator<SessionObject> it2 = next.sessions.iterator();
            while (it2.hasNext()) {
                SessionObject next2 = it2.next();
                next2.position = next.sessions.indexOf(next2) + 1;
                this.mainArrayList.add(next2);
                i++;
            }
        }
        this.mainAdapter.notifyItemRangeInserted(this.mainArrayList.size() - i, i);
        addRelatedRow(this.courseDet.related);
        addCommentRow(this.courseDet.comments);
    }

    void makeTvEpisodeLayout() {
        addUiImagePlayer();
        this.uiImagePlayer.shareImage.setVisibility(8);
        this.uiImagePlayer.bookmarkImage.setVisibility(8);
        this.uiImagePlayer.recordImage.setVisibility(8);
        if (this.tvObjectDet.object_abs.getStatusType() == TvEpisodeObjectAbs.StatusType.playing) {
            this.uiImagePlayer.playImage.setVisibility(0);
            this.uiImagePlayer.startImage.setVisibility(0);
        } else if (this.tvObjectDet.object_abs.getStatusType() == TvEpisodeObjectAbs.StatusType.archive) {
            this.uiImagePlayer.playImage.setVisibility(0);
            this.uiImagePlayer.startImage.setVisibility(8);
        } else if (this.tvObjectDet.object_abs.getStatusType() == TvEpisodeObjectAbs.StatusType.future) {
            this.uiImagePlayer.playImage.setVisibility(8);
            this.uiImagePlayer.startImage.setVisibility(8);
        }
        this.uiImagePlayer.playImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayerPresenterItem playerPresenterItem;
                if (DetailFragment.this.tvObjectDet.object_abs.getStatusType() == TvEpisodeObjectAbs.StatusType.playing) {
                    playerPresenterItem = new PlayerPresenterItem(DetailFragment.this.tvObjectDet.object_abs.channel.channel_id + BuildConfig.FLAVOR, TagObject.TagType.tv_channel + BuildConfig.FLAVOR);
                    playerPresenterItem.isLive = true;
                    FirebaseEventSender.sendEvent(DetailFragment.this.mContext, "play_tv_live", DetailFragment.this.abs.getId() + " " + DetailFragment.this.abs.getTitle());
                } else {
                    FirebaseEventSender.sendEvent(DetailFragment.this.mContext, "play_tv_episode", DetailFragment.this.abs.getId() + " " + DetailFragment.this.abs.getTitle());
                    StringBuilder sb = new StringBuilder();
                    sb.append(DetailFragment.this.abs.getId());
                    sb.append(BuildConfig.FLAVOR);
                    playerPresenterItem = new PlayerPresenterItem(sb.toString(), DetailFragment.this.tagType + BuildConfig.FLAVOR);
                }
                DetailFragment.this.playVideo(playerPresenterItem);
            }
        });
        this.uiImagePlayer.startImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FirebaseEventSender.sendEvent(DetailFragment.this.mContext, "play_tv_episode", DetailFragment.this.abs.getId() + " " + DetailFragment.this.abs.getTitle());
                StringBuilder sb = new StringBuilder();
                sb.append(DetailFragment.this.abs.getId());
                sb.append(BuildConfig.FLAVOR);
                PlayerPresenterItem playerPresenterItem = new PlayerPresenterItem(sb.toString(), DetailFragment.this.tagType + BuildConfig.FLAVOR);
                playerPresenterItem.isLive = false;
                playerPresenterItem.isForcePlayFromBegin = true;
                DetailFragment.this.playVideo(playerPresenterItem);
            }
        });
        this.linearLayout.addView(new TvDetDescriptionPresenter(this.mContext).createViewHolderAndBind(this.tvObjectDet).itemView);
        addImageRow(this.tvObjectDet.snapshots);
        if (this.isAutoPlay) {
            if (this.uiImagePlayer.playImage.getVisibility() == 0) {
                this.uiImagePlayer.playImage.performClick();
            }
            this.isAutoPlay = false;
        }
    }

    private RecyclerViewListObject addRelatedRow(TagObject tagObject) {
        ListInput listInput = new ListInput(tagObject);
        listInput.limit = 18;
        listInput.title = "مرتبط ها";
        final RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(this.mContext), this);
        recyclerViewListObject.listInput = listInput;
        recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.17
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                DetailFragment.this.presentFragment(new ListFragment(recyclerViewListObject.listInput));
            }
        };
        this.mainArrayList.add(recyclerViewListObject);
        return recyclerViewListObject;
    }

    private void addImageRow(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        final ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ImageObject(it.next()));
        }
        ListInput listInput = new ListInput((ArrayList<? extends PresenterItem>) arrayList2);
        listInput.title = "تصاویر";
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(this.mContext), this.baseFragment);
        recyclerViewListObject.hasMoreText = false;
        recyclerViewListObject.hasLoadMore = false;
        recyclerViewListObject.onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.18
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                DetailFragment.this.presentFragment(new ImageListFragment(new ScrollViewListObject((ArrayList<PresenterItem>) arrayList2, MainPresenterSelector.getInstance(DetailFragment.this.mContext))));
            }
        };
        this.mainArrayList.add(recyclerViewListObject);
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
        if (this.uiMusicPlayer != null) {
            AudioPlayManager.getInstance().removeListener(this.uiMusicPlayer.listener);
        }
    }

    public void addUiImagePlayer() {
        this.uiImagePlayer.createView((Activity) this.mContext, this.abs.image_url);
        this.linearLayout.addView(this.uiImagePlayer.view, new FrameLayout.LayoutParams(-1, DimensionHelper.getHeaderHeight(this.mContext)));
        this.uiImagePlayer.shareImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DetailFragment.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailFragment.this.shareIt();
            }
        });
        this.uiImagePlayer.bookmarkImage.setVisibility(4);
    }

    private void addAodPlayer() {
        UIMusicPlayer uIMusicPlayer = new UIMusicPlayer();
        this.uiMusicPlayer = uIMusicPlayer;
        uIMusicPlayer.createView((Activity) this.mContext, this.aodObjectDet.object_abs);
        this.uiMusicPlayer.textViewBody.setText(((AODObjectAbs) this.abs).singer);
        this.uiMusicPlayer.textViewTitle.setText(this.abs.getTitle());
        this.linearLayout.getLayoutParams().height = DimensionHelper.getHeaderHeight(getContext());
        this.linearLayout.addView(this.uiMusicPlayer.view, new FrameLayout.LayoutParams(-1, DimensionHelper.getHeaderHeight(this.mContext)));
        AudioPlayManager.getInstance().addListener(this.uiMusicPlayer.listener);
        if (this.isAutoPlay) {
            AudioPlayManager.getInstance().play(new PlayableAudioObject(this.aodObjectDet.object_abs, this.currentAccount));
            this.isAutoPlay = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareIt() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.addFlags(MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
        intent.putExtra("android.intent.extra.TEXT", this.abs.share_link);
        this.mContext.startActivity(Intent.createChooser(intent, "اشتراک گذاری با: "));
    }
}
