package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import com.jakewharton.rxbinding2.view.RxView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIView.UILinearLayout;
import ir.resaneh1.iptv.UIView.UILinearLayoutScrollable;
import ir.resaneh1.iptv.apiMessanger.RxHelper;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.EndpointViewObject;
import ir.resaneh1.iptv.model.GetEndpointDataInput;
import ir.resaneh1.iptv.model.GetEndpointDataOutput;
import ir.resaneh1.iptv.model.GetEndpointViewInput;
import ir.resaneh1.iptv.model.GetEndpointViewOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.PageAttrObject;
import ir.resaneh1.iptv.model.RecyclerViewListObject;
import ir.resaneh1.iptv.model.ShortcutObject;
import ir.resaneh1.iptv.model.TitleObject;
import ir.resaneh1.iptv.model.ViewDataObject;
import ir.resaneh1.iptv.model.ViewDataObjectArray;
import ir.resaneh1.iptv.model.ViewGroupObject;
import ir.resaneh1.iptv.model.ViewListObject;
import ir.resaneh1.iptv.model.ViewTagObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelectorSecond;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.ArrayViewGroupPresenter;
import ir.resaneh1.iptv.presenters.EndpointTitlePresenter;
import ir.resaneh1.iptv.presenters.ShortcutPresenter;
import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class DynamicFragment extends PresenterFragment {
    FrameLayout contentFrameLayout;
    private Map<String, ViewDataObject> dataMap;
    private MessangerOutput<GetEndpointDataOutput>[] dataOutputs;
    public String endpointTypeId;
    private ArrayList<EndpointViewObject> endpointViews;
    ImageView imageViewBackground;
    private Map<String, String> keyUrlMap;
    private Map<String, Integer> keyViewIdMap;
    public String objectId;
    private Observable<Object> retryObservable;
    private String title;
    private EndpointTitlePresenter titlePresenter;
    private ArrayList<String> urlArray;
    private HashSet<String> urlSet;
    private Map<Integer, AbstractPresenter> viewMap;
    public boolean isPreview = false;
    public boolean isLastPortrait = true;
    private boolean isGetViews = false;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.dynamic_page_fragment;
    }

    public DynamicFragment(String str, String str2, String str3) {
        this.title = str;
        this.endpointTypeId = str2;
        this.objectId = str3;
        this.fragmentName = "DynamicFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.contentFrameLayout = (FrameLayout) findViewById(R.id.frameLayoutContent);
        this.imageViewBackground = (ImageView) findViewById(R.id.imageViewBackground);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.isNeedLifecycleObservable = true;
        this.swipeBackEnabled = false;
        initWithVerticalLinearLayoutManager();
        setToolbar();
        if (this.isPreview) {
            setPreviewLayout();
        }
        this.progressBar.setVisibility(4);
        this.titlePresenter = new EndpointTitlePresenter(this.mContext);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        PresenterSelectorSecond presenterSelectorSecond = new PresenterSelectorSecond() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelectorSecond
            public AbstractPresenter getPresenter(int i) {
                if (i == PresenterItemType.title.ordinal()) {
                    return DynamicFragment.this.titlePresenter;
                }
                try {
                    return (AbstractPresenter) DynamicFragment.this.viewMap.get(Integer.valueOf(i));
                } catch (Exception unused) {
                    return null;
                }
            }
        };
        Context context = this.mContext;
        MainAdapter mainAdapter = new MainAdapter(context, this.mainArrayList, MainPresenterSelector.getInstance(context), presenterSelectorSecond, null, null);
        this.mainAdapter = mainAdapter;
        mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
        this.retryObservable = RxView.clicks(this.retryButton);
        new RxHelper();
        if (this.endpointTypeId != null) {
            callGetViews();
        }
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
            setSearchView(link, pageAttrObject.toolbar_items_color);
        }
        ArrayList<ShortcutObject> arrayList = pageAttrObject.shortcuts;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        setShortcutView(pageAttrObject.shortcuts);
    }

    public void setToolbarTitleAndIcon(boolean z, boolean z2, String str, ColorObject colorObject) {
        this.toolbarMaker.clearToolbar();
        if (z2) {
            View viewCreateView = this.toolbarMaker.toolbarImageView.createView(ApplicationLoader.applicationActivity, R.drawable.arrow_back_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
            if (colorObject != null) {
                this.toolbarMaker.toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
            }
            viewCreateView.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.2
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

    private void callGetViews() {
        this.progressBar.setVisibility(0);
        this.isGetViews = false;
        ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().getEndPointView(new GetEndpointViewInput(this.endpointTypeId), this.retryObservable).subscribeWith(new DisposableObserver<MessangerOutput<GetEndpointViewOutput>>() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetEndpointViewOutput> messangerOutput) {
                GetEndpointViewOutput getEndpointViewOutput;
                DynamicFragment.this.progressBar.setVisibility(4);
                if (messangerOutput == null || (getEndpointViewOutput = messangerOutput.data) == null) {
                    return;
                }
                GetEndpointViewOutput getEndpointViewOutput2 = getEndpointViewOutput;
                PageAttrObject pageAttrObject = getEndpointViewOutput2.page_attr;
                if (pageAttrObject != null) {
                    DynamicFragment.this.setPageByPageAttr(pageAttrObject);
                } else {
                    Link link = getEndpointViewOutput2.search_link;
                    if (link != null) {
                        DynamicFragment.this.setSearchView(link, null);
                    }
                }
                ArrayList<EndpointViewObject> arrayList = getEndpointViewOutput2.endpoint_views;
                if (arrayList != null) {
                    DynamicFragment.this.endpointViews = arrayList;
                    DynamicFragment.this.isGetViews = true;
                    DynamicFragment.this.makeViews();
                    DynamicFragment.this.callGetData();
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DynamicFragment.this.progressBar.setVisibility(4);
                DynamicFragment.this.showRetryLayout();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchView(final Link link, ColorObject colorObject) {
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        View viewCreateView = toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_search_small_grey, Integer.valueOf(Theme.getColor(Theme.key_actionBarDefaultIcon)));
        if (colorObject != null) {
            toolbarImageView.imageView.setColorFilter(colorObject.getColor(), PorterDuff.Mode.SRC_ATOP);
        }
        viewCreateView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    new MainClickHandler().onLinkClick(DynamicFragment.this.baseFragment, link);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void makeViews() {
        ViewListObject viewListObject;
        if (this.endpointViews == null) {
            return;
        }
        this.viewMap = new HashMap();
        this.keyViewIdMap = new HashMap();
        this.urlSet = new HashSet<>();
        this.keyUrlMap = new HashMap();
        Iterator<EndpointViewObject> it = this.endpointViews.iterator();
        int i = 1;
        while (it.hasNext()) {
            EndpointViewObject next = it.next();
            if (next.type == EndpointViewObject.TypeEnum.ViewList && (viewListObject = next.view_list) != null) {
                String str = viewListObject.api_url;
                if (str != null) {
                    this.urlSet.add(str);
                }
                ViewListObject viewListObject2 = next.view_list;
                if (viewListObject2.keys != null && viewListObject2.view != null) {
                    if (viewListObject2.type == ViewListObject.TypeEnum.List) {
                        ViewGroupCellPresenter viewGroupCellPresenter = new ViewGroupCellPresenter(this.mContext, false, next.view_list.view);
                        viewGroupCellPresenter.isNeedMargin = true;
                        if (viewGroupCellPresenter.isGrid) {
                            setSizeOfCells(next.view_list.view, viewGroupCellPresenter, 1);
                        }
                        this.viewMap.put(Integer.valueOf(ViewDataObject.getPresenterItemTypeByViewId(i)), viewGroupCellPresenter);
                    } else {
                        setCountAndSize(viewListObject2);
                        Context context = this.mContext;
                        ViewListObject viewListObject3 = next.view_list;
                        this.viewMap.put(Integer.valueOf(ViewDataObjectArray.getPresenterItemTypeByViewId(i)), new ArrayViewGroupPresenter(context, viewListObject3.view, viewListObject3.itemCount, viewListObject3.itemWidthPx));
                    }
                    Iterator<String> it2 = next.view_list.keys.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        this.keyViewIdMap.put(next2, Integer.valueOf(i));
                        if (next.getUrl() != null) {
                            this.keyUrlMap.put(next2, next.getUrl());
                        }
                    }
                    i++;
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetData() {
        if (this.objectId == null) {
            return;
        }
        if (this.urlSet.size() == 0) {
            this.dataOutputs = new MessangerOutput[0];
            makeData();
            final ArrayList<PresenterItem> arrayListBindDataToViews = bindDataToViews();
            Observable.timer(3L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.5
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    DynamicFragment.this.mainArrayList.clear();
                    DynamicFragment.this.mainArrayList.addAll(arrayListBindDataToViews);
                    DynamicFragment.this.mainAdapter.notifyDataSetChanged();
                }
            });
            return;
        }
        this.progressBar.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        this.urlArray = new ArrayList<>();
        Iterator<String> it = this.urlSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(getApiRequestMessangerRx().getEndPointData(next, new GetEndpointDataInput(this.objectId)));
            this.urlArray.add(next);
        }
        ((PresenterFragment) this).compositeDisposable.add((Disposable) new RxHelper().zipMultiDataOutput(arrayList).subscribeWith(new AnonymousClass6()));
    }

    /* renamed from: ir.resaneh1.iptv.fragment.DynamicFragment$6, reason: invalid class name */
    class AnonymousClass6 extends DisposableObserver<MessangerOutput<GetEndpointDataOutput>[]> {
        AnonymousClass6() {
        }

        @Override // io.reactivex.Observer
        public void onNext(final MessangerOutput<GetEndpointDataOutput>[] messangerOutputArr) {
            Observable.timer(3L, TimeUnit.MILLISECONDS).subscribe(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.6.1
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    MessangerOutput[] messangerOutputArr2 = messangerOutputArr;
                    if (messangerOutputArr2 != null) {
                        DynamicFragment.this.dataOutputs = messangerOutputArr2;
                        DynamicFragment.this.makeData();
                        final ArrayList arrayListBindDataToViews = DynamicFragment.this.bindDataToViews();
                        Observable.timer(3L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.6.1.1
                            @Override // io.reactivex.Observer
                            public void onComplete() {
                            }

                            @Override // io.reactivex.Observer
                            public void onError(Throwable th) {
                            }

                            @Override // io.reactivex.Observer
                            public void onNext(Long l2) {
                                DynamicFragment.this.progressBar.setVisibility(4);
                                DynamicFragment.this.mainArrayList.clear();
                                DynamicFragment.this.mainArrayList.addAll(arrayListBindDataToViews);
                                DynamicFragment.this.mainAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                }
            });
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DynamicFragment.this.progressBar.setVisibility(4);
            DynamicFragment.this.showRetryLayout();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ((PresenterFragment) DynamicFragment.this).compositeDisposable.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeData() {
        if (this.dataOutputs == null) {
            return;
        }
        this.dataMap = new HashMap();
        int i = 0;
        while (true) {
            MessangerOutput<GetEndpointDataOutput>[] messangerOutputArr = this.dataOutputs;
            if (i >= messangerOutputArr.length) {
                return;
            }
            MessangerOutput<GetEndpointDataOutput> messangerOutput = messangerOutputArr[i];
            String str = i < this.urlArray.size() ? this.urlArray.get(i) : null;
            GetEndpointDataOutput getEndpointDataOutput = messangerOutput.data;
            if (getEndpointDataOutput != null && getEndpointDataOutput.endpoint_data != null) {
                for (Map.Entry<String, ViewDataObject> entry : getEndpointDataOutput.endpoint_data.entrySet()) {
                    ViewDataObject value = entry.getValue();
                    String key = entry.getKey();
                    String str2 = this.keyUrlMap.get(key);
                    if (str2 != null && str2.equals(str) && value != null) {
                        if (str != null) {
                            value.apiUrl = str;
                        }
                        if (this.keyViewIdMap.get(entry.getKey()) != null) {
                            value.viewId = this.keyViewIdMap.get(entry.getKey());
                        }
                        this.dataMap.put(key, value);
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PresenterItem> bindDataToViews() {
        ArrayList<EndpointViewObject> arrayList;
        ViewTagObject viewTagObject;
        ViewListObject viewListObject;
        int i;
        String str;
        ArrayList<PresenterItem> arrayList2 = new ArrayList<>();
        if (this.dataMap == null || (arrayList = this.endpointViews) == null) {
            return arrayList2;
        }
        Iterator<EndpointViewObject> it = arrayList.iterator();
        while (it.hasNext()) {
            EndpointViewObject next = it.next();
            EndpointViewObject.TypeEnum typeEnum = next.type;
            if (typeEnum == EndpointViewObject.TypeEnum.ViewList && (viewListObject = next.view_list) != null) {
                if (viewListObject.hasTitle()) {
                    arrayList2.add(new TitleObject(next.view_list.title));
                }
                ViewDataObjectArray viewDataObjectArray = new ViewDataObjectArray();
                ArrayList<String> arrayList3 = next.view_list.keys;
                if (arrayList3 != null) {
                    Iterator<String> it2 = arrayList3.iterator();
                    while (true) {
                        i = 0;
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            ViewDataObject viewDataObject = this.dataMap.get(next2);
                            String str2 = this.keyUrlMap.get(next2);
                            if (str2 != null && viewDataObject != null && (str = viewDataObject.apiUrl) != null && str.equals(str2)) {
                                if (next.view_list.type == ViewListObject.TypeEnum.List) {
                                    arrayList2.add(viewDataObject);
                                } else {
                                    viewDataObjectArray.viewId = this.keyViewIdMap.get(next2);
                                    viewDataObjectArray.arrayList.add(viewDataObject);
                                    i++;
                                    if (i >= next.view_list.itemCount) {
                                        break;
                                    }
                                }
                            }
                        }
                        arrayList2.add(viewDataObjectArray);
                        viewDataObjectArray = new ViewDataObjectArray();
                    }
                    if (i > 0) {
                        arrayList2.add(viewDataObjectArray);
                    }
                }
            } else if (typeEnum == EndpointViewObject.TypeEnum.ViewTag && (viewTagObject = next.view_tag) != null) {
                addHorizontalListRow(arrayList2, viewTagObject);
            }
        }
        return arrayList2;
    }

    public void setCountAndSize(ViewListObject viewListObject) {
        int i = (int) (viewListObject.view.h_space * 100.0f);
        ViewTagObject viewTagObject = new ViewTagObject();
        viewTagObject.view = viewListObject.view;
        this.listInput = new ListInput(viewTagObject);
        float f = i;
        int iCalculateNoOfColumns = DimensionHelper.calculateNoOfColumns(this.mContext, DimensionHelper.getItemWidth(getContext(), this.listInput) + AndroidUtilities.dp(f));
        int iCalculateItemWidthBasedOnColumns = DimensionHelper.calculateItemWidthBasedOnColumns(this.mContext, iCalculateNoOfColumns, AndroidUtilities.dp(f));
        viewListObject.itemCount = iCalculateNoOfColumns;
        viewListObject.itemWidthPx = iCalculateItemWidthBasedOnColumns;
    }

    public void addHorizontalListRow(ArrayList<PresenterItem> arrayList, ViewTagObject viewTagObject) {
        final ListInput listInput = new ListInput(viewTagObject);
        RecyclerViewListObject recyclerViewListObject = new RecyclerViewListObject(listInput, MainPresenterSelector.getInstance(this.mContext), this);
        recyclerViewListObject.onMoreTextClickListener = new OnPresenterItemClickListener(this) { // from class: ir.resaneh1.iptv.fragment.DynamicFragment.7
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
        arrayList.add(recyclerViewListObject);
    }

    private void setToolbar() {
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey(ApplicationLoader.applicationActivity, this.title);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public void retryCall() {
        super.retryCall();
        if (!this.isGetViews) {
            callGetViews();
        } else {
            callGetData();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MyLog.e("HomeFragment", "onConfigurationChanged: ");
        this.mainArrayList.clear();
        this.mainAdapter.notifyDataSetChanged();
        makeViews();
        makeData();
        this.mainArrayList.addAll(bindDataToViews());
        this.mainAdapter.notifyDataSetChanged();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isLastPortrait != isPortrait()) {
            MyLog.e("homeFragment", "onResume: isFirstTime" + this.isLastPortrait + isPortrait());
            this.mainArrayList.clear();
            this.mainAdapter.notifyDataSetChanged();
            makeViews();
            makeData();
            this.mainArrayList.addAll(bindDataToViews());
            this.mainAdapter.notifyDataSetChanged();
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

    private void setShortcutView(ArrayList<ShortcutObject> arrayList) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayoutBottom);
        if (frameLayout == null) {
            return;
        }
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
