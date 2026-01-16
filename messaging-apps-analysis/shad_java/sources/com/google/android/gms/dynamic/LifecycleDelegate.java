package com.google.android.gms.dynamic;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
/* loaded from: classes.dex */
public interface LifecycleDelegate {
    void onCreate(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();
}
