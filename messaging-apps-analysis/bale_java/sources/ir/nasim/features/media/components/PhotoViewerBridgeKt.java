package ir.nasim.features.media.components;

import android.graphics.Bitmap;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20488s57;
import ir.nasim.C10743c74;
import ir.nasim.SA2;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.tgwidgets.editor.messenger.H;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;", "", "starterIndex", "Lkotlin/Function0;", "Lir/nasim/rB7;", "onDismissListener", "Lir/nasim/tgwidgets/editor/ui/PhotoViewer$C0;", "mapToPhotoViewerProvider", "(Lir/nasim/features/media/components/PhotoViewerAbs$PhotoViewerProviderAbs;ILir/nasim/SA2;)Lir/nasim/tgwidgets/editor/ui/PhotoViewer$C0;", "Lir/nasim/features/media/components/PhotoViewerAbs$PlaceProviderObjectAbs;", "mapToPlaceProviderObject", "(Lir/nasim/features/media/components/PhotoViewerAbs$PlaceProviderObjectAbs;)Lir/nasim/features/media/components/PhotoViewerAbs$PlaceProviderObjectAbs;", "nasim_release"}, k = 2, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PhotoViewerBridgeKt {
    public static final PhotoViewer.C0 mapToPhotoViewerProvider(PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, int i, SA2 sa2) {
        AbstractC13042fc3.i(photoViewerProviderAbs, "<this>");
        return new PhotoViewer.C0(i, photoViewerProviderAbs, sa2) { // from class: ir.nasim.features.media.components.PhotoViewerBridgeKt.mapToPhotoViewerProvider.1

            /* renamed from: a, reason: from kotlin metadata */
            private int index;
            final /* synthetic */ PhotoViewerAbs.PhotoViewerProviderAbs b;
            final /* synthetic */ SA2 c;

            {
                this.b = photoViewerProviderAbs;
                this.c = sa2;
                this.index = i;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean allowCaption() {
                return this.b.allowCaption();
            }

            public boolean allowSendingSubmenu() {
                return false;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean canCaptureMorePhotos() {
                return false;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public /* bridge */ /* synthetic */ boolean canLoadMoreAvatars() {
                return super.canLoadMoreAvatars();
            }

            public boolean canReplace(int index) {
                return false;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean canScrollAway() {
                return true;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean cancelButtonPressed() {
                return this.b.cancelButtonPressed();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean closeKeyboard() {
                return true;
            }

            public void deleteImageAtIndex(int index) {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public String getDeleteMessageString() {
                return null;
            }

            public C10743c74 getEditingMessageObject() {
                return null;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public int getPhotoIndex(int index) {
                return index;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public PhotoViewer.D0 getPlaceForPhoto(C10743c74 messageObject, AbstractC20488s57 fileLocation, int index, boolean needPreview) {
                PhotoViewerAbs.PlaceProviderObjectAbs placeForPhoto = this.b.getPlaceForPhoto(index);
                if (placeForPhoto != null) {
                    return PhotoViewerBridgeKt.mapToPlaceProviderObject(placeForPhoto);
                }
                return null;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public int getSelectedCount() {
                return this.b.getSelectedCount();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public HashMap<Object, Object> getSelectedPhotos() {
                return new HashMap<>();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public ArrayList<Object> getSelectedPhotosOrder() {
                return new ArrayList<>();
            }

            public CharSequence getSubtitleFor(int index) {
                return null;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public ImageReceiver.b getThumbForPhoto(C10743c74 messageObject, AbstractC20488s57 fileLocation, int index) {
                Bitmap thumbForPhoto = this.b.getThumbForPhoto(index);
                if (thumbForPhoto != null) {
                    return new ImageReceiver.b(thumbForPhoto);
                }
                return null;
            }

            public CharSequence getTitleFor(int index) {
                return null;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public int getTotalImageCount() {
                return 0;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean isPhotoChecked(int index) {
                return this.b.isPhotoChecked(index);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean loadMore() {
                return false;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void needAddMorePhotos() {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onApplyCaption(CharSequence caption) {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onCaptionChanged(CharSequence caption) {
                this.b.onCaptionChanged(this.index, caption);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onClose() {
                SA2 sa22 = this.c;
                if (sa22 != null) {
                    sa22.invoke();
                }
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public /* bridge */ /* synthetic */ boolean onDeletePhoto(int i2) {
                return super.onDeletePhoto(i2);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onIndexChanged(int currentIndex) {
                this.index = currentIndex;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onOpen() {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void onPathChanged(String path, MediaController.l mediaEditState) {
                AbstractC13042fc3.i(path, "path");
                this.b.onPathChanged(this.index, path, mediaEditState);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public /* bridge */ /* synthetic */ void onPreClose() {
                super.onPreClose();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public /* bridge */ /* synthetic */ void onPreOpen() {
                super.onPreOpen();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void openPhotoForEdit(String file, String thumb, boolean isVideo) {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void replaceButtonPressed(int index, H videoEditedInfo) {
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public boolean scaleToFill() {
                return this.b.scaleToFill();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void sendButtonPressed(int index, H videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
                this.b.sendButtonPressed(index, videoEditedInfo);
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public int setPhotoChecked(int index, H videoEditedInfo) {
                this.b.setPhotoChecked(index);
                return 0;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public int setPhotoUnchecked(Object photoEntry) {
                return 0;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void updatePhotoAtIndex(int index) {
                this.b.updatePhotoAtIndex(index);
            }

            public boolean validateGroupId(long groupId) {
                return true;
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void willHidePhotoViewer() {
                this.b.willHidePhotoViewer();
            }

            @Override // ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
            public void willSwitchFromPhoto(C10743c74 messageObject, AbstractC20488s57 fileLocation, int index) {
                this.b.willSwitchFromPhoto(index);
            }
        };
    }

    public static /* synthetic */ PhotoViewer.C0 mapToPhotoViewerProvider$default(PhotoViewerAbs.PhotoViewerProviderAbs photoViewerProviderAbs, int i, SA2 sa2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sa2 = null;
        }
        return mapToPhotoViewerProvider(photoViewerProviderAbs, i, sa2);
    }

    public static final PhotoViewerAbs.PlaceProviderObjectAbs mapToPlaceProviderObject(PhotoViewerAbs.PlaceProviderObjectAbs placeProviderObjectAbs) {
        AbstractC13042fc3.i(placeProviderObjectAbs, "<this>");
        ImageReceiver.b bVar = placeProviderObjectAbs.thumb;
        if (bVar != null) {
            placeProviderObjectAbs.thumbBitmap = bVar.c;
        }
        placeProviderObjectAbs.dialogIdInt = (int) placeProviderObjectAbs.dialogId;
        placeProviderObjectAbs.sizeInt = (int) placeProviderObjectAbs.size;
        int[] iArr = placeProviderObjectAbs.radius;
        if (iArr != null && iArr.length > 1) {
            placeProviderObjectAbs.radiusAll = iArr[0];
        }
        return placeProviderObjectAbs;
    }
}
