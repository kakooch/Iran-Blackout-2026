package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidMessenger.utilites.BotButtonHandler;
import androidMessenger.utilites.MessageConverter;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.model.FileUploadProperties;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.UIView.UILinearLayoutScrollable;
import ir.resaneh1.iptv.apiMessanger.RxHelper;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.AddObjectData;
import ir.resaneh1.iptv.model.AddPagePartData;
import ir.resaneh1.iptv.model.ApiClickData;
import ir.resaneh1.iptv.model.ButtonFileObject;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.CommandInfoObject;
import ir.resaneh1.iptv.model.DynamicListPagePartDataObject;
import ir.resaneh1.iptv.model.DynamicPageButtonObject;
import ir.resaneh1.iptv.model.DynamicPageCommandObject;
import ir.resaneh1.iptv.model.DynamicPageObjectDataInfo;
import ir.resaneh1.iptv.model.DynamicPagePartDataObject;
import ir.resaneh1.iptv.model.DynamicTagPagePartDataObject;
import ir.resaneh1.iptv.model.EditObjectData;
import ir.resaneh1.iptv.model.GetDynamicPageDataInput;
import ir.resaneh1.iptv.model.GetDynamicPageDataOutput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsInput;
import ir.resaneh1.iptv.model.GetDynamicPageViewsOutput;
import ir.resaneh1.iptv.model.GoLinkData;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.PageAttrObject;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.RemoveObjectData;
import ir.resaneh1.iptv.model.RemovePagePartData;
import ir.resaneh1.iptv.model.RequestDataDynamicPage;
import ir.resaneh1.iptv.model.SendDataDynamicPageInput;
import ir.resaneh1.iptv.model.SendDataDynamicPageOutput;
import ir.resaneh1.iptv.model.SetButtonResultInput;
import ir.resaneh1.iptv.model.ShortcutObject;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewDataObjectArray;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewObjectAttr;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelectorSecond;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ArrayViewGroupPresenter;
import ir.resaneh1.iptv.presenters.EndpointTitlePresenter;
import ir.resaneh1.iptv.presenters.RecyclerViewListPresenter;
import ir.resaneh1.iptv.presenters.ShortcutPresenter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.PhotoPickerActivity;

