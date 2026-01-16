package ir.nasim;

import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ir.nasim.bT2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10326bT2 {
    public static final C10326bT2 a = new C10326bT2();
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.aT2
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C10326bT2.d();
        }
    });
    public static final int c = 8;

    private C10326bT2() {
    }

    private final ArrayList c() {
        return (ArrayList) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList d() throws JSONException {
        String name;
        JSONArray jSONArray = new JSONArray(AbstractC5969Lp4.e().S().W1());
        ArrayList arrayList = new ArrayList();
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int i2 = jSONObject.getInt("index");
                long j = jSONObject.getLong("accessHash");
                String string = jSONObject.getString("fileId");
                AbstractC13042fc3.h(string, "getString(...)");
                int length2 = string.length() - 1;
                int i3 = 0;
                boolean z = false;
                while (i3 <= length2) {
                    boolean z2 = AbstractC13042fc3.k(string.charAt(!z ? i3 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length2--;
                    } else if (z2) {
                        i3++;
                    } else {
                        z = true;
                    }
                }
                arrayList.add(i2 - 1, new C24890zN5(Long.parseLong(string.subSequence(i3, length2 + 1).toString()), jSONObject.getInt("fileSize"), j));
            }
        } catch (JSONException e) {
            if (a.getClass().isAnonymousClass()) {
                name = C10326bT2.class.getName();
                int length3 = name.length();
                AbstractC13042fc3.f(name);
                if (length3 > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C10326bT2.class.getSimpleName();
                int length4 = name.length();
                AbstractC13042fc3.f(name);
                if (length4 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
        return arrayList;
    }

    public final XV4 b() {
        if (!(!c().isEmpty())) {
            return null;
        }
        int iNextInt = new Random().nextInt(c().size());
        return new XV4(c().get(iNextInt), Integer.valueOf(iNextInt));
    }
}
