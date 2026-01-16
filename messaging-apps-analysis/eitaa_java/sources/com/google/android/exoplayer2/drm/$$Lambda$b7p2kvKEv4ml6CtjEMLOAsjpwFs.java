package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.EventDispatcher;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.drm.-$$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs, reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs implements EventDispatcher.Event {
    public static final /* synthetic */ $$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs INSTANCE = new $$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs();

    private /* synthetic */ $$Lambda$b7p2kvKEv4ml6CtjEMLOAsjpwFs() {
    }

    @Override // com.google.android.exoplayer2.util.EventDispatcher.Event
    public final void sendTo(Object obj) {
        ((DefaultDrmSessionEventListener) obj).onDrmKeysRestored();
    }
}
