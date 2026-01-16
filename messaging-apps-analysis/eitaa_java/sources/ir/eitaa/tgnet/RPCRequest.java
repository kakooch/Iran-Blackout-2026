package ir.eitaa.tgnet;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class RPCRequest {
    boolean cancelled;
    public RequestDelegate completionBlock;
    public int connectionType;
    public int flags;
    public long messageId;
    public int minStartTime;
    public QuickAckDelegate quickAckBlock;
    public TLObject rawRequest;
    public TLObject rpcRequest;
    public int runningDatacenterId;
    public int serializedLength;
    public int serverFailureCount;
    public int startTime;
    long token;
    public boolean wait = false;
    public boolean salt = false;
    public int retryCount = 0;
    public int lastResendTime = 0;
    public boolean completed = false;
    public int failedByFloodWait = 0;
    public int connectionToken = 0;
    public boolean confirmed = false;
    public AtomicBoolean responseReceived = new AtomicBoolean(false);
    public boolean initRequest = false;
    public ArrayList<Long> respondsToMessageIds = new ArrayList<>();

    boolean respondsToMessageId(long messageId) {
        return this.messageId == messageId || this.respondsToMessageIds.contains(Long.valueOf(messageId));
    }
}
