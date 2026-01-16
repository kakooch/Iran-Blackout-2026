package org.rbmain.ui.Components;

import android.graphics.Bitmap;
import com.facebook.stetho.websocket.CloseCodes;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.model.InstaProfileObject;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileInput;
import ir.resaneh1.iptv.model.RubinoRequestUploadFileOutput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoInput;
import ir.resaneh1.iptv.model.RubinoUpdateProfilePhotoOutput;
import ir.resaneh1.iptv.model.RubinoUploadFileOutput;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.MessageObject;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.ui.Components.ImageUpdater;

/* loaded from: classes5.dex */
public class RubinoImageUpdater extends ImageUpdater {
    private RubinoImageUpdaterDelegate delegate;
    private boolean isRubinoDefaultAccount;
    private String rubinoProfileId;
    private String uploadingImage;
    private String uploadingSmallImage;

    public interface RubinoImageUpdaterDelegate extends ImageUpdater.ImageUpdaterDelegate {
        void didFailedUploadPhoto();

        void didStartUploadRubinoAvatar();

        void didUploadedRubinoAvatar(String str);
    }

    public RubinoImageUpdater(int i, boolean z, String str, boolean z2) {
        super(z);
        this.currentAccount = i;
        this.isRubinoDefaultAccount = z2;
        this.rubinoProfileId = str;
    }

    public void setDelegate(RubinoImageUpdaterDelegate rubinoImageUpdaterDelegate) {
        super.setDelegate((ImageUpdater.ImageUpdaterDelegate) rubinoImageUpdaterDelegate);
        this.delegate = rubinoImageUpdaterDelegate;
    }

    @Override // org.rbmain.ui.Components.ImageUpdater
    public void cleanup() {
        super.cleanup();
        this.uploadingImage = null;
        this.uploadingSmallImage = null;
    }

