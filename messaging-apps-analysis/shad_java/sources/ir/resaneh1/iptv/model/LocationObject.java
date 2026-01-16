package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.MapViewObject;
import ir.resaneh1.iptv.helper.StorageHelper;
import java.io.File;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class LocationObject {
    private transient String hashname;
    public double latitude;
    public double longitude;
    public MapViewObject map_view;

    public LocationObject(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public File getDownloadedFile() {
        return new File(StorageHelper.getTempDirectoryFile(ApplicationLoader.applicationContext), getHashName());
    }

    public LocationObject() {
    }

    public String getHashName() {
        if (this.hashname == null) {
            this.hashname = this.latitude + "_" + this.longitude + ".jpg";
        }
        return this.hashname;
    }
}
