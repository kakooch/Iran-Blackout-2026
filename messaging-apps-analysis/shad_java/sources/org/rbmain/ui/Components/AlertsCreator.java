package org.rbmain.ui.Components;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.ServiceLocator;
import androidMessenger.model.UpdateObject2;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MessengerLinkHandler;
import androidMessenger.utilites.MyLog;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.exceptions.LogInException;
import ir.aaap.messengercore.model.BotButtonObject;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.aaap.messengercore.model.api.BotModels;
import ir.medu.shad.R;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SecretChatHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$ReportReason;
import org.rbmain.tgnet.TLRPC$TL_account_reportPeer;
import org.rbmain.tgnet.TLRPC$TL_account_updateProfile;
import org.rbmain.tgnet.TLRPC$TL_channels_reportSpam;
import org.rbmain.tgnet.TLRPC$TL_contacts_blockFromReplies;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputReportReasonChildAbuse;
import org.rbmain.tgnet.TLRPC$TL_inputReportReasonFake;
import org.rbmain.tgnet.TLRPC$TL_inputReportReasonPornography;
import org.rbmain.tgnet.TLRPC$TL_inputReportReasonSpam;
import org.rbmain.tgnet.TLRPC$TL_inputReportReasonViolence;
import org.rbmain.tgnet.TLRPC$TL_langPackLanguage;
import org.rbmain.tgnet.TLRPC$TL_messages_report;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserStatus;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.CacheControlActivity;
import org.rbmain.ui.Cells.AccountSelectCell;
import org.rbmain.ui.Cells.BotSelectionItemCell;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.RadioColorCell;
import org.rbmain.ui.Cells.TextColorCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.NumberPicker;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.LanguageSelectActivity;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.NotificationsCustomSettingsActivity;
import org.rbmain.ui.NotificationsSettingsActivity;
import org.rbmain.ui.ThemePreviewActivity;

/* loaded from: classes5.dex */
public class AlertsCreator {

    public interface AccountSelectDelegate {
        void didSelectAccount(int i);
    }

    public interface AskAlertDelegate {
        void onAccepted();
    }

    public interface BlockDialogCallback {
        void run(boolean z, boolean z2);
    }

    public interface DatePickerDelegate {
        void didSelectDate(int i, int i2, int i3);
    }

    public interface DismissDelegate {
        void onDismissed();
    }

    public interface ItemPickerDelegate {
        void didSelectItems(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList);

        void selectedItemChanged(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList);
    }

    public interface NumberPickerDelegate {
        void didSelectNumber(int i);
    }

    public interface ScheduleDatePickerDelegate {
        void didSelectDate(boolean z, int i);
    }

    public interface StringPickerDelegate {
        void didPickString(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createAutoDeleteDatePickerDialog$124(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createCalendarPickerDialog$53(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createChangeBioAlert$21(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createChangeNameAlert$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createDatePickerDialog$47(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDeleteMessagesAlert$96(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createMuteForPickerDialog$120(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createReportAlert$62(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createScheduleDatePickerDialog$38(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createThemeCreateDialog$99(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendReport$60(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static AlertDialog showUpdateAppAlert(Context context, String str, boolean z) {
        return null;
    }

    public static Dialog processError(int i, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLObject tLObject, Object... objArr) {
        int i2 = tLRPC$TL_error.code;
        return null;
    }

    public static void processLoginException(BaseFragment baseFragment, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(LogInException.ErrorEnum.phoneIsNotCorrect.name())) {
            showSimpleAlert(baseFragment, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
            return;
        }
        if (str.equals(LogInException.ErrorEnum.CodeIsInvalid.name())) {
            showSimpleAlert(baseFragment, LocaleController.getString("InvalidCode", R.string.InvalidCode));
            return;
        }
        if (str.equals(LogInException.ErrorEnum.CodeIsExpired.name())) {
            showSimpleAlert(baseFragment, LocaleController.getString("CodeExpired", R.string.CodeExpired));
        } else if (str.equals(LogInException.ErrorEnum.CodeIsUsed.name())) {
            showSimpleAlert(baseFragment, LocaleController.getString("CodeIsUsedError", R.string.CodeIsUsedError));
        } else {
            showSimpleAlert(baseFragment, LocaleController.getString("conneciton_server_failed_message", R.string.conneciton_server_failed_message));
        }
    }

    public static Toast showSimpleToast(BaseFragment baseFragment, String str) {
        Context parentActivity;
        if (str == null) {
            return null;
        }
        if (baseFragment != null && baseFragment.getParentActivity() != null) {
            parentActivity = baseFragment.getParentActivity();
        } else {
            parentActivity = ApplicationLoader.applicationContext;
        }
        Toast toastMakeText = Toast.makeText(parentActivity, str, 1);
        toastMakeText.show();
        return toastMakeText;
    }

    public static AlertDialog.Builder createLanguageAlert(final LaunchActivity launchActivity, final TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguage) {
        String string;
        int iIndexOf;
        if (tLRPC$TL_langPackLanguage == null) {
            return null;
        }
        tLRPC$TL_langPackLanguage.lang_code = tLRPC$TL_langPackLanguage.lang_code.replace('-', '_').toLowerCase();
        tLRPC$TL_langPackLanguage.plural_code = tLRPC$TL_langPackLanguage.plural_code.replace('-', '_').toLowerCase();
        String str = tLRPC$TL_langPackLanguage.base_lang_code;
        if (str != null) {
            tLRPC$TL_langPackLanguage.base_lang_code = str.replace('-', '_').toLowerCase();
        }
        final AlertDialog.Builder builder = new AlertDialog.Builder(launchActivity);
        if (LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals(tLRPC$TL_langPackLanguage.lang_code)) {
            builder.setTitle(LocaleController.getString("Language", R.string.Language));
            string = LocaleController.formatString("LanguageSame", R.string.LanguageSame, tLRPC$TL_langPackLanguage.name);
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
            builder.setNeutralButton(LocaleController.getString("SETTINGS", R.string.SETTINGS), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda28
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlertsCreator.lambda$createLanguageAlert$0(launchActivity, dialogInterface, i);
                }
            });
        } else if (tLRPC$TL_langPackLanguage.strings_count == 0) {
            builder.setTitle(LocaleController.getString("LanguageUnknownTitle", R.string.LanguageUnknownTitle));
            string = LocaleController.formatString("LanguageUnknownCustomAlert", R.string.LanguageUnknownCustomAlert, tLRPC$TL_langPackLanguage.name);
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
        } else {
            builder.setTitle(LocaleController.getString("LanguageTitle", R.string.LanguageTitle));
            string = tLRPC$TL_langPackLanguage.official ? LocaleController.formatString("LanguageAlert", R.string.LanguageAlert, tLRPC$TL_langPackLanguage.name, Integer.valueOf((int) Math.ceil((tLRPC$TL_langPackLanguage.translated_count / tLRPC$TL_langPackLanguage.strings_count) * 100.0f))) : LocaleController.formatString("LanguageCustomAlert", R.string.LanguageCustomAlert, tLRPC$TL_langPackLanguage.name, Integer.valueOf((int) Math.ceil((tLRPC$TL_langPackLanguage.translated_count / tLRPC$TL_langPackLanguage.strings_count) * 100.0f)));
            builder.setPositiveButton(LocaleController.getString("Change", R.string.Change), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda16
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlertsCreator.lambda$createLanguageAlert$1(tLRPC$TL_langPackLanguage, launchActivity, dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(AndroidUtilities.replaceTags(string));
        int iIndexOf2 = TextUtils.indexOf((CharSequence) spannableStringBuilder, '[');
        if (iIndexOf2 != -1) {
            int i = iIndexOf2 + 1;
            iIndexOf = TextUtils.indexOf((CharSequence) spannableStringBuilder, ']', i);
            if (iIndexOf != -1) {
                spannableStringBuilder.delete(iIndexOf, iIndexOf + 1);
                spannableStringBuilder.delete(iIndexOf2, i);
            }
        } else {
            iIndexOf = -1;
        }
        if (iIndexOf2 != -1 && iIndexOf != -1) {
            spannableStringBuilder.setSpan(new URLSpanNoUnderline(tLRPC$TL_langPackLanguage.translations_url) { // from class: org.rbmain.ui.Components.AlertsCreator.1
                @Override // org.rbmain.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View view) {
                    builder.getDismissRunnable().run();
                    super.onClick(view);
                }
            }, iIndexOf2, iIndexOf - 1, 33);
        }
        TextView textView = new TextView(launchActivity);
        textView.setText(spannableStringBuilder);
        textView.setTextSize(1, 16.0f);
        textView.setLinkTextColor(Theme.getColor(Theme.key_dialogTextLink));
        textView.setHighlightColor(Theme.getColor(Theme.key_dialogLinkSelection));
        textView.setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
        textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        builder.setView(textView);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLanguageAlert$0(LaunchActivity launchActivity, DialogInterface dialogInterface, int i) {
        launchActivity.lambda$runLinkRequest$40(new LanguageSelectActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLanguageAlert$1(TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguage, LaunchActivity launchActivity, DialogInterface dialogInterface, int i) {
        String str;
        if (tLRPC$TL_langPackLanguage.official) {
            str = "remote_" + tLRPC$TL_langPackLanguage.lang_code;
        } else {
            str = "unofficial_" + tLRPC$TL_langPackLanguage.lang_code;
        }
        LocaleController.LocaleInfo languageFromDict = LocaleController.getInstance().getLanguageFromDict(str);
        if (languageFromDict == null) {
            languageFromDict = new LocaleController.LocaleInfo();
            languageFromDict.name = tLRPC$TL_langPackLanguage.native_name;
            languageFromDict.nameEnglish = tLRPC$TL_langPackLanguage.name;
            languageFromDict.shortName = tLRPC$TL_langPackLanguage.lang_code;
            languageFromDict.baseLangCode = tLRPC$TL_langPackLanguage.base_lang_code;
            languageFromDict.pluralLangCode = tLRPC$TL_langPackLanguage.plural_code;
            languageFromDict.isRtl = tLRPC$TL_langPackLanguage.rtl;
            if (tLRPC$TL_langPackLanguage.official) {
                languageFromDict.pathToFile = "remote";
            } else {
                languageFromDict.pathToFile = "unofficial";
            }
        }
        LocaleController.getInstance().applyLanguage(languageFromDict, true, false, false, true, UserConfig.selectedAccount);
        launchActivity.rebuildAllFragments(true);
    }

    public static boolean checkSlowMode(Context context, int i, long j, boolean z) {
        TLRPC$Chat chat;
        int i2 = (int) j;
        if (i2 >= 0 || (chat = MessagesController.getInstance(i).getChat(Integer.valueOf(-i2))) == null || !chat.slowmode_enabled || ChatObject.hasAdminRights(chat)) {
            return false;
        }
        if (!z) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(i).getChatFull(chat.id);
            if (chatFull == null) {
                chatFull = MessagesStorage.getInstance(i).loadChatInfo(chat.id, ChatObject.isChannel(chat), new CountDownLatch(1), false, false);
            }
            if (chatFull != null && chatFull.slowmode_next_send_date >= ConnectionsManager.getInstance(i).getCurrentTime()) {
                z = true;
            }
        }
        if (!z) {
            return false;
        }
        createSimpleAlert(context, chat.title, LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError)).show();
        return true;
    }

    public static AlertDialog.Builder createSimpleAlert(Context context, String str) {
        return createSimpleAlert(context, null, str);
    }

    public static AlertDialog.Builder createSimpleAlert(Context context, String str, String str2) {
        if (context == null || str2 == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (str == null) {
            str = LocaleController.getString("AppName", R.string.AppName);
        }
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        return builder;
    }

    public static Dialog showSimpleAlert(BaseFragment baseFragment, String str) {
        return showSimpleAlert(baseFragment, null, str);
    }

    public static Dialog showSimpleAlert(BaseFragment baseFragment, String str, String str2) {
        if (str2 == null || baseFragment == null || baseFragment.getParentActivity() == null) {
            return null;
        }
        AlertDialog alertDialogCreate = createSimpleAlert(baseFragment.getParentActivity(), str, str2).create();
        baseFragment.showDialog(alertDialogCreate);
        return alertDialogCreate;
    }

    public static void showBlockReportSpamReplyAlert(final ChatActivity chatActivity, final MessageObject messageObject, int i, final Runnable runnable) {
        if (chatActivity == null || chatActivity.getParentActivity() == null || messageObject == null) {
            return;
        }
        final AccountInstance accountInstance = chatActivity.getAccountInstance();
        final TLRPC$User user = i > 0 ? accountInstance.getMessagesController().getUser(Integer.valueOf(i)) : null;
        final TLRPC$Chat chat = i < 0 ? accountInstance.getMessagesController().getChat(Integer.valueOf(-i)) : null;
        if (user == null && chat == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(chatActivity.getParentActivity());
        builder.setDimEnabled(runnable == null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda38
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$2(runnable, dialogInterface);
            }
        });
        builder.setTitle(LocaleController.getString("BlockUser", R.string.BlockUser));
        if (user != null) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserReplyAlert", R.string.BlockUserReplyAlert, UserObject.getFirstName(user))));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserReplyAlert", R.string.BlockUserReplyAlert, chat.title)));
        }
        LinearLayout linearLayout = new LinearLayout(chatActivity.getParentActivity());
        linearLayout.setOrientation(1);
        final CheckBoxCell[] checkBoxCellArr = {new CheckBoxCell(chatActivity.getParentActivity(), 1)};
        checkBoxCellArr[0].setBackgroundDrawable(Theme.getSelectorDrawable(false));
        checkBoxCellArr[0].setTag(0);
        checkBoxCellArr[0].setText(LocaleController.getString("DeleteReportSpam", R.string.DeleteReportSpam), BuildConfig.FLAVOR, true, false);
        checkBoxCellArr[0].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
        linearLayout.addView(checkBoxCellArr[0], LayoutHelper.createLinear(-1, -2));
        checkBoxCellArr[0].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda65
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$3(checkBoxCellArr, view);
            }
        });
        builder.setCustomViewOffset(12);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("BlockAndDeleteReplies", R.string.BlockAndDeleteReplies), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$5(user, accountInstance, chatActivity, chat, messageObject, checkBoxCellArr, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        chatActivity.showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$2(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$3(CheckBoxCell[] checkBoxCellArr, View view) {
        checkBoxCellArr[((Integer) view.getTag()).intValue()].setChecked(!checkBoxCellArr[r2.intValue()].isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$5(TLRPC$User tLRPC$User, final AccountInstance accountInstance, ChatActivity chatActivity, TLRPC$Chat tLRPC$Chat, MessageObject messageObject, CheckBoxCell[] checkBoxCellArr, DialogInterface dialogInterface, int i) {
        if (tLRPC$User != null) {
            accountInstance.getMessagesStorage().deleteUserChatHistory(chatActivity.getDialogId(), 0, tLRPC$User.id);
        } else {
            accountInstance.getMessagesStorage().deleteUserChatHistory(chatActivity.getDialogId(), 0, -tLRPC$Chat.id);
        }
        TLRPC$TL_contacts_blockFromReplies tLRPC$TL_contacts_blockFromReplies = new TLRPC$TL_contacts_blockFromReplies();
        tLRPC$TL_contacts_blockFromReplies.msg_id = messageObject.getId();
        tLRPC$TL_contacts_blockFromReplies.delete_message = true;
        tLRPC$TL_contacts_blockFromReplies.delete_history = true;
        if (checkBoxCellArr[0].isChecked()) {
            tLRPC$TL_contacts_blockFromReplies.report_spam = true;
            if (chatActivity.getParentActivity() != null) {
                chatActivity.getUndoView().showWithAction(0L, 74, (Runnable) null);
            }
        }
        accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_contacts_blockFromReplies, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda84
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$4(accountInstance, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$4(AccountInstance accountInstance, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$Updates) {
            accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void showBlockReportSpamAlert(org.rbmain.ui.ActionBar.BaseFragment r18, final long r19, final org.rbmain.tgnet.TLRPC$User r21, final org.rbmain.tgnet.TLRPC$Chat r22, final org.rbmain.tgnet.TLRPC$EncryptedChat r23, final boolean r24, org.rbmain.tgnet.TLRPC$ChatFull r25, final org.rbmain.messenger.MessagesStorage.IntCallback r26) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.showBlockReportSpamAlert(org.rbmain.ui.ActionBar.BaseFragment, long, org.rbmain.tgnet.TLRPC$User, org.rbmain.tgnet.TLRPC$Chat, org.rbmain.tgnet.TLRPC$EncryptedChat, boolean, org.rbmain.tgnet.TLRPC$ChatFull, org.rbmain.messenger.MessagesStorage$IntCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamAlert$6(CheckBoxCell[] checkBoxCellArr, View view) {
        checkBoxCellArr[((Integer) view.getTag()).intValue()].setChecked(!checkBoxCellArr[r2.intValue()].isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showBlockReportSpamAlert$7(TLRPC$User tLRPC$User, AccountInstance accountInstance, CheckBoxCell[] checkBoxCellArr, long j, TLRPC$Chat tLRPC$Chat, TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z, MessagesStorage.IntCallback intCallback, DialogInterface dialogInterface, int i) {
        if (tLRPC$User != null) {
            accountInstance.getMessagesController().blockPeer(tLRPC$User.id);
        }
        if (checkBoxCellArr == null || (checkBoxCellArr[0] != null && checkBoxCellArr[0].isChecked())) {
            accountInstance.getMessagesController().reportSpam(j, tLRPC$User, tLRPC$Chat, tLRPC$EncryptedChat, tLRPC$Chat != null && z);
        }
        if (checkBoxCellArr == null || checkBoxCellArr[1].isChecked()) {
            if (tLRPC$Chat == null || ChatObject.isNotInChat(tLRPC$Chat)) {
                accountInstance.getMessagesController().deleteDialog(j, 0);
            } else {
                accountInstance.getMessagesController().deleteParticipantFromChat((int) (-j), accountInstance.getMessagesController().getUser(Integer.valueOf(accountInstance.getUserConfig().getClientUserId())), null);
            }
            intCallback.run(1);
            return;
        }
        intCallback.run(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    public static void showCustomNotificationsDialog(final BaseFragment baseFragment, final long j, final int i, final ArrayList<NotificationsSettingsActivity.NotificationException> arrayList, final int i2, final MessagesStorage.IntCallback intCallback, final MessagesStorage.IntCallback intCallback2) throws Resources.NotFoundException {
        int i3;
        final AlertDialog.Builder builder;
        Object obj;
        int[] iArr;
        Drawable drawable;
        String[] strArr;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        final boolean zIsGlobalNotificationsEnabled = NotificationsController.getInstance(i2).isGlobalNotificationsEnabled(j);
        String[] strArr2 = new String[5];
        strArr2[0] = LocaleController.getString("NotificationsTurnOn", R.string.NotificationsTurnOn);
        ?? r8 = 1;
        strArr2[1] = LocaleController.formatString("MuteFor", R.string.MuteFor, LocaleController.formatPluralString("Hours", 1));
        strArr2[2] = LocaleController.formatString("MuteFor", R.string.MuteFor, LocaleController.formatPluralString("Days", 2));
        Drawable drawable2 = null;
        strArr2[3] = (j == 0 && (baseFragment instanceof NotificationsCustomSettingsActivity)) ? null : LocaleController.getString("NotificationsCustomize", R.string.NotificationsCustomize);
        int i4 = 4;
        strArr2[4] = LocaleController.getString("NotificationsTurnOff", R.string.NotificationsTurnOff);
        int[] iArr2 = {R.drawable.notifications_on, R.drawable.notifications_mute1h, R.drawable.notifications_mute2d, R.drawable.notifications_settings, R.drawable.notifications_off};
        LinearLayout linearLayout = new LinearLayout(baseFragment.getParentActivity());
        linearLayout.setOrientation(1);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragment.getParentActivity());
        int i5 = 0;
        View view = linearLayout;
        for (int i6 = 5; i5 < i6; i6 = 5) {
            if (strArr2[i5] == null) {
                i3 = i5;
                builder = builder2;
                obj = view;
                iArr = iArr2;
                drawable = drawable2;
                strArr = strArr2;
            } else {
                ?? textView = new TextView(baseFragment.getParentActivity());
                Drawable drawable3 = baseFragment.getParentActivity().getResources().getDrawable(iArr2[i5]);
                if (i5 == i4) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                    drawable3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_text_RedRegular), PorterDuff.Mode.MULTIPLY));
                } else {
                    textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                    drawable3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogIcon), PorterDuff.Mode.MULTIPLY));
                }
                textView.setTextSize(r8, 16.0f);
                textView.setLines(r8);
                textView.setMaxLines(r8);
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable2, drawable2, drawable2);
                textView.setTag(Integer.valueOf(i5));
                textView.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                textView.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                textView.setSingleLine(r8);
                textView.setGravity(19);
                textView.setCompoundDrawablePadding(AndroidUtilities.dp(26.0f));
                textView.setText(strArr2[i5]);
                view.addView(textView, LayoutHelper.createLinear(-1, 48, 51));
                i3 = i5;
                builder = builder2;
                obj = view;
                iArr = iArr2;
                drawable = drawable2;
                strArr = strArr2;
                textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda45
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AlertsCreator.lambda$showCustomNotificationsDialog$8(j, i2, zIsGlobalNotificationsEnabled, intCallback2, i, baseFragment, arrayList, intCallback, builder, view2);
                    }
                });
            }
            i5 = i3 + 1;
            view = obj;
            builder2 = builder;
            iArr2 = iArr;
            drawable2 = drawable;
            strArr2 = strArr;
            i4 = 4;
            r8 = 1;
        }
        AlertDialog.Builder builder3 = builder2;
        builder3.setTitle(LocaleController.getString("Notifications", R.string.Notifications));
        builder3.setView(view);
        baseFragment.showDialog(builder3.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void lambda$showCustomNotificationsDialog$8(long r18, int r20, boolean r21, org.rbmain.messenger.MessagesStorage.IntCallback r22, int r23, org.rbmain.ui.ActionBar.BaseFragment r24, java.util.ArrayList r25, org.rbmain.messenger.MessagesStorage.IntCallback r26, org.rbmain.ui.ActionBar.AlertDialog.Builder r27, android.view.View r28) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.lambda$showCustomNotificationsDialog$8(long, int, boolean, org.rbmain.messenger.MessagesStorage$IntCallback, int, org.rbmain.ui.ActionBar.BaseFragment, java.util.ArrayList, org.rbmain.messenger.MessagesStorage$IntCallback, org.rbmain.ui.ActionBar.AlertDialog$Builder, android.view.View):void");
    }

    public static AlertDialog showSecretLocationAlert(Context context, int i, final Runnable runnable, boolean z) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i2 = MessagesController.getInstance(i).availableMapProviders;
        if ((i2 & 1) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderRubika", R.string.MapPreviewProviderRubika));
            arrayList2.add(0);
        }
        if ((i2 & 2) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderGoogle", R.string.MapPreviewProviderGoogle));
            arrayList2.add(1);
        }
        if ((i2 & 4) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderYandex", R.string.MapPreviewProviderYandex));
            arrayList2.add(3);
        }
        arrayList.add(LocaleController.getString("MapPreviewProviderNobody", R.string.MapPreviewProviderNobody));
        arrayList2.add(2);
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("MapPreviewProviderTitle", R.string.MapPreviewProviderTitle));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            RadioColorCell radioColorCell = new RadioColorCell(context);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i3));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue((String) arrayList.get(i3), SharedConfig.mapPreviewType == ((Integer) arrayList2.get(i3)).intValue());
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda48
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$showSecretLocationAlert$9(arrayList2, runnable, builder, view);
                }
            });
        }
        if (!z) {
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        }
        AlertDialog alertDialogShow = builder.show();
        if (z) {
            alertDialogShow.setCanceledOnTouchOutside(false);
        }
        return alertDialogShow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showSecretLocationAlert$9(ArrayList arrayList, Runnable runnable, AlertDialog.Builder builder, View view) {
        SharedConfig.setSecretMapPreviewType(((Integer) arrayList.get(((Integer) view.getTag()).intValue())).intValue());
        if (runnable != null) {
            runnable.run();
        }
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateDayPicker(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, numberPicker2.getValue());
        calendar.set(1, numberPicker3.getValue());
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(calendar.getActualMaximum(5));
    }

