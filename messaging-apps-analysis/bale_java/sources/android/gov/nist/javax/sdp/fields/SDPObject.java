package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.GenericObject;
import android.gov.nist.core.GenericObjectList;
import android.gov.nist.core.InternalErrorHandler;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class SDPObject extends GenericObject implements SDPFieldNames {
    protected static final String CORE_PACKAGE = "android.gov.nist.core";
    protected static final String SDPFIELDS_PACKAGE = "android.gov.nist.javax.sdp.fields";

    public String dbgPrint(int i) {
        int i2 = this.indentation;
        this.indentation = i;
        String string = toString();
        this.indentation = i2;
        return string;
    }

    @Override // android.gov.nist.core.GenericObject
    public String debugDump() {
        this.stringRepresentation = "";
        Class<?> cls = getClass();
        sprint(cls.getName());
        sprint("{");
        for (Field field : cls.getDeclaredFields()) {
            if (field.getModifiers() != 2) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (name.compareTo("stringRepresentation") != 0 && name.compareTo("indentation") != 0) {
                    sprint(name + ":");
                    try {
                        if (type.isPrimitive()) {
                            String string = type.toString();
                            sprint(string + ":");
                            if (string.compareTo("int") == 0) {
                                sprint(field.getInt(this));
                            } else if (string.compareTo("short") == 0) {
                                sprint(field.getShort(this));
                            } else if (string.compareTo("char") == 0) {
                                sprint(field.getChar(this));
                            } else if (string.compareTo("long") == 0) {
                                sprint(field.getLong(this));
                            } else if (string.compareTo("boolean") == 0) {
                                sprint(field.getBoolean(this));
                            } else if (string.compareTo("double") == 0) {
                                sprint(field.getDouble(this));
                            } else if (string.compareTo("float") == 0) {
                                sprint(field.getFloat(this));
                            }
                        } else if (!GenericObject.class.isAssignableFrom(type)) {
                            int i = GenericObjectList.a;
                            if (!GenericObjectList.class.isAssignableFrom(type)) {
                                if (field.get(this) != null) {
                                    sprint(field.get(this).getClass().getName() + ":");
                                } else {
                                    sprint(type.getName() + ":");
                                }
                                sprint("{");
                                if (field.get(this) != null) {
                                    sprint(field.get(this).toString());
                                } else {
                                    sprint("<null>");
                                }
                                sprint("}");
                            } else if (field.get(this) != null) {
                                sprint(((GenericObjectList) field.get(this)).debugDump(this.indentation + 1));
                            } else {
                                sprint("<null>");
                            }
                        } else if (field.get(this) != null) {
                            sprint(((GenericObject) field.get(this)).debugDump(this.indentation + 1));
                        } else {
                            sprint("<null>");
                        }
                    } catch (ClassNotFoundException e) {
                        System.out.println("Cound not find " + e.getMessage());
                        e.printStackTrace();
                        System.exit(0);
                    } catch (IllegalAccessException unused) {
                    }
                }
            }
        }
        sprint("}");
        return this.stringRepresentation;
    }

    @Override // android.gov.nist.core.GenericObject
    public abstract String encode();

    @Override // android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        Field[] declaredFields = getClass().getDeclaredFields();
        Field[] declaredFields2 = obj.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            Field field2 = declaredFields2[i];
            if (field.getModifiers() != 2) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (name.compareTo("stringRepresentation") != 0 && name.compareTo("indentation") != 0) {
                    try {
                        if (type.isPrimitive()) {
                            String string = type.toString();
                            if (string.compareTo("int") == 0) {
                                if (field.getInt(this) != field2.getInt(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("short") == 0) {
                                if (field.getShort(this) != field2.getShort(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("char") == 0) {
                                if (field.getChar(this) != field2.getChar(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("long") == 0) {
                                if (field.getLong(this) != field2.getLong(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("boolean") == 0) {
                                if (field.getBoolean(this) != field2.getBoolean(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("double") == 0) {
                                if (field.getDouble(this) != field2.getDouble(obj)) {
                                    return false;
                                }
                            } else if (string.compareTo("float") == 0 && field.getFloat(this) != field2.getFloat(obj)) {
                                return false;
                            }
                        } else if (field2.get(obj) != field.get(this)) {
                            if (field.get(this) == null && field2.get(obj) != null) {
                                return false;
                            }
                            if ((field2.get(obj) == null && field.get(obj) != null) || !field.get(this).equals(field2.get(obj))) {
                                return false;
                            }
                        }
                    } catch (IllegalAccessException e) {
                        InternalErrorHandler.handleException(e);
                    }
                }
            }
        }
        return true;
    }

    protected String getStringRepresentation() {
        return this.stringRepresentation;
    }

    protected void initSprint() {
        this.stringRepresentation = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    @Override // android.gov.nist.core.GenericObject
    public boolean match(Object obj) throws IllegalAccessException, IllegalArgumentException {
        if (obj == null) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        GenericObject genericObject = (GenericObject) obj;
        Field[] declaredFields = getClass().getDeclaredFields();
        int i = 0;
        ?? Match = obj.getClass().getDeclaredFields();
        while (i < declaredFields.length) {
            Field field = declaredFields[i];
            Field field2 = Match[i];
            if (field.getModifiers() != 2) {
                Class<?> type = field.getType();
                String name = field.getName();
                if (name.compareTo("stringRepresentation") != 0 && name.compareTo("indentation") != 0) {
                    try {
                        if (type.isPrimitive()) {
                            String string = type.toString();
                            if (string.compareTo("int") == 0) {
                                if (field.getInt(this) != field2.getInt(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("short") == 0) {
                                if (field.getShort(this) != field2.getShort(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("char") == 0) {
                                if (field.getChar(this) != field2.getChar(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("long") == 0) {
                                if (field.getLong(this) != field2.getLong(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("boolean") == 0) {
                                if (field.getBoolean(this) != field2.getBoolean(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("double") == 0) {
                                if (field.getDouble(this) != field2.getDouble(genericObject)) {
                                    return false;
                                }
                            } else if (string.compareTo("float") == 0 && field.getFloat(this) != field2.getFloat(genericObject)) {
                                return false;
                            }
                        } else {
                            Object obj2 = field.get(this);
                            Object obj3 = field2.get(genericObject);
                            if (obj3 == obj2) {
                                return true;
                            }
                            if (obj3 != null && obj2 == null) {
                                return false;
                            }
                            if ((obj3 instanceof String) && (obj2 instanceof String)) {
                                if (((String) obj2).compareToIgnoreCase((String) obj3) != 0) {
                                    return false;
                                }
                            } else {
                                if (obj3 != null && GenericObject.isMySubclass(obj2.getClass()) && GenericObject.isMySubclass(obj3.getClass()) && obj2.getClass().equals(obj3.getClass()) && ((GenericObject) obj3).getMatcher() != null) {
                                    Match = ((GenericObject) obj3).getMatcher().match(((GenericObject) obj2).encode());
                                    return Match;
                                }
                                if (GenericObject.isMySubclass(obj2.getClass()) && !((GenericObject) obj2).match(obj3)) {
                                    return false;
                                }
                                if (GenericObjectList.isMySubclass(obj2.getClass()) && !((GenericObjectList) obj2).match(obj3)) {
                                    return false;
                                }
                            }
                        }
                    } catch (IllegalAccessException e) {
                        InternalErrorHandler.handleException(e);
                    }
                }
            }
            i++;
            Match = Match;
        }
        return true;
    }

    @Override // android.gov.nist.core.GenericObject
    protected void sprint(String str) {
        super.sprint(str);
    }

    public String toString() {
        return encode();
    }
}
