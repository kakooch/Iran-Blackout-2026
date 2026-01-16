package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class GetObjectOutput<T> extends StatusOutput {

    @SerializedName("result")
    public T object;
}
