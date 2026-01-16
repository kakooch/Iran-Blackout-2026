package ir.nasim;

import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;

/* loaded from: classes8.dex */
public interface ND {
    void F4(int i);

    void I2(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

    void W3(String str, GeolocationPermissions.Callback callback);

    void b3(PermissionRequest permissionRequest);
}
