package ir.eitaa.messenger;

import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$GeoPoint;
import ir.eitaa.tgnet.TLRPC$InputGeoPoint;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputWebFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputGeoPoint;
import ir.eitaa.tgnet.TLRPC$TL_inputWebFileGeoPointLocation;
import ir.eitaa.tgnet.TLRPC$TL_inputWebFileLocation;
import ir.eitaa.tgnet.TLRPC$TL_webDocument;
import ir.eitaa.tgnet.TLRPC$WebDocument;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class WebFile extends TLObject {
    public ArrayList<TLRPC$DocumentAttribute> attributes;
    public TLRPC$InputGeoPoint geo_point;
    public int h;
    public TLRPC$InputWebFileLocation location;
    public String mime_type;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public int scale;
    public int size;
    public String url;
    public int w;
    public int zoom;

    public static WebFile createWithGeoPoint(TLRPC$GeoPoint point, int w, int h, int zoom, int scale) {
        return createWithGeoPoint(point.lat, point._long, point.access_hash, w, h, zoom, scale);
    }

    public static WebFile createWithGeoPoint(double lat, double _long, long access_hash, int w, int h, int zoom, int scale) {
        WebFile webFile = new WebFile();
        TLRPC$TL_inputWebFileGeoPointLocation tLRPC$TL_inputWebFileGeoPointLocation = new TLRPC$TL_inputWebFileGeoPointLocation();
        webFile.location = tLRPC$TL_inputWebFileGeoPointLocation;
        TLRPC$TL_inputGeoPoint tLRPC$TL_inputGeoPoint = new TLRPC$TL_inputGeoPoint();
        webFile.geo_point = tLRPC$TL_inputGeoPoint;
        tLRPC$TL_inputWebFileGeoPointLocation.geo_point = tLRPC$TL_inputGeoPoint;
        tLRPC$TL_inputWebFileGeoPointLocation.access_hash = access_hash;
        tLRPC$TL_inputGeoPoint.lat = lat;
        tLRPC$TL_inputGeoPoint._long = _long;
        webFile.w = w;
        tLRPC$TL_inputWebFileGeoPointLocation.w = w;
        webFile.h = h;
        tLRPC$TL_inputWebFileGeoPointLocation.h = h;
        webFile.zoom = zoom;
        tLRPC$TL_inputWebFileGeoPointLocation.zoom = zoom;
        webFile.scale = scale;
        tLRPC$TL_inputWebFileGeoPointLocation.scale = scale;
        webFile.mime_type = "image/png";
        webFile.url = String.format(Locale.US, "maps_%.6f_%.6f_%d_%d_%d_%d.png", Double.valueOf(lat), Double.valueOf(_long), Integer.valueOf(w), Integer.valueOf(h), Integer.valueOf(zoom), Integer.valueOf(scale));
        webFile.attributes = new ArrayList<>();
        return webFile;
    }

    public static WebFile createWithWebDocument(TLRPC$WebDocument webDocument) {
        if (!(webDocument instanceof TLRPC$TL_webDocument)) {
            return null;
        }
        WebFile webFile = new WebFile();
        TLRPC$TL_webDocument tLRPC$TL_webDocument = (TLRPC$TL_webDocument) webDocument;
        TLRPC$TL_inputWebFileLocation tLRPC$TL_inputWebFileLocation = new TLRPC$TL_inputWebFileLocation();
        webFile.location = tLRPC$TL_inputWebFileLocation;
        String str = webDocument.url;
        webFile.url = str;
        tLRPC$TL_inputWebFileLocation.url = str;
        tLRPC$TL_inputWebFileLocation.access_hash = tLRPC$TL_webDocument.access_hash;
        webFile.size = tLRPC$TL_webDocument.size;
        webFile.mime_type = tLRPC$TL_webDocument.mime_type;
        webFile.attributes = tLRPC$TL_webDocument.attributes;
        return webFile;
    }
}
