package jawnae.pyronet;

import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PyroClientAdapter implements PyroClientListener {
    @Override // jawnae.pyronet.PyroClientListener
    public void droppedClient(PyroClient client, IOException cause) throws IOException {
        if (cause == null || !BuildVars.DEBUG_VERSION) {
            return;
        }
        FileLog.e("tmessages - this.getClass().getSimpleName() + .droppedClient() caught exception: ", cause);
    }
}
