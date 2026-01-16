package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class FileInlineObject {
    public String access_hash_rec;
    public boolean auto_play;
    public String cdn_tag;
    public long file_id;
    public String file_name;
    public int height;
    public boolean is_round;
    public transient String local_attach_path;
    public transient String local_attach_path_orginal;
    public String music_performer;
    public long size;
    public String thumb_inline;
    public int time;
    public int width;
    public String mime = "none";
    public String dc_id = "0";
    public FileInlineType type = FileInlineType.File;

    public enum FileInlineType {
        File,
        Image,
        Voice,
        Video,
        Music,
        Gif
    }

    public String getMime() {
        return this.mime;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileInlineObject)) {
            return false;
        }
        FileInlineObject fileInlineObject = (FileInlineObject) obj;
        return this.file_id == fileInlineObject.file_id && Objects.equals(this.dc_id, fileInlineObject.dc_id) && Objects.equals(this.access_hash_rec, fileInlineObject.access_hash_rec);
    }
}
