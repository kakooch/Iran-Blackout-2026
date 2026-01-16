package ir.eitaa.tgnet;

import ir.eitaa.messenger.Utilities;
import java.util.ArrayList;
import jawnae.pyronet.PyroClientAdapter;

/* loaded from: classes.dex */
public class ConnectionContext extends PyroClientAdapter {
    private long sessionId;
    private ArrayList<Long> processedMessageIds = new ArrayList<>();
    private ArrayList<Long> messagesIdsForConfirmation = new ArrayList<>();
    private ArrayList<Long> processedSessionChanges = new ArrayList<>();
    private int nextSeqNo = 0;

    public ConnectionContext() {
        genereateNewSessionId();
    }

    private void genereateNewSessionId() {
        this.sessionId = Utilities.random.nextLong();
    }

    public void setSessionId(long id) {
        this.sessionId = id;
    }

    boolean isMessageIdProcessed(long messageId) {
        return this.processedMessageIds.contains(Long.valueOf(messageId));
    }
}
