package ir.eitaa.tgnet;

import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_webPage extends TLRPC$WebPage {
    public static int constructor = -392411726;

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        this.flags = stream.readInt32(exception);
        this.id = stream.readInt64(exception);
        this.url = stream.readString(exception);
        this.display_url = stream.readString(exception);
        this.hash = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.type = stream.readString(exception);
        }
        if ((this.flags & 2) != 0) {
            this.site_name = stream.readString(exception);
        }
        if ((this.flags & 4) != 0) {
            this.title = stream.readString(exception);
        }
        if ((this.flags & 8) != 0) {
            this.description = stream.readString(exception);
        }
        if ((this.flags & 16) != 0) {
            this.photo = TLRPC$Photo.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 32) != 0) {
            this.embed_url = stream.readString(exception);
        }
        if ((this.flags & 32) != 0) {
            this.embed_type = stream.readString(exception);
        }
        if ((this.flags & 64) != 0) {
            this.embed_width = stream.readInt32(exception);
        }
        if ((this.flags & 64) != 0) {
            this.embed_height = stream.readInt32(exception);
        }
        if ((this.flags & 128) != 0) {
            this.duration = stream.readInt32(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.author = stream.readString(exception);
        }
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.document = TLRPC$Document.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.cached_page = TLRPC$Page.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            int int32 = stream.readInt32(exception);
            if (int32 != 481674261) {
                if (exception) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                }
                return;
            }
            int int322 = stream.readInt32(exception);
            for (int i = 0; i < int322; i++) {
                TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeThemeTLdeserialize = TLRPC$TL_webPageAttributeTheme.TLdeserialize(stream, stream.readInt32(exception), exception);
                if (tLRPC$TL_webPageAttributeThemeTLdeserialize == null) {
                    return;
                }
                this.attributes.add(tLRPC$TL_webPageAttributeThemeTLdeserialize);
            }
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        stream.writeInt32(constructor);
        stream.writeInt32(this.flags);
        stream.writeInt64(this.id);
        stream.writeString(this.url);
        stream.writeString(this.display_url);
        stream.writeInt32(this.hash);
        if ((this.flags & 1) != 0) {
            stream.writeString(this.type);
        }
        if ((this.flags & 2) != 0) {
            stream.writeString(this.site_name);
        }
        if ((this.flags & 4) != 0) {
            stream.writeString(this.title);
        }
        if ((this.flags & 8) != 0) {
            stream.writeString(this.description);
        }
        if ((this.flags & 16) != 0) {
            this.photo.serializeToStream(stream);
        }
        if ((this.flags & 32) != 0) {
            stream.writeString(this.embed_url);
        }
        if ((this.flags & 32) != 0) {
            stream.writeString(this.embed_type);
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.embed_width);
        }
        if ((this.flags & 64) != 0) {
            stream.writeInt32(this.embed_height);
        }
        if ((this.flags & 128) != 0) {
            stream.writeInt32(this.duration);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            stream.writeString(this.author);
        }
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.document.serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.cached_page.serializeToStream(stream);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            stream.writeInt32(481674261);
            int size = this.attributes.size();
            stream.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.attributes.get(i).serializeToStream(stream);
            }
        }
    }
}
