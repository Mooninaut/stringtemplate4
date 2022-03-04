package org.stringtemplate.v4.test;

import org.junit.Test;
import org.stringtemplate.v4.misc.Misc;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestAppendPath extends BaseTest {
    private final String TEMPLATE_GROUP_FILE = "templateDir/TestFile.stg";

    private final String ROOT_DIR = "file:/rootDir";
    private final String EXPECTED = ROOT_DIR + "/" + TEMPLATE_GROUP_FILE;

    private final String JAR_ROOT_DIR = "jar:file:/path/archive.jar!/rootDir";
    private final String JAR_EXPECTED = "file:/path/archive.jar!/rootDir/templateDir/TestFile.stg";

    private String doAppendPath(String root, String templateGroupFile) throws MalformedURLException {
        return Misc.appendPath(new URL(root), templateGroupFile).toString();
    }

    @Test
    public void testBareRootDirAndBareGroupDir() throws MalformedURLException {
        assertEquals(EXPECTED, doAppendPath(ROOT_DIR, TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testRootDirWithTrailingSlashAndBareGroupDir() throws MalformedURLException {
        assertEquals(EXPECTED, doAppendPath(ROOT_DIR+"/", TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testBareRootDirAndGroupDirWithLeadingSlash() throws MalformedURLException {
        assertEquals(EXPECTED, doAppendPath(ROOT_DIR, "/"+TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testRootDirWithTrailingSlashAndGroupDirWithLeadingSlash() throws MalformedURLException {
        assertEquals(EXPECTED, doAppendPath(ROOT_DIR+"/", "/"+TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testJarBareRootDirAndBareGroupDir() throws MalformedURLException {
        assertEquals(JAR_EXPECTED, doAppendPath(JAR_ROOT_DIR, TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testJarRootDirWithTrailingSlashAndBareGroupDir() throws MalformedURLException {
        assertEquals(JAR_EXPECTED, doAppendPath(JAR_ROOT_DIR+"/", TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testJarBareRootDirAndGroupDirWithLeadingSlash() throws MalformedURLException {
        assertEquals(JAR_EXPECTED, doAppendPath(JAR_ROOT_DIR, "/"+TEMPLATE_GROUP_FILE));
    }

    @Test
    public void testJarRootDirWithTrailingSlashAndGroupDirWithLeadingSlash() throws MalformedURLException {
        assertEquals(JAR_EXPECTED, doAppendPath(JAR_ROOT_DIR+"/", "/"+TEMPLATE_GROUP_FILE));
    }


}
