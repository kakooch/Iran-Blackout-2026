package ir.resaneh1.iptv.fragment.rubino.highlight;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.highlight.ArchivedStoryCell;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.LoadingCell;

/* loaded from: classes3.dex */
public class ArchiveStoryListFragment extends BaseFragment {
    private ListAdapter adapter;
    private ActionBarMenuItem doneItem;
    private TextView emptyView;
    private boolean isLoading;
    private GridLayoutManager layoutManager;
    private RecyclerListView listView;
    private ArrayList<StoryObject> storyObjects = new ArrayList<>();
    private Set<StoryObject> selectedStories = new HashSet();
    private String nextStartId = null;
    private boolean hasContinue = true;
    private DisposableObserver<Rubino.GetMyArchiveStoriesOutput> getArchiveStoriesObservable = null;
    private int storiesStartRow = -1;
    private int storiesEndRow = -1;
    private int loadingRow = -1;
    private int rowCount = 0;
    private int actionbar_doneItem = 100;

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString(R.string.rubinoNewHighLight));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i != -1) {
                    if (i == ArchiveStoryListFragment.this.actionbar_doneItem) {
                        ArchiveStoryListFragment.this.presentFragment(new AddHighlightFragment((Set<StoryObject>) ArchiveStoryListFragment.this.selectedStories));
                        return;
                    }
                    return;
                }
                ArchiveStoryListFragment.this.finishFragment();
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(this.actionbar_doneItem, LocaleController.getString(R.string.rubinoActionNext));
        this.doneItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.textView.setTypeface(Theme.getRubinoTypeFaceMedium());
        this.doneItem.textView.setTextColor(ContextCompat.getColor(context, R.color.rubino_blue));
        this.doneItem.setVisibility(8);
        this.adapter = new ListAdapter(context, AndroidUtilities.getScreenWidth() / 3);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setAdapter(this.adapter);
        RecyclerListView recyclerListView2 = this.listView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3, 1, false);
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setFastScrollEnabled();
        this.listView.setScrollEnabled(false);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment.2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return i == ArchiveStoryListFragment.this.loadingRow ? 3 : 1;
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1, 48, 8.0f, 8.0f, 8.0f, 8.0f));
        callGetArchiveStories(true);
        TextView textView = new TextView(getParentActivity());
        this.emptyView = textView;
        textView.setTextColor(-8355712);
        this.emptyView.setTextSize(20.0f);
        this.emptyView.setGravity(17);
        this.emptyView.setVisibility(8);
        this.emptyView.setText(LocaleController.getString(R.string.rubinoHighlightNoStory));
        frameLayout.addView(this.emptyView);
        this.listView.setEmptyView(this.emptyView);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int iAbs = Math.abs(ArchiveStoryListFragment.this.layoutManager.findLastVisibleItemPosition() - ArchiveStoryListFragment.this.layoutManager.findFirstVisibleItemPosition()) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (iAbs <= 0 || ArchiveStoryListFragment.this.layoutManager.findLastVisibleItemPosition() < itemCount - 5) {
                    return;
                }
                ArchiveStoryListFragment.this.callGetArchiveStories(false);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetArchiveStories(boolean z) {
        if (z || (this.hasContinue && !this.isLoading)) {
            this.isLoading = true;
            if (z) {
                this.storyObjects.clear();
                this.hasContinue = true;
                this.nextStartId = null;
                DisposableObserver<Rubino.GetMyArchiveStoriesOutput> disposableObserver = this.getArchiveStoriesObservable;
                if (disposableObserver != null) {
                    disposableObserver.dispose();
                }
                updateRowIds();
            }
            this.getArchiveStoriesObservable = (DisposableObserver) getRubinoController().getMyArchiveStories(z ? null : this.nextStartId, (z || this.storyObjects.size() == 0) ? 10 : 30).subscribeWith(new DisposableObserver<Rubino.GetMyArchiveStoriesOutput>() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment.4
                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Rubino.GetMyArchiveStoriesOutput getMyArchiveStoriesOutput) {
                    ArchiveStoryListFragment.this.nextStartId = getMyArchiveStoriesOutput.next_start_id;
                    ArchiveStoryListFragment.this.hasContinue = getMyArchiveStoriesOutput.has_continue;
                    if (getMyArchiveStoriesOutput.stories != null) {
                        ArchiveStoryListFragment.this.storyObjects.addAll(getMyArchiveStoriesOutput.stories);
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    ArchiveStoryListFragment.this.isLoading = false;
                    ArchiveStoryListFragment.this.updateRowIds();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowIds() {
        this.loadingRow = -1;
        this.storiesStartRow = -1;
        this.storiesEndRow = -1;
        this.rowCount = 0;
        if (!this.storyObjects.isEmpty()) {
            int i = this.rowCount;
            this.storiesStartRow = i;
            int size = i + this.storyObjects.size();
            this.rowCount = size;
            this.storiesEndRow = size;
        }
        if (this.isLoading) {
            int i2 = this.rowCount;
            this.rowCount = i2 + 1;
            this.loadingRow = i2;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        DisposableObserver<Rubino.GetMyArchiveStoriesOutput> disposableObserver = this.getArchiveStoriesObservable;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.FastScrollAdapter {
        private final int itemWidth;
        private final Context mContext;

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        private ListAdapter(Context context, int i) {
            this.mContext = context;
            this.itemWidth = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LoadingCell loadingCell;
            if (i == 0) {
                ArchivedStoryCell archivedStoryCell = new ArchivedStoryCell(this.mContext, this.itemWidth);
                archivedStoryCell.setDelegate(new ArchivedStoryCell.ArchivedStoryDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.highlight.ArchiveStoryListFragment$ListAdapter$$ExternalSyntheticLambda0
                    @Override // ir.resaneh1.iptv.fragment.rubino.highlight.ArchivedStoryCell.ArchivedStoryDelegate
                    public final void onItemClick(ArchivedStoryCell archivedStoryCell2, StoryObject storyObject) {
                        this.f$0.lambda$onCreateViewHolder$0(archivedStoryCell2, storyObject);
                    }
                });
                loadingCell = archivedStoryCell;
            } else {
                loadingCell = i == 1 ? new LoadingCell(this.mContext) : null;
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(ArchivedStoryCell archivedStoryCell, StoryObject storyObject) {
            boolean zIsChecked = archivedStoryCell.isChecked();
            if (zIsChecked) {
                ArchiveStoryListFragment.this.selectedStories.remove(storyObject);
            } else {
                ArchiveStoryListFragment.this.selectedStories.add(storyObject);
            }
            archivedStoryCell.setChecked(!zIsChecked, true);
            ArchiveStoryListFragment.this.checkNextButton();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ArchivedStoryCell archivedStoryCell = (ArchivedStoryCell) viewHolder.itemView;
                StoryObject storyObject = (StoryObject) ArchiveStoryListFragment.this.storyObjects.get(i - ArchiveStoryListFragment.this.storiesStartRow);
                archivedStoryCell.setData(storyObject, ArchiveStoryListFragment.this.selectedStories.contains(storyObject));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == ArchiveStoryListFragment.this.loadingRow) {
                return 1;
            }
            if (i < ArchiveStoryListFragment.this.storiesStartRow || i >= ArchiveStoryListFragment.this.storiesEndRow) {
                return super.getItemViewType(i);
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ArchiveStoryListFragment.this.rowCount;
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            if (i < ArchiveStoryListFragment.this.storiesStartRow || i >= ArchiveStoryListFragment.this.storiesEndRow) {
                return BuildConfig.FLAVOR;
            }
            int i2 = i - ArchiveStoryListFragment.this.storiesStartRow;
            int i3 = i2 - (i2 % 3);
            return (i3 < 0 || i3 >= ArchiveStoryListFragment.this.storyObjects.size()) ? BuildConfig.FLAVOR : DateFormatUtils.getMonthKeyPersian(((StoryObject) ArchiveStoryListFragment.this.storyObjects.get(i3)).create_date * 1000);
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float f) {
            return (int) (getItemCount() * f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNextButton() {
        this.doneItem.setVisibility(this.selectedStories.size() > 0 ? 0 : 8);
    }
}
