package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class GetFileInput {
    public String access_hash_rec;
    public String dc_id;
    public long endIndex;
    public String file_id;
    public long startIndex;

    public GetFileInput(String str, long j, long j2, String str2, String str3) {
        this.dc_id = str;
        this.startIndex = j;
        this.endIndex = j2;
        this.access_hash_rec = str2;
        this.file_id = str3;
    }

    public HashMap<String, String> getHeaderMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("start-index", this.startIndex + BuildConfig.FLAVOR);
        map.put("last-index", this.endIndex + BuildConfig.FLAVOR);
        map.put("file-id", this.file_id + BuildConfig.FLAVOR);
        map.put("dc-id", this.dc_id);
        map.put("range", "bytes=" + this.startIndex + "-" + this.endIndex);
        map.put("access-hash-rec", this.access_hash_rec);
        return map;
    }
}
