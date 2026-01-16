package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StickerSetObject {
    public int count_stickers;
    public AvatarFileInline set_image;
    public String share_string;
    public String sticker_set_id;
    public String title;
    public ArrayList<StickerObject> top_stickers;
    public String update_time;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StickerSetObject)) {
            return false;
        }
        StickerSetObject stickerSetObject = (StickerSetObject) obj;
        return Objects.equals(this.sticker_set_id, stickerSetObject.sticker_set_id) && Objects.equals(this.title, stickerSetObject.title) && Objects.equals(this.set_image, stickerSetObject.set_image) && Objects.equalsArray(this.top_stickers, stickerSetObject.top_stickers) && Objects.equals(Integer.valueOf(this.count_stickers), Integer.valueOf(stickerSetObject.count_stickers)) && Objects.equals(this.share_string, stickerSetObject.share_string) && Objects.equals(this.update_time, stickerSetObject.update_time);
    }

    public int hashCode() {
        return Objects.hash(this.sticker_set_id, this.title, this.set_image, this.top_stickers, Integer.valueOf(this.count_stickers), this.share_string, this.update_time);
    }
}
