package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class TLRPC$InputMedia extends TLObject {
    public String address;
    public TLRPC$InputFile file;
    public String first_name;
    public int flags;
    public boolean force_file;
    public TLRPC$InputGeoPoint geo_point;
    public int heading;
    public String last_name;
    public String mime_type;
    public boolean nosound_video;
    public int period;
    public String phone_number;
    public String provider;
    public int proximity_notification_radius;
    public boolean stopped;
    public TLRPC$InputFile thumb;
    public String title;
    public int ttl_seconds;
    public String vcard;
    public String venue_id;
    public String venue_type;
    public ArrayList<TLRPC$InputDocument> stickers = new ArrayList<>();
    public ArrayList<TLRPC$DocumentAttribute> attributes = new ArrayList<>();

    public static TLRPC$InputMedia TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$InputMedia tLRPC$TL_inputMediaGeoLive;
        switch (constructor) {
            case -1771768449:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$InputMedia() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputMediaEmpty
                    public static int constructor = -1771768449;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1759532989:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoLive();
                break;
            case -1279654347:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaPhoto();
                break;
            case -1052959727:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaVenue();
                break;
            case -750828557:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGame();
                break;
            case -440664550:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$InputMedia() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputMediaPhotoExternal
                    public static int constructor = -440664550;
                    public String url;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.url = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.ttl_seconds = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeString(this.url);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.ttl_seconds);
                        }
                    }
                };
                break;
            case -428884101:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaDice();
                break;
            case -122978821:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaContact();
                break;
            case -104578748:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaGeoPoint();
                break;
            case -78455655:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$InputMedia() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputMediaDocumentExternal
                    public static int constructor = -78455655;
                    public String url;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.url = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.ttl_seconds = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeString(this.url);
                        if ((this.flags & 1) != 0) {
                            stream2.writeInt32(this.ttl_seconds);
                        }
                    }
                };
                break;
            case 261416433:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaPoll();
                break;
            case 505969924:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaUploadedPhoto();
                break;
            case 547960182:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaLiveStream();
                break;
            case 860303448:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaDocument();
                break;
            case 1530447553:
                tLRPC$TL_inputMediaGeoLive = new TLRPC$TL_inputMediaUploadedDocument();
                break;
            default:
                tLRPC$TL_inputMediaGeoLive = null;
                break;
        }
        if (tLRPC$TL_inputMediaGeoLive == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in InputMedia", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_inputMediaGeoLive != null) {
            tLRPC$TL_inputMediaGeoLive.readParams(stream, exception);
        }
        return tLRPC$TL_inputMediaGeoLive;
    }
}
