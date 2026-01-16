package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class RubinoAddFilePostInput extends InstaInput {
    public String duration;
    public String file_id;
    public FileTypeEnum file_type;
    public String hash_file_receive;
    public String post_id;
    public String snapshot_file_id;
    public String snapshot_hash_file_receive;

    public enum FileTypeEnum {
        Picture,
        Video
    }
}
