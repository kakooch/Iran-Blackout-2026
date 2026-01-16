package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidMessenger.proxy.IdStorage;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.ChatType;
import ir.medu.shad.R;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.helper.FlavorHelper;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SecretChatHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.ContactsAdapter;
import org.rbmain.ui.Adapters.SearchAdapter;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LetterSectionCell;
import org.rbmain.ui.Cells.ProfileSearchCell;
import org.rbmain.ui.Cells.TextCell;
import org.rbmain.ui.Cells.UserCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.StickerEmptyView;

/* loaded from: classes4.dex */
public class ContactsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private boolean allowBots;
    private boolean allowSelf;
    private boolean allowUsernameSearch;
    private int animationIndex;
    private boolean askAboutContacts;
    private AnimatorSet bounceIconAnimator;
    private int channelId;
    private int chatId;
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
    private SparseArray<TLRPC$User> ignoreUsers;
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
        void didSelectContact(TLRPC$User tLRPC$User, String str, ContactsActivity contactsActivity);
    }

    public ContactsActivity(Bundle bundle) {
        super(bundle);
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
        this.fragmentName = "ContactsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.encryptedChatCreated);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.closeChats);
        this.checkPermission = UserConfig.getInstance(this.currentAccount).syncContacts;
        Bundle bundle = this.arguments;
        if (bundle != null) {
            this.onlyUsers = bundle.getBoolean("onlyUsers", false);
            this.destroyAfterSelect = this.arguments.getBoolean("destroyAfterSelect", false);
            this.returnAsResult = this.arguments.getBoolean("returnAsResult", false);
            this.createSecretChat = this.arguments.getBoolean("createSecretChat", false);
            this.createSecretChat = false;
            this.selectAlertString = this.arguments.getString("selectAlertString");
            this.allowUsernameSearch = this.arguments.getBoolean("allowUsernameSearch", true);
            this.needForwardCount = this.arguments.getBoolean("needForwardCount", true);
            this.allowBots = this.arguments.getBoolean("allowBots", true);
            this.allowSelf = this.arguments.getBoolean("allowSelf", true);
            this.channelId = this.arguments.getInt("channelId", 0);
            this.needFinishFragment = this.arguments.getBoolean("needFinishFragment", true);
            this.chatId = this.arguments.getInt("chat_id", 0);
            this.disableSections = this.arguments.getBoolean("disableSections", false);
            this.resetDelegate = this.arguments.getBoolean("resetDelegate", false);
            this.needPhonebook = this.arguments.getBoolean("needPhonebook", false);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.contactsDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.encryptedChatCreated);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.closeChats);
        this.delegate = null;
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
        getNotificationCenter().onAnimationFinish(this.animationIndex);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationProgress(boolean z, float f) {
        super.onTransitionAnimationProgress(z, f);
        this.fragmentView.invalidate();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|(2:4|(1:6)(2:7|(1:9)(1:10)))(1:11)|12|(3:14|(1:16)(1:17)|18)|19|(1:21)(2:23|(2:25|(1:30)(1:29))(11:31|89|32|35|(2:37|(1:39)(1:40))(1:41)|42|(20:46|(1:48)(1:49)|50|(1:52)(1:53)|54|(1:57)|58|(1:60)(1:61)|62|(1:64)(1:65)|66|(1:68)|69|(1:71)(1:72)|73|(1:75)|76|(1:78)(1:79)|(1:81)(1:82)|83)|84|(1:86)|87|88))|22|89|32|35|(0)(0)|42|(21:44|46|(0)(0)|50|(0)(0)|54|(0)|58|(0)(0)|62|(0)(0)|66|(0)|69|(0)(0)|73|(0)|76|(0)(0)|(0)(0)|83)|84|(0)|87|88) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0120, code lost:
    
        r23.hasGps = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0362  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r24) {
        /*
            Method dump skipped, instructions count: 877
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ContactsActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(int i, View view, int i2) {
        Activity parentActivity;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchListViewAdapter;
        boolean zIsLocationEnabled = true;
        if (adapter == searchAdapter) {
            Object item = searchAdapter.getItem(i2);
            if (item instanceof TLRPC$User) {
                TLRPC$User tLRPC$User = (TLRPC$User) item;
                if (this.searchListViewAdapter.isGlobalSearch(i2)) {
                    ArrayList<TLRPC$User> arrayList = new ArrayList<>();
                    arrayList.add(tLRPC$User);
                    MessagesController.getInstance(this.currentAccount).putUsers(arrayList, false);
                    MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(arrayList, null, false, true);
                }
                if (this.returnAsResult) {
                    SparseArray<TLRPC$User> sparseArray = this.ignoreUsers;
                    if (sparseArray == null || sparseArray.indexOfKey(tLRPC$User.id) < 0) {
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
                bundle.putInt("user_id", tLRPC$User.id);
                if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle, this)) {
                    getDialogsProxy().loadObjectInfo(IdStorage.getInstance().getDialogId(tLRPC$User.id), ChatType.User, true, null);
                    presentFragment(new ChatActivity(bundle), !(ApplicationLoader.applicationActivity.getLastFragment() instanceof MainTabFragment));
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
                if (positionInSectionForPosition == 1 && this.hasGps) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 23 && (parentActivity = getParentActivity()) != null && parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
                        presentFragment(new ActionIntroActivity(1));
                        return;
                    }
                    if (i3 >= 28) {
                        zIsLocationEnabled = ((LocationManager) ApplicationLoader.applicationContext.getSystemService("location")).isLocationEnabled();
                    } else if (i3 >= 19) {
                        try {
                            zIsLocationEnabled = Settings.Secure.getInt(ApplicationLoader.applicationContext.getContentResolver(), "location_mode", 0) != 0;
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                    if (!zIsLocationEnabled) {
                        presentFragment(new ActionIntroActivity(4));
                        return;
                    } else {
                        presentFragment(new PeopleNearbyActivity());
                        return;
                    }
                }
                return;
            }
            if (i != 0) {
                if (positionInSectionForPosition == 0) {
                    int i4 = this.chatId;
                    if (i4 == 0) {
                        i4 = this.channelId;
                    }
                    presentFragment(new GroupInviteActivity(i4));
                    return;
                }
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
                    globalMainSettings.edit().putBoolean("channel_intro", true).apply();
                    return;
                }
            }
            return;
        }
        Object item2 = this.listViewAdapter.getItem(sectionForPosition, positionInSectionForPosition);
        if (item2 instanceof TLRPC$User) {
            TLRPC$User tLRPC$User2 = (TLRPC$User) item2;
            if (this.returnAsResult) {
                SparseArray<TLRPC$User> sparseArray2 = this.ignoreUsers;
                if (sparseArray2 == null || sparseArray2.indexOfKey(tLRPC$User2.id) < 0) {
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
            bundle3.putInt("user_id", tLRPC$User2.id);
            if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle3, this)) {
                getDialogsProxy().loadObjectInfo(IdStorage.getInstance().getDialogId(tLRPC$User2.id), ChatType.User, true, null);
                presentFragment(new ChatActivity(bundle3), !(ApplicationLoader.applicationActivity.getLastFragment() instanceof MainTabFragment));
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
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f$0.lambda$createView$0(str2, dialogInterface, i5);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(String str, DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", str, null));
            intent.putExtra("sms_body", ContactsController.getInstance(this.currentAccount).getInviteText(1));
            getParentActivity().startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
        presentFragment(new NewContactActivity());
    }

    private void didSelectResult(final TLRPC$User tLRPC$User, boolean z, final String str) {
        final EditTextBoldCursor editTextBoldCursor;
        if (z && this.selectAlertString != null) {
            if (getParentActivity() == null) {
                return;
            }
            if (tLRPC$User.bot) {
                if (tLRPC$User.bot_nochats) {
                    try {
                        BulletinFactory.of(this).createErrorBulletin(LocaleController.getString("BotCantJoinGroups", R.string.BotCantJoinGroups)).show();
                        return;
                    } catch (Exception e) {
                        FileLog.e(e);
                        return;
                    }
                }
                if (this.channelId != 0) {
                    TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(this.channelId));
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                    if (ChatObject.canAddAdmins(chat)) {
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setMessage(LocaleController.getString("AddBotAsAdmin", R.string.AddBotAsAdmin));
                        builder.setPositiveButton(LocaleController.getString("MakeAdmin", R.string.MakeAdmin), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.f$0.lambda$didSelectResult$3(tLRPC$User, str, dialogInterface, i);
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
            String stringSimple = LocaleController.formatStringSimple(this.selectAlertString, UserObject.getUserName(tLRPC$User));
            if (tLRPC$User.bot || !this.needForwardCount) {
                editTextBoldCursor = null;
            } else {
                stringSimple = String.format("%s\n\n%s", stringSimple, LocaleController.getString("AddToTheGroupForwardCount", R.string.AddToTheGroupForwardCount));
                editTextBoldCursor = new EditTextBoldCursor(getParentActivity());
                editTextBoldCursor.setTextSize(1, 18.0f);
                editTextBoldCursor.setText("50");
                editTextBoldCursor.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                editTextBoldCursor.setGravity(17);
                editTextBoldCursor.setInputType(2);
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(getParentActivity(), true));
                editTextBoldCursor.addTextChangedListener(new TextWatcher(this) { // from class: org.rbmain.ui.ContactsActivity.9
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        try {
                            String string = editable.toString();
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
                                    if (!string.equals(BuildConfig.FLAVOR + iIntValue)) {
                                        editTextBoldCursor.setText(BuildConfig.FLAVOR + iIntValue);
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
            builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$didSelectResult$4(tLRPC$User, editTextBoldCursor, dialogInterface, i);
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
            contactsActivityDelegate.didSelectContact(tLRPC$User, str, this);
            if (this.resetDelegate) {
                this.delegate = null;
            }
        }
        if (this.needFinishFragment) {
            finishFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$3(TLRPC$User tLRPC$User, String str, DialogInterface dialogInterface, int i) {
        ContactsActivityDelegate contactsActivityDelegate = this.delegate;
        if (contactsActivityDelegate != null) {
            contactsActivityDelegate.didSelectContact(tLRPC$User, str, this);
            this.delegate = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didSelectResult$4(TLRPC$User tLRPC$User, EditText editText, DialogInterface dialogInterface, int i) {
        didSelectResult(tLRPC$User, false, editText != null ? editText.getText().toString() : "0");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        Activity parentActivity;
        super.onResume();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.ContactsActivity.10
            @Override // java.lang.Runnable
            public void run() {
                ContactsActivity.this.getAccountInstance().getCoreMainClass().startContactList();
            }
        });
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
                AlertDialog alertDialogCreate = AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda7
                    @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                    public final void run(int i) {
                        this.f$0.lambda$onResume$5(i);
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
    public /* synthetic */ void lambda$onResume$5(int i) {
        this.askAboutContacts = i != 0;
        if (i == 0) {
            return;
        }
        askForPermissons(false);
    }

    protected RecyclerListView getListView() {
        return this.listView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FrameLayout frameLayout = this.floatingButtonContainer;
        if (frameLayout != null) {
            frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: org.rbmain.ui.ContactsActivity.11
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        super.onDialogDismiss(dialog);
        AlertDialog alertDialog = this.permissionDialog;
        if (alertDialog == null || dialog != alertDialog || getParentActivity() == null || !this.askAboutContacts) {
            return;
        }
        askForPermissons(false);
    }

    private void askForPermissons(boolean z) {
        Activity parentActivity = getParentActivity();
        if (parentActivity == null || !UserConfig.getInstance(this.currentAccount).syncContacts || parentActivity.checkSelfPermission("android.permission.READ_CONTACTS") == 0) {
            return;
        }
        if (z && this.askAboutContacts) {
            showDialog(AlertsCreator.createContactsPermissionDialog(parentActivity, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda6
                @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                public final void run(int i) {
                    this.f$0.lambda$askForPermissons$6(i);
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
    public /* synthetic */ void lambda$askForPermissons$6(int i) {
        this.askAboutContacts = i != 0;
        if (i == 0) {
            return;
        }
        askForPermissons(false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr.length > i2 && "android.permission.READ_CONTACTS".equals(strArr[i2])) {
                    if (iArr[i2] == 0) {
                        ContactsController.getInstance(this.currentAccount).forceImportContacts();
                        return;
                    }
                    SharedPreferences.Editor editorEdit = MessagesController.getGlobalNotificationsSettings().edit();
                    this.askAboutContacts = false;
                    editorEdit.putBoolean("askAboutContacts", false).apply();
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        getAccountInstance().getCoreMainClass().stopContactList();
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.closeSearchField();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        ContactsAdapter contactsAdapter;
        if (i == NotificationCenter.contactsDidLoad) {
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
        if (i == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            if ((iIntValue & 2) != 0 || (iIntValue & 1) != 0 || (iIntValue & 4) != 0) {
                updateVisibleRows(iIntValue);
            }
            if ((iIntValue & 4) == 0 || this.sortByName || (contactsAdapter = this.listViewAdapter) == null) {
                return;
            }
            contactsAdapter.sortOnlineContacts();
            return;
        }
        if (i == NotificationCenter.encryptedChatCreated) {
            if (this.createSecretChat && this.creatingChat) {
                TLRPC$EncryptedChat tLRPC$EncryptedChat = (TLRPC$EncryptedChat) objArr[0];
                Bundle bundle = new Bundle();
                bundle.putInt("enc_id", tLRPC$EncryptedChat.id);
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.closeChats, new Object[0]);
                presentFragment(new ChatActivity(bundle), !(ApplicationLoader.applicationActivity.getLastFragment() instanceof MainTabFragment));
                return;
            }
            return;
        }
        if (i != NotificationCenter.closeChats || this.creatingChat || FlavorHelper.isRubx()) {
            return;
        }
        removeSelfFromStack();
    }

    private void updateVisibleRows(int i) {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.listView.getChildAt(i2);
                if (childAt instanceof UserCell) {
                    ((UserCell) childAt).update(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideFloatingButton(boolean z) {
        if (this.floatingHidden == z) {
            return;
        }
        this.floatingHidden = z;
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
        this.floatingButtonContainer.setClickable(!z);
        animatorSet.start();
    }

    public void setDelegate(ContactsActivityDelegate contactsActivityDelegate) {
        this.delegate = contactsActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showItemsAnimated() {
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        final int iFindLastVisibleItemPosition = linearLayoutManager == null ? 0 : linearLayoutManager.findLastVisibleItemPosition();
        this.listView.invalidate();
        this.listView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.ContactsActivity.12
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected AnimatorSet onCustomTransitionAnimation(final boolean z, final Runnable runnable) {
        final ValueAnimator valueAnimatorOfFloat;
        BaseFragment baseFragment;
        float[] fArr = {0.0f, 1.0f};
        if (z) {
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
        DialogsActivity dialogsActivityIfSelected = baseFragment instanceof DialogsActivity ? (DialogsActivity) baseFragment : null;
        if (baseFragment instanceof MainTabFragment) {
            dialogsActivityIfSelected = ((MainTabFragment) baseFragment).getDialogsActivityIfSelected();
        }
        if (dialogsActivityIfSelected == null) {
            return null;
        }
        final RLottieImageView floatingButton = dialogsActivityIfSelected.getFloatingButton();
        View view = floatingButton.getParent() != null ? (View) floatingButton.getParent() : null;
        if (this.floatingButtonContainer == null || view == null || floatingButton.getVisibility() != 0 || Math.abs(view.getTranslationY()) > AndroidUtilities.dp(4.0f) || Math.abs(this.floatingButtonContainer.getTranslationY()) > AndroidUtilities.dp(4.0f)) {
            return null;
        }
        floatingButton.setVisibility(8);
        if (z) {
            viewGroup.setAlpha(0.0f);
        }
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda0
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ContactsActivity.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ContactsActivity.this.floatingButtonContainer != null) {
                    if (ContactsActivity.this.floatingButtonContainer.getParent() instanceof ViewGroup) {
                        ((ViewGroup) ContactsActivity.this.floatingButtonContainer.getParent()).removeView(ContactsActivity.this.floatingButtonContainer);
                    }
                    ContactsActivity contactsActivity = ContactsActivity.this;
                    ((ViewGroup) contactsActivity.fragmentView).addView(contactsActivity.floatingButtonContainer);
                    floatingButton.setVisibility(0);
                    if (!z) {
                        floatingButton.setAnimation(R.raw.write_contacts_fab_icon_reverse, 52, 52);
                        floatingButton.getAnimatedDrawable().setCurrentFrame(ContactsActivity.this.floatingButton.getAnimatedDrawable().getCurrentFrame());
                        floatingButton.playAnimation();
                    }
                }
                runnable.run();
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCustomTransitionAnimation$8(animatorSet, z, floatingButton);
            }
        }, 50L);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCustomTransitionAnimation$7(ValueAnimator valueAnimator, ViewGroup viewGroup, ValueAnimator valueAnimator2) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        viewGroup.setTranslationX(AndroidUtilities.dp(48.0f) * fFloatValue);
        viewGroup.setAlpha(1.0f - fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCustomTransitionAnimation$8(AnimatorSet animatorSet, boolean z, final RLottieImageView rLottieImageView) {
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
        this.bounceIconAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ContactsActivity.14
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ContactsActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$9();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, Theme.key_actionBarDefaultSearch));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, Theme.key_actionBarDefaultSearchPlaceholder));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SECTIONS, new Class[]{LetterSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollActive));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollInactive));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_FASTSCROLL, null, null, null, null, Theme.key_fastScrollText));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
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
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayIcon));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionIcon));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_chats_actionBackground));
        arrayList.add(new ThemeDescription(this.floatingButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_chats_actionPressedBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_groupDrawable, Theme.dialogs_broadcastDrawable, Theme.dialogs_botDrawable}, null, Theme.key_chats_nameIcon));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, Theme.key_chats_verifiedCheck));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, Theme.key_chats_verifiedBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, Theme.dialogs_offlinePaint, null, null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, Theme.dialogs_onlinePaint, null, null, Theme.key_windowBackgroundWhiteBlueText3));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_name));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_secretName));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$9() {
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
