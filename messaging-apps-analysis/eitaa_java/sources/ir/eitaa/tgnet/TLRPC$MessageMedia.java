package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public abstract class TLRPC$MessageMedia extends TLObject {
    public String address;
    public TLRPC$Audio audio_unused;
    public byte[] bytes;
    public String captionLegacy;
    public String currency;
    public String description;
    public TLRPC$Document document;
    public String first_name;
    public int flags;
    public TLRPC$TL_game game;
    public TLRPC$GeoPoint geo;
    public int heading;
    public String last_name;
    public int period;
    public String phone_number;
    public TLRPC$Photo photo;
    public String provider;
    public int proximity_notification_radius;
    public int receipt_msg_id;
    public boolean shipping_address_requested;
    public String start_param;
    public boolean test;
    public String title;
    public long total_amount;
    public int ttl_seconds;
    public long user_id;
    public String vcard;
    public String venue_id;
    public String venue_type;
    public TLRPC$Video video_unused;
    public TLRPC$WebPage webpage;

    public static TLRPC$MessageMedia TLdeserialize(AbstractSerializedData stream, int constructor, boolean exception) {
        TLRPC$MessageMedia tLRPC$TL_messageMediaInvoice;
        TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument;
        switch (constructor) {
            case -2074799289:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaInvoice();
                break;
            case -1666158377:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDocument();
                break;
            case -1618676578:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaUnsupported();
                break;
            case -1563278704:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaVideo_layer45() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaVideo_old
                    public static int constructor = -1563278704;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaVideo_layer45, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.video_unused = TLRPC$Video.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaVideo_layer45, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.video_unused.serializeToStream(stream2);
                    }
                };
                break;
            case -1557277184:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaWebPage();
                break;
            case -1256047857:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto_layer74
                    public static int constructor = -1256047857;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        } else {
                            this.photo = new TLRPC$TL_photoEmpty();
                        }
                        if ((this.flags & 2) != 0) {
                            this.captionLegacy = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.ttl_seconds = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            this.photo.serializeToStream(stream2);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.captionLegacy);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.ttl_seconds);
                        }
                    }
                };
                break;
            case -1186937242:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaGeoLive();
                break;
            case -961117440:
                tLRPC$TL_messageMediaInvoice = new TLRPC$MessageMedia() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaAudio_layer45
                    public static int constructor = -961117440;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.audio_unused = TLRPC$Audio.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.audio_unused.serializeToStream(stream2);
                    }
                };
                break;
            case -926655958:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto_old
                    public static int constructor = -926655958;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.photo.serializeToStream(stream2);
                    }
                };
                break;
            case -873313984:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaContact() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaContact_layer131
                    public static int constructor = -873313984;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaContact, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.phone_number = stream2.readString(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.vcard = stream2.readString(exception2);
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaContact, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.phone_number);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeString(this.vcard);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case -873187034:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaLiveStream();
                break;
            case -203411800:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDocument() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument_layer68
                    public static int constructor = -203411800;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.captionLegacy = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.document.serializeToStream(stream2);
                        stream2.writeString(this.captionLegacy);
                    }
                };
                break;
            case -38694904:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaGame();
                break;
            case 694364726:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaUnsupported_old();
                break;
            case 784356159:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaVenue();
                break;
            case 802824708:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDocument() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument_old
                    public static int constructor = 802824708;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.document.serializeToStream(stream2);
                    }
                };
                break;
            case 1032643901:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaPhoto() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto_layer68
                    public static int constructor = 1032643901;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.photo = TLRPC$Photo.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.captionLegacy = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.photo.serializeToStream(stream2);
                        stream2.writeString(this.captionLegacy);
                    }
                };
                break;
            case 1038967584:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaEmpty();
                break;
            case 1065280907:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDice();
                break;
            case 1272375192:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaPoll();
                break;
            case 1457575028:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaGeo();
                break;
            case 1540298357:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaVideo_layer45();
                break;
            case 1585262393:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaContact() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaContact_layer81
                    public static int constructor = 1585262393;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaContact, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.phone_number = stream2.readString(exception2);
                        this.first_name = stream2.readString(exception2);
                        this.last_name = stream2.readString(exception2);
                        this.user_id = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaContact, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeString(this.phone_number);
                        stream2.writeString(this.first_name);
                        stream2.writeString(this.last_name);
                        stream2.writeInt32((int) this.user_id);
                    }
                };
                break;
            case 1670374507:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDice() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaDice_layer111
                    public static int constructor = 1670374507;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDice, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.value = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDice, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.value);
                    }
                };
                break;
            case 1766936791:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaPhoto();
                break;
            case 1882335561:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaContact();
                break;
            case 2031269663:
                tLRPC$TL_messageMediaInvoice = new TLRPC$MessageMedia() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaVenue_layer71
                    public static int constructor = 2031269663;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.title = stream2.readString(exception2);
                        this.address = stream2.readString(exception2);
                        this.provider = stream2.readString(exception2);
                        this.venue_id = stream2.readString(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.geo.serializeToStream(stream2);
                        stream2.writeString(this.title);
                        stream2.writeString(this.address);
                        stream2.writeString(this.provider);
                        stream2.writeString(this.venue_id);
                    }
                };
                break;
            case 2084316681:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaGeoLive() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive_layer119
                    public static int constructor = 2084316681;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        this.geo = TLRPC$GeoPoint.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        this.period = stream2.readInt32(exception2);
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        this.geo.serializeToStream(stream2);
                        stream2.writeInt32(this.period);
                    }
                };
                break;
            case 2084836563:
                tLRPC$TL_messageMediaInvoice = new TLRPC$TL_messageMediaDocument() { // from class: ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument_layer74
                    public static int constructor = 2084836563;

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream2, boolean exception2) {
                        int int32 = stream2.readInt32(exception2);
                        this.flags = int32;
                        if ((int32 & 1) != 0) {
                            this.document = TLRPC$Document.TLdeserialize(stream2, stream2.readInt32(exception2), exception2);
                        } else {
                            this.document = new TLRPC$TL_documentEmpty();
                        }
                        if ((this.flags & 2) != 0) {
                            this.captionLegacy = stream2.readString(exception2);
                        }
                        if ((this.flags & 4) != 0) {
                            this.ttl_seconds = stream2.readInt32(exception2);
                        }
                    }

                    @Override // ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument, ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream2) {
                        stream2.writeInt32(constructor);
                        stream2.writeInt32(this.flags);
                        if ((this.flags & 1) != 0) {
                            this.document.serializeToStream(stream2);
                        }
                        if ((this.flags & 2) != 0) {
                            stream2.writeString(this.captionLegacy);
                        }
                        if ((this.flags & 4) != 0) {
                            stream2.writeInt32(this.ttl_seconds);
                        }
                    }
                };
                break;
            default:
                tLRPC$TL_messageMediaInvoice = null;
                break;
        }
        if (tLRPC$TL_messageMediaInvoice == null && exception) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageMedia", Integer.valueOf(constructor)));
        }
        if (tLRPC$TL_messageMediaInvoice == null) {
            return tLRPC$TL_messageMediaInvoice;
        }
        tLRPC$TL_messageMediaInvoice.readParams(stream, exception);
        if (tLRPC$TL_messageMediaInvoice.video_unused != null) {
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
            if (tLRPC$TL_messageMediaInvoice.video_unused instanceof TLRPC$TL_videoEncrypted) {
                TLRPC$TL_documentEncrypted tLRPC$TL_documentEncrypted = new TLRPC$TL_documentEncrypted();
                tLRPC$TL_messageMediaDocument.document = tLRPC$TL_documentEncrypted;
                TLRPC$Video tLRPC$Video = tLRPC$TL_messageMediaInvoice.video_unused;
                tLRPC$TL_documentEncrypted.key = tLRPC$Video.key;
                tLRPC$TL_documentEncrypted.iv = tLRPC$Video.iv;
            } else {
                tLRPC$TL_messageMediaDocument.document = new TLRPC$TL_document();
            }
            tLRPC$TL_messageMediaDocument.flags = 3;
            TLRPC$Document tLRPC$Document = tLRPC$TL_messageMediaDocument.document;
            tLRPC$Document.file_reference = new byte[0];
            TLRPC$Video tLRPC$Video2 = tLRPC$TL_messageMediaInvoice.video_unused;
            tLRPC$Document.id = tLRPC$Video2.id;
            tLRPC$Document.access_hash = tLRPC$Video2.access_hash;
            tLRPC$Document.date = tLRPC$Video2.date;
            String str = tLRPC$Video2.mime_type;
            if (str != null) {
                tLRPC$Document.mime_type = str;
            } else {
                tLRPC$Document.mime_type = "video/mp4";
            }
            tLRPC$Document.size = tLRPC$Video2.size;
            tLRPC$Document.thumbs.add(tLRPC$Video2.thumb);
            tLRPC$TL_messageMediaDocument.document.dc_id = tLRPC$TL_messageMediaInvoice.video_unused.dc_id;
            tLRPC$TL_messageMediaDocument.captionLegacy = tLRPC$TL_messageMediaInvoice.captionLegacy;
            TLRPC$TL_documentAttributeVideo tLRPC$TL_documentAttributeVideo = new TLRPC$TL_documentAttributeVideo();
            TLRPC$Video tLRPC$Video3 = tLRPC$TL_messageMediaInvoice.video_unused;
            tLRPC$TL_documentAttributeVideo.w = tLRPC$Video3.w;
            tLRPC$TL_documentAttributeVideo.h = tLRPC$Video3.h;
            tLRPC$TL_documentAttributeVideo.duration = tLRPC$Video3.duration;
            tLRPC$TL_messageMediaDocument.document.attributes.add(tLRPC$TL_documentAttributeVideo);
            if (tLRPC$TL_messageMediaDocument.captionLegacy == null) {
                tLRPC$TL_messageMediaDocument.captionLegacy = "";
            }
        } else {
            if (tLRPC$TL_messageMediaInvoice.audio_unused == null) {
                return tLRPC$TL_messageMediaInvoice;
            }
            tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
            if (tLRPC$TL_messageMediaInvoice.audio_unused instanceof TLRPC$TL_audioEncrypted) {
                TLRPC$TL_documentEncrypted tLRPC$TL_documentEncrypted2 = new TLRPC$TL_documentEncrypted();
                tLRPC$TL_messageMediaDocument.document = tLRPC$TL_documentEncrypted2;
                TLRPC$Audio tLRPC$Audio = tLRPC$TL_messageMediaInvoice.audio_unused;
                tLRPC$TL_documentEncrypted2.key = tLRPC$Audio.key;
                tLRPC$TL_documentEncrypted2.iv = tLRPC$Audio.iv;
            } else {
                tLRPC$TL_messageMediaDocument.document = new TLRPC$TL_document();
            }
            tLRPC$TL_messageMediaDocument.flags = 3;
            TLRPC$Document tLRPC$Document2 = tLRPC$TL_messageMediaDocument.document;
            tLRPC$Document2.file_reference = new byte[0];
            TLRPC$Audio tLRPC$Audio2 = tLRPC$TL_messageMediaInvoice.audio_unused;
            tLRPC$Document2.id = tLRPC$Audio2.id;
            tLRPC$Document2.access_hash = tLRPC$Audio2.access_hash;
            tLRPC$Document2.date = tLRPC$Audio2.date;
            String str2 = tLRPC$Audio2.mime_type;
            if (str2 != null) {
                tLRPC$Document2.mime_type = str2;
            } else {
                tLRPC$Document2.mime_type = "audio/ogg";
            }
            tLRPC$Document2.size = tLRPC$Audio2.size;
            TLRPC$TL_photoSizeEmpty tLRPC$TL_photoSizeEmpty = new TLRPC$TL_photoSizeEmpty();
            tLRPC$TL_photoSizeEmpty.type = "s";
            tLRPC$TL_messageMediaDocument.document.thumbs.add(tLRPC$TL_photoSizeEmpty);
            tLRPC$TL_messageMediaDocument.document.dc_id = tLRPC$TL_messageMediaInvoice.audio_unused.dc_id;
            tLRPC$TL_messageMediaDocument.captionLegacy = tLRPC$TL_messageMediaInvoice.captionLegacy;
            TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
            tLRPC$TL_documentAttributeAudio.duration = tLRPC$TL_messageMediaInvoice.audio_unused.duration;
            tLRPC$TL_documentAttributeAudio.voice = true;
            tLRPC$TL_messageMediaDocument.document.attributes.add(tLRPC$TL_documentAttributeAudio);
            if (tLRPC$TL_messageMediaDocument.captionLegacy == null) {
                tLRPC$TL_messageMediaDocument.captionLegacy = "";
            }
        }
        return tLRPC$TL_messageMediaDocument;
    }
}
