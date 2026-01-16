package androidMessenger.model;

/* loaded from: classes.dex */
public class ExtraMediaInfo {
    public int classGuid;
    public int count;
    public int fromCache;
    public boolean isChannel;
    public long max_id;
    public int type;
    public long uid;

    public ExtraMediaInfo(long j, int i, long j2, int i2, int i3, int i4, boolean z) {
        this.uid = j;
        this.count = i;
        this.max_id = j2;
        this.type = i2;
        this.fromCache = i3;
        this.classGuid = i4;
        this.isChannel = z;
    }
}
