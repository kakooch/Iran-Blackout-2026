package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import androidMessenger.utilites.AppFavorUtils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.utilites.Objects;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIInstaUserInfoHeader;
import ir.resaneh1.iptv.UIInstaUserInfoRow;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.insta.InstaDraftManager;
import ir.resaneh1.iptv.messangerUploaderV2.MessengerDraftManagerV2;
import ir.resaneh1.iptv.model.InstaGetProfileInfoOutput;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.InstaUpdateProfileInput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarProgressBar;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ChangeUsernameActivity;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.RubinoImageUpdater;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class InstaEditProfileFragment extends PresenterFragment implements NotificationCenter.NotificationCenterDelegate {
    private TLRPC$FileLocation avatar;
    private TLRPC$FileLocation avatarBig;
    RubinoImageUpdater imageUpdater;
    public boolean isDefault;
    private InstaProfileObject profileObject;
    private UIInstaUserInfoRow rowShareLink;
    private SendingMediaInfo sendingMediaInfoProfilePhoto;
    private ToolbarImageView toolbarImageViewCheck;
    private ToolbarProgressBar toolbarProgressbar;
    ToolbarTextView toolbarTextView;
    private UIInstaUserInfoRow uiBioRow;
    private UIInstaUserInfoRow uiEmailRow;
    private UIInstaUserInfoRow uiFamilyNameRow;
    private UIInstaUserInfoHeader uiInstaUserInfoHeader;
    private UIInstaUserInfoRow uiNameRow;
    private UIInstaUserInfoRow uiPhoneRow;
    private UIInstaUserInfoRow uiUserNameRow;
    private UIInstaUserInfoRow uiWebsiteRow;
    private static final Pattern telPattern = Pattern.compile("\\d+$");
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 2);
    public boolean isFirstBack = true;
    private int rndSendingProfilePhoto = 0;
    private boolean isPhotoChanged = false;
    View.OnClickListener onUsernmaeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseFragment setUserNameFragment;
            if (InstaEditProfileFragment.this.isDefault) {
                setUserNameFragment = new ChangeUsernameActivity();
            } else {
                setUserNameFragment = new SetUserNameFragment(InstaEditProfileFragment.this.profileObject.username);
            }
            InstaEditProfileFragment.this.presentFragment(setUserNameFragment);
        }
    };
    View.OnClickListener onShareLinkClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.10
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (InstaEditProfileFragment.this.isDefault) {
                new MainClickHandler().onTextShare("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + InstaEditProfileFragment.this.getAppPreferences().getMyUsername());
                return;
            }
            new MainClickHandler().onTextShare("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + InstaEditProfileFragment.this.profileObject.username);
        }
    };

    public void callGetDefaultProfileInfo() {
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_header_linear;
    }

    public InstaEditProfileFragment(boolean z) {
        this.isDefault = true;
        this.isDefault = z;
        this.fragmentName = "InstaEditProfileFragment";
    }

    public InstaEditProfileFragment() {
        this.isDefault = true;
        InstaProfileObject instaCurrentProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject();
        this.profileObject = instaCurrentProfileObject;
        boolean zIsDefault = instaCurrentProfileObject.isDefault();
        this.isDefault = zIsDefault;
        this.imageUpdater = new RubinoImageUpdater(this.currentAccount, false, this.profileObject.id, zIsDefault);
        this.fragmentName = "InstaEditProfileFragment";
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        getNotificationCenter().removeObserver(this, NotificationCenter.myInstaUploadProfileDone);
        getNotificationCenter().removeObserver(this, NotificationCenter.myInstaUploadProfileRefreshView);
        getNotificationCenter().removeObserver(this, NotificationCenter.myInstaUploadProfilePhotoProgressView);
        getNotificationCenter().removeObserver(this, NotificationCenter.myMessengerUploadProfileDone);
        getNotificationCenter().removeObserver(this, NotificationCenter.myMessengerUploadProfileRefreshView);
        getNotificationCenter().removeObserver(this, NotificationCenter.myMessengerUploadProfilePhotoProgressView);
        if (this.isDefault) {
            getNotificationCenter().removeObserver(this, NotificationCenter.rubinoProfileUpdated);
        }
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.myInstaUploadProfileDone);
        getNotificationCenter().addObserver(this, NotificationCenter.myInstaUploadProfileRefreshView);
        getNotificationCenter().addObserver(this, NotificationCenter.myInstaUploadProfilePhotoProgressView);
        getNotificationCenter().addObserver(this, NotificationCenter.myMessengerUploadProfileDone);
        getNotificationCenter().addObserver(this, NotificationCenter.myMessengerUploadProfileRefreshView);
        getNotificationCenter().addObserver(this, NotificationCenter.myMessengerUploadProfilePhotoProgressView);
        if (this.isDefault) {
            getNotificationCenter().addObserver(this, NotificationCenter.rubinoProfileUpdated);
        }
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        String str;
        if (i == NotificationCenter.myInstaUploadProfilePhotoProgressView) {
            this.uiInstaUserInfoHeader.progressView.setVisibility(0);
            return;
        }
        if (i == NotificationCenter.myInstaUploadProfileRefreshView) {
            refreshUploadingView();
            return;
        }
        if (i == NotificationCenter.myInstaUploadProfileDone) {
            if (this.sendingMediaInfoProfilePhoto == null || this.isDefault) {
                return;
            }
            this.uiInstaUserInfoHeader.progressView.setVisibility(4);
            return;
        }
        if (i == NotificationCenter.myMessengerUploadProfilePhotoProgressView) {
            this.uiInstaUserInfoHeader.progressView.setVisibility(0);
            return;
        }
        if (i == NotificationCenter.myMessengerUploadProfileRefreshView) {
            refreshUploadingView();
            return;
        }
        if (i == NotificationCenter.myMessengerUploadProfileDone) {
            this.uiInstaUserInfoHeader.progressView.setVisibility(4);
            return;
        }
        if (i == NotificationCenter.rubinoProfileUpdated && this.isDefault) {
            String str2 = (String) objArr[0];
            InstaProfileObject instaProfileObject = this.profileObject;
            if (instaProfileObject == null || (str = instaProfileObject.id) == null || !str.equals(str2)) {
                return;
            }
            RubinoProfileObject rubinoDefaultProfileObject = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoDefaultProfileObject();
            if (!Objects.equals(this.profileObject.name, rubinoDefaultProfileObject.name)) {
                this.profileObject.name = rubinoDefaultProfileObject.name;
                this.uiNameRow.textView.setText(getAppPreferences().getMyFirstname());
                this.uiFamilyNameRow.textView.setText(getAppPreferences().getMyLastname());
            }
            if (!Objects.equals(this.profileObject.username, rubinoDefaultProfileObject.username)) {
                InstaProfileObject instaProfileObject2 = this.profileObject;
                String str3 = rubinoDefaultProfileObject.username;
                instaProfileObject2.username = str3;
                this.uiUserNameRow.textView.setText(str3);
                this.rowShareLink.textView.setText("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + getAppPreferences().getMyUsername());
            }
            if (!Objects.equals(this.profileObject.bio, rubinoDefaultProfileObject.bio)) {
                InstaProfileObject instaProfileObject3 = this.profileObject;
                String str4 = rubinoDefaultProfileObject.bio;
                instaProfileObject3.bio = str4;
                this.uiBioRow.textView.setText(str4);
            }
            if (!Objects.equals(this.profileObject.email, rubinoDefaultProfileObject.email)) {
                InstaProfileObject instaProfileObject4 = this.profileObject;
                String str5 = rubinoDefaultProfileObject.email;
                instaProfileObject4.email = str5;
                this.uiEmailRow.textView.setText(str5);
            }
            if (!Objects.equals(this.profileObject.phone, rubinoDefaultProfileObject.phone)) {
                InstaProfileObject instaProfileObject5 = this.profileObject;
                String str6 = rubinoDefaultProfileObject.phone;
                instaProfileObject5.phone = str6;
                this.uiPhoneRow.textView.setText(str6);
            }
            if (!Objects.equals(this.profileObject.website, rubinoDefaultProfileObject.website)) {
                InstaProfileObject instaProfileObject6 = this.profileObject;
                String str7 = rubinoDefaultProfileObject.website;
                instaProfileObject6.website = str7;
                this.uiWebsiteRow.textView.setText(str7);
            }
            if (Objects.equals(this.profileObject.full_photo_url, rubinoDefaultProfileObject.full_photo_url) && Objects.equals(this.profileObject.full_thumbnail_url, rubinoDefaultProfileObject.full_thumbnail_url)) {
                return;
            }
            InstaProfileObject instaProfileObject7 = this.profileObject;
            String str8 = rubinoDefaultProfileObject.full_photo_url;
            instaProfileObject7.full_photo_url = str8;
            instaProfileObject7.full_thumbnail_url = rubinoDefaultProfileObject.full_thumbnail_url;
            GlideHelper.loadCircle(this.mContext, this.uiInstaUserInfoHeader.imageView, str8);
        }
    }

    void refreshUploadingView() {
        InstaDraftManager.SendingProfilePhoto sendingProfilePhoto = InstaDraftManager.getInstance(this.currentAccount).sendingProfilePhotoMap.get(Integer.valueOf(this.rndSendingProfilePhoto));
        if (sendingProfilePhoto != null && sendingProfilePhoto.hasError) {
            this.uiInstaUserInfoHeader.retryTextView.setVisibility(0);
            this.uiInstaUserInfoHeader.retryDescriptionTextView.setVisibility(0);
            this.uiInstaUserInfoHeader.progressView.setVisibility(4);
            this.uiInstaUserInfoHeader.retryTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    InstaEditProfileFragment.this.uiInstaUserInfoHeader.retryTextView.setVisibility(8);
                    InstaEditProfileFragment.this.uiInstaUserInfoHeader.retryDescriptionTextView.setVisibility(8);
                    InstaEditProfileFragment.this.uiInstaUserInfoHeader.progressView.setVisibility(0);
                }
            });
        }
        MessengerDraftManagerV2.SendingProfilePhoto sendingProfilePhoto2 = MessengerDraftManagerV2.getInstance(this.currentAccount).sendingProfilePhotoMap.get(Integer.valueOf(this.rndSendingProfilePhoto));
        if (sendingProfilePhoto2 == null || !sendingProfilePhoto2.hasError) {
            return;
        }
        this.uiInstaUserInfoHeader.retryTextView.setVisibility(0);
        this.uiInstaUserInfoHeader.retryDescriptionTextView.setVisibility(0);
        this.uiInstaUserInfoHeader.progressView.setVisibility(4);
        this.uiInstaUserInfoHeader.retryTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaEditProfileFragment.this.uiInstaUserInfoHeader.retryTextView.setVisibility(8);
                InstaEditProfileFragment.this.uiInstaUserInfoHeader.retryDescriptionTextView.setVisibility(8);
                InstaEditProfileFragment.this.uiInstaUserInfoHeader.progressView.setVisibility(0);
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        super.findView();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        if (collapsingToolbarLayout != null) {
            collapsingToolbarLayout.setContentScrimResource(R.drawable.transparent);
        }
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.white));
        setToolbar();
        setUserHeaderView();
        setUserInfoView();
        if (this.isDefault) {
            callGetDefaultProfileInfo();
        }
    }

    public void onUserNameChanged(String str) {
        this.uiUserNameRow.textView.setText(str);
        this.uiUserNameRow.isChanged = true;
        if (this.isDefault) {
            this.profileObject.username = str;
            HashSet hashSet = new HashSet();
            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.username);
            getRubinoController().onMyRubinoProfileUpdated(RubinoProfileObject.createFromOldObject(this.profileObject), hashSet);
            this.rowShareLink.textView.setText("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + getAppPreferences().getMyUsername());
            return;
        }
        this.rowShareLink.textView.setText("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + str);
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_100));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextView = toolbarTextView;
        toolbarTextView.createView((Activity) this.mContext, LocaleController.getString(R.string.save), R.color.grey_900);
        this.toolbarTextView.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaEditProfileFragment.this.onEditClick();
            }
        });
        ToolbarProgressBar toolbarProgressBar = new ToolbarProgressBar();
        this.toolbarProgressbar = toolbarProgressBar;
        toolbarProgressBar.createView((Activity) this.mContext);
        this.toolbarProgressbar.view.setVisibility(8);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_check_grey);
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaEditProfileFragment.this.onEditClick();
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_close_grey);
        toolbarImageView2.view.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ApplicationLoader.applicationActivity != null) {
                    ApplicationLoader.applicationActivity.onBackPressed();
                }
            }
        });
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewCheck.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarProgressbar.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarTextView.view);
        this.toolbarMaker.addViewToLeftLayout(toolbarImageView2.view);
    }

    private void setUserHeaderView() {
        UIInstaUserInfoHeader uIInstaUserInfoHeader = new UIInstaUserInfoHeader();
        this.uiInstaUserInfoHeader = uIInstaUserInfoHeader;
        uIInstaUserInfoHeader.createView((Activity) this.mContext);
        GlideHelper.loadCircle(this.mContext, this.uiInstaUserInfoHeader.imageView, this.profileObject.full_thumbnail_url, R.drawable.placeholder_avatar_man);
        this.uiInstaUserInfoHeader.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InstaEditProfileFragment.this.imageUpdater.openMenu(false, null, null);
            }
        });
        this.imageUpdater.setDelegate((RubinoImageUpdater.RubinoImageUpdaterDelegate) new AnonymousClass7());
        this.imageUpdater.parentFragment = this;
        LinearLayout linearLayout = this.headerContainer;
        if (linearLayout != null) {
            linearLayout.addView(this.uiInstaUserInfoHeader.view);
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.InstaEditProfileFragment$7, reason: invalid class name */
    class AnonymousClass7 implements RubinoImageUpdater.RubinoImageUpdaterDelegate {
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

        AnonymousClass7() {
        }

        @Override // org.rbmain.ui.Components.RubinoImageUpdater.RubinoImageUpdaterDelegate
        public void didUploadedRubinoAvatar(String str) {
            InstaEditProfileFragment instaEditProfileFragment = InstaEditProfileFragment.this;
            GlideHelper.loadCircle(instaEditProfileFragment.mContext, instaEditProfileFragment.uiInstaUserInfoHeader.imageView, str);
            InstaEditProfileFragment.this.uiInstaUserInfoHeader.progressView.setVisibility(4);
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didUploadPhoto(final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputFile tLRPC$InputFile2, final TLRPC$InputFile tLRPC$InputFile3, final double d, final String str, final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment$7$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$2(tLRPC$InputFile, tLRPC$InputFile2, tLRPC$InputFile3, d, str, tLRPC$PhotoSize2, tLRPC$PhotoSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$2(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
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
                InstaEditProfileFragment.this.getAccountInstance().getFileProxy().sendUploadPhotoReq(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment$7$$ExternalSyntheticLambda2
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$didUploadPhoto$1(str, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            InstaEditProfileFragment.this.avatar = tLRPC$PhotoSize.location;
            InstaEditProfileFragment.this.avatarBig = tLRPC$PhotoSize2.location;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$1(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment$7$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$0(tLRPC$TL_error, tLObject, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
            if (tLRPC$TL_error == null) {
                TLRPC$User user = InstaEditProfileFragment.this.getMessagesController().getUser(Integer.valueOf(InstaEditProfileFragment.this.getUserConfig().getClientUserId()));
                if (user == null) {
                    user = InstaEditProfileFragment.this.getUserConfig().getCurrentUser();
                    if (user == null) {
                        return;
                    } else {
                        InstaEditProfileFragment.this.getMessagesController().putUser(user, false);
                    }
                } else {
                    InstaEditProfileFragment.this.getUserConfig().setCurrentUser(user);
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
                if (closestPhotoSizeWithSize != null && InstaEditProfileFragment.this.avatar != null) {
                    FileLoader.getPathToAttach(InstaEditProfileFragment.this.avatar, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize, true));
                    ImageLoader.getInstance().replaceImageInCache(InstaEditProfileFragment.this.avatar.volume_id + "_" + InstaEditProfileFragment.this.avatar.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForUserOrChat(user, 1), false);
                }
                if (closestPhotoSizeWithSize2 != null && InstaEditProfileFragment.this.avatarBig != null) {
                    FileLoader.getPathToAttach(InstaEditProfileFragment.this.avatarBig, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
                }
                if (tLRPC$VideoSize != null && str != null) {
                    new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
                }
                InstaEditProfileFragment.this.getMessagesStorage().clearUserPhotos(user.id);
                ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
                arrayList2.add(user);
                InstaEditProfileFragment.this.getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
            }
            InstaEditProfileFragment.this.getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
            InstaEditProfileFragment.this.getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
            InstaEditProfileFragment.this.getUserConfig().saveConfig(true);
        }

        @Override // org.rbmain.ui.Components.RubinoImageUpdater.RubinoImageUpdaterDelegate
        public void didStartUploadRubinoAvatar() {
            InstaEditProfileFragment.this.uiInstaUserInfoHeader.progressView.setVisibility(0);
        }

        @Override // org.rbmain.ui.Components.RubinoImageUpdater.RubinoImageUpdaterDelegate
        public void didFailedUploadPhoto() {
            InstaEditProfileFragment.this.uiInstaUserInfoHeader.progressView.setVisibility(4);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        this.imageUpdater.onActivityResult(i, i2, intent);
    }

    public boolean hasChange() {
        return this.uiUserNameRow.isChanged || this.uiNameRow.isChanged || this.uiFamilyNameRow.isChanged || this.uiBioRow.isChanged || this.uiEmailRow.isChanged || this.uiWebsiteRow.isChanged || this.uiPhoneRow.isChanged || this.isPhotoChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEditClick() {
        this.isFirstBack = false;
        if (hasChange()) {
            if (this.isDefault) {
                if ((this.uiNameRow.editText.getText().toString().trim() + this.uiFamilyNameRow.editText.getText().toString().trim()).trim().isEmpty()) {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.invalidNameAndLastName).toString());
                    return;
                }
            }
            InstaUpdateProfileInput instaUpdateProfileInput = new InstaUpdateProfileInput();
            if (!this.isDefault) {
                instaUpdateProfileInput.profile_id = this.profileObject.id;
            }
            UIInstaUserInfoRow uIInstaUserInfoRow = this.uiUserNameRow;
            if (uIInstaUserInfoRow.isChanged) {
                instaUpdateProfileInput.username = uIInstaUserInfoRow.textView.getText().toString();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow2 = this.uiEmailRow;
            if (uIInstaUserInfoRow2.isChanged) {
                if (uIInstaUserInfoRow2.editText.getText().toString().equals(BuildConfig.FLAVOR) || validate(this.uiEmailRow.text)) {
                    instaUpdateProfileInput.email = this.uiEmailRow.editText.getText().toString();
                } else {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.incorrect_email));
                    return;
                }
            }
            UIInstaUserInfoRow uIInstaUserInfoRow3 = this.uiBioRow;
            if (uIInstaUserInfoRow3.isChanged) {
                instaUpdateProfileInput.bio = uIInstaUserInfoRow3.editText.getText().toString();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow4 = this.uiNameRow;
            boolean z = uIInstaUserInfoRow4.isChanged;
            if (z || this.uiFamilyNameRow.isChanged) {
                if (this.isDefault) {
                    instaUpdateProfileInput.name = (this.uiNameRow.editText.getText().toString().trim() + " " + this.uiFamilyNameRow.editText.getText().toString().trim()).trim();
                } else if (z) {
                    instaUpdateProfileInput.name = uIInstaUserInfoRow4.editText.getText().toString().trim();
                }
                if (instaUpdateProfileInput.name.trim().length() == 0) {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.invalidNameAndLastName).toString());
                    return;
                }
            }
            UIInstaUserInfoRow uIInstaUserInfoRow5 = this.uiWebsiteRow;
            if (uIInstaUserInfoRow5.isChanged) {
                instaUpdateProfileInput.website = uIInstaUserInfoRow5.editText.getText().toString().trim();
            }
            UIInstaUserInfoRow uIInstaUserInfoRow6 = this.uiPhoneRow;
            if (uIInstaUserInfoRow6.isChanged) {
                if (uIInstaUserInfoRow6.editText.getText().toString().equals(BuildConfig.FLAVOR) || isValidPhone(this.uiPhoneRow.editText.getText().toString())) {
                    instaUpdateProfileInput.phone = this.uiPhoneRow.editText.getText().toString().trim();
                } else {
                    ToastiLikeSnack.showL(this.mContext, LocaleController.getString(R.string.phoneError3));
                    return;
                }
            }
            this.toolbarProgressbar.view.setVisibility(0);
            this.toolbarImageViewCheck.view.setVisibility(8);
            ApiRequestMessanger.getInstance(this.currentAccount).instaUpdateProfile(instaUpdateProfileInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.8
                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onResponse(Call call, Object obj) {
                    InstaProfileObject instaProfileObject;
                    InstaEditProfileFragment.this.progressBar.setVisibility(4);
                    InstaEditProfileFragment.this.toolbarProgressbar.view.setVisibility(8);
                    InstaEditProfileFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                    InstaGetProfileInfoOutput instaGetProfileInfoOutput = (InstaGetProfileInfoOutput) obj;
                    if (instaGetProfileInfoOutput != null && (instaProfileObject = instaGetProfileInfoOutput.profile) != null) {
                        InstaEditProfileFragment.this.profileObject = instaProfileObject;
                        HashSet hashSet = new HashSet();
                        if (InstaEditProfileFragment.this.uiNameRow.isChanged || InstaEditProfileFragment.this.uiFamilyNameRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.name);
                        }
                        if (InstaEditProfileFragment.this.uiUserNameRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.username);
                        }
                        if (InstaEditProfileFragment.this.uiBioRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.bio);
                        }
                        if (InstaEditProfileFragment.this.uiEmailRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.email);
                        }
                        if (InstaEditProfileFragment.this.uiPhoneRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.phone);
                        }
                        if (InstaEditProfileFragment.this.uiWebsiteRow.isChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.website);
                        }
                        if (InstaEditProfileFragment.this.isPhotoChanged) {
                            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.avatar);
                        }
                        InstaEditProfileFragment.this.getRubinoController().onMyRubinoProfileUpdated(RubinoProfileObject.createFromOldObject(InstaEditProfileFragment.this.profileObject), hashSet);
                    }
                    InstaEditProfileFragment instaEditProfileFragment = InstaEditProfileFragment.this;
                    if (instaEditProfileFragment.isDefault) {
                        instaEditProfileFragment.callMessangerUpdateProfile(instaEditProfileFragment.uiNameRow.editText.getText().toString().trim(), InstaEditProfileFragment.this.uiFamilyNameRow.editText.getText().toString().trim(), InstaEditProfileFragment.this.uiBioRow.editText.getText().toString().trim());
                    } else if (ApplicationLoader.applicationActivity != null) {
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onFailure(Call call, Throwable th) {
                    InstaEditProfileFragment.this.toolbarProgressbar.view.setVisibility(8);
                    InstaEditProfileFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                    InstaEditProfileFragment.this.progressBar.setVisibility(4);
                    ToastiLikeSnack.showL(InstaEditProfileFragment.this.mContext, LocaleController.getString(R.string.error_on_edit_details));
                }

                @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                public void onError(MessangerOutput messangerOutput) {
                    if (messangerOutput.status == MessangerOutput.EnumStatus.ERROR_ACTION && messangerOutput.status_det == MessangerOutput.EnumStatusDet.USERNAME_NOT_EXIST) {
                        InstaEditProfileFragment instaEditProfileFragment = InstaEditProfileFragment.this;
                        instaEditProfileFragment.callMessangerUpdateProfile(instaEditProfileFragment.uiNameRow.editText.getText().toString().trim(), InstaEditProfileFragment.this.uiFamilyNameRow.editText.getText().toString().trim(), InstaEditProfileFragment.this.uiBioRow.editText.getText().toString().trim());
                    } else {
                        InstaEditProfileFragment.this.progressBar.setVisibility(4);
                        InstaEditProfileFragment.this.toolbarProgressbar.view.setVisibility(8);
                        InstaEditProfileFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                        ToastiLikeSnack.showL(InstaEditProfileFragment.this.mContext, LocaleController.getString(R.string.error_on_edit_details));
                    }
                }
            });
            return;
        }
        if (ApplicationLoader.applicationActivity != null) {
            this.isFirstBack = false;
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    }

    private void setUserInfoView() {
        if (this.linearLayout == null || this.profileObject == null) {
            return;
        }
        UIInstaUserInfoRow uIInstaUserInfoRow = new UIInstaUserInfoRow();
        this.uiUserNameRow = uIInstaUserInfoRow;
        uIInstaUserInfoRow.isEditable = !this.isDefault;
        uIInstaUserInfoRow.createView((Activity) this.mContext, LocaleController.getString(R.string.user_name), BuildConfig.FLAVOR, true, this.onUsernmaeClickListener);
        this.uiUserNameRow.editText.setVisibility(4);
        this.uiUserNameRow.textView.setVisibility(0);
        if (this.isDefault) {
            this.uiUserNameRow.textView.setText(getAppPreferences().getMyUsername());
        } else {
            this.uiUserNameRow.textView.setText(this.profileObject.username);
        }
        if (this.uiUserNameRow.textView.getText().toString().isEmpty()) {
            this.uiUserNameRow.textView.setText(LocaleController.getString(R.string.set_username));
        }
        this.uiUserNameRow.view.setOnClickListener(this.onUsernmaeClickListener);
        UIInstaUserInfoRow uIInstaUserInfoRow2 = new UIInstaUserInfoRow();
        this.rowShareLink = uIInstaUserInfoRow2;
        uIInstaUserInfoRow2.isEditable = false;
        uIInstaUserInfoRow2.createView((Activity) this.mContext, LocaleController.formatString(R.string.RubinoLink, LocaleController.getString(AppFavorUtils.rubinoNameId)).toString(), BuildConfig.FLAVOR, false, this.onShareLinkClick);
        this.rowShareLink.view.setOnClickListener(this.onShareLinkClick);
        this.rowShareLink.editText.setVisibility(4);
        if (this.isDefault) {
            this.rowShareLink.textView.setText("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + getAppPreferences().getMyUsername());
        } else {
            this.rowShareLink.textView.setText("https://" + LocaleController.getString(R.string.appHostDomainPlain) + "/" + this.profileObject.username);
        }
        this.rowShareLink.textView.setVisibility(0);
        this.rowShareLink.textView.setOnClickListener(this.onShareLinkClick);
        this.rowShareLink.textView.setGravity(5);
        UIInstaUserInfoRow uIInstaUserInfoRow3 = new UIInstaUserInfoRow();
        this.uiNameRow = uIInstaUserInfoRow3;
        uIInstaUserInfoRow3.hasVerticalLine = true;
        uIInstaUserInfoRow3.hasHorizontalLine = true;
        if (this.isDefault) {
            uIInstaUserInfoRow3.hasVerticalLine = true;
            uIInstaUserInfoRow3.hasHorizontalLine = true;
            uIInstaUserInfoRow3.createView((Activity) this.mContext, LocaleController.getString("nameHint", R.string.nameHint), getAppPreferences().getMyFirstname(), false, null);
        } else {
            uIInstaUserInfoRow3.hasVerticalLine = false;
            uIInstaUserInfoRow3.hasHorizontalLine = false;
            uIInstaUserInfoRow3.createView((Activity) this.mContext, LocaleController.getString("nameHint", R.string.nameHint), this.profileObject.name, false, null);
        }
        UIInstaUserInfoRow uIInstaUserInfoRow4 = this.uiNameRow;
        uIInstaUserInfoRow4.editText.setFilters(InputFilterHelper.getFilter(30, 1, uIInstaUserInfoRow4.view));
        UIInstaUserInfoRow uIInstaUserInfoRow5 = new UIInstaUserInfoRow();
        this.uiFamilyNameRow = uIInstaUserInfoRow5;
        uIInstaUserInfoRow5.hasVerticalLine = true;
        uIInstaUserInfoRow5.createView((Activity) this.mContext, LocaleController.getString("lastNameHint", R.string.lastNameHint), getAppPreferences().getMyLastname(), false, null);
        UIInstaUserInfoRow uIInstaUserInfoRow6 = this.uiFamilyNameRow;
        uIInstaUserInfoRow6.editText.setFilters(InputFilterHelper.getFilter(50, 1, uIInstaUserInfoRow6.view));
        UIInstaUserInfoRow uIInstaUserInfoRow7 = new UIInstaUserInfoRow();
        this.uiBioRow = uIInstaUserInfoRow7;
        if (this.isDefault) {
            uIInstaUserInfoRow7.createView((Activity) this.mContext, LocaleController.getString("UserBio", R.string.UserBio), getAppPreferences().getMyBio(), false, null);
        } else {
            uIInstaUserInfoRow7.createView((Activity) this.mContext, LocaleController.getString("UserBio", R.string.UserBio), this.profileObject.bio, false, null);
        }
        this.uiBioRow.editText.setMinLines(2);
        UIInstaUserInfoRow uIInstaUserInfoRow8 = this.uiBioRow;
        uIInstaUserInfoRow8.editText.setFilters(InputFilterHelper.getFilter(ImageReceiver.DEFAULT_CROSSFADE_DURATION, 15, uIInstaUserInfoRow8.view));
        this.uiBioRow.editText.setMaxLines(15);
        this.uiBioRow.editText.setSingleLine(false);
        this.uiBioRow.editText.setImeOptions(1073741824);
        UIInstaUserInfoRow uIInstaUserInfoRow9 = new UIInstaUserInfoRow();
        this.uiEmailRow = uIInstaUserInfoRow9;
        if (this.isDefault) {
            uIInstaUserInfoRow9.createView((Activity) this.mContext, LocaleController.getString("rubinoEmail", R.string.rubinoEmail), this.profileObject.email, false, null);
        } else {
            uIInstaUserInfoRow9.createView((Activity) this.mContext, LocaleController.getString("rubinoEmail", R.string.rubinoEmail), this.profileObject.email, false, null);
        }
        UIInstaUserInfoRow uIInstaUserInfoRow10 = new UIInstaUserInfoRow();
        this.uiPhoneRow = uIInstaUserInfoRow10;
        uIInstaUserInfoRow10.createView((Activity) this.mContext, LocaleController.getString("rubinoPhone", R.string.rubinoPhone), BuildConfig.FLAVOR, false, null);
        if (!this.isDefault && this.profileObject.phone != null) {
            this.uiPhoneRow.createView((Activity) this.mContext, LocaleController.getString("rubinoPhone", R.string.rubinoPhone), this.profileObject.phone, false, null);
        }
        UIInstaUserInfoRow uIInstaUserInfoRow11 = new UIInstaUserInfoRow();
        this.uiWebsiteRow = uIInstaUserInfoRow11;
        uIInstaUserInfoRow11.createView((Activity) this.mContext, LocaleController.getString("rubinoWebsite", R.string.rubinoWebsite), BuildConfig.FLAVOR, false, null);
        if (!this.isDefault && this.profileObject.website != null) {
            this.uiWebsiteRow.createView((Activity) this.mContext, LocaleController.getString("rubinoWebsite", R.string.rubinoWebsite), this.profileObject.website, false, null);
        }
        View viewInflate = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate2 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate3 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate4 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate5 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate6 = View.inflate(this.mContext, R.layout.row_space, null);
        View viewInflate7 = View.inflate(this.mContext, R.layout.row_space, null);
        this.linearLayout.addView(viewInflate5);
        this.linearLayout.addView(this.uiUserNameRow.view);
        this.linearLayout.addView(viewInflate3);
        if (getAppPreferences().getMyUsername() != null && !getAppPreferences().getMyUsername().isEmpty() && AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject() != null && AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id != null && !AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id.isEmpty()) {
            this.linearLayout.addView(this.rowShareLink.view);
            this.linearLayout.addView(viewInflate);
        }
        this.linearLayout.addView(this.uiNameRow.view);
        if (this.isDefault) {
            this.linearLayout.addView(this.uiFamilyNameRow.view);
        }
        this.linearLayout.addView(viewInflate2);
        this.linearLayout.addView(this.uiBioRow.view);
        this.linearLayout.addView(viewInflate7);
        this.linearLayout.addView(this.uiEmailRow.view);
        this.linearLayout.addView(viewInflate4);
        if (this.isDefault) {
            return;
        }
        this.linearLayout.addView(this.uiPhoneRow.view);
        this.linearLayout.addView(viewInflate6);
        this.linearLayout.addView(this.uiWebsiteRow.view);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i != 4 || iArr == null || iArr.length <= 0) {
            return;
        }
        int i2 = iArr[0];
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.isFirstBack && hasChange()) {
            final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, LocaleController.getString(R.string.save_changes));
            threeButtonDialog.button1.setText(LocaleController.getString(R.string.confirm));
            threeButtonDialog.button2.setText(LocaleController.getString(R.string.no));
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    threeButtonDialog.dismiss();
                    InstaEditProfileFragment.this.onEditClick();
                }
            });
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ApplicationLoader.applicationActivity != null) {
                        InstaEditProfileFragment.this.isFirstBack = false;
                        ApplicationLoader.applicationActivity.onBackPressed();
                    }
                    threeButtonDialog.dismiss();
                }
            });
            threeButtonDialog.show();
            return false;
        }
        return super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callMessangerUpdateProfile(String str, String str2, String str3) {
        this.toolbarProgressbar.view.setVisibility(0);
        this.toolbarImageViewCheck.view.setVisibility(8);
        this.toolbarTextView.view.setVisibility(8);
        getCoreMainClass().updateProfile(str, str2, str3, new LoadListener<Integer>() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.13
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NotificationCenter.getInstance(((BaseFragment) InstaEditProfileFragment.this).currentAccount).postNotificationName(NotificationCenter.updateInterfaces, 1);
                        InstaEditProfileFragment.this.progressBar.setVisibility(4);
                        InstaEditProfileFragment.this.toolbarProgressbar.view.setVisibility(8);
                        InstaEditProfileFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                        InstaEditProfileFragment.this.toolbarTextView.view.setVisibility(0);
                        if (ApplicationLoader.applicationActivity != null) {
                            ApplicationLoader.applicationActivity.onBackPressed();
                        }
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.InstaEditProfileFragment.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InstaEditProfileFragment.this.progressBar.setVisibility(4);
                        InstaEditProfileFragment.this.toolbarProgressbar.view.setVisibility(8);
                        InstaEditProfileFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                        InstaEditProfileFragment.this.toolbarTextView.view.setVisibility(0);
                        if (ApplicationLoader.applicationActivity != null) {
                            ApplicationLoader.applicationActivity.onBackPressed();
                        }
                    }
                });
            }
        });
    }

    public static boolean validate(String str) {
        return VALID_EMAIL_ADDRESS_REGEX.matcher(str).find();
    }

    private boolean isValidPhone(String str) {
        String strReplace = NumberUtils.toEnglish(str).replace(" ", BuildConfig.FLAVOR).replace("-", BuildConfig.FLAVOR).replace("+", BuildConfig.FLAVOR);
        if (strReplace.length() >= 15 || strReplace.length() <= 2) {
            return false;
        }
        return telPattern.matcher(strReplace).matches();
    }
}
