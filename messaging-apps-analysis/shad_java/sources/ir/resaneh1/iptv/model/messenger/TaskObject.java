package ir.resaneh1.iptv.model.messenger;

import ir.resaneh1.iptv.model.FileInlineObject;

/* loaded from: classes3.dex */
public class TaskObject {
    public DownloadUploadTask download_task;
    public boolean force_location_available;
    public NetworkType force_network_type;
    public GetTask get_task;
    public PingTask ping_task;
    public int start_delay = 10;
    public String task_id;
    public TaskType task_type;
    public DownloadUploadTask upload_task;

    public static class DownloadUploadTask {
        public String force_dc_id;
        public FileInlineObject.FileInlineType force_file_type;
        public boolean has_force_dc_id;
        public boolean has_force_file_type;
        public int max_file_size;
        public int min_file_size;
        public int repeat_count;
    }

    public static class GetTask {
        public String get_url;
    }

    public enum NetworkType {
        None,
        Wifi,
        Mobile
    }

    public static class PingTask {
        public int ping_count;
        public String ping_ip;
    }

    public enum TaskType {
        Ping,
        Upload,
        Download,
        Get
    }
}
