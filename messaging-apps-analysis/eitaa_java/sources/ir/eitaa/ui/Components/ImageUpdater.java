package ir.eitaa.ui.Components;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageActionEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaEmpty;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.PhotoAlbumPickerActivity;
import ir.eitaa.ui.PhotoCropActivity;
import ir.eitaa.ui.PhotoPickerActivity;
import ir.eitaa.ui.PhotoViewer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ImageUpdater implements NotificationCenter.NotificationCenterDelegate, PhotoCropActivity.PhotoEditActivityDelegate {
    private TLRPC$PhotoSize bigPhoto;
    private ChatAttachAlert chatAttachAlert;
    private boolean clearAfterUpdate;
    private MessageObject convertingVideo;
    public String currentPicturePath;
    private ImageUpdaterDelegate delegate;
    private String finalPath;
    private boolean forceDarkTheme;
    private boolean openWithFrontfaceCamera;
    public BaseFragment parentFragment;
    private boolean showingFromDialog;
    private TLRPC$PhotoSize smallPhoto;
    private TLRPC$InputFile uploadedPhoto;
    private TLRPC$InputFile uploadedVideo;
    private String uploadingImage;
    private String uploadingVideo;
    private String videoPath;
    private double videoTimestamp;
    private int currentAccount = UserConfig.selectedAccount;
    private File picturePath = null;
    private boolean useAttachMenu = true;
    private boolean searchAvailable = true;
    private boolean uploadAfterSelect = true;
    private ImageReceiver imageReceiver = new ImageReceiver(null);
    private boolean canSelectVideo = false;

    public interface ImageUpdaterDelegate {

        /* renamed from: ir.eitaa.ui.Components.ImageUpdater$ImageUpdaterDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didStartUpload(ImageUpdaterDelegate imageUpdaterDelegate, boolean z) {
            }

            public static String $default$getInitialSearchString(ImageUpdaterDelegate imageUpdaterDelegate) {
                return null;
            }

            public static void $default$onUploadProgressChanged(ImageUpdaterDelegate imageUpdaterDelegate, float f) {
            }
        }

        void didStartUpload(boolean isVideo);

        void didUploadPhoto(TLRPC$InputFile photo, TLRPC$InputFile video, double videoStartTimestamp, String videoPath, TLRPC$PhotoSize bigSize, TLRPC$PhotoSize smallSize);

        String getInitialSearchString();

        void onUploadProgressChanged(float progress);
    }

    public boolean isUploadingImage() {
        return (this.uploadingImage == null && this.uploadingVideo == null && this.convertingVideo == null) ? false : true;
    }

    public void clear() {
        if (this.uploadingImage != null || this.uploadingVideo != null || this.convertingVideo != null) {
            this.clearAfterUpdate = true;
        } else {
            this.parentFragment = null;
            this.delegate = null;
        }
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.dismissInternal();
            this.chatAttachAlert.onDestroy();
        }
    }

    public void setOpenWithFrontfaceCamera(boolean value) {
        this.openWithFrontfaceCamera = value;
    }

    public ImageUpdater(boolean allowVideo) {
    }

    public void setDelegate(ImageUpdaterDelegate imageUpdaterDelegate) {
        this.delegate = imageUpdaterDelegate;
    }

    public void openMenu(boolean hasAvatar, final Runnable onDeleteAvatar, DialogInterface.OnDismissListener onDismiss) {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (this.useAttachMenu) {
            openAttachMenu(onDismiss);
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(this.parentFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("ChoosePhoto", R.string.ChoosePhoto), true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        arrayList.add(LocaleController.getString("ChooseTakePhoto", R.string.ChooseTakePhoto));
        arrayList2.add(Integer.valueOf(R.drawable.menu_camera));
        arrayList3.add(0);
        if (this.canSelectVideo) {
            arrayList.add(LocaleController.getString("ChooseRecordVideo", R.string.ChooseRecordVideo));
            arrayList2.add(Integer.valueOf(R.drawable.msg_video));
            arrayList3.add(4);
        }
        arrayList.add(LocaleController.getString("ChooseFromGallery", R.string.ChooseFromGallery));
        arrayList2.add(Integer.valueOf(R.drawable.profile_photos));
        arrayList3.add(1);
        if (this.searchAvailable) {
            arrayList.add(LocaleController.getString("ChooseFromSearch", R.string.ChooseFromSearch));
            arrayList2.add(Integer.valueOf(R.drawable.menu_search));
            arrayList3.add(2);
        }
        if (hasAvatar) {
            arrayList.add(LocaleController.getString("DeletePhoto", R.string.DeletePhoto));
            arrayList2.add(Integer.valueOf(R.drawable.chats_delete));
            arrayList3.add(3);
        }
        int[] iArr = new int[arrayList2.size()];
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList2.get(i)).intValue();
        }
        builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ImageUpdater$c7eFSpKk6NOOMgV-svTJlXGT0ak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$openMenu$0$ImageUpdater(arrayList3, onDeleteAvatar, dialogInterface, i2);
            }
        });
        BottomSheet bottomSheetCreate = builder.create();
        bottomSheetCreate.setOnHideListener(onDismiss);
        this.parentFragment.showDialog(bottomSheetCreate);
        if (hasAvatar) {
            bottomSheetCreate.setItemColor(arrayList.size() - 1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openMenu$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openMenu$0$ImageUpdater(ArrayList arrayList, Runnable runnable, DialogInterface dialogInterface, int i) {
        int iIntValue = ((Integer) arrayList.get(i)).intValue();
        if (iIntValue == 0) {
            openCamera();
            return;
        }
        if (iIntValue == 1) {
            openGallery();
            return;
        }
        if (iIntValue == 2) {
            openSearch();
        } else if (iIntValue == 3) {
            runnable.run();
        } else if (iIntValue == 4) {
            openVideoCamera();
        }
    }

    public void setSearchAvailable(boolean value) {
        this.searchAvailable = value;
        this.useAttachMenu = value;
    }

    public void setSearchAvailable(boolean value, boolean useAttachMenu) {
        this.useAttachMenu = useAttachMenu;
        this.searchAvailable = value;
    }

    public void setUploadAfterSelect(boolean value) {
        this.uploadAfterSelect = value;
    }

    public void onResume() {
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.onResume();
        }
    }

    public void onPause() {
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert != null) {
            chatAttachAlert.onPause();
        }
    }

    public boolean dismissDialogOnPause(Dialog dialog) {
        return dialog != this.chatAttachAlert;
    }

    public boolean dismissCurrentDialog(Dialog dialog) {
        ChatAttachAlert chatAttachAlert = this.chatAttachAlert;
        if (chatAttachAlert == null || dialog != chatAttachAlert) {
            return false;
        }
        chatAttachAlert.getPhotoLayout().closeCamera(false);
        this.chatAttachAlert.dismissInternal();
        this.chatAttachAlert.getPhotoLayout().hideCamera(true);
        return true;
    }

    public void openSearch() {
        if (this.parentFragment == null) {
            return;
        }
        final HashMap map = new HashMap();
        final ArrayList arrayList = new ArrayList();
        PhotoPickerActivity photoPickerActivity = new PhotoPickerActivity(0, null, map, arrayList, 1, false, null, this.forceDarkTheme);
        photoPickerActivity.setDelegate(new PhotoPickerActivity.PhotoPickerActivityDelegate() { // from class: ir.eitaa.ui.Components.ImageUpdater.1
            private boolean sendPressed;

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void onCaptionChanged(CharSequence caption) {
            }

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public /* synthetic */ void onOpenInPressed() {
                PhotoPickerActivity.PhotoPickerActivityDelegate.CC.$default$onOpenInPressed(this);
            }

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void selectedPhotosChanged() {
            }

            @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
            public void actionButtonPressed(boolean canceled, boolean notify, int scheduleDate) {
                if (map.isEmpty() || ImageUpdater.this.delegate == null || this.sendPressed || canceled) {
                    return;
                }
                this.sendPressed = true;
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    Object obj = map.get(arrayList.get(i));
                    SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                    arrayList2.add(sendingMediaInfo);
                    if (obj instanceof MediaController.SearchImage) {
                        MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                        String str = searchImage.imagePath;
                        if (str != null) {
                            sendingMediaInfo.path = str;
                        } else {
                            sendingMediaInfo.searchImage = searchImage;
                        }
                        sendingMediaInfo.videoEditedInfo = searchImage.editedInfo;
                        sendingMediaInfo.thumbPath = searchImage.thumbPath;
                        CharSequence charSequence = searchImage.caption;
                        sendingMediaInfo.caption = charSequence != null ? charSequence.toString() : null;
                        sendingMediaInfo.entities = searchImage.entities;
                        sendingMediaInfo.masks = searchImage.stickers;
                        sendingMediaInfo.ttl = searchImage.ttl;
                    }
                }
                ImageUpdater.this.didSelectPhotos(arrayList2);
            }
        });
        photoPickerActivity.setMaxSelectedPhotos(1, false);
        photoPickerActivity.setInitialSearchString(this.delegate.getInitialSearchString());
        if (this.showingFromDialog) {
            this.parentFragment.showAsSheet(photoPickerActivity);
        } else {
            this.parentFragment.presentFragment(photoPickerActivity);
        }
    }

    private void openAttachMenu(DialogInterface.OnDismissListener onDismissListener) {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        createChatAttachView();
        this.chatAttachAlert.setOpenWithFrontFaceCamera(this.openWithFrontfaceCamera);
        this.chatAttachAlert.setMaxSelectedPhotos(1, false);
        this.chatAttachAlert.getPhotoLayout().loadGalleryPhotos();
        int i = Build.VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            AndroidUtilities.hideKeyboard(this.parentFragment.getFragmentView().findFocus());
        }
        this.chatAttachAlert.init();
        this.chatAttachAlert.setOnHideListener(onDismissListener);
        this.parentFragment.showDialog(this.chatAttachAlert);
    }

    private void createChatAttachView() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null || this.chatAttachAlert != null) {
            return;
        }
        ChatAttachAlert chatAttachAlert = new ChatAttachAlert(this.parentFragment.getParentActivity(), this.parentFragment, this.forceDarkTheme, this.showingFromDialog);
        this.chatAttachAlert = chatAttachAlert;
        chatAttachAlert.setAvatarPicker(this.canSelectVideo ? 2 : 1, this.searchAvailable);
        this.chatAttachAlert.setDelegate(new ChatAttachAlert.ChatAttachViewDelegate() { // from class: ir.eitaa.ui.Components.ImageUpdater.2
            @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
            public void didSelectBot(TLRPC$User user) {
            }

            @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
            public boolean needEnterComment() {
                return false;
            }

            @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
            public void didPressedButton(int button, boolean arg, boolean notify, int scheduleDate, boolean forceDocument) {
                BaseFragment baseFragment2 = ImageUpdater.this.parentFragment;
                if (baseFragment2 == null || baseFragment2.getParentActivity() == null || ImageUpdater.this.chatAttachAlert == null) {
                    return;
                }
                if (button == 8 || button == 7) {
                    HashMap<Object, Object> selectedPhotos = ImageUpdater.this.chatAttachAlert.getPhotoLayout().getSelectedPhotos();
                    ArrayList<Object> selectedPhotosOrder = ImageUpdater.this.chatAttachAlert.getPhotoLayout().getSelectedPhotosOrder();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < selectedPhotosOrder.size(); i++) {
                        Object obj = selectedPhotos.get(selectedPhotosOrder.get(i));
                        SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                        arrayList.add(sendingMediaInfo);
                        if (obj instanceof MediaController.PhotoEntry) {
                            MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj;
                            String str = photoEntry.imagePath;
                            if (str != null) {
                                sendingMediaInfo.path = str;
                            } else {
                                sendingMediaInfo.path = photoEntry.path;
                            }
                            sendingMediaInfo.thumbPath = photoEntry.thumbPath;
                            sendingMediaInfo.videoEditedInfo = photoEntry.editedInfo;
                            sendingMediaInfo.isVideo = photoEntry.isVideo;
                            CharSequence charSequence = photoEntry.caption;
                            sendingMediaInfo.caption = charSequence != null ? charSequence.toString() : null;
                            sendingMediaInfo.entities = photoEntry.entities;
                            sendingMediaInfo.masks = photoEntry.stickers;
                            sendingMediaInfo.ttl = photoEntry.ttl;
                        } else if (obj instanceof MediaController.SearchImage) {
                            MediaController.SearchImage searchImage = (MediaController.SearchImage) obj;
                            String str2 = searchImage.imagePath;
                            if (str2 != null) {
                                sendingMediaInfo.path = str2;
                            } else {
                                sendingMediaInfo.searchImage = searchImage;
                            }
                            sendingMediaInfo.thumbPath = searchImage.thumbPath;
                            sendingMediaInfo.videoEditedInfo = searchImage.editedInfo;
                            CharSequence charSequence2 = searchImage.caption;
                            sendingMediaInfo.caption = charSequence2 != null ? charSequence2.toString() : null;
                            sendingMediaInfo.entities = searchImage.entities;
                            sendingMediaInfo.masks = searchImage.stickers;
                            sendingMediaInfo.ttl = searchImage.ttl;
                            TLRPC$BotInlineResult tLRPC$BotInlineResult = searchImage.inlineResult;
                            if (tLRPC$BotInlineResult != null && searchImage.type == 1) {
                                sendingMediaInfo.inlineResult = tLRPC$BotInlineResult;
                                sendingMediaInfo.params = searchImage.params;
                            }
                            searchImage.date = (int) (System.currentTimeMillis() / 1000);
                        }
                    }
                    ImageUpdater.this.didSelectPhotos(arrayList);
                    if (button != 8) {
                        ImageUpdater.this.chatAttachAlert.dismiss();
                        return;
                    }
                    return;
                }
                ImageUpdater.this.chatAttachAlert.dismissWithButtonClick(button);
                processSelectedAttach(button);
            }

            @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
            public void onCameraOpened() {
                AndroidUtilities.hideKeyboard(ImageUpdater.this.parentFragment.getFragmentView().findFocus());
            }

            @Override // ir.eitaa.ui.Components.ChatAttachAlert.ChatAttachViewDelegate
            public void doOnIdle(Runnable runnable) {
                runnable.run();
            }

            private void processSelectedAttach(int which) {
                if (which == 0) {
                    ImageUpdater.this.openCamera();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos) {
        MessageObject messageObject;
        Bitmap bitmapLoadBitmap;
        if (photos.isEmpty()) {
            return;
        }
        SendMessagesHelper.SendingMediaInfo sendingMediaInfo = photos.get(0);
        Bitmap bitmapLoadBitmap2 = null;
        if (sendingMediaInfo.isVideo || sendingMediaInfo.videoEditedInfo != null) {
            TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
            tLRPC$TL_message.id = 0;
            tLRPC$TL_message.message = "";
            tLRPC$TL_message.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message.action = new TLRPC$TL_messageActionEmpty();
            tLRPC$TL_message.dialog_id = 0L;
            messageObject = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, false, false);
            messageObject.messageOwner.attachPath = new File(FileLoader.getDirectory(4), SharedConfig.getLastLocalId() + "_avatar.mp4").getAbsolutePath();
            messageObject.videoEditedInfo = sendingMediaInfo.videoEditedInfo;
            bitmapLoadBitmap2 = ImageLoader.loadBitmap(sendingMediaInfo.thumbPath, null, 800.0f, 800.0f, true);
        } else {
            String str = sendingMediaInfo.path;
            if (str != null) {
                bitmapLoadBitmap = ImageLoader.loadBitmap(str, null, 800.0f, 800.0f, true);
            } else {
                MediaController.SearchImage searchImage = sendingMediaInfo.searchImage;
                if (searchImage != null) {
                    TLRPC$Photo tLRPC$Photo = searchImage.photo;
                    if (tLRPC$Photo != null) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, AndroidUtilities.getPhotoSize());
                        if (closestPhotoSizeWithSize != null) {
                            File pathToAttach = FileLoader.getPathToAttach(closestPhotoSizeWithSize, true);
                            this.finalPath = pathToAttach.getAbsolutePath();
                            if (!pathToAttach.exists()) {
                                pathToAttach = FileLoader.getPathToAttach(closestPhotoSizeWithSize, false);
                                if (!pathToAttach.exists()) {
                                    pathToAttach = null;
                                }
                            }
                            if (pathToAttach != null) {
                                bitmapLoadBitmap = ImageLoader.loadBitmap(pathToAttach.getAbsolutePath(), null, 800.0f, 800.0f, true);
                            } else {
                                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoaded);
                                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileLoadFailed);
                                this.uploadingImage = FileLoader.getAttachFileName(closestPhotoSizeWithSize.location);
                                this.imageReceiver.setImage(ImageLocation.getForPhoto(closestPhotoSizeWithSize, sendingMediaInfo.searchImage.photo), null, null, "jpg", null, 1);
                                bitmapLoadBitmap = null;
                            }
                        } else {
                            bitmapLoadBitmap = null;
                        }
                    } else if (searchImage.imageUrl != null) {
                        File file = new File(FileLoader.getDirectory(4), Utilities.MD5(sendingMediaInfo.searchImage.imageUrl) + "." + ImageLoader.getHttpUrlExtension(sendingMediaInfo.searchImage.imageUrl, "jpg"));
                        this.finalPath = file.getAbsolutePath();
                        if (file.exists() && file.length() != 0) {
                            bitmapLoadBitmap = ImageLoader.loadBitmap(file.getAbsolutePath(), null, 800.0f, 800.0f, true);
                        } else {
                            this.uploadingImage = sendingMediaInfo.searchImage.imageUrl;
                            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.httpFileDidLoad);
                            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.httpFileDidFailedLoad);
                            this.imageReceiver.setImage(sendingMediaInfo.searchImage.imageUrl, (String) null, (Drawable) null, "jpg", 1);
                        }
                    }
                }
                messageObject = null;
            }
            messageObject = null;
            bitmapLoadBitmap2 = bitmapLoadBitmap;
        }
        processBitmap(bitmapLoadBitmap2, messageObject);
    }

    public void openCamera() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 20);
                return;
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File fileGeneratePicturePath = AndroidUtilities.generatePicturePath();
            if (fileGeneratePicturePath != null) {
                if (i >= 24) {
                    intent.putExtra("output", FileProvider.getUriForFile(this.parentFragment.getParentActivity(), "ir.eitaa.messenger.provider", fileGeneratePicturePath));
                    intent.addFlags(2);
                    intent.addFlags(1);
                } else {
                    intent.putExtra("output", Uri.fromFile(fileGeneratePicturePath));
                }
                this.currentPicturePath = fileGeneratePicturePath.getAbsolutePath();
            }
            this.parentFragment.startActivityForResult(intent, 13);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void openVideoCamera() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.CAMERA") != 0) {
                this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.CAMERA"}, 19);
                return;
            }
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            File fileGenerateVideoPath = AndroidUtilities.generateVideoPath();
            if (fileGenerateVideoPath != null) {
                if (i >= 24) {
                    intent.putExtra("output", FileProvider.getUriForFile(this.parentFragment.getParentActivity(), "ir.eitaa.messenger.provider", fileGenerateVideoPath));
                    intent.addFlags(2);
                    intent.addFlags(1);
                } else if (i >= 18) {
                    intent.putExtra("output", Uri.fromFile(fileGenerateVideoPath));
                }
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                intent.putExtra("android.intent.extra.durationLimit", 10);
                this.currentPicturePath = fileGenerateVideoPath.getAbsolutePath();
            }
            this.parentFragment.startActivityForResult(intent, 15);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        ChatAttachAlert chatAttachAlert;
        if (requestCode != 17 || (chatAttachAlert = this.chatAttachAlert) == null) {
            return;
        }
        chatAttachAlert.getPhotoLayout().checkCamera(false);
    }

    public void openGallery() {
        BaseFragment baseFragment = this.parentFragment;
        if (baseFragment == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && baseFragment.getParentActivity() != null && this.parentFragment.getParentActivity().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            this.parentFragment.getParentActivity().requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        PhotoAlbumPickerActivity photoAlbumPickerActivity = new PhotoAlbumPickerActivity(this.canSelectVideo ? PhotoAlbumPickerActivity.SELECT_TYPE_AVATAR_VIDEO : PhotoAlbumPickerActivity.SELECT_TYPE_AVATAR, false, false, null);
        photoAlbumPickerActivity.setAllowSearchImages(this.searchAvailable);
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate() { // from class: ir.eitaa.ui.Components.ImageUpdater.3
            @Override // ir.eitaa.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos, boolean notify, int scheduleDate) {
                ImageUpdater.this.didSelectPhotos(photos);
            }

            @Override // ir.eitaa.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
                try {
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    ImageUpdater.this.parentFragment.startActivityForResult(intent, 14);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        this.parentFragment.presentFragment(photoAlbumPickerActivity);
    }

    private void startCrop(final String path, final Uri uri) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ImageUpdater$SiEIu1ypWgAkRVSRHDf_8JPkiSI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startCrop$1$ImageUpdater(path, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$startCrop$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$startCrop$1$ImageUpdater(String str, Uri uri) {
        try {
            LaunchActivity launchActivity = (LaunchActivity) this.parentFragment.getParentActivity();
            if (launchActivity == null) {
                return;
            }
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString("photoPath", str);
            } else if (uri != null) {
                bundle.putParcelable("photoUri", uri);
            }
            PhotoCropActivity photoCropActivity = new PhotoCropActivity(bundle);
            photoCropActivity.setDelegate(this);
            launchActivity.lambda$runLinkRequest$39$LaunchActivity(photoCropActivity);
        } catch (Exception e) {
            FileLog.e(e);
            processBitmap(ImageLoader.loadBitmap(str, uri, 800.0f, 800.0f, true), null);
        }
    }

    public void openPhotoForEdit(String path, String thumb, int orientation, boolean isVideo) throws InterruptedException, Resources.NotFoundException {
        final ArrayList<Object> arrayList = new ArrayList<>();
        MediaController.PhotoEntry photoEntry = new MediaController.PhotoEntry(0, 0, 0L, path, orientation, false, 0, 0, 0L);
        photoEntry.isVideo = isVideo;
        photoEntry.thumbPath = thumb;
        arrayList.add(photoEntry);
        PhotoViewer.getInstance().setParentActivity(this.parentFragment.getParentActivity());
        PhotoViewer.getInstance().openPhotoForSelect(arrayList, 0, 1, false, new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.Components.ImageUpdater.4
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean allowCaption() {
                return false;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean canScrollAway() {
                return false;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
                Bitmap bitmapLoadBitmap;
                MediaController.PhotoEntry photoEntry2 = (MediaController.PhotoEntry) arrayList.get(0);
                String str = photoEntry2.imagePath;
                MessageObject messageObject = null;
                if (str == null && (str = photoEntry2.path) == null) {
                    str = null;
                }
                if (photoEntry2.isVideo || photoEntry2.editedInfo != null) {
                    TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                    tLRPC$TL_message.id = 0;
                    tLRPC$TL_message.message = "";
                    tLRPC$TL_message.media = new TLRPC$TL_messageMediaEmpty();
                    tLRPC$TL_message.action = new TLRPC$TL_messageActionEmpty();
                    tLRPC$TL_message.dialog_id = 0L;
                    MessageObject messageObject2 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, false, false);
                    messageObject2.messageOwner.attachPath = new File(FileLoader.getDirectory(4), SharedConfig.getLastLocalId() + "_avatar.mp4").getAbsolutePath();
                    messageObject2.videoEditedInfo = photoEntry2.editedInfo;
                    bitmapLoadBitmap = ImageLoader.loadBitmap(photoEntry2.thumbPath, null, 800.0f, 800.0f, true);
                    messageObject = messageObject2;
                } else {
                    bitmapLoadBitmap = ImageLoader.loadBitmap(str, null, 800.0f, 800.0f, true);
                }
                ImageUpdater.this.processBitmap(bitmapLoadBitmap, messageObject);
            }
        }, null);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) throws InterruptedException, Resources.NotFoundException {
        int attributeInt;
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
            if (requestCode == 13) {
                PhotoViewer.getInstance().setParentActivity(this.parentFragment.getParentActivity());
                try {
                    attributeInt = new ExifInterface(this.currentPicturePath).getAttributeInt("Orientation", 1);
                } catch (Exception e) {
                    FileLog.e(e);
                }
                int i = attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
                openPhotoForEdit(this.currentPicturePath, null, i, false);
                AndroidUtilities.addMediaToGallery(this.currentPicturePath);
                this.currentPicturePath = null;
                return;
            }
            if (requestCode == 14) {
                if (data == null || data.getData() == null) {
                    return;
                }
                startCrop(null, data.getData());
                return;
            }
            if (requestCode == 15) {
                openPhotoForEdit(this.currentPicturePath, null, 0, true);
                AndroidUtilities.addMediaToGallery(this.currentPicturePath);
                this.currentPicturePath = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processBitmap(Bitmap bitmap, MessageObject avatarObject) {
        VideoEditedInfo videoEditedInfo;
        if (bitmap == null) {
            return;
        }
        this.uploadedVideo = null;
        this.uploadedPhoto = null;
        this.convertingVideo = null;
        this.videoPath = null;
        this.bigPhoto = ImageLoader.scaleAndSaveImage(bitmap, 800.0f, 800.0f, 80, false, 320, 320);
        TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmap, 150.0f, 150.0f, 80, false, ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        this.smallPhoto = tLRPC$PhotoSizeScaleAndSaveImage;
        if (tLRPC$PhotoSizeScaleAndSaveImage != null) {
            try {
                ImageLoader.getInstance().putImageToCache(new BitmapDrawable(BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$PhotoSizeScaleAndSaveImage, true).getAbsolutePath())), this.smallPhoto.location.volume_id + "_" + this.smallPhoto.location.local_id + "@50_50");
            } catch (Throwable unused) {
            }
        }
        bitmap.recycle();
        if (this.bigPhoto != null) {
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
            this.uploadingImage = FileLoader.getDirectory(4) + "/" + this.bigPhoto.location.volume_id + "_" + this.bigPhoto.location.local_id + ".jpg";
            if (this.uploadAfterSelect) {
                if (avatarObject != null && (videoEditedInfo = avatarObject.videoEditedInfo) != null) {
                    this.convertingVideo = avatarObject;
                    long j = videoEditedInfo.startTime;
                    if (j < 0) {
                        j = 0;
                    }
                    double d = videoEditedInfo.avatarStartTime - j;
                    Double.isNaN(d);
                    this.videoTimestamp = d / 1000000.0d;
                    NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.filePreparingStarted);
                    NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.filePreparingFailed);
                    NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileNewChunkAvailable);
                    MediaController.getInstance().scheduleVideoConvert(avatarObject, true);
                    this.uploadingImage = null;
                    ImageUpdaterDelegate imageUpdaterDelegate = this.delegate;
                    if (imageUpdaterDelegate != null) {
                        imageUpdaterDelegate.didStartUpload(true);
                    }
                } else {
                    ImageUpdaterDelegate imageUpdaterDelegate2 = this.delegate;
                    if (imageUpdaterDelegate2 != null) {
                        imageUpdaterDelegate2.didStartUpload(false);
                    }
                }
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploaded);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploadProgressChanged);
                NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.fileUploadFailed);
                if (this.uploadingImage != null) {
                    FileLoader.getInstance(this.currentAccount).uploadFile(this.uploadingImage, false, true, ConnectionsManager.FileTypePhoto);
                }
            }
            ImageUpdaterDelegate imageUpdaterDelegate3 = this.delegate;
            if (imageUpdaterDelegate3 != null) {
                imageUpdaterDelegate3.didUploadPhoto(null, null, 0.0d, null, this.bigPhoto, this.smallPhoto);
            }
        }
    }

    @Override // ir.eitaa.ui.PhotoCropActivity.PhotoEditActivityDelegate
    public void didFinishEdit(Bitmap bitmap) {
        processBitmap(bitmap, null);
    }

    private void cleanup() {
        this.uploadingImage = null;
        this.uploadingVideo = null;
        this.videoPath = null;
        this.convertingVideo = null;
        if (this.clearAfterUpdate) {
            this.imageReceiver.setImageBitmap((Drawable) null);
            this.parentFragment = null;
            this.delegate = null;
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ImageUpdaterDelegate imageUpdaterDelegate;
        BaseFragment baseFragment;
        BaseFragment baseFragment2;
        int i = NotificationCenter.fileUploaded;
        if (id == i || id == NotificationCenter.fileUploadFailed) {
            String str = (String) args[0];
            if (str.equals(this.uploadingImage)) {
                this.uploadingImage = null;
                if (id == i) {
                    this.uploadedPhoto = (TLRPC$InputFile) args[1];
                }
            } else {
                if (!str.equals(this.uploadingVideo)) {
                    return;
                }
                this.uploadingVideo = null;
                if (id == i) {
                    this.uploadedVideo = (TLRPC$InputFile) args[1];
                }
            }
            if (this.uploadingImage == null && this.uploadingVideo == null && this.convertingVideo == null) {
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploadProgressChanged);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileUploadFailed);
                if (id == i && (imageUpdaterDelegate = this.delegate) != null) {
                    imageUpdaterDelegate.didUploadPhoto(this.uploadedPhoto, this.uploadedVideo, this.videoTimestamp, this.videoPath, this.bigPhoto, this.smallPhoto);
                }
                cleanup();
                return;
            }
            return;
        }
        if (id == NotificationCenter.fileUploadProgressChanged) {
            String str2 = (String) args[0];
            String str3 = this.convertingVideo != null ? this.uploadingVideo : this.uploadingImage;
            if (this.delegate == null || !str2.equals(str3)) {
                return;
            }
            this.delegate.onUploadProgressChanged(Math.min(1.0f, ((Long) args[1]).longValue() / ((Long) args[2]).longValue()));
            return;
        }
        int i2 = NotificationCenter.fileLoaded;
        if (id == i2 || id == NotificationCenter.fileLoadFailed || id == NotificationCenter.httpFileDidLoad || id == NotificationCenter.httpFileDidFailedLoad) {
            if (((String) args[0]).equals(this.uploadingImage)) {
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i2);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileLoadFailed);
                NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
                int i3 = NotificationCenter.httpFileDidLoad;
                notificationCenter.removeObserver(this, i3);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.httpFileDidFailedLoad);
                this.uploadingImage = null;
                if (id == i2 || id == i3) {
                    processBitmap(ImageLoader.loadBitmap(this.finalPath, null, 800.0f, 800.0f, true), null);
                    return;
                } else {
                    this.imageReceiver.setImageBitmap((Drawable) null);
                    return;
                }
            }
            return;
        }
        int i4 = NotificationCenter.filePreparingFailed;
        if (id == i4) {
            MessageObject messageObject = (MessageObject) args[0];
            if (messageObject != this.convertingVideo || (baseFragment2 = this.parentFragment) == null) {
                return;
            }
            baseFragment2.getSendMessagesHelper().stopVideoService(messageObject.messageOwner.attachPath);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.filePreparingStarted);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i4);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileNewChunkAvailable);
            cleanup();
            return;
        }
        if (id == NotificationCenter.fileNewChunkAvailable) {
            MessageObject messageObject2 = (MessageObject) args[0];
            if (messageObject2 != this.convertingVideo || this.parentFragment == null) {
                return;
            }
            String str4 = (String) args[1];
            long jLongValue = ((Long) args[2]).longValue();
            long jLongValue2 = ((Long) args[3]).longValue();
            this.parentFragment.getFileLoader().checkUploadNewDataAvailable(str4, false, jLongValue, jLongValue2);
            if (jLongValue2 != 0) {
                double dLongValue = ((Long) args[5]).longValue();
                Double.isNaN(dLongValue);
                double d = dLongValue / 1000000.0d;
                if (this.videoTimestamp > d) {
                    this.videoTimestamp = d;
                }
                Bitmap bitmapCreateVideoThumbnailAtTime = SendMessagesHelper.createVideoThumbnailAtTime(str4, (long) (this.videoTimestamp * 1000.0d), null, true);
                if (bitmapCreateVideoThumbnailAtTime != null) {
                    File pathToAttach = FileLoader.getPathToAttach(this.smallPhoto, true);
                    if (pathToAttach != null) {
                        pathToAttach.delete();
                    }
                    File pathToAttach2 = FileLoader.getPathToAttach(this.bigPhoto, true);
                    if (pathToAttach2 != null) {
                        pathToAttach2.delete();
                    }
                    this.bigPhoto = ImageLoader.scaleAndSaveImage(bitmapCreateVideoThumbnailAtTime, 800.0f, 800.0f, 80, false, 320, 320);
                    TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapCreateVideoThumbnailAtTime, 150.0f, 150.0f, 80, false, ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
                    this.smallPhoto = tLRPC$PhotoSizeScaleAndSaveImage;
                    if (tLRPC$PhotoSizeScaleAndSaveImage != null) {
                        try {
                            ImageLoader.getInstance().putImageToCache(new BitmapDrawable(BitmapFactory.decodeFile(FileLoader.getPathToAttach(tLRPC$PhotoSizeScaleAndSaveImage, true).getAbsolutePath())), this.smallPhoto.location.volume_id + "_" + this.smallPhoto.location.local_id + "@50_50");
                        } catch (Throwable unused) {
                        }
                    }
                }
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.filePreparingStarted);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.filePreparingFailed);
                NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.fileNewChunkAvailable);
                this.parentFragment.getSendMessagesHelper().stopVideoService(messageObject2.messageOwner.attachPath);
                this.videoPath = str4;
                this.uploadingVideo = str4;
                this.convertingVideo = null;
                return;
            }
            return;
        }
        if (id == NotificationCenter.filePreparingStarted && ((MessageObject) args[0]) == this.convertingVideo && (baseFragment = this.parentFragment) != null) {
            this.uploadingVideo = (String) args[1];
            baseFragment.getFileLoader().uploadFile(this.uploadingVideo, false, false, (int) this.convertingVideo.videoEditedInfo.estimatedSize, ConnectionsManager.FileTypeVideo, false);
        }
    }

    public void setForceDarkTheme(boolean forceDarkTheme) {
        this.forceDarkTheme = forceDarkTheme;
    }

    public void setShowingFromDialog(boolean b) {
        this.showingFromDialog = b;
    }
}
