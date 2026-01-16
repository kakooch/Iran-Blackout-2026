package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class RubinoRequestUploadFileInput extends InstaInput {
    public String file_name;
    public Long file_size;
    public FileType file_type = FileType.Picture;

    public enum FileType {
        Picture,
        Video
    }

    public RubinoRequestUploadFileInput(String str) {
        this.profile_id = str;
    }

    public RubinoRequestUploadFileInput() {
    }
}
