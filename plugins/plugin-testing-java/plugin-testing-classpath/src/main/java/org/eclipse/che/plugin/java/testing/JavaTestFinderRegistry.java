/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.java.testing;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

/**
 * Registry of {@link JavaTestFinder} implementations. All the Java Test Finders should be
 * registered here.
 */
@Singleton
public class JavaTestFinderRegistry {

  private final Map<String, JavaTestFinder> javaTestFinders = new HashMap<>();

  @Inject
  public JavaTestFinderRegistry(Set<JavaTestFinder> finders) {
    finders.forEach(this::register);
  }

  private void register(@NotNull JavaTestFinder finder) {
    javaTestFinders.put(finder.getName(), finder);
  }

  /**
   * Get the registered java test finder by name.
   *
   * @param finderName name of the {@link JavaTestFinder} implementation.
   * @return the {@link JavaTestFinder} implementation if available, otherwise null.
   */
  public JavaTestFinder getJavaTestFinder(String finderName) {
    return javaTestFinders.get(finderName);
  }
}