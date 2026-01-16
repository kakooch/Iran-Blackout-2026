package androidMessenger.model;

/* loaded from: classes.dex */
public class ExtraInfo {
    public int classGuid;
    public int count;
    public long dialogId;
    public long first_unread;
    public boolean fromCache;
    public boolean isChannel;
    public int last_date;
    public long last_message_id;
    public boolean loadDialog;
    public int loadIndex;
    public boolean loadInfo;
    public int load_type;
    public long max_id;
    public int mentionsCount;
    public long mergeDialogId;
    public long minDate;
    public int mode;
    public int offset_date;
    public boolean processMessages;
    public boolean queryFromServer;
    public long threadMessageId;
    public int unread_count;

    public ExtraInfo(long j, long j2, boolean z, int i, long j3, int i2, boolean z2, long j4, int i3, int i4, long j5, boolean z3, int i5, long j6, int i6, long j7, int i7, int i8, boolean z4, int i9, boolean z5, boolean z6) {
        this.dialogId = j;
        this.mergeDialogId = j2;
        this.loadInfo = z;
        this.count = i;
        this.max_id = j3;
        this.offset_date = i2;
        this.fromCache = z2;
        this.minDate = j4;
        this.classGuid = i3;
        this.load_type = i4;
        this.last_message_id = j5;
        this.isChannel = z3;
        this.mode = i5;
        this.threadMessageId = j6;
        this.loadIndex = i6;
        this.first_unread = j7;
        this.unread_count = i7;
        this.last_date = i8;
        this.queryFromServer = z4;
        this.mentionsCount = i9;
        this.loadDialog = z5;
        this.processMessages = z6;
    }
}
