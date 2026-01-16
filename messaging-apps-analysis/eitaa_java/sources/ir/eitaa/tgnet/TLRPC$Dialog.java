package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$Dialog extends TLObject {
    public TLRPC$DraftMessage draft;
    public int flags;
    public int folder_id;
    public long id;
    public boolean isLocked = false;
    public int last_message_date;
    public TLRPC$PeerNotifySettings notify_settings;
    public TLRPC$Peer peer;
    public boolean pinned;
    public int pinnedNum;
    public int pts;
    public int read_inbox_max_id;
    public int read_outbox_max_id;
    public int top_message;
    public int unread_count;
    public boolean unread_mark;
    public int unread_mentions_count;

    public static TLRPC$Dialog TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$Dialog tLRPC$TL_dialog;
        if (constructor == 739712882) {
            tLRPC$TL_dialog = new TLRPC$TL_dialog();
        } else {
            tLRPC$TL_dialog = constructor != 1908216652 ? null : new TLRPC$TL_dialogFolder();
        }
        if (tLRPC$TL_dialog == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in Dialog", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_dialog != null) {
            tLRPC$TL_dialog.readParams(stream, exception);
        }
        return tLRPC$TL_dialog;
    }
}
