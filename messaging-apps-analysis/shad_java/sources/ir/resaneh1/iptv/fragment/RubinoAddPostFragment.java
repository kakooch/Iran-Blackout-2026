package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import androidMessenger.utilites.MessageConverter;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.MetaDataObject;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIInstaUserInfoRow;
import ir.resaneh1.iptv.UIView.UIRubinoAddMultiMediaRow;
import ir.resaneh1.iptv.UIView.UIRubinoAddPost;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.SendingMediaInfo;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenters.PlayerPresenter;
import ir.resaneh1.iptv.toolbar.ToolbarImageView;
import ir.resaneh1.iptv.toolbar.ToolbarTextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.PhotoAlbumPickerActivity;

/* loaded from: classes3.dex */
public class RubinoAddPostFragment extends PresenterFragment {
    private EditText captionEditText;
    ToolbarImageView toolbarImageViewCheck;
    private ToolbarImageView toolbarImageViewClose;
    ToolbarTextView toolbarTextViewSend;
    UIRubinoAddPost uiInstaAddPost;
    UIRubinoAddMultiMediaRow uiRubinoAddMultiMediaRow;
    public ArrayList<SendingMediaInfo> sendingMediaInfos = new ArrayList<>();
    View.OnClickListener onAddClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RubinoAddPostFragment.this.openMediaChooser();
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.swipeBackEnabled = false;
        this.progressBar.setVisibility(4);
        setToolbar();
        makeLayout();
    }

    public void makeLayout() {
        this.linearLayout.addView(View.inflate(this.mContext, R.layout.row_space, null));
        UIRubinoAddPost uIRubinoAddPost = new UIRubinoAddPost();
        this.uiInstaAddPost = uIRubinoAddPost;
        uIRubinoAddPost.createView(ApplicationLoader.applicationActivity);
        this.uiInstaAddPost.frameLayout.setOnClickListener(this.onAddClick);
        this.uiInstaAddPost.multiMediaView.setVisibility(8);
        this.uiInstaAddPost.multiMediaView.setOnClickListener(this.onAddClick);
        this.linearLayout.addView(this.uiInstaAddPost.view);
        UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = new UIRubinoAddMultiMediaRow();
        this.uiRubinoAddMultiMediaRow = uIRubinoAddMultiMediaRow;
        uIRubinoAddMultiMediaRow.createView((Activity) this.mContext, this.onAddClick, this);
        this.uiRubinoAddMultiMediaRow.view.setVisibility(8);
        this.linearLayout.addView(this.uiRubinoAddMultiMediaRow.view);
        this.linearLayout.addView(View.inflate(this.mContext, R.layout.row_space, null));
        this.linearLayout.addView(View.inflate(this.mContext, R.layout.row_space, null));
        UIInstaUserInfoRow uIInstaUserInfoRow = new UIInstaUserInfoRow();
        uIInstaUserInfoRow.createView((Activity) this.mContext, "متن", BuildConfig.FLAVOR, false, null);
        EditText editText = uIInstaUserInfoRow.editText;
        this.captionEditText = editText;
        this.captionEditText.setFilters(new InputFilter[]{InputFilterHelper.getFilter(2200, 64, editText)[0], new InputFilter() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment.1
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence == null || TextUtils.indexOf(charSequence, '#') == -1 || spanned.length() - spanned.toString().replace("#", BuildConfig.FLAVOR).length() < 15) {
                    return null;
                }
                if (RubinoAddPostFragment.this.captionEditText != null) {
                    AndroidUtilities.shakeView(RubinoAddPostFragment.this.captionEditText, 2.0f, 0);
                }
                return BuildConfig.FLAVOR;
            }
        }});
        this.captionEditText.setMaxLines(10);
        this.captionEditText.setSingleLine(false);
        this.captionEditText.setImeOptions(1073741824);
        this.linearLayout.addView(uIInstaUserInfoRow.view);
    }

    public void setMultiView() {
        this.uiInstaAddPost.view.setVisibility(8);
        this.uiRubinoAddMultiMediaRow.view.setVisibility(0);
    }

    void onPhotoSelected(SendMessagesHelper.SendingMediaInfo sendingMediaInfo) {
        String str = sendingMediaInfo.caption;
        if (str != null && !str.isEmpty()) {
            this.captionEditText.setText(sendingMediaInfo.caption);
        }
        fillImageAttribute(sendingMediaInfo);
        adjustSize(sendingMediaInfo);
    }

    public void refreshLayout() {
        long j;
        long j2;
        this.uiInstaAddPost.refreshLayout();
        if (this.sendingMediaInfos.size() == 1) {
            ArrayList<SendingMediaInfo> arrayList = this.sendingMediaInfos;
            SendingMediaInfo sendingMediaInfo = arrayList.get(arrayList.size() - 1);
            if (sendingMediaInfo.isVideo) {
                VideoEditedInfo videoEditedInfo = sendingMediaInfo.videoEditedInfo;
                if (videoEditedInfo != null) {
                    j = videoEditedInfo.startTime / 1000;
                    j2 = videoEditedInfo.endTime / 1000;
                } else {
                    j = -1;
                    j2 = -1;
                }
                PlayerBaseFragment.instaIsMute = false;
                this.uiInstaAddPost.showVideo(sendingMediaInfo.path, (sendingMediaInfo.width * 1.0f) / sendingMediaInfo.height, j, j2);
            } else {
                this.uiInstaAddPost.showImage(sendingMediaInfo.path, sendingMediaInfo.height, sendingMediaInfo.width);
            }
        }
        this.uiRubinoAddMultiMediaRow.refreshList(this.sendingMediaInfos);
        if (this.sendingMediaInfos.size() == 0 || this.sendingMediaInfos.size() == 1) {
            this.uiRubinoAddMultiMediaRow.view.setVisibility(8);
            this.uiInstaAddPost.view.setVisibility(0);
            if (this.sendingMediaInfos.size() == 0) {
                this.uiInstaAddPost.multiMediaView.setVisibility(4);
                return;
            } else {
                this.uiInstaAddPost.multiMediaView.setVisibility(0);
                return;
            }
        }
        if (this.sendingMediaInfos.size() >= 2) {
            if (this.uiRubinoAddMultiMediaRow.view.getVisibility() == 8 || this.uiRubinoAddMultiMediaRow.view.getVisibility() == 4) {
                setMultiView();
            }
        }
    }

    void openMediaChooser() {
        if (Build.VERSION.SDK_INT >= 23 && ApplicationLoader.applicationActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            getParentActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
            return;
        }
        PlayerPresenter.destroyPlayer(getContext());
        PhotoAlbumPickerActivity photoAlbumPickerActivity = new PhotoAlbumPickerActivity(PhotoAlbumPickerActivity.SELECT_TYPE_ALL, true, true, null);
        photoAlbumPickerActivity.setMaxSelectedPhotos(10 - this.sendingMediaInfos.size(), true);
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment.3
            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
            }

            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z, int i) throws Throwable {
                Iterator<SendMessagesHelper.SendingMediaInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    SendMessagesHelper.SendingMediaInfo next = it.next();
                    RubinoAddPostFragment rubinoAddPostFragment = RubinoAddPostFragment.this;
                    rubinoAddPostFragment.sendingMediaInfos.add(rubinoAddPostFragment.convertSendingMediaInfo(next));
                    if (next.isVideo) {
                        RubinoAddPostFragment.this.onVideoSelected(next);
                    } else {
                        RubinoAddPostFragment.this.onPhotoSelected(next);
                    }
                    RubinoAddPostFragment.this.toolbarImageViewCheck.view.setVisibility(0);
                    RubinoAddPostFragment.this.toolbarTextViewSend.view.setVisibility(0);
                }
                RubinoAddPostFragment.this.refreshLayout();
            }
        });
        presentFragment(photoAlbumPickerActivity);
    }

    public SendingMediaInfo convertSendingMediaInfo(SendMessagesHelper.SendingMediaInfo sendingMediaInfo) {
        SendingMediaInfo sendingMediaInfo2 = new SendingMediaInfo();
        sendingMediaInfo2.uri = sendingMediaInfo.uri;
        sendingMediaInfo2.path = sendingMediaInfo.path;
        sendingMediaInfo2.videoEditedInfo = sendingMediaInfo.videoEditedInfo;
        sendingMediaInfo2.caption = sendingMediaInfo.caption;
        ArrayList<TLRPC$MessageEntity> arrayList = sendingMediaInfo.entities;
        if (arrayList != null) {
            MetaDataObject metaDataObjectConvertAllEntitiesToMetaData = MessageConverter.convertAllEntitiesToMetaData(arrayList);
            sendingMediaInfo2.entities = metaDataObjectConvertAllEntitiesToMetaData != null ? metaDataObjectConvertAllEntitiesToMetaData.meta_data_parts : null;
        }
        sendingMediaInfo2.isVideo = sendingMediaInfo.isVideo;
        sendingMediaInfo2.width = sendingMediaInfo.width;
        sendingMediaInfo2.height = sendingMediaInfo.height;
        sendingMediaInfo2.duration = sendingMediaInfo.duration;
        sendingMediaInfo2.thumbPath = sendingMediaInfo.thumbPath;
        sendingMediaInfo2.orginalPath = sendingMediaInfo.orginalPath;
        sendingMediaInfo2.rnd = sendingMediaInfo.rnd;
        return sendingMediaInfo2;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        BaseFragment.destroyPlayeronfragmentDestroy = false;
        return super.onFragmentCreate();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        BaseFragment.destroyPlayeronfragmentDestroy = true;
        super.onFragmentDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoSelected(SendMessagesHelper.SendingMediaInfo sendingMediaInfo) throws Throwable {
        String str = sendingMediaInfo.caption;
        if (str != null && !str.isEmpty()) {
            this.captionEditText.setText(sendingMediaInfo.caption);
        }
        fillVideoAttribute(sendingMediaInfo);
        adjustSize(sendingMediaInfo);
    }

    public void fillImageAttribute(SendMessagesHelper.SendingMediaInfo sendingMediaInfo) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(sendingMediaInfo.path, options);
        sendingMediaInfo.height = options.outHeight;
        sendingMediaInfo.width = options.outWidth;
        try {
            ExifInterface exifInterface = new ExifInterface(sendingMediaInfo.path);
            int attributeInt = exifInterface.getAttributeInt("ImageWidth", sendingMediaInfo.width);
            if (attributeInt > 0) {
                sendingMediaInfo.width = attributeInt;
            }
            int attributeInt2 = exifInterface.getAttributeInt("ImageLength", sendingMediaInfo.height);
            if (attributeInt2 > 0) {
                sendingMediaInfo.height = attributeInt2;
            }
            int attributeInt3 = exifInterface.getAttributeInt("Orientation", 0);
            if (attributeInt3 == 6 || attributeInt3 == 8) {
                int i = sendingMediaInfo.width;
                sendingMediaInfo.width = sendingMediaInfo.height;
                sendingMediaInfo.height = i;
            }
            if (sendingMediaInfo.width <= 0 || sendingMediaInfo.height <= 0) {
                sendingMediaInfo.width = MediaController.MAX_WIDTH_HEIGHT_SIZE;
                sendingMediaInfo.height = MediaController.MAX_WIDTH_HEIGHT_SIZE;
            }
        } catch (IOException unused) {
        }
    }

    private void adjustSize(SendMessagesHelper.SendingMediaInfo sendingMediaInfo) {
        int i = sendingMediaInfo.height;
        int i2 = sendingMediaInfo.width;
        if ((i * 1.0f) / i2 < 0.5f) {
            sendingMediaInfo.height = (int) (i2 / 2.0f);
        } else if ((i * 1.0f) / i2 > 1.2f) {
            sendingMediaInfo.height = (int) (i2 * 1.2f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fillVideoAttribute(org.rbmain.messenger.SendMessagesHelper.SendingMediaInfo r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.RubinoAddPostFragment.fillVideoAttribute(org.rbmain.messenger.SendMessagesHelper$SendingMediaInfo):void");
    }

    public void uploadPost() {
        if (this.sendingMediaInfos.size() <= 0) {
            return;
        }
        Iterator<SendingMediaInfo> it = this.sendingMediaInfos.iterator();
        while (it.hasNext()) {
            SendingMediaInfo next = it.next();
            if (next.height < 256 || next.width < 256) {
                String string = LocaleController.getString(R.string.Image);
                if (next.isVideo) {
                    string = LocaleController.getString(R.string.Video);
                }
                ToastiLikeSnack.showS(ApplicationLoader.applicationActivity, "طول و عرض " + string + " کوچک تر از حد مجاز است.");
                return;
            }
        }
        Iterator<SendingMediaInfo> it2 = this.sendingMediaInfos.iterator();
        while (it2.hasNext()) {
            SendingMediaInfo next2 = it2.next();
            next2.orginalPath = next2.path;
            next2.caption = ((Object) this.captionEditText.getText()) + BuildConfig.FLAVOR;
        }
        String str = ((Object) this.captionEditText.getText()) + BuildConfig.FLAVOR;
        AndroidUtilities.hideKeyboard(this.captionEditText);
        if (!this.sendingMediaInfos.get(0).isVideo) {
            ir.appp.messenger.SendMessagesHelper.getInstance(this.currentAccount).prepareSendPhotoPostRubino(this.sendingMediaInfos, str, AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        } else {
            ir.appp.messenger.SendMessagesHelper.getInstance(this.currentAccount).prepareSendVideoRubino(this.sendingMediaInfos, str, AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id);
        }
        getNotificationCenter().postNotificationName(NotificationCenter.myInstaRefreshSendingView, new Object[0]);
        new MainClickHandler().openRubinoTab();
    }

    private void setToolbar() {
        this.toolbarMaker.clearToolbar();
        this.toolbarMaker.toolbar.setBackgroundColor(this.mContext.getResources().getColor(R.color.grey_100));
        ToolbarTextView toolbarTextView = new ToolbarTextView();
        this.toolbarTextViewSend = toolbarTextView;
        toolbarTextView.createView((Activity) this.mContext, LocaleController.getString(R.string.rubinoActionSend), R.color.grey_700);
        this.toolbarTextViewSend.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setToolbar$0(view);
            }
        });
        ToolbarTextView toolbarTextView2 = new ToolbarTextView();
        toolbarTextView2.createView((Activity) this.mContext, LocaleController.getString(R.string.add_post), R.color.grey_700);
        ToolbarImageView toolbarImageView = new ToolbarImageView();
        this.toolbarImageViewCheck = toolbarImageView;
        toolbarImageView.createView((Activity) this.mContext, R.drawable.ic_check_grey);
        this.toolbarImageViewCheck.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setToolbar$1(view);
            }
        });
        ToolbarImageView toolbarImageView2 = new ToolbarImageView();
        this.toolbarImageViewClose = toolbarImageView2;
        toolbarImageView2.createView((Activity) this.mContext, R.drawable.ic_close_grey_700);
        this.toolbarImageViewClose.view.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.RubinoAddPostFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RubinoAddPostFragment.lambda$setToolbar$2(view);
            }
        });
        this.toolbarImageViewCheck.view.setVisibility(8);
        this.toolbarTextViewSend.view.setVisibility(8);
        this.toolbarMaker.addToCenter(toolbarTextView2.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarImageViewCheck.view);
        this.toolbarMaker.addViewToRightLayout(this.toolbarTextViewSend.view);
        this.toolbarMaker.addViewToLeftLayout(this.toolbarImageViewClose.view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setToolbar$0(View view) {
        uploadPost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setToolbar$1(View view) {
        uploadPost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setToolbar$2(View view) {
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = this.uiRubinoAddMultiMediaRow;
        if (uIRubinoAddMultiMediaRow != null) {
            uIRubinoAddMultiMediaRow.isPausePresenterFragment = true;
        }
    }

    public boolean isMulti() {
        return this.uiRubinoAddMultiMediaRow.view.getVisibility() == 0;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        UIRubinoAddMultiMediaRow uIRubinoAddMultiMediaRow = this.uiRubinoAddMultiMediaRow;
        if (uIRubinoAddMultiMediaRow != null) {
            uIRubinoAddMultiMediaRow.isPausePresenterFragment = false;
        }
        if (isMulti()) {
            this.uiRubinoAddMultiMediaRow.playVideoInListIfNeeded();
        } else {
            refreshLayout();
        }
    }
}
