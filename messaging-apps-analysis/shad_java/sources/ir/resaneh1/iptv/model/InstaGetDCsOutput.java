package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class InstaGetDCsOutput {
    public ArrayList<InstaServerConfigObject> api_servers;
    public DefaultServerObject default_servers;
    public ArrayList<InstaServerConfigObject> file_servers;

    public class DefaultServerObject {
        public String api_server;

        public DefaultServerObject() {
        }
    }
}
