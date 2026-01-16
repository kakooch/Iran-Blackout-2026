package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_report_getReasons extends TLObject {
    public static int constructor = 792077194;
    public String lang;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        TLRPC$Vector tLRPC$Vector = new TLRPC$Vector();
        int int32 = stream.readInt32(exception);
        int i = 0;
        while (true) {
            if (i >= int32) {
                break;
            }
            if (stream.readInt32(exception) == TLRPC$TL_report_reason.constructor) {
                TLRPC$TL_report_reason tLRPC$TL_report_reason = new TLRPC$TL_report_reason();
                tLRPC$TL_report_reason.readParams(stream, exception);
                tLRPC$Vector.objects.add(tLRPC$TL_report_reason);
                i++;
            } else if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_report_getReasons", Integer.valueOf(constructor2)));
            }
        }
        return tLRPC$Vector;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeString(this.lang);
    }
}
