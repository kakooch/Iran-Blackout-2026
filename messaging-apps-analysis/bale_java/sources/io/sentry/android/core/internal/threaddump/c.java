package io.sentry.android.core.internal.threaddump;

import android.gov.nist.core.Separators;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.sentry.C3155n3;
import io.sentry.C3183r3;
import io.sentry.Y2;
import io.sentry.Z2;
import io.sentry.protocol.A;
import io.sentry.protocol.B;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.z;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class c {
    private static final Pattern f = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");
    private static final Pattern g = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");
    private static final Pattern h = Pattern.compile(" *(?:native: )?#(\\d+) \\S+ ([0-9a-fA-F]+)\\s+((.*?)(?:\\s+\\(deleted\\))?(?:\\s+\\(offset (.*?)\\))?)(?:\\s+\\((?:\\?\\?\\?|(.*?)(?:\\+(\\d+))?)\\))?(?:\\s+\\(BuildId: (.*?)\\))?");
    private static final Pattern i = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");
    private static final Pattern j = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");
    private static final Pattern k = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern l = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern m = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern n = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");
    private static final Pattern o = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
    private static final Pattern p = Pattern.compile(" *- waiting to lock an unknown object");
    private static final Pattern q = Pattern.compile("\\s+");
    private final C3155n3 a;
    private final boolean b;
    private final C3183r3 c;
    private final Map d = new HashMap();
    private final List e = new ArrayList();

    public c(C3155n3 c3155n3, boolean z) {
        this.a = c3155n3;
        this.b = z;
        this.c = new C3183r3(c3155n3);
    }

    private static String a(String str) {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new BigInteger("10" + str, 16).toByteArray());
            byteBufferWrap.get();
            return String.format("%08x-%04x-%04x-%04x-%04x%08x", Integer.valueOf(byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN).getInt()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.getShort()), Short.valueOf(byteBufferWrap.order(ByteOrder.BIG_ENDIAN).getShort()), Short.valueOf(byteBufferWrap.getShort()), Integer.valueOf(byteBufferWrap.getInt()));
        } catch (NumberFormatException | BufferUnderflowException unused) {
            return null;
        }
    }

    private void b(B b, Z2 z2) {
        Map mapK = b.k();
        if (mapK == null) {
            mapK = new HashMap();
        }
        Z2 z22 = (Z2) mapK.get(z2.f());
        if (z22 != null) {
            z22.l(Math.max(z22.g(), z2.g()));
        } else {
            mapK.put(z2.f(), new Z2(z2));
        }
        b.t(mapK);
    }

    private Integer d(Matcher matcher, int i2, Integer num) {
        String strGroup = matcher.group(i2);
        return (strGroup == null || strGroup.length() == 0) ? num : Integer.valueOf(Integer.parseInt(strGroup));
    }

    private Long e(Matcher matcher, int i2, Long l2) {
        String strGroup = matcher.group(i2);
        return (strGroup == null || strGroup.length() == 0) ? l2 : Long.valueOf(Long.parseLong(strGroup));
    }

    private Integer g(Matcher matcher, int i2, Integer num) throws NumberFormatException {
        String strGroup = matcher.group(i2);
        if (strGroup == null || strGroup.length() == 0) {
            return num;
        }
        int i3 = Integer.parseInt(strGroup);
        return i3 >= 0 ? Integer.valueOf(i3) : num;
    }

    private boolean h(Matcher matcher, String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    private A j(b bVar, B b) {
        Matcher matcher;
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = h.matcher("");
        Matcher matcher3 = i.matcher("");
        Matcher matcher4 = j.matcher("");
        Matcher matcher5 = k.matcher("");
        Matcher matcher6 = m.matcher("");
        Matcher matcher7 = l.matcher("");
        Matcher matcher8 = o.matcher("");
        Matcher matcher9 = n.matcher("");
        Matcher matcher10 = p.matcher("");
        Matcher matcher11 = q.matcher("");
        z zVar = null;
        while (true) {
            if (!bVar.a()) {
                break;
            }
            a aVarB = bVar.b();
            if (aVarB == null) {
                this.a.getLogger().c(Y2.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                break;
            }
            String str = aVarB.b;
            Matcher matcher12 = matcher11;
            if (h(matcher3, str)) {
                zVar = new z();
                String str2 = String.format("%s.%s", matcher3.group(1), matcher3.group(2));
                zVar.C(str2);
                zVar.x(matcher3.group(3));
                zVar.w(matcher3.group(4));
                zVar.A(g(matcher3, 5, null));
                zVar.y(this.c.b(str2));
                arrayList.add(zVar);
                matcher = matcher3;
            } else {
                if (h(matcher2, str)) {
                    z zVar2 = new z();
                    zVar2.E(matcher2.group(3));
                    zVar2.x(matcher2.group(6));
                    zVar2.A(d(matcher2, 7, null));
                    zVar2.z("0x" + matcher2.group(2));
                    zVar2.F(PluginErrorDetails.Platform.NATIVE);
                    String strGroup = matcher2.group(8);
                    String strA = strGroup == null ? null : a(strGroup);
                    if (strA != null) {
                        if (this.d.containsKey(strA)) {
                            matcher = matcher3;
                        } else {
                            DebugImage debugImage = new DebugImage();
                            debugImage.setDebugId(strA);
                            matcher = matcher3;
                            debugImage.setType("elf");
                            debugImage.setCodeFile(matcher2.group(4));
                            debugImage.setCodeId(strGroup);
                            this.d.put(strA, debugImage);
                        }
                        zVar2.v("rel:" + strA);
                    } else {
                        matcher = matcher3;
                    }
                    arrayList.add(zVar2);
                    matcher11 = matcher12;
                    zVar = null;
                } else {
                    matcher = matcher3;
                    if (h(matcher4, str)) {
                        zVar = new z();
                        String str3 = String.format("%s.%s", matcher4.group(1), matcher4.group(2));
                        zVar.C(str3);
                        zVar.x(matcher4.group(3));
                        zVar.y(this.c.b(str3));
                        zVar.D(Boolean.TRUE);
                        arrayList.add(zVar);
                    } else if (h(matcher5, str)) {
                        if (zVar != null) {
                            Z2 z2 = new Z2();
                            z2.l(1);
                            z2.h(matcher5.group(1));
                            z2.j(matcher5.group(2));
                            z2.i(matcher5.group(3));
                            zVar.B(z2);
                            b(b, z2);
                        }
                    } else if (h(matcher6, str)) {
                        if (zVar != null) {
                            Z2 z22 = new Z2();
                            z22.l(2);
                            z22.h(matcher6.group(1));
                            z22.j(matcher6.group(2));
                            z22.i(matcher6.group(3));
                            zVar.B(z22);
                            b(b, z22);
                        }
                    } else if (!h(matcher7, str)) {
                        if (!h(matcher8, str)) {
                            if (!h(matcher9, str)) {
                                if (!h(matcher10, str)) {
                                    if (str.length() == 0) {
                                        break;
                                    }
                                    matcher11 = matcher12;
                                    if (h(matcher11, str)) {
                                        break;
                                    }
                                } else if (zVar != null) {
                                    Z2 z23 = new Z2();
                                    z23.l(8);
                                    zVar.B(z23);
                                    b(b, z23);
                                }
                            } else if (zVar != null) {
                                Z2 z24 = new Z2();
                                z24.l(8);
                                z24.h(matcher9.group(1));
                                z24.j(matcher9.group(2));
                                z24.i(matcher9.group(3));
                                zVar.B(z24);
                                b(b, z24);
                            }
                        } else if (zVar != null) {
                            Z2 z25 = new Z2();
                            z25.l(8);
                            z25.h(matcher8.group(1));
                            z25.j(matcher8.group(2));
                            z25.i(matcher8.group(3));
                            z25.k(e(matcher8, 4, null));
                            zVar.B(z25);
                            b(b, z25);
                        }
                        matcher11 = matcher12;
                    } else if (zVar != null) {
                        Z2 z26 = new Z2();
                        z26.l(4);
                        z26.h(matcher7.group(1));
                        z26.j(matcher7.group(2));
                        z26.i(matcher7.group(3));
                        zVar.B(z26);
                        b(b, z26);
                    }
                }
                matcher3 = matcher;
            }
            matcher11 = matcher12;
            matcher3 = matcher;
        }
        Collections.reverse(arrayList);
        A a = new A(arrayList);
        a.e(Boolean.TRUE);
        return a;
    }

    private B k(b bVar) {
        B b = new B();
        Matcher matcher = f.matcher("");
        Matcher matcher2 = g.matcher("");
        if (!bVar.a()) {
            return null;
        }
        a aVarB = bVar.b();
        boolean z = false;
        if (aVarB == null) {
            this.a.getLogger().c(Y2.WARNING, "Internal error while parsing thread dump.", new Object[0]);
            return null;
        }
        if (h(matcher, aVarB.b)) {
            Long lE = e(matcher, 4, null);
            if (lE == null) {
                this.a.getLogger().c(Y2.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            b.u(lE);
            b.w(matcher.group(1));
            String strGroup = matcher.group(5);
            if (strGroup != null) {
                if (strGroup.contains(Separators.SP)) {
                    b.z(strGroup.substring(0, strGroup.indexOf(32)));
                } else {
                    b.z(strGroup);
                }
            }
        } else if (h(matcher2, aVarB.b)) {
            Long lE2 = e(matcher2, 3, null);
            if (lE2 == null) {
                this.a.getLogger().c(Y2.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            b.u(lE2);
            b.w(matcher2.group(1));
        }
        String strM = b.m();
        if (strM != null) {
            boolean zEquals = strM.equals("main");
            b.v(Boolean.valueOf(zEquals));
            b.q(Boolean.valueOf(zEquals));
            if (zEquals && !this.b) {
                z = true;
            }
            b.r(Boolean.valueOf(z));
        }
        b.y(j(bVar, b));
        return b;
    }

    public List c() {
        return new ArrayList(this.d.values());
    }

    public List f() {
        return this.e;
    }

    public void i(b bVar) {
        Matcher matcher = f.matcher("");
        Matcher matcher2 = g.matcher("");
        while (bVar.a()) {
            a aVarB = bVar.b();
            if (aVarB == null) {
                this.a.getLogger().c(Y2.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return;
            }
            String str = aVarB.b;
            if (h(matcher, str) || h(matcher2, str)) {
                bVar.d();
                B bK = k(bVar);
                if (bK != null) {
                    this.e.add(bK);
                }
            }
        }
    }
}
