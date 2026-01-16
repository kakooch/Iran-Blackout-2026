package androidMessenger.utilites;

import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes.dex */
public class FilePickerManager {
    public static FilePickerManager instance;
    public LaunchActivity mainActivity = ApplicationLoader.applicationActivity;

    public interface Listener {
    }

    public static FilePickerManager getInstance() {
        if (instance == null) {
            instance = new FilePickerManager();
        }
        return instance;
    }

    public enum ActivityRequestCode {
        cameraImage(6000),
        cameraVideo(6001),
        recordAudio(6002);

        public int value;

        ActivityRequestCode(int i) {
            this.value = i;
        }
    }

    public void openCamera(boolean z, Listener listener) {
        LaunchActivity launchActivity;
        if (listener == null || (launchActivity = this.mainActivity) == null) {
            return;
        }
        launchActivity.startActivitySelectFile(z);
    }

    public void openAudioRecorder(Listener listener) {
        LaunchActivity launchActivity;
        if (listener == null || (launchActivity = this.mainActivity) == null) {
            return;
        }
        launchActivity.startActivityRecordAudio();
    }
}
