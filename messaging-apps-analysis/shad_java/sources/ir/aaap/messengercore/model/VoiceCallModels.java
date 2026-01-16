package ir.aaap.messengercore.model;

import ir.aaap.messengercore.model.MessageCallData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class VoiceCallModels {

    public static class AcceptCallInput {
        public String call_id;
        public ArrayList<String> library_versions;
        public int max_layer;
        public int min_layer;
    }

    public static class AcceptCallOutput {
        public CallUpdateObject call_update;
        public ChatUpdateObject chat_update;
        public MessageUpdateObject message_update;
    }

    public static class CallAbsObject {
        public String call_id;
        public CallType call_type;
        public MessageCallData.DiscardReasonEnum discard_reason;
        public int duration;
        public long message_id;
        public String object_guid;
        public ArrayList<ChatAbsObject> other_participants;
        public CallRequestType request_type;
        public long start_time;
    }

    public static class CallConfig {
        public String audio_bitrate_step_decr;
        public String audio_bitrate_step_incr;
        public String audio_init_bitrate;
        public String audio_init_bitrate_edge;
        public String audio_init_bitrate_gprs;
        public String audio_init_bitrate_saving;
        public String audio_max_bitrate;
        public String audio_max_bitrate_edge;
        public String audio_max_bitrate_gprs;
        public String audio_max_bitrate_saving;
        public String audio_min_bitrate;
        public String max_unsent_stream_packets;
        public String p2p_to_relay_switch_threshold;
        public String packet_loss_for_extra_ec;
        public String rate_flags;
        public String rate_min_rtt;
        public String rate_min_send_loss;
        public String reconnecting_state_timeout;
        public String relay_switch_threshold;
        public String relay_to_p2p_switch_threshold;
        public String unack_nop_threshold;
    }

    public static class CallOutObject {
        public String call_id;
        public CallOutType call_out_type;
        public SipCallOutObject sip_call_out_data;
    }

    public enum CallOutType {
        SIP
    }

    public enum CallProtocolType {
        CallOut,
        WebRtc
    }

    public enum CallRequestType {
        Caller,
        Receiver
    }

    public static class CallSignalDataObject {
        public String call_id;
        public String data;
    }

    public static class CallStartedInput {
        public String call_id;
    }

    public static class CallStartedOutput {
    }

    public enum CallStateEnum {
        Requested,
        Waiting,
        Accepted,
        Discarded
    }

    public enum CallType {
        Voice,
        Video,
        CallOut
    }

    public enum CallUpdateActionEnum {
        New,
        Edit,
        Delete
    }

    public static class CallUpdateObject {
        public CallUpdateActionEnum action;
        public PhoneCall call;
        public String call_id;
        public String object_guid;
        public int timestamp;
        public ChatType type;
        public ArrayList<String> updated_parameters;
    }

    public enum ConnectionType {
        Tg,
        WebRTC
    }

    public static class DiscardCallInput {
        public String call_id;
        public int duration;
        public EnumDiscardCallReason reason;
    }

    public static class DiscardCallOutput {
        public CallUpdateObject call_update;
        public ChatUpdateObject chat_update;
        public MessageUpdateObject message_update;
    }

    public enum EnumDiscardCallReason {
        Missed,
        Disconnect,
        Hangup,
        Busy
    }

    public enum FilterTypeEnum {
        All,
        Missed
    }

    public static class GetCallsInput {
        public FilterTypeEnum filter_type;
        public String max_id;
        public String min_id;
        public SortTypeEnum sort;
    }

    public static class GetCallsOutput {
        public ArrayList<CallAbsObject> calls;
        public boolean has_continue;
        public String new_max_id;
        public String new_min_id;
    }

    public static class GetSignalingDataInput {
        public String call_id;
    }

    public static class GetSignalingDataOutput {
        public ArrayList<String> data_list;
    }

    public static class GetVoiceCallOutput {
        public CallConfig call_config;
    }

    public static class PhoneConnection {
        public static int constructor = -1655957568;
        public long id;
        public String ip;
        public String ipv6;
        public String peer_tag;
        public int port = 27000;
        public String turn_password;
        public String turn_username;
        public ConnectionType type;
    }

    public static class RateCallInput {
        public String call_id;
        public String comment;
        public int star_count;
    }

    public static class RateCallOutput {
    }

    public static class ReceivedCallInput {
        public String call_id;
    }

    public static class ReceivedCallOutput {
        public CallUpdateObject call_update;
        public ChatUpdateObject chat_update;
        public MessageUpdateObject message_update;
    }

    public static class RequestCallInput {
        public CallType call_type;
        public ArrayList<String> library_versions;
        public int max_layer;
        public int min_layer;
        public String receiver_phone_number;
        public String user_guid;
        public boolean support_call_out = true;
        public int sip_version = 1;
    }

    public static class RequestCallOutput {
        public CallProtocolType call_type;
        public CallUpdateObject call_update;
        public CallOutObject callout_data;
        public ChatUpdateObject chat_update;
        public MessageUpdateObject message_update;
    }

    public static class SendSignalDataInput {
        public String call_id;
        public String data;
    }

    public static class SendSignalDataOutput {
    }

    public static class SipCallOutObject {
        public String caller_id;
        public String ip;
        public String password;
        public String username;
    }

    public enum SortTypeEnum {
        FromMin,
        FromMax
    }

    public static class TL_updatePhoneCallSignalingData {
        public byte[] data;
        public String phone_call_id;
    }

    public static class PhoneCall {
        public String call_id;
        public CallType call_type;
        public ArrayList<PhoneConnection> connections;
        public EnumDiscardCallReason discard_reason;
        public int duration;
        public String key;
        public ArrayList<ChatAbsObject> other_participants;
        public int protocol_layer;
        public int receive_time;
        public boolean report_rating;
        public CallStateEnum state;
        public int timestamp;
        public ArrayList<String> library_versions = new ArrayList<>();
        public boolean p2p_allowed = false;
        HashMap<String, Integer> updatedTimeStampMap = new HashMap<>();

        public void updateWithCallUpdate(CallUpdateObject callUpdateObject) {
            if (callUpdateObject.action == CallUpdateActionEnum.Edit) {
                Iterator<String> it = callUpdateObject.updated_parameters.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Integer numValueOf = this.updatedTimeStampMap.get(next);
                    if (numValueOf == null) {
                        numValueOf = 0;
                    }
                    int iIntValue = numValueOf.intValue();
                    int i = this.timestamp;
                    if (iIntValue < i) {
                        numValueOf = Integer.valueOf(i);
                    }
                    if (next.equals("state")) {
                        int iIntValue2 = numValueOf.intValue();
                        int i2 = callUpdateObject.timestamp;
                        if (iIntValue2 < i2) {
                            this.state = callUpdateObject.call.state;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i2));
                        }
                    }
                    if (next.equals("key")) {
                        int iIntValue3 = numValueOf.intValue();
                        int i3 = callUpdateObject.timestamp;
                        if (iIntValue3 < i3) {
                            this.key = callUpdateObject.call.key;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i3));
                        }
                    }
                    if (next.equals("connections")) {
                        int iIntValue4 = numValueOf.intValue();
                        int i4 = callUpdateObject.timestamp;
                        if (iIntValue4 < i4) {
                            this.connections = callUpdateObject.call.connections;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i4));
                        }
                    }
                    if (next.equals("protocol_layer")) {
                        int iIntValue5 = numValueOf.intValue();
                        int i5 = callUpdateObject.timestamp;
                        if (iIntValue5 < i5) {
                            this.protocol_layer = callUpdateObject.call.protocol_layer;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i5));
                        }
                    }
                    if (next.equals("receive_time")) {
                        int iIntValue6 = numValueOf.intValue();
                        int i6 = callUpdateObject.timestamp;
                        if (iIntValue6 < i6) {
                            this.receive_time = callUpdateObject.call.receive_time;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i6));
                        }
                    }
                    if (next.equals("call_type")) {
                        int iIntValue7 = numValueOf.intValue();
                        int i7 = callUpdateObject.timestamp;
                        if (iIntValue7 < i7) {
                            this.call_type = callUpdateObject.call.call_type;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i7));
                        }
                    }
                    if (next.equals("library_versions")) {
                        int iIntValue8 = numValueOf.intValue();
                        int i8 = callUpdateObject.timestamp;
                        if (iIntValue8 < i8) {
                            this.library_versions = callUpdateObject.call.library_versions;
                            this.updatedTimeStampMap.put(next, Integer.valueOf(i8));
                        }
                    }
                }
            }
        }
    }
}
