package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.Property;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MrzRecognizer;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SRPHelper;
import ir.eitaa.messenger.SecureDocument;
import ir.eitaa.messenger.SecureDocumentKey;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputSecureFile;
import ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$SecureFile;
import ir.eitaa.tgnet.TLRPC$SecurePasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$SecurePlainData;
import ir.eitaa.tgnet.TLRPC$SecureRequiredType;
import ir.eitaa.tgnet.TLRPC$SecureValueError;
import ir.eitaa.tgnet.TLRPC$SecureValueType;
import ir.eitaa.tgnet.TLRPC$TL_account_acceptAuthorization;
import ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm;
import ir.eitaa.tgnet.TLRPC$TL_account_deleteSecureValue;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_saveSecureValue;
import ir.eitaa.tgnet.TLRPC$TL_account_sendVerifyEmailCode;
import ir.eitaa.tgnet.TLRPC$TL_account_sendVerifyPhoneCode;
import ir.eitaa.tgnet.TLRPC$TL_account_sentEmailCode;
import ir.eitaa.tgnet.TLRPC$TL_account_updatePasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_verifyEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_verifyPhone;
import ir.eitaa.tgnet.TLRPC$TL_auth_cancelCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_auth_passwordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_auth_requestPasswordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_auth_resendCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_codeSettings;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_getPassportConfig;
import ir.eitaa.tgnet.TLRPC$TL_help_passportConfig;
import ir.eitaa.tgnet.TLRPC$TL_inputFile;
import ir.eitaa.tgnet.TLRPC$TL_inputSecureFile;
import ir.eitaa.tgnet.TLRPC$TL_inputSecureFileUploaded;
import ir.eitaa.tgnet.TLRPC$TL_inputSecureValue;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import ir.eitaa.tgnet.TLRPC$TL_secureCredentialsEncrypted;
import ir.eitaa.tgnet.TLRPC$TL_secureData;
import ir.eitaa.tgnet.TLRPC$TL_secureFile;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoSHA512;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoUnknown;
import ir.eitaa.tgnet.TLRPC$TL_securePlainEmail;
import ir.eitaa.tgnet.TLRPC$TL_securePlainPhone;
import ir.eitaa.tgnet.TLRPC$TL_secureRequiredType;
import ir.eitaa.tgnet.TLRPC$TL_secureRequiredTypeOneOf;
import ir.eitaa.tgnet.TLRPC$TL_secureSecretSettings;
import ir.eitaa.tgnet.TLRPC$TL_secureValue;
import ir.eitaa.tgnet.TLRPC$TL_secureValueError;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorData;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorFile;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorFiles;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorFrontSide;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorReverseSide;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorSelfie;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorTranslationFile;
import ir.eitaa.tgnet.TLRPC$TL_secureValueErrorTranslationFiles;
import ir.eitaa.tgnet.TLRPC$TL_secureValueHash;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeAddress;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeBankStatement;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeDriverLicense;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeEmail;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeIdentityCard;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeInternalPassport;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypePassport;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypePassportRegistration;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypePersonalDetails;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypePhone;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeRentalAgreement;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeTemporaryRegistration;
import ir.eitaa.tgnet.TLRPC$TL_secureValueTypeUtilityBill;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$Vector;
import ir.eitaa.tgnet.TLRPC$auth_CodeType;
import ir.eitaa.tgnet.TLRPC$auth_SentCodeType;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.CameraScanActivity;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.EmptyTextProgressView;
import ir.eitaa.ui.Components.HintEditText;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgress;
import ir.eitaa.ui.Components.SlideView;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.CountrySelectActivity;
import ir.eitaa.ui.PassportActivity;
import ir.eitaa.ui.PhotoViewer;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class PassportActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private TextView acceptTextView;
    private TextSettingsCell addDocumentCell;
    private ShadowSectionCell addDocumentSectionCell;
    private boolean allowNonLatinName;
    private ArrayList<TLRPC$TL_secureRequiredType> availableDocumentTypes;
    private TextInfoPrivacyCell bottomCell;
    private TextInfoPrivacyCell bottomCellTranslation;
    private FrameLayout bottomLayout;
    private boolean callbackCalled;
    private ChatAttachAlert chatAttachAlert;
    private HashMap<String, String> codesMap;
    private ArrayList<String> countriesArray;
    private HashMap<String, String> countriesMap;
    private int currentActivityType;
    private long currentBotId;
    private String currentCallbackUrl;
    private String currentCitizeship;
    private HashMap<String, String> currentDocumentValues;
    private TLRPC$TL_secureRequiredType currentDocumentsType;
    private TLRPC$TL_secureValue currentDocumentsTypeValue;
    private String currentEmail;
    private int[] currentExpireDate;
    private TLRPC$TL_account_authorizationForm currentForm;
    private String currentGender;
    private String currentNonce;
    private TLRPC$TL_account_password currentPassword;
    private String currentPayload;
    private TLRPC$TL_auth_sentCode currentPhoneVerification;
    private LinearLayout currentPhotoViewerLayout;
    private String currentPicturePath;
    private String currentPublicKey;
    private String currentResidence;
    private String currentScope;
    private TLRPC$TL_secureRequiredType currentType;
    private TLRPC$TL_secureValue currentTypeValue;
    private HashMap<String, String> currentValues;
    private int currentViewNum;
    private PassportActivityDelegate delegate;
    private TextSettingsCell deletePassportCell;
    private ArrayList<View> dividers;
    private boolean documentOnly;
    private ArrayList<SecureDocument> documents;
    private HashMap<SecureDocument, SecureDocumentCell> documentsCells;
    private HashMap<String, String> documentsErrors;
    private LinearLayout documentsLayout;
    private HashMap<TLRPC$TL_secureRequiredType, TLRPC$TL_secureRequiredType> documentsToTypesLink;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private int emailCodeLength;
    private ImageView emptyImageView;
    private LinearLayout emptyLayout;
    private TextView emptyTextView1;
    private TextView emptyTextView2;
    private TextView emptyTextView3;
    private EmptyTextProgressView emptyView;
    private HashMap<String, HashMap<String, String>> errorsMap;
    private HashMap<String, String> errorsValues;
    private View extraBackgroundView;
    private View extraBackgroundView2;
    private HashMap<String, String> fieldsErrors;
    private SecureDocument frontDocument;
    private LinearLayout frontLayout;
    private HeaderCell headerCell;
    private boolean ignoreOnFailure;
    private boolean ignoreOnPhoneChange;
    private boolean ignoreOnTextChange;
    private String initialValues;
    private EditTextBoldCursor[] inputExtraFields;
    private ViewGroup[] inputFieldContainers;
    private EditTextBoldCursor[] inputFields;
    private HashMap<String, String> languageMap;
    private LinearLayout linearLayout2;
    private HashMap<String, String> mainErrorsMap;
    private TextInfoPrivacyCell nativeInfoCell;
    private boolean needActivityResult;
    private CharSequence noAllDocumentsErrorText;
    private CharSequence noAllTranslationErrorText;
    private ImageView noPasswordImageView;
    private TextView noPasswordSetTextView;
    private TextView noPasswordTextView;
    private boolean[] nonLatinNames;
    private FrameLayout passwordAvatarContainer;
    private TextView passwordForgotButton;
    private TextInfoPrivacyCell passwordInfoRequestTextView;
    private TextInfoPrivacyCell passwordRequestTextView;
    private PassportActivityDelegate pendingDelegate;
    private ErrorRunnable pendingErrorRunnable;
    private Runnable pendingFinishRunnable;
    private String pendingPhone;
    private Dialog permissionsDialog;
    private ArrayList<String> permissionsItems;
    private HashMap<String, String> phoneFormatMap;
    private TextView plusTextView;
    private PassportActivity presentAfterAnimation;
    private AlertDialog progressDialog;
    private ContextProgressView progressView;
    private ContextProgressView progressViewButton;
    private PhotoViewer.PhotoViewerProvider provider;
    private SecureDocument reverseDocument;
    private LinearLayout reverseLayout;
    private byte[] saltedPassword;
    private byte[] savedPasswordHash;
    private byte[] savedSaltedPassword;
    private TextSettingsCell scanDocumentCell;
    private int scrollHeight;
    private ScrollView scrollView;
    private ShadowSectionCell sectionCell;
    private ShadowSectionCell sectionCell2;
    private byte[] secureSecret;
    private long secureSecretId;
    private SecureDocument selfieDocument;
    private LinearLayout selfieLayout;
    private TextInfoPrivacyCell topErrorCell;
    private ArrayList<SecureDocument> translationDocuments;
    private LinearLayout translationLayout;
    private HashMap<TLRPC$TL_secureRequiredType, HashMap<String, String>> typesValues;
    private HashMap<TLRPC$TL_secureRequiredType, TextDetailSecureCell> typesViews;
    private TextSettingsCell uploadDocumentCell;
    private TextDetailSettingsCell uploadFrontCell;
    private TextDetailSettingsCell uploadReverseCell;
    private TextDetailSettingsCell uploadSelfieCell;
    private TextSettingsCell uploadTranslationCell;
    private HashMap<String, SecureDocument> uploadingDocuments;
    private int uploadingFileType;
    private boolean useCurrentValue;
    private int usingSavedPassword;
    private SlideView[] views;

    /* JADX INFO: Access modifiers changed from: private */
    interface ErrorRunnable {
        void onError(String error, String text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface PassportActivityDelegate {
        void deleteValue(TLRPC$TL_secureRequiredType type, TLRPC$TL_secureRequiredType documentType, ArrayList<TLRPC$TL_secureRequiredType> documentRequiredTypes, boolean deleteType, Runnable finishRunnable, ErrorRunnable errorRunnable);

        SecureDocument saveFile(TLRPC$TL_secureFile secureFile);

        void saveValue(TLRPC$TL_secureRequiredType type, String text, String json, TLRPC$TL_secureRequiredType documentType, String documentsJson, ArrayList<SecureDocument> documents, SecureDocument selfie, ArrayList<SecureDocument> translationDocuments, SecureDocument front, SecureDocument reverse, Runnable finishRunnable, ErrorRunnable errorRunnable);
    }

    public class LinkSpan extends ClickableSpan {
        public LinkSpan() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(true);
            ds.setTypeface(AndroidUtilities.getFontFamily(true));
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Browser.openUrl(PassportActivity.this.getParentActivity(), PassportActivity.this.currentForm.privacy_policy_url);
        }
    }

    public class TextDetailSecureCell extends FrameLayout {
        private ImageView checkImageView;
        private boolean needDivider;
        private TextView textView;
        private TextView valueTextView;

        public TextDetailSecureCell(Context context) {
            super(context);
            int i = PassportActivity.this.currentActivityType == 8 ? 21 : 51;
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            TextView textView2 = this.textView;
            boolean z = LocaleController.isRTL;
            addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (z ? 5 : 3) | 48, z ? i : 21, 10.0f, z ? 21 : i, 0.0f));
            TextView textView3 = new TextView(context);
            this.valueTextView = textView3;
            textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setPadding(0, 0, 0, 0);
            TextView textView4 = this.valueTextView;
            boolean z2 = LocaleController.isRTL;
            addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? i : 21, 35.0f, z2 ? 21 : i, 0.0f));
            ImageView imageView = new ImageView(context);
            this.checkImageView = imageView;
            imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("featuredStickers_addedIcon"), PorterDuff.Mode.MULTIPLY));
            this.checkImageView.setImageResource(R.drawable.sticker_added);
            addView(this.checkImageView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 3 : 5) | 48, 21.0f, 25.0f, 21.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.needDivider ? 1 : 0), 1073741824));
        }

        public void setTextAndValue(String text, CharSequence value, boolean divider) {
            this.textView.setText(text);
            this.valueTextView.setText(value);
            this.needDivider = divider;
            setWillNotDraw(!divider);
        }

        public void setChecked(boolean checked) {
            this.checkImageView.setVisibility(checked ? 0 : 4);
        }

        public void setValue(CharSequence value) {
            this.valueTextView.setText(value);
        }

        public void setNeedDivider(boolean value) {
            this.needDivider = value;
            setWillNotDraw(!value);
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }
    }

    public class SecureDocumentCell extends FrameLayout implements DownloadController.FileDownloadProgressListener {
        private int TAG;
        private int buttonState;
        private SecureDocument currentSecureDocument;
        private BackupImageView imageView;
        private RadialProgress radialProgress;
        private TextView textView;
        private TextView valueTextView;

        public SecureDocumentCell(Context context) {
            super(context);
            this.TAG = DownloadController.getInstance(((BaseFragment) PassportActivity.this).currentAccount).generateObserverTag();
            this.radialProgress = new RadialProgress(this);
            BackupImageView backupImageView = new BackupImageView(context);
            this.imageView = backupImageView;
            addView(backupImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 8.0f, 21.0f, 0.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            View view = this.textView;
            boolean z = LocaleController.isRTL;
            addView(view, LayoutHelper.createFrame(-2, -2.0f, (z ? 5 : 3) | 48, z ? 21 : 81, 10.0f, z ? 81 : 21, 0.0f));
            TextView textView2 = new TextView(context);
            this.valueTextView = textView2;
            textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setPadding(0, 0, 0, 0);
            View view2 = this.valueTextView;
            boolean z2 = LocaleController.isRTL;
            addView(view2, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 21 : 81, 35.0f, z2 ? 81 : 21, 0.0f));
            setWillNotDraw(false);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + 1, 1073741824));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            int left2 = this.imageView.getLeft() + ((this.imageView.getMeasuredWidth() - AndroidUtilities.dp(24.0f)) / 2);
            int top2 = this.imageView.getTop() + ((this.imageView.getMeasuredHeight() - AndroidUtilities.dp(24.0f)) / 2);
            this.radialProgress.setProgressRect(left2, top2, AndroidUtilities.dp(24.0f) + left2, AndroidUtilities.dp(24.0f) + top2);
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            if (child == this.imageView) {
                this.radialProgress.draw(canvas);
            }
            return zDrawChild;
        }

        public void setTextAndValueAndImage(String text, CharSequence value, SecureDocument document) {
            this.textView.setText(text);
            this.valueTextView.setText(value);
            this.imageView.setImage(document, "48_48");
            this.currentSecureDocument = document;
            updateButtonState(false);
        }

        public void setValue(CharSequence value) {
            this.valueTextView.setText(value);
        }

        public void updateButtonState(boolean animated) {
            String attachFileName = FileLoader.getAttachFileName(this.currentSecureDocument);
            boolean zExists = FileLoader.getPathToAttach(this.currentSecureDocument).exists();
            if (TextUtils.isEmpty(attachFileName)) {
                this.radialProgress.setBackground(null, false, false);
                return;
            }
            SecureDocument secureDocument = this.currentSecureDocument;
            if (secureDocument.path != null) {
                if (secureDocument.inputFile != null) {
                    DownloadController.getInstance(((BaseFragment) PassportActivity.this).currentAccount).removeLoadingFileObserver(this);
                    this.radialProgress.setBackground(null, false, animated);
                    this.buttonState = -1;
                    return;
                } else {
                    DownloadController.getInstance(((BaseFragment) PassportActivity.this).currentAccount).addLoadingFileObserver(this.currentSecureDocument.path, this);
                    this.buttonState = 1;
                    Float fileProgress = ImageLoader.getInstance().getFileProgress(this.currentSecureDocument.path);
                    this.radialProgress.setBackground(Theme.chat_photoStatesDrawables[5][0], true, animated);
                    this.radialProgress.setProgress(fileProgress != null ? fileProgress.floatValue() : 0.0f, false);
                    invalidate();
                    return;
                }
            }
            if (zExists) {
                DownloadController.getInstance(((BaseFragment) PassportActivity.this).currentAccount).removeLoadingFileObserver(this);
                this.buttonState = -1;
                this.radialProgress.setBackground(null, false, animated);
                invalidate();
                return;
            }
            DownloadController.getInstance(((BaseFragment) PassportActivity.this).currentAccount).addLoadingFileObserver(attachFileName, this);
            this.buttonState = 1;
            Float fileProgress2 = ImageLoader.getInstance().getFileProgress(attachFileName);
            this.radialProgress.setBackground(Theme.chat_photoStatesDrawables[5][0], true, animated);
            this.radialProgress.setProgress(fileProgress2 != null ? fileProgress2.floatValue() : 0.0f, animated);
            invalidate();
        }

        @Override // android.view.View
        public void invalidate() {
            super.invalidate();
            this.textView.invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onFailedDownload(String fileName, boolean canceled) {
            updateButtonState(false);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onSuccessDownload(String fileName) {
            this.radialProgress.setProgress(1.0f, true);
            updateButtonState(true);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
            this.radialProgress.setProgress(Math.min(1.0f, downloadedSize / totalSize), true);
            if (this.buttonState != 1) {
                updateButtonState(false);
            }
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
            this.radialProgress.setProgress(Math.min(1.0f, uploadedSize / totalSize), true);
        }

        @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
        public int getObserverTag() {
            return this.TAG;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0170 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017a A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0184 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018e A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0198 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ab A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c0 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d3 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0201 A[Catch: Exception -> 0x023d, TryCatch #0 {Exception -> 0x023d, blocks: (B:6:0x0037, B:8:0x004a, B:11:0x0065, B:49:0x013e, B:51:0x0148, B:55:0x015f, B:57:0x0166, B:58:0x016c, B:82:0x01b6, B:84:0x01bb, B:85:0x01c0, B:86:0x01d3, B:88:0x01e8, B:89:0x01fb, B:90:0x0201, B:92:0x0216, B:93:0x0229, B:95:0x0231, B:60:0x0170, B:63:0x017a, B:66:0x0184, B:69:0x018e, B:72:0x0198, B:75:0x01a2, B:78:0x01ab, B:13:0x007a, B:15:0x007e, B:16:0x008d, B:18:0x0091, B:19:0x00a0, B:21:0x00a4, B:22:0x00b3, B:24:0x00b7, B:25:0x00c6, B:27:0x00ca, B:28:0x00d9, B:30:0x00dd, B:31:0x00eb, B:33:0x00ef, B:34:0x00ff, B:36:0x0103, B:37:0x0106, B:39:0x010e, B:41:0x011a, B:48:0x012e, B:44:0x0126), top: B:101:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x022f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PassportActivity(int r20, long r21, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm r28, ir.eitaa.tgnet.TLRPC$TL_account_password r29) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.<init>(int, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, ir.eitaa.tgnet.TLRPC$TL_account_authorizationForm, ir.eitaa.tgnet.TLRPC$TL_account_password):void");
    }

    /* renamed from: ir.eitaa.ui.PassportActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Comparator<TLRPC$SecureValueError>, j$.util.Comparator {
        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        AnonymousClass2() {
        }

        int getErrorValue(TLRPC$SecureValueError error) {
            if (error instanceof TLRPC$TL_secureValueError) {
                return 0;
            }
            if (error instanceof TLRPC$TL_secureValueErrorFrontSide) {
                return 1;
            }
            if (error instanceof TLRPC$TL_secureValueErrorReverseSide) {
                return 2;
            }
            if (error instanceof TLRPC$TL_secureValueErrorSelfie) {
                return 3;
            }
            if (error instanceof TLRPC$TL_secureValueErrorTranslationFile) {
                return 4;
            }
            if (error instanceof TLRPC$TL_secureValueErrorTranslationFiles) {
                return 5;
            }
            if (error instanceof TLRPC$TL_secureValueErrorFile) {
                return 6;
            }
            if (error instanceof TLRPC$TL_secureValueErrorFiles) {
                return 7;
            }
            if (error instanceof TLRPC$TL_secureValueErrorData) {
                return PassportActivity.this.getFieldCost(((TLRPC$TL_secureValueErrorData) error).field);
            }
            return 100;
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(TLRPC$SecureValueError e1, TLRPC$SecureValueError e2) {
            int errorValue = getErrorValue(e1);
            int errorValue2 = getErrorValue(e2);
            if (errorValue < errorValue2) {
                return -1;
            }
            return errorValue > errorValue2 ? 1 : 0;
        }
    }

    public PassportActivity(int type, TLRPC$TL_account_authorizationForm form, TLRPC$TL_account_password accountPassword, TLRPC$TL_secureRequiredType secureType, TLRPC$TL_secureValue secureValue, TLRPC$TL_secureRequiredType secureDocumentsType, TLRPC$TL_secureValue secureDocumentsValue, HashMap<String, String> values, HashMap<String, String> documentValues) {
        this.currentCitizeship = "";
        this.currentResidence = "";
        this.currentExpireDate = new int[3];
        this.dividers = new ArrayList<>();
        this.nonLatinNames = new boolean[3];
        this.allowNonLatinName = true;
        this.countriesArray = new ArrayList<>();
        this.countriesMap = new HashMap<>();
        this.codesMap = new HashMap<>();
        this.phoneFormatMap = new HashMap<>();
        this.documents = new ArrayList<>();
        this.translationDocuments = new ArrayList<>();
        this.documentsCells = new HashMap<>();
        this.uploadingDocuments = new HashMap<>();
        this.typesValues = new HashMap<>();
        this.typesViews = new HashMap<>();
        this.documentsToTypesLink = new HashMap<>();
        this.errorsMap = new HashMap<>();
        this.mainErrorsMap = new HashMap<>();
        this.errorsValues = new HashMap<>();
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.PassportActivity.1
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                if (index < 0 || index >= PassportActivity.this.currentPhotoViewerLayout.getChildCount()) {
                    return null;
                }
                SecureDocumentCell secureDocumentCell = (SecureDocumentCell) PassportActivity.this.currentPhotoViewerLayout.getChildAt(index);
                int[] iArr = new int[2];
                secureDocumentCell.imageView.getLocationInWindow(iArr);
                PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                placeProviderObject.viewX = iArr[0];
                placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0);
                placeProviderObject.parentView = PassportActivity.this.currentPhotoViewerLayout;
                ImageReceiver imageReceiver = secureDocumentCell.imageView.getImageReceiver();
                placeProviderObject.imageReceiver = imageReceiver;
                placeProviderObject.thumb = imageReceiver.getBitmapSafe();
                return placeProviderObject;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void deleteImageAtIndex(int index) {
                SecureDocument secureDocument = PassportActivity.this.uploadingFileType == 1 ? PassportActivity.this.selfieDocument : PassportActivity.this.uploadingFileType == 4 ? (SecureDocument) PassportActivity.this.translationDocuments.get(index) : PassportActivity.this.uploadingFileType == 2 ? PassportActivity.this.frontDocument : PassportActivity.this.uploadingFileType == 3 ? PassportActivity.this.reverseDocument : (SecureDocument) PassportActivity.this.documents.get(index);
                SecureDocumentCell secureDocumentCell = (SecureDocumentCell) PassportActivity.this.documentsCells.remove(secureDocument);
                if (secureDocumentCell == null) {
                    return;
                }
                String documentHash = PassportActivity.this.getDocumentHash(secureDocument);
                String str = null;
                if (PassportActivity.this.uploadingFileType == 1) {
                    PassportActivity.this.selfieDocument = null;
                    str = "selfie" + documentHash;
                } else if (PassportActivity.this.uploadingFileType != 4) {
                    if (PassportActivity.this.uploadingFileType == 2) {
                        PassportActivity.this.frontDocument = null;
                        str = "front" + documentHash;
                    } else if (PassportActivity.this.uploadingFileType == 3) {
                        PassportActivity.this.reverseDocument = null;
                        str = "reverse" + documentHash;
                    } else if (PassportActivity.this.uploadingFileType == 0) {
                        str = "files" + documentHash;
                    }
                } else {
                    str = "translation" + documentHash;
                }
                if (str != null) {
                    if (PassportActivity.this.documentsErrors != null) {
                        PassportActivity.this.documentsErrors.remove(str);
                    }
                    if (PassportActivity.this.errorsValues != null) {
                        PassportActivity.this.errorsValues.remove(str);
                    }
                }
                PassportActivity passportActivity = PassportActivity.this;
                passportActivity.updateUploadText(passportActivity.uploadingFileType);
                PassportActivity.this.currentPhotoViewerLayout.removeView(secureDocumentCell);
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public String getDeleteMessageString() {
                if (PassportActivity.this.uploadingFileType == 1) {
                    return LocaleController.formatString("PassportDeleteSelfieAlert", R.string.PassportDeleteSelfieAlert, new Object[0]);
                }
                return LocaleController.formatString("PassportDeleteScanAlert", R.string.PassportDeleteScanAlert, new Object[0]);
            }
        };
        this.currentActivityType = type;
        this.currentForm = form;
        this.currentType = secureType;
        if (secureType != null) {
            this.allowNonLatinName = secureType.native_names;
        }
        this.currentTypeValue = secureValue;
        this.currentDocumentsType = secureDocumentsType;
        this.currentDocumentsTypeValue = secureDocumentsValue;
        this.currentPassword = accountPassword;
        this.currentValues = values;
        this.currentDocumentValues = documentValues;
        if (type == 3) {
            this.permissionsItems = new ArrayList<>();
        } else if (type == 7) {
            this.views = new SlideView[3];
        }
        if (this.currentValues == null) {
            this.currentValues = new HashMap<>();
        }
        if (this.currentDocumentValues == null) {
            this.currentDocumentValues = new HashMap<>();
        }
        if (type == 5) {
            if (UserConfig.getInstance(this.currentAccount).savedPasswordHash != null && UserConfig.getInstance(this.currentAccount).savedSaltedPassword != null) {
                this.usingSavedPassword = 1;
                this.savedPasswordHash = UserConfig.getInstance(this.currentAccount).savedPasswordHash;
                this.savedSaltedPassword = UserConfig.getInstance(this.currentAccount).savedSaltedPassword;
            }
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            if (tLRPC$TL_account_password == null) {
                loadPasswordInfo();
            } else {
                TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
                if (this.usingSavedPassword == 1) {
                    onPasswordDone(true);
                }
            }
            if (SharedConfig.isPassportConfigLoaded()) {
                return;
            }
            TLRPC$TL_help_getPassportConfig tLRPC$TL_help_getPassportConfig = new TLRPC$TL_help_getPassportConfig();
            tLRPC$TL_help_getPassportConfig.hash = SharedConfig.passportConfigHash;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_help_getPassportConfig, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$NjcMb-gcB6IWdF4jVUu_NooTbdo
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Y8E5wXEBsgDKOMLUGzL4VG7-VS0
                        @Override // java.lang.Runnable
                        public final void run() {
                            PassportActivity.lambda$new$0(tLObject);
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void lambda$new$0(TLObject tLObject) {
        if (tLObject instanceof TLRPC$TL_help_passportConfig) {
            TLRPC$TL_help_passportConfig tLRPC$TL_help_passportConfig = (TLRPC$TL_help_passportConfig) tLObject;
            SharedConfig.setPassportConfig(tLRPC$TL_help_passportConfig.countries_langs.data, tLRPC$TL_help_passportConfig.hash);
        } else {
            SharedConfig.getCountryLangs();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        ViewGroup[] viewGroupArr;
        super.onResume();
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.onResume();
        }
        if (this.currentActivityType == 5 && (viewGroupArr = this.inputFieldContainers) != null && viewGroupArr[0] != null && viewGroupArr[0].getVisibility() == 0) {
            this.inputFields[0].requestFocus();
            AndroidUtilities.showKeyboard(this.inputFields[0]);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$QGrzqTLSyX9b3YT0gcTHoFhxAfU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$2$PassportActivity();
                }
            }, 200L);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$2$PassportActivity() {
        ViewGroup[] viewGroupArr = this.inputFieldContainers;
        if (viewGroupArr == null || viewGroupArr[0] == null || viewGroupArr[0].getVisibility() != 0) {
            return;
        }
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.onPause();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploaded);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploadFailed);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.twoStepPasswordChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didRemoveTwoStepPassword);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploaded);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploadFailed);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.twoStepPasswordChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didRemoveTwoStepPassword);
        int i = 0;
        callCallback(false);
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.dismissInternal();
            this.chatAttachAlert.onDestroy();
        }
        if (this.currentActivityType == 7) {
            while (true) {
                SlideView[] slideViewArr = this.views;
                if (i >= slideViewArr.length) {
                    break;
                }
                if (slideViewArr[i] != null) {
                    slideViewArr[i].onDestroyActivity();
                }
                i++;
            }
            AlertDialog alertDialog = this.progressDialog;
            if (alertDialog != null) {
                try {
                    alertDialog.dismiss();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                this.progressDialog = null;
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws NoSuchFieldException, NoSuchAlgorithmException, IOException {
        ChatAttachAlert chatAttachAlert;
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass3());
        if (this.currentActivityType == 7) {
            ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.PassportActivity.4
                @Override // android.widget.ScrollView, android.view.ViewGroup
                protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
                    return false;
                }

                @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
                public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                    if (PassportActivity.this.currentViewNum == 1 || PassportActivity.this.currentViewNum == 2 || PassportActivity.this.currentViewNum == 4) {
                        rectangle.bottom += AndroidUtilities.dp(40.0f);
                    }
                    return super.requestChildRectangleOnScreen(child, rectangle, immediate);
                }

                @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    PassportActivity.this.scrollHeight = View.MeasureSpec.getSize(heightMeasureSpec) - AndroidUtilities.dp(30.0f);
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            };
            this.scrollView = scrollView;
            this.fragmentView = scrollView;
            scrollView.setFillViewport(true);
            AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor("actionBarDefault"));
        } else {
            FrameLayout frameLayout = new FrameLayout(context);
            this.fragmentView = frameLayout;
            FrameLayout frameLayout2 = frameLayout;
            frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
            ScrollView scrollView2 = new ScrollView(context) { // from class: ir.eitaa.ui.PassportActivity.5
                @Override // android.widget.ScrollView, android.view.ViewGroup
                protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
                    return false;
                }

                @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
                public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                    rectangle.offset(child.getLeft() - child.getScrollX(), child.getTop() - child.getScrollY());
                    rectangle.top += AndroidUtilities.dp(20.0f);
                    rectangle.bottom += AndroidUtilities.dp(50.0f);
                    return super.requestChildRectangleOnScreen(child, rectangle, immediate);
                }
            };
            this.scrollView = scrollView2;
            scrollView2.setFillViewport(true);
            AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor("actionBarDefault"));
            frameLayout2.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, this.currentActivityType == 0 ? 48.0f : 0.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            this.linearLayout2 = linearLayout;
            linearLayout.setOrientation(1);
            this.scrollView.addView(this.linearLayout2, new FrameLayout.LayoutParams(-1, -2));
        }
        int i = this.currentActivityType;
        if (i != 0 && i != 8) {
            this.doneItem = this.actionBar.createMenu().addItemWithWidth(2, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
            ContextProgressView contextProgressView = new ContextProgressView(context, 1);
            this.progressView = contextProgressView;
            contextProgressView.setAlpha(0.0f);
            this.progressView.setScaleX(0.1f);
            this.progressView.setScaleY(0.1f);
            this.progressView.setVisibility(4);
            this.doneItem.addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
            int i2 = this.currentActivityType;
            if ((i2 == 1 || i2 == 2) && (chatAttachAlert = this.chatAttachAlert) != null) {
                try {
                    if (chatAttachAlert.isShowing()) {
                        this.chatAttachAlert.dismiss();
                    }
                } catch (Exception unused) {
                }
                this.chatAttachAlert.onDestroy();
                this.chatAttachAlert = null;
            }
        }
        int i3 = this.currentActivityType;
        if (i3 == 5) {
            createPasswordInterface(context);
        } else if (i3 == 0) {
            createRequestInterface(context);
        } else if (i3 == 1) {
            createIdentityInterface(context);
            fillInitialValues();
        } else if (i3 == 2) {
            createAddressInterface(context);
            fillInitialValues();
        } else if (i3 == 3) {
            createPhoneInterface(context);
        } else if (i3 == 4) {
            createEmailInterface(context);
        } else if (i3 == 6) {
            createEmailVerificationInterface(context);
        } else if (i3 == 7) {
            createPhoneVerificationInterface(context);
        } else if (i3 == 8) {
            createManageInterface(context);
        }
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.PassportActivity$3, reason: invalid class name */
    class AnonymousClass3 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass3() {
        }

        private boolean onIdentityDone(final Runnable finishRunnable, final ErrorRunnable errorRunnable) throws JSONException {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            String string;
            String string2;
            String string3;
            if (!PassportActivity.this.uploadingDocuments.isEmpty() || PassportActivity.this.checkFieldsForError()) {
                return false;
            }
            if (PassportActivity.this.allowNonLatinName) {
                PassportActivity.this.allowNonLatinName = false;
                boolean z = false;
                for (final int i = 0; i < PassportActivity.this.nonLatinNames.length; i++) {
                    if (PassportActivity.this.nonLatinNames[i]) {
                        PassportActivity.this.inputFields[i].setErrorText(LocaleController.getString("PassportUseLatinOnly", R.string.PassportUseLatinOnly));
                        if (!z) {
                            if (PassportActivity.this.nonLatinNames[0]) {
                                PassportActivity passportActivity = PassportActivity.this;
                                string = passportActivity.getTranslitString(passportActivity.inputExtraFields[0].getText().toString());
                            } else {
                                string = PassportActivity.this.inputFields[0].getText().toString();
                            }
                            final String str = string;
                            if (PassportActivity.this.nonLatinNames[1]) {
                                PassportActivity passportActivity2 = PassportActivity.this;
                                string2 = passportActivity2.getTranslitString(passportActivity2.inputExtraFields[1].getText().toString());
                            } else {
                                string2 = PassportActivity.this.inputFields[1].getText().toString();
                            }
                            final String str2 = string2;
                            if (PassportActivity.this.nonLatinNames[2]) {
                                PassportActivity passportActivity3 = PassportActivity.this;
                                string3 = passportActivity3.getTranslitString(passportActivity3.inputExtraFields[2].getText().toString());
                            } else {
                                string3 = PassportActivity.this.inputFields[2].getText().toString();
                            }
                            final String str3 = string3;
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(PassportActivity.this.getParentActivity());
                                builder.setMessage(LocaleController.formatString("PassportNameCheckAlert", R.string.PassportNameCheckAlert, str, str2, str3));
                                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                                builder.setPositiveButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$3$OYFBXlLl0IMgOOTbxjDGeIqmANg
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i2) throws JSONException {
                                        this.f$0.lambda$onIdentityDone$0$PassportActivity$3(str, str2, str3, finishRunnable, errorRunnable, dialogInterface, i2);
                                    }
                                });
                                builder.setNegativeButton(LocaleController.getString("Edit", R.string.Edit), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$3$fBxfzHsld-ffhMJrPMvxJegzsbk
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        this.f$0.lambda$onIdentityDone$1$PassportActivity$3(i, dialogInterface, i2);
                                    }
                                });
                                PassportActivity.this.showDialog(builder.create());
                            } else {
                                PassportActivity passportActivity4 = PassportActivity.this;
                                passportActivity4.onFieldError(passportActivity4.inputFields[i]);
                            }
                            z = true;
                        }
                    }
                }
                if (z) {
                    return false;
                }
            }
            if (!PassportActivity.this.isHasNotAnyChanges()) {
                SecureDocument secureDocument = null;
                try {
                    if (PassportActivity.this.documentOnly) {
                        jSONObject = null;
                    } else {
                        HashMap map = new HashMap(PassportActivity.this.currentValues);
                        if (PassportActivity.this.currentType.native_names) {
                            if (PassportActivity.this.nativeInfoCell.getVisibility() == 0) {
                                map.put("first_name_native", PassportActivity.this.inputExtraFields[0].getText().toString());
                                map.put("middle_name_native", PassportActivity.this.inputExtraFields[1].getText().toString());
                                map.put("last_name_native", PassportActivity.this.inputExtraFields[2].getText().toString());
                            } else {
                                map.put("first_name_native", PassportActivity.this.inputFields[0].getText().toString());
                                map.put("middle_name_native", PassportActivity.this.inputFields[1].getText().toString());
                                map.put("last_name_native", PassportActivity.this.inputFields[2].getText().toString());
                            }
                        }
                        map.put("first_name", PassportActivity.this.inputFields[0].getText().toString());
                        map.put("middle_name", PassportActivity.this.inputFields[1].getText().toString());
                        map.put("last_name", PassportActivity.this.inputFields[2].getText().toString());
                        map.put("birth_date", PassportActivity.this.inputFields[3].getText().toString());
                        map.put("gender", PassportActivity.this.currentGender);
                        map.put("country_code", PassportActivity.this.currentCitizeship);
                        map.put("residence_country_code", PassportActivity.this.currentResidence);
                        jSONObject = new JSONObject();
                        try {
                            ArrayList arrayList = new ArrayList(map.keySet());
                            Collections.sort(arrayList, new $$Lambda$PassportActivity$3$JwIE7RA8Iitx943753DanLc4JpI(this));
                            int size = arrayList.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                String str4 = (String) arrayList.get(i2);
                                jSONObject.put(str4, map.get(str4));
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (PassportActivity.this.currentDocumentsType != null) {
                        HashMap map2 = new HashMap(PassportActivity.this.currentDocumentValues);
                        map2.put("document_no", PassportActivity.this.inputFields[7].getText().toString());
                        if (PassportActivity.this.currentExpireDate[0] != 0) {
                            map2.put("expiry_date", String.format(Locale.US, "%02d.%02d.%d", Integer.valueOf(PassportActivity.this.currentExpireDate[2]), Integer.valueOf(PassportActivity.this.currentExpireDate[1]), Integer.valueOf(PassportActivity.this.currentExpireDate[0])));
                        } else {
                            map2.put("expiry_date", "");
                        }
                        jSONObject2 = new JSONObject();
                        try {
                            ArrayList arrayList2 = new ArrayList(map2.keySet());
                            Collections.sort(arrayList2, new $$Lambda$PassportActivity$3$qyRoDzj_x_mAq6xda7FykakWTAo(this));
                            int size2 = arrayList2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                String str5 = (String) arrayList2.get(i3);
                                jSONObject2.put(str5, map2.get(str5));
                            }
                        } catch (Exception unused2) {
                        }
                    } else {
                        jSONObject2 = null;
                    }
                } catch (Exception unused3) {
                    jSONObject = null;
                    jSONObject2 = null;
                }
                if (PassportActivity.this.fieldsErrors != null) {
                    PassportActivity.this.fieldsErrors.clear();
                }
                if (PassportActivity.this.documentsErrors != null) {
                    PassportActivity.this.documentsErrors.clear();
                }
                PassportActivityDelegate passportActivityDelegate = PassportActivity.this.delegate;
                TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = PassportActivity.this.currentType;
                String string4 = jSONObject != null ? jSONObject.toString() : null;
                TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2 = PassportActivity.this.currentDocumentsType;
                String string5 = jSONObject2 != null ? jSONObject2.toString() : null;
                SecureDocument secureDocument2 = PassportActivity.this.selfieDocument;
                ArrayList<SecureDocument> arrayList3 = PassportActivity.this.translationDocuments;
                SecureDocument secureDocument3 = PassportActivity.this.frontDocument;
                if (PassportActivity.this.reverseLayout != null && PassportActivity.this.reverseLayout.getVisibility() == 0) {
                    secureDocument = PassportActivity.this.reverseDocument;
                }
                passportActivityDelegate.saveValue(tLRPC$TL_secureRequiredType, null, string4, tLRPC$TL_secureRequiredType2, string5, null, secureDocument2, arrayList3, secureDocument3, secureDocument, finishRunnable, errorRunnable);
                return true;
            }
            PassportActivity.this.finishFragment();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onIdentityDone$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onIdentityDone$0$PassportActivity$3(String str, String str2, String str3, Runnable runnable, ErrorRunnable errorRunnable, DialogInterface dialogInterface, int i) throws JSONException {
            PassportActivity.this.inputFields[0].setText(str);
            PassportActivity.this.inputFields[1].setText(str2);
            PassportActivity.this.inputFields[2].setText(str3);
            PassportActivity.this.showEditDoneProgress(true, true);
            onIdentityDone(runnable, errorRunnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onIdentityDone$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onIdentityDone$1$PassportActivity$3(int i, DialogInterface dialogInterface, int i2) {
            PassportActivity passportActivity = PassportActivity.this;
            passportActivity.onFieldError(passportActivity.inputFields[i]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onIdentityDone$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int lambda$onIdentityDone$2$PassportActivity$3(String str, String str2) {
            int fieldCost = PassportActivity.this.getFieldCost(str);
            int fieldCost2 = PassportActivity.this.getFieldCost(str2);
            if (fieldCost < fieldCost2) {
                return -1;
            }
            return fieldCost > fieldCost2 ? 1 : 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onIdentityDone$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int lambda$onIdentityDone$3$PassportActivity$3(String str, String str2) {
            int fieldCost = PassportActivity.this.getFieldCost(str);
            int fieldCost2 = PassportActivity.this.getFieldCost(str2);
            if (fieldCost < fieldCost2) {
                return -1;
            }
            return fieldCost > fieldCost2 ? 1 : 0;
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) throws JSONException {
            JSONObject jSONObject;
            String str;
            String string;
            if (id == -1) {
                if (PassportActivity.this.checkDiscard()) {
                    return;
                }
                if (PassportActivity.this.currentActivityType == 0 || PassportActivity.this.currentActivityType == 5) {
                    PassportActivity.this.callCallback(false);
                }
                PassportActivity.this.finishFragment();
                return;
            }
            if (id == 1) {
                if (PassportActivity.this.getParentActivity() == null) {
                    return;
                }
                TextView textView = new TextView(PassportActivity.this.getParentActivity());
                String string2 = LocaleController.getString("PassportInfo2", R.string.PassportInfo2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string2);
                int iIndexOf = string2.indexOf(42);
                int iLastIndexOf = string2.lastIndexOf(42);
                if (iIndexOf != -1 && iLastIndexOf != -1) {
                    spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) "");
                    spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) "");
                    spannableStringBuilder.setSpan(new URLSpanNoUnderline(LocaleController.getString("PassportInfoUrl", R.string.PassportInfoUrl)) { // from class: ir.eitaa.ui.PassportActivity.3.1
                        @Override // ir.eitaa.ui.Components.URLSpanNoUnderline, android.text.style.URLSpan, android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            PassportActivity.this.dismissCurrentDialog();
                            super.onClick(widget);
                        }
                    }, iIndexOf, iLastIndexOf - 1, 33);
                }
                textView.setText(spannableStringBuilder);
                textView.setTextSize(1, 16.0f);
                textView.setLinkTextColor(Theme.getColor("dialogTextLink"));
                textView.setHighlightColor(Theme.getColor("dialogLinkSelection"));
                textView.setPadding(AndroidUtilities.dp(23.0f), 0, AndroidUtilities.dp(23.0f), 0);
                textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                textView.setTextColor(Theme.getColor("dialogTextBlack"));
                AlertDialog.Builder builder = new AlertDialog.Builder(PassportActivity.this.getParentActivity());
                builder.setView(textView);
                builder.setTitle(LocaleController.getString("PassportInfoTitle", R.string.PassportInfoTitle));
                builder.setNegativeButton(LocaleController.getString("Close", R.string.Close), null);
                PassportActivity.this.showDialog(builder.create());
                return;
            }
            if (id == 2) {
                if (PassportActivity.this.currentActivityType == 5) {
                    PassportActivity.this.onPasswordDone(false);
                    return;
                }
                if (PassportActivity.this.currentActivityType == 7) {
                    PassportActivity.this.views[PassportActivity.this.currentViewNum].onNextPressed();
                    return;
                }
                final Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$3$-4ew3zmtX4ZLDeS_0PpErJugV9U
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onItemClick$4$PassportActivity$3();
                    }
                };
                final ErrorRunnable errorRunnable = new ErrorRunnable() { // from class: ir.eitaa.ui.PassportActivity.3.2
                    @Override // ir.eitaa.ui.PassportActivity.ErrorRunnable
                    public void onError(String error, String text) {
                        if (!"PHONE_VERIFICATION_NEEDED".equals(error)) {
                            PassportActivity.this.showEditDoneProgress(true, false);
                        } else {
                            PassportActivity passportActivity = PassportActivity.this;
                            passportActivity.startPhoneVerification(true, text, runnable, this, passportActivity.delegate);
                        }
                    }
                };
                if (PassportActivity.this.currentActivityType == 4) {
                    if (PassportActivity.this.useCurrentValue) {
                        string = PassportActivity.this.currentEmail;
                    } else if (PassportActivity.this.checkFieldsForError()) {
                        return;
                    } else {
                        string = PassportActivity.this.inputFields[0].getText().toString();
                    }
                    PassportActivity.this.delegate.saveValue(PassportActivity.this.currentType, string, null, null, null, null, null, null, null, null, runnable, errorRunnable);
                } else if (PassportActivity.this.currentActivityType == 3) {
                    if (PassportActivity.this.useCurrentValue) {
                        str = UserConfig.getInstance(((BaseFragment) PassportActivity.this).currentAccount).getCurrentUser().phone;
                    } else {
                        if (PassportActivity.this.checkFieldsForError()) {
                            return;
                        }
                        str = PassportActivity.this.inputFields[1].getText().toString() + PassportActivity.this.inputFields[2].getText().toString();
                    }
                    PassportActivity.this.delegate.saveValue(PassportActivity.this.currentType, str, null, null, null, null, null, null, null, null, runnable, errorRunnable);
                } else if (PassportActivity.this.currentActivityType == 2) {
                    if (!PassportActivity.this.uploadingDocuments.isEmpty() || PassportActivity.this.checkFieldsForError()) {
                        return;
                    }
                    if (!PassportActivity.this.isHasNotAnyChanges()) {
                        if (PassportActivity.this.documentOnly) {
                            jSONObject = null;
                        } else {
                            jSONObject = new JSONObject();
                            try {
                                jSONObject.put("street_line1", PassportActivity.this.inputFields[0].getText().toString());
                                jSONObject.put("street_line2", PassportActivity.this.inputFields[1].getText().toString());
                                jSONObject.put("post_code", PassportActivity.this.inputFields[2].getText().toString());
                                jSONObject.put("city", PassportActivity.this.inputFields[3].getText().toString());
                                jSONObject.put("state", PassportActivity.this.inputFields[4].getText().toString());
                                jSONObject.put("country_code", PassportActivity.this.currentCitizeship);
                            } catch (Exception unused) {
                            }
                        }
                        if (PassportActivity.this.fieldsErrors != null) {
                            PassportActivity.this.fieldsErrors.clear();
                        }
                        if (PassportActivity.this.documentsErrors != null) {
                            PassportActivity.this.documentsErrors.clear();
                        }
                        PassportActivity.this.delegate.saveValue(PassportActivity.this.currentType, null, jSONObject != null ? jSONObject.toString() : null, PassportActivity.this.currentDocumentsType, null, PassportActivity.this.documents, PassportActivity.this.selfieDocument, PassportActivity.this.translationDocuments, null, null, runnable, errorRunnable);
                    } else {
                        PassportActivity.this.finishFragment();
                        return;
                    }
                } else if (PassportActivity.this.currentActivityType != 1) {
                    if (PassportActivity.this.currentActivityType == 6) {
                        final TLRPC$TL_account_verifyEmail tLRPC$TL_account_verifyEmail = new TLRPC$TL_account_verifyEmail();
                        tLRPC$TL_account_verifyEmail.email = (String) PassportActivity.this.currentValues.get("email");
                        tLRPC$TL_account_verifyEmail.code = PassportActivity.this.inputFields[0].getText().toString();
                        ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_account_verifyEmail, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$3$-XO8dED-l0ZhIJfqXnaTioI6ZI4
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$onItemClick$6$PassportActivity$3(runnable, errorRunnable, tLRPC$TL_account_verifyEmail, tLObject, tLRPC$TL_error);
                            }
                        }), ((BaseFragment) PassportActivity.this).classGuid);
                    }
                } else if (!onIdentityDone(runnable, errorRunnable)) {
                    return;
                }
                PassportActivity.this.showEditDoneProgress(true, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$4$PassportActivity$3() {
            PassportActivity.this.finishFragment();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$6$PassportActivity$3(final Runnable runnable, final ErrorRunnable errorRunnable, final TLRPC$TL_account_verifyEmail tLRPC$TL_account_verifyEmail, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$3$S-OCIuQ2OdhkFnVDdlVjAWJ1-aQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$5$PassportActivity$3(tLRPC$TL_error, runnable, errorRunnable, tLRPC$TL_account_verifyEmail);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$5$PassportActivity$3(TLRPC$TL_error tLRPC$TL_error, Runnable runnable, ErrorRunnable errorRunnable, TLRPC$TL_account_verifyEmail tLRPC$TL_account_verifyEmail) {
            if (tLRPC$TL_error == null) {
                PassportActivity.this.delegate.saveValue(PassportActivity.this.currentType, (String) PassportActivity.this.currentValues.get("email"), null, null, null, null, null, null, null, null, runnable, errorRunnable);
            } else {
                AlertsCreator.processError(((BaseFragment) PassportActivity.this).currentAccount, tLRPC$TL_error, PassportActivity.this, tLRPC$TL_account_verifyEmail, new Object[0]);
                errorRunnable.onError(null, null);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean dismissDialogOnPause(Dialog dialog) {
        return dialog != this.chatAttachAlert && super.dismissDialogOnPause(dialog);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void dismissCurrentDialog() {
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null && this.visibleDialog == chatAttachAlert) {
            chatAttachAlert.getPhotoLayout().closeCamera(false);
            this.chatAttachAlert.dismissInternal();
            this.chatAttachAlert.getPhotoLayout().hideCamera(true);
            return;
        }
        super.dismissCurrentDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTranslitString(String value) {
        return LocaleController.getInstance().getTranslitString(value, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getFieldCost(String key) {
        key.hashCode();
        switch (key) {
            case "residence_country_code":
                return 26;
            case "last_name_native":
            case "last_name":
                return 22;
            case "gender":
                return 24;
            case "street_line1":
                return 29;
            case "street_line2":
                return 30;
            case "first_name":
            case "first_name_native":
                return 20;
            case "city":
                return 32;
            case "state":
                return 33;
            case "middle_name":
            case "middle_name_native":
                return 21;
            case "expiry_date":
                return 28;
            case "document_no":
                return 27;
            case "birth_date":
                return 23;
            case "country_code":
                return 25;
            case "post_code":
                return 31;
            default:
                return 100;
        }
    }

    private void createPhoneVerificationInterface(Context context) {
        this.actionBar.setTitle(LocaleController.getString("PassportPhone", R.string.PassportPhone));
        FrameLayout frameLayout = new FrameLayout(context);
        this.scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        for (int i = 0; i < 3; i++) {
            this.views[i] = new PhoneConfirmationView(context, i + 2);
            this.views[i].setVisibility(8);
            SlideView slideView = this.views[i];
            float f = 18.0f;
            float f2 = AndroidUtilities.isTablet() ? 26.0f : 18.0f;
            if (AndroidUtilities.isTablet()) {
                f = 26.0f;
            }
            frameLayout.addView(slideView, LayoutHelper.createFrame(-1, -1.0f, 51, f2, 30.0f, f, 0.0f));
        }
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.currentValues.get("phone"));
        fillNextCodeParams(bundle, this.currentPhoneVerification, false);
    }

    private void loadPasswordInfo() {
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$J7ma5HofYqsMDOerggUEuBHlqgU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$4$PassportActivity(tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$4$PassportActivity(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$ZcP2xz-os-a_KBzT7vKyigFf39U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$3$PassportActivity(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$3$PassportActivity(TLObject tLObject) {
        if (tLObject != null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            if (!TwoStepVerificationActivity.canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                return;
            }
            TwoStepVerificationActivity.initPasswordNewAlgo(this.currentPassword);
            updatePasswordInterface();
            if (this.inputFieldContainers[0].getVisibility() == 0) {
                this.inputFields[0].requestFocus();
                AndroidUtilities.showKeyboard(this.inputFields[0]);
            }
            if (this.usingSavedPassword == 1) {
                onPasswordDone(true);
            }
        }
    }

    private void createEmailVerificationInterface(Context context) {
        this.actionBar.setTitle(LocaleController.getString("PassportEmail", R.string.PassportEmail));
        this.inputFields = new EditTextBoldCursor[1];
        for (int i = 0; i < 1; i++) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.linearLayout2.addView(frameLayout, LayoutHelper.createLinear(-1, 50));
            frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.inputFields[i] = new EditTextBoldCursor(context);
            this.inputFields[i].setTag(Integer.valueOf(i));
            this.inputFields[i].setTextSize(1, 16.0f);
            this.inputFields[i].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i].setBackgroundDrawable(null);
            this.inputFields[i].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i].setCursorWidth(1.5f);
            int i2 = 3;
            this.inputFields[i].setInputType(3);
            this.inputFields[i].setImeOptions(268435462);
            this.inputFields[i].setHint(LocaleController.getString("PassportEmailCode", R.string.PassportEmailCode));
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            editTextBoldCursorArr[i].setSelection(editTextBoldCursorArr[i].length());
            this.inputFields[i].setPadding(0, 0, 0, AndroidUtilities.dp(6.0f));
            EditTextBoldCursor editTextBoldCursor = this.inputFields[i];
            if (LocaleController.isRTL) {
                i2 = 5;
            }
            editTextBoldCursor.setGravity(i2);
            frameLayout.addView(this.inputFields[i], LayoutHelper.createFrame(-1, -2.0f, 51, 21.0f, 12.0f, 21.0f, 6.0f));
            this.inputFields[i].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$rirSzYpeq6aCmEqPucRXC2ui-PE
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                    return this.f$0.lambda$createEmailVerificationInterface$5$PassportActivity(textView, i3, keyEvent);
                }
            });
            this.inputFields[i].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.6
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    if (PassportActivity.this.ignoreOnTextChange || PassportActivity.this.emailCodeLength == 0 || PassportActivity.this.inputFields[0].length() != PassportActivity.this.emailCodeLength) {
                        return;
                    }
                    PassportActivity.this.doneItem.callOnClick();
                }
            });
        }
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.bottomCell = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.bottomCell.setText(LocaleController.formatString("PassportEmailVerifyInfo", R.string.PassportEmailVerifyInfo, this.currentValues.get("email")));
        this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createEmailVerificationInterface$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createEmailVerificationInterface$5$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        this.doneItem.callOnClick();
        return true;
    }

    private void createPasswordInterface(Context context) {
        TLRPC$User currentUser;
        if (this.currentForm != null) {
            int i = 0;
            while (true) {
                if (i >= this.currentForm.users.size()) {
                    currentUser = null;
                    break;
                }
                currentUser = this.currentForm.users.get(i);
                if (currentUser.id == this.currentBotId) {
                    break;
                } else {
                    i++;
                }
            }
        } else {
            currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        }
        FrameLayout frameLayout = (FrameLayout) this.fragmentView;
        this.actionBar.setTitle(LocaleController.getString("EitaaPassport", R.string.EitaaPassport));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        frameLayout.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.passwordAvatarContainer = frameLayout2;
        this.linearLayout2.addView(frameLayout2, LayoutHelper.createLinear(-1, 100));
        BackupImageView backupImageView = new BackupImageView(context);
        backupImageView.setRoundRadius(AndroidUtilities.dp(32.0f));
        this.passwordAvatarContainer.addView(backupImageView, LayoutHelper.createFrame(64, 64.0f, 17, 0.0f, 8.0f, 0.0f, 0.0f));
        backupImageView.setForUserOrChat(currentUser, new AvatarDrawable(currentUser));
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.passwordRequestTextView = textInfoPrivacyCell;
        textInfoPrivacyCell.getTextView().setGravity(1);
        if (this.currentBotId == 0) {
            this.passwordRequestTextView.setText(LocaleController.getString("PassportSelfRequest", R.string.PassportSelfRequest));
        } else {
            this.passwordRequestTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("PassportRequest", R.string.PassportRequest, UserObject.getFirstName(currentUser))));
        }
        ((FrameLayout.LayoutParams) this.passwordRequestTextView.getTextView().getLayoutParams()).gravity = 1;
        this.linearLayout2.addView(this.passwordRequestTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 0.0f, 21.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.noPasswordImageView = imageView;
        imageView.setImageResource(R.drawable.no_password);
        this.noPasswordImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
        this.linearLayout2.addView(this.noPasswordImageView, LayoutHelper.createLinear(-2, -2, 49, 0, 13, 0, 0));
        TextView textView = new TextView(context);
        this.noPasswordTextView = textView;
        textView.setTextSize(1, 14.0f);
        this.noPasswordTextView.setGravity(1);
        this.noPasswordTextView.setPadding(AndroidUtilities.dp(21.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(21.0f), AndroidUtilities.dp(17.0f));
        this.noPasswordTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
        this.noPasswordTextView.setText(LocaleController.getString("EitaaPassportCreatePasswordInfo", R.string.EitaaPassportCreatePasswordInfo));
        this.linearLayout2.addView(this.noPasswordTextView, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 10.0f, 21.0f, 0.0f));
        TextView textView2 = new TextView(context);
        this.noPasswordSetTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText5"));
        this.noPasswordSetTextView.setGravity(17);
        this.noPasswordSetTextView.setTextSize(1, 16.0f);
        this.noPasswordSetTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.noPasswordSetTextView.setText(LocaleController.getString("EitaaPassportCreatePassword", R.string.EitaaPassportCreatePassword));
        this.linearLayout2.addView(this.noPasswordSetTextView, LayoutHelper.createFrame(-1, 24.0f, (LocaleController.isRTL ? 5 : 3) | 48, 21.0f, 9.0f, 21.0f, 0.0f));
        this.noPasswordSetTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Fw5Ok27T7e0OMJMqwlR6o01WSWc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createPasswordInterface$6$PassportActivity(view);
            }
        });
        this.inputFields = new EditTextBoldCursor[1];
        this.inputFieldContainers = new ViewGroup[1];
        for (int i2 = 0; i2 < 1; i2++) {
            this.inputFieldContainers[i2] = new FrameLayout(context);
            this.linearLayout2.addView(this.inputFieldContainers[i2], LayoutHelper.createLinear(-1, 50));
            this.inputFieldContainers[i2].setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.inputFields[i2] = new EditTextBoldCursor(context);
            this.inputFields[i2].setTag(Integer.valueOf(i2));
            this.inputFields[i2].setTextSize(1, 16.0f);
            this.inputFields[i2].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i2].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setBackgroundDrawable(null);
            this.inputFields[i2].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i2].setCursorWidth(1.5f);
            this.inputFields[i2].setInputType(129);
            this.inputFields[i2].setMaxLines(1);
            this.inputFields[i2].setLines(1);
            this.inputFields[i2].setSingleLine(true);
            this.inputFields[i2].setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.inputFields[i2].setTypeface(Typeface.DEFAULT);
            this.inputFields[i2].setImeOptions(268435462);
            this.inputFields[i2].setPadding(0, 0, 0, AndroidUtilities.dp(6.0f));
            this.inputFields[i2].setGravity(LocaleController.isRTL ? 5 : 3);
            this.inputFieldContainers[i2].addView(this.inputFields[i2], LayoutHelper.createFrame(-1, -2.0f, 51, 21.0f, 12.0f, 21.0f, 6.0f));
            this.inputFields[i2].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$x3ELdK0L7Gnu01w5rbXJ3mNjdfU
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                    return this.f$0.lambda$createPasswordInterface$7$PassportActivity(textView3, i3, keyEvent);
                }
            });
            this.inputFields[i2].setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.PassportActivity.7
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(ActionMode mode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
            });
        }
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.passwordInfoRequestTextView = textInfoPrivacyCell2;
        textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.passwordInfoRequestTextView.setText(LocaleController.formatString("PassportRequestPasswordInfo", R.string.PassportRequestPasswordInfo, new Object[0]));
        this.linearLayout2.addView(this.passwordInfoRequestTextView, LayoutHelper.createLinear(-1, -2));
        TextView textView3 = new TextView(context);
        this.passwordForgotButton = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        this.passwordForgotButton.setTextSize(1, 14.0f);
        this.passwordForgotButton.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
        this.passwordForgotButton.setPadding(0, 0, 0, 0);
        this.linearLayout2.addView(this.passwordForgotButton, LayoutHelper.createLinear(-2, 30, (LocaleController.isRTL ? 5 : 3) | 48, 21, 0, 21, 0));
        this.passwordForgotButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$DtF19VqJTojLJ3YQgPbcHczx0N4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createPasswordInterface$12$PassportActivity(view);
            }
        });
        updatePasswordInterface();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$6$PassportActivity(View view) {
        TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 0, this.currentPassword);
        twoStepVerificationSetupActivity.setCloseAfterSet(true);
        presentFragment(twoStepVerificationSetupActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createPasswordInterface$7$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        this.doneItem.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$12$PassportActivity(View view) {
        if (this.currentPassword.has_recovery) {
            needShowProgress();
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_auth_requestPasswordRecovery(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$K66XddJdf2UKtkWSfAWmJOLtgpc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createPasswordInterface$10$PassportActivity(tLObject, tLRPC$TL_error);
                }
            }, 10), this.classGuid);
            return;
        }
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setNegativeButton(LocaleController.getString("RestorePasswordResetAccount", R.string.RestorePasswordResetAccount), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$BiyPsN5opmuEK_zRxiQ08drmhrc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createPasswordInterface$11$PassportActivity(dialogInterface, i);
            }
        });
        builder.setTitle(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle));
        builder.setMessage(LocaleController.getString("RestorePasswordNoEmailText", R.string.RestorePasswordNoEmailText));
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$10$PassportActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$m8mOBQhxJfwd4okhM-LO3rmv2Bw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createPasswordInterface$9$PassportActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$9$PassportActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        String pluralString;
        needHideProgress();
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = (TLRPC$TL_auth_passwordRecovery) tLObject;
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setMessage(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, tLRPC$TL_auth_passwordRecovery.email_pattern));
            builder.setTitle(LocaleController.getString("RestoreEmailSentTitle", R.string.RestoreEmailSentTitle));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$pArfDw1YRTN082fQjiGiGWJ1DTg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$createPasswordInterface$8$PassportActivity(tLRPC$TL_auth_passwordRecovery, dialogInterface, i);
                }
            });
            Dialog dialogShowDialog = showDialog(builder.create());
            if (dialogShowDialog != null) {
                dialogShowDialog.setCanceledOnTouchOutside(false);
                dialogShowDialog.setCancelable(false);
                return;
            }
            return;
        }
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
            return;
        }
        showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$8$PassportActivity(TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery, DialogInterface dialogInterface, int i) {
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        tLRPC$TL_account_password.email_unconfirmed_pattern = tLRPC$TL_auth_passwordRecovery.email_pattern;
        presentFragment(new TwoStepVerificationSetupActivity(this.currentAccount, 4, tLRPC$TL_account_password));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPasswordInterface$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPasswordInterface$11$PassportActivity(DialogInterface dialogInterface, int i) {
        Browser.openUrl(getParentActivity(), "http://my.eitaa.org/?phone=" + UserConfig.getInstance(this.currentAccount).getClientPhone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPasswordDone(final boolean saved) {
        final String string;
        if (saved) {
            string = null;
        } else {
            string = this.inputFields[0].getText().toString();
            if (TextUtils.isEmpty(string)) {
                onPasscodeError(false);
                return;
            }
            showEditDoneProgress(true, true);
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$mVejk4pt6XmqHJBFxiw8c4WlEQc
            @Override // java.lang.Runnable
            public final void run() throws NoSuchAlgorithmException {
                this.f$0.lambda$onPasswordDone$13$PassportActivity(saved, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* renamed from: lambda$onPasswordDone$13, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$onPasswordDone$13$PassportActivity(boolean r11, java.lang.String r12) throws java.security.NoSuchAlgorithmException {
        /*
            r10 = this;
            ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings r6 = new ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings
            r6.<init>()
            r7 = 0
            if (r11 == 0) goto Lc
            byte[] r0 = r10.savedPasswordHash
        La:
            r8 = r0
            goto L24
        Lc:
            ir.eitaa.tgnet.TLRPC$TL_account_password r0 = r10.currentPassword
            ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo r0 = r0.current_algo
            boolean r0 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow
            if (r0 == 0) goto L23
            byte[] r0 = ir.eitaa.messenger.AndroidUtilities.getStringBytes(r12)
            ir.eitaa.tgnet.TLRPC$TL_account_password r1 = r10.currentPassword
            ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo r1 = r1.current_algo
            ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow r1 = (ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) r1
            byte[] r0 = ir.eitaa.messenger.SRPHelper.getX(r0, r1)
            goto La
        L23:
            r8 = r7
        L24:
            ir.eitaa.ui.PassportActivity$8 r9 = new ir.eitaa.ui.PassportActivity$8
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r8
            r4 = r6
            r5 = r12
            r0.<init>(r2, r3, r4, r5)
            ir.eitaa.tgnet.TLRPC$TL_account_password r11 = r10.currentPassword
            ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo r12 = r11.current_algo
            boolean r0 = r12 instanceof ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow
            if (r0 == 0) goto L6a
            ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow r12 = (ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) r12
            long r0 = r11.srp_id
            byte[] r11 = r11.srp_B
            ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordSRP r11 = ir.eitaa.messenger.SRPHelper.startCheck(r8, r0, r11, r12)
            r6.password = r11
            if (r11 != 0) goto L52
            ir.eitaa.tgnet.TLRPC$TL_error r11 = new ir.eitaa.tgnet.TLRPC$TL_error
            r11.<init>()
            java.lang.String r12 = "ALGO_INVALID"
            r11.text = r12
            r9.run(r7, r11)
            return
        L52:
            int r11 = r10.currentAccount
            ir.eitaa.tgnet.ConnectionsManager r11 = ir.eitaa.tgnet.ConnectionsManager.getInstance(r11)
            r12 = 10
            int r11 = r11.sendRequest(r6, r9, r12)
            int r12 = r10.currentAccount
            ir.eitaa.tgnet.ConnectionsManager r12 = ir.eitaa.tgnet.ConnectionsManager.getInstance(r12)
            int r0 = r10.classGuid
            r12.bindRequestToGuid(r11, r0)
            goto L76
        L6a:
            ir.eitaa.tgnet.TLRPC$TL_error r11 = new ir.eitaa.tgnet.TLRPC$TL_error
            r11.<init>()
            java.lang.String r12 = "PASSWORD_HASH_INVALID"
            r11.text = r12
            r9.run(r7, r11)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.lambda$onPasswordDone$13$PassportActivity(boolean, java.lang.String):void");
    }

    /* renamed from: ir.eitaa.ui.PassportActivity$8, reason: invalid class name */
    class AnonymousClass8 implements RequestDelegate {
        final /* synthetic */ TLRPC$TL_account_getPasswordSettings val$req;
        final /* synthetic */ boolean val$saved;
        final /* synthetic */ String val$textPassword;
        final /* synthetic */ byte[] val$x_bytes;

        AnonymousClass8(final boolean val$saved, final byte[] val$x_bytes, final TLRPC$TL_account_getPasswordSettings val$req, final String val$textPassword) {
            this.val$saved = val$saved;
            this.val$x_bytes = val$x_bytes;
            this.val$req = val$req;
            this.val$textPassword = val$textPassword;
        }

        private void openRequestInterface() {
            if (PassportActivity.this.inputFields == null) {
                return;
            }
            if (!this.val$saved) {
                UserConfig.getInstance(((BaseFragment) PassportActivity.this).currentAccount).savePassword(this.val$x_bytes, PassportActivity.this.saltedPassword);
            }
            AndroidUtilities.hideKeyboard(PassportActivity.this.inputFields[0]);
            PassportActivity.this.ignoreOnFailure = true;
            PassportActivity passportActivity = new PassportActivity(PassportActivity.this.currentBotId == 0 ? 8 : 0, PassportActivity.this.currentBotId, PassportActivity.this.currentScope, PassportActivity.this.currentPublicKey, PassportActivity.this.currentPayload, PassportActivity.this.currentNonce, PassportActivity.this.currentCallbackUrl, PassportActivity.this.currentForm, PassportActivity.this.currentPassword);
            passportActivity.currentEmail = PassportActivity.this.currentEmail;
            ((BaseFragment) passportActivity).currentAccount = ((BaseFragment) PassportActivity.this).currentAccount;
            passportActivity.saltedPassword = PassportActivity.this.saltedPassword;
            passportActivity.secureSecret = PassportActivity.this.secureSecret;
            passportActivity.secureSecretId = PassportActivity.this.secureSecretId;
            passportActivity.needActivityResult = PassportActivity.this.needActivityResult;
            if (((BaseFragment) PassportActivity.this).parentLayout != null && ((BaseFragment) PassportActivity.this).parentLayout.checkTransitionAnimation()) {
                PassportActivity.this.presentAfterAnimation = passportActivity;
            } else {
                PassportActivity.this.presentFragment(passportActivity, true);
            }
        }

        private void resetSecret() {
            TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
            if (PassportActivity.this.currentPassword.current_algo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                tLRPC$TL_account_updatePasswordSettings.password = SRPHelper.startCheck(this.val$x_bytes, PassportActivity.this.currentPassword.srp_id, PassportActivity.this.currentPassword.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) PassportActivity.this.currentPassword.current_algo);
            }
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
            tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_account_passwordInputSettings.new_secure_settings = new TLRPC$TL_secureSecretSettings();
            TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings;
            tLRPC$TL_secureSecretSettings.secure_secret = new byte[0];
            tLRPC$TL_secureSecretSettings.secure_algo = new TLRPC$TL_securePasswordKdfAlgoUnknown();
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings2 = tLRPC$TL_account_updatePasswordSettings.new_settings;
            tLRPC$TL_account_passwordInputSettings2.new_secure_settings.secure_secret_id = 0L;
            tLRPC$TL_account_passwordInputSettings2.flags |= 4;
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(this.val$req, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$pMDLJ6_j3qUDb2rZvA8Gub_MlD8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$resetSecret$3$PassportActivity$8(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resetSecret$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resetSecret$3$PassportActivity$8(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$j7NLBq4xgb65zpG2RoBl6I4GzEs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resetSecret$2$PassportActivity$8(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resetSecret$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resetSecret$2$PassportActivity$8(TLRPC$TL_error tLRPC$TL_error) {
            if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
                ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$V8Rd7fkrDOiDm5yrY64SW6U3VlA
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error2) {
                        this.f$0.lambda$resetSecret$1$PassportActivity$8(tLObject, tLRPC$TL_error2);
                    }
                }, 8);
            } else {
                generateNewSecret();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resetSecret$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resetSecret$1$PassportActivity$8(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$1n_qYPyqk9zpbRo3wEtKFDWdij0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resetSecret$0$PassportActivity$8(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resetSecret$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resetSecret$0$PassportActivity$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            if (tLRPC$TL_error == null) {
                PassportActivity.this.currentPassword = (TLRPC$TL_account_password) tLObject;
                TwoStepVerificationActivity.initPasswordNewAlgo(PassportActivity.this.currentPassword);
                resetSecret();
            }
        }

        private void generateNewSecret() {
            DispatchQueue dispatchQueue = Utilities.globalQueue;
            final byte[] bArr = this.val$x_bytes;
            final String str = this.val$textPassword;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$Ilyv3Gcg0_WOxlFbuUJ2jVNBEgU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$generateNewSecret$8$PassportActivity$8(bArr, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$generateNewSecret$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$generateNewSecret$8$PassportActivity$8(byte[] bArr, String str) {
            Utilities.random.setSeed(PassportActivity.this.currentPassword.secure_random);
            TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
            if (PassportActivity.this.currentPassword.current_algo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                tLRPC$TL_account_updatePasswordSettings.password = SRPHelper.startCheck(bArr, PassportActivity.this.currentPassword.srp_id, PassportActivity.this.currentPassword.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) PassportActivity.this.currentPassword.current_algo);
            }
            tLRPC$TL_account_updatePasswordSettings.new_settings = new TLRPC$TL_account_passwordInputSettings();
            PassportActivity passportActivity = PassportActivity.this;
            passportActivity.secureSecret = passportActivity.getRandomSecret();
            PassportActivity passportActivity2 = PassportActivity.this;
            passportActivity2.secureSecretId = Utilities.bytesToLong(Utilities.computeSHA256(passportActivity2.secureSecret));
            if (PassportActivity.this.currentPassword.new_secure_algo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) PassportActivity.this.currentPassword.new_secure_algo;
                PassportActivity.this.saltedPassword = Utilities.computePBKDF2(AndroidUtilities.getStringBytes(str), tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt);
                byte[] bArr2 = new byte[32];
                System.arraycopy(PassportActivity.this.saltedPassword, 0, bArr2, 0, 32);
                byte[] bArr3 = new byte[16];
                System.arraycopy(PassportActivity.this.saltedPassword, 32, bArr3, 0, 16);
                Utilities.aesCbcEncryptionByteArraySafe(PassportActivity.this.secureSecret, bArr2, bArr3, 0, PassportActivity.this.secureSecret.length, 0, 1);
                tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings = new TLRPC$TL_secureSecretSettings();
                TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings;
                tLRPC$TL_secureSecretSettings.secure_algo = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
                tLRPC$TL_secureSecretSettings.secure_secret = PassportActivity.this.secureSecret;
                tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings.secure_secret_id = PassportActivity.this.secureSecretId;
                tLRPC$TL_account_updatePasswordSettings.new_settings.flags |= 4;
            }
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$wAIxy8-LpGjVO6fqOkeJ4jBE9Ik
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$generateNewSecret$7$PassportActivity$8(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$generateNewSecret$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$generateNewSecret$7$PassportActivity$8(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$f6zrR31ht6athq-4l8IGcI84hKk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$generateNewSecret$6$PassportActivity$8(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$generateNewSecret$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$generateNewSecret$6$PassportActivity$8(TLRPC$TL_error tLRPC$TL_error) {
            if (tLRPC$TL_error == null || !"SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
                if (PassportActivity.this.currentForm == null) {
                    PassportActivity.this.currentForm = new TLRPC$TL_account_authorizationForm();
                }
                openRequestInterface();
                return;
            }
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$4A-S2lgG1NvzffoIQ0TMLCjbStw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$generateNewSecret$5$PassportActivity$8(tLObject, tLRPC$TL_error2);
                }
            }, 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$generateNewSecret$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$generateNewSecret$5$PassportActivity$8(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$qZ194EkMkdX9OA2EUVL2Z6VUvwQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$generateNewSecret$4$PassportActivity$8(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$generateNewSecret$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$generateNewSecret$4$PassportActivity$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            if (tLRPC$TL_error == null) {
                PassportActivity.this.currentPassword = (TLRPC$TL_account_password) tLObject;
                TwoStepVerificationActivity.initPasswordNewAlgo(PassportActivity.this.currentPassword);
                generateNewSecret();
            }
        }

        @Override // ir.eitaa.tgnet.RequestDelegate
        public void run(final TLObject response, final TLRPC$TL_error error) {
            if (error != null && "SRP_ID_INVALID".equals(error.text)) {
                TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword = new TLRPC$TL_account_getPassword();
                ConnectionsManager connectionsManager = ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount);
                final boolean z = this.val$saved;
                connectionsManager.sendRequest(tLRPC$TL_account_getPassword, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$mwlPpowhwZJ4n6G8LhUKOwEHtQo
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$run$10$PassportActivity$8(z, tLObject, tLRPC$TL_error);
                    }
                }, 8);
                return;
            }
            if (error == null) {
                DispatchQueue dispatchQueue = Utilities.globalQueue;
                final String str = this.val$textPassword;
                final boolean z2 = this.val$saved;
                dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$4_2JURdhNgp2GR-4g3jnuMvBYY0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$15$PassportActivity$8(response, str, z2);
                    }
                });
                return;
            }
            final boolean z3 = this.val$saved;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$0H6zCdi04iu8y7HLwlBfJCW14TI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$16$PassportActivity$8(z3, error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$10$PassportActivity$8(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$c-PNoRRKB8coN-pEUx58Ylx9bys
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$9$PassportActivity$8(tLRPC$TL_error, tLObject, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$9$PassportActivity$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
            if (tLRPC$TL_error == null) {
                PassportActivity.this.currentPassword = (TLRPC$TL_account_password) tLObject;
                TwoStepVerificationActivity.initPasswordNewAlgo(PassportActivity.this.currentPassword);
                PassportActivity.this.onPasswordDone(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$15, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$15$PassportActivity$8(TLObject tLObject, String str, final boolean z) {
            final byte[] bArr;
            final TLRPC$TL_account_passwordSettings tLRPC$TL_account_passwordSettings = (TLRPC$TL_account_passwordSettings) tLObject;
            TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = tLRPC$TL_account_passwordSettings.secure_settings;
            if (tLRPC$TL_secureSecretSettings == null) {
                if (PassportActivity.this.currentPassword.new_secure_algo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                    TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) PassportActivity.this.currentPassword.new_secure_algo;
                    byte[] bArr2 = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt;
                    PassportActivity.this.saltedPassword = Utilities.computePBKDF2(AndroidUtilities.getStringBytes(str), tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt);
                    bArr = bArr2;
                } else {
                    bArr = new byte[0];
                }
                PassportActivity.this.secureSecret = null;
                PassportActivity.this.secureSecretId = 0L;
            } else {
                PassportActivity.this.secureSecret = tLRPC$TL_secureSecretSettings.secure_secret;
                PassportActivity.this.secureSecretId = tLRPC$TL_account_passwordSettings.secure_settings.secure_secret_id;
                TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = tLRPC$TL_account_passwordSettings.secure_settings.secure_algo;
                if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoSHA512) {
                    bArr = ((TLRPC$TL_securePasswordKdfAlgoSHA512) tLRPC$SecurePasswordKdfAlgo).salt;
                    PassportActivity.this.saltedPassword = Utilities.computeSHA512(bArr, AndroidUtilities.getStringBytes(str), bArr);
                } else if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                    TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter1000002 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) tLRPC$SecurePasswordKdfAlgo;
                    byte[] bArr3 = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter1000002.salt;
                    PassportActivity.this.saltedPassword = Utilities.computePBKDF2(AndroidUtilities.getStringBytes(str), tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter1000002.salt);
                    bArr = bArr3;
                } else {
                    if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoUnknown) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$b8nld0MmP4ch7mpOKQRvJ3YbHTc
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$11$PassportActivity$8();
                            }
                        });
                        return;
                    }
                    bArr = new byte[0];
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$N3ynIRv8HuelMjU1nLEVfvvwSCI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$14$PassportActivity$8(tLRPC$TL_account_passwordSettings, z, bArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$11$PassportActivity$8() {
            AlertsCreator.showUpdateAppAlert(PassportActivity.this.getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$14, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$14$PassportActivity$8(TLRPC$TL_account_passwordSettings tLRPC$TL_account_passwordSettings, boolean z, byte[] bArr) {
            PassportActivity.this.currentEmail = tLRPC$TL_account_passwordSettings.email;
            if (z) {
                PassportActivity passportActivity = PassportActivity.this;
                passportActivity.saltedPassword = passportActivity.savedSaltedPassword;
            }
            PassportActivity passportActivity2 = PassportActivity.this;
            if (PassportActivity.checkSecret(passportActivity2.decryptSecret(passportActivity2.secureSecret, PassportActivity.this.saltedPassword), Long.valueOf(PassportActivity.this.secureSecretId)) && bArr.length != 0 && PassportActivity.this.secureSecretId != 0) {
                if (PassportActivity.this.currentBotId == 0) {
                    ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_getAllSecureValues
                        public static int constructor = -1299661699;

                        @Override // ir.eitaa.tgnet.TLObject
                        public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                            TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
                            int int32 = stream.readInt32(exception);
                            for (int i = 0; i < int32; i++) {
                                TLRPC$TL_secureValue tLRPC$TL_secureValueTLdeserialize = TLRPC$TL_secureValue.TLdeserialize(stream, stream.readInt32(exception), exception);
                                if (tLRPC$TL_secureValueTLdeserialize == null) {
                                    return tLRPC$Vector;
                                }
                                tLRPC$Vector.objects.add(tLRPC$TL_secureValueTLdeserialize);
                            }
                            return tLRPC$Vector;
                        }

                        @Override // ir.eitaa.tgnet.TLObject
                        public void serializeToStream(AbstractSerializedData stream) {
                            stream.writeInt32(constructor);
                        }
                    }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$flkFec1RsFmCKfy0UA2uPmDPgEo
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$run$13$PassportActivity$8(tLObject, tLRPC$TL_error);
                        }
                    });
                    return;
                } else {
                    openRequestInterface();
                    return;
                }
            }
            if (z) {
                UserConfig.getInstance(((BaseFragment) PassportActivity.this).currentAccount).resetSavedPassword();
                PassportActivity.this.usingSavedPassword = 0;
                PassportActivity.this.updatePasswordInterface();
                return;
            }
            if (PassportActivity.this.currentForm != null) {
                PassportActivity.this.currentForm.values.clear();
                PassportActivity.this.currentForm.errors.clear();
            }
            if (PassportActivity.this.secureSecret == null || PassportActivity.this.secureSecret.length == 0) {
                generateNewSecret();
            } else {
                resetSecret();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$13, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$13$PassportActivity$8(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8$0UKlAZEOZKktu4p1g4n90qYGg_0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$12$PassportActivity$8(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$12$PassportActivity$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                PassportActivity.this.currentForm = new TLRPC$TL_account_authorizationForm();
                TLRPC$Vector tLRPC$Vector = (TLRPC$Vector) tLObject;
                int size = tLRPC$Vector.objects.size();
                for (int i = 0; i < size; i++) {
                    PassportActivity.this.currentForm.values.add((TLRPC$TL_secureValue) tLRPC$Vector.objects.get(i));
                }
                openRequestInterface();
                return;
            }
            if (!"APP_VERSION_OUTDATED".equals(tLRPC$TL_error.text)) {
                PassportActivity.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
            } else {
                AlertsCreator.showUpdateAppAlert(PassportActivity.this.getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
            }
            PassportActivity.this.showEditDoneProgress(true, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$16, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$16$PassportActivity$8(boolean z, TLRPC$TL_error tLRPC$TL_error) {
            String pluralString;
            if (z) {
                UserConfig.getInstance(((BaseFragment) PassportActivity.this).currentAccount).resetSavedPassword();
                PassportActivity.this.usingSavedPassword = 0;
                PassportActivity.this.updatePasswordInterface();
                if (PassportActivity.this.inputFieldContainers == null || PassportActivity.this.inputFieldContainers[0].getVisibility() != 0) {
                    return;
                }
                PassportActivity.this.inputFields[0].requestFocus();
                AndroidUtilities.showKeyboard(PassportActivity.this.inputFields[0]);
                return;
            }
            PassportActivity.this.showEditDoneProgress(true, false);
            if (tLRPC$TL_error.text.equals("PASSWORD_HASH_INVALID")) {
                PassportActivity.this.onPasscodeError(true);
                return;
            }
            if (!tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                PassportActivity.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            PassportActivity.this.showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
        }
    }

    private boolean isPersonalDocument(TLRPC$SecureValueType type) {
        return (type instanceof TLRPC$TL_secureValueTypeDriverLicense) || (type instanceof TLRPC$TL_secureValueTypePassport) || (type instanceof TLRPC$TL_secureValueTypeInternalPassport) || (type instanceof TLRPC$TL_secureValueTypeIdentityCard);
    }

    private boolean isAddressDocument(TLRPC$SecureValueType type) {
        return (type instanceof TLRPC$TL_secureValueTypeUtilityBill) || (type instanceof TLRPC$TL_secureValueTypeBankStatement) || (type instanceof TLRPC$TL_secureValueTypePassportRegistration) || (type instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) || (type instanceof TLRPC$TL_secureValueTypeRentalAgreement);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0158 A[PHI: r1 r2 r8 r16
      0x0158: PHI (r1v59 boolean) = 
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v35 boolean)
      (r1v60 boolean)
      (r1v35 boolean)
     binds: [B:35:0x015e, B:37:0x0168, B:40:0x0175, B:53:0x01ae, B:51:0x01a5, B:31:0x0154, B:32:0x0156, B:29:0x0150, B:26:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r2v42 int) = (r2v21 int), (r2v21 int), (r2v21 int), (r2v21 int), (r2v43 int), (r2v21 int), (r2v21 int), (r2v21 int), (r2v21 int) binds: [B:35:0x015e, B:37:0x0168, B:40:0x0175, B:53:0x01ae, B:51:0x01a5, B:31:0x0154, B:32:0x0156, B:29:0x0150, B:26:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r8v7 int) = (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v1 int), (r8v8 int) binds: [B:35:0x015e, B:37:0x0168, B:40:0x0175, B:53:0x01ae, B:51:0x01a5, B:31:0x0154, B:32:0x0156, B:29:0x0150, B:26:0x0144] A[DONT_GENERATE, DONT_INLINE]
      0x0158: PHI (r16v8 boolean) = 
      (r16v2 boolean)
      (r16v2 boolean)
      (r16v2 boolean)
      (r16v2 boolean)
      (r16v2 boolean)
      (r16v2 boolean)
      (r16v9 boolean)
      (r16v2 boolean)
      (r16v2 boolean)
     binds: [B:35:0x015e, B:37:0x0168, B:40:0x0175, B:53:0x01ae, B:51:0x01a5, B:31:0x0154, B:32:0x0156, B:29:0x0150, B:26:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createRequestInterface(android.content.Context r24) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.createRequestInterface(android.content.Context):void");
    }

    /* renamed from: ir.eitaa.ui.PassportActivity$1ValueToSend, reason: invalid class name */
    class C1ValueToSend {
        boolean selfie_required;
        boolean translation_required;
        TLRPC$TL_secureValue value;

        public C1ValueToSend(TLRPC$TL_secureValue v, boolean s, boolean t) {
            this.value = v;
            this.selfie_required = s;
            this.translation_required = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createRequestInterface$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createRequestInterface$16$PassportActivity(View view) throws JSONException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        ArrayList arrayList;
        int i;
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType;
        ArrayList arrayList2 = new ArrayList();
        int size = this.currentForm.required_types.size();
        for (int i2 = 0; i2 < size; i2++) {
            TLRPC$SecureRequiredType tLRPC$SecureRequiredType = this.currentForm.required_types.get(i2);
            if (tLRPC$SecureRequiredType instanceof TLRPC$TL_secureRequiredType) {
                tLRPC$TL_secureRequiredType = (TLRPC$TL_secureRequiredType) tLRPC$SecureRequiredType;
            } else {
                if (tLRPC$SecureRequiredType instanceof TLRPC$TL_secureRequiredTypeOneOf) {
                    TLRPC$TL_secureRequiredTypeOneOf tLRPC$TL_secureRequiredTypeOneOf = (TLRPC$TL_secureRequiredTypeOneOf) tLRPC$SecureRequiredType;
                    if (!tLRPC$TL_secureRequiredTypeOneOf.types.isEmpty()) {
                        TLRPC$SecureRequiredType tLRPC$SecureRequiredType2 = tLRPC$TL_secureRequiredTypeOneOf.types.get(0);
                        if (tLRPC$SecureRequiredType2 instanceof TLRPC$TL_secureRequiredType) {
                            TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2 = (TLRPC$TL_secureRequiredType) tLRPC$SecureRequiredType2;
                            int size2 = tLRPC$TL_secureRequiredTypeOneOf.types.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    tLRPC$TL_secureRequiredType = tLRPC$TL_secureRequiredType2;
                                    break;
                                }
                                TLRPC$SecureRequiredType tLRPC$SecureRequiredType3 = tLRPC$TL_secureRequiredTypeOneOf.types.get(i3);
                                if (tLRPC$SecureRequiredType3 instanceof TLRPC$TL_secureRequiredType) {
                                    TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType3 = (TLRPC$TL_secureRequiredType) tLRPC$SecureRequiredType3;
                                    if (getValueByType(tLRPC$TL_secureRequiredType3, true) != null) {
                                        tLRPC$TL_secureRequiredType = tLRPC$TL_secureRequiredType3;
                                        break;
                                    }
                                }
                                i3++;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            TLRPC$TL_secureValue valueByType = getValueByType(tLRPC$TL_secureRequiredType, true);
            if (valueByType == null) {
                Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(200L);
                }
                AndroidUtilities.shakeView(getViewByType(tLRPC$TL_secureRequiredType), 2.0f, 0);
                return;
            }
            HashMap<String, String> map = this.errorsMap.get(getNameForType(tLRPC$TL_secureRequiredType.type));
            if (map != null && !map.isEmpty()) {
                Vibrator vibrator2 = (Vibrator) getParentActivity().getSystemService("vibrator");
                if (vibrator2 != null) {
                    vibrator2.vibrate(200L);
                }
                AndroidUtilities.shakeView(getViewByType(tLRPC$TL_secureRequiredType), 2.0f, 0);
                return;
            }
            arrayList2.add(new C1ValueToSend(valueByType, tLRPC$TL_secureRequiredType.selfie_required, tLRPC$TL_secureRequiredType.translation_required));
        }
        showEditDoneProgress(false, true);
        TLRPC$TL_account_acceptAuthorization tLRPC$TL_account_acceptAuthorization = new TLRPC$TL_account_acceptAuthorization();
        tLRPC$TL_account_acceptAuthorization.bot_id = this.currentBotId;
        tLRPC$TL_account_acceptAuthorization.scope = this.currentScope;
        tLRPC$TL_account_acceptAuthorization.public_key = this.currentPublicKey;
        JSONObject jSONObject = new JSONObject();
        int size3 = arrayList2.size();
        int i4 = 0;
        while (i4 < size3) {
            C1ValueToSend c1ValueToSend = (C1ValueToSend) arrayList2.get(i4);
            TLRPC$TL_secureValue tLRPC$TL_secureValue = c1ValueToSend.value;
            JSONObject jSONObject2 = new JSONObject();
            TLRPC$SecurePlainData tLRPC$SecurePlainData = tLRPC$TL_secureValue.plain_data;
            if (tLRPC$SecurePlainData != null) {
                if (tLRPC$SecurePlainData instanceof TLRPC$TL_securePlainEmail) {
                } else if (tLRPC$SecurePlainData instanceof TLRPC$TL_securePlainPhone) {
                }
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    TLRPC$TL_secureData tLRPC$TL_secureData = tLRPC$TL_secureValue.data;
                    if (tLRPC$TL_secureData != null) {
                        byte[] bArrDecryptValueSecret = decryptValueSecret(tLRPC$TL_secureData.secret, tLRPC$TL_secureData.data_hash);
                        jSONObject2.put("data_hash", Base64.encodeToString(tLRPC$TL_secureValue.data.data_hash, 2));
                        jSONObject2.put("secret", Base64.encodeToString(bArrDecryptValueSecret, 2));
                        jSONObject3.put("data", jSONObject2);
                    }
                    if (tLRPC$TL_secureValue.files.isEmpty()) {
                        arrayList = arrayList2;
                        i = size3;
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        int i5 = 0;
                        for (int size4 = tLRPC$TL_secureValue.files.size(); i5 < size4; size4 = size4) {
                            TLRPC$TL_secureFile tLRPC$TL_secureFile = (TLRPC$TL_secureFile) tLRPC$TL_secureValue.files.get(i5);
                            arrayList = arrayList2;
                            try {
                                i = size3;
                                try {
                                    byte[] bArrDecryptValueSecret2 = decryptValueSecret(tLRPC$TL_secureFile.secret, tLRPC$TL_secureFile.file_hash);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("file_hash", Base64.encodeToString(tLRPC$TL_secureFile.file_hash, 2));
                                    jSONObject4.put("secret", Base64.encodeToString(bArrDecryptValueSecret2, 2));
                                    jSONArray.put(jSONObject4);
                                    i5++;
                                    arrayList2 = arrayList;
                                    size3 = i;
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                            }
                        }
                        arrayList = arrayList2;
                        i = size3;
                        jSONObject3.put("files", jSONArray);
                    }
                    TLRPC$SecureFile tLRPC$SecureFile = tLRPC$TL_secureValue.front_side;
                    if (tLRPC$SecureFile instanceof TLRPC$TL_secureFile) {
                        TLRPC$TL_secureFile tLRPC$TL_secureFile2 = (TLRPC$TL_secureFile) tLRPC$SecureFile;
                        byte[] bArrDecryptValueSecret3 = decryptValueSecret(tLRPC$TL_secureFile2.secret, tLRPC$TL_secureFile2.file_hash);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("file_hash", Base64.encodeToString(tLRPC$TL_secureFile2.file_hash, 2));
                        jSONObject5.put("secret", Base64.encodeToString(bArrDecryptValueSecret3, 2));
                        jSONObject3.put("front_side", jSONObject5);
                    }
                    TLRPC$SecureFile tLRPC$SecureFile2 = tLRPC$TL_secureValue.reverse_side;
                    if (tLRPC$SecureFile2 instanceof TLRPC$TL_secureFile) {
                        TLRPC$TL_secureFile tLRPC$TL_secureFile3 = (TLRPC$TL_secureFile) tLRPC$SecureFile2;
                        byte[] bArrDecryptValueSecret4 = decryptValueSecret(tLRPC$TL_secureFile3.secret, tLRPC$TL_secureFile3.file_hash);
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("file_hash", Base64.encodeToString(tLRPC$TL_secureFile3.file_hash, 2));
                        jSONObject6.put("secret", Base64.encodeToString(bArrDecryptValueSecret4, 2));
                        jSONObject3.put("reverse_side", jSONObject6);
                    }
                    if (c1ValueToSend.selfie_required) {
                        TLRPC$SecureFile tLRPC$SecureFile3 = tLRPC$TL_secureValue.selfie;
                        if (tLRPC$SecureFile3 instanceof TLRPC$TL_secureFile) {
                            TLRPC$TL_secureFile tLRPC$TL_secureFile4 = (TLRPC$TL_secureFile) tLRPC$SecureFile3;
                            byte[] bArrDecryptValueSecret5 = decryptValueSecret(tLRPC$TL_secureFile4.secret, tLRPC$TL_secureFile4.file_hash);
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("file_hash", Base64.encodeToString(tLRPC$TL_secureFile4.file_hash, 2));
                            jSONObject7.put("secret", Base64.encodeToString(bArrDecryptValueSecret5, 2));
                            jSONObject3.put("selfie", jSONObject7);
                        }
                    }
                    if (c1ValueToSend.translation_required && !tLRPC$TL_secureValue.translation.isEmpty()) {
                        JSONArray jSONArray2 = new JSONArray();
                        int size5 = tLRPC$TL_secureValue.translation.size();
                        for (int i6 = 0; i6 < size5; i6++) {
                            TLRPC$TL_secureFile tLRPC$TL_secureFile5 = (TLRPC$TL_secureFile) tLRPC$TL_secureValue.translation.get(i6);
                            byte[] bArrDecryptValueSecret6 = decryptValueSecret(tLRPC$TL_secureFile5.secret, tLRPC$TL_secureFile5.file_hash);
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("file_hash", Base64.encodeToString(tLRPC$TL_secureFile5.file_hash, 2));
                            jSONObject8.put("secret", Base64.encodeToString(bArrDecryptValueSecret6, 2));
                            jSONArray2.put(jSONObject8);
                        }
                        jSONObject3.put("translation", jSONArray2);
                    }
                    jSONObject.put(getNameForType(tLRPC$TL_secureValue.type), jSONObject3);
                } catch (Exception unused3) {
                }
                TLRPC$TL_secureValueHash tLRPC$TL_secureValueHash = new TLRPC$TL_secureValueHash();
                tLRPC$TL_secureValueHash.type = tLRPC$TL_secureValue.type;
                tLRPC$TL_secureValueHash.hash = tLRPC$TL_secureValue.hash;
                tLRPC$TL_account_acceptAuthorization.value_hashes.add(tLRPC$TL_secureValueHash);
                i4++;
                arrayList2 = arrayList;
                size3 = i;
            }
            arrayList = arrayList2;
            i = size3;
            TLRPC$TL_secureValueHash tLRPC$TL_secureValueHash2 = new TLRPC$TL_secureValueHash();
            tLRPC$TL_secureValueHash2.type = tLRPC$TL_secureValue.type;
            tLRPC$TL_secureValueHash2.hash = tLRPC$TL_secureValue.hash;
            tLRPC$TL_account_acceptAuthorization.value_hashes.add(tLRPC$TL_secureValueHash2);
            i4++;
            arrayList2 = arrayList;
            size3 = i;
        }
        JSONObject jSONObject9 = new JSONObject();
        try {
            jSONObject9.put("secure_data", jSONObject);
        } catch (Exception unused4) {
        }
        Object obj = this.currentPayload;
        if (obj != null) {
            try {
                jSONObject9.put("payload", obj);
            } catch (Exception unused5) {
            }
        }
        Object obj2 = this.currentNonce;
        if (obj2 != null) {
            try {
                jSONObject9.put("nonce", obj2);
            } catch (Exception unused6) {
            }
        }
        EncryptionResult encryptionResultEncryptData = encryptData(AndroidUtilities.getStringBytes(jSONObject9.toString()));
        TLRPC$TL_secureCredentialsEncrypted tLRPC$TL_secureCredentialsEncrypted = new TLRPC$TL_secureCredentialsEncrypted();
        tLRPC$TL_account_acceptAuthorization.credentials = tLRPC$TL_secureCredentialsEncrypted;
        tLRPC$TL_secureCredentialsEncrypted.hash = encryptionResultEncryptData.fileHash;
        tLRPC$TL_secureCredentialsEncrypted.data = encryptionResultEncryptData.encryptedData;
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(this.currentPublicKey.replaceAll("\\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", ""), 0)));
            Cipher cipher = Cipher.getInstance("RSA/NONE/OAEPWithSHA1AndMGF1Padding");
            cipher.init(1, rSAPublicKey);
            tLRPC$TL_account_acceptAuthorization.credentials.secret = cipher.doFinal(encryptionResultEncryptData.decrypyedFileSecret);
        } catch (Exception e) {
            FileLog.e(e);
        }
        ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_acceptAuthorization, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Y_EvPOO1bEY_m_nTeEass2AMmM4
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createRequestInterface$15$PassportActivity(tLObject, tLRPC$TL_error);
            }
        }), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createRequestInterface$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createRequestInterface$15$PassportActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$1rbf8Net-qW6TBaY9uDZsLq9Os4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createRequestInterface$14$PassportActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createRequestInterface$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createRequestInterface$14$PassportActivity(TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            this.ignoreOnFailure = true;
            callCallback(true);
            finishFragment();
        } else {
            showEditDoneProgress(false, false);
            if ("APP_VERSION_OUTDATED".equals(tLRPC$TL_error.text)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
            } else {
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createManageInterface(android.content.Context r20) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.createManageInterface(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$17$PassportActivity(View view) {
        openAddDocumentAlert();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$21$PassportActivity(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("EitaaPassportDeleteTitle", R.string.EitaaPassportDeleteTitle));
        builder.setMessage(LocaleController.getString("EitaaPassportDeleteAlert", R.string.EitaaPassportDeleteAlert));
        builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$hlxsJJzXPqJMjaui5kHtWILeBjk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createManageInterface$20$PassportActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$20$PassportActivity(DialogInterface dialogInterface, int i) {
        TLRPC$TL_account_deleteSecureValue tLRPC$TL_account_deleteSecureValue = new TLRPC$TL_account_deleteSecureValue();
        for (int i2 = 0; i2 < this.currentForm.values.size(); i2++) {
            tLRPC$TL_account_deleteSecureValue.types.add(this.currentForm.values.get(i2).type);
        }
        needShowProgress();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_deleteSecureValue, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$rRUiWIGWzgDKvMdpI0_vK8lUYGU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createManageInterface$19$PassportActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$19$PassportActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$ghaAa0VsvvQwne2_kuKZoWimaJ4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createManageInterface$18$PassportActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$18$PassportActivity() {
        int i = 0;
        while (i < this.linearLayout2.getChildCount()) {
            View childAt = this.linearLayout2.getChildAt(i);
            if (childAt instanceof TextDetailSecureCell) {
                this.linearLayout2.removeView(childAt);
                i--;
            }
            i++;
        }
        needHideProgress();
        this.typesViews.clear();
        this.typesValues.clear();
        this.currentForm.values.clear();
        updateManageVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createManageInterface$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createManageInterface$22$PassportActivity(View view) {
        openAddDocumentAlert();
    }

    private boolean hasNotValueForType(Class<? extends TLRPC$SecureValueType> type) {
        int size = this.currentForm.values.size();
        for (int i = 0; i < size; i++) {
            if (this.currentForm.values.get(i).type.getClass() == type) {
                return false;
            }
        }
        return true;
    }

    private boolean hasUnfilledValues() {
        return hasNotValueForType(TLRPC$TL_secureValueTypePhone.class) || hasNotValueForType(TLRPC$TL_secureValueTypeEmail.class) || hasNotValueForType(TLRPC$TL_secureValueTypePersonalDetails.class) || hasNotValueForType(TLRPC$TL_secureValueTypePassport.class) || hasNotValueForType(TLRPC$TL_secureValueTypeInternalPassport.class) || hasNotValueForType(TLRPC$TL_secureValueTypeIdentityCard.class) || hasNotValueForType(TLRPC$TL_secureValueTypeDriverLicense.class) || hasNotValueForType(TLRPC$TL_secureValueTypeAddress.class) || hasNotValueForType(TLRPC$TL_secureValueTypeUtilityBill.class) || hasNotValueForType(TLRPC$TL_secureValueTypePassportRegistration.class) || hasNotValueForType(TLRPC$TL_secureValueTypeTemporaryRegistration.class) || hasNotValueForType(TLRPC$TL_secureValueTypeBankStatement.class) || hasNotValueForType(TLRPC$TL_secureValueTypeRentalAgreement.class);
    }

    private void openAddDocumentAlert() {
        Class<? extends TLRPC$SecureValueType> cls;
        Class<? extends TLRPC$SecureValueType> cls2;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (hasNotValueForType(TLRPC$TL_secureValueTypePhone.class)) {
            cls = TLRPC$TL_secureValueTypeRentalAgreement.class;
            cls2 = TLRPC$TL_secureValueTypeBankStatement.class;
            arrayList.add(LocaleController.getString("ActionBotDocumentPhone", R.string.ActionBotDocumentPhone));
            arrayList2.add(TLRPC$TL_secureValueTypePhone.class);
        } else {
            cls = TLRPC$TL_secureValueTypeRentalAgreement.class;
            cls2 = TLRPC$TL_secureValueTypeBankStatement.class;
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeEmail.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentEmail", R.string.ActionBotDocumentEmail));
            arrayList2.add(TLRPC$TL_secureValueTypeEmail.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypePersonalDetails.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentIdentity", R.string.ActionBotDocumentIdentity));
            arrayList2.add(TLRPC$TL_secureValueTypePersonalDetails.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypePassport.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentPassport", R.string.ActionBotDocumentPassport));
            arrayList2.add(TLRPC$TL_secureValueTypePassport.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeInternalPassport.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentInternalPassport", R.string.ActionBotDocumentInternalPassport));
            arrayList2.add(TLRPC$TL_secureValueTypeInternalPassport.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypePassportRegistration.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentPassportRegistration", R.string.ActionBotDocumentPassportRegistration));
            arrayList2.add(TLRPC$TL_secureValueTypePassportRegistration.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeTemporaryRegistration.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentTemporaryRegistration", R.string.ActionBotDocumentTemporaryRegistration));
            arrayList2.add(TLRPC$TL_secureValueTypeTemporaryRegistration.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeIdentityCard.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentIdentityCard", R.string.ActionBotDocumentIdentityCard));
            arrayList2.add(TLRPC$TL_secureValueTypeIdentityCard.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeDriverLicense.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentDriverLicence", R.string.ActionBotDocumentDriverLicence));
            arrayList2.add(TLRPC$TL_secureValueTypeDriverLicense.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeAddress.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentAddress", R.string.ActionBotDocumentAddress));
            arrayList2.add(TLRPC$TL_secureValueTypeAddress.class);
        }
        if (hasNotValueForType(TLRPC$TL_secureValueTypeUtilityBill.class)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentUtilityBill", R.string.ActionBotDocumentUtilityBill));
            arrayList2.add(TLRPC$TL_secureValueTypeUtilityBill.class);
        }
        Class<? extends TLRPC$SecureValueType> cls3 = cls2;
        if (hasNotValueForType(cls3)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentBankStatement", R.string.ActionBotDocumentBankStatement));
            arrayList2.add(cls3);
        }
        Class<? extends TLRPC$SecureValueType> cls4 = cls;
        if (hasNotValueForType(cls4)) {
            arrayList.add(LocaleController.getString("ActionBotDocumentRentalAgreement", R.string.ActionBotDocumentRentalAgreement));
            arrayList2.add(cls4);
        }
        if (getParentActivity() == null || arrayList.isEmpty()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PassportNoDocumentsAdd", R.string.PassportNoDocumentsAdd));
        builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$7-q5wJBjdosAi4bFGPh_v8wa2vA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$openAddDocumentAlert$23$PassportActivity(arrayList2, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* renamed from: lambda$openAddDocumentAlert$23, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$openAddDocumentAlert$23$PassportActivity(java.util.ArrayList r2, android.content.DialogInterface r3, int r4) {
        /*
            r1 = this;
            r3 = 0
            ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r0 = new ir.eitaa.tgnet.TLRPC$TL_secureRequiredType     // Catch: java.lang.Exception -> L17
            r0.<init>()     // Catch: java.lang.Exception -> L17
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L15
            java.lang.Class r2 = (java.lang.Class) r2     // Catch: java.lang.Exception -> L15
            java.lang.Object r2 = r2.newInstance()     // Catch: java.lang.Exception -> L15
            ir.eitaa.tgnet.TLRPC$SecureValueType r2 = (ir.eitaa.tgnet.TLRPC$SecureValueType) r2     // Catch: java.lang.Exception -> L15
            r0.type = r2     // Catch: java.lang.Exception -> L15
            goto L18
        L15:
            goto L18
        L17:
            r0 = r3
        L18:
            ir.eitaa.tgnet.TLRPC$SecureValueType r2 = r0.type
            boolean r2 = r1.isPersonalDocument(r2)
            r4 = 1
            if (r2 == 0) goto L34
            r0.selfie_required = r4
            r0.translation_required = r4
            ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r2 = new ir.eitaa.tgnet.TLRPC$TL_secureRequiredType
            r2.<init>()
            ir.eitaa.tgnet.TLRPC$TL_secureValueTypePersonalDetails r3 = new ir.eitaa.tgnet.TLRPC$TL_secureValueTypePersonalDetails
            r3.<init>()
            r2.type = r3
        L31:
            r3 = r0
            r0 = r2
            goto L49
        L34:
            ir.eitaa.tgnet.TLRPC$SecureValueType r2 = r0.type
            boolean r2 = r1.isAddressDocument(r2)
            if (r2 == 0) goto L49
            ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r2 = new ir.eitaa.tgnet.TLRPC$TL_secureRequiredType
            r2.<init>()
            ir.eitaa.tgnet.TLRPC$TL_secureValueTypeAddress r3 = new ir.eitaa.tgnet.TLRPC$TL_secureValueTypeAddress
            r3.<init>()
            r2.type = r3
            goto L31
        L49:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r3 == 0) goto L51
            goto L52
        L51:
            r4 = 0
        L52:
            r1.openTypeActivity(r0, r3, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.lambda$openAddDocumentAlert$23$PassportActivity(java.util.ArrayList, android.content.DialogInterface, int):void");
    }

    private void updateManageVisibility() {
        if (this.currentForm.values.isEmpty()) {
            this.emptyLayout.setVisibility(0);
            this.sectionCell.setVisibility(8);
            this.headerCell.setVisibility(8);
            this.addDocumentCell.setVisibility(8);
            this.deletePassportCell.setVisibility(8);
            this.addDocumentSectionCell.setVisibility(8);
            return;
        }
        this.emptyLayout.setVisibility(8);
        this.sectionCell.setVisibility(0);
        this.headerCell.setVisibility(0);
        this.deletePassportCell.setVisibility(0);
        this.addDocumentSectionCell.setVisibility(0);
        if (hasUnfilledValues()) {
            this.addDocumentCell.setVisibility(0);
        } else {
            this.addDocumentCell.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callCallback(boolean success) {
        int i;
        int i2;
        if (this.callbackCalled) {
            return;
        }
        if (!TextUtils.isEmpty(this.currentCallbackUrl)) {
            if (success) {
                Browser.openUrl(getParentActivity(), Uri.parse(this.currentCallbackUrl + "&tg_passport=success"));
            } else if (!this.ignoreOnFailure && ((i2 = this.currentActivityType) == 5 || i2 == 0)) {
                Browser.openUrl(getParentActivity(), Uri.parse(this.currentCallbackUrl + "&tg_passport=cancel"));
            }
            this.callbackCalled = true;
            return;
        }
        if (this.needActivityResult) {
            if (success || (!this.ignoreOnFailure && ((i = this.currentActivityType) == 5 || i == 0))) {
                getParentActivity().setResult(success ? -1 : 0);
            }
            this.callbackCalled = true;
        }
    }

    private void createEmailInterface(Context context) {
        this.actionBar.setTitle(LocaleController.getString("PassportEmail", R.string.PassportEmail));
        if (!TextUtils.isEmpty(this.currentEmail)) {
            TextSettingsCell textSettingsCell = new TextSettingsCell(context);
            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            textSettingsCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
            textSettingsCell.setText(LocaleController.formatString("PassportPhoneUseSame", R.string.PassportPhoneUseSame, this.currentEmail), false);
            this.linearLayout2.addView(textSettingsCell, LayoutHelper.createLinear(-1, -2));
            textSettingsCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Xquj666CQUBkpktVehSohezWLGg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createEmailInterface$24$PassportActivity(view);
                }
            });
            TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
            this.bottomCell = textInfoPrivacyCell;
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.bottomCell.setText(LocaleController.getString("PassportPhoneUseSameEmailInfo", R.string.PassportPhoneUseSameEmailInfo));
            this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
        }
        this.inputFields = new EditTextBoldCursor[1];
        for (int i = 0; i < 1; i++) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.linearLayout2.addView(frameLayout, LayoutHelper.createLinear(-1, 50));
            frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.inputFields[i] = new EditTextBoldCursor(context);
            this.inputFields[i].setTag(Integer.valueOf(i));
            this.inputFields[i].setTextSize(1, 16.0f);
            this.inputFields[i].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i].setBackgroundDrawable(null);
            this.inputFields[i].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i].setCursorWidth(1.5f);
            this.inputFields[i].setInputType(33);
            this.inputFields[i].setImeOptions(268435462);
            this.inputFields[i].setHint(LocaleController.getString("PaymentShippingEmailPlaceholder", R.string.PaymentShippingEmailPlaceholder));
            TLRPC$TL_secureValue tLRPC$TL_secureValue = this.currentTypeValue;
            if (tLRPC$TL_secureValue != null) {
                TLRPC$SecurePlainData tLRPC$SecurePlainData = tLRPC$TL_secureValue.plain_data;
                if (tLRPC$SecurePlainData instanceof TLRPC$TL_securePlainEmail) {
                    TLRPC$TL_securePlainEmail tLRPC$TL_securePlainEmail = (TLRPC$TL_securePlainEmail) tLRPC$SecurePlainData;
                    if (!TextUtils.isEmpty(tLRPC$TL_securePlainEmail.email)) {
                        this.inputFields[i].setText(tLRPC$TL_securePlainEmail.email);
                    }
                }
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            editTextBoldCursorArr[i].setSelection(editTextBoldCursorArr[i].length());
            this.inputFields[i].setPadding(0, 0, 0, AndroidUtilities.dp(6.0f));
            this.inputFields[i].setGravity(LocaleController.isRTL ? 5 : 3);
            frameLayout.addView(this.inputFields[i], LayoutHelper.createFrame(-1, -2.0f, 51, 21.0f, 12.0f, 21.0f, 6.0f));
            this.inputFields[i].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Z3G_qf75rax4bhETLy0HzuFVKKI
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$createEmailInterface$25$PassportActivity(textView, i2, keyEvent);
                }
            });
        }
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.bottomCell = textInfoPrivacyCell2;
        textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.bottomCell.setText(LocaleController.getString("PassportEmailUploadInfo", R.string.PassportEmailUploadInfo));
        this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createEmailInterface$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createEmailInterface$24$PassportActivity(View view) {
        this.useCurrentValue = true;
        this.doneItem.callOnClick();
        this.useCurrentValue = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createEmailInterface$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createEmailInterface$25$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        this.doneItem.callOnClick();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v3, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r15v5, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v26, types: [android.widget.LinearLayout] */
    private void createPhoneInterface(Context context) throws IOException {
        String str;
        TelephonyManager telephonyManager;
        FrameLayout frameLayout;
        this.actionBar.setTitle(LocaleController.getString("PassportPhone", R.string.PassportPhone));
        this.languageMap = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("countries.txt")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split(";");
                this.countriesArray.add(0, strArrSplit[2]);
                this.countriesMap.put(strArrSplit[2], strArrSplit[0]);
                this.codesMap.put(strArrSplit[0], strArrSplit[2]);
                if (strArrSplit.length > 3) {
                    this.phoneFormatMap.put(strArrSplit[0], strArrSplit[3]);
                }
                this.languageMap.put(strArrSplit[1], strArrSplit[2]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        Collections.sort(this.countriesArray, $$Lambda$Ds7dtVnGrflEw4LvNOxA0cDT4Y.INSTANCE);
        String str2 = UserConfig.getInstance(this.currentAccount).getCurrentUser().phone;
        TextSettingsCell textSettingsCell = new TextSettingsCell(context);
        textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        textSettingsCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        textSettingsCell.setText(LocaleController.formatString("PassportPhoneUseSame", R.string.PassportPhoneUseSame, PhoneFormat.getInstance().format("+" + str2)), false);
        int i = -1;
        this.linearLayout2.addView(textSettingsCell, LayoutHelper.createLinear(-1, -2));
        textSettingsCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$tFo9j7LGXs0RKanlsD0w9N5rlcc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createPhoneInterface$26$PassportActivity(view);
            }
        });
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.bottomCell = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.bottomCell.setText(LocaleController.getString("PassportPhoneUseSameInfo", R.string.PassportPhoneUseSameInfo));
        this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
        HeaderCell headerCell = new HeaderCell(context);
        this.headerCell = headerCell;
        headerCell.setText(LocaleController.getString("PassportPhoneUseOther", R.string.PassportPhoneUseOther));
        this.headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.linearLayout2.addView(this.headerCell, LayoutHelper.createLinear(-1, -2));
        this.inputFields = new EditTextBoldCursor[3];
        int i2 = 0;
        while (i2 < 3) {
            if (i2 == 2) {
                this.inputFields[i2] = new HintEditText(context);
            } else {
                this.inputFields[i2] = new EditTextBoldCursor(context);
            }
            if (i2 == 1) {
                ?? linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(0);
                this.linearLayout2.addView(linearLayout, LayoutHelper.createLinear(i, 50));
                linearLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = linearLayout;
            } else if (i2 == 2) {
                frameLayout = (ViewGroup) this.inputFields[1].getParent();
            } else {
                FrameLayout frameLayout2 = new FrameLayout(context);
                this.linearLayout2.addView(frameLayout2, LayoutHelper.createLinear(i, 50));
                frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = frameLayout2;
            }
            this.inputFields[i2].setTag(Integer.valueOf(i2));
            this.inputFields[i2].setTextSize(1, 16.0f);
            this.inputFields[i2].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i2].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setBackgroundDrawable(null);
            this.inputFields[i2].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i2].setCursorWidth(1.5f);
            if (i2 == 0) {
                this.inputFields[i2].setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$eG4dt2vYVi_xwba3cuPewwWL-kE
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$createPhoneInterface$29$PassportActivity(view, motionEvent);
                    }
                });
                this.inputFields[i2].setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                this.inputFields[i2].setInputType(0);
                this.inputFields[i2].setFocusable(false);
            } else {
                this.inputFields[i2].setInputType(3);
                if (i2 == 2) {
                    this.inputFields[i2].setImeOptions(268435462);
                } else {
                    this.inputFields[i2].setImeOptions(268435461);
                }
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            editTextBoldCursorArr[i2].setSelection(editTextBoldCursorArr[i2].length());
            if (i2 == 1) {
                TextView textView = new TextView(context);
                this.plusTextView = textView;
                textView.setText("+");
                this.plusTextView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.plusTextView.setTextSize(1, 16.0f);
                frameLayout.addView(this.plusTextView, LayoutHelper.createLinear(-2, -2, 21.0f, 12.0f, 0.0f, 6.0f));
                this.inputFields[i2].setPadding(AndroidUtilities.dp(10.0f), 0, 0, 0);
                this.inputFields[i2].setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
                this.inputFields[i2].setGravity(19);
                frameLayout.addView(this.inputFields[i2], LayoutHelper.createLinear(55, -2, 0.0f, 12.0f, 16.0f, 6.0f));
                this.inputFields[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.9
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i3, int i22, int i32) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i3, int i22, int i32) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String str3;
                        boolean z;
                        boolean z2;
                        int iIndexOf;
                        if (PassportActivity.this.ignoreOnTextChange) {
                            return;
                        }
                        PassportActivity.this.ignoreOnTextChange = true;
                        String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(PassportActivity.this.inputFields[1].getText().toString());
                        PassportActivity.this.inputFields[1].setText(strStripExceptNumbers);
                        HintEditText hintEditText = (HintEditText) PassportActivity.this.inputFields[2];
                        if (strStripExceptNumbers.length() == 0) {
                            hintEditText.setHintText((String) null);
                            hintEditText.setHint(LocaleController.getString("PaymentShippingPhoneNumber", R.string.PaymentShippingPhoneNumber));
                            PassportActivity.this.inputFields[0].setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                        } else {
                            int i3 = 4;
                            if (strStripExceptNumbers.length() > 4) {
                                while (true) {
                                    if (i3 < 1) {
                                        str3 = null;
                                        z = false;
                                        break;
                                    }
                                    String strSubstring = strStripExceptNumbers.substring(0, i3);
                                    if (((String) PassportActivity.this.codesMap.get(strSubstring)) != null) {
                                        String str4 = strStripExceptNumbers.substring(i3) + PassportActivity.this.inputFields[2].getText().toString();
                                        PassportActivity.this.inputFields[1].setText(strSubstring);
                                        z = true;
                                        str3 = str4;
                                        strStripExceptNumbers = strSubstring;
                                        break;
                                    }
                                    i3--;
                                }
                                if (!z) {
                                    str3 = strStripExceptNumbers.substring(1) + PassportActivity.this.inputFields[2].getText().toString();
                                    EditTextBoldCursor editTextBoldCursor = PassportActivity.this.inputFields[1];
                                    strStripExceptNumbers = strStripExceptNumbers.substring(0, 1);
                                    editTextBoldCursor.setText(strStripExceptNumbers);
                                }
                            } else {
                                str3 = null;
                                z = false;
                            }
                            String str5 = (String) PassportActivity.this.codesMap.get(strStripExceptNumbers);
                            if (str5 == null || (iIndexOf = PassportActivity.this.countriesArray.indexOf(str5)) == -1) {
                                z2 = false;
                            } else {
                                PassportActivity.this.inputFields[0].setText((CharSequence) PassportActivity.this.countriesArray.get(iIndexOf));
                                String str6 = (String) PassportActivity.this.phoneFormatMap.get(strStripExceptNumbers);
                                if (str6 != null) {
                                    hintEditText.setHintText(str6.replace('X', (char) 8211));
                                    hintEditText.setHint((CharSequence) null);
                                }
                                z2 = true;
                            }
                            if (!z2) {
                                hintEditText.setHintText((String) null);
                                hintEditText.setHint(LocaleController.getString("PaymentShippingPhoneNumber", R.string.PaymentShippingPhoneNumber));
                                PassportActivity.this.inputFields[0].setText(LocaleController.getString("WrongCountry", R.string.WrongCountry));
                            }
                            if (!z) {
                                PassportActivity.this.inputFields[1].setSelection(PassportActivity.this.inputFields[1].getText().length());
                            }
                            if (str3 != null) {
                                hintEditText.requestFocus();
                                hintEditText.setText(str3);
                                hintEditText.setSelection(hintEditText.length());
                            }
                        }
                        PassportActivity.this.ignoreOnTextChange = false;
                    }
                });
            } else if (i2 == 2) {
                this.inputFields[i2].setPadding(0, 0, 0, 0);
                this.inputFields[i2].setGravity(19);
                this.inputFields[i2].setHintText(null);
                this.inputFields[i2].setHint(LocaleController.getString("PaymentShippingPhoneNumber", R.string.PaymentShippingPhoneNumber));
                frameLayout.addView(this.inputFields[i2], LayoutHelper.createLinear(-1, -2, 0.0f, 12.0f, 21.0f, 6.0f));
                this.inputFields[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.10
                    private int actionPosition;
                    private int characterAction = -1;

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        if (count == 0 && after == 1) {
                            this.characterAction = 1;
                            return;
                        }
                        if (count == 1 && after == 0) {
                            if (s.charAt(start) == ' ' && start > 0) {
                                this.characterAction = 3;
                                this.actionPosition = start - 1;
                                return;
                            } else {
                                this.characterAction = 2;
                                return;
                            }
                        }
                        this.characterAction = -1;
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        int i3;
                        int i4;
                        if (PassportActivity.this.ignoreOnPhoneChange) {
                            return;
                        }
                        HintEditText hintEditText = (HintEditText) PassportActivity.this.inputFields[2];
                        int selectionStart = hintEditText.getSelectionStart();
                        String string = hintEditText.getText().toString();
                        if (this.characterAction == 3) {
                            string = string.substring(0, this.actionPosition) + string.substring(this.actionPosition + 1);
                            selectionStart--;
                        }
                        StringBuilder sb = new StringBuilder(string.length());
                        int i5 = 0;
                        while (i5 < string.length()) {
                            int i6 = i5 + 1;
                            String strSubstring = string.substring(i5, i6);
                            if ("0123456789".contains(strSubstring)) {
                                sb.append(strSubstring);
                            }
                            i5 = i6;
                        }
                        PassportActivity.this.ignoreOnPhoneChange = true;
                        String hintText = hintEditText.getHintText();
                        if (hintText != null) {
                            int i7 = 0;
                            while (true) {
                                if (i7 >= sb.length()) {
                                    break;
                                }
                                if (i7 < hintText.length()) {
                                    if (hintText.charAt(i7) == ' ') {
                                        sb.insert(i7, ' ');
                                        i7++;
                                        if (selectionStart == i7 && (i4 = this.characterAction) != 2 && i4 != 3) {
                                            selectionStart++;
                                        }
                                    }
                                    i7++;
                                } else {
                                    sb.insert(i7, ' ');
                                    if (selectionStart == i7 + 1 && (i3 = this.characterAction) != 2 && i3 != 3) {
                                        selectionStart++;
                                    }
                                }
                            }
                        }
                        hintEditText.setText(sb);
                        if (selectionStart >= 0) {
                            hintEditText.setSelection(Math.min(selectionStart, hintEditText.length()));
                        }
                        hintEditText.onTextChange();
                        PassportActivity.this.ignoreOnPhoneChange = false;
                    }
                });
            } else {
                this.inputFields[i2].setPadding(0, 0, 0, AndroidUtilities.dp(6.0f));
                this.inputFields[i2].setGravity(LocaleController.isRTL ? 5 : 3);
                frameLayout.addView(this.inputFields[i2], LayoutHelper.createFrame(-1, -2.0f, 51, 21.0f, 12.0f, 21.0f, 6.0f));
            }
            this.inputFields[i2].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$_uaoRhc1P8is5oqwAXF0VUOzT0Y
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                    return this.f$0.lambda$createPhoneInterface$30$PassportActivity(textView2, i3, keyEvent);
                }
            });
            if (i2 == 2) {
                this.inputFields[i2].setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$XKG1VFgOh7AJHyHXEk0AHbQEHtE
                    @Override // android.view.View.OnKeyListener
                    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                        return this.f$0.lambda$createPhoneInterface$31$PassportActivity(view, i3, keyEvent);
                    }
                });
            }
            if (i2 == 0) {
                View view = new View(context);
                this.dividers.add(view);
                view.setBackgroundColor(Theme.getColor("divider"));
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, 1, 83));
            }
            i2++;
            i = -1;
        }
        try {
            telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        String upperCase = telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase() : null;
        if (upperCase != null && (str = this.languageMap.get(upperCase)) != null && this.countriesArray.indexOf(str) != -1) {
            this.inputFields[1].setText(this.countriesMap.get(str));
        }
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.bottomCell = textInfoPrivacyCell2;
        textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.bottomCell.setText(LocaleController.getString("PassportPhoneUploadInfo", R.string.PassportPhoneUploadInfo));
        this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPhoneInterface$26$PassportActivity(View view) {
        this.useCurrentValue = true;
        this.doneItem.callOnClick();
        this.useCurrentValue = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createPhoneInterface$29$PassportActivity(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$0gOI71OLFzY-M-hJu5-EZfnVzF4
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$createPhoneInterface$28$PassportActivity(country);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPhoneInterface$28$PassportActivity(CountrySelectActivity.Country country) {
        this.inputFields[0].setText(country.name);
        if (this.countriesArray.indexOf(country.name) != -1) {
            this.ignoreOnTextChange = true;
            String str = this.countriesMap.get(country.name);
            this.inputFields[1].setText(str);
            String str2 = this.phoneFormatMap.get(str);
            this.inputFields[2].setHintText(str2 != null ? str2.replace('X', (char) 8211) : null);
            this.ignoreOnTextChange = false;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$1s6kOdNN8BvAC6E5N1pbskbxvn4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createPhoneInterface$27$PassportActivity();
            }
        }, 300L);
        this.inputFields[2].requestFocus();
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        editTextBoldCursorArr[2].setSelection(editTextBoldCursorArr[2].length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createPhoneInterface$27$PassportActivity() {
        AndroidUtilities.showKeyboard(this.inputFields[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createPhoneInterface$30$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            this.inputFields[2].requestFocus();
            return true;
        }
        if (i != 6) {
            return false;
        }
        this.doneItem.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createPhoneInterface$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createPhoneInterface$31$PassportActivity(View view, int i, KeyEvent keyEvent) {
        if (i != 67 || this.inputFields[2].length() != 0) {
            return false;
        }
        this.inputFields[1].requestFocus();
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        editTextBoldCursorArr[1].setSelection(editTextBoldCursorArr[1].length());
        this.inputFields[1].dispatchKeyEvent(keyEvent);
        return true;
    }

    private void createAddressInterface(Context context) throws IOException {
        final String str;
        this.languageMap = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open("countries.txt")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] strArrSplit = line.split(";");
                this.languageMap.put(strArrSplit[1], strArrSplit[2]);
            }
            bufferedReader.close();
        } catch (Exception e) {
            FileLog.e(e);
        }
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.topErrorCell = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_top, "windowBackgroundGrayShadow"));
        this.topErrorCell.setPadding(0, AndroidUtilities.dp(7.0f), 0, 0);
        int i = -2;
        this.linearLayout2.addView(this.topErrorCell, LayoutHelper.createLinear(-1, -2));
        checkTopErrorCell(true);
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = this.currentDocumentsType;
        if (tLRPC$TL_secureRequiredType != null) {
            TLRPC$SecureValueType tLRPC$SecureValueType = tLRPC$TL_secureRequiredType.type;
            if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeRentalAgreement) {
                this.actionBar.setTitle(LocaleController.getString("ActionBotDocumentRentalAgreement", R.string.ActionBotDocumentRentalAgreement));
            } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeBankStatement) {
                this.actionBar.setTitle(LocaleController.getString("ActionBotDocumentBankStatement", R.string.ActionBotDocumentBankStatement));
            } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeUtilityBill) {
                this.actionBar.setTitle(LocaleController.getString("ActionBotDocumentUtilityBill", R.string.ActionBotDocumentUtilityBill));
            } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePassportRegistration) {
                this.actionBar.setTitle(LocaleController.getString("ActionBotDocumentPassportRegistration", R.string.ActionBotDocumentPassportRegistration));
            } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) {
                this.actionBar.setTitle(LocaleController.getString("ActionBotDocumentTemporaryRegistration", R.string.ActionBotDocumentTemporaryRegistration));
            }
            HeaderCell headerCell = new HeaderCell(context);
            this.headerCell = headerCell;
            headerCell.setText(LocaleController.getString("PassportDocuments", R.string.PassportDocuments));
            this.headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.linearLayout2.addView(this.headerCell, LayoutHelper.createLinear(-1, -2));
            LinearLayout linearLayout = new LinearLayout(context);
            this.documentsLayout = linearLayout;
            linearLayout.setOrientation(1);
            this.linearLayout2.addView(this.documentsLayout, LayoutHelper.createLinear(-1, -2));
            TextSettingsCell textSettingsCell = new TextSettingsCell(context);
            this.uploadDocumentCell = textSettingsCell;
            textSettingsCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
            this.linearLayout2.addView(this.uploadDocumentCell, LayoutHelper.createLinear(-1, -2));
            this.uploadDocumentCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$pkUqfFrOvD4sHE7zCXqUm10GadQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createAddressInterface$32$PassportActivity(view);
                }
            });
            TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
            this.bottomCell = textInfoPrivacyCell2;
            textInfoPrivacyCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            if (this.currentBotId != 0) {
                this.noAllDocumentsErrorText = LocaleController.getString("PassportAddAddressUploadInfo", R.string.PassportAddAddressUploadInfo);
            } else {
                TLRPC$SecureValueType tLRPC$SecureValueType2 = this.currentDocumentsType.type;
                if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypeRentalAgreement) {
                    this.noAllDocumentsErrorText = LocaleController.getString("PassportAddAgreementInfo", R.string.PassportAddAgreementInfo);
                } else if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypeUtilityBill) {
                    this.noAllDocumentsErrorText = LocaleController.getString("PassportAddBillInfo", R.string.PassportAddBillInfo);
                } else if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypePassportRegistration) {
                    this.noAllDocumentsErrorText = LocaleController.getString("PassportAddPassportRegistrationInfo", R.string.PassportAddPassportRegistrationInfo);
                } else if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) {
                    this.noAllDocumentsErrorText = LocaleController.getString("PassportAddTemporaryRegistrationInfo", R.string.PassportAddTemporaryRegistrationInfo);
                } else if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypeBankStatement) {
                    this.noAllDocumentsErrorText = LocaleController.getString("PassportAddBankInfo", R.string.PassportAddBankInfo);
                } else {
                    this.noAllDocumentsErrorText = "";
                }
            }
            CharSequence charSequence = this.noAllDocumentsErrorText;
            HashMap<String, String> map = this.documentsErrors;
            CharSequence charSequence2 = charSequence;
            if (map != null) {
                String str2 = map.get("files_all");
                charSequence2 = charSequence;
                if (str2 != null) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                    spannableStringBuilder.append((CharSequence) "\n\n");
                    spannableStringBuilder.append(this.noAllDocumentsErrorText);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Theme.getColor("windowBackgroundWhiteRedText3")), 0, str2.length(), 33);
                    this.errorsValues.put("files_all", "");
                    charSequence2 = spannableStringBuilder;
                }
            }
            this.bottomCell.setText(charSequence2);
            this.linearLayout2.addView(this.bottomCell, LayoutHelper.createLinear(-1, -2));
            if (this.currentDocumentsType.translation_required) {
                HeaderCell headerCell2 = new HeaderCell(context);
                this.headerCell = headerCell2;
                headerCell2.setText(LocaleController.getString("PassportTranslation", R.string.PassportTranslation));
                this.headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                this.linearLayout2.addView(this.headerCell, LayoutHelper.createLinear(-1, -2));
                LinearLayout linearLayout2 = new LinearLayout(context);
                this.translationLayout = linearLayout2;
                linearLayout2.setOrientation(1);
                this.linearLayout2.addView(this.translationLayout, LayoutHelper.createLinear(-1, -2));
                TextSettingsCell textSettingsCell2 = new TextSettingsCell(context);
                this.uploadTranslationCell = textSettingsCell2;
                textSettingsCell2.setBackgroundDrawable(Theme.getSelectorDrawable(true));
                this.linearLayout2.addView(this.uploadTranslationCell, LayoutHelper.createLinear(-1, -2));
                this.uploadTranslationCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$prBFLmID_ezTMtdBs8l6cUmxocQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createAddressInterface$33$PassportActivity(view);
                    }
                });
                TextInfoPrivacyCell textInfoPrivacyCell3 = new TextInfoPrivacyCell(context);
                this.bottomCellTranslation = textInfoPrivacyCell3;
                textInfoPrivacyCell3.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                if (this.currentBotId != 0) {
                    this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationUploadInfo", R.string.PassportAddTranslationUploadInfo);
                } else {
                    TLRPC$SecureValueType tLRPC$SecureValueType3 = this.currentDocumentsType.type;
                    if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeRentalAgreement) {
                        this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationAgreementInfo", R.string.PassportAddTranslationAgreementInfo);
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeUtilityBill) {
                        this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationBillInfo", R.string.PassportAddTranslationBillInfo);
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypePassportRegistration) {
                        this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationPassportRegistrationInfo", R.string.PassportAddTranslationPassportRegistrationInfo);
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) {
                        this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationTemporaryRegistrationInfo", R.string.PassportAddTranslationTemporaryRegistrationInfo);
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeBankStatement) {
                        this.noAllTranslationErrorText = LocaleController.getString("PassportAddTranslationBankInfo", R.string.PassportAddTranslationBankInfo);
                    } else {
                        this.noAllTranslationErrorText = "";
                    }
                }
                CharSequence charSequence3 = this.noAllTranslationErrorText;
                HashMap<String, String> map2 = this.documentsErrors;
                CharSequence charSequence4 = charSequence3;
                if (map2 != null) {
                    String str3 = map2.get("translation_all");
                    charSequence4 = charSequence3;
                    if (str3 != null) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str3);
                        spannableStringBuilder2.append((CharSequence) "\n\n");
                        spannableStringBuilder2.append(this.noAllTranslationErrorText);
                        spannableStringBuilder2.setSpan(new ForegroundColorSpan(Theme.getColor("windowBackgroundWhiteRedText3")), 0, str3.length(), 33);
                        this.errorsValues.put("translation_all", "");
                        charSequence4 = spannableStringBuilder2;
                    }
                }
                this.bottomCellTranslation.setText(charSequence4);
                this.linearLayout2.addView(this.bottomCellTranslation, LayoutHelper.createLinear(-1, -2));
            }
        } else {
            this.actionBar.setTitle(LocaleController.getString("PassportAddress", R.string.PassportAddress));
        }
        HeaderCell headerCell3 = new HeaderCell(context);
        this.headerCell = headerCell3;
        headerCell3.setText(LocaleController.getString("PassportAddressHeader", R.string.PassportAddressHeader));
        this.headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.linearLayout2.addView(this.headerCell, LayoutHelper.createLinear(-1, -2));
        int i2 = 6;
        this.inputFields = new EditTextBoldCursor[6];
        int i3 = 0;
        while (i3 < i2) {
            final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.inputFields[i3] = editTextBoldCursor;
            FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.PassportActivity.11
                private StaticLayout errorLayout;
                float offsetX;

                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    int size = View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(34.0f);
                    StaticLayout errorLayout = editTextBoldCursor.getErrorLayout(size);
                    this.errorLayout = errorLayout;
                    if (errorLayout != null) {
                        int lineCount = errorLayout.getLineCount();
                        int i4 = 0;
                        if (lineCount > 1) {
                            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(64.0f) + (this.errorLayout.getLineBottom(lineCount - 1) - this.errorLayout.getLineBottom(0)), 1073741824);
                        }
                        if (LocaleController.isRTL) {
                            float fMax = 0.0f;
                            while (true) {
                                if (i4 >= lineCount) {
                                    break;
                                }
                                if (this.errorLayout.getLineLeft(i4) != 0.0f) {
                                    this.offsetX = 0.0f;
                                    break;
                                }
                                fMax = Math.max(fMax, this.errorLayout.getLineWidth(i4));
                                if (i4 == lineCount - 1) {
                                    this.offsetX = size - fMax;
                                }
                                i4++;
                            }
                        }
                    }
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    if (this.errorLayout != null) {
                        canvas.save();
                        canvas.translate(AndroidUtilities.dp(21.0f) + this.offsetX, editTextBoldCursor.getLineY() + AndroidUtilities.dp(3.0f));
                        this.errorLayout.draw(canvas);
                        canvas.restore();
                    }
                }
            };
            frameLayout.setWillNotDraw(false);
            this.linearLayout2.addView(frameLayout, LayoutHelper.createLinear(-1, i));
            frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            if (i3 == 5) {
                View view = new View(context);
                this.extraBackgroundView = view;
                view.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                this.linearLayout2.addView(this.extraBackgroundView, LayoutHelper.createLinear(-1, i2));
            }
            if (this.documentOnly && this.currentDocumentsType != null) {
                frameLayout.setVisibility(8);
                View view2 = this.extraBackgroundView;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
            this.inputFields[i3].setTag(Integer.valueOf(i3));
            this.inputFields[i3].setSupportRtlHint(true);
            this.inputFields[i3].setTextSize(1, 16.0f);
            this.inputFields[i3].setHintColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i3].setHeaderHintColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
            this.inputFields[i3].setTransformHintToHeader(true);
            this.inputFields[i3].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i3].setBackgroundDrawable(null);
            this.inputFields[i3].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i3].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i3].setCursorWidth(1.5f);
            this.inputFields[i3].setLineColors(Theme.getColor("windowBackgroundWhiteInputField"), Theme.getColor("windowBackgroundWhiteInputFieldActivated"), Theme.getColor("windowBackgroundWhiteRedText3"));
            if (i3 == 5) {
                this.inputFields[i3].setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8i6ac9lbErx-QzavBX5KOTGPjWE
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        return this.f$0.lambda$createAddressInterface$35$PassportActivity(view3, motionEvent);
                    }
                });
                this.inputFields[i3].setInputType(0);
                this.inputFields[i3].setFocusable(false);
            } else {
                this.inputFields[i3].setInputType(16385);
                this.inputFields[i3].setImeOptions(268435461);
            }
            if (i3 == 0) {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportStreet1", R.string.PassportStreet1));
                str = "street_line1";
            } else if (i3 == 1) {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportStreet2", R.string.PassportStreet2));
                str = "street_line2";
            } else if (i3 == 2) {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportPostcode", R.string.PassportPostcode));
                str = "post_code";
            } else if (i3 == 3) {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportCity", R.string.PassportCity));
                str = "city";
            } else if (i3 == 4) {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportState", R.string.PassportState));
                str = "state";
            } else if (i3 != 5) {
                i3++;
                i2 = 6;
                i = -2;
            } else {
                this.inputFields[i3].setHintText(LocaleController.getString("PassportCountry", R.string.PassportCountry));
                str = "country_code";
            }
            setFieldValues(this.currentValues, this.inputFields[i3], str);
            if (i3 == 2) {
                this.inputFields[i3].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.12
                    private boolean ignore;

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        if (this.ignore) {
                            return;
                        }
                        boolean z = true;
                        this.ignore = true;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= s.length()) {
                                z = false;
                                break;
                            }
                            char cCharAt = s.charAt(i4);
                            if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-' || cCharAt == ' '))) {
                                break;
                            } else {
                                i4++;
                            }
                        }
                        this.ignore = false;
                        if (!z) {
                            PassportActivity.this.checkFieldForError(editTextBoldCursor, str, s, false);
                        } else {
                            editTextBoldCursor.setErrorText(LocaleController.getString("PassportUseLatinOnly", R.string.PassportUseLatinOnly));
                        }
                    }
                });
                this.inputFields[i3].setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
            } else {
                this.inputFields[i3].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.13
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        PassportActivity.this.checkFieldForError(editTextBoldCursor, str, s, false);
                    }
                });
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            editTextBoldCursorArr[i3].setSelection(editTextBoldCursorArr[i3].length());
            this.inputFields[i3].setPadding(0, 0, 0, 0);
            this.inputFields[i3].setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            frameLayout.addView(this.inputFields[i3], LayoutHelper.createFrame(-1, 64.0f, 51, 21.0f, 0.0f, 21.0f, 0.0f));
            this.inputFields[i3].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PLun6uqaIcnofC3KN916zKjtVj0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                    return this.f$0.lambda$createAddressInterface$36$PassportActivity(textView, i4, keyEvent);
                }
            });
            i3++;
            i2 = 6;
            i = -2;
        }
        ShadowSectionCell shadowSectionCell = new ShadowSectionCell(context);
        this.sectionCell = shadowSectionCell;
        this.linearLayout2.addView(shadowSectionCell, LayoutHelper.createLinear(-1, -2));
        if (this.documentOnly && this.currentDocumentsType != null) {
            this.headerCell.setVisibility(8);
            this.sectionCell.setVisibility(8);
        }
        if (((this.currentBotId != 0 || this.currentDocumentsType == null) && this.currentTypeValue != null && !this.documentOnly) || this.currentDocumentsTypeValue != null) {
            TLRPC$TL_secureValue tLRPC$TL_secureValue = this.currentDocumentsTypeValue;
            if (tLRPC$TL_secureValue != null) {
                addDocumentViews(tLRPC$TL_secureValue.files);
                addTranslationDocumentViews(this.currentDocumentsTypeValue.translation);
            }
            this.sectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            TextSettingsCell textSettingsCell3 = new TextSettingsCell(context);
            textSettingsCell3.setTextColor(Theme.getColor("windowBackgroundWhiteRedText3"));
            textSettingsCell3.setBackgroundDrawable(Theme.getSelectorDrawable(true));
            if (this.currentDocumentsType == null) {
                textSettingsCell3.setText(LocaleController.getString("PassportDeleteInfo", R.string.PassportDeleteInfo), false);
            } else {
                textSettingsCell3.setText(LocaleController.getString("PassportDeleteDocument", R.string.PassportDeleteDocument), false);
            }
            this.linearLayout2.addView(textSettingsCell3, LayoutHelper.createLinear(-1, -2));
            textSettingsCell3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$-0ec9IyOjkarkKAI5QlHJUGBZFE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$createAddressInterface$37$PassportActivity(view3);
                }
            });
            ShadowSectionCell shadowSectionCell2 = new ShadowSectionCell(context);
            this.sectionCell = shadowSectionCell2;
            shadowSectionCell2.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.linearLayout2.addView(this.sectionCell, LayoutHelper.createLinear(-1, -2));
        } else {
            this.sectionCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            if (this.documentOnly && this.currentDocumentsType != null) {
                this.bottomCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            }
        }
        updateUploadText(0);
        updateUploadText(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createAddressInterface$32$PassportActivity(View view) {
        this.uploadingFileType = 0;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createAddressInterface$33$PassportActivity(View view) {
        this.uploadingFileType = 4;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createAddressInterface$35$PassportActivity(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$61lEA6aKZqy85C1p9i5WuVl3WMQ
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$createAddressInterface$34$PassportActivity(country);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createAddressInterface$34$PassportActivity(CountrySelectActivity.Country country) {
        this.inputFields[5].setText(country.name);
        this.currentCitizeship = country.shortname;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createAddressInterface$36$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue() + 1;
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        if (iIntValue < editTextBoldCursorArr.length) {
            if (editTextBoldCursorArr[iIntValue].isFocusable()) {
                this.inputFields[iIntValue].requestFocus();
            } else {
                this.inputFields[iIntValue].dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0));
                textView.clearFocus();
                AndroidUtilities.hideKeyboard(textView);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createAddressInterface$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createAddressInterface$37$PassportActivity(View view) {
        createDocumentDeleteAlert();
    }

    private void createDocumentDeleteAlert() {
        final boolean[] zArr = {true};
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$YRfmB_qulvaYMioNP2OwefWYY6M
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createDocumentDeleteAlert$38$PassportActivity(zArr, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        boolean z = this.documentOnly;
        if (z && this.currentDocumentsType == null && (this.currentType.type instanceof TLRPC$TL_secureValueTypeAddress)) {
            builder.setMessage(LocaleController.getString("PassportDeleteAddressAlert", R.string.PassportDeleteAddressAlert));
        } else if (z && this.currentDocumentsType == null && (this.currentType.type instanceof TLRPC$TL_secureValueTypePersonalDetails)) {
            builder.setMessage(LocaleController.getString("PassportDeletePersonalAlert", R.string.PassportDeletePersonalAlert));
        } else {
            builder.setMessage(LocaleController.getString("PassportDeleteDocumentAlert", R.string.PassportDeleteDocumentAlert));
        }
        if (!this.documentOnly && this.currentDocumentsType != null) {
            FrameLayout frameLayout = new FrameLayout(getParentActivity());
            CheckBoxCell checkBoxCell = new CheckBoxCell(getParentActivity(), 1);
            checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
            TLRPC$SecureValueType tLRPC$SecureValueType = this.currentType.type;
            if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeAddress) {
                checkBoxCell.setText(LocaleController.getString("PassportDeleteDocumentAddress", R.string.PassportDeleteDocumentAddress), "", true, false);
            } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePersonalDetails) {
                checkBoxCell.setText(LocaleController.getString("PassportDeleteDocumentPersonal", R.string.PassportDeleteDocumentPersonal), "", true, false);
            }
            checkBoxCell.setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
            frameLayout.addView(checkBoxCell, LayoutHelper.createFrame(-1, 48, 51));
            checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$s5oQep39R3RVUHao83e_WL4VJVs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PassportActivity.lambda$createDocumentDeleteAlert$39(zArr, view);
                }
            });
            builder.setView(frameLayout);
        }
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createDocumentDeleteAlert$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createDocumentDeleteAlert$38$PassportActivity(boolean[] zArr, DialogInterface dialogInterface, int i) {
        if (!this.documentOnly) {
            this.currentValues.clear();
        }
        this.currentDocumentValues.clear();
        this.delegate.deleteValue(this.currentType, this.currentDocumentsType, this.availableDocumentTypes, zArr[0], null, null);
        finishFragment();
    }

    static /* synthetic */ void lambda$createDocumentDeleteAlert$39(boolean[] zArr, View view) {
        if (view.isEnabled()) {
            zArr[0] = !zArr[0];
            ((CheckBoxCell) view).setChecked(zArr[0], true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFieldError(View field) {
        if (field == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(field, 2.0f, 0);
        scrollToField(field);
    }

    private void scrollToField(View field) {
        while (field != null && this.linearLayout2.indexOfChild(field) < 0) {
            field = (View) field.getParent();
        }
        if (field != null) {
            this.scrollView.smoothScrollTo(0, field.getTop() - ((this.scrollView.getMeasuredHeight() - field.getMeasuredHeight()) / 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDocumentHash(SecureDocument document) {
        byte[] bArr;
        if (document == null) {
            return "";
        }
        TLRPC$TL_secureFile tLRPC$TL_secureFile = document.secureFile;
        if (tLRPC$TL_secureFile != null && (bArr = tLRPC$TL_secureFile.file_hash) != null) {
            return Base64.encodeToString(bArr, 2);
        }
        byte[] bArr2 = document.fileHash;
        return bArr2 != null ? Base64.encodeToString(bArr2, 2) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkFieldForError(EditTextBoldCursor field, String key, Editable s, boolean document) {
        String str;
        String str2;
        String str3;
        HashMap<String, String> map = this.errorsValues;
        if (map != null && (str = map.get(key)) != null && TextUtils.equals(str, s)) {
            HashMap<String, String> map2 = this.fieldsErrors;
            if (map2 != null && (str3 = map2.get(key)) != null) {
                field.setErrorText(str3);
            } else {
                HashMap<String, String> map3 = this.documentsErrors;
                if (map3 != null && (str2 = map3.get(key)) != null) {
                    field.setErrorText(str2);
                }
            }
        } else {
            field.setErrorText(null);
        }
        String str4 = document ? "error_document_all" : "error_all";
        HashMap<String, String> map4 = this.errorsValues;
        if (map4 == null || !map4.containsKey(str4)) {
            return;
        }
        this.errorsValues.remove(str4);
        checkTopErrorCell(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:138:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean checkFieldsForError() {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.checkFieldsForError():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0626  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createIdentityInterface(final android.content.Context r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.createIdentityInterface(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$40$PassportActivity(View view) {
        this.uploadingFileType = 2;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$41$PassportActivity(View view) {
        this.uploadingFileType = 3;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$42$PassportActivity(View view) {
        this.uploadingFileType = 1;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$43$PassportActivity(View view) {
        this.uploadingFileType = 4;
        openAttachMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$44$PassportActivity(View view) {
        if (Build.VERSION.SDK_INT >= 23 && getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
            getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 22);
            return;
        }
        CameraScanActivity cameraScanActivity = new CameraScanActivity(0);
        cameraScanActivity.setDelegate(new CameraScanActivity.CameraScanActivityDelegate() { // from class: ir.eitaa.ui.PassportActivity.14
            @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
            public /* synthetic */ void didFindQr(String str) {
                CameraScanActivity.CameraScanActivityDelegate.CC.$default$didFindQr(this, str);
            }

            @Override // ir.eitaa.ui.CameraScanActivity.CameraScanActivityDelegate
            public void didFindMrzInfo(MrzRecognizer.Result result) {
                if (!TextUtils.isEmpty(result.firstName)) {
                    PassportActivity.this.inputFields[0].setText(result.firstName);
                }
                if (!TextUtils.isEmpty(result.middleName)) {
                    PassportActivity.this.inputFields[1].setText(result.middleName);
                }
                if (!TextUtils.isEmpty(result.lastName)) {
                    PassportActivity.this.inputFields[2].setText(result.lastName);
                }
                int i = result.gender;
                if (i != 0) {
                    if (i == 1) {
                        PassportActivity.this.currentGender = "male";
                        PassportActivity.this.inputFields[4].setText(LocaleController.getString("PassportMale", R.string.PassportMale));
                    } else if (i == 2) {
                        PassportActivity.this.currentGender = "female";
                        PassportActivity.this.inputFields[4].setText(LocaleController.getString("PassportFemale", R.string.PassportFemale));
                    }
                }
                if (!TextUtils.isEmpty(result.nationality)) {
                    PassportActivity.this.currentCitizeship = result.nationality;
                    String str = (String) PassportActivity.this.languageMap.get(PassportActivity.this.currentCitizeship);
                    if (str != null) {
                        PassportActivity.this.inputFields[5].setText(str);
                    }
                }
                if (!TextUtils.isEmpty(result.issuingCountry)) {
                    PassportActivity.this.currentResidence = result.issuingCountry;
                    String str2 = (String) PassportActivity.this.languageMap.get(PassportActivity.this.currentResidence);
                    if (str2 != null) {
                        PassportActivity.this.inputFields[6].setText(str2);
                    }
                }
                if (result.birthDay <= 0 || result.birthMonth <= 0 || result.birthYear <= 0) {
                    return;
                }
                PassportActivity.this.inputFields[3].setText(String.format(Locale.US, "%02d.%02d.%d", Integer.valueOf(result.birthDay), Integer.valueOf(result.birthMonth), Integer.valueOf(result.birthYear)));
            }
        });
        presentFragment(cameraScanActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createIdentityInterface$46$PassportActivity(final View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$HBBDeAMPa5bI3KRhFefcJ6EJA1k
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$createIdentityInterface$45$PassportActivity(view, country);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$45$PassportActivity(View view, CountrySelectActivity.Country country) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        EditTextBoldCursor editTextBoldCursor = this.inputFields[iIntValue];
        if (iIntValue == 5) {
            this.currentCitizeship = country.shortname;
        } else {
            this.currentResidence = country.shortname;
        }
        editTextBoldCursor.setText(country.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createIdentityInterface$49$PassportActivity(Context context, View view, MotionEvent motionEvent) {
        String string;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iIntValue;
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.get(1);
            calendar.get(2);
            calendar.get(5);
            try {
                final EditTextBoldCursor editTextBoldCursor = (EditTextBoldCursor) view;
                final int iIntValue2 = ((Integer) editTextBoldCursor.getTag()).intValue();
                if (iIntValue2 == 8) {
                    string = LocaleController.getString("PassportSelectExpiredDate", R.string.PassportSelectExpiredDate);
                    i = 0;
                    i2 = 20;
                    i3 = 0;
                } else {
                    string = LocaleController.getString("PassportSelectBithdayDate", R.string.PassportSelectBithdayDate);
                    i = -120;
                    i2 = 0;
                    i3 = -18;
                }
                String[] strArrSplit = editTextBoldCursor.getText().toString().split("\\.");
                if (strArrSplit.length == 3) {
                    int iIntValue3 = Utilities.parseInt(strArrSplit[0]).intValue();
                    int iIntValue4 = Utilities.parseInt(strArrSplit[1]).intValue();
                    iIntValue = Utilities.parseInt(strArrSplit[2]).intValue();
                    i4 = iIntValue3;
                    i5 = iIntValue4;
                } else {
                    i4 = -1;
                    i5 = -1;
                    iIntValue = -1;
                }
                AlertDialog.Builder builderCreateDatePickerDialog = AlertsCreator.createDatePickerDialog(context, i, i2, i3, i4, i5, iIntValue, string, iIntValue2 == 8, new AlertsCreator.DatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$pJrYAQ3c84wSAGsQmlMSUnjHNV8
                    @Override // ir.eitaa.ui.Components.AlertsCreator.DatePickerDelegate
                    public final void didSelectDate(int i6, int i7, int i8) {
                        this.f$0.lambda$createIdentityInterface$47$PassportActivity(iIntValue2, editTextBoldCursor, i6, i7, i8);
                    }
                });
                if (iIntValue2 == 8) {
                    builderCreateDatePickerDialog.setNegativeButton(LocaleController.getString("PassportSelectNotExpire", R.string.PassportSelectNotExpire), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8171G5FstviHqixG4MMCCQjr1jE
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            this.f$0.lambda$createIdentityInterface$48$PassportActivity(editTextBoldCursor, dialogInterface, i6);
                        }
                    });
                }
                showDialog(builderCreateDatePickerDialog.create());
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$47$PassportActivity(int i, EditTextBoldCursor editTextBoldCursor, int i2, int i3, int i4) {
        if (i == 8) {
            int[] iArr = this.currentExpireDate;
            iArr[0] = i2;
            iArr[1] = i3 + 1;
            iArr[2] = i4;
        }
        editTextBoldCursor.setText(String.format(Locale.US, "%02d.%02d.%d", Integer.valueOf(i4), Integer.valueOf(i3 + 1), Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$48$PassportActivity(EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface, int i) {
        int[] iArr = this.currentExpireDate;
        iArr[2] = 0;
        iArr[1] = 0;
        iArr[0] = 0;
        editTextBoldCursor.setText(LocaleController.getString("PassportNoExpireDate", R.string.PassportNoExpireDate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createIdentityInterface$51$PassportActivity(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("PassportSelectGender", R.string.PassportSelectGender));
            builder.setItems(new CharSequence[]{LocaleController.getString("PassportMale", R.string.PassportMale), LocaleController.getString("PassportFemale", R.string.PassportFemale)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$C_dMw9F-6sYbmdX8FH1SxuLyVQA
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$createIdentityInterface$50$PassportActivity(dialogInterface, i);
                }
            });
            builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$50$PassportActivity(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            this.currentGender = "male";
            this.inputFields[4].setText(LocaleController.getString("PassportMale", R.string.PassportMale));
        } else if (i == 1) {
            this.currentGender = "female";
            this.inputFields[4].setText(LocaleController.getString("PassportFemale", R.string.PassportFemale));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createIdentityInterface$52$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue() + 1;
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        if (iIntValue < editTextBoldCursorArr.length) {
            if (editTextBoldCursorArr[iIntValue].isFocusable()) {
                this.inputFields[iIntValue].requestFocus();
            } else {
                this.inputFields[iIntValue].dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0));
                textView.clearFocus();
                AndroidUtilities.hideKeyboard(textView);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createIdentityInterface$53$PassportActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue() + 1;
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputExtraFields;
        if (iIntValue < editTextBoldCursorArr.length) {
            if (editTextBoldCursorArr[iIntValue].isFocusable()) {
                this.inputExtraFields[iIntValue].requestFocus();
            } else {
                this.inputExtraFields[iIntValue].dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 1, 0.0f, 0.0f, 0));
                textView.clearFocus();
                AndroidUtilities.hideKeyboard(textView);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createIdentityInterface$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createIdentityInterface$54$PassportActivity(View view) {
        createDocumentDeleteAlert();
    }

    private void updateInterfaceStringsForDocumentType() {
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = this.currentDocumentsType;
        if (tLRPC$TL_secureRequiredType != null) {
            this.actionBar.setTitle(getTextForType(tLRPC$TL_secureRequiredType.type));
        } else {
            this.actionBar.setTitle(LocaleController.getString("PassportPersonal", R.string.PassportPersonal));
        }
        updateUploadText(2);
        updateUploadText(3);
        updateUploadText(1);
        updateUploadText(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateUploadText(int r9) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.updateUploadText(int):void");
    }

    private void checkTopErrorCell(boolean init) {
        String str;
        String str2;
        if (this.topErrorCell == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = null;
        if (this.fieldsErrors != null && ((init || this.errorsValues.containsKey("error_all")) && (str2 = this.fieldsErrors.get("error_all")) != null)) {
            spannableStringBuilder = new SpannableStringBuilder(str2);
            if (init) {
                this.errorsValues.put("error_all", "");
            }
        }
        if (this.documentsErrors != null && ((init || this.errorsValues.containsKey("error_document_all")) && (str = this.documentsErrors.get("error_all")) != null)) {
            if (spannableStringBuilder == null) {
                spannableStringBuilder = new SpannableStringBuilder(str);
            } else {
                spannableStringBuilder.append((CharSequence) "\n\n").append((CharSequence) str);
            }
            if (init) {
                this.errorsValues.put("error_document_all", "");
            }
        }
        if (spannableStringBuilder != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Theme.getColor("windowBackgroundWhiteRedText3")), 0, spannableStringBuilder.length(), 33);
            this.topErrorCell.setText(spannableStringBuilder);
            this.topErrorCell.setVisibility(0);
        } else if (this.topErrorCell.getVisibility() != 8) {
            this.topErrorCell.setVisibility(8);
        }
    }

    private void addDocumentViewInternal(TLRPC$TL_secureFile f, int uploadingType) throws IOException {
        addDocumentView(new SecureDocument(getSecureDocumentKey(f.secret, f.file_hash), f, null, null, null), uploadingType);
    }

    private void addDocumentViews(ArrayList<TLRPC$SecureFile> files) throws IOException {
        this.documents.clear();
        int size = files.size();
        for (int i = 0; i < size; i++) {
            TLRPC$SecureFile tLRPC$SecureFile = files.get(i);
            if (tLRPC$SecureFile instanceof TLRPC$TL_secureFile) {
                addDocumentViewInternal((TLRPC$TL_secureFile) tLRPC$SecureFile, 0);
            }
        }
    }

    private void addTranslationDocumentViews(ArrayList<TLRPC$SecureFile> files) throws IOException {
        this.translationDocuments.clear();
        int size = files.size();
        for (int i = 0; i < size; i++) {
            TLRPC$SecureFile tLRPC$SecureFile = files.get(i);
            if (tLRPC$SecureFile instanceof TLRPC$TL_secureFile) {
                addDocumentViewInternal((TLRPC$TL_secureFile) tLRPC$SecureFile, 4);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setFieldValues(java.util.HashMap<java.lang.String, java.lang.String> r7, ir.eitaa.ui.Components.EditTextBoldCursor r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.setFieldValues(java.util.HashMap, ir.eitaa.ui.Components.EditTextBoldCursor, java.lang.String):void");
    }

    private void addDocumentView(final SecureDocument document, final int type) throws IOException {
        String string;
        String str;
        String dateForBan;
        HashMap<String, String> map;
        if (type == 1) {
            this.selfieDocument = document;
            if (this.selfieLayout == null) {
                return;
            }
        } else if (type == 4) {
            this.translationDocuments.add(document);
            if (this.translationLayout == null) {
                return;
            }
        } else if (type == 2) {
            this.frontDocument = document;
            if (this.frontLayout == null) {
                return;
            }
        } else if (type == 3) {
            this.reverseDocument = document;
            if (this.reverseLayout == null) {
                return;
            }
        } else {
            this.documents.add(document);
            if (this.documentsLayout == null) {
                return;
            }
        }
        if (getParentActivity() == null) {
            return;
        }
        final SecureDocumentCell secureDocumentCell = new SecureDocumentCell(getParentActivity());
        secureDocumentCell.setTag(document);
        secureDocumentCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        this.documentsCells.put(document, secureDocumentCell);
        String documentHash = getDocumentHash(document);
        if (type == 1) {
            string = LocaleController.getString("PassportSelfie", R.string.PassportSelfie);
            this.selfieLayout.addView(secureDocumentCell, LayoutHelper.createLinear(-1, -2));
            str = "selfie" + documentHash;
        } else if (type == 4) {
            string = LocaleController.getString("AttachPhoto", R.string.AttachPhoto);
            this.translationLayout.addView(secureDocumentCell, LayoutHelper.createLinear(-1, -2));
            str = "translation" + documentHash;
        } else if (type == 2) {
            TLRPC$SecureValueType tLRPC$SecureValueType = this.currentDocumentsType.type;
            if ((tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePassport) || (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeInternalPassport)) {
                string = LocaleController.getString("PassportMainPage", R.string.PassportMainPage);
            } else {
                string = LocaleController.getString("PassportFrontSide", R.string.PassportFrontSide);
            }
            this.frontLayout.addView(secureDocumentCell, LayoutHelper.createLinear(-1, -2));
            str = "front" + documentHash;
        } else if (type == 3) {
            string = LocaleController.getString("PassportReverseSide", R.string.PassportReverseSide);
            this.reverseLayout.addView(secureDocumentCell, LayoutHelper.createLinear(-1, -2));
            str = "reverse" + documentHash;
        } else {
            string = LocaleController.getString("AttachPhoto", R.string.AttachPhoto);
            this.documentsLayout.addView(secureDocumentCell, LayoutHelper.createLinear(-1, -2));
            str = "files" + documentHash;
        }
        final String str2 = str;
        if (str2 != null && (map = this.documentsErrors) != null && (dateForBan = map.get(str2)) != null) {
            secureDocumentCell.valueTextView.setTextColor(Theme.getColor("windowBackgroundWhiteRedText3"));
            this.errorsValues.put(str2, "");
        } else {
            dateForBan = LocaleController.formatDateForBan(document.secureFile.date);
        }
        secureDocumentCell.setTextAndValueAndImage(string, dateForBan, document);
        secureDocumentCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$46Ob72SuEOEwM8bFUrb5l3q_xm8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f$0.lambda$addDocumentView$55$PassportActivity(type, view);
            }
        });
        secureDocumentCell.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$53CtsBj-tjux916bD1xOoGM796c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.lambda$addDocumentView$57$PassportActivity(type, document, secureDocumentCell, str2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addDocumentView$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addDocumentView$55$PassportActivity(int i, View view) throws Resources.NotFoundException {
        this.uploadingFileType = i;
        if (i == 1) {
            this.currentPhotoViewerLayout = this.selfieLayout;
        } else if (i == 4) {
            this.currentPhotoViewerLayout = this.translationLayout;
        } else if (i == 2) {
            this.currentPhotoViewerLayout = this.frontLayout;
        } else if (i == 3) {
            this.currentPhotoViewerLayout = this.reverseLayout;
        } else {
            this.currentPhotoViewerLayout = this.documentsLayout;
        }
        SecureDocument secureDocument = (SecureDocument) view.getTag();
        PhotoViewer.getInstance().setParentActivity(getParentActivity());
        if (i == 1) {
            ArrayList<SecureDocument> arrayList = new ArrayList<>();
            arrayList.add(this.selfieDocument);
            PhotoViewer.getInstance().openPhoto(arrayList, 0, this.provider);
            return;
        }
        if (i == 2) {
            ArrayList<SecureDocument> arrayList2 = new ArrayList<>();
            arrayList2.add(this.frontDocument);
            PhotoViewer.getInstance().openPhoto(arrayList2, 0, this.provider);
        } else if (i == 3) {
            ArrayList<SecureDocument> arrayList3 = new ArrayList<>();
            arrayList3.add(this.reverseDocument);
            PhotoViewer.getInstance().openPhoto(arrayList3, 0, this.provider);
        } else if (i == 0) {
            PhotoViewer photoViewer = PhotoViewer.getInstance();
            ArrayList<SecureDocument> arrayList4 = this.documents;
            photoViewer.openPhoto(arrayList4, arrayList4.indexOf(secureDocument), this.provider);
        } else {
            PhotoViewer photoViewer2 = PhotoViewer.getInstance();
            ArrayList<SecureDocument> arrayList5 = this.translationDocuments;
            photoViewer2.openPhoto(arrayList5, arrayList5.indexOf(secureDocument), this.provider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addDocumentView$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$addDocumentView$57$PassportActivity(final int i, final SecureDocument secureDocument, final SecureDocumentCell secureDocumentCell, final String str, View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        if (i == 1) {
            builder.setMessage(LocaleController.getString("PassportDeleteSelfie", R.string.PassportDeleteSelfie));
        } else {
            builder.setMessage(LocaleController.getString("PassportDeleteScan", R.string.PassportDeleteScan));
        }
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$nljScz56NhL8noH7W9m-6qfeN5Y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$addDocumentView$56$PassportActivity(secureDocument, i, secureDocumentCell, str, dialogInterface, i2);
            }
        });
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addDocumentView$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addDocumentView$56$PassportActivity(SecureDocument secureDocument, int i, SecureDocumentCell secureDocumentCell, String str, DialogInterface dialogInterface, int i2) {
        this.documentsCells.remove(secureDocument);
        if (i == 1) {
            this.selfieDocument = null;
            this.selfieLayout.removeView(secureDocumentCell);
        } else if (i == 4) {
            this.translationDocuments.remove(secureDocument);
            this.translationLayout.removeView(secureDocumentCell);
        } else if (i == 2) {
            this.frontDocument = null;
            this.frontLayout.removeView(secureDocumentCell);
        } else if (i == 3) {
            this.reverseDocument = null;
            this.reverseLayout.removeView(secureDocumentCell);
        } else {
            this.documents.remove(secureDocument);
            this.documentsLayout.removeView(secureDocumentCell);
        }
        if (str != null) {
            HashMap<String, String> map = this.documentsErrors;
            if (map != null) {
                map.remove(str);
            }
            HashMap<String, String> map2 = this.errorsValues;
            if (map2 != null) {
                map2.remove(str);
            }
        }
        updateUploadText(i);
        String str2 = secureDocument.path;
        if (str2 == null || this.uploadingDocuments.remove(str2) == null) {
            return;
        }
        if (this.uploadingDocuments.isEmpty()) {
            this.doneItem.setEnabled(true);
            this.doneItem.setAlpha(1.0f);
        }
        FileLoader.getInstance(this.currentAccount).cancelFileUpload(secureDocument.path, false);
    }

    private String getNameForType(TLRPC$SecureValueType type) {
        return type instanceof TLRPC$TL_secureValueTypePersonalDetails ? "personal_details" : type instanceof TLRPC$TL_secureValueTypePassport ? "passport" : type instanceof TLRPC$TL_secureValueTypeInternalPassport ? "internal_passport" : type instanceof TLRPC$TL_secureValueTypeDriverLicense ? "driver_license" : type instanceof TLRPC$TL_secureValueTypeIdentityCard ? "identity_card" : type instanceof TLRPC$TL_secureValueTypeUtilityBill ? "utility_bill" : type instanceof TLRPC$TL_secureValueTypeAddress ? "address" : type instanceof TLRPC$TL_secureValueTypeBankStatement ? "bank_statement" : type instanceof TLRPC$TL_secureValueTypeRentalAgreement ? "rental_agreement" : type instanceof TLRPC$TL_secureValueTypeTemporaryRegistration ? "temporary_registration" : type instanceof TLRPC$TL_secureValueTypePassportRegistration ? "passport_registration" : type instanceof TLRPC$TL_secureValueTypeEmail ? "email" : type instanceof TLRPC$TL_secureValueTypePhone ? "phone" : "";
    }

    private TextDetailSecureCell getViewByType(TLRPC$TL_secureRequiredType requiredType) {
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType;
        TextDetailSecureCell textDetailSecureCell = this.typesViews.get(requiredType);
        return (textDetailSecureCell != null || (tLRPC$TL_secureRequiredType = this.documentsToTypesLink.get(requiredType)) == null) ? textDetailSecureCell : this.typesViews.get(tLRPC$TL_secureRequiredType);
    }

    private String getTextForType(TLRPC$SecureValueType type) {
        if (type instanceof TLRPC$TL_secureValueTypePassport) {
            return LocaleController.getString("ActionBotDocumentPassport", R.string.ActionBotDocumentPassport);
        }
        if (type instanceof TLRPC$TL_secureValueTypeDriverLicense) {
            return LocaleController.getString("ActionBotDocumentDriverLicence", R.string.ActionBotDocumentDriverLicence);
        }
        if (type instanceof TLRPC$TL_secureValueTypeIdentityCard) {
            return LocaleController.getString("ActionBotDocumentIdentityCard", R.string.ActionBotDocumentIdentityCard);
        }
        if (type instanceof TLRPC$TL_secureValueTypeUtilityBill) {
            return LocaleController.getString("ActionBotDocumentUtilityBill", R.string.ActionBotDocumentUtilityBill);
        }
        if (type instanceof TLRPC$TL_secureValueTypeBankStatement) {
            return LocaleController.getString("ActionBotDocumentBankStatement", R.string.ActionBotDocumentBankStatement);
        }
        if (type instanceof TLRPC$TL_secureValueTypeRentalAgreement) {
            return LocaleController.getString("ActionBotDocumentRentalAgreement", R.string.ActionBotDocumentRentalAgreement);
        }
        if (type instanceof TLRPC$TL_secureValueTypeInternalPassport) {
            return LocaleController.getString("ActionBotDocumentInternalPassport", R.string.ActionBotDocumentInternalPassport);
        }
        if (type instanceof TLRPC$TL_secureValueTypePassportRegistration) {
            return LocaleController.getString("ActionBotDocumentPassportRegistration", R.string.ActionBotDocumentPassportRegistration);
        }
        if (type instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) {
            return LocaleController.getString("ActionBotDocumentTemporaryRegistration", R.string.ActionBotDocumentTemporaryRegistration);
        }
        if (type instanceof TLRPC$TL_secureValueTypePhone) {
            return LocaleController.getString("ActionBotDocumentPhone", R.string.ActionBotDocumentPhone);
        }
        return type instanceof TLRPC$TL_secureValueTypeEmail ? LocaleController.getString("ActionBotDocumentEmail", R.string.ActionBotDocumentEmail) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0290 A[Catch: Exception -> 0x03e3, TryCatch #5 {Exception -> 0x03e3, blocks: (B:105:0x0218, B:130:0x0289, B:132:0x028d, B:134:0x0290, B:137:0x029a, B:109:0x0236), top: B:325:0x0218 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x033e A[PHI: r1
      0x033e: PHI (r1v18 java.lang.Object) = (r1v16 java.lang.Object), (r1v19 java.lang.Object), (r1v22 java.lang.Object) binds: [B:178:0x033a, B:175:0x0330, B:170:0x031d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0375 A[Catch: Exception -> 0x0395, TryCatch #3 {Exception -> 0x0395, blocks: (B:140:0x02a6, B:142:0x02ae, B:144:0x02b4, B:146:0x02be, B:148:0x02c6, B:151:0x02d0, B:153:0x02d6, B:155:0x02de, B:157:0x02e6, B:159:0x02ee, B:162:0x02f7, B:163:0x02fd, B:164:0x0302, B:186:0x0347, B:187:0x034b, B:189:0x0353, B:190:0x0360, B:192:0x0368, B:193:0x0375, B:195:0x0380, B:171:0x0320, B:174:0x032a, B:177:0x0334), top: B:321:0x02a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0380 A[Catch: Exception -> 0x0395, TRY_LEAVE, TryCatch #3 {Exception -> 0x0395, blocks: (B:140:0x02a6, B:142:0x02ae, B:144:0x02b4, B:146:0x02be, B:148:0x02c6, B:151:0x02d0, B:153:0x02d6, B:155:0x02de, B:157:0x02e6, B:159:0x02ee, B:162:0x02f7, B:163:0x02fd, B:164:0x0302, B:186:0x0347, B:187:0x034b, B:189:0x0353, B:190:0x0360, B:192:0x0368, B:193:0x0375, B:195:0x0380, B:171:0x0320, B:174:0x032a, B:177:0x0334), top: B:321:0x02a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTypeValue(ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r31, java.lang.String r32, java.lang.String r33, ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r34, java.lang.String r35, boolean r36, int r37) throws org.json.JSONException, java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.setTypeValue(ir.eitaa.tgnet.TLRPC$TL_secureRequiredType, java.lang.String, java.lang.String, ir.eitaa.tgnet.TLRPC$TL_secureRequiredType, java.lang.String, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNativeFields(boolean byEdit) {
        EditTextBoldCursor[] editTextBoldCursorArr;
        if (this.inputExtraFields == null) {
            return;
        }
        String str = this.languageMap.get(this.currentResidence);
        String str2 = SharedConfig.getCountryLangs().get(this.currentResidence);
        int i = 0;
        if (!this.currentType.native_names || TextUtils.isEmpty(this.currentResidence) || "EN".equals(str2)) {
            if (this.nativeInfoCell.getVisibility() != 8) {
                this.nativeInfoCell.setVisibility(8);
                this.headerCell.setVisibility(8);
                this.extraBackgroundView2.setVisibility(8);
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.inputExtraFields;
                    if (i >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    ((View) editTextBoldCursorArr2[i].getParent()).setVisibility(8);
                    i++;
                }
                if (((this.currentBotId != 0 || this.currentDocumentsType == null) && this.currentTypeValue != null && !this.documentOnly) || this.currentDocumentsTypeValue != null) {
                    this.sectionCell2.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                } else {
                    this.sectionCell2.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                }
            }
            return;
        }
        if (this.nativeInfoCell.getVisibility() != 0) {
            this.nativeInfoCell.setVisibility(0);
            this.headerCell.setVisibility(0);
            this.extraBackgroundView2.setVisibility(0);
            int i2 = 0;
            while (true) {
                editTextBoldCursorArr = this.inputExtraFields;
                if (i2 >= editTextBoldCursorArr.length) {
                    break;
                }
                ((View) editTextBoldCursorArr[i2].getParent()).setVisibility(0);
                i2++;
            }
            if (editTextBoldCursorArr[0].length() == 0 && this.inputExtraFields[1].length() == 0 && this.inputExtraFields[2].length() == 0) {
                int i3 = 0;
                while (true) {
                    boolean[] zArr = this.nonLatinNames;
                    if (i3 >= zArr.length) {
                        break;
                    }
                    if (zArr[i3]) {
                        this.inputExtraFields[0].setText(this.inputFields[0].getText());
                        this.inputExtraFields[1].setText(this.inputFields[1].getText());
                        this.inputExtraFields[2].setText(this.inputFields[2].getText());
                        break;
                    }
                    i3++;
                }
            }
            this.sectionCell2.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
        }
        this.nativeInfoCell.setText(LocaleController.formatString("PassportNativeInfo", R.string.PassportNativeInfo, str));
        String serverString = str2 != null ? LocaleController.getServerString("PassportLanguage_" + str2) : null;
        if (serverString != null) {
            this.headerCell.setText(LocaleController.formatString("PassportNativeHeaderLang", R.string.PassportNativeHeaderLang, serverString));
        } else {
            this.headerCell.setText(LocaleController.getString("PassportNativeHeader", R.string.PassportNativeHeader));
        }
        for (int i4 = 0; i4 < 3; i4++) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (serverString != null) {
                            this.inputExtraFields[i4].setHintText(LocaleController.getString("PassportSurname", R.string.PassportSurname));
                        } else {
                            this.inputExtraFields[i4].setHintText(LocaleController.formatString("PassportSurnameCountry", R.string.PassportSurnameCountry, str));
                        }
                    }
                } else if (serverString != null) {
                    this.inputExtraFields[i4].setHintText(LocaleController.getString("PassportMidname", R.string.PassportMidname));
                } else {
                    this.inputExtraFields[i4].setHintText(LocaleController.formatString("PassportMidnameCountry", R.string.PassportMidnameCountry, str));
                }
            } else if (serverString != null) {
                this.inputExtraFields[i4].setHintText(LocaleController.getString("PassportName", R.string.PassportName));
            } else {
                this.inputExtraFields[i4].setHintText(LocaleController.formatString("PassportNameCountry", R.string.PassportNameCountry, str));
            }
        }
        if (byEdit) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$6BdhpzZKLFYCsZqh5ABkr46h2Yw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkNativeFields$58$PassportActivity();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkNativeFields$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkNativeFields$58$PassportActivity() {
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputExtraFields;
        if (editTextBoldCursorArr != null) {
            scrollToField(editTextBoldCursorArr[0]);
        }
    }

    private TLRPC$TL_secureValue getValueByType(TLRPC$TL_secureRequiredType requiredType, boolean check) {
        String[] strArr;
        JSONObject jSONObject;
        if (requiredType == null) {
            return null;
        }
        int size = this.currentForm.values.size();
        for (int i = 0; i < size; i++) {
            TLRPC$TL_secureValue tLRPC$TL_secureValue = this.currentForm.values.get(i);
            if (requiredType.type.getClass() == tLRPC$TL_secureValue.type.getClass()) {
                if (check) {
                    if (requiredType.selfie_required && !(tLRPC$TL_secureValue.selfie instanceof TLRPC$TL_secureFile)) {
                        return null;
                    }
                    if (requiredType.translation_required && tLRPC$TL_secureValue.translation.isEmpty()) {
                        return null;
                    }
                    if (isAddressDocument(requiredType.type) && tLRPC$TL_secureValue.files.isEmpty()) {
                        return null;
                    }
                    if (isPersonalDocument(requiredType.type) && !(tLRPC$TL_secureValue.front_side instanceof TLRPC$TL_secureFile)) {
                        return null;
                    }
                    TLRPC$SecureValueType tLRPC$SecureValueType = requiredType.type;
                    if (((tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeDriverLicense) || (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeIdentityCard)) && !(tLRPC$TL_secureValue.reverse_side instanceof TLRPC$TL_secureFile)) {
                        return null;
                    }
                    if ((tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePersonalDetails) || (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeAddress)) {
                        if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePersonalDetails) {
                            strArr = requiredType.native_names ? new String[]{"first_name_native", "last_name_native", "birth_date", "gender", "country_code", "residence_country_code"} : new String[]{"first_name", "last_name", "birth_date", "gender", "country_code", "residence_country_code"};
                        } else {
                            strArr = new String[]{"street_line1", "street_line2", "post_code", "city", "state", "country_code"};
                        }
                        try {
                            TLRPC$TL_secureData tLRPC$TL_secureData = tLRPC$TL_secureValue.data;
                            jSONObject = new JSONObject(decryptData(tLRPC$TL_secureData.data, decryptValueSecret(tLRPC$TL_secureData.secret, tLRPC$TL_secureData.data_hash), tLRPC$TL_secureValue.data.data_hash));
                        } catch (Throwable unused) {
                        }
                        for (int i2 = 0; i2 < strArr.length; i2++) {
                            if (!jSONObject.has(strArr[i2]) || TextUtils.isEmpty(jSONObject.getString(strArr[i2]))) {
                                return null;
                            }
                        }
                    }
                }
                return tLRPC$TL_secureValue;
            }
        }
        return null;
    }

    private void openTypeActivity(TLRPC$TL_secureRequiredType requiredType, TLRPC$TL_secureRequiredType documentRequiredType, ArrayList<TLRPC$TL_secureRequiredType> availableDocumentTypes, final boolean documentOnly) {
        int i;
        TLRPC$TL_account_password tLRPC$TL_account_password;
        HashMap<String, String> map;
        final int size = availableDocumentTypes != null ? availableDocumentTypes.size() : 0;
        final TLRPC$SecureValueType tLRPC$SecureValueType = requiredType.type;
        TLRPC$SecureValueType tLRPC$SecureValueType2 = documentRequiredType != null ? documentRequiredType.type : null;
        if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePersonalDetails) {
            i = 1;
        } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeAddress) {
            i = 2;
        } else if (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePhone) {
            i = 3;
        } else {
            i = tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeEmail ? 4 : -1;
        }
        if (i != -1) {
            HashMap<String, String> map2 = !documentOnly ? this.errorsMap.get(getNameForType(tLRPC$SecureValueType)) : null;
            HashMap<String, String> map3 = this.errorsMap.get(getNameForType(tLRPC$SecureValueType2));
            TLRPC$TL_secureValue valueByType = getValueByType(requiredType, false);
            TLRPC$TL_secureValue valueByType2 = getValueByType(documentRequiredType, false);
            TLRPC$TL_account_authorizationForm tLRPC$TL_account_authorizationForm = this.currentForm;
            TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
            HashMap<String, String> map4 = this.typesValues.get(requiredType);
            if (documentRequiredType != null) {
                tLRPC$TL_account_password = tLRPC$TL_account_password2;
                map = this.typesValues.get(documentRequiredType);
            } else {
                tLRPC$TL_account_password = tLRPC$TL_account_password2;
                map = null;
            }
            int i2 = i;
            PassportActivity passportActivity = new PassportActivity(i, tLRPC$TL_account_authorizationForm, tLRPC$TL_account_password, requiredType, valueByType, documentRequiredType, valueByType2, map4, map);
            passportActivity.delegate = new PassportActivityDelegate() { // from class: ir.eitaa.ui.PassportActivity.20
                private TLRPC$InputSecureFile getInputSecureFile(SecureDocument document) {
                    if (document.inputFile != null) {
                        TLRPC$TL_inputSecureFileUploaded tLRPC$TL_inputSecureFileUploaded = new TLRPC$TL_inputSecureFileUploaded();
                        TLRPC$TL_inputFile tLRPC$TL_inputFile = document.inputFile;
                        tLRPC$TL_inputSecureFileUploaded.id = tLRPC$TL_inputFile.id;
                        tLRPC$TL_inputSecureFileUploaded.parts = tLRPC$TL_inputFile.parts;
                        tLRPC$TL_inputSecureFileUploaded.md5_checksum = tLRPC$TL_inputFile.md5_checksum;
                        tLRPC$TL_inputSecureFileUploaded.file_hash = document.fileHash;
                        tLRPC$TL_inputSecureFileUploaded.secret = document.fileSecret;
                        return tLRPC$TL_inputSecureFileUploaded;
                    }
                    TLRPC$TL_inputSecureFile tLRPC$TL_inputSecureFile = new TLRPC$TL_inputSecureFile();
                    TLRPC$TL_secureFile tLRPC$TL_secureFile = document.secureFile;
                    tLRPC$TL_inputSecureFile.id = tLRPC$TL_secureFile.id;
                    tLRPC$TL_inputSecureFile.access_hash = tLRPC$TL_secureFile.access_hash;
                    return tLRPC$TL_inputSecureFile;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void renameFile(SecureDocument oldDocument, TLRPC$TL_secureFile newSecureFile) {
                    File pathToAttach = FileLoader.getPathToAttach(oldDocument);
                    String str = oldDocument.secureFile.dc_id + "_" + oldDocument.secureFile.id;
                    File pathToAttach2 = FileLoader.getPathToAttach(newSecureFile);
                    String str2 = newSecureFile.dc_id + "_" + newSecureFile.id;
                    pathToAttach.renameTo(pathToAttach2);
                    ImageLoader.getInstance().replaceImageInCache(str, str2, null, false);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // ir.eitaa.ui.PassportActivity.PassportActivityDelegate
                public void saveValue(TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, String str, String str2, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2, String str3, ArrayList<SecureDocument> arrayList, SecureDocument secureDocument, ArrayList<SecureDocument> arrayList2, SecureDocument secureDocument2, SecureDocument secureDocument3, Runnable runnable, ErrorRunnable errorRunnable) throws NoSuchAlgorithmException {
                    TLRPC$TL_inputSecureValue tLRPC$TL_inputSecureValue;
                    TLRPC$TL_securePlainPhone tLRPC$TL_securePlainPhone;
                    TLRPC$TL_inputSecureValue tLRPC$TL_inputSecureValue2;
                    if (!TextUtils.isEmpty(str2)) {
                        tLRPC$TL_inputSecureValue = new TLRPC$TL_inputSecureValue();
                        tLRPC$TL_inputSecureValue.type = tLRPC$TL_secureRequiredType.type;
                        tLRPC$TL_inputSecureValue.flags |= 1;
                        EncryptionResult encryptionResultEncryptData = PassportActivity.this.encryptData(AndroidUtilities.getStringBytes(str2));
                        TLRPC$TL_secureData tLRPC$TL_secureData = new TLRPC$TL_secureData();
                        tLRPC$TL_inputSecureValue.data = tLRPC$TL_secureData;
                        tLRPC$TL_secureData.data = encryptionResultEncryptData.encryptedData;
                        tLRPC$TL_secureData.data_hash = encryptionResultEncryptData.fileHash;
                        tLRPC$TL_secureData.secret = encryptionResultEncryptData.fileSecret;
                    } else if (TextUtils.isEmpty(str)) {
                        tLRPC$TL_inputSecureValue = null;
                    } else {
                        TLRPC$SecureValueType tLRPC$SecureValueType3 = tLRPC$SecureValueType;
                        if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeEmail) {
                            TLRPC$TL_securePlainEmail tLRPC$TL_securePlainEmail = new TLRPC$TL_securePlainEmail();
                            tLRPC$TL_securePlainEmail.email = str;
                            tLRPC$TL_securePlainPhone = tLRPC$TL_securePlainEmail;
                        } else {
                            if (!(tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypePhone)) {
                                return;
                            }
                            TLRPC$TL_securePlainPhone tLRPC$TL_securePlainPhone2 = new TLRPC$TL_securePlainPhone();
                            tLRPC$TL_securePlainPhone2.phone = str;
                            tLRPC$TL_securePlainPhone = tLRPC$TL_securePlainPhone2;
                        }
                        TLRPC$TL_inputSecureValue tLRPC$TL_inputSecureValue3 = new TLRPC$TL_inputSecureValue();
                        tLRPC$TL_inputSecureValue3.type = tLRPC$TL_secureRequiredType.type;
                        tLRPC$TL_inputSecureValue3.flags |= 32;
                        tLRPC$TL_inputSecureValue3.plain_data = tLRPC$TL_securePlainPhone;
                        tLRPC$TL_inputSecureValue = tLRPC$TL_inputSecureValue3;
                    }
                    if (!documentOnly && tLRPC$TL_inputSecureValue == null) {
                        if (errorRunnable != null) {
                            errorRunnable.onError(null, null);
                            return;
                        }
                        return;
                    }
                    if (tLRPC$TL_secureRequiredType2 != null) {
                        TLRPC$TL_inputSecureValue tLRPC$TL_inputSecureValue4 = new TLRPC$TL_inputSecureValue();
                        tLRPC$TL_inputSecureValue4.type = tLRPC$TL_secureRequiredType2.type;
                        if (!TextUtils.isEmpty(str3)) {
                            tLRPC$TL_inputSecureValue4.flags |= 1;
                            EncryptionResult encryptionResultEncryptData2 = PassportActivity.this.encryptData(AndroidUtilities.getStringBytes(str3));
                            TLRPC$TL_secureData tLRPC$TL_secureData2 = new TLRPC$TL_secureData();
                            tLRPC$TL_inputSecureValue4.data = tLRPC$TL_secureData2;
                            tLRPC$TL_secureData2.data = encryptionResultEncryptData2.encryptedData;
                            tLRPC$TL_secureData2.data_hash = encryptionResultEncryptData2.fileHash;
                            tLRPC$TL_secureData2.secret = encryptionResultEncryptData2.fileSecret;
                        }
                        if (secureDocument2 != null) {
                            tLRPC$TL_inputSecureValue4.front_side = getInputSecureFile(secureDocument2);
                            tLRPC$TL_inputSecureValue4.flags |= 2;
                        }
                        if (secureDocument3 != null) {
                            tLRPC$TL_inputSecureValue4.reverse_side = getInputSecureFile(secureDocument3);
                            tLRPC$TL_inputSecureValue4.flags |= 4;
                        }
                        if (secureDocument != null) {
                            tLRPC$TL_inputSecureValue4.selfie = getInputSecureFile(secureDocument);
                            tLRPC$TL_inputSecureValue4.flags |= 8;
                        }
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            tLRPC$TL_inputSecureValue4.flags |= 64;
                            int size2 = arrayList2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                tLRPC$TL_inputSecureValue4.translation.add(getInputSecureFile(arrayList2.get(i3)));
                            }
                        }
                        if (arrayList != null && !arrayList.isEmpty()) {
                            tLRPC$TL_inputSecureValue4.flags |= 16;
                            int size3 = arrayList.size();
                            for (int i4 = 0; i4 < size3; i4++) {
                                tLRPC$TL_inputSecureValue4.files.add(getInputSecureFile(arrayList.get(i4)));
                            }
                        }
                        if (documentOnly) {
                            tLRPC$TL_inputSecureValue = tLRPC$TL_inputSecureValue4;
                            tLRPC$TL_inputSecureValue2 = null;
                        } else {
                            tLRPC$TL_inputSecureValue2 = tLRPC$TL_inputSecureValue4;
                        }
                    } else {
                        tLRPC$TL_inputSecureValue2 = null;
                    }
                    TLRPC$TL_account_saveSecureValue tLRPC$TL_account_saveSecureValue = new TLRPC$TL_account_saveSecureValue();
                    tLRPC$TL_account_saveSecureValue.value = tLRPC$TL_inputSecureValue;
                    tLRPC$TL_account_saveSecureValue.secure_secret_id = PassportActivity.this.secureSecretId;
                    ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_account_saveSecureValue, new AnonymousClass1(errorRunnable, str, tLRPC$TL_account_saveSecureValue, tLRPC$TL_secureRequiredType2, tLRPC$TL_secureRequiredType, arrayList, secureDocument, secureDocument2, secureDocument3, arrayList2, str2, str3, runnable, this, tLRPC$TL_inputSecureValue2));
                }

                /* renamed from: ir.eitaa.ui.PassportActivity$20$1, reason: invalid class name */
                class AnonymousClass1 implements RequestDelegate {
                    final /* synthetic */ PassportActivityDelegate val$currentDelegate;
                    final /* synthetic */ TLRPC$TL_secureRequiredType val$documentRequiredType;
                    final /* synthetic */ ArrayList val$documents;
                    final /* synthetic */ String val$documentsJson;
                    final /* synthetic */ ErrorRunnable val$errorRunnable;
                    final /* synthetic */ TLRPC$TL_inputSecureValue val$finalFileInputSecureValue;
                    final /* synthetic */ Runnable val$finishRunnable;
                    final /* synthetic */ SecureDocument val$front;
                    final /* synthetic */ String val$json;
                    final /* synthetic */ TLRPC$TL_account_saveSecureValue val$req;
                    final /* synthetic */ TLRPC$TL_secureRequiredType val$requiredType;
                    final /* synthetic */ SecureDocument val$reverse;
                    final /* synthetic */ SecureDocument val$selfie;
                    final /* synthetic */ String val$text;
                    final /* synthetic */ ArrayList val$translationDocuments;

                    AnonymousClass1(final ErrorRunnable val$errorRunnable, final String val$text, final TLRPC$TL_account_saveSecureValue val$req, final TLRPC$TL_secureRequiredType val$documentRequiredType, final TLRPC$TL_secureRequiredType val$requiredType, final ArrayList val$documents, final SecureDocument val$selfie, final SecureDocument val$front, final SecureDocument val$reverse, final ArrayList val$translationDocuments, final String val$json, final String val$documentsJson, final Runnable val$finishRunnable, final PassportActivityDelegate val$currentDelegate, final TLRPC$TL_inputSecureValue val$finalFileInputSecureValue) {
                        this.val$errorRunnable = val$errorRunnable;
                        this.val$text = val$text;
                        this.val$req = val$req;
                        this.val$documentRequiredType = val$documentRequiredType;
                        this.val$requiredType = val$requiredType;
                        this.val$documents = val$documents;
                        this.val$selfie = val$selfie;
                        this.val$front = val$front;
                        this.val$reverse = val$reverse;
                        this.val$translationDocuments = val$translationDocuments;
                        this.val$json = val$json;
                        this.val$documentsJson = val$documentsJson;
                        this.val$finishRunnable = val$finishRunnable;
                        this.val$currentDelegate = val$currentDelegate;
                        this.val$finalFileInputSecureValue = val$finalFileInputSecureValue;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* renamed from: onResult, reason: merged with bridge method [inline-methods] */
                    public void lambda$run$4$PassportActivity$20$1(final TLRPC$TL_error error, final TLRPC$TL_secureValue newValue, final TLRPC$TL_secureValue newPendingValue) {
                        final ErrorRunnable errorRunnable = this.val$errorRunnable;
                        final String str = this.val$text;
                        final TLRPC$TL_account_saveSecureValue tLRPC$TL_account_saveSecureValue = this.val$req;
                        AnonymousClass20 anonymousClass20 = AnonymousClass20.this;
                        final boolean z = documentOnly;
                        final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = this.val$documentRequiredType;
                        final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2 = this.val$requiredType;
                        final ArrayList arrayList = this.val$documents;
                        final SecureDocument secureDocument = this.val$selfie;
                        final SecureDocument secureDocument2 = this.val$front;
                        final SecureDocument secureDocument3 = this.val$reverse;
                        final ArrayList arrayList2 = this.val$translationDocuments;
                        final String str2 = this.val$json;
                        final String str3 = this.val$documentsJson;
                        final int i = size;
                        final Runnable runnable = this.val$finishRunnable;
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$20$1$z9PCHThb3aWtozRSUKVGmdTZK7E
                            @Override // java.lang.Runnable
                            public final void run() throws JSONException, NoSuchAlgorithmException, IOException {
                                this.f$0.lambda$onResult$0$PassportActivity$20$1(error, errorRunnable, str, tLRPC$TL_account_saveSecureValue, z, tLRPC$TL_secureRequiredType, tLRPC$TL_secureRequiredType2, newValue, newPendingValue, arrayList, secureDocument, secureDocument2, secureDocument3, arrayList2, str2, str3, i, runnable);
                            }
                        });
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* renamed from: lambda$onResult$0, reason: merged with bridge method [inline-methods] */
                    public /* synthetic */ void lambda$onResult$0$PassportActivity$20$1(TLRPC$TL_error tLRPC$TL_error, ErrorRunnable errorRunnable, String str, TLRPC$TL_account_saveSecureValue tLRPC$TL_account_saveSecureValue, boolean z, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2, TLRPC$TL_secureValue tLRPC$TL_secureValue, TLRPC$TL_secureValue tLRPC$TL_secureValue2, ArrayList arrayList, SecureDocument secureDocument, SecureDocument secureDocument2, SecureDocument secureDocument3, ArrayList arrayList2, String str2, String str3, int i, Runnable runnable) throws JSONException, NoSuchAlgorithmException, IOException {
                        int i2;
                        if (tLRPC$TL_error != null) {
                            if (errorRunnable != null) {
                                errorRunnable.onError(tLRPC$TL_error.text, str);
                            }
                            AlertsCreator.processError(((BaseFragment) PassportActivity.this).currentAccount, tLRPC$TL_error, PassportActivity.this, tLRPC$TL_account_saveSecureValue, str);
                            return;
                        }
                        if (!z) {
                            PassportActivity.this.removeValue(tLRPC$TL_secureRequiredType2);
                            PassportActivity.this.removeValue(tLRPC$TL_secureRequiredType);
                        } else if (tLRPC$TL_secureRequiredType != null) {
                            PassportActivity.this.removeValue(tLRPC$TL_secureRequiredType);
                        } else {
                            PassportActivity.this.removeValue(tLRPC$TL_secureRequiredType2);
                        }
                        if (tLRPC$TL_secureValue != null) {
                            PassportActivity.this.currentForm.values.add(tLRPC$TL_secureValue);
                        }
                        if (tLRPC$TL_secureValue2 != null) {
                            PassportActivity.this.currentForm.values.add(tLRPC$TL_secureValue2);
                        }
                        if (arrayList != null && !arrayList.isEmpty()) {
                            int size = arrayList.size();
                            int i3 = 0;
                            while (i3 < size) {
                                SecureDocument secureDocument4 = (SecureDocument) arrayList.get(i3);
                                if (secureDocument4.inputFile != null) {
                                    int size2 = tLRPC$TL_secureValue.files.size();
                                    int i4 = 0;
                                    while (i4 < size2) {
                                        TLRPC$SecureFile tLRPC$SecureFile = tLRPC$TL_secureValue.files.get(i4);
                                        i2 = size;
                                        if (tLRPC$SecureFile instanceof TLRPC$TL_secureFile) {
                                            TLRPC$TL_secureFile tLRPC$TL_secureFile = (TLRPC$TL_secureFile) tLRPC$SecureFile;
                                            if (Utilities.arraysEquals(secureDocument4.fileSecret, 0, tLRPC$TL_secureFile.secret, 0)) {
                                                renameFile(secureDocument4, tLRPC$TL_secureFile);
                                                break;
                                            }
                                        }
                                        i4++;
                                        size = i2;
                                    }
                                    i2 = size;
                                } else {
                                    i2 = size;
                                }
                                i3++;
                                size = i2;
                            }
                        }
                        if (secureDocument != null && secureDocument.inputFile != null) {
                            TLRPC$SecureFile tLRPC$SecureFile2 = tLRPC$TL_secureValue.selfie;
                            if (tLRPC$SecureFile2 instanceof TLRPC$TL_secureFile) {
                                TLRPC$TL_secureFile tLRPC$TL_secureFile2 = (TLRPC$TL_secureFile) tLRPC$SecureFile2;
                                if (Utilities.arraysEquals(secureDocument.fileSecret, 0, tLRPC$TL_secureFile2.secret, 0)) {
                                    renameFile(secureDocument, tLRPC$TL_secureFile2);
                                }
                            }
                        }
                        if (secureDocument2 != null && secureDocument2.inputFile != null) {
                            TLRPC$SecureFile tLRPC$SecureFile3 = tLRPC$TL_secureValue.front_side;
                            if (tLRPC$SecureFile3 instanceof TLRPC$TL_secureFile) {
                                TLRPC$TL_secureFile tLRPC$TL_secureFile3 = (TLRPC$TL_secureFile) tLRPC$SecureFile3;
                                if (Utilities.arraysEquals(secureDocument2.fileSecret, 0, tLRPC$TL_secureFile3.secret, 0)) {
                                    renameFile(secureDocument2, tLRPC$TL_secureFile3);
                                }
                            }
                        }
                        if (secureDocument3 != null && secureDocument3.inputFile != null) {
                            TLRPC$SecureFile tLRPC$SecureFile4 = tLRPC$TL_secureValue.reverse_side;
                            if (tLRPC$SecureFile4 instanceof TLRPC$TL_secureFile) {
                                TLRPC$TL_secureFile tLRPC$TL_secureFile4 = (TLRPC$TL_secureFile) tLRPC$SecureFile4;
                                if (Utilities.arraysEquals(secureDocument3.fileSecret, 0, tLRPC$TL_secureFile4.secret, 0)) {
                                    renameFile(secureDocument3, tLRPC$TL_secureFile4);
                                }
                            }
                        }
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            int size3 = arrayList2.size();
                            for (int i5 = 0; i5 < size3; i5++) {
                                SecureDocument secureDocument5 = (SecureDocument) arrayList2.get(i5);
                                if (secureDocument5.inputFile != null) {
                                    int size4 = tLRPC$TL_secureValue.translation.size();
                                    for (int i6 = 0; i6 < size4; i6++) {
                                        TLRPC$SecureFile tLRPC$SecureFile5 = tLRPC$TL_secureValue.translation.get(i6);
                                        if (tLRPC$SecureFile5 instanceof TLRPC$TL_secureFile) {
                                            TLRPC$TL_secureFile tLRPC$TL_secureFile5 = (TLRPC$TL_secureFile) tLRPC$SecureFile5;
                                            if (Utilities.arraysEquals(secureDocument5.fileSecret, 0, tLRPC$TL_secureFile5.secret, 0)) {
                                                renameFile(secureDocument5, tLRPC$TL_secureFile5);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        PassportActivity.this.setTypeValue(tLRPC$TL_secureRequiredType2, str, str2, tLRPC$TL_secureRequiredType, str3, z, i);
                        if (runnable != null) {
                            runnable.run();
                        }
                    }

                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public void run(final TLObject response, final TLRPC$TL_error error) {
                        if (error != null) {
                            if (error.text.equals("EMAIL_VERIFICATION_NEEDED")) {
                                TLRPC$TL_account_sendVerifyEmailCode tLRPC$TL_account_sendVerifyEmailCode = new TLRPC$TL_account_sendVerifyEmailCode();
                                tLRPC$TL_account_sendVerifyEmailCode.email = this.val$text;
                                ConnectionsManager connectionsManager = ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount);
                                final String str = this.val$text;
                                final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = this.val$requiredType;
                                final PassportActivityDelegate passportActivityDelegate = this.val$currentDelegate;
                                final ErrorRunnable errorRunnable = this.val$errorRunnable;
                                connectionsManager.sendRequest(tLRPC$TL_account_sendVerifyEmailCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$20$1$u8Ou2UrC33B2KSN2dp7TWAgtIlk
                                    @Override // ir.eitaa.tgnet.RequestDelegate
                                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                        this.f$0.lambda$run$2$PassportActivity$20$1(str, tLRPC$TL_secureRequiredType, passportActivityDelegate, errorRunnable, tLObject, tLRPC$TL_error);
                                    }
                                });
                                return;
                            }
                            if (error.text.equals("PHONE_VERIFICATION_NEEDED")) {
                                final ErrorRunnable errorRunnable2 = this.val$errorRunnable;
                                final String str2 = this.val$text;
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$20$1$UsLFPYDPfMGPYYnCSbIBJsAsOXQ
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        errorRunnable2.onError(error.text, str2);
                                    }
                                });
                                return;
                            }
                        }
                        if (error == null && this.val$finalFileInputSecureValue != null) {
                            final TLRPC$TL_secureValue tLRPC$TL_secureValue = (TLRPC$TL_secureValue) response;
                            TLRPC$TL_account_saveSecureValue tLRPC$TL_account_saveSecureValue = new TLRPC$TL_account_saveSecureValue();
                            tLRPC$TL_account_saveSecureValue.value = this.val$finalFileInputSecureValue;
                            tLRPC$TL_account_saveSecureValue.secure_secret_id = PassportActivity.this.secureSecretId;
                            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_account_saveSecureValue, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$20$1$8WRSge3fId00mjyysXQWQBaajeA
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$run$4$PassportActivity$20$1(tLRPC$TL_secureValue, tLObject, tLRPC$TL_error);
                                }
                            });
                            return;
                        }
                        lambda$run$4(error, (TLRPC$TL_secureValue) response, null);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
                    public /* synthetic */ void lambda$run$2$PassportActivity$20$1(final String str, final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, final PassportActivityDelegate passportActivityDelegate, final ErrorRunnable errorRunnable, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$20$1$TMjDNui84GNRsCsi5yhqvFGhPDw
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$run$1$PassportActivity$20$1(tLObject, str, tLRPC$TL_secureRequiredType, passportActivityDelegate, tLRPC$TL_error, errorRunnable);
                            }
                        });
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
                    public /* synthetic */ void lambda$run$1$PassportActivity$20$1(TLObject tLObject, String str, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, PassportActivityDelegate passportActivityDelegate, TLRPC$TL_error tLRPC$TL_error, ErrorRunnable errorRunnable) {
                        if (tLObject == null) {
                            PassportActivity.this.showAlertWithText(LocaleController.getString("PassportEmail", R.string.PassportEmail), tLRPC$TL_error.text);
                            if (errorRunnable != null) {
                                errorRunnable.onError(tLRPC$TL_error.text, str);
                                return;
                            }
                            return;
                        }
                        TLRPC$TL_account_sentEmailCode tLRPC$TL_account_sentEmailCode = (TLRPC$TL_account_sentEmailCode) tLObject;
                        HashMap map = new HashMap();
                        map.put("email", str);
                        map.put("pattern", tLRPC$TL_account_sentEmailCode.email_pattern);
                        PassportActivity passportActivity = new PassportActivity(6, PassportActivity.this.currentForm, PassportActivity.this.currentPassword, tLRPC$TL_secureRequiredType, (TLRPC$TL_secureValue) null, (TLRPC$TL_secureRequiredType) null, (TLRPC$TL_secureValue) null, (HashMap<String, String>) map, (HashMap<String, String>) null);
                        ((BaseFragment) passportActivity).currentAccount = ((BaseFragment) PassportActivity.this).currentAccount;
                        passportActivity.emailCodeLength = tLRPC$TL_account_sentEmailCode.length;
                        passportActivity.saltedPassword = PassportActivity.this.saltedPassword;
                        passportActivity.secureSecret = PassportActivity.this.secureSecret;
                        passportActivity.delegate = passportActivityDelegate;
                        PassportActivity.this.presentFragment(passportActivity, true);
                    }
                }

                @Override // ir.eitaa.ui.PassportActivity.PassportActivityDelegate
                public SecureDocument saveFile(TLRPC$TL_secureFile secureFile) throws NoSuchAlgorithmException, IOException {
                    String str = FileLoader.getDirectory(4) + "/" + secureFile.dc_id + "_" + secureFile.id + ".jpg";
                    EncryptionResult encryptionResultCreateSecureDocument = PassportActivity.this.createSecureDocument(str);
                    return new SecureDocument(encryptionResultCreateSecureDocument.secureDocumentKey, secureFile, str, encryptionResultCreateSecureDocument.fileHash, encryptionResultCreateSecureDocument.fileSecret);
                }

                @Override // ir.eitaa.ui.PassportActivity.PassportActivityDelegate
                public void deleteValue(TLRPC$TL_secureRequiredType requiredType2, TLRPC$TL_secureRequiredType documentRequiredType2, ArrayList<TLRPC$TL_secureRequiredType> documentRequiredTypes, boolean deleteType, Runnable finishRunnable, ErrorRunnable errorRunnable) {
                    PassportActivity.this.deleteValueInternal(requiredType2, documentRequiredType2, documentRequiredTypes, deleteType, finishRunnable, errorRunnable, documentOnly);
                }
            };
            passportActivity.currentAccount = this.currentAccount;
            passportActivity.saltedPassword = this.saltedPassword;
            passportActivity.secureSecret = this.secureSecret;
            passportActivity.currentBotId = this.currentBotId;
            passportActivity.fieldsErrors = map2;
            passportActivity.documentOnly = documentOnly;
            passportActivity.documentsErrors = map3;
            passportActivity.availableDocumentTypes = availableDocumentTypes;
            if (i2 == 4) {
                passportActivity.currentEmail = this.currentEmail;
            }
            presentFragment(passportActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TLRPC$TL_secureValue removeValue(TLRPC$TL_secureRequiredType requiredType) {
        if (requiredType == null) {
            return null;
        }
        int size = this.currentForm.values.size();
        for (int i = 0; i < size; i++) {
            if (requiredType.type.getClass() == this.currentForm.values.get(i).type.getClass()) {
                return this.currentForm.values.remove(i);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteValueInternal(final TLRPC$TL_secureRequiredType requiredType, final TLRPC$TL_secureRequiredType documentRequiredType, final ArrayList<TLRPC$TL_secureRequiredType> documentRequiredTypes, final boolean deleteType, final Runnable finishRunnable, final ErrorRunnable errorRunnable, final boolean documentOnly) {
        if (requiredType == null) {
            return;
        }
        TLRPC$TL_account_deleteSecureValue tLRPC$TL_account_deleteSecureValue = new TLRPC$TL_account_deleteSecureValue();
        if (!documentOnly || documentRequiredType == null) {
            if (deleteType) {
                tLRPC$TL_account_deleteSecureValue.types.add(requiredType.type);
            }
            if (documentRequiredType != null) {
                tLRPC$TL_account_deleteSecureValue.types.add(documentRequiredType.type);
            }
        } else {
            tLRPC$TL_account_deleteSecureValue.types.add(documentRequiredType.type);
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_deleteSecureValue, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$r8C2siDUy2cuApolZZY469n33gs
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$deleteValueInternal$60$PassportActivity(errorRunnable, documentOnly, documentRequiredType, requiredType, deleteType, documentRequiredTypes, finishRunnable, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteValueInternal$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteValueInternal$60$PassportActivity(final ErrorRunnable errorRunnable, final boolean z, final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2, final boolean z2, final ArrayList arrayList, final Runnable runnable, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$I-igLTnPY8R-fcF-c0fcMRSTlFk
            @Override // java.lang.Runnable
            public final void run() throws JSONException, NoSuchAlgorithmException, IOException {
                this.f$0.lambda$deleteValueInternal$59$PassportActivity(tLRPC$TL_error, errorRunnable, z, tLRPC$TL_secureRequiredType, tLRPC$TL_secureRequiredType2, z2, arrayList, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteValueInternal$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$deleteValueInternal$59$PassportActivity(TLRPC$TL_error tLRPC$TL_error, ErrorRunnable errorRunnable, boolean z, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2, boolean z2, ArrayList arrayList, Runnable runnable) throws JSONException, NoSuchAlgorithmException, IOException {
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType3;
        String str;
        TLRPC$TL_secureData tLRPC$TL_secureData;
        String strDecryptData;
        String strDecryptData2 = null;
        if (tLRPC$TL_error != null) {
            if (errorRunnable != null) {
                errorRunnable.onError(tLRPC$TL_error.text, null);
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
            return;
        }
        if (!z) {
            if (z2) {
                removeValue(tLRPC$TL_secureRequiredType2);
            }
            removeValue(tLRPC$TL_secureRequiredType);
        } else if (tLRPC$TL_secureRequiredType != null) {
            removeValue(tLRPC$TL_secureRequiredType);
        } else {
            removeValue(tLRPC$TL_secureRequiredType2);
        }
        if (this.currentActivityType == 8) {
            TextDetailSecureCell textDetailSecureCellRemove = this.typesViews.remove(tLRPC$TL_secureRequiredType2);
            if (textDetailSecureCellRemove != null) {
                this.linearLayout2.removeView(textDetailSecureCellRemove);
                View childAt = this.linearLayout2.getChildAt(r0.getChildCount() - 6);
                if (childAt instanceof TextDetailSecureCell) {
                    ((TextDetailSecureCell) childAt).setNeedDivider(false);
                }
            }
            updateManageVisibility();
        } else {
            if (tLRPC$TL_secureRequiredType == null || arrayList == null || arrayList.size() <= 1) {
                tLRPC$TL_secureRequiredType3 = tLRPC$TL_secureRequiredType;
                str = null;
            } else {
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        tLRPC$TL_secureRequiredType3 = tLRPC$TL_secureRequiredType;
                        break;
                    }
                    tLRPC$TL_secureRequiredType3 = (TLRPC$TL_secureRequiredType) arrayList.get(i);
                    TLRPC$TL_secureValue valueByType = getValueByType(tLRPC$TL_secureRequiredType3, false);
                    if (valueByType != null) {
                        TLRPC$TL_secureData tLRPC$TL_secureData2 = valueByType.data;
                        if (tLRPC$TL_secureData2 != null) {
                            strDecryptData = decryptData(tLRPC$TL_secureData2.data, decryptValueSecret(tLRPC$TL_secureData2.secret, tLRPC$TL_secureData2.data_hash), valueByType.data.data_hash);
                        }
                    } else {
                        i++;
                    }
                }
                strDecryptData = null;
                if (tLRPC$TL_secureRequiredType3 == null) {
                    str = strDecryptData;
                    tLRPC$TL_secureRequiredType3 = (TLRPC$TL_secureRequiredType) arrayList.get(0);
                } else {
                    str = strDecryptData;
                }
            }
            if (z2) {
                setTypeValue(tLRPC$TL_secureRequiredType2, null, null, tLRPC$TL_secureRequiredType3, str, z, arrayList != null ? arrayList.size() : 0);
            } else {
                TLRPC$TL_secureValue valueByType2 = getValueByType(tLRPC$TL_secureRequiredType2, false);
                if (valueByType2 != null && (tLRPC$TL_secureData = valueByType2.data) != null) {
                    strDecryptData2 = decryptData(tLRPC$TL_secureData.data, decryptValueSecret(tLRPC$TL_secureData.secret, tLRPC$TL_secureData.data_hash), valueByType2.data.data_hash);
                }
                setTypeValue(tLRPC$TL_secureRequiredType2, null, strDecryptData2, tLRPC$TL_secureRequiredType3, str, z, arrayList != null ? arrayList.size() : 0);
            }
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private ir.eitaa.ui.PassportActivity.TextDetailSecureCell addField(android.content.Context r17, final ir.eitaa.tgnet.TLRPC$TL_secureRequiredType r18, final java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_secureRequiredType> r19, final boolean r20, boolean r21) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.addField(android.content.Context, ir.eitaa.tgnet.TLRPC$TL_secureRequiredType, java.util.ArrayList, boolean, boolean):ir.eitaa.ui.PassportActivity$TextDetailSecureCell");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addField$64, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addField$64$PassportActivity(final ArrayList arrayList, final TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, final boolean z, View view) {
        TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2;
        int i;
        String str;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                tLRPC$TL_secureRequiredType2 = (TLRPC$TL_secureRequiredType) arrayList.get(i2);
                if (getValueByType(tLRPC$TL_secureRequiredType2, false) != null || size == 1) {
                    break;
                }
            }
            tLRPC$TL_secureRequiredType2 = null;
        } else {
            tLRPC$TL_secureRequiredType2 = null;
        }
        TLRPC$SecureValueType tLRPC$SecureValueType = tLRPC$TL_secureRequiredType.type;
        if ((tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePersonalDetails) || (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeAddress)) {
            if (tLRPC$TL_secureRequiredType2 == null && arrayList != null && !arrayList.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                TLRPC$SecureValueType tLRPC$SecureValueType2 = tLRPC$TL_secureRequiredType.type;
                if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypePersonalDetails) {
                    builder.setTitle(LocaleController.getString("PassportIdentityDocument", R.string.PassportIdentityDocument));
                } else if (tLRPC$SecureValueType2 instanceof TLRPC$TL_secureValueTypeAddress) {
                    builder.setTitle(LocaleController.getString("PassportAddress", R.string.PassportAddress));
                }
                ArrayList arrayList2 = new ArrayList();
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    TLRPC$SecureValueType tLRPC$SecureValueType3 = ((TLRPC$TL_secureRequiredType) arrayList.get(i3)).type;
                    if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeDriverLicense) {
                        arrayList2.add(LocaleController.getString("PassportAddLicence", R.string.PassportAddLicence));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypePassport) {
                        arrayList2.add(LocaleController.getString("PassportAddPassport", R.string.PassportAddPassport));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeInternalPassport) {
                        arrayList2.add(LocaleController.getString("PassportAddInternalPassport", R.string.PassportAddInternalPassport));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeIdentityCard) {
                        arrayList2.add(LocaleController.getString("PassportAddCard", R.string.PassportAddCard));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeUtilityBill) {
                        arrayList2.add(LocaleController.getString("PassportAddBill", R.string.PassportAddBill));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeBankStatement) {
                        arrayList2.add(LocaleController.getString("PassportAddBank", R.string.PassportAddBank));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeRentalAgreement) {
                        arrayList2.add(LocaleController.getString("PassportAddAgreement", R.string.PassportAddAgreement));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypeTemporaryRegistration) {
                        arrayList2.add(LocaleController.getString("PassportAddTemporaryRegistration", R.string.PassportAddTemporaryRegistration));
                    } else if (tLRPC$SecureValueType3 instanceof TLRPC$TL_secureValueTypePassportRegistration) {
                        arrayList2.add(LocaleController.getString("PassportAddPassportRegistration", R.string.PassportAddPassportRegistration));
                    }
                }
                builder.setItems((CharSequence[]) arrayList2.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$LKldogk11qakoObJYbZXNbQo71o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$addField$61$PassportActivity(tLRPC$TL_secureRequiredType, arrayList, z, dialogInterface, i4);
                    }
                });
                showDialog(builder.create());
                return;
            }
        } else {
            boolean z2 = tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypePhone;
            if ((z2 || (tLRPC$SecureValueType instanceof TLRPC$TL_secureValueTypeEmail)) && getValueByType(tLRPC$TL_secureRequiredType, false) != null) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$Newxq3AFJfxPJ5Kj_kj-Cxd9kkM
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$addField$63$PassportActivity(tLRPC$TL_secureRequiredType, z, dialogInterface, i4);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
                if (z2) {
                    i = R.string.PassportDeletePhoneAlert;
                    str = "PassportDeletePhoneAlert";
                } else {
                    i = R.string.PassportDeleteEmailAlert;
                    str = "PassportDeleteEmailAlert";
                }
                builder2.setMessage(LocaleController.getString(str, i));
                showDialog(builder2.create());
                return;
            }
        }
        openTypeActivity(tLRPC$TL_secureRequiredType, tLRPC$TL_secureRequiredType2, arrayList, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addField$61, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addField$61$PassportActivity(TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, ArrayList arrayList, boolean z, DialogInterface dialogInterface, int i) {
        openTypeActivity(tLRPC$TL_secureRequiredType, (TLRPC$TL_secureRequiredType) arrayList.get(i), arrayList, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addField$63, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addField$63$PassportActivity(TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType, boolean z, DialogInterface dialogInterface, int i) {
        needShowProgress();
        deleteValueInternal(tLRPC$TL_secureRequiredType, null, null, true, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$1NMIDKBGgNMr1KeW2MzuXvgvspA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.needHideProgress();
            }
        }, new ErrorRunnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$y1L8e2O9Z1jL7hebarg_oCD5B1U
            @Override // ir.eitaa.ui.PassportActivity.ErrorRunnable
            public final void onError(String str, String str2) {
                this.f$0.lambda$addField$62$PassportActivity(str, str2);
            }
        }, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$addField$62, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$addField$62$PassportActivity(String str, String str2) {
        needHideProgress();
    }

    private static class EncryptionResult {
        byte[] decrypyedFileSecret;
        byte[] encryptedData;
        byte[] fileHash;
        byte[] fileSecret;
        SecureDocumentKey secureDocumentKey;

        public EncryptionResult(byte[] d, byte[] fs, byte[] dfs, byte[] fh, byte[] fk, byte[] fi) {
            this.encryptedData = d;
            this.fileSecret = fs;
            this.fileHash = fh;
            this.decrypyedFileSecret = dfs;
            this.secureDocumentKey = new SecureDocumentKey(fk, fi);
        }
    }

    private SecureDocumentKey getSecureDocumentKey(byte[] file_secret, byte[] file_hash) throws NoSuchAlgorithmException {
        byte[] bArrComputeSHA512 = Utilities.computeSHA512(decryptValueSecret(file_secret, file_hash), file_hash);
        byte[] bArr = new byte[32];
        System.arraycopy(bArrComputeSHA512, 0, bArr, 0, 32);
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArrComputeSHA512, 32, bArr2, 0, 16);
        return new SecureDocumentKey(bArr, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] decryptSecret(byte[] secret, byte[] passwordHash) {
        if (secret == null || secret.length != 32) {
            return null;
        }
        byte[] bArr = new byte[32];
        System.arraycopy(passwordHash, 0, bArr, 0, 32);
        byte[] bArr2 = new byte[16];
        System.arraycopy(passwordHash, 32, bArr2, 0, 16);
        byte[] bArr3 = new byte[32];
        System.arraycopy(secret, 0, bArr3, 0, 32);
        Utilities.aesCbcEncryptionByteArraySafe(bArr3, bArr, bArr2, 0, 32, 0, 0);
        return bArr3;
    }

    private byte[] decryptValueSecret(byte[] encryptedSecureValueSecret, byte[] hash) throws NoSuchAlgorithmException {
        if (encryptedSecureValueSecret == null || encryptedSecureValueSecret.length != 32 || hash == null || hash.length != 32) {
            return null;
        }
        byte[] bArr = new byte[32];
        System.arraycopy(this.saltedPassword, 0, bArr, 0, 32);
        byte[] bArr2 = new byte[16];
        System.arraycopy(this.saltedPassword, 32, bArr2, 0, 16);
        byte[] bArr3 = new byte[32];
        System.arraycopy(this.secureSecret, 0, bArr3, 0, 32);
        Utilities.aesCbcEncryptionByteArraySafe(bArr3, bArr, bArr2, 0, 32, 0, 0);
        if (!checkSecret(bArr3, null)) {
            return null;
        }
        byte[] bArrComputeSHA512 = Utilities.computeSHA512(bArr3, hash);
        byte[] bArr4 = new byte[32];
        System.arraycopy(bArrComputeSHA512, 0, bArr4, 0, 32);
        byte[] bArr5 = new byte[16];
        System.arraycopy(bArrComputeSHA512, 32, bArr5, 0, 16);
        byte[] bArr6 = new byte[32];
        System.arraycopy(encryptedSecureValueSecret, 0, bArr6, 0, 32);
        Utilities.aesCbcEncryptionByteArraySafe(bArr6, bArr4, bArr5, 0, 32, 0, 0);
        return bArr6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:15|3)|(2:17|4)|8|13|9|10|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.eitaa.ui.PassportActivity.EncryptionResult createSecureDocument(java.lang.String r5) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            long r0 = r0.length()
            int r1 = (int) r0
            byte[] r0 = new byte[r1]
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Exception -> L19
            java.lang.String r3 = "rws"
            r2.<init>(r5, r3)     // Catch: java.lang.Exception -> L19
            r2.readFully(r0)     // Catch: java.lang.Exception -> L18
            goto L1a
        L18:
            r1 = r2
        L19:
            r2 = r1
        L1a:
            ir.eitaa.ui.PassportActivity$EncryptionResult r5 = r4.encryptData(r0)
            r0 = 0
            r2.seek(r0)     // Catch: java.lang.Exception -> L2b
            byte[] r0 = r5.encryptedData     // Catch: java.lang.Exception -> L2b
            r2.write(r0)     // Catch: java.lang.Exception -> L2b
            r2.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PassportActivity.createSecureDocument(java.lang.String):ir.eitaa.ui.PassportActivity$EncryptionResult");
    }

    private String decryptData(byte[] data, byte[] file_secret, byte[] file_hash) throws NoSuchAlgorithmException {
        if (data == null || file_secret == null || file_secret.length != 32 || file_hash == null || file_hash.length != 32) {
            return null;
        }
        byte[] bArrComputeSHA512 = Utilities.computeSHA512(file_secret, file_hash);
        byte[] bArr = new byte[32];
        System.arraycopy(bArrComputeSHA512, 0, bArr, 0, 32);
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArrComputeSHA512, 32, bArr2, 0, 16);
        int length = data.length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(data, 0, bArr3, 0, data.length);
        Utilities.aesCbcEncryptionByteArraySafe(bArr3, bArr, bArr2, 0, length, 0, 0);
        if (!Arrays.equals(Utilities.computeSHA256(bArr3), file_hash)) {
            return null;
        }
        int i = bArr3[0] & 255;
        return new String(bArr3, i, length - i);
    }

    public static boolean checkSecret(byte[] secret, Long id) {
        if (secret == null || secret.length != 32) {
            return false;
        }
        int i = 0;
        for (byte b : secret) {
            i += b & 255;
        }
        if (i % 255 != 239) {
            return false;
        }
        return id == null || Utilities.bytesToLong(Utilities.computeSHA256(secret)) == id.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] getRandomSecret() {
        byte[] bArr = new byte[32];
        Utilities.random.nextBytes(bArr);
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            i += 255 & bArr[i2];
        }
        int i3 = i % 255;
        if (i3 != 239) {
            int iNextInt = Utilities.random.nextInt(32);
            int i4 = (bArr[iNextInt] & 255) + (239 - i3);
            if (i4 < 255) {
                i4 += 255;
            }
            bArr[iNextInt] = (byte) (i4 % 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EncryptionResult encryptData(byte[] data) throws NoSuchAlgorithmException {
        byte[] randomSecret = getRandomSecret();
        int iNextInt = Utilities.random.nextInt(208) + 32;
        while ((data.length + iNextInt) % 16 != 0) {
            iNextInt++;
        }
        byte[] bArr = new byte[iNextInt];
        Utilities.random.nextBytes(bArr);
        bArr[0] = (byte) iNextInt;
        int length = iNextInt + data.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, iNextInt);
        System.arraycopy(data, 0, bArr2, iNextInt, data.length);
        byte[] bArrComputeSHA256 = Utilities.computeSHA256(bArr2);
        byte[] bArrComputeSHA512 = Utilities.computeSHA512(randomSecret, bArrComputeSHA256);
        byte[] bArr3 = new byte[32];
        System.arraycopy(bArrComputeSHA512, 0, bArr3, 0, 32);
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArrComputeSHA512, 32, bArr4, 0, 16);
        Utilities.aesCbcEncryptionByteArraySafe(bArr2, bArr3, bArr4, 0, length, 0, 1);
        byte[] bArr5 = new byte[32];
        System.arraycopy(this.saltedPassword, 0, bArr5, 0, 32);
        byte[] bArr6 = new byte[16];
        System.arraycopy(this.saltedPassword, 32, bArr6, 0, 16);
        byte[] bArr7 = new byte[32];
        System.arraycopy(this.secureSecret, 0, bArr7, 0, 32);
        Utilities.aesCbcEncryptionByteArraySafe(bArr7, bArr5, bArr6, 0, 32, 0, 0);
        byte[] bArrComputeSHA5122 = Utilities.computeSHA512(bArr7, bArrComputeSHA256);
        byte[] bArr8 = new byte[32];
        System.arraycopy(bArrComputeSHA5122, 0, bArr8, 0, 32);
        byte[] bArr9 = new byte[16];
        System.arraycopy(bArrComputeSHA5122, 32, bArr9, 0, 16);
        byte[] bArr10 = new byte[32];
        System.arraycopy(randomSecret, 0, bArr10, 0, 32);
        Utilities.aesCbcEncryptionByteArraySafe(bArr10, bArr8, bArr9, 0, 32, 0, 1);
        return new EncryptionResult(bArr2, bArr10, randomSecret, bArrComputeSHA256, bArr3, bArr4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertWithText(String title, String text) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(title);
        builder.setMessage(text);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPasscodeError(boolean clear) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (clear) {
            this.inputFields[0].setText("");
        }
        AndroidUtilities.shakeView(this.inputFields[0], 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhoneVerification(boolean checkPermissions, final String phone, Runnable finishRunnable, ErrorRunnable errorRunnable, final PassportActivityDelegate delegate) {
        TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
        boolean z = (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0) ? false : true;
        final TLRPC$TL_account_sendVerifyPhoneCode tLRPC$TL_account_sendVerifyPhoneCode = new TLRPC$TL_account_sendVerifyPhoneCode();
        tLRPC$TL_account_sendVerifyPhoneCode.phone_number = phone;
        TLRPC$TL_codeSettings tLRPC$TL_codeSettings = new TLRPC$TL_codeSettings();
        tLRPC$TL_account_sendVerifyPhoneCode.settings = tLRPC$TL_codeSettings;
        tLRPC$TL_codeSettings.allow_flashcall = z;
        tLRPC$TL_codeSettings.allow_app_hash = ApplicationLoader.hasPlayServices;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        if (tLRPC$TL_account_sendVerifyPhoneCode.settings.allow_app_hash) {
            sharedPreferences.edit().putString("sms_hash", BuildVars.SMS_HASH).commit();
        } else {
            sharedPreferences.edit().remove("sms_hash").commit();
        }
        if (tLRPC$TL_account_sendVerifyPhoneCode.settings.allow_flashcall) {
            try {
                String line1Number = telephonyManager.getLine1Number();
                if (!TextUtils.isEmpty(line1Number)) {
                    tLRPC$TL_account_sendVerifyPhoneCode.settings.current_number = PhoneNumberUtils.compare(phone, line1Number);
                    TLRPC$TL_codeSettings tLRPC$TL_codeSettings2 = tLRPC$TL_account_sendVerifyPhoneCode.settings;
                    if (!tLRPC$TL_codeSettings2.current_number) {
                        tLRPC$TL_codeSettings2.allow_flashcall = false;
                    }
                } else {
                    tLRPC$TL_account_sendVerifyPhoneCode.settings.current_number = false;
                }
            } catch (Exception e) {
                tLRPC$TL_account_sendVerifyPhoneCode.settings.allow_flashcall = false;
                FileLog.e(e);
            }
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_sendVerifyPhoneCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$tMmHfgGaxpkkhXU6wmpIxFgUAjI
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$startPhoneVerification$66$PassportActivity(phone, delegate, tLRPC$TL_account_sendVerifyPhoneCode, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startPhoneVerification$66, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startPhoneVerification$66$PassportActivity(final String str, final PassportActivityDelegate passportActivityDelegate, final TLRPC$TL_account_sendVerifyPhoneCode tLRPC$TL_account_sendVerifyPhoneCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$8Vr21P-rmdBPws-JdGCi3Wy9xew
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startPhoneVerification$65$PassportActivity(tLRPC$TL_error, str, passportActivityDelegate, tLObject, tLRPC$TL_account_sendVerifyPhoneCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startPhoneVerification$65, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startPhoneVerification$65$PassportActivity(TLRPC$TL_error tLRPC$TL_error, String str, PassportActivityDelegate passportActivityDelegate, TLObject tLObject, TLRPC$TL_account_sendVerifyPhoneCode tLRPC$TL_account_sendVerifyPhoneCode) {
        if (tLRPC$TL_error == null) {
            HashMap map = new HashMap();
            map.put("phone", str);
            PassportActivity passportActivity = new PassportActivity(7, this.currentForm, this.currentPassword, this.currentType, (TLRPC$TL_secureValue) null, (TLRPC$TL_secureRequiredType) null, (TLRPC$TL_secureValue) null, (HashMap<String, String>) map, (HashMap<String, String>) null);
            passportActivity.currentAccount = this.currentAccount;
            passportActivity.saltedPassword = this.saltedPassword;
            passportActivity.secureSecret = this.secureSecret;
            passportActivity.delegate = passportActivityDelegate;
            passportActivity.currentPhoneVerification = (TLRPC$TL_auth_sentCode) tLObject;
            presentFragment(passportActivity, true);
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_sendVerifyPhoneCode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePasswordInterface() {
        ImageView imageView = this.noPasswordImageView;
        if (imageView == null) {
            return;
        }
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        if (tLRPC$TL_account_password == null || this.usingSavedPassword != 0) {
            imageView.setVisibility(8);
            this.noPasswordTextView.setVisibility(8);
            this.noPasswordSetTextView.setVisibility(8);
            this.passwordAvatarContainer.setVisibility(8);
            this.inputFieldContainers[0].setVisibility(8);
            this.doneItem.setVisibility(8);
            this.passwordForgotButton.setVisibility(8);
            this.passwordInfoRequestTextView.setVisibility(8);
            this.passwordRequestTextView.setVisibility(8);
            this.emptyView.setVisibility(0);
            return;
        }
        if (!tLRPC$TL_account_password.has_password) {
            this.passwordRequestTextView.setVisibility(0);
            this.noPasswordImageView.setVisibility(0);
            this.noPasswordTextView.setVisibility(0);
            this.noPasswordSetTextView.setVisibility(0);
            this.passwordAvatarContainer.setVisibility(8);
            this.inputFieldContainers[0].setVisibility(8);
            this.doneItem.setVisibility(8);
            this.passwordForgotButton.setVisibility(8);
            this.passwordInfoRequestTextView.setVisibility(8);
            this.passwordRequestTextView.setLayoutParams(LayoutHelper.createLinear(-1, -2, 0.0f, 25.0f, 0.0f, 0.0f));
            this.emptyView.setVisibility(8);
            return;
        }
        this.passwordRequestTextView.setVisibility(0);
        this.noPasswordImageView.setVisibility(8);
        this.noPasswordTextView.setVisibility(8);
        this.noPasswordSetTextView.setVisibility(8);
        this.emptyView.setVisibility(8);
        this.passwordAvatarContainer.setVisibility(0);
        this.inputFieldContainers[0].setVisibility(0);
        this.doneItem.setVisibility(0);
        this.passwordForgotButton.setVisibility(0);
        this.passwordInfoRequestTextView.setVisibility(0);
        this.passwordRequestTextView.setLayoutParams(LayoutHelper.createLinear(-1, -2, 0.0f, 0.0f, 0.0f, 0.0f));
        if (this.inputFields != null) {
            TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
            if (tLRPC$TL_account_password2 != null && !TextUtils.isEmpty(tLRPC$TL_account_password2.hint)) {
                this.inputFields[0].setHint(this.currentPassword.hint);
            } else {
                this.inputFields[0].setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean animateDoneItem, final boolean show) {
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (animateDoneItem && this.doneItem != null) {
            this.doneItemAnimation = new AnimatorSet();
            if (show) {
                this.progressView.setVisibility(0);
                this.doneItem.setEnabled(false);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.doneItem.getContentView().setVisibility(0);
                this.doneItem.setEnabled(true);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 1.0f));
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PassportActivity.21
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PassportActivity.this.doneItemAnimation == null || !PassportActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        PassportActivity.this.progressView.setVisibility(4);
                    } else {
                        PassportActivity.this.doneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (PassportActivity.this.doneItemAnimation == null || !PassportActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    PassportActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
            return;
        }
        if (this.acceptTextView != null) {
            this.doneItemAnimation = new AnimatorSet();
            if (show) {
                this.progressViewButton.setVisibility(0);
                this.bottomLayout.setEnabled(false);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.acceptTextView.setVisibility(0);
                this.bottomLayout.setEnabled(true);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PassportActivity.22
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PassportActivity.this.doneItemAnimation == null || !PassportActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        PassportActivity.this.progressViewButton.setVisibility(4);
                    } else {
                        PassportActivity.this.acceptTextView.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (PassportActivity.this.doneItemAnimation == null || !PassportActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    PassportActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        SecureDocumentCell secureDocumentCell;
        ActionBarMenuItem actionBarMenuItem;
        if (id == NotificationCenter.fileUploaded) {
            String str = (String) args[0];
            SecureDocument secureDocument = this.uploadingDocuments.get(str);
            if (secureDocument != null) {
                secureDocument.inputFile = (TLRPC$TL_inputFile) args[1];
                this.uploadingDocuments.remove(str);
                if (this.uploadingDocuments.isEmpty() && (actionBarMenuItem = this.doneItem) != null) {
                    actionBarMenuItem.setEnabled(true);
                    this.doneItem.setAlpha(1.0f);
                }
                HashMap<SecureDocument, SecureDocumentCell> map = this.documentsCells;
                if (map != null && (secureDocumentCell = map.get(secureDocument)) != null) {
                    secureDocumentCell.updateButtonState(true);
                }
                HashMap<String, String> map2 = this.errorsValues;
                if (map2 != null && map2.containsKey("error_document_all")) {
                    this.errorsValues.remove("error_document_all");
                    checkTopErrorCell(false);
                }
                int i = secureDocument.type;
                if (i == 0) {
                    if (this.bottomCell != null && !TextUtils.isEmpty(this.noAllDocumentsErrorText)) {
                        this.bottomCell.setText(this.noAllDocumentsErrorText);
                    }
                    this.errorsValues.remove("files_all");
                    return;
                }
                if (i == 4) {
                    if (this.bottomCellTranslation != null && !TextUtils.isEmpty(this.noAllTranslationErrorText)) {
                        this.bottomCellTranslation.setText(this.noAllTranslationErrorText);
                    }
                    this.errorsValues.remove("translation_all");
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileUploadFailed) {
            return;
        }
        if (id == NotificationCenter.twoStepPasswordChanged) {
            if (args != null && args.length > 0) {
                if (args[7] != null) {
                    EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
                    if (editTextBoldCursorArr[0] != null) {
                        editTextBoldCursorArr[0].setText((String) args[7]);
                    }
                }
                if (args[6] == null) {
                    TLRPC$TL_account_password tLRPC$TL_account_password = new TLRPC$TL_account_password();
                    this.currentPassword = tLRPC$TL_account_password;
                    tLRPC$TL_account_password.current_algo = (TLRPC$PasswordKdfAlgo) args[1];
                    tLRPC$TL_account_password.new_secure_algo = (TLRPC$SecurePasswordKdfAlgo) args[2];
                    tLRPC$TL_account_password.secure_random = (byte[]) args[3];
                    tLRPC$TL_account_password.has_recovery = !TextUtils.isEmpty((String) args[4]);
                    TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
                    tLRPC$TL_account_password2.hint = (String) args[5];
                    tLRPC$TL_account_password2.srp_id = -1L;
                    byte[] bArr = new byte[Factory.DEVICE_HAS_CRAPPY_OPENSLES];
                    tLRPC$TL_account_password2.srp_B = bArr;
                    Utilities.random.nextBytes(bArr);
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.inputFields;
                    if (editTextBoldCursorArr2[0] != null && editTextBoldCursorArr2[0].length() > 0) {
                        this.usingSavedPassword = 2;
                    }
                }
            } else {
                this.currentPassword = null;
                loadPasswordInfo();
            }
            updatePasswordInterface();
            return;
        }
        int i2 = NotificationCenter.didRemoveTwoStepPassword;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (this.presentAfterAnimation != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$pNAfPngRaV_b7FSVWNa1r7zJ_9Y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onTransitionAnimationEnd$67$PassportActivity();
                }
            });
        }
        int i = this.currentActivityType;
        if (i == 5) {
            if (isOpen) {
                if (this.inputFieldContainers[0].getVisibility() == 0) {
                    this.inputFields[0].requestFocus();
                    AndroidUtilities.showKeyboard(this.inputFields[0]);
                }
                if (this.usingSavedPassword == 2) {
                    onPasswordDone(false);
                    return;
                }
                return;
            }
            return;
        }
        if (i == 7) {
            if (isOpen) {
                this.views[this.currentViewNum].onShow();
                return;
            }
            return;
        }
        if (i == 4) {
            if (isOpen) {
                this.inputFields[0].requestFocus();
                AndroidUtilities.showKeyboard(this.inputFields[0]);
                return;
            }
            return;
        }
        if (i == 6) {
            if (isOpen) {
                this.inputFields[0].requestFocus();
                AndroidUtilities.showKeyboard(this.inputFields[0]);
                return;
            }
            return;
        }
        if ((i == 2 || i == 1) && Build.VERSION.SDK_INT >= 21) {
            createChatAttachView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onTransitionAnimationEnd$67, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTransitionAnimationEnd$67$PassportActivity() {
        presentFragment(this.presentAfterAnimation, true);
        this.presentAfterAnimation = null;
    }

    private void showAttachmentError() {
        if (getParentActivity() == null) {
            return;
        }
        Toast.makeText(getParentActivity(), LocaleController.getString("UnsupportedAttachment", R.string.UnsupportedAttachment), 0).show();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            if (requestCode == 0 || requestCode == 2) {
                createChatAttachView();
                ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
                if (chatAttachAlert != null) {
                    chatAttachAlert.onActivityResultFragment(requestCode, data, this.currentPicturePath);
                }
                this.currentPicturePath = null;
                return;
            }
            if (requestCode == 1) {
                if (data == null || data.getData() == null) {
                    showAttachmentError();
                    return;
                }
                ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList = new ArrayList<>();
                SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                sendingMediaInfo.uri = data.getData();
                arrayList.add(sendingMediaInfo);
                processSelectedFiles(arrayList);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        ChatAttachAlert chatAttachAlert;
        TextSettingsCell textSettingsCell;
        int i = this.currentActivityType;
        if ((i != 1 && i != 2) || (chatAttachAlert = this.chatAttachAlert) == null) {
            if (i == 3 && requestCode == 6) {
                startPhoneVerification(false, this.pendingPhone, this.pendingFinishRunnable, this.pendingErrorRunnable, this.pendingDelegate);
                return;
            }
            return;
        }
        if (requestCode == 17) {
            chatAttachAlert.getPhotoLayout().checkCamera(false);
            return;
        }
        if (requestCode == 21) {
            if (getParentActivity() == null || grantResults == null || grantResults.length == 0 || grantResults[0] == 0) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("PermissionNoAudioVideo", R.string.PermissionNoAudioVideo));
            builder.setNegativeButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PGTG20xWfzHLlgFlzD9ebNbIt6Q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$onRequestPermissionsResultFragment$68$PassportActivity(dialogInterface, i2);
                }
            });
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            builder.show();
            return;
        }
        if (requestCode == 19 && grantResults != null && grantResults.length > 0 && grantResults[0] == 0) {
            processSelectedAttach(0);
            return;
        }
        if (requestCode != 22 || grantResults == null || grantResults.length <= 0 || grantResults[0] != 0 || (textSettingsCell = this.scanDocumentCell) == null) {
            return;
        }
        textSettingsCell.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onRequestPermissionsResultFragment$68, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onRequestPermissionsResultFragment$68$PassportActivity(DialogInterface dialogInterface, int i) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName()));
            getParentActivity().startActivity(intent);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle args) {
        String str = this.currentPicturePath;
        if (str != null) {
            args.putString("path", str);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        int i = this.currentActivityType;
        int i2 = 0;
        if (i == 7) {
            this.views[this.currentViewNum].onBackPressed(true);
            while (true) {
                SlideView[] slideViewArr = this.views;
                if (i2 >= slideViewArr.length) {
                    break;
                }
                if (slideViewArr[i2] != null) {
                    slideViewArr[i2].onDestroyActivity();
                }
                i2++;
            }
        } else if (i == 0 || i == 5) {
            callCallback(false);
        } else if (i == 1 || i == 2) {
            return !checkDiscard();
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        if (this.currentActivityType != 3 || Build.VERSION.SDK_INT < 23 || dialog != this.permissionsDialog || this.permissionsItems.isEmpty()) {
            return;
        }
        getParentActivity().requestPermissions((String[]) this.permissionsItems.toArray(new String[0]), 6);
    }

    public void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCacnel(false);
        this.progressDialog.show();
    }

    public void needHideProgress() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    public void setPage(int page, boolean animated, Bundle params) {
        if (page == 3) {
            this.doneItem.setVisibility(8);
        }
        SlideView[] slideViewArr = this.views;
        final SlideView slideView = slideViewArr[this.currentViewNum];
        final SlideView slideView2 = slideViewArr[page];
        this.currentViewNum = page;
        slideView2.setParams(params, false);
        slideView2.onShow();
        if (animated) {
            slideView2.setTranslationX(AndroidUtilities.displaySize.x);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.setDuration(300L);
            animatorSet.playTogether(ObjectAnimator.ofFloat(slideView, "translationX", -AndroidUtilities.displaySize.x), ObjectAnimator.ofFloat(slideView2, "translationX", 0.0f));
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PassportActivity.23
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    slideView2.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    slideView.setVisibility(8);
                    slideView.setX(0.0f);
                }
            });
            animatorSet.start();
            return;
        }
        slideView2.setTranslationX(0.0f);
        slideView2.setVisibility(0);
        if (slideView != slideView2) {
            slideView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillNextCodeParams(Bundle params, TLRPC$TL_auth_sentCode res, boolean animated) {
        params.putString("phoneHash", res.phone_code_hash);
        TLRPC$auth_CodeType tLRPC$auth_CodeType = res.next_type;
        if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeCall) {
            params.putInt("nextType", 4);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeFlashCall) {
            params.putInt("nextType", 3);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeSms) {
            params.putInt("nextType", 2);
        }
        if (res.timeout == 0) {
            res.timeout = 60;
        }
        params.putInt("timeout", res.timeout * 1000);
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType = res.type;
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeCall) {
            params.putInt("type", 4);
            params.putInt("length", res.type.length);
            setPage(2, animated, params);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeFlashCall) {
            params.putInt("type", 3);
            params.putString("pattern", res.type.pattern);
            setPage(1, animated, params);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeSms) {
            params.putInt("type", 2);
            params.putInt("length", res.type.length);
            setPage(0, animated, params);
        }
    }

    private void openAttachMenu() {
        if (getParentActivity() == null) {
            return;
        }
        if (this.uploadingFileType == 0 && this.documents.size() >= 20) {
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("PassportUploadMaxReached", R.string.PassportUploadMaxReached, LocaleController.formatPluralString("Files", 20)));
            return;
        }
        createChatAttachView();
        this.chatAttachAlert.setOpenWithFrontFaceCamera(this.uploadingFileType == 1);
        this.chatAttachAlert.setMaxSelectedPhotos(getMaxSelectedDocuments(), false);
        this.chatAttachAlert.getPhotoLayout().loadGalleryPhotos();
        int i = Build.VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            AndroidUtilities.hideKeyboard(this.fragmentView.findFocus());
        }
        this.chatAttachAlert.init();
        showDialog(this.chatAttachAlert);
    }

    private void createChatAttachView() {
        if (getParentActivity() != null && this.chatAttachAlert == null) {
            ChatAttachAlert chatAttachAlert = new ChatAttachAlert(getParentActivity(), this, false, false);
            this.chatAttachAlert = chatAttachAlert;
            chatAttachAlert.setDelegate(new ChatAttachAlert.ChatAttachViewDelegate() { // from class: ir.eitaa.ui.PassportActivity.24
                @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
                public void didSelectBot(TLRPC$User user) {
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
                public boolean needEnterComment() {
                    return false;
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
                public void didPressedButton(int button, boolean arg, boolean notify, int scheduleDate, boolean forceDocument) {
                    if (PassportActivity.this.getParentActivity() == null || PassportActivity.this.chatAttachAlert == null) {
                        return;
                    }
                    if (button == 8 || button == 7) {
                        if (button != 8) {
                            PassportActivity.this.chatAttachAlert.dismiss();
                        }
                        HashMap<Object, Object> selectedPhotos = PassportActivity.this.chatAttachAlert.getPhotoLayout().getSelectedPhotos();
                        ArrayList<Object> selectedPhotosOrder = PassportActivity.this.chatAttachAlert.getPhotoLayout().getSelectedPhotosOrder();
                        if (selectedPhotos.isEmpty()) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < selectedPhotosOrder.size(); i++) {
                            MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) selectedPhotos.get(selectedPhotosOrder.get(i));
                            SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                            String str = photoEntry.imagePath;
                            if (str != null) {
                                sendingMediaInfo.path = str;
                            } else {
                                sendingMediaInfo.path = photoEntry.path;
                            }
                            arrayList.add(sendingMediaInfo);
                            photoEntry.reset();
                        }
                        PassportActivity.this.processSelectedFiles(arrayList);
                        return;
                    }
                    if (PassportActivity.this.chatAttachAlert != null) {
                        PassportActivity.this.chatAttachAlert.dismissWithButtonClick(button);
                    }
                    PassportActivity.this.processSelectedAttach(button);
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
                public void onCameraOpened() {
                    AndroidUtilities.hideKeyboard(((BaseFragment) PassportActivity.this).fragmentView.findFocus());
                }

                @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
                public void doOnIdle(Runnable runnable) {
                    runnable.run();
                }
            });
        }
    }

    private int getMaxSelectedDocuments() {
        int size;
        int i = this.uploadingFileType;
        if (i == 0) {
            size = this.documents.size();
        } else {
            if (i != 4) {
                return 1;
            }
            size = this.translationDocuments.size();
        }
        return 20 - size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSelectedAttach(int which) {
        if (which == 0) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 19);
                return;
            }
            try {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                File fileGeneratePicturePath = AndroidUtilities.generatePicturePath();
                if (fileGeneratePicturePath != null) {
                    if (i >= 24) {
                        intent.putExtra("output", FileProvider.getUriForFile(getParentActivity(), "ir.eitaa.messenger.provider", fileGeneratePicturePath));
                        intent.addFlags(2);
                        intent.addFlags(1);
                    } else {
                        intent.putExtra("output", Uri.fromFile(fileGeneratePicturePath));
                    }
                    this.currentPicturePath = fileGeneratePicturePath.getAbsolutePath();
                }
                startActivityForResult(intent, 0);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos, boolean notify, int scheduleDate) {
        processSelectedFiles(photos);
    }

    public void startDocumentSelectActivity() {
        try {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            if (Build.VERSION.SDK_INT >= 18) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent.setType("*/*");
            startActivityForResult(intent, 21);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void didSelectFiles(ArrayList<String> files, String caption, boolean notify, int scheduleDate) {
        ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList = new ArrayList<>();
        int size = files.size();
        for (int i = 0; i < size; i++) {
            SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
            sendingMediaInfo.path = files.get(i);
            arrayList.add(sendingMediaInfo);
        }
        processSelectedFiles(arrayList);
    }

    private void fillInitialValues() {
        if (this.initialValues != null) {
            return;
        }
        this.initialValues = getCurrentValues();
    }

    private String getCurrentValues() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            if (i >= editTextBoldCursorArr.length) {
                break;
            }
            sb.append((CharSequence) editTextBoldCursorArr[i].getText());
            sb.append(",");
            i++;
        }
        if (this.inputExtraFields != null) {
            int i2 = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr2 = this.inputExtraFields;
                if (i2 >= editTextBoldCursorArr2.length) {
                    break;
                }
                sb.append((CharSequence) editTextBoldCursorArr2[i2].getText());
                sb.append(",");
                i2++;
            }
        }
        int size = this.documents.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append(this.documents.get(i3).secureFile.id);
        }
        SecureDocument secureDocument = this.frontDocument;
        if (secureDocument != null) {
            sb.append(secureDocument.secureFile.id);
        }
        SecureDocument secureDocument2 = this.reverseDocument;
        if (secureDocument2 != null) {
            sb.append(secureDocument2.secureFile.id);
        }
        SecureDocument secureDocument3 = this.selfieDocument;
        if (secureDocument3 != null) {
            sb.append(secureDocument3.secureFile.id);
        }
        int size2 = this.translationDocuments.size();
        for (int i4 = 0; i4 < size2; i4++) {
            sb.append(this.translationDocuments.get(i4).secureFile.id);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHasNotAnyChanges() {
        String str = this.initialValues;
        return str == null || str.equals(getCurrentValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDiscard() {
        if (isHasNotAnyChanges()) {
            return false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("PassportDiscard", R.string.PassportDiscard), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$JYU_dFRCDSabYBRcHf0-5wrBbek
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$checkDiscard$69$PassportActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setTitle(LocaleController.getString("DiscardChanges", R.string.DiscardChanges));
        builder.setMessage(LocaleController.getString("PassportDiscardChanges", R.string.PassportDiscardChanges));
        showDialog(builder.create());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkDiscard$69, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkDiscard$69$PassportActivity(DialogInterface dialogInterface, int i) {
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSelectedFiles(final ArrayList<SendMessagesHelper.SendingMediaInfo> photos) {
        if (photos.isEmpty()) {
            return;
        }
        int i = this.uploadingFileType;
        boolean z = true;
        final boolean z2 = false;
        if (i != 1 && i != 4 && (this.currentType.type instanceof TLRPC$TL_secureValueTypePersonalDetails)) {
            int i2 = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
                if (i2 < editTextBoldCursorArr.length) {
                    if (i2 != 5 && i2 != 8 && i2 != 4 && i2 != 6 && editTextBoldCursorArr[i2].length() > 0) {
                        z = false;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            z2 = z;
        }
        final int i3 = this.uploadingFileType;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$CCSHa9litZPkB9USYvB-x6zClS8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSelectedFiles$72$PassportActivity(photos, i3, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedFiles$72, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedFiles$72$PassportActivity(ArrayList arrayList, final int i, boolean z) {
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage;
        int i2 = this.uploadingFileType;
        int iMin = Math.min((i2 == 0 || i2 == 4) ? 20 : 1, arrayList.size());
        boolean z2 = false;
        for (int i3 = 0; i3 < iMin; i3++) {
            SendMessagesHelper.SendingMediaInfo sendingMediaInfo = (SendMessagesHelper.SendingMediaInfo) arrayList.get(i3);
            Bitmap bitmapLoadBitmap = ImageLoader.loadBitmap(sendingMediaInfo.path, sendingMediaInfo.uri, 2048.0f, 2048.0f, false);
            if (bitmapLoadBitmap != null && (tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapLoadBitmap, 2048.0f, 2048.0f, 89, false, 320, 320)) != null) {
                TLRPC$TL_secureFile tLRPC$TL_secureFile = new TLRPC$TL_secureFile();
                tLRPC$TL_secureFile.dc_id = (int) tLRPC$PhotoSizeScaleAndSaveImage.location.volume_id;
                tLRPC$TL_secureFile.id = r9.local_id;
                tLRPC$TL_secureFile.date = (int) (System.currentTimeMillis() / 1000);
                final SecureDocument secureDocumentSaveFile = this.delegate.saveFile(tLRPC$TL_secureFile);
                secureDocumentSaveFile.type = i;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$RpboclgJkaDKnVZgU79vosNMeww
                    @Override // java.lang.Runnable
                    public final void run() throws IOException {
                        this.f$0.lambda$processSelectedFiles$70$PassportActivity(secureDocumentSaveFile, i);
                    }
                });
                if (z && !z2) {
                    try {
                        final MrzRecognizer.Result resultRecognize = MrzRecognizer.recognize(bitmapLoadBitmap, this.currentDocumentsType.type instanceof TLRPC$TL_secureValueTypeDriverLicense);
                        if (resultRecognize != null) {
                            try {
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$e_LoooAWy6XycGFmsSHidNWOzH8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$processSelectedFiles$71$PassportActivity(resultRecognize);
                                    }
                                });
                                z2 = true;
                            } catch (Throwable th) {
                                th = th;
                                z2 = true;
                                FileLog.e(th);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        SharedConfig.saveConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedFiles$70, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedFiles$70$PassportActivity(SecureDocument secureDocument, int i) throws IOException {
        int i2 = this.uploadingFileType;
        if (i2 == 1) {
            SecureDocument secureDocument2 = this.selfieDocument;
            if (secureDocument2 != null) {
                SecureDocumentCell secureDocumentCellRemove = this.documentsCells.remove(secureDocument2);
                if (secureDocumentCellRemove != null) {
                    this.selfieLayout.removeView(secureDocumentCellRemove);
                }
                this.selfieDocument = null;
            }
        } else if (i2 == 4) {
            if (this.translationDocuments.size() >= 20) {
                return;
            }
        } else if (i2 == 2) {
            SecureDocument secureDocument3 = this.frontDocument;
            if (secureDocument3 != null) {
                SecureDocumentCell secureDocumentCellRemove2 = this.documentsCells.remove(secureDocument3);
                if (secureDocumentCellRemove2 != null) {
                    this.frontLayout.removeView(secureDocumentCellRemove2);
                }
                this.frontDocument = null;
            }
        } else if (i2 == 3) {
            SecureDocument secureDocument4 = this.reverseDocument;
            if (secureDocument4 != null) {
                SecureDocumentCell secureDocumentCellRemove3 = this.documentsCells.remove(secureDocument4);
                if (secureDocumentCellRemove3 != null) {
                    this.reverseLayout.removeView(secureDocumentCellRemove3);
                }
                this.reverseDocument = null;
            }
        } else if (i2 == 0 && this.documents.size() >= 20) {
            return;
        }
        this.uploadingDocuments.put(secureDocument.path, secureDocument);
        this.doneItem.setEnabled(false);
        this.doneItem.setAlpha(0.5f);
        FileLoader.getInstance(this.currentAccount).uploadFile(secureDocument.path, false, true, ConnectionsManager.FileTypePhoto);
        addDocumentView(secureDocument, i);
        updateUploadText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedFiles$71, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedFiles$71$PassportActivity(MrzRecognizer.Result result) {
        int i;
        int i2;
        int i3 = result.type;
        if (i3 == 2) {
            if (!(this.currentDocumentsType.type instanceof TLRPC$TL_secureValueTypeIdentityCard)) {
                int size = this.availableDocumentTypes.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = this.availableDocumentTypes.get(i4);
                    if (tLRPC$TL_secureRequiredType.type instanceof TLRPC$TL_secureValueTypeIdentityCard) {
                        this.currentDocumentsType = tLRPC$TL_secureRequiredType;
                        updateInterfaceStringsForDocumentType();
                        break;
                    }
                    i4++;
                }
            }
        } else if (i3 == 1) {
            if (!(this.currentDocumentsType.type instanceof TLRPC$TL_secureValueTypePassport)) {
                int size2 = this.availableDocumentTypes.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size2) {
                        break;
                    }
                    TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType2 = this.availableDocumentTypes.get(i5);
                    if (tLRPC$TL_secureRequiredType2.type instanceof TLRPC$TL_secureValueTypePassport) {
                        this.currentDocumentsType = tLRPC$TL_secureRequiredType2;
                        updateInterfaceStringsForDocumentType();
                        break;
                    }
                    i5++;
                }
            }
        } else if (i3 == 3) {
            if (!(this.currentDocumentsType.type instanceof TLRPC$TL_secureValueTypeInternalPassport)) {
                int size3 = this.availableDocumentTypes.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size3) {
                        break;
                    }
                    TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType3 = this.availableDocumentTypes.get(i6);
                    if (tLRPC$TL_secureRequiredType3.type instanceof TLRPC$TL_secureValueTypeInternalPassport) {
                        this.currentDocumentsType = tLRPC$TL_secureRequiredType3;
                        updateInterfaceStringsForDocumentType();
                        break;
                    }
                    i6++;
                }
            }
        } else if (i3 == 4 && !(this.currentDocumentsType.type instanceof TLRPC$TL_secureValueTypeDriverLicense)) {
            int size4 = this.availableDocumentTypes.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size4) {
                    break;
                }
                TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType4 = this.availableDocumentTypes.get(i7);
                if (tLRPC$TL_secureRequiredType4.type instanceof TLRPC$TL_secureValueTypeDriverLicense) {
                    this.currentDocumentsType = tLRPC$TL_secureRequiredType4;
                    updateInterfaceStringsForDocumentType();
                    break;
                }
                i7++;
            }
        }
        if (!TextUtils.isEmpty(result.firstName)) {
            this.inputFields[0].setText(result.firstName);
        }
        if (!TextUtils.isEmpty(result.middleName)) {
            this.inputFields[1].setText(result.middleName);
        }
        if (!TextUtils.isEmpty(result.lastName)) {
            this.inputFields[2].setText(result.lastName);
        }
        if (!TextUtils.isEmpty(result.number)) {
            this.inputFields[7].setText(result.number);
        }
        int i8 = result.gender;
        if (i8 != 0) {
            if (i8 == 1) {
                this.currentGender = "male";
                this.inputFields[4].setText(LocaleController.getString("PassportMale", R.string.PassportMale));
            } else if (i8 == 2) {
                this.currentGender = "female";
                this.inputFields[4].setText(LocaleController.getString("PassportFemale", R.string.PassportFemale));
            }
        }
        if (!TextUtils.isEmpty(result.nationality)) {
            String str = result.nationality;
            this.currentCitizeship = str;
            String str2 = this.languageMap.get(str);
            if (str2 != null) {
                this.inputFields[5].setText(str2);
            }
        }
        if (!TextUtils.isEmpty(result.issuingCountry)) {
            String str3 = result.issuingCountry;
            this.currentResidence = str3;
            String str4 = this.languageMap.get(str3);
            if (str4 != null) {
                this.inputFields[6].setText(str4);
            }
        }
        int i9 = result.birthDay;
        if (i9 > 0 && result.birthMonth > 0 && result.birthYear > 0) {
            this.inputFields[3].setText(String.format(Locale.US, "%02d.%02d.%d", Integer.valueOf(i9), Integer.valueOf(result.birthMonth), Integer.valueOf(result.birthYear)));
        }
        int i10 = result.expiryDay;
        if (i10 > 0 && (i = result.expiryMonth) > 0 && (i2 = result.expiryYear) > 0) {
            int[] iArr = this.currentExpireDate;
            iArr[0] = i2;
            iArr[1] = i;
            iArr[2] = i10;
            this.inputFields[8].setText(String.format(Locale.US, "%02d.%02d.%d", Integer.valueOf(i10), Integer.valueOf(result.expiryMonth), Integer.valueOf(result.expiryYear)));
            return;
        }
        int[] iArr2 = this.currentExpireDate;
        iArr2[2] = 0;
        iArr2[1] = 0;
        iArr2[0] = 0;
        this.inputFields[8].setText(LocaleController.getString("PassportNoExpireDate", R.string.PassportNoExpireDate));
    }

    public void setNeedActivityResult(boolean needActivityResult) {
        this.needActivityResult = needActivityResult;
    }

    private static class ProgressView extends View {
        private Paint paint;
        private Paint paint2;
        private float progress;

        public ProgressView(Context context) {
            super(context);
            this.paint = new Paint();
            this.paint2 = new Paint();
            this.paint.setColor(Theme.getColor("login_progressInner"));
            this.paint2.setColor(Theme.getColor("login_progressOuter"));
        }

        public void setProgress(float value) {
            this.progress = value;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float measuredWidth = (int) (getMeasuredWidth() * this.progress);
            canvas.drawRect(0.0f, 0.0f, measuredWidth, getMeasuredHeight(), this.paint2);
            canvas.drawRect(measuredWidth, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
        }
    }

    public class PhoneConfirmationView extends SlideView implements NotificationCenter.NotificationCenterDelegate {
        private ImageView blackImageView;
        private ImageView blueImageView;
        private EditTextBoldCursor[] codeField;
        private LinearLayout codeFieldContainer;
        private int codeTime;
        private Timer codeTimer;
        private TextView confirmTextView;
        private Bundle currentParams;
        private boolean ignoreOnTextChange;
        private double lastCodeTime;
        private double lastCurrentTime;
        private String lastError;
        private int length;
        private boolean nextPressed;
        private int nextType;
        private String pattern;
        private String phone;
        private String phoneHash;
        private TextView problemText;
        private ProgressView progressView;
        private int time;
        private TextView timeText;
        private Timer timeTimer;
        private int timeout;
        private final Object timerSync;
        private TextView titleTextView;
        private int verificationType;
        private boolean waitingForEvent;

        static /* synthetic */ void lambda$onBackPressed$9(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        static /* synthetic */ int access$10026(PhoneConfirmationView phoneConfirmationView, double d) {
            double d2 = phoneConfirmationView.codeTime;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            phoneConfirmationView.codeTime = i;
            return i;
        }

        static /* synthetic */ int access$10626(PhoneConfirmationView phoneConfirmationView, double d) {
            double d2 = phoneConfirmationView.time;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            phoneConfirmationView.time = i;
            return i;
        }

        public PhoneConfirmationView(Context context, final int type) {
            super(context);
            this.timerSync = new Object();
            this.time = 60000;
            this.codeTime = 15000;
            this.lastError = "";
            this.pattern = "*";
            this.verificationType = type;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            TextView textView2 = new TextView(context);
            this.titleTextView = textView2;
            textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.titleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.titleTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.titleTextView.setGravity(49);
            if (this.verificationType == 3) {
                this.confirmTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
                FrameLayout frameLayout = new FrameLayout(context);
                addView(frameLayout, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.phone_activate);
                boolean z = LocaleController.isRTL;
                if (z) {
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 19, 2.0f, 2.0f, 0.0f, 0.0f));
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, LocaleController.isRTL ? 5 : 3, 82.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, z ? 5 : 3, 0.0f, 0.0f, 82.0f, 0.0f));
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 21, 0.0f, 2.0f, 0.0f, 2.0f));
                }
            } else {
                this.confirmTextView.setGravity(49);
                FrameLayout frameLayout2 = new FrameLayout(context);
                addView(frameLayout2, LayoutHelper.createLinear(-2, -2, 49));
                if (this.verificationType == 1) {
                    ImageView imageView2 = new ImageView(context);
                    this.blackImageView = imageView2;
                    imageView2.setImageResource(R.drawable.sms_devices);
                    this.blackImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blackImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    ImageView imageView3 = new ImageView(context);
                    this.blueImageView = imageView3;
                    imageView3.setImageResource(R.drawable.sms_bubble);
                    this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentAppCodeTitle", R.string.SentAppCodeTitle));
                } else {
                    ImageView imageView4 = new ImageView(context);
                    this.blueImageView = imageView4;
                    imageView4.setImageResource(R.drawable.sms_code);
                    this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentSmsCodeTitle", R.string.SentSmsCodeTitle));
                }
                addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 18, 0, 0));
                addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 17, 0, 0));
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.codeFieldContainer = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.codeFieldContainer, LayoutHelper.createLinear(-2, 36, 1));
            if (this.verificationType == 3) {
                this.codeFieldContainer.setVisibility(8);
            }
            TextView textView3 = new TextView(context) { // from class: ir.eitaa.ui.PassportActivity.PhoneConfirmationView.1
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.timeText = textView3;
            textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.timeText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            if (this.verificationType == 3) {
                this.timeText.setTextSize(1, 14.0f);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                this.progressView = new ProgressView(context);
                this.timeText.setGravity(LocaleController.isRTL ? 5 : 3);
                addView(this.progressView, LayoutHelper.createLinear(-1, 3, 0.0f, 12.0f, 0.0f, 0.0f));
            } else {
                this.timeText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
                this.timeText.setTextSize(1, 15.0f);
                this.timeText.setGravity(49);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, 49));
            }
            TextView textView4 = new TextView(context) { // from class: ir.eitaa.ui.PassportActivity.PhoneConfirmationView.2
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.problemText = textView4;
            textView4.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.problemText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.problemText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
            this.problemText.setTextSize(1, 15.0f);
            this.problemText.setGravity(49);
            if (this.verificationType == 1) {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCodeSms", R.string.DidNotGetTheCodeSms));
            } else {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCode", R.string.DidNotGetTheCode));
            }
            addView(this.problemText, LayoutHelper.createLinear(-2, -2, 49));
            this.problemText.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$kHKVx9ia2UzvVRvN1kRaYtGpd2k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$new$0$PassportActivity$PhoneConfirmationView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$PassportActivity$PhoneConfirmationView(View view) throws PackageManager.NameNotFoundException {
            if (this.nextPressed) {
                return;
            }
            int i = this.nextType;
            if (!((i == 4 && this.verificationType == 2) || i == 0)) {
                resendCode();
                return;
            }
            try {
                PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                String str = String.format(Locale.US, "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"reports@stel.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Android registration/login issue " + str + " " + this.phone);
                intent.putExtra("android.intent.extra.TEXT", "Phone: " + this.phone + "\nApp version: " + str + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault() + "\nError: " + this.lastError);
                getContext().startActivity(Intent.createChooser(intent, "Send email..."));
            } catch (Exception unused) {
                AlertsCreator.showSimpleAlert(PassportActivity.this, LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            ImageView imageView;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.verificationType == 3 || (imageView = this.blueImageView) == null) {
                return;
            }
            int measuredHeight = imageView.getMeasuredHeight() + this.titleTextView.getMeasuredHeight() + this.confirmTextView.getMeasuredHeight() + AndroidUtilities.dp(35.0f);
            int iDp = AndroidUtilities.dp(80.0f);
            int iDp2 = AndroidUtilities.dp(291.0f);
            if (PassportActivity.this.scrollHeight - measuredHeight >= iDp) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(PassportActivity.this.scrollHeight, iDp2));
            } else {
                setMeasuredDimension(getMeasuredWidth(), measuredHeight + iDp);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int i;
            super.onLayout(changed, l, t, r, b);
            if (this.verificationType == 3 || this.blueImageView == null) {
                return;
            }
            int bottom = this.confirmTextView.getBottom();
            int measuredHeight = getMeasuredHeight() - bottom;
            if (this.problemText.getVisibility() == 0) {
                int measuredHeight2 = this.problemText.getMeasuredHeight();
                i = (measuredHeight + bottom) - measuredHeight2;
                TextView textView = this.problemText;
                textView.layout(textView.getLeft(), i, this.problemText.getRight(), measuredHeight2 + i);
            } else if (this.timeText.getVisibility() == 0) {
                int measuredHeight3 = this.timeText.getMeasuredHeight();
                i = (measuredHeight + bottom) - measuredHeight3;
                TextView textView2 = this.timeText;
                textView2.layout(textView2.getLeft(), i, this.timeText.getRight(), measuredHeight3 + i);
            } else {
                i = measuredHeight + bottom;
            }
            int measuredHeight4 = this.codeFieldContainer.getMeasuredHeight();
            int i2 = (((i - bottom) - measuredHeight4) / 2) + bottom;
            LinearLayout linearLayout = this.codeFieldContainer;
            linearLayout.layout(linearLayout.getLeft(), i2, this.codeFieldContainer.getRight(), measuredHeight4 + i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resendCode() {
            final Bundle bundle = new Bundle();
            bundle.putString("phone", this.phone);
            this.nextPressed = true;
            PassportActivity.this.needShowProgress();
            final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
            tLRPC$TL_auth_resendCode.phone_number = this.phone;
            tLRPC$TL_auth_resendCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$cwBGC8Hr-wfqyOlJa8jyfonGudY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$resendCode$3$PassportActivity$PhoneConfirmationView(bundle, tLRPC$TL_auth_resendCode, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$3$PassportActivity$PhoneConfirmationView(final Bundle bundle, final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$yzWjRDp7fvOKgJWwAOwWsQCoKYQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resendCode$2$PassportActivity$PhoneConfirmationView(tLRPC$TL_error, bundle, tLObject, tLRPC$TL_auth_resendCode);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$2$PassportActivity$PhoneConfirmationView(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject, TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                PassportActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject, true);
            } else {
                AlertDialog alertDialog = (AlertDialog) AlertsCreator.processError(((BaseFragment) PassportActivity.this).currentAccount, tLRPC$TL_error, PassportActivity.this, tLRPC$TL_auth_resendCode, new Object[0]);
                if (alertDialog != null && tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    alertDialog.setPositiveButtonListener(new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$ELyKNJGT6VR8aL78j40iJkFSO5Y
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$resendCode$1$PassportActivity$PhoneConfirmationView(dialogInterface, i);
                        }
                    });
                }
            }
            PassportActivity.this.needHideProgress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$1$PassportActivity$PhoneConfirmationView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            PassportActivity.this.finishFragment();
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            int i;
            int i2;
            if (params == null) {
                return;
            }
            this.waitingForEvent = true;
            int i3 = this.verificationType;
            if (i3 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i3 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.currentParams = params;
            this.phone = params.getString("phone");
            this.phoneHash = params.getString("phoneHash");
            int i4 = params.getInt("timeout");
            this.time = i4;
            this.timeout = i4;
            this.nextType = params.getInt("nextType");
            this.pattern = params.getString("pattern");
            int i5 = params.getInt("length");
            this.length = i5;
            if (i5 == 0) {
                this.length = 5;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            CharSequence charSequenceReplaceTags = "";
            if (editTextBoldCursorArr != null && editTextBoldCursorArr.length == this.length) {
                int i6 = 0;
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                    if (i6 >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    editTextBoldCursorArr2[i6].setText("");
                    i6++;
                }
            } else {
                this.codeField = new EditTextBoldCursor[this.length];
                final int i7 = 0;
                while (i7 < this.length) {
                    this.codeField[i7] = new EditTextBoldCursor(getContext());
                    this.codeField[i7].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i7].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i7].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.codeField[i7].setCursorWidth(1.5f);
                    Drawable drawableMutate = getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteInputFieldActivated"), PorterDuff.Mode.MULTIPLY));
                    this.codeField[i7].setBackgroundDrawable(drawableMutate);
                    this.codeField[i7].setImeOptions(268435461);
                    this.codeField[i7].setTextSize(1, 20.0f);
                    this.codeField[i7].setMaxLines(1);
                    this.codeField[i7].setTypeface(AndroidUtilities.getFontFamily(true));
                    this.codeField[i7].setPadding(0, 0, 0, 0);
                    this.codeField[i7].setGravity(49);
                    if (this.verificationType == 3) {
                        this.codeField[i7].setEnabled(false);
                        this.codeField[i7].setInputType(0);
                        this.codeField[i7].setVisibility(8);
                    } else {
                        this.codeField[i7].setInputType(3);
                    }
                    this.codeFieldContainer.addView(this.codeField[i7], LayoutHelper.createLinear(34, 36, 1, 0, 0, i7 != this.length - 1 ? 7 : 0, 0));
                    this.codeField[i7].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.PassportActivity.PhoneConfirmationView.3
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            int length;
                            if (!PhoneConfirmationView.this.ignoreOnTextChange && (length = s.length()) >= 1) {
                                if (length > 1) {
                                    String string = s.toString();
                                    PhoneConfirmationView.this.ignoreOnTextChange = true;
                                    for (int i8 = 0; i8 < Math.min(PhoneConfirmationView.this.length - i7, length); i8++) {
                                        if (i8 != 0) {
                                            PhoneConfirmationView.this.codeField[i7 + i8].setText(string.substring(i8, i8 + 1));
                                        } else {
                                            s.replace(0, length, string.substring(i8, i8 + 1));
                                        }
                                    }
                                    PhoneConfirmationView.this.ignoreOnTextChange = false;
                                }
                                if (i7 != PhoneConfirmationView.this.length - 1) {
                                    PhoneConfirmationView.this.codeField[i7 + 1].setSelection(PhoneConfirmationView.this.codeField[i7 + 1].length());
                                    PhoneConfirmationView.this.codeField[i7 + 1].requestFocus();
                                }
                                if ((i7 == PhoneConfirmationView.this.length - 1 || (i7 == PhoneConfirmationView.this.length - 2 && length >= 2)) && PhoneConfirmationView.this.getCode().length() == PhoneConfirmationView.this.length) {
                                    PhoneConfirmationView.this.onNextPressed();
                                }
                            }
                        }
                    });
                    this.codeField[i7].setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$CsoLTsYH9NUFqJyTPjLc3uNAbNQ
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$4$PassportActivity$PhoneConfirmationView(i7, view, i8, keyEvent);
                        }
                    });
                    this.codeField[i7].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$hTbodC5ZsCb8Mric0xuT-MQt_ZY
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$5$PassportActivity$PhoneConfirmationView(textView, i8, keyEvent);
                        }
                    });
                    i7++;
                }
            }
            ProgressView progressView = this.progressView;
            if (progressView != null) {
                progressView.setVisibility(this.nextType != 0 ? 0 : 8);
            }
            if (this.phone == null) {
                return;
            }
            String str = PhoneFormat.getInstance().format("+" + this.phone);
            int i8 = this.verificationType;
            if (i8 == 2) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentSmsCode", R.string.SentSmsCode, LocaleController.addNbsp(str)));
            } else if (i8 == 3) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallCode", R.string.SentCallCode, LocaleController.addNbsp(str)));
            } else if (i8 == 4) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallOnly", R.string.SentCallOnly, LocaleController.addNbsp(str)));
            }
            this.confirmTextView.setText(charSequenceReplaceTags);
            if (this.verificationType != 3) {
                AndroidUtilities.showKeyboard(this.codeField[0]);
                this.codeField[0].requestFocus();
            } else {
                AndroidUtilities.hideKeyboard(this.codeField[0]);
            }
            destroyTimer();
            destroyCodeTimer();
            this.lastCurrentTime = System.currentTimeMillis();
            int i9 = this.verificationType;
            if (i9 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) {
                this.problemText.setVisibility(8);
                this.timeText.setVisibility(0);
                int i10 = this.nextType;
                if (i10 == 4) {
                    this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 1, 0));
                } else if (i10 == 2) {
                    this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 1, 0));
                }
                createTimer();
                return;
            }
            if (i9 == 2 && ((i = this.nextType) == 4 || i == 3)) {
                this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            if (i9 == 4 && this.nextType == 2) {
                this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            this.timeText.setVisibility(8);
            this.problemText.setVisibility(8);
            createCodeTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setParams$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$4$PassportActivity$PhoneConfirmationView(int i, View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67 || this.codeField[i].length() != 0 || i <= 0) {
                return false;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            int i3 = i - 1;
            editTextBoldCursorArr[i3].setSelection(editTextBoldCursorArr[i3].length());
            this.codeField[i3].requestFocus();
            this.codeField[i3].dispatchKeyEvent(keyEvent);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setParams$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$5$PassportActivity$PhoneConfirmationView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createCodeTimer() {
            if (this.codeTimer != null) {
                return;
            }
            this.codeTime = 15000;
            this.codeTimer = new Timer();
            this.lastCodeTime = System.currentTimeMillis();
            this.codeTimer.schedule(new AnonymousClass4(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.PassportActivity$PhoneConfirmationView$4, reason: invalid class name */
        class AnonymousClass4 extends TimerTask {
            AnonymousClass4() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$4$nGc0av_qct9u4vpHGv09MkIdj0I
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$PassportActivity$PhoneConfirmationView$4();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$PassportActivity$PhoneConfirmationView$4() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = PhoneConfirmationView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                PhoneConfirmationView.this.lastCodeTime = dCurrentTimeMillis;
                PhoneConfirmationView.access$10026(PhoneConfirmationView.this, dCurrentTimeMillis - d);
                if (PhoneConfirmationView.this.codeTime <= 1000) {
                    PhoneConfirmationView.this.problemText.setVisibility(0);
                    PhoneConfirmationView.this.timeText.setVisibility(8);
                    PhoneConfirmationView.this.destroyCodeTimer();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyCodeTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.codeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.codeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        private void createTimer() {
            if (this.timeTimer != null) {
                return;
            }
            Timer timer = new Timer();
            this.timeTimer = timer;
            timer.schedule(new AnonymousClass5(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.PassportActivity$PhoneConfirmationView$5, reason: invalid class name */
        class AnonymousClass5 extends TimerTask {
            AnonymousClass5() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (PhoneConfirmationView.this.timeTimer == null) {
                    return;
                }
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = PhoneConfirmationView.this.lastCurrentTime;
                Double.isNaN(dCurrentTimeMillis);
                PhoneConfirmationView.access$10626(PhoneConfirmationView.this, dCurrentTimeMillis - d);
                PhoneConfirmationView.this.lastCurrentTime = dCurrentTimeMillis;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$5$-dOFrr7q_9A7F6Sllis9NjXzKa0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2$PassportActivity$PhoneConfirmationView$5();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$2$PassportActivity$PhoneConfirmationView$5() {
                if (PhoneConfirmationView.this.time >= 1000) {
                    int i = (PhoneConfirmationView.this.time / 1000) / 60;
                    int i2 = (PhoneConfirmationView.this.time / 1000) - (i * 60);
                    if (PhoneConfirmationView.this.nextType == 4 || PhoneConfirmationView.this.nextType == 3) {
                        PhoneConfirmationView.this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, Integer.valueOf(i), Integer.valueOf(i2)));
                    } else if (PhoneConfirmationView.this.nextType == 2) {
                        PhoneConfirmationView.this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    if (PhoneConfirmationView.this.progressView != null) {
                        PhoneConfirmationView.this.progressView.setProgress(1.0f - (PhoneConfirmationView.this.time / PhoneConfirmationView.this.timeout));
                        return;
                    }
                    return;
                }
                if (PhoneConfirmationView.this.progressView != null) {
                    PhoneConfirmationView.this.progressView.setProgress(1.0f);
                }
                PhoneConfirmationView.this.destroyTimer();
                if (PhoneConfirmationView.this.verificationType != 3) {
                    if (PhoneConfirmationView.this.verificationType == 2 || PhoneConfirmationView.this.verificationType == 4) {
                        if (PhoneConfirmationView.this.nextType == 4 || PhoneConfirmationView.this.nextType == 2) {
                            if (PhoneConfirmationView.this.nextType == 4) {
                                PhoneConfirmationView.this.timeText.setText(LocaleController.getString("Calling", R.string.Calling));
                            } else {
                                PhoneConfirmationView.this.timeText.setText(LocaleController.getString("SendingSms", R.string.SendingSms));
                            }
                            PhoneConfirmationView.this.createCodeTimer();
                            TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                            tLRPC$TL_auth_resendCode.phone_number = PhoneConfirmationView.this.phone;
                            tLRPC$TL_auth_resendCode.phone_code_hash = PhoneConfirmationView.this.phoneHash;
                            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$5$0BM5RrXgdrJQlTPi6aOrxNEPJo4
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$run$1$PassportActivity$PhoneConfirmationView$5(tLObject, tLRPC$TL_error);
                                }
                            }, 2);
                            return;
                        }
                        if (PhoneConfirmationView.this.nextType == 3) {
                            AndroidUtilities.setWaitingForSms(false);
                            NotificationCenter.getGlobalInstance().removeObserver(PhoneConfirmationView.this, NotificationCenter.didReceiveSmsCode);
                            PhoneConfirmationView.this.waitingForEvent = false;
                            PhoneConfirmationView.this.destroyCodeTimer();
                            PhoneConfirmationView.this.resendCode();
                            return;
                        }
                        return;
                    }
                    return;
                }
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(PhoneConfirmationView.this, NotificationCenter.didReceiveCall);
                PhoneConfirmationView.this.waitingForEvent = false;
                PhoneConfirmationView.this.destroyCodeTimer();
                PhoneConfirmationView.this.resendCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$1$PassportActivity$PhoneConfirmationView$5(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$5$u3gol5FwxMvreeJvof4aFydtg_I
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$PassportActivity$PhoneConfirmationView$5(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$PassportActivity$PhoneConfirmationView$5(TLRPC$TL_error tLRPC$TL_error) {
                PhoneConfirmationView.this.lastError = tLRPC$TL_error.text;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.timeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.timeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getCode() {
            if (this.codeField == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i < editTextBoldCursorArr.length) {
                    sb.append(PhoneFormat.stripExceptNumbers(editTextBoldCursorArr[i].getText().toString()));
                    i++;
                } else {
                    return sb.toString();
                }
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            String code = getCode();
            if (TextUtils.isEmpty(code)) {
                AndroidUtilities.shakeView(this.codeFieldContainer, 2.0f, 0);
                return;
            }
            this.nextPressed = true;
            int i = this.verificationType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            PassportActivity.this.showEditDoneProgress(true, true);
            final TLRPC$TL_account_verifyPhone tLRPC$TL_account_verifyPhone = new TLRPC$TL_account_verifyPhone();
            tLRPC$TL_account_verifyPhone.phone_number = this.phone;
            tLRPC$TL_account_verifyPhone.phone_code = code;
            tLRPC$TL_account_verifyPhone.phone_code_hash = this.phoneHash;
            destroyTimer();
            PassportActivity.this.needShowProgress();
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_account_verifyPhone, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$u3VfkYc8WE_maW8yZZ0sj-OSNgc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$7$PassportActivity$PhoneConfirmationView(tLRPC$TL_account_verifyPhone, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$7$PassportActivity$PhoneConfirmationView(final TLRPC$TL_account_verifyPhone tLRPC$TL_account_verifyPhone, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$_Q8kel0HcmzsB6RZHII2t-g-tB8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$6$PassportActivity$PhoneConfirmationView(tLRPC$TL_error, tLRPC$TL_account_verifyPhone);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$6$PassportActivity$PhoneConfirmationView(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_verifyPhone tLRPC$TL_account_verifyPhone) {
            int i;
            int i2;
            PassportActivity.this.needHideProgress();
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                destroyTimer();
                destroyCodeTimer();
                PassportActivityDelegate passportActivityDelegate = PassportActivity.this.delegate;
                TLRPC$TL_secureRequiredType tLRPC$TL_secureRequiredType = PassportActivity.this.currentType;
                String str = (String) PassportActivity.this.currentValues.get("phone");
                final PassportActivity passportActivity = PassportActivity.this;
                passportActivityDelegate.saveValue(tLRPC$TL_secureRequiredType, str, null, null, null, null, null, null, null, null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$vGP3NExbrWztPzvO0G8Nz6i0Yto
                    @Override // java.lang.Runnable
                    public final void run() {
                        passportActivity.finishFragment();
                    }
                }, null);
                return;
            }
            this.lastError = tLRPC$TL_error.text;
            int i3 = this.verificationType;
            if ((i3 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) || ((i3 == 2 && ((i = this.nextType) == 4 || i == 3)) || (i3 == 4 && this.nextType == 2))) {
                createTimer();
            }
            int i4 = this.verificationType;
            if (i4 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i4 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = true;
            if (this.verificationType != 3) {
                AlertsCreator.processError(((BaseFragment) PassportActivity.this).currentAccount, tLRPC$TL_error, PassportActivity.this, tLRPC$TL_account_verifyPhone, new Object[0]);
            }
            PassportActivity.this.showEditDoneProgress(true, false);
            if (!tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") && !tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    onBackPressed(true);
                    PassportActivity.this.setPage(0, true, null);
                    return;
                }
                return;
            }
            int i5 = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i5 < editTextBoldCursorArr.length) {
                    editTextBoldCursorArr[i5].setText("");
                    i5++;
                } else {
                    editTextBoldCursorArr[0].requestFocus();
                    return;
                }
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            if (!force) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PassportActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("StopVerification", R.string.StopVerification));
                builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$kHtlUfR9HikNxKjWLTHBHV9OllM
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onBackPressed$8$PassportActivity$PhoneConfirmationView(dialogInterface, i);
                    }
                });
                PassportActivity.this.showDialog(builder.create());
                return false;
            }
            TLRPC$TL_auth_cancelCode tLRPC$TL_auth_cancelCode = new TLRPC$TL_auth_cancelCode();
            tLRPC$TL_auth_cancelCode.phone_number = this.phone;
            tLRPC$TL_auth_cancelCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) PassportActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_cancelCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PassportActivity$PhoneConfirmationView$t7Lb_wBuFpvhEA1vqHylK_yB8m4
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    PassportActivity.PhoneConfirmationView.lambda$onBackPressed$9(tLObject, tLRPC$TL_error);
                }
            }, 2);
            destroyTimer();
            destroyCodeTimer();
            this.currentParams = null;
            int i = this.verificationType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onBackPressed$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onBackPressed$8$PassportActivity$PhoneConfirmationView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            PassportActivity.this.setPage(0, true, null);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onDestroyActivity() {
            super.onDestroyActivity();
            int i = this.verificationType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            destroyTimer();
            destroyCodeTimer();
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            LinearLayout linearLayout = this.codeFieldContainer;
            if (linearLayout == null || linearLayout.getVisibility() != 0) {
                return;
            }
            for (int length = this.codeField.length - 1; length >= 0; length--) {
                if (length == 0 || this.codeField[length].length() != 0) {
                    this.codeField[length].requestFocus();
                    EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                    editTextBoldCursorArr[length].setSelection(editTextBoldCursorArr[length].length());
                    AndroidUtilities.showKeyboard(this.codeField[length]);
                    return;
                }
            }
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            EditTextBoldCursor[] editTextBoldCursorArr;
            if (!this.waitingForEvent || (editTextBoldCursorArr = this.codeField) == null) {
                return;
            }
            if (id == NotificationCenter.didReceiveSmsCode) {
                editTextBoldCursorArr[0].setText("" + args[0]);
                onNextPressed();
                return;
            }
            if (id == NotificationCenter.didReceiveCall) {
                String str = "" + args[0];
                if (AndroidUtilities.checkPhonePattern(this.pattern, str)) {
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(str);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                }
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.extraBackgroundView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        if (this.extraBackgroundView2 != null) {
            arrayList.add(new ThemeDescription(this.extraBackgroundView2, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        }
        for (int i = 0; i < this.dividers.size(); i++) {
            arrayList.add(new ThemeDescription(this.dividers.get(i), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "divider"));
        }
        Iterator<Map.Entry<SecureDocument, SecureDocumentCell>> it = this.documentsCells.entrySet().iterator();
        while (it.hasNext()) {
            SecureDocumentCell value = it.next().getValue();
            arrayList.add(new ThemeDescription(value, ThemeDescription.FLAG_SELECTORWHITE, new Class[]{SecureDocumentCell.class}, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(value, 0, new Class[]{SecureDocumentCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(value, 0, new Class[]{SecureDocumentCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        }
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_SELECTORWHITE, new Class[]{TextDetailSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_SELECTORWHITE, new Class[]{TextSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_SELECTORWHITE, new Class[]{TextDetailSecureCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextDetailSecureCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextDetailSecureCell.class}, null, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{TextDetailSecureCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{TextDetailSecureCell.class}, new String[]{"checkImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "featuredStickers_addedIcon"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        if (this.inputFields != null) {
            for (int i2 = 0; i2 < this.inputFields.length; i2++) {
                arrayList.add(new ThemeDescription((View) this.inputFields[i2].getParent(), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_HINTTEXTCOLOR | ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "windowBackgroundWhiteBlueHeader"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_PROGRESSBAR | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteRedText3"));
            }
        } else {
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_PROGRESSBAR | ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueHeader"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "windowBackgroundWhiteRedText3"));
        }
        if (this.inputExtraFields != null) {
            for (int i3 = 0; i3 < this.inputExtraFields.length; i3++) {
                arrayList.add(new ThemeDescription((View) this.inputExtraFields[i3].getParent(), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_HINTTEXTCOLOR | ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "windowBackgroundWhiteBlueHeader"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(this.inputExtraFields[i3], ThemeDescription.FLAG_PROGRESSBAR | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteRedText3"));
            }
        }
        arrayList.add(new ThemeDescription(this.emptyView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.noPasswordImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chat_messagePanelIcons"));
        arrayList.add(new ThemeDescription(this.noPasswordTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.noPasswordSetTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText5"));
        arrayList.add(new ThemeDescription(this.passwordForgotButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(this.plusTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.acceptTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "passport_authorizeText"));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "passport_authorizeBackground"));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "passport_authorizeBackgroundSelected"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressInner2"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressOuter2"));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, "contextProgressInner2"));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, "contextProgressOuter2"));
        arrayList.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "sessions_devicesImage"));
        arrayList.add(new ThemeDescription(this.emptyTextView1, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.emptyTextView2, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.emptyTextView3, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
        return arrayList;
    }
}
