package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class StickerObject {
    public String emoji_character;
    public AvatarFileInline file;
    public String sticker_id;
    public String sticker_set_id;
    public float w_h_ratio;

    public enum TypeEnum {
        favorite,
        recent
    }

    public long getFileId() {
        AvatarFileInline avatarFileInline = this.file;
        if (avatarFileInline == null) {
            return 0L;
        }
        return avatarFileInline.file_id;
    }

    public String getDcId() {
        AvatarFileInline avatarFileInline = this.file;
        if (avatarFileInline == null) {
            return null;
        }
        return avatarFileInline.dc_id;
    }

    public String getCdnTag() {
        AvatarFileInline avatarFileInline = this.file;
        if (avatarFileInline == null) {
            return null;
        }
        return avatarFileInline.cdn_tag;
    }

    public String getHashRec() {
        AvatarFileInline avatarFileInline = this.file;
        if (avatarFileInline == null) {
            return null;
        }
        return avatarFileInline.access_hash_rec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StickerObject)) {
            return false;
        }
        StickerObject stickerObject = (StickerObject) obj;
        return Float.compare(stickerObject.w_h_ratio, this.w_h_ratio) == 0 && Objects.equals(this.sticker_id, stickerObject.sticker_id) && Objects.equals(this.file, stickerObject.file) && Objects.equals(this.emoji_character, stickerObject.emoji_character) && Objects.equals(this.sticker_set_id, stickerObject.sticker_set_id);
    }

    public int hashCode() {
        return Objects.hash(this.sticker_id, Float.valueOf(this.w_h_ratio), this.file, this.emoji_character, this.sticker_set_id);
    }
}
