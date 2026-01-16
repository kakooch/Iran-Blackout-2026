package ir.appp.rghapp.rubinoPostSlider;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PhotoSlideObject {
    private int currentIndex = 0;
    private ArrayList<PhotoViewerObject> photos;
    public int reqCellHeight;

    public PhotoSlideObject(ArrayList<PhotoViewerObject> arrayList) {
        this.photos = arrayList;
    }

    public ArrayList<PhotoViewerObject> getPhotos() {
        return this.photos;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getReqCellHeight() {
        return this.reqCellHeight;
    }

    public void setCurrentIndex(int i) {
        this.currentIndex = i;
    }
}
