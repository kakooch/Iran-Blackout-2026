package org.rbmain.tgnet;

import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes4.dex */
public abstract class TLRPC$PhoneCall extends TLObject {
    public long access_hash;
    public int admin_id;
    public int date;
    public int duration;
    public int flags;
    public byte[] g_a_hash;
    public byte[] g_a_or_b;
    public byte[] g_b;
    public String id;
    public String key;
    public long key_fingerprint;
    public boolean need_debug;
    public boolean need_rating;
    public boolean p2p_allowed;
    public int participant_id;
    public TLRPC$PhoneCallProtocol protocol;
    public TLRPC$PhoneCallDiscardReason reason;
    public int receive_date;
    public int start_date;
    public int timestamp;
    public boolean video;
    public ArrayList<TLRPC$PhoneConnection> connections = new ArrayList<>();
    public HashMap<String, Integer> updatedTimeStampMap = new HashMap<>();

    public static TLRPC$PhoneCall TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$PhoneCall tLRPC$TL_phoneCall;
        switch (i) {
            case -2025673089:
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCall();
                break;
            case -2014659757:
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallRequested();
                break;
            case -1719909046:
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallAccepted();
                break;
            case 462375633:
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
                break;
            case 1355435489:
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallDiscarded();
                break;
            case 1399245077:
                tLRPC$TL_phoneCall = new TLRPC$PhoneCall() { // from class: org.rbmain.tgnet.TLRPC$TL_phoneCallEmpty
                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData2, boolean z2) {
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData2) {
                    }
                };
                break;
            default:
                tLRPC$TL_phoneCall = null;
                break;
        }
        if (tLRPC$TL_phoneCall == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PhoneCall", Integer.valueOf(i)));
        }
        if (tLRPC$TL_phoneCall != null) {
            tLRPC$TL_phoneCall.readParams(abstractSerializedData, z);
        }
        return tLRPC$TL_phoneCall;
    }

    public Object clone() throws CloneNotSupportedException {
        TLRPC$PhoneCall tLRPC$TL_phoneCall;
        if (this instanceof TLRPC$TL_phoneCallRequested) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallRequested();
        } else if (this instanceof TLRPC$TL_phoneCallWaiting) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
        } else if (this instanceof TLRPC$TL_phoneCallAccepted) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallAccepted();
        } else if (this instanceof TLRPC$TL_phoneCallDiscarded) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallDiscarded();
        } else {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCall();
        }
        cloneFields(tLRPC$TL_phoneCall);
        return tLRPC$TL_phoneCall;
    }

    public void cloneFields(TLRPC$PhoneCall tLRPC$PhoneCall) {
        if (tLRPC$PhoneCall == null) {
            return;
        }
        tLRPC$PhoneCall.flags = this.flags;
        tLRPC$PhoneCall.p2p_allowed = this.p2p_allowed;
        tLRPC$PhoneCall.id = this.id;
        tLRPC$PhoneCall.access_hash = this.access_hash;
        tLRPC$PhoneCall.date = this.date;
        tLRPC$PhoneCall.admin_id = this.admin_id;
        tLRPC$PhoneCall.participant_id = this.participant_id;
        tLRPC$PhoneCall.g_a_or_b = this.g_a_or_b;
        tLRPC$PhoneCall.key_fingerprint = this.key_fingerprint;
        tLRPC$PhoneCall.protocol = this.protocol;
        tLRPC$PhoneCall.connections = this.connections;
        tLRPC$PhoneCall.need_rating = this.need_rating;
        tLRPC$PhoneCall.start_date = this.start_date;
        tLRPC$PhoneCall.need_debug = this.need_debug;
        tLRPC$PhoneCall.video = this.video;
        tLRPC$PhoneCall.reason = this.reason;
        tLRPC$PhoneCall.duration = this.duration;
        tLRPC$PhoneCall.g_a_hash = this.g_a_hash;
        tLRPC$PhoneCall.g_b = this.g_b;
        tLRPC$PhoneCall.receive_date = this.receive_date;
        tLRPC$PhoneCall.key = this.key;
        tLRPC$PhoneCall.updatedTimeStampMap = this.updatedTimeStampMap;
        tLRPC$PhoneCall.timestamp = this.timestamp;
    }
}
