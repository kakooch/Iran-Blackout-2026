package ir.nasim.features.media.components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.GestureDetector;
import ir.nasim.AbstractC20488s57;
import ir.nasim.C10743c74;
import ir.nasim.C15225jD4;
import ir.nasim.C20171rb5;
import ir.nasim.S23;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes6.dex */
public abstract class PhotoViewerAbs implements PhotoViewerInterface, C15225jD4.b, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    public static final int PHOTO_TYPE_SEND_MULTI = 0;
    public static final int PHOTO_TYPE_SET_SINGLE = 1;
    private static volatile PhotoViewerAbs a;
    private static volatile PhotoViewerBridge b;
    protected boolean isPurchaseType = false;
    protected boolean isWallpaperType = false;

    public static class EmptyPhotoViewerProviderAbs implements EmptyPhotoViewerProviderInt {
        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ boolean canLoadMoreAvatars() {
            return super.canLoadMoreAvatars();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ boolean onDeletePhoto(int i) {
            return super.onDeletePhoto(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ void onIndexChanged(int i) {
            super.onIndexChanged(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ void onPathChanged(String str, MediaController.l lVar) {
            super.onPathChanged(str, lVar);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ void onPreClose() {
            super.onPreClose();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.EmptyPhotoViewerProviderInt, ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        public /* bridge */ /* synthetic */ void onPreOpen() {
            super.onPreOpen();
        }
    }

    public interface EmptyPhotoViewerProviderInt extends PhotoViewerProviderAbs {
        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean allowCaption() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default boolean allowSendingSubmenu() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean canCaptureMorePhotos() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default boolean canLoadMoreAvatars() {
            return super.canLoadMoreAvatars();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default boolean canReplace(int i) {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean canScrollAway() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean cancelButtonPressed() {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean closeKeyboard() {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default void deleteImageAtIndex(int i) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default String getDeleteMessageString() {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default C10743c74 getEditingMessageObject() {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default int getPhotoIndex(int i) {
            return -1;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default PlaceProviderObjectAbs getPlaceForPhoto(int i) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default int getSelectedCount() {
            return 0;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default HashMap<Object, Object> getSelectedPhotos() {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default ArrayList<Object> getSelectedPhotosOrder() {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default CharSequence getSubtitleFor(int i) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default Bitmap getThumbForPhoto(int i) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default CharSequence getTitleFor(int i) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default int getTotalImageCount() {
            return -1;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean isPhotoChecked(int i) {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean loadMore() {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void needAddMorePhotos() {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void onApplyCaption(CharSequence charSequence) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default void onCaptionChanged(int i, CharSequence charSequence) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void onClose() {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default boolean onDeletePhoto(int i) {
            return super.onDeletePhoto(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onIndexChanged(int i) {
            super.onIndexChanged(i);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void onOpen() {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPathChanged(String str, MediaController.l lVar) {
            super.onPathChanged(str, lVar);
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPreClose() {
            super.onPreClose();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPreOpen() {
            super.onPreOpen();
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void openPhotoForEdit(String str, String str2, boolean z) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void replaceButtonPressed(int i, H h) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default boolean scaleToFill() {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default void sendButtonPressed(int i, H h) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default int setPhotoChecked(int i, H h) {
            return -1;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default int setPhotoUnchecked(Object obj) {
            return -1;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void updatePhotoAtIndex(int i) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default boolean validateGroupId(long j) {
            return true;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void willHidePhotoViewer() {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default void willSwitchFromPhoto(int i) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default PhotoViewer.D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
            return null;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void onCaptionChanged(CharSequence charSequence) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void sendButtonPressed(int i, H h, boolean z, int i2, boolean z2) {
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
        default boolean setPhotoChecked(int i) {
            return false;
        }

        @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        default void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
        }
    }

    public interface PhotoViewerProviderAbs extends PhotoViewer.C0 {
        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean allowCaption();

        /* synthetic */ boolean allowSendingSubmenu();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean canCaptureMorePhotos();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default boolean canLoadMoreAvatars() {
            return super.canLoadMoreAvatars();
        }

        /* synthetic */ boolean canReplace(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean canScrollAway();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean cancelButtonPressed();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean closeKeyboard();

        /* synthetic */ void deleteImageAtIndex(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ String getDeleteMessageString();

        /* synthetic */ C10743c74 getEditingMessageObject();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ int getPhotoIndex(int i);

        PlaceProviderObjectAbs getPlaceForPhoto(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ PhotoViewer.D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ int getSelectedCount();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ HashMap getSelectedPhotos();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ ArrayList getSelectedPhotosOrder();

        /* synthetic */ CharSequence getSubtitleFor(int i);

        Bitmap getThumbForPhoto(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i);

        /* synthetic */ CharSequence getTitleFor(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ int getTotalImageCount();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean isPhotoChecked(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean loadMore();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void needAddMorePhotos();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void onApplyCaption(CharSequence charSequence);

        void onCaptionChanged(int i, CharSequence charSequence);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void onCaptionChanged(CharSequence charSequence);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void onClose();

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default boolean onDeletePhoto(int i) {
            return super.onDeletePhoto(i);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onIndexChanged(int i) {
            super.onIndexChanged(i);
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void onOpen();

        default void onPathChanged(int i, String str, MediaController.l lVar) {
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPreClose() {
            super.onPreClose();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPreOpen() {
            super.onPreOpen();
        }

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void openPhotoForEdit(String str, String str2, boolean z);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void replaceButtonPressed(int i, H h);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ boolean scaleToFill();

        void sendButtonPressed(int i, H h);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void sendButtonPressed(int i, H h, boolean z, int i2, boolean z2);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ int setPhotoChecked(int i, H h);

        boolean setPhotoChecked(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ int setPhotoUnchecked(Object obj);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void updatePhotoAtIndex(int i);

        /* synthetic */ boolean validateGroupId(long j);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void willHidePhotoViewer();

        void willSwitchFromPhoto(int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* synthetic */ void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i);

        @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
        /* bridge */ /* synthetic */ default void onPathChanged(String str, MediaController.l lVar) {
            super.onPathChanged(str, lVar);
        }
    }

    public static class PlaceProviderObjectAbs extends PhotoViewer.D0 {
        public int dialogIdInt;
        public S23 imageReceiverOld;
        public int radiusAll;
        public int sizeInt;
        public Bitmap thumbBitmap;
    }

    private static PhotoViewerBridge a() {
        PhotoViewerBridge photoViewerBridge = b;
        if (photoViewerBridge == null) {
            synchronized (PhotoViewerAbs.class) {
                try {
                    photoViewerBridge = b;
                    if (photoViewerBridge == null) {
                        photoViewerBridge = new PhotoViewerBridge();
                        b = photoViewerBridge;
                    }
                } finally {
                }
            }
        }
        return photoViewerBridge;
    }

    private static PhotoViewerAbs b() {
        PhotoViewerAbs c20171rb5 = a;
        if (c20171rb5 == null) {
            synchronized (PhotoViewerAbs.class) {
                try {
                    c20171rb5 = a;
                    if (c20171rb5 == null) {
                        c20171rb5 = new C20171rb5();
                        a = c20171rb5;
                    }
                } finally {
                }
            }
        }
        return c20171rb5;
    }

    public static PhotoViewerInterface getInstance(boolean z) {
        return z ? a() : b();
    }

    @Override // ir.nasim.C15225jD4.b
    public abstract /* synthetic */ void didReceivedNotification(int i, Object... objArr);

    public abstract void onDraw(Canvas canvas);

    protected void resetInstance() {
        b = null;
        a = null;
    }

    public static PhotoViewerInterface getInstance() {
        return getInstance(false);
    }
}
