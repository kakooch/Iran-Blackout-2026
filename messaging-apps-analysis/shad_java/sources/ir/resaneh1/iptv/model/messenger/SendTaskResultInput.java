package ir.resaneh1.iptv.model.messenger;

import ir.resaneh1.iptv.model.LocationObject;
import ir.resaneh1.iptv.model.messenger.TaskObject;

/* loaded from: classes3.dex */
public class SendTaskResultInput {
    public int cell_id;
    public DownloadResult download_result;
    public GetResult get_result;
    public int lac_id;
    public LocationObject location;
    public String mobile_operator;
    public String mobile_type_network;
    public TaskObject.NetworkType network_type;
    public PingResult ping_result;
    public int signal_level;
    public String task_id;
    public TaskObject.TaskType task_type;
    public UploadResult upload_result;

    public static class DownloadResult {
        public long download_size;
        public long download_time;
        public String download_url;
    }

    public static class GetResult {
        public long get_size;
        public long get_time;
        public String get_url;
        public boolean is_successful;
    }

    public static class PingResult {
        public String ping_ip;
        public float ping_loss;
        public long ping_time;
    }

    public static class UploadResult {
        public long upload_size;
        public long upload_time;
        public String upload_url;
    }
}
