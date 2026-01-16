package io.antmedia.android.broadcaster;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public interface ILiveVideoBroadcaster {

    public interface TakePhotoCallback {
        void onTakePhoto(Bitmap bitmap);
    }
}
