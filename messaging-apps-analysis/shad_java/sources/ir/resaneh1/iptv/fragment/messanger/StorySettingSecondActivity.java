package ir.resaneh1.iptv.fragment.messanger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.InstaProfileSettingObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import ir.resaneh1.iptv.model.StorySettingOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class StorySettingSecondActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int allRow;
    private int currentType;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private boolean donePressed;
    private boolean enableAnimation;
    private int followBackRow;
    private int lastCheckedType = -1;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int nobodyRow;
    private String profileID;
    private ContextProgressView progressView;
    private Disposable requestDisposable;
    private int rowCount;
    private int rulesType;
    private int sectionRow;
    private Map<String, Object> settingInput;
    private InstaProfileSettingObject settingObject;

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public StorySettingSecondActivity(int i, InstaProfileSettingObject instaProfileSettingObject, String str) {
        this.rulesType = i;
        this.settingObject = instaProfileSettingObject;
        FragmentType fragmentType = FragmentType.Messenger;
        this.profileID = str;
        this.fragmentName = "PrivacyControlActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
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
        if (this.rulesType == 0) {
            this.actionBar.setTitle(LocaleController.getString(R.string.storyAllowReply));
        }
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    StorySettingSecondActivity.this.finishFragment();
                    return;
                }
                if (i != 1 || StorySettingSecondActivity.this.getParentActivity() == null || StorySettingSecondActivity.this.donePressed) {
                    return;
                }
                if (StorySettingSecondActivity.this.settingInput != null) {
                    StorySettingSecondActivity.this.donePressed = true;
                    StorySettingSecondActivity.this.callSetObject();
                } else {
                    StorySettingSecondActivity.this.finishFragment();
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        this.doneItem = actionBarMenuItemAddItemWithWidth;
        actionBarMenuItemAddItemWithWidth.setVisibility(0);
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        this.doneItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1.0f));
        this.progressView.setVisibility(4);
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        applyCurrentSettings();
        updateRows();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.String] */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        int i2;
        SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum;
        int i3 = this.nobodyRow;
        if (i == i3 || i == this.allRow || i == this.followBackRow) {
            int i4 = this.currentType;
            if (i == i3) {
                i2 = 1;
            } else if (i == this.allRow) {
                i2 = 0;
            } else {
                i2 = i == this.followBackRow ? 2 : i4;
            }
            if (i2 == i4) {
                return;
            }
            this.enableAnimation = true;
            this.lastCheckedType = i4;
            this.currentType = i2;
            SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum2 = null;
            if (this.rulesType == 0) {
                ?? Name = InstaProfileSettingObject.UpdatedParameterEnum.story_allow_reply.name();
                int i5 = this.currentType;
                if (i5 == 0) {
                    storyAllowReplyEnum2 = SetStorySettingInput.StoryAllowReplyEnum.AllFollowers;
                } else if (i5 == 1) {
                    storyAllowReplyEnum2 = SetStorySettingInput.StoryAllowReplyEnum.Off;
                } else if (i5 == 2) {
                    storyAllowReplyEnum2 = SetStorySettingInput.StoryAllowReplyEnum.FollowersFollowBack;
                }
                SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum3 = storyAllowReplyEnum2;
                storyAllowReplyEnum2 = Name;
                storyAllowReplyEnum = storyAllowReplyEnum3;
            } else {
                storyAllowReplyEnum = null;
            }
            if (storyAllowReplyEnum2 != null && storyAllowReplyEnum != null) {
                if (this.settingInput == null) {
                    this.settingInput = new HashMap();
                }
                this.settingInput.put(storyAllowReplyEnum2, storyAllowReplyEnum);
            }
            updateRows();
        }
    }

    private void applyCurrentSettings() {
        InstaProfileSettingObject instaProfileSettingObject = this.settingObject;
        if (instaProfileSettingObject != null && this.rulesType == 0) {
            SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum = instaProfileSettingObject.story_allow_reply;
            if (storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.AllFollowers) {
                this.currentType = 0;
            } else if (storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.Off) {
                this.currentType = 1;
            } else if (storyAllowReplyEnum == SetStorySettingInput.StoryAllowReplyEnum.FollowersFollowBack) {
                this.currentType = 2;
            }
        }
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.sectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.allRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.followBackRow = i2;
        this.rowCount = i3 + 1;
        this.nobodyRow = i3;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.lastCheckedType = -1;
        this.enableAnimation = false;
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == StorySettingSecondActivity.this.nobodyRow || adapterPosition == StorySettingSecondActivity.this.allRow || adapterPosition == StorySettingSecondActivity.this.followBackRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return StorySettingSecondActivity.this.rowCount;
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
                textSettingsCell = new RadioCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r7, int r8) {
            /*
                r6 = this;
                int r0 = r7.getItemViewType()
                if (r0 == 0) goto Lcf
                r1 = 1
                if (r0 == r1) goto Lc5
                r2 = 2
                if (r0 == r2) goto La6
                r3 = 3
                if (r0 == r3) goto L11
                goto Ld3
            L11:
                android.view.View r7 = r7.itemView
                org.rbmain.ui.Cells.RadioCell r7 = (org.rbmain.ui.Cells.RadioCell) r7
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$400(r0)
                r3 = 0
                if (r8 != r0) goto L36
                r8 = 2131891316(0x7f121474, float:1.9417349E38)
                java.lang.String r0 = "RubinoEveryone"
                java.lang.String r8 = org.rbmain.messenger.LocaleController.getString(r0, r8)
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$900(r0)
                if (r0 != 0) goto L31
                r0 = 1
                goto L32
            L31:
                r0 = 0
            L32:
                r7.setText(r8, r0, r1)
                goto L81
            L36:
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$500(r0)
                if (r8 != r0) goto L60
                r8 = 2131893151(0x7f121b9f, float:1.942107E38)
                java.lang.String r8 = org.rbmain.messenger.LocaleController.getString(r8)
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$900(r0)
                if (r0 != r2) goto L4f
                r0 = 1
                goto L50
            L4f:
                r0 = 0
            L50:
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r4 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r4 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$300(r4)
                r5 = -1
                if (r4 == r5) goto L5b
                r4 = 1
                goto L5c
            L5b:
                r4 = 0
            L5c:
                r7.setText(r8, r0, r4)
                goto L82
            L60:
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$300(r0)
                if (r8 != r0) goto L81
                r8 = 2131891324(0x7f12147c, float:1.9417365E38)
                java.lang.String r0 = "RubinoNoOne"
                java.lang.String r8 = org.rbmain.messenger.LocaleController.getString(r0, r8)
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$900(r0)
                if (r0 != r1) goto L7b
                r0 = 1
                goto L7c
            L7b:
                r0 = 0
            L7c:
                r7.setText(r8, r0, r3)
                r2 = 1
                goto L82
            L81:
                r2 = 0
            L82:
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$900(r8)
                if (r8 != r2) goto L94
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                boolean r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$1000(r8)
                r7.setChecked(r3, r8)
                goto Ld3
            L94:
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$1100(r8)
                if (r8 != r2) goto Ld3
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                boolean r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$1000(r8)
                r7.setChecked(r1, r8)
                goto Ld3
            La6:
                android.view.View r7 = r7.itemView
                org.rbmain.ui.Cells.HeaderCell r7 = (org.rbmain.ui.Cells.HeaderCell) r7
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$700(r0)
                if (r8 != r0) goto Ld3
                ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.this
                int r8 = ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.access$800(r8)
                if (r8 != 0) goto Ld3
                r8 = 2131893732(0x7f121de4, float:1.9422249E38)
                java.lang.String r8 = org.rbmain.messenger.LocaleController.getString(r8)
                r7.setText(r8)
                goto Ld3
            Lc5:
                android.view.View r7 = r7.itemView
                org.rbmain.ui.Cells.TextInfoPrivacyCell r7 = (org.rbmain.ui.Cells.TextInfoPrivacyCell) r7
                java.lang.String r8 = ""
                r7.setText(r8)
                goto Ld3
            Lcf:
                android.view.View r7 = r7.itemView
                org.rbmain.ui.Cells.TextSettingsCell r7 = (org.rbmain.ui.Cells.TextSettingsCell) r7
            Ld3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == StorySettingSecondActivity.this.sectionRow) {
                return 2;
            }
            return (i == StorySettingSecondActivity.this.allRow || i == StorySettingSecondActivity.this.followBackRow || i == StorySettingSecondActivity.this.nobodyRow) ? 3 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSetObject() {
        showEditDoneProgress(true);
        Disposable disposable = this.requestDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Map<String, Object> map = this.settingInput;
        if (map == null || map.isEmpty()) {
            return;
        }
        SetStorySettingInput setStorySettingInput = new SetStorySettingInput();
        setStorySettingInput.profile_id = this.profileID;
        Map<String, Object> map2 = this.settingInput;
        InstaProfileSettingObject.UpdatedParameterEnum updatedParameterEnum = InstaProfileSettingObject.UpdatedParameterEnum.story_allow_reply;
        SetStorySettingInput.StoryAllowReplyEnum storyAllowReplyEnum = (SetStorySettingInput.StoryAllowReplyEnum) map2.get(updatedParameterEnum.name());
        setStorySettingInput.story_allow_reply = storyAllowReplyEnum;
        if (storyAllowReplyEnum == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        setStorySettingInput.updated_parameters = hashSet;
        hashSet.add(updatedParameterEnum);
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().setStorySetting(setStorySettingInput).subscribeWith(new DisposableObserver<MessangerOutput<StorySettingOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<StorySettingOutput> messangerOutput) {
                StorySettingSecondActivity.this.showEditDoneProgress(false);
                StorySettingOutput storySettingOutput = messangerOutput.data;
                if (storySettingOutput != null && storySettingOutput.profile_setting != null) {
                    StorySettingSecondActivity.this.settingObject = storySettingOutput.profile_setting;
                    AppRubinoPreferences.getInstance(((BaseFragment) StorySettingSecondActivity.this).currentAccount).setProfileSetting(StorySettingSecondActivity.this.settingObject);
                }
                StorySettingSecondActivity.this.finishFragment();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                StorySettingSecondActivity.this.showEditDoneProgress(false);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean z) {
        if (this.doneItem == null) {
            return;
        }
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.doneItemAnimation = new AnimatorSet();
        if (z) {
            this.progressView.setVisibility(0);
            this.doneItem.setEnabled(false);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleX", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleY", 0.1f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "alpha", 0.0f), ObjectAnimator.ofFloat(this.progressView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.progressView, "alpha", 1.0f));
        } else {
            this.doneItem.getImageView().setVisibility(0);
            this.doneItem.setEnabled(true);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.progressView, "alpha", 0.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "alpha", 1.0f));
        }
        this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.messanger.StorySettingSecondActivity.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StorySettingSecondActivity.this.doneItemAnimation == null || !StorySettingSecondActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    StorySettingSecondActivity.this.progressView.setVisibility(4);
                } else {
                    StorySettingSecondActivity.this.doneItem.getImageView().setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (StorySettingSecondActivity.this.doneItemAnimation == null || !StorySettingSecondActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                StorySettingSecondActivity.this.doneItemAnimation = null;
            }
        });
        this.doneItemAnimation.setDuration(150L);
        this.doneItemAnimation.start();
    }
}
