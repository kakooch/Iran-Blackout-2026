package ir.resaneh1.iptv.fragment.messanger;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidMessenger.utilites.AppFavorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.InstaGetProfileInfoInput;
import ir.resaneh1.iptv.model.InstaGetProfileInfoOutput;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaUpdateProfileInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import java.util.HashSet;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class RubinoSettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private Context context;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private int greyRow1;
    private int greyRow2;
    private int greyRow3;
    private int greyRow4;
    private int greyRow5;
    private RecyclerListView listView;
    private int loadingRow;
    private int messageInfoRow;
    private int messageRow;
    private int notificationInfoRow;
    private int notificationRow;
    private int privatePageInfoRow;
    private int privatePageRow;
    private boolean profileIsLoaded;
    InstaProfileObject profileObject;
    private ContextProgressView progressView;
    private int rowCount = 0;
    private int tagPostInfoRow;
    private int tagPostRow;

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    public RubinoSettingsActivity(InstaProfileObject instaProfileObject) {
        FragmentType fragmentType = FragmentType.Rubino;
        this.profileObject = instaProfileObject;
        this.profileIsLoaded = false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRowsIds() {
        this.greyRow1 = -1;
        this.greyRow2 = -1;
        this.greyRow4 = -1;
        this.greyRow5 = -1;
        this.greyRow3 = -1;
        this.tagPostRow = -1;
        this.tagPostInfoRow = -1;
        this.rowCount = 0;
        if (this.profileIsLoaded) {
            int i = 0 + 1;
            this.rowCount = i;
            this.privatePageRow = 0;
            int i2 = i + 1;
            this.rowCount = i2;
            this.privatePageInfoRow = i;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.messageRow = i2;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.messageInfoRow = i3;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.notificationRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.notificationInfoRow = i5;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.tagPostRow = i6;
            this.rowCount = i7 + 1;
            this.tagPostInfoRow = i7;
            this.loadingRow = -1;
        } else {
            this.privatePageRow = -1;
            this.privatePageInfoRow = -1;
            this.messageRow = -1;
            this.messageInfoRow = -1;
            this.notificationRow = -1;
            this.notificationInfoRow = -1;
            this.rowCount = 0 + 1;
            this.loadingRow = 0;
        }
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.context = context;
        this.actionBar.setBackButtonImage(R.drawable.ic_arrow_back_white);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.formatString(R.string.RubinoSettings, LocaleController.getString(AppFavorUtils.rubinoNameId)));
        this.actionBar.getTitleTextView().setPadding(0, 0, 0, 0);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    RubinoSettingsActivity.this.finishFragment();
                }
            }
        });
        this.doneItem = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.progressView = contextProgressView;
        this.doneItem.addView(contextProgressView, LayoutHelper.createFrame(-1, -1.0f));
        this.progressView.setVisibility(4);
        this.doneItem.getImageView().setVisibility(4);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$0(view, i);
            }
        });
        updateRowsIds();
        callGetMyProfile();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view, int i) {
        if (getParentActivity() == null) {
            return;
        }
        if (view instanceof TextCheckCell) {
            TextCheckCell textCheckCell = (TextCheckCell) view;
            textCheckCell.setChecked(!textCheckCell.isChecked());
            InstaUpdateProfileInput instaUpdateProfileInput = new InstaUpdateProfileInput();
            instaUpdateProfileInput.profile_id = this.profileObject.id;
            if (i == this.privatePageRow) {
                if (textCheckCell.isChecked()) {
                    instaUpdateProfileInput.profile_status = InstaProfileObject.ProfileStatusEnum.Private;
                } else {
                    instaUpdateProfileInput.profile_status = InstaProfileObject.ProfileStatusEnum.Public;
                }
            } else if (i == this.messageRow) {
                instaUpdateProfileInput.is_message_allowed = Boolean.valueOf(textCheckCell.isChecked());
            } else if (i == this.notificationRow) {
                instaUpdateProfileInput.is_mute = Boolean.valueOf(!textCheckCell.isChecked());
            }
            callUpdate(instaUpdateProfileInput, i);
            return;
        }
        if (view instanceof TextSettingsCell) {
            showDialog();
        }
    }

    private void callUpdate(InstaUpdateProfileInput instaUpdateProfileInput, final int i) {
        showEditDoneProgress(true);
        ApiRequestMessanger.getInstance(this.currentAccount).instaUpdateProfile(instaUpdateProfileInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity.3
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                RubinoSettingsActivity.this.showEditDoneProgress(false);
                InstaProfileObject instaProfileObject = ((InstaGetProfileInfoOutput) obj).profile;
                if (instaProfileObject != null) {
                    RubinoSettingsActivity.this.profileObject = instaProfileObject;
                    HashSet hashSet = new HashSet();
                    if (i == RubinoSettingsActivity.this.privatePageRow) {
                        hashSet.add(RubinoProfileObject.UpdatedParameterEnum.status);
                    }
                    if (i == RubinoSettingsActivity.this.messageRow) {
                        hashSet.add(RubinoProfileObject.UpdatedParameterEnum.is_message_allowed);
                    }
                    if (i == RubinoSettingsActivity.this.notificationRow) {
                        hashSet.add(RubinoProfileObject.UpdatedParameterEnum.is_mute);
                    }
                    if (i == RubinoSettingsActivity.this.tagPostRow) {
                        hashSet.add(RubinoProfileObject.UpdatedParameterEnum.tag_post);
                        RubinoSettingsActivity.this.updateRowsIds();
                    }
                    RubinoSettingsActivity.this.getRubinoController().onMyRubinoProfileUpdated(RubinoProfileObject.createFromOldObject(RubinoSettingsActivity.this.profileObject), hashSet);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                RubinoSettingsActivity.this.showEditDoneProgress(false);
                if (RubinoSettingsActivity.this.adapter != null) {
                    RubinoSettingsActivity.this.adapter.notifyDataSetChanged();
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                ToastiLikeSnack.showL(RubinoSettingsActivity.this.context, "خطا در تغییر تنظیمات");
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        updateRowsIds();
    }

    void showDialog() {
        new AlertDialog.Builder(getParentActivity()).setTitle(LocaleController.getString(R.string.rubinoTagPostSettingTitle)).setItems(new String[]{getStringByPostType(RubinoProfileObject.TagPostEnum.Everyone), getStringByPostType(RubinoProfileObject.TagPostEnum.NoOne), getStringByPostType(RubinoProfileObject.TagPostEnum.Following)}, new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showDialog$1(dialogInterface, i);
            }
        }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$1(DialogInterface dialogInterface, int i) {
        InstaUpdateProfileInput instaUpdateProfileInput = new InstaUpdateProfileInput();
        instaUpdateProfileInput.profile_id = this.profileObject.id;
        if (i == 0) {
            instaUpdateProfileInput.tag_post = RubinoProfileObject.TagPostEnum.Everyone;
        } else if (i == 1) {
            instaUpdateProfileInput.tag_post = RubinoProfileObject.TagPostEnum.NoOne;
        } else if (i == 2) {
            instaUpdateProfileInput.tag_post = RubinoProfileObject.TagPostEnum.Following;
        }
        callUpdate(instaUpdateProfileInput, this.tagPostRow);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == RubinoSettingsActivity.this.privatePageRow || adapterPosition == RubinoSettingsActivity.this.messageRow || adapterPosition == RubinoSettingsActivity.this.notificationRow;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return RubinoSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View headerCell;
            if (i == 0) {
                headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                headerCell = new TextCheckCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 2) {
                headerCell = new ShadowSectionCell(this.mContext);
            } else if (i == 3) {
                headerCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 4) {
                headerCell = new LoadingCell(this.mContext);
            } else {
                headerCell = new TextSettingsCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType != 3) {
                    if (itemViewType == 4) {
                        new LoadingCell(this.mContext).setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        return;
                    } else {
                        if (itemViewType != 5) {
                            return;
                        }
                        TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                        String string = LocaleController.getString(R.string.rubinoTagPostSettingTitle);
                        RubinoSettingsActivity rubinoSettingsActivity = RubinoSettingsActivity.this;
                        textSettingsCell.setTextAndValue(string, rubinoSettingsActivity.getStringByPostType(rubinoSettingsActivity.profileObject.tag_post), false);
                        return;
                    }
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i != RubinoSettingsActivity.this.privatePageInfoRow) {
                    if (i == RubinoSettingsActivity.this.messageInfoRow) {
                        textInfoPrivacyCell.setText(LocaleController.formatString(R.string.RubinoAccountPrivacyPublic, LocaleController.getString(AppFavorUtils.rubinoNameId)));
                    } else if (i == RubinoSettingsActivity.this.notificationInfoRow) {
                        textInfoPrivacyCell.setText(LocaleController.formatString(R.string.RubinoAccountPrivacyDefault, LocaleController.getString(AppFavorUtils.rubinoNameId)));
                    } else if (i == RubinoSettingsActivity.this.tagPostInfoRow) {
                        textInfoPrivacyCell.setText(LocaleController.formatString(R.string.rubinoTagPostSettingInfo, LocaleController.getString(AppFavorUtils.rubinoNameId)));
                    }
                } else {
                    textInfoPrivacyCell.setText(LocaleController.getString(R.string.request_follow_for_access_others));
                }
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                return;
            }
            TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
            if (i != RubinoSettingsActivity.this.privatePageRow) {
                if (i != RubinoSettingsActivity.this.messageRow) {
                    if (i == RubinoSettingsActivity.this.notificationRow) {
                        if (FlavorHelper.isShad()) {
                            String string2 = LocaleController.formatString(R.string.RubinoGetNotifications, LocaleController.getString(R.string.RubinoNameFarsi)).toString();
                            InstaProfileObject instaProfileObject = RubinoSettingsActivity.this.profileObject;
                            textCheckCell.setTextAndCheck(string2, instaProfileObject == null || !instaProfileObject.is_mute, true);
                            return;
                        } else {
                            String string3 = LocaleController.formatString(R.string.RubinoGetNotifications, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString();
                            InstaProfileObject instaProfileObject2 = RubinoSettingsActivity.this.profileObject;
                            textCheckCell.setTextAndCheck(string3, instaProfileObject2 == null || !instaProfileObject2.is_mute, true);
                            return;
                        }
                    }
                    return;
                }
                String string4 = LocaleController.getString(R.string.recieve_private_message);
                InstaProfileObject instaProfileObject3 = RubinoSettingsActivity.this.profileObject;
                textCheckCell.setTextAndCheck(string4, instaProfileObject3 == null || instaProfileObject3.is_message_allowed, true);
                return;
            }
            String string5 = LocaleController.getString(R.string.private_page);
            InstaProfileObject instaProfileObject4 = RubinoSettingsActivity.this.profileObject;
            textCheckCell.setTextAndCheck(string5, instaProfileObject4 == null || instaProfileObject4.isPrivate(), true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == RubinoSettingsActivity.this.privatePageRow || i == RubinoSettingsActivity.this.messageRow || i == RubinoSettingsActivity.this.notificationRow) {
                return 1;
            }
            if (i == RubinoSettingsActivity.this.greyRow1 || i == RubinoSettingsActivity.this.greyRow2 || i == RubinoSettingsActivity.this.greyRow3 || i == RubinoSettingsActivity.this.greyRow4 || i == RubinoSettingsActivity.this.greyRow5) {
                return 2;
            }
            if (i == RubinoSettingsActivity.this.notificationInfoRow || i == RubinoSettingsActivity.this.messageInfoRow || i == RubinoSettingsActivity.this.privatePageInfoRow || i == RubinoSettingsActivity.this.tagPostInfoRow) {
                return 3;
            }
            if (i == RubinoSettingsActivity.this.loadingRow) {
                return 4;
            }
            return i == RubinoSettingsActivity.this.tagPostRow ? 5 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getStringByPostType(RubinoProfileObject.TagPostEnum tagPostEnum) {
        if (tagPostEnum == RubinoProfileObject.TagPostEnum.Everyone) {
            return LocaleController.getString(R.string.RubinoEveryone);
        }
        if (tagPostEnum == RubinoProfileObject.TagPostEnum.NoOne) {
            return LocaleController.getString(R.string.RubinoNoOne);
        }
        return tagPostEnum == RubinoProfileObject.TagPostEnum.Following ? LocaleController.getString(R.string.RubinoFollowing) : BuildConfig.FLAVOR;
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
            this.doneItem.setEnabled(true);
            this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.progressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.progressView, "alpha", 0.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleX", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "scaleY", 1.0f), ObjectAnimator.ofFloat(this.doneItem.getImageView(), "alpha", 1.0f));
        }
        this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (RubinoSettingsActivity.this.doneItemAnimation == null || !RubinoSettingsActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    RubinoSettingsActivity.this.progressView.setVisibility(4);
                } else {
                    RubinoSettingsActivity.this.doneItem.getImageView().setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (RubinoSettingsActivity.this.doneItemAnimation == null || !RubinoSettingsActivity.this.doneItemAnimation.equals(animator)) {
                    return;
                }
                RubinoSettingsActivity.this.doneItemAnimation = null;
            }
        });
        this.doneItemAnimation.setDuration(150L);
        this.doneItemAnimation.start();
    }

    private void callGetMyProfile() {
        if (this.profileObject == null) {
            return;
        }
        InstaGetProfileInfoInput instaGetProfileInfoInput = new InstaGetProfileInfoInput();
        String str = this.profileObject.id;
        instaGetProfileInfoInput.profile_id = str;
        instaGetProfileInfoInput.target_profile_id = str;
        ApiRequestMessanger.getInstance(this.currentAccount).instaGetMyProfileInfo(instaGetProfileInfoInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.messanger.RubinoSettingsActivity.5
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                InstaProfileObject instaProfileObject = ((InstaGetProfileInfoOutput) obj).profile;
                if (instaProfileObject != null) {
                    RubinoSettingsActivity rubinoSettingsActivity = RubinoSettingsActivity.this;
                    rubinoSettingsActivity.profileObject = instaProfileObject;
                    rubinoSettingsActivity.profileIsLoaded = true;
                    RubinoSettingsActivity.this.updateRowsIds();
                }
            }
        });
    }
}
