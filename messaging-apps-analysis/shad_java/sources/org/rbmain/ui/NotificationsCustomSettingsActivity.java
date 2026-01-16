package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsSettingsFacade;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.NotificationsCheckCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextColorCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.NotificationsSettingsActivity;
import org.rbmain.ui.ProfileNotificationsActivity;

/* loaded from: classes4.dex */
public class NotificationsCustomSettingsActivity extends BaseFragment {
    private ListAdapter adapter;
    private int alertRow;
    private int alertSection2Row;
    private AnimatorSet animatorSet;
    private int currentType;
    private int deleteAllRow;
    private int deleteAllSectionRow;
    private EmptyTextProgressView emptyView;
    private ArrayList<NotificationsSettingsActivity.NotificationException> exceptions;
    private int exceptionsAddRow;
    private HashMap<Long, NotificationsSettingsActivity.NotificationException> exceptionsDict;
    private int exceptionsEndRow;
    private int exceptionsSection2Row;
    private int exceptionsStartRow;
    private int groupSection2Row;
    private RecyclerListView listView;
    private int messageLedRow;
    private int messagePopupNotificationRow;
    private int messagePriorityRow;
    private int messageSectionRow;
    private int messageSoundRow;
    private int messageVibrateRow;
    private int previewRow;
    private int rowCount;
    private SearchAdapter searchAdapter;
    private boolean searchWas;
    private boolean searching;

    public NotificationsCustomSettingsActivity(int i, ArrayList<NotificationsSettingsActivity.NotificationException> arrayList) {
        this(i, arrayList, false);
    }

