package ir.resaneh1.iptv.fragment.messanger;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.InstaProfileSettingObject;
import ir.resaneh1.iptv.model.SetStorySettingInput;
import java.util.Map;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
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
public class LiveSettingActivity extends BaseFragment {
    private int currentType;
    private ActionBarMenuItem doneItem;
    private boolean donePressed;
    private boolean enableAnimation;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int liveExternal;
    private int liveInternal;
    private ContextProgressView progressView;
    private int rowCount;
    private int rulesType;
    private int sectionRow;
    private Map<String, Object> settingInput;
    private InstaProfileSettingObject settingObject;
    private int lastCheckedType = -1;
    private int liveBroadcastInfo = -1;

    public LiveSettingActivity() {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "LiveSettingActivity";
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
        this.currentType = getAppPreferences().getBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false) ? 1 : 0;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString(R.string.liveSetting));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    LiveSettingActivity.this.finishFragment();
                    return;
                }
                if (i != 1 || LiveSettingActivity.this.getParentActivity() == null || LiveSettingActivity.this.donePressed) {
                    return;
                }
                if (LiveSettingActivity.this.settingInput != null) {
                    LiveSettingActivity.this.donePressed = true;
                } else {
                    LiveSettingActivity.this.finishFragment();
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity$$ExternalSyntheticLambda0
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
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        int i2 = this.liveInternal;
        if (i == i2 || i == this.liveExternal) {
            int i3 = this.currentType;
            if (i == i2) {
                getAppPreferences().setBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false);
                i3 = 0;
            } else if (i == this.liveExternal) {
                getAppPreferences().setBoolean(AppPreferences.Key.LiveBroadCastExternalMode, true);
                i3 = 1;
            }
            int i4 = this.currentType;
            if (i3 == i4) {
                return;
            }
            this.enableAnimation = true;
            this.lastCheckedType = i4;
            this.currentType = i3;
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
        this.liveInternal = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.liveExternal = i2;
        this.rowCount = i3 + 1;
        this.liveBroadcastInfo = i3;
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
            return adapterPosition == LiveSettingActivity.this.liveInternal || adapterPosition == LiveSettingActivity.this.liveExternal;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveSettingActivity.this.rowCount;
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

        /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r5, int r6) {
            /*
                r4 = this;
                int r0 = r5.getItemViewType()
                if (r0 == 0) goto Lb3
                r1 = 1
                if (r0 == r1) goto L97
                r2 = 2
                if (r0 == r2) goto L78
                r3 = 3
                if (r0 == r3) goto L11
                goto Lb7
            L11:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.RadioCell r5 = (org.rbmain.ui.Cells.RadioCell) r5
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$200(r0)
                r3 = 0
                if (r6 != r0) goto L34
                r6 = 2131893236(0x7f121bf4, float:1.9421243E38)
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r6)
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$800(r0)
                if (r0 != 0) goto L2f
                r0 = 1
                goto L30
            L2f:
                r0 = 0
            L30:
                r5.setText(r6, r0, r1)
                goto L53
            L34:
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$300(r0)
                if (r6 != r0) goto L53
                r6 = 2131893235(0x7f121bf3, float:1.942124E38)
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r6)
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$800(r0)
                if (r0 != r2) goto L4d
                r0 = 1
                goto L4e
            L4d:
                r0 = 0
            L4e:
                r5.setText(r6, r0, r3)
                r6 = 1
                goto L54
            L53:
                r6 = 0
            L54:
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$800(r0)
                if (r0 != r6) goto L66
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                boolean r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$900(r6)
                r5.setChecked(r3, r6)
                goto Lb7
            L66:
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$1000(r0)
                if (r0 != r6) goto Lb7
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                boolean r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$900(r6)
                r5.setChecked(r1, r6)
                goto Lb7
            L78:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.HeaderCell r5 = (org.rbmain.ui.Cells.HeaderCell) r5
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$600(r0)
                if (r6 != r0) goto Lb7
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r6 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$700(r6)
                if (r6 != 0) goto Lb7
                r6 = 2131893234(0x7f121bf2, float:1.9421239E38)
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r6)
                r5.setText(r6)
                goto Lb7
            L97:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.TextInfoPrivacyCell r5 = (org.rbmain.ui.Cells.TextInfoPrivacyCell) r5
                java.lang.String r0 = ""
                r5.setText(r0)
                ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.this
                int r0 = ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.access$500(r0)
                if (r6 != r0) goto Lb7
                r6 = 2131893229(0x7f121bed, float:1.9421229E38)
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r6)
                r5.setText(r6)
                goto Lb7
            Lb3:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.TextSettingsCell r5 = (org.rbmain.ui.Cells.TextSettingsCell) r5
            Lb7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.messanger.LiveSettingActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == LiveSettingActivity.this.sectionRow) {
                return 2;
            }
            if (i == LiveSettingActivity.this.liveInternal || i == LiveSettingActivity.this.liveExternal) {
                return 3;
            }
            return i == LiveSettingActivity.this.liveBroadcastInfo ? 1 : 0;
        }
    }
}
