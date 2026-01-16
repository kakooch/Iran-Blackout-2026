package ir.appp.rghapp;

import android.util.SparseArray;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class RGHMediaHelper$AlbumEntry {
    public int bucketId;
    public String bucketName;
    public ArrayList<RGHMediaHelper$PhotoEntry> photos = new ArrayList<>();
    public SparseArray<RGHMediaHelper$PhotoEntry> photosByIds = new SparseArray<>();

    public RGHMediaHelper$AlbumEntry(int i, String str, RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        this.bucketId = i;
        this.bucketName = str;
    }

    public void addPhoto(RGHMediaHelper$PhotoEntry rGHMediaHelper$PhotoEntry) {
        this.photos.add(rGHMediaHelper$PhotoEntry);
        this.photosByIds.put(rGHMediaHelper$PhotoEntry.imageId, rGHMediaHelper$PhotoEntry);
    }
}
