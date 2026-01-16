package ir.nasim.database.dailogLists;

import androidx.annotation.Keep;
import ir.nasim.F92;
import ir.nasim.G92;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lir/nasim/database/dailogLists/MessageState;", "", "<init>", "(Ljava/lang/String;I)V", "Sent", "Read", "Pending", "Failed", "Unknown", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageState {
    private static final /* synthetic */ F92 $ENTRIES;
    private static final /* synthetic */ MessageState[] $VALUES;
    public static final MessageState Sent = new MessageState("Sent", 0);
    public static final MessageState Read = new MessageState("Read", 1);
    public static final MessageState Pending = new MessageState("Pending", 2);
    public static final MessageState Failed = new MessageState("Failed", 3);
    public static final MessageState Unknown = new MessageState("Unknown", 4);

    private static final /* synthetic */ MessageState[] $values() {
        return new MessageState[]{Sent, Read, Pending, Failed, Unknown};
    }

    static {
        MessageState[] messageStateArr$values = $values();
        $VALUES = messageStateArr$values;
        $ENTRIES = G92.a(messageStateArr$values);
    }

    private MessageState(String str, int i) {
    }

    public static F92 getEntries() {
        return $ENTRIES;
    }

    public static MessageState valueOf(String str) {
        return (MessageState) Enum.valueOf(MessageState.class, str);
    }

    public static MessageState[] values() {
        return (MessageState[]) $VALUES.clone();
    }
}
