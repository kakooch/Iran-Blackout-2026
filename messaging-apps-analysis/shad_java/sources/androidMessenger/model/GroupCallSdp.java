package androidMessenger.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GroupCallSdp {

    public static class Audio {
        ArrayList<PayloadType> payload_types = new ArrayList<>();

        @SerializedName("rtp-hdrexts")
        ArrayList<Rtp> rtp_hdrexts = new ArrayList<>();
    }

    public static class Candidate {
        public String component;
        public String foundation;
        public String generation;
        public String id;
        public String ip;
        public String network;
        public String port;
        public String priority;
        public String protocol;
        public String type;
    }

    public static class Fingerprint {
        public String fingerprint;
        public String hash;
        public String setup;
    }

    public static class PayloadType {
        public int channels;
        public int clockrate;
        public int id;
        public String name;
    }

    public static class Rtp {
        public int id;
        public String uri;
    }

    public static class Sdp {
        public Audio audio;
        public int[] ssrcs;
        public Transport transport;
        public Object video;
    }

    public static class SdpOffer {
        public ArrayList<Fingerprint> fingerprints;
        public String pwd;
        public String ssrc;
        public String ufrag;
    }

    public static class Transport {
        public String pwd;
        public String ufrag;
        public ArrayList<Candidate> candidates = new ArrayList<>();

        @SerializedName("rtcp-mux")
        boolean rtcp_mux = true;
        public ArrayList<Fingerprint> fingerprints = new ArrayList<>();
    }
}
