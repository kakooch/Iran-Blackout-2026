package com.github.mikephil.charting.utils;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes2.dex */
public class ColorTemplate {
    public static final int COLOR_NONE = 1122867;
    public static final int COLOR_SKIP = 1122868;
    public static final int[] LIBERTY_COLORS = {Color.rgb(207, 248, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER), Color.rgb(148, 212, 212), Color.rgb(136, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER), Color.rgb(SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, 174, 175), Color.rgb(42, 109, 130)};
    public static final int[] JOYFUL_COLORS = {Color.rgb(217, 80, WKSRecord.Service.NETBIOS_DGM), Color.rgb(254, 149, 7), Color.rgb(254, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER), Color.rgb(Type.L64, 167, 134), Color.rgb(53, 194, 209)};
    public static final int[] PASTEL_COLORS = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER), Color.rgb(SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, 134, 134), Color.rgb(SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, 48, 80)};
    public static final int[] COLORFUL_COLORS = {Color.rgb(SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(Type.L64, 150, 31), Color.rgb(SetRpcStruct$ComposedRpc.REVOKE_INVITE_URL_FIELD_NUMBER, 100, 53)};
    public static final int[] VORDIPLOM_COLORS = {Color.rgb(192, 255, WKSRecord.Service.EMFIS_DATA), Color.rgb(255, SetRpcStruct$ComposedRpc.RESPONSE_LOAD_STICKER_COLLECTION_FIELD_NUMBER, WKSRecord.Service.EMFIS_DATA), Color.rgb(255, 208, WKSRecord.Service.EMFIS_DATA), Color.rgb(WKSRecord.Service.EMFIS_DATA, SetRpcStruct$ComposedRpc.RESPONSE_SEARCH_PEER_FIELD_NUMBER, 255), Color.rgb(255, WKSRecord.Service.EMFIS_DATA, SetRpcStruct$ComposedRpc.RESPONSE_GET_NASIM_FILE_UPLOAD_URL_FIELD_NUMBER)};
    public static final int[] MATERIAL_COLORS = {rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db")};

    public static int colorWithAlpha(int i, int i2) {
        return (i & 16777215) | ((i2 & 255) << 24);
    }

    public static List<Integer> createColors(Resources resources, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(resources.getColor(i)));
        }
        return arrayList;
    }

    public static int getHoloBlue() {
        return Color.rgb(51, SetRpcStruct$ComposedRpc.RESPONSE_JOIN_GROUP_FIELD_NUMBER, SetRpcStruct$ComposedRpc.NOTIFY_ABOUT_DEVICE_INFO_FIELD_NUMBER);
    }

    public static int rgb(String str) {
        int i = (int) Long.parseLong(str.replace(Separators.POUND, ""), 16);
        return Color.rgb((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    public static List<Integer> createColors(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }
}