    private static void checkPickerDate(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        if (i > numberPicker3.getValue()) {
            numberPicker3.setValue(i);
        }
        if (numberPicker3.getValue() == i) {
            if (i2 > numberPicker2.getValue()) {
                numberPicker2.setValue(i2);
            }
            if (i2 != numberPicker2.getValue() || i3 <= numberPicker.getValue()) {
                return;
            }
            numberPicker.setValue(i3);
        }
    }

    public static void showOpenUrlAlert(BaseFragment baseFragment, String str, boolean z, boolean z2) {
        showOpenUrlAlert(baseFragment, str, z, true, z2);
    }

    public static void showOpenUrlAlert(final BaseFragment baseFragment, final String str, boolean z, final boolean z2, boolean z3) {
        String str2;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        final long inlineReturn = baseFragment instanceof ChatActivity ? ((ChatActivity) baseFragment).getInlineReturn() : 0L;
        if (Browser.isInternalUrl(str, null) || !z3) {
            Browser.openUrl(baseFragment.getParentActivity(), str, inlineReturn == 0, z2);
            return;
        }
        if (z) {
            try {
                Uri uri = Uri.parse(str);
                str2 = uri.getScheme() + "://" + IDN.toASCII(uri.getHost(), 1) + uri.getPath();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            str2 = str;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("OpenUrlTitle", R.string.OpenUrlTitle));
        String string = LocaleController.getString("OpenUrlAlert2", R.string.OpenUrlAlert2);
        int iIndexOf = string.indexOf("%");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, str2));
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new URLSpan(str2), iIndexOf, str2.length() + iIndexOf, 33);
        }
        builder.setMessage(spannableStringBuilder);
        builder.setMessageTextViewClickable(false);
        builder.setPositiveButton(LocaleController.getString("Open", R.string.Open), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$showOpenUrlAlert$10(baseFragment, str, inlineReturn, z2, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showOpenUrlAlert$10(BaseFragment baseFragment, String str, long j, boolean z, DialogInterface dialogInterface, int i) {
        Browser.openUrl(baseFragment.getParentActivity(), str, j == 0, z);
    }

    public static void createImportDialogAlert(BaseFragment baseFragment, String str, String str2, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, final Runnable runnable) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (tLRPC$Chat == null && tLRPC$User == null) {
            return;
        }
        int currentAccount = baseFragment.getCurrentAccount();
        Activity parentActivity = baseFragment.getParentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        int clientUserId = UserConfig.getInstance(currentAccount).getClientUserId();
        TextView textView = new TextView(parentActivity);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setTextSize(1, 16.0f);
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        FrameLayout frameLayout = new FrameLayout(parentActivity);
        builder.setView(frameLayout);
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        BackupImageView backupImageView = new BackupImageView(parentActivity);
        backupImageView.setRoundRadius(AndroidUtilities.dp(20.0f));
        frameLayout.addView(backupImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 5 : 3) | 48, 22.0f, 5.0f, 22.0f, 0.0f));
        TextView textView2 = new TextView(parentActivity);
        textView2.setTextColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem));
        textView2.setTextSize(1, 20.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(LocaleController.getString("ImportMessages", R.string.ImportMessages));
        boolean z = LocaleController.isRTL;
        frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 21 : 76, 11.0f, z ? 76 : 21, 0.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
        if (tLRPC$User != null) {
            if (UserObject.isReplyUser(tLRPC$User)) {
                avatarDrawable.setSmallSize(true);
                avatarDrawable.setAvatarType(12);
                backupImageView.setImage((ImageLocation) null, (String) null, avatarDrawable, tLRPC$User);
            } else if (tLRPC$User.id == clientUserId) {
                avatarDrawable.setSmallSize(true);
                avatarDrawable.setAvatarType(1);
                backupImageView.setImage((ImageLocation) null, (String) null, avatarDrawable, tLRPC$User);
            } else {
                avatarDrawable.setSmallSize(false);
                avatarDrawable.setInfo(tLRPC$User);
                backupImageView.setForUserOrChat(tLRPC$User, avatarDrawable);
            }
        } else {
            avatarDrawable.setInfo(tLRPC$Chat);
            backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable);
        }
        textView.setText(AndroidUtilities.replaceTags(str2));
        builder.setPositiveButton(LocaleController.getString("Import", R.string.Import), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createImportDialogAlert$14(runnable, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createImportDialogAlert$14(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void createClearOrDeleteDialogAlert(BaseFragment baseFragment, boolean z, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, boolean z2, boolean z3, MessagesStorage.BooleanCallback booleanCallback) {
        createClearOrDeleteDialogAlert(baseFragment, z, tLRPC$Chat != null && tLRPC$Chat.creator, false, tLRPC$Chat, tLRPC$User, z2, z3, booleanCallback);
    }

    public static void createClearOrDeleteDialogAlert(BaseFragment baseFragment, boolean z, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, boolean z2, boolean z3, boolean z4, MessagesStorage.BooleanCallback booleanCallback, Theme.ResourcesProvider resourcesProvider) {
        createClearOrDeleteDialogAlert(baseFragment, z, tLRPC$Chat != null && tLRPC$Chat.creator, false, tLRPC$Chat, tLRPC$User, z2, z3, booleanCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void createClearOrDeleteDialogAlert(final org.rbmain.ui.ActionBar.BaseFragment r36, final boolean r37, final boolean r38, final boolean r39, final org.rbmain.tgnet.TLRPC$Chat r40, final org.rbmain.tgnet.TLRPC$User r41, final boolean r42, final boolean r43, final org.rbmain.messenger.MessagesStorage.BooleanCallback r44) {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.createClearOrDeleteDialogAlert(org.rbmain.ui.ActionBar.BaseFragment, boolean, boolean, boolean, org.rbmain.tgnet.TLRPC$Chat, org.rbmain.tgnet.TLRPC$User, boolean, boolean, org.rbmain.messenger.MessagesStorage$BooleanCallback):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$15(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$17(boolean z, boolean z2, boolean z3, final TLRPC$User tLRPC$User, final BaseFragment baseFragment, final boolean z4, final boolean z5, final TLRPC$Chat tLRPC$Chat, final boolean z6, final MessagesStorage.BooleanCallback booleanCallback, final boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (!z && !z2 && !z3) {
            if (UserObject.isUserSelf(tLRPC$User)) {
                createClearOrDeleteDialogAlert(baseFragment, z4, z5, true, tLRPC$Chat, tLRPC$User, false, z6, booleanCallback);
                return;
            } else if (tLRPC$User != null && zArr[0]) {
                MessagesStorage.getInstance(baseFragment.getCurrentAccount()).getMessagesCount(tLRPC$User.id, new MessagesStorage.IntCallback() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda83
                    @Override // org.rbmain.messenger.MessagesStorage.IntCallback
                    public final void run(int i2) {
                        AlertsCreator.lambda$createClearOrDeleteDialogAlert$16(baseFragment, z4, z5, tLRPC$Chat, tLRPC$User, z6, booleanCallback, zArr, i2);
                    }
                });
                return;
            }
        }
        if (booleanCallback != null) {
            booleanCallback.run(z2 || zArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$16(BaseFragment baseFragment, boolean z, boolean z2, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, boolean z3, MessagesStorage.BooleanCallback booleanCallback, boolean[] zArr, int i) {
        if (i >= 50) {
            createClearOrDeleteDialogAlert(baseFragment, z, z2, true, tLRPC$Chat, tLRPC$User, false, z3, booleanCallback);
        } else if (booleanCallback != null) {
            booleanCallback.run(zArr[0]);
        }
    }

    public static void createChangeBioAlert(String str, final int i, final Context context, final int i2) {
        int i3;
        String str2;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(i > 0 ? LocaleController.getString("UserBio", R.string.UserBio) : LocaleController.getString("DescriptionPlaceholder", R.string.DescriptionPlaceholder));
        if (i > 0) {
            i3 = R.string.VoipGroupBioEditAlertText;
            str2 = "VoipGroupBioEditAlertText";
        } else {
            i3 = R.string.DescriptionInfo;
            str2 = "DescriptionInfo";
        }
        builder.setMessage(LocaleController.getString(str2, i3));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        if (i < 0) {
            int i4 = -i;
            if (MessagesController.getInstance(i2).getChatFull(i4) == null) {
                MessagesController.getInstance(i2).loadFullChat(i4, ConnectionsManager.generateClassGuid(), true);
            }
        }
        final NumberTextView numberTextView = new NumberTextView(context);
        final EditText editText = new EditText(context);
        int i5 = Theme.key_voipgroup_actionBarItems;
        editText.setTextColor(Theme.getColor(i5));
        editText.setHint(i > 0 ? LocaleController.getString("UserBio", R.string.UserBio) : LocaleController.getString("DescriptionPlaceholder", R.string.DescriptionPlaceholder));
        editText.setTextSize(1, 16.0f);
        editText.setBackground(Theme.createEditTextDrawable(context, true));
        editText.setMaxLines(4);
        editText.setRawInputType(147457);
        editText.setImeOptions(6);
        InputFilter[] inputFilterArr = new InputFilter[1];
        final int i6 = i > 0 ? 70 : 255;
        inputFilterArr[0] = new CodepointsLengthInputFilter(i6) { // from class: org.rbmain.ui.Components.AlertsCreator.5
            @Override // org.rbmain.ui.Components.CodepointsLengthInputFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
                CharSequence charSequenceFilter = super.filter(charSequence, i7, i8, spanned, i9, i10);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length()) {
                    Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
                    if (vibrator != null) {
                        vibrator.vibrate(200L);
                    }
                    AndroidUtilities.shakeView(numberTextView, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        };
        editText.setFilters(inputFilterArr);
        numberTextView.setCenterAlign(true);
        numberTextView.setTextSize(15);
        numberTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText4));
        numberTextView.setImportantForAccessibility(2);
        frameLayout.addView(numberTextView, LayoutHelper.createFrame(20, 20.0f, LocaleController.isRTL ? 3 : 5, 0.0f, 14.0f, 21.0f, 0.0f));
        editText.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(24.0f) : 0, AndroidUtilities.dp(8.0f), LocaleController.isRTL ? 0 : AndroidUtilities.dp(24.0f), AndroidUtilities.dp(8.0f));
        editText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.AlertsCreator.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int iCodePointCount = i6 - Character.codePointCount(editable, 0, editable.length());
                if (iCodePointCount < 30) {
                    NumberTextView numberTextView2 = numberTextView;
                    numberTextView2.setNumber(iCodePointCount, numberTextView2.getVisibility() == 0);
                    AndroidUtilities.updateViewVisibilityAnimated(numberTextView, true);
                    return;
                }
                AndroidUtilities.updateViewVisibilityAnimated(numberTextView, false);
            }
        });
        AndroidUtilities.updateViewVisibilityAnimated(numberTextView, false, 0.0f, false);
        editText.setText(str);
        editText.setSelection(editText.getText().toString().length());
        builder.setView(frameLayout);
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                AlertsCreator.lambda$createChangeBioAlert$22(i, i2, editText, dialogInterface, i7);
            }
        };
        builder.setPositiveButton(LocaleController.getString("Save", R.string.Save), onClickListener);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda36
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AndroidUtilities.hideKeyboard(editText);
            }
        });
        frameLayout.addView(editText, LayoutHelper.createFrame(-1, -2.0f, 0, 23.0f, 12.0f, 23.0f, 21.0f));
        editText.requestFocus();
        AndroidUtilities.showKeyboard(editText);
        final AlertDialog alertDialogCreate = builder.create();
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda75
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createChangeBioAlert$24(i, alertDialogCreate, onClickListener, textView, i7, keyEvent);
            }
        });
        alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
        alertDialogCreate.show();
        alertDialogCreate.setTextColor(Theme.getColor(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createChangeBioAlert$22(int i, int i2, EditText editText, DialogInterface dialogInterface, int i3) {
        String str = BuildConfig.FLAVOR;
        if (i > 0) {
            TLRPC$UserFull userFull = MessagesController.getInstance(i2).getUserFull(UserConfig.getInstance(i2).getClientUserId());
            String strTrim = editText.getText().toString().replace("\n", " ").replaceAll(" +", " ").trim();
            if (userFull != null) {
                String str2 = userFull.about;
                if (str2 != null) {
                    str = str2;
                }
                if (str.equals(strTrim)) {
                    AndroidUtilities.hideKeyboard(editText);
                    dialogInterface.dismiss();
                    return;
                } else {
                    userFull.about = strTrim;
                    NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.userInfoDidLoad, Integer.valueOf(i), userFull);
                }
            }
            TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile = new TLRPC$TL_account_updateProfile();
            tLRPC$TL_account_updateProfile.about = strTrim;
            tLRPC$TL_account_updateProfile.flags |= 4;
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 2, Integer.valueOf(i));
            DialogsProxy.getInstance(i2).updateUserProfileBio(tLRPC$TL_account_updateProfile, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda88
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AlertsCreator.lambda$createChangeBioAlert$21(tLObject, tLRPC$TL_error);
                }
            });
        } else {
            int i4 = -i;
            TLRPC$ChatFull chatFull = MessagesController.getInstance(i2).getChatFull(i4);
            String string = editText.getText().toString();
            if (chatFull != null) {
                String str3 = chatFull.about;
                if (str3 != null) {
                    str = str3;
                }
                if (str.equals(string)) {
                    AndroidUtilities.hideKeyboard(editText);
                    dialogInterface.dismiss();
                    return;
                } else {
                    chatFull.about = string;
                    NotificationCenter notificationCenter = NotificationCenter.getInstance(i2);
                    int i5 = NotificationCenter.chatInfoDidLoad;
                    Boolean bool = Boolean.FALSE;
                    notificationCenter.postNotificationName(i5, chatFull, 0, bool, bool);
                }
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 2, Integer.valueOf(i));
            MessagesController.getInstance(i2).updateChatAbout(i4, string, chatFull);
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createChangeBioAlert$24(int i, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, TextView textView, int i2, KeyEvent keyEvent) {
        if ((i2 != 6 && (i <= 0 || keyEvent.getKeyCode() != 66)) || !alertDialog.isShowing()) {
            return false;
        }
        onClickListener.onClick(alertDialog, 0);
        return true;
    }

    public static void createChangeNameAlert(final int i, Context context, final int i2) {
        String str;
        String str2;
        int i3;
        String str3;
        final EditText editText;
        if (i > 0) {
            TLRPC$User user = MessagesController.getInstance(i2).getUser(Integer.valueOf(i));
            str = user.first_name;
            str2 = user.last_name;
        } else {
            str = MessagesController.getInstance(i2).getChat(Integer.valueOf(-i)).title;
            str2 = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (i > 0) {
            i3 = R.string.VoipEditName;
            str3 = "VoipEditName";
        } else {
            i3 = R.string.VoipEditTitle;
            str3 = "VoipEditTitle";
        }
        builder.setTitle(LocaleController.getString(str3, i3));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final EditText editText2 = new EditText(context);
        int i4 = Theme.key_voipgroup_actionBarItems;
        editText2.setTextColor(Theme.getColor(i4));
        editText2.setTextSize(1, 16.0f);
        editText2.setMaxLines(1);
        editText2.setLines(1);
        editText2.setSingleLine(true);
        editText2.setGravity(LocaleController.isRTL ? 5 : 3);
        editText2.setInputType(49152);
        editText2.setImeOptions(i > 0 ? 5 : 6);
        editText2.setHint(i > 0 ? LocaleController.getString("FirstName", R.string.FirstName) : LocaleController.getString("VoipEditTitleHint", R.string.VoipEditTitleHint));
        editText2.setBackground(Theme.createEditTextDrawable(context, true));
        editText2.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
        editText2.requestFocus();
        if (i > 0) {
            editText = new EditText(context);
            editText.setTextColor(Theme.getColor(i4));
            editText.setTextSize(1, 16.0f);
            editText.setMaxLines(1);
            editText.setLines(1);
            editText.setSingleLine(true);
            editText.setGravity(LocaleController.isRTL ? 5 : 3);
            editText.setInputType(49152);
            editText.setImeOptions(6);
            editText.setHint(LocaleController.getString("LastName", R.string.LastName));
            editText.setBackground(Theme.createEditTextDrawable(context, true));
            editText.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
        } else {
            editText = null;
        }
        AndroidUtilities.showKeyboard(editText2);
        linearLayout.addView(editText2, LayoutHelper.createLinear(-1, -2, 0, 23, 12, 23, 21));
        if (editText != null) {
            linearLayout.addView(editText, LayoutHelper.createLinear(-1, -2, 0, 23, 12, 23, 21));
        }
        editText2.setText(str);
        editText2.setSelection(editText2.getText().toString().length());
        if (editText != null) {
            editText.setText(str2);
            editText.setSelection(editText.getText().toString().length());
        }
        builder.setView(linearLayout);
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                AlertsCreator.lambda$createChangeNameAlert$26(editText2, i, i2, editText, dialogInterface, i5);
            }
        };
        builder.setPositiveButton(LocaleController.getString("Save", R.string.Save), onClickListener);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda37
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createChangeNameAlert$27(editText2, editText, dialogInterface);
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
        alertDialogCreate.show();
        alertDialogCreate.setTextColor(Theme.getColor(i4));
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda77
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createChangeNameAlert$28(alertDialogCreate, onClickListener, textView, i5, keyEvent);
            }
        };
        if (editText != null) {
            editText.setOnEditorActionListener(onEditorActionListener);
        } else {
            editText2.setOnEditorActionListener(onEditorActionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createChangeNameAlert$26(EditText editText, int i, int i2, EditText editText2, DialogInterface dialogInterface, int i3) {
        if (editText.getText() == null) {
            return;
        }
        if (i > 0) {
            TLRPC$User user = MessagesController.getInstance(i2).getUser(Integer.valueOf(i));
            String string = editText.getText().toString();
            String string2 = editText2.getText().toString();
            String str = user.first_name;
            String str2 = user.last_name;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            if (str2 == null) {
                str2 = BuildConfig.FLAVOR;
            }
            if (str.equals(string) && str2.equals(string2)) {
                dialogInterface.dismiss();
                return;
            }
            TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile = new TLRPC$TL_account_updateProfile();
            tLRPC$TL_account_updateProfile.flags = 3;
            tLRPC$TL_account_updateProfile.first_name = string;
            user.first_name = string;
            tLRPC$TL_account_updateProfile.last_name = string2;
            user.last_name = string2;
            TLRPC$User user2 = MessagesController.getInstance(i2).getUser(Integer.valueOf(UserConfig.getInstance(i2).getClientUserId()));
            if (user2 != null) {
                user2.first_name = tLRPC$TL_account_updateProfile.first_name;
                user2.last_name = tLRPC$TL_account_updateProfile.last_name;
            }
            UserConfig.getInstance(i2).saveConfig(true);
            NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
            NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.updateInterfaces, 1);
            DialogsProxy.getInstance(i2).updateUserProfileName(tLRPC$TL_account_updateProfile, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda85
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AlertsCreator.lambda$createChangeNameAlert$25(tLObject, tLRPC$TL_error);
                }
            });
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 3, Integer.valueOf(i));
        } else {
            int i4 = -i;
            TLRPC$Chat chat = MessagesController.getInstance(i2).getChat(Integer.valueOf(i4));
            String string3 = editText.getText().toString();
            String str3 = chat.title;
            if (str3 != null && str3.equals(string3)) {
                dialogInterface.dismiss();
                return;
            }
            chat.title = string3;
            NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.updateInterfaces, 16);
            MessagesController.getInstance(i2).changeChatTitle(i4, string3);
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 3, Integer.valueOf(i));
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createChangeNameAlert$27(EditText editText, EditText editText2, DialogInterface dialogInterface) {
        AndroidUtilities.hideKeyboard(editText);
        AndroidUtilities.hideKeyboard(editText2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createChangeNameAlert$28(AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, TextView textView, int i, KeyEvent keyEvent) {
        if ((i != 6 && keyEvent.getKeyCode() != 66) || !alertDialog.isShowing()) {
            return false;
        }
        onClickListener.onClick(alertDialog, 0);
        return true;
    }

    public static void createBlockDialogAlert(BaseFragment baseFragment, int i, boolean z, TLRPC$User tLRPC$User, final BlockDialogCallback blockDialogCallback) {
        String string;
        int i2;
        String str;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (i == 1 && tLRPC$User == null) {
            return;
        }
        Activity parentActivity = baseFragment.getParentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        CheckBoxCell[] checkBoxCellArr = new CheckBoxCell[2];
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        if (i == 1) {
            String name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
            builder.setTitle(LocaleController.formatString("BlockUserTitle", R.string.BlockUserTitle, name));
            string = LocaleController.getString("BlockUser", R.string.BlockUser);
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserMessage", R.string.BlockUserMessage, name)));
        } else {
            builder.setTitle(LocaleController.formatString("BlockUserTitle", R.string.BlockUserTitle, LocaleController.formatPluralString("UsersCountTitle", i)));
            string = LocaleController.getString("BlockUsers", R.string.BlockUsers);
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUsersMessage", R.string.BlockUsersMessage, LocaleController.formatPluralString("UsersCount", i))));
        }
        final boolean[] zArr = {true, true};
        final int i3 = 0;
        for (int i4 = 2; i3 < i4; i4 = 2) {
            if (i3 != 0 || z) {
                checkBoxCellArr[i3] = new CheckBoxCell(parentActivity, 1);
                checkBoxCellArr[i3].setBackgroundDrawable(Theme.getSelectorDrawable(false));
                if (i3 == 0) {
                    checkBoxCellArr[i3].setText(LocaleController.getString("ReportSpamTitle", R.string.ReportSpamTitle), BuildConfig.FLAVOR, true, false);
                } else {
                    CheckBoxCell checkBoxCell = checkBoxCellArr[i3];
                    if (i == 1) {
                        i2 = R.string.DeleteThisChatBothSides;
                        str = "DeleteThisChatBothSides";
                    } else {
                        i2 = R.string.DeleteTheseChatsBothSides;
                        str = "DeleteTheseChatsBothSides";
                    }
                    checkBoxCell.setText(LocaleController.getString(str, i2), BuildConfig.FLAVOR, true, false);
                }
                checkBoxCellArr[i3].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                linearLayout.addView(checkBoxCellArr[i3], LayoutHelper.createLinear(-1, 48));
                checkBoxCellArr[i3].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda68
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AlertsCreator.lambda$createBlockDialogAlert$29(zArr, i3, view);
                    }
                });
            }
            i3++;
        }
        builder.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                AlertsCreator.lambda$createBlockDialogAlert$30(blockDialogCallback, zArr, dialogInterface, i5);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        baseFragment.showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createBlockDialogAlert$29(boolean[] zArr, int i, View view) {
        zArr[i] = !zArr[i];
        ((CheckBoxCell) view).setChecked(zArr[i], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createBlockDialogAlert$30(BlockDialogCallback blockDialogCallback, boolean[] zArr, DialogInterface dialogInterface, int i) {
        blockDialogCallback.run(zArr[0], zArr[1]);
    }

    public static AlertDialog.Builder createDatePickerDialog(Context context, int i, int i2, int i3, int i4, int i5, int i6, String str, final boolean z, final DatePickerDelegate datePickerDelegate) {
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(1.0f);
        final NumberPicker numberPicker = new NumberPicker(context);
        final NumberPicker numberPicker2 = new NumberPicker(context);
        final NumberPicker numberPicker3 = new NumberPicker(context);
        linearLayout.addView(numberPicker2, LayoutHelper.createLinear(0, -2, 0.3f));
        numberPicker2.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda104
            @Override // org.rbmain.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i7) {
                AlertsCreator.lambda$createDatePickerDialog$31(z, numberPicker2, numberPicker, numberPicker3, numberPicker4, i7);
            }
        });
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(11);
        linearLayout.addView(numberPicker, LayoutHelper.createLinear(0, -2, 0.3f));
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda102
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i7) {
                return AlertsCreator.lambda$createDatePickerDialog$32(i7);
            }
        });
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda113
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i7, int i8) {
                AlertsCreator.updateDayPicker(numberPicker2, numberPicker, numberPicker3);
            }
        });
        numberPicker.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda105
            @Override // org.rbmain.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i7) {
                AlertsCreator.lambda$createDatePickerDialog$34(z, numberPicker2, numberPicker, numberPicker3, numberPicker4, i7);
            }
        });
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i7 = calendar.get(1);
        numberPicker3.setMinValue(i7 + i);
        numberPicker3.setMaxValue(i7 + i2);
        numberPicker3.setValue(i7 + i3);
        linearLayout.addView(numberPicker3, LayoutHelper.createLinear(0, -2, 0.4f));
        numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda112
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i8, int i9) {
                AlertsCreator.updateDayPicker(numberPicker2, numberPicker, numberPicker3);
            }
        });
        numberPicker3.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda106
            @Override // org.rbmain.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i8) {
                AlertsCreator.lambda$createDatePickerDialog$36(z, numberPicker2, numberPicker, numberPicker3, numberPicker4, i8);
            }
        });
        updateDayPicker(numberPicker2, numberPicker, numberPicker3);
        if (z) {
            checkPickerDate(numberPicker2, numberPicker, numberPicker3);
        }
        if (i4 != -1) {
            numberPicker2.setValue(i4);
            numberPicker.setValue(i5);
            numberPicker3.setValue(i6);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Set", R.string.Set), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda30
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i8) {
                AlertsCreator.lambda$createDatePickerDialog$37(z, numberPicker2, numberPicker, numberPicker3, datePickerDelegate, dialogInterface, i8);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$31(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createDatePickerDialog$32(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(2, i);
        return calendar.getDisplayName(2, 1, Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$34(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$36(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$37(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, DatePickerDelegate datePickerDelegate, DialogInterface dialogInterface, int i) {
        if (z) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
        datePickerDelegate.didSelectDate(numberPicker3.getValue(), numberPicker2.getValue(), numberPicker.getValue());
    }

    public static AlertDialog.Builder createItemPickerDialog(Context context, int i, long j, MiniFunctionModels.ButtonSelection buttonSelection, String str, final ItemPickerDelegate itemPickerDelegate) {
        final TextView textView = null;
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setWeightSum(1.0f);
        int i2 = Theme.key_chat_emojiPanelBackground;
        linearLayout.setBackgroundColor(Theme.getColor(i2));
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        CharSequence charSequence = CoreUtilities.isNotEmpty(buttonSelection.title) ? buttonSelection.title : str;
        builder.setView(linearLayout);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerListView.setVerticalScrollBarEnabled(false);
        recyclerListView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f));
        recyclerListView.setBackgroundColor(Theme.getColor(i2));
        final ArrayList arrayList = new ArrayList();
        ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList2 = buttonSelection.items;
        if (arrayList2 != null) {
            Iterator<BotButtonObject.BotButtonSimpleObject> it = arrayList2.iterator();
            while (it.hasNext()) {
                it.next().isSelected = false;
            }
        }
        linearLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f));
        if (buttonSelection.is_multi_selection) {
            FrameLayout frameLayout = new FrameLayout(context);
            TextView textView2 = new TextView(context);
            textView2.setText(charSequence);
            int i3 = Theme.key_dialogTextBlack;
            textView2.setTextColor(Theme.getColor(i3));
            textView2.setTextSize(1, 20.0f);
            textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setSingleLine(true);
            frameLayout.addView(textView2, LayoutHelper.createFrame(-2, 32.0f, (LocaleController.isRTL ? 5 : 3) | 48, 32.0f, 19.0f, 24.0f, 10.0f));
            TextView textView3 = new TextView(context);
            textView3.setText(LocaleController.getString("Done", R.string.Done));
            textView3.setTextColor(Theme.getColor(i3));
            textView3.setTextSize(1, 18.0f);
            textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            if (arrayList.size() == 0) {
                textView3.setVisibility(8);
            }
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_done);
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
            textView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            frameLayout.addView(textView3, LayoutHelper.createFrame(-2, 32.0f, (LocaleController.isRTL ? 3 : 5) | 48, 24.0f, 19.0f, 0.0f, 10.0f));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemPickerDelegate itemPickerDelegate2 = itemPickerDelegate;
                    if (itemPickerDelegate2 != null) {
                        itemPickerDelegate2.didSelectItems(arrayList);
                    }
                    builder.getDismissRunnable().run();
                }
            });
            builder.setTopViewAspectRatio(0.16559829f);
            builder.setTopView(frameLayout);
            textView = textView3;
        } else {
            builder.setTitle(charSequence);
        }
        final ItemSelectionAdapter itemSelectionAdapter = new ItemSelectionAdapter(context, i, j, buttonSelection, arrayList, new ItemPickerDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator.8
            @Override // org.rbmain.ui.Components.AlertsCreator.ItemPickerDelegate
            public void didSelectItems(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList3) {
                ItemPickerDelegate itemPickerDelegate2 = itemPickerDelegate;
                if (itemPickerDelegate2 != null) {
                    itemPickerDelegate2.didSelectItems(arrayList3);
                }
                builder.getDismissRunnable().run();
            }

            @Override // org.rbmain.ui.Components.AlertsCreator.ItemPickerDelegate
            public void selectedItemChanged(ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList3) {
                if (textView != null) {
                    if (arrayList3.size() == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                    }
                }
            }
        });
        recyclerListView.setAdapter(itemSelectionAdapter);
        if (buttonSelection.search_type != BotButtonObject.BotButtonSelection.SearchType.None) {
            linearLayout.addView(new SearchField(context, new SearchField.SearchListener() { // from class: org.rbmain.ui.Components.AlertsCreator.9
                @Override // org.rbmain.ui.Components.AlertsCreator.SearchField.SearchListener
                public void doSearch(String str2) {
                    ItemSelectionAdapter itemSelectionAdapter2 = itemSelectionAdapter;
                    if (itemSelectionAdapter2 != null) {
                        itemSelectionAdapter2.doSearch(str2);
                    }
                }
            }), 0, LayoutHelper.createFrame(-1, -2.0f));
        }
        return builder;
    }

    public static boolean checkScheduleDate(TextView textView, TextView textView2, int i, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        return checkScheduleDate(textView, textView2, 0L, i, numberPicker, numberPicker2, numberPicker3);
    }

    public static boolean checkScheduleDate(TextView textView, TextView textView2, long j, int i, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3) {
        int i2;
        long timeInMillis;
        int i3;
        int i4;
        String pluralString;
        int i5;
        int i6;
        int i7;
        int value = numberPicker.getValue();
        int value2 = numberPicker2.getValue();
        int value3 = numberPicker3.getValue();
        Calendar calendar = Calendar.getInstance();
        long jCurrentTimeMillis = System.currentTimeMillis();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int i8 = calendar.get(1);
        int i9 = calendar.get(6);
        if (j > 0) {
            i2 = i8;
            calendar.setTimeInMillis(jCurrentTimeMillis + (j * 1000));
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            timeInMillis = calendar.getTimeInMillis();
        } else {
            i2 = i8;
            timeInMillis = j;
        }
        calendar.setTimeInMillis(System.currentTimeMillis() + (value * 24 * 3600 * 1000));
        calendar.set(11, value2);
        calendar.set(12, value3);
        long timeInMillis2 = calendar.getTimeInMillis();
        long j2 = jCurrentTimeMillis + 60000;
        if (timeInMillis2 <= j2) {
            calendar.setTimeInMillis(j2);
            if (i9 != calendar.get(6)) {
                numberPicker.setValue(1);
                i7 = 11;
                i3 = 1;
            } else {
                i3 = value;
                i7 = 11;
            }
            i4 = calendar.get(i7);
            numberPicker2.setValue(i4);
            value3 = calendar.get(12);
            numberPicker3.setValue(value3);
        } else if (timeInMillis <= 0 || timeInMillis2 <= timeInMillis) {
            i3 = value;
            i4 = value2;
        } else {
            calendar.setTimeInMillis(timeInMillis);
            i3 = 7;
            numberPicker.setValue(7);
            i4 = calendar.get(11);
            numberPicker2.setValue(i4);
            value3 = calendar.get(12);
            numberPicker3.setValue(value3);
        }
        int i10 = calendar.get(1);
        calendar.setTimeInMillis(System.currentTimeMillis() + (i3 * 24 * 3600 * 1000));
        calendar.set(11, i4);
        calendar.set(12, value3);
        long timeInMillis3 = calendar.getTimeInMillis();
        if (textView != null) {
            if (i3 == 0) {
                i5 = 1;
                i6 = 0;
            } else if (i2 == i10) {
                i5 = 1;
                i6 = 1;
            } else {
                i5 = 1;
                i6 = 2;
            }
            if (i == i5) {
                i6 += 3;
            } else if (i == 2) {
                i6 += 6;
            } else if (i == 3) {
                i6 += 9;
            }
            textView.setText(LocaleController.getInstance().formatterScheduleSend[i6].format(timeInMillis3));
        }
        if (textView2 != null) {
            int i11 = (int) ((timeInMillis3 - jCurrentTimeMillis) / 1000);
            if (i11 > 86400) {
                pluralString = LocaleController.formatPluralString("DaysSchedule", i11 / 86400);
            } else if (i11 >= 3600) {
                pluralString = LocaleController.formatPluralString("HoursSchedule", i11 / 3600);
            } else if (i11 >= 60) {
                pluralString = LocaleController.formatPluralString("MinutesSchedule", i11 / 60);
            } else {
                pluralString = LocaleController.formatPluralString("SecondsSchedule", i11);
            }
            if (textView2.getTag() != null) {
                textView2.setText(LocaleController.formatString("VoipChannelScheduleInfo", R.string.VoipChannelScheduleInfo, pluralString));
            } else {
                textView2.setText(LocaleController.formatString("VoipGroupScheduleInfo", R.string.VoipGroupScheduleInfo, pluralString));
            }
        }
        return timeInMillis2 - jCurrentTimeMillis > 60000;
    }

    public static class ScheduleDatePickerColors {
        public final int backgroundColor;
        public final int buttonBackgroundColor;
        public final int buttonBackgroundPressedColor;
        public final int buttonTextColor;
        public final int iconColor;
        public final int iconSelectorColor;
        public final int subMenuBackgroundColor;
        public final int subMenuSelectorColor;
        public final int subMenuTextColor;
        public final int textColor;

        private ScheduleDatePickerColors() {
            this(Theme.getColor(Theme.key_dialogTextBlack), Theme.getColor(Theme.key_dialogBackground), Theme.getColor(Theme.key_sheet_other), Theme.getColor(Theme.key_player_actionBarSelector), Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground), Theme.getColor(Theme.key_listSelector));
        }

        public ScheduleDatePickerColors(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.buttonTextColor = Theme.getColor(Theme.key_featuredStickers_buttonText);
            this.buttonBackgroundColor = Theme.getColor(Theme.key_featuredStickers_addButton);
            this.buttonBackgroundPressedColor = Theme.getColor(Theme.key_featuredStickers_addButtonPressed);
            this.textColor = i;
            this.backgroundColor = i2;
            this.iconColor = i3;
            this.iconSelectorColor = i4;
            this.subMenuTextColor = i5;
            this.subMenuBackgroundColor = i6;
            this.subMenuSelectorColor = i7;
        }
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, ScheduleDatePickerDelegate scheduleDatePickerDelegate) {
        return createScheduleDatePickerDialog(context, j, -1L, scheduleDatePickerDelegate, (Runnable) null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, ScheduleDatePickerDelegate scheduleDatePickerDelegate, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, j, -1L, scheduleDatePickerDelegate, null, resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, ScheduleDatePickerDelegate scheduleDatePickerDelegate, ScheduleDatePickerColors scheduleDatePickerColors) {
        return createScheduleDatePickerDialog(context, j, -1L, scheduleDatePickerDelegate, null, scheduleDatePickerColors, null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, ScheduleDatePickerDelegate scheduleDatePickerDelegate, Runnable runnable, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, j, -1L, scheduleDatePickerDelegate, runnable, resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, long j2, ScheduleDatePickerDelegate scheduleDatePickerDelegate, Runnable runnable) {
        return createScheduleDatePickerDialog(context, j, j2, scheduleDatePickerDelegate, runnable, new ScheduleDatePickerColors(), null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long j, long j2, ScheduleDatePickerDelegate scheduleDatePickerDelegate, Runnable runnable, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, j, j2, scheduleDatePickerDelegate, runnable, new ScheduleDatePickerColors(), resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, final long j, long j2, final ScheduleDatePickerDelegate scheduleDatePickerDelegate, final Runnable runnable, final ScheduleDatePickerColors scheduleDatePickerColors, Theme.ResourcesProvider resourcesProvider) {
        LinearLayout linearLayout;
        NumberPicker numberPicker;
        final Calendar calendar;
        TLRPC$User user;
        TLRPC$UserStatus tLRPC$UserStatus;
        if (context == null) {
            return null;
        }
        final long clientUserId = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false);
        builder.setApplyBottomPadding(false);
        final NumberPicker numberPicker2 = new NumberPicker(context, resourcesProvider);
        numberPicker2.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker2.setTextOffset(AndroidUtilities.dp(10.0f));
        numberPicker2.setItemCount(5);
        final NumberPicker numberPicker3 = new NumberPicker(context, resourcesProvider) { // from class: org.rbmain.ui.Components.AlertsCreator.10
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i) {
                return LocaleController.formatPluralString("Hours", i);
            }
        };
        numberPicker3.setWrapSelectorWheel(true);
        numberPicker3.setAllItemsCount(24);
        numberPicker3.setItemCount(5);
        numberPicker3.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker4 = new NumberPicker(context, resourcesProvider) { // from class: org.rbmain.ui.Components.AlertsCreator.11
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i) {
                return LocaleController.formatPluralString("Minutes", i);
            }
        };
        numberPicker4.setWrapSelectorWheel(true);
        numberPicker4.setAllItemsCount(60);
        numberPicker4.setItemCount(5);
        numberPicker4.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker4.setTextOffset(-AndroidUtilities.dp(34.0f));
        LinearLayout linearLayout2 = new LinearLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.12
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i3 = point.x > point.y ? 3 : 5;
                numberPicker2.setItemCount(i3);
                numberPicker3.setItemCount(i3);
                numberPicker4.setItemCount(i3);
                numberPicker2.getLayoutParams().height = AndroidUtilities.dp(42.0f) * i3;
                numberPicker3.getLayoutParams().height = AndroidUtilities.dp(42.0f) * i3;
                numberPicker4.getLayoutParams().height = AndroidUtilities.dp(42.0f) * i3;
                this.ignoreLayout = false;
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        linearLayout2.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout2.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 51, 22, 0, 0, 4));
        TextView textView = new TextView(context);
        if (j == clientUserId) {
            textView.setText(LocaleController.getString("SetReminder", R.string.SetReminder));
        } else {
            textView.setText(LocaleController.getString("ScheduleMessage", R.string.ScheduleMessage));
        }
        textView.setTextColor(scheduleDatePickerColors.textColor);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda70
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$38(view, motionEvent);
            }
        });
        if (!DialogObject.isUserDialog(j) || j == clientUserId || (user = MessagesController.getInstance(UserConfig.selectedAccount).getUser(Long.valueOf(j))) == null || user.bot || (tLRPC$UserStatus = user.status) == null || tLRPC$UserStatus.expires <= 0) {
            linearLayout = linearLayout2;
            numberPicker = numberPicker4;
        } else {
            String firstName = UserObject.getFirstName(user);
            if (firstName.length() > 10) {
                firstName = firstName.substring(0, 10) + "…";
            }
            linearLayout = linearLayout2;
            numberPicker = numberPicker4;
            final ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, scheduleDatePickerColors.iconColor, false, resourcesProvider);
            actionBarMenuItem.setLongClickEnabled(false);
            actionBarMenuItem.setSubMenuOpenSide(2);
            actionBarMenuItem.setIcon(R.drawable.ic_ab_other);
            actionBarMenuItem.setBackgroundDrawable(Theme.createSelectorDrawable(scheduleDatePickerColors.iconSelectorColor, 1));
            frameLayout.addView(actionBarMenuItem, LayoutHelper.createFrame(40, 40.0f, 53, 0.0f, 8.0f, 5.0f, 0.0f));
            actionBarMenuItem.addSubItem(1, LocaleController.formatString("ScheduleWhenOnline", R.string.ScheduleWhenOnline, firstName));
            actionBarMenuItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda49
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createScheduleDatePickerDialog$39(actionBarMenuItem, scheduleDatePickerColors, view);
                }
            });
            actionBarMenuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda90
                @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
                public final void onItemClick(int i) {
                    AlertsCreator.lambda$createScheduleDatePickerDialog$40(scheduleDatePickerDelegate, builder, i);
                }
            });
            actionBarMenuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        }
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setWeightSum(1.0f);
        final LinearLayout linearLayout4 = linearLayout;
        linearLayout4.addView(linearLayout3, LayoutHelper.createLinear(-1, -2, 1.0f, 0, 0, 12, 0, 12));
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(jCurrentTimeMillis);
        final int i = calendar2.get(1);
        final TextView textView2 = new TextView(context) { // from class: org.rbmain.ui.Components.AlertsCreator.13
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout3.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.5f));
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(365);
        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda92
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$41(jCurrentTimeMillis, calendar2, i, i2);
            }
        });
        final NumberPicker numberPicker5 = numberPicker;
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda109
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker6, int i2, int i3) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$42(linearLayout4, textView2, clientUserId, j, numberPicker2, numberPicker3, numberPicker5, numberPicker6, i2, i3);
            }
        };
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(23);
        linearLayout3.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.2f));
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda96
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$43(i2);
            }
        });
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        final NumberPicker numberPicker6 = numberPicker;
        numberPicker6.setMinValue(0);
        numberPicker6.setMaxValue(59);
        numberPicker6.setValue(0);
        numberPicker6.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda103
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$44(i2);
            }
        });
        linearLayout3.addView(numberPicker6, LayoutHelper.createLinear(0, 270, 0.3f));
        numberPicker6.setOnValueChangedListener(onValueChangeListener);
        if (j2 <= 0 || j2 == 2147483646) {
            calendar = calendar2;
        } else {
            long j3 = 1000 * j2;
            calendar = calendar2;
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.set(11, 0);
            int timeInMillis = (int) ((j3 - calendar.getTimeInMillis()) / 86400000);
            calendar.setTimeInMillis(j3);
            if (timeInMillis >= 0) {
                numberPicker6.setValue(calendar.get(12));
                numberPicker3.setValue(calendar.get(11));
                numberPicker2.setValue(timeInMillis);
            }
        }
        final boolean[] zArr = {true};
        checkScheduleDate(textView2, null, clientUserId == j ? 1 : 0, numberPicker2, numberPicker3, numberPicker6);
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(scheduleDatePickerColors.buttonTextColor);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setBackground(Theme.AdaptiveRipple.filledRect(scheduleDatePickerColors.buttonBackgroundColor, 8.0f));
        linearLayout4.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda69
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$45(zArr, clientUserId, j, numberPicker2, numberPicker3, numberPicker6, calendar, scheduleDatePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout4);
        BottomSheet bottomSheetShow = builder.show();
        bottomSheetShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda41
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$46(runnable, zArr, dialogInterface);
            }
        });
        bottomSheetShow.setBackgroundColor(scheduleDatePickerColors.backgroundColor);
        bottomSheetShow.fixNavigationBar(scheduleDatePickerColors.backgroundColor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createScheduleDatePickerDialog$39(ActionBarMenuItem actionBarMenuItem, ScheduleDatePickerColors scheduleDatePickerColors, View view) {
        actionBarMenuItem.toggleSubMenu();
        actionBarMenuItem.setPopupItemsColor(scheduleDatePickerColors.subMenuTextColor, false);
        actionBarMenuItem.setupPopupRadialSelectors(scheduleDatePickerColors.subMenuSelectorColor);
        actionBarMenuItem.redrawPopup(scheduleDatePickerColors.subMenuBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createScheduleDatePickerDialog$40(ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, int i) {
        if (i == 1) {
            scheduleDatePickerDelegate.didSelectDate(true, 2147483646);
            builder.getDismissRunnable().run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createScheduleDatePickerDialog$41(long j, Calendar calendar, int i, int i2) {
        if (i2 == 0) {
            return LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
        }
        long j2 = j + (i2 * 86400000);
        calendar.setTimeInMillis(j2);
        if (calendar.get(1) == i) {
            return LocaleController.getInstance().formatterWeek.format(j2) + ", " + LocaleController.getInstance().formatterScheduleDay.format(j2);
        }
        return LocaleController.getInstance().formatterScheduleYear.format(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createScheduleDatePickerDialog$42(LinearLayout linearLayout, TextView textView, long j, long j2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkScheduleDate(textView, null, j == j2 ? 1 : 0, numberPicker, numberPicker2, numberPicker3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createScheduleDatePickerDialog$43(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createScheduleDatePickerDialog$44(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createScheduleDatePickerDialog$45(boolean[] zArr, long j, long j2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Calendar calendar, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
        zArr[0] = false;
        boolean zCheckScheduleDate = checkScheduleDate(null, null, j == j2 ? 1 : 0, numberPicker, numberPicker2, numberPicker3);
        calendar.setTimeInMillis(System.currentTimeMillis() + (numberPicker.getValue() * 24 * 3600 * 1000));
        calendar.set(11, numberPicker2.getValue());
        calendar.set(12, numberPicker3.getValue());
        if (zCheckScheduleDate) {
            calendar.set(13, 0);
        }
        scheduleDatePickerDelegate.didSelectDate(true, (int) (calendar.getTimeInMillis() / 1000));
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createScheduleDatePickerDialog$46(Runnable runnable, boolean[] zArr, DialogInterface dialogInterface) {
        if (runnable == null || !zArr[0]) {
            return;
        }
        runnable.run();
    }

    public static BottomSheet.Builder createDatePickerDialog(Context context, long j, final ScheduleDatePickerDelegate scheduleDatePickerDelegate) {
        LinearLayout linearLayout;
        if (context == null) {
            return null;
        }
        ScheduleDatePickerColors scheduleDatePickerColors = new ScheduleDatePickerColors();
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false);
        builder.setApplyBottomPadding(false);
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker.setTextOffset(AndroidUtilities.dp(10.0f));
        numberPicker.setItemCount(5);
        final NumberPicker numberPicker2 = new NumberPicker(context) { // from class: org.rbmain.ui.Components.AlertsCreator.14
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i) {
                return LocaleController.formatPluralString("Hours", i);
            }
        };
        numberPicker2.setItemCount(5);
        numberPicker2.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker3 = new NumberPicker(context) { // from class: org.rbmain.ui.Components.AlertsCreator.15
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i) {
                return LocaleController.formatPluralString("Minutes", i);
            }
        };
        numberPicker3.setItemCount(5);
        numberPicker3.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(34.0f));
        final LinearLayout linearLayout2 = new LinearLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.16
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i3 = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i3);
                numberPicker2.setItemCount(i3);
                numberPicker3.setItemCount(i3);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                this.ignoreLayout = false;
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        linearLayout2.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout2.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 51, 22, 0, 0, 4));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("ExpireAfter", R.string.ExpireAfter));
        textView.setTextColor(scheduleDatePickerColors.textColor);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda74
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createDatePickerDialog$47(view, motionEvent);
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setWeightSum(1.0f);
        linearLayout2.addView(linearLayout3, LayoutHelper.createLinear(-1, -2));
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        final int i = calendar.get(1);
        TextView textView2 = new TextView(context) { // from class: org.rbmain.ui.Components.AlertsCreator.17
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout3.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.5f));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(365);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda91
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createDatePickerDialog$48(jCurrentTimeMillis, calendar, i, i2);
            }
        });
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda110
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i2, int i3) {
                AlertsCreator.lambda$createDatePickerDialog$49(linearLayout2, numberPicker, numberPicker2, numberPicker3, numberPicker4, i2, i3);
            }
        };
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(23);
        linearLayout3.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.2f));
        numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda95
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createDatePickerDialog$50(i2);
            }
        });
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(59);
        numberPicker3.setValue(0);
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda100
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createDatePickerDialog$51(i2);
            }
        });
        linearLayout3.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.3f));
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        if (j <= 0 || j == 2147483646) {
            linearLayout = linearLayout2;
        } else {
            long j2 = 1000 * j;
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.set(11, 0);
            linearLayout = linearLayout2;
            int timeInMillis = (int) ((j2 - calendar.getTimeInMillis()) / 86400000);
            calendar.setTimeInMillis(j2);
            if (timeInMillis >= 0) {
                numberPicker3.setValue(calendar.get(12));
                numberPicker2.setValue(calendar.get(11));
                numberPicker.setValue(timeInMillis);
            }
        }
        checkScheduleDate(null, null, 0, numberPicker, numberPicker2, numberPicker3);
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(scheduleDatePickerColors.buttonTextColor);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), scheduleDatePickerColors.buttonBackgroundColor, scheduleDatePickerColors.buttonBackgroundPressedColor));
        textView2.setText(LocaleController.getString("SetTimeLimit", R.string.SetTimeLimit));
        LinearLayout linearLayout4 = linearLayout;
        linearLayout4.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda55
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createDatePickerDialog$52(numberPicker, numberPicker2, numberPicker3, calendar, scheduleDatePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout4);
        builder.show().setBackgroundColor(scheduleDatePickerColors.backgroundColor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createDatePickerDialog$48(long j, Calendar calendar, int i, int i2) {
        if (i2 == 0) {
            return LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
        }
        long j2 = j + (i2 * 86400000);
        calendar.setTimeInMillis(j2);
        if (calendar.get(1) == i) {
            return LocaleController.getInstance().formatterScheduleDay.format(j2);
        }
        return LocaleController.getInstance().formatterScheduleYear.format(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$49(LinearLayout linearLayout, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkScheduleDate(null, null, 0, numberPicker, numberPicker2, numberPicker3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createDatePickerDialog$50(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createDatePickerDialog$51(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDatePickerDialog$52(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Calendar calendar, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
        boolean zCheckScheduleDate = checkScheduleDate(null, null, 0, numberPicker, numberPicker2, numberPicker3);
        calendar.setTimeInMillis(System.currentTimeMillis() + (numberPicker.getValue() * 24 * 3600 * 1000));
        calendar.set(11, numberPicker2.getValue());
        calendar.set(12, numberPicker3.getValue());
        if (zCheckScheduleDate) {
            calendar.set(13, 0);
        }
        scheduleDatePickerDelegate.didSelectDate(true, (int) (calendar.getTimeInMillis() / 1000));
        builder.getDismissRunnable().run();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061 A[PHI: r1
      0x0061: PHI (r1v2 int) = (r1v1 int), (r1v4 int), (r1v4 int) binds: [B:13:0x0051, B:16:0x0059, B:17:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void checkCalendarDate(long r11, org.rbmain.ui.Components.NumberPicker r13, org.rbmain.ui.Components.NumberPicker r14, org.rbmain.ui.Components.NumberPicker r15) {
        /*
            int r0 = r13.getValue()
            int r1 = r14.getValue()
            int r2 = r15.getValue()
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            r3.setTimeInMillis(r11)
            r11 = 1
            int r12 = r3.get(r11)
            r4 = 2
            int r5 = r3.get(r4)
            r6 = 5
            int r7 = r3.get(r6)
            long r8 = java.lang.System.currentTimeMillis()
            r3.setTimeInMillis(r8)
            int r8 = r3.get(r11)
            int r9 = r3.get(r4)
            int r10 = r3.get(r6)
            if (r2 <= r8) goto L3b
            r15.setValue(r8)
            r2 = r8
        L3b:
            if (r2 != r8) goto L4b
            if (r1 <= r9) goto L43
            r14.setValue(r9)
            r1 = r9
        L43:
            if (r1 != r9) goto L4b
            if (r0 <= r10) goto L4b
            r13.setValue(r10)
            r0 = r10
        L4b:
            if (r2 >= r12) goto L51
            r15.setValue(r12)
            r2 = r12
        L51:
            if (r2 != r12) goto L61
            if (r1 >= r5) goto L59
            r14.setValue(r5)
            r1 = r5
        L59:
            if (r1 != r5) goto L61
            if (r0 >= r7) goto L61
            r13.setValue(r7)
            goto L62
        L61:
            r7 = r0
        L62:
            r3.set(r11, r2)
            r3.set(r4, r1)
            int r11 = r3.getActualMaximum(r6)
            r13.setMaxValue(r11)
            if (r7 <= r11) goto L74
            r13.setValue(r11)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.checkCalendarDate(long, org.rbmain.ui.Components.NumberPicker, org.rbmain.ui.Components.NumberPicker, org.rbmain.ui.Components.NumberPicker):void");
    }

    public static BottomSheet.Builder createCalendarPickerDialog(Context context, final long j, final MessagesStorage.IntCallback intCallback) {
        if (context == null) {
            return null;
        }
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false);
        builder.setApplyBottomPadding(false);
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setTextOffset(AndroidUtilities.dp(10.0f));
        numberPicker.setItemCount(5);
        final NumberPicker numberPicker2 = new NumberPicker(context);
        numberPicker2.setItemCount(5);
        numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker3 = new NumberPicker(context);
        numberPicker3.setItemCount(5);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(24.0f));
        final LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.18
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i3 = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i3);
                numberPicker2.setItemCount(i3);
                numberPicker3.setItemCount(i3);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i3;
                this.ignoreLayout = false;
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        linearLayout.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 51, 22, 0, 0, 4));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("ChooseDate", R.string.ChooseDate));
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda73
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createCalendarPickerDialog$53(view, motionEvent);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(1.0f);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2));
        System.currentTimeMillis();
        TextView textView2 = new TextView(context) { // from class: org.rbmain.ui.Components.AlertsCreator.19
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout2.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.25f));
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(31);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda98
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return AlertsCreator.lambda$createCalendarPickerDialog$54(i);
            }
        });
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda108
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i, int i2) {
                AlertsCreator.lambda$createCalendarPickerDialog$55(linearLayout, j, numberPicker, numberPicker2, numberPicker3, numberPicker4, i, i2);
            }
        };
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(11);
        numberPicker2.setWrapSelectorWheel(false);
        linearLayout2.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.5f));
        numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda97
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return AlertsCreator.lambda$createCalendarPickerDialog$56(i);
            }
        });
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i2 = calendar.get(1);
        numberPicker3.setMinValue(i);
        numberPicker3.setMaxValue(i2);
        numberPicker3.setWrapSelectorWheel(false);
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda99
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return AlertsCreator.lambda$createCalendarPickerDialog$57(i3);
            }
        });
        linearLayout2.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.25f));
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        numberPicker.setValue(31);
        numberPicker2.setValue(12);
        numberPicker3.setValue(i2);
        checkCalendarDate(j, numberPicker, numberPicker2, numberPicker3);
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setText(LocaleController.getString("JumpToDate", R.string.JumpToDate));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createCalendarPickerDialog$58(j, numberPicker, numberPicker2, numberPicker3, calendar, intCallback, builder, view);
            }
        });
        builder.setCustomView(linearLayout);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createCalendarPickerDialog$54(int i) {
        return BuildConfig.FLAVOR + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createCalendarPickerDialog$55(LinearLayout linearLayout, long j, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkCalendarDate(j, numberPicker, numberPicker2, numberPicker3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createCalendarPickerDialog$56(int i) {
        switch (i) {
            case 0:
                return LocaleController.getString("January", R.string.January);
            case 1:
                return LocaleController.getString("February", R.string.February);
            case 2:
                return LocaleController.getString("March", R.string.March);
            case 3:
                return LocaleController.getString("April", R.string.April);
            case 4:
                return LocaleController.getString("May", R.string.May);
            case 5:
                return LocaleController.getString("June", R.string.June);
            case 6:
                return LocaleController.getString("July", R.string.July);
            case 7:
                return LocaleController.getString("August", R.string.August);
            case 8:
                return LocaleController.getString("September", R.string.September);
            case 9:
                return LocaleController.getString("October", R.string.October);
            case 10:
                return LocaleController.getString("November", R.string.November);
            default:
                return LocaleController.getString("December", R.string.December);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createCalendarPickerDialog$57(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createCalendarPickerDialog$58(long j, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Calendar calendar, MessagesStorage.IntCallback intCallback, BottomSheet.Builder builder, View view) {
        checkCalendarDate(j, numberPicker, numberPicker2, numberPicker3);
        calendar.set(1, numberPicker3.getValue());
        calendar.set(2, numberPicker2.getValue());
        calendar.set(5, numberPicker.getValue());
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(13, 0);
        intCallback.run((int) (calendar.getTimeInMillis() / 1000));
        builder.getDismissRunnable().run();
    }

    public static void sendReport(TLRPC$InputPeer tLRPC$InputPeer, int i, String str, ArrayList<Long> arrayList) {
        TLRPC$TL_messages_report tLRPC$TL_messages_report = new TLRPC$TL_messages_report();
        tLRPC$TL_messages_report.peer = tLRPC$InputPeer;
        tLRPC$TL_messages_report.id.addAll(arrayList);
        tLRPC$TL_messages_report.message = str;
        if (i == 0) {
            tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonSpam();
        } else if (i == 1) {
            tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonFake();
        } else if (i == 2) {
            tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonViolence();
        } else if (i == 3) {
            tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonChildAbuse();
        } else if (i == 4) {
            tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonPornography();
        } else if (i == 5) {
            tLRPC$TL_messages_report.reason = new TLRPC$ReportReason() { // from class: org.rbmain.tgnet.TLRPC$TL_inputReportReasonOther
                public static int constructor = -1041980751;

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                }
            };
        }
        DialogsProxy.getInstance(UserConfig.selectedAccount).callReport(tLRPC$TL_messages_report, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda87
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AlertsCreator.lambda$sendReport$60(tLObject, tLRPC$TL_error);
            }
        });
    }

    public static void createReportAlert(final Context context, final long j, final long j2, final BaseFragment baseFragment, final Runnable runnable) {
        int[] iArr;
        final Integer[] numArr;
        CharSequence[] charSequenceArr;
        if (context == null || baseFragment == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(context);
        builder.setDimBehind(runnable == null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda39
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createReportAlert$61(runnable, dialogInterface);
            }
        });
        builder.setTitle(LocaleController.getString("ReportChat", R.string.ReportChat), true);
        if (j2 != 0) {
            CharSequence[] charSequenceArr2 = {LocaleController.getString("ReportChatSpam", R.string.ReportChatSpam), LocaleController.getString("ReportChatViolence", R.string.ReportChatViolence), LocaleController.getString("ReportChatChild", R.string.ReportChatChild), LocaleController.getString("ReportChatPornography", R.string.ReportChatPornography), LocaleController.getString("ReportChatOther", R.string.ReportChatOther)};
            iArr = new int[]{R.drawable.msg_report_spam, R.drawable.msg_report_violence, R.drawable.msg_report_abuse, R.drawable.msg_report_xxx, R.drawable.msg_report_other};
            charSequenceArr = charSequenceArr2;
            numArr = new Integer[]{102, 101, 104, 103, 100};
        } else {
            CharSequence[] charSequenceArr3 = {LocaleController.getString("ReportChatSpam", R.string.ReportChatSpam), LocaleController.getString("ReportChatFakeAccount", R.string.ReportChatFakeAccount), LocaleController.getString("ReportChatViolence", R.string.ReportChatViolence), LocaleController.getString("ReportChatChild", R.string.ReportChatChild), LocaleController.getString("ReportChatPornography", R.string.ReportChatPornography), LocaleController.getString("ReportChatOther", R.string.ReportChatOther)};
            iArr = new int[]{R.drawable.msg_report_spam, R.drawable.msg_report_fake, R.drawable.msg_report_violence, R.drawable.msg_report_abuse, R.drawable.msg_report_xxx, R.drawable.msg_report_other};
            numArr = new Integer[]{102, 106, 101, 104, 103, 100};
            charSequenceArr = charSequenceArr3;
        }
        final CharSequence[] charSequenceArr4 = charSequenceArr;
        builder.setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createReportAlert$63(j2, baseFragment, j, charSequenceArr4, numArr, context, dialogInterface, i);
            }
        });
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createReportAlert$61(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$createReportAlert$63(final long j, final BaseFragment baseFragment, final long j2, CharSequence[] charSequenceArr, final Integer[] numArr, Context context, DialogInterface dialogInterface, final int i) {
        TLRPC$TL_account_reportPeer tLRPC$TL_account_reportPeer;
        if (((j == 0 && i != 5) || (j != 0 && i != 4)) && (baseFragment instanceof ChatActivity)) {
            showReportAlert(j2, baseFragment, j, null, charSequenceArr[i].toString(), null, numArr[i].intValue());
            return;
        }
        if ((j == 0 && i == 5) || (j != 0 && i == 4)) {
            if (baseFragment instanceof ChatActivity) {
                AndroidUtilities.requestAdjustNothing(baseFragment.getParentActivity(), baseFragment.getClassGuid());
            }
            baseFragment.showDialog(new ReportAlert(context, i == 4 ? 5 : i) { // from class: org.rbmain.ui.Components.AlertsCreator.20
                @Override // org.rbmain.ui.ActionBar.BottomSheet
                public void dismissInternal() {
                    super.dismissInternal();
                    BaseFragment baseFragment2 = baseFragment;
                    if (baseFragment2 instanceof ChatActivity) {
                        ((ChatActivity) baseFragment2).checkAdjustResize();
                    }
                }

                @Override // org.rbmain.ui.Components.ReportAlert
                protected void onSend(int i2, String str) {
                    ArrayList arrayList = new ArrayList();
                    long j3 = j;
                    if (j3 != 0) {
                        arrayList.add(Long.valueOf(j3));
                    }
                    AccountInstance.getInstance(baseFragment.getCurrentAccount()).getDialogsProxy().callReport(IdStorage.getInstance().getDialogId(j2), j, null, str, numArr[i].intValue());
                    BaseFragment baseFragment2 = baseFragment;
                    if (baseFragment2 instanceof ChatActivity) {
                        ((ChatActivity) baseFragment2).getUndoView().showWithAction(0L, 74, (Runnable) null);
                    }
                }
            });
            return;
        }
        TLRPC$InputPeer inputPeer = MessagesController.getInstance(UserConfig.selectedAccount).getInputPeer((int) j2);
        if (j != 0) {
            TLRPC$TL_messages_report tLRPC$TL_messages_report = new TLRPC$TL_messages_report();
            tLRPC$TL_messages_report.peer = inputPeer;
            tLRPC$TL_messages_report.id.add(Long.valueOf(j));
            tLRPC$TL_messages_report.message = BuildConfig.FLAVOR;
            tLRPC$TL_account_reportPeer = tLRPC$TL_messages_report;
            if (i == 0) {
                tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonSpam();
                tLRPC$TL_account_reportPeer = tLRPC$TL_messages_report;
            } else if (i == 1) {
                tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonViolence();
                tLRPC$TL_account_reportPeer = tLRPC$TL_messages_report;
            } else if (i == 2) {
                tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonChildAbuse();
                tLRPC$TL_account_reportPeer = tLRPC$TL_messages_report;
            } else if (i == 3) {
                tLRPC$TL_messages_report.reason = new TLRPC$TL_inputReportReasonPornography();
                tLRPC$TL_account_reportPeer = tLRPC$TL_messages_report;
            }
        } else {
            TLRPC$TL_account_reportPeer tLRPC$TL_account_reportPeer2 = new TLRPC$TL_account_reportPeer();
            tLRPC$TL_account_reportPeer2.peer = inputPeer;
            tLRPC$TL_account_reportPeer2.message = BuildConfig.FLAVOR;
            if (i == 0) {
                tLRPC$TL_account_reportPeer2.reason = new TLRPC$TL_inputReportReasonSpam();
            } else if (i == 1) {
                tLRPC$TL_account_reportPeer2.reason = new TLRPC$TL_inputReportReasonFake();
            } else if (i == 2) {
                tLRPC$TL_account_reportPeer2.reason = new TLRPC$TL_inputReportReasonViolence();
            } else if (i == 3) {
                tLRPC$TL_account_reportPeer2.reason = new TLRPC$TL_inputReportReasonChildAbuse();
            } else if (i == 4) {
                tLRPC$TL_account_reportPeer2.reason = new TLRPC$TL_inputReportReasonPornography();
            }
            tLRPC$TL_account_reportPeer = tLRPC$TL_account_reportPeer2;
        }
        DialogsProxy.getInstance(UserConfig.selectedAccount).callReport(tLRPC$TL_account_reportPeer, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda86
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AlertsCreator.lambda$createReportAlert$62(tLObject, tLRPC$TL_error);
            }
        });
        if (baseFragment instanceof ChatActivity) {
            ((ChatActivity) baseFragment).getUndoView().showWithAction(0L, 74, (Runnable) null);
        } else {
            BulletinFactory.of(baseFragment).createReportSent().show();
        }
    }

    public static void createLiveReportAlert(final Context context, final long j, final long j2, final String str, final BaseFragment baseFragment) {
        if (context == null || baseFragment == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(context);
        builder.setTitle(LocaleController.getString("ReportChat", R.string.ReportChat), true);
        final CharSequence[] charSequenceArr = {LocaleController.getString("Cheat", R.string.Cheat), LocaleController.getString("CopyrightInfringement", R.string.CopyrightInfringement), LocaleController.getString("ChildAbuse", R.string.ChildAbuse), LocaleController.getString("ReportChatPornography", R.string.ReportChatPornography), LocaleController.getString("ReportChatSpam", R.string.ReportChatSpam), LocaleController.getString("Aggressive", R.string.Aggressive), LocaleController.getString("ReportChatOther", R.string.ReportChatOther)};
        final Integer[] numArr = {106, 105, 104, 103, 102, 101, 100};
        builder.setItems(charSequenceArr, new int[]{R.drawable.msg_report_fake, R.drawable.msg_cancel, R.drawable.msg_report_abuse, R.drawable.msg_report_xxx, R.drawable.msg_report_spam, R.drawable.msg_report_violence, R.drawable.msg_report_other}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createLiveReportAlert$64(charSequenceArr, numArr, baseFragment, context, j, j2, str, dialogInterface, i);
            }
        });
        builder.create().show();
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLiveReportAlert$64(CharSequence[] charSequenceArr, Integer[] numArr, final BaseFragment baseFragment, Context context, final long j, final long j2, final String str, DialogInterface dialogInterface, int i) {
        if (i == charSequenceArr.length - 1) {
            int iIntValue = numArr[i].intValue();
            if (baseFragment instanceof ChatActivity) {
                AndroidUtilities.requestAdjustNothing(baseFragment.getParentActivity(), baseFragment.getClassGuid());
            }
            baseFragment.showDialog(new ReportAlert(context, iIntValue) { // from class: org.rbmain.ui.Components.AlertsCreator.21
                @Override // org.rbmain.ui.ActionBar.BottomSheet
                public void dismissInternal() {
                    super.dismissInternal();
                    BaseFragment baseFragment2 = baseFragment;
                    if (baseFragment2 instanceof ChatActivity) {
                        ((ChatActivity) baseFragment2).checkAdjustResize();
                    }
                }

                @Override // org.rbmain.ui.Components.ReportAlert
                protected void onSend(int i2, String str2) {
                    AlertsCreator.showReportAlert(j, baseFragment, j2, str, str2, str2, i2);
                    BaseFragment baseFragment2 = baseFragment;
                    if (baseFragment2 instanceof ChatActivity) {
                        ((ChatActivity) baseFragment2).getUndoView().showWithAction(0L, 74, (Runnable) null);
                    }
                }
            });
            return;
        }
        if (i < 0 || i > charSequenceArr.length - 2) {
            return;
        }
        showReportAlert(j, baseFragment, j2, str, charSequenceArr[i].toString(), null, numArr[i].intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showReportAlert(long j, final BaseFragment baseFragment, final long j2, final String str, String str2, final String str3, final int i) {
        String string;
        final String dialogId = IdStorage.getInstance().getDialogId(j);
        if (j == 0) {
            string = str != null ? LocaleController.getString("Live", R.string.Live) : BuildConfig.FLAVOR;
        } else if (j2 != 0) {
            string = LocaleController.getString("Message", R.string.Message);
        } else if (j > 0) {
            string = LocaleController.getString("User", R.string.User);
        } else if (ServiceLocator.getInstance(baseFragment.getCurrentAccount()).getCoreMainClass().isChannel(dialogId)) {
            string = LocaleController.getString("Channel", R.string.Channel);
        } else {
            string = LocaleController.getString("Group", R.string.Group);
        }
        String string2 = LocaleController.formatString("ReportSpamAlertMessenger", R.string.ReportSpamAlertMessenger, string, str2);
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setMessage(string2);
        builder.setTitle(LocaleController.getString("report", R.string.report));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$showReportAlert$65(baseFragment, dialogId, j2, str, str3, i, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showReportAlert$65(BaseFragment baseFragment, String str, long j, String str2, String str3, int i, DialogInterface dialogInterface, int i2) {
        AccountInstance.getInstance(baseFragment.getCurrentAccount()).getDialogsProxy().callReport(str, j, str2, str3, i);
        if (baseFragment instanceof ChatActivity) {
            ((ChatActivity) baseFragment).getUndoView().showWithAction(0L, 74, (Runnable) null);
        }
    }

    public static void showSendMediaAlert(int i, BaseFragment baseFragment) {
        if (i == 0) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (i == 1) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedStickers", R.string.ErrorSendRestrictedStickers));
        } else if (i == 2) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedMedia", R.string.ErrorSendRestrictedMedia));
        } else if (i == 3) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedPolls", R.string.ErrorSendRestrictedPolls));
        } else if (i == 4) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedStickersAll", R.string.ErrorSendRestrictedStickersAll));
        } else if (i == 5) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedMediaAll", R.string.ErrorSendRestrictedMediaAll));
        } else if (i == 6) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedPollsAll", R.string.ErrorSendRestrictedPollsAll));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        baseFragment.showDialog(builder.create(), true, null);
    }

    public static Dialog createColorSelectDialog(Activity activity, final long j, final int i, final Runnable runnable) {
        int i2;
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        if (j != 0) {
            if (notificationsSettings.contains("color_" + j)) {
                i2 = notificationsSettings.getInt("color_" + j, -16776961);
            } else if (((int) j) < 0) {
                i2 = notificationsSettings.getInt("GroupLed", -16776961);
            } else {
                i2 = notificationsSettings.getInt("MessagesLed", -16776961);
            }
        } else if (i == 1) {
            i2 = notificationsSettings.getInt("MessagesLed", -16776961);
        } else if (i == 0) {
            i2 = notificationsSettings.getInt("GroupLed", -16776961);
        } else {
            i2 = notificationsSettings.getInt("ChannelLed", -16776961);
        }
        final LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        String[] strArr = {LocaleController.getString("ColorRed", R.string.ColorRed), LocaleController.getString("ColorOrange", R.string.ColorOrange), LocaleController.getString("ColorYellow", R.string.ColorYellow), LocaleController.getString("ColorGreen", R.string.ColorGreen), LocaleController.getString("ColorCyan", R.string.ColorCyan), LocaleController.getString("ColorBlue", R.string.ColorBlue), LocaleController.getString("ColorViolet", R.string.ColorViolet), LocaleController.getString("ColorPink", R.string.ColorPink), LocaleController.getString("ColorWhite", R.string.ColorWhite)};
        final int[] iArr = {i2};
        int i3 = 0;
        for (int i4 = 9; i3 < i4; i4 = 9) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i3));
            int[] iArr2 = TextColorCell.colors;
            radioColorCell.setCheckColor(iArr2[i3], iArr2[i3]);
            radioColorCell.setTextAndValue(strArr[i3], i2 == TextColorCell.colorsToSave[i3]);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda47
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createColorSelectDialog$67(linearLayout, iArr, view);
                }
            });
            i3++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(LocaleController.getString("LedColor", R.string.LedColor));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Set", R.string.Set), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                AlertsCreator.lambda$createColorSelectDialog$68(j, iArr, i, runnable, dialogInterface, i5);
            }
        });
        builder.setNeutralButton(LocaleController.getString("LedDisabled", R.string.LedDisabled), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                AlertsCreator.lambda$createColorSelectDialog$69(j, i, runnable, dialogInterface, i5);
            }
        });
        if (j != 0) {
            builder.setNegativeButton(LocaleController.getString("Default", R.string.Default), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    AlertsCreator.lambda$createColorSelectDialog$70(j, runnable, dialogInterface, i5);
                }
            });
        }
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createColorSelectDialog$67(LinearLayout linearLayout, int[] iArr, View view) {
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioColorCell radioColorCell = (RadioColorCell) linearLayout.getChildAt(i);
            radioColorCell.setChecked(radioColorCell == view, true);
        }
        iArr[0] = TextColorCell.colorsToSave[((Integer) view.getTag()).intValue()];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createColorSelectDialog$68(long j, int[] iArr, int i, Runnable runnable, DialogInterface dialogInterface, int i2) {
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        if (j != 0) {
            editorEdit.putInt("color_" + j, iArr[0]);
            NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannel(j);
        } else {
            if (i == 1) {
                editorEdit.putInt("MessagesLed", iArr[0]);
            } else if (i == 0) {
                editorEdit.putInt("GroupLed", iArr[0]);
            } else {
                editorEdit.putInt("ChannelLed", iArr[0]);
            }
            NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannelGlobal(i);
        }
        editorEdit.apply();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createColorSelectDialog$69(long j, int i, Runnable runnable, DialogInterface dialogInterface, int i2) {
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        if (j != 0) {
            editorEdit.putInt("color_" + j, 0);
        } else if (i == 1) {
            editorEdit.putInt("MessagesLed", 0);
        } else if (i == 0) {
            editorEdit.putInt("GroupLed", 0);
        } else {
            editorEdit.putInt("ChannelLed", 0);
        }
        editorEdit.apply();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createColorSelectDialog$70(long j, Runnable runnable, DialogInterface dialogInterface, int i) {
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        editorEdit.remove("color_" + j);
        editorEdit.apply();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createVibrationSelectDialog(Activity activity, long j, boolean z, boolean z2, Runnable runnable) {
        String str;
        if (j != 0) {
            str = "vibrate_" + j;
        } else {
            str = z ? "vibrate_group" : "vibrate_messages";
        }
        return createVibrationSelectDialog(activity, j, str, runnable);
    }

    public static Dialog createVibrationSelectDialog(Activity activity, final long j, final String str, final Runnable runnable) {
        String[] strArr;
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        int i = 0;
        if (j != 0) {
            iArr[0] = notificationsSettings.getInt(str, 0);
            if (iArr[0] == 3) {
                iArr[0] = 2;
            } else if (iArr[0] == 2) {
                iArr[0] = 3;
            }
            strArr = new String[]{LocaleController.getString("VibrationDefault", R.string.VibrationDefault), LocaleController.getString("Short", R.string.Short), LocaleController.getString("Long", R.string.Long), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled)};
        } else {
            iArr[0] = notificationsSettings.getInt(str, 0);
            if (iArr[0] == 0) {
                iArr[0] = 1;
            } else if (iArr[0] == 1) {
                iArr[0] = 2;
            } else if (iArr[0] == 2) {
                iArr[0] = 0;
            }
            strArr = new String[]{LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled), LocaleController.getString("VibrationDefault", R.string.VibrationDefault), LocaleController.getString("Short", R.string.Short), LocaleController.getString("Long", R.string.Long), LocaleController.getString("OnlyIfSilent", R.string.OnlyIfSilent)};
        }
        String[] strArr2 = strArr;
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        int i2 = 0;
        while (i2 < strArr2.length) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), i, AndroidUtilities.dp(4.0f), i);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr2[i2], iArr[i] == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda58
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createVibrationSelectDialog$71(iArr, j, str, builder, runnable, view);
                }
            });
            i2++;
            i = 0;
        }
        builder.setTitle(LocaleController.getString("Vibrate", R.string.Vibrate));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createVibrationSelectDialog$71(int[] iArr, long j, String str, AlertDialog.Builder builder, Runnable runnable, View view) {
        iArr[0] = ((Integer) view.getTag()).intValue();
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        if (j != 0) {
            if (iArr[0] == 0) {
                editorEdit.putInt(str, 0);
            } else if (iArr[0] == 1) {
                editorEdit.putInt(str, 1);
            } else if (iArr[0] == 2) {
                editorEdit.putInt(str, 3);
            } else if (iArr[0] == 3) {
                editorEdit.putInt(str, 2);
            }
            NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannel(j);
        } else {
            if (iArr[0] == 0) {
                editorEdit.putInt(str, 2);
            } else if (iArr[0] == 1) {
                editorEdit.putInt(str, 0);
            } else if (iArr[0] == 2) {
                editorEdit.putInt(str, 1);
            } else if (iArr[0] == 3) {
                editorEdit.putInt(str, 3);
            } else if (iArr[0] == 4) {
                editorEdit.putInt(str, 4);
            }
            if (str.equals("vibrate_channel")) {
                NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannelGlobal(2);
            } else if (str.equals("vibrate_group")) {
                NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannelGlobal(0);
            } else {
                NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannelGlobal(1);
            }
        }
        editorEdit.apply();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createLocationUpdateDialog(Activity activity, TLRPC$User tLRPC$User, final MessagesStorage.IntCallback intCallback) {
        final int[] iArr = new int[1];
        String[] strArr = {LocaleController.getString("SendLiveLocationFor15m", R.string.SendLiveLocationFor15m), LocaleController.getString("SendLiveLocationFor1h", R.string.SendLiveLocationFor1h), LocaleController.getString("SendLiveLocationFor8h", R.string.SendLiveLocationFor8h)};
        final LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(activity);
        if (tLRPC$User != null) {
            textView.setText(LocaleController.formatString("LiveLocationAlertPrivate", R.string.LiveLocationAlertPrivate, UserObject.getFirstName(tLRPC$User)));
        } else {
            textView.setText(LocaleController.getString("LiveLocationAlertGroup", R.string.LiveLocationAlertGroup));
        }
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setTextSize(1, 16.0f);
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, 0, 24, 8));
        int i = 0;
        while (i < 3) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr[i], iArr[0] == i);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda59
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createLocationUpdateDialog$72(iArr, linearLayout, view);
                }
            });
            i++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTopImage(new ShareLocationDrawable(activity, 0), Theme.getColor(Theme.key_dialogTopBackground));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("ShareFile", R.string.ShareFile), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda33
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$createLocationUpdateDialog$73(iArr, intCallback, dialogInterface, i2);
            }
        });
        builder.setNeutralButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLocationUpdateDialog$72(int[] iArr, LinearLayout linearLayout, View view) {
        iArr[0] = ((Integer) view.getTag()).intValue();
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof RadioColorCell) {
                ((RadioColorCell) childAt).setChecked(childAt == view, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createLocationUpdateDialog$73(int[] iArr, MessagesStorage.IntCallback intCallback, DialogInterface dialogInterface, int i) {
        int i2;
        if (iArr[0] == 0) {
            i2 = DBHelper.GET_STICKER_LIMIT;
        } else {
            i2 = iArr[0] == 1 ? 3600 : 28800;
        }
        intCallback.run(i2);
    }

    public static AlertDialog.Builder createBackgroundLocationPermissionDialog(final Activity activity, TLRPC$User tLRPC$User, final Runnable runnable) {
        if (activity == null || Build.VERSION.SDK_INT < 29) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String res = RLottieDrawable.readRes(null, Theme.getCurrentTheme().isDark() ? R.raw.permission_map_dark : R.raw.permission_map);
        String res2 = RLottieDrawable.readRes(null, Theme.getCurrentTheme().isDark() ? R.raw.permission_pin_dark : R.raw.permission_pin);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: org.rbmain.ui.Components.AlertsCreator.22
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
            }
        });
        View view = new View(activity);
        view.setBackground(SvgHelper.getDrawable(res));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        View view2 = new View(activity);
        view2.setBackground(SvgHelper.getDrawable(res2));
        frameLayout.addView(view2, LayoutHelper.createFrame(60, 82.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        BackupImageView backupImageView = new BackupImageView(activity);
        backupImageView.setRoundRadius(AndroidUtilities.dp(26.0f));
        backupImageView.setForUserOrChat(tLRPC$User, new AvatarDrawable(tLRPC$User));
        frameLayout.addView(backupImageView, LayoutHelper.createFrame(52, 52.0f, 17, 0.0f, 0.0f, 0.0f, 11.0f));
        builder.setTopView(frameLayout);
        builder.setTopViewAspectRatio(0.37820512f);
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("PermissionBackgroundLocation", R.string.PermissionBackgroundLocation)));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createBackgroundLocationPermissionDialog$74(activity, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                runnable.run();
            }
        });
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createBackgroundLocationPermissionDialog$74(Activity activity, DialogInterface dialogInterface, int i) {
        if (activity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
            activity.requestPermissions(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 30);
        }
    }

    public static AlertDialog.Builder createGigagroupConvertAlert(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String res = RLottieDrawable.readRes(null, R.raw.gigagroup);
        FrameLayout frameLayout = new FrameLayout(activity);
        if (Build.VERSION.SDK_INT >= 21) {
            frameLayout.setClipToOutline(true);
            frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: org.rbmain.ui.Components.AlertsCreator.23
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
                }
            });
        }
        View view = new View(activity);
        view.setBackground(new BitmapDrawable(SvgHelper.getBitmap(res, AndroidUtilities.dp(320.0f), AndroidUtilities.dp(127.17949f), false)));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f, 0, -1.0f, -1.0f, -1.0f, -1.0f));
        builder.setTopView(frameLayout);
        builder.setTopViewAspectRatio(0.3974359f);
        builder.setTitle(LocaleController.getString("GigagroupAlertTitle", R.string.GigagroupAlertTitle));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("GigagroupAlertText", R.string.GigagroupAlertText)));
        builder.setPositiveButton(LocaleController.getString("GigagroupAlertLearnMore", R.string.GigagroupAlertLearnMore), onClickListener);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), onClickListener2);
        return builder;
    }

    public static AlertDialog.Builder createDrawOverlayPermissionDialog(final Activity activity, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String res = RLottieDrawable.readRes(null, R.raw.pip_video_request);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-14535089, -14527894}));
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: org.rbmain.ui.Components.AlertsCreator.24
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AndroidUtilities.dp(6.0f), AndroidUtilities.dpf2(6.0f));
            }
        });
        View view = new View(activity);
        view.setBackground(new BitmapDrawable(SvgHelper.getBitmap(res, AndroidUtilities.dp(320.0f), AndroidUtilities.dp(161.36752f), false)));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f, 0, -1.0f, -1.0f, -1.0f, -1.0f));
        builder.setTopView(frameLayout);
        builder.setTitle(LocaleController.getString("PermissionDrawAboveOtherAppsTitle", R.string.PermissionDrawAboveOtherAppsTitle));
        builder.setMessage(LocaleController.getString("PermissionDrawAboveOtherApps", R.string.PermissionDrawAboveOtherApps));
        builder.setPositiveButton(LocaleController.getString("Enable", R.string.Enable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createDrawOverlayPermissionDialog$76(activity, dialogInterface, i);
            }
        });
        builder.notDrawBackgroundOnTopView(true);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), onClickListener);
        builder.setTopViewAspectRatio(0.50427353f);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDrawOverlayPermissionDialog$76(Activity activity, DialogInterface dialogInterface, int i) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        activity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())));
    }

    public static AlertDialog.Builder createDrawOverlayGroupCallPermissionDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String res = RLottieDrawable.readRes(null, R.raw.pip_voice_request);
        final GroupCallPipButton groupCallPipButton = new GroupCallPipButton(context, 0, true);
        groupCallPipButton.setImportantForAccessibility(2);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.25
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                groupCallPipButton.setTranslationY((getMeasuredHeight() * 0.28f) - (groupCallPipButton.getMeasuredWidth() / 2.0f));
                groupCallPipButton.setTranslationX((getMeasuredWidth() * 0.82f) - (groupCallPipButton.getMeasuredWidth() / 2.0f));
            }
        };
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-15128003, -15118002}));
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: org.rbmain.ui.Components.AlertsCreator.26
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AndroidUtilities.dp(6.0f), AndroidUtilities.dpf2(6.0f));
            }
        });
        View view = new View(context);
        view.setBackground(new BitmapDrawable(SvgHelper.getBitmap(res, AndroidUtilities.dp(320.0f), AndroidUtilities.dp(184.61539f), false)));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f, 0, -1.0f, -1.0f, -1.0f, -1.0f));
        frameLayout.addView(groupCallPipButton, LayoutHelper.createFrame(117, 117.0f));
        builder.setTopView(frameLayout);
        builder.setTitle(LocaleController.getString("PermissionDrawAboveOtherAppsGroupCallTitle", R.string.PermissionDrawAboveOtherAppsGroupCallTitle));
        builder.setMessage(LocaleController.getString("PermissionDrawAboveOtherAppsGroupCall", R.string.PermissionDrawAboveOtherAppsGroupCall));
        builder.setPositiveButton(LocaleController.getString("Enable", R.string.Enable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createDrawOverlayGroupCallPermissionDialog$77(context, dialogInterface, i);
            }
        });
        builder.notDrawBackgroundOnTopView(true);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTopViewAspectRatio(0.5769231f);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDrawOverlayGroupCallPermissionDialog$77(Context context, DialogInterface dialogInterface, int i) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
                    Activity activityFindActivity = AndroidUtilities.findActivity(context);
                    if (activityFindActivity instanceof LaunchActivity) {
                        activityFindActivity.startActivityForResult(intent, 105);
                    } else {
                        context.startActivity(intent);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static AlertDialog.Builder createContactsPermissionDialog(Activity activity, final MessagesStorage.IntCallback intCallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTopImage(R.drawable.permissions_contacts, Theme.getColor(Theme.key_dialogTopBackground));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("ContactsPermissionAlert", R.string.ContactsPermissionAlert)));
        builder.setPositiveButton(LocaleController.getString("ContactsPermissionAlertContinue", R.string.ContactsPermissionAlertContinue), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                intCallback.run(1);
            }
        });
        builder.setNegativeButton(LocaleController.getString("ContactsPermissionAlertNotNow", R.string.ContactsPermissionAlertNotNow), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                intCallback.run(0);
            }
        });
        return builder;
    }

    public static Dialog createFreeSpaceDialog(final LaunchActivity launchActivity) {
        final int[] iArr = new int[1];
        int i = SharedConfig.keepMedia;
        if (i == 2) {
            iArr[0] = 3;
        } else if (i == 0) {
            iArr[0] = 1;
        } else if (i == 1) {
            iArr[0] = 2;
        } else if (i == 3) {
            iArr[0] = 0;
        }
        String[] strArr = {LocaleController.formatPluralString("Days", 3), LocaleController.formatPluralString("Weeks", 1), LocaleController.formatPluralString("Months", 1), LocaleController.getString("LowDiskSpaceNeverRemove", R.string.LowDiskSpaceNeverRemove)};
        final LinearLayout linearLayout = new LinearLayout(launchActivity);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(launchActivity);
        textView.setText(LocaleController.getString("LowDiskSpaceTitle2", R.string.LowDiskSpaceTitle2));
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, 0, 24, 8));
        int i2 = 0;
        while (i2 < 4) {
            RadioColorCell radioColorCell = new RadioColorCell(launchActivity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr[i2], iArr[0] == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda60
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createFreeSpaceDialog$80(iArr, linearLayout, view);
                }
            });
            i2++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(launchActivity);
        builder.setTitle(LocaleController.getString("LowDiskSpaceTitle", R.string.LowDiskSpaceTitle));
        builder.setMessage(LocaleController.getString("LowDiskSpaceMessage", R.string.LowDiskSpaceMessage));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda32
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertsCreator.lambda$createFreeSpaceDialog$81(iArr, dialogInterface, i3);
            }
        });
        builder.setNeutralButton(LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda29
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertsCreator.lambda$createFreeSpaceDialog$82(launchActivity, dialogInterface, i3);
            }
        });
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFreeSpaceDialog$80(int[] iArr, LinearLayout linearLayout, View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        if (iIntValue == 0) {
            iArr[0] = 3;
        } else if (iIntValue == 1) {
            iArr[0] = 0;
        } else if (iIntValue == 2) {
            iArr[0] = 1;
        } else if (iIntValue == 3) {
            iArr[0] = 2;
        }
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof RadioColorCell) {
                ((RadioColorCell) childAt).setChecked(childAt == view, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFreeSpaceDialog$81(int[] iArr, DialogInterface dialogInterface, int i) {
        SharedConfig.setKeepMedia(iArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createFreeSpaceDialog$82(LaunchActivity launchActivity, DialogInterface dialogInterface, int i) {
        launchActivity.lambda$runLinkRequest$40(new CacheControlActivity());
    }

    public static Dialog createPrioritySelectDialog(Activity activity, final long j, final int i, final Runnable runnable) {
        char c;
        String[] strArr;
        int i2;
        Activity activity2 = activity;
        final SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        int i3 = 0;
        if (j != 0) {
            iArr[0] = notificationsSettings.getInt("priority_" + j, 3);
            if (iArr[0] == 3) {
                iArr[0] = 0;
            } else if (iArr[0] == 4) {
                iArr[0] = 1;
            } else {
                i2 = 5;
                if (iArr[0] == 5) {
                    iArr[0] = 2;
                } else if (iArr[0] == 0) {
                    iArr[0] = 3;
                } else {
                    iArr[0] = 4;
                }
                String[] strArr2 = new String[i2];
                strArr2[0] = LocaleController.getString("NotificationsPrioritySettings", R.string.NotificationsPrioritySettings);
                strArr2[1] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
                strArr2[2] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
                strArr2[3] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
                strArr2[4] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
                strArr = strArr2;
            }
            i2 = 5;
            String[] strArr22 = new String[i2];
            strArr22[0] = LocaleController.getString("NotificationsPrioritySettings", R.string.NotificationsPrioritySettings);
            strArr22[1] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
            strArr22[2] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
            strArr22[3] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
            strArr22[4] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
            strArr = strArr22;
        } else {
            if (i == 1) {
                iArr[0] = notificationsSettings.getInt("priority_messages", 1);
            } else if (i == 0) {
                iArr[0] = notificationsSettings.getInt("priority_group", 1);
            } else if (i == 2) {
                iArr[0] = notificationsSettings.getInt("priority_channel", 1);
            }
            if (iArr[0] == 4) {
                iArr[0] = 0;
            } else if (iArr[0] == 5) {
                iArr[0] = 1;
            } else {
                if (iArr[0] == 0) {
                    c = 2;
                    iArr[0] = 2;
                } else {
                    c = 2;
                    iArr[0] = 3;
                }
                String[] strArr3 = new String[4];
                strArr3[0] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
                strArr3[1] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
                strArr3[c] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
                strArr3[3] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
                strArr = strArr3;
            }
            c = 2;
            String[] strArr32 = new String[4];
            strArr32[0] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
            strArr32[1] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
            strArr32[c] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
            strArr32[3] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
            strArr = strArr32;
        }
        LinearLayout linearLayout = new LinearLayout(activity2);
        linearLayout.setOrientation(1);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        int i4 = 0;
        while (i4 < strArr.length) {
            RadioColorCell radioColorCell = new RadioColorCell(activity2);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), i3, AndroidUtilities.dp(4.0f), i3);
            radioColorCell.setTag(Integer.valueOf(i4));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr[i4], iArr[i3] == i4);
            linearLayout.addView(radioColorCell);
            final AlertDialog.Builder builder2 = builder;
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda57
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createPrioritySelectDialog$83(iArr, j, i, notificationsSettings, builder2, runnable, view);
                }
            });
            i4++;
            activity2 = activity;
            linearLayout = linearLayout;
            builder = builder2;
            i3 = 0;
        }
        AlertDialog.Builder builder3 = builder;
        builder3.setTitle(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance));
        builder3.setView(linearLayout);
        builder3.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder3.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPrioritySelectDialog$83(int[] iArr, long j, int i, SharedPreferences sharedPreferences, AlertDialog.Builder builder, Runnable runnable, View view) {
        int i2 = 0;
        iArr[0] = ((Integer) view.getTag()).intValue();
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        int i3 = 5;
        if (j != 0) {
            if (iArr[0] == 0) {
                i2 = 3;
            } else if (iArr[0] == 1) {
                i2 = 4;
            } else if (iArr[0] == 2) {
                i2 = 5;
            } else if (iArr[0] != 3) {
                i2 = 1;
            }
            editorEdit.putInt("priority_" + j, i2);
            NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannel(j);
        } else {
            if (iArr[0] == 0) {
                i3 = 4;
            } else if (iArr[0] != 1) {
                i3 = iArr[0] == 2 ? 0 : 1;
            }
            if (i == 1) {
                editorEdit.putInt("priority_messages", i3);
                iArr[0] = sharedPreferences.getInt("priority_messages", 1);
            } else if (i == 0) {
                editorEdit.putInt("priority_group", i3);
                iArr[0] = sharedPreferences.getInt("priority_group", 1);
            } else if (i == 2) {
                editorEdit.putInt("priority_channel", i3);
                iArr[0] = sharedPreferences.getInt("priority_channel", 1);
            }
            NotificationsController.getInstance(UserConfig.selectedAccount).deleteNotificationChannelGlobal(i);
        }
        editorEdit.apply();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createPopupSelectDialog(Activity activity, final int i, final Runnable runnable) {
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        if (i == 1) {
            iArr[0] = notificationsSettings.getInt("popupAll", 0);
        } else if (i == 0) {
            iArr[0] = notificationsSettings.getInt("popupGroup", 0);
        } else {
            iArr[0] = notificationsSettings.getInt("popupChannel", 0);
        }
        String[] strArr = {LocaleController.getString("NoPopup", R.string.NoPopup), LocaleController.getString("OnlyWhenScreenOn", R.string.OnlyWhenScreenOn), LocaleController.getString("OnlyWhenScreenOff", R.string.OnlyWhenScreenOff), LocaleController.getString("AlwaysShowPopup", R.string.AlwaysShowPopup)};
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        int i2 = 0;
        while (i2 < 4) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr[i2], iArr[0] == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda56
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createPopupSelectDialog$84(iArr, i, builder, runnable, view);
                }
            });
            i2++;
        }
        builder.setTitle(LocaleController.getString("PopupNotification", R.string.PopupNotification));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createPopupSelectDialog$84(int[] iArr, int i, AlertDialog.Builder builder, Runnable runnable, View view) {
        iArr[0] = ((Integer) view.getTag()).intValue();
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        if (i == 1) {
            editorEdit.putInt("popupAll", iArr[0]);
        } else if (i == 0) {
            editorEdit.putInt("popupGroup", iArr[0]);
        } else {
            editorEdit.putInt("popupChannel", iArr[0]);
        }
        editorEdit.apply();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createSingleChoiceDialog(Activity activity, String[] strArr, String str, int i, final DialogInterface.OnClickListener onClickListener) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        int i2 = 0;
        while (i2 < strArr.length) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
            radioColorCell.setTextAndValue(strArr[i2], i == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda50
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createSingleChoiceDialog$85(builder, onClickListener, view);
                }
            });
            i2++;
        }
        builder.setTitle(str);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createSingleChoiceDialog$85(AlertDialog.Builder builder, DialogInterface.OnClickListener onClickListener, View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        builder.getDismissRunnable().run();
        onClickListener.onClick(null, iIntValue);
    }

    public static AlertDialog.Builder createTTLAlert(Context context, final TLRPC$EncryptedChat tLRPC$EncryptedChat) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("MessageLifetime", R.string.MessageLifetime));
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(20);
        int i = tLRPC$EncryptedChat.ttl;
        if (i > 0 && i < 16) {
            numberPicker.setValue(i);
        } else if (i == 30) {
            numberPicker.setValue(16);
        } else if (i == 60) {
            numberPicker.setValue(17);
        } else if (i == 3600) {
            numberPicker.setValue(18);
        } else if (i == 86400) {
            numberPicker.setValue(19);
        } else if (i == 604800) {
            numberPicker.setValue(20);
        } else if (i == 0) {
            numberPicker.setValue(0);
        }
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda101
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createTTLAlert$86(i2);
            }
        });
        builder.setView(numberPicker);
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$createTTLAlert$87(tLRPC$EncryptedChat, numberPicker, dialogInterface, i2);
            }
        });
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createTTLAlert$86(int i) {
        if (i == 0) {
            return LocaleController.getString("ShortMessageLifetimeForever", R.string.ShortMessageLifetimeForever);
        }
        if (i >= 1 && i < 16) {
            return LocaleController.formatTTLString(i);
        }
        if (i == 16) {
            return LocaleController.formatTTLString(30);
        }
        if (i == 17) {
            return LocaleController.formatTTLString(60);
        }
        if (i == 18) {
            return LocaleController.formatTTLString(3600);
        }
        if (i == 19) {
            return LocaleController.formatTTLString(86400);
        }
        return i == 20 ? LocaleController.formatTTLString(604800) : BuildConfig.FLAVOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createTTLAlert$87(TLRPC$EncryptedChat tLRPC$EncryptedChat, NumberPicker numberPicker, DialogInterface dialogInterface, int i) {
        int i2 = tLRPC$EncryptedChat.ttl;
        int value = numberPicker.getValue();
        if (value >= 0 && value < 16) {
            tLRPC$EncryptedChat.ttl = value;
        } else if (value == 16) {
            tLRPC$EncryptedChat.ttl = 30;
        } else if (value == 17) {
            tLRPC$EncryptedChat.ttl = 60;
        } else if (value == 18) {
            tLRPC$EncryptedChat.ttl = 3600;
        } else if (value == 19) {
            tLRPC$EncryptedChat.ttl = 86400;
        } else if (value == 20) {
            tLRPC$EncryptedChat.ttl = 604800;
        }
        if (i2 != tLRPC$EncryptedChat.ttl) {
            SecretChatHelper.getInstance(UserConfig.selectedAccount).sendTTLMessage(tLRPC$EncryptedChat, null);
            MessagesStorage.getInstance(UserConfig.selectedAccount).updateEncryptedChatTTL(tLRPC$EncryptedChat);
        }
    }

    public static AlertDialog createAccountSelectDialog(Activity activity, final AccountSelectDelegate accountSelectDelegate) {
        if (UserConfig.getActivatedAccountsCount() < 2) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final Runnable dismissRunnable = builder.getDismissRunnable();
        final AlertDialog[] alertDialogArr = new AlertDialog[1];
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        for (int i = 0; i < 3; i++) {
            if (UserConfig.getInstance(i).getCurrentUser() != null) {
                AccountSelectCell accountSelectCell = new AccountSelectCell(activity, false);
                accountSelectCell.setAccount(i, false);
                accountSelectCell.setPadding(AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(14.0f), 0);
                accountSelectCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                linearLayout.addView(accountSelectCell, LayoutHelper.createLinear(-1, 50));
                accountSelectCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda63
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AlertsCreator.lambda$createAccountSelectDialog$88(alertDialogArr, dismissRunnable, accountSelectDelegate, view);
                    }
                });
            }
        }
        builder.setTitle(LocaleController.getString("SelectAccount", R.string.SelectAccount));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogArr[0] = alertDialogCreate;
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAccountSelectDialog$88(AlertDialog[] alertDialogArr, Runnable runnable, AccountSelectDelegate accountSelectDelegate, View view) {
        if (alertDialogArr[0] != null) {
            alertDialogArr[0].setOnDismissListener(null);
        }
        runnable.run();
        accountSelectDelegate.didSelectAccount(((AccountSelectCell) view).getAccountNumber());
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void createDeleteMessagesAlert(org.rbmain.ui.ActionBar.BaseFragment r29, org.rbmain.tgnet.TLRPC$User r30, final org.rbmain.tgnet.TLRPC$Chat r31, final org.rbmain.tgnet.TLRPC$EncryptedChat r32, final org.rbmain.tgnet.TLRPC$ChatFull r33, long r34, final org.rbmain.messenger.MessageObject r36, final androidx.collection.LongSparseArray<org.rbmain.messenger.MessageObject>[] r37, final org.rbmain.messenger.MessageObject.GroupedMessages r38, final boolean r39, int r40, final java.lang.Runnable r41, final java.lang.Runnable r42) {
        /*
            Method dump skipped, instructions count: 923
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.createDeleteMessagesAlert(org.rbmain.ui.ActionBar.BaseFragment, org.rbmain.tgnet.TLRPC$User, org.rbmain.tgnet.TLRPC$Chat, org.rbmain.tgnet.TLRPC$EncryptedChat, org.rbmain.tgnet.TLRPC$ChatFull, long, org.rbmain.messenger.MessageObject, androidx.collection.LongSparseArray[], org.rbmain.messenger.MessageObject$GroupedMessages, boolean, int, java.lang.Runnable, java.lang.Runnable):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDeleteMessagesAlert$95(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDeleteMessagesAlert$97(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, TLRPC$EncryptedChat tLRPC$EncryptedChat, int i, long j, boolean[] zArr, boolean z, LongSparseArray[] longSparseArrayArr, TLRPC$User tLRPC$User, boolean[] zArr2, TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, Runnable runnable, DialogInterface dialogInterface, int i2) {
        ArrayList<Long> arrayList;
        int i3;
        ArrayList<Long> arrayList2;
        int i4;
        ArrayList<Long> arrayList3;
        int i5 = 10;
        ArrayList<Long> arrayList4 = null;
        int i6 = 0;
        if (messageObject != null) {
            ArrayList<Long> arrayList5 = new ArrayList<>();
            if (groupedMessages != null) {
                for (int i7 = 0; i7 < groupedMessages.messages.size(); i7++) {
                    MessageObject messageObject2 = groupedMessages.messages.get(i7);
                    arrayList5.add(Long.valueOf(messageObject2.getId()));
                    if (tLRPC$EncryptedChat != null && messageObject2.messageOwner.random_id != 0 && messageObject2.type != 10) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList<>();
                        }
                        arrayList4.add(Long.valueOf(messageObject2.messageOwner.random_id));
                    }
                }
            } else {
                arrayList5.add(Long.valueOf(messageObject.getId()));
                if (tLRPC$EncryptedChat != null && messageObject.messageOwner.random_id != 0 && messageObject.type != 10) {
                    ArrayList<Long> arrayList6 = new ArrayList<>();
                    arrayList6.add(Long.valueOf(messageObject.messageOwner.random_id));
                    arrayList3 = arrayList6;
                }
                i3 = 0;
                MessagesController.getInstance(i).deleteMessages(arrayList5, arrayList3, tLRPC$EncryptedChat, j, messageObject.messageOwner.peer_id.channel_id, zArr[0], z);
                arrayList = arrayList5;
            }
            arrayList3 = arrayList4;
            i3 = 0;
            MessagesController.getInstance(i).deleteMessages(arrayList5, arrayList3, tLRPC$EncryptedChat, j, messageObject.messageOwner.peer_id.channel_id, zArr[0], z);
            arrayList = arrayList5;
        } else {
            arrayList = null;
            int i8 = 1;
            while (i8 >= 0) {
                ArrayList<Long> arrayList7 = new ArrayList<>();
                for (int i9 = 0; i9 < longSparseArrayArr[i8].size(); i9++) {
                    arrayList7.add(Long.valueOf(longSparseArrayArr[i8].keyAt(i9)));
                }
                int i10 = (arrayList7.isEmpty() || (i4 = ((MessageObject) longSparseArrayArr[i8].get(arrayList7.get(i6).longValue())).messageOwner.peer_id.channel_id) == 0) ? 0 : i4;
                if (tLRPC$EncryptedChat != null) {
                    ArrayList<Long> arrayList8 = new ArrayList<>();
                    for (int i11 = 0; i11 < longSparseArrayArr[i8].size(); i11++) {
                        MessageObject messageObject3 = (MessageObject) longSparseArrayArr[i8].valueAt(i11);
                        long j2 = messageObject3.messageOwner.random_id;
                        if (j2 != 0 && messageObject3.type != i5) {
                            arrayList8.add(Long.valueOf(j2));
                        }
                    }
                    arrayList2 = arrayList8;
                } else {
                    arrayList2 = null;
                }
                MessagesController.getInstance(i).deleteMessages(arrayList7, arrayList2, tLRPC$EncryptedChat, j, i10, zArr[i6], z);
                longSparseArrayArr[i8].clear();
                i8--;
                arrayList = arrayList7;
                i6 = 0;
                i5 = 10;
            }
            i3 = 0;
        }
        if (tLRPC$User != null) {
            if (zArr2[i3]) {
                MessagesController.getInstance(i).deleteParticipantFromChat(tLRPC$Chat.id, tLRPC$User, tLRPC$ChatFull);
            }
            if (zArr2[1]) {
                TLRPC$TL_channels_reportSpam tLRPC$TL_channels_reportSpam = new TLRPC$TL_channels_reportSpam();
                tLRPC$TL_channels_reportSpam.channel = MessagesController.getInputChannel(tLRPC$Chat);
                tLRPC$TL_channels_reportSpam.user_id = MessagesController.getInstance(i).getInputUser(tLRPC$User);
                tLRPC$TL_channels_reportSpam.id = arrayList;
                ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_channels_reportSpam, new RequestDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda89
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        AlertsCreator.lambda$createDeleteMessagesAlert$96(tLObject, tLRPC$TL_error);
                    }
                });
            }
            if (zArr2[2]) {
                MessagesController.getInstance(i).deleteUserChannelHistory(tLRPC$Chat, tLRPC$User, i3);
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createDeleteMessagesAlert$98(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void createThemeCreateDialog(final BaseFragment baseFragment, int i, final Theme.ThemeInfo themeInfo, final Theme.ThemeAccent themeAccent) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        Activity parentActivity = baseFragment.getParentActivity();
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(parentActivity);
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(parentActivity, true));
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("NewTheme", R.string.NewTheme));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("Create", R.string.Create), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda35
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$createThemeCreateDialog$99(dialogInterface, i2);
            }
        });
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        TextView textView = new TextView(parentActivity);
        if (i != 0) {
            textView.setText(AndroidUtilities.replaceTags(LocaleController.getString("EnterThemeNameEdit", R.string.EnterThemeNameEdit)));
        } else {
            textView.setText(LocaleController.getString("EnterThemeName", R.string.EnterThemeName));
        }
        textView.setTextSize(1, 16.0f);
        textView.setPadding(AndroidUtilities.dp(23.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(23.0f), AndroidUtilities.dp(6.0f));
        int i2 = Theme.key_dialogTextBlack;
        textView.setTextColor(Theme.getColor(i2));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2));
        editTextBoldCursor.setTextSize(1, 16.0f);
        editTextBoldCursor.setTextColor(Theme.getColor(i2));
        editTextBoldCursor.setMaxLines(1);
        editTextBoldCursor.setLines(1);
        editTextBoldCursor.setInputType(16385);
        editTextBoldCursor.setGravity(51);
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setImeOptions(6);
        editTextBoldCursor.setCursorColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
        linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
        editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda78
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createThemeCreateDialog$100(textView2, i3, keyEvent);
            }
        });
        editTextBoldCursor.setText(generateThemeName(themeAccent));
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda44
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createThemeCreateDialog$102(editTextBoldCursor, dialogInterface);
            }
        });
        baseFragment.showDialog(alertDialogCreate);
        editTextBoldCursor.requestFocus();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                AlertsCreator.lambda$createThemeCreateDialog$105(baseFragment, editTextBoldCursor, themeAccent, themeInfo, alertDialogCreate, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createThemeCreateDialog$100(TextView textView, int i, KeyEvent keyEvent) {
        AndroidUtilities.hideKeyboard(textView);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createThemeCreateDialog$102(final EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda80
            @Override // java.lang.Runnable
            public final void run() {
                AlertsCreator.lambda$createThemeCreateDialog$101(editTextBoldCursor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createThemeCreateDialog$101(EditTextBoldCursor editTextBoldCursor) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createThemeCreateDialog$105(final BaseFragment baseFragment, final EditTextBoldCursor editTextBoldCursor, Theme.ThemeAccent themeAccent, Theme.ThemeInfo themeInfo, final AlertDialog alertDialog, View view) throws Throwable {
        if (baseFragment.getParentActivity() == null) {
            return;
        }
        if (editTextBoldCursor.length() == 0) {
            Vibrator vibrator = (Vibrator) ApplicationLoader.applicationContext.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(editTextBoldCursor, 2.0f, 0);
            return;
        }
        if (baseFragment instanceof ThemePreviewActivity) {
            Theme.applyPreviousTheme();
            baseFragment.finishFragment();
        }
        if (themeAccent != null) {
            themeInfo.setCurrentAccentId(themeAccent.id);
            Theme.refreshThemeColors();
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda81
                @Override // java.lang.Runnable
                public final void run() {
                    AlertsCreator.lambda$createThemeCreateDialog$104(editTextBoldCursor, alertDialog, baseFragment);
                }
            });
            return;
        }
        processCreate(editTextBoldCursor, alertDialog, baseFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createThemeCreateDialog$104(final EditTextBoldCursor editTextBoldCursor, final AlertDialog alertDialog, final BaseFragment baseFragment) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda82
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                AlertsCreator.processCreate(editTextBoldCursor, alertDialog, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processCreate(EditTextBoldCursor editTextBoldCursor, AlertDialog alertDialog, BaseFragment baseFragment) throws Throwable {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        AndroidUtilities.hideKeyboard(editTextBoldCursor);
        Theme.ThemeInfo themeInfoCreateNewTheme = Theme.createNewTheme(editTextBoldCursor.getText().toString());
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.themeListUpdated, new Object[0]);
        new ThemeEditorView().show(baseFragment.getParentActivity(), themeInfoCreateNewTheme);
        alertDialog.dismiss();
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (globalMainSettings.getBoolean("themehint", false)) {
            return;
        }
        globalMainSettings.edit().putBoolean("themehint", true).apply();
        try {
            Toast.makeText(baseFragment.getParentActivity(), LocaleController.getString("CreateNewThemeHelp", R.string.CreateNewThemeHelp), 1).show();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static String generateThemeName(Theme.ThemeAccent themeAccent) {
        int i;
        List listAsList = Arrays.asList("Ancient", "Antique", "Autumn", "Baby", "Barely", "Baroque", "Blazing", "Blushing", "Bohemian", "Bubbly", "Burning", "Buttered", "Classic", "Clear", "Cool", "Cosmic", "Cotton", "Cozy", "Crystal", "Dark", "Daring", "Darling", "Dawn", "Dazzling", "Deep", "Deepest", "Delicate", "Delightful", "Divine", "Double", "Downtown", "Dreamy", "Dusky", "Dusty", "Electric", "Enchanted", "Endless", "Evening", "Fantastic", "Flirty", "Forever", "Frigid", "Frosty", "Frozen", "Gentle", "Heavenly", "Hyper", "Icy", "Infinite", "Innocent", "Instant", "Luscious", "Lunar", "Lustrous", "Magic", "Majestic", "Mambo", "Midnight", "Millenium", "Morning", "Mystic", "Natural", "Neon", "Night", "Opaque", "Paradise", "Perfect", "Perky", "Polished", "Powerful", "Rich", "Royal", "Sheer", "Simply", "Sizzling", "Solar", "Sparkling", "Splendid", "Spicy", "Spring", "Stellar", "Sugared", "Summer", "Sunny", "Super", "Sweet", "Tender", "Tenacious", "Tidal", "Toasted", "Totally", "Tranquil", "Tropical", "True", "Twilight", "Twinkling", "Ultimate", "Ultra", "Velvety", "Vibrant", "Vintage", "Virtual", "Warm", "Warmest", "Whipped", "Wild", "Winsome");
        List listAsList2 = Arrays.asList("Ambrosia", "Attack", "Avalanche", "Blast", "Bliss", "Blossom", "Blush", "Burst", "Butter", "Candy", "Carnival", "Charm", "Chiffon", "Cloud", "Comet", "Delight", "Dream", "Dust", "Fantasy", "Flame", "Flash", "Fire", "Freeze", "Frost", "Glade", "Glaze", "Gleam", "Glimmer", "Glitter", "Glow", "Grande", "Haze", "Highlight", "Ice", "Illusion", "Intrigue", "Jewel", "Jubilee", "Kiss", "Lights", "Lollypop", "Love", "Luster", "Madness", "Matte", "Mirage", "Mist", "Moon", "Muse", "Myth", "Nectar", "Nova", "Parfait", "Passion", "Pop", "Rain", "Reflection", "Rhapsody", "Romance", "Satin", "Sensation", "Silk", "Shine", "Shadow", "Shimmer", "Sky", "Spice", "Star", "Sugar", "Sunrise", "Sunset", "Sun", "Twist", "Unbound", "Velvet", "Vibrant", "Waters", "Wine", "Wink", "Wonder", "Zone");
        HashMap map = new HashMap();
        map.put(9306112, "Berry");
        map.put(14598550, "Brandy");
        map.put(8391495, "Cherry");
        map.put(16744272, "Coral");
        map.put(14372985, "Cranberry");
        map.put(14423100, "Crimson");
        map.put(14725375, "Mauve");
        map.put(16761035, "Pink");
        map.put(16711680, "Red");
        map.put(16711807, "Rose");
        map.put(8406555, "Russet");
        map.put(16720896, "Scarlet");
        map.put(15856113, "Seashell");
        map.put(16724889, "Strawberry");
        map.put(16760576, "Amber");
        map.put(15438707, "Apricot");
        map.put(16508850, "Banana");
        map.put(10601738, "Citrus");
        map.put(11560192, "Ginger");
        map.put(16766720, "Gold");
        map.put(16640272, "Lemon");
        map.put(16753920, "Orange");
        map.put(16770484, "Peach");
        map.put(16739155, "Persimmon");
        map.put(14996514, "Sunflower");
        map.put(15893760, "Tangerine");
        map.put(16763004, "Topaz");
        map.put(16776960, "Yellow");
        map.put(3688720, "Clover");
        map.put(8628829, "Cucumber");
        map.put(5294200, "Emerald");
        map.put(11907932, "Olive");
        map.put(65280, "Green");
        map.put(43115, "Jade");
        map.put(2730887, "Jungle");
        map.put(12582656, "Lime");
        map.put(776785, "Malachite");
        map.put(10026904, "Mint");
        map.put(11394989, "Moss");
        map.put(3234721, "Azure");
        map.put(255, "Blue");
        map.put(18347, "Cobalt");
        map.put(5204422, "Indigo");
        map.put(96647, "Lagoon");
        map.put(7461346, "Aquamarine");
        map.put(1182351, "Ultramarine");
        map.put(128, "Navy");
        map.put(3101086, "Sapphire");
        map.put(7788522, "Sky");
        map.put(32896, "Teal");
        map.put(4251856, "Turquoise");
        map.put(10053324, "Amethyst");
        map.put(5046581, "Blackberry");
        map.put(6373457, "Eggplant");
        map.put(13148872, "Lilac");
        map.put(11894492, "Lavender");
        map.put(13421823, "Periwinkle");
        map.put(8663417, "Plum");
        map.put(6684825, "Purple");
        map.put(14204888, "Thistle");
        map.put(14315734, "Orchid");
        map.put(2361920, "Violet");
        map.put(4137225, "Bronze");
        map.put(3604994, "Chocolate");
        map.put(8077056, "Cinnamon");
        map.put(3153694, "Cocoa");
        map.put(7365973, "Coffee");
        map.put(7956873, "Rum");
        map.put(5113350, "Mahogany");
        map.put(7875865, "Mocha");
        map.put(12759680, "Sand");
        map.put(8924439, "Sienna");
        map.put(7864585, "Maple");
        map.put(15787660, "Khaki");
        map.put(12088115, "Copper");
        map.put(12144200, "Chestnut");
        map.put(15653316, "Almond");
        map.put(16776656, "Cream");
        map.put(12186367, "Diamond");
        map.put(11109127, "Honey");
        map.put(16777200, "Ivory");
        map.put(15392968, "Pearl");
        map.put(15725299, "Porcelain");
        map.put(13745832, "Vanilla");
        map.put(16777215, "White");
        map.put(8421504, "Gray");
        map.put(0, "Black");
        map.put(15266260, "Chrome");
        map.put(3556687, "Charcoal");
        map.put(789277, "Ebony");
        map.put(12632256, "Silver");
        map.put(16119285, "Smoke");
        map.put(2499381, "Steel");
        map.put(5220413, "Apple");
        map.put(8434628, "Glacier");
        map.put(16693933, "Melon");
        map.put(12929932, "Mulberry");
        map.put(11126466, "Opal");
        map.put(5547512, "Blue");
        Theme.ThemeAccent accent = themeAccent == null ? Theme.getCurrentTheme().getAccent(false) : themeAccent;
        if (accent == null || (i = accent.accentColor) == 0) {
            i = AndroidUtilities.calcDrawableColor(Theme.getCachedWallpaper())[0];
        }
        String str = null;
        int i2 = ConnectionsManager.DEFAULT_DATACENTER_ID;
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        for (Map.Entry entry : map.entrySet()) {
            Integer num = (Integer) entry.getKey();
            int iRed2 = Color.red(num.intValue());
            int i3 = (iRed + iRed2) / 2;
            int i4 = iRed - iRed2;
            int iGreen2 = iGreen - Color.green(num.intValue());
            int iBlue2 = iBlue - Color.blue(num.intValue());
            int i5 = ((((i3 + 512) * i4) * i4) >> 8) + (iGreen2 * 4 * iGreen2) + ((((767 - i3) * iBlue2) * iBlue2) >> 8);
            if (i5 < i2) {
                str = (String) entry.getValue();
                i2 = i5;
            }
        }
        if (Utilities.random.nextInt() % 2 == 0) {
            return ((String) listAsList.get(Utilities.random.nextInt(listAsList.size()))) + " " + str;
        }
        return str + " " + ((String) listAsList2.get(Utilities.random.nextInt(listAsList2.size())));
    }

    public static AlertDialog.Builder createNumberPickerAlert(Context context, String str, int i, int i2, int i3, final NumberPickerDelegate numberPickerDelegate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setMinValue(i);
        numberPicker.setMaxValue(i2);
        numberPicker.setValue(i3);
        builder.setView(numberPicker);
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AlertsCreator.lambda$createNumberPickerAlert$106(numberPickerDelegate, numberPicker, dialogInterface, i4);
            }
        });
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createNumberPickerAlert$106(NumberPickerDelegate numberPickerDelegate, NumberPicker numberPicker, DialogInterface dialogInterface, int i) {
        numberPickerDelegate.didSelectNumber(numberPicker.getValue());
    }

    public static AlertDialog.Builder createStringPickerAlert(Context context, String str, String[] strArr, String str2, final StringPickerDelegate stringPickerDelegate) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setDisplayedValues(strArr);
        if (str2 != null) {
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                }
                if (strArr[i2].equals(str2)) {
                    i = i2;
                    break;
                }
                i2++;
            }
            numberPicker.setValue(i);
        }
        numberPicker.setMinValue(0);
        if (strArr.length > 0) {
            numberPicker.setMaxValue(strArr.length - 1);
        }
        numberPicker.setDescendantFocusability(393216);
        builder.setView(numberPicker);
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertsCreator.lambda$createStringPickerAlert$107(stringPickerDelegate, numberPicker, dialogInterface, i3);
            }
        });
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createStringPickerAlert$107(StringPickerDelegate stringPickerDelegate, NumberPicker numberPicker, DialogInterface dialogInterface, int i) {
        stringPickerDelegate.didPickString(numberPicker.getDisplayedValues()[numberPicker.getValue()]);
    }

    public static void createTextBoxAlert(Context context, String str, boolean z, boolean z2, String str2, String str3, final StringPickerDelegate stringPickerDelegate) {
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(context, true));
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(str);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda27
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AndroidUtilities.hideKeyboard(editTextBoldCursor);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        editTextBoldCursor.setTextSize(1, 16.0f);
        if (z) {
            editTextBoldCursor.setSingleLine(true);
        } else {
            editTextBoldCursor.setSingleLine(false);
            editTextBoldCursor.setMaxLines(5);
        }
        if (z2) {
            editTextBoldCursor.setInputType(2);
        } else {
            editTextBoldCursor.setInputType(1);
        }
        editTextBoldCursor.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        editTextBoldCursor.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
        editTextBoldCursor.setCursorColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
        linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
        editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda76
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createTextBoxAlert$109(builder, textView, i, keyEvent);
            }
        });
        if (!TextUtils.isEmpty(str3)) {
            editTextBoldCursor.setText(str3);
            editTextBoldCursor.setSelection(editTextBoldCursor.length());
        }
        if (!TextUtils.isEmpty(str2)) {
            editTextBoldCursor.setHint(str2);
        } else {
            editTextBoldCursor.setHint(LocaleController.getString("WriteHere", R.string.WriteHere));
        }
        builder.setPositiveButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda25
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createTextBoxAlert$110(stringPickerDelegate, editTextBoldCursor, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda42
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AndroidUtilities.hideKeyboard(editTextBoldCursor);
            }
        });
        alertDialogCreate.show();
        editTextBoldCursor.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createTextBoxAlert$109(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
        AndroidUtilities.hideKeyboard(textView);
        builder.create().getButton(-1).callOnClick();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createTextBoxAlert$110(StringPickerDelegate stringPickerDelegate, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface, int i) {
        stringPickerDelegate.didPickString(editTextBoldCursor.getText().toString());
    }

    public static void showAskAlert(Context context, String str, AskAlertDelegate askAlertDelegate) {
        showAskAlert(context, null, str, askAlertDelegate, null);
    }

    public static void showAskAlert(Context context, String str, AskAlertDelegate askAlertDelegate, DismissDelegate dismissDelegate) {
        showAskAlert(context, null, str, askAlertDelegate, dismissDelegate);
    }

    public static void showAskAlert(Context context, String str, String str2, final AskAlertDelegate askAlertDelegate, final DismissDelegate dismissDelegate) {
        if (context == null || str2 == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (str == null) {
            str = LocaleController.getString("AppName", R.string.AppName);
        }
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                askAlertDelegate.onAccepted();
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda23
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$showAskAlert$113(dismissDelegate, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        TextView textView = (TextView) alertDialogCreate.getButton(-2);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAskAlert$113(DismissDelegate dismissDelegate, DialogInterface dialogInterface, int i) {
        if (dismissDelegate != null) {
            dismissDelegate.onDismissed();
        }
    }

    public static class ItemSelectionAdapter extends RecyclerListView.SelectionAdapter {
        MiniFunctionModels.ButtonSelection buttonSelection;
        int currentAccount;
        ItemPickerDelegate delegate;
        long dialogId;
        int endItemRow;
        boolean hasContinue;
        private boolean isLoading;
        boolean isSearch;
        ArrayList<BotButtonObject.BotButtonSimpleObject> items;
        private String lastSearchedText;
        Context mContext;
        ArrayList<BotButtonObject.BotButtonSimpleObject> searchResults = new ArrayList<>();
        ArrayList<BotButtonObject.BotButtonSimpleObject> selectedItems;
        int startItemRow;
        String start_id;

        public ItemSelectionAdapter(Context context, int i, long j, MiniFunctionModels.ButtonSelection buttonSelection, ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList, ItemPickerDelegate itemPickerDelegate) {
            this.items = buttonSelection.items;
            this.selectedItems = arrayList;
            this.buttonSelection = buttonSelection;
            this.delegate = itemPickerDelegate;
            this.currentAccount = i;
            this.dialogId = j;
            this.mContext = context;
            if (buttonSelection.columns_count == 0) {
                buttonSelection.columns_count = 1;
            }
            if (buttonSelection.get_type == BotButtonObject.BotButtonSelection.GetType.Api) {
                this.hasContinue = true;
            } else {
                this.hasContinue = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout loadingCell;
            if (i == 0) {
                FrameLayout bottomSheetCell = new BottomSheet.BottomSheetCell(this.mContext, 0);
                bottomSheetCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                loadingCell = bottomSheetCell;
            } else if (i == 1) {
                loadingCell = new LoadingCell(this.mContext, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(120.0f));
            } else if (i == 2) {
                BotSelectionItemCell botSelectionItemCell = new BotSelectionItemCell(this.mContext);
                botSelectionItemCell.setDelegate(new BotSelectionItemCell.BotSelectionItemCellDelegate() { // from class: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.1
                    @Override // org.rbmain.ui.Cells.BotSelectionItemCell.BotSelectionItemCellDelegate
                    public boolean didLongClickItem(BotSelectionItemCell botSelectionItemCell2, int i2, BotButtonObject.BotButtonSimpleObject botButtonSimpleObject, int i3) {
                        return false;
                    }

                    @Override // org.rbmain.ui.Cells.BotSelectionItemCell.BotSelectionItemCellDelegate
                    public void didClickItem(BotSelectionItemCell botSelectionItemCell2, int i2, BotButtonObject.BotButtonSimpleObject botButtonSimpleObject, int i3) {
                        ItemSelectionAdapter itemSelectionAdapter = ItemSelectionAdapter.this;
                        if (itemSelectionAdapter.delegate != null) {
                            if (itemSelectionAdapter.selectedItems == null) {
                                itemSelectionAdapter.selectedItems = new ArrayList<>();
                            }
                            ItemSelectionAdapter itemSelectionAdapter2 = ItemSelectionAdapter.this;
                            if (!itemSelectionAdapter2.buttonSelection.is_multi_selection && botButtonSimpleObject.isSelected) {
                                Iterator<BotButtonObject.BotButtonSimpleObject> it = itemSelectionAdapter2.selectedItems.iterator();
                                while (it.hasNext()) {
                                    it.next().isSelected = false;
                                }
                                ItemSelectionAdapter.this.selectedItems.clear();
                            }
                            if (botButtonSimpleObject.isSelected) {
                                ItemSelectionAdapter.this.selectedItems.add(botButtonSimpleObject);
                            } else {
                                ItemSelectionAdapter.this.selectedItems.remove(botButtonSimpleObject);
                            }
                            if (ItemSelectionAdapter.this.buttonSelection.is_multi_selection) {
                                botSelectionItemCell2.setItem(i3, i2, botButtonSimpleObject);
                                ItemSelectionAdapter itemSelectionAdapter3 = ItemSelectionAdapter.this;
                                itemSelectionAdapter3.delegate.selectedItemChanged(itemSelectionAdapter3.selectedItems);
                            } else {
                                ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList = new ArrayList<>();
                                arrayList.add(botButtonSimpleObject);
                                ItemSelectionAdapter.this.notifyDataSetChanged();
                                ItemSelectionAdapter.this.delegate.didSelectItems(arrayList);
                            }
                        }
                    }
                });
                loadingCell = botSelectionItemCell;
            } else {
                loadingCell = new GraySectionCell(this.mContext);
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (!this.isSearch && this.hasContinue && i > this.endItemRow - 5) {
                loadItems();
            }
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                BottomSheet.BottomSheetCell bottomSheetCell = (BottomSheet.BottomSheetCell) viewHolder.itemView;
                BotButtonObject.BotButtonSimpleObject botButtonSimpleObject = (this.isSearch ? this.searchResults : this.items).get(i);
                BotButtonObject.BotButtonSimpleObject.BotButtonViewType botButtonViewType = botButtonSimpleObject.type;
                if (botButtonViewType == BotButtonObject.BotButtonSimpleObject.BotButtonViewType.TextOnly) {
                    bottomSheetCell.setTextAndIcon(botButtonSimpleObject.text, 0);
                    return;
                } else if (botButtonViewType == BotButtonObject.BotButtonSimpleObject.BotButtonViewType.TextImgThu) {
                    bottomSheetCell.setTextAndIcon(botButtonSimpleObject.text, 0);
                    return;
                } else {
                    if (botButtonViewType == BotButtonObject.BotButtonSimpleObject.BotButtonViewType.TextImgBig) {
                        bottomSheetCell.setTextAndIcon(botButtonSimpleObject.text, 0);
                        return;
                    }
                    return;
                }
            }
            if (itemViewType != 2) {
                return;
            }
            int i2 = this.buttonSelection.columns_count;
            BotSelectionItemCell botSelectionItemCell = (BotSelectionItemCell) viewHolder.itemView;
            botSelectionItemCell.setItemsCount(i2);
            botSelectionItemCell.setIsFirst(i == this.startItemRow);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = ((i - this.startItemRow) * i2) + i3;
                if (i4 < (this.isSearch ? this.searchResults : this.items).size()) {
                    BotButtonObject.BotButtonSimpleObject botButtonSimpleObject2 = (this.isSearch ? this.searchResults : this.items).get(i4);
                    botSelectionItemCell.setTag(Integer.valueOf(i));
                    botSelectionItemCell.setItem(i3, i4, botButtonSimpleObject2);
                } else {
                    botSelectionItemCell.setItem(i3, i4, null);
                }
            }
            botSelectionItemCell.requestLayout();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getItemCount() {
            /*
                r4 = this;
                boolean r0 = r4.isSearch
                r1 = 0
                if (r0 == 0) goto L10
                java.util.ArrayList<ir.aaap.messengercore.model.BotButtonObject$BotButtonSimpleObject> r0 = r4.searchResults
                if (r0 == 0) goto Le
                int r0 = r0.size()
                goto L18
            Le:
                r0 = 0
                goto L18
            L10:
                java.util.ArrayList<ir.aaap.messengercore.model.BotButtonObject$BotButtonSimpleObject> r0 = r4.items
                if (r0 == 0) goto Le
                int r0 = r0.size()
            L18:
                float r0 = (float) r0
                ir.aaap.messengercore.model.MiniFunctionModels$ButtonSelection r2 = r4.buttonSelection
                int r2 = r2.columns_count
                float r2 = (float) r2
                float r0 = r0 / r2
                double r2 = (double) r0
                double r2 = java.lang.Math.ceil(r2)
                int r0 = (int) r2
                r4.startItemRow = r1
                r4.endItemRow = r0
                boolean r1 = r4.isSearch
                if (r1 != 0) goto L3b
                ir.aaap.messengercore.model.MiniFunctionModels$ButtonSelection r1 = r4.buttonSelection
                ir.aaap.messengercore.model.BotButtonObject$BotButtonSelection$GetType r1 = r1.get_type
                ir.aaap.messengercore.model.BotButtonObject$BotButtonSelection$GetType r2 = ir.aaap.messengercore.model.BotButtonObject.BotButtonSelection.GetType.Api
                if (r1 != r2) goto L3b
                boolean r1 = r4.hasContinue
                if (r1 == 0) goto L3b
                int r0 = r0 + 1
            L3b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.getItemCount():int");
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i < this.startItemRow || i >= this.endItemRow) ? 1 : 2;
        }

        public void doSearch(String str) {
            if (str.equals(this.lastSearchedText)) {
                return;
            }
            this.lastSearchedText = str;
            if (str.isEmpty()) {
                this.isSearch = false;
                this.searchResults.clear();
                notifyDataSetChanged();
            } else {
                this.isSearch = true;
                this.searchResults.clear();
                if (this.buttonSelection.search_type == BotButtonObject.BotButtonSelection.SearchType.Api) {
                    searchApi(str);
                } else {
                    searchLocal(str);
                }
            }
        }

        private void searchLocal(String str) {
            ArrayList arrayList = new ArrayList();
            Iterator<BotButtonObject.BotButtonSimpleObject> it = this.items.iterator();
            while (it.hasNext()) {
                BotButtonObject.BotButtonSimpleObject next = it.next();
                String str2 = next.text;
                if (str2 != null) {
                    Locale locale = Locale.ROOT;
                    if (str2.toLowerCase(locale).contains(str.toLowerCase(locale))) {
                        arrayList.add(next);
                    }
                }
            }
            this.searchResults.clear();
            this.searchResults.addAll(arrayList);
            notifyDataSetChanged();
        }

        public void searchApi(String str) {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().searchBotSelectionItems(this.dialogId, this.buttonSelection.selection_id, str, 10, new LoadListener<BotModels.SearchBotSelectionOutput>() { // from class: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.2
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(BotModels.SearchBotSelectionOutput searchBotSelectionOutput) {
                    ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList;
                    ItemSelectionAdapter.this.isLoading = false;
                    if (searchBotSelectionOutput != null && (arrayList = searchBotSelectionOutput.items) != null && arrayList.size() > 0) {
                        ItemSelectionAdapter.this.searchResults.clear();
                        ItemSelectionAdapter.this.searchResults.addAll(searchBotSelectionOutput.items);
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ItemSelectionAdapter.this.notifyDataSetChanged();
                        }
                    });
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    ItemSelectionAdapter.this.isLoading = false;
                }
            });
        }

        public void loadItems() {
            if (this.isLoading) {
                return;
            }
            this.isLoading = true;
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().getBotSelectionItems(this.dialogId, this.buttonSelection.selection_id, this.start_id, new LoadListener<BotModels.GetBotSelectionOutput>() { // from class: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.3
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(BotModels.GetBotSelectionOutput getBotSelectionOutput) {
                    ItemSelectionAdapter.this.isLoading = false;
                    if (getBotSelectionOutput != null) {
                        ArrayList<BotButtonObject.BotButtonSimpleObject> arrayList = getBotSelectionOutput.items;
                        if (arrayList != null && arrayList.size() > 0) {
                            ItemSelectionAdapter itemSelectionAdapter = ItemSelectionAdapter.this;
                            if (itemSelectionAdapter.items == null) {
                                itemSelectionAdapter.items = new ArrayList<>();
                            }
                            ItemSelectionAdapter.this.items.addAll(getBotSelectionOutput.items);
                        }
                        ItemSelectionAdapter itemSelectionAdapter2 = ItemSelectionAdapter.this;
                        itemSelectionAdapter2.hasContinue = getBotSelectionOutput.has_continue;
                        itemSelectionAdapter2.start_id = getBotSelectionOutput.next_start_id;
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator.ItemSelectionAdapter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ItemSelectionAdapter.this.notifyDataSetChanged();
                        }
                    });
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    ItemSelectionAdapter.this.isLoading = false;
                }
            });
        }
    }

    public static class SearchField extends FrameLayout {
        private View backgroundView;
        private ImageView clearSearchImageView;
        private CloseProgressDrawable2 progressDrawable;
        private View searchBackground;
        private EditTextBoldCursor searchEditText;
        int searchFieldHeight;
        private ImageView searchIconImageView;
        private View shadowView;

        public interface SearchListener {
            void doSearch(String str);
        }

        public SearchField(Context context, final SearchListener searchListener) {
            super(context);
            this.searchFieldHeight = AndroidUtilities.dp(64.0f);
            View view = new View(context);
            this.shadowView = view;
            view.setAlpha(0.0f);
            this.shadowView.setTag(1);
            this.shadowView.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelShadowLine));
            addView(this.shadowView, new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83));
            View view2 = new View(context);
            this.backgroundView = view2;
            view2.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
            addView(this.backgroundView, new FrameLayout.LayoutParams(-1, this.searchFieldHeight));
            View view3 = new View(context);
            this.searchBackground = view3;
            view3.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(Theme.key_chat_emojiSearchBackground)));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 14.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            ImageView imageView2 = this.searchIconImageView;
            int i = Theme.key_chat_emojiSearchIcon;
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            addView(this.searchIconImageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 14.0f, 0.0f, 0.0f));
            ImageView imageView3 = new ImageView(context);
            this.clearSearchImageView = imageView3;
            imageView3.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView4 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView4.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 14.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$SearchField$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    this.f$0.lambda$new$0(view4);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context) { // from class: org.rbmain.ui.Components.AlertsCreator.SearchField.1
                @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    if (!SearchField.this.searchEditText.isEnabled()) {
                        return super.onTouchEvent(motionEvent);
                    }
                    if (motionEvent.getAction() == 0) {
                        SearchField.this.searchEditText.requestFocus();
                        AndroidUtilities.showKeyboard(SearchField.this.searchEditText);
                    }
                    return super.onTouchEvent(motionEvent);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(Theme.getColor(i));
            this.searchEditText.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            this.searchEditText.setHint(LocaleController.getString("Search", R.string.Search));
            this.searchEditText.setCursorColor(Theme.getColor(Theme.key_featuredStickers_addedIcon));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 12.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.Components.AlertsCreator.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    SearchListener searchListener2 = searchListener;
                    if (searchListener2 != null) {
                        searchListener2.doSearch(SearchField.this.searchEditText.getText().toString());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            this.searchEditText.setText(BuildConfig.FLAVOR);
            AndroidUtilities.showKeyboard(this.searchEditText);
        }
    }

    public static void showPublishDialog(final Context context, final String str) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("R.string.AppName", R.string.AppName));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(10.0f));
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setText(str);
        linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2, 8388659));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        TextView textView2 = new TextView(context);
        textView2.setGravity(1);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_copy_filled)), 0, 1, 0);
        spannableStringBuilder.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder.append((CharSequence) LocaleController.getString("PublishTextCopy", R.string.PublishTextCopy));
        spannableStringBuilder.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 0);
        textView2.setText(spannableStringBuilder);
        textView2.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setSingleLine(true);
        int i = Theme.key_featuredStickers_buttonText;
        textView2.setTextColor(Theme.getColor(i));
        int iDp = AndroidUtilities.dp(6.0f);
        int i2 = Theme.key_featuredStickers_addButton;
        int color = Theme.getColor(i2);
        int i3 = Theme.key_featuredStickers_addButtonPressed;
        textView2.setBackground(Theme.createSimpleSelectorRoundRectDrawable(iDp, color, Theme.getColor(i3)));
        linearLayout2.addView(textView2, LayoutHelper.createLinear(0, 40, 1.0f, 0, 4, 0, 4, 0));
        TextView textView3 = new TextView(context);
        textView3.setGravity(1);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) "..").setSpan(new ColoredImageSpan(ContextCompat.getDrawable(context, R.drawable.msg_share_filled)), 0, 1, 0);
        spannableStringBuilder2.setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(8.0f)), 1, 2, 0);
        spannableStringBuilder2.append((CharSequence) LocaleController.getString("PublishTextShare", R.string.PublishTextShare));
        spannableStringBuilder2.append((CharSequence) ".").setSpan(new DialogCell.FixedWidthSpan(AndroidUtilities.dp(5.0f)), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 0);
        textView3.setText(spannableStringBuilder2);
        textView3.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f));
        textView3.setTextSize(1, 14.0f);
        textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView3.setSingleLine(true);
        textView3.setTextColor(Theme.getColor(i));
        textView3.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(i2), Theme.getColor(i3)));
        linearLayout2.addView(textView3, LayoutHelper.createLinear(0, 40, 1.0f, 4, 0, 4, 0));
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
        builder.setView(linearLayout);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$showPublishDialog$114(builder, str, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$showPublishDialog$115(builder, str, context, view);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showPublishDialog$114(AlertDialog.Builder builder, String str, View view) {
        try {
            builder.getDismissRunnable().run();
            if (ApplicationLoader.applicationActivity != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.addFlags(MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
                intent.putExtra("android.intent.extra.TEXT", str);
                ApplicationLoader.applicationActivity.startActivity(Intent.createChooser(intent, "اشتراک گذاری با: "));
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showPublishDialog$115(AlertDialog.Builder builder, String str, Context context, View view) {
        try {
            builder.getDismissRunnable().run();
            AndroidUtilities.addToClipboard(str);
            if (ApplicationLoader.applicationActivity != null) {
                BaseFragment lastFragment = ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment();
                if (lastFragment != null) {
                    BulletinFactory.of(lastFragment).createCopyLinkBulletin().show();
                } else {
                    Toast.makeText(context, LocaleController.getString("LinkCopied", R.string.LinkCopied), 0).show();
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static AlertDialog createUpdateAlert(final BaseFragment baseFragment, final UpdateObject2 updateObject2) {
        AlertDialog alertDialogCreate = null;
        if (baseFragment != null && updateObject2 != null) {
            Activity parentActivity = baseFragment.getParentActivity();
            AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
            builder.setTitle(LocaleController.getString("UpdateApp", R.string.UpdateApp));
            if (updateObject2.changes != null) {
                TextView textView = new TextView(parentActivity);
                StringBuilder sb = new StringBuilder();
                sb.append(LocaleController.getString("LastChanges", R.string.LastChanges));
                sb.append(":\n");
                for (int i = 0; i < updateObject2.changes.size(); i++) {
                    sb.append("- ");
                    sb.append(updateObject2.changes.get(i));
                    sb.append("\n");
                }
                textView.setText(sb.toString());
                textView.setTextSize(1, 16.0f);
                textView.setLinkTextColor(Theme.getColor(Theme.key_dialogTextLink));
                textView.setHighlightColor(Theme.getColor(Theme.key_dialogLinkSelection));
                textView.setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
                textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                textView.setLayoutParams(LayoutHelper.createFrame(-1, -2, (LocaleController.isRTL ? 5 : 3) | 48));
                builder.setView(textView);
            }
            if (!updateObject2.force_update) {
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            }
            builder.setNegativeButton(LocaleController.getString("Update", R.string.Update), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AlertsCreator.lambda$createUpdateAlert$116(updateObject2, baseFragment, dialogInterface, i2);
                }
            });
            alertDialogCreate = builder.create();
            if (updateObject2.force_update) {
                alertDialogCreate.setCanCancel(false);
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda43
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        return AlertsCreator.lambda$createUpdateAlert$117(baseFragment, dialogInterface, i2, keyEvent);
                    }
                });
            }
        }
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createUpdateAlert$116(UpdateObject2 updateObject2, BaseFragment baseFragment, DialogInterface dialogInterface, int i) {
        if (updateObject2.store_landing != null) {
            MessengerLinkHandler.getInstance(baseFragment.getCurrentAccount()).lambda$showDialogWithLink$30(updateObject2.store_landing);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createUpdateAlert$117(final BaseFragment baseFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        baseFragment.getParentActivity().finish();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda79
            @Override // java.lang.Runnable
            public final void run() {
                baseFragment.removeSelfFromStack();
            }
        }, 1000L);
        return false;
    }

    public static void showChatWithAdmin(BaseFragment baseFragment, TLRPC$User tLRPC$User, String str, boolean z, int i) {
        int i2;
        String str2;
        if (baseFragment.getParentActivity() == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(baseFragment.getParentActivity());
        if (z) {
            i2 = R.string.ChatWithAdminChannelTitle;
            str2 = "ChatWithAdminChannelTitle";
        } else {
            i2 = R.string.ChatWithAdminGroupTitle;
            str2 = "ChatWithAdminGroupTitle";
        }
        builder.setTitle(LocaleController.getString(str2, i2), true);
        LinearLayout linearLayout = new LinearLayout(baseFragment.getParentActivity());
        linearLayout.setOrientation(1);
        TextView textView = new TextView(baseFragment.getParentActivity());
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -1, 0, 21, 0, 21, 8));
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        textView.setTextSize(1, 16.0f);
        textView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ChatWithAdminMessage", R.string.ChatWithAdminMessage, str, LocaleController.formatDateAudio(i, false))));
        TextView textView2 = new TextView(baseFragment.getParentActivity());
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setText(LocaleController.getString("IUnderstand", R.string.IUnderstand));
        textView2.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        textView2.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, 48, 0, 16, 12, 16, 8));
        builder.setCustomView(linearLayout);
        final BottomSheet bottomSheetShow = builder.show();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bottomSheetShow.dismiss();
            }
        });
    }

    public static BottomSheet.Builder createMuteForPickerDialog(Context context, Theme.ResourcesProvider resourcesProvider, final ScheduleDatePickerDelegate scheduleDatePickerDelegate) {
        if (context == null) {
            return null;
        }
        ScheduleDatePickerColors scheduleDatePickerColors = new ScheduleDatePickerColors();
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false, resourcesProvider);
        builder.setApplyBottomPadding(false);
        final int[] iArr = {30, 60, 120, 180, 480, 1440, 2880, 4320, 5760, 7200, 8640, 10080, 20160, 30240, 44640, 89280, 133920, 178560, 223200, 267840, 525600};
        final NumberPicker numberPicker = new NumberPicker(context, resourcesProvider) { // from class: org.rbmain.ui.Components.AlertsCreator.27
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i) {
                int[] iArr2 = iArr;
                if (iArr2[i] == 0) {
                    return LocaleController.getString("MuteNever", R.string.MuteNever);
                }
                if (iArr2[i] < 60) {
                    return LocaleController.formatPluralString("Minutes", iArr2[i]);
                }
                if (iArr2[i] < 1440) {
                    return LocaleController.formatPluralString("Hours", iArr2[i] / 60);
                }
                if (iArr2[i] < 10080) {
                    return LocaleController.formatPluralString("Days", iArr2[i] / 1440);
                }
                if (iArr2[i] < 44640) {
                    return LocaleController.formatPluralString("Weeks", iArr2[i] / 10080);
                }
                if (iArr2[i] < 525600) {
                    return LocaleController.formatPluralString("Months", iArr2[i] / 44640);
                }
                return LocaleController.formatPluralString("Years", iArr2[i] / 525600);
            }
        };
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(20);
        numberPicker.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker.setValue(0);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda93
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return AlertsCreator.lambda$createMuteForPickerDialog$119(iArr, i);
            }
        });
        final LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.28
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i3 = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i3);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(42.0f) * i3;
                this.ignoreLayout = false;
                super.onMeasure(i, i2);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        linearLayout.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 51, 22, 0, 0, 4));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("MuteForAlert", R.string.MuteForAlert));
        textView.setTextColor(scheduleDatePickerColors.textColor);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda72
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createMuteForPickerDialog$120(view, motionEvent);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(1.0f);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 1.0f, 0, 0, 12, 0, 12));
        TextView textView2 = new TextView(context) { // from class: org.rbmain.ui.Components.AlertsCreator.29
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout2.addView(numberPicker, LayoutHelper.createLinear(0, 270, 1.0f));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda107
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i, int i2) {
                AlertsCreator.lambda$createMuteForPickerDialog$121(linearLayout, numberPicker2, i, i2);
            }
        });
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(scheduleDatePickerColors.buttonTextColor);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), scheduleDatePickerColors.buttonBackgroundColor, scheduleDatePickerColors.buttonBackgroundPressedColor));
        textView2.setText(LocaleController.getString("AutoDeleteConfirm", R.string.AutoDeleteConfirm));
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda61
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createMuteForPickerDialog$122(iArr, numberPicker, scheduleDatePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout);
        BottomSheet bottomSheetShow = builder.show();
        bottomSheetShow.setBackgroundColor(scheduleDatePickerColors.backgroundColor);
        bottomSheetShow.fixNavigationBar(scheduleDatePickerColors.backgroundColor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createMuteForPickerDialog$119(int[] iArr, int i) {
        if (iArr[i] == 0) {
            return LocaleController.getString("MuteNever", R.string.MuteNever);
        }
        if (iArr[i] < 60) {
            return LocaleController.formatPluralString("Minutes", iArr[i]);
        }
        if (iArr[i] < 1440) {
            return LocaleController.formatPluralString("Hours", iArr[i] / 60);
        }
        if (iArr[i] < 10080) {
            return LocaleController.formatPluralString("Days", iArr[i] / 1440);
        }
        if (iArr[i] < 44640) {
            return LocaleController.formatPluralString("Weeks", iArr[i] / 10080);
        }
        if (iArr[i] < 525600) {
            return LocaleController.formatPluralString("Months", iArr[i] / 44640);
        }
        return LocaleController.formatPluralString("Years", iArr[i] / 525600);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createMuteForPickerDialog$121(LinearLayout linearLayout, NumberPicker numberPicker, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createMuteForPickerDialog$122(int[] iArr, NumberPicker numberPicker, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
        scheduleDatePickerDelegate.didSelectDate(true, iArr[numberPicker.getValue()] * 60);
        builder.getDismissRunnable().run();
    }

    public static BottomSheet.Builder createAutoDeleteDatePickerDialog(Context context, int i, Theme.ResourcesProvider resourcesProvider, final ScheduleDatePickerDelegate scheduleDatePickerDelegate) {
        if (context == null) {
            return null;
        }
        ScheduleDatePickerColors scheduleDatePickerColors = new ScheduleDatePickerColors();
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false, resourcesProvider);
        builder.setApplyBottomPadding(false);
        final int[] iArr = {0, 1440, 2880, 4320, 5760, 7200, 8640, 10080, 20160, 30240, 44640, 89280, 133920, 178560, 223200, 267840, 525600};
        final NumberPicker numberPicker = new NumberPicker(context, resourcesProvider) { // from class: org.rbmain.ui.Components.AlertsCreator.30
            @Override // org.rbmain.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int i2) {
                int[] iArr2 = iArr;
                if (iArr2[i2] == 0) {
                    return LocaleController.getString("AutoDeleteNever", R.string.AutoDeleteNever);
                }
                if (iArr2[i2] < 10080) {
                    return LocaleController.formatPluralString("Days", iArr2[i2] / 1440);
                }
                if (iArr2[i2] < 44640) {
                    return LocaleController.formatPluralString("Weeks", iArr2[i2] / 1440);
                }
                if (iArr2[i2] < 525600) {
                    return LocaleController.formatPluralString("Months", iArr2[i2] / 10080);
                }
                return LocaleController.formatPluralString("Years", ((iArr2[i2] * 5) / 31) * 60 * 24);
            }
        };
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(16);
        numberPicker.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker.setValue(0);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda94
            @Override // org.rbmain.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createAutoDeleteDatePickerDialog$123(iArr, i2);
            }
        });
        final LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.Components.AlertsCreator.31
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i4 = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i4);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(42.0f) * i4;
                this.ignoreLayout = false;
                super.onMeasure(i2, i3);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        boolean z = true;
        linearLayout.setOrientation(1);
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2, 51, 22, 0, 0, 4));
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("AutoDeleteAfteTitle", R.string.AutoDeleteAfteTitle));
        textView.setTextColor(scheduleDatePickerColors.textColor);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda71
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createAutoDeleteDatePickerDialog$124(view, motionEvent);
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(1.0f);
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, 1.0f, 0, 0, 12, 0, 12));
        final AnimatedTextView animatedTextView = new AnimatedTextView(context, z, z, false) { // from class: org.rbmain.ui.Components.AlertsCreator.32
            @Override // android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout2.addView(numberPicker, LayoutHelper.createLinear(0, 270, 1.0f));
        animatedTextView.setPadding(0, 0, 0, 0);
        animatedTextView.setGravity(17);
        animatedTextView.setTextColor(scheduleDatePickerColors.buttonTextColor);
        animatedTextView.setTextSize(AndroidUtilities.dp(14.0f));
        animatedTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        animatedTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), scheduleDatePickerColors.buttonBackgroundColor, scheduleDatePickerColors.buttonBackgroundPressedColor));
        linearLayout.addView(animatedTextView, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        animatedTextView.setText(LocaleController.getString("DisableAutoDeleteTimer", R.string.DisableAutoDeleteTimer));
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda111
            @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker2, int i2, int i3) {
                AlertsCreator.lambda$createAutoDeleteDatePickerDialog$125(animatedTextView, linearLayout, numberPicker2, i2, i3);
            }
        });
        animatedTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.AlertsCreator$$ExternalSyntheticLambda62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createAutoDeleteDatePickerDialog$126(iArr, numberPicker, scheduleDatePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout);
        BottomSheet bottomSheetShow = builder.show();
        bottomSheetShow.setBackgroundColor(scheduleDatePickerColors.backgroundColor);
        bottomSheetShow.fixNavigationBar(scheduleDatePickerColors.backgroundColor);
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$createAutoDeleteDatePickerDialog$123(int[] iArr, int i) {
        if (iArr[i] == 0) {
            return LocaleController.getString("AutoDeleteNever", R.string.AutoDeleteNever);
        }
        if (iArr[i] < 10080) {
            return LocaleController.formatPluralString("Days", iArr[i] / 1440);
        }
        if (iArr[i] < 44640) {
            return LocaleController.formatPluralString("Weeks", iArr[i] / 10080);
        }
        if (iArr[i] < 525600) {
            return LocaleController.formatPluralString("Months", iArr[i] / 44640);
        }
        return LocaleController.formatPluralString("Years", iArr[i] / 525600);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAutoDeleteDatePickerDialog$125(AnimatedTextView animatedTextView, LinearLayout linearLayout, NumberPicker numberPicker, int i, int i2) {
        try {
            if (i2 == 0) {
                animatedTextView.setText(LocaleController.getString("DisableAutoDeleteTimer", R.string.DisableAutoDeleteTimer));
            } else {
                animatedTextView.setText(LocaleController.getString("SetAutoDeleteTimer", R.string.SetAutoDeleteTimer));
            }
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAutoDeleteDatePickerDialog$126(int[] iArr, NumberPicker numberPicker, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
        scheduleDatePickerDelegate.didSelectDate(true, iArr[numberPicker.getValue()]);
        builder.getDismissRunnable().run();
    }
}
