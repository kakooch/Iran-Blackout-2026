package ir.eitaa.tgnet;

import java.util.ArrayList;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class TLRPC$TL_config extends TLObject {
    public static int constructor = 856375399;
    public int base_lang_pack_version;
    public boolean blocked_mode;
    public int call_connect_timeout_ms;
    public int call_packet_timeout_ms;
    public int call_receive_timeout_ms;
    public int call_ring_timeout_ms;
    public int channels_read_media_period;
    public int chat_size_max;
    public int date;
    public int downloadChunkSize_KB;
    public int edit_time_limit;
    public int expires;
    public int flags;
    public int forwarded_count_max;
    public String gif_search_username;
    public String img_search_username;
    public int lang_pack_version;
    public String me_url_prefix;
    public int megagroup_size_max;
    public int notify_cloud_delay_ms;
    public int notify_default_delay_ms;
    public int offline_blur_timeout_ms;
    public int offline_idle_timeout_ms;
    public int online_cloud_timeout_ms;
    public int online_update_period_ms;
    public boolean pfs_enabled;
    public boolean phonecalls_enabled;
    public int pinned_dialogs_count_max;
    public int pinned_infolder_count_max;
    public boolean preload_featured_stickers;
    public int push_chat_limit;
    public int push_chat_period_ms;
    public int rating_e_decay;
    public int saved_gifs_limit;
    public int schedule_period_background_delay_ms;
    public int schedule_period_background_ms;
    public int schedule_period_forground_ms;
    public String static_maps_provider;
    public int stickers_recent_limit;
    public String suggested_lang_code;
    public boolean test_mode;
    public int this_dc;
    public int tmp_sessions;
    public int uploadChunkSize_KB;
    public String venue_search_username;
    public boolean revoke_pm_inbox = true;
    public ArrayList<TLRPC$TL_dcOption> dc_options = new ArrayList<>();
    public String dc_txt_domain_name = "tapv2.stel.com";
    public int revoke_time_limit = 31536000;
    public int revoke_pm_time_limit = 31536000;
    public int stickers_faved_limit = 5;
    public int caption_length_max = 1404;
    public int message_length_max = Factory.DEVICE_HAS_CRAPPY_AAUDIO;
    public int webfile_dc_id = 4;
    public String appURL = "";
    public String socketURL = "";
    public boolean update_available = false;
    public String payHost = "";
    public boolean payEnabled = false;
    public boolean exploreEnabled = false;
    public boolean mxbEnabled = false;
    public boolean callOutEnabled = false;
    public boolean reportVersion = false;
    public TLRPC$TL_liveStreamConfig liveStreamConfig = new TLRPC$TL_liveStreamConfig();

    public static TLRPC$TL_config TLdeserialize(AbstractSerializedData stream, int constructor2, boolean exception) {
        if (constructor != constructor2) {
            if (exception) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_config", Integer.valueOf(constructor2)));
            }
            return null;
        }
        TLRPC$TL_config tLRPC$TL_config = new TLRPC$TL_config();
        tLRPC$TL_config.readParams(stream, exception);
        return tLRPC$TL_config;
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void readParams(AbstractSerializedData stream, boolean exception) {
        int int32 = stream.readInt32(exception);
        this.flags = int32;
        this.phonecalls_enabled = (int32 & 2) != 0;
        this.pfs_enabled = (int32 & 8192) != 0;
        this.date = stream.readInt32(exception);
        this.expires = stream.readInt32(exception);
        this.test_mode = stream.readBool(exception);
        this.this_dc = stream.readInt32(exception);
        int int322 = stream.readInt32(exception);
        if (int322 != 481674261) {
            if (exception) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(int322)));
            }
            return;
        }
        int int323 = stream.readInt32(exception);
        for (int i = 0; i < int323; i++) {
            TLRPC$TL_dcOption tLRPC$TL_dcOptionTLdeserialize = TLRPC$TL_dcOption.TLdeserialize(stream, stream.readInt32(exception), exception);
            if (tLRPC$TL_dcOptionTLdeserialize == null) {
                return;
            }
            this.dc_options.add(tLRPC$TL_dcOptionTLdeserialize);
        }
        this.dc_txt_domain_name = stream.readString(exception);
        this.chat_size_max = stream.readInt32(exception);
        this.megagroup_size_max = stream.readInt32(exception);
        this.forwarded_count_max = stream.readInt32(exception);
        this.online_update_period_ms = stream.readInt32(exception);
        this.offline_blur_timeout_ms = stream.readInt32(exception);
        this.offline_idle_timeout_ms = stream.readInt32(exception);
        this.online_cloud_timeout_ms = stream.readInt32(exception);
        this.notify_cloud_delay_ms = stream.readInt32(exception);
        this.notify_default_delay_ms = stream.readInt32(exception);
        this.push_chat_period_ms = stream.readInt32(exception);
        this.push_chat_limit = stream.readInt32(exception);
        this.saved_gifs_limit = stream.readInt32(exception);
        this.edit_time_limit = stream.readInt32(exception);
        this.revoke_time_limit = stream.readInt32(exception);
        this.revoke_pm_time_limit = stream.readInt32(exception);
        this.rating_e_decay = stream.readInt32(exception);
        this.stickers_recent_limit = stream.readInt32(exception);
        this.stickers_faved_limit = stream.readInt32(exception);
        this.channels_read_media_period = stream.readInt32(exception);
        if ((this.flags & 1) != 0) {
            this.tmp_sessions = stream.readInt32(exception);
        }
        this.pinned_dialogs_count_max = stream.readInt32(exception);
        this.pinned_infolder_count_max = stream.readInt32(exception);
        this.call_receive_timeout_ms = stream.readInt32(exception);
        this.call_ring_timeout_ms = stream.readInt32(exception);
        this.call_connect_timeout_ms = stream.readInt32(exception);
        this.call_packet_timeout_ms = stream.readInt32(exception);
        this.me_url_prefix = stream.readString(exception);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            this.gif_search_username = stream.readString(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.venue_search_username = stream.readString(exception);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            this.img_search_username = stream.readString(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            this.static_maps_provider = stream.readString(exception);
        }
        this.caption_length_max = stream.readInt32(exception);
        this.message_length_max = stream.readInt32(exception);
        this.webfile_dc_id = stream.readInt32(exception);
        if ((this.flags & 4) != 0) {
            this.suggested_lang_code = stream.readString(exception);
            this.lang_pack_version = stream.readInt32(exception);
            this.base_lang_pack_version = stream.readInt32(exception);
        }
        this.schedule_period_forground_ms = stream.readInt32(exception);
        this.schedule_period_background_ms = stream.readInt32(exception);
        this.schedule_period_background_delay_ms = stream.readInt32(exception);
        this.uploadChunkSize_KB = stream.readInt32(exception);
        this.downloadChunkSize_KB = stream.readInt32(exception);
        boolean z = (this.flags & 64) != 0;
        this.update_available = z;
        if (z) {
            this.appURL = stream.readString(exception);
        }
        int i2 = this.flags;
        boolean z2 = (i2 & 128) != 0;
        this.payEnabled = z2;
        this.callOutEnabled = (32768 & i2) != 0;
        this.exploreEnabled = (65536 & i2) != 0;
        this.mxbEnabled = (131072 & i2) != 0;
        this.reportVersion = (i2 & 262144) != 0;
        if (z2) {
            this.payHost = stream.readString(exception);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            this.liveStreamConfig = TLRPC$TL_liveStreamConfig.TLdeserialize(stream, stream.readInt32(exception), exception);
        }
        if ((this.flags & 16384) != 0) {
            this.socketURL = stream.readString(exception);
        }
    }

    @Override // ir.eitaa.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData stream) {
        TLRPC$TL_liveStreamConfig tLRPC$TL_liveStreamConfig;
        stream.writeInt32(constructor);
        int i = this.phonecalls_enabled ? this.flags | 2 : this.flags & (-3);
        this.flags = i;
        int i2 = this.update_available ? i | 64 : i & (-65);
        this.flags = i2;
        int i3 = this.payEnabled ? i2 | 128 : i2 & (-129);
        this.flags = i3;
        stream.writeInt32(i3);
        stream.writeInt32(this.date);
        stream.writeInt32(this.expires);
        stream.writeBool(this.test_mode);
        stream.writeInt32(this.this_dc);
        stream.writeInt32(481674261);
        int size = this.dc_options.size();
        stream.writeInt32(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.dc_options.get(i4).serializeToStream(stream);
        }
        stream.writeString(this.dc_txt_domain_name);
        stream.writeInt32(this.chat_size_max);
        stream.writeInt32(this.megagroup_size_max);
        stream.writeInt32(this.forwarded_count_max);
        stream.writeInt32(this.online_update_period_ms);
        stream.writeInt32(this.offline_blur_timeout_ms);
        stream.writeInt32(this.offline_idle_timeout_ms);
        stream.writeInt32(this.online_cloud_timeout_ms);
        stream.writeInt32(this.notify_cloud_delay_ms);
        stream.writeInt32(this.notify_default_delay_ms);
        stream.writeInt32(this.push_chat_period_ms);
        stream.writeInt32(this.push_chat_limit);
        stream.writeInt32(this.saved_gifs_limit);
        stream.writeInt32(this.edit_time_limit);
        stream.writeInt32(this.revoke_time_limit);
        stream.writeInt32(this.revoke_pm_time_limit);
        stream.writeInt32(this.rating_e_decay);
        stream.writeInt32(this.stickers_recent_limit);
        stream.writeInt32(this.stickers_faved_limit);
        stream.writeInt32(this.channels_read_media_period);
        if ((this.flags & 1) != 0) {
            stream.writeInt32(this.tmp_sessions);
        }
        stream.writeInt32(this.pinned_dialogs_count_max);
        stream.writeInt32(this.pinned_infolder_count_max);
        stream.writeInt32(this.call_receive_timeout_ms);
        stream.writeInt32(this.call_ring_timeout_ms);
        stream.writeInt32(this.call_connect_timeout_ms);
        stream.writeInt32(this.call_packet_timeout_ms);
        stream.writeString(this.me_url_prefix);
        if ((this.flags & Factory.DEVICE_USE_ANDROID_CAMCORDER) != 0) {
            stream.writeString(this.gif_search_username);
        }
        if ((this.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            stream.writeString(this.venue_search_username);
        }
        if ((this.flags & Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS) != 0) {
            stream.writeString(this.img_search_username);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_AAUDIO) != 0) {
            stream.writeString(this.static_maps_provider);
        }
        stream.writeInt32(this.caption_length_max);
        stream.writeInt32(this.message_length_max);
        stream.writeInt32(this.webfile_dc_id);
        if ((this.flags & 4) != 0) {
            stream.writeString(this.suggested_lang_code);
            stream.writeInt32(this.base_lang_pack_version);
            stream.writeInt32(this.lang_pack_version);
        }
        stream.writeInt32(this.schedule_period_forground_ms);
        stream.writeInt32(this.schedule_period_background_ms);
        stream.writeInt32(this.schedule_period_background_delay_ms);
        stream.writeInt32(this.uploadChunkSize_KB);
        stream.writeInt32(this.downloadChunkSize_KB);
        if (this.update_available) {
            stream.writeString(this.appURL);
        }
        if (this.payEnabled) {
            stream.writeString(this.payHost);
        }
        if ((this.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0 && (tLRPC$TL_liveStreamConfig = this.liveStreamConfig) != null) {
            tLRPC$TL_liveStreamConfig.serializeToStream(stream);
        }
        if ((this.flags & 16384) != 0) {
            stream.writeString(this.socketURL);
        }
    }
}
