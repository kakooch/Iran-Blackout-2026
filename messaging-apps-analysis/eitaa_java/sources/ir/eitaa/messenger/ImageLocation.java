package ir.eitaa.messenger;

import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_photoPathSize;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$TL_secureFile;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes.dex */
public class ImageLocation {
    public static final int TYPE_BIG = 0;
    public static final int TYPE_SMALL = 1;
    public static final int TYPE_STRIPPED = 2;
    public long access_hash;
    public int currentSize;
    public int dc_id;
    public TLRPC$Document document;
    public long documentId;
    public byte[] file_reference;
    public int imageType;
    public byte[] iv;
    public byte[] key;
    public TLRPC$TL_fileLocationToBeDeprecated location;
    public String path;
    public TLRPC$Photo photo;
    public long photoId;
    public TLRPC$InputPeer photoPeer;
    public int photoPeerType;
    public TLRPC$PhotoSize photoSize;
    public SecureDocument secureDocument;
    public TLRPC$InputStickerSet stickerSet;
    public String thumbSize;
    public int thumbVersion;
    public long videoSeekTo;
    public WebFile webFile;

    public static ImageLocation getForPath(String path) {
        if (path == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.path = path;
        return imageLocation;
    }

    public static ImageLocation getForSecureDocument(SecureDocument secureDocument) {
        if (secureDocument == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.secureDocument = secureDocument;
        return imageLocation;
    }

    public static ImageLocation getForDocument(TLRPC$Document document) {
        if (document == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.document = document;
        imageLocation.key = document.key;
        imageLocation.iv = document.iv;
        imageLocation.currentSize = document.size;
        return imageLocation;
    }

    public static ImageLocation getForWebFile(WebFile webFile) {
        if (webFile == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.webFile = webFile;
        imageLocation.currentSize = webFile.size;
        return imageLocation;
    }

    public static ImageLocation getForObject(TLRPC$PhotoSize photoSize, TLObject object) {
        if (object instanceof TLRPC$Photo) {
            return getForPhoto(photoSize, (TLRPC$Photo) object);
        }
        if (object instanceof TLRPC$Document) {
            return getForDocument(photoSize, (TLRPC$Document) object);
        }
        return null;
    }

    public static ImageLocation getForPhoto(TLRPC$PhotoSize photoSize, TLRPC$Photo photo) {
        if ((photoSize instanceof TLRPC$TL_photoStrippedSize) || (photoSize instanceof TLRPC$TL_photoPathSize)) {
            ImageLocation imageLocation = new ImageLocation();
            imageLocation.photoSize = photoSize;
            return imageLocation;
        }
        if (photoSize == null || photo == null) {
            return null;
        }
        int i = photo.dc_id;
        if (i == 0) {
            i = photoSize.location.dc_id;
        }
        return getForPhoto(photoSize.location, photoSize.size, photo, null, null, 1, i, null, photoSize.type);
    }

    public static ImageLocation getForUserOrChat(TLObject object, int type) {
        if (object instanceof TLRPC$User) {
            return getForUser((TLRPC$User) object, type);
        }
        if (object instanceof TLRPC$Chat) {
            return getForChat((TLRPC$Chat) object, type);
        }
        return null;
    }

    public static ImageLocation getForUser(TLRPC$User user, int type) {
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        if (user == null || user.access_hash == 0 || (tLRPC$UserProfilePhoto = user.photo) == null) {
            return null;
        }
        if (type == 2) {
            if (tLRPC$UserProfilePhoto.stripped_thumb == null) {
                return null;
            }
            ImageLocation imageLocation = new ImageLocation();
            TLRPC$TL_photoStrippedSize tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoStrippedSize();
            imageLocation.photoSize = tLRPC$TL_photoStrippedSize;
            tLRPC$TL_photoStrippedSize.type = "s";
            tLRPC$TL_photoStrippedSize.bytes = user.photo.stripped_thumb;
            return imageLocation;
        }
        TLRPC$FileLocation tLRPC$FileLocation = type == 0 ? tLRPC$UserProfilePhoto.photo_big : tLRPC$UserProfilePhoto.photo_small;
        if (tLRPC$FileLocation == null) {
            return null;
        }
        TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
        tLRPC$TL_inputPeerUser.user_id = user.id;
        tLRPC$TL_inputPeerUser.access_hash = user.access_hash;
        int i = user.photo.dc_id;
        if (i == 0) {
            i = tLRPC$FileLocation.dc_id;
        }
        ImageLocation forPhoto = getForPhoto(tLRPC$FileLocation, 0, null, null, tLRPC$TL_inputPeerUser, type, i, null, null);
        forPhoto.photoId = user.photo.photo_id;
        return forPhoto;
    }

    public static ImageLocation getForChat(TLRPC$Chat chat, int type) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$InputPeer tLRPC$TL_inputPeerChat;
        if (chat == null || (tLRPC$ChatPhoto = chat.photo) == null) {
            return null;
        }
        if (type == 2) {
            if (tLRPC$ChatPhoto.stripped_thumb == null) {
                return null;
            }
            ImageLocation imageLocation = new ImageLocation();
            TLRPC$TL_photoStrippedSize tLRPC$TL_photoStrippedSize = new TLRPC$TL_photoStrippedSize();
            imageLocation.photoSize = tLRPC$TL_photoStrippedSize;
            tLRPC$TL_photoStrippedSize.type = "s";
            tLRPC$TL_photoStrippedSize.bytes = chat.photo.stripped_thumb;
            return imageLocation;
        }
        TLRPC$FileLocation tLRPC$FileLocation = type == 0 ? tLRPC$ChatPhoto.photo_big : tLRPC$ChatPhoto.photo_small;
        if (tLRPC$FileLocation == null) {
            return null;
        }
        if (!ChatObject.isChannel(chat)) {
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChat();
            tLRPC$TL_inputPeerChat.chat_id = chat.id;
        } else {
            if (chat.access_hash == 0) {
                return null;
            }
            tLRPC$TL_inputPeerChat = new TLRPC$TL_inputPeerChannel();
            tLRPC$TL_inputPeerChat.channel_id = chat.id;
            tLRPC$TL_inputPeerChat.access_hash = chat.access_hash;
        }
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_inputPeerChat;
        int i = chat.photo.dc_id;
        if (i == 0) {
            i = tLRPC$FileLocation.dc_id;
        }
        ImageLocation forPhoto = getForPhoto(tLRPC$FileLocation, 0, null, null, tLRPC$InputPeer, type, i, null, null);
        forPhoto.photoId = chat.photo.photo_id;
        return forPhoto;
    }

    public static ImageLocation getForSticker(TLRPC$PhotoSize photoSize, TLRPC$Document sticker, int thumbVersion) {
        TLRPC$InputStickerSet inputStickerSet;
        if ((photoSize instanceof TLRPC$TL_photoStrippedSize) || (photoSize instanceof TLRPC$TL_photoPathSize)) {
            ImageLocation imageLocation = new ImageLocation();
            imageLocation.photoSize = photoSize;
            return imageLocation;
        }
        if (photoSize == null || sticker == null || (inputStickerSet = MediaDataController.getInputStickerSet(sticker)) == null) {
            return null;
        }
        ImageLocation forPhoto = getForPhoto(photoSize.location, photoSize.size, null, null, null, 1, sticker.dc_id, inputStickerSet, photoSize.type);
        if (MessageObject.isAnimatedStickerDocument(sticker, true)) {
            forPhoto.imageType = 1;
        }
        forPhoto.thumbVersion = thumbVersion;
        return forPhoto;
    }

    public static ImageLocation getForDocument(TLRPC$VideoSize videoSize, TLRPC$Document document) {
        if (videoSize == null || document == null) {
            return null;
        }
        ImageLocation forPhoto = getForPhoto(videoSize.location, videoSize.size, null, document, null, 1, document.dc_id, null, videoSize.type);
        forPhoto.imageType = 2;
        return forPhoto;
    }

    public static ImageLocation getForPhoto(TLRPC$VideoSize videoSize, TLRPC$Photo photo) {
        if (videoSize == null || photo == null) {
            return null;
        }
        ImageLocation forPhoto = getForPhoto(videoSize.location, videoSize.size, photo, null, null, 1, photo.dc_id, null, videoSize.type);
        forPhoto.imageType = 2;
        if ((videoSize.flags & 1) != 0) {
            forPhoto.videoSeekTo = (int) (videoSize.video_start_ts * 1000.0d);
        }
        return forPhoto;
    }

    public static ImageLocation getForDocument(TLRPC$PhotoSize photoSize, TLRPC$Document document) {
        if ((photoSize instanceof TLRPC$TL_photoStrippedSize) || (photoSize instanceof TLRPC$TL_photoPathSize)) {
            ImageLocation imageLocation = new ImageLocation();
            imageLocation.photoSize = photoSize;
            return imageLocation;
        }
        if (photoSize == null || document == null) {
            return null;
        }
        return getForPhoto(photoSize.location, photoSize.size, null, document, null, 1, document.dc_id, null, photoSize.type);
    }

    public static ImageLocation getForLocal(TLRPC$FileLocation location) {
        if (location == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        imageLocation.location = tLRPC$TL_fileLocationToBeDeprecated;
        tLRPC$TL_fileLocationToBeDeprecated.local_id = location.local_id;
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = location.volume_id;
        tLRPC$TL_fileLocationToBeDeprecated.secret = location.secret;
        tLRPC$TL_fileLocationToBeDeprecated.dc_id = location.dc_id;
        imageLocation.dc_id = 1;
        return imageLocation;
    }

    private static ImageLocation getForPhoto(TLRPC$FileLocation location, int size, TLRPC$Photo photo, TLRPC$Document document, TLRPC$InputPeer photoPeer, int photoPeerType, int dc_id, TLRPC$InputStickerSet stickerSet, String thumbSize) {
        if (location == null) {
            return null;
        }
        if (photo == null && photoPeer == null && stickerSet == null && document == null) {
            return null;
        }
        ImageLocation imageLocation = new ImageLocation();
        imageLocation.dc_id = dc_id;
        imageLocation.photo = photo;
        imageLocation.currentSize = size;
        imageLocation.photoPeer = photoPeer;
        imageLocation.photoPeerType = photoPeerType;
        imageLocation.stickerSet = stickerSet;
        if (location instanceof TLRPC$TL_fileLocationToBeDeprecated) {
            imageLocation.location = (TLRPC$TL_fileLocationToBeDeprecated) location;
            if (photo != null) {
                imageLocation.file_reference = photo.file_reference;
                imageLocation.access_hash = photo.access_hash;
                imageLocation.photoId = photo.id;
                imageLocation.thumbSize = thumbSize;
            } else if (document != null) {
                imageLocation.file_reference = document.file_reference;
                imageLocation.access_hash = document.access_hash;
                imageLocation.documentId = document.id;
                imageLocation.thumbSize = thumbSize;
            }
        } else {
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
            imageLocation.location = tLRPC$TL_fileLocationToBeDeprecated;
            tLRPC$TL_fileLocationToBeDeprecated.local_id = location.local_id;
            tLRPC$TL_fileLocationToBeDeprecated.volume_id = location.volume_id;
            tLRPC$TL_fileLocationToBeDeprecated.secret = location.secret;
            imageLocation.dc_id = location.dc_id;
            imageLocation.file_reference = location.file_reference;
            imageLocation.key = location.key;
            imageLocation.iv = location.iv;
            imageLocation.access_hash = location.secret;
        }
        return imageLocation;
    }

    public static String getStippedKey(Object parentObject, Object fullObject, Object strippedObject) {
        if (parentObject instanceof TLRPC$WebPage) {
            if (fullObject instanceof ImageLocation) {
                ImageLocation imageLocation = (ImageLocation) fullObject;
                Object obj = imageLocation.document;
                if (obj == null && (obj = imageLocation.photoSize) == null) {
                    TLRPC$Photo tLRPC$Photo = imageLocation.photo;
                    if (tLRPC$Photo != null) {
                        fullObject = tLRPC$Photo;
                    }
                } else {
                    fullObject = obj;
                }
            }
            if (fullObject == null) {
                return "stripped" + FileRefController.getKeyForParentObject(parentObject) + "_" + strippedObject;
            }
            if (fullObject instanceof TLRPC$Document) {
                return "stripped" + FileRefController.getKeyForParentObject(parentObject) + "_" + ((TLRPC$Document) fullObject).id;
            }
            if (fullObject instanceof TLRPC$Photo) {
                return "stripped" + FileRefController.getKeyForParentObject(parentObject) + "_" + ((TLRPC$Photo) fullObject).id;
            }
            if (fullObject instanceof TLRPC$PhotoSize) {
                TLRPC$PhotoSize tLRPC$PhotoSize = (TLRPC$PhotoSize) fullObject;
                if (tLRPC$PhotoSize.location != null) {
                    return "stripped" + FileRefController.getKeyForParentObject(parentObject) + "_" + tLRPC$PhotoSize.location.local_id + "_" + tLRPC$PhotoSize.location.volume_id;
                }
                return "stripped" + FileRefController.getKeyForParentObject(parentObject);
            }
            if (fullObject instanceof TLRPC$FileLocation) {
                TLRPC$FileLocation tLRPC$FileLocation = (TLRPC$FileLocation) fullObject;
                return "stripped" + FileRefController.getKeyForParentObject(parentObject) + "_" + tLRPC$FileLocation.local_id + "_" + tLRPC$FileLocation.volume_id;
            }
        }
        return "stripped" + FileRefController.getKeyForParentObject(parentObject);
    }

    public String getKey(Object parentObject, Object fullObject, boolean url) {
        if (this.secureDocument != null) {
            return this.secureDocument.secureFile.dc_id + "_" + this.secureDocument.secureFile.id;
        }
        TLRPC$PhotoSize tLRPC$PhotoSize = this.photoSize;
        if ((tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) || (tLRPC$PhotoSize instanceof TLRPC$TL_photoPathSize)) {
            if (tLRPC$PhotoSize.bytes.length > 0) {
                return getStippedKey(parentObject, fullObject, tLRPC$PhotoSize);
            }
            return null;
        }
        if (this.location != null) {
            return this.location.volume_id + "_" + this.location.local_id;
        }
        WebFile webFile = this.webFile;
        if (webFile != null) {
            return Utilities.MD5(webFile.url);
        }
        TLRPC$Document tLRPC$Document = this.document;
        if (tLRPC$Document != null) {
            if (url || !(tLRPC$Document instanceof DocumentObject.ThemeDocument)) {
                if (tLRPC$Document.id == 0 || tLRPC$Document.dc_id == 0) {
                    return null;
                }
                return this.document.dc_id + "_" + this.document.id;
            }
            DocumentObject.ThemeDocument themeDocument = (DocumentObject.ThemeDocument) tLRPC$Document;
            StringBuilder sb = new StringBuilder();
            sb.append(this.document.dc_id);
            sb.append("_");
            sb.append(this.document.id);
            sb.append("_");
            sb.append(Theme.getBaseThemeKey(themeDocument.themeSettings));
            sb.append("_");
            sb.append(themeDocument.themeSettings.accent_color);
            sb.append("_");
            sb.append(themeDocument.themeSettings.message_colors.size() > 1 ? themeDocument.themeSettings.message_colors.get(1).intValue() : 0);
            sb.append("_");
            sb.append(themeDocument.themeSettings.message_colors.size() > 0 ? themeDocument.themeSettings.message_colors.get(0).intValue() : 0);
            return sb.toString();
        }
        String str = this.path;
        if (str != null) {
            return Utilities.MD5(str);
        }
        return null;
    }

    public boolean isEncrypted() {
        return this.key != null;
    }

    public int getSize() {
        TLRPC$PhotoSize tLRPC$PhotoSize = this.photoSize;
        if (tLRPC$PhotoSize != null) {
            return tLRPC$PhotoSize.size;
        }
        SecureDocument secureDocument = this.secureDocument;
        if (secureDocument != null) {
            TLRPC$TL_secureFile tLRPC$TL_secureFile = secureDocument.secureFile;
            if (tLRPC$TL_secureFile != null) {
                return tLRPC$TL_secureFile.size;
            }
        } else {
            TLRPC$Document tLRPC$Document = this.document;
            if (tLRPC$Document != null) {
                return tLRPC$Document.size;
            }
            WebFile webFile = this.webFile;
            if (webFile != null) {
                return webFile.size;
            }
        }
        return this.currentSize;
    }
}
