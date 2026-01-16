package org.webrtc;

import org.webrtc.Logging;

/* loaded from: classes3.dex */
public interface Loggable {
    void onLogMessage(String message, Logging.Severity severity, String tag);
}
