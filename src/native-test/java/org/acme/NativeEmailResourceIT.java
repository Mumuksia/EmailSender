package org.acme;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeEmailResourceIT extends EmailResourceTest {

    // Execute the same tests but in native mode.
}