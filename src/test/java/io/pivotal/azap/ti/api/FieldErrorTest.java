package io.pivotal.azap.ti.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FieldErrorTest {

  @Test
  public void rootErrorPathIsSlash() {
    FieldError root = FieldError.root("test");

    assertThat(root.getPath(), is("/"));
    assertThat(root.getCode(), is("root-object-error"));
    assertThat(root.getMessage(), is("test"));
  }


}