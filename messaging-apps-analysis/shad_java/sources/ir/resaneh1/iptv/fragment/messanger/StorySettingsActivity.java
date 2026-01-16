package ir.resaneh1.iptv.fragment.messanger;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.GetStorySettingInput;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaProfileSettingObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import ir.resaneh1.iptv.model.StorySettingOutput;
import java.util.HashSet;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class StorySettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    ListAdapter listAdapter;
    RecyclerListView listView;
    private String profileId;
    int rowCount;
    int saveGalleryRow;
    private InstaProfileSettingObject settingObject;
    int storyReplyRow;
    int storySectionRow;

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public StorySettingsActivity(InstaProfileObject instaProfileObject) {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "StorySettingsActivity";
        this.profileId = instaProfileObject != null ? instaProfileObject.id : null;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getObject();
        updateRows();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.arrow_back_grey);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("StorySetting", R.string.StorySetting));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    StorySettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        String str;
        if (view.isEnabled() && (str = this.profileId) != null) {
            if (i == this.storyReplyRow) {
                InstaProfileSettingObject instaProfileSettingObject = this.settingObject;
                if (instaProfileSettingObject == null) {
                    return;
                }
                presentFragment(new StorySettingSecondActivity(0, instaProfileSettingObject, str));
                return;
            }
            if (i == this.saveGalleryRow && (view instanceof TextCheckCell)) {
                TextCheckCell textCheckCell = (TextCheckCell) view;
                textCheckCell.setChecked(!textCheckCell.isChecked());
                SetStorySettingInput setStorySettingInput = new SetStorySettingInput();
                setStorySettingInput.profile_id = this.profileId;
                setStorySettingInput.story_save_to_gallery = textCheckCell.isChecked();
                InstaProfileSettingObject instaProfileSettingObject2 = this.settingObject;
                if (instaProfileSettingObject2 != null) {
                    instaProfileSettingObject2.story_save_to_gallery = textCheckCell.isChecked();
                }
                HashSet hashSet = new HashSet();
                setStorySettingInput.updated_parameters = hashSet;
                hashSet.add(InstaProfileSettingObject.UpdatedParameterEnum.story_save_to_gallery);
                this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().setStorySetting(setStorySettingInput).subscribeWith(new DisposableObserver<MessangerOutput<StorySettingOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity.3
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(MessangerOutput<StorySettingOutput> messangerOutput) {
                        StorySettingOutput storySettingOutput;
                        if (messangerOutput == null || (storySettingOutput = messangerOutput.data) == null || storySettingOutput.profile_setting == null) {
                            return;
                        }
                        StorySettingsActivity.this.settingObject = storySettingOutput.profile_setting;
                        AppRubinoPreferences.getInstance(((BaseFragment) StorySettingsActivity.this).currentAccount).setProfileSetting(StorySettingsActivity.this.settingObject);
                        StorySettingsActivity.this.listAdapter.notifyDataSetChanged();
                    }
                }));
            }
        }
    }

    void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.storySectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.storyReplyRow = i;
        this.rowCount = i2 + 1;
        this.saveGalleryRow = i2;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    String formatRulesString(SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum) {
        if (storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.Off) {
            return LocaleController.getString("RubinoNoOne", R.string.RubinoNoOne);
        }
        if (storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.AllFollowers) {
            return LocaleController.getString("RubinoEveryone", R.string.RubinoEveryone);
        }
        return storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.FollowersFollowBack ? LocaleController.getString(R.string.followBack) : BuildConfig.FLAVOR;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.listAdapter != null) {
            this.settingObject = AppRubinoPreferences.getInstance(this.currentAccount).getProfileSettingObject();
            this.listAdapter.notifyDataSetChanged();
        }
    }

    class ListAdapter extends RecyclerListView.SelectionAdapter {
        Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            StorySettingsActivity storySettingsActivity = StorySettingsActivity.this;
            return adapterPosition == storySettingsActivity.storyReplyRow || adapterPosition == storySettingsActivity.saveGalleryRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StorySettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            if (i == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                textSettingsCell = new TextCheckCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                StorySettingsActivity storySettingsActivity = StorySettingsActivity.this;
                if (i == storySettingsActivity.storyReplyRow) {
                    if (storySettingsActivity.settingObject != null && StorySettingsActivity.this.settingObject.story_allow_reply != null) {
                        StorySettingsActivity storySettingsActivity2 = StorySettingsActivity.this;
                        string = storySettingsActivity2.formatRulesString(storySettingsActivity2.settingObject.story_allow_reply);
                    } else {
                        string = LocaleController.getString("Loading", R.string.Loading);
                    }
                    textSettingsCell.setTextAndValue(LocaleController.getString(R.string.storyAllowReply), string, true);
                    return;
                }
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i == StorySettingsActivity.this.storySectionRow) {
                    headerCell.setText(LocaleController.getString("Story", R.string.Story));
                    return;
                }
                return;
            }
            if (itemViewType != 3) {
                return;
            }
            TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
            if (i == StorySettingsActivity.this.saveGalleryRow) {
                textCheckCell.setTextAndCheck(LocaleController.getString(R.string.saveToGallery), StorySettingsActivity.this.settingObject != null ? StorySettingsActivity.this.settingObject.story_save_to_gallery : false, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            StorySettingsActivity storySettingsActivity = StorySettingsActivity.this;
            if (i == storySettingsActivity.storyReplyRow) {
                return 0;
            }
            if (i == storySettingsActivity.saveGalleryRow) {
                return 3;
            }
            return i == storySettingsActivity.storySectionRow ? 2 : 0;
        }
    }

    private void getObject() {
        if (this.profileId == null) {
            return;
        }
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getStorySetting(new GetStorySettingInput(this.profileId)).subscribeWith(new DisposableObserver<MessangerOutput<StorySettingOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingsActivity.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<StorySettingOutput> messangerOutput) {
                StorySettingOutput storySettingOutput;
                if (messangerOutput == null || (storySettingOutput = messangerOutput.data) == null) {
                    return;
                }
                StorySettingsActivity.this.settingObject = storySettingOutput.profile_setting;
                AppRubinoPreferences.getInstance(((BaseFragment) StorySettingsActivity.this).currentAccount).setProfileSetting(StorySettingsActivity.this.settingObject);
                ListAdapter listAdapter = StorySettingsActivity.this.listAdapter;
                if (listAdapter != null) {
                    listAdapter.notifyDataSetChanged();
                }
            }
        }));
    }
}
