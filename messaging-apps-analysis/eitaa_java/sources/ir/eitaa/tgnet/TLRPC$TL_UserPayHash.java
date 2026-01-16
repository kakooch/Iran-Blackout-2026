package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_UserPayHash extends TLObject {
    public static int constructor = -1095770451;
    public int flag;
    public String hash;
    public String voipHostName;
    public String voipPassword;
    public int voipPort;
    public String voipUserName;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flag = stream.readInt32(exception);
        this.hash = stream.readString(exception);
        if ((this.flag & 1) != 0) {
            this.voipHostName = stream.readString(exception);
            this.voipPort = stream.readInt32(exception);
        }
        if ((this.flag & 2) != 0) {
            this.voipUserName = stream.readString(exception);
            this.voipPassword = stream.readString(exception);
        }
    }
}
