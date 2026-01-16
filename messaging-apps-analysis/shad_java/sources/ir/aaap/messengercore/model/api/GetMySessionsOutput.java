package ir.aaap.messengercore.model.api;

import ir.aaap.messengercore.model.SessionObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetMySessionsOutput {
    public SessionObject active_session;
    public boolean can_remove_all;
    public ArrayList<SessionObject> other_sessions;
}
