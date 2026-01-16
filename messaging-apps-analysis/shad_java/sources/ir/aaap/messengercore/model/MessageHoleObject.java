package ir.aaap.messengercore.model;

import android.os.Build;
import ir.aaap.messengercore.MessageUtils;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class MessageHoleObject {
    public long end;
    public long start;
    public MessageUtils.FilterTypeEnum type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageHoleObject)) {
            return false;
        }
        MessageHoleObject messageHoleObject = (MessageHoleObject) obj;
        return this.start == messageHoleObject.start && this.end == messageHoleObject.end && this.type == messageHoleObject.type && getClass().getDeclaredFields().length == messageHoleObject.getClass().getDeclaredFields().length;
    }

    public int hashCode() {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(new Object[]{Long.valueOf(this.start), Long.valueOf(this.end), this.type});
        }
        return 1;
    }
}
