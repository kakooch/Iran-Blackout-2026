package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.TagObject;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.AODCellPresenter;
import ir.resaneh1.iptv.presenters.CommentItemPresenter;
import ir.resaneh1.iptv.presenters.CourseCellPresenter;
import ir.resaneh1.iptv.presenters.LinkItemCellPresenter;
import ir.resaneh1.iptv.presenters.OperatorCellPresenter;
import ir.resaneh1.iptv.presenters.TVEpisodeCellPresenter;
import ir.resaneh1.iptv.presenters.TVEpisodeRowPresenter;
import ir.resaneh1.iptv.presenters.TvChannelCellPresenter;
import ir.resaneh1.iptv.presenters.VODCellPresenter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import ir.resaneh1.iptv.presenters.VirtualChannelAbsCellPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class ListFragment extends PresenterFragment {
    AODCellPresenter aodCellPresenter;
    public int columns;
    CommentItemPresenter commentPostPresenter;
    CourseCellPresenter courseCellPresenter;
    public boolean isFirstTime;
    public boolean isGrid;
    public boolean isHorizontal;
    public boolean isLastPortrait;
    public boolean isPreview;
    private LinkItemCellPresenter itemLinkPresenter;
    private String lastSearchedText;
    OperatorCellPresenter operatorCellPresenter;
    public int spaceDp;
    TVEpisodeCellPresenter tvCellPresenter;
    TvChannelCellPresenter tvChannelCellPresenter;
    private TVEpisodeRowPresenter tvEpisodeRowPresenter;
    private ViewGroupCellPresenter viewGroupCellPresenter;
    VirtualChannelAbsCellPresenter virtualChannelCellPresenter;
    VODCellPresenter vodCellPresenter;
    public int width;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_recyclerview;
    }

    public ListFragment() {
        this.isGrid = true;
        this.isHorizontal = false;
        this.columns = 1;
        this.spaceDp = 8;
        this.width = 100;
        this.isFirstTime = true;
        this.isLastPortrait = true;
        this.isPreview = false;
        this.lastSearchedText = "!uvt,oug,uo,f";
        this.isNeedLifecycleObservable = true;
    }

    public ListFragment(ListInput listInput) {
        this.isGrid = true;
        this.isHorizontal = false;
        this.columns = 1;
        this.spaceDp = 8;
        this.width = 100;
        this.isFirstTime = true;
        this.isLastPortrait = true;
        this.isPreview = false;
        this.lastSearchedText = "!uvt,oug,uo,f";
        this.isNeedLifecycleObservable = true;
        this.listInput = listInput;
        ViewTagObject viewTagObject = listInput.viewTagObject;
        if (viewTagObject != null) {
            this.isHorizontal = false;
            ViewGroupObject viewGroupObject = viewTagObject.view;
            if (viewGroupObject != null) {
                ViewGroupObject.TypeEnum typeEnum = viewGroupObject.type;
                if (typeEnum == ViewGroupObject.TypeEnum.Normal) {
                    this.isGrid = true;
                } else if (typeEnum == ViewGroupObject.TypeEnum.List) {
                    this.isGrid = false;
                }
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        MyLog.e("lifeCycle", "resume " + this.fragmentDebugName);
        if (!this.isFirstTime) {
            if (this.isLastPortrait != isPortrait()) {
                MyLog.e("ListFragment", "onResume: config change");
                setLayout();
                return;
            }
            return;
        }
        this.isFirstTime = false;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        ViewTagObject viewTagObject;
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, this.listInput.title);
        if (this.isPreview) {
            setPreviewLayout();
        }
        this.vodCellPresenter = new VODCellPresenter(this.mContext);
        this.aodCellPresenter = new AODCellPresenter(this.mContext);
        this.courseCellPresenter = new CourseCellPresenter(this.mContext);
        this.virtualChannelCellPresenter = new VirtualChannelAbsCellPresenter(this.mContext);
        this.tvCellPresenter = new TVEpisodeCellPresenter(this.mContext);
        this.tvEpisodeRowPresenter = new TVEpisodeRowPresenter(this.mContext);
        this.operatorCellPresenter = new OperatorCellPresenter(this.mContext);
        this.tvChannelCellPresenter = new TvChannelCellPresenter(this.mContext);
        this.itemLinkPresenter = new LinkItemCellPresenter(this.mContext);
        Context context = this.mContext;
        ListInput listInput = this.listInput;
        CommentItemPresenter commentItemPresenter = new CommentItemPresenter(context, listInput.parentId, listInput.likedItems);
        this.commentPostPresenter = commentItemPresenter;
        commentItemPresenter.isCanReply = false;
        ListInput listInput2 = this.listInput;
        TagObject tagObject = listInput2.tagObject;
        if (tagObject != null && tagObject.show_type == TagObject.ShowType.event && tagObject.type == TagObject.TagType.tv_episode) {
            this.isGrid = false;
        }
        if (listInput2.itemType == ListInput.ItemType.tag && tagObject != null && tagObject.type == TagObject.TagType.dynamicView && tagObject.viewObject != null) {
            ViewGroupCellPresenter viewGroupCellPresenter = new ViewGroupCellPresenter(this.mContext, false, this.listInput.tagObject.viewObject);
            this.viewGroupCellPresenter = viewGroupCellPresenter;
            viewGroupCellPresenter.isGrid = this.isGrid;
        }
        ListInput listInput3 = this.listInput;
        ListInput.ItemType itemType = listInput3.itemType;
        ListInput.ItemType itemType2 = ListInput.ItemType.viewTag;
        if ((itemType == itemType2 || itemType == ListInput.ItemType.searchViewTag) && (viewTagObject = listInput3.viewTagObject) != null && viewTagObject.view != null) {
            ViewGroupCellPresenter viewGroupCellPresenter2 = new ViewGroupCellPresenter(this.mContext, false, this.listInput.viewTagObject.view);
            this.viewGroupCellPresenter = viewGroupCellPresenter2;
            viewGroupCellPresenter2.isGrid = this.isGrid;
        }
        if (this.isGrid) {
            setSizeOfCells();
            initWithRtlGridLayout(this.width, this.spaceDp);
        } else if (this.isHorizontal) {
            initWithHorizontallLinearLayoutManager();
        } else {
            initWithVerticalLinearLayoutManager();
            ListInput listInput4 = this.listInput;
            ListInput.ItemType itemType3 = listInput4.itemType;
            if (itemType3 == itemType2 || itemType3 == ListInput.ItemType.searchViewTag) {
                this.mainRecyclerView.setPadding(AndroidUtilities.dp(listInput4.viewTagObject.view.h_space * 100.0f), 0, AndroidUtilities.dp(this.listInput.viewTagObject.view.h_space * 100.0f), AndroidUtilities.dp(this.listInput.viewTagObject.view.v_space * 100.0f));
            }
        }
        final MainClickHandler mainClickHandler = new MainClickHandler();
        OnPresenterItemClickListener onPresenterItemClickListener = new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.ListFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                MyLog.e("ListFragment", "onClick: " + abstractViewHolder.item.getPresenterType());
                mainClickHandler.onClick(ListFragment.this.baseFragment, abstractViewHolder);
            }
        };
        OnLoadMoreListener onLoadMoreListener = new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.ListFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                MyLog.e("ListFragment", "loadMore: ");
                ListFragment.this.loadItems();
            }
        };
        this.onItemLoadedListener = new ItemListRequest.Listener(this) { // from class: ir.resaneh1.iptv.fragment.ListFragment.3
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
            }
        };
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.ListFragment.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.viewDataObject) {
                    return ListFragment.this.viewGroupCellPresenter;
                }
                if (presenterItemType == PresenterItemType.vod) {
                    return ListFragment.this.vodCellPresenter;
                }
                if (presenterItemType == PresenterItemType.aod) {
                    return ListFragment.this.aodCellPresenter;
                }
                if (presenterItemType == PresenterItemType.course) {
                    return ListFragment.this.courseCellPresenter;
                }
                if (presenterItemType == PresenterItemType.virtualChannelAbs) {
                    return ListFragment.this.virtualChannelCellPresenter;
                }
                if (presenterItemType == PresenterItemType.itemLink) {
                    return ListFragment.this.itemLinkPresenter;
                }
                if (presenterItemType == PresenterItemType.tv_episode) {
                    ListFragment listFragment = ListFragment.this;
                    if (listFragment.listInput.tagObject.show_type == TagObject.ShowType.event) {
                        return listFragment.tvEpisodeRowPresenter;
                    }
                    return listFragment.tvCellPresenter;
                }
                if (presenterItemType == PresenterItemType.Operator) {
                    return ListFragment.this.operatorCellPresenter;
                }
                if (presenterItemType == PresenterItemType.tv_channel) {
                    return ListFragment.this.tvChannelCellPresenter;
                }
                if (presenterItemType == PresenterItemType.comment) {
                    ListFragment listFragment2 = ListFragment.this;
                    if (listFragment2.listInput.tagObject.show_type == TagObject.ShowType.postComment) {
                        return listFragment2.commentPostPresenter;
                    }
                }
                return MainPresenterSelector.getInstance(ListFragment.this.mContext).getPresenter(presenterItemType);
            }
        }, onPresenterItemClickListener, onLoadMoreListener);
        this.mainAdapter = mainAdapter;
        mainAdapter.isSavePosition = true;
        mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
        ListInput listInput5 = this.listInput;
        if (listInput5 == null || listInput5.itemType == null) {
            this.notFoundLayout.setVisibility(0);
            this.progressBar.setVisibility(4);
        } else if (!this.isPreview) {
            if (this.mainAdapter.isLoadMoreAuto) {
                addLoadMoreItem(true);
            } else {
                addLoadMoreItem(false);
            }
            loadItems();
        }
        if (this.isGrid) {
            RecyclerView recyclerView = this.mainRecyclerView;
            recyclerView.setPadding(recyclerView.getPaddingLeft(), AndroidUtilities.dp(this.spaceDp), this.mainRecyclerView.getPaddingRight(), AndroidUtilities.dp(this.spaceDp));
        }
    }

    private void setPreviewLayout() {
        findViewById(R.id.toolbar_with_background).setVisibility(8);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
    }

    private void setSizeOfCells() {
        ViewGroupCellPresenter viewGroupCellPresenter;
        ViewGroupCellPresenter viewGroupCellPresenter2;
        ListInput listInput = this.listInput;
        ListInput.ItemType itemType = listInput.itemType;
        ListInput.ItemType itemType2 = ListInput.ItemType.viewTag;
        if (itemType == itemType2 || itemType == ListInput.ItemType.searchViewTag) {
            this.spaceDp = (int) (listInput.viewTagObject.view.h_space * 100.0f);
        }
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(this.mContext, DimensionHelper.getItemWidth(getContext(), this.listInput) + AndroidUtilities.dp(this.spaceDp));
        this.columns = iCalculateNoOfColumns;
        this.width = DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, iCalculateNoOfColumns, AndroidUtilities.dp(this.spaceDp));
        float itemImageHeight = DimensionHelper.getItemImageHeight(this.mContext, this.listInput) / DimensionHelper.getItemImageWidth(this.mContext, this.listInput);
        ListInput listInput2 = this.listInput;
        if (listInput2 != null) {
            ListInput.ItemType itemType3 = listInput2.itemType;
            if (itemType3 == ListInput.ItemType.tag) {
                TagObject.TagType tagType = listInput2.tagObject.type;
                if (tagType == TagObject.TagType.vod_film) {
                    VODCellPresenter vODCellPresenter = this.vodCellPresenter;
                    int i = this.width;
                    vODCellPresenter.width = i;
                    vODCellPresenter.height = (int) (i * itemImageHeight);
                } else if (tagType == TagObject.TagType.aod_track) {
                    AODCellPresenter aODCellPresenter = this.aodCellPresenter;
                    int i2 = this.width;
                    aODCellPresenter.width = i2;
                    aODCellPresenter.height = (int) (i2 * itemImageHeight);
                } else if (tagType == TagObject.TagType.course) {
                    CourseCellPresenter courseCellPresenter = this.courseCellPresenter;
                    int i3 = this.width;
                    courseCellPresenter.width = i3;
                    courseCellPresenter.height = (int) (i3 * itemImageHeight);
                } else if (tagType == TagObject.TagType.virtual_channel) {
                    VirtualChannelAbsCellPresenter virtualChannelAbsCellPresenter = this.virtualChannelCellPresenter;
                    int i4 = this.width;
                    virtualChannelAbsCellPresenter.width = i4;
                    virtualChannelAbsCellPresenter.height = (int) (i4 * itemImageHeight);
                } else if (tagType == TagObject.TagType.item_link) {
                    LinkItemCellPresenter linkItemCellPresenter = this.itemLinkPresenter;
                    int i5 = this.width;
                    linkItemCellPresenter.width = i5;
                    linkItemCellPresenter.height = (int) (i5 * itemImageHeight);
                } else if (tagType == TagObject.TagType.tv_episode) {
                    TVEpisodeCellPresenter tVEpisodeCellPresenter = this.tvCellPresenter;
                    int i6 = this.width;
                    tVEpisodeCellPresenter.width = i6;
                    tVEpisodeCellPresenter.height = (int) (i6 * itemImageHeight);
                } else if (tagType == TagObject.TagType.operator) {
                    OperatorCellPresenter operatorCellPresenter = this.operatorCellPresenter;
                    int i7 = this.width;
                    operatorCellPresenter.width = i7;
                    operatorCellPresenter.height = (int) (i7 * itemImageHeight);
                } else if (tagType == TagObject.TagType.tv_channel) {
                    TvChannelCellPresenter tvChannelCellPresenter = this.tvChannelCellPresenter;
                    int i8 = this.width;
                    tvChannelCellPresenter.width = i8;
                    tvChannelCellPresenter.height = (int) (i8 * itemImageHeight);
                } else if (tagType == TagObject.TagType.dynamicView && (viewGroupCellPresenter2 = this.viewGroupCellPresenter) != null) {
                    int i9 = this.width;
                    viewGroupCellPresenter2.widthPx = i9;
                    viewGroupCellPresenter2.heightPx = (int) (i9 * itemImageHeight);
                }
                MyLog.e("ListFragment", "init: " + this.width + " " + ((int) (this.width * itemImageHeight)) + " " + itemImageHeight + " " + this.columns);
                return;
            }
            if ((itemType3 != itemType2 && itemType3 != ListInput.ItemType.searchViewTag) || listInput2.viewTagObject == null || (viewGroupCellPresenter = this.viewGroupCellPresenter) == null) {
                return;
            }
            int i10 = this.width;
            viewGroupCellPresenter.widthPx = i10;
            viewGroupCellPresenter.heightPx = (int) (itemImageHeight * i10);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayout();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        MyLog.e("lifeCycle", "pause " + this.fragmentDebugName);
        this.isLastPortrait = isPortrait();
    }

    public void setLayout() {
        if (this.isGrid) {
            for (int i = 0; i < this.mainRecyclerView.getItemDecorationCount(); i++) {
                this.mainRecyclerView.removeItemDecorationAt(i);
            }
            setSizeOfCells();
            initWithRtlGridLayout(this.width, this.spaceDp);
            return;
        }
        if (this.viewGroupCellPresenter != null) {
            this.mainAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        this.isStopLoading = false;
        this.progressBar.setVisibility(0);
        loadItems();
    }

    public void onSearchClick(String str) {
        if (str == null || str.equals(this.lastSearchedText)) {
            return;
        }
        this.lastSearchedText = str;
        callSearch(str);
    }

    private void callSearch(String str) {
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        this.notFoundLayout.setVisibility(4);
        ListInput listInput = this.listInput;
        if (listInput.itemType != ListInput.ItemType.searchViewTag || listInput.viewTagObject == null) {
            return;
        }
        listInput.search_input = str;
        listInput.start_id = BuildConfig.FLAVOR;
        this.isStopLoading = false;
        if (this.mainAdapter.isLoadMoreAuto) {
            addLoadMoreItem(true);
        } else {
            addLoadMoreItem(false);
        }
        loadItems();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void setRetryLayout() {
        super.setRetryLayout();
        if (this.mainArrayList.size() == 0) {
            showRetryLayout();
        }
    }

    public void initSearch() {
        this.lastSearchedText = "!uvt,oug,uo,f";
        this.notFoundLayout.setVisibility(4);
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        MyLog.e("lifeCycle", "destroy " + this.fragmentDebugName);
    }
}
