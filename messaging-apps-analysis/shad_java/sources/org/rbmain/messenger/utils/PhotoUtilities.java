package org.rbmain.messenger.utils;

import com.facebook.stetho.websocket.CloseCodes;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.MediaController;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ChatActivity;

/* loaded from: classes4.dex */
public class PhotoUtilities {
    public static void setImageAsAvatar(MediaController.PhotoEntry photoEntry, BaseFragment baseFragment, Runnable runnable) {
    }

    public static void showAvatartConstructorForUpdateUserPhoto(ChatActivity chatActivity, TLRPC$VideoSize tLRPC$VideoSize) {
    }

    public static void applyPhotoToUser(TLRPC$Photo tLRPC$Photo, TLRPC$User tLRPC$User, boolean z) {
        ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$Photo.sizes;
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, 100);
        TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, CloseCodes.NORMAL_CLOSURE);
        tLRPC$User.flags |= 32;
        TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
        tLRPC$User.photo = tLRPC$TL_userProfilePhoto;
        tLRPC$TL_userProfilePhoto.photo_id = tLRPC$Photo.id;
        ArrayList<TLRPC$VideoSize> arrayList2 = tLRPC$Photo.video_sizes;
        tLRPC$TL_userProfilePhoto.has_video = arrayList2 != null && arrayList2.size() > 0;
        if (closestPhotoSizeWithSize != null) {
            tLRPC$User.photo.photo_small = closestPhotoSizeWithSize.location;
        }
        if (closestPhotoSizeWithSize2 != null) {
            tLRPC$User.photo.photo_big = closestPhotoSizeWithSize2.location;
        }
    }

    public static void replacePhotoImagesInCache(int i, TLRPC$Photo tLRPC$Photo, TLRPC$Photo tLRPC$Photo2) {
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 100);
        TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, CloseCodes.NORMAL_CLOSURE);
        TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo2.sizes, 100);
        TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo2.sizes, CloseCodes.NORMAL_CLOSURE);
        if (closestPhotoSizeWithSize3 != null && closestPhotoSizeWithSize != null) {
            FileLoader.getInstance(i);
            File pathToAttach = FileLoader.getPathToAttach(closestPhotoSizeWithSize3, true);
            FileLoader.getInstance(i);
            FileLoader.getPathToAttach(closestPhotoSizeWithSize, true).renameTo(pathToAttach);
            ImageLoader.getInstance().replaceImageInCache(closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", closestPhotoSizeWithSize3.location.volume_id + "_" + closestPhotoSizeWithSize3.location.local_id + "@50_50", ImageLocation.getForPhoto(closestPhotoSizeWithSize, tLRPC$Photo), false);
        }
        if (closestPhotoSizeWithSize4 == null || closestPhotoSizeWithSize2 == null) {
            return;
        }
        FileLoader.getInstance(i);
        File pathToAttach2 = FileLoader.getPathToAttach(closestPhotoSizeWithSize4, true);
        FileLoader.getInstance(i);
        FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true).renameTo(pathToAttach2);
        ImageLoader.getInstance().replaceImageInCache(closestPhotoSizeWithSize2.location.volume_id + "_" + closestPhotoSizeWithSize2.location.local_id + "@150_150", closestPhotoSizeWithSize4.location.volume_id + "_" + closestPhotoSizeWithSize4.location.local_id + "@150_150", ImageLocation.getForPhoto(closestPhotoSizeWithSize2, tLRPC$Photo), false);
    }
}
