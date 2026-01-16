package ir.nasim;

import android.content.Intent;
import ir.nasim.features.MainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;

/* renamed from: ir.nasim.Ey5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4398Ey5 {
    public static final a a = new a(null);

    /* renamed from: ir.nasim.Ey5$a */
    public static final class a {

        /* renamed from: ir.nasim.Ey5$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0352a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC13889gz5.values().length];
                try {
                    iArr[EnumC13889gz5.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC13889gz5.j.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC13889gz5.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC13889gz5.d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[EnumC13889gz5.e.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[EnumC13889gz5.f.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[EnumC13889gz5.h.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[EnumC13889gz5.i.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        private final List a(String str) {
            String strG0 = AbstractC20762sZ6.G0(str, "[", "]");
            if (strG0.length() == 0) {
                return AbstractC10360bX0.m();
            }
            List listN0 = AbstractC20762sZ6.N0(strG0, new String[]{","}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listN0, 10));
            Iterator it = listN0.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Integer.parseInt(AbstractC20762sZ6.n1((String) it.next()).toString())));
            }
            return arrayList;
        }

        private final C22033uZ0 b(Map map) {
            CharSequence charSequence;
            Integer numO;
            CharSequence charSequence2 = (CharSequence) map.get("threadMessageRID");
            if (charSequence2 == null || charSequence2.length() == 0 || (charSequence = (CharSequence) map.get("threadMessageDate")) == null || charSequence.length() == 0) {
                return null;
            }
            String str = (String) map.get("threadMessageRID");
            long longOrDefault = str != null ? Util.toLongOrDefault(str, 0L) : 0L;
            String str2 = (String) map.get("threadMessageDate");
            long longOrDefault2 = str2 != null ? Util.toLongOrDefault(str2, 0L) : 0L;
            String str3 = (String) map.get("discussionGroupPeerId");
            return new C22033uZ0(longOrDefault, longOrDefault2, Integer.valueOf((str3 == null || (numO = AbstractC19562qZ6.o(str3)) == null) ? 0 : numO.intValue()));
        }

        private final AbstractC24063xz d(String str) {
            if (str != null) {
                try {
                    return AbstractC24063xz.r(C14582i90.a(str));
                } catch (Exception e) {
                    C19406qI3.a("NotificationData", e.getMessage(), new Object[0]);
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:257:0x0512 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:346:0x0514 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final ir.nasim.AbstractC4398Ey5 c(java.util.Map r55) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 1850
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4398Ey5.a.c(java.util.Map):ir.nasim.Ey5");
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public abstract Intent a();

    protected final Intent b() {
        Intent intent = new Intent(C5721Ko.a.d(), (Class<?>) MainActivity.class);
        intent.addFlags(67108864);
        return intent;
    }

    public abstract EnumC13889gz5 c();

    public abstract AbstractC6544Ny5 d();
}
