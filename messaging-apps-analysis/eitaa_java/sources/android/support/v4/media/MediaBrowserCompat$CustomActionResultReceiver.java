package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {
    private final MediaBrowserCompat$CustomActionCallback mCallback;
    private final Bundle mExtras;

    @Override // android.support.v4.os.ResultReceiver
    protected void onReceiveResult(int i, Bundle bundle) {
        if (this.mCallback == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(bundle);
        if (i == -1 || i == 0 || i == 1) {
            throw null;
        }
        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.mExtras + ", resultData=" + bundle + ")");
    }
}
