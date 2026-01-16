package ir.aaap.messengercore.model.api;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class SendFileInput {
    public String access_hash_send;
    public byte[] bytes;
    public String file_id;
    public int partNumber;
    public int totalPart;

    public HashMap<String, String> getHeaderMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("part-number", this.partNumber + BuildConfig.FLAVOR);
        map.put("total-part", this.totalPart + BuildConfig.FLAVOR);
        map.put("file-id", this.file_id);
        map.put("access-hash-send", this.access_hash_send);
        return map;
    }
}