    public NotificationsCustomSettingsActivity(int i, ArrayList<NotificationsSettingsActivity.NotificationException> arrayList, boolean z) {
        this.rowCount = 0;
        this.exceptionsDict = new HashMap<>();
        this.currentType = i;
        this.exceptions = arrayList;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationsSettingsActivity.NotificationException notificationException = this.exceptions.get(i2);
            this.exceptionsDict.put(Long.valueOf(notificationException.did), notificationException);
        }
        if (z) {
            loadExceptions();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        updateRows(true);
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.searching = false;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.currentType == -1) {
            this.actionBar.setTitle(LocaleController.getString("NotificationsExceptions", R.string.NotificationsExceptions));
        } else {
            this.actionBar.setTitle(LocaleController.getString("Notifications", R.string.Notifications));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    NotificationsCustomSettingsActivity.this.finishFragment();
                }
            }
        });
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList = this.exceptions;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity.2
                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchExpand() {
                    NotificationsCustomSettingsActivity.this.searching = true;
                    NotificationsCustomSettingsActivity.this.emptyView.setShowAtCenter(true);
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onSearchCollapse() {
                    NotificationsCustomSettingsActivity.this.searchAdapter.searchDialogs(null);
                    NotificationsCustomSettingsActivity.this.searching = false;
                    NotificationsCustomSettingsActivity.this.searchWas = false;
                    NotificationsCustomSettingsActivity.this.emptyView.setText(LocaleController.getString("NoExceptions", R.string.NoExceptions));
                    NotificationsCustomSettingsActivity.this.listView.setAdapter(NotificationsCustomSettingsActivity.this.adapter);
                    NotificationsCustomSettingsActivity.this.adapter.notifyDataSetChanged();
                    NotificationsCustomSettingsActivity.this.listView.setFastScrollVisible(true);
                    NotificationsCustomSettingsActivity.this.listView.setVerticalScrollBarEnabled(false);
                    NotificationsCustomSettingsActivity.this.emptyView.setShowAtCenter(false);
                }

                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
                public void onTextChanged(EditText editText) {
                    if (NotificationsCustomSettingsActivity.this.searchAdapter == null) {
                        return;
                    }
                    String string = editText.getText().toString();
                    if (string.length() != 0) {
                        NotificationsCustomSettingsActivity.this.searchWas = true;
                        if (NotificationsCustomSettingsActivity.this.listView != null) {
                            NotificationsCustomSettingsActivity.this.emptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                            NotificationsCustomSettingsActivity.this.emptyView.showProgress();
                            NotificationsCustomSettingsActivity.this.listView.setAdapter(NotificationsCustomSettingsActivity.this.searchAdapter);
                            NotificationsCustomSettingsActivity.this.searchAdapter.notifyDataSetChanged();
                            NotificationsCustomSettingsActivity.this.listView.setFastScrollVisible(false);
                            NotificationsCustomSettingsActivity.this.listView.setVerticalScrollBarEnabled(true);
                        }
                    }
                    NotificationsCustomSettingsActivity.this.searchAdapter.searchDialogs(string);
                }
            }).setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        }
        this.searchAdapter = new SearchAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.setTextSize(18);
        this.emptyView.setText(LocaleController.getString("NoExceptions", R.string.NoExceptions));
        this.emptyView.showTextView();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setEmptyView(this.emptyView);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda9
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f, float f2) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f, f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) throws Resources.NotFoundException {
                this.f$0.lambda$createView$8(view, i, f, f2);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(NotificationsCustomSettingsActivity.this.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$createView$8(View view, final int i, float f, float f2) throws Resources.NotFoundException {
        final ArrayList<NotificationsSettingsActivity.NotificationException> arrayList;
        final NotificationsSettingsActivity.NotificationException notificationException;
        final boolean z;
        int i2;
        NotificationsSettingsActivity.NotificationException notificationException2;
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2;
        String string;
        int i3;
        if (getParentActivity() == null) {
            return;
        }
        if (this.listView.getAdapter() == this.searchAdapter || (i >= this.exceptionsStartRow && i < this.exceptionsEndRow)) {
            RecyclerView.Adapter adapter = this.listView.getAdapter();
            SearchAdapter searchAdapter = this.searchAdapter;
            if (adapter == searchAdapter) {
                Object object = searchAdapter.getObject(i);
                if (!(object instanceof NotificationsSettingsActivity.NotificationException)) {
                    boolean z2 = object instanceof TLRPC$User;
                    if (z2) {
                        i2 = ((TLRPC$User) object).id;
                    } else {
                        i2 = -((TLRPC$Chat) object).id;
                    }
                    long j = i2;
                    if (this.exceptionsDict.containsKey(Long.valueOf(j))) {
                        notificationException2 = this.exceptionsDict.get(Long.valueOf(j));
                    } else {
                        NotificationsSettingsActivity.NotificationException notificationException3 = new NotificationsSettingsActivity.NotificationException();
                        notificationException3.did = j;
                        if (z2) {
                            notificationException3.did = ((TLRPC$User) object).id;
                        } else {
                            notificationException3.did = -((TLRPC$Chat) object).id;
                        }
                        notificationException2 = notificationException3;
                        i = 1;
                    }
                    arrayList2 = this.exceptions;
                } else {
                    arrayList2 = this.searchAdapter.searchResult;
                    notificationException2 = (NotificationsSettingsActivity.NotificationException) object;
                }
                notificationException = notificationException2;
                z = i;
                arrayList = arrayList2;
            } else {
                ArrayList<NotificationsSettingsActivity.NotificationException> arrayList3 = this.exceptions;
                int i4 = i - this.exceptionsStartRow;
                if (i4 < 0 || i4 >= arrayList3.size()) {
                    return;
                }
                arrayList = arrayList3;
                notificationException = arrayList3.get(i4);
                z = 0;
            }
            if (notificationException == null) {
                return;
            }
            AlertsCreator.showCustomNotificationsDialog(this, notificationException.did, -1, null, this.currentAccount, null, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda7
                @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                public final void run(int i5) {
                    this.f$0.lambda$createView$0(z, arrayList, notificationException, i, i5);
                }
            });
            return;
        }
        if (i == this.exceptionsAddRow) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putBoolean("checkCanWrite", false);
            int i5 = this.currentType;
            if (i5 == 0) {
                bundle.putInt("dialogsType", 6);
            } else if (i5 == 2) {
                bundle.putInt("dialogsType", 5);
            } else {
                bundle.putInt("dialogsType", 4);
            }
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda10
                @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList4, CharSequence charSequence, boolean z3) {
                    this.f$0.lambda$createView$2(dialogsActivity2, arrayList4, charSequence, z3);
                }
            });
            presentFragment(dialogsActivity);
        } else {
            Parcelable parcelable = null;
            if (i == this.deleteAllRow) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("NotificationsDeleteAllExceptionTitle", R.string.NotificationsDeleteAllExceptionTitle));
                builder.setMessage(LocaleController.getString("NotificationsDeleteAllExceptionAlert", R.string.NotificationsDeleteAllExceptionAlert));
                builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        this.f$0.lambda$createView$3(dialogInterface, i6);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            } else if (i == this.alertRow) {
                boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(this.currentType);
                NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
                getNotificationsController().setGlobalNotificationsEnabled(this.currentType, zIsGlobalNotificationsEnabled ? ConnectionsManager.DEFAULT_DATACENTER_ID : 0);
                notificationsCheckCell.setChecked(!zIsGlobalNotificationsEnabled);
                if (viewHolderFindViewHolderForAdapterPosition != null) {
                    this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
                }
                checkRowsEnabled();
                i = zIsGlobalNotificationsEnabled ? 1 : 0;
            } else if (i == this.previewRow) {
                if (!view.isEnabled()) {
                    return;
                }
                SharedPreferences notificationsSettings = getNotificationsSettings();
                SharedPreferences.Editor editorEdit = notificationsSettings.edit();
                int i6 = this.currentType;
                if (i6 == 1) {
                    boolean z3 = notificationsSettings.getBoolean("EnablePreviewAll", true);
                    editorEdit.putBoolean("EnablePreviewAll", !z3);
                    i3 = z3;
                } else if (i6 == 0) {
                    boolean z4 = notificationsSettings.getBoolean("EnablePreviewGroup", true);
                    editorEdit.putBoolean("EnablePreviewGroup", !z4);
                    i3 = z4;
                } else {
                    boolean z5 = notificationsSettings.getBoolean("EnablePreviewChannel", true);
                    editorEdit.putBoolean("EnablePreviewChannel", !z5);
                    i3 = z5;
                }
                i = i3;
                editorEdit.apply();
                getNotificationsController().updateServerNotificationsSettings(this.currentType);
            } else if (i == this.messageSoundRow) {
                if (!view.isEnabled()) {
                    return;
                }
                try {
                    SharedPreferences notificationsSettings2 = getNotificationsSettings();
                    Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                    intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                    intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(2));
                    Uri uri = Settings.System.DEFAULT_NOTIFICATION_URI;
                    String path = uri != null ? uri.getPath() : null;
                    int i7 = this.currentType;
                    if (i7 == 1) {
                        string = notificationsSettings2.getString("GlobalSoundPath", path);
                    } else if (i7 == 0) {
                        string = notificationsSettings2.getString("GroupSoundPath", path);
                    } else {
                        string = notificationsSettings2.getString("ChannelSoundPath", path);
                    }
                    if (string != null && !string.equals("NoSound")) {
                        parcelable = string.equals(path) ? uri : Uri.parse(string);
                    }
                    intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", parcelable);
                    startActivityForResult(intent, i);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (i == this.messageLedRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createColorSelectDialog(getParentActivity(), 0L, this.currentType, new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$4(i);
                        }
                    }));
                }
            } else if (i == this.messagePopupNotificationRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createPopupSelectDialog(getParentActivity(), this.currentType, new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$5(i);
                        }
                    }));
                }
            } else if (i == this.messageVibrateRow) {
                if (!view.isEnabled()) {
                    return;
                }
                int i8 = this.currentType;
                showDialog(AlertsCreator.createVibrationSelectDialog(getParentActivity(), 0L, i8 == 1 ? "vibrate_messages" : i8 == 0 ? "vibrate_group" : "vibrate_channel", new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createView$6(i);
                    }
                }));
            } else if (i == this.messagePriorityRow) {
                if (!view.isEnabled()) {
                    return;
                } else {
                    showDialog(AlertsCreator.createPrioritySelectDialog(getParentActivity(), 0L, this.currentType, new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$7(i);
                        }
                    }));
                }
            }
        }
        if (view instanceof TextCheckCell) {
            ((TextCheckCell) view).setChecked(i ^ 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(boolean z, ArrayList arrayList, NotificationsSettingsActivity.NotificationException notificationException, int i, int i2) {
        int iIndexOf;
        if (i2 == 0) {
            if (z) {
                return;
            }
            ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2 = this.exceptions;
            if (arrayList != arrayList2 && (iIndexOf = arrayList2.indexOf(notificationException)) >= 0) {
                this.exceptions.remove(iIndexOf);
                this.exceptionsDict.remove(Long.valueOf(notificationException.did));
            }
            arrayList.remove(notificationException);
            if (arrayList == this.exceptions) {
                if (this.exceptionsAddRow != -1 && arrayList.isEmpty()) {
                    this.listView.getAdapter().notifyItemChanged(this.exceptionsAddRow);
                    this.listView.getAdapter().notifyItemRemoved(this.deleteAllRow);
                    this.listView.getAdapter().notifyItemRemoved(this.deleteAllSectionRow);
                }
                this.listView.getAdapter().notifyItemRemoved(i);
                updateRows(false);
                checkRowsEnabled();
            } else {
                updateRows(true);
                this.searchAdapter.notifyDataSetChanged();
            }
            this.actionBar.closeSearchField();
            return;
        }
        SharedPreferences notificationsSettings = getNotificationsSettings();
        notificationException.hasCustom = notificationsSettings.getBoolean(NotificationsSettingsFacade.PROPERTY_CUSTOM + notificationException.did, false);
        int i3 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + notificationException.did, 0);
        notificationException.notify = i3;
        if (i3 != 0) {
            int i4 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + notificationException.did, -1);
            if (i4 != -1) {
                notificationException.muteUntil = i4;
            }
        }
        if (z) {
            this.exceptions.add(notificationException);
            this.exceptionsDict.put(Long.valueOf(notificationException.did), notificationException);
            updateRows(true);
        } else {
            this.listView.getAdapter().notifyItemChanged(i);
        }
        this.actionBar.closeSearchField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putLong("dialog_id", ((Long) arrayList.get(0)).longValue());
        bundle.putBoolean("exception", true);
        ProfileNotificationsActivity profileNotificationsActivity = new ProfileNotificationsActivity(bundle);
        profileNotificationsActivity.setDelegate(new ProfileNotificationsActivity.ProfileNotificationsActivityDelegate() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda11
            @Override // org.rbmain.ui.ProfileNotificationsActivity.ProfileNotificationsActivityDelegate
            public final void didCreateNewException(NotificationsSettingsActivity.NotificationException notificationException) {
                this.f$0.lambda$createView$1(notificationException);
            }
        });
        presentFragment(profileNotificationsActivity, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(NotificationsSettingsActivity.NotificationException notificationException) {
        this.exceptions.add(0, notificationException);
        updateRows(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(DialogInterface dialogInterface, int i) {
        SharedPreferences.Editor editorEdit = getNotificationsSettings().edit();
        int size = this.exceptions.size();
        for (int i2 = 0; i2 < size; i2++) {
            NotificationsSettingsActivity.NotificationException notificationException = this.exceptions.get(i2);
            editorEdit.remove(NotificationsSettingsFacade.PROPERTY_NOTIFY + notificationException.did).remove(NotificationsSettingsFacade.PROPERTY_CUSTOM + notificationException.did);
            getMessagesStorage().setDialogFlags(notificationException.did, 0L);
            TLRPC$Dialog tLRPC$Dialog = getMessagesController().dialogs_dict.get(notificationException.did);
            if (tLRPC$Dialog != null) {
                tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
            }
        }
        editorEdit.apply();
        int size2 = this.exceptions.size();
        for (int i3 = 0; i3 < size2; i3++) {
            getNotificationsController().updateServerNotificationsSettings(this.exceptions.get(i3).did, false);
        }
        this.exceptions.clear();
        this.exceptionsDict.clear();
        updateRows(true);
        getNotificationCenter().postNotificationName(NotificationCenter.notificationsSettingsUpdated, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(int i) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
        if (viewHolderFindViewHolderForAdapterPosition != null) {
            this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
        }
    }

    private void checkRowsEnabled() {
        if (this.exceptions.isEmpty()) {
            int childCount = this.listView.getChildCount();
            ArrayList<Animator> arrayList = new ArrayList<>();
            boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(this.currentType);
            for (int i = 0; i < childCount; i++) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.getChildViewHolder(this.listView.getChildAt(i));
                int itemViewType = holder.getItemViewType();
                if (itemViewType == 0) {
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (holder.getAdapterPosition() == this.messageSectionRow) {
                        headerCell.setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                    }
                } else if (itemViewType == 1) {
                    ((TextCheckCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                } else if (itemViewType == 3) {
                    ((TextColorCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                } else if (itemViewType == 5) {
                    ((TextSettingsCell) holder.itemView).setEnabled(zIsGlobalNotificationsEnabled, arrayList);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet = this.animatorSet;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.playTogether(arrayList);
            this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(NotificationsCustomSettingsActivity.this.animatorSet)) {
                        NotificationsCustomSettingsActivity.this.animatorSet = null;
                    }
                }
            });
            this.animatorSet.setDuration(150L);
            this.animatorSet.start();
        }
    }

    private void loadExceptions() {
        getMessagesStorage().getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadExceptions$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00fb, code lost:
    
        if (r8.deleted != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0280 A[LOOP:3: B:116:0x027e->B:117:0x0280, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0224  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadExceptions$10() {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.NotificationsCustomSettingsActivity.lambda$loadExceptions$10():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadExceptions$9(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
        getMessagesController().putUsers(arrayList, true);
        getMessagesController().putChats(arrayList2, true);
        getMessagesController().putEncryptedChats(arrayList3, true);
        int i = this.currentType;
        if (i == 1) {
            this.exceptions = arrayList4;
        } else if (i == 0) {
            this.exceptions = arrayList5;
        } else {
            this.exceptions = arrayList6;
        }
        updateRows(true);
    }

    private void updateRows(boolean z) {
        ListAdapter listAdapter;
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList;
        this.rowCount = 0;
        int i = this.currentType;
        if (i != -1) {
            int i2 = 0 + 1;
            this.rowCount = i2;
            this.alertRow = 0;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.alertSection2Row = i2;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.messageSectionRow = i3;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.previewRow = i4;
            int i6 = i5 + 1;
            this.rowCount = i6;
            this.messageLedRow = i5;
            int i7 = i6 + 1;
            this.rowCount = i7;
            this.messageVibrateRow = i6;
            if (i == 2) {
                this.messagePopupNotificationRow = -1;
            } else {
                this.rowCount = i7 + 1;
                this.messagePopupNotificationRow = i7;
            }
            int i8 = this.rowCount;
            int i9 = i8 + 1;
            this.rowCount = i9;
            this.messageSoundRow = i8;
            if (Build.VERSION.SDK_INT >= 21) {
                this.rowCount = i9 + 1;
                this.messagePriorityRow = i9;
            } else {
                this.messagePriorityRow = -1;
            }
            int i10 = this.rowCount;
            this.rowCount = i10 + 1;
            this.groupSection2Row = i10;
            this.exceptionsAddRow = -1;
        } else {
            this.alertRow = -1;
            this.alertSection2Row = -1;
            this.messageSectionRow = -1;
            this.previewRow = -1;
            this.messageLedRow = -1;
            this.messageVibrateRow = -1;
            this.messagePopupNotificationRow = -1;
            this.messageSoundRow = -1;
            this.messagePriorityRow = -1;
            this.groupSection2Row = -1;
            this.exceptionsAddRow = -1;
        }
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2 = this.exceptions;
        if (arrayList2 != null) {
            arrayList2.isEmpty();
        }
        this.exceptionsStartRow = -1;
        this.exceptionsEndRow = -1;
        if (this.currentType == -1 && (arrayList = this.exceptions) != null) {
            arrayList.isEmpty();
        }
        this.exceptionsSection2Row = -1;
        ArrayList<NotificationsSettingsActivity.NotificationException> arrayList3 = this.exceptions;
        if (arrayList3 != null) {
            arrayList3.isEmpty();
        }
        this.deleteAllRow = -1;
        this.deleteAllSectionRow = -1;
        if (!z || (listAdapter = this.adapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
        Ringtone ringtone;
        if (i2 == -1) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            String title = null;
            if (uri != null && (ringtone = RingtoneManager.getRingtone(getParentActivity(), uri)) != null) {
                if (uri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
                    title = LocaleController.getString("SoundDefault", R.string.SoundDefault);
                } else {
                    title = ringtone.getTitle(getParentActivity());
                }
                ringtone.stop();
            }
            SharedPreferences.Editor editorEdit = getNotificationsSettings().edit();
            int i3 = this.currentType;
            if (i3 == 1) {
                if (title != null && uri != null) {
                    editorEdit.putString("GlobalSound", title);
                    editorEdit.putString("GlobalSoundPath", uri.toString());
                } else {
                    editorEdit.putString("GlobalSound", "NoSound");
                    editorEdit.putString("GlobalSoundPath", "NoSound");
                }
            } else if (i3 == 0) {
                if (title != null && uri != null) {
                    editorEdit.putString("GroupSound", title);
                    editorEdit.putString("GroupSoundPath", uri.toString());
                } else {
                    editorEdit.putString("GroupSound", "NoSound");
                    editorEdit.putString("GroupSoundPath", "NoSound");
                }
            } else if (i3 == 2) {
                if (title != null && uri != null) {
                    editorEdit.putString("ChannelSound", title);
                    editorEdit.putString("ChannelSoundPath", uri.toString());
                } else {
                    editorEdit.putString("ChannelSound", "NoSound");
                    editorEdit.putString("ChannelSoundPath", "NoSound");
                }
            }
            getNotificationsController().deleteNotificationChannelGlobal(this.currentType);
            editorEdit.apply();
            getNotificationsController().updateServerNotificationsSettings(this.currentType);
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(i);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                this.adapter.onBindViewHolder(viewHolderFindViewHolderForAdapterPosition, i);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private SearchAdapterHelper searchAdapterHelper;
        private ArrayList<NotificationsSettingsActivity.NotificationException> searchResult = new ArrayList<>();
        private ArrayList<CharSequence> searchResultNames = new ArrayList<>();
        private Runnable searchRunnable;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public SearchAdapter(Context context) {
            this.mContext = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(true);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$SearchAdapter$$ExternalSyntheticLambda4
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ boolean canApplySearchResults(int i) {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$canApplySearchResults(this, i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public final void onDataSetChanged(int i) {
                    this.f$0.lambda$new$0(i);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i) {
            if (this.searchRunnable == null && !this.searchAdapterHelper.isSearchInProgress()) {
                NotificationsCustomSettingsActivity.this.emptyView.showTextView();
            }
            notifyDataSetChanged();
        }

        public void searchDialogs(final String str) {
            if (this.searchRunnable != null) {
                Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                this.searchRunnable = null;
            }
            if (str == null) {
                this.searchResult.clear();
                this.searchResultNames.clear();
                this.searchAdapterHelper.mergeResults(null);
                this.searchAdapterHelper.queryServerSearch(null, true, NotificationsCustomSettingsActivity.this.currentType != 1, true, false, false, 0, false, 0, 0);
                notifyDataSetChanged();
                return;
            }
            DispatchQueue dispatchQueue = Utilities.searchQueue;
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$SearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$1(str);
                }
            };
            this.searchRunnable = runnable;
            dispatchQueue.postRunnable(runnable, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: processSearch, reason: merged with bridge method [inline-methods] */
        public void lambda$searchDialogs$1(final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$3(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processSearch$3(final String str) {
            this.searchAdapterHelper.queryServerSearch(str, true, NotificationsCustomSettingsActivity.this.currentType != 1, true, false, false, 0, false, 0, 0);
            final ArrayList arrayList = new ArrayList(NotificationsCustomSettingsActivity.this.exceptions);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$SearchAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSearch$2(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01bd A[LOOP:1: B:51:0x011b->B:79:0x01bd, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x017e A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Type inference failed for: r9v16, types: [org.rbmain.tgnet.TLRPC$User] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$processSearch$2(java.lang.String r21, java.util.ArrayList r22) {
            /*
                Method dump skipped, instructions count: 473
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.NotificationsCustomSettingsActivity.SearchAdapter.lambda$processSearch$2(java.lang.String, java.util.ArrayList):void");
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final ArrayList<NotificationsSettingsActivity.NotificationException> arrayList2, final ArrayList<CharSequence> arrayList3) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$SearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$4(arrayList2, arrayList3, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$4(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            if (NotificationsCustomSettingsActivity.this.searching) {
                this.searchRunnable = null;
                this.searchResult = arrayList;
                this.searchResultNames = arrayList2;
                this.searchAdapterHelper.mergeResults(arrayList3);
                if (NotificationsCustomSettingsActivity.this.searching && !this.searchAdapterHelper.isSearchInProgress()) {
                    NotificationsCustomSettingsActivity.this.emptyView.showTextView();
                }
                notifyDataSetChanged();
            }
        }

        public Object getObject(int i) {
            if (i >= 0 && i < this.searchResult.size()) {
                return this.searchResult.get(i);
            }
            int size = i - (this.searchResult.size() + 1);
            ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
            if (size < 0 || size >= globalSearch.size()) {
                return null;
            }
            return this.searchAdapterHelper.getGlobalSearch().get(size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size();
            ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
            return !globalSearch.isEmpty() ? size + globalSearch.size() + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View userCell;
            if (i == 0) {
                userCell = new UserCell(this.mContext, 4, 0, false, true);
                userCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                userCell = new GraySectionCell(this.mContext);
            }
            return new RecyclerListView.Holder(userCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                ((GraySectionCell) viewHolder.itemView).setText(LocaleController.getString("AddToExceptions", R.string.AddToExceptions));
                return;
            }
            UserCell userCell = (UserCell) viewHolder.itemView;
            if (i < this.searchResult.size()) {
                userCell.setException(this.searchResult.get(i), this.searchResultNames.get(i), i != this.searchResult.size() - 1);
                userCell.setAddButtonVisible(false);
            } else {
                int size = i - (this.searchResult.size() + 1);
                ArrayList<TLObject> globalSearch = this.searchAdapterHelper.getGlobalSearch();
                userCell.setData(globalSearch.get(size), null, LocaleController.getString("NotificationsOn", R.string.NotificationsOn), 0, size != globalSearch.size() - 1);
                userCell.setAddButtonVisible(true);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == this.searchResult.size() ? 1 : 0;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return (itemViewType == 0 || itemViewType == 4) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NotificationsCustomSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View headerCell;
            switch (i) {
                case 0:
                    headerCell = new HeaderCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 1:
                    headerCell = new TextCheckCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 2:
                    headerCell = new UserCell(this.mContext, 6, 0, false);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 3:
                    headerCell = new TextColorCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 4:
                    headerCell = new ShadowSectionCell(this.mContext);
                    break;
                case 5:
                    headerCell = new TextSettingsCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 6:
                    headerCell = new NotificationsCheckCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                default:
                    headerCell = new TextCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            boolean z;
            int i2;
            int i3;
            String string;
            int i4;
            int i5;
            String string2;
            String string3;
            int i6;
            int i7;
            int i8 = 0;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                        headerCell.setText(LocaleController.getString("SETTINGS", R.string.SETTINGS));
                        break;
                    }
                    break;
                case 1:
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (i == NotificationsCustomSettingsActivity.this.previewRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                z = notificationsSettings.getBoolean("EnablePreviewGroup", true);
                            } else {
                                z = notificationsSettings.getBoolean("EnablePreviewChannel", true);
                            }
                        } else {
                            z = notificationsSettings.getBoolean("EnablePreviewAll", true);
                        }
                        textCheckCell.setTextAndCheck(LocaleController.getString("MessagePreview", R.string.MessagePreview), z, true);
                        break;
                    }
                    break;
                case 2:
                    ((UserCell) viewHolder.itemView).setException((NotificationsSettingsActivity.NotificationException) NotificationsCustomSettingsActivity.this.exceptions.get(i - NotificationsCustomSettingsActivity.this.exceptionsStartRow), null, i != NotificationsCustomSettingsActivity.this.exceptionsEndRow - 1);
                    break;
                case 3:
                    TextColorCell textColorCell = (TextColorCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings2 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                        if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                            i2 = notificationsSettings2.getInt("GroupLed", -16776961);
                        } else {
                            i2 = notificationsSettings2.getInt("ChannelLed", -16776961);
                        }
                    } else {
                        i2 = notificationsSettings2.getInt("MessagesLed", -16776961);
                    }
                    while (true) {
                        if (i8 < 9) {
                            if (TextColorCell.colorsToSave[i8] == i2) {
                                i2 = TextColorCell.colors[i8];
                            } else {
                                i8++;
                            }
                        }
                    }
                    textColorCell.setTextAndColor(LocaleController.getString("LedColor", R.string.LedColor), i2, true);
                    break;
                case 4:
                    if (i == NotificationsCustomSettingsActivity.this.deleteAllSectionRow || ((i == NotificationsCustomSettingsActivity.this.groupSection2Row && NotificationsCustomSettingsActivity.this.exceptionsSection2Row == -1) || (i == NotificationsCustomSettingsActivity.this.exceptionsSection2Row && NotificationsCustomSettingsActivity.this.deleteAllRow == -1))) {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        break;
                    } else {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        break;
                    }
                case 5:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings3 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (i == NotificationsCustomSettingsActivity.this.messageSoundRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                string2 = notificationsSettings3.getString("GroupSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                            } else {
                                string2 = notificationsSettings3.getString("ChannelSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                            }
                        } else {
                            string2 = notificationsSettings3.getString("GlobalSound", LocaleController.getString("SoundDefault", R.string.SoundDefault));
                        }
                        if (string2.equals("NoSound")) {
                            string2 = LocaleController.getString("NoSound", R.string.NoSound);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("Sound", R.string.Sound), string2, true);
                        break;
                    } else if (i == NotificationsCustomSettingsActivity.this.messageVibrateRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i5 = notificationsSettings3.getInt("vibrate_group", 0);
                            } else {
                                i5 = notificationsSettings3.getInt("vibrate_channel", 0);
                            }
                        } else {
                            i5 = notificationsSettings3.getInt("vibrate_messages", 0);
                        }
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        if (i5 == 4) {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("OnlyIfSilent", R.string.OnlyIfSilent), true);
                                            break;
                                        }
                                    } else {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Long", R.string.Long), true);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled), true);
                                    break;
                                }
                            } else {
                                textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Short", R.string.Short), true);
                                break;
                            }
                        } else {
                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDefault", R.string.VibrationDefault), true);
                            break;
                        }
                    } else if (i == NotificationsCustomSettingsActivity.this.messagePriorityRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i4 = notificationsSettings3.getInt("priority_group", 1);
                            } else {
                                i4 = notificationsSettings3.getInt("priority_channel", 1);
                            }
                        } else {
                            i4 = notificationsSettings3.getInt("priority_messages", 1);
                        }
                        if (i4 != 0) {
                            if (i4 != 1 && i4 != 2) {
                                if (i4 != 4) {
                                    if (i4 == 5) {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium), false);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow), false);
                                    break;
                                }
                            } else {
                                textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent), false);
                                break;
                            }
                        } else {
                            textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh), false);
                            break;
                        }
                    } else if (i == NotificationsCustomSettingsActivity.this.messagePopupNotificationRow) {
                        if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                            if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                                i3 = notificationsSettings3.getInt("popupGroup", 0);
                            } else {
                                i3 = notificationsSettings3.getInt("popupChannel", 0);
                            }
                        } else {
                            i3 = notificationsSettings3.getInt("popupAll", 0);
                        }
                        if (i3 == 0) {
                            string = LocaleController.getString("NoPopup", R.string.NoPopup);
                        } else if (i3 == 1) {
                            string = LocaleController.getString("OnlyWhenScreenOn", R.string.OnlyWhenScreenOn);
                        } else if (i3 == 2) {
                            string = LocaleController.getString("OnlyWhenScreenOff", R.string.OnlyWhenScreenOff);
                        } else {
                            string = LocaleController.getString("AlwaysShowPopup", R.string.AlwaysShowPopup);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("PopupNotification", R.string.PopupNotification), string, true);
                        break;
                    }
                    break;
                case 6:
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                    notificationsCheckCell.setDrawLine(false);
                    StringBuilder sb = new StringBuilder();
                    SharedPreferences notificationsSettings4 = NotificationsCustomSettingsActivity.this.getNotificationsSettings();
                    if (NotificationsCustomSettingsActivity.this.currentType != 1) {
                        if (NotificationsCustomSettingsActivity.this.currentType == 0) {
                            string3 = LocaleController.getString("NotificationsForGroups", R.string.NotificationsForGroups);
                            i6 = notificationsSettings4.getInt("EnableGroup2", 0);
                        } else {
                            string3 = LocaleController.getString("NotificationsForChannels", R.string.NotificationsForChannels);
                            i6 = notificationsSettings4.getInt("EnableChannel2", 0);
                        }
                    } else {
                        string3 = LocaleController.getString("NotificationsForPrivateChats", R.string.NotificationsForPrivateChats);
                        i6 = notificationsSettings4.getInt("EnableAll2", 0);
                    }
                    String str = string3;
                    int currentTime = NotificationsCustomSettingsActivity.this.getConnectionsManager().getCurrentTime();
                    boolean z2 = i6 < currentTime;
                    if (!z2) {
                        if (i6 - 31536000 >= currentTime) {
                            sb.append(LocaleController.getString("NotificationsOff", R.string.NotificationsOff));
                        } else {
                            sb.append(LocaleController.formatString("NotificationsOffUntil", R.string.NotificationsOffUntil, LocaleController.stringForMessageListDate(i6)));
                            i7 = 2;
                            notificationsCheckCell.setTextAndValueAndCheck(str, sb, z2, i7, false);
                            break;
                        }
                    } else {
                        sb.append(LocaleController.getString("NotificationsOn", R.string.NotificationsOn));
                    }
                    i7 = 0;
                    notificationsCheckCell.setTextAndValueAndCheck(str, sb, z2, i7, false);
                case 7:
                    TextCell textCell = (TextCell) viewHolder.itemView;
                    if (i == NotificationsCustomSettingsActivity.this.exceptionsAddRow) {
                        textCell.setTextAndIcon(LocaleController.getString("NotificationsAddAnException", R.string.NotificationsAddAnException), R.drawable.actions_addmember2, NotificationsCustomSettingsActivity.this.exceptionsStartRow != -1);
                        textCell.setColors(Theme.key_windowBackgroundWhiteBlueIcon, Theme.key_windowBackgroundWhiteBlueButton);
                        break;
                    } else if (i == NotificationsCustomSettingsActivity.this.deleteAllRow) {
                        textCell.setText(LocaleController.getString("NotificationsDeleteAllException", R.string.NotificationsDeleteAllException), false);
                        textCell.setColors(-1, Theme.key_text_RedRegular);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (NotificationsCustomSettingsActivity.this.exceptions == null || !NotificationsCustomSettingsActivity.this.exceptions.isEmpty()) {
                return;
            }
            boolean zIsGlobalNotificationsEnabled = NotificationsCustomSettingsActivity.this.getNotificationsController().isGlobalNotificationsEnabled(NotificationsCustomSettingsActivity.this.currentType);
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (viewHolder.getAdapterPosition() == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                    headerCell.setEnabled(zIsGlobalNotificationsEnabled, null);
                    return;
                } else {
                    headerCell.setEnabled(true, null);
                    return;
                }
            }
            if (itemViewType == 1) {
                ((TextCheckCell) viewHolder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            } else if (itemViewType == 3) {
                ((TextColorCell) viewHolder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            } else {
                if (itemViewType != 5) {
                    return;
                }
                ((TextSettingsCell) viewHolder.itemView).setEnabled(zIsGlobalNotificationsEnabled, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == NotificationsCustomSettingsActivity.this.messageSectionRow) {
                return 0;
            }
            if (i == NotificationsCustomSettingsActivity.this.previewRow) {
                return 1;
            }
            if (i >= NotificationsCustomSettingsActivity.this.exceptionsStartRow && i < NotificationsCustomSettingsActivity.this.exceptionsEndRow) {
                return 2;
            }
            if (i == NotificationsCustomSettingsActivity.this.messageLedRow) {
                return 3;
            }
            if (i == NotificationsCustomSettingsActivity.this.groupSection2Row || i == NotificationsCustomSettingsActivity.this.alertSection2Row || i == NotificationsCustomSettingsActivity.this.exceptionsSection2Row || i == NotificationsCustomSettingsActivity.this.deleteAllSectionRow) {
                return 4;
            }
            if (i == NotificationsCustomSettingsActivity.this.alertRow) {
                return 6;
            }
            return (i == NotificationsCustomSettingsActivity.this.exceptionsAddRow || i == NotificationsCustomSettingsActivity.this.deleteAllRow) ? 7 : 5;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.NotificationsCustomSettingsActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$11();
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCheckCell.class, TextColorCell.class, TextSettingsCell.class, UserCell.class, NotificationsCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i4 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_switchTrack;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_switchTrackChecked;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextColorCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueButton));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_text_RedRegular));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueIcon));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$11() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(0);
                }
            }
        }
    }
}
