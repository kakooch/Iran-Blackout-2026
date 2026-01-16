package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import java.util.Iterator;
import java.util.List;
import livekit.org.webrtc.MediaConstraints;

/* loaded from: classes3.dex */
public abstract class JW3 {
    public static final String a(MediaConstraints mediaConstraints, String str) {
        Object next;
        Object next2;
        String value;
        AbstractC13042fc3.i(mediaConstraints, "<this>");
        AbstractC13042fc3.i(str, "key");
        List<MediaConstraints.KeyValuePair> list = mediaConstraints.mandatory;
        AbstractC13042fc3.h(list, "mandatory");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (AbstractC13042fc3.d(((MediaConstraints.KeyValuePair) next).getKey(), str)) {
                break;
            }
        }
        MediaConstraints.KeyValuePair keyValuePair = (MediaConstraints.KeyValuePair) next;
        if (keyValuePair != null && (value = keyValuePair.getValue()) != null) {
            return value;
        }
        List<MediaConstraints.KeyValuePair> list2 = mediaConstraints.optional;
        AbstractC13042fc3.h(list2, ParameterNames.OPTIONAL);
        Iterator<T> it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            if (AbstractC13042fc3.d(((MediaConstraints.KeyValuePair) next2).getKey(), str)) {
                break;
            }
        }
        MediaConstraints.KeyValuePair keyValuePair2 = (MediaConstraints.KeyValuePair) next2;
        if (keyValuePair2 != null) {
            return keyValuePair2.getValue();
        }
        return null;
    }
}
