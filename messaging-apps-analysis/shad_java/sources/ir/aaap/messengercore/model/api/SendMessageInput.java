package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.AuxDataObject;
import ir.aaap.messengercore.model.ContactMessageObject;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MetaDataObject;
import ir.aaap.messengercore.model.StickerObject;

/* loaded from: classes3.dex */
public class SendMessageInput {
    public AuxDataObject aux_data;
    public FileInlineObject file_inline;
    public boolean is_mute;
    public LiveLocationObject live_location;
    public LocationObject location;
    public ContactMessageObject message_contact;
    public MetaDataObject metadata;
    public String object_guid;
    public Long reply_to_message_id;
    public long rnd;
    public StickerObject sticker;
    public String text;
    public String via_bot_guid;
}
