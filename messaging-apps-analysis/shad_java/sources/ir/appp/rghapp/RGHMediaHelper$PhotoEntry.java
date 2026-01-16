package ir.appp.rghapp;

import android.graphics.Bitmap;
import ir.appp.rghapp.components.sshCrop.SSHCropView;
import ir.appp.rghapp.rubinoPostSlider.PostTagObject;
import java.util.HashMap;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.Components.Point;

/* loaded from: classes3.dex */
public class RGHMediaHelper$PhotoEntry implements Cloneable {
    public Bitmap bitmap;
    public SSHCropView.SSHCropState cropState;
    public long dateTaken;
    public long duration;
    public VideoEditedInfo editedInfo;
    public int height;
    public int imageId;
    public String imagePath;
    public boolean isVideo;
    public int orientation;
    public String path;
    public RGHMediaHelper$SavedFilterState savedFilterState;
    public long size;
    public HashMap<PostTagObject, Point> tempTaggedProfiles = new HashMap<>();
    public Bitmap thumbBitmap;
    public String thumbPath;
    public int width;

    public RGHMediaHelper$PhotoEntry(int i, int i2, long j, String str, int i3, boolean z) {
        this.imageId = i2;
        this.dateTaken = j;
        this.path = str;
        if (z) {
            this.duration = i3;
        } else {
            this.orientation = i3;
        }
        this.isVideo = z;
    }

    public RGHMediaHelper$PhotoEntry(int i, int i2, long j, String str, long j2, boolean z, int i3, int i4, long j3) {
        this.imageId = i2;
        this.dateTaken = j;
        this.path = str;
        this.width = i3;
        this.height = i4;
        this.size = j3;
        if (z) {
            this.duration = j2;
        } else {
            this.orientation = (int) j2;
        }
        this.isVideo = z;
        this.cropState = null;
        this.savedFilterState = new RGHMediaHelper$SavedFilterState();
        VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
        this.editedInfo = videoEditedInfo;
        videoEditedInfo.cropState = new MediaController.CropState();
        this.cropState = new SSHCropView.SSHCropState(i3, i4, 0);
    }

    public void resetForAddPost() {
        this.imagePath = null;
        if (!this.isVideo) {
            this.thumbPath = null;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        Bitmap bitmap2 = this.thumbBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.thumbBitmap.recycle();
            this.thumbBitmap = null;
        }
        this.savedFilterState = new RGHMediaHelper$SavedFilterState();
        VideoEditedInfo videoEditedInfo = new VideoEditedInfo();
        this.editedInfo = videoEditedInfo;
        videoEditedInfo.cropState = new MediaController.CropState();
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public RGHMediaHelper$PhotoEntry copy() {
        try {
            return (RGHMediaHelper$PhotoEntry) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
