package jawnae.pyronet;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface PyroClientListener {
    void connectedClient(PyroClient client);

    void disconnectedClient(PyroClient client);

    void droppedClient(PyroClient client, IOException cause);

    void receivedData(PyroClient client, ByteBuffer data);

    void sentData(PyroClient client, int bytes);

    void unconnectableClient(PyroClient client, Exception cause);
}
