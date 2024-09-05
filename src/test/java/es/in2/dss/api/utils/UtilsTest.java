//package es.in2.dss.api.utils;
//
//import es.in2.dss.z.util.Utils;
//import org.junit.jupiter.api.Test;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UtilsTest {
//
//    @Test
//    void testConstructor() {
//        Constructor<Utils> constructor;
//        try {
//            constructor = Utils.class.getDeclaredConstructor();
//        } catch (NoSuchMethodException e) {
//            fail("Constructor not found");
//            return;
//        }
//
//        constructor.setAccessible(true);
//
//        try {
//            constructor.newInstance();
//            fail("Expected exception not thrown");
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            assertInstanceOf(IllegalStateException.class, e.getCause());
//            assertEquals("Utility class", e.getCause().getMessage());
//        }
//    }
//
//    @SuppressWarnings("ConstantValue")
//    @Test
//    void testIsNullOrBlank() {
//        assertTrue(Utils.isNullOrBlank(null));
//        assertTrue(Utils.isNullOrBlank(""));
//        assertTrue(Utils.isNullOrBlank("   "));
//        assertFalse(Utils.isNullOrBlank("Hello"));
//    }
//
//    @Test
//    void testEnsureUrlHasProtocol() {
//        assertNull(Utils.ensureUrlHasProtocol(null));
//
//        String urlWithHttp = "http://example.com";
//        assertEquals(urlWithHttp, Utils.ensureUrlHasProtocol(urlWithHttp));
//
//        String urlWithHttps = "https://example.com";
//        assertEquals(urlWithHttps, Utils.ensureUrlHasProtocol(urlWithHttps));
//
//        String urlWithoutProtocol = "example.com";
//        String expectedUrlWithHttps = "https://" + urlWithoutProtocol;
//
//        assertEquals(expectedUrlWithHttps, Utils.ensureUrlHasProtocol(urlWithoutProtocol));
//    }
//}
