package org.rbmain.tgnet;

/* loaded from: classes4.dex */
public abstract class TLRPC$PhoneConnection extends TLObject {
    public int flags;
    public long id;
    public String ip;
    public String ipv6;
    public String password;
    public byte[] peer_tag;
    public int port;
    public boolean stun;
    public boolean tcp;
    public boolean turn;
    public String username;
}
