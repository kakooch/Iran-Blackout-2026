package ir.nasim.features.media.components;

import android.app.Activity;
import android.app.AlertDialog;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C11458d25;
import ir.nasim.NP0;
import ir.nasim.SA2;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.tgwidgets.editor.ui.O;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 JC\u0010!\u001a\u00020\u000f2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u000fH\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,JU\u00103\u001a\u00020\u000f2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J]\u00103\u001a\u00020\u000f2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00106Jg\u00103\u001a\u00020\u000f2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b3\u00107Jm\u00103\u001a\u00020\u000f2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u000108H\u0016¢\u0006\u0004\b3\u0010:J\u000f\u0010;\u001a\u00020\u0014H\u0016¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010<\u001a\u00020\u0014H\u0016¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010=\u001a\u00020\u0014H\u0016¢\u0006\u0004\b=\u0010\u0003¨\u0006>"}, d2 = {"Lir/nasim/features/media/components/PhotoViewerBridge;", "Lir/nasim/features/media/components/PhotoViewerInterface;", "<init>", "()V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "photos", "", "index", "type", "Lir/nasim/tgwidgets/editor/ui/PhotoViewer$C0;", "provider", "Lir/nasim/NP0;", "chatActivity", "", "a", "(Ljava/util/ArrayList;IILir/nasim/tgwidgets/editor/ui/PhotoViewer$C0;Lir/nasim/NP0;)Z", "Landroid/app/Activity;", "activity", "Lir/nasim/rB7;", "setParentActivity", "(Landroid/app/Activity;)V", "Lir/nasim/tgwidgets/editor/ui/O;", "inputBar", "setInputBar", "(Lir/nasim/tgwidgets/editor/ui/O;)V", "setParentChatActivity", "(Lir/nasim/NP0;)V", "Landroid/app/AlertDialog$Builder;", "builder", "showAlertDialog", "(Landroid/app/AlertDialog$Builder;)V", "openPhotoForWallpaper", "(Ljava/util/ArrayList;ILir/nasim/tgwidgets/editor/ui/PhotoViewer$C0;Lir/nasim/NP0;)Z", "animated", "fromEditMode", "closePhoto", "(ZZ)V", "isVisible", "()Z", "", "object", "isShowingImage", "(Ljava/lang/String;)Z", "isPurchaseType", "Lir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;", "Lir/nasim/d25;", "peer", "Lir/nasim/core/modules/profile/entity/ExPeerType;", DialogEntity.COLUMN_EX_PEER_TYPE, "openPhotoForSelect", "(Ljava/util/ArrayList;IIZLir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;)Z", "isWallpaperReq", "(Ljava/util/ArrayList;IIZZLir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;)Z", "(Ljava/util/ArrayList;IIZZLir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Lir/nasim/NP0;)Z", "Lkotlin/Function0;", "onDismissListener", "(Ljava/util/ArrayList;IIZZLir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;Lir/nasim/d25;Lir/nasim/core/modules/profile/entity/ExPeerType;Lir/nasim/SA2;)Z", "onResume", "onPause", "destroyPhotoViewer", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PhotoViewerBridge implements PhotoViewerInterface {
    public static final int $stable = 0;

    private final boolean a(ArrayList photos, int index, int type, PhotoViewer.C0 provider, NP0 chatActivity) {
        return PhotoViewer.k8().ra(photos, index, type, false, provider, chatActivity);
    }

    static /* synthetic */ boolean b(PhotoViewerBridge photoViewerBridge, ArrayList arrayList, int i, int i2, PhotoViewer.C0 c0, NP0 np0, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            np0 = null;
        }
        return photoViewerBridge.a(arrayList, i, i2, c0, np0);
    }

    public static /* synthetic */ boolean openPhotoForWallpaper$default(PhotoViewerBridge photoViewerBridge, ArrayList arrayList, int i, PhotoViewer.C0 c0, NP0 np0, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            np0 = null;
        }
        return photoViewerBridge.openPhotoForWallpaper(arrayList, i, c0, np0);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void closePhoto(boolean animated, boolean fromEditMode) {
        PhotoViewer.k8().z7(animated, fromEditMode);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void destroyPhotoViewer() {
        PhotoViewer.k8().J7();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean isShowingImage(String object) {
        PhotoViewer photoViewerK8 = PhotoViewer.k8();
        return photoViewerK8.C8() && !photoViewerK8.X3 && object != null && AbstractC13042fc3.d(object, photoViewerK8.y4);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean isVisible() {
        return PhotoViewer.k8().C8();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void onPause() {
        PhotoViewer photoViewerK8 = PhotoViewer.k8();
        if (photoViewerK8.P1 != null) {
            photoViewerK8.z7(false, false);
        } else if (photoViewerK8.K1.getVisibility() != 8) {
            photoViewerK8.x7(true);
        }
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void onResume() {
        PhotoViewer.k8().za(0);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList<Object> photos, int index, int type, boolean isPurchaseType, PhotoViewerAbs.PhotoViewerProviderAbs provider, C11458d25 peer, ExPeerType exPeerType) {
        if (photos == null) {
            return false;
        }
        return b(this, photos, index, type, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, null, 16, null);
    }

    public final boolean openPhotoForWallpaper(ArrayList<Object> photos, int index, PhotoViewer.C0 provider, NP0 chatActivity) {
        AbstractC13042fc3.i(photos, "photos");
        return PhotoViewer.k8().ra(photos, index, 3, false, provider, chatActivity);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void setInputBar(O inputBar) {
        PhotoViewer.k8().Wa(inputBar);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void setParentActivity(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        PhotoViewer.k8().bb(activity);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void setParentChatActivity(NP0 chatActivity) {
        PhotoViewer.k8().db(chatActivity);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public void showAlertDialog(AlertDialog.Builder builder) {
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList<Object> photos, int index, int type, boolean isPurchaseType, boolean isWallpaperReq, PhotoViewerAbs.PhotoViewerProviderAbs provider, C11458d25 peer, ExPeerType exPeerType) {
        if (isWallpaperReq) {
            if (photos == null) {
                return false;
            }
            return openPhotoForWallpaper$default(this, photos, index, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, null, 8, null);
        }
        if (photos == null) {
            return false;
        }
        return b(this, photos, index, type, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, null, 16, null);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList<Object> photos, int index, int type, boolean isPurchaseType, boolean isWallpaperReq, PhotoViewerAbs.PhotoViewerProviderAbs provider, C11458d25 peer, ExPeerType exPeerType, NP0 chatActivity) {
        if (isWallpaperReq) {
            if (photos == null) {
                return false;
            }
            return openPhotoForWallpaper(photos, index, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, chatActivity);
        }
        if (photos == null) {
            return false;
        }
        return a(photos, index, type, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, chatActivity);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerInterface
    public boolean openPhotoForSelect(ArrayList<Object> photos, int index, int type, boolean isPurchaseType, boolean isWallpaperReq, PhotoViewerAbs.PhotoViewerProviderAbs provider, C11458d25 peer, ExPeerType exPeerType, SA2 onDismissListener) {
        if (isWallpaperReq) {
            if (photos == null) {
                return false;
            }
            return openPhotoForWallpaper$default(this, photos, index, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, null, 8, null);
        }
        if (photos == null) {
            return false;
        }
        return b(this, photos, index, 0, provider != null ? PhotoViewerBridgeKt.mapToPhotoViewerProvider$default(provider, index, null, 2, null) : null, null, 16, null);
    }
}
