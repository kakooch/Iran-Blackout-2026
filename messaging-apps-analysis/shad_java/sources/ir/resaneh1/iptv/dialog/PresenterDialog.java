package ir.resaneh1.iptv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.LoadMoreItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.LoadMorePresenter;
import ir.resaneh1.iptv.toolbar.ToolbarMaker;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class PresenterDialog extends Dialog {
    private View fragmentView;
    public boolean has_continue;
    public boolean isFullScreen;
    public boolean isMatchParent;
    protected boolean isStopLoading;
    public int itemCount;
    public LinearLayout linearLayout;
    public LinearLayoutManager linearLayoutManager;
    public ListInput listInput;
    public LoadMoreItem loadMoreItem;
    public LoadMoreItem.LoadMoreType loadMoreType;
    protected MainAdapter mainAdapter;
    public ArrayList<PresenterItem> mainArrayList;
    public RecyclerView mainRecyclerView;
    public String max_id;
    public String min_id;
    public View notFoundLayout;
    public ItemListRequest.Listener onItemLoadedListener;
    View.OnClickListener onLoadMoreClickListener;
    public View progressBar;
    public View retryLayout;
    public String start_id;
    private View toolbarContainer;
    public ToolbarMaker toolbarMaker;

    public int getLayoutId() {
        throw null;
    }

    protected void setRetryLayout() {
    }

    public PresenterDialog(Context context) {
        super(context);
        this.mainArrayList = new ArrayList<>();
        this.itemCount = 0;
        this.max_id = BuildConfig.FLAVOR;
        this.min_id = BuildConfig.FLAVOR;
        this.start_id = null;
        this.isStopLoading = false;
        this.loadMoreType = LoadMoreItem.LoadMoreType.moreIcon;
        this.isMatchParent = false;
        this.isFullScreen = false;
        this.has_continue = true;
        this.onLoadMoreClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadMorePresenter.ViewHolder viewHolder = (LoadMorePresenter.ViewHolder) view.getTag();
                ((LoadMoreItem) viewHolder.item).isLoading = true;
                LoadMorePresenter.refresh(viewHolder);
                PresenterDialog presenterDialog = PresenterDialog.this;
                presenterDialog.isStopLoading = false;
                presenterDialog.loadItems();
            }
        };
    }

    public PresenterDialog(Context context, int i) {
        super(context, i);
        this.mainArrayList = new ArrayList<>();
        this.itemCount = 0;
        this.max_id = BuildConfig.FLAVOR;
        this.min_id = BuildConfig.FLAVOR;
        this.start_id = null;
        this.isStopLoading = false;
        this.loadMoreType = LoadMoreItem.LoadMoreType.moreIcon;
        this.isMatchParent = false;
        this.isFullScreen = false;
        this.has_continue = true;
        this.onLoadMoreClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.dialog.PresenterDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoadMorePresenter.ViewHolder viewHolder = (LoadMorePresenter.ViewHolder) view.getTag();
                ((LoadMoreItem) viewHolder.item).isLoading = true;
                LoadMorePresenter.refresh(viewHolder);
                PresenterDialog presenterDialog = PresenterDialog.this;
                presenterDialog.isStopLoading = false;
                presenterDialog.loadItems();
            }
        };
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(createView());
        if (!this.isMatchParent) {
            if (DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity) < AndroidUtilities.dp(400.0f)) {
                getWindow().setLayout(-1, -2);
            } else {
                getWindow().setLayout(AndroidUtilities.dp(400.0f), -2);
            }
        } else {
            getWindow().setLayout(-1, -1);
        }
        if (this.isFullScreen) {
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
            getWindow().setFlags(1024, 1024);
        }
    }

    public View createView() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null, false);
        this.fragmentView = viewInflate;
        viewInflate.setOnTouchListener(new View.OnTouchListener(this) { // from class: ir.resaneh1.iptv.dialog.PresenterDialog.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        findView();
        init();
        return this.fragmentView;
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) this.fragmentView.findViewById(i);
    }

    protected void findView() {
        this.mainRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        View viewFindViewById = findViewById(R.id.progressBarContainer);
        this.progressBar = viewFindViewById;
        if (viewFindViewById != null) {
            if (ApplicationLoader.applicationActivity != null) {
                UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, (FrameLayout) this.progressBar, 40);
            }
        } else {
            this.progressBar = findViewById(R.id.progressBar);
        }
        this.notFoundLayout = findViewById(R.id.notFoundLayout);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.toolbarContainer = findViewById(R.id.toolbar);
        this.retryLayout = findViewById(R.id.retryLayout);
    }

    protected void setNotFoundLayout() {
        View view = this.notFoundLayout;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    protected void init() {
        View view = this.retryLayout;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.notFoundLayout;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        this.mainArrayList = new ArrayList<>();
        MyLog.e("PresenterFragment", "init: " + this.toolbarContainer);
        this.toolbarMaker = new ToolbarMaker(ApplicationLoader.applicationActivity, this.toolbarContainer);
        this.isStopLoading = false;
        this.loadMoreItem = new LoadMoreItem(this.onLoadMoreClickListener, this.loadMoreType);
    }

    protected void initWithVerticalLinearLayoutManager() {
        this.linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.mainRecyclerView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
        this.mainRecyclerView.setLayoutManager(this.linearLayoutManager);
    }

    protected void loadItems() {
        ListInput listInput = this.listInput;
        if (listInput != null) {
            if (!this.isStopLoading) {
                this.isStopLoading = true;
                listInput.max_id = this.max_id;
                listInput.min_id = this.min_id;
                listInput.start_id = this.start_id;
                MainAdapter mainAdapter = this.mainAdapter;
                if (mainAdapter != null) {
                    listInput.first_index = (this.itemCount + 1) - mainAdapter.biasFromFirst;
                }
                listInput.last_index = listInput.limit + listInput.first_index;
                if (!mainAdapter.isLoadMoreAuto) {
                    setLoadMoreItemLoading(true);
                }
                new ItemListRequest().load(getContext(), this.listInput, new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.dialog.PresenterDialog.3
                    @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                    public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                        String str;
                        PresenterDialog.this.progressBar.setVisibility(4);
                        ItemListRequest.Listener listener = PresenterDialog.this.onItemLoadedListener;
                        if (listener != null) {
                            listener.onResponse(arrayList, getListOutput);
                        }
                        PresenterDialog.this.removeLoadMoreItemIfNeeded();
                        PresenterDialog.this.addItemsToAdapter(arrayList);
                        if (getListOutput != null && (str = getListOutput.start_id) != null) {
                            PresenterDialog presenterDialog = PresenterDialog.this;
                            presenterDialog.start_id = str;
                            boolean z = getListOutput.has_continue;
                            presenterDialog.has_continue = z;
                            if (z) {
                                presenterDialog.isStopLoading = false;
                            } else {
                                presenterDialog.removeLoadMoreItemIfNeeded();
                            }
                        } else {
                            int size = arrayList.size();
                            PresenterDialog presenterDialog2 = PresenterDialog.this;
                            if (size >= presenterDialog2.listInput.limit) {
                                presenterDialog2.isStopLoading = false;
                            } else {
                                presenterDialog2.removeLoadMoreItemIfNeeded();
                            }
                        }
                        if (PresenterDialog.this.mainArrayList.size() <= 0) {
                            PresenterDialog.this.setNotFoundLayout();
                        }
                    }

                    @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
                    public void onFailure(Throwable th) {
                        PresenterDialog.this.progressBar.setVisibility(4);
                        if (PresenterDialog.this.mainArrayList.size() <= 0) {
                            PresenterDialog.this.setRetryLayout();
                        }
                        PresenterDialog.this.setLoadMoreItemLoading(false);
                        PresenterDialog presenterDialog = PresenterDialog.this;
                        presenterDialog.isStopLoading = true;
                        ItemListRequest.Listener listener = presenterDialog.onItemLoadedListener;
                        if (listener != null) {
                            listener.onFailure(th);
                        }
                    }
                });
                return;
            }
            this.progressBar.setVisibility(4);
            return;
        }
        this.progressBar.setVisibility(4);
    }

    public void removeLoadMoreItemIfNeeded() {
        if (this.mainArrayList.size() > 0) {
            if (this.mainArrayList.get(r0.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
                this.mainArrayList.remove(r0.size() - 1);
                this.mainAdapter.notifyItemRemoved(this.mainArrayList.size());
            }
        }
    }

    public void addLoadMoreItem(boolean z) {
        LoadMoreItem loadMoreItem = new LoadMoreItem(this.onLoadMoreClickListener, this.loadMoreType);
        this.loadMoreItem = loadMoreItem;
        loadMoreItem.isLoading = z;
        loadMoreItem.height = AndroidUtilities.dp(56.0f);
        MyLog.e("PresenterFragment", "addLoadMoreItem: " + this.loadMoreItem.width + " " + this.loadMoreItem.height);
        this.mainArrayList.add(this.loadMoreItem);
        this.mainAdapter.notifyItemChanged(this.mainArrayList.size() + (-1));
    }

    public void setLoadMoreItemLoading(boolean z) {
        if (this.mainArrayList.size() > 0) {
            if (this.mainArrayList.get(r0.size() - 1).getPresenterType() == PresenterItemType.loadMore) {
                this.loadMoreItem.isLoading = z;
                this.mainAdapter.notifyItemChanged(this.mainArrayList.size() - 1);
            }
        }
    }

    public void addItemsToAdapter(ArrayList<? extends PresenterItem> arrayList) {
        this.mainRecyclerView.stopScroll();
        if (!this.mainAdapter.isWantLoadMore) {
            this.mainArrayList.clear();
            this.mainAdapter.notifyDataSetChanged();
        }
        this.itemCount += arrayList.size();
        if (arrayList.size() > 0) {
            this.max_id = arrayList.get(arrayList.size() - 1).getPresenterId();
            this.min_id = arrayList.get(arrayList.size() - 1).getPresenterId();
        }
        this.mainArrayList.addAll(arrayList);
        int size = arrayList.size();
        MainAdapter mainAdapter = this.mainAdapter;
        if (mainAdapter.isWantLoadMore) {
            if (mainAdapter.isLoadMoreAuto) {
                addLoadMoreItem(true);
            } else {
                addLoadMoreItem(false);
            }
            size++;
        }
        this.mainAdapter.notifyItemRangeChanged(this.mainArrayList.size() - size, size);
    }
}