    @Override // org.rbmain.ui.Components.ImageUpdater
    public void processBitmap(final Bitmap bitmap, final MessageObject messageObject) {
        if (bitmap == null) {
            return;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        final TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage = ImageLoader.scaleAndSaveImage(bitmapCopy, 800.0f, 800.0f, 80, false, 320, 320);
        final TLRPC$PhotoSize tLRPC$PhotoSizeScaleAndSaveImage2 = ImageLoader.scaleAndSaveImage(bitmapCopy, 200.0f, 200.0f, 80, false, ImageReceiver.DEFAULT_CROSSFADE_DURATION, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
        if (tLRPC$PhotoSizeScaleAndSaveImage == null || tLRPC$PhotoSizeScaleAndSaveImage2 == null) {
            return;
        }
        this.delegate.didStartUploadRubinoAvatar();
        String str = this.rubinoProfileId;
        if (str == null || str.isEmpty()) {
            return;
        }
        Observable.just(1).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$processBitmap$0(tLRPC$PhotoSizeScaleAndSaveImage2, tLRPC$PhotoSizeScaleAndSaveImage, (Integer) obj);
            }
        }).subscribe(new Observer<Integer>() { // from class: org.rbmain.ui.Components.RubinoImageUpdater.1
            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                if (RubinoImageUpdater.this.isRubinoDefaultAccount) {
                    RubinoImageUpdater.super.processBitmap(bitmap, messageObject);
                } else {
                    RubinoImageUpdater.this.uploadingImage = null;
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RubinoImageUpdater.this.uploadingImage = null;
                RubinoImageUpdater.this.delegate.didFailedUploadPhoto();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RubinoImageUpdater.this.uploadingImage = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$processBitmap$0(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2, Integer num) throws Exception {
        return uploadAvatarForRubino(tLRPC$PhotoSize, tLRPC$PhotoSize2, this.rubinoProfileId);
    }

    Observable<Integer> uploadAvatarForRubino(final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2, final String str) {
        final String[] strArr = new String[1];
        final String[] strArr2 = new String[1];
        final String[] strArr3 = new String[1];
        final String[] strArr4 = new String[1];
        return Observable.just(1).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$1(str, tLRPC$PhotoSize, (Integer) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$2(strArr, (MessangerOutput) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoImageUpdater.lambda$uploadAvatarForRubino$3(strArr2, (MessangerOutput) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$4(str, tLRPC$PhotoSize2, (Integer) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$5(strArr3, (MessangerOutput) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RubinoImageUpdater.lambda$uploadAvatarForRubino$6(strArr4, (MessangerOutput) obj);
            }
        }).observeOn(Schedulers.io()).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$7(strArr3, strArr4, strArr, strArr2, str, (Integer) obj);
            }
        }).flatMap(new Function() { // from class: org.rbmain.ui.Components.RubinoImageUpdater$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$uploadAvatarForRubino$8((MessangerOutput) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$1(String str, TLRPC$PhotoSize tLRPC$PhotoSize, Integer num) throws Exception {
        RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput(str);
        rubinoRequestUploadFileInput.file_name = "avatarThumb.jpg";
        this.uploadingSmallImage = FileLoader.getDirectory(4) + "/" + tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id + ".jpg";
        rubinoRequestUploadFileInput.file_size = Long.valueOf(new File(this.uploadingSmallImage).length());
        rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Picture;
        rubinoRequestUploadFileInput.profile_id = str;
        return ApiRequestMessangerRx.getInstance(this.currentAccount).rubinoRequestUploadFile(rubinoRequestUploadFileInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$2(String[] strArr, MessangerOutput messangerOutput) throws Exception {
        strArr[0] = ((RubinoRequestUploadFileOutput) messangerOutput.data).file_id;
        File file = new File(this.uploadingSmallImage);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
        int i = fileInputStream.read(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.put(bArr, 0, i);
        byteBufferAllocate.rewind();
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
        ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(this.currentAccount);
        T t = messangerOutput.data;
        return apiRequestMessangerRx.rubinoUploadFile(((RubinoRequestUploadFileOutput) t).server_url, bArrCopyOfRange, 1, 1, ((RubinoRequestUploadFileOutput) t).hash_file_request, ((RubinoRequestUploadFileOutput) t).file_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$uploadAvatarForRubino$3(String[] strArr, MessangerOutput messangerOutput) throws Exception {
        strArr[0] = ((RubinoUploadFileOutput) messangerOutput.data).hash_file_receive;
        return Observable.just(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$4(String str, TLRPC$PhotoSize tLRPC$PhotoSize, Integer num) throws Exception {
        RubinoRequestUploadFileInput rubinoRequestUploadFileInput = new RubinoRequestUploadFileInput(str);
        rubinoRequestUploadFileInput.file_name = "avatarMain.jpg";
        this.uploadingImage = FileLoader.getDirectory(4) + "/" + tLRPC$PhotoSize.location.volume_id + "_" + tLRPC$PhotoSize.location.local_id + ".jpg";
        rubinoRequestUploadFileInput.file_size = Long.valueOf(new File(this.uploadingImage).length());
        rubinoRequestUploadFileInput.file_type = RubinoRequestUploadFileInput.FileType.Picture;
        rubinoRequestUploadFileInput.profile_id = str;
        return ApiRequestMessangerRx.getInstance(this.currentAccount).rubinoRequestUploadFile(rubinoRequestUploadFileInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$5(String[] strArr, MessangerOutput messangerOutput) throws Exception {
        strArr[0] = ((RubinoRequestUploadFileOutput) messangerOutput.data).file_id;
        File file = new File(this.uploadingImage);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[((int) file.length()) + CloseCodes.NORMAL_CLOSURE];
        int i = fileInputStream.read(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.put(bArr, 0, i);
        byteBufferAllocate.rewind();
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
        ApiRequestMessangerRx apiRequestMessangerRx = ApiRequestMessangerRx.getInstance(this.currentAccount);
        T t = messangerOutput.data;
        return apiRequestMessangerRx.rubinoUploadFile(((RubinoRequestUploadFileOutput) t).server_url, bArrCopyOfRange, 1, 1, ((RubinoRequestUploadFileOutput) t).hash_file_request, ((RubinoRequestUploadFileOutput) t).file_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable lambda$uploadAvatarForRubino$6(String[] strArr, MessangerOutput messangerOutput) throws Exception {
        strArr[0] = ((RubinoUploadFileOutput) messangerOutput.data).hash_file_receive;
        return Observable.just(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$7(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String str, Integer num) throws Exception {
        RubinoUpdateProfilePhotoInput rubinoUpdateProfilePhotoInput = new RubinoUpdateProfilePhotoInput();
        rubinoUpdateProfilePhotoInput.file_id = strArr[0];
        rubinoUpdateProfilePhotoInput.hash_file_receive = strArr2[0];
        rubinoUpdateProfilePhotoInput.thumbnail_file_id = strArr3[0];
        rubinoUpdateProfilePhotoInput.thumbnail_hash_file_receive = strArr4[0];
        rubinoUpdateProfilePhotoInput.profile_id = str;
        return ApiRequestMessangerRx.getInstance(this.currentAccount).rubinoUpdateProfilePhoto(rubinoUpdateProfilePhotoInput);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Observable lambda$uploadAvatarForRubino$8(MessangerOutput messangerOutput) throws Exception {
        this.delegate.didUploadedRubinoAvatar(this.uploadingImage);
        T t = messangerOutput.data;
        if (((RubinoUpdateProfilePhotoOutput) t).profile != null) {
            InstaProfileObject instaProfileObject = ((RubinoUpdateProfilePhotoOutput) t).profile;
            HashSet hashSet = new HashSet();
            hashSet.add(RubinoProfileObject.UpdatedParameterEnum.avatar);
            RubinoController.getInstance(this.currentAccount).onMyRubinoProfileUpdated(RubinoProfileObject.createFromOldObject(instaProfileObject), hashSet);
        }
        return Observable.just(1);
    }

    @Override // org.rbmain.ui.Components.ImageUpdater
    public boolean isUploadingImage() {
        return (!super.isUploadingImage() && this.uploadingImage == null && this.uploadingSmallImage == null) ? false : true;
    }
}
