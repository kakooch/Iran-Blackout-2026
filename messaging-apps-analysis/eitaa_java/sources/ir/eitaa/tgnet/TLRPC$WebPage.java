package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public abstract class TLRPC$WebPage extends TLObject {
    public ArrayList<TLRPC$TL_webPageAttributeTheme> attributes = new ArrayList<>();
    public String author;
    public TLRPC$Page cached_page;
    public int date;
    public String description;
    public String display_url;
    public TLRPC$Document document;
    public int duration;
    public int embed_height;
    public String embed_type;
    public String embed_url;
    public int embed_width;
    public int flags;
    public int hash;
    public long id;
    public TLRPC$Photo photo;
    public String site_name;
    public String title;
    public String type;
    public String url;

    public static TLRPC$WebPage TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$WebPage tLRPC$TL_webPagePending;
        switch (constructor) {
            case -2054908813:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPageNotModified() { // from class: ir.eitaa.tgnet.TLRPC$TL_webPageNotModified_layer110
                    public static int constructor = -2054908813;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPageNotModified, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -1558273867:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPage() { // from class: ir.eitaa.tgnet.TLRPC$TL_webPage_old
                    public static int constructor = -1558273867;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt64(exception2);
                        this.url = stream2.readString(exception2);
                        this.display_url = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.type = stream2.readString(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.site_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.title = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.description = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_url = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_type = stream2.readString(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_width = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_height = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.author = stream2.readString(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.id);
                        stream2.writeString(this.url);
                        stream2.writeString(this.display_url);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.type);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.site_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.title);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.description);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_url);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_type);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_width);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_height);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeString(this.author);
                        }
                    }
                };
                break;
            case -981018084:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPagePending();
                break;
            case -897446185:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPage() { // from class: ir.eitaa.tgnet.TLRPC$TL_webPage_layer58
                    public static int constructor = -897446185;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt64(exception2);
                        this.url = stream2.readString(exception2);
                        this.display_url = stream2.readString(exception2);
                        if ((this.flags & 1) != 0) {
                            this.type = stream2.readString(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.site_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.title = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.description = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_url = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_type = stream2.readString(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_width = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_height = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.author = stream2.readString(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.id);
                        stream2.writeString(this.url);
                        stream2.writeString(this.display_url);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.type);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.site_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.title);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.description);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_url);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_type);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_width);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_height);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeString(this.author);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case -736472729:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPageUrlPending();
                break;
            case -392411726:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPage();
                break;
            case -350980120:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPageEmpty();
                break;
            case -94051982:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPage() { // from class: ir.eitaa.tgnet.TLRPC$TL_webPage_layer107
                    public static int constructor = -94051982;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt64(exception2);
                        this.url = stream2.readString(exception2);
                        this.display_url = stream2.readString(exception2);
                        this.hash = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.type = stream2.readString(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.site_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.title = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.description = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_url = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_type = stream2.readString(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_width = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_height = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.author = stream2.readString(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            int int32 = stream2.readInt32(exception2);
                            if (int32 != 481674261) {
                                if (exception2) {
                                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                                }
                                return;
                            }
                            TLRPC$TL_webPageAttributeTheme tLRPC$TL_webPageAttributeTheme = new TLRPC$TL_webPageAttributeTheme();
                            int int322 = stream2.readInt32(exception2);
                            for (int i = 0; i < int322; i++) {
                                TLRPC$Document tLRPC$DocumentTLdeserialize = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                                if (tLRPC$DocumentTLdeserialize == null) {
                                    return;
                                }
                                tLRPC$TL_webPageAttributeTheme.documents.add(tLRPC$DocumentTLdeserialize);
                            }
                            this.attributes.add(tLRPC$TL_webPageAttributeTheme);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.cached_page = TLRPC$Page.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.id);
                        stream2.writeString(this.url);
                        stream2.writeString(this.display_url);
                        stream2.writeInt32(this.hash);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.type);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.site_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.title);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.description);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_url);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_type);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_width);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_height);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeString(this.author);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
                            stream2.writeInt32(481674261);
                            stream2.writeInt32(0);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.cached_page.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1594340540:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPage() { // from class: ir.eitaa.tgnet.TLRPC$TL_webPage_layer104
                    public static int constructor = 1594340540;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.flags = stream2.readInt32(exception2);
                        this.id = stream2.readInt64(exception2);
                        this.url = stream2.readString(exception2);
                        this.display_url = stream2.readString(exception2);
                        this.hash = stream2.readInt32(exception2);
                        if ((this.flags & 1) != 0) {
                            this.type = stream2.readString(exception2);
                        }
                        if ((this.flags & 2) != 0) {
                            this.site_name = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.title = stream2.readString(exception2);
                        }
                        if ((this.flags & 8) != 0) {
                            this.description = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_url = stream2.readString(exception2);
                        }
                        if ((this.flags & 32) != 0) {
                            this.embed_type = stream2.readString(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_width = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 64) != 0) {
                            this.embed_height = stream2.readInt32(exception2);
                        }
                        if ((this.flags & 128) != 0) {
                            this.duration = stream2.readInt32(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            this.author = stream2.readString(exception2);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.cached_page = TLRPC$Page.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_webPage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        stream2.writeInt64(this.id);
                        stream2.writeString(this.url);
                        stream2.writeString(this.display_url);
                        stream2.writeInt32(this.hash);
                        if ((this.flags & 1) != 0) {
                            stream2.writeString(this.type);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.site_name);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.title);
                        }
                        if ((this.flags & 8) != 0) {
                            stream2.writeString(this.description);
                        }
                        if ((this.flags & 16) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_url);
                        }
                        if ((this.flags & 32) != 0) {
                            stream2.writeString(this.embed_type);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_width);
                        }
                        if ((this.flags & 64) != 0) {
                            stream2.writeInt32(this.embed_height);
                        }
                        if ((this.flags & 128) != 0) {
                            stream2.writeInt32(this.duration);
                        }
                        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
                            stream2.writeString(this.author);
                        }
                        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                            this.cached_page.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1930545681:
                tLRPC$TL_webPagePending = new TLRPC$TL_webPageNotModified();
                break;
            default:
                tLRPC$TL_webPagePending = null;
                break;
        }
        if (tLRPC$TL_webPagePending == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in WebPage", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_webPagePending != null) {
            tLRPC$TL_webPagePending.readParams(stream, exception);
        }
        return tLRPC$TL_webPagePending;
    }
}
