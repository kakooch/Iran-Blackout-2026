package ir.eitaa.ui.Components;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.URLSpan;
import android.util.Base64;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import ir.eitaa.helper.MxbHelper;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SecretChatHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.messenger.time.DateConverter;
import ir.eitaa.messenger.time.JalaliCalendar;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$ChannelParticipant;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$ReportReason;
import ir.eitaa.tgnet.TLRPC$TL_account_changePhone;
import ir.eitaa.tgnet.TLRPC$TL_account_confirmPhone;
import ir.eitaa.tgnet.TLRPC$TL_account_getAuthorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getTmpPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_saveSecureValue;
import ir.eitaa.tgnet.TLRPC$TL_account_sendChangePhoneCode;
import ir.eitaa.tgnet.TLRPC$TL_account_sendConfirmPhoneCode;
import ir.eitaa.tgnet.TLRPC$TL_account_updateProfile;
import ir.eitaa.tgnet.TLRPC$TL_account_verifyEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_verifyPhone;
import ir.eitaa.tgnet.TLRPC$TL_auth_resendCode;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channelParticipantCreator;
import ir.eitaa.tgnet.TLRPC$TL_channels_channelParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_createChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_editAdmin;
import ir.eitaa.tgnet.TLRPC$TL_channels_editBanned;
import ir.eitaa.tgnet.TLRPC$TL_channels_getParticipant;
import ir.eitaa.tgnet.TLRPC$TL_channels_inviteToChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_joinChannel;
import ir.eitaa.tgnet.TLRPC$TL_channels_reportSpam;
import ir.eitaa.tgnet.TLRPC$TL_contacts_blockFromReplies;
import ir.eitaa.tgnet.TLRPC$TL_contacts_importContacts;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_support;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_langPackLanguage;
import ir.eitaa.tgnet.TLRPC$TL_mbpUserRegisterInfos;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatAddUser;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatDeleteUser;
import ir.eitaa.tgnet.TLRPC$TL_messageActionChatJoinedByLink;
import ir.eitaa.tgnet.TLRPC$TL_messageActionEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionGeoProximityReached;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPinMessage;
import ir.eitaa.tgnet.TLRPC$TL_messageActionSetChatTheme;
import ir.eitaa.tgnet.TLRPC$TL_messages_addChatUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_checkHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_checkHistoryImportPeer;
import ir.eitaa.tgnet.TLRPC$TL_messages_createChat;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatAdmin;
import ir.eitaa.tgnet.TLRPC$TL_messages_editChatDefaultBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_messages_editMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_forwardMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_getAttachedStickers;
import ir.eitaa.tgnet.TLRPC$TL_messages_importChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_messages_initHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_messages_migrateChat;
import ir.eitaa.tgnet.TLRPC$TL_messages_report;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendInlineBotResult;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMessage;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendMultiMedia;
import ir.eitaa.tgnet.TLRPC$TL_messages_sendScheduledMessages;
import ir.eitaa.tgnet.TLRPC$TL_messages_startBot;
import ir.eitaa.tgnet.TLRPC$TL_messages_startHistoryImport;
import ir.eitaa.tgnet.TLRPC$TL_mxbUserRegisterInfo;
import ir.eitaa.tgnet.TLRPC$TL_payments_sendPaymentForm;
import ir.eitaa.tgnet.TLRPC$TL_payments_validateRequestedInfo;
import ir.eitaa.tgnet.TLRPC$TL_phone_inviteToGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_report_reason;
import ir.eitaa.tgnet.TLRPC$TL_updateUserName;
import ir.eitaa.tgnet.TLRPC$TL_upload_saveBigFilePart;
import ir.eitaa.tgnet.TLRPC$TL_upload_saveFilePart;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.CacheControlActivity;
import ir.eitaa.ui.Cells.AccountSelectCell;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.RadioColorCell;
import ir.eitaa.ui.Cells.TextCell;
import ir.eitaa.ui.Cells.TextColorCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.NumberPicker;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import ir.eitaa.ui.LanguageSelectActivity;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.LoginActivity;
import ir.eitaa.ui.NotificationsCustomSettingsActivity;
import ir.eitaa.ui.NotificationsSettingsActivity;
import ir.eitaa.ui.ThemePreviewActivity;
import ir.eitaa.ui.TooManyCommunitiesActivity;
import ir.eitaa.ui.explore.components.ExploreLivesDialogView;
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
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class AlertsCreator {

    public interface AccountSelectDelegate {
        void didSelectAccount(int account);
    }

    public interface BlockDialogCallback {
        void run(boolean report, boolean delete);
    }

    public interface DatePickerDelegate {
        void didSelectDate(int year, int month, int dayOfMonth);
    }

    public interface ScheduleDatePickerDelegate {
        void didSelectDate(boolean notify, int scheduleDate);
    }

    static /* synthetic */ boolean lambda$createCalendarPickerDialog$53(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$createChangeBioAlert$21(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$createChangeNameAlert$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ boolean lambda$createDatePickerDialog$47(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$95(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ boolean lambda$createScheduleDatePickerDialog$38(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$createThemeCreateDialog$97(DialogInterface dialogInterface, int i) {
    }

    static /* synthetic */ void lambda$sendEitaaReport$61(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static Dialog processError(final int currentAccount, TLRPC$TL_error error, BaseFragment fragment, TLObject request, Object... args) {
        String str;
        TLRPC$InputPeer tLRPC$InputPeer;
        int i = error.code;
        if (i == 406 || (str = error.text) == null) {
            return null;
        }
        if (i == 460) {
            NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, error.text);
            return null;
        }
        boolean z = request instanceof TLRPC$TL_messages_initHistoryImport;
        if (z || (request instanceof TLRPC$TL_messages_checkHistoryImportPeer) || (request instanceof TLRPC$TL_messages_checkHistoryImport) || (request instanceof TLRPC$TL_messages_startHistoryImport)) {
            if (z) {
                tLRPC$InputPeer = ((TLRPC$TL_messages_initHistoryImport) request).peer;
            } else {
                tLRPC$InputPeer = request instanceof TLRPC$TL_messages_startHistoryImport ? ((TLRPC$TL_messages_startHistoryImport) request).peer : null;
            }
            if (str.contains("USER_IS_BLOCKED")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorUserBlocked", R.string.ImportErrorUserBlocked));
            } else if (error.text.contains("USER_NOT_MUTUAL_CONTACT")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportMutualError", R.string.ImportMutualError));
            } else if (error.text.contains("IMPORT_PEER_TYPE_INVALID")) {
                if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
                    showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorChatInvalidUser", R.string.ImportErrorChatInvalidUser));
                } else {
                    showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorChatInvalidGroup", R.string.ImportErrorChatInvalidGroup));
                }
            } else if (error.text.contains("CHAT_ADMIN_REQUIRED")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorNotAdmin", R.string.ImportErrorNotAdmin));
            } else if (error.text.startsWith("IMPORT_FORMAT")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorFileFormatInvalid", R.string.ImportErrorFileFormatInvalid));
            } else if (error.text.startsWith("PEER_ID_INVALID")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorPeerInvalid", R.string.ImportErrorPeerInvalid));
            } else if (error.text.contains("IMPORT_LANG_NOT_FOUND")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportErrorFileLang", R.string.ImportErrorFileLang));
            } else if (error.text.contains("IMPORT_UPLOAD_FAILED")) {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ImportFailedToUpload", R.string.ImportFailedToUpload));
            } else if (error.text.startsWith("FLOOD_WAIT")) {
                showFloodWaitAlert(error.text, fragment);
            } else {
                showSimpleAlert(fragment, LocaleController.getString("ImportErrorTitle", R.string.ImportErrorTitle), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
            }
        } else if ((request instanceof TLRPC$TL_account_saveSecureValue) || (request instanceof TLRPC$TL_account_getAuthorizationForm)) {
            if (str.contains("PHONE_NUMBER_INVALID")) {
                showSimpleAlert(fragment, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
            } else if (error.text.startsWith("FLOOD_WAIT")) {
                showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
            } else if ("APP_VERSION_OUTDATED".equals(error.text)) {
                showUpdateAppAlert(fragment.getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
            } else {
                showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
            }
        } else {
            boolean z2 = request instanceof TLRPC$TL_channels_joinChannel;
            if (z2 || (request instanceof TLRPC$TL_channels_editAdmin) || (request instanceof TLRPC$TL_channels_inviteToChannel) || (request instanceof TLRPC$TL_messages_addChatUser) || (request instanceof TLRPC$TL_messages_startBot) || (request instanceof TLRPC$TL_channels_editBanned) || (request instanceof TLRPC$TL_messages_editChatDefaultBannedRights) || (request instanceof TLRPC$TL_messages_editChatAdmin) || (request instanceof TLRPC$TL_messages_migrateChat) || (request instanceof TLRPC$TL_phone_inviteToGroupCall)) {
                if (fragment != null && str.equals("CHANNELS_TOO_MUCH")) {
                    if (z2 || (request instanceof TLRPC$TL_channels_inviteToChannel)) {
                        fragment.presentFragment(new TooManyCommunitiesActivity(0));
                        return null;
                    }
                    fragment.presentFragment(new TooManyCommunitiesActivity(1));
                    return null;
                }
                if (fragment != null) {
                    showAddUserAlert(error.text, fragment, (args == null || args.length <= 0) ? false : ((Boolean) args[0]).booleanValue(), request);
                } else if (error.text.equals("PEER_FLOOD")) {
                    NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 1);
                }
            } else {
                if (request instanceof TLRPC$TL_messages_createChat) {
                    if (str.equals("CHANNELS_TOO_MUCH")) {
                        fragment.presentFragment(new TooManyCommunitiesActivity(2));
                        return null;
                    }
                    if (error.text.startsWith("FLOOD_WAIT")) {
                        showFloodWaitAlert(error.text, fragment);
                    } else {
                        showAddUserAlert(error.text, fragment, false, request);
                    }
                } else if (request instanceof TLRPC$TL_channels_createChannel) {
                    if (str.equals("CHANNELS_TOO_MUCH")) {
                        fragment.presentFragment(new TooManyCommunitiesActivity(2));
                        return null;
                    }
                    if (error.text.startsWith("FLOOD_WAIT")) {
                        showFloodWaitAlert(error.text, fragment);
                    } else {
                        showAddUserAlert(error.text, fragment, false, request);
                    }
                } else if (request instanceof TLRPC$TL_messages_editMessage) {
                    if (str.startsWith("CHAT_SEND_LINK_FORBIDDEN")) {
                        showSimpleAlert(fragment, LocaleController.getString("ErrorSendRestrictedLinksAll", R.string.ErrorSendRestrictedLinksAll));
                    } else if (!error.text.equals("MESSAGE_NOT_MODIFIED")) {
                        if (fragment != null) {
                            showSimpleAlert(fragment, LocaleController.getString("EditMessageError", R.string.EditMessageError));
                        } else {
                            showSimpleToast(null, LocaleController.getString("EditMessageError", R.string.EditMessageError));
                        }
                    }
                } else if ((request instanceof TLRPC$TL_messages_sendMessage) || (request instanceof TLRPC$TL_messages_sendMedia) || (request instanceof TLRPC$TL_messages_sendInlineBotResult) || (request instanceof TLRPC$TL_messages_forwardMessages) || (request instanceof TLRPC$TL_messages_sendMultiMedia) || (request instanceof TLRPC$TL_messages_sendScheduledMessages)) {
                    if (str.startsWith("ALL_PEER_FLOOD")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("NobodyLikesSpam10", R.string.NobodyLikesSpam10));
                    } else if (error.text.startsWith("GROUP_PEER_FLOOD")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("NobodyLikesSpam11", R.string.NobodyLikesSpam11));
                    } else if (error.text.equals("PEER_FLOOD")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 0);
                    } else if (error.text.startsWith("CHAT_SEND_LINK_FORBIDDEN")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("ErrorSendRestrictedLinksAll", R.string.ErrorSendRestrictedLinksAll));
                    } else if (error.text.startsWith("CHAT_WRITE_FORBIDDEN")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("SendMessageRestrictedForever", R.string.SendMessageRestrictedForever));
                    } else if (error.text.startsWith("CHAT_SEND_MEDIA_FORBIDDEN")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("ErrorSendRestrictedMediaAll", R.string.ErrorSendRestrictedMediaAll));
                    } else if (error.text.startsWith("CHAT_SEND_STICKERS_FORBIDDEN")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("ErrorSendRestrictedStickersAll", R.string.ErrorSendRestrictedStickersAll));
                    } else if (error.text.startsWith("FORWARD_WITH_OUT_QUOTING_DENY")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("ErrorForwardWithoutQuotingDenied", R.string.ErrorForwardWithoutQuotingDenied));
                    } else if (error.text.startsWith("MEDIA_NOT_FREE")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("ErrorMediaNotFree", R.string.ErrorMediaNotFree));
                    } else if (error.text.startsWith("FLOOD_WAIT")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.getString("FloodWait", R.string.FloodWait));
                    }
                } else if (request instanceof TLRPC$TL_messages_importChatInvite) {
                    if (str.startsWith("FLOOD_WAIT")) {
                        showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                    } else if (error.text.equals("USERS_TOO_MUCH")) {
                        showSimpleAlert(fragment, LocaleController.getString("JoinToGroupErrorFull", R.string.JoinToGroupErrorFull));
                    } else if (error.text.equals("CHANNELS_TOO_MUCH")) {
                        fragment.presentFragment(new TooManyCommunitiesActivity(0));
                    } else if (error.text.equals("INVITE_HASH_EXPIRED")) {
                        showSimpleAlert(fragment, LocaleController.getString("ExpiredLink", R.string.ExpiredLink), LocaleController.getString("InviteExpired", R.string.InviteExpired));
                    } else if (error.text.equals("INVITE_HASH_INVALID")) {
                        showSimpleAlert(fragment, LocaleController.getString("JoinToGroupErrorNotExist", R.string.JoinToGroupErrorNotExist));
                    } else if (fragment != null) {
                        showAddUserAlert(error.text, fragment, ((Boolean) args[0]).booleanValue(), null);
                    } else if (error.text.equals("PEER_FLOOD")) {
                        NotificationCenter.getInstance(currentAccount).postNotificationName(NotificationCenter.needShowAlert, 1);
                    }
                } else if (request instanceof TLRPC$TL_messages_getAttachedStickers) {
                    if (fragment != null && fragment.getParentActivity() != null) {
                        Toast.makeText(fragment.getParentActivity(), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text, 0).show();
                    }
                } else {
                    if ((request instanceof TLRPC$TL_account_confirmPhone) || (request instanceof TLRPC$TL_account_verifyPhone) || (request instanceof TLRPC$TL_account_verifyEmail)) {
                        if (str.contains("PHONE_CODE_EMPTY") || error.text.contains("PHONE_CODE_INVALID") || error.text.contains("CODE_INVALID") || error.text.contains("CODE_EMPTY")) {
                            return showSimpleAlert(fragment, LocaleController.getString("InvalidCode", R.string.InvalidCode));
                        }
                        if (error.text.contains("PHONE_CODE_EXPIRED") || error.text.contains("EMAIL_VERIFY_EXPIRED")) {
                            return showSimpleAlert(fragment, LocaleController.getString("CodeExpired", R.string.CodeExpired));
                        }
                        if (error.text.startsWith("FLOOD_WAIT")) {
                            return showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                        }
                        return showSimpleAlert(fragment, error.text);
                    }
                    if (request instanceof TLRPC$TL_auth_resendCode) {
                        if (str.contains("PHONE_NUMBER_INVALID")) {
                            return showSimpleAlert(fragment, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                        }
                        if (error.text.contains("PHONE_CODE_EMPTY") || error.text.contains("PHONE_CODE_INVALID")) {
                            return showSimpleAlert(fragment, LocaleController.getString("InvalidCode", R.string.InvalidCode));
                        }
                        if (error.text.contains("PHONE_CODE_EXPIRED")) {
                            return showSimpleAlert(fragment, LocaleController.getString("CodeExpired", R.string.CodeExpired));
                        }
                        if (error.text.startsWith("FLOOD_WAIT")) {
                            return showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                        }
                        if (error.code != -1000) {
                            return showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
                        }
                    } else {
                        if (request instanceof TLRPC$TL_account_sendConfirmPhoneCode) {
                            if (i == 400) {
                                return showSimpleAlert(fragment, LocaleController.getString("CancelLinkExpired", R.string.CancelLinkExpired));
                            }
                            if (str.startsWith("FLOOD_WAIT")) {
                                return showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                            }
                            return showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
                        }
                        if (request instanceof TLRPC$TL_account_changePhone) {
                            if (str.contains("PHONE_NUMBER_INVALID")) {
                                showSimpleAlert(fragment, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                            } else if (error.text.contains("PHONE_CODE_EMPTY") || error.text.contains("PHONE_CODE_INVALID")) {
                                showSimpleAlert(fragment, LocaleController.getString("InvalidCode", R.string.InvalidCode));
                            } else if (error.text.contains("PHONE_CODE_EXPIRED")) {
                                showSimpleAlert(fragment, LocaleController.getString("CodeExpired", R.string.CodeExpired));
                            } else if (error.text.startsWith("FLOOD_WAIT")) {
                                showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                            } else {
                                showSimpleAlert(fragment, error.text);
                            }
                        } else if (request instanceof TLRPC$TL_account_sendChangePhoneCode) {
                            if (str.contains("PHONE_NUMBER_INVALID")) {
                                LoginActivity.needShowInvalidAlert(fragment, (String) args[0], false);
                            } else if (error.text.contains("PHONE_CODE_EMPTY") || error.text.contains("PHONE_CODE_INVALID")) {
                                showSimpleAlert(fragment, LocaleController.getString("InvalidCode", R.string.InvalidCode));
                            } else if (error.text.contains("PHONE_CODE_EXPIRED")) {
                                showSimpleAlert(fragment, LocaleController.getString("CodeExpired", R.string.CodeExpired));
                            } else if (error.text.startsWith("FLOOD_WAIT")) {
                                showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                            } else if (error.text.startsWith("PHONE_NUMBER_OCCUPIED")) {
                                showSimpleAlert(fragment, LocaleController.formatString("ChangePhoneNumberOccupied", R.string.ChangePhoneNumberOccupied, args[0]));
                            } else if (error.text.startsWith("PHONE_NUMBER_BANNED")) {
                                LoginActivity.needShowInvalidAlert(fragment, (String) args[0], true);
                            } else {
                                showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
                            }
                        } else if (request instanceof TLRPC$TL_updateUserName) {
                            str.hashCode();
                            if (str.equals("USERNAME_INVALID")) {
                                showSimpleAlert(fragment, LocaleController.getString("UsernameInvalid", R.string.UsernameInvalid));
                            } else if (str.equals("USERNAME_OCCUPIED")) {
                                showSimpleAlert(fragment, LocaleController.getString("UsernameInUse", R.string.UsernameInUse));
                            } else {
                                showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
                            }
                        } else if (request instanceof TLRPC$TL_contacts_importContacts) {
                            if (str.startsWith("FLOOD_WAIT")) {
                                showSimpleAlert(fragment, LocaleController.getString("FloodWait", R.string.FloodWait));
                            } else {
                                showSimpleAlert(fragment, LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error.text);
                            }
                        } else if ((request instanceof TLRPC$TL_account_getPassword) || (request instanceof TLRPC$TL_account_getTmpPassword)) {
                            if (str.startsWith("FLOOD_WAIT")) {
                                showSimpleToast(fragment, getFloodWaitString(error.text));
                            } else {
                                showSimpleToast(fragment, error.text);
                            }
                        } else if (request instanceof TLRPC$TL_payments_sendPaymentForm) {
                            str.hashCode();
                            if (str.equals("BOT_PRECHECKOUT_FAILED")) {
                                showSimpleToast(fragment, LocaleController.getString("PaymentPrecheckoutFailed", R.string.PaymentPrecheckoutFailed));
                            } else if (str.equals("PAYMENT_FAILED")) {
                                showSimpleToast(fragment, LocaleController.getString("PaymentFailed", R.string.PaymentFailed));
                            } else {
                                showSimpleToast(fragment, error.text);
                            }
                        } else if (request instanceof TLRPC$TL_payments_validateRequestedInfo) {
                            str.hashCode();
                            if (str.equals("SHIPPING_NOT_AVAILABLE")) {
                                showSimpleToast(fragment, LocaleController.getString("PaymentNoShippingMethod", R.string.PaymentNoShippingMethod));
                            } else {
                                showSimpleToast(fragment, error.text);
                            }
                        } else if (((request instanceof TLRPC$TL_upload_saveBigFilePart) || (request instanceof TLRPC$TL_upload_saveFilePart)) && str.startsWith("MAX_FILE_SIZE")) {
                            final int iIntValue = Utilities.parseInt(error.text).intValue();
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$mu5exYR6-2_Q7jngosfAzqIlkfQ
                                @Override // java.lang.Runnable
                                public final void run() {
                                    int i2 = currentAccount;
                                    int i3 = iIntValue;
                                    NotificationCenter.getInstance(i2).postNotificationName(NotificationCenter.needShowAlert, 10, LocaleController.formatString("FileUploadLimit", R.string.FileUploadLimit, AndroidUtilities.formatFileSize(i3 * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV * Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV)));
                                }
                            });
                        }
                    }
                }
                return null;
            }
        }
        return null;
    }

    public static Toast showSimpleToast(BaseFragment baseFragment, final String text) {
        Context parentActivity;
        if (text == null) {
            return null;
        }
        if (baseFragment != null && baseFragment.getParentActivity() != null) {
            parentActivity = baseFragment.getParentActivity();
        } else {
            parentActivity = ApplicationLoader.applicationContext;
        }
        Toast toastMakeText = Toast.makeText(parentActivity, text, 1);
        toastMakeText.show();
        return toastMakeText;
    }

    public static AlertDialog showUpdateAppAlert(final Context context, final String text, boolean updateApp) {
        if (context == null || text == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(text);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        if (updateApp) {
            builder.setNegativeButton(LocaleController.getString("UpdateApp", R.string.UpdateApp), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$ebJS5nGczRSpfXERmU8_qKiV_RU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Browser.openUrl(context, BuildVars.PLAYSTORE_APP_URL);
                }
            });
        }
        return builder.show();
    }

    public static AlertDialog.Builder createLanguageAlert(final LaunchActivity activity, final TLRPC$TL_langPackLanguage language) {
        String string;
        int iIndexOf;
        if (language == null) {
            return null;
        }
        language.lang_code = language.lang_code.replace('-', '_').toLowerCase();
        language.plural_code = language.plural_code.replace('-', '_').toLowerCase();
        String str = language.base_lang_code;
        if (str != null) {
            language.base_lang_code = str.replace('-', '_').toLowerCase();
        }
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (LocaleController.getInstance().getCurrentLocaleInfo().shortName.equals(language.lang_code)) {
            builder.setTitle(LocaleController.getString("Language", R.string.Language));
            string = LocaleController.formatString("LanguageSame", R.string.LanguageSame, language.name);
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
            builder.setNeutralButton(LocaleController.getString("SETTINGS", R.string.SETTINGS), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$bNZRjhuWSIo0kxR6pqNmRPAYeSk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    activity.lambda$runLinkRequest$39(new LanguageSelectActivity());
                }
            });
        } else if (language.strings_count == 0) {
            builder.setTitle(LocaleController.getString("LanguageUnknownTitle", R.string.LanguageUnknownTitle));
            string = LocaleController.formatString("LanguageUnknownCustomAlert", R.string.LanguageUnknownCustomAlert, language.name);
            builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
        } else {
            builder.setTitle(LocaleController.getString("LanguageTitle", R.string.LanguageTitle));
            string = language.official ? LocaleController.formatString("LanguageAlert", R.string.LanguageAlert, language.name, Integer.valueOf((int) Math.ceil((language.translated_count / language.strings_count) * 100.0f))) : LocaleController.formatString("LanguageCustomAlert", R.string.LanguageCustomAlert, language.name, Integer.valueOf((int) Math.ceil((language.translated_count / language.strings_count) * 100.0f)));
            builder.setPositiveButton(LocaleController.getString("Change", R.string.Change), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$mQKPNbMFxt30SzE0URomh_2itnk
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlertsCreator.lambda$createLanguageAlert$3(language, activity, dialogInterface, i);
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
            spannableStringBuilder.setSpan(new URLSpanNoUnderline(language.translations_url) { // from class: ir.eitaa.ui.Components.AlertsCreator.1
                @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View widget) {
                    builder.getDismissRunnable().run();
                    super.onClick(widget);
                }
            }, iIndexOf2, iIndexOf - 1, 33);
        }
        TextView textView = new TextView(activity);
        textView.setText(spannableStringBuilder);
        textView.setTextSize(1, 16.0f);
        textView.setLinkTextColor(Theme.getColor("dialogTextLink"));
        textView.setHighlightColor(Theme.getColor("dialogLinkSelection"));
        textView.setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
        textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        builder.setView(textView);
        return builder;
    }

    static /* synthetic */ void lambda$createLanguageAlert$3(TLRPC$TL_langPackLanguage tLRPC$TL_langPackLanguage, LaunchActivity launchActivity, DialogInterface dialogInterface, int i) {
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

    public static boolean checkSlowMode(Context context, int currentAccount, long did, boolean few) {
        TLRPC$Chat chat;
        if (!DialogObject.isChatDialog(did) || (chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(-did))) == null || !chat.slowmode_enabled || ChatObject.hasAdminRights(chat)) {
            return false;
        }
        if (!few) {
            TLRPC$ChatFull chatFull = MessagesController.getInstance(currentAccount).getChatFull(chat.id);
            if (chatFull == null) {
                chatFull = MessagesStorage.getInstance(currentAccount).loadChatInfo(chat.id, ChatObject.isChannel(chat), new CountDownLatch(1), false, false);
            }
            if (chatFull != null && chatFull.slowmode_next_send_date >= ConnectionsManager.getInstance(currentAccount).getCurrentTime()) {
                few = true;
            }
        }
        if (!few) {
            return false;
        }
        createSimpleAlert(context, chat.title, LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError)).show();
        return true;
    }

    public static AlertDialog.Builder createSimpleAlert(Context context, final String text) {
        return createSimpleAlert(context, null, text);
    }

    public static AlertDialog.Builder createSimpleAlert(Context context, final String title, final String text) {
        return createSimpleAlert(context, title, text, null);
    }

    public static AlertDialog.Builder createSimpleAlert(Context context, final String title, final String text, Theme.ResourcesProvider resourcesProvider) {
        if (context == null || text == null) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (title == null) {
            title = LocaleController.getString("AppName", R.string.AppName);
        }
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        return builder;
    }

    public static Dialog showSimpleAlert(BaseFragment baseFragment, final String text) {
        return showSimpleAlert(baseFragment, null, text);
    }

    public static Dialog showSimpleAlert(BaseFragment baseFragment, final String title, final String text) {
        return showSimpleAlert(baseFragment, title, text, null);
    }

    public static Dialog showSimpleAlert(BaseFragment baseFragment, final String title, final String text, Theme.ResourcesProvider resourcesProvider) {
        if (text == null || baseFragment == null || baseFragment.getParentActivity() == null) {
            return null;
        }
        AlertDialog alertDialogCreate = createSimpleAlert(baseFragment.getParentActivity(), title, text, resourcesProvider).create();
        baseFragment.showDialog(alertDialogCreate);
        return alertDialogCreate;
    }

    public static void showBlockReportSpamReplyAlert(final ChatActivity fragment, final MessageObject messageObject, long peerId, final Theme.ResourcesProvider resourcesProvider) {
        if (fragment == null || fragment.getParentActivity() == null || messageObject == null) {
            return;
        }
        final AccountInstance accountInstance = fragment.getAccountInstance();
        final TLRPC$User user = peerId > 0 ? accountInstance.getMessagesController().getUser(Long.valueOf(peerId)) : null;
        final TLRPC$Chat chat = peerId < 0 ? accountInstance.getMessagesController().getChat(Long.valueOf(-peerId)) : null;
        if (user == null && chat == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity(), resourcesProvider);
        builder.setTitle(LocaleController.getString("BlockUser", R.string.BlockUser));
        if (user != null) {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserReplyAlert", R.string.BlockUserReplyAlert, UserObject.getFirstName(user))));
        } else {
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserReplyAlert", R.string.BlockUserReplyAlert, chat.title)));
        }
        LinearLayout linearLayout = new LinearLayout(fragment.getParentActivity());
        linearLayout.setOrientation(1);
        final CheckBoxCell[] checkBoxCellArr = {new CheckBoxCell(fragment.getParentActivity(), 1, resourcesProvider)};
        checkBoxCellArr[0].setBackgroundDrawable(Theme.getSelectorDrawable(false));
        checkBoxCellArr[0].setTag(0);
        checkBoxCellArr[0].setText(LocaleController.getString("DeleteReportSpam", R.string.DeleteReportSpam), "", true, false);
        checkBoxCellArr[0].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
        linearLayout.addView(checkBoxCellArr[0], LayoutHelper.createLinear(-1, -2));
        checkBoxCellArr[0].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$caJx74MjsJG9DrCpOFjjh8qSFPQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                checkBoxCellArr[((Integer) view.getTag()).intValue()].setChecked(!r0[view.intValue()].isChecked(), true);
            }
        });
        builder.setCustomViewOffset(12);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("BlockAndDeleteReplies", R.string.BlockAndDeleteReplies), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$oK_7nI_Rux1B6MVL-v1sSJkFuCQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$6(user, accountInstance, fragment, chat, messageObject, checkBoxCellArr, resourcesProvider, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        fragment.showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$6(TLRPC$User tLRPC$User, final AccountInstance accountInstance, ChatActivity chatActivity, TLRPC$Chat tLRPC$Chat, MessageObject messageObject, CheckBoxCell[] checkBoxCellArr, Theme.ResourcesProvider resourcesProvider, DialogInterface dialogInterface, int i) {
        if (tLRPC$User != null) {
            accountInstance.getMessagesStorage().deleteUserChatHistory(chatActivity.getDialogId(), tLRPC$User.id);
        } else {
            accountInstance.getMessagesStorage().deleteUserChatHistory(chatActivity.getDialogId(), -tLRPC$Chat.id);
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
        accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_contacts_blockFromReplies, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$z48fCCvBIqsBmDAK8b4ty1o7sxA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AlertsCreator.lambda$showBlockReportSpamReplyAlert$5(accountInstance, tLObject, tLRPC$TL_error);
            }
        });
    }

    static /* synthetic */ void lambda$showBlockReportSpamReplyAlert$5(AccountInstance accountInstance, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$Updates) {
            accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void showBlockReportSpamAlert(ir.eitaa.ui.ActionBar.BaseFragment r17, final long r18, final ir.eitaa.tgnet.TLRPC$User r20, final ir.eitaa.tgnet.TLRPC$Chat r21, final ir.eitaa.tgnet.TLRPC$EncryptedChat r22, final boolean r23, ir.eitaa.tgnet.TLRPC$ChatFull r24, final ir.eitaa.messenger.MessagesStorage.IntCallback r25, ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r26) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AlertsCreator.showBlockReportSpamAlert(ir.eitaa.ui.ActionBar.BaseFragment, long, ir.eitaa.tgnet.TLRPC$User, ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$EncryptedChat, boolean, ir.eitaa.tgnet.TLRPC$ChatFull, ir.eitaa.messenger.MessagesStorage$IntCallback, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):void");
    }

    static /* synthetic */ void lambda$showBlockReportSpamAlert$8(TLRPC$User tLRPC$User, AccountInstance accountInstance, CheckBoxCell[] checkBoxCellArr, long j, TLRPC$Chat tLRPC$Chat, TLRPC$EncryptedChat tLRPC$EncryptedChat, boolean z, MessagesStorage.IntCallback intCallback, DialogInterface dialogInterface, int i) {
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
                accountInstance.getMessagesController().deleteParticipantFromChat(-j, accountInstance.getMessagesController().getUser(Long.valueOf(accountInstance.getUserConfig().getClientUserId())), null);
            }
            intCallback.run(1);
            return;
        }
        intCallback.run(0);
    }

    public static void showCustomNotificationsDialog(BaseFragment parentFragment, long did, int globalType, ArrayList<NotificationsSettingsActivity.NotificationException> exceptions, int currentAccount, MessagesStorage.IntCallback callback) throws Resources.NotFoundException {
        showCustomNotificationsDialog(parentFragment, did, globalType, exceptions, currentAccount, callback, null);
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
                    textView.setTextColor(Theme.getColor("dialogTextRed"));
                    drawable3.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogRedIcon"), PorterDuff.Mode.MULTIPLY));
                } else {
                    textView.setTextColor(Theme.getColor("dialogTextBlack"));
                    drawable3.setColorFilter(new PorterDuffColorFilter(Theme.getColor("dialogIcon"), PorterDuff.Mode.MULTIPLY));
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
                textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$_DYEi5o0TVTw1xiIpqzwmFgtNLU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AlertsCreator.lambda$showCustomNotificationsDialog$9(j, i2, zIsGlobalNotificationsEnabled, intCallback2, i, baseFragment, arrayList, intCallback, builder, view2);
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

    /* JADX WARN: Removed duplicated region for block: B:57:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void lambda$showCustomNotificationsDialog$9(long r18, int r20, boolean r21, ir.eitaa.messenger.MessagesStorage.IntCallback r22, int r23, ir.eitaa.ui.ActionBar.BaseFragment r24, java.util.ArrayList r25, ir.eitaa.messenger.MessagesStorage.IntCallback r26, ir.eitaa.ui.ActionBar.AlertDialog.Builder r27, android.view.View r28) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AlertsCreator.lambda$showCustomNotificationsDialog$9(long, int, boolean, ir.eitaa.messenger.MessagesStorage$IntCallback, int, ir.eitaa.ui.ActionBar.BaseFragment, java.util.ArrayList, ir.eitaa.messenger.MessagesStorage$IntCallback, ir.eitaa.ui.ActionBar.AlertDialog$Builder, android.view.View):void");
    }

    public static AlertDialog showSecretLocationAlert(Context context, int currentAccount, final Runnable onSelectRunnable, boolean inChat, Theme.ResourcesProvider resourcesProvider) {
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        int i = MessagesController.getInstance(currentAccount).availableMapProviders;
        if ((i & 1) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderEitaa ", R.string.MapPreviewProviderEitaa));
            arrayList2.add(0);
        }
        if ((i & 2) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderGoogle", R.string.MapPreviewProviderGoogle));
            arrayList2.add(1);
        }
        if ((i & 4) != 0) {
            arrayList.add(LocaleController.getString("MapPreviewProviderYandex", R.string.MapPreviewProviderYandex));
            arrayList2.add(3);
        }
        arrayList.add(LocaleController.getString("MapPreviewProviderNobody", R.string.MapPreviewProviderNobody));
        arrayList2.add(2);
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, resourcesProvider);
        builder.setTitle(LocaleController.getString("MapPreviewProviderTitle", R.string.MapPreviewProviderTitle));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            RadioColorCell radioColorCell = new RadioColorCell(context, resourcesProvider);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue((String) arrayList.get(i2), SharedConfig.mapPreviewType == ((Integer) arrayList2.get(i2)).intValue());
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$v_9YWO66nNdB87vL4RXeX2HSLL0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$showSecretLocationAlert$10(arrayList2, onSelectRunnable, builder, view);
                }
            });
        }
        if (!inChat) {
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        }
        AlertDialog alertDialogShow = builder.show();
        if (inChat) {
            alertDialogShow.setCanceledOnTouchOutside(false);
        }
        return alertDialogShow;
    }

    static /* synthetic */ void lambda$showSecretLocationAlert$10(ArrayList arrayList, Runnable runnable, AlertDialog.Builder builder, View view) {
        SharedConfig.setSecretMapPreviewType(((Integer) arrayList.get(((Integer) view.getTag()).intValue())).intValue());
        if (runnable != null) {
            runnable.run();
        }
        builder.getDismissRunnable().run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateDayPicker(NumberPicker dayPicker, NumberPicker monthPicker, NumberPicker yearPicker) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, monthPicker.getValue());
        calendar.set(1, yearPicker.getValue());
        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(calendar.getActualMaximum(5));
    }

    private static void checkPickerDate(NumberPicker dayPicker, NumberPicker monthPicker, NumberPicker yearPicker) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        if (i > yearPicker.getValue()) {
            yearPicker.setValue(i);
        }
        if (yearPicker.getValue() == i) {
            if (i2 > monthPicker.getValue()) {
                monthPicker.setValue(i2);
            }
            if (i2 != monthPicker.getValue() || i3 <= dayPicker.getValue()) {
                return;
            }
            dayPicker.setValue(i3);
        }
    }

    public static void showOpenUrlAlert(BaseFragment fragment, String url, boolean punycode, boolean ask) {
        showOpenUrlAlert(fragment, url, punycode, true, ask, null);
    }

    public static void showOpenUrlAlert(BaseFragment fragment, String url, boolean punycode, boolean ask, Theme.ResourcesProvider resourcesProvider) {
        showOpenUrlAlert(fragment, url, punycode, true, ask, resourcesProvider);
    }

    public static void showOpenUrlAlert(final BaseFragment fragment, final String url, boolean punycode, final boolean tryTelegraph, boolean ask, Theme.ResourcesProvider resourcesProvider) {
        String str;
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        long inlineReturn = fragment instanceof ChatActivity ? ((ChatActivity) fragment).getInlineReturn() : 0L;
        if (Browser.isInternalUrl(url, null) || !ask) {
            Browser.openUrl(fragment.getParentActivity(), url, inlineReturn == 0, tryTelegraph);
            return;
        }
        if (punycode) {
            try {
                Uri uri = Uri.parse(url);
                str = uri.getScheme() + "://" + IDN.toASCII(uri.getHost(), 1) + uri.getPath();
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            str = url;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity(), resourcesProvider);
        builder.setTitle(LocaleController.getString("OpenUrlTitle", R.string.OpenUrlTitle));
        String string = LocaleController.getString("OpenUrlAlert2", R.string.OpenUrlAlert2);
        int iIndexOf = string.indexOf("%");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, str));
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new URLSpan(str), iIndexOf, str.length() + iIndexOf, 33);
        }
        builder.setMessage(spannableStringBuilder);
        builder.setMessageTextViewClickable(false);
        final long j = inlineReturn;
        builder.setPositiveButton(LocaleController.getString("Open", R.string.Open), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$1i6ZqjvWb2ABHb4COAKHIph4s9w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.PositiveButtonAlert(url, fragment, j, Boolean.valueOf(tryTelegraph));
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        fragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void PositiveButtonAlert(String url, BaseFragment fragment, long inlineReturn, Boolean tryTelegraph) {
        if (url.toLowerCase().contains("?eitaafly") || url.toLowerCase().contains("&eitaafly")) {
            EmbedBottomSheet.show(fragment.getParentActivity(), null, null, "", "", url, url, 680, 360, false);
        } else {
            Browser.openUrl(fragment.getParentActivity(), url, inlineReturn == 0, tryTelegraph.booleanValue());
        }
    }

    public static AlertDialog createSupportAlert(final BaseFragment fragment) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return null;
        }
        TextView textView = new TextView(fragment.getParentActivity());
        SpannableString spannableString = new SpannableString(Html.fromHtml(LocaleController.getString("AskAQuestionInfo", R.string.AskAQuestionInfo).replace("\n", "<br>")));
        for (URLSpan uRLSpan : (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class)) {
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            spannableString.removeSpan(uRLSpan);
            spannableString.setSpan(new URLSpanNoUnderline(uRLSpan.getURL()) { // from class: ir.eitaa.ui.Components.AlertsCreator.2
                @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                public void onClick(View widget) {
                    fragment.dismissCurrentDialog();
                    super.onClick(widget);
                }
            }, spanStart, spanEnd, 0);
        }
        textView.setText(spannableString);
        textView.setTextSize(1, 16.0f);
        textView.setLinkTextColor(Theme.getColor("dialogTextLink"));
        textView.setHighlightColor(Theme.getColor("dialogLinkSelection"));
        textView.setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
        textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity());
        builder.setView(textView);
        builder.setTitle(LocaleController.getString("AskAQuestion", R.string.AskAQuestion));
        builder.setPositiveButton(LocaleController.getString("AskButton", R.string.AskButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$BXWzEAjjkY-xlDryqxmy8iG7KfM
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.performAskAQuestion(fragment);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void performAskAQuestion(final ir.eitaa.ui.ActionBar.BaseFragment r11) {
        /*
            int r0 = r11.getCurrentAccount()
            android.content.SharedPreferences r1 = ir.eitaa.messenger.MessagesController.getMainSettings(r0)
            java.lang.String r2 = "support_id2"
            r3 = 0
            long r5 = ir.eitaa.messenger.AndroidUtilities.getPrefIntOrLong(r1, r2, r3)
            r2 = 0
            r7 = 0
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 == 0) goto L56
            ir.eitaa.messenger.MessagesController r3 = ir.eitaa.messenger.MessagesController.getInstance(r0)
            java.lang.Long r4 = java.lang.Long.valueOf(r5)
            ir.eitaa.tgnet.TLRPC$User r3 = r3.getUser(r4)
            if (r3 != 0) goto L55
            java.lang.String r4 = "support_user"
            java.lang.String r4 = r1.getString(r4, r7)
            if (r4 == 0) goto L55
            byte[] r4 = android.util.Base64.decode(r4, r2)     // Catch: java.lang.Exception -> L50
            if (r4 == 0) goto L55
            ir.eitaa.tgnet.SerializedData r3 = new ir.eitaa.tgnet.SerializedData     // Catch: java.lang.Exception -> L50
            r3.<init>(r4)     // Catch: java.lang.Exception -> L50
            int r4 = r3.readInt32(r2)     // Catch: java.lang.Exception -> L50
            ir.eitaa.tgnet.TLRPC$User r4 = ir.eitaa.tgnet.TLRPC$User.TLdeserialize(r3, r4, r2)     // Catch: java.lang.Exception -> L50
            if (r4 == 0) goto L4b
            long r5 = r4.id     // Catch: java.lang.Exception -> L50
            r8 = 333000(0x514c8, double:1.64524E-318)
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 != 0) goto L4b
            r4 = r7
        L4b:
            r3.cleanup()     // Catch: java.lang.Exception -> L50
            r7 = r4
            goto L56
        L50:
            r3 = move-exception
            ir.eitaa.messenger.FileLog.e(r3)
            goto L56
        L55:
            r7 = r3
        L56:
            if (r7 != 0) goto L7a
            ir.eitaa.ui.ActionBar.AlertDialog r3 = new ir.eitaa.ui.ActionBar.AlertDialog
            android.app.Activity r4 = r11.getParentActivity()
            r5 = 3
            r3.<init>(r4, r5)
            r3.setCanCacnel(r2)
            r3.show()
            ir.eitaa.tgnet.TLRPC$TL_help_getSupport r2 = new ir.eitaa.tgnet.TLRPC$TL_help_getSupport
            r2.<init>()
            ir.eitaa.tgnet.ConnectionsManager r4 = ir.eitaa.tgnet.ConnectionsManager.getInstance(r0)
            ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$vSsEL6dKPbFvjewE5cYUgxQh01k r5 = new ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$vSsEL6dKPbFvjewE5cYUgxQh01k
            r5.<init>()
            r4.sendRequest(r2, r5)
            goto L96
        L7a:
            ir.eitaa.messenger.MessagesController r0 = ir.eitaa.messenger.MessagesController.getInstance(r0)
            r1 = 1
            r0.putUser(r7, r1)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            long r1 = r7.id
            java.lang.String r3 = "user_id"
            r0.putLong(r3, r1)
            ir.eitaa.ui.ChatActivity r1 = new ir.eitaa.ui.ChatActivity
            r1.<init>(r0)
            r11.presentFragment(r1)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AlertsCreator.performAskAQuestion(ir.eitaa.ui.ActionBar.BaseFragment):void");
    }

    static /* synthetic */ void lambda$performAskAQuestion$15(final SharedPreferences sharedPreferences, final AlertDialog alertDialog, final int i, final BaseFragment baseFragment, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_help_support tLRPC$TL_help_support = (TLRPC$TL_help_support) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$X7vo1dzNYOLN0LO9K31nDSRptLA
                @Override // java.lang.Runnable
                public final void run() {
                    AlertsCreator.lambda$performAskAQuestion$13(sharedPreferences, tLRPC$TL_help_support, alertDialog, i, baseFragment);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$-brHVZPW1M21qnuATPh3PmtmC24
                @Override // java.lang.Runnable
                public final void run() {
                    AlertsCreator.lambda$performAskAQuestion$14(alertDialog);
                }
            });
        }
    }

    static /* synthetic */ void lambda$performAskAQuestion$13(SharedPreferences sharedPreferences, TLRPC$TL_help_support tLRPC$TL_help_support, AlertDialog alertDialog, int i, BaseFragment baseFragment) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("support_id2", tLRPC$TL_help_support.user.id);
        SerializedData serializedData = new SerializedData();
        tLRPC$TL_help_support.user.serializeToStream(serializedData);
        editorEdit.putString("support_user", Base64.encodeToString(serializedData.toByteArray(), 0));
        editorEdit.commit();
        serializedData.cleanup();
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$TL_help_support.user);
        MessagesStorage.getInstance(i).putUsersAndChats(arrayList, null, true, true);
        MessagesController.getInstance(i).putUser(tLRPC$TL_help_support.user, false);
        Bundle bundle = new Bundle();
        bundle.putLong("user_id", tLRPC$TL_help_support.user.id);
        baseFragment.presentFragment(new ChatActivity(bundle));
    }

    static /* synthetic */ void lambda$performAskAQuestion$14(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void createImportDialogAlert(BaseFragment fragment, String title, String message, TLRPC$User user, TLRPC$Chat chat, final Runnable onProcessRunnable) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        if (chat == null && user == null) {
            return;
        }
        int currentAccount = fragment.getCurrentAccount();
        Activity parentActivity = fragment.getParentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        long clientUserId = UserConfig.getInstance(currentAccount).getClientUserId();
        TextView textView = new TextView(parentActivity);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
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
        textView2.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        textView2.setTextSize(1, 20.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(LocaleController.getString("ImportMessages", R.string.ImportMessages));
        boolean z = LocaleController.isRTL;
        frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 21 : 76, 11.0f, z ? 76 : 21, 0.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
        if (user != null) {
            if (UserObject.isReplyUser(user)) {
                avatarDrawable.setSmallSize(true);
                avatarDrawable.setAvatarType(12);
                backupImageView.setImage((ImageLocation) null, (String) null, avatarDrawable, user);
            } else if (user.id == clientUserId) {
                avatarDrawable.setSmallSize(true);
                avatarDrawable.setAvatarType(1);
                backupImageView.setImage((ImageLocation) null, (String) null, avatarDrawable, user);
            } else {
                avatarDrawable.setSmallSize(false);
                avatarDrawable.setInfo(user);
                backupImageView.setForUserOrChat(user, avatarDrawable);
            }
        } else {
            avatarDrawable.setInfo(chat);
            backupImageView.setForUserOrChat(chat, avatarDrawable);
        }
        textView.setText(AndroidUtilities.replaceTags(message));
        builder.setPositiveButton(LocaleController.getString("Import", R.string.Import), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$zitJGizNnOUfWBjcpQv16D6q0K8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createImportDialogAlert$16(onProcessRunnable, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        fragment.showDialog(builder.create());
    }

    static /* synthetic */ void lambda$createImportDialogAlert$16(Runnable runnable, DialogInterface dialogInterface, int i) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void createClearOrDeleteDialogAlert(BaseFragment fragment, boolean clear, TLRPC$Chat chat, TLRPC$User user, boolean secret, boolean checkDeleteForAll, MessagesStorage.BooleanCallback onProcessRunnable) {
        createClearOrDeleteDialogAlert(fragment, clear, chat != null && chat.creator, false, chat, user, secret, checkDeleteForAll, onProcessRunnable, null);
    }

    public static void createClearOrDeleteDialogAlert(BaseFragment fragment, boolean clear, TLRPC$Chat chat, TLRPC$User user, boolean secret, boolean checkDeleteForAll, MessagesStorage.BooleanCallback onProcessRunnable, Theme.ResourcesProvider resourcesProvider) {
        createClearOrDeleteDialogAlert(fragment, clear, chat != null && chat.creator, false, chat, user, secret, checkDeleteForAll, onProcessRunnable, resourcesProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void createClearOrDeleteDialogAlert(final ir.eitaa.ui.ActionBar.BaseFragment r35, final boolean r36, final boolean r37, final boolean r38, final ir.eitaa.tgnet.TLRPC$Chat r39, final ir.eitaa.tgnet.TLRPC$User r40, final boolean r41, final boolean r42, final ir.eitaa.messenger.MessagesStorage.BooleanCallback r43, final ir.eitaa.ui.ActionBar.Theme.ResourcesProvider r44) {
        /*
            Method dump skipped, instructions count: 1450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AlertsCreator.createClearOrDeleteDialogAlert(ir.eitaa.ui.ActionBar.BaseFragment, boolean, boolean, boolean, ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$User, boolean, boolean, ir.eitaa.messenger.MessagesStorage$BooleanCallback, ir.eitaa.ui.ActionBar.Theme$ResourcesProvider):void");
    }

    static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$17(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$19(boolean z, boolean z2, boolean z3, final TLRPC$User tLRPC$User, final BaseFragment baseFragment, final boolean z4, final boolean z5, final TLRPC$Chat tLRPC$Chat, final boolean z6, final MessagesStorage.BooleanCallback booleanCallback, final Theme.ResourcesProvider resourcesProvider, final boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (!z && !z2 && !z3) {
            if (UserObject.isUserSelf(tLRPC$User)) {
                createClearOrDeleteDialogAlert(baseFragment, z4, z5, true, tLRPC$Chat, tLRPC$User, false, z6, booleanCallback, resourcesProvider);
                return;
            } else if (tLRPC$User != null && zArr[0]) {
                MessagesStorage.getInstance(baseFragment.getCurrentAccount()).getMessagesCount(tLRPC$User.id, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$S0Ko7raFWgZTTbPf2HcgmI4E0vc
                    @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                    public final void run(int i2) {
                        AlertsCreator.lambda$createClearOrDeleteDialogAlert$18(baseFragment, z4, z5, tLRPC$Chat, tLRPC$User, z6, booleanCallback, resourcesProvider, zArr, i2);
                    }
                });
                return;
            }
        }
        if (booleanCallback != null) {
            booleanCallback.run(z2 || zArr[0]);
        }
    }

    static /* synthetic */ void lambda$createClearOrDeleteDialogAlert$18(BaseFragment baseFragment, boolean z, boolean z2, TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, boolean z3, MessagesStorage.BooleanCallback booleanCallback, Theme.ResourcesProvider resourcesProvider, boolean[] zArr, int i) {
        if (i >= 50) {
            createClearOrDeleteDialogAlert(baseFragment, z, z2, true, tLRPC$Chat, tLRPC$User, false, z3, booleanCallback, resourcesProvider);
        } else if (booleanCallback != null) {
            booleanCallback.run(zArr[0]);
        }
    }

    public static void createCallDialogAlert(final BaseFragment fragment, final TLRPC$User user, final boolean videoCall) {
        String string;
        String string2;
        if (fragment == null || fragment.getParentActivity() == null || user == null || UserObject.isDeleted(user) || UserConfig.getInstance(fragment.getCurrentAccount()).getClientUserId() == user.id) {
            return;
        }
        fragment.getCurrentAccount();
        Activity parentActivity = fragment.getParentActivity();
        FrameLayout frameLayout = new FrameLayout(parentActivity);
        if (videoCall) {
            string = LocaleController.getString("VideoCallAlertTitle", R.string.VideoCallAlertTitle);
            string2 = LocaleController.formatString("VideoCallAlert", R.string.VideoCallAlert, UserObject.getUserName(user));
        } else {
            string = LocaleController.getString("CallAlertTitle", R.string.CallAlertTitle);
            string2 = LocaleController.formatString("CallAlert", R.string.CallAlert, UserObject.getUserName(user));
        }
        TextView textView = new TextView(parentActivity);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        textView.setText(AndroidUtilities.replaceTags(string2));
        AvatarDrawable avatarDrawable = new AvatarDrawable();
        avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
        avatarDrawable.setSmallSize(false);
        avatarDrawable.setInfo(user);
        BackupImageView backupImageView = new BackupImageView(parentActivity);
        backupImageView.setRoundRadius(AndroidUtilities.dp(20.0f));
        backupImageView.setForUserOrChat(user, avatarDrawable);
        frameLayout.addView(backupImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 5 : 3) | 48, 22.0f, 5.0f, 22.0f, 0.0f));
        TextView textView2 = new TextView(parentActivity);
        textView2.setTextColor(Theme.getColor("actionBarDefaultSubmenuItem"));
        textView2.setTextSize(1, 20.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setLines(1);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(string);
        boolean z = LocaleController.isRTL;
        frameLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 21 : 76, 11.0f, z ? 76 : 21, 0.0f));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
        fragment.showDialog(new AlertDialog.Builder(parentActivity).setView(frameLayout).setPositiveButton(LocaleController.getString("Call", R.string.Call), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$G4U1c7VXbRSJaat4RVsXHjgmccw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createCallDialogAlert$20(fragment, user, videoCall, dialogInterface, i);
            }
        }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).create());
    }

    static /* synthetic */ void lambda$createCallDialogAlert$20(BaseFragment baseFragment, TLRPC$User tLRPC$User, boolean z, DialogInterface dialogInterface, int i) {
        TLRPC$UserFull userFull = baseFragment.getMessagesController().getUserFull(tLRPC$User.id);
        VoIPHelper.startCall(tLRPC$User, z, userFull != null && userFull.video_calls_available, baseFragment.getParentActivity(), userFull, baseFragment.getAccountInstance());
    }

    public static void createChangeBioAlert(String currentBio, final long peerId, final Context context, final int currentAccount) {
        int i;
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(peerId > 0 ? LocaleController.getString("UserBio", R.string.UserBio) : LocaleController.getString("DescriptionPlaceholder", R.string.DescriptionPlaceholder));
        if (peerId > 0) {
            i = R.string.VoipGroupBioEditAlertText;
            str = "VoipGroupBioEditAlertText";
        } else {
            i = R.string.DescriptionInfo;
            str = "DescriptionInfo";
        }
        builder.setMessage(LocaleController.getString(str, i));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setClipChildren(false);
        if (peerId < 0) {
            long j = -peerId;
            if (MessagesController.getInstance(currentAccount).getChatFull(j) == null) {
                MessagesController.getInstance(currentAccount).loadFullChat(j, ConnectionsManager.generateClassGuid(), true);
            }
        }
        final NumberTextView numberTextView = new NumberTextView(context);
        final EditText editText = new EditText(context);
        editText.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
        editText.setHint(peerId > 0 ? LocaleController.getString("UserBio", R.string.UserBio) : LocaleController.getString("DescriptionPlaceholder", R.string.DescriptionPlaceholder));
        editText.setTextSize(1, 16.0f);
        editText.setTypeface(AndroidUtilities.getFontFamily(false));
        editText.setBackground(Theme.createEditTextDrawable(context, true));
        editText.setMaxLines(4);
        editText.setRawInputType(147457);
        editText.setImeOptions(6);
        InputFilter[] inputFilterArr = new InputFilter[1];
        final int i2 = peerId > 0 ? 70 : 255;
        inputFilterArr[0] = new CodepointsLengthInputFilter(i2) { // from class: ir.eitaa.ui.Components.AlertsCreator.4
            @Override // ir.eitaa.ui.Components.CodepointsLengthInputFilter, android.text.InputFilter
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                CharSequence charSequenceFilter = super.filter(source, start, end, dest, dstart, dend);
                if (charSequenceFilter != null && source != null && charSequenceFilter.length() != source.length()) {
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
        numberTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        numberTextView.setImportantForAccessibility(2);
        frameLayout.addView(numberTextView, LayoutHelper.createFrame(20, 20.0f, LocaleController.isRTL ? 3 : 5, 0.0f, 14.0f, 21.0f, 0.0f));
        editText.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(24.0f) : 0, AndroidUtilities.dp(8.0f), LocaleController.isRTL ? 0 : AndroidUtilities.dp(24.0f), AndroidUtilities.dp(8.0f));
        editText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.AlertsCreator.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                int iCodePointCount = i2 - Character.codePointCount(s, 0, s.length());
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
        editText.setText(currentBio);
        editText.setSelection(editText.getText().toString().length());
        builder.setView(frameLayout);
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$bk0HfoSekMdUnyR4A7soCyHROMg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertsCreator.lambda$createChangeBioAlert$22(peerId, currentAccount, editText, dialogInterface, i3);
            }
        };
        builder.setPositiveButton(LocaleController.getString("Save", R.string.Save), onClickListener);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$gukpXbAuOHkZD37RKbSNBxDg-Ck
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AndroidUtilities.hideKeyboard(editText);
            }
        });
        frameLayout.addView(editText, LayoutHelper.createFrame(-1, -2.0f, 0, 23.0f, 12.0f, 23.0f, 21.0f));
        editText.requestFocus();
        AndroidUtilities.showKeyboard(editText);
        final AlertDialog alertDialogCreate = builder.create();
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$qE6ffyUTLXNHHw77Uc6VyBvsF0o
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createChangeBioAlert$24(peerId, alertDialogCreate, onClickListener, textView, i3, keyEvent);
            }
        });
        alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
        alertDialogCreate.show();
        alertDialogCreate.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
    }

    static /* synthetic */ void lambda$createChangeBioAlert$22(long j, int i, EditText editText, DialogInterface dialogInterface, int i2) {
        if (j > 0) {
            TLRPC$UserFull userFull = MessagesController.getInstance(i).getUserFull(UserConfig.getInstance(i).getClientUserId());
            String strTrim = editText.getText().toString().replace("\n", " ").replaceAll(" +", " ").trim();
            if (userFull != null) {
                String str = userFull.about;
                if ((str != null ? str : "").equals(strTrim)) {
                    AndroidUtilities.hideKeyboard(editText);
                    dialogInterface.dismiss();
                    return;
                } else {
                    userFull.about = strTrim;
                    NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.userInfoDidLoad, Long.valueOf(j), userFull);
                }
            }
            TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile = new TLRPC$TL_account_updateProfile();
            tLRPC$TL_account_updateProfile.about = strTrim;
            tLRPC$TL_account_updateProfile.flags = 4 | tLRPC$TL_account_updateProfile.flags;
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 2, Long.valueOf(j));
            ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_account_updateProfile, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$vPmXgUsPMh0sZY6KU3VM2LtERuQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AlertsCreator.lambda$createChangeBioAlert$21(tLObject, tLRPC$TL_error);
                }
            }, 2);
        } else {
            long j2 = -j;
            TLRPC$ChatFull chatFull = MessagesController.getInstance(i).getChatFull(j2);
            String string = editText.getText().toString();
            if (chatFull != null) {
                String str2 = chatFull.about;
                if ((str2 != null ? str2 : "").equals(string)) {
                    AndroidUtilities.hideKeyboard(editText);
                    dialogInterface.dismiss();
                    return;
                } else {
                    chatFull.about = string;
                    NotificationCenter notificationCenter = NotificationCenter.getInstance(i);
                    int i3 = NotificationCenter.chatInfoDidLoad;
                    Boolean bool = Boolean.FALSE;
                    notificationCenter.postNotificationName(i3, chatFull, 0, bool, bool);
                }
            }
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 2, Long.valueOf(j));
            MessagesController.getInstance(i).updateChatAbout(j2, string, chatFull);
        }
        dialogInterface.dismiss();
    }

    static /* synthetic */ boolean lambda$createChangeBioAlert$24(long j, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, TextView textView, int i, KeyEvent keyEvent) {
        if ((i != 6 && (j <= 0 || keyEvent.getKeyCode() != 66)) || !alertDialog.isShowing()) {
            return false;
        }
        onClickListener.onClick(alertDialog, 0);
        return true;
    }

    public static void createChangeNameAlert(final long peerId, Context context, final int currentAccount) {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        String str4;
        final EditText editText;
        if (DialogObject.isUserDialog(peerId)) {
            TLRPC$User user = MessagesController.getInstance(currentAccount).getUser(Long.valueOf(peerId));
            str = user.first_name;
            str2 = user.last_name;
        } else {
            str = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(-peerId)).title;
            str2 = null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (peerId > 0) {
            i = R.string.VoipEditName;
            str3 = "VoipEditName";
        } else {
            i = R.string.VoipEditTitle;
            str3 = "VoipEditTitle";
        }
        builder.setTitle(LocaleController.getString(str3, i));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final EditText editText2 = new EditText(context);
        editText2.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
        editText2.setTextSize(1, 16.0f);
        editText2.setTypeface(AndroidUtilities.getFontFamily(false));
        editText2.setMaxLines(1);
        editText2.setLines(1);
        editText2.setSingleLine(true);
        editText2.setGravity(LocaleController.isRTL ? 5 : 3);
        editText2.setInputType(49152);
        editText2.setImeOptions(peerId > 0 ? 5 : 6);
        if (peerId > 0) {
            i2 = R.string.FirstName;
            str4 = "FirstName";
        } else {
            i2 = R.string.VoipEditTitleHint;
            str4 = "VoipEditTitleHint";
        }
        editText2.setHint(LocaleController.getString(str4, i2));
        editText2.setBackground(Theme.createEditTextDrawable(context, true));
        editText2.setPadding(0, AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f));
        editText2.requestFocus();
        if (peerId > 0) {
            editText = new EditText(context);
            editText.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            editText.setTextSize(1, 16.0f);
            editText.setTypeface(AndroidUtilities.getFontFamily(false));
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
        final EditText editText3 = editText;
        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$aIBGkn037SCkH0wYk0TXwgneMmY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AlertsCreator.lambda$createChangeNameAlert$26(editText2, peerId, currentAccount, editText3, dialogInterface, i3);
            }
        };
        builder.setPositiveButton(LocaleController.getString("Save", R.string.Save), onClickListener);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setOnPreDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$fOSej6NDFH5zl2SC8yqKAand754
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createChangeNameAlert$27(editText2, editText, dialogInterface);
            }
        });
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
        alertDialogCreate.show();
        alertDialogCreate.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$bOw1agVPVNx5qYTLbfUwv6FhvAs
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createChangeNameAlert$28(alertDialogCreate, onClickListener, textView, i3, keyEvent);
            }
        };
        if (editText != null) {
            editText.setOnEditorActionListener(onEditorActionListener);
        } else {
            editText2.setOnEditorActionListener(onEditorActionListener);
        }
    }

    static /* synthetic */ void lambda$createChangeNameAlert$26(EditText editText, long j, int i, EditText editText2, DialogInterface dialogInterface, int i2) {
        if (editText.getText() == null) {
            return;
        }
        if (j > 0) {
            TLRPC$User user = MessagesController.getInstance(i).getUser(Long.valueOf(j));
            String string = editText.getText().toString();
            String string2 = editText2.getText().toString();
            String str = user.first_name;
            String str2 = user.last_name;
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
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
            TLRPC$User user2 = MessagesController.getInstance(i).getUser(Long.valueOf(UserConfig.getInstance(i).getClientUserId()));
            if (user2 != null) {
                user2.first_name = tLRPC$TL_account_updateProfile.first_name;
                user2.last_name = tLRPC$TL_account_updateProfile.last_name;
            }
            UserConfig.getInstance(i).saveConfig(true);
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_NAME));
            ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_account_updateProfile, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$WEvOj-ScRihGD-gawavJ5o77VSo
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AlertsCreator.lambda$createChangeNameAlert$25(tLObject, tLRPC$TL_error);
                }
            });
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 3, Long.valueOf(j));
        } else {
            long j2 = -j;
            TLRPC$Chat chat = MessagesController.getInstance(i).getChat(Long.valueOf(j2));
            String string3 = editText.getText().toString();
            String str3 = chat.title;
            if (str3 != null && str3.equals(string3)) {
                dialogInterface.dismiss();
                return;
            }
            chat.title = string3;
            NotificationCenter.getInstance(i).postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_CHAT_NAME));
            MessagesController.getInstance(i).changeChatTitle(j2, string3);
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.showBulletin, 3, Long.valueOf(j));
        }
        dialogInterface.dismiss();
    }

    static /* synthetic */ void lambda$createChangeNameAlert$27(EditText editText, EditText editText2, DialogInterface dialogInterface) {
        AndroidUtilities.hideKeyboard(editText);
        AndroidUtilities.hideKeyboard(editText2);
    }

    static /* synthetic */ boolean lambda$createChangeNameAlert$28(AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener, TextView textView, int i, KeyEvent keyEvent) {
        if ((i != 6 && keyEvent.getKeyCode() != 66) || !alertDialog.isShowing()) {
            return false;
        }
        onClickListener.onClick(alertDialog, 0);
        return true;
    }

    public static void createBlockDialogAlert(BaseFragment fragment, int count, boolean reportSpam, TLRPC$User user, final BlockDialogCallback onProcessRunnable) {
        String string;
        int i;
        String str;
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        if (count == 1 && user == null) {
            return;
        }
        Activity parentActivity = fragment.getParentActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        CheckBoxCell[] checkBoxCellArr = new CheckBoxCell[2];
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        if (count == 1) {
            String name = ContactsController.formatName(user.first_name, user.last_name);
            builder.setTitle(LocaleController.formatString("BlockUserTitle", R.string.BlockUserTitle, name));
            string = LocaleController.getString("BlockUser", R.string.BlockUser);
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUserMessage", R.string.BlockUserMessage, name)));
        } else {
            builder.setTitle(LocaleController.formatString("BlockUserTitle", R.string.BlockUserTitle, LocaleController.formatPluralString("UsersCountTitle", count)));
            string = LocaleController.getString("BlockUsers", R.string.BlockUsers);
            builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("BlockUsersMessage", R.string.BlockUsersMessage, LocaleController.formatPluralString("UsersCount", count))));
        }
        final boolean[] zArr = {true, true};
        final int i2 = 0;
        for (int i3 = 2; i2 < i3; i3 = 2) {
            if (i2 != 0 || reportSpam) {
                checkBoxCellArr[i2] = new CheckBoxCell(parentActivity, 1);
                checkBoxCellArr[i2].setBackgroundDrawable(Theme.getSelectorDrawable(false));
                if (i2 == 0) {
                    checkBoxCellArr[i2].setText(LocaleController.getString("ReportSpamTitle", R.string.ReportSpamTitle), "", true, false);
                } else {
                    CheckBoxCell checkBoxCell = checkBoxCellArr[i2];
                    if (count == 1) {
                        i = R.string.DeleteThisChatBothSides;
                        str = "DeleteThisChatBothSides";
                    } else {
                        i = R.string.DeleteTheseChatsBothSides;
                        str = "DeleteTheseChatsBothSides";
                    }
                    checkBoxCell.setText(LocaleController.getString(str, i), "", true, false);
                }
                checkBoxCellArr[i2].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                linearLayout.addView(checkBoxCellArr[i2], LayoutHelper.createLinear(-1, 48));
                checkBoxCellArr[i2].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$jzE4QAVni2fb8FOpKwqz1YaL8GE
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AlertsCreator.lambda$createBlockDialogAlert$29(zArr, i2, view);
                    }
                });
            }
            i2++;
        }
        builder.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$KcT_CHL7Uy0qxK2g2x0jQ8Ojjdc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AlertsCreator.BlockDialogCallback blockDialogCallback = onProcessRunnable;
                boolean[] zArr2 = zArr;
                blockDialogCallback.run(zArr2[0], zArr2[1]);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        fragment.showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    static /* synthetic */ void lambda$createBlockDialogAlert$29(boolean[] zArr, int i, View view) {
        zArr[i] = !zArr[i];
        ((CheckBoxCell) view).setChecked(zArr[i], true);
    }

    public static AlertDialog.Builder createDatePickerDialog(Context context, int minYear, int maxYear, int currentYearDiff, int selectedDay, int selectedMonth, int selectedYear, String title, final boolean checkMinDate, final DatePickerDelegate datePickerDelegate) {
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
        numberPicker2.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$dQV_JHa0AWRA4HR2uHTzEz6sUcY
            @Override // ir.eitaa.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i) {
                AlertsCreator.lambda$createDatePickerDialog$31(checkMinDate, numberPicker2, numberPicker, numberPicker3, numberPicker4, i);
            }
        });
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(11);
        linearLayout.addView(numberPicker, LayoutHelper.createLinear(0, -2, 0.3f));
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$V9J6qEVXZiZh7jzYSTwFi0PK1Rg
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i) {
                return AlertsCreator.lambda$createDatePickerDialog$32(i);
            }
        });
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$DFQiMWP0a8tIymlLMwfL06HoK4E
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i, int i2) {
                AlertsCreator.updateDayPicker(numberPicker2, numberPicker, numberPicker3);
            }
        });
        numberPicker.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$pqb9BKfZ1EMFH_T1Zqu093xuPmE
            @Override // ir.eitaa.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i) {
                AlertsCreator.lambda$createDatePickerDialog$34(checkMinDate, numberPicker2, numberPicker, numberPicker3, numberPicker4, i);
            }
        });
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        numberPicker3.setMinValue(i + minYear);
        numberPicker3.setMaxValue(i + maxYear);
        numberPicker3.setValue(i + currentYearDiff);
        linearLayout.addView(numberPicker3, LayoutHelper.createLinear(0, -2, 0.4f));
        numberPicker3.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$TyGHY8t8pauGxWQNWiBgyaj7tz0
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i2, int i3) {
                AlertsCreator.updateDayPicker(numberPicker2, numberPicker, numberPicker3);
            }
        });
        numberPicker3.setOnScrollListener(new NumberPicker.OnScrollListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$IFDE7uMkTWbfC5JzpUhf5TJhgdQ
            @Override // ir.eitaa.ui.Components.NumberPicker.OnScrollListener
            public final void onScrollStateChange(NumberPicker numberPicker4, int i2) {
                AlertsCreator.lambda$createDatePickerDialog$36(checkMinDate, numberPicker2, numberPicker, numberPicker3, numberPicker4, i2);
            }
        });
        updateDayPicker(numberPicker2, numberPicker, numberPicker3);
        if (checkMinDate) {
            checkPickerDate(numberPicker2, numberPicker, numberPicker3);
        }
        if (selectedDay != -1) {
            numberPicker2.setValue(selectedDay);
            numberPicker.setValue(selectedMonth);
            numberPicker3.setValue(selectedYear);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Set", R.string.Set), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$J0Ahc0KyyPxckZSoctrVP17QtoA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$createDatePickerDialog$37(checkMinDate, numberPicker2, numberPicker, numberPicker3, datePickerDelegate, dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder;
    }

    static /* synthetic */ void lambda$createDatePickerDialog$31(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    static /* synthetic */ String lambda$createDatePickerDialog$32(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(2, i);
        return calendar.getDisplayName(2, 1, Locale.getDefault());
    }

    static /* synthetic */ void lambda$createDatePickerDialog$34(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    static /* synthetic */ void lambda$createDatePickerDialog$36(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i) {
        if (z && i == 0) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
    }

    static /* synthetic */ void lambda$createDatePickerDialog$37(boolean z, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, DatePickerDelegate datePickerDelegate, DialogInterface dialogInterface, int i) {
        if (z) {
            checkPickerDate(numberPicker, numberPicker2, numberPicker3);
        }
        datePickerDelegate.didSelectDate(numberPicker3.getValue(), numberPicker2.getValue(), numberPicker.getValue());
    }

    public static boolean checkScheduleDate(TextView button, TextView infoText, int type, NumberPicker dayPicker, NumberPicker hourPicker, NumberPicker minutePicker) {
        return checkScheduleDate(button, infoText, 0L, type, dayPicker, hourPicker, minutePicker);
    }

    public static boolean checkScheduleDate(TextView button, TextView infoText, long maxDate, int type, NumberPicker dayPicker, NumberPicker hourPicker, NumberPicker minutePicker) {
        int i;
        long timeInMillis;
        int i2;
        int i3;
        String pluralString;
        int i4;
        int i5;
        int i6;
        int value = dayPicker.getValue();
        int value2 = hourPicker.getValue();
        int value3 = minutePicker.getValue();
        Calendar calendar = Calendar.getInstance();
        long jCurrentTimeMillis = System.currentTimeMillis();
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int i7 = calendar.get(1);
        int i8 = calendar.get(6);
        if (maxDate > 0) {
            i = i7;
            calendar.setTimeInMillis(jCurrentTimeMillis + (maxDate * 1000));
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            timeInMillis = calendar.getTimeInMillis();
        } else {
            i = i7;
            timeInMillis = maxDate;
        }
        calendar.setTimeInMillis(System.currentTimeMillis() + (value * 24 * 3600 * 1000));
        calendar.set(11, value2);
        calendar.set(12, value3);
        long timeInMillis2 = calendar.getTimeInMillis();
        long j = jCurrentTimeMillis + 60000;
        if (timeInMillis2 <= j) {
            calendar.setTimeInMillis(j);
            if (i8 != calendar.get(6)) {
                dayPicker.setValue(1);
                i6 = 11;
                i2 = 1;
            } else {
                i2 = value;
                i6 = 11;
            }
            i3 = calendar.get(i6);
            hourPicker.setValue(i3);
            value3 = calendar.get(12);
            minutePicker.setValue(value3);
        } else if (timeInMillis <= 0 || timeInMillis2 <= timeInMillis) {
            i2 = value;
            i3 = value2;
        } else {
            calendar.setTimeInMillis(timeInMillis);
            i2 = 7;
            dayPicker.setValue(7);
            i3 = calendar.get(11);
            hourPicker.setValue(i3);
            value3 = calendar.get(12);
            minutePicker.setValue(value3);
        }
        int i9 = calendar.get(1);
        calendar.setTimeInMillis(System.currentTimeMillis() + (i2 * 24 * 3600 * 1000));
        calendar.set(11, i3);
        calendar.set(12, value3);
        long timeInMillis3 = calendar.getTimeInMillis();
        if (button != null) {
            if (i2 == 0) {
                i4 = 1;
                i5 = 0;
            } else if (i == i9) {
                i4 = 1;
                i5 = 1;
            } else {
                i4 = 1;
                i5 = 2;
            }
            if (type == i4) {
                i5 += 3;
            } else if (type == 2) {
                i5 += 6;
            } else if (type == 3) {
                i5 += 9;
            }
            button.setText(LocaleController.getInstance().formatterScheduleSend[i5].format(timeInMillis3));
        }
        if (infoText != null) {
            int i10 = (int) ((timeInMillis3 - jCurrentTimeMillis) / 1000);
            if (i10 > 86400) {
                pluralString = LocaleController.formatPluralString("DaysSchedule", Math.round(i10 / 86400.0f));
            } else if (i10 >= 3600) {
                pluralString = LocaleController.formatPluralString("HoursSchedule", Math.round(i10 / 3600.0f));
            } else if (i10 >= 60) {
                pluralString = LocaleController.formatPluralString("MinutesSchedule", Math.round(i10 / 60.0f));
            } else {
                pluralString = LocaleController.formatPluralString("SecondsSchedule", i10);
            }
            if (infoText.getTag() != null) {
                infoText.setText(LocaleController.formatString("VoipChannelScheduleInfo", R.string.VoipChannelScheduleInfo, pluralString));
            } else {
                infoText.setText(LocaleController.formatString("VoipGroupScheduleInfo", R.string.VoipGroupScheduleInfo, pluralString));
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
            this((Theme.ResourcesProvider) null);
        }

        private ScheduleDatePickerColors(Theme.ResourcesProvider rp) {
            this(rp != null ? rp.getColorOrDefault("dialogTextBlack") : Theme.getColor("dialogTextBlack"), rp != null ? rp.getColorOrDefault("dialogBackground") : Theme.getColor("dialogBackground"), rp != null ? rp.getColorOrDefault("key_sheet_other") : Theme.getColor("key_sheet_other"), rp != null ? rp.getColorOrDefault("player_actionBarSelector") : Theme.getColor("player_actionBarSelector"), rp != null ? rp.getColorOrDefault("actionBarDefaultSubmenuItem") : Theme.getColor("actionBarDefaultSubmenuItem"), rp != null ? rp.getColorOrDefault("actionBarDefaultSubmenuBackground") : Theme.getColor("actionBarDefaultSubmenuBackground"), rp != null ? rp.getColorOrDefault("listSelectorSDK21") : Theme.getColor("listSelectorSDK21"), rp != null ? rp.getColorOrDefault("featuredStickers_buttonText") : Theme.getColor("featuredStickers_buttonText"), rp != null ? rp.getColorOrDefault("featuredStickers_addButton") : Theme.getColor("featuredStickers_addButton"), rp != null ? rp.getColorOrDefault("featuredStickers_addButtonPressed") : Theme.getColor("featuredStickers_addButtonPressed"));
        }

        public ScheduleDatePickerColors(int textColor, int backgroundColor, int iconColor, int iconSelectorColor, int subMenuTextColor, int subMenuBackgroundColor, int subMenuSelectorColor) {
            this(textColor, backgroundColor, iconColor, iconSelectorColor, subMenuTextColor, subMenuBackgroundColor, subMenuSelectorColor, Theme.getColor("featuredStickers_buttonText"), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed"));
        }

        public ScheduleDatePickerColors(int textColor, int backgroundColor, int iconColor, int iconSelectorColor, int subMenuTextColor, int subMenuBackgroundColor, int subMenuSelectorColor, int buttonTextColor, int buttonBackgroundColor, int buttonBackgroundPressedColor) {
            this.textColor = textColor;
            this.backgroundColor = backgroundColor;
            this.iconColor = iconColor;
            this.iconSelectorColor = iconSelectorColor;
            this.subMenuTextColor = subMenuTextColor;
            this.subMenuBackgroundColor = subMenuBackgroundColor;
            this.subMenuSelectorColor = subMenuSelectorColor;
            this.buttonTextColor = buttonTextColor;
            this.buttonBackgroundColor = buttonBackgroundColor;
            this.buttonBackgroundPressedColor = buttonBackgroundPressedColor;
        }
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, final ScheduleDatePickerDelegate datePickerDelegate) {
        return createScheduleDatePickerDialog(context, dialogId, -1L, datePickerDelegate, (Runnable) null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, final ScheduleDatePickerDelegate datePickerDelegate, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, dialogId, -1L, datePickerDelegate, null, resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, final ScheduleDatePickerDelegate datePickerDelegate, final ScheduleDatePickerColors datePickerColors) {
        return createScheduleDatePickerDialog(context, dialogId, -1L, datePickerDelegate, null, datePickerColors, null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, final ScheduleDatePickerDelegate datePickerDelegate, final Runnable cancelRunnable, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, dialogId, -1L, datePickerDelegate, cancelRunnable, resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, long currentDate, final ScheduleDatePickerDelegate datePickerDelegate, final Runnable cancelRunnable) {
        return createScheduleDatePickerDialog(context, dialogId, currentDate, datePickerDelegate, cancelRunnable, new ScheduleDatePickerColors(), null);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, long dialogId, long currentDate, final ScheduleDatePickerDelegate datePickerDelegate, final Runnable cancelRunnable, Theme.ResourcesProvider resourcesProvider) {
        return createScheduleDatePickerDialog(context, dialogId, currentDate, datePickerDelegate, cancelRunnable, new ScheduleDatePickerColors(resourcesProvider), resourcesProvider);
    }

    public static BottomSheet.Builder createScheduleDatePickerDialog(Context context, final long dialogId, long currentDate, final ScheduleDatePickerDelegate datePickerDelegate, final Runnable cancelRunnable, final ScheduleDatePickerColors datePickerColors, Theme.ResourcesProvider resourcesProvider) {
        LinearLayout linearLayout;
        int i;
        final Calendar calendar;
        TLRPC$User user;
        TLRPC$UserStatus tLRPC$UserStatus;
        if (context == null) {
            return null;
        }
        final long clientUserId = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false, resourcesProvider);
        builder.setApplyBottomPadding(false);
        final NumberPicker numberPicker = new NumberPicker(context, resourcesProvider);
        numberPicker.setTextColor(datePickerColors.textColor);
        numberPicker.setTextOffset(AndroidUtilities.dp(10.0f));
        numberPicker.setItemCount(5);
        final NumberPicker numberPicker2 = new NumberPicker(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.AlertsCreator.6
            @Override // ir.eitaa.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int value) {
                return LocaleController.formatPluralString("Hours", value);
            }
        };
        numberPicker2.setItemCount(5);
        numberPicker2.setTextColor(datePickerColors.textColor);
        numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker3 = new NumberPicker(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.AlertsCreator.7
            @Override // ir.eitaa.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int value) {
                return LocaleController.formatPluralString("Minutes", value);
            }
        };
        numberPicker3.setItemCount(5);
        numberPicker3.setTextColor(datePickerColors.textColor);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(34.0f));
        LinearLayout linearLayout2 = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.8
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i2 = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i2);
                numberPicker2.setItemCount(i2);
                numberPicker3.setItemCount(i2);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i2;
                numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i2;
                numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i2;
                this.ignoreLayout = false;
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        if (dialogId == clientUserId) {
            textView.setText(LocaleController.getString("SetReminder", R.string.SetReminder));
        } else {
            textView.setText(LocaleController.getString("ScheduleMessage", R.string.ScheduleMessage));
        }
        textView.setTextColor(datePickerColors.textColor);
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$Ibo79E6pBWOkDSJ0H6Rfo3a6TRg
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$38(view, motionEvent);
            }
        });
        if (!DialogObject.isUserDialog(dialogId) || dialogId == clientUserId || (user = MessagesController.getInstance(UserConfig.selectedAccount).getUser(Long.valueOf(dialogId))) == null || user.bot || (tLRPC$UserStatus = user.status) == null || tLRPC$UserStatus.expires <= 0) {
            linearLayout = linearLayout2;
            i = 1;
        } else {
            String firstName = UserObject.getFirstName(user);
            if (firstName.length() > 10) {
                firstName = firstName.substring(0, 10) + "…";
            }
            linearLayout = linearLayout2;
            final ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, datePickerColors.iconColor, false, resourcesProvider);
            actionBarMenuItem.setLongClickEnabled(false);
            actionBarMenuItem.setSubMenuOpenSide(2);
            actionBarMenuItem.setIcon(R.drawable.ic_ab_other);
            i = 1;
            actionBarMenuItem.setBackgroundDrawable(Theme.createSelectorDrawable(datePickerColors.iconSelectorColor, 1));
            frameLayout.addView(actionBarMenuItem, LayoutHelper.createFrame(40, 40.0f, 53, 0.0f, 8.0f, 5.0f, 0.0f));
            actionBarMenuItem.addSubItem(1, LocaleController.formatString("ScheduleWhenOnline", R.string.ScheduleWhenOnline, firstName));
            actionBarMenuItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$OQHYba7OmWaMamhgMOYTvsYGfBI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createScheduleDatePickerDialog$39(actionBarMenuItem, datePickerColors, view);
                }
            });
            actionBarMenuItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$OvZN5cAEBAfuQSCoRWtun7ga2is
                @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
                public final void onItemClick(int i2) {
                    AlertsCreator.lambda$createScheduleDatePickerDialog$40(datePickerDelegate, builder, i2);
                }
            });
            actionBarMenuItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        }
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setWeightSum(1.0f);
        final LinearLayout linearLayout4 = linearLayout;
        linearLayout4.addView(linearLayout3, LayoutHelper.createLinear(-1, -2));
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(jCurrentTimeMillis);
        final int i2 = calendar2.get(i);
        final TextView textView2 = new TextView(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.9
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout3.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.5f));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(365);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$ER1UYQumZ3TAUwU1BhEKjDQJX9A
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return AlertsCreator.lambda$createScheduleDatePickerDialog$41(jCurrentTimeMillis, calendar2, i2, i3);
            }
        });
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$DbyuFPvffyQCMZNKzFgmIyqq3Lk
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i3, int i4) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$42(linearLayout4, textView2, clientUserId, dialogId, numberPicker, numberPicker2, numberPicker3, numberPicker4, i3, i4);
            }
        };
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(23);
        linearLayout3.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.2f));
        numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$H5hjcELjsxk_2siVbttkRSaQfgI
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return String.format("%02d", Integer.valueOf(i3));
            }
        });
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(59);
        numberPicker3.setValue(0);
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$znGtex7HYNT8i6lChUs_8HrpEZU
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return String.format("%02d", Integer.valueOf(i3));
            }
        });
        linearLayout3.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.3f));
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        if (currentDate <= 0 || currentDate == 2147483646) {
            calendar = calendar2;
        } else {
            long j = 1000 * currentDate;
            calendar = calendar2;
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.set(11, 0);
            int timeInMillis = (int) ((j - calendar.getTimeInMillis()) / 86400000);
            calendar.setTimeInMillis(j);
            if (timeInMillis >= 0) {
                numberPicker3.setValue(calendar.get(12));
                numberPicker2.setValue(calendar.get(11));
                numberPicker.setValue(timeInMillis);
            }
        }
        final boolean[] zArr = {true};
        checkScheduleDate(textView2, null, clientUserId == dialogId ? 1 : 0, numberPicker, numberPicker2, numberPicker3);
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(datePickerColors.buttonTextColor);
        textView2.setTextSize(1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), datePickerColors.buttonBackgroundColor, datePickerColors.buttonBackgroundPressedColor));
        linearLayout4.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$ge2FE-RkNsvMBnmTsDQibpIIEd0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$45(zArr, clientUserId, dialogId, numberPicker, numberPicker2, numberPicker3, calendar, datePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout4);
        BottomSheet bottomSheetShow = builder.show();
        bottomSheetShow.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$zb8Ja7-wJWUhlRPUM3bWwuq55XM
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                AlertsCreator.lambda$createScheduleDatePickerDialog$46(cancelRunnable, zArr, dialogInterface);
            }
        });
        bottomSheetShow.setBackgroundColor(datePickerColors.backgroundColor);
        return builder;
    }

    static /* synthetic */ void lambda$createScheduleDatePickerDialog$39(ActionBarMenuItem actionBarMenuItem, ScheduleDatePickerColors scheduleDatePickerColors, View view) {
        actionBarMenuItem.toggleSubMenu();
        actionBarMenuItem.setPopupItemsColor(scheduleDatePickerColors.subMenuTextColor, false);
        actionBarMenuItem.setupPopupRadialSelectors(scheduleDatePickerColors.subMenuSelectorColor);
        actionBarMenuItem.redrawPopup(scheduleDatePickerColors.subMenuBackgroundColor);
    }

    static /* synthetic */ void lambda$createScheduleDatePickerDialog$40(ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, int i) {
        if (i == 1) {
            scheduleDatePickerDelegate.didSelectDate(true, 2147483646);
            builder.getDismissRunnable().run();
        }
    }

    static /* synthetic */ String lambda$createScheduleDatePickerDialog$41(long j, Calendar calendar, int i, int i2) {
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

    static /* synthetic */ void lambda$createScheduleDatePickerDialog$42(LinearLayout linearLayout, TextView textView, long j, long j2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkScheduleDate(textView, null, j == j2 ? 1 : 0, numberPicker, numberPicker2, numberPicker3);
    }

    static /* synthetic */ void lambda$createScheduleDatePickerDialog$45(boolean[] zArr, long j, long j2, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Calendar calendar, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
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

    static /* synthetic */ void lambda$createScheduleDatePickerDialog$46(Runnable runnable, boolean[] zArr, DialogInterface dialogInterface) {
        if (runnable == null || !zArr[0]) {
            return;
        }
        runnable.run();
    }

    public static BottomSheet.Builder createDatePickerDialog(Context context, long currentDate, final ScheduleDatePickerDelegate datePickerDelegate) {
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
        final NumberPicker numberPicker2 = new NumberPicker(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.10
            @Override // ir.eitaa.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int value) {
                return LocaleController.formatPluralString("Hours", value);
            }
        };
        numberPicker2.setItemCount(5);
        numberPicker2.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker3 = new NumberPicker(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.11
            @Override // ir.eitaa.ui.Components.NumberPicker
            protected CharSequence getContentDescription(int value) {
                return LocaleController.formatPluralString("Minutes", value);
            }
        };
        numberPicker3.setItemCount(5);
        numberPicker3.setTextColor(scheduleDatePickerColors.textColor);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(34.0f));
        final LinearLayout linearLayout2 = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.12
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                this.ignoreLayout = true;
                android.graphics.Point point = AndroidUtilities.displaySize;
                int i = point.x > point.y ? 3 : 5;
                numberPicker.setItemCount(i);
                numberPicker2.setItemCount(i);
                numberPicker3.setItemCount(i);
                numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i;
                numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i;
                numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * i;
                this.ignoreLayout = false;
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$-noVxV9Wi63UMVQWk-l8QAuHMfA
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
        TextView textView2 = new TextView(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.13
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout3.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.5f));
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(365);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$cE4gdlWzcq1xPZMWh1ELWdJdbx4
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createDatePickerDialog$48(jCurrentTimeMillis, calendar, i, i2);
            }
        });
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$2tIaJw1UGFbHG0Sxz66_E7jzlSs
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i2, int i3) {
                AlertsCreator.lambda$createDatePickerDialog$49(linearLayout2, numberPicker, numberPicker2, numberPicker3, numberPicker4, i2, i3);
            }
        };
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(23);
        linearLayout3.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.2f));
        numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$VQYg9fImt729Dqv8BdjCdY7VJlA
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return String.format("%02d", Integer.valueOf(i2));
            }
        });
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(59);
        numberPicker3.setValue(0);
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$TMyB2ZCWxxgjxar3Du8FKSHBMZ8
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return String.format("%02d", Integer.valueOf(i2));
            }
        });
        linearLayout3.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.3f));
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        if (currentDate <= 0 || currentDate == 2147483646) {
            linearLayout = linearLayout2;
        } else {
            long j = 1000 * currentDate;
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.set(11, 0);
            linearLayout = linearLayout2;
            int timeInMillis = (int) ((j - calendar.getTimeInMillis()) / 86400000);
            calendar.setTimeInMillis(j);
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
        textView2.setTypeface(AndroidUtilities.getFontFamily(true));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), scheduleDatePickerColors.buttonBackgroundColor, scheduleDatePickerColors.buttonBackgroundPressedColor));
        textView2.setText(LocaleController.getString("SetTimeLimit", R.string.SetTimeLimit));
        LinearLayout linearLayout4 = linearLayout;
        linearLayout4.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$eECta-9ByTXISFaRX7Vn4JwzzSw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createDatePickerDialog$52(numberPicker, numberPicker2, numberPicker3, calendar, datePickerDelegate, builder, view);
            }
        });
        builder.setCustomView(linearLayout4);
        builder.show().setBackgroundColor(scheduleDatePickerColors.backgroundColor);
        return builder;
    }

    static /* synthetic */ String lambda$createDatePickerDialog$48(long j, Calendar calendar, int i, int i2) {
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

    static /* synthetic */ void lambda$createDatePickerDialog$49(LinearLayout linearLayout, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkScheduleDate(null, null, 0, numberPicker, numberPicker2, numberPicker3);
    }

    static /* synthetic */ void lambda$createDatePickerDialog$52(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, Calendar calendar, ScheduleDatePickerDelegate scheduleDatePickerDelegate, BottomSheet.Builder builder, View view) {
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[PHI: r1
      0x0088: PHI (r1v2 int) = (r1v1 int), (r1v4 int), (r1v4 int) binds: [B:16:0x0078, B:19:0x0080, B:20:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void checkCalendarDate(long r11, ir.eitaa.ui.Components.NumberPicker r13, ir.eitaa.ui.Components.NumberPicker r14, ir.eitaa.ui.Components.NumberPicker r15) {
        /*
            int r0 = r13.getValue()
            int r1 = r14.getValue()
            int r2 = r15.getValue()
            java.util.Calendar r3 = java.util.Calendar.getInstance()
            ir.eitaa.messenger.LocaleController r4 = ir.eitaa.messenger.LocaleController.getInstance()
            boolean r4 = r4.isFarsi()
            r5 = 5
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L3a
            ir.eitaa.messenger.time.JalaliCalendar r4 = new ir.eitaa.messenger.time.JalaliCalendar
            r4.<init>(r11)
            int r11 = r4.year
            int r12 = r4.month
            int r12 = r12 - r7
            int r4 = r4.day
            ir.eitaa.messenger.time.JalaliCalendar r8 = new ir.eitaa.messenger.time.JalaliCalendar
            long r9 = java.lang.System.currentTimeMillis()
            r8.<init>(r9)
            int r9 = r8.year
            int r10 = r8.month
            int r10 = r10 - r7
            int r8 = r8.day
            goto L5c
        L3a:
            r3.setTimeInMillis(r11)
            int r11 = r3.get(r7)
            int r12 = r3.get(r6)
            int r4 = r3.get(r5)
            long r8 = java.lang.System.currentTimeMillis()
            r3.setTimeInMillis(r8)
            int r9 = r3.get(r7)
            int r10 = r3.get(r6)
            int r8 = r3.get(r5)
        L5c:
            if (r2 <= r9) goto L62
            r15.setValue(r9)
            r2 = r9
        L62:
            if (r2 != r9) goto L72
            if (r1 <= r10) goto L6a
            r14.setValue(r10)
            r1 = r10
        L6a:
            if (r1 != r10) goto L72
            if (r0 <= r8) goto L72
            r13.setValue(r8)
            r0 = r8
        L72:
            if (r2 >= r11) goto L78
            r15.setValue(r11)
            r2 = r11
        L78:
            if (r2 != r11) goto L88
            if (r1 >= r12) goto L80
            r14.setValue(r12)
            r1 = r12
        L80:
            if (r1 != r12) goto L88
            if (r0 >= r4) goto L88
            r13.setValue(r4)
            goto L89
        L88:
            r4 = r0
        L89:
            r3.set(r7, r2)
            r3.set(r6, r1)
            int r11 = r3.getActualMaximum(r5)
            r13.setMaxValue(r11)
            if (r4 <= r11) goto L9b
            r13.setValue(r11)
        L9b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.AlertsCreator.checkCalendarDate(long, ir.eitaa.ui.Components.NumberPicker, ir.eitaa.ui.Components.NumberPicker, ir.eitaa.ui.Components.NumberPicker):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    public static BottomSheet.Builder createCalendarPickerDialog(Context context, final long minDate, final MessagesStorage.IntCallback callback, Theme.ResourcesProvider resourcesProvider) {
        LinearLayout linearLayout;
        ?? r1;
        int i;
        int i2;
        if (context == null) {
            return null;
        }
        final BottomSheet.Builder builder = new BottomSheet.Builder(context, false, resourcesProvider);
        builder.setApplyBottomPadding(false);
        final NumberPicker numberPicker = new NumberPicker(context, resourcesProvider);
        numberPicker.setTextOffset(AndroidUtilities.dp(10.0f));
        numberPicker.setItemCount(5);
        final NumberPicker numberPicker2 = new NumberPicker(context, resourcesProvider);
        numberPicker2.setItemCount(5);
        numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
        final NumberPicker numberPicker3 = new NumberPicker(context, resourcesProvider);
        numberPicker3.setItemCount(5);
        numberPicker3.setTextOffset(-AndroidUtilities.dp(24.0f));
        final LinearLayout linearLayout2 = new LinearLayout(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.14
            boolean ignoreLayout = false;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
        textView.setText(LocaleController.getString("ChooseDate", R.string.ChooseDate));
        textView.setTextColor(Theme.getColor("dialogTextBlack", resourcesProvider));
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 12.0f, 0.0f, 0.0f));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$gfCIcWvOqgeIEaVTqhMV49u13UI
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return AlertsCreator.lambda$createCalendarPickerDialog$53(view, motionEvent);
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setWeightSum(1.0f);
        linearLayout2.addView(linearLayout3, LayoutHelper.createLinear(-1, -2));
        System.currentTimeMillis();
        TextView textView2 = new TextView(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.15
            @Override // android.widget.TextView, android.view.View
            public CharSequence getAccessibilityClassName() {
                return Button.class.getName();
            }
        };
        linearLayout3.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.25f));
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(31);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$ERFdR8IBZXD1gBAvN8tdU9ZMjwA
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i3) {
                return String.format("%02d", Integer.valueOf(i3));
            }
        });
        NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$sXMwmp0R6pCPb0kFuB_-hT0ptyI
            @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
            public final void onValueChange(NumberPicker numberPicker4, int i3, int i4) {
                AlertsCreator.lambda$createCalendarPickerDialog$55(linearLayout2, minDate, numberPicker, numberPicker2, numberPicker3, numberPicker4, i3, i4);
            }
        };
        numberPicker.setOnValueChangedListener(onValueChangeListener);
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(11);
        numberPicker2.setWrapSelectorWheel(false);
        linearLayout3.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.5f));
        if (LocaleController.getInstance().isFarsi()) {
            numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$5u1RtRfDrDkWzWqfS22RTFhWlWY
                @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
                public final String format(int i3) {
                    return AlertsCreator.lambda$createCalendarPickerDialog$56(i3);
                }
            });
        } else {
            numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$sWd6z7h5wuAE5deOAR9q5W9ODdA
                @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
                public final String format(int i3) {
                    return AlertsCreator.lambda$createCalendarPickerDialog$57(i3);
                }
            });
        }
        numberPicker2.setOnValueChangedListener(onValueChangeListener);
        final Calendar calendar = Calendar.getInstance();
        if (LocaleController.getInstance().isFarsi()) {
            int i3 = new JalaliCalendar(minDate).year;
            linearLayout = linearLayout3;
            i2 = new JalaliCalendar(System.currentTimeMillis()).year;
            i = i3;
            r1 = 1;
        } else {
            linearLayout = linearLayout3;
            calendar.setTimeInMillis(minDate);
            r1 = 1;
            i = calendar.get(1);
            calendar.setTimeInMillis(System.currentTimeMillis());
            i2 = calendar.get(1);
        }
        numberPicker3.setMinValue(i);
        numberPicker3.setMaxValue(i2);
        numberPicker3.setWrapSelectorWheel(false);
        numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$wVnLwlxCSMFc4T90hR-4-QL24D4
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i4) {
                return String.format("%02d", Integer.valueOf(i4));
            }
        });
        linearLayout.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.25f));
        numberPicker3.setOnValueChangedListener(onValueChangeListener);
        numberPicker.setValue(31);
        numberPicker2.setValue(12);
        numberPicker3.setValue(i2);
        checkCalendarDate(minDate, numberPicker, numberPicker2, numberPicker3);
        textView2.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        textView2.setGravity(17);
        textView2.setTextColor(Theme.getColor("featuredStickers_buttonText", resourcesProvider));
        textView2.setTextSize(r1, 14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(r1));
        textView2.setText(LocaleController.getString("JumpToDate", R.string.JumpToDate));
        textView2.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton", resourcesProvider), Theme.getColor("featuredStickers_addButtonPressed", resourcesProvider)));
        linearLayout2.addView(textView2, LayoutHelper.createLinear(-1, 48, 83, 16, 15, 16, 16));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$2Qwl-hBmKNDIVr-mugCRMxABMEo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertsCreator.lambda$createCalendarPickerDialog$59(numberPicker3, numberPicker2, numberPicker, minDate, calendar, callback, builder, view);
            }
        });
        builder.setCustomView(linearLayout2);
        return builder;
    }

    static /* synthetic */ void lambda$createCalendarPickerDialog$55(LinearLayout linearLayout, long j, NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            linearLayout.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        checkCalendarDate(j, numberPicker, numberPicker2, numberPicker3);
    }

    static /* synthetic */ String lambda$createCalendarPickerDialog$56(int i) {
        switch (i) {
            case 0:
                return LocaleController.getString("Farvardin", R.string.Farvardin);
            case 1:
                return LocaleController.getString("Ordibehesht", R.string.Ordibehesht);
            case 2:
                return LocaleController.getString("Khordad", R.string.Khordad);
            case 3:
                return LocaleController.getString("Tir", R.string.Tir);
            case 4:
                return LocaleController.getString("Mordad", R.string.Mordad);
            case 5:
                return LocaleController.getString("Shahrivar", R.string.Shahrivar);
            case 6:
                return LocaleController.getString("Mehr", R.string.Mehr);
            case 7:
                return LocaleController.getString("Aban", R.string.Aban);
            case 8:
                return LocaleController.getString("Azar", R.string.Azar);
            case 9:
                return LocaleController.getString("Dey", R.string.Dey);
            case 10:
                return LocaleController.getString("Bahman", R.string.Bahman);
            default:
                return LocaleController.getString("Esfand", R.string.Esfand);
        }
    }

    static /* synthetic */ String lambda$createCalendarPickerDialog$57(int i) {
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

    static /* synthetic */ void lambda$createCalendarPickerDialog$59(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, long j, Calendar calendar, MessagesStorage.IntCallback intCallback, BottomSheet.Builder builder, View view) {
        int value;
        int value2;
        int i;
        if (LocaleController.getInstance().isFarsi()) {
            int[] iArrJalali_to_gregorian = DateConverter.jalali_to_gregorian(numberPicker.getValue(), numberPicker2.getValue() + 1, numberPicker3.getValue());
            value2 = iArrJalali_to_gregorian[0];
            i = iArrJalali_to_gregorian[1];
            value = iArrJalali_to_gregorian[2];
        } else {
            value = 0;
            value2 = 0;
            i = 0;
        }
        checkCalendarDate(j, numberPicker3, numberPicker2, numberPicker);
        if (!LocaleController.getInstance().isFarsi()) {
            value2 = numberPicker.getValue();
        }
        calendar.set(1, value2);
        calendar.set(2, LocaleController.getInstance().isFarsi() ? i - 1 : numberPicker2.getValue());
        if (!LocaleController.getInstance().isFarsi()) {
            value = numberPicker3.getValue();
        }
        calendar.set(5, value);
        calendar.set(12, 0);
        calendar.set(11, 0);
        calendar.set(13, 0);
        intCallback.run((int) (calendar.getTimeInMillis() / 1000));
        builder.getDismissRunnable().run();
    }

    public static BottomSheet createMuteAlert(final BaseFragment fragment, final long dialog_id, final Theme.ResourcesProvider resourcesProvider) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return null;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(fragment.getParentActivity(), false, resourcesProvider);
        builder.setTitle(LocaleController.getString("Notifications", R.string.Notifications), true);
        builder.setItems(new CharSequence[]{LocaleController.formatString("MuteFor", R.string.MuteFor, LocaleController.formatPluralString("Hours", 1)), LocaleController.formatString("MuteFor", R.string.MuteFor, LocaleController.formatPluralString("Hours", 8)), LocaleController.formatString("MuteFor", R.string.MuteFor, LocaleController.formatPluralString("Days", 2)), LocaleController.getString("MuteDisable", R.string.MuteDisable)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$8OZ1fVfFVPjoLhxWa-66Qy3DlwE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createMuteAlert$60(dialog_id, fragment, resourcesProvider, dialogInterface, i);
            }
        });
        return builder.create();
    }

    static /* synthetic */ void lambda$createMuteAlert$60(long j, BaseFragment baseFragment, Theme.ResourcesProvider resourcesProvider, DialogInterface dialogInterface, int i) {
        int i2 = 2;
        if (i == 0) {
            i2 = 0;
        } else if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 3;
        }
        NotificationsController.getInstance(UserConfig.selectedAccount).setDialogNotificationsSettings(j, i2);
        if (BulletinFactory.canShowBulletin(baseFragment)) {
            BulletinFactory.createMuteBulletin(baseFragment, i2, resourcesProvider).show();
        }
    }

    public static void sendEitaaReport(TLRPC$InputPeer peer, int type, String message, ArrayList<Integer> messages) {
        TLRPC$TL_messages_report tLRPC$TL_messages_report = new TLRPC$TL_messages_report();
        tLRPC$TL_messages_report.peer = peer;
        tLRPC$TL_messages_report.id.addAll(messages);
        tLRPC$TL_messages_report.message = message;
        TLRPC$ReportReason tLRPC$ReportReason = new TLRPC$ReportReason() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputUniversalReportReason
            public static int constructor = -631585315;

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
                stream.writeInt32(this.flags);
                stream.writeInt32(this.id);
                if ((this.flags & 1) != 0) {
                    stream.writeString(this.text);
                }
            }
        };
        tLRPC$TL_messages_report.reason = tLRPC$ReportReason;
        tLRPC$ReportReason.id = type;
        tLRPC$ReportReason.text = message;
        if (message != null && !message.isEmpty()) {
            tLRPC$TL_messages_report.reason.flags |= 1;
        }
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_messages_report, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$B3xT1TjsBAP-bJ7caUjrYO-vlKQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AlertsCreator.lambda$sendEitaaReport$61(tLObject, tLRPC$TL_error);
            }
        });
    }

    public static void createEitaaReportAlert(final Context context, final long dialog_id, final int messageId, final BaseFragment parentFragment) {
        createEitaaReportAlert(context, dialog_id, messageId, parentFragment, null);
    }

    public static void createEitaaReportAlert(final Context context, final long dialog_id, final int messageId, final BaseFragment parentFragment, final Theme.ResourcesProvider resourcesProvider) {
        if (context == null || parentFragment == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(context, true, resourcesProvider);
        if (messageId == 0) {
            builder.setTitle(LocaleController.getString("ReportSheetTitle", R.string.ReportSheetTitle));
            builder.setItems(new CharSequence[]{LocaleController.getString("ReportSheetQuestion1", R.string.ReportSheetAnswer1), LocaleController.getString("ReportSheetQuestion2", R.string.ReportSheetAnswer2)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$QY8m3K35RLGlLWdodgN4oPxwUEc
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlertsCreator.showEitaaReportListAlert(context, dialog_id, messageId, 0, parentFragment, resourcesProvider, i == 0);
                }
            });
            parentFragment.showDialog(builder.create());
            return;
        }
        showEitaaReportListAlert(context, dialog_id, messageId, 0, parentFragment, resourcesProvider, false);
    }

    public static void showEitaaReportListAlert(final Context context, final long dialog_id, final int messageId, final int subjectId, final BaseFragment parentFragment, final Theme.ResourcesProvider resourcesProvider, final boolean selectMessage) {
        if (context == null || parentFragment == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Iterator it = new ArrayList(MessagesController.getInstance(UserConfig.selectedAccount).reportReasons).iterator();
        while (it.hasNext()) {
            TLRPC$TL_report_reason tLRPC$TL_report_reason = (TLRPC$TL_report_reason) it.next();
            if (tLRPC$TL_report_reason.id == subjectId && tLRPC$TL_report_reason.hasComment) {
                if (messageId == 0 && selectMessage && (parentFragment instanceof ChatActivity)) {
                    ((ChatActivity) parentFragment).openReportChat(subjectId);
                    return;
                }
                if (parentFragment instanceof ChatActivity) {
                    AndroidUtilities.requestAdjustNothing(parentFragment.getParentActivity(), parentFragment.getClassGuid());
                }
                parentFragment.showDialog(new ReportAlert(context, subjectId) { // from class: ir.eitaa.ui.Components.AlertsCreator.16
                    @Override // ir.eitaa.ui.ActionBar.BottomSheet
                    public void dismissInternal() {
                        super.dismissInternal();
                        BaseFragment baseFragment = parentFragment;
                        if (baseFragment instanceof ChatActivity) {
                            ((ChatActivity) baseFragment).checkAdjustResize();
                        }
                    }

                    @Override // ir.eitaa.ui.Components.ReportAlert
                    protected void onSend(int type, String message) {
                        ArrayList arrayList3 = new ArrayList();
                        int i = messageId;
                        if (i != 0) {
                            arrayList3.add(Integer.valueOf(i));
                        }
                        AlertsCreator.sendEitaaReport(MessagesController.getInstance(UserConfig.selectedAccount).getInputPeer(dialog_id), type, message, arrayList3);
                        BaseFragment baseFragment = parentFragment;
                        if (baseFragment instanceof ChatActivity) {
                            ((ChatActivity) baseFragment).getUndoView().showWithAction(0L, 74, (Runnable) null);
                        }
                    }
                });
                return;
            }
            if (tLRPC$TL_report_reason.subjectId == subjectId) {
                arrayList.add(tLRPC$TL_report_reason.title);
                arrayList2.add(Integer.valueOf(tLRPC$TL_report_reason.id));
            }
        }
        if (arrayList.isEmpty()) {
            if (messageId == 0 && selectMessage && (parentFragment instanceof ChatActivity)) {
                ((ChatActivity) parentFragment).openReportChat(subjectId);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            if (messageId == 0) {
                builder.setMessage(LocaleController.getString("ReportSheetAreYouSure1", R.string.ReportSheetAreYouSure1));
            } else {
                builder.setMessage(LocaleController.getString("ReportSheetAreYouSure2", R.string.ReportSheetAreYouSure2));
            }
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$c-GeAT7Fi0gI26q5rOUvGsA6d8o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AlertsCreator.lambda$showEitaaReportListAlert$63(dialog_id, messageId, subjectId, parentFragment, resourcesProvider, dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            parentFragment.showDialog(builder.create());
            return;
        }
        BottomSheet.Builder builder2 = new BottomSheet.Builder(context, true, resourcesProvider);
        if (messageId == 0) {
            builder2.setTitle(LocaleController.getString("ReportSheetQuestion3", R.string.ReportSheetQuestion1));
        } else {
            builder2.setTitle(LocaleController.getString("ReportSheetQuestion4", R.string.ReportSheetQuestion2));
        }
        builder2.setItems((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$-dkrVTTKC6n1basoAB7YjoTHrVA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$showEitaaReportListAlert$64(arrayList2, context, dialog_id, messageId, parentFragment, resourcesProvider, selectMessage, dialogInterface, i);
            }
        });
        parentFragment.showDialog(builder2.create());
    }

    static /* synthetic */ void lambda$showEitaaReportListAlert$63(long j, int i, int i2, BaseFragment baseFragment, Theme.ResourcesProvider resourcesProvider, DialogInterface dialogInterface, int i3) {
        TLRPC$InputPeer inputPeer = MessagesController.getInstance(UserConfig.selectedAccount).getInputPeer((int) j);
        ArrayList arrayList = new ArrayList();
        if (i != 0) {
            arrayList.add(Integer.valueOf(i));
        }
        sendEitaaReport(inputPeer, i2, null, arrayList);
        if (baseFragment instanceof ChatActivity) {
            ((ChatActivity) baseFragment).getUndoView().showWithAction(0L, 74, (Runnable) null);
        } else {
            BulletinFactory.of(baseFragment).createReportSent(resourcesProvider).show();
        }
    }

    static /* synthetic */ void lambda$showEitaaReportListAlert$64(ArrayList arrayList, Context context, long j, int i, BaseFragment baseFragment, Theme.ResourcesProvider resourcesProvider, boolean z, DialogInterface dialogInterface, int i2) {
        if (i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        showEitaaReportListAlert(context, j, i, ((Integer) arrayList.get(i2)).intValue(), baseFragment, resourcesProvider, z);
    }

    private static String getFloodWaitString(String error) {
        String pluralString;
        int iIntValue = Utilities.parseInt(error).intValue();
        if (iIntValue < 60) {
            pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
        } else {
            pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
        }
        return LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString);
    }

    public static void showFloodWaitAlert(String error, final BaseFragment fragment) {
        String pluralString;
        if (error == null || !error.startsWith("FLOOD_WAIT") || fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        int iIntValue = Utilities.parseInt(error).intValue();
        if (iIntValue < 60) {
            pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
        } else {
            pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        fragment.showDialog(builder.create(), true, null);
    }

    public static void showSendMediaAlert(int result, final BaseFragment fragment, Theme.ResourcesProvider resourcesProvider) {
        if (result == 0) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity(), resourcesProvider);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (result == 1) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedStickers", R.string.ErrorSendRestrictedStickers));
        } else if (result == 2) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedMedia", R.string.ErrorSendRestrictedMedia));
        } else if (result == 3) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedPolls", R.string.ErrorSendRestrictedPolls));
        } else if (result == 4) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedStickersAll", R.string.ErrorSendRestrictedStickersAll));
        } else if (result == 5) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedMediaAll", R.string.ErrorSendRestrictedMediaAll));
        } else if (result == 6) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedPollsAll", R.string.ErrorSendRestrictedPollsAll));
        } else if (result == 7) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedForwardsAll", R.string.ErrorSendRestrictedForwardsAll));
        } else if (result == 8) {
            builder.setMessage(LocaleController.getString("ErrorSendRestrictedForwards", R.string.ErrorSendRestrictedForwards));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        fragment.showDialog(builder.create(), true, null);
    }

    public static void showAddUserAlert(String error, final BaseFragment fragment, boolean isChannel, TLObject request) {
        AlertDialog.Builder builder;
        if (error == null || fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        builder = new AlertDialog.Builder(fragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        switch (error) {
            case "CHANNELS_ADMIN_LOCATED_TOO_MUCH":
                builder.setMessage(LocaleController.getString("LocatedChannelsTooMuch", R.string.LocatedChannelsTooMuch));
                break;
            case "CHANNELS_ADMIN_PUBLIC_TOO_MUCH":
                builder.setMessage(LocaleController.getString("PublicChannelsTooMuch", R.string.PublicChannelsTooMuch));
                break;
            case "USERS_TOO_FEW":
                builder.setMessage(LocaleController.getString("CreateGroupError", R.string.CreateGroupError));
                break;
            case "FLOOD_WAIT":
                builder.setMessage(LocaleController.getString("FloodWait", R.string.FloodWait));
                break;
            case "USER_BLOCKED":
            case "USER_BOT":
            case "USER_ID_INVALID":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("ChannelUserCantAdd", R.string.ChannelUserCantAdd));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("GroupUserCantAdd", R.string.GroupUserCantAdd));
                    break;
                }
            case "USER_RESTRICTED":
                builder.setMessage(LocaleController.getString("UserRestricted", R.string.UserRestricted));
                break;
            case "PEER_FLOOD":
                builder.setMessage(LocaleController.getString("NobodyLikesSpam2", R.string.NobodyLikesSpam2));
                builder.setNegativeButton(LocaleController.getString("MoreInfo", R.string.MoreInfo), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$YMErj9lJDL5o5XT25JFjbRs0KOw
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        BaseFragment baseFragment = fragment;
                        MessagesController.getInstance(baseFragment.getCurrentAccount()).openByUserName("spambot", baseFragment, 1);
                    }
                });
                break;
            case "BOTS_TOO_MUCH":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("ChannelUserCantBot", R.string.ChannelUserCantBot));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("GroupUserCantBot", R.string.GroupUserCantBot));
                    break;
                }
            case "USER_KICKED":
            case "CHAT_ADMIN_BAN_REQUIRED":
                if (request instanceof TLRPC$TL_channels_inviteToChannel) {
                    builder.setMessage(LocaleController.getString("AddUserErrorBlacklisted", R.string.AddUserErrorBlacklisted));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("AddAdminErrorBlacklisted", R.string.AddAdminErrorBlacklisted));
                    break;
                }
            case "YOU_BLOCKED_USER":
                builder.setMessage(LocaleController.getString("YouBlockedUser", R.string.YouBlockedUser));
                break;
            case "USER_ADMIN_INVALID":
                builder.setMessage(LocaleController.getString("AddBannedErrorAdmin", R.string.AddBannedErrorAdmin));
                break;
            case "USERS_TOO_MUCH":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("ChannelUserAddLimit", R.string.ChannelUserAddLimit));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("GroupUserAddLimit", R.string.GroupUserAddLimit));
                    break;
                }
            case "ADMINS_TOO_MUCH":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("ChannelUserCantAdmin", R.string.ChannelUserCantAdmin));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("GroupUserCantAdmin", R.string.GroupUserCantAdmin));
                    break;
                }
            case "CHANNELS_TOO_MUCH":
                builder.setTitle(LocaleController.getString("ChannelTooMuchTitle", R.string.ChannelTooMuchTitle));
                if (request instanceof TLRPC$TL_channels_createChannel) {
                    builder.setMessage(LocaleController.getString("ChannelTooMuch", R.string.ChannelTooMuch));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("ChannelTooMuchJoin", R.string.ChannelTooMuchJoin));
                    break;
                }
            case "USER_CHANNELS_TOO_MUCH":
                builder.setTitle(LocaleController.getString("ChannelTooMuchTitle", R.string.ChannelTooMuchTitle));
                builder.setMessage(LocaleController.getString("UserChannelTooMuchJoin", R.string.UserChannelTooMuchJoin));
                break;
            case "USER_NOT_MUTUAL_CONTACT":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("ChannelUserLeftError", R.string.ChannelUserLeftError));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("GroupUserLeftError", R.string.GroupUserLeftError));
                    break;
                }
            case "CHAT_ADMIN_INVITE_REQUIRED":
                builder.setMessage(LocaleController.getString("AddAdminErrorNotAMember", R.string.AddAdminErrorNotAMember));
                break;
            case "USER_PRIVACY_RESTRICTED":
                if (isChannel) {
                    builder.setMessage(LocaleController.getString("InviteToChannelError", R.string.InviteToChannelError));
                    break;
                } else {
                    builder.setMessage(LocaleController.getString("InviteToGroupError", R.string.InviteToGroupError));
                    break;
                }
            case "USER_ALREADY_PARTICIPANT":
                builder.setTitle(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat));
                builder.setMessage(LocaleController.getString("VoipGroupInviteAlreadyParticipant", R.string.VoipGroupInviteAlreadyParticipant));
                break;
            default:
                builder.setMessage(LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + error);
                break;
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        fragment.showDialog(builder.create(), true, null);
    }

    public static Dialog createColorSelectDialog(Activity parentActivity, final long dialog_id, final int globalType, final Runnable onSelect) {
        int i;
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        if (dialog_id != 0) {
            if (notificationsSettings.contains("color_" + dialog_id)) {
                i = notificationsSettings.getInt("color_" + dialog_id, -16776961);
            } else if (DialogObject.isChatDialog(dialog_id)) {
                i = notificationsSettings.getInt("GroupLed", -16776961);
            } else {
                i = notificationsSettings.getInt("MessagesLed", -16776961);
            }
        } else if (globalType == 1) {
            i = notificationsSettings.getInt("MessagesLed", -16776961);
        } else if (globalType == 0) {
            i = notificationsSettings.getInt("GroupLed", -16776961);
        } else {
            i = notificationsSettings.getInt("ChannelLed", -16776961);
        }
        final LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        String[] strArr = {LocaleController.getString("ColorRed", R.string.ColorRed), LocaleController.getString("ColorOrange", R.string.ColorOrange), LocaleController.getString("ColorYellow", R.string.ColorYellow), LocaleController.getString("ColorGreen", R.string.ColorGreen), LocaleController.getString("ColorCyan", R.string.ColorCyan), LocaleController.getString("ColorBlue", R.string.ColorBlue), LocaleController.getString("ColorViolet", R.string.ColorViolet), LocaleController.getString("ColorPink", R.string.ColorPink), LocaleController.getString("ColorWhite", R.string.ColorWhite)};
        final int[] iArr = {i};
        int i2 = 0;
        for (int i3 = 9; i2 < i3; i3 = 9) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i2));
            int[] iArr2 = TextColorCell.colors;
            radioColorCell.setCheckColor(iArr2[i2], iArr2[i2]);
            radioColorCell.setTextAndValue(strArr[i2], i == TextColorCell.colorsToSave[i2]);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$2cgu7spwFoOo625gF0JR9kFaKzY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createColorSelectDialog$66(linearLayout, iArr, view);
                }
            });
            i2++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("LedColor", R.string.LedColor));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Set", R.string.Set), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$hDmE2P3G1UgYtMJAo0d-bQoW_eU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AlertsCreator.lambda$createColorSelectDialog$67(dialog_id, iArr, globalType, onSelect, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(LocaleController.getString("LedDisabled", R.string.LedDisabled), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$Nv4WFgJhOVeX9w2JnCIYNoslVQU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AlertsCreator.lambda$createColorSelectDialog$68(dialog_id, globalType, onSelect, dialogInterface, i4);
            }
        });
        if (dialog_id != 0) {
            builder.setNegativeButton(LocaleController.getString("Default", R.string.Default), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$J0CXqp7W_g5JhboqMI0p_xyWuz8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    AlertsCreator.lambda$createColorSelectDialog$69(dialog_id, onSelect, dialogInterface, i4);
                }
            });
        }
        return builder.create();
    }

    static /* synthetic */ void lambda$createColorSelectDialog$66(LinearLayout linearLayout, int[] iArr, View view) {
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RadioColorCell radioColorCell = (RadioColorCell) linearLayout.getChildAt(i);
            radioColorCell.setChecked(radioColorCell == view, true);
        }
        iArr[0] = TextColorCell.colorsToSave[((Integer) view.getTag()).intValue()];
    }

    static /* synthetic */ void lambda$createColorSelectDialog$67(long j, int[] iArr, int i, Runnable runnable, DialogInterface dialogInterface, int i2) {
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
        editorEdit.commit();
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$createColorSelectDialog$68(long j, int i, Runnable runnable, DialogInterface dialogInterface, int i2) {
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
        editorEdit.commit();
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$createColorSelectDialog$69(long j, Runnable runnable, DialogInterface dialogInterface, int i) {
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        editorEdit.remove("color_" + j);
        editorEdit.commit();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createVibrationSelectDialog(Activity parentActivity, final long dialogId, final boolean globalGroup, final boolean globalAll, final Runnable onSelect) {
        String str;
        if (dialogId != 0) {
            str = "vibrate_" + dialogId;
        } else {
            str = globalGroup ? "vibrate_group" : "vibrate_messages";
        }
        return createVibrationSelectDialog(parentActivity, dialogId, str, onSelect);
    }

    public static Dialog createVibrationSelectDialog(Activity parentActivity, final long dialogId, final String prefKeyPrefix, final Runnable onSelect) {
        String[] strArr;
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        int i = 0;
        if (dialogId != 0) {
            iArr[0] = notificationsSettings.getInt(prefKeyPrefix, 0);
            if (iArr[0] == 3) {
                iArr[0] = 2;
            } else if (iArr[0] == 2) {
                iArr[0] = 3;
            }
            strArr = new String[]{LocaleController.getString("VibrationDefault", R.string.VibrationDefault), LocaleController.getString("Short", R.string.Short), LocaleController.getString("Long", R.string.Long), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled)};
        } else {
            iArr[0] = notificationsSettings.getInt(prefKeyPrefix, 0);
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
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        int i2 = 0;
        while (i2 < strArr2.length) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), i, AndroidUtilities.dp(4.0f), i);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue(strArr2[i2], iArr[i] == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$NYQVDfDNyUDVKIuCfJMlQ6JYXOw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createVibrationSelectDialog$70(iArr, dialogId, prefKeyPrefix, builder, onSelect, view);
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

    static /* synthetic */ void lambda$createVibrationSelectDialog$70(int[] iArr, long j, String str, AlertDialog.Builder builder, Runnable runnable, View view) {
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
        editorEdit.commit();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static AlertDialog.Builder createGigagroupConvertAlert(Activity activity, DialogInterface.OnClickListener onProcess, DialogInterface.OnClickListener onCancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String res = RLottieDrawable.readRes(null, R.raw.gigagroup);
        FrameLayout frameLayout = new FrameLayout(activity);
        if (Build.VERSION.SDK_INT >= 21) {
            frameLayout.setClipToOutline(true);
            frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.AlertsCreator.18
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
        builder.setPositiveButton(LocaleController.getString("GigagroupAlertLearnMore", R.string.GigagroupAlertLearnMore), onProcess);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), onCancel);
        return builder;
    }

    public static AlertDialog.Builder createDrawOverlayPermissionDialog(final Activity activity, DialogInterface.OnClickListener onCancel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        String res = RLottieDrawable.readRes(null, R.raw.pip_video_request);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-14535089, -14527894}));
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.AlertsCreator.19
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
        builder.setPositiveButton(LocaleController.getString("Enable", R.string.Enable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$nL6QxJM5Ob-yZFMwz1RYVd6hCo4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createDrawOverlayPermissionDialog$75(activity, dialogInterface, i);
            }
        });
        builder.notDrawBackgroundOnTopView(true);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), onCancel);
        builder.setTopViewAspectRatio(0.50427353f);
        return builder;
    }

    static /* synthetic */ void lambda$createDrawOverlayPermissionDialog$75(Activity activity, DialogInterface dialogInterface, int i) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            activity.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static AlertDialog.Builder createDrawOverlayGroupCallPermissionDialog(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String res = RLottieDrawable.readRes(null, R.raw.pip_voice_request);
        final GroupCallPipButton groupCallPipButton = new GroupCallPipButton(context, 0, true);
        groupCallPipButton.setImportantForAccessibility(2);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.AlertsCreator.20
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                groupCallPipButton.setTranslationY((getMeasuredHeight() * 0.28f) - (groupCallPipButton.getMeasuredWidth() / 2.0f));
                groupCallPipButton.setTranslationX((getMeasuredWidth() * 0.82f) - (groupCallPipButton.getMeasuredWidth() / 2.0f));
            }
        };
        frameLayout.setBackground(new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[]{-15128003, -15118002}));
        frameLayout.setClipToOutline(true);
        frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.AlertsCreator.21
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() + AndroidUtilities.dp(6.0f), AndroidUtilities.dpf2(6.0f));
            }
        });
        View view = new View(context);
        view.setBackground(new BitmapDrawable(SvgHelper.getBitmap(res, AndroidUtilities.dp(320.0f), AndroidUtilities.dp(184.61539f), false)));
        frameLayout.addView(view, LayoutHelper.createFrame(-1, -1.0f, 0, -1.0f, -1.0f, -1.0f, -1.0f));
        frameLayout.addView(groupCallPipButton, LayoutHelper.createFrame(R.styleable.AppCompatTheme_windowFixedWidthMinor, 117.0f));
        builder.setTopView(frameLayout);
        builder.setTitle(LocaleController.getString("PermissionDrawAboveOtherAppsGroupCallTitle", R.string.PermissionDrawAboveOtherAppsGroupCallTitle));
        builder.setMessage(LocaleController.getString("PermissionDrawAboveOtherAppsGroupCall", R.string.PermissionDrawAboveOtherAppsGroupCall));
        builder.setPositiveButton(LocaleController.getString("Enable", R.string.Enable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$iSbS16A5UF-uvcSO8Q7rUiZxtHk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createDrawOverlayGroupCallPermissionDialog$76(context, dialogInterface, i);
            }
        });
        builder.notDrawBackgroundOnTopView(true);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTopViewAspectRatio(0.5769231f);
        return builder;
    }

    static /* synthetic */ void lambda$createDrawOverlayGroupCallPermissionDialog$76(Context context, DialogInterface dialogInterface, int i) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getPackageName()));
                    Activity activityFindActivity = AndroidUtilities.findActivity(context);
                    if (activityFindActivity instanceof LaunchActivity) {
                        activityFindActivity.startActivityForResult(intent, R.styleable.AppCompatTheme_textColorSearchUrl);
                    } else {
                        context.startActivity(intent);
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public static AlertDialog.Builder createContactsPermissionDialog(Activity parentActivity, final MessagesStorage.IntCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTopImage(R.drawable.permissions_contacts, Theme.getColor("chats_actionBackground"));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.getString("ContactsPermissionAlert", R.string.ContactsPermissionAlert)));
        builder.setPositiveButton(LocaleController.getString("ContactsPermissionAlertContinue", R.string.ContactsPermissionAlertContinue), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$OqYJV_vc-sPUuktlzX6jP-5A98k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                callback.run(1);
            }
        });
        builder.setNegativeButton(LocaleController.getString("ContactsPermissionAlertNotNow", R.string.ContactsPermissionAlertNotNow), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$8rgrnfPZoQ0ELKsIbzXTkf99QVU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                callback.run(0);
            }
        });
        return builder;
    }

    public static Dialog createVideoPlayerOptionDialog(Activity parentActivity, final BaseFragment parentFragment, final Runnable onSelect) {
        final SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("VideoPlayerConfig", 0);
        int i = sharedPreferences.getInt("playerResumeOption", 0);
        String[] strArr = {LocaleController.getString("AlwaysAsk", R.string.AlwaysAsk), LocaleController.getString("AlwaysResume", R.string.AlwaysResume), LocaleController.getString("AlwaysStartOver", R.string.AlwaysStartOver)};
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        int i2 = 0;
        while (i2 < 3) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setCheckColor(-5000269, -13129232);
            radioColorCell.setTextAndValue(strArr[i2], i == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.AlertsCreator.22
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int iIntValue = ((Integer) v.getTag()).intValue();
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putInt("playerResumeOption", iIntValue);
                    editorEdit.commit();
                    BaseFragment baseFragment = parentFragment;
                    if (baseFragment != null) {
                        baseFragment.dismissCurrentDialog();
                    }
                    Runnable runnable = onSelect;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
            i2++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("VideoPlayerResumeOption", R.string.VideoPlayerResumeOption));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    public static Dialog createAudioPlayerOptionDialog(Activity parentActivity, final BaseFragment parentFragment, final Runnable onSelect) {
        final SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
        int i = sharedPreferences.getInt("playerResumeOption", 0);
        String[] strArr = {LocaleController.getString("AlwaysAsk", R.string.AlwaysAsk), LocaleController.getString("AlwaysResume", R.string.AlwaysResume), LocaleController.getString("AlwaysStartOver", R.string.AlwaysStartOver)};
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        int i2 = 0;
        while (i2 < 3) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setCheckColor(-5000269, -13129232);
            radioColorCell.setTextAndValue(strArr[i2], i == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.AlertsCreator.23
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int iIntValue = ((Integer) v.getTag()).intValue();
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putInt("playerResumeOption", iIntValue);
                    editorEdit.commit();
                    BaseFragment baseFragment = parentFragment;
                    if (baseFragment != null) {
                        baseFragment.dismissCurrentDialog();
                    }
                    Runnable runnable = onSelect;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
            i2++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("AudioPlayerResumeOption", R.string.AudioPlayerResumeOption));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    public static Dialog createFreeSpaceDialog(final LaunchActivity parentActivity) {
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
        final LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(parentActivity);
        textView.setText(LocaleController.getString("LowDiskSpaceTitle2", R.string.LowDiskSpaceTitle2));
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 24, 0, 24, 8));
        int i2 = 0;
        while (i2 < 4) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i2));
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue(strArr[i2], iArr[0] == i2);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$Bw9mDxCLHA_FfcpyKstbg1FY57g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createFreeSpaceDialog$79(iArr, linearLayout, view);
                }
            });
            i2++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("LowDiskSpaceTitle", R.string.LowDiskSpaceTitle));
        builder.setMessage(LocaleController.getString("LowDiskSpaceMessage", R.string.LowDiskSpaceMessage));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$3hXHz2gGJ1g_X2lbvd_5OB_GAJo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SharedConfig.setKeepMedia(iArr[0]);
            }
        });
        builder.setNeutralButton(LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$b2kRcDhVYcZlNBtMze9mUy2Zk3g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                parentActivity.lambda$runLinkRequest$39(new CacheControlActivity());
            }
        });
        return builder.create();
    }

    static /* synthetic */ void lambda$createFreeSpaceDialog$79(int[] iArr, LinearLayout linearLayout, View view) {
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

    public static Dialog createPrioritySelectDialog(Activity parentActivity, final long dialog_id, final int globalType, final Runnable onSelect) {
        char c;
        String[] strArr;
        int i;
        Activity activity = parentActivity;
        final SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        int i2 = 0;
        if (dialog_id != 0) {
            iArr[0] = notificationsSettings.getInt("priority_" + dialog_id, 3);
            if (iArr[0] == 3) {
                iArr[0] = 0;
            } else if (iArr[0] == 4) {
                iArr[0] = 1;
            } else {
                i = 5;
                if (iArr[0] == 5) {
                    iArr[0] = 2;
                } else if (iArr[0] == 0) {
                    iArr[0] = 3;
                } else {
                    iArr[0] = 4;
                }
                String[] strArr2 = new String[i];
                strArr2[0] = LocaleController.getString("NotificationsPrioritySettings", R.string.NotificationsPrioritySettings);
                strArr2[1] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
                strArr2[2] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
                strArr2[3] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
                strArr2[4] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
                strArr = strArr2;
            }
            i = 5;
            String[] strArr22 = new String[i];
            strArr22[0] = LocaleController.getString("NotificationsPrioritySettings", R.string.NotificationsPrioritySettings);
            strArr22[1] = LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow);
            strArr22[2] = LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium);
            strArr22[3] = LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh);
            strArr22[4] = LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent);
            strArr = strArr22;
        } else {
            if (globalType == 1) {
                iArr[0] = notificationsSettings.getInt("priority_messages", 1);
            } else if (globalType == 0) {
                iArr[0] = notificationsSettings.getInt("priority_group", 1);
            } else if (globalType == 2) {
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
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        int i3 = 0;
        while (i3 < strArr.length) {
            RadioColorCell radioColorCell = new RadioColorCell(activity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), i2, AndroidUtilities.dp(4.0f), i2);
            radioColorCell.setTag(Integer.valueOf(i3));
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue(strArr[i3], iArr[i2] == i3);
            linearLayout.addView(radioColorCell);
            final AlertDialog.Builder builder2 = builder;
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$69-oTSjPfZaPPy5WC52BNpQpoUE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createPrioritySelectDialog$82(iArr, dialog_id, globalType, notificationsSettings, builder2, onSelect, view);
                }
            });
            i3++;
            activity = parentActivity;
            linearLayout = linearLayout;
            builder = builder2;
            i2 = 0;
        }
        AlertDialog.Builder builder3 = builder;
        builder3.setTitle(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance));
        builder3.setView(linearLayout);
        builder3.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder3.create();
    }

    static /* synthetic */ void lambda$createPrioritySelectDialog$82(int[] iArr, long j, int i, SharedPreferences sharedPreferences, AlertDialog.Builder builder, Runnable runnable, View view) {
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
        editorEdit.commit();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createPopupSelectDialog(Activity parentActivity, final int globalType, final Runnable onSelect) {
        SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(UserConfig.selectedAccount);
        final int[] iArr = new int[1];
        if (globalType == 1) {
            iArr[0] = notificationsSettings.getInt("popupAll", 0);
        } else if (globalType == 0) {
            iArr[0] = notificationsSettings.getInt("popupGroup", 0);
        } else {
            iArr[0] = notificationsSettings.getInt("popupChannel", 0);
        }
        String[] strArr = {LocaleController.getString("NoPopup", R.string.NoPopup), LocaleController.getString("OnlyWhenScreenOn", R.string.OnlyWhenScreenOn), LocaleController.getString("OnlyWhenScreenOff", R.string.OnlyWhenScreenOff), LocaleController.getString("AlwaysShowPopup", R.string.AlwaysShowPopup)};
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        int i = 0;
        while (i < 4) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setTag(Integer.valueOf(i));
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue(strArr[i], iArr[0] == i);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$hLn0vZeXCmI_TI2aiUAjeYg4RQ8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createPopupSelectDialog$83(iArr, globalType, builder, onSelect, view);
                }
            });
            i++;
        }
        builder.setTitle(LocaleController.getString("PopupNotification", R.string.PopupNotification));
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    static /* synthetic */ void lambda$createPopupSelectDialog$83(int[] iArr, int i, AlertDialog.Builder builder, Runnable runnable, View view) {
        iArr[0] = ((Integer) view.getTag()).intValue();
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).edit();
        if (i == 1) {
            editorEdit.putInt("popupAll", iArr[0]);
        } else if (i == 0) {
            editorEdit.putInt("popupGroup", iArr[0]);
        } else {
            editorEdit.putInt("popupChannel", iArr[0]);
        }
        editorEdit.commit();
        builder.getDismissRunnable().run();
        if (runnable != null) {
            runnable.run();
        }
    }

    public static Dialog createSingleChoiceDialog(Activity parentActivity, final String[] options, final String title, final int selected, final DialogInterface.OnClickListener listener) {
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        final AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        int i = 0;
        while (i < options.length) {
            RadioColorCell radioColorCell = new RadioColorCell(parentActivity);
            radioColorCell.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            radioColorCell.setTag(Integer.valueOf(i));
            radioColorCell.setCheckColor(Theme.getColor("radioBackground"), Theme.getColor("dialogRadioBackgroundChecked"));
            radioColorCell.setTextAndValue(options[i], selected == i);
            linearLayout.addView(radioColorCell);
            radioColorCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$YsJutpokXO8ftkJDtIHcPCkZr2A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlertsCreator.lambda$createSingleChoiceDialog$84(builder, listener, view);
                }
            });
            i++;
        }
        builder.setTitle(title);
        builder.setView(linearLayout);
        builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        return builder.create();
    }

    static /* synthetic */ void lambda$createSingleChoiceDialog$84(AlertDialog.Builder builder, DialogInterface.OnClickListener onClickListener, View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        builder.getDismissRunnable().run();
        onClickListener.onClick(null, iIntValue);
    }

    public static AlertDialog.Builder createTTLAlert(final Context context, final TLRPC$EncryptedChat encryptedChat, Theme.ResourcesProvider resourcesProvider) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, resourcesProvider);
        builder.setTitle(LocaleController.getString("MessageLifetime", R.string.MessageLifetime));
        final NumberPicker numberPicker = new NumberPicker(context);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(20);
        int i = encryptedChat.ttl;
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
        numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$lL77lc1I-biEftXm5QiojUrhpOI
            @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
            public final String format(int i2) {
                return AlertsCreator.lambda$createTTLAlert$85(i2);
            }
        });
        builder.setView(numberPicker);
        builder.setNegativeButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$I5jaGl_406mxziI7PLzW4u2sFjU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AlertsCreator.lambda$createTTLAlert$86(encryptedChat, numberPicker, dialogInterface, i2);
            }
        });
        return builder;
    }

    static /* synthetic */ String lambda$createTTLAlert$85(int i) {
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
        return i == 20 ? LocaleController.formatTTLString(604800) : "";
    }

    static /* synthetic */ void lambda$createTTLAlert$86(TLRPC$EncryptedChat tLRPC$EncryptedChat, NumberPicker numberPicker, DialogInterface dialogInterface, int i) {
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

    public static AlertDialog createAccountSelectDialog(Activity parentActivity, final AccountSelectDelegate delegate) {
        if (UserConfig.getActivatedAccountsCount() < 2) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        final Runnable dismissRunnable = builder.getDismissRunnable();
        final AlertDialog[] alertDialogArr = new AlertDialog[1];
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        for (int i = 0; i < 3; i++) {
            if (UserConfig.getInstance(i).getCurrentUser() != null) {
                AccountSelectCell accountSelectCell = new AccountSelectCell(parentActivity, false);
                accountSelectCell.setAccount(i, false);
                accountSelectCell.setPadding(AndroidUtilities.dp(14.0f), 0, AndroidUtilities.dp(14.0f), 0);
                accountSelectCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                linearLayout.addView(accountSelectCell, LayoutHelper.createLinear(-1, 50));
                accountSelectCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$10-C47GU2TKb2QieM1gO35Ns6bc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AlertsCreator.lambda$createAccountSelectDialog$87(alertDialogArr, dismissRunnable, delegate, view);
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

    static /* synthetic */ void lambda$createAccountSelectDialog$87(AlertDialog[] alertDialogArr, Runnable runnable, AccountSelectDelegate accountSelectDelegate, View view) {
        if (alertDialogArr[0] != null) {
            alertDialogArr[0].setOnDismissListener(null);
        }
        runnable.run();
        accountSelectDelegate.didSelectAccount(((AccountSelectCell) view).getAccountNumber());
    }

    public static void createDeleteMessagesAlert(final BaseFragment fragment, final TLRPC$User user, final TLRPC$Chat chat, final TLRPC$EncryptedChat encryptedChat, final TLRPC$ChatFull chatInfo, final long mergeDialogId, final MessageObject selectedMessage, final SparseArray<MessageObject>[] selectedMessages, final MessageObject.GroupedMessages selectedGroup, final boolean scheduled, int loadParticipant, final Runnable onDelete, final Theme.ResourcesProvider resourcesProvider) {
        Activity parentActivity;
        int size;
        int i;
        long jMakeEncryptedDialogId;
        boolean z;
        int i2;
        final boolean[] zArr;
        AlertDialog.Builder builder;
        boolean[] zArr2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        final TLRPC$User tLRPC$User;
        MessageObject messageObject;
        AlertDialog.Builder builder2;
        int i6;
        boolean z4;
        boolean[] zArr3;
        TLRPC$MessageAction tLRPC$MessageAction;
        boolean[] zArr4;
        String str;
        AlertDialog.Builder builder3;
        int i7;
        TLRPC$User user2;
        int i8;
        AlertDialog.Builder builder4;
        boolean z5;
        boolean z6;
        TLRPC$MessageAction tLRPC$MessageAction2;
        int i9 = loadParticipant;
        if (fragment != null) {
            if ((user == null && chat == null && encryptedChat == null) || (parentActivity = fragment.getParentActivity()) == null) {
                return;
            }
            final int currentAccount = fragment.getCurrentAccount();
            AlertDialog.Builder builder5 = new AlertDialog.Builder(parentActivity, resourcesProvider);
            if (selectedGroup != null) {
                size = selectedGroup.messages.size();
            } else {
                size = selectedMessage != null ? 1 : selectedMessages[0].size() + selectedMessages[1].size();
            }
            if (encryptedChat != null) {
                i = size;
                jMakeEncryptedDialogId = DialogObject.makeEncryptedDialogId(encryptedChat.id);
            } else {
                i = size;
                if (user != null) {
                    jMakeEncryptedDialogId = user.id;
                } else {
                    jMakeEncryptedDialogId = -chat.id;
                }
            }
            final long j = jMakeEncryptedDialogId;
            int currentTime = ConnectionsManager.getInstance(currentAccount).getCurrentTime();
            if (selectedMessage != null) {
                z = !selectedMessage.isDice() || Math.abs(currentTime - selectedMessage.messageOwner.date) > 86400;
            } else {
                int i10 = 0;
                z = false;
                for (int i11 = 2; i10 < i11; i11 = 2) {
                    for (int i12 = 0; i12 < selectedMessages[i10].size(); i12++) {
                        MessageObject messageObjectValueAt = selectedMessages[i10].valueAt(i12);
                        if (!messageObjectValueAt.isDice() || Math.abs(currentTime - messageObjectValueAt.messageOwner.date) > 86400) {
                            z = true;
                            break;
                        }
                    }
                    i10++;
                }
            }
            final boolean[] zArr5 = new boolean[3];
            boolean[] zArr6 = (user == null || !user.self) ? new boolean[]{true} : new boolean[1];
            boolean z7 = user != null && MessagesController.getInstance(currentAccount).canRevokePmInbox;
            if (user != null) {
                i2 = MessagesController.getInstance(currentAccount).revokeTimePmLimit;
            } else {
                i2 = MessagesController.getInstance(currentAccount).revokeTimeLimit;
            }
            long clientUserId = UserConfig.getInstance(fragment.getCurrentAccount()).getClientUserId();
            boolean z8 = encryptedChat == null && user != null && z7 && i2 == Integer.MAX_VALUE;
            if (chat != null && chat.megagroup && !scheduled) {
                boolean zCanBlockUsers = ChatObject.canBlockUsers(chat);
                if (selectedMessage != null) {
                    TLRPC$MessageAction tLRPC$MessageAction3 = selectedMessage.messageOwner.action;
                    zArr4 = zArr6;
                    if (tLRPC$MessageAction3 == null || (tLRPC$MessageAction3 instanceof TLRPC$TL_messageActionEmpty) || (tLRPC$MessageAction3 instanceof TLRPC$TL_messageActionChatDeleteUser) || (tLRPC$MessageAction3 instanceof TLRPC$TL_messageActionChatJoinedByLink) || (tLRPC$MessageAction3 instanceof TLRPC$TL_messageActionChatAddUser)) {
                        str = "DeleteMessagesOption";
                        user2 = MessagesController.getInstance(currentAccount).getUser(Long.valueOf(selectedMessage.messageOwner.from_id.user_id));
                    } else {
                        str = "DeleteMessagesOption";
                        user2 = null;
                    }
                    builder3 = builder5;
                    i7 = (!selectedMessage.isSendError() && selectedMessage.getDialogId() == mergeDialogId && ((tLRPC$MessageAction2 = selectedMessage.messageOwner.action) == null || (tLRPC$MessageAction2 instanceof TLRPC$TL_messageActionEmpty)) && selectedMessage.isOut() && currentTime - selectedMessage.messageOwner.date <= i2) ? 1 : 0;
                } else {
                    zArr4 = zArr6;
                    str = "DeleteMessagesOption";
                    long fromChatId = -1;
                    for (int i13 = 1; i13 >= 0; i13--) {
                        for (int i14 = 0; i14 < selectedMessages[i13].size(); i14++) {
                            MessageObject messageObjectValueAt2 = selectedMessages[i13].valueAt(i14);
                            if (fromChatId == -1) {
                                fromChatId = messageObjectValueAt2.getFromChatId();
                            }
                            if (fromChatId < 0 || fromChatId != messageObjectValueAt2.getSenderId()) {
                                fromChatId = -2;
                                break;
                            }
                        }
                        if (fromChatId == -2) {
                            break;
                        }
                    }
                    int i15 = 0;
                    for (int i16 = 1; i16 >= 0; i16--) {
                        int i17 = 0;
                        while (i17 < selectedMessages[i16].size()) {
                            MessageObject messageObjectValueAt3 = selectedMessages[i16].valueAt(i17);
                            AlertDialog.Builder builder6 = builder5;
                            if (i16 == 1 && messageObjectValueAt3.isOut()) {
                                TLRPC$Message tLRPC$Message = messageObjectValueAt3.messageOwner;
                                if (tLRPC$Message.action == null && currentTime - tLRPC$Message.date <= i2) {
                                    i15++;
                                }
                            }
                            i17++;
                            builder5 = builder6;
                        }
                    }
                    builder3 = builder5;
                    if (fromChatId != -1) {
                        int i18 = i15;
                        user2 = MessagesController.getInstance(currentAccount).getUser(Long.valueOf(fromChatId));
                        i7 = i18;
                    } else {
                        i7 = i15;
                        user2 = null;
                    }
                }
                if (user2 == null || user2.id == UserConfig.getInstance(currentAccount).getClientUserId()) {
                    i8 = currentAccount;
                    builder4 = builder3;
                    if (i7 <= 0 || !z) {
                        zArr = zArr4;
                        z5 = false;
                        user2 = null;
                    } else {
                        FrameLayout frameLayout = new FrameLayout(parentActivity);
                        CheckBoxCell checkBoxCell = new CheckBoxCell(parentActivity, 1, resourcesProvider);
                        checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                        checkBoxCell.setText(LocaleController.getString(str, R.string.DeleteMessagesOption), "", zArr4[0], false);
                        checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                        frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                        zArr = zArr4;
                        checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$etOmxKeqY7AunC6IvxC0_XtyZbI
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AlertsCreator.lambda$createDeleteMessagesAlert$93(zArr, view);
                            }
                        });
                        builder4.setView(frameLayout);
                        builder4.setCustomViewOffset(9);
                        z5 = true;
                    }
                } else {
                    if (i9 == 1 && !chat.creator) {
                        final AlertDialog[] alertDialogArr = {new AlertDialog(parentActivity, 3)};
                        TLRPC$TL_channels_getParticipant tLRPC$TL_channels_getParticipant = new TLRPC$TL_channels_getParticipant();
                        tLRPC$TL_channels_getParticipant.channel = MessagesController.getInputChannel(chat);
                        tLRPC$TL_channels_getParticipant.participant = MessagesController.getInputPeer(user2);
                        final int iSendRequest = ConnectionsManager.getInstance(currentAccount).sendRequest(tLRPC$TL_channels_getParticipant, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$b5HBPWqjpSux0mU_sKEzq2pdCyI
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$nNktHS-aKblHVIHbzXC4PNpkVRE
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        AlertsCreator.lambda$createDeleteMessagesAlert$88(alertDialogArr, tLObject, tLRPC$TL_error, baseFragment, tLRPC$User, tLRPC$Chat, tLRPC$EncryptedChat, tLRPC$ChatFull, j, messageObject, sparseArrayArr, groupedMessages, z, runnable, resourcesProvider);
                                    }
                                });
                            }
                        });
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$W9qiEE-HFSPiPuG82tJihTvnpYs
                            @Override // java.lang.Runnable
                            public final void run() {
                                AlertsCreator.lambda$createDeleteMessagesAlert$91(alertDialogArr, currentAccount, iSendRequest, fragment);
                            }
                        }, 1000L);
                        return;
                    }
                    i8 = currentAccount;
                    FrameLayout frameLayout2 = new FrameLayout(parentActivity);
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < 3) {
                        if ((i9 == 2 || !zCanBlockUsers) && i19 == 0) {
                            z6 = zCanBlockUsers;
                        } else {
                            CheckBoxCell checkBoxCell2 = new CheckBoxCell(parentActivity, 1, resourcesProvider);
                            checkBoxCell2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                            checkBoxCell2.setTag(Integer.valueOf(i19));
                            if (i19 == 0) {
                                checkBoxCell2.setText(LocaleController.getString("DeleteBanUser", R.string.DeleteBanUser), "", false, false);
                                z6 = zCanBlockUsers;
                            } else if (i19 == 1) {
                                z6 = zCanBlockUsers;
                                checkBoxCell2.setText(LocaleController.getString("DeleteReportSpam", R.string.DeleteReportSpam), "", false, false);
                            } else {
                                z6 = zCanBlockUsers;
                                checkBoxCell2.setText(LocaleController.formatString("DeleteAllFrom", R.string.DeleteAllFrom, ContactsController.formatName(user2.first_name, user2.last_name)), "", false, false);
                            }
                            checkBoxCell2.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                            frameLayout2.addView(checkBoxCell2, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, i20 * 48, 0.0f, 0.0f));
                            checkBoxCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$3f2YwCw5b4Lb7gCVBa0Y8j3Dolk
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    AlertsCreator.lambda$createDeleteMessagesAlert$92(zArr5, view);
                                }
                            });
                            i20++;
                        }
                        i19++;
                        i9 = loadParticipant;
                        zCanBlockUsers = z6;
                    }
                    builder4 = builder3;
                    builder4.setView(frameLayout2);
                    zArr = zArr4;
                    z5 = false;
                }
                i5 = i7;
                tLRPC$User = user2;
                zArr2 = zArr5;
                i3 = i8;
                i4 = i;
                z3 = false;
                boolean z9 = z5;
                builder = builder4;
                z2 = z9;
            } else {
                AlertDialog.Builder builder7 = builder5;
                zArr = zArr6;
                int i21 = i2;
                int i22 = currentAccount;
                if (scheduled || ChatObject.isChannel(chat) || encryptedChat != null) {
                    builder = builder7;
                    zArr2 = zArr5;
                    i3 = i22;
                    i4 = i;
                    z2 = false;
                    z3 = false;
                    i5 = 0;
                } else {
                    if ((user == null || user.id == UserConfig.getInstance(i22).getClientUserId() || (user.bot && !user.support)) && chat == null) {
                        messageObject = selectedMessage;
                        builder2 = builder7;
                        zArr2 = zArr5;
                        i3 = i22;
                        i6 = 0;
                        z3 = false;
                    } else {
                        messageObject = selectedMessage;
                        if (messageObject != null) {
                            int i23 = (selectedMessage.isSendError() || !((tLRPC$MessageAction = messageObject.messageOwner.action) == null || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionEmpty) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPhoneCall) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionPinMessage) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionGeoProximityReached) || (tLRPC$MessageAction instanceof TLRPC$TL_messageActionSetChatTheme)) || (!(selectedMessage.isOut() || z7 || ChatObject.hasAdminRights(chat)) || currentTime - messageObject.messageOwner.date > i21)) ? 0 : 1;
                            z3 = !selectedMessage.isOut();
                            builder2 = builder7;
                            zArr2 = zArr5;
                            i3 = i22;
                            i6 = i23;
                        } else {
                            int i24 = 0;
                            boolean z10 = false;
                            int i25 = 1;
                            while (i25 >= 0) {
                                boolean z11 = z10;
                                int i26 = i24;
                                int i27 = 0;
                                while (true) {
                                    zArr3 = zArr5;
                                    if (i27 < selectedMessages[i25].size()) {
                                        MessageObject messageObjectValueAt4 = selectedMessages[i25].valueAt(i27);
                                        int i28 = i22;
                                        TLRPC$MessageAction tLRPC$MessageAction4 = messageObjectValueAt4.messageOwner.action;
                                        AlertDialog.Builder builder8 = builder7;
                                        if ((tLRPC$MessageAction4 == null || (tLRPC$MessageAction4 instanceof TLRPC$TL_messageActionEmpty) || (tLRPC$MessageAction4 instanceof TLRPC$TL_messageActionPhoneCall) || (tLRPC$MessageAction4 instanceof TLRPC$TL_messageActionPinMessage) || (tLRPC$MessageAction4 instanceof TLRPC$TL_messageActionGeoProximityReached)) && ((messageObjectValueAt4.isOut() || z7 || (chat != null && ChatObject.canBlockUsers(chat))) && currentTime - messageObjectValueAt4.messageOwner.date <= i21)) {
                                            i26++;
                                            if (!z11 && !messageObjectValueAt4.isOut()) {
                                                z11 = true;
                                            }
                                        }
                                        i27++;
                                        zArr5 = zArr3;
                                        builder7 = builder8;
                                        i22 = i28;
                                    }
                                }
                                i25--;
                                i24 = i26;
                                z10 = z11;
                                zArr5 = zArr3;
                            }
                            builder2 = builder7;
                            zArr2 = zArr5;
                            i3 = i22;
                            i6 = i24;
                            z3 = z10;
                        }
                    }
                    boolean z12 = messageObject == null || messageObject.messageOwner.from_id.user_id == clientUserId;
                    int i29 = 0;
                    while (true) {
                        if (i29 >= selectedMessages[0].size()) {
                            z4 = z12;
                            break;
                        } else {
                            if (selectedMessages[0].valueAt(i29).messageOwner.from_id.user_id != clientUserId) {
                                z4 = false;
                                break;
                            }
                            i29++;
                        }
                    }
                    if (i6 <= 0 || !z || ((user != null && UserObject.isDeleted(user)) || !z4)) {
                        i4 = i;
                        builder = builder2;
                        i5 = i6;
                        z2 = false;
                    } else {
                        FrameLayout frameLayout3 = new FrameLayout(parentActivity);
                        CheckBoxCell checkBoxCell3 = new CheckBoxCell(parentActivity, 1, resourcesProvider);
                        checkBoxCell3.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                        if (z8) {
                            checkBoxCell3.setText(LocaleController.formatString("DeleteMessagesOptionAlso", R.string.DeleteMessagesOptionAlso, UserObject.getFirstName(user)), "", zArr[0], false);
                            i4 = i;
                        } else {
                            i4 = i;
                            if (chat != null && (z3 || i6 == i4)) {
                                checkBoxCell3.setText(LocaleController.getString("DeleteForAll", R.string.DeleteForAll), "", zArr[0], false);
                            } else {
                                checkBoxCell3.setText(LocaleController.getString("DeleteMessagesOption", R.string.DeleteMessagesOption), "", zArr[0], false);
                            }
                        }
                        checkBoxCell3.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
                        frameLayout3.addView(checkBoxCell3, LayoutHelper.createFrame(-1, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                        checkBoxCell3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$VThKIHyuBnnpN14F2ZFoEoWCZz8
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                AlertsCreator.lambda$createDeleteMessagesAlert$94(zArr, view);
                            }
                        });
                        builder = builder2;
                        builder.setView(frameLayout3);
                        builder.setCustomViewOffset(9);
                        i5 = i6;
                        z2 = true;
                    }
                }
                tLRPC$User = null;
            }
            final int i30 = i3;
            final boolean[] zArr7 = zArr;
            final boolean[] zArr8 = zArr2;
            builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$yB26rfzXxed2ztIhCst4jEECj3M
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i31) {
                    AlertsCreator.lambda$createDeleteMessagesAlert$96(selectedMessage, selectedGroup, encryptedChat, i30, j, zArr7, scheduled, user, selectedMessages, tLRPC$User, zArr8, chat, chatInfo, onDelete, dialogInterface, i31);
                }
            });
            if (i4 == 1) {
                builder.setTitle(LocaleController.getString("DeleteSingleMessagesTitle", R.string.DeleteSingleMessagesTitle));
            } else {
                builder.setTitle(LocaleController.formatString("DeleteMessagesTitle", R.string.DeleteMessagesTitle, LocaleController.formatPluralString("messages", i4)));
            }
            if (chat == null || !z3) {
                if (!z2 || z8 || i5 == i4) {
                    if (chat == null || !chat.megagroup || scheduled) {
                        if (i4 == 1) {
                            builder.setMessage(LocaleController.getString("AreYouSureDeleteSingleMessage", R.string.AreYouSureDeleteSingleMessage));
                        } else {
                            builder.setMessage(LocaleController.getString("AreYouSureDeleteFewMessages", R.string.AreYouSureDeleteFewMessages));
                        }
                    } else if (i4 == 1) {
                        builder.setMessage(LocaleController.getString("AreYouSureDeleteSingleMessageMega", R.string.AreYouSureDeleteSingleMessageMega));
                    } else {
                        builder.setMessage(LocaleController.getString("AreYouSureDeleteFewMessagesMega", R.string.AreYouSureDeleteFewMessagesMega));
                    }
                } else if (chat != null) {
                    builder.setMessage(LocaleController.formatString("DeleteMessagesTextGroup", R.string.DeleteMessagesTextGroup, LocaleController.formatPluralString("messages", i5)));
                } else {
                    builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("DeleteMessagesText", R.string.DeleteMessagesText, LocaleController.formatPluralString("messages", i5), UserObject.getFirstName(user))));
                }
            } else if (z2 && i5 != i4) {
                builder.setMessage(LocaleController.formatString("DeleteMessagesTextGroupPart", R.string.DeleteMessagesTextGroupPart, LocaleController.formatPluralString("messages", i5)));
            } else if (i4 == 1) {
                builder.setMessage(LocaleController.getString("AreYouSureDeleteSingleMessage", R.string.AreYouSureDeleteSingleMessage));
            } else {
                builder.setMessage(LocaleController.getString("AreYouSureDeleteFewMessages", R.string.AreYouSureDeleteFewMessages));
            }
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            fragment.showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$88(AlertDialog[] alertDialogArr, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, TLRPC$EncryptedChat tLRPC$EncryptedChat, TLRPC$ChatFull tLRPC$ChatFull, long j, MessageObject messageObject, SparseArray[] sparseArrayArr, MessageObject.GroupedMessages groupedMessages, boolean z, Runnable runnable, Theme.ResourcesProvider resourcesProvider) {
        int i;
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        if (tLObject != null) {
            TLRPC$ChannelParticipant tLRPC$ChannelParticipant = ((TLRPC$TL_channels_channelParticipant) tLObject).participant;
            i = ((tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantAdmin) || (tLRPC$ChannelParticipant instanceof TLRPC$TL_channelParticipantCreator)) ? 2 : 0;
        } else {
            i = (tLRPC$TL_error == null || !"USER_NOT_PARTICIPANT".equals(tLRPC$TL_error.text)) ? 2 : 0;
        }
        createDeleteMessagesAlert(baseFragment, tLRPC$User, tLRPC$Chat, tLRPC$EncryptedChat, tLRPC$ChatFull, j, messageObject, sparseArrayArr, groupedMessages, z, i, runnable, resourcesProvider);
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$91(AlertDialog[] alertDialogArr, final int i, final int i2, BaseFragment baseFragment) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$oeMO8cP-OemeUNdBurFAorE9_gg
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ConnectionsManager.getInstance(i).cancelRequest(i2, true);
            }
        });
        baseFragment.showDialog(alertDialogArr[0]);
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$92(boolean[] zArr, View view) {
        if (view.isEnabled()) {
            CheckBoxCell checkBoxCell = (CheckBoxCell) view;
            Integer num = (Integer) checkBoxCell.getTag();
            zArr[num.intValue()] = !zArr[num.intValue()];
            checkBoxCell.setChecked(zArr[num.intValue()], true);
        }
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$93(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$94(boolean[] zArr, View view) {
        zArr[0] = !zArr[0];
        ((CheckBoxCell) view).setChecked(zArr[0], true);
    }

    static /* synthetic */ void lambda$createDeleteMessagesAlert$96(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, TLRPC$EncryptedChat tLRPC$EncryptedChat, int i, long j, boolean[] zArr, boolean z, TLRPC$User tLRPC$User, SparseArray[] sparseArrayArr, TLRPC$User tLRPC$User2, boolean[] zArr2, TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, Runnable runnable, DialogInterface dialogInterface, int i2) {
        ArrayList<Integer> arrayList;
        char c;
        ArrayList<Integer> arrayList2 = null;
        ArrayList arrayList3 = null;
        int i3 = 10;
        if (messageObject != null) {
            ArrayList<Integer> arrayList4 = new ArrayList<>();
            ArrayList<Long> arrayList5 = new ArrayList<>();
            if (groupedMessages != null) {
                for (int i4 = 0; i4 < groupedMessages.messages.size(); i4++) {
                    MessageObject messageObject2 = groupedMessages.messages.get(i4);
                    arrayList4.add(Integer.valueOf(messageObject2.getId()));
                    arrayList5.add(Long.valueOf(messageObject2.getDialogId()));
                    if (tLRPC$EncryptedChat != null && messageObject2.messageOwner.random_id != 0 && messageObject2.type != 10) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(Long.valueOf(messageObject2.messageOwner.random_id));
                    }
                }
            } else {
                arrayList4.add(Integer.valueOf(messageObject.getId()));
                arrayList5.add(Long.valueOf(messageObject.getDialogId()));
                if (tLRPC$EncryptedChat != null && messageObject.messageOwner.random_id != 0 && messageObject.type != 10) {
                    new ArrayList().add(Long.valueOf(messageObject.messageOwner.random_id));
                }
            }
            MessagesController.getInstance(i).deleteMessages(arrayList4, arrayList5, tLRPC$EncryptedChat, j, zArr[0], z, false, 0L, null, tLRPC$User != null && tLRPC$User.MXB_VIRTUAL_USER);
            arrayList = arrayList4;
        } else {
            int i5 = 1;
            while (i5 >= 0) {
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                ArrayList<Long> arrayList7 = new ArrayList<>();
                for (int i6 = 0; i6 < sparseArrayArr[i5].size(); i6++) {
                    arrayList6.add(Integer.valueOf(sparseArrayArr[i5].keyAt(i6)));
                    arrayList7.add(Long.valueOf(((MessageObject) sparseArrayArr[i5].valueAt(i6)).getDialogId()));
                }
                if (arrayList6.isEmpty()) {
                    c = 0;
                } else {
                    c = 0;
                    int i7 = (((MessageObject) sparseArrayArr[i5].get(arrayList6.get(0).intValue())).messageOwner.peer_id.channel_id > 0L ? 1 : (((MessageObject) sparseArrayArr[i5].get(arrayList6.get(0).intValue())).messageOwner.peer_id.channel_id == 0L ? 0 : -1));
                }
                if (tLRPC$EncryptedChat != null) {
                    ArrayList arrayList8 = new ArrayList();
                    for (int i8 = 0; i8 < sparseArrayArr[i5].size(); i8++) {
                        MessageObject messageObject3 = (MessageObject) sparseArrayArr[i5].valueAt(i8);
                        long j2 = messageObject3.messageOwner.random_id;
                        if (j2 != 0 && messageObject3.type != i3) {
                            arrayList8.add(Long.valueOf(j2));
                        }
                    }
                }
                MessagesController.getInstance(i).deleteMessages(arrayList6, arrayList7, tLRPC$EncryptedChat, j, zArr[c], z, false, 0L, null, tLRPC$User != null && tLRPC$User.MXB_VIRTUAL_USER);
                sparseArrayArr[i5].clear();
                i5--;
                arrayList2 = arrayList6;
                i3 = 10;
            }
            arrayList = arrayList2;
        }
        if (tLRPC$User2 != null) {
            if (zArr2[0]) {
                MessagesController.getInstance(i).deleteParticipantFromChat(tLRPC$Chat.id, tLRPC$User2, tLRPC$ChatFull);
            }
            if (zArr2[1]) {
                TLRPC$TL_channels_reportSpam tLRPC$TL_channels_reportSpam = new TLRPC$TL_channels_reportSpam();
                tLRPC$TL_channels_reportSpam.channel = MessagesController.getInputChannel(tLRPC$Chat);
                tLRPC$TL_channels_reportSpam.user_id = MessagesController.getInstance(i).getInputUser(tLRPC$User2);
                tLRPC$TL_channels_reportSpam.id = arrayList;
                ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_channels_reportSpam, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$M6UbSYK7_RdzJ6wuqTvGdWE-whA
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        AlertsCreator.lambda$createDeleteMessagesAlert$95(tLObject, tLRPC$TL_error);
                    }
                });
            }
            if (zArr2[2]) {
                MessagesController.getInstance(i).deleteUserChannelHistory(tLRPC$Chat, tLRPC$User2, 0);
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void createThemeCreateDialog(final BaseFragment fragment, int type, final Theme.ThemeInfo switchToTheme, final Theme.ThemeAccent switchToAccent) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        Activity parentActivity = fragment.getParentActivity();
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(parentActivity);
        editTextBoldCursor.setTypeface(AndroidUtilities.getFontFamily(false));
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(parentActivity, true));
        AlertDialog.Builder builder = new AlertDialog.Builder(parentActivity);
        builder.setTitle(LocaleController.getString("NewTheme", R.string.NewTheme));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("Create", R.string.Create), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$RVzgBNkFLj5s3DzYnF7zaQ1MDN8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AlertsCreator.lambda$createThemeCreateDialog$97(dialogInterface, i);
            }
        });
        LinearLayout linearLayout = new LinearLayout(parentActivity);
        linearLayout.setOrientation(1);
        builder.setView(linearLayout);
        TextView textView = new TextView(parentActivity);
        if (type != 0) {
            textView.setText(AndroidUtilities.replaceTags(LocaleController.getString("EnterThemeNameEdit", R.string.EnterThemeNameEdit)));
        } else {
            textView.setText(LocaleController.getString("EnterThemeName", R.string.EnterThemeName));
        }
        textView.setTextSize(1, 16.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setPadding(AndroidUtilities.dp(23.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(23.0f), AndroidUtilities.dp(6.0f));
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2));
        editTextBoldCursor.setTextSize(1, 16.0f);
        editTextBoldCursor.setTextColor(Theme.getColor("dialogTextBlack"));
        editTextBoldCursor.setMaxLines(1);
        editTextBoldCursor.setLines(1);
        editTextBoldCursor.setInputType(16385);
        editTextBoldCursor.setGravity(51);
        editTextBoldCursor.setSingleLine(true);
        editTextBoldCursor.setImeOptions(6);
        editTextBoldCursor.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
        editTextBoldCursor.setCursorWidth(1.5f);
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
        linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
        editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$XO04WyFfsLcoh64sCx7_R7iOcrc
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                return AlertsCreator.lambda$createThemeCreateDialog$98(textView2, i, keyEvent);
            }
        });
        editTextBoldCursor.setText(generateThemeName(switchToAccent));
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$zl17VsxXxc62G3Sgu5xHUydVQsI
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$EiVMWAMSuHs1_BUZRWA8v9iZbNw
                    @Override // java.lang.Runnable
                    public final void run() {
                        AlertsCreator.lambda$createThemeCreateDialog$99(editTextBoldCursor);
                    }
                });
            }
        });
        fragment.showDialog(alertDialogCreate);
        editTextBoldCursor.requestFocus();
        alertDialogCreate.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$FVhEqpzm1EMy98b706G3YLE3JQA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Throwable {
                AlertsCreator.lambda$createThemeCreateDialog$103(fragment, editTextBoldCursor, switchToAccent, switchToTheme, alertDialogCreate, view);
            }
        });
    }

    static /* synthetic */ boolean lambda$createThemeCreateDialog$98(TextView textView, int i, KeyEvent keyEvent) {
        AndroidUtilities.hideKeyboard(textView);
        return false;
    }

    static /* synthetic */ void lambda$createThemeCreateDialog$99(EditTextBoldCursor editTextBoldCursor) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    static /* synthetic */ void lambda$createThemeCreateDialog$103(final BaseFragment baseFragment, final EditTextBoldCursor editTextBoldCursor, Theme.ThemeAccent themeAccent, Theme.ThemeInfo themeInfo, final AlertDialog alertDialog, View view) throws Throwable {
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
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$WRCjOcJ_zewm_Zng8xfELkzrh9M
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AlertsCreator$Wf_nfaaisSDxhoXnOL75VFtTUhs
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            AlertsCreator.processCreate(editTextBoldCursor, alertDialog, baseFragment);
                        }
                    });
                }
            });
            return;
        }
        processCreate(editTextBoldCursor, alertDialog, baseFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processCreate(EditTextBoldCursor editText, AlertDialog alertDialog, BaseFragment fragment) throws Throwable {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        AndroidUtilities.hideKeyboard(editText);
        Theme.ThemeInfo themeInfoCreateNewTheme = Theme.createNewTheme(editText.getText().toString());
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.themeListUpdated, new Object[0]);
        new ThemeEditorView().show(fragment.getParentActivity(), themeInfoCreateNewTheme);
        alertDialog.dismiss();
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (globalMainSettings.getBoolean("themehint", false)) {
            return;
        }
        globalMainSettings.edit().putBoolean("themehint", true).commit();
        try {
            Toast.makeText(fragment.getParentActivity(), LocaleController.getString("CreateNewThemeHelp", R.string.CreateNewThemeHelp), 1).show();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private static String generateThemeName(Theme.ThemeAccent accent) {
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
        Theme.ThemeAccent accent2 = accent == null ? Theme.getCurrentTheme().getAccent(false) : accent;
        if (accent2 == null || (i = accent2.accentColor) == 0) {
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
            int i5 = ((((i3 + Factory.DEVICE_USE_ANDROID_CAMCORDER) * i4) * i4) >> 8) + (iGreen2 * 4 * iGreen2) + ((((767 - i3) * iBlue2) * iBlue2) >> 8);
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

    public static void showLivesDialog(Activity activity, List<TLRPC$Chat> lives) {
        if (activity == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ExploreLivesDialogView exploreLivesDialogView = new ExploreLivesDialogView(activity);
        builder.setView(exploreLivesDialogView);
        android.app.AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        exploreLivesDialogView.setDialog(alertDialogCreate);
        exploreLivesDialogView.setLives(lives);
    }

    public static void createMxbDialog(final BaseFragment baseFragment, String title, boolean showInvite, TLRPC$TL_mbpUserRegisterInfos infos) {
        BottomSheet.Builder builder = new BottomSheet.Builder(baseFragment.getParentActivity());
        LinearLayout linearLayout = new LinearLayout(baseFragment.getParentActivity());
        linearLayout.setOrientation(1);
        builder.setTitle(title);
        builder.setCustomView(linearLayout);
        final BottomSheet bottomSheetCreate = builder.create();
        if (showInvite) {
            TextCell textCell = new TextCell(baseFragment.getParentActivity());
            textCell.setTextAndIcon(LocaleController.getString("InviteToEitaa", R.string.InviteToEitaa), R.drawable.menu_invite, true);
            linearLayout.addView(textCell);
            textCell.setBackgroundDrawable(Theme.createRadSelectorDrawable(Theme.getColor("profile_tabSelector"), 0, 0));
            textCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.AlertsCreator.24
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                }
            });
        }
        for (int i = 0; i < infos.mxbRegisterInfos.size(); i++) {
            final TLRPC$TL_mxbUserRegisterInfo tLRPC$TL_mxbUserRegisterInfo = infos.mxbRegisterInfos.get(i);
            String asString = MxbHelper.getInstance().messengersName.getAsString(Integer.toString(tLRPC$TL_mxbUserRegisterInfo.messenger_id));
            if (asString != null) {
                int iIntValue = MxbHelper.getInstance().messengersIc.getAsInteger(Integer.toString(tLRPC$TL_mxbUserRegisterInfo.messenger_id)).intValue();
                FrameLayout frameLayout = new FrameLayout(baseFragment.getParentActivity());
                SimpleTextView simpleTextView = new SimpleTextView(baseFragment.getParentActivity());
                simpleTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                simpleTextView.setTextSize(16);
                simpleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
                simpleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
                simpleTextView.setText(LocaleController.getString("SendMessageOn", R.string.SendMessageOn) + " " + asString);
                boolean z = LocaleController.isRTL;
                frameLayout.addView(simpleTextView, LayoutHelper.createFrame(-2, -2.0f, (z ? 5 : 3) | 16, z ? 0.0f : 71.0f, 0.0f, z ? 71.0f : 0.0f, 0.0f));
                ImageView imageView = new ImageView(baseFragment.getParentActivity());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setImageResource(iIntValue);
                boolean z2 = LocaleController.isRTL;
                frameLayout.addView(imageView, LayoutHelper.createFrame(32, 32.0f, (z2 ? 5 : 3) | 16, z2 ? 0.0f : 21.0f, 16.0f, z2 ? 21.0f : 0.0f, 16.0f));
                linearLayout.addView(frameLayout);
                frameLayout.setBackgroundDrawable(Theme.createRadSelectorDrawable(Theme.getColor("profile_tabSelector"), 0, 0));
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.AlertsCreator.25
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        BaseFragment baseFragment2 = baseFragment;
                        TLRPC$TL_mxbUserRegisterInfo tLRPC$TL_mxbUserRegisterInfo2 = tLRPC$TL_mxbUserRegisterInfo;
                        MxbHelper.openChat(baseFragment2, tLRPC$TL_mxbUserRegisterInfo2.messenger_id, tLRPC$TL_mxbUserRegisterInfo2.phone, tLRPC$TL_mxbUserRegisterInfo2.user_id);
                        bottomSheetCreate.dismiss();
                    }
                });
            }
        }
        bottomSheetCreate.show();
    }
}
