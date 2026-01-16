package ir.resaneh1.iptv.fragment.rubino;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.appp.common.utils.LayoutHelper;
import ir.appp.rghapp.RGHMediaHelper$PhotoEntry;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import ir.appp.rghapp.rubinoPostSlider.PostTagType;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.ProfileInTagPeopleCell;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.fragment.rubino.RubinoSearchView;
import ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.SpanHelper;
import ir.resaneh1.iptv.insta.RubinoDraftManager;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class RubinoTagPostActivity extends BaseFragment {
    private RubinoSearchView actionBarSearchView;
    private ListAdapter adapter;
    private int addTagPeopleRow;
    private int arrayEndRow;
    private int arrayStartRow;
    private RGHMediaHelper$PhotoEntry currentPhotoEntry;
    private int currentPhotoEntryPosition;
    private boolean endReached;
    private String lastSearchedText;
    private RecyclerListView listView;
    private String maxId;
    private MentionedPeopleAdapter mentionedPeopleAdapter;
    private int noResultRow;
    private int postRow;
    private DisposableObserver<Rubino.ProfileListObject> requestObservable;
    private ListAdapter searchAdapter;
    private int searchArrayEndRow;
    private int searchArrayStartRow;
    private boolean searchesInProgress;
    private boolean searching;
    private final RubinoDraftManager.RubinoSendingPost sendingPost;
    private boolean showSearch;
    private int tagAnotherPersonRow;
    private ArrayList<PostTagObject> taggedProfiles;
    private final ArrayList<RubinoProfileObject> searchProfiles = new ArrayList<>();
    private int rowCount = 0;

    public RubinoTagPostActivity(RubinoDraftManager.RubinoSendingPost rubinoSendingPost) {
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList;
        ArrayList<RGHMediaHelper$PhotoEntry> arrayList2;
        this.swipeBackEnabled = false;
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "RubinoCaptionPostActivity";
        this.sendingPost = rubinoSendingPost;
        if (rubinoSendingPost != null && (arrayList2 = rubinoSendingPost.entryList) != null && !arrayList2.isEmpty() && rubinoSendingPost.entryList.get(0).isVideo) {
            ArrayList<PostTagObject> arrayList3 = new ArrayList<>();
            this.taggedProfiles = arrayList3;
            arrayList3.addAll(rubinoSendingPost.entryList.get(0).tempTaggedProfiles.keySet());
        }
        this.isSmallActionBar = true;
        if (rubinoSendingPost == null || (arrayList = rubinoSendingPost.entryList) == null || arrayList.isEmpty()) {
            return;
        }
        this.currentPhotoEntry = rubinoSendingPost.entryList.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean entryIsPhoto() {
        if (this.currentPhotoEntry == null) {
            return !this.sendingPost.entryList.get(0).isVideo;
        }
        return !r0.isVideo;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        setupActionbar(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1));
        this.searchAdapter = new ListAdapter(context);
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        this.listView.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity$$ExternalSyntheticLambda1
            @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        updateRowsIds();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        if (getParentActivity() == null || !(view instanceof ProfileOrHashtagCell) || this.currentPhotoEntry == null) {
            return;
        }
        ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) view;
        if (!profileOrHashtagCell.isEnable()) {
            RubinoProfileObject rubinoProfileObject = profileOrHashtagCell.currentProfile;
            String string = (rubinoProfileObject == null || rubinoProfileObject.username.isEmpty()) ? LocaleController.getString(R.string.this_user) : rubinoProfileObject.username;
            String strValueOf = String.valueOf(LocaleController.formatString(R.string.rubinoTagNotEnable, string));
            SpannableString spannableString = new SpannableString(strValueOf + "\n" + String.valueOf(LocaleController.formatString(R.string.rubinoTagNotEnableText, string)));
            int length = strValueOf.length();
            int i2 = Theme.key_rubinoBlackColor;
            RubinoController.showRubinoCenterDialog(false, false, null, SpanHelper.makeBoldWithColorAndRelativeSize(spannableString, 0, length, Theme.getColor(i2), 1.4f), LocaleController.getString("Discard", R.string.OK), null, -16476939, Theme.getColor(i2), null, null);
            return;
        }
        PostTagObject postTagObject = new PostTagObject();
        postTagObject.profileObject = profileOrHashtagCell.currentProfile;
        postTagObject.tagType = PostTagType.USER;
        if (!entryIsPhoto()) {
            if (this.taggedProfiles == null) {
                this.taggedProfiles = new ArrayList<>();
            }
            this.taggedProfiles.add(postTagObject);
        }
        HashMap<PostTagObject, Point> map = this.currentPhotoEntry.tempTaggedProfiles;
        map.put(postTagObject, map.get(null));
        this.currentPhotoEntry.tempTaggedProfiles.remove(null);
        toggleSearchingMode(false);
    }

    private void setupActionbar(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.close_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString(R.string.rubinoTagPeople));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                } else if (i == 1) {
                    RubinoTagPostActivity.this.clearEmptyTaggedProfileFromSendingPost();
                    RubinoTagPostActivity.this.addFinalTaggedProfiles();
                    RubinoTagPostActivity.this.finishFragment();
                }
            }
        });
        this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done_blue, AndroidUtilities.dp(56.0f)).getImageView().setVisibility(0);
        RubinoSearchView rubinoSearchView = new RubinoSearchView(context, this.compositeDisposable, RubinoSearchView.type_in_actionbar, new RubinoSearchView.SearchListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity$$ExternalSyntheticLambda2
            @Override // ir.resaneh1.iptv.fragment.rubino.RubinoSearchView.SearchListener
            public final void search(String str) {
                this.f$0.lambda$setupActionbar$1(str);
            }
        });
        this.actionBarSearchView = rubinoSearchView;
        this.actionBar.addView(rubinoSearchView, LayoutHelper.createFrame(-1, 48, 16, 0.0f, 0.0f, 48.0f, 0.0f));
        this.actionBarSearchView.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefault));
        this.actionBarSearchView.editText.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(16.0f), 0);
        this.actionBarSearchView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupActionbar$1(String str) {
        if (str.isEmpty()) {
            this.searching = false;
            RecyclerView.Adapter adapter = this.listView.getAdapter();
            ListAdapter listAdapter = this.adapter;
            if (adapter != listAdapter) {
                this.listView.setAdapter(listAdapter);
            }
        } else {
            this.searching = true;
            RecyclerView.Adapter adapter2 = this.listView.getAdapter();
            ListAdapter listAdapter2 = this.searchAdapter;
            if (adapter2 != listAdapter2) {
                this.listView.setAdapter(listAdapter2);
            }
            searchText(str);
        }
        updateRowsIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFinalTaggedProfiles() {
        Iterator<RGHMediaHelper$PhotoEntry> it = this.sendingPost.entryList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;
        int screenHeight;
        int screenWidth;

        public ListAdapter(Context context) {
            this.mContext = context;
            this.screenWidth = DimensionHelper.getScreenWidth((Activity) context);
            this.screenHeight = DimensionHelper.getScreenHeight((Activity) context) - ((BaseFragment) RubinoTagPostActivity.this).actionBar.getHeight();
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition != RubinoTagPostActivity.this.addTagPeopleRow && adapterPosition != RubinoTagPostActivity.this.tagAnotherPersonRow) {
                if (RubinoTagPostActivity.this.searching && adapterPosition >= RubinoTagPostActivity.this.searchArrayStartRow && adapterPosition < RubinoTagPostActivity.this.searchArrayEndRow) {
                    View view = viewHolder.itemView;
                    if (!(view instanceof ProfileOrHashtagCell) || ((ProfileOrHashtagCell) view).isEnable()) {
                    }
                }
                return false;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoTagPostActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 0) {
                View postInTagPeopleView = new PostInTagPeopleView(this.mContext, new TagPeopleViewItem.ActionOnTagItemView() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity.ListAdapter.1
                    @Override // ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem.ActionOnTagItemView
                    public void onClickOnView(Point point, int i2) {
                        RubinoTagPostActivity.this.currentPhotoEntry.tempTaggedProfiles.put(null, point);
                        RubinoTagPostActivity.this.toggleSearchingMode(true);
                    }

                    @Override // ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem.ActionOnTagItemView
                    public void onRemoveSearchMode() {
                        RubinoTagPostActivity.this.toggleSearchingMode(false);
                    }

                    @Override // ir.resaneh1.iptv.fragment.rubino.TagPeopleViewItem.ActionOnTagItemView
                    public void onScroll(int i2) {
                        if (RubinoTagPostActivity.this.sendingPost != null) {
                            RubinoTagPostActivity.this.clearEmptyTaggedProfileFromSendingPost();
                            RubinoTagPostActivity.this.toggleSearchingMode(false);
                            RubinoTagPostActivity rubinoTagPostActivity = RubinoTagPostActivity.this;
                            rubinoTagPostActivity.currentPhotoEntry = rubinoTagPostActivity.sendingPost.entryList.get(i2);
                            RubinoTagPostActivity.this.currentPhotoEntryPosition = i2;
                            RubinoTagPostActivity.this.taggedProfiles = null;
                            if (!RubinoTagPostActivity.this.entryIsPhoto()) {
                                RubinoTagPostActivity.this.taggedProfiles = new ArrayList();
                                RubinoTagPostActivity.this.taggedProfiles.addAll(RubinoTagPostActivity.this.currentPhotoEntry.tempTaggedProfiles.keySet());
                            }
                        } else {
                            RubinoTagPostActivity.this.currentPhotoEntry = null;
                        }
                        RubinoTagPostActivity.this.updateRowsIds();
                    }
                });
                int i2 = this.screenWidth;
                postInTagPeopleView.setLayoutParams(new RecyclerView.LayoutParams(i2, i2));
                view = postInTagPeopleView;
            } else if (i == 1) {
                TextView textView = new TextView(this.mContext);
                int iDp = AndroidUtilities.dp(16.0f);
                textView.setPadding(iDp, iDp, iDp, iDp);
                textView.setGravity(17);
                if (Build.VERSION.SDK_INT >= 17) {
                    textView.setTextAlignment(4);
                }
                textView.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
                textView.setTypeface(Theme.getRubinoTypeFaceRegular());
                textView.setTextSize(2, 14.0f);
                textView.setLineSpacing(AndroidUtilities.dp(8.0f), 1.0f);
                textView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                int i3 = this.screenWidth;
                textView.setLayoutParams(new RecyclerView.LayoutParams(i3, this.screenHeight - i3));
                view = textView;
            } else if (i == 3) {
                ProfileOrHashtagCell profileOrHashtagCell = new ProfileOrHashtagCell(this.mContext, false, true);
                profileOrHashtagCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                profileOrHashtagCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                profileOrHashtagCell.controllClick = false;
                view = profileOrHashtagCell;
            } else if (i == 4) {
                RecyclerView recyclerView = new RecyclerView(this.mContext);
                RubinoTagPostActivity rubinoTagPostActivity = RubinoTagPostActivity.this;
                rubinoTagPostActivity.mentionedPeopleAdapter = new MentionedPeopleAdapter();
                recyclerView.setAdapter(RubinoTagPostActivity.this.mentionedPeopleAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
                int i4 = this.screenWidth;
                recyclerView.setLayoutParams(new RecyclerView.LayoutParams(i4, this.screenHeight - i4));
                view = recyclerView;
            } else if (i == 6) {
                View rubinoSearchLoadingOrEmptyCell = new RubinoSearchLoadingOrEmptyCell(this.mContext, true);
                rubinoSearchLoadingOrEmptyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                view = rubinoSearchLoadingOrEmptyCell;
            } else {
                View textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                view = textSettingsCell;
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                ((PostInTagPeopleView) viewHolder.itemView).setPost(RubinoTagPostActivity.this.sendingPost, RubinoTagPostActivity.this.currentPhotoEntryPosition);
                return;
            }
            if (itemViewType == 1) {
                TextView textView = (TextView) viewHolder.itemView;
                if (RubinoTagPostActivity.this.sendingPost.entryList.size() > 1) {
                    textView.setText(String.format("%s\n%s", this.mContext.getString(R.string.rubino_tag_people_single), this.mContext.getString(R.string.rubino_tag_people_multi)));
                    return;
                } else {
                    textView.setText(this.mContext.getString(R.string.rubino_tag_people_single));
                    return;
                }
            }
            if (itemViewType == 3) {
                ProfileOrHashtagCell profileOrHashtagCell = (ProfileOrHashtagCell) viewHolder.itemView;
                if (i < RubinoTagPostActivity.this.searchArrayStartRow || i >= RubinoTagPostActivity.this.searchArrayEndRow) {
                    return;
                }
                profileOrHashtagCell.setProfile((RubinoProfileObject) RubinoTagPostActivity.this.searchProfiles.get(i - RubinoTagPostActivity.this.searchArrayStartRow), ((BaseFragment) RubinoTagPostActivity.this).classGuid);
                return;
            }
            if (itemViewType == 4) {
                RubinoTagPostActivity.this.arrayStartRow = 1;
                RubinoTagPostActivity rubinoTagPostActivity = RubinoTagPostActivity.this;
                rubinoTagPostActivity.arrayEndRow = rubinoTagPostActivity.arrayStartRow + RubinoTagPostActivity.this.taggedProfiles.size();
                RubinoTagPostActivity.this.mentionedPeopleAdapter.notifyDataSetChanged();
                return;
            }
            if (itemViewType != 6) {
                return;
            }
            RubinoSearchLoadingOrEmptyCell rubinoSearchLoadingOrEmptyCell = (RubinoSearchLoadingOrEmptyCell) viewHolder.itemView;
            if (RubinoTagPostActivity.this.actionBarSearchView != null) {
                String strTrim = RubinoTagPostActivity.this.actionBarSearchView.getText().trim();
                if (strTrim.isEmpty()) {
                    rubinoSearchLoadingOrEmptyCell.setText(BuildConfig.FLAVOR);
                    return;
                }
                rubinoSearchLoadingOrEmptyCell.setText(LocaleController.getString(R.string.rubinoSearchNoResult).replace("$arg1", "\"" + strTrim + "\""));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RubinoTagPostActivity.this.postRow) {
                return 0;
            }
            if (i == RubinoTagPostActivity.this.addTagPeopleRow) {
                return 1;
            }
            if (i >= RubinoTagPostActivity.this.searchArrayStartRow && i < RubinoTagPostActivity.this.searchArrayEndRow) {
                return 3;
            }
            if (i == RubinoTagPostActivity.this.tagAnotherPersonRow) {
                return 4;
            }
            return i == RubinoTagPostActivity.this.noResultRow ? 6 : 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MentionedPeopleAdapter extends RecyclerListView.SelectionAdapter {
        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        private MentionedPeopleAdapter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RubinoTagAnotherPersonView rubinoTagAnotherPersonView;
            if (i == 1) {
                ProfileInTagPeopleCell profileInTagPeopleCell = new ProfileInTagPeopleCell(RubinoTagPostActivity.this.getContext());
                profileInTagPeopleCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                profileInTagPeopleCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                profileInTagPeopleCell.setDelegate(new ProfileInTagPeopleCell.ProfileTagPeopleDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity$MentionedPeopleAdapter$$ExternalSyntheticLambda1
                    @Override // ir.resaneh1.iptv.fragment.rubino.ProfileInTagPeopleCell.ProfileTagPeopleDelegate
                    public final void onCloseClick(PostTagObject postTagObject) {
                        this.f$0.lambda$onCreateViewHolder$0(postTagObject);
                    }
                });
                rubinoTagAnotherPersonView = profileInTagPeopleCell;
            } else {
                RubinoTagAnotherPersonView rubinoTagAnotherPersonView2 = new RubinoTagAnotherPersonView(RubinoTagPostActivity.this.getContext());
                rubinoTagAnotherPersonView2.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                rubinoTagAnotherPersonView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity$MentionedPeopleAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$1(view);
                    }
                });
                rubinoTagAnotherPersonView = rubinoTagAnotherPersonView2;
            }
            rubinoTagAnotherPersonView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(rubinoTagAnotherPersonView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(PostTagObject postTagObject) {
            RubinoTagPostActivity.this.taggedProfiles.remove(postTagObject);
            RubinoTagPostActivity.this.currentPhotoEntry.tempTaggedProfiles.remove(postTagObject);
            RubinoTagPostActivity.this.updateRowsIds();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
            RubinoTagPostActivity.this.toggleSearchingMode(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 1) {
                ProfileInTagPeopleCell profileInTagPeopleCell = (ProfileInTagPeopleCell) viewHolder.itemView;
                if (i < RubinoTagPostActivity.this.arrayStartRow || i >= RubinoTagPostActivity.this.arrayEndRow) {
                    return;
                }
                profileInTagPeopleCell.setProfile((PostTagObject) RubinoTagPostActivity.this.taggedProfiles.get(i - RubinoTagPostActivity.this.arrayStartRow));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (RubinoTagPostActivity.this.arrayEndRow - RubinoTagPostActivity.this.arrayStartRow) + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i < RubinoTagPostActivity.this.arrayStartRow || i >= RubinoTagPostActivity.this.arrayEndRow) ? 0 : 1;
        }
    }

    public void searchText(String str) {
        String str2 = this.lastSearchedText;
        if (str2 == null || !str2.equals(str)) {
            this.lastSearchedText = str;
            this.searchesInProgress = true;
            loadData(str, true);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.showSearch) {
            toggleSearchingMode(false);
            PostInTagPeopleView postInTagView = getPostInTagView();
            if (postInTagView != null) {
                postInTagView.clearEmptyTags();
            }
            return false;
        }
        clearTaggedProfilesFromSendingPost();
        return super.onBackPressed();
    }

    private void clearTaggedProfilesFromSendingPost() {
        Iterator<RGHMediaHelper$PhotoEntry> it = this.sendingPost.entryList.iterator();
        while (it.hasNext()) {
            it.next().tempTaggedProfiles.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEmptyTaggedProfileFromSendingPost() {
        Iterator<RGHMediaHelper$PhotoEntry> it = this.sendingPost.entryList.iterator();
        while (it.hasNext()) {
            it.next().tempTaggedProfiles.remove(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleSearchingMode(boolean z) {
        if (this.showSearch == z) {
            return;
        }
        this.showSearch = z;
        if (z) {
            this.lastSearchedText = BuildConfig.FLAVOR;
            this.actionBarSearchView.editText.setText(BuildConfig.FLAVOR);
            this.actionBarSearchView.editText.requestFocus();
            this.searchProfiles.clear();
            AndroidUtilities.showKeyboard(this.actionBarSearchView.editText);
            this.actionBarSearchView.setVisibility(0);
            return;
        }
        AndroidUtilities.hideKeyboard(this.actionBarSearchView.editText);
        this.actionBarSearchView.setVisibility(8);
        if (this.searching) {
            this.searching = false;
            this.listView.setAdapter(this.adapter);
            updateRowsIds();
        }
    }

    void loadData(String str, final boolean z) {
        DisposableObserver<Rubino.ProfileListObject> disposableObserver = this.requestObservable;
        if (disposableObserver != null && !disposableObserver.isDisposed()) {
            this.requestObservable.dispose();
        }
        if (str == null || str.isEmpty()) {
            this.searchesInProgress = false;
            this.searchProfiles.clear();
            this.endReached = true;
            updateRowsIds();
            return;
        }
        DisposableObserver<Rubino.ProfileListObject> disposableObserver2 = (DisposableObserver) RubinoController.getInstance(this.currentAccount).getSearchProfilesForTagObservable(str, z ? null : this.maxId, 50).observeOn(Schedulers.io()).doOnNext(new Consumer() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$loadData$2(z, (Rubino.ProfileListObject) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Rubino.ProfileListObject>() { // from class: ir.resaneh1.iptv.fragment.rubino.RubinoTagPostActivity.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Rubino.ProfileListObject profileListObject) {
                dispose();
                RubinoTagPostActivity.this.searchesInProgress = false;
                RubinoTagPostActivity.this.updateRowsIds();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoTagPostActivity.this.searchesInProgress = false;
                RubinoTagPostActivity.this.lastSearchedText = null;
                RubinoTagPostActivity.this.updateRowsIds();
                dispose();
            }
        });
        this.requestObservable = disposableObserver2;
        this.compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadData$2(boolean z, Rubino.ProfileListObject profileListObject) throws Exception {
        if (profileListObject != null) {
            if (z) {
                this.searchProfiles.clear();
            }
            ArrayList arrayList = new ArrayList();
            RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry = this.currentPhotoEntry;
            if (rGHMediaHelper$PhotoEntry != null && rGHMediaHelper$PhotoEntry.tempTaggedProfiles.size() > 0) {
                Iterator<RubinoProfileObject> it = profileListObject.profiles.iterator();
                while (it.hasNext()) {
                    RubinoProfileObject next = it.next();
                    if (!this.currentPhotoEntry.tempTaggedProfiles.containsKey(next)) {
                        arrayList.add(next);
                    }
                }
            } else {
                arrayList.addAll(profileListObject.profiles);
            }
            int size = arrayList.size();
            if (size > 0) {
                this.searchProfiles.addAll(arrayList);
                this.maxId = ((RubinoProfileObject) arrayList.get(size - 1)).id;
            }
            this.endReached = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsIds() {
        this.postRow = -1;
        this.addTagPeopleRow = -1;
        this.tagAnotherPersonRow = -1;
        this.searchArrayStartRow = -1;
        this.searchArrayEndRow = -1;
        this.noResultRow = -1;
        this.rowCount = 0;
        if (this.searching) {
            updateSearchingRows();
        } else {
            updateNonSearchingRows();
        }
    }

    private void updateNonSearchingRows() {
        if (this.sendingPost != null) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.postRow = i;
            if (entryIsPhoto()) {
                int i2 = this.rowCount;
                this.rowCount = i2 + 1;
                this.addTagPeopleRow = i2;
            } else {
                ArrayList<PostTagObject> arrayList = this.taggedProfiles;
                if (arrayList != null && !arrayList.isEmpty()) {
                    int i3 = this.rowCount;
                    this.rowCount = i3 + 1;
                    this.tagAnotherPersonRow = i3;
                } else {
                    int i4 = this.rowCount;
                    this.rowCount = i4 + 1;
                    this.addTagPeopleRow = i4;
                }
            }
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private void updateSearchingRows() {
        if (this.sendingPost != null) {
            if (!this.searchProfiles.isEmpty()) {
                int i = this.rowCount;
                this.searchArrayStartRow = i;
                int size = i + this.searchProfiles.size();
                this.rowCount = size;
                this.searchArrayEndRow = size;
            }
            if (this.endReached && this.searchProfiles.isEmpty() && !this.searchesInProgress) {
                int i2 = this.rowCount;
                this.rowCount = i2 + 1;
                this.noResultRow = i2;
            }
        }
        ListAdapter listAdapter = this.searchAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private PostInTagPeopleView getPostInTagView() {
        if (this.listView == null) {
            return null;
        }
        for (int i = 0; i < this.listView.getChildCount(); i++) {
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof PostInTagPeopleView) {
                return (PostInTagPeopleView) childAt;
            }
        }
        return null;
    }
}
