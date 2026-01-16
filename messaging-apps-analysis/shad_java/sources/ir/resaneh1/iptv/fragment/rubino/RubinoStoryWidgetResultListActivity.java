package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.EmojiSliderResultObject;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoStoryWidgetResultListActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    public static int type_emojiSlider;
    private int arrayEndRow;
    private int arrayStartRow;
    private ArrayList<EmojiSliderResultObject> emojiResultArray = new ArrayList<>();
    private boolean hasContinue;
    private ListAdapter listAdapter;
    private RecyclerListViewEdited listView;
    private int loadMorePosition;
    public DisposableObserver loadObserver;
    private int loadingRow;
    private boolean needToRetry;
    private int retryRow;
    private int rowCount;
    private String startId;
    private StoryObject storyObject;
    private int type;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$0(View view, int i, float f, float f2) {
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public RubinoStoryWidgetResultListActivity(StoryObject storyObject, int i) {
        this.type = i;
        this.storyObject = storyObject;
        initFlags();
    }

    private void initFlags() {
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoStoryWidgetResultListActivity" + this.type;
        this.swipeBackEnabled = true;
        this.isSmallActionBar = true;
        if (DimensionHelper.isShowstoryNeedFullScreen()) {
            this.isFullScreen = true;
        }
        this.isForceBlackTheme = true;
        this.needLockOrientation = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        if (this.type == type_emojiSlider) {
            this.actionBar.setTitle(LocaleController.getString(R.string.rubinoStoryWidgetAnswers));
        }
        this.actionBar.getTitleTextView().setTypeface(Theme.getRubinoTypeFaceRegular());
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    RubinoStoryWidgetResultListActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        int i = Theme.key_windowBackgroundWhite;
        frameLayout2.setBackgroundColor(Theme.getColor(i));
        RecyclerListViewEdited recyclerListViewEdited = new RecyclerListViewEdited(context);
        this.listView = recyclerListViewEdited;
        recyclerListViewEdited.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setClipToPadding(false);
        this.listView.setClipChildren(false);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setEmptyView(new RubinoEmptyView(context, 17));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setBackgroundColor(Theme.getColor(i));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListViewEdited.OnItemClickListenerExtended() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity$$ExternalSyntheticLambda0
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemClickListenerExtended
            public final void onItemClick(View view, int i2, float f, float f2) {
                RubinoStoryWidgetResultListActivity.lambda$createView$0(view, i2, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListViewEdited.OnItemLongClickListener(this) { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity.3
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.OnItemLongClickListener
            public boolean onItemClick(View view, int i2) {
                return false;
            }
        });
        this.hasContinue = true;
        updateRows();
        return this.fragmentView;
    }

    void updateRows() {
        this.arrayStartRow = -1;
        this.arrayEndRow = -1;
        this.loadingRow = -1;
        this.retryRow = -1;
        this.loadMorePosition = Math.max(0, this.emojiResultArray.size() - 15);
        this.rowCount = 0;
        if (this.needToRetry) {
            this.rowCount = 0 + 1;
            this.retryRow = 0;
            this.loadMorePosition = -1;
        } else if (this.type == type_emojiSlider) {
            if (this.emojiResultArray.size() > 0) {
                int i = this.rowCount;
                this.arrayStartRow = i;
                int size = i + this.emojiResultArray.size();
                this.rowCount = size;
                this.arrayEndRow = size;
            }
            if (this.hasContinue) {
                int i2 = this.rowCount;
                this.rowCount = i2 + 1;
                this.loadingRow = i2;
            }
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsOnAddEmojiReslut() {
        if (this.type == type_emojiSlider) {
            if (this.arrayStartRow < 0 || this.emojiResultArray.size() <= 0) {
                updateRows();
                return;
            }
            this.loadMorePosition = Math.max(0, this.emojiResultArray.size() - 15);
            int i = this.arrayStartRow;
            this.rowCount = i;
            int size = i + this.emojiResultArray.size();
            this.rowCount = size;
            this.arrayEndRow = size;
            int i2 = this.loadingRow;
            if (this.hasContinue) {
                this.rowCount = size + 1;
                this.loadingRow = size;
            } else {
                this.loadingRow = -1;
            }
            ListAdapter listAdapter = this.listAdapter;
            if (listAdapter != null) {
                listAdapter.notifyItemRangeChanged(i2, 1);
                int i3 = this.rowCount;
                if ((i3 - i2) - 1 > 0) {
                    this.listAdapter.notifyItemRangeInserted(i2 + 1, (i3 - i2) - 1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getResults(final boolean z) {
        if ((z || this.hasContinue) && this.type == type_emojiSlider) {
            DisposableObserver disposableObserver = (DisposableObserver) getRubinoController().getEmojiSliderResultsObservable(this.storyObject.id, z ? null : this.startId, 50).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.GetEmojiResultsOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity.4
                @Override // io.reactivex.Observer
                public void onNext(Rubino.GetEmojiResultsOutput getEmojiResultsOutput) {
                    if (getEmojiResultsOutput != null) {
                        RubinoStoryWidgetResultListActivity.this.startId = getEmojiResultsOutput.next_start_id;
                        ArrayList<EmojiSliderResultObject> arrayList = getEmojiResultsOutput.emoji_slider_results;
                        if (arrayList == null || arrayList.size() <= 0) {
                            RubinoStoryWidgetResultListActivity.this.hasContinue = false;
                        } else {
                            if (z) {
                                RubinoStoryWidgetResultListActivity.this.emojiResultArray.clear();
                            }
                            RubinoStoryWidgetResultListActivity.this.emojiResultArray.addAll(getEmojiResultsOutput.emoji_slider_results);
                        }
                        if (!z) {
                            RubinoStoryWidgetResultListActivity.this.updateRowsOnAddEmojiReslut();
                        } else {
                            RubinoStoryWidgetResultListActivity.this.updateRows();
                        }
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    dispose();
                    if (RubinoStoryWidgetResultListActivity.this.emojiResultArray.size() == 0) {
                        RubinoStoryWidgetResultListActivity.this.needToRetry = true;
                        RubinoStoryWidgetResultListActivity.this.updateRows();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            this.loadObserver = disposableObserver;
            this.compositeDisposable.add(disposableObserver);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    class ListAdapter extends RecyclerListViewEdited.SelectionAdapter {
        Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListViewEdited.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.itemView instanceof RubinoRetryView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoStoryWidgetResultListActivity.this.rowCount;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ProfileInSeenStoryCell profileInSeenStoryCell;
            View rubinoLoadingCell;
            if (i == 0) {
                ProfileInSeenStoryCell profileInSeenStoryCell2 = new ProfileInSeenStoryCell(this.mContext);
                profileInSeenStoryCell2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                profileInSeenStoryCell = profileInSeenStoryCell2;
            } else if (i == 2) {
                RubinoRetryView rubinoRetryView = new RubinoRetryView(this.mContext);
                rubinoRetryView.setData(R.drawable.rubino_loadmore_icon_refresh);
                rubinoRetryView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoStoryWidgetResultListActivity.ListAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RubinoStoryWidgetResultListActivity.this.needToRetry = false;
                        RubinoStoryWidgetResultListActivity.this.updateRows();
                    }
                });
                rubinoRetryView.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(80.0f)));
                ((LinearLayout.LayoutParams) rubinoRetryView.imageView.getLayoutParams()).topMargin = AndroidUtilities.dp(4.0f);
                profileInSeenStoryCell = rubinoRetryView;
            } else {
                rubinoLoadingCell = new RubinoLoadingCell(this.mContext, false);
                return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
            }
            rubinoLoadingCell = profileInSeenStoryCell;
            return new RecyclerListViewEdited.Holder(rubinoLoadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MyLog.e("List Status", "onBind: " + viewHolder.getAdapterPosition());
            if (viewHolder.getItemViewType() == 0) {
                ProfileInSeenStoryCell profileInSeenStoryCell = (ProfileInSeenStoryCell) viewHolder.itemView;
                if (i >= RubinoStoryWidgetResultListActivity.this.arrayStartRow && i < RubinoStoryWidgetResultListActivity.this.arrayEndRow) {
                    profileInSeenStoryCell.setEmojiResult((EmojiSliderResultObject) RubinoStoryWidgetResultListActivity.this.emojiResultArray.get(i - RubinoStoryWidgetResultListActivity.this.arrayStartRow));
                }
            }
            if (RubinoStoryWidgetResultListActivity.this.hasContinue) {
                if (i == RubinoStoryWidgetResultListActivity.this.loadMorePosition || i == RubinoStoryWidgetResultListActivity.this.loadingRow) {
                    RubinoStoryWidgetResultListActivity.this.getResults(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i >= RubinoStoryWidgetResultListActivity.this.arrayStartRow && i < RubinoStoryWidgetResultListActivity.this.arrayEndRow) {
                return 0;
            }
            if (i == RubinoStoryWidgetResultListActivity.this.loadingRow) {
                return 1;
            }
            return i == RubinoStoryWidgetResultListActivity.this.retryRow ? 2 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
            MyLog.e("List Status", "detached: " + viewHolder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            super.onViewAttachedToWindow(viewHolder);
            MyLog.e("List Status", "attached: " + viewHolder.getAdapterPosition());
        }
    }
}
