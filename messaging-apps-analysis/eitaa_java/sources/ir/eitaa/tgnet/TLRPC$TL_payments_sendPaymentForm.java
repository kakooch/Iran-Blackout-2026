package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_sendPaymentForm extends TLObject {
    public static int constructor = 818134173;
    public TLRPC$InputPaymentCredentials credentials;
    public int flags;
    public long form_id;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public String requested_info_id;
    public String shipping_option_id;
    public long tip_amount;

    @Override // ir.eitaa.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
        return TLRPC$payments_PaymentResult.TLdeserialize(stream, constructor2, exception);
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.form_id);
        this.peer.serializeToStream(stream);
        stream.writeInt32(this.msg_id);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.requested_info_id);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.shipping_option_id);
        }
        this.credentials.serializeToStream(stream);
        if ((this.flags & 4) != 0) {
            stream.writeInt64(this.tip_amount);
        }
    }
}
