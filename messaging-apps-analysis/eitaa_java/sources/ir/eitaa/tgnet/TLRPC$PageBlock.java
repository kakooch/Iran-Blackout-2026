package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$PageBlock extends TLObject {
    public boolean bottom;
    public boolean first;
    public int groupId;
    public int level;
    public int mid;
    public TLRPC$PhotoSize thumb;
    public TLObject thumbObject;

    public static TLRPC$PageBlock TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$PageBlock tLRPC$TL_pageBlockAudio;
        switch (constructor) {
            case -2143067670:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockAudio();
                break;
            case -1879401953:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockSubtitle();
                break;
            case -1702174239:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockOrderedList();
                break;
            case -1538310410:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockMap();
                break;
            case -1468953147:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockEmbed();
                break;
            case -1162877472:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockAuthorDate();
                break;
            case -1085412734:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockTable();
                break;
            case -1076861716:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockHeader();
                break;
            case -1066346178:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockPreformatted();
                break;
            case -840826671:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockEmbed() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed_layer82
                    public static int constructor = -840826671;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.full_width = (int32 & 1) != 0;
                        this.allow_scrolling = (int32 & 8) != 0;
                        if ((int32 & 2) != 0) {
                            this.url = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.html = stream2.readString(exception2);
                        }
                        if ((this.flags & 16) != 0) {
                            this.poster_photo_id = stream2.readInt64(exception2);
                        }
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.full_width ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.allow_scrolling ? i | 8 : i & (-9);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.url);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.html);
                        }
                        if ((this.flags & 16) != 0) {
                            stream2.writeInt64(this.poster_photo_id);
                        }
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case -837994576:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockAnchor();
                break;
            case -650782469:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockEmbed() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed_layer60
                    public static int constructor = -650782469;
                    public boolean allow_scrolling;
                    public TLRPC$RichText caption;
                    public int flags;
                    public boolean full_width;
                    public int h;
                    public String html;
                    public String url;
                    public int w;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.full_width = (int32 & 1) != 0;
                        this.allow_scrolling = (int32 & 8) != 0;
                        if ((int32 & 2) != 0) {
                            this.url = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.html = stream2.readString(exception2);
                        }
                        this.w = stream2.readInt32(exception2);
                        this.h = stream2.readInt32(exception2);
                        this.caption = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbed, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.full_width ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.allow_scrolling ? i | 8 : i & (-9);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.url);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeString(this.html);
                        }
                        stream2.writeInt32(this.w);
                        stream2.writeInt32(this.h);
                        this.caption.serializeToStream(stream2);
                    }
                };
                break;
            case -640214938:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockVideo() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockVideo_layer82
                    public static int constructor = -640214938;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockVideo, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        this.autoplay = (int32 & 1) != 0;
                        this.loop = (int32 & 2) != 0;
                        this.video_id = stream2.readInt64(exception2);
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockVideo, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        int i = this.autoplay ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        int i2 = this.loop ? i | 2 : i & (-3);
                        this.flags = i2;
                        stream2.writeInt32(i2);
                        stream2.writeInt64(this.video_id);
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case -618614392:
                tLRPC$TL_pageBlockAudio = new TLRPC$PageBlock() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockDivider
                    public static int constructor = -618614392;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case -454524911:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockList();
                break;
            case -372860542:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto_layer82
                    public static int constructor = -372860542;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo_id = stream2.readInt64(exception2);
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.photo_id);
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case -283684427:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockChannel();
                break;
            case -248793375:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockSubheader();
                break;
            case -229005301:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockEmbedPost();
                break;
            case 52401552:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockSlideshow();
                break;
            case 145955919:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockCollage() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockCollage_layer82
                    public static int constructor = 145955919;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockCollage, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.items.add(tLRPC$PageBlockTLdeserialize);
                        }
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockCollage, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.items.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.items.get(i).serializeToStream(stream2);
                        }
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case 319588707:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockSlideshow() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockSlideshow_layer82
                    public static int constructor = 319588707;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockSlideshow, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.items.add(tLRPC$PageBlockTLdeserialize);
                        }
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockSlideshow, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(481674261);
                        int size = this.items.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.items.get(i).serializeToStream(stream2);
                        }
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case 324435594:
                tLRPC$TL_pageBlockAudio = new TLRPC$PageBlock() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockUnsupported
                    public static int constructor = 324435594;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                    }
                };
                break;
            case 370236054:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockRelatedArticles();
                break;
            case 391759200:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockPhoto();
                break;
            case 504660880:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockKicker();
                break;
            case 641563686:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockBlockquote();
                break;
            case 690781161:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockEmbedPost() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbedPost_layer82
                    public static int constructor = 690781161;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbedPost, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.url = stream2.readString(exception2);
                        this.webpage_id = stream2.readInt64(exception2);
                        this.author_photo_id = stream2.readInt64(exception2);
                        this.author = stream2.readString(exception2);
                        this.date = stream2.readInt32(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$PageBlock tLRPC$PageBlockTLdeserialize = TLRPC$PageBlock.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$PageBlockTLdeserialize == null) {
                                return;
                            }
                            this.blocks.add(tLRPC$PageBlockTLdeserialize);
                        }
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockEmbedPost, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.url);
                        stream2.writeInt64(this.webpage_id);
                        stream2.writeInt64(this.author_photo_id);
                        stream2.writeString(this.author);
                        stream2.writeInt32(this.date);
                        stream2.writeInt32(481674261);
                        int size = this.blocks.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            this.blocks.get(i).serializeToStream(stream2);
                        }
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case 834148991:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockAudio() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockAudio_layer82
                    public static int constructor = 834148991;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockAudio, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.audio_id = stream2.readInt64(exception2);
                        TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
                        this.caption = tLRPC$TL_pageCaption;
                        tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.caption.credit = new TLRPC$TL_textEmpty();
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockAudio, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt64(this.audio_id);
                        this.caption.text.serializeToStream(stream2);
                    }
                };
                break;
            case 972174080:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockCover();
                break;
            case 978896884:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockList() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockList_layer82
                    public static int constructor = 978896884;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockList, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.ordered = stream2.readBool(exception2);
                        int int32 = stream2.readInt32(exception2);
                        if (int32 != 481674261) {
                            if (exception2) {
                                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int32)));
                            }
                            return;
                        }
                        int int322 = stream2.readInt32(exception2);
                        for (int i = 0; i < int322; i++) {
                            TLRPC$RichText tLRPC$RichTextTLdeserialize = TLRPC$RichText.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                            if (tLRPC$RichTextTLdeserialize == null) {
                                return;
                            }
                            TLRPC$TL_pageListItemText tLRPC$TL_pageListItemText = new TLRPC$TL_pageListItemText();
                            tLRPC$TL_pageListItemText.text = tLRPC$RichTextTLdeserialize;
                            this.items.add(tLRPC$TL_pageListItemText);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockList, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeBool(this.ordered);
                        stream2.writeInt32(481674261);
                        int size = this.items.size();
                        stream2.writeInt32(size);
                        for (int i = 0; i < size; i++) {
                            ((TLRPC$TL_pageListItemText) this.items.get(i)).text.serializeToStream(stream2);
                        }
                    }
                };
                break;
            case 1029399794:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockAuthorDate() { // from class: ir.eitaa.tgnet.TLRPC$TL_pageBlockAuthorDate_layer60
                    public static int constructor = 1029399794;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockAuthorDate, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        String string = stream2.readString(exception2);
                        TLRPC$TL_textPlain tLRPC$TL_textPlain = new TLRPC$TL_textPlain();
                        this.author = tLRPC$TL_textPlain;
                        tLRPC$TL_textPlain.text = string;
                        this.published_date = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_pageBlockAuthorDate, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(((TLRPC$TL_textPlain) this.author).text);
                        stream2.writeInt32(this.published_date);
                    }
                };
                break;
            case 1182402406:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockParagraph();
                break;
            case 1216809369:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockFooter();
                break;
            case 1329878739:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockPullquote();
                break;
            case 1705048653:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockCollage();
                break;
            case 1890305021:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockTitle();
                break;
            case 1987480557:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockDetails();
                break;
            case 2089805750:
                tLRPC$TL_pageBlockAudio = new TLRPC$TL_pageBlockVideo();
                break;
            default:
                tLRPC$TL_pageBlockAudio = null;
                break;
        }
        if (tLRPC$TL_pageBlockAudio == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in PageBlock", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_pageBlockAudio != null) {
            tLRPC$TL_pageBlockAudio.readParams(stream, exception);
        }
        return tLRPC$TL_pageBlockAudio;
    }
}
