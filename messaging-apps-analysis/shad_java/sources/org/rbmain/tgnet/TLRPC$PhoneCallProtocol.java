package org.rbmain.tgnet;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class TLRPC$PhoneCallProtocol extends TLObject {
    public int flags;
    public ArrayList<String> library_versions = new ArrayList<>();
    public int max_layer;
    public int min_layer;
    public boolean udp_p2p;
    public boolean udp_reflector;
}
