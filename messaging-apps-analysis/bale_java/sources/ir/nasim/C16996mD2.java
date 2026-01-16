package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.features.media.components.PhotoViewerAbs;
import ir.nasim.features.media.components.PhotoViewerBridge;
import ir.nasim.features.media.components.PhotoViewerInterface;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.PhotoViewer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.mD2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16996mD2 implements PhotoViewerAbs.PhotoViewerProviderAbs {
    private final /* synthetic */ PhotoViewerAbs.EmptyPhotoViewerProviderAbs a;
    private final boolean b;
    private final List c;
    private final SA2 d;
    private final UA2 e;
    private final InterfaceC14603iB2 f;
    private final UA2 g;
    private final InterfaceC16978mB2 h;
    private final SA2 i;
    private final PhotoViewerInterface j;
    private ArrayList k;

    public C16996mD2(boolean z, List list, SA2 sa2, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2, SA2 sa22, PhotoViewerInterface photoViewerInterface) {
        AbstractC13042fc3.i(list, "allItems");
        AbstractC13042fc3.i(sa2, "selectedItemsCount");
        AbstractC13042fc3.i(ua2, "isItemSelected");
        AbstractC13042fc3.i(interfaceC14603iB2, "onCaptionChanged");
        AbstractC13042fc3.i(ua22, "onSelectionChanged");
        AbstractC13042fc3.i(interfaceC16978mB2, "onPathChanged");
        AbstractC13042fc3.i(sa22, "onSendButtonClicked");
        AbstractC13042fc3.i(photoViewerInterface, "photoViewerInstance");
        this.a = new PhotoViewerAbs.EmptyPhotoViewerProviderAbs();
        this.b = z;
        this.c = list;
        this.d = sa2;
        this.e = ua2;
        this.f = interfaceC14603iB2;
        this.g = ua22;
        this.h = interfaceC16978mB2;
        this.i = sa22;
        this.j = photoViewerInterface;
        this.k = new ArrayList();
    }

    public final XV4 a(C21837uD2 c21837uD2) {
        AbstractC13042fc3.i(c21837uD2, "item");
        List list = this.c;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        int i = 0;
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC10360bX0.w();
            }
            C21837uD2 c21837uD22 = (C21837uD2) obj;
            if (c21837uD2.c() == c21837uD22.c()) {
                i = i2;
            }
            AbstractC14815iX3.b bVar = new AbstractC14815iX3.b(0, c21837uD22.c(), i2, c21837uD22.f(), c21837uD22.e(), c21837uD22.b() != null);
            MediaController.l lVarD = c21837uD22.d();
            if (lVarD != null) {
                bVar.a(lVarD);
            }
            bVar.a = c21837uD22.a();
            arrayList.add(bVar);
            i2 = i3;
        }
        this.k = arrayList;
        return AbstractC4616Fw7.a(Integer.valueOf(i), this.k);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean allowCaption() {
        return this.b;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean allowSendingSubmenu() {
        return this.a.allowSendingSubmenu();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean canCaptureMorePhotos() {
        return this.a.canCaptureMorePhotos();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean canReplace(int i) {
        return this.a.canReplace(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean canScrollAway() {
        return this.a.canScrollAway();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean cancelButtonPressed() {
        return this.a.cancelButtonPressed();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean closeKeyboard() {
        return this.a.closeKeyboard();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void deleteImageAtIndex(int i) {
        this.a.deleteImageAtIndex(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public String getDeleteMessageString() {
        return this.a.getDeleteMessageString();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public C10743c74 getEditingMessageObject() {
        return this.a.getEditingMessageObject();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getPhotoIndex(int i) {
        return this.a.getPhotoIndex(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public PhotoViewerAbs.PlaceProviderObjectAbs getPlaceForPhoto(int i) {
        return this.a.getPlaceForPhoto(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getSelectedCount() {
        return ((Number) this.d.invoke()).intValue();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public HashMap getSelectedPhotos() {
        return this.a.getSelectedPhotos();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public ArrayList getSelectedPhotosOrder() {
        return this.a.getSelectedPhotosOrder();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public CharSequence getSubtitleFor(int i) {
        return this.a.getSubtitleFor(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public Bitmap getThumbForPhoto(int i) {
        return this.a.getThumbForPhoto(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public CharSequence getTitleFor(int i) {
        return this.a.getTitleFor(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int getTotalImageCount() {
        return this.a.getTotalImageCount();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean isPhotoChecked(int i) {
        C21837uD2 c21837uD2 = (C21837uD2) AbstractC15401jX0.t0(this.c, i);
        if (c21837uD2 != null) {
            return ((Boolean) this.e.invoke(Integer.valueOf(c21837uD2.c()))).booleanValue();
        }
        return false;
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean loadMore() {
        return this.a.loadMore();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void needAddMorePhotos() {
        this.a.needAddMorePhotos();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onApplyCaption(CharSequence charSequence) {
        this.a.onApplyCaption(charSequence);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onCaptionChanged(CharSequence charSequence) {
        this.a.onCaptionChanged(charSequence);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onClose() {
        this.a.onClose();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void onOpen() {
        this.a.onOpen();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void onPathChanged(int i, String str, MediaController.l lVar) {
        AbstractC13042fc3.i(str, "path");
        this.h.e(Integer.valueOf(i), str, null, lVar);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void openPhotoForEdit(String str, String str2, boolean z) {
        this.a.openPhotoForEdit(str, str2, z);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void replaceButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
        sendButtonPressed(i, h);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public boolean scaleToFill() {
        return this.a.scaleToFill();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h, boolean z, int i2, boolean z2) {
        sendButtonPressed(i, h);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int setPhotoChecked(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
        return this.a.setPhotoChecked(i, h);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public int setPhotoUnchecked(Object obj) {
        return this.a.setPhotoUnchecked(obj);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void updatePhotoAtIndex(int i) {
        this.a.updatePhotoAtIndex(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean validateGroupId(long j) {
        return this.a.validateGroupId(j);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void willHidePhotoViewer() {
        this.a.willHidePhotoViewer();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void willSwitchFromPhoto(int i) {
        this.a.willSwitchFromPhoto(i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public PhotoViewer.D0 getPlaceForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i, boolean z) {
        return this.a.getPlaceForPhoto(c10743c74, abstractC20488s57, i, z);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public ImageReceiver.b getThumbForPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
        return this.a.getThumbForPhoto(c10743c74, abstractC20488s57, i);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void onCaptionChanged(int i, CharSequence charSequence) {
        this.f.invoke(Integer.valueOf(i), charSequence != null ? charSequence.toString() : null);
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public void sendButtonPressed(int i, ir.nasim.tgwidgets.editor.messenger.H h) {
        if (!isPhotoChecked(i)) {
            setPhotoChecked(i);
        }
        PhotoViewerInterface photoViewerInterface = this.j;
        if ((photoViewerInterface instanceof PhotoViewerBridge ? (PhotoViewerBridge) photoViewerInterface : null) != null) {
            AbstractC14815iX3.b bVar = (AbstractC14815iX3.b) this.k.get(i);
            String str = bVar.c;
            if (str == null && (str = bVar.A) == null) {
                str = "";
            }
            this.h.e(Integer.valueOf(i), str, h, bVar);
        }
        this.i.invoke();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs
    public boolean setPhotoChecked(int i) {
        return ((Boolean) this.g.invoke(Integer.valueOf(i))).booleanValue();
    }

    @Override // ir.nasim.features.media.components.PhotoViewerAbs.PhotoViewerProviderAbs, ir.nasim.tgwidgets.editor.ui.PhotoViewer.C0
    public void willSwitchFromPhoto(C10743c74 c10743c74, AbstractC20488s57 abstractC20488s57, int i) {
        this.a.willSwitchFromPhoto(c10743c74, abstractC20488s57, i);
    }
}
