package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_account_updateProfile;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes4.dex */
public class ChangeNameAndAvatarActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, ImageUpdater.ImageUpdaterDelegate {
    private TLRPC$FileLocation avatar;
    private AnimatorSet avatarAnimation;
    private TLRPC$FileLocation avatarBig;
    private AvatarDrawable avatarDrawable;
    private RLottieImageView avatarEditor;
    private BackupImageView avatarImage;
    private View avatarOverlay;
    private RadialProgressView avatarProgressView;
    private RLottieDrawable cameraDrawable;
    private View doneButton;
    private FrameLayout editTextContainer;
    private EditTextBoldCursor firstNameField;
    private ImageUpdater imageUpdater;
    private EditTextBoldCursor lastNameField;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public /* synthetic */ void didStartUpload(boolean z) {
        ImageUpdater.ImageUpdaterDelegate.CC.$default$didStartUpload(this, z);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public /* synthetic */ String getInitialSearchString() {
        return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public /* synthetic */ void onUploadProgressChanged(float f) {
        ImageUpdater.ImageUpdaterDelegate.CC.$default$onUploadProgressChanged(this, f);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("EditNameAndAvatarTitle", R.string.EditNameAndAvatarTitle));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ChangeNameAndAvatarActivity.this.finishFragment();
                    return;
                }
                if (i == 1) {
                    if (ChangeNameAndAvatarActivity.this.firstNameField.getText().length() == 0 && ChangeNameAndAvatarActivity.this.lastNameField.getText().length() == 0) {
                        return;
                    }
                    ChangeNameAndAvatarActivity.this.saveName();
                    ChangeNameAndAvatarActivity.this.finishFragment();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
        if (user == null) {
            user = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.fragmentView = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ((LinearLayout) this.fragmentView).setOrientation(1);
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChangeNameAndAvatarActivity.lambda$createView$0(view, motionEvent);
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.editTextContainer = frameLayout;
        linearLayout.addView(frameLayout, LayoutHelper.createLinear(-1, -2));
        this.avatarDrawable = new AvatarDrawable();
        BackupImageView backupImageView = new BackupImageView(context);
        this.avatarImage = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(32.0f));
        FrameLayout frameLayout2 = this.editTextContainer;
        BackupImageView backupImageView2 = this.avatarImage;
        boolean z = LocaleController.isRTL;
        frameLayout2.addView(backupImageView2, LayoutHelper.createFrame(64, 64.0f, (z ? 5 : 3) | 48, z ? 0.0f : 16.0f, 12.0f, z ? 16.0f : 0.0f, 12.0f));
        ImageUpdater imageUpdater = new ImageUpdater(false);
        this.imageUpdater = imageUpdater;
        imageUpdater.setOpenWithFrontfaceCamera(true);
        this.imageUpdater.setSearchAvailable(false);
        ImageUpdater imageUpdater2 = this.imageUpdater;
        imageUpdater2.parentFragment = this;
        imageUpdater2.setDelegate(this);
        final Paint paint = new Paint(1);
        paint.setColor(1426063360);
        View view = new View(context) { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity.2
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                if (ChangeNameAndAvatarActivity.this.avatarImage == null || !ChangeNameAndAvatarActivity.this.avatarImage.getImageReceiver().hasNotThumb()) {
                    return;
                }
                paint.setAlpha((int) (ChangeNameAndAvatarActivity.this.avatarImage.getImageReceiver().getCurrentAlpha() * 85.0f));
                canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2.0f, paint);
            }
        };
        this.avatarOverlay = view;
        FrameLayout frameLayout3 = this.editTextContainer;
        boolean z2 = LocaleController.isRTL;
        frameLayout3.addView(view, LayoutHelper.createFrame(64, 64.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 16.0f, 12.0f, z2 ? 16.0f : 0.0f, 12.0f));
        this.avatarOverlay.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$3(view2);
            }
        });
        this.cameraDrawable = new RLottieDrawable(R.raw.camera, "2131820554", AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f), false, null);
        RLottieImageView rLottieImageView = new RLottieImageView(context) { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity.3
            @Override // android.view.View
            public void invalidate(int i, int i2, int i3, int i4) {
                super.invalidate(i, i2, i3, i4);
                ChangeNameAndAvatarActivity.this.avatarOverlay.invalidate();
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                ChangeNameAndAvatarActivity.this.avatarOverlay.invalidate();
            }
        };
        this.avatarEditor = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.avatarEditor.setAnimation(this.cameraDrawable);
        this.avatarEditor.setEnabled(false);
        this.avatarEditor.setClickable(false);
        this.avatarEditor.setPadding(AndroidUtilities.dp(2.0f), 0, 0, AndroidUtilities.dp(1.0f));
        FrameLayout frameLayout4 = this.editTextContainer;
        RLottieImageView rLottieImageView2 = this.avatarEditor;
        boolean z3 = LocaleController.isRTL;
        frameLayout4.addView(rLottieImageView2, LayoutHelper.createFrame(64, 64.0f, (z3 ? 5 : 3) | 48, z3 ? 0.0f : 16.0f, 12.0f, z3 ? 16.0f : 0.0f, 12.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.avatarProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(30.0f));
        this.avatarProgressView.setProgressColor(-1);
        this.avatarProgressView.setNoProgress(false);
        FrameLayout frameLayout5 = this.editTextContainer;
        RadialProgressView radialProgressView2 = this.avatarProgressView;
        boolean z4 = LocaleController.isRTL;
        frameLayout5.addView(radialProgressView2, LayoutHelper.createFrame(64, 64.0f, (z4 ? 5 : 3) | 48, z4 ? 0.0f : 16.0f, 12.0f, z4 ? 16.0f : 0.0f, 12.0f));
        showAvatarProgress(false, false);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.firstNameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
        int i = Theme.key_windowBackgroundWhiteHintText;
        editTextBoldCursor2.setHintTextColor(Theme.getColor(i));
        EditTextBoldCursor editTextBoldCursor3 = this.firstNameField;
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        editTextBoldCursor3.setTextColor(Theme.getColor(i2));
        this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.firstNameField.setMaxLines(1);
        this.firstNameField.setLines(1);
        EditTextBoldCursor editTextBoldCursor4 = this.firstNameField;
        editTextBoldCursor4.setFilters(InputFilterHelper.getFilter(30, 1, editTextBoldCursor4));
        this.firstNameField.setSingleLine(true);
        this.firstNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.firstNameField.setInputType(49152);
        this.firstNameField.setImeOptions(5);
        this.firstNameField.setHint(LocaleController.getString("FirstNameProfile", R.string.FirstNameProfile));
        this.firstNameField.setCursorColor(Theme.getColor(i2));
        this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.firstNameField.setCursorWidth(1.5f);
        FrameLayout frameLayout6 = this.editTextContainer;
        EditTextBoldCursor editTextBoldCursor5 = this.firstNameField;
        boolean z5 = LocaleController.isRTL;
        frameLayout6.addView(editTextBoldCursor5, LayoutHelper.createFrame(-1, 36.0f, 16, z5 ? 16.0f : 96.0f, 0.0f, z5 ? 96.0f : 16.0f, 24.0f));
        this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$4(textView, i3, keyEvent);
            }
        });
        EditTextBoldCursor editTextBoldCursor6 = new EditTextBoldCursor(context);
        this.lastNameField = editTextBoldCursor6;
        editTextBoldCursor6.setTextSize(1, 18.0f);
        this.lastNameField.setHintTextColor(Theme.getColor(i));
        this.lastNameField.setTextColor(Theme.getColor(i2));
        this.lastNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.lastNameField.setMaxLines(1);
        this.lastNameField.setLines(1);
        EditTextBoldCursor editTextBoldCursor7 = this.lastNameField;
        editTextBoldCursor7.setFilters(InputFilterHelper.getFilter(50, 1, editTextBoldCursor7));
        this.lastNameField.setSingleLine(true);
        this.lastNameField.setGravity(LocaleController.isRTL ? 5 : 3);
        this.lastNameField.setInputType(49152);
        this.lastNameField.setImeOptions(6);
        this.lastNameField.setHint(LocaleController.getString("LastNameProfile", R.string.LastNameProfile));
        this.lastNameField.setCursorColor(Theme.getColor(i2));
        this.lastNameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.lastNameField.setCursorWidth(1.5f);
        FrameLayout frameLayout7 = this.editTextContainer;
        EditTextBoldCursor editTextBoldCursor8 = this.lastNameField;
        boolean z6 = LocaleController.isRTL;
        frameLayout7.addView(editTextBoldCursor8, LayoutHelper.createFrame(-1, 36.0f, 16, z6 ? 16.0f : 96.0f, 24.0f, z6 ? 96.0f : 16.0f, 0.0f));
        this.lastNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda5
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$5(textView, i3, keyEvent);
            }
        });
        if (user != null) {
            this.firstNameField.setText(user.first_name);
            EditTextBoldCursor editTextBoldCursor9 = this.firstNameField;
            editTextBoldCursor9.setSelection(editTextBoldCursor9.length());
            this.lastNameField.setText(user.last_name);
            this.avatarDrawable.setInfo(user);
            this.avatarImage.setImage(ImageLocation.getForUser(user, 1), "50_50", this.avatarDrawable, (Object) null);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        this.imageUpdater.openMenu(this.avatar != null, new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1();
            }
        }, new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$createView$2(dialogInterface);
            }
        });
        this.cameraDrawable.setCurrentFrame(0);
        this.cameraDrawable.setCustomEndFrame(43);
        this.avatarEditor.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1() {
        this.avatar = null;
        this.avatarBig = null;
        showAvatarProgress(false, true);
        this.avatarImage.setImage((ImageLocation) null, (String) null, this.avatarDrawable, (Object) null);
        this.avatarEditor.setAnimation(this.cameraDrawable);
        this.cameraDrawable.setCurrentFrame(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(DialogInterface dialogInterface) {
        this.cameraDrawable.setCustomEndFrame(86);
        this.avatarEditor.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$4(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.lastNameField.requestFocus();
        EditTextBoldCursor editTextBoldCursor = this.lastNameField;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$5(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.doneButton.performClick();
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (MessagesController.getGlobalMainSettings().getBoolean("view_animations", true)) {
            return;
        }
        this.firstNameField.requestFocus();
        AndroidUtilities.showKeyboard(this.firstNameField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveName() {
        String str;
        final TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
        if (currentUser == null || this.lastNameField.getText() == null || this.firstNameField.getText() == null) {
            return;
        }
        final String strTrim = this.firstNameField.getText().toString().trim();
        final String strTrim2 = this.lastNameField.getText().toString().trim();
        String str2 = currentUser.first_name;
        if (str2 == null || !str2.equals(strTrim) || (str = currentUser.last_name) == null || !str.equals(strTrim2)) {
            final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
            final TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile = new TLRPC$TL_account_updateProfile();
            tLRPC$TL_account_updateProfile.flags = 3;
            tLRPC$TL_account_updateProfile.first_name = strTrim;
            tLRPC$TL_account_updateProfile.last_name = strTrim2;
            final int iUpdateUserProfileName = DialogsProxy.getInstance(this.currentAccount).updateUserProfileName(tLRPC$TL_account_updateProfile, new RequestDelegate() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda13
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveName$8(alertDialog, currentUser, strTrim, strTrim2, tLRPC$TL_account_updateProfile, tLObject, tLRPC$TL_error);
                }
            });
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$saveName$9(iUpdateUserProfileName, dialogInterface);
                }
            });
            alertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$8(final AlertDialog alertDialog, final TLRPC$User tLRPC$User, final String str, final String str2, final TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$6(alertDialog, tLRPC$User, str, str2, tLRPC$TL_account_updateProfile);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveName$7(alertDialog, tLRPC$TL_error, tLRPC$TL_account_updateProfile);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$6(AlertDialog alertDialog, TLRPC$User tLRPC$User, String str, String str2, TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        tLRPC$User.first_name = str;
        tLRPC$User.last_name = str2;
        TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(Integer.valueOf(UserConfig.getInstance(this.currentAccount).getClientUserId()));
        if (user != null) {
            user.first_name = tLRPC$TL_account_updateProfile.first_name;
            user.last_name = tLRPC$TL_account_updateProfile.last_name;
        }
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.updateInterfaces, 1);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$7(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_updateProfile tLRPC$TL_account_updateProfile) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_updateProfile, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveName$9(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onTransitionAnimationEnd$10();
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTransitionAnimationEnd$10() {
        EditTextBoldCursor editTextBoldCursor = this.firstNameField;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.firstNameField);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        EditTextBoldCursor editTextBoldCursor = this.firstNameField;
        int i = ThemeDescription.FLAG_TEXTCOLOR;
        int i2 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i, null, null, null, null, i2));
        EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
        int i3 = ThemeDescription.FLAG_HINTTEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteHintText;
        arrayList.add(new ThemeDescription(editTextBoldCursor2, i3, null, null, null, null, i4));
        EditTextBoldCursor editTextBoldCursor3 = this.firstNameField;
        int i5 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i6 = Theme.key_windowBackgroundWhiteInputField;
        arrayList.add(new ThemeDescription(editTextBoldCursor3, i5, null, null, null, null, i6));
        EditTextBoldCursor editTextBoldCursor4 = this.firstNameField;
        int i7 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i8 = Theme.key_windowBackgroundWhiteInputFieldActivated;
        arrayList.add(new ThemeDescription(editTextBoldCursor4, i7, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(this.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i8));
        return arrayList;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        ImageUpdater imageUpdater = this.imageUpdater;
        if (imageUpdater != null) {
            imageUpdater.clear();
        }
        BackupImageView backupImageView = this.avatarImage;
        if (backupImageView != null) {
            backupImageView.setImageDrawable(null);
        }
    }

    @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
    public void didUploadPhoto(final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputFile tLRPC$InputFile2, final TLRPC$InputFile tLRPC$InputFile3, final double d, final String str, final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$15(tLRPC$InputFile, tLRPC$InputFile2, tLRPC$InputFile3, d, str, tLRPC$PhotoSize2, tLRPC$PhotoSize);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$15(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
        if ((tLRPC$InputFile != null && tLRPC$InputFile2 != null) || tLRPC$InputFile3 != null) {
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
            if (tLRPC$InputFile != null && tLRPC$InputFile2 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
                tLRPC$TL_photos_uploadProfilePhoto.smallFile = tLRPC$InputFile2;
                tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
            }
            if (tLRPC$InputFile3 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.video = tLRPC$InputFile3;
                int i = tLRPC$TL_photos_uploadProfilePhoto.flags | 2;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i;
                tLRPC$TL_photos_uploadProfilePhoto.video_start_ts = d;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i | 4;
            }
            getAccountInstance().getFileProxy().sendUploadPhotoReq(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda12
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didUploadPhoto$14(str, tLObject, tLRPC$TL_error);
                }
            });
            showAvatarProgress(false, true);
        } else {
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
            this.avatar = tLRPC$FileLocation;
            this.avatarBig = tLRPC$PhotoSize2.location;
            this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, (Object) null);
            showAvatarProgress(true, false);
        }
        this.actionBar.createMenu().requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$14(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$didUploadPhoto$13(tLRPC$TL_error, tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didUploadPhoto$13(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
        if (tLRPC$TL_error == null) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(getUserConfig().getClientUserId()));
            if (user == null) {
                user = getUserConfig().getCurrentUser();
                if (user == null) {
                    return;
                } else {
                    getMessagesController().putUser(user, false);
                }
            } else {
                getUserConfig().setCurrentUser(user);
            }
            TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
            ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$TL_photos_photo.photo.sizes;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, MediaController.MAX_WIDTH_HEIGHT_SIZE);
            TLRPC$VideoSize tLRPC$VideoSize = tLRPC$TL_photos_photo.photo.video_sizes.isEmpty() ? null : tLRPC$TL_photos_photo.photo.video_sizes.get(0);
            TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
            user.photo = tLRPC$TL_userProfilePhoto;
            tLRPC$TL_userProfilePhoto.photo_id = tLRPC$TL_photos_photo.photo.id;
            if (closestPhotoSizeWithSize != null) {
                tLRPC$TL_userProfilePhoto.photo_small = closestPhotoSizeWithSize.location;
            }
            if (closestPhotoSizeWithSize2 != null) {
                tLRPC$TL_userProfilePhoto.photo_big = closestPhotoSizeWithSize2.location;
            }
            if (closestPhotoSizeWithSize != null && this.avatar != null) {
                FileLoader.getPathToAttach(this.avatar, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize, true));
                ImageLoader.getInstance().replaceImageInCache(this.avatar.volume_id + "_" + this.avatar.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForUserOrChat(user, 1), false);
            }
            if (closestPhotoSizeWithSize2 != null && this.avatarBig != null) {
                FileLoader.getPathToAttach(this.avatarBig, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
            }
            if (tLRPC$VideoSize != null && str != null) {
                new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
            }
            getMessagesStorage().clearUserPhotos(user.id);
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            arrayList2.add(user);
            getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
            this.avatarImage.setImage(ImageLocation.getForUser(user, 1), "50_50", this.avatarDrawable, (Object) null);
        }
        this.avatar = null;
        this.avatarBig = null;
        getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
        getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
        getUserConfig().saveConfig(true);
    }

    private void showAvatarProgress(final boolean z, boolean z2) {
        if (this.avatarEditor == null) {
            return;
        }
        AnimatorSet animatorSet = this.avatarAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.avatarAnimation = null;
        }
        if (z2) {
            this.avatarAnimation = new AnimatorSet();
            if (z) {
                this.avatarProgressView.setVisibility(0);
                this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.avatarEditor.setVisibility(0);
                this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
            }
            this.avatarAnimation.setDuration(180L);
            this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ChangeNameAndAvatarActivity.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ChangeNameAndAvatarActivity.this.avatarAnimation == null || ChangeNameAndAvatarActivity.this.avatarEditor == null) {
                        return;
                    }
                    if (z) {
                        ChangeNameAndAvatarActivity.this.avatarEditor.setVisibility(4);
                    } else {
                        ChangeNameAndAvatarActivity.this.avatarProgressView.setVisibility(4);
                    }
                    ChangeNameAndAvatarActivity.this.avatarAnimation = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    ChangeNameAndAvatarActivity.this.avatarAnimation = null;
                }
            });
            this.avatarAnimation.start();
            return;
        }
        if (z) {
            this.avatarEditor.setAlpha(1.0f);
            this.avatarEditor.setVisibility(4);
            this.avatarProgressView.setAlpha(1.0f);
            this.avatarProgressView.setVisibility(0);
            return;
        }
        this.avatarEditor.setAlpha(1.0f);
        this.avatarEditor.setVisibility(0);
        this.avatarProgressView.setAlpha(0.0f);
        this.avatarProgressView.setVisibility(4);
    }
}
