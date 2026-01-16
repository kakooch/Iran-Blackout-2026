package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SecretChatHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.ContactsAdapter;
import ir.eitaa.ui.Adapters.SearchAdapter;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LetterSectionCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.UserCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.StickerEmptyView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ContactsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private boolean allowBots;
    private boolean allowSelf;
    private boolean allowUsernameSearch;
    private int animationIndex;
    private boolean askAboutContacts;
    private AnimatorSet bounceIconAnimator;
    private long callOutLastClickTime;
    private long channelId;
    private long chatId;
    private boolean checkPermission;
    private boolean createSecretChat;
    private boolean creatingChat;
    private ContactsActivityDelegate delegate;
    private boolean destroyAfterSelect;
    private boolean disableSections;
    private StickerEmptyView emptyView;
    private RLottieImageView floatingButton;
    private FrameLayout floatingButtonContainer;
    private boolean floatingHidden;
    private AccelerateDecelerateInterpolator floatingInterpolator;
    private boolean hasGps;
    private LongSparseArray<TLRPC$User> ignoreUsers;
    private String initialSearchString;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private ContactsAdapter listViewAdapter;
    private boolean needFinishFragment;
    private boolean needForwardCount;
    private boolean needPhonebook;
    private boolean onlyUsers;
    private AlertDialog permissionDialog;
    private long permissionRequestTime;
    private int prevPosition;
    private int prevTop;
    private boolean resetDelegate;
    private boolean returnAsResult;
    private boolean scrollUpdated;
    private SearchAdapter searchListViewAdapter;
    private boolean searchWas;
    private boolean searching;
    private String selectAlertString;
    private boolean sortByName;
    private ActionBarMenuItem sortItem;

    public interface ContactsActivityDelegate {
        void didSelectContact(TLRPC$User user, String param, ContactsActivity activity);
    }

    public ContactsActivity(Bundle args) {
        super(args);
        this.floatingInterpolator = new AccelerateDecelerateInterpolator();
        this.allowSelf = true;
        this.allowBots = true;
        this.needForwardCount = true;
        this.needFinishFragment = true;
        this.resetDelegate = true;
        this.selectAlertString = null;
        this.allowUsernameSearch = true;
        this.askAboutContacts = true;
        this.checkPermission = true;
        this.animationIndex = -1;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.encryptedChatCreated);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mxbStatusNeedReload);
        this.checkPermission = UserConfig.getInstance(this.currentAccount).syncContacts;
        Bundle bundle = this.arguments;
        if (bundle != null) {
            this.onlyUsers = bundle.getBoolean("onlyUsers", false);
            this.destroyAfterSelect = this.arguments.getBoolean("destroyAfterSelect", false);
            this.returnAsResult = this.arguments.getBoolean("returnAsResult", false);
            this.createSecretChat = this.arguments.getBoolean("createSecretChat", false);
            this.selectAlertString = this.arguments.getString("selectAlertString");
            this.allowUsernameSearch = this.arguments.getBoolean("allowUsernameSearch", true);
            this.needForwardCount = this.arguments.getBoolean("needForwardCount", true);
            this.allowBots = this.arguments.getBoolean("allowBots", true);
            this.allowSelf = this.arguments.getBoolean("allowSelf", true);
            this.channelId = this.arguments.getLong("channelId", 0L);
            this.needFinishFragment = this.arguments.getBoolean("needFinishFragment", true);
            this.chatId = this.arguments.getLong("chat_id", 0L);
            this.disableSections = this.arguments.getBoolean("disableSections", false);
            this.resetDelegate = this.arguments.getBoolean("resetDelegate", false);
        } else {
            this.needPhonebook = true;
        }
        if (!this.createSecretChat && !this.returnAsResult) {
            this.sortByName = SharedConfig.sortContactsByName;
        }
        getContactsController().checkInviteText();
        getContactsController().reloadContactsStatusesMaybe();
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.encryptedChatCreated);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mxbStatusNeedReload);
        this.delegate = null;
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        getNotificationCenter().onAnimationFinish(this.animationIndex);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationProgress(boolean isOpen, float progress) {
        super.onTransitionAnimationProgress(isOpen, progress);
        this.fragmentView.invalidate();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|(2:4|(1:6)(2:7|(1:9)(1:10)))(1:11)|12|(3:16|(1:18)(1:19)|20)|21|(1:23)|24|(1:26)(2:28|(2:30|(1:35)(1:34))(11:36|94|37|40|(2:42|(1:44)(1:45))(1:46)|47|(20:51|(1:53)(1:54)|55|(1:57)(1:58)|59|(1:62)|63|(1:65)(1:66)|67|(1:69)(1:70)|71|(1:73)|74|(1:76)(1:77)|78|(1:80)|81|(1:83)(1:84)|(1:86)(1:87)|88)|89|(1:91)|92|93))|27|94|37|40|(0)(0)|47|(21:49|51|(0)(0)|55|(0)(0)|59|(0)|63|(0)(0)|67|(0)(0)|71|(0)|74|(0)(0)|78|(0)|81|(0)(0)|(0)(0)|88)|89|(0)|92|93) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0147, code lost:
    
        r23.hasGps = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x038c  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 919
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ContactsActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$ContactsActivity(int i, View view, int i2) {
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchListViewAdapter;
        if (adapter == searchAdapter) {
            Object item = searchAdapter.getItem(i2);
            if (item instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) item;
                if (this.searchListViewAdapter.isGlobalSearch(i2)) {
                    ArrayList<TLRPC$User> arrayList = new ArrayList<>();
                    arrayList.add(tLRPC$User);
                    getMessagesController().putUsers(arrayList, false);
                    MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(arrayList, null, false, true);
                }
                if (this.returnAsResult) {
                    LongSparseArray<TLRPC$User> longSparseArray = this.ignoreUsers;
                    if (longSparseArray == null || longSparseArray.indexOfKey(tLRPC$User.id) < 0) {
                        didSelectResult(tLRPC$User, true, null);
                        return;
                    }
                    return;
                }
                if (this.createSecretChat) {
                    if (tLRPC$User.id == UserConfig.getInstance(this.currentAccount).getClientUserId()) {
                        return;
                    }
                    this.creatingChat = true;
                    SecretChatHelper.getInstance(this.currentAccount).startSecretChat(getParentActivity(), tLRPC$User);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", tLRPC$User.id);
                if (getMessagesController().checkCanOpenChat(bundle, this)) {
                    presentFragment(new ChatActivity(bundle), true);
                    return;
                }
                return;
            }
            if (item instanceof String) {
                String str = (String) item;
                if (str.equals("section")) {
                    return;
                }
                NewContactActivity newContactActivity = new NewContactActivity();
                newContactActivity.setInitialPhoneNumber(str, true);
                presentFragment(newContactActivity);
                return;
            }
            return;
        }
        int sectionForPosition = this.listViewAdapter.getSectionForPosition(i2);
        int positionInSectionForPosition = this.listViewAdapter.getPositionInSectionForPosition(i2);
        if (positionInSectionForPosition < 0 || sectionForPosition < 0) {
            return;
        }
        if ((!this.onlyUsers || i != 0) && sectionForPosition == 0) {
            if (this.needPhonebook) {
                if (positionInSectionForPosition == 0) {
                    presentFragment(new InviteContactsActivity());
                    return;
                }
                return;
            }
            if (i != 0) {
                return;
            }
            if (positionInSectionForPosition == 0) {
                presentFragment(new GroupCreateActivity(new Bundle()), false);
                return;
            }
            if (positionInSectionForPosition == 1) {
                SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                if (!BuildVars.DEBUG_VERSION && globalMainSettings.getBoolean("channel_intro", false)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("step", 0);
                    presentFragment(new ChannelCreateActivity(bundle2));
                    return;
                } else {
                    presentFragment(new ActionIntroActivity(0));
                    globalMainSettings.edit().putBoolean("channel_intro", true).commit();
                    return;
                }
            }
            return;
        }
        Object item2 = this.listViewAdapter.getItem(sectionForPosition, positionInSectionForPosition);
        if (item2 instanceof TLRPC$User) {
            TLRPC$User tLRPC$User2 = (TLRPC$User) item2;
            if (this.returnAsResult) {
                LongSparseArray<TLRPC$User> longSparseArray2 = this.ignoreUsers;
                if (longSparseArray2 == null || longSparseArray2.indexOfKey(tLRPC$User2.id) < 0) {
                    didSelectResult(tLRPC$User2, true, null);
                    return;
                }
                return;
            }
            if (this.createSecretChat) {
                this.creatingChat = true;
                SecretChatHelper.getInstance(this.currentAccount).startSecretChat(getParentActivity(), tLRPC$User2);
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putLong("user_id", tLRPC$User2.id);
            if (getMessagesController().checkCanOpenChat(bundle3, this)) {
                presentFragment(new ChatActivity(bundle3), true);
                return;
            }
            return;
        }
        if (item2 instanceof ContactsController.Contact) {
            ContactsController.Contact contact = (ContactsController.Contact) item2;
            final String str2 = !contact.phones.isEmpty() ? contact.phones.get(0) : null;
            if (str2 == null || getParentActivity() == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setMessage(LocaleController.getString("InviteUser", R.string.InviteUser));
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$H9_SlL1bGtGeKZ8OQNNRKcc0wN4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    this.f$0.lambda$createView$0$ContactsActivity(str2, dialogInterface, i3);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ContactsActivity(String str, DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", str, null));
            intent.putExtra("sms_body", ContactsController.getInstance(this.currentAccount).getInviteText(1));
            getParentActivity().startActivityForResult(intent, 500);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ContactsActivity(View view) {
        presentFragment(new NewContactActivity());
    }

    private void didSelectResult(final TLRPC$User user, boolean useAlert, final String param) {
        final EditTextBoldCursor editTextBoldCursor;
        if (useAlert && this.selectAlertString != null) {
            if (getParentActivity() == null) {
                return;
            }
            if (user.bot) {
                if (user.bot_nochats) {
                    try {
                        BulletinFactory.of(this).createErrorBulletin(LocaleController.getString("BotCantJoinGroups", R.string.BotCantJoinGroups)).show();
                        return;
                    } catch (Exception e) {
                        FileLog.e(e);
                        return;
                    }
                }
                if (this.channelId != 0) {
                    TLRPC$Chat chat = getMessagesController().getChat(Long.valueOf(this.channelId));
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                    if (ChatObject.canAddAdmins(chat)) {
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setMessage(LocaleController.getString("AddBotAsAdmin", R.string.AddBotAsAdmin));
                        builder.setPositiveButton(LocaleController.getString("MakeAdmin", R.string.MakeAdmin), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$FVFN2hDHpr7Hyvl0hluIZjpJe3s
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$didSelectResult$3$ContactsActivity(user, param, dialogInterface, i);
                            }
                        });
                        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    } else {
                        builder.setMessage(LocaleController.getString("CantAddBotAsAdmin", R.string.CantAddBotAsAdmin));
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                    }
                    showDialog(builder.create());
                    return;
                }
            }
            AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
            builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
            String stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(user));
            if (user.bot || !this.needForwardCount) {
                editTextBoldCursor = null;
            } else {
                stringSimple = String.format("%s\n\n%s", stringSimple, LocaleController.getString("AddToTheGroupForwardCount", R.string.AddToTheGroupForwardCount));
                editTextBoldCursor = new EditTextBoldCursor(getParentActivity());
                editTextBoldCursor.setTextSize(1, 18.0f);
                editTextBoldCursor.setText("50");
                editTextBoldCursor.setTextColor(Theme.getColor("dialogTextBlack"));
                editTextBoldCursor.setGravity(17);
                editTextBoldCursor.setInputType(2);
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(getParentActivity(), true));
                editTextBoldCursor.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ContactsActivity.13
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        try {
                            String string = s.toString();
                            if (string.length() != 0) {
                                int iIntValue = Utilities.parseInt(string).intValue();
                                if (iIntValue < 0) {
                                    editTextBoldCursor.setText("0");
                                    EditText editText = editTextBoldCursor;
                                    editText.setSelection(editText.length());
                                } else if (iIntValue > 300) {
                                    editTextBoldCursor.setText("300");
                                    EditText editText2 = editTextBoldCursor;
                                    editText2.setSelection(editText2.length());
                                } else {
                                    if (!string.equals("" + iIntValue)) {
                                        editTextBoldCursor.setText("" + iIntValue);
                                        EditText editText3 = editTextBoldCursor;
                                        editText3.setSelection(editText3.length());
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            FileLog.e(e2);
                        }
                    }
                });
                builder2.setView(editTextBoldCursor);
            }
            builder2.setMessage(stringSimple);
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$U5D5_9Wf3hvTWfurEPzFBNvGBWc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$didSelectResult$4$ContactsActivity(user, editTextBoldCursor, dialogInterface, i);
                }
            });
            builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder2.create());
            if (editTextBoldCursor != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) editTextBoldCursor.getLayoutParams();
                if (marginLayoutParams != null) {
                    if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) marginLayoutParams).gravity = 1;
                    }
                    int iDp = AndroidUtilities.dp(24.0f);
                    marginLayoutParams.leftMargin = iDp;
                    marginLayoutParams.rightMargin = iDp;
                    marginLayoutParams.height = AndroidUtilities.dp(36.0f);
                    editTextBoldCursor.setLayoutParams(marginLayoutParams);
                }
                editTextBoldCursor.setSelection(editTextBoldCursor.getText().length());
                return;
            }
            return;
        }
        ContactsActivityDelegate contactsActivityDelegate = this.delegate;
        if (contactsActivityDelegate != null) {
            contactsActivityDelegate.didSelectContact(user, param, this);
            if (this.resetDelegate) {
                this.delegate = null;
            }
        }
        if (this.needFinishFragment) {
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$3$ContactsActivity(TLRPC$User tLRPC$User, String str, DialogInterface dialogInterface, int i) {
        ContactsActivityDelegate contactsActivityDelegate = this.delegate;
        if (contactsActivityDelegate != null) {
            contactsActivityDelegate.didSelectContact(tLRPC$User, str, this);
            this.delegate = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didSelectResult$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didSelectResult$4$ContactsActivity(TLRPC$User tLRPC$User, EditText editText, DialogInterface dialogInterface, int i) {
        didSelectResult(tLRPC$User, false, editText != null ? editText.getText().toString() : "0");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        Activity parentActivity;
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        ContactsAdapter contactsAdapter = this.listViewAdapter;
        if (contactsAdapter != null) {
            contactsAdapter.notifyDataSetChanged();
        }
        if (!this.checkPermission || Build.VERSION.SDK_INT < 23 || (parentActivity = getParentActivity()) == null) {
            return;
        }
        this.checkPermission = false;
        if (parentActivity.checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
            if (parentActivity.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                AlertDialog alertDialogCreate = AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$P0m9QREWBKiGHajqk-D4_dlrTd8
                    @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                    public final void run(int i) {
                        this.f$0.lambda$onResume$5$ContactsActivity(i);
                    }
                }).create();
                this.permissionDialog = alertDialogCreate;
                showDialog(alertDialogCreate);
                return;
            }
            askForPermissons(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$5$ContactsActivity(int i) {
        this.askAboutContacts = i != 0;
        if (i == 0) {
            return;
        }
        askForPermissons(false);
    }

    protected RecyclerListView getListView() {
        return this.listView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        FrameLayout frameLayout = this.floatingButtonContainer;
        if (frameLayout != null) {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.eitaa.ui.ContactsActivity.14
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ContactsActivity.this.floatingButtonContainer.setTranslationY(ContactsActivity.this.floatingHidden ? AndroidUtilities.dp(100.0f) : 0);
                    ContactsActivity.this.floatingButtonContainer.setClickable(!ContactsActivity.this.floatingHidden);
                    if (ContactsActivity.this.floatingButtonContainer != null) {
                        ContactsActivity.this.floatingButtonContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        super.onDialogDismiss(dialog);
        AlertDialog alertDialog = this.permissionDialog;
        if (alertDialog == null || dialog != alertDialog || getParentActivity() == null || !this.askAboutContacts) {
            return;
        }
        askForPermissons(false);
    }

    @TargetApi(23)
    private void askForPermissons(boolean alert) {
        Activity parentActivity = getParentActivity();
        if (parentActivity == null || !UserConfig.getInstance(this.currentAccount).syncContacts || parentActivity.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
            return;
        }
        if (alert && this.askAboutContacts) {
            showDialog(AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$WS88ppPuCtjz-GTtDNGByfD3vjk
                @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                public final void run(int i) {
                    this.f$0.lambda$askForPermissons$6$ContactsActivity(i);
                }
            }).create());
            return;
        }
        this.permissionRequestTime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.WRITE_CONTACTS");
        arrayList.add("android.permission.GET_ACCOUNTS");
        try {
            parentActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), 1);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$askForPermissons$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$askForPermissons$6$ContactsActivity(int i) {
        this.askAboutContacts = i != 0;
        if (i == 0) {
            return;
        }
        askForPermissons(false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults.length > i && "android.permission.READ_CONTACTS".equals(permissions[i])) {
                    if (grantResults[i] == 0) {
                        ContactsController.getInstance(this.currentAccount).forceImportContacts();
                        return;
                    }
                    SharedPreferences.Editor editorEdit = MessagesController.getGlobalNotificationsSettings().edit();
                    this.askAboutContacts = false;
                    editorEdit.putBoolean("askAboutContacts", false).commit();
                    if (SystemClock.elapsedRealtime() - this.permissionRequestTime < 200) {
                        try {
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", ApplicationLoader.applicationContext.getPackageName(), null));
                            getParentActivity().startActivity(intent);
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.closeSearchField();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ContactsAdapter contactsAdapter;
        if (id == NotificationCenter.contactsDidLoad) {
            ContactsAdapter contactsAdapter2 = this.listViewAdapter;
            if (contactsAdapter2 != null) {
                if (!this.sortByName) {
                    contactsAdapter2.setSortType(2, true);
                }
                this.listViewAdapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) args[0]).intValue();
            if ((MessagesController.UPDATE_MASK_AVATAR & iIntValue) != 0 || (MessagesController.UPDATE_MASK_NAME & iIntValue) != 0 || (MessagesController.UPDATE_MASK_STATUS & iIntValue) != 0) {
                updateVisibleRows(iIntValue);
            }
            if ((iIntValue & MessagesController.UPDATE_MASK_STATUS) == 0 || this.sortByName || (contactsAdapter = this.listViewAdapter) == null) {
                return;
            }
            contactsAdapter.sortOnlineContacts();
            return;
        }
        if (id == NotificationCenter.encryptedChatCreated) {
            if (this.createSecretChat && this.creatingChat) {
                TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) args[0];
                Bundle bundle = new Bundle();
                bundle.putInt("enc_id", tLRPC$EncryptedChat.id);
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                presentFragment(new ChatActivity(bundle), true);
                return;
            }
            return;
        }
        if (id == NotificationCenter.closeChats) {
            if (this.creatingChat) {
                return;
            }
            removeSelfFromStack();
        } else if (id == NotificationCenter.mxbStatusNeedReload) {
            this.listViewAdapter.notifyDataSetChanged();
        }
    }

    private void updateVisibleRows(int mask) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(mask);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean hide) {
        if (this.floatingHidden == hide) {
            return;
        }
        this.floatingHidden = hide;
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[1];
        FrameLayout frameLayout = this.floatingButtonContainer;
        Property property = View.TRANSLATION_Y;
        float[] fArr = new float[1];
        fArr[0] = this.floatingHidden ? AndroidUtilities.dp(100.0f) : 0;
        animatorArr[0] = ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(this.floatingInterpolator);
        this.floatingButtonContainer.setClickable(!hide);
        animatorSet.start();
    }

    public void setDelegate(ContactsActivityDelegate delegate) {
        this.delegate = delegate;
    }

    public void setInitialSearchString(String initialSearchString) {
        this.initialSearchString = initialSearchString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemsAnimated() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        final int iFindLastVisibleItemPosition = linearLayoutManager == null ? 0 : linearLayoutManager.findLastVisibleItemPosition();
        this.listView.invalidate();
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.ContactsActivity.15
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ContactsActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                int childCount = ContactsActivity.this.listView.getChildCount();
                AnimatorSet animatorSet = new AnimatorSet();
                for (int i = 0; i < childCount; i++) {
                    View childAt = ContactsActivity.this.listView.getChildAt(i);
                    if (ContactsActivity.this.listView.getChildAdapterPosition(childAt) > iFindLastVisibleItemPosition) {
                        childAt.setAlpha(0.0f);
                        int iMin = (int) ((Math.min(ContactsActivity.this.listView.getMeasuredHeight(), Math.max(0, childAt.getTop())) / ContactsActivity.this.listView.getMeasuredHeight()) * 100.0f);
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                        objectAnimatorOfFloat.setStartDelay(iMin);
                        objectAnimatorOfFloat.setDuration(200L);
                        animatorSet.playTogether(objectAnimatorOfFloat);
                    }
                }
                animatorSet.start();
                return true;
            }
        });
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected AnimatorSet onCustomTransitionAnimation(final boolean isOpen, final Runnable callback) {
        final ValueAnimator valueAnimatorOfFloat;
        BaseFragment baseFragment;
        float[] fArr = {0.0f, 1.0f};
        if (isOpen) {
            // fill-array-data instruction
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        } else {
            valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        }
        final ViewGroup viewGroup = (ViewGroup) this.fragmentView.getParent();
        if (this.parentLayout.fragmentsStack.size() > 1) {
            ArrayList<BaseFragment> arrayList = this.parentLayout.fragmentsStack;
            baseFragment = arrayList.get(arrayList.size() - 2);
        } else {
            baseFragment = null;
        }
        DialogsActivity dialogsActivity = baseFragment instanceof DialogsActivity ? (DialogsActivity) baseFragment : null;
        if (dialogsActivity == null) {
            return null;
        }
        final RLottieImageView floatingButton = dialogsActivity.getFloatingButton();
        View view = floatingButton.getParent() != null ? (View) floatingButton.getParent() : null;
        if (this.floatingButtonContainer == null || view == null || floatingButton.getVisibility() != 0 || Math.abs(view.getTranslationY()) > AndroidUtilities.dp(4.0f) || Math.abs(this.floatingButtonContainer.getTranslationY()) > AndroidUtilities.dp(4.0f)) {
            return null;
        }
        floatingButton.setVisibility(8);
        if (isOpen) {
            viewGroup.setAlpha(0.0f);
        }
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$CBDY7EVHv5iLMaqPsx6wXYAb4SI
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ContactsActivity.lambda$onCustomTransitionAnimation$7(valueAnimatorOfFloat, viewGroup, valueAnimator);
            }
        });
        FrameLayout frameLayout = this.floatingButtonContainer;
        if (frameLayout != null) {
            ((ViewGroup) this.fragmentView).removeView(frameLayout);
            ((FrameLayout) viewGroup.getParent()).addView(this.floatingButtonContainer);
        }
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.5f));
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ContactsActivity.16
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ContactsActivity.this.floatingButtonContainer != null) {
                    if (ContactsActivity.this.floatingButtonContainer.getParent() instanceof ViewGroup) {
                        ((ViewGroup) ContactsActivity.this.floatingButtonContainer.getParent()).removeView(ContactsActivity.this.floatingButtonContainer);
                    }
                    ((ViewGroup) ((BaseFragment) ContactsActivity.this).fragmentView).addView(ContactsActivity.this.floatingButtonContainer);
                    floatingButton.setVisibility(0);
                    if (!isOpen) {
                        floatingButton.setAnimation(R.raw.write_contacts_fab_icon_reverse, 52, 52);
                        floatingButton.getAnimatedDrawable().setCurrentFrame(ContactsActivity.this.floatingButton.getAnimatedDrawable().getCurrentFrame());
                        floatingButton.playAnimation();
                    }
                }
                callback.run();
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$GnpIUXj7X3HIgVJOYpmYWJsZepI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCustomTransitionAnimation$8$ContactsActivity(animatorSet, isOpen, floatingButton);
            }
        }, 50L);
        return animatorSet;
    }

    static /* synthetic */ void lambda$onCustomTransitionAnimation$7(ValueAnimator valueAnimator, ViewGroup viewGroup, ValueAnimator valueAnimator2) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        viewGroup.setTranslationX(AndroidUtilities.dp(48.0f) * fFloatValue);
        viewGroup.setAlpha(1.0f - fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onCustomTransitionAnimation$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onCustomTransitionAnimation$8$ContactsActivity(AnimatorSet animatorSet, boolean z, final RLottieImageView rLottieImageView) {
        this.animationIndex = getNotificationCenter().setAnimationInProgress(this.animationIndex, null);
        animatorSet.start();
        if (z) {
            this.floatingButton.setAnimation(R.raw.write_contacts_fab_icon, 52, 52);
            this.floatingButton.playAnimation();
        } else {
            this.floatingButton.setAnimation(R.raw.write_contacts_fab_icon_reverse, 52, 52);
            this.floatingButton.playAnimation();
        }
        AnimatorSet animatorSet2 = this.bounceIconAnimator;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.bounceIconAnimator = new AnimatorSet();
        float duration = this.floatingButton.getAnimatedDrawable().getDuration();
        long duration2 = 0;
        int i = 4;
        if (z) {
            for (int i2 = 0; i2 < 6; i2++) {
                AnimatorSet animatorSet3 = new AnimatorSet();
                if (i2 == 0) {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f, 0.9f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f, 0.9f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f, 0.9f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f, 0.9f));
                    animatorSet3.setDuration((long) (0.12765957f * duration));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                } else if (i2 == 1) {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.06f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.06f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.06f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.06f));
                    animatorSet3.setDuration((long) (0.3617021f * duration));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else if (i2 == 2) {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.06f, 0.9f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.06f, 0.9f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.06f, 0.9f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.06f, 0.9f));
                    animatorSet3.setDuration((long) (0.21276596f * duration));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else if (i2 == 3) {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.03f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.03f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.03f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.03f));
                    animatorSet3.setDuration((long) (duration * 0.10638298f));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else if (i2 == 4) {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.03f, 0.98f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.03f, 0.98f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.03f, 0.98f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.03f, 0.98f));
                    animatorSet3.setDuration((long) (duration * 0.10638298f));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else {
                    animatorSet3.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.98f, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.98f, 1.0f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.98f, 1.0f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.98f, 1.0f));
                    animatorSet3.setDuration((long) (0.08510638f * duration));
                    animatorSet3.setInterpolator(CubicBezierInterpolator.EASE_IN);
                }
                animatorSet3.setStartDelay(duration2);
                duration2 += animatorSet3.getDuration();
                this.bounceIconAnimator.playTogether(animatorSet3);
            }
        } else {
            for (int i3 = 0; i3 < 5; i3++) {
                AnimatorSet animatorSet4 = new AnimatorSet();
                if (i3 == 0) {
                    Animator[] animatorArr = new Animator[i];
                    animatorArr[0] = ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f, 0.9f);
                    animatorArr[1] = ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f, 0.9f);
                    animatorArr[2] = ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.0f, 0.9f);
                    animatorArr[3] = ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.0f, 0.9f);
                    animatorSet4.playTogether(animatorArr);
                    animatorSet4.setDuration((long) (0.19444445f * duration));
                    animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_OUT);
                } else if (i3 == 1) {
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.06f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.06f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.9f, 1.06f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.9f, 1.06f));
                    animatorSet4.setDuration((long) (0.22222222f * duration));
                    animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else if (i3 == 2) {
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.06f, 0.92f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.06f, 0.92f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.06f, 0.92f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.06f, 0.92f));
                    animatorSet4.setDuration((long) (0.19444445f * duration));
                    animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else if (i3 == 3) {
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 0.92f, 1.02f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.92f, 1.02f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.92f, 1.02f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.92f, 1.02f));
                    animatorSet4.setDuration((long) (0.25f * duration));
                    animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
                } else {
                    i = 4;
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_X, 1.02f, 1.0f), ObjectAnimator.ofFloat(this.floatingButton, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.02f, 1.0f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 1.02f, 1.0f), ObjectAnimator.ofFloat(rLottieImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 1.02f, 1.0f));
                    animatorSet4.setDuration((long) (duration * 0.10638298f));
                    animatorSet4.setInterpolator(CubicBezierInterpolator.EASE_IN);
                    animatorSet4.setStartDelay(duration2);
                    duration2 += animatorSet4.getDuration();
                    this.bounceIconAnimator.playTogether(animatorSet4);
                }
                i = 4;
                animatorSet4.setStartDelay(duration2);
                duration2 += animatorSet4.getDuration();
                this.bounceIconAnimator.playTogether(animatorSet4);
            }
        }
        this.bounceIconAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ContactsActivity.17
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ContactsActivity.this.floatingButton.setScaleX(1.0f);
                ContactsActivity.this.floatingButton.setScaleY(1.0f);
                rLottieImageView.setScaleX(1.0f);
                rLottieImageView.setScaleY(1.0f);
                ContactsActivity.this.bounceIconAnimator = null;
                ContactsActivity.this.getNotificationCenter().onAnimationFinish(ContactsActivity.this.animationIndex);
            }
        });
        this.bounceIconAnimator.start();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ContactsActivity$skv6pXwD85tGgvD_jF4w_2KLVno
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$9$ContactsActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SECTIONS, new Class[]{LetterSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollActive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollInactive"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, "fastScrollText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayIcon"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionIcon"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "chats_actionBackground"));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "chats_actionPressedBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_groupDrawable, Theme.dialogs_broadcastDrawable, Theme.dialogs_botDrawable}, null, "chats_nameIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, "chats_verifiedCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, "chats_verifiedBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, Theme.dialogs_offlinePaint, null, null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, Theme.dialogs_onlinePaint, null, null, "windowBackgroundWhiteBlueText3"));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_name"));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_secretName"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$9$ContactsActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(0);
                } else if (childAt instanceof ProfileSearchCell) {
                    ((ProfileSearchCell) childAt).update(0);
                }
            }
        }
    }
}
