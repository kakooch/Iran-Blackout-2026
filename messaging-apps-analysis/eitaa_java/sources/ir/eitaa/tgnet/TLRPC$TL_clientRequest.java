package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_clientRequest extends TLObject {
    public boolean appPause;
    public int buildVersion;
    public int flags;
    public boolean foregreoundConnection;
    public String imei;
    public boolean isData;
    public boolean isWifi;
    public String lang;
    public int layer;
    public byte[] packed_data;
    public String token;

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        throw null;
    }
}
