package ir.eitaa.tgnet;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class TLRPC$TL_payments_paymentForm extends TLObject {
    public static int constructor = 378828315;
    public long bot_id;
    public boolean can_save_credentials;
    public int flags;
    public long form_id;
    public TLRPC$TL_invoice invoice;
    public TLRPC$TL_dataJSON native_params;
    public String native_provider;
    public boolean password_missing;
    public long provider_id;
    public TLRPC$TL_paymentSavedCredentialsCard saved_credentials;
    public TLRPC$TL_paymentRequestedInfo saved_info;
    public String url;
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_payments_paymentForm TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_payments_paymentForm", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = new TLRPC$TL_payments_paymentForm();
        tLRPC$TL_payments_paymentForm.readParams(stream, exception);
        return tLRPC$TL_payments_paymentForm;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.can_save_credentials = (int32 & 4) != 0;
        this.password_missing = (int32 & 8) != 0;
        this.form_id = stream.readInt64(exception);
        this.bot_id = stream.readInt64(exception);
        this.invoice = TLRPC$TL_invoice.TLdeserialize(stream, stream.readInt32(exception), exception);
        this.provider_id = stream.readInt64(exception);
        this.url = stream.readString(exception);
        if ((this.flags & 16) != 0) {
            this.native_provider = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.native_params = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 1) != 0) {
            this.saved_info = TLRPC$TL_paymentRequestedInfo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 2) != 0) {
            this.saved_credentials = TLRPC$TL_paymentSavedCredentialsCard.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$User tLRPC$UserTLdeserialize = TLRPC$User.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$UserTLdeserialize == null) {
                return;
            }
            this.users.add(tLRPC$UserTLdeserialize);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        int i = this.can_save_credentials ? this.flags | 4 : this.flags & (-5);
        this.flags = i;
        int i2 = this.password_missing ? i | 8 : i & (-9);
        this.flags = i2;
        stream.writeInt32(i2);
        stream.writeInt64(this.form_id);
        stream.writeInt64(this.bot_id);
        this.invoice.serializeToStream(stream);
        stream.writeInt64(this.provider_id);
        stream.writeString(this.url);
        if ((this.flags & 16) != 0) {
            stream.writeString(this.native_provider);
        }
        if ((this.flags & 16) != 0) {
            this.native_params.serializeToStream(stream);
        }
        if ((this.flags & 1) != 0) {
            this.saved_info.serializeToStream(stream);
        }
        if ((this.flags & 2) != 0) {
            this.saved_credentials.serializeToStream(stream);
        }
        stream.writeInt32(481674261);
        int size = this.users.size();
        stream.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.users.get(i3).serializeToStream(stream);
        }
    }
}
