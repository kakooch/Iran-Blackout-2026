package ir.nasim;

import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: ir.nasim.pG4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC18798pG4 {
    protected static Logger a = Logger.getLogger(AbstractC18798pG4.class.getName());
    protected static Map b = new HashMap();

    static {
        HashSet<Class> hashSet = new HashSet();
        hashSet.add(NB1.class);
        hashSet.add(M76.class);
        hashSet.add(H90.class);
        hashSet.add(AbstractC5400Je2.class);
        hashSet.add(AbstractC18207oG4.class);
        hashSet.add(AbstractC6248Mu5.class);
        hashSet.add(C18283oP.class);
        hashSet.add(AbstractC6101Me2.class);
        hashSet.add(G22.class);
        hashSet.add(IB1.class);
        for (Class cls : hashSet) {
            InterfaceC21881uI1 interfaceC21881uI1 = (InterfaceC21881uI1) cls.getAnnotation(InterfaceC21881uI1.class);
            int[] iArrTags = interfaceC21881uI1.tags();
            int iObjectTypeIndication = interfaceC21881uI1.objectTypeIndication();
            Map map = (Map) b.get(Integer.valueOf(iObjectTypeIndication));
            if (map == null) {
                map = new HashMap();
            }
            for (int i : iArrTags) {
                map.put(Integer.valueOf(i), cls);
            }
            b.put(Integer.valueOf(iObjectTypeIndication), map);
        }
    }

    public static H90 a(int i, ByteBuffer byteBuffer) {
        H90 c24190yB7;
        int iM = AbstractC5635Ke3.m(byteBuffer);
        Map map = (Map) b.get(Integer.valueOf(i));
        if (map == null) {
            map = (Map) b.get(-1);
        }
        Class cls = (Class) map.get(Integer.valueOf(iM));
        if (cls == null || cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) {
            a.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(iM) + " found: " + cls);
            c24190yB7 = new C24190yB7();
        } else {
            try {
                c24190yB7 = (H90) cls.newInstance();
            } catch (Exception e) {
                a.log(Level.SEVERE, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + iM, (Throwable) e);
                throw new RuntimeException(e);
            }
        }
        c24190yB7.d(iM, byteBuffer);
        return c24190yB7;
    }
}