/* loaded from: classes3.dex */
public class DynamicPageFragment extends PresenterFragment {
    FrameLayout contentFrameLayout;
    private Map<String, DynamicPageObjectDataInfo> dataInfoMap;
    public String dynamic_page_type_id;
    public String getDataUrl;
    ImageView imageViewBackground;
    private Disposable loadItemDisposable;
    public String objectId;
    private ArrayList<DynamicPagePartDataObject> pagePartDataArrayFromServer;
    PresenterSelectorSecond presenterSelector;
    private String title;
    private EndpointTitlePresenter titlePresenter;
    private ArrayList<ViewGroupObject> viewArray;
    private Map<String, ViewGroupObject> viewMap;
    private SparseArray<ArrayViewGroupPresenter> viewPresenterArrayMap;
    private SparseArray<ViewGroupCellPresenter> viewPresenterMap;
    private LinkedList<CommandInfoObject> commandQueue = new LinkedList<>();
    private ArrayList<RequestDataDynamicPage> dataToSendArray = new ArrayList<>();
    public boolean isPreview = false;
    public boolean isLastPortrait = true;
    private boolean isViewsLoadedFromServer = false;
    public String nextStartId = BuildConfig.FLAVOR;
    private int currentCommandInProgressCount = 0;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.dynamic_page_fragment;
    }

    public DynamicPageFragment(String str, String str2, String str3) {
        this.title = str;
        this.dynamic_page_type_id = str2;
        this.objectId = str3;
        this.fragmentName = "DynamicPageFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.isNeedLifecycleObservable = true;
        this.swipeBackEnabled = false;
        this.pagePartDataArrayFromServer = new ArrayList<>();
        initWithVerticalLinearLayoutManager();
        if (this.isPreview) {
            setPreviewLayout();
        }
        this.progressBar.setVisibility(4);
        this.titlePresenter = new EndpointTitlePresenter(this.mContext);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.presenterSelector = new PresenterSelectorSecond() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelectorSecond
            public AbstractPresenter getPresenter(int i) {
                if (i == PresenterItemType.title.ordinal()) {
                    return DynamicPageFragment.this.titlePresenter;
                }
                ArrayViewGroupPresenter arrayViewGroupPresenter = (ArrayViewGroupPresenter) DynamicPageFragment.this.viewPresenterArrayMap.get(i);
                if (arrayViewGroupPresenter != null) {
                    return arrayViewGroupPresenter;
                }
                try {
                    return (AbstractPresenter) DynamicPageFragment.this.viewPresenterMap.get(i);
                } catch (Exception unused) {
                    return null;
                }
            }
        };
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), this.presenterSelector, null, new OnLoadMoreListener() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnLoadMoreListener
            public void loadMore(int i) {
                DynamicPageFragment.this.loadItems();
            }
        });
        this.mainAdapter = mainAdapter;
        mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
        new RxHelper();
        if (this.dynamic_page_type_id == null || this.objectId == null) {
            return;
        }
        callGetViews();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.contentFrameLayout = (FrameLayout) findViewById(R.id.frameLayoutContent);
        this.imageViewBackground = (ImageView) findViewById(R.id.imageViewBackground);
    }

    private void setPreviewLayout() {
        View viewFindViewById = findViewById(R.id.toolbar_with_background);
        if (viewFindViewById == null) {
            viewFindViewById = findViewById(R.id.toolbar);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    private void callGetViews() {
        this.progressBar.setVisibility(0);
        this.isViewsLoadedFromServer = false;
        this.viewMap = new HashMap();
        this.viewPresenterMap = new SparseArray<>();
        this.viewPresenterArrayMap = new SparseArray<>();
        ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().getDynamicPageViews(new GetDynamicPageViewsInput(this.dynamic_page_type_id), null).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<GetDynamicPageViewsOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.4
            @Override // io.reactivex.functions.Consumer
            public void accept(MessangerOutput<GetDynamicPageViewsOutput> messangerOutput) throws Exception {
                GetDynamicPageViewsOutput getDynamicPageViewsOutput;
                GetDynamicPageViewsOutput getDynamicPageViewsOutput2;
                ArrayList<ViewGroupObject> arrayList;
                if (messangerOutput == null || (getDynamicPageViewsOutput = messangerOutput.data) == null || (arrayList = (getDynamicPageViewsOutput2 = getDynamicPageViewsOutput).views) == null || arrayList.size() <= 0) {
                    return;
                }
                DynamicPageFragment.this.isViewsLoadedFromServer = true;
                DynamicPageFragment.this.makeViewsMap(getDynamicPageViewsOutput2.views);
                DynamicPageFragment.this.viewArray = getDynamicPageViewsOutput2.views;
                String str = getDynamicPageViewsOutput2.api_url;
                if (str != null) {
                    DynamicPageFragment.this.getDataUrl = str;
                } else {
                    DynamicPageFragment.this.getDataUrl = null;
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GetDynamicPageViewsOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetDynamicPageViewsOutput> messangerOutput) {
                if (DynamicPageFragment.this.isViewsLoadedFromServer) {
                    DynamicPageFragment dynamicPageFragment = DynamicPageFragment.this;
                    if (dynamicPageFragment.getDataUrl != null) {
                        dynamicPageFragment.callGetData();
                        GetDynamicPageViewsOutput getDynamicPageViewsOutput = messangerOutput.data;
                        if (getDynamicPageViewsOutput.page_attr != null) {
                            DynamicPageFragment.this.setPageByPageAttr(getDynamicPageViewsOutput.page_attr);
                            return;
                        } else {
                            DynamicPageFragment.this.setToolbar();
                            return;
                        }
                    }
                }
                DynamicPageFragment.this.setNotFoundLayout();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DynamicPageFragment.this.progressBar.setVisibility(4);
                DynamicPageFragment.this.showRetryLayout();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageByPageAttr(PageAttrObject pageAttrObject) {
        View viewFindViewById;
        if (pageAttrObject == null) {
            return;
        }
        float f = pageAttrObject.top_space;
        this.mainRecyclerView.setPadding(0, AndroidUtilities.dp(f > 0.0f ? (int) (f * 100.0f) : 0), 0, AndroidUtilities.dp(pageAttrObject.bottom_space > 0.0f ? (int) (r4 * 100.0f) : 0));
        int i = pageAttrObject.show_toolbar ? 56 : 0;
        if (i == 0) {
            ((FrameLayout.LayoutParams) this.progressBar.getLayoutParams()).topMargin = AndroidUtilities.dp(72.0f);
        }
        ((FrameLayout.LayoutParams) this.contentFrameLayout.getLayoutParams()).setMargins(0, AndroidUtilities.dp(i), 0, 0);
        if (pageAttrObject.show_toolbar) {
            Toolbar toolbar = this.toolbarMaker.toolbar;
            if (toolbar != null && (viewFindViewById = toolbar.findViewById(R.id.toolbar_lay)) != null) {
                viewFindViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.toolbar_grey));
            }
        } else {
            Toolbar toolbar2 = this.toolbarMaker.toolbar;
            if (toolbar2 != null) {
                toolbar2.setBackgroundColor(0);
                View viewFindViewById2 = this.toolbarMaker.toolbar.findViewById(R.id.toolbar_lay);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.setBackgroundColor(0);
                }
            }
        }
        setToolbarTitleAndIcon(pageAttrObject.show_title, pageAttrObject.show_back, this.title, pageAttrObject.toolbar_items_color);
        this.imageViewBackground.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        ColorObject colorObject = pageAttrObject.background_color;
        if (colorObject != null) {
            this.imageViewBackground.setBackgroundColor(colorObject.getColor());
        }
        if (pageAttrObject.background_image != null) {
            this.fragmentView.setBackgroundColor(0);
            GlideHelper.load(this.mContext, this.imageViewBackground, pageAttrObject.background_image);
        }
        Link link = pageAttrObject.search_link;
        if (link != null) {
            link.dynamic_page_object_id = this.objectId;
            setSearchView(link, pageAttrObject.toolbar_items_color);
        }
        ArrayList<ShortcutObject> arrayList = pageAttrObject.shortcuts;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        setShortcutView(pageAttrObject.shortcuts);
    }

    private void setSearchView(final Link link, ColorObject colorObject) {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        View viewCreateView = toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_search_small_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        if (colorObject != null) {
            toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
        }
        viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    new MainClickHandler().onLinkClick(DynamicPageFragment.this.baseFragment, link);
                } catch (Exception unused) {
                }
            }
        });
        ToolbarMaker toolbarMaker = this.toolbarMaker;
        if (toolbarMaker != null) {
            toolbarMaker.leftLayout.removeAllViews();
            this.toolbarMaker.addViewToLeftLayout(viewCreateView);
        }
    }

    public void setToolbarTitleAndIcon(boolean z, boolean z2, String str, ColorObject colorObject) {
        this.toolbarMaker.clearToolbar();
        if (z2) {
            View viewCreateView = this.toolbarMaker.toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.arrow_back_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
            if (colorObject != null) {
                this.toolbarMaker.toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
            }
            viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            });
            this.toolbarMaker.addViewToRightLayout(viewCreateView);
        }
        if (z) {
            View viewCreateView2 = this.toolbarMaker.toolbarTextView.createView(ApplicationLoader.applicationActivity, str);
            if (colorObject != null) {
                this.toolbarMaker.toolbarTextView.textView.setTextColor(colorObject.getColor());
            } else {
                this.toolbarMaker.toolbarTextView.textView.setTextColor(this.mContext.getResources().getColor(R.color.toolbar_text_grey));
            }
            this.toolbarMaker.addViewToRightLayout(viewCreateView2);
        }
    }

    public void makeViewsMap(ArrayList<ViewGroupObject> arrayList) {
        this.viewPresenterMap.clear();
        this.viewPresenterArrayMap.clear();
        this.viewMap.clear();
        Iterator<ViewGroupObject> it = arrayList.iterator();
        while (it.hasNext()) {
            ViewGroupObject next = it.next();
            ViewGroupCellPresenter viewGroupCellPresenter = new ViewGroupCellPresenter(this.mContext, false, next);
            viewGroupCellPresenter.isNeedMargin = true;
            if (viewGroupCellPresenter.isGrid) {
                setSizeOfCells(next, viewGroupCellPresenter, 1);
            }
            viewGroupCellPresenter.dynamicPageFragment = this;
            ArrayViewGroupPresenter arrayViewGroupPresenter = getArrayViewGroupPresenter(next);
            String str = next.view_key;
            if (str != null) {
                this.viewMap.put(str, next);
                this.viewPresenterMap.put(ViewDataObject.getPresenterItemTypeByViewId(next.view_key.hashCode()), viewGroupCellPresenter);
                this.viewPresenterArrayMap.put(ViewDataObjectArray.getPresenterItemTypeByViewId(next.view_key.hashCode()), arrayViewGroupPresenter);
            }
        }
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

    public ArrayList<PresenterItem> makeListToShow(ArrayList<DynamicPagePartDataObject> arrayList) {
        DynamicListPagePartDataObject dynamicListPagePartDataObject;
        ArrayList<ViewDataObject> arrayList2;
        int i;
        ArrayList<PresenterItem> arrayList3 = new ArrayList<>();
        Iterator<DynamicPagePartDataObject> it = arrayList.iterator();
        while (it.hasNext()) {
            DynamicPagePartDataObject next = it.next();
            if (this.viewMap.get(next.view_key) != null) {
                DynamicPagePartDataObject.ObjectTypeEnum objectTypeEnum = next.object_type;
                if (objectTypeEnum == DynamicPagePartDataObject.ObjectTypeEnum.Tag && next.tag_page_part_data != null) {
                    ViewTagObject viewTagObject = new ViewTagObject();
                    DynamicTagPagePartDataObject dynamicTagPagePartDataObject = next.tag_page_part_data;
                    viewTagObject.tag_id = dynamicTagPagePartDataObject.tag_id;
                    viewTagObject.title = dynamicTagPagePartDataObject.title;
                    viewTagObject.api_url = dynamicTagPagePartDataObject.api_url;
                    viewTagObject.view = this.viewMap.get(next.view_key);
                    viewTagObject.type = next.show_type;
                    addHorizontalListRow(arrayList3, viewTagObject, next.page_part_data_id);
                } else if (objectTypeEnum == DynamicPagePartDataObject.ObjectTypeEnum.List && (dynamicListPagePartDataObject = next.list_page_part_data) != null && (arrayList2 = dynamicListPagePartDataObject.object_data_list) != null && arrayList2.size() > 0) {
                    String str = next.list_page_part_data.title;
                    if (str != null && !str.isEmpty()) {
                        TitleObject titleObject = new TitleObject(next.list_page_part_data.title);
                        titleObject.pagePartId = next.page_part_data_id;
                        arrayList3.add(titleObject);
                    }
                    ViewDataObjectArray viewDataObjectArray = new ViewDataObjectArray();
                    if (next.show_type == ViewTagObject.TypeEnum.Grid) {
                        setCountAndSize(next, this.viewMap.get(next.view_key));
                    }
                    Iterator<ViewDataObject> it2 = next.list_page_part_data.object_data_list.iterator();
                    while (true) {
                        i = 0;
                        while (it2.hasNext()) {
                            ViewDataObject next2 = it2.next();
                            next2.viewId = Integer.valueOf(next.view_key.hashCode());
                            String str2 = next2.object_data_id;
                            if (str2 != null) {
                                this.dataInfoMap.put(str2, new DynamicPageObjectDataInfo(next2, next.page_part_data_id));
                            }
                            ViewTagObject.TypeEnum typeEnum = next.show_type;
                            if (typeEnum == ViewTagObject.TypeEnum.List) {
                                arrayList3.add(next2);
                            } else if (typeEnum == ViewTagObject.TypeEnum.Grid) {
                                viewDataObjectArray.viewId = Integer.valueOf(next.view_key.hashCode());
                                viewDataObjectArray.pagePartId = next.page_part_data_id;
                                viewDataObjectArray.arrayList.add(next2);
                                i++;
                                if (i >= next.itemCount) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                        arrayList3.add(viewDataObjectArray);
                        viewDataObjectArray = new ViewDataObjectArray();
                    }
                    if (i > 0) {
                        arrayList3.add(viewDataObjectArray);
                    }
                }
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetData() {
        if (this.objectId == null) {
            return;
        }
        this.progressBar.setVisibility(0);
        this.dataInfoMap = new HashMap();
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        this.mainAdapter.isLoadMoreAuto = true;
        loadItems();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void loadItems() {
        final ArrayList arrayList = new ArrayList();
        Disposable disposable = this.loadItemDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        if (!this.isStopLoading) {
            this.isStopLoading = true;
            if (!this.mainAdapter.isLoadMoreAuto) {
                setLoadMoreItemLoading(true);
            }
            Disposable disposable2 = (Disposable) getApiRequestMessangerRx().getDynamicPageData(this.getDataUrl, new GetDynamicPageDataInput(this.objectId, this.nextStartId), null).observeOn(Schedulers.computation()).doOnNext(new Consumer<MessangerOutput<GetDynamicPageDataOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.8
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<GetDynamicPageDataOutput> messangerOutput) throws Exception {
                    GetDynamicPageDataOutput getDynamicPageDataOutput;
                    if (messangerOutput == null || (getDynamicPageDataOutput = messangerOutput.data) == null) {
                        return;
                    }
                    GetDynamicPageDataOutput getDynamicPageDataOutput2 = getDynamicPageDataOutput;
                    if (getDynamicPageDataOutput2.page_data != null) {
                        ArrayList<DynamicPagePartDataObject> arrayList2 = new ArrayList<>();
                        Iterator<DynamicPagePartDataObject> it = getDynamicPageDataOutput2.page_data.iterator();
                        while (it.hasNext()) {
                            DynamicPagePartDataObject next = it.next();
                            if (next.view_key != null) {
                                arrayList2.add(next);
                                DynamicPageFragment.this.pagePartDataArrayFromServer.add(next);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            arrayList.addAll(DynamicPageFragment.this.makeListToShow(arrayList2));
                            ((PresenterFragment) DynamicPageFragment.this).isStopLoading = false;
                        }
                    }
                    DynamicPageFragment dynamicPageFragment = DynamicPageFragment.this;
                    dynamicPageFragment.nextStartId = getDynamicPageDataOutput2.next_start_id;
                    if (getDynamicPageDataOutput2.has_continue) {
                        return;
                    }
                    ((PresenterFragment) dynamicPageFragment).isStopLoading = true;
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GetDynamicPageDataOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.7
                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetDynamicPageDataOutput> messangerOutput) {
                    DynamicPageFragment.this.progressBar.setVisibility(4);
                    View view = DynamicPageFragment.this.retryLayout;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    DynamicPageFragment.this.removeLoadMoreItemIfNeeded();
                    if (arrayList.size() > 0) {
                        DynamicPageFragment.this.mainArrayList.addAll(arrayList);
                        int size = arrayList.size();
                        DynamicPageFragment dynamicPageFragment = DynamicPageFragment.this;
                        dynamicPageFragment.mainAdapter.notifyItemRangeChanged(dynamicPageFragment.mainArrayList.size() - size, size);
                        if (!((PresenterFragment) DynamicPageFragment.this).isStopLoading) {
                            DynamicPageFragment dynamicPageFragment2 = DynamicPageFragment.this;
                            MainAdapter mainAdapter = dynamicPageFragment2.mainAdapter;
                            if (mainAdapter.isWantLoadMore) {
                                if (mainAdapter.isLoadMoreAuto) {
                                    dynamicPageFragment2.addLoadMoreItem(true);
                                } else {
                                    dynamicPageFragment2.addLoadMoreItem(false);
                                }
                            }
                        }
                    }
                    if (DynamicPageFragment.this.mainArrayList.size() <= 0) {
                        DynamicPageFragment.this.setNotFoundLayout();
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    DynamicPageFragment.this.progressBar.setVisibility(4);
                    View view = DynamicPageFragment.this.retryLayout;
                    if (view != null) {
                        view.setVisibility(4);
                    }
                    if (DynamicPageFragment.this.mainArrayList.size() <= 0) {
                        DynamicPageFragment.this.showRetryLayout();
                    }
                    DynamicPageFragment.this.setLoadMoreItemLoading(false);
                    ((PresenterFragment) DynamicPageFragment.this).isStopLoading = true;
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    DynamicPageFragment.this.progressBar.setVisibility(4);
                }
            });
            this.loadItemDisposable = disposable2;
            ((PresenterFragment) this).compositeDisposable.add(disposable2);
            return;
        }
        this.progressBar.setVisibility(4);
    }

    public void addHorizontalListRow(ArrayList<PresenterItem> arrayList, ViewTagObject viewTagObject, String str) {
        final ListInput listInput = new ListInput(viewTagObject);
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(this.mContext), this);
        recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.9
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                new MainClickHandler().onMoreViewListClick(listInput.viewTagObject);
            }
        };
        ViewGroupObject viewGroupObject = viewTagObject.view;
        recyclerViewListObject.hasMoreText = viewGroupObject.has_more;
        recyclerViewListObject.hasLoadMore = true;
        recyclerViewListObject.hastTitle = viewGroupObject.has_title;
        recyclerViewListObject.isSaveSelected = true;
        recyclerViewListObject.itemHeight = viewGroupObject.size.getHeightPx();
        recyclerViewListObject.decorationSize = (int) (viewTagObject.view.h_space * 100.0f);
        recyclerViewListObject.pagePartId = str;
        arrayList.add(recyclerViewListObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey(ApplicationLoader.applicationActivity, this.title);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        if (!this.isViewsLoadedFromServer) {
            callGetViews();
        } else {
            loadItems();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MyLog.e("HomeFragment", "onConfigurationChanged: ");
        onRotate();
    }

    private void onRotate() {
        ArrayList arrayList = new ArrayList();
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        ArrayList<ViewGroupObject> arrayList2 = this.viewArray;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        makeViewsMap(this.viewArray);
        if (this.pagePartDataArrayFromServer.size() > 0) {
            arrayList.addAll(makeListToShow(this.pagePartDataArrayFromServer));
            if (arrayList.size() > 0) {
                this.mainArrayList.addAll(arrayList);
                this.mainAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isLastPortrait != isPortrait()) {
            MyLog.e("homeFragment", "onResume: isFirstTime" + this.isLastPortrait + isPortrait());
            onRotate();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.isLastPortrait = isPortrait();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    public void setCountAndSize(DynamicPagePartDataObject dynamicPagePartDataObject, ViewGroupObject viewGroupObject) {
        int i = (int) (viewGroupObject.h_space * 100.0f);
        ViewTagObject viewTagObject = new ViewTagObject();
        viewTagObject.view = viewGroupObject;
        this.listInput = new ListInput(viewTagObject);
        float f = i;
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(this.mContext, DimensionHelper.getItemWidth(getContext(), this.listInput) + AndroidUtilities.dp(f));
        int iCalculateItemWidthBasedOnColumns = DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, iCalculateNoOfColumns, AndroidUtilities.dp(f));
        dynamicPagePartDataObject.itemCount = iCalculateNoOfColumns;
        dynamicPagePartDataObject.itemWidthPx = iCalculateItemWidthBasedOnColumns;
    }

    public ArrayViewGroupPresenter getArrayViewGroupPresenter(ViewGroupObject viewGroupObject) {
        int i = (int) (viewGroupObject.h_space * 100.0f);
        ViewTagObject viewTagObject = new ViewTagObject();
        viewTagObject.view = viewGroupObject;
        this.listInput = new ListInput(viewTagObject);
        float f = i;
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(this.mContext, DimensionHelper.getItemWidth(getContext(), this.listInput) + AndroidUtilities.dp(f));
        return new ArrayViewGroupPresenter(this.mContext, this, viewGroupObject, iCalculateNoOfColumns, DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, iCalculateNoOfColumns, AndroidUtilities.dp(f)));
    }

    public void doCommandRemovePagePart(RemovePagePartData removePagePartData) {
        String str;
        if (removePagePartData == null || (str = removePagePartData.page_part_data_id) == null || !isExistPagePart(str)) {
            return;
        }
        final String str2 = removePagePartData.page_part_data_id;
        final ArrayList<PresenterItem> arrayListFindAndRemoveDataOfPagePartInMainArray = findAndRemoveDataOfPagePartInMainArray(str2);
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.timer(100L, TimeUnit.MILLISECONDS).observeOn(Schedulers.computation()).doOnNext(new Consumer<Long>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.11
            @Override // io.reactivex.functions.Consumer
            public void accept(Long l) throws Exception {
                for (int i = 0; i < arrayListFindAndRemoveDataOfPagePartInMainArray.size(); i++) {
                    PresenterItem presenterItem = (PresenterItem) arrayListFindAndRemoveDataOfPagePartInMainArray.get(i);
                    if (presenterItem instanceof ViewDataObject) {
                        DynamicPageFragment.this.dataInfoMap.remove(((ViewDataObject) presenterItem).object_data_id);
                    }
                }
                DynamicPageFragment.this.removeFromPagePartServerArray(str2);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>(this) { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
            }
        }));
    }

    private ArrayList<PresenterItem> findAndRemoveDataOfPagePartInMainArray(String str) {
        ArrayList<PresenterItem> arrayList = new ArrayList<>();
        int size = this.mainArrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            PresenterItem presenterItem = this.mainArrayList.get(i2);
            String pagePartId = getPagePartId(presenterItem);
            if (pagePartId == null || !pagePartId.equals(str)) {
                if (i >= 0) {
                    break;
                }
            } else {
                if (i < 0) {
                    i = i2;
                }
                arrayList.add(presenterItem);
            }
        }
        if (arrayList.size() > 0) {
            this.mainArrayList.removeAll(arrayList);
            this.mainAdapter.notifyItemRangeRemoved(i, arrayList.size());
        }
        return arrayList;
    }

    private String getPagePartId(PresenterItem presenterItem) {
        if (presenterItem instanceof ViewDataObject) {
            DynamicPageObjectDataInfo dynamicPageObjectDataInfo = this.dataInfoMap.get(((ViewDataObject) presenterItem).object_data_id);
            if (dynamicPageObjectDataInfo != null) {
                return dynamicPageObjectDataInfo.partId;
            }
            return null;
        }
        if (presenterItem instanceof ViewDataObjectArray) {
            return ((ViewDataObjectArray) presenterItem).pagePartId;
        }
        if (presenterItem instanceof RecyclerViewListObject) {
            return ((RecyclerViewListObject) presenterItem).pagePartId;
        }
        if (presenterItem instanceof TitleObject) {
            return ((TitleObject) presenterItem).pagePartId;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doCommandAddPagePart(ir.resaneh1.iptv.model.AddPagePartData r6, java.lang.String r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            ir.resaneh1.iptv.model.DynamicPagePartDataObject r0 = r6.page_part_data
            if (r0 != 0) goto L8
            return
        L8:
            java.lang.String r0 = r0.page_part_data_id
            boolean r0 = r5.isExistPagePart(r0)
            if (r0 == 0) goto L11
            return
        L11:
            ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum r0 = r6.location_type
            ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum r1 = ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum.First
            r2 = 0
            r3 = -1
            if (r0 != r1) goto L1c
            r7 = 0
            goto La8
        L1c:
            ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum r1 = ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum.Last
            if (r0 != r1) goto L31
            java.util.ArrayList<ir.resaneh1.iptv.presenter.abstracts.PresenterItem> r7 = r5.mainArrayList
            int r2 = r7.size()
            java.util.ArrayList<ir.resaneh1.iptv.model.DynamicPagePartDataObject> r7 = r5.pagePartDataArrayFromServer
            int r7 = r7.size()
        L2c:
            r4 = r2
            r2 = r7
            r7 = r4
            goto La8
        L31:
            ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum r1 = ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum.CustomPrev
            java.lang.String r2 = ""
            if (r0 != r1) goto L65
            java.lang.String r0 = r6.custom_page_part_data_id
            if (r0 == 0) goto L4e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L4e
            java.lang.String r7 = r6.custom_page_part_data_id
            int r2 = r5.findPagePartStartedPositionInMainArray(r7)
            java.lang.String r7 = r6.custom_page_part_data_id
            int r7 = r5.findPagePartPositionInServerArray(r7)
            goto L2c
        L4e:
            if (r7 == 0) goto La6
            java.util.Map<java.lang.String, ir.resaneh1.iptv.model.DynamicPageObjectDataInfo> r0 = r5.dataInfoMap
            java.lang.Object r7 = r0.get(r7)
            ir.resaneh1.iptv.model.DynamicPageObjectDataInfo r7 = (ir.resaneh1.iptv.model.DynamicPageObjectDataInfo) r7
            if (r7 == 0) goto L5c
            java.lang.String r2 = r7.partId
        L5c:
            int r7 = r5.findPagePartStartedPositionInMainArray(r2)
            int r2 = r5.findPagePartPositionInServerArray(r2)
            goto La8
        L65:
            ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum r1 = ir.resaneh1.iptv.enums.DynamicPageLocationTypeEnum.CustomNext
            if (r0 != r1) goto La6
            java.lang.String r0 = r6.custom_page_part_data_id
            if (r0 == 0) goto L81
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L81
            java.lang.String r7 = r6.custom_page_part_data_id
            int r7 = r5.findPagePartEndedPositionInMainArray(r7)
            java.lang.String r0 = r6.custom_page_part_data_id
            int r0 = r5.findPagePartPositionInServerArray(r0)
        L7f:
            r2 = r7
            goto L9a
        L81:
            if (r7 == 0) goto L98
            java.util.Map<java.lang.String, ir.resaneh1.iptv.model.DynamicPageObjectDataInfo> r0 = r5.dataInfoMap
            java.lang.Object r7 = r0.get(r7)
            ir.resaneh1.iptv.model.DynamicPageObjectDataInfo r7 = (ir.resaneh1.iptv.model.DynamicPageObjectDataInfo) r7
            if (r7 == 0) goto L8f
            java.lang.String r2 = r7.partId
        L8f:
            int r7 = r5.findPagePartEndedPositionInMainArray(r2)
            int r0 = r5.findPagePartPositionInServerArray(r2)
            goto L7f
        L98:
            r0 = -1
            r2 = -1
        L9a:
            if (r2 < 0) goto La3
            if (r0 < 0) goto La3
            int r2 = r2 + 1
            int r7 = r0 + 1
            goto L2c
        La3:
            r7 = r2
            r2 = r0
            goto La8
        La6:
            r7 = -1
            r2 = -1
        La8:
            if (r2 < 0) goto Lb9
            java.util.ArrayList<ir.resaneh1.iptv.model.DynamicPagePartDataObject> r0 = r5.pagePartDataArrayFromServer
            int r0 = r0.size()
            if (r2 > r0) goto Lb9
            java.util.ArrayList<ir.resaneh1.iptv.model.DynamicPagePartDataObject> r0 = r5.pagePartDataArrayFromServer
            ir.resaneh1.iptv.model.DynamicPagePartDataObject r1 = r6.page_part_data
            r0.add(r2, r1)
        Lb9:
            if (r7 < 0) goto Lcd
            java.util.ArrayList<ir.resaneh1.iptv.presenter.abstracts.PresenterItem> r0 = r5.mainArrayList
            int r0 = r0.size()
            if (r7 > r0) goto Lcd
            ir.resaneh1.iptv.model.DynamicPagePartDataObject r6 = r6.page_part_data
            r5.addPagePartToMainArray(r6, r7)
            androidx.recyclerview.widget.RecyclerView r6 = r5.mainRecyclerView     // Catch: java.lang.Exception -> Lcd
            r6.scrollToPosition(r7)     // Catch: java.lang.Exception -> Lcd
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.DynamicPageFragment.doCommandAddPagePart(ir.resaneh1.iptv.model.AddPagePartData, java.lang.String):void");
    }

    private void addPagePartToMainArray(DynamicPagePartDataObject dynamicPagePartDataObject, int i) {
        ArrayList<DynamicPagePartDataObject> arrayList = new ArrayList<>();
        if (i < 0 || i > this.mainArrayList.size()) {
            return;
        }
        arrayList.add(dynamicPagePartDataObject);
        ArrayList<PresenterItem> arrayListMakeListToShow = makeListToShow(arrayList);
        this.mainArrayList.addAll(i, arrayListMakeListToShow);
        this.mainAdapter.notifyItemRangeInserted(i, arrayListMakeListToShow.size());
    }

    private int findPagePartStartedPositionInMainArray(String str) {
        ArrayList<PresenterItem> arrayList = this.mainArrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.mainArrayList.size(); i++) {
            if (getPagePartId(this.mainArrayList.get(i)) != null && getPagePartId(this.mainArrayList.get(i)).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private int findPagePartEndedPositionInMainArray(String str) {
        ArrayList<PresenterItem> arrayList = this.mainArrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        for (int size = this.mainArrayList.size() - 1; size > 0; size--) {
            String pagePartId = getPagePartId(this.mainArrayList.get(size));
            if (pagePartId != null && pagePartId.equals(str)) {
                return size;
            }
        }
        return -1;
    }

    private int findPagePartPositionInServerArray(String str) {
        ArrayList<DynamicPagePartDataObject> arrayList = this.pagePartDataArrayFromServer;
        if (arrayList == null || arrayList.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < this.pagePartDataArrayFromServer.size(); i++) {
            if (this.pagePartDataArrayFromServer.get(i).page_part_data_id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    private DynamicPagePartDataObject findPagePartInServerArray(String str) {
        ArrayList<DynamicPagePartDataObject> arrayList;
        if (str == null || (arrayList = this.pagePartDataArrayFromServer) == null || arrayList.size() <= 0) {
            return null;
        }
        Iterator<DynamicPagePartDataObject> it = this.pagePartDataArrayFromServer.iterator();
        while (it.hasNext()) {
            DynamicPagePartDataObject next = it.next();
            String str2 = next.page_part_data_id;
            if (str2 != null && str2.equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromPagePartServerArray(String str) {
        DynamicPagePartDataObject dynamicPagePartDataObjectFindPagePartInServerArray;
        if (str == null || (dynamicPagePartDataObjectFindPagePartInServerArray = findPagePartInServerArray(str)) == null) {
            return;
        }
        this.pagePartDataArrayFromServer.remove(dynamicPagePartDataObjectFindPagePartInServerArray);
    }

    private boolean isExistPagePart(String str) {
        return (str == null || findPagePartInServerArray(str) == null) ? false : true;
    }

    public void handleObjectAttrClick(ViewObjectAttr viewObjectAttr, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        if (viewObjectAttr.click_type == ViewObjectAttr.ClickTypeEnum.None) {
            return;
        }
        if (viewObjectAttr.disable_in_progress && viewObjectAttr.isInProgress) {
            return;
        }
        ArrayList<DynamicPageCommandObject> arrayList = viewObjectAttr.local_click_commands;
        if (arrayList != null) {
            doCommands(arrayList, viewDataObject, loadingObject);
            if (viewObjectAttr.click_type == ViewObjectAttr.ClickTypeEnum.LocalClick) {
                viewObjectAttr.isInProgress = false;
            }
        }
        ViewObjectAttr.ClickTypeEnum clickTypeEnum = viewObjectAttr.click_type;
        if (clickTypeEnum == ViewObjectAttr.ClickTypeEnum.ApiClick || clickTypeEnum == ViewObjectAttr.ClickTypeEnum.Menu) {
            callDynamicClick(viewObjectAttr, viewDataObject, loadingObject);
        } else if (clickTypeEnum == ViewObjectAttr.ClickTypeEnum.Button) {
            handleButtonClick(viewObjectAttr, viewDataObject, loadingObject);
        }
    }

    public void handleMenuClick(ViewObjectAttr viewObjectAttr, String str, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        viewObjectAttr.track_id = str;
        handleObjectAttrClick(viewObjectAttr, viewDataObject, loadingObject);
    }

    private void handleButtonClick(final ViewObjectAttr viewObjectAttr, final ViewDataObject viewDataObject, final ViewGroupCellPresenter.LoadingObject loadingObject) {
        DynamicPageButtonObject dynamicPageButtonObject = viewObjectAttr.button;
        if (dynamicPageButtonObject == null) {
            return;
        }
        if (dynamicPageButtonObject.file_upload_properties == null) {
            dynamicPageButtonObject.file_upload_properties = new FileUploadProperties();
        }
        DynamicPageButtonObject dynamicPageButtonObject2 = viewObjectAttr.button;
        dynamicPageButtonObject2.file_upload_properties.requestSendFileUrl = this.getDataUrl;
        BotButtonHandler.handleButtonClick(this, 0L, dynamicPageButtonObject2, viewObjectAttr, new BotButtonHandler.Delegate() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.12
            boolean isDoneCalled = false;

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void notSupported() {
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void done(String str, ArrayList<String> arrayList) {
                ViewObjectAttr viewObjectAttr2;
                DynamicPageButtonObject dynamicPageButtonObject3;
                if (this.isDoneCalled) {
                    return;
                }
                this.isDoneCalled = true;
                SetButtonResultInput setButtonResultInput = new SetButtonResultInput(viewObjectAttr.track_id);
                setButtonResultInput.values = str;
                if (arrayList != null && arrayList.size() > 0) {
                    setButtonResultInput.list_value = arrayList;
                }
                if (str != null && (viewObjectAttr2 = viewObjectAttr) != null && (dynamicPageButtonObject3 = viewObjectAttr2.button) != null && dynamicPageButtonObject3.set_item_name != null) {
                    ViewDataObject viewDataObject2 = null;
                    if (dynamicPageButtonObject3.set_object_data_id != null) {
                        DynamicPageObjectDataInfo dynamicPageObjectDataInfoTryToGetInfoFromTags = (DynamicPageObjectDataInfo) DynamicPageFragment.this.dataInfoMap.get(viewObjectAttr.button.set_object_data_id);
                        if (dynamicPageObjectDataInfoTryToGetInfoFromTags == null) {
                            dynamicPageObjectDataInfoTryToGetInfoFromTags = DynamicPageFragment.this.tryToGetInfoFromTags(viewObjectAttr.button.set_object_data_id);
                        }
                        if (dynamicPageObjectDataInfoTryToGetInfoFromTags != null) {
                            viewDataObject2 = dynamicPageObjectDataInfoTryToGetInfoFromTags.dataObject;
                        }
                    } else {
                        viewDataObject2 = viewDataObject;
                    }
                    if (viewDataObject2 != null) {
                        if (viewDataObject2.texts == null) {
                            viewDataObject2.texts = new HashMap();
                        }
                        viewDataObject2.texts.put(viewObjectAttr.button.set_item_name, str);
                        DynamicPageButtonObject dynamicPageButtonObject4 = viewObjectAttr.button;
                        if (dynamicPageButtonObject4.save_default_value) {
                            try {
                                MiniFunctionModels.ButtonType buttonType = dynamicPageButtonObject4.type;
                                if (buttonType == MiniFunctionModels.ButtonType.NumberPicker) {
                                    dynamicPageButtonObject4.button_number_picker.default_value = Integer.valueOf(Integer.parseInt(str));
                                } else if (buttonType == MiniFunctionModels.ButtonType.StringPicker) {
                                    dynamicPageButtonObject4.button_string_picker.default_value = str;
                                } else if (buttonType == MiniFunctionModels.ButtonType.Calendar) {
                                    dynamicPageButtonObject4.button_calendar.default_value = str;
                                } else if (buttonType != MiniFunctionModels.ButtonType.Selection && buttonType == MiniFunctionModels.ButtonType.Textbox) {
                                    dynamicPageButtonObject4.button_textbox.default_value = str;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        DynamicPageFragment.this.updateVisibleRows();
                    }
                }
                DynamicPageFragment.this.callSetButtonResult(setButtonResultInput, viewObjectAttr, viewDataObject, loadingObject);
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void onLocationSelected(TLRPC$MessageMedia tLRPC$MessageMedia) {
                DynamicPageButtonObject dynamicPageButtonObject3;
                if (this.isDoneCalled) {
                    return;
                }
                this.isDoneCalled = true;
                LocationObject locationObjectConvertMediaToLocationObject = MessageConverter.convertMediaToLocationObject(tLRPC$MessageMedia);
                SetButtonResultInput setButtonResultInput = new SetButtonResultInput(viewObjectAttr.track_id);
                ir.resaneh1.iptv.model.LocationObject locationObject = new ir.resaneh1.iptv.model.LocationObject();
                locationObject.latitude = locationObjectConvertMediaToLocationObject.latitude;
                locationObject.longitude = locationObjectConvertMediaToLocationObject.longitude;
                setButtonResultInput.location = locationObject;
                ViewObjectAttr viewObjectAttr2 = viewObjectAttr;
                if (viewObjectAttr2 != null && (dynamicPageButtonObject3 = viewObjectAttr2.button) != null && dynamicPageButtonObject3.save_default_value) {
                    try {
                        if (dynamicPageButtonObject3.type == MiniFunctionModels.ButtonType.LocationPicker) {
                            dynamicPageButtonObject3.button_location.default_pointer_location = locationObjectConvertMediaToLocationObject;
                        }
                    } catch (Exception unused) {
                    }
                }
                DynamicPageFragment.this.callSetButtonResult(setButtonResultInput, viewObjectAttr, viewDataObject, loadingObject);
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void uploadFileDone(String str, String str2) {
                if (this.isDoneCalled) {
                    return;
                }
                this.isDoneCalled = true;
                SetButtonResultInput setButtonResultInput = new SetButtonResultInput(viewObjectAttr.track_id);
                setButtonResultInput.file = new ButtonFileObject(str, str2);
                if (ApplicationLoader.applicationActivity.getLastFragment() instanceof PhotoPickerActivity) {
                    ApplicationLoader.applicationActivity.getLastFragment().finishFragment();
                }
                DynamicPageFragment.this.callSetButtonResult(setButtonResultInput, viewObjectAttr, viewDataObject, loadingObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSetButtonResult(SetButtonResultInput setButtonResultInput, ViewObjectAttr viewObjectAttr, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        String str;
        if (setButtonResultInput == null || (str = setButtonResultInput.track_id) == null) {
            return;
        }
        RequestDataDynamicPage requestDataDynamicPage = new RequestDataDynamicPage(str);
        requestDataDynamicPage.setForButton(setButtonResultInput);
        handleSendData(requestDataDynamicPage, viewObjectAttr, null, viewDataObject, loadingObject);
    }

    private void callDynamicClick(ViewObjectAttr viewObjectAttr, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        String str;
        if (viewObjectAttr == null || (str = viewObjectAttr.track_id) == null) {
            return;
        }
        RequestDataDynamicPage requestDataDynamicPage = new RequestDataDynamicPage(str);
        requestDataDynamicPage.setForClick();
        handleSendData(requestDataDynamicPage, viewObjectAttr, null, viewDataObject, loadingObject);
    }

    public void doCommands(ArrayList<DynamicPageCommandObject> arrayList, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        Iterator<DynamicPageCommandObject> it = arrayList.iterator();
        while (it.hasNext()) {
            doOrPutInQueueCommand(new CommandInfoObject(it.next(), viewDataObject, loadingObject));
        }
    }

    public void doOrPutInQueueCommand(CommandInfoObject commandInfoObject) {
        if (commandInfoObject == null) {
            return;
        }
        int i = this.currentCommandInProgressCount;
        if (i < 1) {
            this.currentCommandInProgressCount = i + 1;
            doCommand(commandInfoObject.commandObject, commandInfoObject.clickedDataObject, commandInfoObject.loadingObject);
        } else {
            this.commandQueue.add(commandInfoObject);
        }
    }

    public void doCommand(final DynamicPageCommandObject dynamicPageCommandObject, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        GoLinkData goLinkData;
        DynamicPageCommandObject.TypeEnum typeEnum = dynamicPageCommandObject.type;
        if (typeEnum != null) {
            if (typeEnum == DynamicPageCommandObject.TypeEnum.ApiClick) {
                ApiClickData apiClickData = dynamicPageCommandObject.api_click_data;
                if (apiClickData != null) {
                    doCommandApiClick(apiClickData);
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.RemovePagePartData) {
                RemovePagePartData removePagePartData = dynamicPageCommandObject.remove_page_part_data;
                if (removePagePartData != null) {
                    doCommandRemovePagePart(removePagePartData);
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.AddPagePartData) {
                AddPagePartData addPagePartData = dynamicPageCommandObject.add_page_part_data;
                if (addPagePartData != null) {
                    if (viewDataObject != null) {
                        doCommandAddPagePart(addPagePartData, viewDataObject.object_data_id);
                    } else {
                        doCommandAddPagePart(addPagePartData, null);
                    }
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.EditObjectData) {
                EditObjectData editObjectData = dynamicPageCommandObject.edit_object_data;
                if (editObjectData != null) {
                    doCommandEditObject(editObjectData);
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.RemoveObjectData) {
                RemoveObjectData removeObjectData = dynamicPageCommandObject.remove_object_data;
                if (removeObjectData != null) {
                    doCommandRemoveObject(removeObjectData.object_data_id);
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.AddObjectData) {
                AddObjectData addObjectData = dynamicPageCommandObject.add_object_data;
                if (addObjectData != null) {
                    doCommandAddObject(addObjectData, viewDataObject);
                }
            } else if (typeEnum == DynamicPageCommandObject.TypeEnum.GoLink && (goLinkData = dynamicPageCommandObject.go_link_data) != null && goLinkData.link != null) {
                if (goLinkData.delay > 0) {
                    if (ApplicationLoader.applicationActivity != null && ApplicationLoader.applicationActivity.mainCompositeDisposable != null) {
                        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) Observable.timer(dynamicPageCommandObject.go_link_data.delay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.13
                            @Override // io.reactivex.Observer
                            public void onNext(Long l) {
                                MyLog.e("DynamicPageFragment", "go link delay");
                                new MainClickHandler().onLinkClick(DynamicPageFragment.this.baseFragment, dynamicPageCommandObject.go_link_data.link);
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                                MyLog.e("DynamicPageFragment", "error ");
                            }

                            @Override // io.reactivex.Observer
                            public void onComplete() {
                                MyLog.e("DynamicPageFragment", "onComplete ");
                            }
                        }));
                    }
                } else {
                    MyLog.e("DynamicPageFragment", "go link ");
                    new MainClickHandler().onLinkClick(this.baseFragment, dynamicPageCommandObject.go_link_data.link);
                }
            }
        }
        if (loadingObject != null) {
            loadingObject.hideLoading();
        }
        this.currentCommandInProgressCount--;
        doCommandFromQueue();
    }

    private void doCommandApiClick(ApiClickData apiClickData) {
        String str = apiClickData.track_id;
        if (str == null) {
            return;
        }
        RequestDataDynamicPage requestDataDynamicPage = new RequestDataDynamicPage(str);
        requestDataDynamicPage.setForClick();
        handleSendData(requestDataDynamicPage, null, apiClickData.type_api_call, null, null);
    }

    private void doCommandEditObject(EditObjectData editObjectData) {
        DynamicPageObjectDataInfo dynamicPageObjectDataInfoTryToGetInfoFromTags = this.dataInfoMap.get(editObjectData.object_data_id);
        if (dynamicPageObjectDataInfoTryToGetInfoFromTags == null) {
            dynamicPageObjectDataInfoTryToGetInfoFromTags = tryToGetInfoFromTags(editObjectData.object_data_id);
        }
        if (dynamicPageObjectDataInfoTryToGetInfoFromTags != null) {
            dynamicPageObjectDataInfoTryToGetInfoFromTags.dataObject.editByNewDataObject(editObjectData.object_data);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(editObjectData.object_data_id);
            updateVisibleRows(arrayList);
        }
    }

    public void doCommandFromQueue() {
        CommandInfoObject commandInfoObjectPoll;
        if (this.currentCommandInProgressCount >= 1 || (commandInfoObjectPoll = this.commandQueue.poll()) == null) {
            return;
        }
        doOrPutInQueueCommand(commandInfoObjectPoll);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void doCommandAddObject(ir.resaneh1.iptv.model.AddObjectData r10, ir.resaneh1.iptv.model.ViewDataObject r11) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.DynamicPageFragment.doCommandAddObject(ir.resaneh1.iptv.model.AddObjectData, ir.resaneh1.iptv.model.ViewDataObject):void");
    }

    private int getIndexInItemPresenterListById(ArrayList<PresenterItem> arrayList, String str) {
        if (arrayList == null || arrayList.size() <= 0 || str == null) {
            return -1;
        }
        Iterator<PresenterItem> it = arrayList.iterator();
        while (it.hasNext()) {
            PresenterItem next = it.next();
            if ((next instanceof ViewDataObject) && str.equals(((ViewDataObject) next).object_data_id)) {
                return arrayList.indexOf(next);
            }
        }
        return -1;
    }

    private void doCommandRemoveObject(String str) {
        DynamicPagePartDataObject dynamicPagePartDataObjectFindPagePartInServerArray;
        ArrayList<PresenterItem> arrayList;
        int indexInItemPresenterListById;
        DynamicListPagePartDataObject dynamicListPagePartDataObject;
        ArrayList<ViewDataObject> arrayList2;
        if (str == null) {
            return;
        }
        DynamicPageObjectDataInfo dynamicPageObjectDataInfoTryToGetInfoFromTags = this.dataInfoMap.get(str);
        if (dynamicPageObjectDataInfoTryToGetInfoFromTags == null) {
            dynamicPageObjectDataInfoTryToGetInfoFromTags = tryToGetInfoFromTags(str);
        }
        if (dynamicPageObjectDataInfoTryToGetInfoFromTags == null || dynamicPageObjectDataInfoTryToGetInfoFromTags.dataObject == null || (dynamicPagePartDataObjectFindPagePartInServerArray = findPagePartInServerArray(dynamicPageObjectDataInfoTryToGetInfoFromTags.partId)) == null) {
            return;
        }
        DynamicPagePartDataObject.ObjectTypeEnum objectTypeEnum = dynamicPagePartDataObjectFindPagePartInServerArray.object_type;
        if (objectTypeEnum == DynamicPagePartDataObject.ObjectTypeEnum.List && (dynamicListPagePartDataObject = dynamicPagePartDataObjectFindPagePartInServerArray.list_page_part_data) != null && (arrayList2 = dynamicListPagePartDataObject.object_data_list) != null) {
            Iterator<ViewDataObject> it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ViewDataObject next = it.next();
                String str2 = next.object_data_id;
                if (str2 != null && str2.equals(str)) {
                    dynamicPagePartDataObjectFindPagePartInServerArray.list_page_part_data.object_data_list.remove(next);
                    break;
                }
            }
            this.dataInfoMap.remove(str);
            ViewTagObject.TypeEnum typeEnum = dynamicPagePartDataObjectFindPagePartInServerArray.show_type;
            if (typeEnum == ViewTagObject.TypeEnum.List) {
                int iIndexOf = this.mainArrayList.indexOf(dynamicPageObjectDataInfoTryToGetInfoFromTags.dataObject);
                MyLog.e("DynamicPageFragment", "index" + iIndexOf);
                if (iIndexOf >= 0) {
                    MyLog.e("DynamicPageFragment", "removed");
                    this.mainArrayList.remove(iIndexOf);
                    this.mainAdapter.notifyItemRemoved(iIndexOf);
                    return;
                }
                return;
            }
            if (typeEnum == ViewTagObject.TypeEnum.Grid) {
                int iFindPagePartStartedPositionInMainArray = findPagePartStartedPositionInMainArray(dynamicPageObjectDataInfoTryToGetInfoFromTags.partId);
                findAndRemoveDataOfPagePartInMainArray(dynamicPageObjectDataInfoTryToGetInfoFromTags.partId);
                addPagePartToMainArray(dynamicPagePartDataObjectFindPagePartInServerArray, iFindPagePartStartedPositionInMainArray);
                return;
            }
            return;
        }
        if (objectTypeEnum == DynamicPagePartDataObject.ObjectTypeEnum.Tag) {
            PresenterItem presenterItem = this.mainArrayList.get(findPagePartStartedPositionInMainArray(dynamicPagePartDataObjectFindPagePartInServerArray.page_part_data_id));
            if (presenterItem == null || !(presenterItem instanceof RecyclerViewListObject) || (indexInItemPresenterListById = getIndexInItemPresenterListById((arrayList = ((RecyclerViewListObject) presenterItem).list), str)) < 0 || indexInItemPresenterListById >= arrayList.size()) {
                return;
            }
            arrayList.remove(indexInItemPresenterListById);
            updateVisibleRows();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DynamicPageObjectDataInfo tryToGetInfoFromTags(String str) {
        ArrayList<PresenterItem> arrayList;
        int indexInItemPresenterListById;
        Iterator<PresenterItem> it = this.mainArrayList.iterator();
        while (it.hasNext()) {
            PresenterItem next = it.next();
            if ((next instanceof RecyclerViewListObject) && (arrayList = ((RecyclerViewListObject) next).list) != null && (indexInItemPresenterListById = getIndexInItemPresenterListById(arrayList, str)) >= 0) {
                try {
                    String str2 = ((RecyclerViewListObject) next).pagePartId;
                    ViewDataObject viewDataObject = (ViewDataObject) ((RecyclerViewListObject) next).list.get(indexInItemPresenterListById);
                    if (str2 != null && viewDataObject != null) {
                        return new DynamicPageObjectDataInfo(viewDataObject, str2);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVisibleRows() {
        updateVisibleRows(null);
    }

    private void updateVisibleRows(final ArrayList<String> arrayList) {
        RecyclerView recyclerView = this.mainRecyclerView;
        if (recyclerView == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final AbstractPresenter.AbstractViewHolder abstractViewHolder = null;
            try {
                abstractViewHolder = (AbstractPresenter.AbstractViewHolder) this.mainRecyclerView.getChildAt(i).getTag();
            } catch (Exception unused) {
            }
            if (abstractViewHolder != null) {
                final boolean[] zArr = {false};
                ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1).observeOn(Schedulers.computation()).doOnNext(new Consumer<Integer>(this) { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.15
                    @Override // io.reactivex.functions.Consumer
                    public void accept(Integer num) throws Exception {
                        AbstractPresenter.AbstractViewHolder abstractViewHolder2;
                        Titem titem;
                        ArrayList arrayList2 = arrayList;
                        if (arrayList2 == null || (titem = (abstractViewHolder2 = abstractViewHolder).item) == 0) {
                            return;
                        }
                        if (abstractViewHolder2 instanceof ViewGroupCellPresenter.MyViewHolder) {
                            zArr[0] = arrayList2.contains(titem.getId());
                            return;
                        }
                        if (abstractViewHolder2 instanceof ArrayViewGroupPresenter.MyViewHolder) {
                            Iterator<ViewDataObject> it = ((ViewDataObjectArray) titem).arrayList.iterator();
                            while (it.hasNext()) {
                                if (arrayList.contains(it.next().object_data_id)) {
                                    zArr[0] = true;
                                    return;
                                }
                            }
                            return;
                        }
                        if (abstractViewHolder2 instanceof RecyclerViewListPresenter.MyViewHolder) {
                            Iterator<PresenterItem> it2 = ((RecyclerViewListObject) titem).list.iterator();
                            while (it2.hasNext()) {
                                if (arrayList.contains(it2.next().getId())) {
                                    zArr[0] = true;
                                    return;
                                }
                            }
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.14
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Integer num) {
                        AbstractPresenter presenter;
                        Titem titem = abstractViewHolder.item;
                        if (titem != 0) {
                            if ((arrayList == null || zArr[0]) && (presenter = DynamicPageFragment.this.mainAdapter.getPresenter(titem.getPresenterItemTypeInt())) != null) {
                                if (presenter instanceof ViewGroupCellPresenter) {
                                    AbstractPresenter.AbstractViewHolder abstractViewHolder2 = abstractViewHolder;
                                    presenter.onBindViewHolder(abstractViewHolder2, abstractViewHolder2.item);
                                } else if (presenter instanceof ArrayViewGroupPresenter) {
                                    AbstractPresenter.AbstractViewHolder abstractViewHolder3 = abstractViewHolder;
                                    presenter.onBindViewHolder(abstractViewHolder3, abstractViewHolder3.item);
                                } else if (presenter instanceof RecyclerViewListPresenter) {
                                    try {
                                        ((RecyclerViewListPresenter) presenter).handleChangeItem((RecyclerViewListPresenter.MyViewHolder) abstractViewHolder);
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        }
                    }
                }));
            }
        }
    }

    public void handleSendData(RequestDataDynamicPage requestDataDynamicPage, ViewObjectAttr viewObjectAttr, ViewObjectAttr.ApiCallTypeEnum apiCallTypeEnum, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        if (requestDataDynamicPage == null) {
            return;
        }
        if (apiCallTypeEnum == null && viewObjectAttr != null) {
            apiCallTypeEnum = viewObjectAttr.type_api_call;
        }
        if (apiCallTypeEnum == null || apiCallTypeEnum == ViewObjectAttr.ApiCallTypeEnum.NowAlone) {
            ArrayList<RequestDataDynamicPage> arrayList = new ArrayList<>();
            arrayList.add(requestDataDynamicPage);
            callSendData(arrayList, viewObjectAttr, viewDataObject, loadingObject);
            return;
        }
        if (apiCallTypeEnum == ViewObjectAttr.ApiCallTypeEnum.Later) {
            requestDataDynamicPage.time = System.currentTimeMillis();
            this.dataToSendArray.add(requestDataDynamicPage);
            return;
        }
        if (apiCallTypeEnum == ViewObjectAttr.ApiCallTypeEnum.AllQueue) {
            requestDataDynamicPage.time = System.currentTimeMillis();
            this.dataToSendArray.add(requestDataDynamicPage);
            ArrayList<RequestDataDynamicPage> arrayList2 = new ArrayList<>();
            HashSet hashSet = new HashSet();
            for (int size = this.dataToSendArray.size() - 1; size >= 0; size--) {
                RequestDataDynamicPage requestDataDynamicPage2 = this.dataToSendArray.get(size);
                if (!hashSet.contains(requestDataDynamicPage2.getKey())) {
                    arrayList2.add(0, requestDataDynamicPage2);
                    hashSet.add(requestDataDynamicPage2.getKey());
                }
            }
            this.dataToSendArray.clear();
            callSendData(arrayList2, viewObjectAttr, viewDataObject, loadingObject);
        }
    }

    private void callSendData(final ArrayList<RequestDataDynamicPage> arrayList, final ViewObjectAttr viewObjectAttr, final ViewDataObject viewDataObject, final ViewGroupCellPresenter.LoadingObject loadingObject) {
        if (this.getDataUrl == null) {
            return;
        }
        if (loadingObject != null) {
            loadingObject.showLoading();
        }
        if (viewObjectAttr != null && viewDataObject != null && viewDataObject.progressViewDisposableMap.get(viewObjectAttr.itemName) != null) {
            viewDataObject.progressViewDisposableMap.get(viewObjectAttr.itemName).onNext(Boolean.TRUE);
        }
        if (viewDataObject != null) {
            viewObjectAttr.isInProgress = true;
        }
        ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().sendDataDynamicPage(this.getDataUrl, new SendDataDynamicPageInput(arrayList), null).subscribeWith(new DisposableObserver<MessangerOutput<SendDataDynamicPageOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.16
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<SendDataDynamicPageOutput> messangerOutput) {
                ViewDataObject viewDataObject2;
                SendDataDynamicPageOutput sendDataDynamicPageOutput;
                ArrayList<DynamicPageCommandObject> arrayList2;
                ViewObjectAttr viewObjectAttr2 = viewObjectAttr;
                if (viewObjectAttr2 != null) {
                    viewObjectAttr2.isInProgress = false;
                }
                if (messangerOutput != null && (sendDataDynamicPageOutput = messangerOutput.data) != null && (arrayList2 = sendDataDynamicPageOutput.commands) != null) {
                    DynamicPageFragment.this.doCommands(arrayList2, viewDataObject, loadingObject);
                }
                ViewGroupCellPresenter.LoadingObject loadingObject2 = loadingObject;
                if (loadingObject2 != null) {
                    loadingObject2.hideLoading();
                }
                ViewObjectAttr viewObjectAttr3 = viewObjectAttr;
                if (viewObjectAttr3 == null || (viewDataObject2 = viewDataObject) == null || viewDataObject2.progressViewDisposableMap.get(viewObjectAttr3.itemName) == null) {
                    return;
                }
                viewDataObject.progressViewDisposableMap.get(viewObjectAttr.itemName).onNext(Boolean.FALSE);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ViewDataObject viewDataObject2;
                ViewObjectAttr viewObjectAttr2 = viewObjectAttr;
                if (viewObjectAttr2 != null) {
                    viewObjectAttr2.isInProgress = false;
                }
                ViewGroupCellPresenter.LoadingObject loadingObject2 = loadingObject;
                if (loadingObject2 != null) {
                    loadingObject2.hideLoading();
                }
                ViewObjectAttr viewObjectAttr3 = viewObjectAttr;
                if (viewObjectAttr3 != null && (viewDataObject2 = viewDataObject) != null && viewDataObject2.progressViewDisposableMap.get(viewObjectAttr3.itemName) != null) {
                    viewDataObject.progressViewDisposableMap.get(viewObjectAttr.itemName).onNext(Boolean.FALSE);
                }
                DynamicPageFragment.this.dataToSendArray.addAll(arrayList);
                Collections.sort(DynamicPageFragment.this.dataToSendArray, new Comparator<RequestDataDynamicPage>(this) { // from class: ir.resaneh1.iptv.fragment.DynamicPageFragment.16.1
                    @Override // java.util.Comparator
                    public int compare(RequestDataDynamicPage requestDataDynamicPage, RequestDataDynamicPage requestDataDynamicPage2) {
                        long j = requestDataDynamicPage.time;
                        long j2 = requestDataDynamicPage2.time;
                        if (j < j2) {
                            return -1;
                        }
                        return j > j2 ? 1 : 0;
                    }
                });
            }
        }));
    }

    private void setShortcutView(ArrayList<ShortcutObject> arrayList) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayoutBottom);
        int screenMinDimension = DimensionHelper.getScreenMinDimension((Activity) this.mContext);
        ShortcutPresenter shortcutPresenter = new ShortcutPresenter(this.mContext);
        frameLayout.removeAllViews();
        if (arrayList.size() * AndroidUtilities.dp(72.0f) < screenMinDimension) {
            UILinearLayout uILinearLayout = new UILinearLayout();
            uILinearLayout.createView((Activity) this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
            uILinearLayout.linearLayout.removeAllViews();
            uILinearLayout.linearLayout.setOrientation(0);
            if (Build.VERSION.SDK_INT >= 17) {
                uILinearLayout.linearLayout.setLayoutDirection(1);
            }
            uILinearLayout.linearLayout.getLayoutParams().width = screenMinDimension;
            Iterator<ShortcutObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ShortcutPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = shortcutPresenter.createViewHolderAndBind(it.next());
                myViewHolderCreateViewHolderAndBind.itemView.setLayoutParams(layoutParams);
                uILinearLayout.linearLayout.addView(myViewHolderCreateViewHolderAndBind.itemView);
            }
            frameLayout.addView(uILinearLayout.view);
        } else {
            UILinearLayoutScrollable uILinearLayoutScrollable = new UILinearLayoutScrollable();
            uILinearLayoutScrollable.createView((Activity) this.mContext, true);
            Iterator<ShortcutObject> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                uILinearLayoutScrollable.linearLayout.addView(shortcutPresenter.createViewHolderAndBind(it2.next()).itemView);
            }
            frameLayout.addView(uILinearLayoutScrollable.view);
        }
        frameLayout.setBackground(this.mContext.getResources().getDrawable(R.drawable.gradiant_white_bottom_up));
    }
}
