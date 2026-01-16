package androidMessenger.utilites;

import android.content.Intent;
import android.os.Build;
import androidMessenger.utilites.AudioSelectActivity;
import androidMessenger.utilites.DocumentSelectActivity;
import java.util.ArrayList;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.PhotoAlbumPickerActivity;

/* loaded from: classes.dex */
public class FilePicker {

    public interface Listener {
        void done(String str);
    }

    public void selectImageOrVideo(final LaunchActivity launchActivity, boolean z, boolean z2, final Listener listener) {
        int i = PhotoAlbumPickerActivity.SELECT_TYPE_ALL;
        if ((!z || !z2) && z) {
            i = PhotoAlbumPickerActivity.SELECT_TYPE_WALLPAPER;
        }
        final PhotoAlbumPickerActivity photoAlbumPickerActivity = new PhotoAlbumPickerActivity(i, false, false, null);
        photoAlbumPickerActivity.setMaxSelectedPhotos(1, true);
        photoAlbumPickerActivity.setDelegate(new PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate(this) { // from class: androidMessenger.utilites.FilePicker.1
            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z3, int i2) {
                Listener listener2;
                if (arrayList.size() > 0 && (listener2 = listener) != null) {
                    listener2.done(arrayList.get(0).path);
                }
                photoAlbumPickerActivity.finishFragment();
            }

            @Override // org.rbmain.ui.PhotoAlbumPickerActivity.PhotoAlbumPickerActivityDelegate
            public void startPhotoSelectActivity() {
                try {
                    Intent intent = new Intent();
                    intent.setType("video/*");
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.putExtra("android.intent.extra.sizeLimit", FileLoader.MAX_FILE_SIZE);
                    Intent intent2 = new Intent("android.intent.action.PICK");
                    intent2.setType("image/*");
                    Intent intentCreateChooser = Intent.createChooser(intent2, null);
                    intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent});
                    launchActivity.startActivityForResult(intentCreateChooser, 1);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        });
        launchActivity.lambda$runLinkRequest$40(photoAlbumPickerActivity);
    }

    public void selectFile(LaunchActivity launchActivity, final Listener listener) {
        if (Build.VERSION.SDK_INT >= 23 && launchActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            launchActivity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        DocumentSelectActivity documentSelectActivity = new DocumentSelectActivity();
        documentSelectActivity.setDelegate(new DocumentSelectActivity.DocumentSelectActivityDelegate(this) { // from class: androidMessenger.utilites.FilePicker.2
            @Override // androidMessenger.utilites.DocumentSelectActivity.DocumentSelectActivityDelegate
            public void startDocumentSelectActivity() {
            }

            @Override // androidMessenger.utilites.DocumentSelectActivity.DocumentSelectActivityDelegate
            public void didSelectFiles(DocumentSelectActivity documentSelectActivity2, ArrayList<String> arrayList) {
                Listener listener2;
                documentSelectActivity2.finishFragment();
                if (arrayList.size() <= 0 || (listener2 = listener) == null) {
                    return;
                }
                listener2.done(arrayList.get(0));
                ir.resaneh1.iptv.logger.MyLog.e("FilePicker", "path : " + arrayList.get(0));
            }
        });
        launchActivity.lambda$runLinkRequest$40(documentSelectActivity);
    }

    public void selectAudio(LaunchActivity launchActivity, final Listener listener) {
        if (Build.VERSION.SDK_INT >= 23 && launchActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            launchActivity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 4);
            return;
        }
        AudioSelectActivity audioSelectActivity = new AudioSelectActivity();
        audioSelectActivity.setDelegate(new AudioSelectActivity.AudioSelectActivityDelegate(this) { // from class: androidMessenger.utilites.FilePicker.3
            @Override // androidMessenger.utilites.AudioSelectActivity.AudioSelectActivityDelegate
            public void didSelectAudio(ArrayList<MessageObject> arrayList) {
                if (arrayList.size() <= 0 || listener == null || arrayList.get(0).messageOwner == null || arrayList.get(0).messageOwner.attachPath == null) {
                    return;
                }
                listener.done(arrayList.get(0).messageOwner.attachPath);
            }
        });
        launchActivity.lambda$runLinkRequest$40(audioSelectActivity);
    }
}
