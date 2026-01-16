package ir.nasim.features.media.components;

import android.app.Activity;
import android.app.AlertDialog;
import ir.nasim.C11458d25;
import ir.nasim.NP0;
import ir.nasim.SA2;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.tgwidgets.editor.ui.O;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public interface PhotoViewerInterface {
    void closePhoto(boolean z, boolean z2);

    void destroyPhotoViewer();

    boolean isShowingImage(String str);

    boolean isVisible();

    void onPause();

    void onResume();

    boolean openPhotoForSelect(ArrayList<Object> arrayList, int i, int i2, boolean z, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType);

    boolean openPhotoForSelect(ArrayList<Object> arrayList, int i, int i2, boolean z, boolean z2, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType);

    default boolean openPhotoForSelect(ArrayList<Object> arrayList, int i, int i2, boolean z, boolean z2, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType, NP0 np0) {
        return openPhotoForSelect(arrayList, i, i2, z2, z, photoViewerProviderAbs, c11458d25, exPeerType);
    }

    boolean openPhotoForSelect(ArrayList<Object> arrayList, int i, int i2, boolean z, boolean z2, PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, C11458d25 c11458d25, ExPeerType exPeerType, SA2 sa2);

    default void setInputBar(O o) {
    }

    void setParentActivity(Activity activity);

    void showAlertDialog(AlertDialog.Builder builder);

    default void setParentChatActivity(NP0 np0) {
    }
}
